package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.collect.Multimap
import com.google.common.collect.MultimapBuilder
import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.asm.identifier
import io.rsbox.toolbox.deobfuscator.asm.isJdkMethod
import io.rsbox.toolbox.deobfuscator.asm.owner
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode
import org.tinylog.kotlin.Logger

class UnusedMethodRemover : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        val classNames = pool.allClasses.associateBy { it.name }
        val superClasses = MultimapBuilder.hashKeys().arrayListValues().build<ClassNode, String>()
        val subClasses = MultimapBuilder.hashKeys().arrayListValues().build<ClassNode, String>()

        pool.classes.forEach { cls ->
            cls.interfaces.forEach { superClasses.put(cls, it) }
            superClasses.put(cls, cls.superName)
        }

        superClasses.forEach { cls, superClassName ->
            if(classNames.containsKey(superClassName)) {
                subClasses.put(classNames.getValue(superClassName), cls.name)
            }
        }

        val usedMethods = pool.classes.asSequence().flatMap { it.methods.asSequence() }
            .flatMap { it.instructions.iterator().asSequence() }
            .mapNotNull { it as? MethodInsnNode }
            .map { "${it.owner}.${it.name}${it.desc}" }
            .toSet()

        val toRemove = hashSetOf<String>()
        pool.classes.forEach { cls ->
            for(method in cls.methods) {
                if(method.isUsed(usedMethods, superClasses, subClasses, classNames)) continue
                toRemove.add(method.identifier)
            }
        }

        pool.classes.forEach { cls ->
            val methods = cls.methods.iterator()
            while(methods.hasNext()) {
                val method = methods.next()
                if(method.identifier !in toRemove) continue
                methods.remove()
                count++
            }
        }

        Logger.info("Removed $count unused methods.")
    }

    private fun MethodNode.isUsed(usedMethods: Set<String>, superClasses: Multimap<ClassNode, String>, subClasses: Multimap<ClassNode, String>, classNames: Map<String, ClassNode>): Boolean {
        if(name == "<init>" || name == "<clinit>") return true
        if(usedMethods.contains(identifier)) return true
        var supers = superClasses[owner]
        while(supers.isNotEmpty()) {
            supers.forEach { cls ->
                if(isJdkMethod(cls, name, desc)) return true
                if(usedMethods.contains("$cls.$name$desc")) return true
            }
            supers = supers.filter { classNames.containsKey(it) }.flatMap { superClasses[classNames.getValue(it)] }
        }
        var subs = subClasses[owner]
        while(subs.isNotEmpty()) {
            subs.forEach { cls ->
                if(usedMethods.contains("$cls.$name$desc")) return true
            }
            subs = subs.flatMap { subClasses[classNames.getValue(it)] }
        }
        return false
    }
}