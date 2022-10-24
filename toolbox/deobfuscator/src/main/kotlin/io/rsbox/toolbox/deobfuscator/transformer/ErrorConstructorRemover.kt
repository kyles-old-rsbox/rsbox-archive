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
import io.rsbox.toolbox.asm.LabelMap
import io.rsbox.toolbox.asm.createLabel
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.InsnNode
import org.objectweb.asm.tree.JumpInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.VarInsnNode
import org.tinylog.kotlin.Logger
import java.lang.reflect.Modifier

class ErrorConstructorRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(!Modifier.isStatic(method.access) || Type.getArgumentTypes(method.desc).size != 2
                    || Type.getArgumentTypes(method.desc)[0].descriptor != "Ljava/lang/String;"
                    || Type.getArgumentTypes(method.desc)[1].descriptor != "Ljava/lang/Throwable;") {
                    return@methodLoop
                }

                val insns = method.instructions

                val aload0 = VarInsnNode(ALOAD, 1)
                val ifNull = JumpInsnNode(IFNULL, insns.createLabel(insns.first))
                val aload1 = VarInsnNode(ALOAD, 1)
                val printStackTrace = MethodInsnNode(INVOKEVIRTUAL, "java/lang/Throwable", "printStackTrace", "()V")
                val ret = InsnNode(RETURN)

                method.instructions.insert(insns[0], aload0)
                method.instructions.insert(insns[1], ifNull)
                method.instructions.insert(insns[2], aload1)
                method.instructions.insert(insns[3], printStackTrace)
                method.instructions.insert(insns[4], ret)
                count++
            }
        }

        Logger.info("Removed $count error constructor methods.")
    }
}