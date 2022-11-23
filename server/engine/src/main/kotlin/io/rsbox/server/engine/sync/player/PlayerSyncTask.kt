/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

@file:Suppress("DuplicatedCode")

package io.rsbox.server.engine.sync.player

import io.netty.buffer.ByteBuf
import io.rsbox.server.common.inject
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.model.World
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.entity.MovementState
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.entity.update.PlayerUpdateFlag
import io.rsbox.server.engine.model.list.PlayerList
import io.rsbox.server.engine.net.packet.server.PlayerInfoPacket
import io.rsbox.server.engine.sync.SyncTask
import io.rsbox.server.util.buffer.BIT_MODE
import io.rsbox.server.util.buffer.BYTE_MODE
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.toJagBuf
import kotlinx.coroutines.*
import java.util.SortedSet
import kotlin.math.abs

class PlayerSyncTask : SyncTask {

    private val world: World by inject()

    private val coroutine = CoroutineScope(Dispatchers.IO)

    override suspend fun execute() {
        coroutine.launch { sync().joinAll() }.join()
    }

    private fun CoroutineScope.sync(): List<Job> {
        val jobs = mutableListOf<Job>()

        world.players.forEach { player ->
            jobs += launch {
                val buf = player.encodeSync()
                player.session.write(PlayerInfoPacket(buf))
            }
        }

        return jobs
    }

    private fun Player.encodeSync(): ByteBuf {
        val mainBuf = session.ctx.alloc().buffer().toJagBuf()
        val maskBuf = session.ctx.alloc().buffer().toJagBuf()

        var local = 0
        var added = 0

        local += writeLocalPlayers(mainBuf, maskBuf, true)
        local += writeLocalPlayers(mainBuf, maskBuf, false)
        added += writeExternalPlayers(mainBuf, maskBuf, false, local, added)
        added += writeExternalPlayers(mainBuf, maskBuf, true, local, added)

        gpi.localPlayerCount = 0
        gpi.externalPlayerCount = 0

        for(index in 1 until PlayerList.MAX_PLAYERS) {
            gpi.skipFlags[index] = gpi.skipFlags[index] shr 1
            if(gpi.localPlayers[index] != null) {
                gpi.localPlayerIndexes[gpi.localPlayerCount++] = index
            } else {
                gpi.externalPlayerIndexes[gpi.externalPlayerCount++] = index
            }
        }

        mainBuf.writeBytes(maskBuf.toByteBuf())
        maskBuf.release()

        return mainBuf.toByteBuf()
    }

