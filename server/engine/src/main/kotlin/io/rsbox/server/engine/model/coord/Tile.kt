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

package io.rsbox.server.engine.model.coord

import io.rsbox.server.engine.model.Direction
import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

@JvmInline
value class Tile(val packed: Int) {

    val x get() = packed and 0x7FFF

    val y get() = (packed shr 15) and 0x7FFF

    val level get() = (packed shr 30) and 0x3

    fun to18BitInteger() = (y shr 13) or ((x shr 13) shl 8) or ((level and 0x3) shl 16)

    fun to30BitInteger() = (y and 0x3FFF) or ((x and 0x3FFF) shl 14) or ((level and 0x3) shl 28)

    constructor(x: Int, y: Int, level: Int = 0) : this(
        (x and 0x7FFF) or ((y and 0x7FFF) shl 15) or (level shl 30)
    )

    fun translate(x: Int = 0, y: Int = 0, level: Int = 0) = Tile(
        this.x + x,
        this.y + y,
        this.level + level
    )

    operator fun plus(other: Tile) = translate(other.x, other.y)
    operator fun minus(other: Tile) = translate(-other.x, -other.y)

    fun isWithinRadius(x: Int, y: Int, level: Int, radius: Int): Boolean {
        if(this.level != level) return false
        val dx = abs(this.x - x)
        val dy = abs(this.y - y)
        return dx <= radius && dy <= radius
    }

    fun isWithinRadius(other: Tile, radius: Int) = isWithinRadius(other.x, other.y, other.level, radius)

    fun distanceTo(x: Int, y: Int): Int {
        val dx = this.x - x
        val dy = this.y - y
        return ceil(sqrt((dx * dx + dy * dy).toDouble())).toInt()
    }

    fun distanceTo(other: Tile): Int {
        if(this.level != other.level) throw IllegalArgumentException("Can not get distance between different levels.")
        return distanceTo(other.x, other.y)
    }

    fun deltaTo(x: Int, y: Int) = abs(this.x - x) + abs(this.y - y)

    fun deltaTo(other: Tile) = deltaTo(other.x, other.y)

    fun directionTo(other: Tile) = Direction.between(this, other)

    fun directionTo(x: Int, y: Int) = directionTo(Tile(x, y, this.level))

    fun sameAs(x: Int, y: Int) = this.x == x && this.y == y

    fun sameAs(other: Tile) = sameAs(other.x, other.y)

    fun toChunk() = Chunk(
        x / Chunk.SIZE,
        y / Chunk.SIZE,
        level
    )

    fun toRegion() = Region(
        x / Region.SIZE,
        y / Region.SIZE
    )

    fun toScene() = Scene(
        x / Scene.SIZE,
        y / Scene.SIZE
    )

    companion object {
        const val SIZE = 1
    }
}