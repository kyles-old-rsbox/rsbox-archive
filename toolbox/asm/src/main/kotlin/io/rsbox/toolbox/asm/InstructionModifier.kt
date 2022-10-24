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

package io.rsbox.toolbox.asm

import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.MethodNode

class InstructionModifier {

    companion object {
        val EMPTY_LIST = InsnList()
    }

    private val replacements = hashMapOf<AbstractInsnNode, InsnList>()
    private val appends = hashMapOf<AbstractInsnNode, InsnList>()
    private val prepends = hashMapOf<AbstractInsnNode, InsnList>()

    fun append(original: AbstractInsnNode, insns: InsnList) {
        appends[original] = insns
    }

    fun append(original: AbstractInsnNode, insn: AbstractInsnNode) {
        val insns = InsnList()
        insns.add(insn)
        append(original, insns)
    }

    fun prepend(original: AbstractInsnNode, insns: InsnList) {
        prepends[original] = insns
    }

    fun prepend(original: AbstractInsnNode, insn: AbstractInsnNode) {
        val insns = InsnList()
        insns.add(insn)
        prepend(original, insns)
    }

    fun replace(original: AbstractInsnNode, vararg insns: AbstractInsnNode) {
        val lst = InsnList()
        insns.forEach { lst.add(it) }
        replacements[original] = lst
    }

    fun replace(original: AbstractInsnNode, insns: InsnList) {
        replacements[original] = insns
    }

    fun replace(originalInsns: List<AbstractInsnNode>, insns: List<AbstractInsnNode>) {
        val originalInsnsList = InsnList()
        val insnsList = InsnList()
        originalInsns.forEach { originalInsnsList.add(it) }
        insns.forEach { insnsList.add(it) }
        replace(originalInsnsList, insnsList)
    }

    fun replace(originalInsns: InsnList, insns: InsnList) {
        for(idx in 0 until originalInsns.size()) {
            val original = originalInsns[idx]!!
            val insn = insns[idx]
            if(insn == null) {
                remove(original)
            } else {
                replace(original, insn)
            }
        }
    }

    fun remove(original: AbstractInsnNode) {
        replacements[original] = EMPTY_LIST
    }

    fun removeAll(insns: List<AbstractInsnNode>) {
        insns.forEach { remove(it) }
    }

    fun apply(method: MethodNode) {
        prepends.forEach { (original, insns) ->
            method.instructions.insertBefore(original, insns)
        }
        appends.forEach { (original, insns) ->
            method.instructions.insert(original, insns)
        }
        replacements.forEach { (original, insns) ->
            method.instructions.insert(original, insns)
            method.instructions.remove(original)
        }
    }
}