    private fun Player.writeLocalPlayers(buf: JagByteBuf, maskBuf: JagByteBuf, activeMode: Boolean): Int {
        var local = 0
        var skipCount = 0

        fun shouldUpdate(player: Player, other: Player): Boolean {
            return other.updateFlags.isNotEmpty()
                    || !player.tile.isWithinRadius(other.tile, ServerConfig.RENDER_DISTANCE)
                    || other.movementState != MovementState.NONE
        }

        fun updatePlayer(player: Player, buf: JagByteBuf, maskBuf: JagByteBuf) {
            val shouldUpdate = player.updateFlags.isNotEmpty()
            buf.writeBoolean(shouldUpdate)

            if(player.movementState == MovementState.TELEPORT) {
                buf.writeBits(3, 2)
                val dx = player.tile.x - player.prevTile.x
                val dy = player.tile.y - player.prevTile.y
                val dz = player.tile.level - player.prevTile.level
                if(abs(dx) <= ServerConfig.RENDER_DISTANCE && abs(dy) <= ServerConfig.RENDER_DISTANCE) {
                    buf.writeBoolean(false)
                    buf.writeBits(dz and 0x3, 2)
                    buf.writeBits(dx and 0x1F, 5)
                    buf.writeBits(dy and 0x1F, 5)
                } else {
                    buf.writeBoolean(true)
                    buf.writeBits(dz and 0x3, 2)
                    buf.writeBits(dx and 0x3FFF, 14)
                    buf.writeBits(dy and 0x3FFF, 14)
                }
            }
            else if(!this.tile.isWithinRadius(player.tile, ServerConfig.RENDER_DISTANCE)) {
                buf.writeBits(0, 2)
                gpi.localPlayers[player.index] = null
            } else if(player.movementState == MovementState.WALK) {
                buf.writeBits(1, 2)
                buf.writeBits(getMoveDirection(player), 3)
            } else if(player.movementState == MovementState.RUN) {
                buf.writeBits(2, 2)
                buf.writeBits(getMoveDirection(player), 4)
            } else if(shouldUpdate) {
                buf.writeBits(0, 2)
            }

            if(shouldUpdate) {
                player.encodeUpdateFlags(maskBuf)
            }
        }

        fun skipPlayers(buf: JagByteBuf, index: Int, activeMode: Boolean) {
            ((index + 1) until gpi.localPlayerCount)
                .asSequence()
                .map { gpi.localPlayerIndexes[it] }
                .filter { wasSkipped(it, activeMode) }
                .map { gpi.localPlayers[it] }
                .map { it != null && shouldUpdate(this, it) }
                .takeWhile { !it }
                .forEach { _ -> skipCount++ }
            buf.writeSkipCount(skipCount)
        }

        skipCount = 0
        buf.switchWriteAccess(BIT_MODE)

        for(i in 0 until gpi.localPlayerCount) {
            val index = gpi.localPlayerIndexes[i]
            if(wasSkipped(index, activeMode)) {
                if(skipCount > 0) {
                    skipCount--
                    markSkipped(index)
                } else {
                    val player = gpi.localPlayers[index]
                    val shouldUpdate = player != null && shouldUpdate(this, player)
                    buf.writeBoolean(shouldUpdate)
                    if(!shouldUpdate) {
                        skipPlayers(buf, i, activeMode)
                        markSkipped(index)
                    } else {
                        updatePlayer(player!!, buf, maskBuf)
                    }
                }
            }
        }

        buf.switchWriteAccess(BYTE_MODE)
        return local
    }

    private fun Player.writeExternalPlayers(buf: JagByteBuf, maskBuf: JagByteBuf, activeMode: Boolean, local: Int, added: Int): Int {
        var additions = 0
        var skipCount = 0

        fun shouldUpdate(player: Player, other: Player): Boolean {
            return player.tile.isWithinRadius(other.tile, ServerConfig.RENDER_DISTANCE)
                    || player.gpi.tiles[other.index] != other.tile.to18BitInteger()
        }

        fun updatePlayer(player: Player, buf: JagByteBuf, maskBuf: JagByteBuf) {
            if(this.tile.isWithinRadius(player.tile, ServerConfig.RENDER_DISTANCE)) {
                buf.writeBits(0, 2)
                if(gpi.tiles[player.index] != player.tile.to18BitInteger()) {
                    buf.writeBoolean(true)
                    writeTileUpdate(player, buf)
                } else {
                    buf.writeBoolean(false)
                }
                buf.writeBits(player.tile.x, 13)
                buf.writeBits(player.tile.y, 13)
                buf.writeBoolean(true)
                player.encodeUpdateFlags(maskBuf, sortedSetOf(PlayerUpdateFlag.APPEARANCE))
                gpi.localPlayers[player.index] = player
            } else {
                writeTileUpdate(player, buf)
            }
        }

        fun skipPlayers(buf: JagByteBuf, index: Int, activeMode: Boolean) {
            ((index + 1) until gpi.externalPlayerCount)
                .asSequence()
                .map { gpi.externalPlayerIndexes[it] }
                .filter { wasSkipped(it, activeMode) }
                .map { world.players[it] }
                .map { it != null && shouldUpdate(this, it) }
                .takeWhile { !it }
                .forEach { _ -> skipCount++ }
            buf.writeSkipCount(skipCount)
        }

        skipCount = 0
        buf.switchWriteAccess(BIT_MODE)

        for(i in 0 until gpi.externalPlayerCount) {
            val index = gpi.externalPlayerIndexes[i]
            if(wasSkipped(index, activeMode)) {
                if(skipCount > 0) {
                    skipCount--
                    markSkipped(index)
                } else {
                    val player = world.players[index]
                    val shouldUpdate = player != null && shouldUpdate(this, player)
                    buf.writeBoolean(shouldUpdate)
                    if(!shouldUpdate) {
                        skipPlayers(buf, i, activeMode)
                        markSkipped(index)
                    } else {
                        updatePlayer(player!!, buf, maskBuf)
                        markSkipped(index)
                    }
                }
            }
        }

        buf.switchWriteAccess(BYTE_MODE)
        return additions
    }

