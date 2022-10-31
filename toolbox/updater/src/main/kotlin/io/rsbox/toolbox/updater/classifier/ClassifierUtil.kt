package io.rsbox.toolbox.updater.classifier

import io.rsbox.toolbox.asm.tree.*
import io.rsbox.toolbox.updater.asm.hasMatch
import io.rsbox.toolbox.updater.asm.match
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.lang.reflect.Modifier

object ClassifierUtil {

    fun String.isObfuscatedName(): Boolean {
        return (this.length <= 3 && this != "run" && this != "add") || listOf("class", "method", "field", "__").any { this.startsWith(it) }
    }

    fun isMaybeEqual(a: Type, b: Type): Boolean {
        if(a.sort != b.sort) return false
        if(a.sort == Type.ARRAY && b.sort == Type.ARRAY) {
            if(!isMaybeEqual(a.elementType, b.elementType)) return false
        }
        return true
    }

    fun isMaybeEqual(a: ClassNode?, b: ClassNode?): Boolean {
        if(a == null && b == null) return true
        if(a == null || b == null) return false
        if(a == b) return true
        if(a.hasMatch()) return a.match == b
        if(b.hasMatch()) return b.match == a
        if(!isMaybeEqual(a.type, b.type)) return false
        return true
    }

    fun isMaybeEqual(a: MethodNode, b: MethodNode): Boolean {
        if(a == b) return true
        if(a.hasMatch()) return a.match == b
        if(b.hasMatch()) return b.match == a
        if(!Modifier.isStatic(a.access) && !Modifier.isStatic(b.access)) {
            if(!isMaybeEqual(a.owner, b.owner)) return false
        }
        if(!isMaybeEqual(a.type.returnType, b.type.returnType)) return false
        if(a.type.argumentTypes.size != b.type.argumentTypes.size) return false
        return true
    }

    fun isMaybeEqual(a: FieldNode?, b: FieldNode?): Boolean {
        if(a == null && b == null) return true
        if(a == null || b == null) return false
        if(a.hasMatch()) return a.match == b
        if(b.hasMatch()) return b.match == a
        if(!Modifier.isStatic(a.access) && !Modifier.isStatic(b.access)) {
            if(!isMaybeEqual(a.owner, b.owner)) return false
        }
        if(!isMaybeEqual(a.type, b.type)) return false
        return true
    }

    fun <T> classifier(score: (from: T, to: T) -> Double): Classifier<T> {
        return object : Classifier<T> {
            override var name = ""
            override var weight = 0.0
            override fun score(from: T, to: T): Double {
                return score(from, to)
            }
        }
    }
}