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
import io.rsbox.toolbox.updater.asm.setup
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

    private var exportMappings = false

    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size < 3) throw IllegalArgumentException()

        fromJar = File(args[0])
        toJar = File(args[1])
        outJar = File(args[2])

        if(args.size == 4 && args[3] in listOf("--export-mappings", "-e", "--export")) {
            exportMappings = true
        }

        Logger.info("RSBox : RuneScape Client Updater. Developed by Kyle Escobar <https://github.com/kyleescobar>.")

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

        fromPool = ClassPool()
        fromPool.readJar(fromJar)
        fromPool.allClasses.forEach { cls ->
            if(cls.name.contains("bouncycastle") || cls.name.contains("json")) {
                fromPool.ignoreClass(cls)
            }
        }
        fromPool.init()
        fromPool.setup()

        toPool = ClassPool()
        toPool.readJar(toJar)
        toPool.allClasses.forEach { cls ->
            if(cls.name.contains("bouncycastle") || cls.name.contains("json")) {
                toPool.ignoreClass(cls)
            }
        }
        toPool.init()
        toPool.setup()

        Logger.info("Successfully loaded classes from input jar files.")
    }

    private fun run() {
        Logger.info("Running Updater.")

        val mask = ACC_ENUM or ACC_INTERFACE or ACC_ANNOTATION or ACC_RECORD or ACC_ABSTRACT
        val accessA = ACC_INTERFACE and mask
        val accessB = (ACC_INTERFACE or ACC_ENUM or ACC_ABSTRACT) and mask
        val result = 1 - Integer.bitCount(accessA xor accessB) / 5.0
        println(result)
    }

    private fun save() {
        if(outJar.exists()) {
            outJar.deleteRecursively()
        }
        toPool.writeJar(outJar)

        Logger.info("Saved updated classes to output jar: ${outJar.path}.")
    }
}