package io.rsbox.toolbox.deobfuscator.asm

import io.rsbox.toolbox.deobfuscator.util.field
import io.rsbox.toolbox.deobfuscator.util.nullField
import org.objectweb.asm.tree.ClassNode

internal fun ClassNode.init(pool: ClassPool) {
    this.pool = pool
    methods.forEach { it.init(this) }
    fields.forEach { it.init(this) }
}

internal fun ClassNode.reset() {
    parent = null
    children.clear()
    interfaceClasses.clear()
    implementers.clear()
    methods.forEach { it.reset() }
    fields.forEach { it.reset() }
}

internal fun ClassNode.build() {
    parent = pool.findClass(superName)
    if(parent != null) {
        parent!!.children.add(this)
    }

    interfaces.mapNotNull { pool.findClass(it) }.forEach { interf ->
        interfaceClasses.add(interf)
        interf.implementers.add(this)
    }

    methods.forEach { it.build() }
    fields.forEach { it.build() }
}

var ClassNode.pool: ClassPool by field()
var ClassNode.ignored: Boolean by field { false }

var ClassNode.parent: ClassNode? by nullField()
val ClassNode.children: MutableList<ClassNode> by field { mutableListOf() }
val ClassNode.interfaceClasses: MutableList<ClassNode>  by field { mutableListOf() }
val ClassNode.implementers: MutableList<ClassNode>  by field { mutableListOf() }

val ClassNode.identifier: String get() = name

fun ClassNode.getMethod(name: String, desc: String) = methods.firstOrNull { it.name == name && it.desc == desc }
fun ClassNode.getField(name: String, desc: String) = fields.firstOrNull { it.name == name && it.desc == desc }