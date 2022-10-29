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

package io.rsbox.toolbox.deobfuscator

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.asm.tree.ClassPool
import io.rsbox.toolbox.asm.tree.owner
import io.rsbox.toolbox.deobfuscator.asm.*
import io.rsbox.toolbox.deobfuscator.transformer.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.coley.analysis.util.InheritanceGraph
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger
import java.io.File
import java.util.jar.JarEntry
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
        register<LocalVariableFixer>()
        register<StackFrameFixer>()
        register<ExprOrderOptimizer>()
        register<MultiplierRemover>()
        register<TempMultiplierRemover>()
        register<ScriptInterpreterOptimizer>()
        register<FieldSorter>()
        register<MethodSorter>()
        register<GetPathFixer>()
        register<ControlFlowFixer>()
        register<StackFrameFixer>()
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

        var clsIdx = 0
        val classIdxMap = hashMapOf<String, Int>()
        pool.readJar(inputFile) { _, entry ->
            if(entry.name.endsWith(".class") && !entry.name.contains("bouncycastle") && !entry.name.contains("json")) {
                classIdxMap[entry.name.replace(".class", "").replace(".", "/")] = clsIdx++
            }
        }

        pool.allClasses.forEach {
            if(it.name.contains("bouncycastle") || it.name.contains("json")) {
                pool.ignoreClass(it)
            }
        }
        pool.init()

        val graph = InheritanceGraph()
        graph.addClasspath()
        graph.addModulePath()
        pool.allClasses.forEach { cls ->
            graph.add(cls.name, cls.interfaces.plus(cls.superName))
        }
        pool.inheritanceGraph = graph

        Logger.info("Loaded ${pool.classes.size} classes. (Ignored ${pool.ignoredClasses.size} classes).")

        /*
         * Initialize classes obfuscated initial info.
         */
        pool.allClasses.forEach { cls ->
            cls.obfName = cls.name
            cls.jarIndex = classIdxMap[cls.name] ?: -1

            cls.methods.forEach { method ->
                method.obfOwner = cls.name
                method.obfName = method.name
                method.obfDesc = method.desc
            }

            cls.fields.forEach { field ->
                field.obfOwner = cls.name
                field.obfName = field.name
                field.obfDesc = field.desc
            }
        }

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
         * Set all the final obfuscated infos and prepare to write them
         * inside the output jar file.
         */
        val classInfos = mutableListOf<ClassObfuscatedInfo>()
        val methodInfos = mutableListOf<MethodObfuscatedInfo>()
        val fieldInfos = mutableListOf<FieldObfuscatedInfo>()

        pool.allClasses.forEach { cls ->
            cls.obfInfo = ClassObfuscatedInfo(
                name = cls.name,
                obfName = cls.obfName,
                jarIndex = cls.jarIndex ?: -1
            ).also { classInfos.add(it) }

            cls.methods.forEach { method ->
                method.obfInfo = MethodObfuscatedInfo(
                    owner = method.owner.name,
                    name = method.name,
                    desc = method.desc,
                    obfOwner = method.obfOwner,
                    obfName = method.obfName,
                    obfDesc = method.obfDesc,
                    opaque = method.opaque
                ).also { methodInfos.add(it) }
            }

            cls.fields.forEach { field ->
                field.obfInfo = FieldObfuscatedInfo(
                    owner = field.owner.name,
                    name = field.name,
                    desc = field.desc,
                    obfOwner = field.obfOwner,
                    obfName = field.obfName,
                    obfDesc = field.obfDesc
                ).also { fieldInfos.add(it) }
            }
        }

        val obfInfoJson = ObfuscatedInfo(
            classes = classInfos,
            methods = methodInfos,
            fields = fieldInfos
        ).let { Json.encodeToString(it) }

        /*
         * Export / save deobfuscated classes.
         */
        Logger.info("Saving deobfuscated classes to jar: ${outputFile.path}.")
        pool.writeJar(outputFile) { jos ->
            /*
             * Include the obfuscated info json data as a resource in
             * the output jar.
             */
            jos.putNextEntry(JarEntry("META-INF/obf-info.json"))
            jos.write(obfInfoJson.toByteArray())
            jos.closeEntry()
        }

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

    fun updateObfInfo(oldClass: ClassNode, newClass: ClassNode) {
        newClass.obfName = oldClass.obfName ?: oldClass.name
        newClass.jarIndex = oldClass.jarIndex
    }

    fun updateObfInfo(oldMethod: MethodNode, newMethod: MethodNode) {
        newMethod.obfOwner = oldMethod.obfOwner
        newMethod.obfName = oldMethod.obfName
        newMethod.obfDesc = oldMethod.obfDesc
        newMethod.opaque = oldMethod.opaque
    }

    fun updateObfInfo(oldField: FieldNode, newField: FieldNode) {
        newField.obfOwner = oldField.obfOwner
        newField.obfName = oldField.obfName
        newField.obfDesc = oldField.obfDesc
    }
}