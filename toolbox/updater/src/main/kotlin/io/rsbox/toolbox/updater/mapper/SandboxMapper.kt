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

package io.rsbox.toolbox.updater.mapper

import io.rsbox.toolbox.asm.identifier
import io.rsbox.toolbox.asm.owner
import io.rsbox.toolbox.asm.pool
import io.rsbox.toolbox.updater.NodeMapping
import io.rsbox.toolbox.updater.asm.inheritanceGraph
import me.coley.analysis.SimAnalyzer
import me.coley.analysis.SimFrame
import me.coley.analysis.SimInterpreter
import me.coley.analysis.TypeResolver
import me.coley.analysis.util.TypeUtil
import org.objectweb.asm.Type
import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.LdcInsnNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class SandboxMapper {

    fun map(mapping: NodeMapping) {
        mapping.mappings().forEach { (fromMethod, toMethod) ->
            if(fromMethod is MethodNode && toMethod is MethodNode) {
                if(mapping.isSame(fromMethod, toMethod)) {
                    mapping.map(null, fromMethod, toMethod)
                    Logger.info("Mapped 100% methods: [from: ${fromMethod.identifier}, to: ${toMethod.identifier}].")
                }
            }
        }
    }

    private fun MethodNode.execute(): Array<SimFrame> = try { SimAnalyzer(object : SimInterpreter() {}.also {
        it.setTypeChecker { parent, child -> parent.internalName in this.pool.inheritanceGraph.getAllParents(child.internalName) }
        it.typeResolver = object : TypeResolver {
            override fun common(type1: Type, type2: Type): Type =
                this@execute.pool.inheritanceGraph.getCommon(type1.internalName, type2.internalName)?.let { Type.getObjectType(it) } ?: TypeUtil.OBJECT_TYPE
            override fun commonException(type1: Type, type2: Type) =
                this@execute.pool.inheritanceGraph.getCommon(type1.internalName, type2.internalName)?.let { Type.getObjectType(it) } ?: TypeUtil.EXCEPTION_TYPE
        }
    }).also {
        it.setSkipDeadCodeBlocks(true)
        it.setThrowUnresolvedAnalyzerErrors(false)
    }.analyze(owner.name, this) } catch(e: Exception) { emptyArray() }

    private fun NodeMapping.isSame(fromMethod: MethodNode, toMethod: MethodNode): Boolean {
        val fromFrames = fromMethod.execute()
        val toFrames = toMethod.execute()

        var terminated = false
        var same = true

        var fromPaused = false
        var fromIdx = 0
        var fromFrame: SimFrame? = null

        var toPaused = false
        var toIdx = 0
        var toFrame: SimFrame? = null

        while(true) {
            if(fromPaused && toPaused) {
                if(isSame(fromFrame!!.instruction, toFrame!!.instruction)) {
                    this.map(fromFrame.instruction, fromMethod, toMethod)
                    fromPaused = false
                    toPaused = false
                } else {
                    same = false
                    terminated = true
                    break
                }
            } else {
                if(fromIdx >= fromFrames.size || toIdx >= toFrames.size) {
                    terminated = true
                    break
                }

                if(!fromPaused) {
                    fromFrame = fromFrames[fromIdx++]
                    fromPaused = fromFrame.isMappable()
                }
                if(!toPaused) {
                    toFrame = toFrames[toIdx++]
                    toPaused = toFrame.isMappable()
                }
            }
        }

        return same
    }

    private fun SimFrame?.isMappable(): Boolean {
        return if(this == null) false
        else when(this.instruction) {
            is LdcInsnNode -> true
            else -> false
        }
    }

    private fun isSame(fromInsn: AbstractInsnNode, toInsn: AbstractInsnNode) = when {
        fromInsn is LdcInsnNode && toInsn is LdcInsnNode -> {
            val fromCst = fromInsn.cst
            val toCst = toInsn.cst
            fromCst == toCst
        }
        else -> false
    }
}