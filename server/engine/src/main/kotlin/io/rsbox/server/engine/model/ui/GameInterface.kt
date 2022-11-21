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

package io.rsbox.server.engine.model.ui

import io.rsbox.server.cache.GameCache
import io.rsbox.server.cache.config.EnumConfig
import io.rsbox.server.common.inject

enum class GameInterface(val interfaceId: Int, val child: Int, val type: InterfaceType = InterfaceType.OVERLAY) {
    CHAT_BOX(interfaceId = 162, child = 94, type = InterfaceType.OVERLAY),
    PRIVATE_CHAT(interfaceId = 163, child = 91, type = InterfaceType.OVERLAY),
    MINI_MAP(interfaceId = 160, child = 32, type = InterfaceType.OVERLAY),
    XP_TRACKER(interfaceId = 122, child = 1, type = InterfaceType.OVERLAY),
    SKILLS(interfaceId = 320, child = 76, type = InterfaceType.OVERLAY),
    QUESTS(interfaceId = 629, child = 77, type = InterfaceType.OVERLAY),
    INVENTORY(interfaceId = 149, child = 78, type = InterfaceType.OVERLAY),
    EQUIPMENT(interfaceId = 387, child = 79, type = InterfaceType.OVERLAY),
    PRAYER(interfaceId = 541, child = 80, type = InterfaceType.OVERLAY),
    SPELL_BOOK(interfaceId = 218, child = 81, type = InterfaceType.OVERLAY),
    ACCOUNT(interfaceId = 109, child = 83, type = InterfaceType.OVERLAY),
    SOCIAL(interfaceId = 429, child = 84, type = InterfaceType.OVERLAY),
    LOG_OUT(interfaceId = 182, child = 85, type = InterfaceType.OVERLAY),
    SETTINGS(interfaceId = 116, child = 86, type = InterfaceType.OVERLAY),
    EMOTES(interfaceId = 216, child = 87, type = InterfaceType.OVERLAY),
    MUSIC(interfaceId = 239, child = 88, type = InterfaceType.OVERLAY),
    CLANS(interfaceId = 707, child = 82, type = InterfaceType.OVERLAY),
    COMBAT(interfaceId = 593, child = 75, type = InterfaceType.OVERLAY),
    SIDE_BAR(interfaceId = 728, child = 34, type = InterfaceType.OVERLAY);

    private val cache: GameCache by inject()

    @Suppress("UNCHECKED_CAST")
    fun getChildId(displayMode: DisplayMode): Int {
        val mappings = cache.configArchive.enumConfigs[displayMode.enum]!!.entryMap as Map<EnumConfig.Component, EnumConfig.Component>
        return mappings[EnumConfig.Component(DisplayMode.RESIZABLE_CLASSIC.id, child)]?.child ?: throw IllegalArgumentException("Failed to get modal child mapping.")
    }

    companion object {

        private val cache: GameCache by inject()

        @Suppress("UNCHECKED_CAST")
        fun fromChild(displayMode: DisplayMode, child: Int): GameInterface? {
            val mappings = cache.configArchive.enumConfigs[displayMode.enum]!!.entryMap
                .mapValues { it.key } as Map<EnumConfig.Component, EnumConfig.Component>
            val key = mappings[EnumConfig.Component(displayMode.id, child)]?.child ?: return null
            return values().firstOrNull { it.child == key }
        }
    }
}

/*
 * Packet dump from osrs servers.
[ServerPacket] IF_OPENSUB(parent=165, child=2, interfaceId=162, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=7, interfaceId=651, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=6, interfaceId=708, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=31, interfaceId=163, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=10, interfaceId=303, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=32, interfaceId=160, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=12, interfaceId=122, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=39, interfaceId=728, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=37, interfaceId=378, type=0)
[ServerPacket] IF_OPENSUB(parent=165, child=17, interfaceId=320, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=18, interfaceId=629, type=1)
[ServerPacket] IF_OPENSUB(parent=629, child=33, interfaceId=399, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=19, interfaceId=149, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=20, interfaceId=387, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=21, interfaceId=541, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=22, interfaceId=218, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=25, interfaceId=429, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=24, interfaceId=109, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=26, interfaceId=182, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=27, interfaceId=116, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=28, interfaceId=216, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=29, interfaceId=239, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=23, interfaceId=707, type=1)
[ServerPacket] IF_OPENSUB(parent=707, child=7, interfaceId=7, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=32, interfaceId=160, type=1)
[ServerPacket] IF_OPENSUB(parent=165, child=16, interfaceId=593, type=1)

[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=2, toParent=161, toChild=94).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=14, toParent=161, toChild=16).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=9, toParent=161, toChild=1).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=11, toParent=161, toChild=8).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=15, toParent=161, toChild=73).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=16, toParent=161, toChild=75).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=17, toParent=161, toChild=76).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=18, toParent=161, toChild=77).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=19, toParent=161, toChild=78).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=20, toParent=161, toChild=79).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=21, toParent=161, toChild=80).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=22, toParent=161, toChild=81).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=23, toParent=161, toChild=82).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=24, toParent=161, toChild=83).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=25, toParent=161, toChild=84).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=26, toParent=161, toChild=85).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=27, toParent=161, toChild=86).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=28, toParent=161, toChild=87).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=29, toParent=161, toChild=88).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=30, toParent=161, toChild=3).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=31, toParent=161, toChild=91).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=32, toParent=161, toChild=32).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=12, toParent=161, toChild=9).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=13, toParent=161, toChild=10).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=38, toParent=161, toChild=17).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=7, toParent=161, toChild=6).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=6, toParent=161, toChild=5).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=5, toParent=161, toChild=12).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=10, toParent=161, toChild=2).
[ServerPacket] IF_MOVESUB(fromParent=165, fromChild=39, toParent=161, toChild=34).

 */