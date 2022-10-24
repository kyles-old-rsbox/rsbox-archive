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

package io.rsbox.toolbox.updater

import io.rsbox.toolbox.asm.ClassPool
import io.rsbox.toolbox.asm.readJar
import io.rsbox.toolbox.asm.writeJar
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException

object Updater {

    private lateinit var oldFile: File
    private lateinit var newFile: File
    private lateinit var outputFile: File

    val prevPool = ClassPool()
    val curPool = ClassPool()

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size < 3) throw IllegalArgumentException("Usage: updater.jar <old-refactored-jar> <new-deob-jar> <output-refactored-jar>")
        oldFile = File(args[0])
        newFile = File(args[1])
        outputFile = File(args[1])

        if(!oldFile.exists() || !newFile.exists()) throw FileNotFoundException()

        /*
         * Load the classes from the jar files into the class pools.
         */
        Logger.info("Loading classes from jar files.")

        prevPool.readJar(oldFile)
        prevPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { prevPool.ignoreClass(it) }
        prevPool.init()

        curPool.readJar(newFile)
        curPool.allClasses.filter { it.name.contains("json") || it.name.contains("bouncycastle") }.forEach { curPool.ignoreClass(it) }
        curPool.init()

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


    }
}