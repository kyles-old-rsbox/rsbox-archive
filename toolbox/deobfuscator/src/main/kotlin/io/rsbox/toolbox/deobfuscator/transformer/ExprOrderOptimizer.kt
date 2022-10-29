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

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.VarInsnNode
import org.tinylog.kotlin.Logger

class ExprOrderOptimizer : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                val labelMap = LabelMap()
                val insns = method.instructions.toArray().filter { it.isOrderable() }
                for(insn in insns) {
                    if(insn.previous is VarInsnNode && insn.previous.previous.isConstant()) {
                        val newLeft = insn.previous.previous.clone(labelMap)
                        val newRight = insn.previous.clone(labelMap)
                        method.instructions.set(insn.previous.previous, newRight)
                        method.instructions.set(insn.previous, newLeft)
                        count++
                    }
                    else if(insn.previous.opcode == GETFIELD && (insn.previous.previous is VarInsnNode || insn.previous.previous.opcode == GETSTATIC) && insn.previous.previous.previous.isConstant()) {
                        val newLeft0 = insn.previous.previous.clone(labelMap)
                        val newLeft1 = insn.previous.clone(labelMap)
                        val newRight = insn.previous.previous.previous.clone(labelMap)
                        method.instructions.set(insn.previous.previous.previous, newLeft0)
                        method.instructions.set(insn.previous.previous, newLeft1)
                        method.instructions.set(insn.previous, newRight)
                        count++
                    }
                    else if(insn.previous.opcode == GETSTATIC && insn.previous.previous.isConstant()) {
                        val newLeft = insn.previous.clone(labelMap)
                        val newRight = insn.previous.previous.clone(labelMap)
                        method.instructions.set(insn.previous.previous, newLeft)
                        method.instructions.set(insn.previous, newRight)
                        count++
                    }
                }
            }
        }

        Logger.info("Reordered $count method instruction expressions.")
    }

    private fun AbstractInsnNode.isOrderable(): Boolean {
        return opcode in listOf(IF_ICMPEQ, IF_ICMPNE, IF_ACMPEQ, IF_ACMPNE) || opcode in IMUL..DMUL || opcode in IADD..DADD
    }

    private fun AbstractInsnNode.isConstant(): Boolean = opcode in ICONST_M1..LDC

}