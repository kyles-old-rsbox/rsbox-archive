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

package io.rsbox.server.engine.model.worldlist

class WorldList(private val worlds: MutableList<WorldEntry> = mutableListOf()) : MutableList<WorldEntry> by worlds {

    init {
        worlds.addAll(arrayOf(
            WorldEntry(1, "127.0.0.1", "-", listOf(WorldType.MEMBERS), WorldLocation.UNITED_STATES, 0),
            WorldEntry(2, "127.0.0.1", "Development", listOf(WorldType.TOURNAMENT), WorldLocation.UNITED_STATES, 420)
        ))
    }
}