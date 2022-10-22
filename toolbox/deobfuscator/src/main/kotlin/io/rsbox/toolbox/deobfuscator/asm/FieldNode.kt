package io.rsbox.toolbox.deobfuscator.asm

import io.rsbox.toolbox.deobfuscator.util.field
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode

internal fun FieldNode.init(owner: ClassNode) {
    this.owner = owner
}

internal fun FieldNode.reset() {}
internal fun FieldNode.build() {}

var FieldNode.owner: ClassNode by field()
val FieldNode.pool get() = owner.pool

val FieldNode.identifier: String get() = "${owner.identifier}.$name"