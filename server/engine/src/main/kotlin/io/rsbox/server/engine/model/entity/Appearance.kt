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

data class Appearance(var styles: IntArray, var colors: IntArray, var gender: Gender) {

    companion object {
        private val DEFAULT_STYLES = intArrayOf(18, 26, 36, 0, 33, 42, 10)
        private val DEFAULT_COLORS = intArrayOf(0, 0, 0, 0, 0)
        private val DEFAULT_GENDER = Gender.MALE

        /**
         * The Old School RuneScape default noob appearance.
         */
        val DEFAULT = Appearance(DEFAULT_STYLES, DEFAULT_COLORS, DEFAULT_GENDER)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Appearance

        if (!styles.contentEquals(other.styles)) return false
        if (!colors.contentEquals(other.colors)) return false
        if (gender != other.gender) return false

        return true
    }

    override fun hashCode(): Int {
        var result = styles.contentHashCode()
        result = 31 * result + colors.contentHashCode()
        result = 31 * result + gender.hashCode()
        return result
    }
}