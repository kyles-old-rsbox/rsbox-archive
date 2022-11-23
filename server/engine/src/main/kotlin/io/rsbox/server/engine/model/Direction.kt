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

package io.rsbox.server.engine.model

import io.rsbox.server.engine.model.coord.Tile

enum class Direction(val mask: Int, val stepX: Int, val stepY: Int) {
    NONE(0x0, 0, 0),
    NORTH(0x1, 0, 1),
    EAST(0x2, 1, 0),
    SOUTH(0x4, 0, -1),
    WEST(0x8, -1, 0),
    NORTH_EAST(NORTH.mask or EAST.mask, EAST.stepX, NORTH.stepY),
    SOUTH_EAST(SOUTH.mask or EAST.mask, EAST.stepX, SOUTH.stepY),
    NORTH_WEST(NORTH.mask or WEST.mask, WEST.stepX, NORTH.stepY),
    SOUTH_WEST(SOUTH.mask or WEST.mask, WEST.stepX, SOUTH.stepY);

    companion object {

        fun between(source: Tile, target: Tile): Direction {
            val dx = target.x - source.x
            val dy = target.y - source.y
            return when {
                dx == 0 && dy == 0 -> NONE
                dx > 0 && dy > 0 -> NORTH_EAST
                dx > 0 && dy == 0 -> EAST
                dx > 0 && dy < 0 -> SOUTH_EAST
                dx < 0 && dy > 0 -> NORTH_WEST
                dx < 0 && dy == 0 -> WEST
                dx < 0 && dy < 0 -> SOUTH_WEST
                dx == 0 && dy > 0 -> NORTH
                else -> SOUTH
            }
        }
    }
}