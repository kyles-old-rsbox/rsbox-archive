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

import io.netty.channel.ChannelHandler
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Session
import java.util.concurrent.atomic.AtomicReference

@ChannelHandler.Sharable
class NetworkChannelHandler : ChannelInboundHandlerAdapter() {

    internal val session = AtomicReference<Session>(null)

    override fun channelActive(ctx: ChannelHandlerContext) {
        session.set(Session(ctx).also { it.onConnect() })
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        session.get().disconnect()
    }

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
        if(msg !is Message) return
        session.get().onMessage(msg)
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        session.get().onError(cause)
    }
}