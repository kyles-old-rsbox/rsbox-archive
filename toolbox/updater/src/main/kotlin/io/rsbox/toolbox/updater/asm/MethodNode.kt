package io.rsbox.toolbox.updater.asm

import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.asm.util.field
import io.rsbox.toolbox.asm.util.nullField
import io.rsbox.toolbox.updater.util.linkedListOf
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode
import org.objectweb.asm.tree.LocalVariableNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.ParameterNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.tree.VarInsnNode
import java.lang.reflect.Modifier
import java.util.LinkedList

var MethodNode.match: MethodNode? by nullField()
fun MethodNode.hasMatch() = match != null

val MethodNode.strings: LinkedList<String> by field { linkedListOf() }
val MethodNode.numbers: LinkedList<Number> by field { linkedListOf() }
val MethodNode.refsIn: LinkedList<MethodNode> by field { linkedListOf() }
val MethodNode.refsOut: LinkedList<MethodNode> by field { linkedListOf() }
val MethodNode.fieldReadRefs: LinkedList<FieldNode> by field { linkedListOf() }
val MethodNode.fieldWriteRefs: LinkedList<FieldNode> by field { linkedListOf() }
val MethodNode.classRefs: LinkedList<ClassNode> by field { linkedListOf() }


internal fun MethodNode.loadInfo() {
    instructions.forEach { insn ->
        when(insn) {
            is LdcInsnNode -> {
                when(val cst = insn.cst) {
                    is Number -> numbers.add(cst)
                    is String -> strings.add(cst)
                }
            }
            is IntInsnNode -> {
                numbers.add(insn.operand)
            }
            is InsnNode -> {
                when(insn.opcode) {
                    in ICONST_M1..ICONST_5 -> numbers.add(insn.opcode - ICONST_0)
                    in LCONST_0..LCONST_1 -> numbers.add(insn.opcode - LCONST_0)
                    in FCONST_0..FCONST_2 -> numbers.add(insn.opcode - FCONST_0)
                    in DCONST_0..DCONST_1 -> numbers.add(insn.opcode - DCONST_0)
                }
            }
            is MethodInsnNode -> {
                val dst = pool.findClass(insn.owner)?.getMethod(insn.name, insn.desc) ?: return@forEach
                dst.refsIn.add(this)
                this.refsOut.add(dst)
                dst.owner.methodTypeRefs.add(this)
                this.classRefs.add(dst.owner)
            }
            is FieldInsnNode -> {
                val dst = pool.findClass(insn.owner)?.getField(insn.name, insn.desc) ?: return@forEach
                if(insn.opcode == GETFIELD || insn.opcode == GETSTATIC) {
                    dst.readRefs.add(this)
                    this.fieldReadRefs.add(dst)
                } else {
                    dst.writeRefs.add(this)
                    this.fieldWriteRefs.add(dst)
                }
                dst.owner.methodTypeRefs.add(this)
                this.classRefs.add(dst.owner)
            }
            is TypeInsnNode -> {
                val dst = pool.findClass(insn.desc) ?: return@forEach
                dst.methodTypeRefs.add(this)
                this.classRefs.add(dst)
            }
        }
    }
}