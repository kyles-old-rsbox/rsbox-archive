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

package io.rsbox.toolbox.asm.tree

import io.rsbox.toolbox.asm.util.field
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode

fun FieldNode.init(owner: ClassNode) {
    this.owner = owner
}

fun FieldNode.reset() {}
fun FieldNode.build() {}

var FieldNode.owner: ClassNode by field()
val FieldNode.pool get() = owner.pool

val FieldNode.identifier: String get() = "${owner.identifier}.$name"
val FieldNode.type: Type get() = Type.getType(desc)
val FieldNode.typeClass: ClassNode? get() = pool.findClass(type.internalName)