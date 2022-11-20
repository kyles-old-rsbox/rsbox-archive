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

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.rsbox.server.engine.net.StatusResponse

class NetworkChannelInitializer : ChannelInitializer<SocketChannel>() {
    override fun initChannel(ch: SocketChannel) {
        val handler = NetworkChannelHandler()
        val encoder = NetworkChannelEncoder(handler)
        val decoder = NetworkChannelDecoder(handler)

        ch.pipeline()
            .addLast("status-encoder", StatusResponse.Encoder())
            .addLast("decoder", decoder)
            .addLast("encoder", encoder)
            .addLast("handler", handler)
    }
}