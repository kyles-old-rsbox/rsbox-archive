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

package io.rsbox.toolbox.updater.asm

import org.objectweb.asm.Type
import org.objectweb.asm.Type.*

fun Type.isPrimitive(): Boolean {
    return this in listOf(BOOLEAN_TYPE, BYTE_TYPE, SHORT_TYPE, CHAR_TYPE, INT_TYPE, VOID_TYPE, LONG_TYPE, FLOAT_TYPE, DOUBLE_TYPE)
}

fun Type.isObject(): Boolean {
    return sort == OBJECT
}