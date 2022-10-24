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

package io.rsbox.toolbox.updater.mapper

import com.google.common.collect.LinkedHashMultimap
import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.NodeMapping
import io.rsbox.toolbox.updater.classifier.classifyMethod
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

class StaticMethodMapper(private val fromPool: ClassPool, private val toPool: ClassPool, ) {

    private val mappings = LinkedHashMultimap.create<MethodNode, MethodNode>()

    private fun ClassPool.getStaticMethods() = this.classes.flatMap { it.methods }.filter { Modifier.isStatic(it.access) }.toList()
    private fun ClassPool.getPossibleMatches(method: MethodNode) = getStaticMethods().filter { MappingUtil.isMaybeEqual(it, method) }.toList()

    fun map(): NodeMapping {
        val mapping = NodeMapping(fromPool, toPool)
        toPool.getStaticMethods().forEach { toMethod ->
            mappings.putAll(toMethod, fromPool.getPossibleMatches(toMethod))
        }
        mappings.keySet().forEach { toMethod ->
            val fromMethods = mappings.get(toMethod)
            fromMethods.forEach { fromMethod ->
                mapping.map(null, toMethod, fromMethod).also { it.classifyMethod() }
            }
        }
        return mapping
    }
}