package io.rsbox.toolbox.deobfuscator

import io.rsbox.toolbox.deobfuscator.asm.ClassPool

interface Transformer {
    fun run(pool: ClassPool)
}