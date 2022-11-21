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

package io.rsbox.server.engine.net.http

import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpMethod
import io.netty.handler.codec.http.HttpResponseStatus
import io.netty.handler.codec.http.QueryStringDecoder
import io.rsbox.server.engine.net.http.endpoint.JavConfigEndpoint
import io.rsbox.server.engine.net.http.endpoint.WorldListEndpoint

@ChannelHandler.Sharable
class HttpRequestHandler : SimpleChannelInboundHandler<FullHttpRequest>() {

    override fun channelRead0(ctx: ChannelHandlerContext, msg: FullHttpRequest) {
        if(!msg.decoderResult().isSuccess) {
            ctx.writeHttpError(HttpResponseStatus.BAD_REQUEST)
            return
        }

        if(msg.method() != HttpMethod.GET) {
            ctx.writeHttpError(HttpResponseStatus.METHOD_NOT_ALLOWED)
            return
        }

        val uri = msg.uri()
        val query = QueryStringDecoder(uri)

        when {
            query.path() == "/jav_config.ws" -> JavConfigEndpoint.handle(ctx, msg, query)
            query.path() == "/world_list.ws" -> WorldListEndpoint.handle(ctx)
            else -> ctx.writeHttpError(HttpResponseStatus.NOT_FOUND)
        }
    }

    @Suppress("OVERRIDE_DEPRECATION")
    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        cause.printStackTrace()
        if(ctx.channel().isActive) {
            ctx.writeHttpError(HttpResponseStatus.INTERNAL_SERVER_ERROR)
        }
    }
}