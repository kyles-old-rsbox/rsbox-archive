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

import io.rsbox.toolbox.asm.field
import io.rsbox.toolbox.asm.nullField
import io.rsbox.toolbox.updater.MethodObfuscatedInfo
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

var MethodNode.obfInfo: MethodObfuscatedInfo by field()
var MethodNode.obfOwner: String? by nullField()
var MethodNode.obfName: String? by nullField()
var MethodNode.obfDesc: String? by nullField()
var MethodNode.opaque: Int? by nullField()

var MethodNode.mapping: MethodNode? by nullField()
fun MethodNode.isMapped() = mapping != null

val MethodNode.refsIn: MutableList<MethodNode> by field { mutableListOf() }
val MethodNode.refsOut: MutableList<MethodNode> by field { mutableListOf() }
val MethodNode.fieldReadRefs: MutableList<FieldNode> by field { mutableListOf() }
val MethodNode.fieldWriteRefs: MutableList<FieldNode> by field { mutableListOf() }
val MethodNode.classRefs: MutableList<ClassNode> by field { mutableListOf() }
val MethodNode.strings: MutableList<String> by field { mutableListOf() }
val MethodNode.numbers: MutableList<Number> by field { mutableListOf() }