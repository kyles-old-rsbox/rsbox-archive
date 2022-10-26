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

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.deobfuscator.Deobfuscator
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.commons.ClassRemapper
import org.objectweb.asm.commons.SimpleRemapper
import org.objectweb.asm.tree.ClassNode
import org.tinylog.kotlin.Logger

class Renamer : Transformer {

    private var classCount = 0
    private var methodCount = 0
    private var fieldCount = 0

    private val mappings = hashMapOf<String, String>()

    override fun run(pool: ClassPool) {
        generateMappings(pool)
        applyMappings(pool)

        Logger.info("Renamed $classCount classes.")
        Logger.info("Renamed $methodCount methods.")
        Logger.info("Renamed $fieldCount fields.")
    }

    private fun generateMappings(pool: ClassPool) {
        // Build an inheritance graph of the current class pool
        val inheritanceGraph = InheritanceGraph(pool)

        // Generate class mappings
        pool.classes.forEach classLoop@ { cls ->
            if(!cls.name.isObfuscatedName()) return@classLoop
            val newName = "old_class${++classCount}"
            mappings[cls.identifier] = newName
        }

        // Generate Method Mappings
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(!method.name.isObfuscatedName() || mappings.containsKey(method.identifier)) return@methodLoop
                val newName = "old_method${++methodCount}"
                mappings[method.identifier] = newName
                inheritanceGraph[method.owner.name]!!.children.forEach { relative ->
                    mappings["${relative.name}.${method.name}${method.desc}"] = newName
                }
            }
        }

        // Generate Field Mappings
        pool.classes.forEach { cls ->
            cls.fields.forEach fieldLoop@ { field ->
                if(!field.name.isObfuscatedName() || mappings.containsKey(field.identifier)) return@fieldLoop
                val newName = "old_field${++fieldCount}"
                mappings[field.identifier] = newName
                inheritanceGraph[field.owner.name]!!.children.forEach { relative ->
                    mappings["${relative.name}.${field.name}"] = newName
                }
            }
        }
    }

    private fun applyMappings(pool: ClassPool) {
        val classes = mutableListOf<ClassNode>()
        val remapper = SimpleRemapper(mappings)
        pool.allClasses.forEach { cls ->
            val node = ClassNode()
            cls.accept(ClassRemapper(node, remapper))
            node.ignored = cls.ignored
            Deobfuscator.updateObfInfo(cls, node)
            cls.methods.forEach methodLoop@ { oldMethod ->
                val newMethodName = mappings[oldMethod.identifier] ?: return@methodLoop
                val newMethod = node.methods.first { it.name == newMethodName }
                Deobfuscator.updateObfInfo(oldMethod, newMethod)
            }
            cls.fields.forEach fieldLoop@ { oldField ->
                val newFieldName = mappings[oldField.identifier] ?: return@fieldLoop
                val newField = node.fields.first { it.name == newFieldName }
                Deobfuscator.updateObfInfo(oldField, newField)
            }
            classes.add(node)
        }
        pool.clear()
        classes.forEach { pool.addClass(it, it.ignored) }
        pool.init()
    }

    private fun String.isObfuscatedName(): Boolean {
        return (this.length <= 3 && this != "run" && this != "add") || listOf("class", "method", "field", "__").any { this.startsWith(it) }
    }
}