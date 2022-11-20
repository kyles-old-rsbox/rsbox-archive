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

package io.rsbox.server.engine.net.handshake

import io.netty.buffer.ByteBuf
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Protocol
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.StatusResponse

class HandshakeProtocol(session: Session) : Protocol(session) {

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        when(HandshakeType.fromOpcode(buf.readUnsignedByte().toInt())) {
            HandshakeType.JS5 -> HandshakeRequest.JS5(buf.readInt())
            HandshakeType.LOGIN -> HandshakeRequest.LOGIN()
            else -> throw IllegalStateException("Invalid handshake type.")
        }.also { out.add(it) }
    }

    override fun encode(msg: Message, out: ByteBuf) {
    }

    override fun handle(msg: Message) {
        when(msg) {
            is HandshakeRequest.JS5 -> msg.handle()
            is HandshakeRequest.LOGIN -> msg.handle()
        }
    }

    private fun HandshakeRequest.JS5.handle() {
        // Check Revision
        if(revision != ServerConfig.REVISION) {
            session.writeAndClose(StatusResponse.OUT_OF_DATE)
            return
        }

        session.writeAndFlush(StatusResponse.SUCCESSFUL)
        println("JS5 handshake")
    }

    private fun HandshakeRequest.LOGIN.handle() {
        println("Login handshake")
    }
}