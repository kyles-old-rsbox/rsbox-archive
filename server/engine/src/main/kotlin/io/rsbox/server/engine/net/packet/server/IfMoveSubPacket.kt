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

import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.engine.net.game.ServerPacket
import io.rsbox.server.util.buffer.INVERSE_MIDDLE
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.LITTLE

@ServerPacket(opcode = 45, type = PacketType.FIXED)
class IfMoveSubPacket(
    val fromParent: Int,
    val fromChild: Int,
    val toParent: Int,
    val toChild: Int
) : Packet {
    companion object : Codec<IfMoveSubPacket> {
        override fun encode(session: Session, packet: IfMoveSubPacket, out: JagByteBuf) {
            val fromComponent = (packet.fromParent shl 16) or packet.fromChild
            val toComponent = (packet.toParent shl 16) or packet.toChild
            out.writeInt(toComponent, endian = INVERSE_MIDDLE)
            out.writeInt(fromComponent, endian = LITTLE)
        }
    }
}