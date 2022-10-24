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

import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.GOTO
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.LabelNode
import org.tinylog.kotlin.Logger

class RedundantGotoRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                val insns = method.instructions.iterator()
                while(insns.hasNext()) {
                    val insn = insns.next()
                    if(insn.opcode != GOTO) continue
                    insn as JumpInsnNode
                    if(insn.next == null || insn.next !is LabelNode) continue
                    if(insn.label == insn.next) {
                        insns.remove()
                        count++
                    }
                }
            }
        }

        Logger.info("Removed $count redundant GOTO instructions.")
    }
}