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
import io.rsbox.server.engine.Engine
import io.rsbox.server.engine.model.World
import io.rsbox.server.engine.model.coord.Scene
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.entity.MovementState
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.entity.update.PlayerUpdateFlag
import io.rsbox.server.engine.model.list.PlayerList
import io.rsbox.server.engine.model.manager.SceneManager
import io.rsbox.server.engine.net.packet.server.PlayerInfoPacket
import io.rsbox.server.engine.sync.SyncTask
import io.rsbox.server.util.buffer.BIT_MODE
import io.rsbox.server.util.buffer.BYTE_MODE
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.toJagBuf
import java.util.SortedSet
import kotlin.math.abs

class PlayerSyncTask : SyncTask {

    private val world: World by inject()
    private val engine: Engine by inject()

    override suspend fun execute() {
        world.players.forEach { player ->
            val buf = player.encodeSync()
            val packet = PlayerInfoPacket(buf)
            player.session.write(packet)
        }
    }

    private fun Player.encodeSync(): ByteBuf {
        val mainBuf = session.channel.alloc().buffer().toJagBuf()
        val maskBuf = session.channel.alloc().buffer().toJagBuf()

        var added = 0
        writeLocalPlayers(mainBuf, maskBuf, true)
        writeLocalPlayers(mainBuf, maskBuf, false)
        added += writeExternalPlayers(mainBuf, maskBuf, false, added)
        added += writeExternalPlayers(mainBuf, maskBuf, true, added)

        val buf = session.channel.alloc().buffer()

        gpi.localPlayerCount = 0
        gpi.externalPlayerCount = 0

        for(i in 1 until PlayerList.MAX_PLAYERS) {
            gpi.skipFlags[i] = gpi.skipFlags[i] shr 1
            if(gpi.localPlayers[i] != null) {
                gpi.localPlayerIndexes[gpi.localPlayerCount++] = i
            } else {
                gpi.externalPlayerIndexes[gpi.externalPlayerCount++] = i
            }
        }

        mainBuf.writeBytes(maskBuf.toByteBuf())
        maskBuf.release()

        buf.writeBytes(mainBuf.toByteBuf())
        return buf
    }

