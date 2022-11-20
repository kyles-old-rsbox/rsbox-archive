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

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.rsbox.server.config.ServerConfig
import org.tinylog.kotlin.Logger
import java.net.InetSocketAddress
import kotlin.system.exitProcess

class HttpServer {

    private val bootstrap = ServerBootstrap()
    private val bossGroup = NioEventLoopGroup()
    private val workerGroup = NioEventLoopGroup()

    init {
        bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(HttpChannelInitializer())
            .childOption(ChannelOption.TCP_NODELAY, true)
            .childOption(ChannelOption.SO_REUSEADDR, true)
            .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
    }

    fun start() {
        Logger.info("Starting world list server.")

        val socketAddress = InetSocketAddress(ServerConfig.NETWORK.ADDRESS, 80)
        bootstrap.bind(socketAddress).sync().addListener {
            if(!it.isSuccess) {
                Logger.error(it.cause()) { "Failed to bind HTTP network server to: ${socketAddress.hostString}:${socketAddress.port}." }
                exitProcess(0)
            }
        }
    }

    fun stop() {
        Logger.info("Stopping world list server.")
        bossGroup.shutdownGracefully()
        workerGroup.shutdownGracefully()
    }

}