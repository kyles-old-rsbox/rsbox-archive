package io.rsbox.toolbox.deobfuscator

import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.transformer.*
import org.tinylog.kotlin.Logger
import readJar
import writeJar
import java.io.File
import kotlin.reflect.full.createInstance

object Deobfuscator {

    private lateinit var inputFile: File
    private lateinit var outputFile: File
    private var runTestClient = false

    private val pool = ClassPool()
    private val transformers = mutableListOf<Transformer>()

    /**
     * Deobfuscator main
     * Usage: deobfuscator.jar <input jar> <output jar> [--test, -t]
     *
     * Input Jar: File path to the obfuscated gamepack jar.
     * Output Jar: File path to save the deobfuscated gamepack jar to.
     * --test, -t: Enable post-test client using the output jar.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        if(args.size < 2) throw IllegalArgumentException("Usage: deobfuscator.jar <input jar> <output jar> [--test, -t]")

        val inputFile = File(args[0])
        val outputFile = File(args[1])

        if(!inputFile.exists()) throw IllegalArgumentException("Input jar file: ${inputFile.absolutePath} does not exist.")
        if(outputFile.exists()) {
            outputFile.deleteRecursively()
        }

        this.inputFile = inputFile
        this.outputFile = outputFile

        if(args.size == 3 && (args[2] == "--test" || args[2] == "-t")) {
            runTestClient = true
        }

        run()
    }

    private fun init() {
        Logger.info("Running RSBox Deobfuscator.")
        transformers.clear()

        /*
         * Register bytecode transformers in order they will be run in.
         */
        register<RuntimeExceptionRemover>()
        register<DeadCodeRemover>()
        register<ControlFlowFixer>()
        register<Renamer>()
        register<ErrorConstructorRemover>()
        register<StaticFieldOwnerOptimizer>()
        register<StaticMethodOwnerOptimizer>()
        register<UnusedFieldRemover>()
        register<UnusedMethodRemover>()
        register<OpaquePredicateRemover>()
        register<RedundantGotoRemover>()
        register<StackFrameFixer>()
        register<MultiplierRemover>()
        register<ExprOrderFixer>()
        register<FieldSorter>()
        register<MethodSorter>()
    }

    private fun run() {
        /*
         * Initialize deobfuscator
         */
        this.init()

        /*
         * Load the input jar classes.
         */
        Logger.info("Loading classes from jar: ${inputFile.path}.")
        pool.clear()
        pool.readJar(inputFile)
        pool.allClasses.forEach {
            if(it.name.contains("/")) {
                pool.ignoreClass(it)
            }
        }
        pool.init()
        Logger.info("Loaded ${pool.classes.size} classes. (Ignored ${pool.ignoredClasses.size} classes).")

        /*
         * Run transformers.
         */
        Logger.info("Running ${transformers.size} bytecode transformers.")
        transformers.forEach { transformer ->
            Logger.info("Running ${transformer::class.simpleName}.")
            val start = System.currentTimeMillis()
            transformer.run(pool)
            val end = System.currentTimeMillis()
            Logger.info("Finished ${transformer::class.simpleName} in ${end - start}ms.")
        }
        Logger.info("Successfully ran all bytecode transformers.")

        /*
         * Export / save deobfuscated classes.
         */
        Logger.info("Saving deobfuscated classes to jar: ${outputFile.path}.")
        pool.writeJar(outputFile)

        /*
         * Run test client if enabled.
         */
        if(runTestClient) {
            TestClient(outputFile).start()
        }

        Logger.info("Successfully completed deobfuscation. Output can be found at: ${outputFile.absolutePath}")
    }

    private inline fun <reified T : Transformer> register() {
        transformers.add(T::class.createInstance())
    }
}