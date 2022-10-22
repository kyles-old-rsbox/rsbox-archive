package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import org.objectweb.asm.Type
import org.objectweb.asm.tree.TryCatchBlockNode
import org.tinylog.kotlin.Logger
import java.lang.RuntimeException

class RuntimeExceptionRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                val toRemove = mutableListOf<TryCatchBlockNode>()
                method.tryCatchBlocks.forEach { tcb ->
                    if(tcb.type == Type.getInternalName(RuntimeException::class.java)) {
                        toRemove.add(tcb)
                    }
                }
                method.tryCatchBlocks.removeAll(toRemove)
                count += toRemove.size
            }
        }

        Logger.info("Removed $count RuntimeException try-catch blocks.")
    }
}