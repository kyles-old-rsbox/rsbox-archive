package io.rsbox.toolbox.updater.asm

import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.asm.util.field
import io.rsbox.toolbox.asm.util.nullField
import io.rsbox.toolbox.updater.util.linkedListOf
import io.rsbox.toolbox.updater.util.toLinkedList
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.util.LinkedList

var ClassNode.match: ClassNode? by nullField()
fun ClassNode.hasMatch() = match != null

val ClassNode.methodTypeRefs: LinkedList<MethodNode> by field { linkedListOf() }
val ClassNode.fieldTypeRefs: LinkedList<FieldNode> by field { linkedListOf() }

internal fun ClassNode.loadInfo() {

}