    private fun Player.writeLocalPlayers(buf: JagByteBuf, maskBuf: JagByteBuf, activeMode: Boolean) {
        var skipCount = 0

        fun shouldUpdateLocalPlayer(player: Player, other: Player): Boolean {
            return (other.updateFlags.isNotEmpty()
                    || !player.tile.isWithinRadius(other.tile, Scene.RENDER_DISTANCE)
                    || other.movementState != MovementState.NONE)
        }

        fun updateLocalPlayer(localPlayer: Player, buf: JagByteBuf, maskBuf: JagByteBuf) {
            val updateRequired = localPlayer.updateFlags.isNotEmpty()
            buf.writeBoolean(updateRequired)

            if(localPlayer.movementState == MovementState.TELEPORT) {
                buf.writeBits(3, 2)
                val dx = localPlayer.tile.x - localPlayer.prevTile.x
                val dy = localPlayer.tile.y - localPlayer.prevTile.y
                val dz = localPlayer.tile.level - localPlayer.prevTile.level
                if(abs(dx) <= Scene.RENDER_DISTANCE && abs(dy) <= Scene.RENDER_DISTANCE) {
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
            else if(!this.tile.isWithinRadius(localPlayer.tile, Scene.RENDER_DISTANCE)) {
                buf.writeBits(0, 2)
                gpi.localPlayers[localPlayer.index] = null
            }
            else if(localPlayer.movementState == MovementState.WALK) {
                buf.writeBits(1, 2)
                buf.writeBits(getMovementDir(localPlayer), 3)
            }
            else if(localPlayer.movementState == MovementState.RUN) {
                buf.writeBits(2, 2)
                buf.writeBits(getMovementDir(localPlayer), 4)
            }
            else if(updateRequired) {
                buf.writeBits(0, 2)
            }

            if(updateRequired) {
                maskBuf.writeUpdateFlags(localPlayer, sortedSetOf())
            }
        }

        fun skipLocalPlayers(buf: JagByteBuf, currentIndex: Int, activeMode: Boolean) {
            ((currentIndex + 1) until gpi.localPlayerCount)
                .asSequence()
                .map { gpi.localPlayerIndexes[it] }
                .filter { wasPreviouslySkipped(it, activeMode) }
                .map { gpi.localPlayers[it] }
                .map { it != null && shouldUpdateLocalPlayer(this, it) }
                .takeWhile { !it }
                .toList()
                .forEach { _ -> skipCount++ }
            buf.writeSkip(skipCount)
        }

        /**
         * Write the local player gpi and update data.
         */

        buf.switchWriteAccess(BIT_MODE)
        for(i in 0 until gpi.localPlayerCount) {
            val localIndex = gpi.localPlayerIndexes[i]
            if(wasPreviouslySkipped(localIndex, activeMode)) {
                if(skipCount > 0) {
                    skipCount--
                    skipPlayerIndex(localIndex)
                } else {
                    val localPlayer = gpi.localPlayers[localIndex]
                    val updateRequired = localPlayer != null && shouldUpdateLocalPlayer(this, localPlayer)

                    /*
                     * Write true/false if this player needs to be updated.
                     */
                    buf.writeBoolean(updateRequired)

                    if(!updateRequired) {
                        skipLocalPlayers(buf, i, activeMode)
                        skipPlayerIndex(localIndex)
                    } else {
                        updateLocalPlayer(localPlayer!!, buf, maskBuf)
                    }
                }
            }
        }
        buf.switchWriteAccess(BYTE_MODE)
    }

    private fun Player.writeExternalPlayers(buf: JagByteBuf, maskBuf: JagByteBuf, activeMode: Boolean, prevAdded: Int): Int {
        var skipCount = 0
        var added = prevAdded

        fun shouldUpdateExternalPlayer(player: Player, other: Player): Boolean {
            return (player.tile.isWithinRadius(other.tile, Scene.RENDER_DISTANCE)
                    || player.gpi.tiles[other.index] != other.tile.to18BitInteger())
        }

        fun updateExternalPlayer(externalPlayer: Player, buf: JagByteBuf, maskBuf: JagByteBuf) {
            if(this.tile.isWithinRadius(externalPlayer.tile, Scene.RENDER_DISTANCE)) {
                buf.writeBits(0, 2)
                if(gpi.tiles[externalPlayer.index] != externalPlayer.tile.to18BitInteger()) {
                    buf.writeBoolean(true)
                    writeTileUpdate(externalPlayer, buf)
                } else {
                    buf.writeBoolean(false)
                }
                buf.writeBits(externalPlayer.tile.x, 13)
                buf.writeBits(externalPlayer.tile.y, 13)
                buf.writeBoolean(true)
                maskBuf.writeUpdateFlags(externalPlayer, sortedSetOf(PlayerUpdateFlag.APPEARANCE, PlayerUpdateFlag.MOVEMENT_MODE))
                gpi.localPlayers[externalPlayer.index] = externalPlayer
            } else {
                writeTileUpdate(externalPlayer, buf)
            }
        }

        fun skipExternalPlayers(buf: JagByteBuf, currentIndex: Int, activeMode: Boolean) {
            ((currentIndex + 1) until gpi.externalPlayerCount)
                .asSequence()
                .map { gpi.externalPlayerIndexes[it] }
                .filter { wasPreviouslySkipped(it, activeMode) }
                .map { world.players[it] }
                .map { it != null && shouldUpdateExternalPlayer(this, it) }
                .takeWhile { !it }
                .toList()
                .forEach { _ -> skipCount++ }
            buf.writeSkip(skipCount)
        }

        buf.switchWriteAccess(BIT_MODE)
        for(i in 0 until gpi.externalPlayerCount) {
            val externalIndex = gpi.externalPlayerIndexes[i]
            if(wasPreviouslySkipped(externalIndex, activeMode)) {
                if(skipCount > 0) {
                    skipCount--
                    skipPlayerIndex(externalIndex)
                } else {
                    val externalPlayer = world.players[externalIndex]
                    val updateRequired = externalPlayer != null && shouldUpdateExternalPlayer(this, externalPlayer)

                    buf.writeBoolean(updateRequired)

                    if(!updateRequired) {
                        skipExternalPlayers(buf, i, activeMode)
                        skipPlayerIndex(externalIndex)
                    } else {
                        updateExternalPlayer(externalPlayer!!, buf, maskBuf)
                        skipPlayerIndex(externalIndex)
                    }
                }
            }
        }
        buf.switchWriteAccess(BYTE_MODE)

        return added
    }

    private fun Player.wasPreviouslySkipped(index: Int, activeMode: Boolean) = when(activeMode) {
        true -> gpi.skipFlags[index] and 0x1 == 0
        false -> gpi.skipFlags[index] and 0x1 != 0
    }

    private fun JagByteBuf.writeSkip(count: Int) {
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

    private fun Player.skipPlayerIndex(index: Int) {
        gpi.skipFlags[index] = gpi.skipFlags[index] or 0x2
    }

    private fun getDirectionType(dx: Int, dy: Int) = MOVEMENT_DIRS[2 - dy][dx + 2]

    private fun getMovementDir(player: Player): Int {
        val dx = player.tile.x - player.prevTile.x
        val dy = player.tile.y - player.prevTile.y
        return getDirectionType(dx, dy)
    }

    private fun Player.writeTileUpdate(externalPlayer: Player, buf: JagByteBuf) {
        val last = gpi.tiles[externalPlayer.index]
        val cur = externalPlayer.tile.to18BitInteger()

        val ly = last and 0xFF
        val lx = (last shr 8) and 0xFF
        val lz = last shr 16

        val cy = cur and 0xFF
        val cx = (cur shr 8) and 0xFF
        val cz = cur shr 16

        val dx = cx - lx
        val dy = cy - ly
        val dz = (cz - lz) and 0x3

        if(dx == 0 && dy == 0) {
            buf.writeBits(1, 2)
            buf.writeBits(dz, 2)
        }
        else if(abs(dx) <= 1 && abs(dy) <= 1) {
            buf.writeBits(2, 2)
            buf.writeBits((dz shl 3) or getDirectionType(dx, dy), 5)
        }
        else {
            buf.writeBits(3, 2)
            buf.writeBits(Tile(dx, dy, dz).to18BitInteger(), 18)
        }
        gpi.tiles[externalPlayer.index] = cur
    }


    private fun JagByteBuf.writeUpdateFlags(player: Player, updateFlags: SortedSet<PlayerUpdateFlag> = sortedSetOf()) {
        var mask = 0

        updateFlags.addAll(player.updateFlags)
        updateFlags.forEach {
            mask = mask or it.mask
        }

        if(mask >= 0xFF) {
            this.writeByte(mask or EXCESS_MASK)
            this.writeByte(mask shr 8)
        } else {
            this.writeByte(mask)
        }

        updateFlags.forEach { updateFlag ->
            updateFlag.encode(this, player)
        }
    }

    private fun shouldAdd(player: Player, other: Player) = other != player && !other.invisible && other.tile.isWithinRadius(player.tile, Scene.RENDER_DISTANCE)
    private fun shouldRemove(player: Player, other: Player) = other.index == -1 || other.invisible || !other.tile.isWithinRadius(player.tile, Scene.RENDER_DISTANCE)

    companion object {

        private const val EXCESS_MASK = 0x4

        private val MOVEMENT_DIRS = arrayOf(
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(9, 5, 6, 7, 10),
            intArrayOf(7, 3, -1, 4, 8),
            intArrayOf(5, 0, 1, 2, 6),
            intArrayOf(0, 1, 2, 3, 4)
        )
    }
}