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

package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.base.Objects
import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.IincInsnNode
import org.objectweb.asm.tree.VarInsnNode
import org.tinylog.kotlin.Logger

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