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

import com.google.common.collect.Iterables
import io.rsbox.toolbox.asm.readClass
import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class StaticMethodMover : Transformer {

    private var count = 0

    private val staticMethods = mutableSetOf<MethodNode>()

    override fun run(pool: ClassPool) {
        val staticsCls = StaticMethodMover::class.java.getResourceAsStream("/io/rsbox/toolbox/deobfuscator/transformer/StaticMethodMover\$Statics.class")!!
            .readAllBytes().let { readClass(it) }
        staticsCls.name = "Statics"
        staticsCls.init(pool)
        staticsCls.reset()
        staticsCls.build()
        pool.addClass(staticsCls, ignore = true)

        staticsCls.ignored = true
        staticsCls.init(pool)

        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                if(Modifier.isStatic(method.access) && method.name != "<clinit>" && method.identifier !in StaticMethodOwnerOptimizer.placedMethods) {
                    staticMethods.add(method)
                }
            }
        }

        staticMethods.forEach { method ->
            val newMethod = MethodNode(method.access, method.name, method.desc, null, Iterables.toArray(method.exceptions, String::class.java))
            method.accept(newMethod)
            staticsCls.methods.add(newMethod)
        }

        pool.addClass(staticsCls)
        pool.init()

        count = staticMethods.size
        Logger.info("Moved ${staticMethods.size} static methods.")
    }

    object Statics {

    }
}