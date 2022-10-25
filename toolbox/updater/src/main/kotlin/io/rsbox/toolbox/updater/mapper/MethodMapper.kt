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
import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.owner
import io.rsbox.toolbox.updater.MappingUtil
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

class MethodMapper {

    val mappings = LinkedHashMultimap.create<MethodNode, MethodNode>()

    private fun methods(pool: ClassPool) = pool.classes.flatMap { it.methods }.filter {
        !Modifier.isStatic(it.access) && it.name != "<init>" && it.instructions.size() > 0
    }.toList()

    private fun getPossibleMatches(pool: ClassPool, method: MethodNode) = methods(pool)
        .filter { MappingUtil.isMaybeEqual(method.owner, it.owner) }
        .filter { MappingUtil.isMaybeEqual(method.desc, it.desc) }
        .toList()

    fun map(fromPool: ClassPool, toPool: ClassPool) {
        methods(toPool).forEach { toMethod ->
            mappings.putAll(toMethod, getPossibleMatches(fromPool, toMethod))
        }
    }
}