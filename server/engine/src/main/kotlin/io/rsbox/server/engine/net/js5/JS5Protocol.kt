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

import com.google.common.primitives.Ints
import io.guthix.js5.container.Js5Compression
import io.guthix.js5.container.Js5Container
import io.guthix.js5.container.Uncompressed
import io.netty.buffer.ByteBuf
import io.rsbox.server.cache.GameCache
import io.rsbox.server.common.inject
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Protocol
import io.rsbox.server.engine.net.Session
import org.tinylog.kotlin.Logger

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

        msg.data.forEach { byte ->
            if(out.writerIndex() % 512 == 0) {
                out.writeByte(-1)
            }
            out.writeByte(byte.toInt())
        }
    }

    override fun handle(msg: Message) {
        if(msg !is JS5Request) return

        val response = msg.createResponse()
        if(response.archive == -1 && response.group == -1) {
            return
        }
        session.writeAndFlush(response)
    }

    @Suppress("KotlinConstantConditions")
    private fun JS5Request.createResponse(): JS5Response {
        /*
         * If the request is cached already, return the associated response.
         */
        cachedResponses[this]?.also { response ->
            return response
        }

        val bytes: ByteArray
        if(archive == 255) {
            if(group == 255) {
                val validator = cache.cache.generateValidator(
                    includeWhirlpool = false,
                    includeSizes = false
                )
                val container = Js5Container(validator.encode())
                val data = container.encode()
                bytes = ByteArray(data.readableBytes())
                data.readBytes(bytes)
            } else {
                val data = cache.read(archive, group)
                bytes = ByteArray(data.readableBytes())
                data.readBytes(bytes)
            }
        } else {
            val buf = cache.read(archive, group)
            var data = ByteArray(buf.readableBytes())
            buf.readBytes(data)
            if(data.isNotEmpty()) {
                val compression = data[0]
                val size = Ints.fromBytes(data[1], data[2], data[3], data[4])
                val targetSize = size + (if(compression.toInt() != 0) 9 else 5)
                if(targetSize != size && data.size - targetSize == 2) {
                    data = data.copyOf(data.size - 2)
                }
                bytes = data
            } else {
                Logger.warn("Failed to read data for [Archive: ${archive}, Group: ${group}].")
                return JS5Response(-1, -1, ByteArray(0))
            }
        }

        val response = JS5Response(archive, group, bytes)
        if(!cachedResponses.containsKey(this)) {
            cachedResponses[this] = response
        }
        return response
    }

    companion object {
        /**
         * Cached data responses. This will speed up the JS5 protocol over time as it avoids doing disk IO operations
         * for already read Js5Requests.
         */
        private val cachedResponses = hashMapOf<JS5Request, JS5Response>()
    }
}