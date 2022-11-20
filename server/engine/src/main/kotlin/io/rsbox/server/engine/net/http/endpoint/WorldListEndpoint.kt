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

package io.rsbox.server.engine.net.http.endpoint

import io.guthix.buffer.writeString
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.HttpHeaderNames.*
import io.netty.handler.codec.http.HttpHeaderValues
import io.netty.handler.codec.http.HttpResponseStatus
import io.netty.handler.codec.http.HttpVersion
import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.worldlist.WorldList

object WorldListEndpoint {

    private val worldList: WorldList by inject()

    fun handle(ctx: ChannelHandlerContext) {
        /*
         * Write the worlds info from the world-list into
         * a buffer.
         */
        val worldsBuf = ctx.alloc().buffer()
        worldsBuf.writeShort(worldList.size)
        worldList.forEach { worldEntry ->
            var mask = 0
            worldEntry.types.forEach { mask = mask or it.mask }
            worldsBuf.writeShort(worldEntry.id)
            worldsBuf.writeInt(mask)
            worldsBuf.writeString(worldEntry.address)
            worldsBuf.writeString(worldEntry.activity)
            worldsBuf.writeByte(worldEntry.location.id)
            worldsBuf.writeShort(worldEntry.players)
        }

        /*
         * Write the worldsBuf into a output buffer.
         */
        val buf = ctx.alloc().buffer()
        buf.writeInt(worldsBuf.readableBytes())
        buf.writeBytes(worldsBuf)

        val response = DefaultFullHttpResponse(
            HttpVersion.HTTP_1_1,
            HttpResponseStatus.OK,
            buf
        )
        val headers = response.headers()
        headers[CONTENT_TYPE] = "application/octet-stream"
        headers[CONTENT_LENGTH] = buf.readableBytes()
        headers[CONNECTION] = HttpHeaderValues.KEEP_ALIVE

        ctx.writeAndFlush(response)
    }

}