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

package io.rsbox.toolbox.asm.internals;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaMethod;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SystemDictionary {
    private final Map<Pair<VMSymbols.VMIntrinsics, String>, JavaMethod> invokeMethodTable = new HashMap<>();
    private final Lock systemDictionaryLock = new ReentrantLock();
    private VirtualMachine vm;
    private JavaClass java_lang_Object;
    private JavaClass java_lang_Throwable;
    private JavaClass java_lang_Error;
    private JavaClass java_lang_String;
    private JavaClass java_lang_Cloneable;
    private JavaClass java_lang_System;
    private JavaClass java_lang_ThreadGroup;
    private JavaClass java_lang_Thread;
    private JavaClass java_lang_Class;
    private JavaClass java_lang_ClassLoader;
    private JavaClass java_lang_ref_Finalizer;
    private JavaClass java_util_Properties;
    private JavaClass java_lang_invoke_MethodHandleNatives;
    private JavaClass java_lang_invoke_MethodHandle;
    private JavaClass java_lang_invoke_MemberName;
    private JavaClass java_lang_invoke_MethodType;
    private JavaClass java_lang_reflect_Field;
    private JavaClass java_lang_reflect_Method;
    private JavaClass java_lang_reflect_Constructor;
    private JavaClass java_lang_Boolean;
    private JavaClass java_lang_Character;
    private JavaClass java_lang_Byte;
    private JavaClass java_lang_Short;
    private JavaClass java_lang_Integer;
    private JavaClass java_lang_Float;
    private JavaClass java_lang_Long;
    private JavaClass java_lang_Double;

    public SystemDictionary(VirtualMachine vm) {
        this.vm = vm;
        loadClasses();
    }

    public MethodHandle findMethodHandleIntrinsic(VMSymbols.VMIntrinsics id, String signature) {
        Pair<VMSymbols.VMIntrinsics, String> pair = Pair.of(id, signature);
        JavaMethod method = invokeMethodTable.get(pair);
        if (method == null) {
            method = JavaMethod.makeMethodHandleIntrinsic(vm, id, signature);
        }

        systemDictionaryLock.lock();
        try {
            JavaMethod innerMethod = invokeMethodTable.get(pair);
            if (innerMethod == null) {
                invokeMethodTable.put(pair, method);
            } else {
                method = innerMethod;
            }
        } finally {
            systemDictionaryLock.unlock();
        }

        return new MethodHandle(method);
    }

    public JavaClass getJavaLangInvokeMethodType() {
        return java_lang_invoke_MethodType;
    }

    public JavaClass getJavaLangReflectField() {
        return java_lang_reflect_Field;
    }

    public JavaClass getJavaLangReflectConstructor() {
        return java_lang_reflect_Constructor;
    }

    public JavaClass getJavaLangReflectMethod() {
        return java_lang_reflect_Method;
    }

    private void loadClasses() {
        java_lang_Object = JavaClass.forName(vm, "java/lang/Object");
        java_lang_Throwable = JavaClass.forName(vm, "java/lang/Throwable");
        java_lang_Error = JavaClass.forName(vm, "java/lang/Error");
        java_lang_String = JavaClass.forName(vm, "java/lang/String");
        java_lang_System = JavaClass.forName(vm, "java/lang/System");
        java_lang_Cloneable = JavaClass.forName(vm, "java/lang/Cloneable");
        java_lang_ThreadGroup = JavaClass.forName(vm, "java/lang/ThreadGroup");
        java_lang_Thread = JavaClass.forName(vm, "java/lang/Thread");
        java_lang_Class = JavaClass.forName(vm, "java/lang/Class");
        java_lang_ClassLoader = JavaClass.forName(vm, "java/lang/ClassLoader");
        java_lang_reflect_Method = JavaClass.forName(vm, "java/lang/reflect/Method");
        java_lang_reflect_Field = JavaClass.forName(vm, "java/lang/reflect/Field");
        java_lang_reflect_Constructor = JavaClass.forName(vm, "java/lang/reflect/Constructor");
        java_lang_ref_Finalizer = JavaClass.forName(vm, "java/lang/ref/Finalizer");
        java_util_Properties = JavaClass.forName(vm, "java/util/Properties");
        java_lang_invoke_MethodHandleNatives = JavaClass.forName(vm, "java/lang/invoke/MethodHandleNatives");
        java_lang_invoke_MethodHandle = JavaClass.forName(vm, "java/lang/invoke/MethodHandle");
        java_lang_invoke_MethodType = JavaClass.forName(vm, "java/lang/invoke/MethodType");
        java_lang_Boolean = JavaClass.forName(vm, "java/lang/Boolean");
        java_lang_Character = JavaClass.forName(vm, "java/lang/Character");
        java_lang_Byte = JavaClass.forName(vm, "java/lang/Byte");
        java_lang_Short = JavaClass.forName(vm, "java/lang/Short");
        java_lang_Integer = JavaClass.forName(vm, "java/lang/Integer");
        java_lang_Float = JavaClass.forName(vm, "java/lang/Float");
        java_lang_Long = JavaClass.forName(vm, "java/lang/Long");
        java_lang_Double = JavaClass.forName(vm, "java/lang/Double");
    }

    public JavaClass getJavaLangString() {
        return java_lang_String;
    }

    public JavaClass getJavalangCloneable() {
        return java_lang_Cloneable;
    }

    public JavaClass getJavaLangSystem() {
        return java_lang_System;
    }

    public JavaClass getJavaLangObject() {
        return java_lang_Object;
    }

    public JavaClass getJavaLangClass() {
        return java_lang_Class;
    }

    public JavaClass getJavaUtilProperties() {
        return java_util_Properties;
    }

    public JavaClass getJavaLangThrowable() {
        return java_lang_Throwable;
    }

    public JavaClass getJavaLangInvokeMethodHandleNatives() {
        return java_lang_invoke_MethodHandleNatives;
    }

    public JavaClass getJavaLangInvokeMethodHandle() {
        return java_lang_invoke_MethodHandle;
    }

    public JavaClass getJavaLangThreadGroup() {
        return java_lang_ThreadGroup;
    }

    public JavaClass getJavaLangThread() {
        return java_lang_Thread;
    }

    public JavaClass getJavaLangRefFinalizer() {
        return java_lang_ref_Finalizer;
    }

    public JavaClass getJavaLangClassLoader() {
        return java_lang_ClassLoader;
    }

    public JavaClass getJavaLangError() {
        return java_lang_Error;
    }

    public JavaClass getJavaLangBoolean() {
        return java_lang_Boolean;
    }

    public JavaClass getJavaLangCharacter() {
        return java_lang_Character;
    }

    public JavaClass getJavaLangByte() {
        return java_lang_Byte;
    }

    public JavaClass getJavaLangShort() {
        return java_lang_Short;
    }

    public JavaClass getJavaLangInteger() {
        return java_lang_Integer;
    }

    public JavaClass getJavaLangFloat() {
        return java_lang_Float;
    }

    public JavaClass getJavaLangLong() {
        return java_lang_Long;
    }

    public JavaClass getJavaLangDouble() {
        return java_lang_Double;
    }

    public JavaClass getSunReflectDelegatingClassLoader() {
        return null;
    }
}
