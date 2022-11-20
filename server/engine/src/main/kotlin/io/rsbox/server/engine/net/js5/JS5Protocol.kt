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

package io.rsbox.server.engine.net.js5

import io.netty.buffer.ByteBuf
import io.rsbox.server.cache.GameCache
import io.rsbox.server.common.inject
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Protocol
import io.rsbox.server.engine.net.Session

class JS5Protocol(session: Session) : Protocol(session) {

    private val cache: GameCache by inject()

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        buf.markReaderIndex()

        when(JS5RequestType.fromOpcode(buf.readByte().toInt())) {
            /*
             * Skip status request types
             */
            JS5RequestType.GAME_INIT,
            JS5RequestType.GAME_LOADED,
            JS5RequestType.GAME_READY -> {
                buf.skipBytes(3)
            }

            JS5RequestType.REQUEST_PRIORITY,
            JS5RequestType.REQUEST_NORMAL -> {
                if(buf.readableBytes() < 3) {
                    buf.resetReaderIndex()
                } else {
                    val archive = buf.readUnsignedByte().toInt()
                    val group = buf.readUnsignedShort()
                    JS5Request(archive, group).also { out.add(it) }
                }
            }
        }
    }

    override fun encode(msg: Message, out: ByteBuf) {
        if(msg !is JS5Response) return

        out.writeByte(msg.archive)
        out.writeShort(msg.group)
        out.writeByte(msg.compressionType)
        out.writeInt(msg.compressedSize)

        msg.data.forEach { byte ->
            if(out.writerIndex() % 512 == 0) {
                out.writeByte(-1)
            }
            out.writeByte(byte.toInt())
        }
    }

    override fun handle(msg: Message) {
        if(msg !is JS5Request) return
        session.writeAndFlush(msg.createResponse())
    }

    private fun JS5Request.createResponse(): JS5Response {
        val data = cache.read(archive, group)
        val compressionType = data.readUnsignedByte().toInt()
        val compressedSize = data.readInt()

        val bytes = ByteArray(data.writerIndex() - Byte.SIZE_BYTES - Int.SIZE_BYTES)
        data.readBytes(bytes)

        return JS5Response(archive, group, compressionType, compressedSize, bytes)
    }

    companion object {
        private val cachedResponses = mutableMapOf<JS5Request, JS5Response>()
    }
}