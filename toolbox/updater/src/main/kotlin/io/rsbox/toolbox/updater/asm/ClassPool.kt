package io.rsbox.toolbox.updater.asm

import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.asm.util.field
import org.objectweb.asm.tree.MethodNode

var ClassPool.other: ClassPool by field()

fun ClassPool.loadInfo() {
    allClasses.forEach { cls ->
        cls.methods.forEach { method ->
            method.loadInfo()
        }
        cls.fields.forEach { field ->
            field.loadInfo()
        }
        cls.loadInfo()
    }
}

fun ClassPool.resolveMethod(owner: String, name: String, desc: String): MethodNode? {
    val ret = findClass(owner)?.getMethod(name, desc)
    return ret
}