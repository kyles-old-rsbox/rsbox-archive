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
import io.rsbox.toolbox.updater.FieldObfuscatedInfo
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

var FieldNode.obfInfo: FieldObfuscatedInfo by field()
var FieldNode.obfOwner: String? by nullField()
var FieldNode.obfName: String? by nullField()
var FieldNode.obfDesc: String? by nullField()

var FieldNode.mapping: FieldNode? by nullField()
fun FieldNode.isMapped() = mapping != null

val FieldNode.readRefs: MutableList<MethodNode> by field { mutableListOf() }
val FieldNode.writeRefs: MutableList<MethodNode> by field { mutableListOf() }