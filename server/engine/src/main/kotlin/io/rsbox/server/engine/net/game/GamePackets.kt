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

import io.github.classgraph.ClassGraph
import org.tinylog.kotlin.Logger
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

class GamePackets {

    val clientPackets = PacketRegistry()
    val serverPackets = PacketRegistry()

    internal fun load() {
        Logger.info("Loading game packets.")
        loadClientPackets()
        loadServerPackets()
    }

    private fun loadClientPackets() {
        ClassGraph()
            .enableClassInfo()
            .enableAnnotationInfo()
            .acceptPackages("io.rsbox.server.engine.net.packet.client")
            .scan()
            .use {
                it.getClassesWithAnnotation(ClientPacket::class.qualifiedName).forEach { classInfo ->
                    val annotation = classInfo.getAnnotationInfo(ClientPacket::class.qualifiedName)
                        .loadClassAndInstantiate() as ClientPacket
                    val opcode = annotation.opcode
                    val type = annotation.type
                    val packet = classInfo.loadClass().kotlin as KClass<Packet>
                    val codec = packet.companionObjectInstance as Codec<Packet>
                    val length = type.length
                    clientPackets.register(packet, opcode, codec, length)
                }
            }
        Logger.info("Registered ${clientPackets.size} client packets.")
    }

    private fun loadServerPackets() {
        ClassGraph()
            .enableClassInfo()
            .enableAnnotationInfo()
            .acceptPackages("io.rsbox.server.engine.net.packet.server")
            .scan()
            .use {
                it.getClassesWithAnnotation(ServerPacket::class.qualifiedName).forEach { classInfo ->
                    val annotation = classInfo.getAnnotationInfo(ServerPacket::class.qualifiedName)
                        .loadClassAndInstantiate() as ServerPacket
                    val opcode = annotation.opcode
                    val type = annotation.type
                    val packet = classInfo.loadClass().kotlin as KClass<Packet>
                    val codec = packet.companionObjectInstance as Codec<Packet>
                    val length = type.length
                    serverPackets.register(packet, opcode, codec, length)
                }
            }
        Logger.info("Registered ${serverPackets.size} server packets.")
    }

    companion object {

        /**
         * List of ClientPacket opcodes and lengths.
         *
         * This is used to be able to skip unimplemented client
         * packets's incoming buffers.
         * This can be removed once every client packet gets implemented.
         */
        internal val CLIENT_PACKET_LENGTHS = mapOf(
            0 to 0,
            1 to 9,
            2 to 14,
            3 to -1,
            4 to -1,
            5 to 3,
            6 to 8,
            7 to 0,
            8 to -2,
            9 to 3,
            10 to -1,
            11 to 7,
            12 to 8,
            13 to -1,
            14 to 7,
            15 to 7,
            16 to 8,
            17 to 3,
            18 to 15,
            19 to 8,
            20 to 8,
            21 to 8,
            22 to 8,
            23 to 8,
            24 to 7,
            25 to 7,
            26 to 13,
            27 to 4,
            28 to 8,
            29 to -1,
            30 to 7,
            31 to 3,
            32 to 7,
            33 to 4,
            34 to -1,
            35 to -1,
            36 to 4,
            37 to 8,
            38 to -2,
            39 to 1,
            40 to -1,
            41 to -1,
            42 to 3,
            43 to 2,
            44 to 6,
            45 to 3,
            46 to 0,
            47 to 8,
            48 to 15,
            49 to -1,
            50 to 3,
            51 to 5,
            52 to 8,
            53 to 4,
            54 to 15,
            55 to 6,
            56 to 3,
            57 to 16,
            58 to 16,
            59 to 8,
            60 to -1,
            61 to 3,
            62 to 7,
            63 to -1,
            64 to 8,
            65 to 8,
            66 to -1,
            67 to 3,
            68 to 8,
            69 to -2,
            70 to 6,
            71 to 3,
            72 to 11,
            73 to -1,
            74 to 8,
            75 to -1,
            76 to -1,
            77 to 8,
            78 to -1,
            79 to -1,
            80 to 11,
            81 to 8,
            82 to 7,
            83 to 3,
            84 to 15,
            85 to 2,
            86 to 9,
            87 to 2,
            88 to 0,
            89 to -1,
            90 to 4,
            91 to 8,
            92 to 3,
            93 to 7,
            94 to -1,
            95 to -1,
            96 to -1,
            97 to 0,
            98 to -1,
            99 to 2,
            100 to 2,
            101 to 10,
            102 to 3,
            103 to 16,
            104 to 11,
            105 to 7,
            106 to 11,
            107 to 22,
        )
    }
}