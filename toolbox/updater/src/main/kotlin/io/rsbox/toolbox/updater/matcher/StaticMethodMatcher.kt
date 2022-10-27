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
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.NodeMappings
import io.rsbox.toolbox.updater.sandbox.SandboxMethodMatcher
import io.rsbox.toolbox.updater.util.ConsoleProgressBar
import me.tongfei.progressbar.ProgressBarBuilder
import me.tongfei.progressbar.ProgressBarStyle
import me.tongfei.progressbar.TerminalUtils
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier
import java.time.temporal.ChronoUnit

class StaticMethodMatcher {

    private val matches = HashMultimap.create<MethodNode, MethodNode>()

    private val ClassPool.staticMethods: List<MethodNode> get() {
        return classes.flatMap { it.methods }.filter { Modifier.isStatic(it.access) }.toList()
    }

    private fun ClassPool.findPotentialMatches(toMethod: MethodNode): List<MethodNode> {
        return staticMethods.filter { fromMethod -> MappingUtil.isPotentiallyEqual(fromMethod, toMethod) }.toList()
    }

    fun match(fromPool: ClassPool, toPool: ClassPool): NodeMappings {
        toPool.staticMethods.forEach { toMethod ->
            matches.putAll(toMethod, fromPool.findPotentialMatches(toMethod))
        }

        ConsoleProgressBar.start("Matching Static Methods", "Methods", matches.size().toLong())

        val toMerge = mutableListOf<NodeMappings>()
        matches.keySet().forEach { toMethod ->
            val fromMethods = matches.get(toMethod)
            val sandboxMapping = SandboxMethodMatcher().match(toMethod, fromMethods) ?: return@forEach

            sandboxMapping.map(sandboxMapping.fromMethod, sandboxMapping.toMethod).also {
                it.executed = true
                it.weight = sandboxMapping.score
            }

            toMerge.add(sandboxMapping)
        }

        val mergeMapping = NodeMappings()
        toMerge.forEach { mergeMapping.merge(it) }

        ConsoleProgressBar.stop()

        return mergeMapping
    }
}