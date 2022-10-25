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
import io.rsbox.toolbox.updater.mapper.MethodMapper
import io.rsbox.toolbox.updater.mapper.StaticMethodMapper
import io.rsbox.toolbox.updater.mapper.SandboxMapper
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException
import kotlin.math.max

@Suppress("DuplicatedCode")
object Updater {

    private lateinit var oldFile: File
    private lateinit var newFile: File
    private lateinit var outputFile: File

    private val prevPool = ClassPool()
    private val curPool = ClassPool()

    private lateinit var topMapping: NodeMapping

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
        prevPool.readJar(oldFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                prevPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        prevPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { prevPool.ignoreClass(it) }
        prevPool.init()
        prevPool.extractFeatures()

        curPool.readJar(newFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                curPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        curPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { curPool.ignoreClass(it) }
        curPool.init()
        curPool.extractFeatures()

        Logger.info("Successfully loaded classes from input jar files. [Old-Classes: ${prevPool.classes.size}, New-Class: ${curPool.classes.size}].")

        /*
         * Run the updater
         */
        run()

        /*
         * Export the updated classes to output jar file.
         */
        Logger.info("Saving updated classes to output jar.")
        if(outputFile.exists()) outputFile.deleteRecursively()
        curPool.writeJar(outputFile)

        Logger.info("Updater has completed successfully.")
    }

    private fun run() {
        Logger.info("Updating classes from previous name mappings...")

        /*
         * Run mapping methods.
         */
        topMapping = NodeMapping()
        topMapping.merge(mapStaticMethods())
        topMapping.merge(mapMethods())
        topMapping.reduce()

        Logger.info("Finished updating classes.")
        val total = max(prevPool.classes.size, curPool.classes.size) +
                max(prevPool.classes.flatMap { it.methods }.size, curPool.classes.flatMap { it.methods }.size) +
                max(prevPool.classes.flatMap { it.fields }.size, curPool.classes.flatMap { it.fields }.size)
        val count = topMapping.mappings().keys.size
        val percentage = (count.toDouble() / total.toDouble()) * 100.0
        Logger.info("Successfully updated: $count / $total ($percentage%).")
    }

    /**
     * ===== MAPPING METHODS =====
     */

    private fun mapStaticMethods(): NodeMapping {
        Logger.info("Matching static methods...")

        val mapper = StaticMethodMapper()
        mapper.map(prevPool, curPool)

        val toMerge = mutableListOf<NodeMapping>()
        mapper.mappings.keySet().forEach { toMethod ->
            val fromMethods = mapper.mappings.get(toMethod)

            val sandboxMapper = SandboxMapper(fromMethods.toList(), toMethod)
            val sandboxMapping = sandboxMapper.run() ?: return@forEach

            sandboxMapping.map(null, sandboxMapping.fromMethod, sandboxMapping.toMethod).also {
                it.weight = sandboxMapping.same
            }

            toMerge.add(sandboxMapping)
        }

        val resultMapping = NodeMapping()
        toMerge.forEach { mapping ->
            resultMapping.merge(mapping)
        }

        Logger.info("Finished matching static methods.")

        return resultMapping
    }

    private fun mapMethods(): NodeMapping {
        Logger.info("Matching non-static methods.")

        val mapper = MethodMapper()
        mapper.map(prevPool, curPool)

        val toMerge = mutableListOf<NodeMapping>()
        mapper.mappings.keySet().forEach { toMethod ->
            val fromMethods = mapper.mappings.get(toMethod)
            val sandboxMapper = SandboxMapper(fromMethods.toList(), toMethod)
            val sandboxMapping = sandboxMapper.run() ?: return@forEach
            sandboxMapping.map(null, sandboxMapping.fromMethod, sandboxMapping.toMethod)
            toMerge.add(sandboxMapping)
        }

        val resultMapping = NodeMapping()
        toMerge.forEach { mapping ->
            resultMapping.merge(mapping)
        }

        Logger.info("Finished matching non-static methods.")

        return resultMapping
    }
}