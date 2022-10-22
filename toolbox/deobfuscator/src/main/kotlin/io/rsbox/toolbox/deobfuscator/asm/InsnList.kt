package io.rsbox.toolbox.deobfuscator.asm

import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.InsnList

fun InsnList.append(previous: AbstractInsnNode, vararg insns: AbstractInsnNode) {
    check(contains(previous))
    insns.reversed().forEach { insert(previous, it) }
}

fun InsnList.prepend(next: AbstractInsnNode, vararg insns: AbstractInsnNode) {
    check(contains(next))
    insns.forEach { insertBefore(next, it) }
}

fun InsnList.delete(vararg insns: AbstractInsnNode) {
    insns.forEach {
        check(contains(it))
        remove(it)
    }
}

fun InsnList.replace(old: AbstractInsnNode, replacement: AbstractInsnNode) {
    check(contains(old))
    set(old, replacement)
}