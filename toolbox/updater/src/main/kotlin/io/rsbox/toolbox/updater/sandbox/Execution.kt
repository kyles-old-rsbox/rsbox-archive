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

package io.rsbox.toolbox.updater.sandbox

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.NodeMappings
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.IntInsnNode
import org.objectweb.asm.tree.LdcInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode
import org.objectweb.asm.tree.TypeInsnNode
import org.objectweb.asm.tree.analysis.Analyzer
import org.objectweb.asm.tree.analysis.Frame
import org.objectweb.asm.tree.analysis.SourceInterpreter
import org.objectweb.asm.tree.analysis.SourceValue
import java.lang.reflect.Modifier

class Execution(private val method: MethodNode) {

    private val owner: ClassNode = method.owner
    private val pool: ClassPool = method.pool

    private var initialized = false
    private var exited = false
    private var paused = false

    private lateinit var frames: Array<Frame<SourceValue>?>

    var currentFrame: Frame<SourceValue>? = null
        private set

    private var currentIndex: Int = 0

    private val analyzer = Analyzer(SourceInterpreter())
    private var pausePredicate: (AbstractInsnNode) -> Boolean = { false }

    fun init() {
        exited = false
        paused = false
        currentFrame = null
        currentIndex = 0

        frames = analyzer.analyze(method.owner.name, method)
        val insns = method.instructions.toArray()
        for(i in frames.indices) {
            if(frames[i] != null) {
                frames[i]!!.instruction = insns[i]
            }
        }

        initialized = true
    }

    fun pauseWhen(predicate: (AbstractInsnNode) -> Boolean) {
        this.pausePredicate = predicate
    }

    fun run(): Frame<SourceValue>? {
        if(exited) return null
        paused = false

        while(!paused) {
            if(currentIndex == frames.size) {
                exited = true
                return null
            }

            currentFrame = frames[currentIndex++] ?: continue

            if(pausePredicate(currentFrame!!.instruction)) {
                paused = true
            }
        }

        return currentFrame
    }

    companion object {

        fun match(fromMethod: MethodNode, toMethod: MethodNode): NodeMappings {
            val mapping = NodeMappings()
            mapping.fromMethod = fromMethod
            mapping.toMethod = toMethod

            val fromExecution = Execution(fromMethod)
            fromExecution.init()
            fromExecution.pauseWhen(pausePredicate)

            val toExecution = Execution(toMethod)
            toExecution.init()
            toExecution.pauseWhen(pausePredicate)

            var score = 0
            while(!fromExecution.exited && !toExecution.exited) {
                val fromFrame = fromExecution.run() ?: break
                val toFrame = toExecution.run() ?: break
                if(mapFrames(mapping, fromMethod, toMethod, fromFrame, toFrame)) score++
            }
            mapping.score = score
            return mapping
        }

        private fun mapFrames(mapping: NodeMappings, fromMethod: MethodNode, toMethod: MethodNode, fromFrame: Frame<SourceValue>, toFrame: Frame<SourceValue>): Boolean {
            val fromPool = fromMethod.pool
            val toPool = toMethod.pool

            val fromInsn = fromFrame.instruction
            val toInsn = toFrame.instruction

            when {
                /** PUT FIELD MAPPING **/
                fromInsn.opcode in listOf(PUTFIELD, PUTSTATIC) && toInsn.opcode in listOf(PUTFIELD, PUTSTATIC) -> {
                    fromInsn as FieldInsnNode
                    toInsn as FieldInsnNode
                    val fromField = fromPool.findClass(fromInsn.owner)?.getField(fromInsn.name, fromInsn.desc) ?: return false
                    val toField = toPool.findClass(toInsn.owner)?.getField(toInsn.name, toInsn.desc) ?: return false
                    if(MappingUtil.isPotentiallyEqual(fromField, toField)) {
                        mapping.map(fromField, toField)
                        mapping.map(fromField.owner, toField.owner)
                        if(fromField.typeClass != null && toField.typeClass != null) {
                            mapping.map(fromField.typeClass!!, toField.typeClass!!)
                        }
                    }
                }

                /** METHOD INVOKE MAPPING **/
                fromInsn is MethodInsnNode && toInsn is MethodInsnNode && fromInsn.opcode == toInsn.opcode -> {
                    val fromM = fromPool.findClass(fromInsn.owner)?.getMethod(fromInsn.name, fromInsn.desc) ?: return false
                    val toM = toPool.findClass(toInsn.owner)?.getField(toInsn.name, toInsn.desc) ?: return false
                    if(MappingUtil.isMethodDescPotentiallyEqual(fromM.desc, toM.desc)) {
                        mapping.map(fromM, toM)
                        if(!Modifier.isStatic(fromM.access) && !Modifier.isStatic(toM.access)) {
                            mapping.map(fromM.owner, toM.owner)
                        }
                        val fromReturnType = fromM.type.returnType.findInPool(fromPool)
                        val toReturnType = toM.type.returnType.findInPool(toPool)
                        if(fromReturnType != null && toReturnType != null) {
                            mapping.map(fromReturnType, toReturnType)
                        }
                        for(i in 0 until fromM.type.argumentTypes.size) {
                            val fromArg = fromM.type.argumentTypes[i]!!.findInPool(fromPool)
                            val toArg = toM.type.argumentTypes[i]!!.findInPool(toPool)
                            if(fromArg != null && toArg != null) {
                                mapping.map(fromArg, toArg)
                            }
                        }
                    }
                    return true
                }
            }

            return false
        }

        private val pausePredicate: (AbstractInsnNode) -> Boolean = { insn ->
            insn.opcode in listOf(PUTFIELD, PUTSTATIC) ||
            insn is MethodInsnNode
        }

        private fun Type.findInPool(pool: ClassPool): ClassNode? = pool.findClass(this.internalName)
    }
}