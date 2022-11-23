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

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.net.game.GameProtocol
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.handshake.HandshakeProtocol
import io.rsbox.server.util.security.IsaacRandom
import org.tinylog.kotlin.Logger
import java.util.concurrent.atomic.AtomicReference
import kotlin.collections.ArrayDeque
import kotlin.random.Random
import kotlin.random.nextLong

class Session(val ctx: ChannelHandlerContext) {

    val channel get() = ctx.channel()

    lateinit var player: Player internal set

    var seed = Random.nextLong(0..Long.MAX_VALUE)
    var xteas = IntArray(4) { 0 }
    var reconnectXteas: IntArray? = null

    val protocol = AtomicReference<Protocol>(null)

    var encoderIsaac = IsaacRandom()
    var decoderIsaac = IsaacRandom()

    private val packetQueue = ArrayDeque<Packet>()

    internal fun onConnect() {
        protocol.set(HandshakeProtocol(this))
    }

    internal fun onDisconnect() {
        if(protocol.get() is GameProtocol) {
            player.onLogout()
        }
    }

    internal fun onMessage(msg: Message) {
        if(protocol.get() is GameProtocol && msg is Packet) {
            packetQueue.add(msg)
        } else {
            protocol.get().handle(msg)
        }
    }

    internal fun onError(cause: Throwable) {
        if(cause.stackTrace.isEmpty() || (cause.stackTrace[0].methodName != "read0" && cause.stackTrace[0].methodName != "callDecode")) {
            Logger.error(cause) { "An error occurred in session networking thread. [Method: ${cause.stackTrace[0].methodName}]." }
            this.disconnect()
        }
    }

    fun disconnect() {
        if(channel.isActive) {
            ctx.close()
        }
    }

    fun write(msg: Message) = ctx.write(msg)
    fun write(buf: ByteBuf) = ctx.write(buf)
    fun writeAndFlush(msg: Message) = ctx.writeAndFlush(msg)
    fun writeAndFlush(buf: ByteBuf) = ctx.writeAndFlush(buf)

    fun flush() = ctx.flush()

    fun writeAndClose(msg: Message) {
        ctx.writeAndFlush(msg).addListener {
            if(it.isSuccess) {
                this.disconnect()
            }
        }
    }

    suspend fun cycle() {
        var handledPackets = 0
        while(packetQueue.isNotEmpty() && handledPackets < 10) {
            val packet = packetQueue.removeFirst()
            packet.handle(this)
            handledPackets++
        }
    }
}