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

import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.updater.asm.isObject
import io.rsbox.toolbox.updater.asm.isPrimitive
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode

object MappingUtil {

    fun isMaybeEqual(a: Type?, b: Type?): Boolean {
        val typeA = a
        val typeB = b
        if(typeA == null && typeB == null) return true
        if(typeA == null || typeB == null) return false
        if(typeA.sort != typeB.sort) return false
        if(typeA.descriptor.startsWith("[") && typeB.descriptor.startsWith("[")) {
            if(typeA.dimensions != typeB.dimensions) return false
            if(!isMaybeEqual(typeA.elementType, typeB.elementType)) return false
        }
        if(typeA.isPrimitive() != typeB.isPrimitive()) return false
        return true
    }

    fun isMaybeEqual(descA: String?, descB: String?): Boolean {
        if(descA == null && descB == null) return true
        if(descA == null || descB == null) return false
        val typeA = Type.getMethodType(descA)
        val typeB = Type.getMethodType(descB)
        if(!isMaybeEqual(typeA.returnType, typeB.returnType)) return false
        if(typeA.argumentTypes.size != typeB.argumentTypes.size) return false
        for(i in typeA.argumentTypes.indices) {
            val argA = typeA.argumentTypes[i]
            val argB = typeB.argumentTypes[i]
            if(!isMaybeEqual(argA, argB)) return false
        }
        return true
    }

    fun isMaybeEqual(clsA: ClassNode?, clsB: ClassNode?): Boolean {
        if(clsA == null && clsB == null) return true
        if(clsA == null || clsB == null) return true
        if(clsA.access != clsB.access) return false
        if(!isMaybeEqual(clsA.type, clsB.type)) return false
        if(!isMaybeEqual(Type.getObjectType(clsA.superName),Type.getObjectType(clsB.superName))) return false
        if(clsA.parent != null && clsB.parent != null) {
            if(!isMaybeEqual(clsA.parent, clsB.parent)) return false
        }
        if(clsA.interfaces.size != clsB.interfaces.size) return false
        for(i in clsA.interfaces.indices) {
            val itA = clsA.interfaces[i]
            val itB = clsB.interfaces[i]
            if(!isMaybeEqual(Type.getObjectType(itA), Type.getObjectType(itB))) return false
        }
        if(clsA.interfaceClasses.size != clsB.interfaceClasses.size) return false
        for(i in clsA.interfaceClasses.indices) {
            val itA = clsA.interfaceClasses[i]
            val itB = clsB.interfaceClasses[i]
            if(!isMaybeEqual(itA, itB)) return false
        }
        return true
    }

    fun isMaybeEqual(methodA: MethodNode?, methodB: MethodNode?): Boolean {
        if(methodA == null && methodB == null) return true
        if(methodA == null || methodB == null) return false
        if(methodA.access != methodB.access) return false
        if(!isMaybeEqual(methodA.owner, methodB.owner)) return false
        if(!isMaybeEqual(methodA.desc, methodB.desc)) return false
        if(!isMaybeEqual(methodA.returnTypeClass, methodB.returnTypeClass)) return false
        if(methodA.argumentTypeClasses.size != methodB.argumentTypeClasses.size) return false
        for(i in methodA.argumentTypeClasses.indices) {
            val argA = methodA.argumentTypeClasses[i]
            val argB = methodB.argumentTypeClasses[i]
            if(!isMaybeEqual(argA, argB)) return false
        }
        return true
    }

    fun isMaybeEqual(fieldA: FieldNode?, fieldB: FieldNode?): Boolean {
        if(fieldA == null && fieldB == null) return true
        if(fieldA == null || fieldB == null) return false
        if(fieldA.access != fieldB.access) return false
        if(!isMaybeEqual(fieldA.owner, fieldB.owner)) return false
        if(!isMaybeEqual(fieldA.type, fieldB.type)) return false
        if(fieldA.value != null && fieldB.value != null) {
            if(fieldA.value != fieldB.value) return false
        }
        return true
    }

    fun String.isObfuscatedName(): Boolean {
        return (this.length <= 3 && this != "run" && this != "add") || listOf("class", "method", "field", "__").any { this.startsWith(it) }
    }
}