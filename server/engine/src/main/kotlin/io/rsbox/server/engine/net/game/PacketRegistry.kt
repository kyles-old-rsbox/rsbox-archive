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

package io.rsbox.server.engine.net.game

import kotlin.reflect.KClass

class PacketRegistry {

    private val packets = mutableSetOf<PacketInfo>()

    val size: Int get() = packets.size

    internal fun register(
        packet: KClass<Packet>,
        opcode: Int,
        codec: Codec<Packet>,
        length: Int
    ) {
        val info = PacketInfo(packet, opcode, codec, length)
        packets.add(info)
    }

    fun getOpcode(packet: KClass<out Packet>): Int = packets.first { it.packet == packet }.opcode
    fun getCodec(opcode: Int): Codec<Packet> = packets.first { it.opcode == opcode }.codec
    fun getLength(opcode: Int): Int = packets.first { it.opcode == opcode }.length

    fun getType(opcode: Int) = when(getLength(opcode)) {
        -1 -> PacketType.VARIABLE_BYTE
        -2 -> PacketType.VARIABLE_SHORT
        else -> PacketType.FIXED
    }

    fun isUnknown(opcode: Int) = packets.firstOrNull { it.opcode == opcode } == null

    private data class PacketInfo(
        val packet: KClass<Packet>,
        val opcode: Int,
        val codec: Codec<Packet>,
        val length: Int
    )
}