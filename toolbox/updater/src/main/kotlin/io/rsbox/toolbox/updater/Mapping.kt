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

import io.rsbox.toolbox.asm.identifier
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import kotlin.math.max

class Mapping(val from: Any, val to: Any) {

    var count: Int = 0
        private set

    private val instructions = mutableListOf<AbstractInsnNode>()

    var weight: Int = 0
        set(value) {
            if(value > field) {
                field = value
            }
        }

    fun increment() { ++count }
    fun increment(times: Int) { repeat(times) { ++count } }

    fun merge(other: Mapping) {
        count += other.count
        other.instructions.forEach { addInstruction(it) }
        weight = max(weight, other.weight)
    }

    fun addInstruction(insn: AbstractInsnNode) {
        if(!instructions.contains(insn)) {
            instructions.add(insn)
        }
    }

    override fun toString(): String = when(from) {
        is ClassNode -> "[From: ${from.identifier}, To: ${(to as ClassNode).identifier}]"
        is MethodNode -> "[From: ${from.identifier}, To: ${(to as MethodNode).identifier}]"
        is FieldNode -> "[From: ${from.identifier}, To: ${(to as FieldNode).identifier}]"
        else -> "[From: $from, To: $to]"
    }
}