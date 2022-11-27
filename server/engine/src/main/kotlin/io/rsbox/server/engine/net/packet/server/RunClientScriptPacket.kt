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
import io.rsbox.server.util.buffer.JagByteBuf

@ServerPacket(opcode = 47, type = PacketType.VARIABLE_SHORT)
class RunClientScriptPacket(val id: Int, vararg val args: Any) : Packet {
    companion object : Codec<RunClientScriptPacket> {
        override fun encode(session: Session, packet: RunClientScriptPacket, out: JagByteBuf) {
            val str = StringBuilder()
            packet.args.reversed().forEach { arg ->
                if(arg is String) {
                    str.append("s")
                } else {
                    str.append("i")
                }
            }
            out.writeString("$str")
            packet.args.forEach { arg ->
                if(arg is String) {
                    out.writeString(arg)
                } else {
                    out.writeInt(arg as Int)
                }
            }
            out.writeInt(packet.id)
        }
    }
}