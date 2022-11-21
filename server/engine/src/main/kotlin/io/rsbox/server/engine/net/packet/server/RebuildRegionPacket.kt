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

package io.rsbox.server.engine.net.packet.server

import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.list.PlayerList
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.engine.net.game.ServerPacket
import io.rsbox.server.util.buffer.*

@ServerPacket(opcode = 56, type = PacketType.VARIABLE_SHORT)
class RebuildRegionPacket(
    val player: Player,
    val gpi: Boolean = false
) : Packet {
    companion object : Codec<RebuildRegionPacket> {
        override fun encode(session: Session, packet: RebuildRegionPacket, out: JagByteBuf) {
            if(packet.gpi) {
                out.switchWriteAccess(BIT_MODE)
                out.writeBits(packet.player.tile.to30BitInteger(), 30)
                for(i in 1 until PlayerList.MAX_PLAYERS) {
                    if(i == packet.player.index) continue
                    out.writeBits(packet.player.gpi.tiles[i], 18)
                }
                out.switchWriteAccess(BYTE_MODE)
            }

            val chunk = packet.player.scene.baseTile.toChunk()
            val regions = packet.player.scene.regions

            out.writeShort(chunk.x, transform = ADD)
            out.writeShort(chunk.y, endian = LITTLE)
            out.writeShort(regions.size)

            regions.forEach { region ->
                region.xteas.forEach { out.writeInt(it) }
            }
        }
    }
}