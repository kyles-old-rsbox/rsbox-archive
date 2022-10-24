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

import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.InsnList
import java.lang.reflect.Modifier
import java.util.regex.Pattern


class InstructionMatcher(private val insns: InsnList) {

    private var insnIdxMap = hashMapOf<AbstractInsnNode, Int>()
    private var currentIdx = 0
    private var mappedCode = ""

    val currentIndex: Int get() = currentIdx

    init {
        reload()
    }

    fun reload() {
        val buf = StringBuffer()
        insnIdxMap = hashMapOf()
        val it = insns.iterator()
        while(it.hasNext()) {
            val insn = it.next()
            if(insn.opcode < 0) continue
            insnIdxMap[insn] = buf.length
            buf.append(OPCODE_NAME_MAP[insn.opcode]).append(" ")
        }
        mappedCode = buf.toString()
    }

    private fun getKey(value: Int): AbstractInsnNode? {
        insnIdxMap.forEach { (insn, idx) ->
            if(idx == value) {
                return insn
            }
        }
        return null
    }

    private fun getMatchFromRange(start: Int, end: Int): List<AbstractInsnNode> {
        val startInsn = getKey(start)
        var realEndIdx = -1
        for (i in end - 1 downTo start) {
            if(mappedCode[i] == ' ') {
                realEndIdx = i + 1
                break
            }
        }
        val endInsn = getKey(realEndIdx)
        var startIdx = 0
        if(startInsn != null) {
            startIdx = insns.indexOf(startInsn)
        }
        val match = arrayOfNulls<AbstractInsnNode>(insns.indexOf(endInsn) - startIdx + 1)
        for (i in match.indices) {
            match[i] = insns[startIdx + i]
        }
        return match.filterNotNull().toList()
    }

    fun search(pattern: Pattern, from: AbstractInsnNode, predicate: (List<AbstractInsnNode>) -> Boolean = { true }): List<List<AbstractInsnNode>> {
        val matcher = pattern.matcher(mappedCode)
        val ret = insnIdxMap[from]
        var startIdx = 0
        if(ret != null) {
            startIdx = ret.toInt()
        }
        val matches = mutableListOf<List<AbstractInsnNode>>()
        while(matcher.find(startIdx)) {
            val start = matcher.start()
            val end = matcher.end()
            val match = getMatchFromRange(start, end)
            if(predicate(match)) {
                matches.add(match)
            }
            startIdx = end
        }
        currentIdx = startIdx
        return matches
    }

    fun search(pattern: Pattern, predicate: (List<AbstractInsnNode>) -> Boolean = { true}) = search(pattern, insns.first, predicate)
    fun search(pattern: String, from: AbstractInsnNode, predicate: (List<AbstractInsnNode>) -> Boolean = { true }) = search(Pattern.compile(pattern.lowercase()), from, predicate)
    fun search(pattern: String, predicate: (List<AbstractInsnNode>) -> Boolean = { true }) = search(pattern, insns.first, predicate)

    companion object {

        private val OPCODE_NAME_MAP = hashMapOf<Int, String>()

        private val NON_INSN_CONST_PATTERNS = arrayOf(
            Pattern.compile("acc_.+"),
            Pattern.compile("t_.+"),
            Pattern.compile("v1_.+")
        )

        init {
            val opcodes = Opcodes::class.java
            val declaredFields = opcodes.declaredFields
            declaredFields.forEach { field ->
                val modifiers = field.modifiers
                if(Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) && field.type == Integer.TYPE) {
                    try {
                        val name = field.name.lowercase()
                        var failed = false
                        for(pattern in NON_INSN_CONST_PATTERNS) {
                            val matcher = pattern.matcher(name)
                            if(matcher.find() && matcher.start() == 0) {
                                failed = true
                                break
                            }
                        }
                        if(failed) return@forEach
                        val cst = field.getInt(null)
                        OPCODE_NAME_MAP[cst] = name
                    } catch (e: IllegalAccessException) { /* Do Nothing */ }
                }
            }
        }
    }
}