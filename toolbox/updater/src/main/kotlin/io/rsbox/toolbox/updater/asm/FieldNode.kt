package io.rsbox.toolbox.updater.asm

import io.rsbox.toolbox.asm.util.field
import io.rsbox.toolbox.asm.util.nullField
import io.rsbox.toolbox.updater.util.linkedListOf
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.util.LinkedList

var FieldNode.match: FieldNode? by nullField()
fun FieldNode.hasMatch() = match != null

val FieldNode.readRefs: LinkedList<MethodNode> by field { linkedListOf() }
val FieldNode.writeRefs: LinkedList<MethodNode> by field { linkedListOf() }

internal fun FieldNode.loadInfo() {

}