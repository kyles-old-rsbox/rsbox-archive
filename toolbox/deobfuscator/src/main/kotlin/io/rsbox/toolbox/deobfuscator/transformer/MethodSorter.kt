package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import org.objectweb.asm.tree.LineNumberNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class MethodSorter : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            val lineNumbers = cls.methods.associateWith { it.lineNumber ?: Int.MAX_VALUE }
            cls.methods = cls.methods.sortedBy { lineNumbers.getValue(it) }
            count += cls.methods.size
        }

        Logger.info("Sorted $count methods.")
    }

    private val MethodNode.lineNumber: Int? get() {
        for(insn in instructions) {
            if(insn is LineNumberNode) {
                return insn.line
            }
        }
        return null
    }
}