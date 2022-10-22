@file:Suppress("SafeCastWithReturn")

package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.collect.MultimapBuilder
import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.*
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.Type.BYTE_TYPE
import org.objectweb.asm.Type.SHORT_TYPE
import org.objectweb.asm.Type.INT_TYPE
import org.objectweb.asm.tree.*
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class OpaquePredicateRemover : Transformer {

    private var checkCount = 0
    private var argCount = 0

    override fun run(pool: ClassPool) {
        removeOpaquePredicates(pool)
        removeOpaqueArgs(pool)
    }

    private fun removeOpaquePredicates(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(method.instructions.size() == 0) return@methodLoop
                val modifier = InstructionModifier()
                listOf(EXCEPTION_PATTERN, RETURN_PATTERN).forEach { pattern ->
                    InstructionMatcher(method.instructions).search(pattern).forEach matchLoop@ { insns ->
                        insns.firstOrNull { it is VarInsnNode && it.`var` == method.lastArgIndex } as? VarInsnNode ?: return@matchLoop
                        insns.firstOrNull { it is IntInsnNode || (it is LdcInsnNode && it.cst is Number) || it.opcode in ICONST_M1..ICONST_5 } ?: return@matchLoop
                        val cmpInsn = insns.firstOrNull { it is JumpInsnNode && it.opcode != GOTO } as? JumpInsnNode ?: return@matchLoop
                        val methodInsn = insns.firstOrNull { it is MethodInsnNode } as? MethodInsnNode
                        if(methodInsn != null && methodInsn.owner != Type.getInternalName(java.lang.IllegalStateException::class.java)) return@matchLoop
                        val gotoInsn = JumpInsnNode(GOTO, LabelNode(cmpInsn.label.label))
                        modifier.append(insns.last(), gotoInsn)
                        modifier.removeAll(insns)
                        checkCount++
                    }
                }
                modifier.apply(method)
            }
        }

        Logger.info("Removed $checkCount opaque predicates.")
    }

    private fun removeOpaqueArgs(pool: ClassPool) {
        val classNames = pool.allClasses.associateBy { it.name }
        val rootMethods = hashSetOf<String>()
        val opaqueMethodsMap = MultimapBuilder.hashKeys().arrayListValues().build<String, MethodNode>()
        val opaqueMethods = opaqueMethodsMap.asMap()

        pool.classes.forEach { cls ->
            val superClasses = findSupers(cls, classNames)
            cls.methods.forEach { method ->
                if(superClasses.none { it.getMethod(method.name, method.desc) != null }) {
                    rootMethods.add(method.identifier)
                }
            }
        }

        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                val identifier = findOverride(method.owner.name, method.name, method.desc, rootMethods, classNames) ?: return@methodLoop
                opaqueMethodsMap.put(identifier, method)
            }
        }

        val it = opaqueMethods.iterator()
        for((_, method) in it) {
            if(method.any { !it.hasOpaqueArg() }) it.remove()
        }

        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                method.instructions.forEach insnLoop@ { insn ->
                    if(insn !is MethodInsnNode) return@insnLoop
                    val identifier = findOverride(insn.owner, insn.name, insn.desc, opaqueMethods.keys, classNames) ?: return@insnLoop
                    if(!insn.previous.isIntConstant()) opaqueMethods.remove(identifier)
                }
            }
        }

        opaqueMethodsMap.values().forEach { method ->
            val oldDesc = method.desc
            val newDesc = oldDesc.dropLastArg()
            method.desc = newDesc
            argCount++
        }

        pool.classes.flatMap { it.methods }.forEach { method ->
            val insns = method.instructions
            for(insn in insns) {
                if(insn !is MethodInsnNode) continue
                if(findOverride(insn.owner, insn.name, insn.desc, opaqueMethods.keys, classNames) != null) {
                    insn.desc = insn.desc.dropLastArg()
                    val prev = insn.previous
                    insns.remove(prev)
                }
            }
        }

        Logger.info("Removed $argCount opaque arguments.")
    }

    private val MethodNode.lastArgIndex: Int get() {
        val offset = if(Modifier.isStatic(access)) 1 else 0
        return (Type.getArgumentsAndReturnSizes(desc) shr 2) - offset - 1
    }

    private fun MethodNode.hasOpaqueArg(): Boolean {
        val argTypes = Type.getArgumentTypes(desc)
        if(argTypes.isEmpty()) return false
        val lastArg = argTypes.last()
        if(lastArg != BYTE_TYPE && lastArg != SHORT_TYPE && lastArg != INT_TYPE) return false
        if(Modifier.isAbstract(access)) return true
        instructions.forEach { insn ->
            if(insn !is VarInsnNode) return@forEach
            if(insn.`var` == lastArgIndex) return false
        }
        return true
    }

    private fun String.dropLastArg(): String {
        val type = Type.getMethodType(this)
        return Type.getMethodDescriptor(type.returnType, *type.argumentTypes.copyOf(type.argumentTypes.size - 1))
    }

    private fun AbstractInsnNode.isIntConstant() = when(opcode) {
        LDC -> (this as LdcInsnNode).cst is Int
        SIPUSH, BIPUSH, ICONST_M1, ICONST_0, ICONST_1, ICONST_2, ICONST_3, ICONST_4, ICONST_5 -> true
        else -> false
    }

    private fun findSupers(cls: ClassNode, classNames: Map<String, ClassNode>): Collection<ClassNode> {
        return cls.interfaces.plus(cls.superName).mapNotNull { classNames[it] }.flatMap { findSupers(it, classNames).plus(it) }
    }

    private fun findOverride(owner: String, name: String, desc: String, methods: Set<String>, classNames: Map<String, ClassNode>): String? {
        val identifier = "$owner.$name$desc"
        if(identifier in methods) return identifier
        if(name.startsWith("<init>")) return null
        val cls = classNames[owner] ?: return null
        for(superCls in findSupers(cls, classNames)) {
            return findOverride(superCls.name, name, desc, methods, classNames) ?: continue
        }
        return null
    }

    private val EXCEPTION_PATTERN = "(iload) " +
            "(ldc|iconst_m1|iconst_0|iconst_1|iconst_2|iconst_3|iconst_4|iconst_5|sipush|bipush) " +
            "(if_icmpeq|if_icmpne|if_icmplt|if_icmpgt|if_icmple|if_icmpge|if_acmpeq|if_acmpne) " +
            "(new) " +
            "(dup) " +
            "(invokespecial) " +
            "(athrow)"

    private val RETURN_PATTERN = "(iload) " +
            "(ldc|iconst_m1|iconst_0|iconst_1|iconst_2|iconst_3|iconst_4|iconst_5|sipush|bipush) " +
            "(if_icmpeq|if_icmpne|if_icmplt|if_icmpgt|if_icmple|if_icmpge|if_acmpeq|if_acmpne) " +
            "(return|areturn|dreturn|freturn|ireturn|lreturn)"
}