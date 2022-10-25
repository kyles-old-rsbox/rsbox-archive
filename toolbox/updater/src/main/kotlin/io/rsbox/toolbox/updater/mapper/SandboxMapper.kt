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

import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.field
import io.rsbox.toolbox.asm.owner
import io.rsbox.toolbox.asm.pool
import io.rsbox.toolbox.updater.MappingUtil
import io.rsbox.toolbox.updater.NodeMapping
import io.rsbox.toolbox.updater.asm.inheritanceGraph
import me.coley.analysis.SimAnalyzer
import me.coley.analysis.SimFrame
import me.coley.analysis.SimInterpreter
import me.coley.analysis.TypeResolver
import me.coley.analysis.util.TypeUtil.EXCEPTION_TYPE
import me.coley.analysis.util.TypeUtil.OBJECT_TYPE
import org.objectweb.asm.Type
import org.objectweb.asm.tree.MethodNode

class SandboxMapper(private val fromMethods: List<MethodNode>, private val toMethod: MethodNode) {

    fun run(): NodeMapping? {
        var highest: NodeMapping? = null
        var multiple = false

        fromMethods.forEach { fromMethod ->
            val mapping = this.execute(fromMethod, toMethod)
            if(highest == null || mapping.same > highest!!.same) {
                highest = mapping
                multiple = true
            } else if(mapping.same == highest!!.same) {
                multiple = false
            }
        }
        return if(multiple) null else highest
    }

    private fun execute(fromMethod: MethodNode, toMethod: MethodNode): NodeMapping {
        fromMethod.pool.initAnalyzer()
        toMethod.pool.initAnalyzer()

        val mapping = NodeMapping()
        mapping.fromMethod = fromMethod
        mapping.toMethod = toMethod

        val fromExecutor = MethodExecutor(fromMethod)
        val toExecutor = MethodExecutor(toMethod)

        fromExecutor.initialize()
        toExecutor.initialize()

        var sameFrameCount = 0
        while(true) {
            val fromFrame = fromExecutor.step()
            val toFrame = toExecutor.step()
            if(fromFrame == null && toFrame == null) break
            if(fromFrame == null || toFrame == null) continue
            if(!MappingUtil.isSame(mapping, fromMethod, toMethod, fromFrame, toFrame)) continue
            sameFrameCount++
            MappingUtil.map(mapping, fromMethod, toMethod, fromFrame, toFrame)
        }
        mapping.same = sameFrameCount
        return mapping
    }

    private val ClassPool.interpreter: SimInterpreter by field { SimInterpreter() }
    private var ClassPool.analyzer: SimAnalyzer by field()
    private var ClassPool.initializedAnalyzer: Boolean by field { false }

    private fun ClassPool.initAnalyzer() {
        if(initializedAnalyzer) return
        interpreter.setTypeChecker { parent, child -> parent.internalName in inheritanceGraph.getAllParents(child.internalName) }
        interpreter.typeResolver = object : TypeResolver {
            override fun common(type1: Type, type2: Type) = inheritanceGraph.getCommon(type1.internalName, type2.internalName)?.let {
                Type.getObjectType(it)
            } ?: OBJECT_TYPE

            override fun commonException(type1: Type, type2: Type) = inheritanceGraph.getCommon(type1.internalName, type2.internalName)?.let {
                Type.getObjectType(it)
            } ?: EXCEPTION_TYPE
        }
        analyzer = SimAnalyzer(interpreter)
        analyzer.setSkipDeadCodeBlocks(true)
        analyzer.setThrowUnresolvedAnalyzerErrors(false)
        initializedAnalyzer = true
    }

    private inner class MethodExecutor(private val method: MethodNode) {

        private var frameIdx = 0
        private lateinit var frames: Array<SimFrame>

        var curFrame: SimFrame? = null
            private set

        private var initialized = false
        private var paused = true
        private var terminated = false

        fun initialize() {
            frames = try { method.pool.analyzer.analyze(method.owner.name, method) } catch(e: Exception) { emptyArray() }
            frameIdx = 0
            paused = false
            initialized = true
        }

        fun step(): SimFrame? {
            if(!initialized) throw IllegalStateException("Method Executor must be initialized first.")

            paused = false
            while(!paused) {
                if(frameIdx >= frames.size) {
                    terminated = true
                    break
                }

                curFrame = frames[frameIdx++]
                if(curFrame != null) {
                    paused = true
                }
            }

            return if(paused) curFrame
            else null
        }
    }
}