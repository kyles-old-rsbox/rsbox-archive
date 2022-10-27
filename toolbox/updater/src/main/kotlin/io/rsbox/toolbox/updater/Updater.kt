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

@file:OptIn(ExperimentalSerializationApi::class)

package io.rsbox.toolbox.updater

import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.readJar
import io.rsbox.toolbox.asm.writeJar
import io.rsbox.toolbox.updater.asm.extractFeatures
import io.rsbox.toolbox.updater.asm.obfInfo
import io.rsbox.toolbox.updater.matcher.ClassMatcher
import io.rsbox.toolbox.updater.matcher.MethodMatcher
import io.rsbox.toolbox.updater.matcher.StaticMethodMatcher
import io.rsbox.toolbox.updater.sandbox.Execution
import io.rsbox.toolbox.updater.sandbox.SandboxMethodMatcher
import io.rsbox.toolbox.updater.util.ConsoleProgressBar
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException

@Suppress("DuplicatedCode")
object Updater {

    private lateinit var oldFile: File
    private lateinit var newFile: File
    private lateinit var outputFile: File

    private val fromPool = ClassPool()
    private val toPool = ClassPool()

    private lateinit var mappings: NodeMappings

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size < 3) throw IllegalArgumentException("Usage: updater.jar <old-refactored-jar> <new-deob-jar> <output-refactored-jar>")

        oldFile = File(args[0])
        newFile = File(args[1])
        outputFile = File(args[2])

        if(!oldFile.exists() || !newFile.exists()) throw FileNotFoundException()

        Logger.info("Loading classes from input jar files...")

        /*
         * Load the classes from the jar files into the class pools.
         */
        fromPool.readJar(oldFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                fromPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        fromPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { fromPool.ignoreClass(it) }
        fromPool.init()
        fromPool.extractFeatures()

        toPool.readJar(newFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                toPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        toPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { toPool.ignoreClass(it) }
        toPool.init()
        toPool.extractFeatures()

        Logger.info("Successfully loaded classes from input jar files. [Old-Classes: ${fromPool.classes.size}, New-Class: ${toPool.classes.size}].")

        /*
         * Run the updater
         */
        run()

        /*
         * Export the updated classes to output jar file.
         */
        Logger.info("Saving updated classes to output jar.")
        if(outputFile.exists()) outputFile.deleteRecursively()
        toPool.writeJar(outputFile)

        Logger.info("Updater has completed successfully.")
    }

    private fun run() {
        Logger.info("Starting RSBox updater.")
        mappings = NodeMappings()

        Logger.info("Matching static methods.")
        mappings.merge(StaticMethodMatcher().match(fromPool, toPool))

        Logger.info("Matching non-static methods.")
        mappings.merge(MethodMatcher().match(fromPool, toPool))

        Logger.info("Reducing matches.")
        mappings.reduce()

        Logger.info("Matching unsandboxed methods.")
        while(matchUnsandboxedMethods(mappings)) { /* Do Nothing */ }

        Logger.info("Matching classes.")
        ClassMatcher(fromPool, toPool).match(mappings)

        Logger.info("Reducing matches.")
        mappings.reduce()

        Logger.info("RSBox updater completed successfully.")
    }

    private fun matchUnsandboxedMethods(mappings: NodeMappings): Boolean {
        ConsoleProgressBar.start("Matching UnSandboxed Methods", "", mappings.asMappingMap().size.toLong())
        var matched = false
        mappings.asMappingMap().keys.forEach { toNode ->
            ConsoleProgressBar.step()
            val match = mappings.getMappings(toNode).iterator().next()
            if(match.executed || match.from !is MethodNode) return@forEach
            val fromMethod = match.from
            val toMethod = match.to as MethodNode
            if(fromMethod.instructions.size() == 0 || toMethod.instructions.size() == 0) return@forEach

            val sandboxMapping = Execution.match(fromMethod, toMethod)
            sandboxMapping.map(sandboxMapping.fromMethod, sandboxMapping.toMethod).also {
                it.executed = true
            }

            matched = true
            mappings.merge(sandboxMapping)
        }
        ConsoleProgressBar.stop()
        return matched
    }
}