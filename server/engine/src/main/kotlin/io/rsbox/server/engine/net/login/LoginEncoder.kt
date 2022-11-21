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

package io.rsbox.server.engine.net.login

import io.netty.buffer.ByteBuf
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Session

class LoginEncoder(private val session: Session) {

    fun encode(msg: Message, out: ByteBuf) {
        if(msg !is LoginResponse) return

        out.writeByte(2)
        out.writeByte(21)
        out.writeBoolean(false)
        out.writeInt(0)
        out.writeByte(msg.player.privilegeLevel.id)
        out.writeBoolean(msg.player.privilegeLevel.id > 0)
        out.writeShort(msg.player.index)
        out.writeBoolean(true)
        out.writeLong(0L)
    }
}