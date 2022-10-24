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

package io.rsbox.toolbox.updater

import com.google.common.collect.HashMultimap
import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.identifier
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

class NodeMapping(private val fromPool: ClassPool, private val toPool: ClassPool) {

    private var mappings = HashMultimap.create<Any, Mapping>()

    var same: Int = 0

    private fun getMapping(from: Any, to: Any): Mapping {
        mappings.get(from).forEach { mapping ->
            if(mapping.to == to) {
                return mapping
            }
        }
        val mapping = Mapping(from, to)
        mappings.put(from, mapping)
        return mapping
    }

    private fun getHighest(from: Any): Any? {
        var highest: Mapping? = null
        mappings.get(from).forEach { mapping ->
            if(highest == null || mapping.count > highest!!.count) {
                highest = mapping
            } else if(mapping.count == highest!!.count && getName(from)!! > getName(highest!!.to)!!) {
                highest = mapping
            }
        }
        return if(highest != null) highest!!.to else null
    }

    fun merge(other: NodeMapping) {
        for (entry in other.mappings.entries()) {
            val mapping = getMapping(entry.key, entry.value.to)
            mapping.merge(entry.value)
        }
    }

    fun get(obj: Any): Any? = getHighest(obj)
    fun getMappings(obj: Any) = mappings.get(obj)

    fun mappings(): Map<Any, Any?> {
        val ret = hashMapOf<Any, Any?>()
        mappings.keySet().forEach { obj ->
            ret[obj] = getHighest(obj)
        }
        return ret
    }

    fun map(insn: AbstractInsnNode? = null, from: Any, to: Any): Mapping {
        val mapping = getMapping(from, to)
        if(insn != null) {
            mapping.addInstruction(insn)
        }
        mapping.increment()
        return mapping
    }

    private fun mapClass() {

    }

    fun reduce() {
        val sorted = mutableListOf<Mapping>().also { it.addAll(mappings.values()) }
        sorted.sortWith { a, b ->
            val i = a.count.compareTo(b.count)
            if(i != 0) i
            if(a.weight != b.weight) a.weight.compareTo(b.weight)
            getName(a.from)!!.compareTo(getName(b.from)!!)
        }
        sorted.reverse()

        val reducedMap = HashMultimap.create<Any, Mapping>()
        val reverse = hashMapOf<Any, Any>()

        sorted.forEach { mapping ->
            if(reducedMap.containsKey(mapping.from)) return@forEach
            if(reverse.containsKey(mapping.to)) return@forEach
            reducedMap.put(mapping.from, mapping)
            reverse[mapping.to] = mapping.from
        }
        mappings = reducedMap
    }

    private fun getName(obj: Any) = when (obj) {
        is FieldNode -> obj.identifier
        is MethodNode -> obj.identifier
        is ClassNode -> obj.identifier
        else -> null
    }
}