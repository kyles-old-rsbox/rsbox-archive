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

import com.google.common.collect.ImmutableMultiset
import com.google.common.collect.Multiset
import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.type
import io.rsbox.toolbox.updater.MappingUtil
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import java.lang.reflect.Modifier

class ClassPoolMatcher(val fromPool: ClassPool, val toPool: ClassPool) {

    val mappings = hashMapOf<ClassNode, ClassNode>()

    fun match() {
        fromPool.classes.forEach fromClassLoop@ { fromClass ->
            toPool.classes.forEach toClassLoop@ { toClass ->
                if(!MappingUtil.isPotentiallyEqual(fromClass, toClass)) return@toClassLoop
                if(!isSame(fromClass, toClass)) return@toClassLoop
                mappings[fromClass] = toClass
            }
        }
    }

    private fun ClassNode.findMatchableFields(): Multiset<Type> {
        return this.fields
            .filter { !Modifier.isStatic(it.access) }
            .map { it.type }
            .toList()
            .let { ImmutableMultiset.copyOf(it) }
    }

    private fun ClassNode.findMatchableMethods(): Multiset<Type> {
        return this.methods
            .filter { !Modifier.isStatic(it.access) }
            .filter { !it.name.startsWith("<") }
            .map { it.type }
            .toList()
            .let { ImmutableMultiset.copyOf(it) }
    }

    private fun isSame(classA: ClassNode, classB: ClassNode): Boolean {
        val classAFields = classA.findMatchableFields()
        val classBFields = classB.findMatchableFields()

        if(classAFields != classBFields) {
            return false
        }

        val classAMethods = classA.findMatchableMethods()
        val classBMethods = classB.findMatchableMethods()

        if(classAMethods != classBMethods) {
            return false
        }

        return true
    }
}