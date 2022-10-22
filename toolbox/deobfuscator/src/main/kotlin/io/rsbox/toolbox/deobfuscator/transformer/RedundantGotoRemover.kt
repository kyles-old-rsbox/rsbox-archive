package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
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