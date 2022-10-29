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

package io.rsbox.toolbox.asm.tree

import org.objectweb.asm.ClassReader
import org.objectweb.asm.tree.ClassNode

class ClassPool {

    private val classMap = hashMapOf<String, ClassNode>()
    private val ignoredClassMap = hashMapOf<String, ClassNode>()

    private val readers = hashMapOf<String, ClassReader>()

    val classes get() = classMap.values.toList()
    val ignoredClasses get() = ignoredClassMap.values.toList()

    val allClasses get() = mutableListOf<ClassNode>().also {
        it.addAll(classes)
        it.addAll(ignoredClasses)
    }.toList()

    fun addClass(node: ClassNode, ignore: Boolean = false) {
        if(!ignore) {
            classMap[node.name] = node
        } else {
            ignoredClassMap[node.name] = node
        }
        node.ignored = ignore
    }

    fun addClass(node: ClassNode, reader: ClassReader, ignore: Boolean = false) {
        addClass(node, ignore)
        readers[node.name] = reader
    }

    fun removeClass(node: ClassNode) {
        classMap.remove(node.name)
        ignoredClassMap.remove(node.name)
    }

    fun ignoreClass(node: ClassNode) {
        removeClass(node)
        addClass(node, ignore = true)
    }

    fun unignoreClass(node: ClassNode) {
        removeClass(node)
        addClass(node, ignore = false)
    }

    fun getClass(name: String) = classMap[name]
    fun getIgnoredClass(name: String) = ignoredClassMap[name]
    fun findClass(name: String) = getClass(name) ?: getIgnoredClass(name)

    fun getClassReader(name: String) = readers[name]

    fun init() {
        allClasses.forEach { it.init(this) }
        allClasses.forEach { it.reset() }
        allClasses.forEach { it.build() }
    }

    fun clear() {
        classMap.clear()
        ignoredClassMap.clear()
    }
}