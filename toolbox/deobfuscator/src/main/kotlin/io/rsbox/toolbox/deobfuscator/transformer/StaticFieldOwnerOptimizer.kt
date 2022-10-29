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

import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.GETSTATIC
import org.objectweb.asm.Opcodes.PUTSTATIC
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class StaticFieldOwnerOptimizer : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        val resolver = FieldOwnerResolver(pool)
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                method.instructions.iterator().forEach { insn ->
                    if(insn is FieldInsnNode) {
                        val opcode = insn.opcode
                        val prevOwner = insn.owner
                        val isStatic = opcode in listOf(GETSTATIC, PUTSTATIC)
                        insn.owner = resolver.getOwner(insn.owner, insn.name, insn.desc, isStatic)
                        val newOwner = insn.owner
                        if(prevOwner != newOwner) {
                            count++
                        }
                    }
                }
            }
        }
        Logger.info("Optimized $count fields and moved owner classes.")
    }

    private class FieldOwnerResolver(private val pool: ClassPool) {

        private val classNames = pool.allClasses.associateBy { it.name }

        fun getOwner(owner: String, name: String, desc: String, isStatic: Boolean): String {
            var cls = classNames[owner] ?: return owner
            while(true) {
                if(cls.containsField(name, desc, isStatic)) {
                    return cls.name
                }
                cls = classNames[cls.superName] ?: return cls.superName
            }
        }

        private fun ClassNode.containsField(name: String, desc: String, isStatic: Boolean): Boolean {
            return fields.any { it.name == name && it.desc == desc && Modifier.isStatic(it.access) == isStatic }
        }
    }
}