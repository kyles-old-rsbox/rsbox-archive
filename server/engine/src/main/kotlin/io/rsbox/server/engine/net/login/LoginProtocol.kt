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
import io.rsbox.server.engine.net.Protocol
import io.rsbox.server.engine.net.Session

class LoginProtocol(session: Session) : Protocol(session) {

    private val decoder = LoginDecoder(session)
    private val encoder = LoginEncoder(session)

    override fun decode(buf: ByteBuf, out: MutableList<Any>) = decoder.decode(buf, out)
    override fun encode(msg: Message, out: ByteBuf) = encoder.encode(msg, out)

    override fun handle(msg: Message) {
        if(msg !is LoginRequest) return
        println("Login request: [Username: ${msg.username}, Password: ${msg.password}].")
    }
}