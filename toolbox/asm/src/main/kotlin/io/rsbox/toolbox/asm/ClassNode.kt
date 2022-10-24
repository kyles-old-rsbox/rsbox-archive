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

package io.rsbox.toolbox.asm

import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode

fun ClassNode.init(pool: ClassPool) {
    this.pool = pool
    methods.forEach { it.init(this) }
    fields.forEach { it.init(this) }
}

fun ClassNode.reset() {
    parent = null
    children.clear()
    interfaceClasses.clear()
    implementers.clear()
    methods.forEach { it.reset() }
    fields.forEach { it.reset() }
}

fun ClassNode.build() {
    parent = pool.findClass(superName)
    if(parent != null) {
        parent!!.children.add(this)
    }

    interfaces.mapNotNull { pool.findClass(it) }.forEach { interf ->
        interfaceClasses.add(interf)
        interf.implementers.add(this)
    }

    methods.forEach { it.build() }
    fields.forEach { it.build() }
}

var ClassNode.pool: ClassPool by field()
var ClassNode.ignored: Boolean by field { false }

var ClassNode.parent: ClassNode? by nullField()
val ClassNode.children: MutableList<ClassNode> by field { mutableListOf() }
val ClassNode.interfaceClasses: MutableList<ClassNode>  by field { mutableListOf() }
val ClassNode.implementers: MutableList<ClassNode>  by field { mutableListOf() }

val ClassNode.identifier: String get() = name
val ClassNode.type: Type get() = Type.getObjectType(name)

fun ClassNode.getMethod(name: String, desc: String) = methods.firstOrNull { it.name == name && it.desc == desc }
fun ClassNode.getField(name: String, desc: String) = fields.firstOrNull { it.name == name && it.desc == desc }