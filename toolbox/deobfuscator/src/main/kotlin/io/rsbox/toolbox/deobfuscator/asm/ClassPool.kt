package io.rsbox.toolbox.deobfuscator.asm

import org.objectweb.asm.tree.ClassNode

class ClassPool {

    private val classMap = hashMapOf<String, ClassNode>()
    private val ignoredClassMap = hashMapOf<String, ClassNode>()

    val classes get() = classMap.values.toList()
    val ignoredClasses get() = ignoredClassMap.values.toList()

    val allClasses get() = mutableListOf<ClassNode>().also {
        it.addAll(classes)
        it.addAll(ignoredClasses)
    }.toList()

    fun addClass(node: ClassNode, ignore: Boolean = false) {
        if(!ignore) {
            classMap[node.name] = node
        } else {
            ignoredClassMap[node.name] = node
        }
        node.ignored = ignore
    }

    fun removeClass(node: ClassNode) {
        classMap.remove(node.name)
        ignoredClassMap.remove(node.name)
    }

    fun ignoreClass(node: ClassNode) {
        removeClass(node)
        addClass(node, ignore = true)
    }

    fun unignoreClass(node: ClassNode) {
        removeClass(node)
        addClass(node, ignore = false)
    }

    fun getClass(name: String) = classMap[name]
    fun getIgnoredClass(name: String) = ignoredClassMap[name]
    fun findClass(name: String) = getClass(name) ?: getIgnoredClass(name)

    fun init() {
        allClasses.forEach { it.init(this) }
        allClasses.forEach { it.reset() }
        allClasses.forEach { it.build() }
    }

    fun clear() {
        classMap.clear()
        ignoredClassMap.clear()
    }
}