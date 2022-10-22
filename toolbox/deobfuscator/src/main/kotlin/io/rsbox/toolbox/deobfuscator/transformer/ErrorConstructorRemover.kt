package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.asm.InstructionMatcher
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class ErrorConstructorRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            val methods = cls.methods.iterator()
            while(methods.hasNext()) {
                val method = methods.next()
                if(method.isErrorConstructor()) {
                    methods.remove()
                    count++
                }
            }
        }

        Logger.info("Removed $count error constructor methods.")
    }

    private fun MethodNode.isErrorConstructor(): Boolean {
        if(name != "<init>") return false
        if(Type.getArgumentTypes(desc).isNotEmpty()) return false
        if(exceptions != listOf(Type.getType(Throwable::class.java).internalName)) return false
        val insns = instructions.toArray().filter { it.opcode > 0 }
        val insnsList = InsnList().also { insnsList -> insns.forEach { insnsList.add(it) } }
        val matcher = InstructionMatcher(insnsList)
        val matches = matcher.search(ERROR_CONSTRUCTOR_PATTERN)
        return matches.isNotEmpty()
    }

    private val ERROR_CONSTRUCTOR_PATTERN = "(aload) " +
            "(invokespecial) " +
            "(new) " +
            "(dup) " +
            "(invokespecial)" +
            "(athrow)"
}