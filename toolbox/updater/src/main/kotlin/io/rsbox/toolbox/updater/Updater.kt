package io.rsbox.toolbox.updater

import io.rsbox.toolbox.asm.readJar
import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.asm.writeJar
import io.rsbox.toolbox.updater.asm.loadInfo
import io.rsbox.toolbox.updater.classifier.StaticMethodClassifiers
import org.jline.utils.Log
import org.tinylog.kotlin.Logger
import java.io.File

object Updater {

    private lateinit var fromJar: File
    private lateinit var toJar: File
    private lateinit var outJar: File

    val fromPool = ClassPool()
    val toPool = ClassPool()

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
        Logger.info("Loading class from input jars.")

        fromPool.readJar(fromJar)
        fromPool.allClasses.forEach {
            if(it.name.contains("bouncycastle") || it.name.contains("json")) {
                fromPool.ignoreClass(it)
            }
        }
        fromPool.init()
        fromPool.loadInfo()

        toPool.readJar(toJar)
        toPool.allClasses.forEach {
            if(it.name.contains("bouncycastle") || it.name.contains("json")) {
                toPool.ignoreClass(it)
            }
        }
        toPool.init()
        toPool.loadInfo()

        Logger.info("Successfully loaded classes.")

        /*
         * Initialize classifiers.
         */
        StaticMethodClassifiers.init()

    }

    private fun run() {
        Logger.info("Starting updater.")

        StaticMethodClassifiers.match(fromPool, toPool)
        println()
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