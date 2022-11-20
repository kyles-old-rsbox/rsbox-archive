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
    FREE(0),
    MEMBERS(1),
    PVP(1 shl 2),
    BOUNTY_HUNTER(1 shl 5),
    SKILL_TOTAL(1 shl 7),
    PVP_HIGH_RISK(1 shl 10),
    UNKNOWN1(1 shl 14),
    TOURNAMENT(1 shl 25),
    UNKNOWN2(1 shl 26),
    DEADMAN(1 shl 29),
    LEAGUES(1 shl 30);
}