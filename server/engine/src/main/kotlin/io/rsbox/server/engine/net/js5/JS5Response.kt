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

package io.rsbox.server.engine.net.js5

import io.rsbox.server.engine.net.Message

data class JS5Response(
    val archive: Int,
    val group: Int,
    val compressionType: Int,
    val compressedSize: Int,
    val data: ByteArray
) : Message {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JS5Response

        if (archive != other.archive) return false
        if (group != other.group) return false
        if (compressionType != other.compressionType) return false
        if (compressedSize != other.compressedSize) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = archive
        result = 31 * result + group
        result = 31 * result + compressionType
        result = 31 * result + compressedSize
        result = 31 * result + data.contentHashCode()
        return result
    }
}