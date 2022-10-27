/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.rsbox.toolbox.updater.matcher

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.NodeMappings
import io.rsbox.toolbox.updater.util.ConsoleProgressBar
import org.objectweb.asm.Opcodes.PUTSTATIC
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

class ClassMatcher(private val fromPool: ClassPool, private val toPool: ClassPool) {

    val fromFields = hashSetOf<FieldNode>()
    val toFields = hashSetOf<FieldNode>()

    fun match(nodeMappings: NodeMappings) {
        val mappingsSet = hashSetOf<Any>()
        mappingsSet.addAll(nodeMappings.mappings.keySet())

        mappingsSet.forEach { fromNode ->
            if(fromNode is ClassNode) {
                nodeMappings.mappings.removeAll(fromNode)
            }
        }

        ConsoleProgressBar.start("Matching Classes", "", fromPool.classes.size.toLong())

        fromPool.indexFields()
        toPool.indexFields()

        var mappingsMap = nodeMappings.asMappingMap()
        mappingsMap.keys.forEach { key ->
            val value = mappingsMap[key]
            mapClass(nodeMappings, key, value!!)
        }

        mappingsMap = nodeMappings.asMappingMap()
        nodeMappings.reduce()

        val matcher = ClassPoolMatcher(fromPool, toPool)
        matcher.match()

        fromPool.classes.forEach { fromClass ->
            if(!mappingsMap.containsKey(fromClass)) {
                val toClass = mappingsMap[fromClass] ?:return@forEach
                val match = nodeMappings.getMapping(fromClass, toClass)
                match.score++
            }
            ConsoleProgressBar.step()
        }

        ConsoleProgressBar.stop()
    }

    fun mapClass(mapping: NodeMappings, from: Any, to: Any) {
        val fromClass: ClassNode
        val toClass: ClassNode

        if(from is FieldNode || to is FieldNode) {
            val fromField = from as FieldNode
            val toField = to as FieldNode

            if(!fromField.isIndexed() || !toField.isIndexed()) {
                if(Modifier.isStatic(fromField.access) || Modifier.isStatic(toField.access)) return
            }

            fromClass = fromField.owner
            toClass = toField.owner
        } else if(from is MethodNode || to is MethodNode) {
            val fromMethod = from as MethodNode
            val toMethod = to as MethodNode

            if(Modifier.isStatic(fromMethod.access) || Modifier.isStatic(toMethod.access)) return

            fromClass = fromMethod.owner
            toClass = toMethod.owner
        } else {
            return
        }

        val match = mapping.getMapping(fromClass, toClass)
        match.score++
    }

    private fun ClassPool.indexFields() {
        val fieldsSet = when(this) {
            fromPool -> fromFields
            toPool -> toFields
            else -> throw IllegalStateException()
        }

        classes.forEach classLoop@ { cls ->
            val method = cls.getMethod("<clinit>", "()V") ?: return@classLoop
            val insns = method.instructions
            for(insn in insns) {
                if(insn.opcode != PUTSTATIC) continue
                insn as FieldInsnNode
                val insnFieldOwner = this.findClass(insn.owner)
                val insnField = insnFieldOwner?.getField(insn.name, insn.desc)
                if(cls != insnFieldOwner || insnField == null) continue
                fieldsSet.add(insnField)
            }
        }
    }

    fun FieldNode.isIndexed(): Boolean {
        val fieldSet = when(this.pool) {
            fromPool -> fromFields
            toPool -> toFields
            else -> throw IllegalStateException()
        }
        return this in fieldSet
    }
}