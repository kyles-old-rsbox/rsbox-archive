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

package io.rsbox.server.engine.model.entity

import io.rsbox.server.engine.model.Direction
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.queue.PriorityQueueList
import org.tinylog.kotlin.Logger

abstract class LivingEntity : Entity() {

    var index = -1

    abstract val size: Int
    abstract override var tile: Tile
    abstract var prevTile: Tile
    abstract var followTile: Tile

    var teleportTile: Tile? = null
    var path = mutableListOf<Tile>()
    var interacting: LivingEntity? = null
    var movementState = MovementState.NONE
    var invisible = false
    var direction = Direction.SOUTH

    internal val queue = PriorityQueueList()

    internal suspend fun queueCycle() {
        val shouldPollPending = queue.paused
        try {
            queue.processCurrent()
        } catch (e: Throwable) {
            queue.discardCurrent()
            Logger.error(e) { "An error occurred in queue." }
        }
        if(shouldPollPending) {
            try {
                queue.pollPending()
            } catch (e: Throwable) {
                Logger.error(e) { "An error occurred in queue." }
            }
        }
    }

    abstract suspend fun cycle()

}