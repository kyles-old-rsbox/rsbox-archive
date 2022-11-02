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

import io.rsbox.toolbox.asm.readJar
import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.asm.writeJar
import org.objectweb.asm.Opcodes.*
import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException

object Updater {

    /**
     * Represents the class pool loaded from the old/previous
     * jar file with the names you want applied to a new rev.
     */
    private lateinit var fromPool: ClassPool

    /**
     * Represents the class pool which names will be updated from the
     * fromPool.
     */
    private lateinit var toPool: ClassPool

    private lateinit var fromJar: File
    private lateinit var toJar: File
    private lateinit var outJar: File

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size != 3) {
            throw IllegalArgumentException("Missing required arguments. Usage: updater.jar <from-jar> <to-jar> <output-jar>")
        }

        fromJar = File(args[0])
        toJar = File(args[1])
        outJar = File(args[2])

        init()
        run()
        save()
    }

    private fun init() {
        Logger.info("Initializing Updater.")

        /*
         * Load classes from jars into respective pools.
         */
        if(!fromJar.exists() || !toJar.exists()) throw FileNotFoundException("Invalid program arguments.")

        fromPool.readJar(fromJar)
        fromPool.allClasses.forEach {
            if(it.name.contains("bouncycastle") || it.name.contains("json")) {
                fromPool.ignoreClass(it)
            }
        }
        fromPool.init()

        toPool.readJar(toJar)
        toPool.allClasses.forEach {
            if(it.name.contains("bouncycastle") || it.name.contains("json")) {
                toPool.ignoreClass(it)
            }
        }
        toPool.init()

        Logger.info("Successfully loaded classes.")
    }

    private fun run() {
        Logger.info("Starting updater.")
    }

    private fun save() {
        Logger.info("Saving updated classes to jar: ${outJar.path}.")

        if(outJar.exists()) {
            outJar.deleteRecursively()
        }

        toPool.writeJar(outJar)

        Logger.info("Successfully saved updated classes.")
    }
}