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

import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.tree.LineNumberNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class MethodSorter : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            val lineNumbers = cls.methods.associateWith { it.lineNumber ?: Int.MAX_VALUE }
            cls.methods = cls.methods.sortedBy { lineNumbers.getValue(it) }
            count += cls.methods.size
        }

        Logger.info("Sorted $count methods.")
    }

    private val MethodNode.lineNumber: Int? get() {
        for(insn in instructions) {
            if(insn is LineNumberNode) {
                return insn.line
            }
        }
        return null
    }
}