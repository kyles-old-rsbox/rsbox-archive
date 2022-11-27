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

@file:Suppress("UNCHECKED_CAST")

package io.rsbox.server.engine.net.game

import io.netty.buffer.ByteBuf
import io.rsbox.server.common.inject
import io.rsbox.server.engine.net.Message
import io.rsbox.server.engine.net.Protocol
import io.rsbox.server.engine.net.Session
import io.rsbox.server.util.buffer.toJagBuf
import org.tinylog.kotlin.Logger
import kotlin.reflect.KClass

class GameProtocol(session: Session) : Protocol(session) {

    private val gamePackets: GamePackets by inject()

    private var decoderStage = DecoderStage.OPCODE
    private var decoderOpcode = -1
    private var decoderLength = 0
    private var isUnknown = false

    override fun decode(buf: ByteBuf, out: MutableList<Any>) {
        try {
            when(decoderStage) {
                DecoderStage.OPCODE -> buf.decodeOpcode(out)
                DecoderStage.LENGTH -> buf.decodeLength(out)
                DecoderStage.PAYLOAD -> buf.decodePayload(out)
            }
        } catch (e: Exception) {
            Logger.error(e) { "An error occurred while decoding client packet. [opcode: $decoderOpcode]." }
            session.disconnect()
            return
        }
    }

    override fun encode(msg: Message, out: ByteBuf) {
        if(msg !is Packet) return

        val opcode = gamePackets.serverPackets.getOpcode(msg::class as KClass<out Packet>)
        val type = gamePackets.serverPackets.getType(opcode)
        val codec = gamePackets.serverPackets.getCodec(opcode)

        val buf = session.ctx.alloc().buffer().toJagBuf()
        codec.encode(session, msg, buf)

        val length = buf.writerIndex()

        out.writeByte((opcode + session.encoderIsaac.nextInt()) and 0xFF)

        when(type) {
            PacketType.VARIABLE_BYTE -> out.writeByte(length)
            PacketType.VARIABLE_SHORT -> out.writeShort(length)
            else -> { /* Do Nothing */ }
        }

        out.writeBytes(buf.toByteBuf())
        buf.release()
    }

    override fun handle(msg: Message) {
        println("handler: packet")
    }

    private enum class DecoderStage {
        OPCODE,
        LENGTH,
        PAYLOAD
    }

    private fun ByteBuf.decodeOpcode(out: MutableList<Any>) {
        decoderOpcode = (this.readUnsignedByte().toInt() - session.decoderIsaac.nextInt()) and 0xFF
        decoderLength = GamePackets.CLIENT_PACKET_LENGTHS[decoderOpcode] ?: throw IllegalStateException("No client packet length found for opcode: $decoderOpcode.")
        isUnknown = gamePackets.clientPackets.isUnknown(decoderOpcode)

        decoderStage = when {
            decoderLength == 0 -> {
                this.decodePayload(out)
                return
            }
            decoderLength < 0 -> DecoderStage.LENGTH
            else -> DecoderStage.PAYLOAD
        }
    }

    private fun ByteBuf.decodeLength(out: MutableList<Any>) {
        decoderLength = when(decoderLength) {
            -1 -> this.readUnsignedByte().toInt()
            -2 -> this.readUnsignedShort()
            else -> throw IllegalStateException("Illegal variable length of $decoderLength for opcode: $decoderOpcode.")
        }

        if(decoderLength == 0) {
            this.decodePayload(out)
        } else {
            decoderStage = DecoderStage.PAYLOAD
        }
    }

    private fun ByteBuf.decodePayload(out: MutableList<Any>) {
        if(this.readableBytes() >= decoderLength) {
            val payload = this.readBytes(decoderLength)
            decoderStage = DecoderStage.OPCODE

            if(!isUnknown) {
                val codec = gamePackets.clientPackets.getCodec(decoderOpcode)
                val packet = codec.decode(session, payload.toJagBuf())
                out.add(packet)
            } else {
                Logger.warn("Received unknown client packet. [opcode: $decoderOpcode, length: $decoderLength, remaining: ${this.readableBytes()}]")
            }
        }
    }
}