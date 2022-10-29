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

package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.collect.Iterables
import com.google.common.collect.TreeMultimap
import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier
import java.util.*

class StaticMethodOwnerOptimizer : Transformer {

    private var count = 0

    private val duplicateMethodsMap = TreeMultimap.create<String, String>()
    private val origMethodOwnersMap = TreeMap<String, String>()

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(!(Modifier.isStatic(method.access) && method.name != "<clinit>")) return@methodLoop
                duplicateMethodsMap.put(method.fingerprint, "${cls.name}.${method.name}${method.desc}")
            }
        }

        duplicateMethodsMap.asMap().entries.removeIf { it.value.size == 1 }
        val duplicateMethods = duplicateMethodsMap.asMap().values.sortedBy { it.first() }

        pool.classes.forEach { cls ->
            for(method in cls.methods) {
                val dups = duplicateMethods.firstOrNull { it.contains(method.identifier) } ?: continue
                val classNames = dups.minus(method.identifier).map { it.split(".").first() }.distinct()
                val realClassName = classNames.first()
                if(cls.name == realClassName) continue
                origMethodOwnersMap[method.identifier] = realClassName
            }
        }

        val methodNameMap = pool.classes.flatMap { it.methods }.associateBy { it.identifier }
        val movedMethods = hashSetOf<MethodNode>()

        origMethodOwnersMap.forEach { (src, orig) ->
            val srcMethod = methodNameMap[src] ?: return@forEach
            val origCls = pool.findClass(orig) ?: return@forEach

            val exceptions = Iterables.toArray(srcMethod.exceptions, String::class.java)
            val movedMethod = MethodNode(srcMethod.access, srcMethod.name, srcMethod.desc, srcMethod.signature, exceptions)
            srcMethod.accept(movedMethod)
            origCls.methods.add(movedMethod)

            movedMethod.init(origCls)
            movedMethod.reset()
            movedMethod.build()
            placedMethods.add(movedMethod.identifier)

            movedMethods.add(movedMethod)
            count++
        }

        val movedMethodsNameMap = movedMethods.associateBy { it.identifier }
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                val insns = method.instructions.iterator()
                while(insns.hasNext()) {
                    val insn = insns.next()
                    if(insn !is MethodInsnNode) continue
                    val identifier = "${insn.owner}.${insn.name}${insn.desc}"
                    if(origMethodOwnersMap.containsKey(identifier)) {
                        val origCls = origMethodOwnersMap[identifier] ?: continue
                        insn.owner = origCls
                        count++
                    }
                }
            }
        }

        origMethodOwnersMap.keys.mapNotNull { methodNameMap[it] }.forEach { method ->
            method.owner.methods.remove(method)
            count++
        }

        pool.init()

        Logger.info("Moved $count static methods to their original classes.")
    }

    private val MethodNode.fingerprint: String get() = "${Type.getReturnType(desc)}.${(instructions.lineNumberRange ?: "*")}.${instructions.hash}"

    private val InsnList.lineNumberRange: IntRange? get() {
        val lineNumbers = iterator().asSequence().mapNotNull { it as? LineNumberNode }.mapNotNull { it.line }.toList()
        if(lineNumbers.isEmpty()) return null
        return lineNumbers.first()..lineNumbers.last()
    }

    private val InsnList.hash: Int get() = iterator().asSequence().mapNotNull {
        when(it) {
            is FieldInsnNode -> "${it.owner}.${it.name}:${it.opcode}"
            is MethodInsnNode -> "${it.opcode}:${it.owner}.${it.name}"
            is InsnNode -> it.opcode.toString()
            else -> null
        }
    }.toSet().hashCode()

    companion object {
        internal val placedMethods = hashSetOf<String>()
    }
}