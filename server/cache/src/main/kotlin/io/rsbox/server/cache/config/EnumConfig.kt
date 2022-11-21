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

package io.rsbox.server.cache.config

import io.guthix.buffer.readString
import io.netty.buffer.ByteBuf

data class EnumConfig<K, V>(
    override val id: Int,
    val entryMap: MutableMap<K, V> = mutableMapOf()
) : Config(id), MutableMap<K, V> by entryMap {
    var keyType: Type? = null
    var valueType: Type? = null
    var defaultValue: Any? = null

    @Suppress("UNCHECKED_CAST")
    override fun get(key: K): V? {
        val value = entryMap[key]
        return value ?: return defaultValue as V
    }

    enum class Type(val letter: Char) {
        BOOLEAN('1'),
        ANIMATION('A'),
        INTEGER('i'),
        COMPONENT('I'),
        OBJ('o'),
        NAMED_OBJ('O'),
        STRING('s'),
        STAT('S'),
        INV('v'),
        NPC('n'),
        GRAPHIC('d'),
        ENUM('g'),
        LOC('l'),
        STRUCT('J'),
        MAP_AREA('`'),
        CATEGORY('y'),
        AREA('R'),
        COORDINATE('c'),
        COLOR('C'),
        MODEL('m'),
        APPEARANCE('K'),
        FONT('f'),
        CHAT_CHAR('k'),
        CHAR('z');

        companion object {
            operator fun invoke(char: Char?): Type? = values().find { it.letter == char }
        }
    }

    data class Component(val parent: Int, val child: Int) {
        companion object {
            fun decode(value: Int): Component = Component(value shr 16, value and 0xFFFF)
        }
    }

    data class Coordinate(
        val plane: Int,
        val regionX: Int,
        val regionY: Int,
        val localX: Int,
        val localY: Int
    ) {
        companion object {
            fun decode(value: Int): Coordinate {
                var out = value
                val localY = out and 64
                out = out shr 6
                val localX = value and 64
                out = out shr 6
                val regionY = value and 64
                out = out shr 6
                val regionX = value and 64
                out = out shr 6
                val plane = out and 2
                return Coordinate(plane, regionX, regionY, localX, localY)
            }
        }
    }

    enum class Stat {
        ATTACK,
        DEFENCE,
        STRENGTH,
        HITPOINTS,
        RANGED,
        PRAYER,
        MAGIC,
        COOKING,
        WOODCUTTING,
        FLETCHING,
        FISHING,
        FIREMAKING,
        CRAFTING,
        SMITHING,
        MINING,
        HERBLORE,
        AGILITY,
        THIEVING,
        SLAYER,
        FARMING,
        RUNECRAFTING,
        HUNTER,
        CONSTRUCTION;

        companion object {
            fun decode(id: Int): Stat = values()[id]
        }
    }

    companion object : ConfigCompanion<EnumConfig<Any, Any>>() {

        override val id: Int = 8

        fun decodeEnumType(type: Type?, value: Int): Any = when(type) {
            Type.BOOLEAN -> value == 1
            Type.COMPONENT -> Component.decode(value)
            Type.STAT -> Stat.decode(value)
            Type.COORDINATE -> Coordinate.decode(value)
            else -> value
        }

        override fun decode(id: Int, data: ByteBuf): EnumConfig<Any, Any> {
            val enumConfig = EnumConfig<Any, Any>(id)
            decoder@ while(true) {
                when(val opcode = data.readUnsignedByte().toInt()) {
                    0 -> break@decoder
                    1 -> enumConfig.keyType = Type(data.readUnsignedByte().toInt().toChar())
                    2 -> enumConfig.valueType = Type(data.readUnsignedByte().toInt().toChar())
                    3 -> enumConfig.defaultValue = data.readString()
                    4 -> {
                        val value = data.readInt()
                        enumConfig.defaultValue = if(value == -1) null else decodeEnumType(enumConfig.valueType, value)
                    }
                    5 -> {
                        val length = data.readUnsignedShort()
                        for(i in 0 until length) {
                            val key = decodeEnumType(enumConfig.keyType, data.readInt())
                            enumConfig.entryMap[key] = data.readString()
                        }
                    }
                    6 -> {
                        val length = data.readUnsignedShort()
                        for(i in 0 until length) {
                            val key = decodeEnumType(enumConfig.keyType, data.readInt())
                            enumConfig.entryMap[key] = decodeEnumType(enumConfig.valueType, data.readInt())
                        }
                    }
                    else -> throw IllegalStateException("Unknown opcode $opcode ")
                }
            }
            return enumConfig
        }
    }
}