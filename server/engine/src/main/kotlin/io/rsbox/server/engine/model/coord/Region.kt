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

import io.rsbox.server.config.XteaConfig

@JvmInline
value class Region(val id: Int) {

    val x get() = id shr 8

    val y get() = id and 0xFF

    val xteas get() = XteaConfig.getRegionKey(id)

    constructor(x: Int, y: Int) : this(
        (x shl 8) or y
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

    fun toScene() = Scene(
        x / (Scene.SIZE / SIZE),
        y / (Scene.SIZE / SIZE)
    )

    companion object {
        const val SIZE = 64
    }
}