    private fun Player.wasSkipped(index: Int, activeMode: Boolean) = when(activeMode) {
        true -> gpi.skipFlags[index] and 0x1 == 0
        false -> gpi.skipFlags[index] and 0x1 != 0
    }

    private fun JagByteBuf.writeSkipCount(count: Int) {
        when {
            count == 0 -> {
                writeBits(0, 2)
            }
            count < 32 -> {
                writeBits(1, 2)
                writeBits(count, 5)
            }
            count < 256 -> {
                writeBits(2, 2)
                writeBits(count, 8)
            }
            count < 2048 -> {
                writeBits(3, 2)
                writeBits(count, 11)
            }
        }
    }

    private fun Player.markSkipped(index: Int) {
        gpi.skipFlags[index] = gpi.skipFlags[index] or 0x2
    }

    private fun Player.writeTileUpdate(player: Player, buf: JagByteBuf) {
        val prev = gpi.tiles[player.index]
        val cur = player.tile.to18BitInteger()

        val px = (prev shr 8) and 0xFF
        val py = prev and 0xFF
        val pz = prev shr 16

        val cx = (cur shr 8) and 0xFF
        val cy = cur and 0xFF
        val cz = cur shr 16

        val dx = cx - px
        val dy = cy - py
        val dz = (cz - pz) and 0x3

        if(dx == 0 && dy == 0) {
            buf.writeBits(1, 2)
            buf.writeBits(dz, 2)
        } else if(abs(dx) <= 1 && abs(dy) <= 1) {
            buf.writeBits(2, 2)
            buf.writeBits((dz shl 3) or getDirectionId(dx, dy), 5)
        } else {
            buf.writeBits(3, 2)
            buf.writeBits(Tile(dx, dy, dz).to18BitInteger(), 18)
        }
        gpi.tiles[player.index] = cur
    }

    private fun getDirectionId(dx: Int, dy: Int) = MOVE_DIRS[2 - dy][dx + 2]

    private fun getMoveDirection(player: Player): Int {
        val dx = player.tile.x - player.prevTile.x
        val dy = player.tile.y - player.prevTile.y
        return getDirectionId(dx, dy)
    }

    private fun Player.encodeUpdateFlags(buf: JagByteBuf, flags: SortedSet<PlayerUpdateFlag> = sortedSetOf()) {
        var mask = 0

        flags.addAll(updateFlags)
        flags.forEach { mask = mask or it.mask }

        if(mask >= 0xFF) {
            buf.writeByte(mask or EXCESS_MASK)
            buf.writeByte(mask shr 8)
        } else {
            buf.writeByte(mask)
        }

        flags.forEach { flag ->
            flag.encode(buf, this)
        }
    }

    companion object {

        private const val EXCESS_MASK = 0x4

        private val MOVE_DIRS = arrayOf(
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(9, 5, 6, 7, 10),
            intArrayOf(7, 3, -1, 4, 8),
            intArrayOf(5, 0, 1, 2, 6),
            intArrayOf(0, 1, 2, 3, 4)
        )
    }
}