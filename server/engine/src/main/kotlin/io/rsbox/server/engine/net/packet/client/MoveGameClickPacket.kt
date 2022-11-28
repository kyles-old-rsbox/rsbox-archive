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

package io.rsbox.server.engine.net.packet.client

import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.ClientPacket
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.util.buffer.ADD
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.LITTLE
import io.rsbox.server.util.buffer.NEG

@ClientPacket(opcode = 95, type = PacketType.VARIABLE_BYTE)
class MoveGameClickPacket(
    val tileX: Int,
    val tileY: Int,
    val moveType: Int
) : Packet {

    override fun handle(session: Session) {
        val tile = Tile(tileX, tileY, session.player.tile.level)
        session.player.path = session.player.findPath(tile)
    }

    companion object : Codec<MoveGameClickPacket> {
        override fun decode(session: Session, buf: JagByteBuf): MoveGameClickPacket {
            val tileY = buf.readUnsignedShort(endian = LITTLE, transform = ADD)
            val moveType = buf.readUnsignedByte(transform = NEG).toInt()
            val tileX = buf.readUnsignedShort(transform = ADD)
            return MoveGameClickPacket(tileX, tileY, moveType)
        }
    }
}