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

enum class WorldType(val mask: Int) {
    F2P(0),
    MEMBERS(1),
    PVP(1 shl 2),
    OTHER(1 shl 4),
    DEAD_MAN(1 shl 29),
    BETA(1 shl 25),
    LEAGUES(1 shl 30),
    SPEED_RUNNING(1 shl 8),
    FRESH_START(1 shl 27);
}