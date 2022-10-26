package io.rsbox.toolbox.updater

import io.rsbox.toolbox.asm.interfaceClasses
import io.rsbox.toolbox.asm.owner
import io.rsbox.toolbox.asm.parent
import io.rsbox.toolbox.asm.type
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.reflect.Modifier

object MappingUtil {

    fun isPotentiallyEqual(a: ClassNode?, b: ClassNode?): Boolean {
        if(a == null && b == null) return true
        if(a == null || b == null) return false
        if(a.parent != null || b.parent != null) {
            if(!isPotentiallyEqual(a.parent, b.parent)) return false
        } else {
            if(a.superName != b.superName) return false
        }
        if(a.interfaceClasses.size != b.interfaceClasses.size) return false
        return true
    }

    fun isPotentiallyEqual(a: MethodNode, b: MethodNode): Boolean {
        if(!isMethodDescPotentiallyEqual(a.desc, b.desc)) return false
        if(Modifier.isStatic(a.access) != Modifier.isStatic(b.access)) return false
        return true
    }

    fun isPotentiallyEqual(a: FieldNode?, b: FieldNode?): Boolean {
        if(a == null && b == null) return true
        if(a == null || b == null) return false
        if(Modifier.isStatic(a.access) != Modifier.isStatic(b.access)) return false
        if(!isTypePotentiallyEqual(a.type, b.type)) return false
        return true
    }

    fun isMethodDescPotentiallyEqual(a: String, b: String): Boolean {
        val typeA = Type.getMethodType(a)
        val typeB = Type.getMethodType(b)
        if(typeA.argumentTypes.size != typeB.argumentTypes.size) return false
        if(!isTypePotentiallyEqual(typeA.returnType, typeB.returnType)) return false
        for(i in 0 until typeA.argumentTypes.size) {
            val argA = typeA.argumentTypes[i]
            val argB = typeB.argumentTypes[i]
            if(!isTypePotentiallyEqual(argA, argB)) return false
        }
        return true
    }

    fun isTypePotentiallyEqual(a: Type, b: Type): Boolean {
        if(a.sort == Type.ARRAY && b.sort == Type.ARRAY) {
            if(a.dimensions != b.dimensions) return false
            if(a.elementType.sort != b.elementType.sort) return false
        }
        if(a.sort != b.sort) return false
        return true
    }

    fun <T> compareLists(listA: List<T>, listB: List<T>, comparator: (a: T, b: T) -> Int): Double {
        val sizeA = listA.size
        val sizeB = listB.size

        if(sizeA == 0 && sizeB == 0) return 1.0
        if(sizeA == 0 || sizeB == 0) return 0.0

        if(sizeA == sizeB) {
            var match = true
            for(i in 0 until sizeA) {
                val entryA = listA[i]
                val entryB = listB[i]
                if(comparator(entryA, entryB) != 0) {
                    match = false
                    break
                }
            }
            if(match) return 1.0
        }

        val v0 = IntArray(sizeB + 1)
        val v1 = IntArray(sizeB + 1)

        for(i in 1 until v0.size) {
            v0[i] = i * 2
        }

        for(i in 0 until sizeA) {
            v1[0] = (i + 1) * 2

            for(j in 0 until sizeB) {
                val entryA = listA[i]
                val entryB = listB[j]
                val cost = comparator(entryA, entryB)
                v1[j + 1] = min(min(v1[j] + 2, v0[j + 1] + 2), v0[j] + cost)
            }

            for(j in v0.indices) {
                v0[j] = v1[j]
            }
        }

        val distance = v1[sizeB]
        val upperBound = max(sizeA, sizeB) * 2

        return 1.0 - (distance.toDouble() / upperBound.toDouble())
    }
}