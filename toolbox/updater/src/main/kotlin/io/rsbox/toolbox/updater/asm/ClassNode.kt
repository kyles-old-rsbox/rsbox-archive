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

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.ClassObfuscatedInfo
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

var ClassNode.obfInfo: ClassObfuscatedInfo by field()
var ClassNode.obfName: String? by nullField()
var ClassNode.jarIndex: Int by field()

var ClassNode.mapping: ClassNode? by nullField()
fun ClassNode.isMapped() = this.mapping != null

val ClassNode.methodTypeRefs: MutableList<MethodNode> by field { mutableListOf() }
val ClassNode.fieldTypeRefs: MutableList<MethodNode> by field { mutableListOf() }
val ClassNode.strings: MutableList<String> by field { mutableListOf() }

val ClassNode.superClasses: List<ClassNode> get() {
    return interfaces.plus(superName).mapNotNull { pool.findClass(it) }.flatMap { it.superClasses.plus(it) }
}

fun ClassNode.resolveMethod(owner: String, name: String, desc: String): MethodNode? {
    val identifier = "$owner.$name$desc"
    if(identifier in pool.rootMethods) return pool.findClass(owner)?.getMethod(name, desc)
    if(name.startsWith("<init>")) return null
    val cls = pool.findClass(owner) ?: return null
    for(superCls in cls.superClasses) {
        return superCls.resolveMethod(superCls.name, name, desc) ?: continue
    }
    return null
}

fun ClassNode.resolveField(owner: String, name: String, desc: String): FieldNode? {
    val identifier = "$owner.$name"
    if(identifier in pool.rootFields) return pool.findClass(owner)?.getField(name, desc)
    val cls = pool.findClass(owner) ?: return null
    for(superCls in cls.superClasses) {
        return superCls.resolveField(superCls.name, name, desc) ?: continue
    }
    return null
}