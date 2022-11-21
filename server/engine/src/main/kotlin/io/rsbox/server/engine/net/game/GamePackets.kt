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
}