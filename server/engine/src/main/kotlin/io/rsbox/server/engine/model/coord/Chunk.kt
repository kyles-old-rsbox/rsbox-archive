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
value class Chunk(val packed: Int) {

    val x get() = packed and 0x7FF

    val y get() = (packed shr 11) and 0x7FF

    val level get() = (packed shr 22) and 0x3

    constructor(x: Int, y: Int, level: Int = 0) : this(
        (x and 0x7FF) or ((y and 0x7FF) shl 11) or (level shl 22)
    )

    fun toTile() = Tile(
        x * SIZE,
        y * SIZE,
        level
    )

    fun toRegion() = Region(
        x / (Region.SIZE / SIZE),
        y / (Region.SIZE / SIZE)
    )

    fun toScene() = Scene(
        x / (Scene.SIZE / SIZE),
        y / (Scene.SIZE / SIZE)
    )

    companion object {
        const val SIZE = 8
    }
}