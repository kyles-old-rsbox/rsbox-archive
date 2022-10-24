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
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException

@Suppress("DuplicatedCode")
object Updater {

    private lateinit var oldFile: File
    private lateinit var newFile: File
    private lateinit var outputFile: File

    private val prevPool = ClassPool()
    private val curPool = ClassPool()

    private lateinit var rootMapping: NodeMapping

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size < 3) throw IllegalArgumentException("Usage: updater.jar <old-refactored-jar> <new-deob-jar> <output-refactored-jar>")
        oldFile = File(args[0])
        newFile = File(args[1])
        outputFile = File(args[2])

        if(!oldFile.exists() || !newFile.exists()) throw FileNotFoundException()

        /*
         * Load the classes from the jar files into the class pools.
         */
        Logger.info("Loading classes from jar: ${oldFile.path}.")
        prevPool.readJar(oldFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                prevPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        prevPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { prevPool.ignoreClass(it) }
        prevPool.init()
        prevPool.extractFeatures()

        Logger.info("Loading classes from jar: ${newFile.path}.")
        curPool.readJar(newFile) { jar, entry ->
            if(entry.name == "META-INF/obf-info.json") {
                curPool.obfInfo = Json.decodeFromStream(jar.getInputStream(entry))
            }
        }
        curPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { curPool.ignoreClass(it) }
        curPool.init()
        curPool.extractFeatures()

        Logger.info("Successfully loaded classes. [Prev Pool: ${prevPool.classes.size}, Current Pool: ${curPool.classes.size}].")

        /*
         * Run the updater
         */
        run()

        /*
         * Export the updated classes to output jar file.
         */
        Logger.info("Saving updated classes to jar: ${outputFile.path}.")
        if(outputFile.exists()) outputFile.deleteRecursively()
        curPool.writeJar(outputFile)
    }

    private fun run() {
        Logger.info("Running RSBox updater.")

        /*
         * Run mapping methods.
         */
        rootMapping = NodeMapping(prevPool, curPool)

        mapStaticMethods()
        mapMethods()
        rootMapping.reduce()

        println()
    }

    /**
     * ===== MAPPING METHODS =====
     */

    private fun mapStaticMethods() {
        val staticMethodMapper = StaticMethodMapper(prevPool, curPool)
        rootMapping.merge(staticMethodMapper.map())
    }

    private fun mapMethods() {
        val methodMapper = MethodMapper(prevPool, curPool)
        rootMapping.merge(methodMapper.map())
    }
}