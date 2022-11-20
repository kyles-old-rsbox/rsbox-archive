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

@JvmInline
value class Scene(val packed: Int) {

    val x get() = packed and 0xFFFF

    val y get() = (packed shr 16) and 0xFFFF

    constructor(x: Int, y: Int) : this(
        (x and 0xFFFF) or ((y and 0xFFFF) shl 16)
    )

    fun toTile(level: Int = 0) = Tile(
        x * SIZE,
        y * SIZE,
        level
    )

    fun toChunk(level: Int = 0) = Chunk(
        x * (SIZE / Chunk.SIZE),
        y * (SIZE / Chunk.SIZE),
        level
    )

    fun toRegion() = Region(
        x * (SIZE / Region.SIZE),
        y * (SIZE / Region.SIZE)
    )

    companion object {
        const val SIZE = 104
    }
}