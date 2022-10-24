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
import org.objectweb.asm.Type
import org.objectweb.asm.tree.TryCatchBlockNode
import org.tinylog.kotlin.Logger

class RuntimeExceptionRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                val toRemove = mutableListOf<TryCatchBlockNode>()
                method.tryCatchBlocks.forEach { tcb ->
                    if(tcb.type == Type.getInternalName(RuntimeException::class.java)) {
                        toRemove.add(tcb)
                    }
                }
                method.tryCatchBlocks.removeAll(toRemove)
                count += toRemove.size
            }
        }

        Logger.info("Removed $count RuntimeException try-catch blocks.")
    }
}