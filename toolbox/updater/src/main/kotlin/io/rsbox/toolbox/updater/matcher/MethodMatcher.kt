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

import com.google.common.collect.HashMultimap
import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.owner
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.NodeMappings
import io.rsbox.toolbox.updater.sandbox.SandboxMethodMatcher
import io.rsbox.toolbox.updater.util.ConsoleProgressBar
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

class MethodMatcher {

    private val matches = HashMultimap.create<MethodNode, MethodNode>()

    private val ClassPool.methods: List<MethodNode> get() {
        return classes.flatMap { it.methods }
            .filter { !Modifier.isStatic(it.access) && it.name != "<init>" && it.instructions.size() > 0 }
            .toList()
    }

    private fun ClassPool.findPotentialMatches(method: MethodNode): List<MethodNode> {
        return this.methods
            .filter { MappingUtil.isPotentiallyEqual(it.owner, method.owner) }
            .filter { MappingUtil.isMethodDescPotentiallyEqual(it.desc, method.desc) }
            .toList()
    }

    fun match(fromPool: ClassPool, toPool: ClassPool): NodeMappings {
        toPool.methods.forEach { toMethod ->
            matches.putAll(toMethod, fromPool.findPotentialMatches(toMethod))
        }

        val mapping = NodeMappings()
        val toMerge = mutableListOf<NodeMappings>()

        ConsoleProgressBar.start("Matching Methods", "", matches.size().toLong())

        matches.keySet().forEach { toMethod ->
            val fromMethods = matches.get(toMethod)
            val sandboxMapping = SandboxMethodMatcher().match(toMethod, fromMethods) ?: return@forEach
            sandboxMapping.map(sandboxMapping.fromMethod, sandboxMapping.toMethod).also {
                it.executed = true
            }
            toMerge.add(sandboxMapping)
        }

        val mergeMapping = NodeMappings()
        toMerge.forEach { mergeMapping.merge(it) }

        ConsoleProgressBar.stop()

        return mergeMapping
    }
}