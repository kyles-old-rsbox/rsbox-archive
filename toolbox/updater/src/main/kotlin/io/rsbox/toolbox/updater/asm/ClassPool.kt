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
import io.rsbox.toolbox.updater.ObfuscatedInfo
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.AbstractInsnNode.*
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.LdcInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.TypeInsnNode

var ClassPool.obfInfo: ObfuscatedInfo by field()

private var ClassPool._rootMethods: HashSet<String>? by nullField()
internal val ClassPool.rootMethods: Set<String> get() {
    if(_rootMethods == null) {
        val ret = hashSetOf<String>()
        classes.forEach { cls ->
            val supers = cls.superClasses
            cls.methods.forEach { method ->
                if(supers.none { it.getMethod(method.name, method.desc) != null }) {
                    ret.add(method.identifier)
                }
            }
        }
        _rootMethods = ret
    }
    return _rootMethods!!
}

private var ClassPool._rootFields: HashSet<String>? by nullField()
internal val ClassPool.rootFields: Set<String> get() {
    if(_rootFields == null) {
        val ret = hashSetOf<String>()
        classes.forEach { cls ->
            val supers = cls.superClasses
            cls.fields.forEach { field ->
                if(supers.none { it.getField(field.name, field.desc) != null }) {
                    ret.add(field.identifier)
                }
            }
        }
        _rootFields = ret
    }
    return _rootFields!!
}

internal fun ClassPool.extractFeatures() {
    extractFeaturesA()
    extractFeaturesB()
}

private fun ClassPool.extractFeaturesA() {
    classes.forEach { cls ->
        cls.methods.forEach { method ->
            method.instructions.forEach insnLoop@ { insn ->
                if(insn !is LdcInsnNode) return@insnLoop
                if(insn.cst !is String) return@insnLoop
                if((insn.cst as String).isBlank()) return@insnLoop
                method.strings.add(insn.cst as String)
                cls.strings.add(insn.cst as String)
            }
        }
        cls.fields.forEach fieldLoop@ { field ->
            if(field.value is String) {
                if((field.value as String).isBlank()) return@fieldLoop
                cls.strings.add(field.value as String)
            }
        }
    }
}

private fun ClassPool.extractFeaturesB() {
    classes.forEach { cls ->
        cls.methods.forEach { method ->
            val insns = method.instructions.iterator()
            while(insns.hasNext()) {
                val insn = insns.next()
                when(insn.type) {
                    METHOD_INSN -> {
                        insn as MethodInsnNode
                        val dst = cls.resolveMethod(insn.owner, insn.name, insn.desc) ?: continue

                        dst.refsIn.add(method)
                        method.refsOut.add(dst)
                        dst.owner.methodTypeRefs.add(method)
                        method.classRefs.add(dst.owner)
                    }
                    FIELD_INSN -> {
                        insn as FieldInsnNode
                        val dst = cls.resolveField(insn.owner, insn.name, insn.desc) ?: continue

                        if(insn.opcode == GETSTATIC || insn.opcode == GETFIELD) {
                            dst.readRefs.add(method)
                            method.fieldReadRefs.add(dst)
                        } else {
                            dst.writeRefs.add(method)
                            method.fieldWriteRefs.add(dst)
                        }

                        dst.owner.methodTypeRefs.add(method)
                        method.classRefs.add(dst.owner)
                    }
                    TYPE_INSN -> {
                        insn as TypeInsnNode
                        val dst = this.findClass(insn.desc) ?: continue

                        dst.methodTypeRefs.add(method)
                        method.classRefs.add(dst)
                    }
                }
            }
        }
    }
}