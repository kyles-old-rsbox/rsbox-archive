package io.rsbox.toolbox.deobfuscator.asm

import io.rsbox.toolbox.deobfuscator.util.field
import org.objectweb.asm.Opcodes.ACC_ABSTRACT
import org.objectweb.asm.Opcodes.ACC_STATIC
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LocalVariableNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.ParameterNode
import org.objectweb.asm.tree.VarInsnNode
import java.lang.reflect.Modifier

internal fun MethodNode.init(owner: ClassNode) {
    this.owner = owner
}

internal fun MethodNode.reset() {}
internal fun MethodNode.build() {}

var MethodNode.owner: ClassNode by field()
val MethodNode.pool get() = owner.pool

val MethodNode.identifier: String get() = "${owner.identifier}.$name$desc"
val MethodNode.type get() = Type.getMethodType(desc)

val MethodNode.overrides: List<MethodNode> get() {
    val ret = mutableListOf<MethodNode>()
    if(isStatic()) {
        ret.add(this)
        return ret
    }
    findBaseMethods(mutableListOf(), owner, name, desc).forEach {
        findInheritedMethods(ret, mutableSetOf(), it.owner, it.name, it.desc)
    }
    return ret
}

fun MethodNode.isStatic() = (access and ACC_STATIC) != 0
fun MethodNode.isAbstract() = (access and ACC_ABSTRACT) != 0


private fun findBaseMethods(methods: MutableList<MethodNode>, cls: ClassNode?, name: String, desc: String): MutableList<MethodNode> {
    if(cls == null) {
        return methods
    }

    val m = cls.getMethod(name, desc)
    if(m != null && !m.isStatic()) {
        methods.add(m)
    }

    val parentMethods = findBaseMethods(mutableListOf(), cls.parent, name, desc)
    cls.interfaceClasses.forEach { parentMethods.addAll(findBaseMethods(mutableListOf(), it, name, desc)) }

    return if(parentMethods.isEmpty()) methods else parentMethods
}

private fun findInheritedMethods(
    methods: MutableList<MethodNode>,
    visited: MutableSet<ClassNode>,
    cls: ClassNode? ,
    name: String,
    desc: String
) {
    if(cls == null || visited.contains(cls)) {
        return
    }
    visited.add(cls)

    val m = cls.getMethod(name, desc)
    if(m != null && !m.isStatic()) {
        methods.add(m)
    }

    mutableListOf<ClassNode>().also {
        it.addAll(cls.children)
        it.addAll(cls.interfaceClasses)
    }.forEach {
        findInheritedMethods(methods, visited, it, name, desc)
    }
}