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

package io.rsbox.server.engine.net

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.net.pipeline.NetworkChannelInitializer
import org.tinylog.kotlin.Logger
import java.net.InetSocketAddress
import kotlin.system.exitProcess

class NetworkServer {

    private val bootstrap = ServerBootstrap()

    private val bossGroup = NioEventLoopGroup(2)
    private val workerGroup = NioEventLoopGroup(1)

    private val channelInitializer = NetworkChannelInitializer()

    init {
        bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(channelInitializer)
            .childOption(ChannelOption.TCP_NODELAY, true)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
    }

    fun start() {
        Logger.info("Starting network server.")
        val socketAddress = InetSocketAddress(ServerConfig.NETWORK.ADDRESS, ServerConfig.NETWORK.PORT)
        bootstrap.bind(socketAddress).addListener {
            if(it.isSuccess) onBindSuccess(socketAddress)
            else onBindFailure(socketAddress, it.cause())
        }
    }

    fun stop() {
        Logger.info("Stopping network server.")
        bossGroup.shutdownGracefully()
        workerGroup.shutdownGracefully()
    }

    private fun onBindSuccess(socketAddress: InetSocketAddress) {
        Logger.info("Server now listening for connections on ${socketAddress.hostString}:${socketAddress.port}.")
    }

    private fun onBindFailure(socketAddress: InetSocketAddress, cause: Throwable) {
        Logger.error(cause) { "An error occurred while starting network server on ${socketAddress.hostString}:${socketAddress.port}. Exiting process." }
        exitProcess(0)
    }
}