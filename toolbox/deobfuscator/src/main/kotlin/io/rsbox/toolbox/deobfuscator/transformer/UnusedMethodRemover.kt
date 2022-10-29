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

import com.google.common.collect.Multimap
import com.google.common.collect.MultimapBuilder
import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.asm.tree.identifier
import io.rsbox.toolbox.asm.isJdkMethod
import io.rsbox.toolbox.asm.tree.owner
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class UnusedMethodRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        val classNames = pool.allClasses.associateBy { it.name }
        val superClasses = MultimapBuilder.hashKeys().arrayListValues().build<ClassNode, String>()
        val subClasses = MultimapBuilder.hashKeys().arrayListValues().build<ClassNode, String>()

        pool.classes.forEach { cls ->
            cls.interfaces.forEach { superClasses.put(cls, it) }
            superClasses.put(cls, cls.superName)
        }

        superClasses.forEach { cls, superClassName ->
            if(classNames.containsKey(superClassName)) {
                subClasses.put(classNames.getValue(superClassName), cls.name)
            }
        }

        val usedMethods = pool.classes.asSequence().flatMap { it.methods.asSequence() }
            .flatMap { it.instructions.iterator().asSequence() }
            .mapNotNull { it as? MethodInsnNode }
            .map { "${it.owner}.${it.name}${it.desc}" }
            .toSet()

        val toRemove = hashSetOf<String>()
        pool.classes.forEach { cls ->
            for(method in cls.methods) {
                if(method.isUsed(usedMethods, superClasses, subClasses, classNames)) continue
                toRemove.add(method.identifier)
            }
        }

        pool.classes.forEach { cls ->
            val methods = cls.methods.iterator()
            while(methods.hasNext()) {
                val method = methods.next()
                if(method.identifier !in toRemove) continue
                methods.remove()
                count++
            }
        }

        Logger.info("Removed $count unused methods.")
    }

    private fun MethodNode.isUsed(usedMethods: Set<String>, superClasses: Multimap<ClassNode, String>, subClasses: Multimap<ClassNode, String>, classNames: Map<String, ClassNode>): Boolean {
        if(name == "<init>" || name == "<clinit>") return true
        if(usedMethods.contains(identifier)) return true
        var supers = superClasses[owner]
        while(supers.isNotEmpty()) {
            supers.forEach { cls ->
                if(isJdkMethod(cls, name, desc)) return true
                if(usedMethods.contains("$cls.$name$desc")) return true
            }
            supers = supers.filter { classNames.containsKey(it) }.flatMap { superClasses[classNames.getValue(it)] }
        }
        var subs = subClasses[owner]
        while(subs.isNotEmpty()) {
            subs.forEach { cls ->
                if(usedMethods.contains("$cls.$name$desc")) return true
            }
            subs = subs.flatMap { subClasses[classNames.getValue(it)] }
        }
        return false
    }
}