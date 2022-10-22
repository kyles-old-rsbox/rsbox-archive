package io.rsbox.toolbox.deobfuscator.transformer

import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.*
import org.objectweb.asm.commons.ClassRemapper
import org.objectweb.asm.commons.SimpleRemapper
import org.objectweb.asm.tree.ClassNode
import org.tinylog.kotlin.Logger

class Renamer : Transformer {

    private var classCount = 0
    private var methodCount = 0
    private var fieldCount = 0

    private val mappings = hashMapOf<String, String>()

    override fun run(pool: ClassPool) {
        generateMappings(pool)
        applyMappings(pool)

        Logger.info("Renamed $classCount classes.")
        Logger.info("Renamed $methodCount methods.")
        Logger.info("Renamed $fieldCount fields.")
    }

    private fun generateMappings(pool: ClassPool) {
        // Build an inheritance graph of the current class pool
        val inheritanceGraph = InheritanceGraph(pool)

        // Generate class mappings
        pool.classes.forEach classLoop@ { cls ->
            if(!cls.name.isObfuscatedName()) return@classLoop
            val newName = "class${++classCount}"
            mappings[cls.identifier] = newName
        }

        // Generate Method Mappings
        pool.classes.forEach { cls ->
            cls.methods.forEach methodLoop@ { method ->
                if(!method.name.isObfuscatedName() || mappings.containsKey(method.identifier)) return@methodLoop
                val newName = "method${++methodCount}"
                mappings[method.identifier] = newName
                inheritanceGraph[method.owner.name]!!.children.forEach { relative ->
                    mappings["${relative.name}.${method.name}${method.desc}"] = newName
                }
            }
        }

        // Generate Field Mappings
        pool.classes.forEach { cls ->
            cls.fields.forEach fieldLoop@ { field ->
                if(!field.name.isObfuscatedName() || mappings.containsKey(field.identifier)) return@fieldLoop
                val newName = "field${++fieldCount}"
                mappings[field.identifier] = newName
                inheritanceGraph[field.owner.name]!!.children.forEach { relative ->
                    mappings["${relative.name}.${field.name}"] = newName
                }
            }
        }
    }

    private fun applyMappings(pool: ClassPool) {
        val classes = mutableListOf<ClassNode>()
        val remapper = SimpleRemapper(mappings)
        pool.allClasses.forEach { cls ->
            val node = ClassNode()
            cls.accept(ClassRemapper(node, remapper))
            node.ignored = cls.ignored
            classes.add(node)
        }
        pool.clear()
        classes.forEach { pool.addClass(it, it.ignored) }
        pool.init()
    }

    private fun String.isObfuscatedName(): Boolean {
        return this.length <= 2 || (this.length == 3 && listOf("aa", "ab", "ac", "ad", "ae", "af", "ag").any { this.startsWith(it) })
    }
}