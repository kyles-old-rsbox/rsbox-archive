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

package io.rsbox.server.engine.model.manager

import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.world.World
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.list.PlayerList

class GpiManager(private val player: Player) {

    private val world: World by inject()

    var localPlayerCount = 0
    val localPlayerIndexes = IntArray(PlayerList.MAX_PLAYERS)
    val localPlayers = arrayOfNulls<Player>(PlayerList.MAX_PLAYERS)

    var externalPlayerCount = 0
    val externalPlayerIndexes = IntArray(PlayerList.MAX_PLAYERS)

    val tiles = IntArray(PlayerList.MAX_PLAYERS)
    val skipFlags = IntArray(PlayerList.MAX_PLAYERS)

    fun init() {
        localPlayers[player.index] = player
        localPlayerIndexes[localPlayerCount++] = player.index

        for(index in 1 until PlayerList.MAX_PLAYERS) {
            if(index == player.index) continue
            externalPlayerIndexes[externalPlayerCount++] = index
            tiles[index] = world.players[index]?.tile?.to18BitInteger() ?: 0
        }
    }
}