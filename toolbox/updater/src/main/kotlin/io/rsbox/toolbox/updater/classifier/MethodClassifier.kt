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

package io.rsbox.toolbox.updater.classifier

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.Mapping
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.asm.*
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.*
import kotlin.math.pow


fun Mapping.classifyMethod() {
    this.methodType()
    this.accessFlags()
    this.argTypes()
    this.returnType()
    this.owner()
    this.strings()
    this.refsIn()
    this.refsOut()
    this.classRefs()
    this.fieldReadRefs()
    this.fieldWriteRefs()
    this.overrides()
    this.methodInsns()
    this.fieldInsns()
    this.typeInsns()
    this.ldcInsns()
    this.varInsns()
}

private fun Mapping.methodType() {
    from as MethodNode
    to as MethodNode
    val mask = Opcodes.ACC_STATIC or Opcodes.ACC_NATIVE or Opcodes.ACC_ABSTRACT
    val resultFrom = from.access and mask
    val resultTo = to.access and mask
    val score = 1 - Integer.bitCount(((resultFrom.toDouble().pow(resultTo.toDouble()) / 3.0) * 10.0).toInt())
    increment(score)
}

private fun Mapping.accessFlags() {
    from as MethodNode
    to as MethodNode
    val mask = (Opcodes.ACC_PUBLIC or Opcodes.ACC_PROTECTED or Opcodes.ACC_PRIVATE) or Opcodes.ACC_FINAL or Opcodes.ACC_SYNCHRONIZED or Opcodes.ACC_BRIDGE or Opcodes.ACC_VARARGS or Opcodes.ACC_STRICT or Opcodes.ACC_SYNTHETIC
    val resultFrom = from.access and mask
    val resultTo = to.access and mask
    val score = 1 - Integer.bitCount(((resultFrom.toDouble().pow(resultTo.toDouble()) / 8.0) * 4.0).toInt())
    increment(score)
}

private fun Mapping.argTypes() {
    from as MethodNode
    to as MethodNode
    val score = from.type.argumentTypes.filter { f -> to.type.argumentTypes.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size
    increment(score * 10)
}

private fun Mapping.returnType() {
    from as MethodNode
    to as MethodNode
    val score = if(MappingUtil.isMaybeEqual(from.type.returnType, to.type.returnType)) 5 else 0
    increment(score)
}

private fun Mapping.owner() {
    from as MethodNode
    to as MethodNode
    val score = if(MappingUtil.isMaybeEqual(from.owner, to.owner)) 2 else 0
    increment(score)
}

private fun Mapping.strings() {
    from as MethodNode
    to as MethodNode
    val score = from.strings.filter { f -> to.strings.any { t -> f == t } }.size * 10
    increment(score)
}

private fun Mapping.refsIn() {
    from as MethodNode
    to as MethodNode
    val score = from.refsIn.filter { f -> to.refsIn.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.refsOut() {
    from as MethodNode
    to as MethodNode
    val score = from.refsOut.filter { f -> to.refsOut.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.classRefs() {
    from as MethodNode
    to as MethodNode
    val score = from.classRefs.filter { f -> to.classRefs.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.fieldReadRefs() {
    from as MethodNode
    to as MethodNode
    val score = from.fieldReadRefs.filter { f -> to.fieldReadRefs.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.fieldWriteRefs() {
    from as MethodNode
    to as MethodNode
    val score = from.fieldWriteRefs.filter { f -> to.fieldWriteRefs.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.overrides() {
    from as MethodNode
    to as MethodNode
    val score = from.overrides.filter { f -> to.overrides.any { t -> MappingUtil.isMaybeEqual(f, t) } }.size * 8
    increment(score)
}

private fun Mapping.methodInsns() {
    from as MethodNode
    to as MethodNode
    val fromInsns = from.instructions.filter { it is MethodInsnNode }.map { it as MethodInsnNode }.toList()
    val toInsns = to.instructions.filter { it is MethodInsnNode }.map { it as MethodInsnNode }.toList()
    val score = fromInsns.filter { f -> toInsns.any { t -> MappingUtil.isMaybeEqual(from.pool.findClass(f.owner)?.getMethod(f.name, f.desc), to.pool.findClass(t.owner)?.getMethod(t.name, t.desc)) } }.size
    increment(score)
}

private fun Mapping.fieldInsns() {
    from as MethodNode
    to as MethodNode
    val fromInsns = from.instructions.filter { it is FieldInsnNode }.map { it as FieldInsnNode }.toList()
    val toInsns = to.instructions.filter { it is FieldInsnNode }.map { it as FieldInsnNode }.toList()
    val score = fromInsns.filter { f -> toInsns.any { t -> MappingUtil.isMaybeEqual(from.pool.findClass(f.owner)?.getField(f.name, f.desc), to.pool.findClass(t.owner)?.getField(t.name, t.desc)) } }.size
    increment(score)
}

private fun Mapping.typeInsns() {
    from as MethodNode
    to as MethodNode
    val fromInsns = from.instructions.filter { it is TypeInsnNode }.map { it as TypeInsnNode }.toList()
    val toInsns = from.instructions.filter { it is TypeInsnNode }.map { it as TypeInsnNode }.toList()
    val score = fromInsns.filter { f -> toInsns.any { t -> MappingUtil.isMaybeEqual(from.pool.findClass(f.desc), to.pool.findClass(t.desc)) } }.size
    increment(score)
}

private fun Mapping.ldcInsns() {
    from as MethodNode
    to as MethodNode
    val fromInsns = from.instructions.filter { it is LdcInsnNode }.map { it as LdcInsnNode }.toList()
    val toInsns = from.instructions.filter { it is LdcInsnNode }.map { it as LdcInsnNode }.toList()
    val score = fromInsns.filter { f -> toInsns.any { t -> f.cst == t.cst } }.size
    increment(score)
}

private fun Mapping.varInsns() {
    from as MethodNode
    to as MethodNode
    val fromInsns = from.instructions.filter { it is VarInsnNode }.map { it as VarInsnNode }.toList()
    val toInsns = from.instructions.filter { it is VarInsnNode }.map { it as VarInsnNode }.toList()
    val score = fromInsns.filter { f -> toInsns.any { t -> f.`var` == t.`var` } }.size
    increment(score)
}