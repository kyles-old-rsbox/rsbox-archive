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

package io.rsbox.server.engine.model.list

import io.rsbox.server.engine.model.entity.Player
import java.util.*
import kotlin.random.Random

class PlayerList : Iterable<Player> {

    private val players = arrayOfNulls<Player>(MAX_PLAYERS)
    private val occupiedIndexes = mutableListOf<Int>()
    private val freeIndexes = Stack<Int>()
    private val iterator = PidIterator()

    init {
        for(index in MAX_PLAYERS downTo 1) {
            freeIndexes.push(index)
        }
    }

    val size: Int get() = occupiedIndexes.size

    fun addPlayer(player: Player) {
        player.index = freeIndexes.pop()
        player.pid = Random.nextInt(occupiedIndexes.size + 1)
        players[player.index] = player
        occupiedIndexes.add(player.pid, player.index)
    }

    fun removePlayer(player: Player) {
        players[player.index] = null
        occupiedIndexes.remove(player.index)
        freeIndexes.add(player.index)
    }

    fun randomizePid() {
        occupiedIndexes.shuffle()
        for(index in occupiedIndexes) {
            players[index]!!.pid = iterator.currentIndex
        }
    }

    operator fun get(index: Int): Player? = players[index]

    operator fun get(username: String): Player? = this.firstOrNull { it.username == username }

    override fun iterator(): PidIterator = PidIterator()

    inner class PidIterator : MutableIterator<Player> {
        internal var currentIndex = 0

        override fun hasNext(): Boolean = currentIndex < occupiedIndexes.size

        override fun next(): Player = players[occupiedIndexes[currentIndex++]] ?: next()

        override fun remove() {
            players[currentIndex] = null
            occupiedIndexes.remove(currentIndex)
            freeIndexes.add(currentIndex)
        }
    }

   companion object {
       const val MAX_PLAYERS = 2048
   }
}