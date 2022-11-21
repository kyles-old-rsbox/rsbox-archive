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
    private val activeIndexes = mutableListOf<Int>()
    private val inactiveIndexes = Stack<Int>()
    private val iterator = PidIterator()

    init {
        for(index in MAX_PLAYERS downTo 1) {
            inactiveIndexes.push(index)
        }
    }

    val size get() = activeIndexes.size

    override fun iterator(): Iterator<Player> = PidIterator()

    fun addPlayer(player: Player) {
        player.index = inactiveIndexes.pop()
        player.pid = Random.nextInt(size + 1)
        players[player.index] = player
        activeIndexes.add(player.pid, player.index)
    }

    fun removePlayer(player: Player) {
        players[player.index] = null
        activeIndexes.remove(player.index)
        inactiveIndexes.add(player.index)
        player.index = -1
        player.pid = -1
    }

    fun randomizePid() {
        activeIndexes.shuffle()
        activeIndexes.forEach { index ->
            players[index]!!.pid = iterator.currentIndex
        }
    }

    operator fun get(index: Int): Player? = players[index]

    operator fun get(username: String): Player? = this.firstOrNull { it.username == username }

    inner class PidIterator : MutableIterator<Player> {
        internal var currentIndex = 0

        override fun hasNext(): Boolean {
            return currentIndex < this@PlayerList.size
        }

        override fun next(): Player {
            return players[activeIndexes[currentIndex++]] ?: next()
        }

        override fun remove() {
            players[currentIndex] = null
            activeIndexes.remove(currentIndex)
            inactiveIndexes.add(currentIndex)
        }
    }

    companion object {
        const val MAX_PLAYERS = 2048
    }
}