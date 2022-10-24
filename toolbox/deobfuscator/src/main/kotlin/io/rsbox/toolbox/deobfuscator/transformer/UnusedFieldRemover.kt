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
import io.rsbox.toolbox.asm.identifier
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.tree.FieldInsnNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class UnusedFieldRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        val usedFields = pool.allClasses.flatMap { it.methods }
            .flatMap { it.instructions.toArray().asIterable() }
            .mapNotNull { it as? FieldInsnNode }
            .map { "${it.owner}.${it.name}" }
            .toSet()

        pool.classes.forEach { cls ->
            val fields = cls.fields.iterator()
            while(fields.hasNext()) {
                val field = fields.next()
                if(!usedFields.contains(field.identifier) && Modifier.isFinal(field.access)) {
                    fields.remove()
                    count++
                }
            }
        }

        Logger.info("Removed $count unused fields.")
    }
}