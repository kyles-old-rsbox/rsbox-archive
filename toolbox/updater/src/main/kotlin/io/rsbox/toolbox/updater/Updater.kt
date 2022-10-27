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
import io.rsbox.toolbox.asm.getMethod
import io.rsbox.toolbox.asm.readJar
import io.rsbox.toolbox.asm.writeJar
import io.rsbox.toolbox.updater.asm.extractFeatures
import io.rsbox.toolbox.updater.asm.obfInfo
import io.rsbox.toolbox.updater.matcher.StaticMethodMatcher
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
        Logger.info("Finished matching static method. [Total Matches: ${mappings.asMappingMap().size}]")

        Logger.info("Reducing matched methods.")
        mappings.reduce()
        Logger.info("Finished reducing. [Total Matches: ${mappings.asMappingMap().size}]")

        Logger.info("RSBox updater completed successfully.")
    }
}