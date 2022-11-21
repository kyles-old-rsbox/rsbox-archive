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

package io.rsbox.server.engine.model.ui

enum class DisplayMode(val id: Int, val enum: Int) {
    FIXED(id = 548, enum = 1129),
    RESIZABLE_CLASSIC(id = 161, enum = 1130),
    RESIZABLE_MODERN(id = 164, enum = 1131),
    FULLSCREEN(id = 165, enum = 1132),
    MOBILE(id = 601, enum = 1745);

    fun isResizable() = this == RESIZABLE_CLASSIC || this == RESIZABLE_MODERN

    companion object {
        fun fromId(id: Int) = values().first { it.id == id }
    }
}