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

package io.rsbox.server.engine.net.pipeline

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.session

@Sharable
class NetworkChannelHandler : ChannelInboundHandlerAdapter() {

    override fun channelActive(ctx: ChannelHandlerContext) {
        val newSession = Session(ctx)
        newSession.onConnect()
        ctx.session = newSession
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        ctx.session.onDisconnect()
    }

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        if(msg !is Message) return
        ctx.session.onMessage(msg)
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        ctx.session.onError(cause)
    }
}