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

package io.rsbox.server.util.buffer

sealed class DataType(val size: Int)

object BYTE : DataType(1)
object SHORT : DataType(2)
object MEDIUM : DataType(3)
object INT : DataType(4)
object LONG : DataType(8)
object BYTES : DataType(-1)
object SMART : DataType(-1)
object STRING : DataType(-1)