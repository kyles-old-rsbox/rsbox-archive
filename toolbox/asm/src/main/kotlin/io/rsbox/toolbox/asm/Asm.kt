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

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

fun ClassPool.readJar(file: File, extraLogic: (JarEntry) -> Unit = {}) {
    JarFile(file).use { jar ->
        jar.entries().asSequence().forEach { entry ->
            if(entry.name.endsWith(".class")) {
                val node = readClass(jar.getInputStream(entry).readAllBytes())
                this.addClass(node)
                extraLogic(entry)
            }
        }
    }
}

fun ClassPool.writeJar(file: File, extraLogic: (JarOutputStream) -> Unit = {}) {
    if(file.exists()) {
        file.deleteRecursively()
    }

    JarOutputStream(FileOutputStream(file)).use { jos ->
        this.allClasses.forEach { cls ->
            jos.putNextEntry(JarEntry(cls.name + ".class"))
            jos.writeClass(cls)
            jos.closeEntry()
        }
        extraLogic(jos)
    }
}

fun readClass(data: ByteArray): ClassNode {
    val node = ClassNode()
    val reader = ClassReader(data)
    reader.accept(node, 0)
    return node
}

fun OutputStream.writeClass(node: ClassNode) {
    val writer = ClassWriter(ClassWriter.COMPUTE_MAXS)
    node.accept(writer)
    this.write(writer.toByteArray())
}


fun AbstractInsnNode.isInstruction(): Boolean = this !is LineNumberNode && this !is FrameNode && this !is LabelNode

fun AbstractInsnNode.next(amount: Int): AbstractInsnNode {
    var cur = this
    repeat(amount) {
        cur = cur.next
    }
    return cur
}

fun AbstractInsnNode.previous(amount: Int): AbstractInsnNode {
    var cur = this
    repeat(amount) {
        cur = cur.previous
    }
    return cur
}

fun AbstractInsnNode.isTerminating(): Boolean = when(this.opcode) {
    Opcodes.RETURN,
    Opcodes.ARETURN,
    Opcodes.IRETURN,
    Opcodes.FRETURN,
    Opcodes.DRETURN,
    Opcodes.LRETURN,
    Opcodes.ATHROW,
    Opcodes.TABLESWITCH,
    Opcodes.LOOKUPSWITCH,
    Opcodes.GOTO -> true
    else -> false
}

fun InsnList.copy(): InsnList {
    val newInsnList = InsnList()
    var insn = this.first
    while(insn != null) {
        newInsnList.add(insn)
        insn = insn.next
    }
    return newInsnList
}

fun InsnList.clone(): InsnList {
    val newInsnList = InsnList()
    val labels = LabelMap()
    var insn = this.first
    while(insn != null) {
        newInsnList.add(insn.clone(labels))
        insn = insn.next
    }
    return newInsnList
}

inline fun <reified T : AbstractInsnNode> Collection<AbstractInsnNode>.findFirst(): AbstractInsnNode {
    this.forEach { insn ->
        if(insn::class == T::class) {
            return insn
        }
    }
    throw NullPointerException()
}

class LabelMap : AbstractMap<LabelNode, LabelNode>() {
    private val map = hashMapOf<LabelNode, LabelNode>()
    override val entries get() = throw IllegalStateException()
    override fun get(key: LabelNode) = map.getOrPut(key) { LabelNode() }
}

fun isJdkMethod(owner: String, name: String, desc: String): Boolean {
    try {
        var classes = listOf(Class.forName(Type.getObjectType(owner).className))
        while(classes.isNotEmpty()) {
            for(cls in classes) {
                if(cls.declaredMethods.any { it.name == name && Type.getMethodDescriptor(it) == desc }) {
                    return true
                }
            }
            classes = classes.flatMap {
                mutableListOf<Class<*>>().apply {
                    addAll(it.interfaces)
                    if(it.superclass != null) {
                        add(it.superclass)
                    }
                }
            }
        }
    } catch(e: Exception) { /* Do Nothing */ }
    return false
}

fun InsnList.createLabel(insn: AbstractInsnNode, forceCreate: Boolean = false): LabelNode {
    if(insn is LabelNode) return insn
    val idx = this.indexOf(insn)
    if(idx > 0) {
        val before = this[idx - 1]
        if(!forceCreate && before is LabelNode) {
            return before
        }
    }
    val labelMap = LabelMap()
    val label = LabelNode()
    this.insert(this[idx], label)
    return label
}