package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.base.Objects
import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.asm.InstructionModifier
import io.rsbox.toolbox.deobfuscator.asm.LabelMap
import io.rsbox.toolbox.deobfuscator.asm.owner
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.IincInsnNode
import org.objectweb.asm.tree.VarInsnNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class LocalVariableFixer : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                val insns = method.instructions
                if(insns.size() == 0) return@methodLoop
                val mappings = LvtMappings(method.maxLocals)
                for(insn in insns) {
                    if (insn !is VarInsnNode && insn !is IincInsnNode) continue
                    when(insn) {
                        is VarInsnNode -> {
                            val newIdx = mappings.remap(insn.`var`, insn) ?: continue
                            insn.`var` = newIdx
                            count++
                        }
                        is IincInsnNode -> {
                            val newIdx = mappings.remap(insn.`var`, insn) ?: continue
                            insn.`var` = newIdx
                            count++
                        }
                    }
                }
            }
        }
        Logger.info("Fixed $count local variable usages.")
    }

    private enum class LVTType(val slots: Int) {
        INT(1),
        LONG(2),
        OBJECT(1);

        companion object {
            fun fromInsn(insn: AbstractInsnNode): LVTType = when(insn.opcode) {
                LLOAD, DLOAD, LSTORE, DSTORE -> LONG
                FLOAD, ILOAD, FSTORE, ISTORE, IINC -> INT
                ALOAD, ASTORE -> OBJECT
                else -> throw IllegalArgumentException()
            }
        }
    }

    private data class LvtMapKey(val index: Int, val type: LVTType) {

        override fun hashCode(): Int {
            var hash = 7
            hash = 89 * hash + index
            hash = 89 * hash + Objects.hashCode(type)
            return hash
        }

        override fun equals(other: Any?): Boolean {
            if(this === other) return true
            if(other == null) return false
            if(this::class != other::class) return false
            if(other !is LvtMapKey) return false
            if(other.index != index) return false
            if(other.type != type) return false
            return true
        }
    }

    private class LvtMappings(private val maxLocals: Int) {
        private val idxMap = hashMapOf<Int, LVTType>()
        private val newIdxMap = hashMapOf<LvtMapKey, Int>()
        private var offset = 0

        fun remap(idx: Int, insn: AbstractInsnNode): Int? {
            val seen = idxMap[idx]
            if(seen == null) {
                idxMap[idx] = LVTType.fromInsn(insn)
            }
            else if(LVTType.fromInsn(insn) != seen) {
                val key = LvtMapKey(idx, LVTType.fromInsn(insn))
                var newIdx = newIdxMap[key]
                if(newIdx == null) {
                   newIdx = maxLocals + offset
                   newIdxMap[key] = newIdx
                   offset += LVTType.fromInsn(insn).slots
                }
                return newIdx
            }
            return null
        }
    }
}