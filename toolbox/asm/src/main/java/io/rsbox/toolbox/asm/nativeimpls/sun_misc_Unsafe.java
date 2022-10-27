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

package io.rsbox.toolbox.asm.nativeimpls;

import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;

public class sun_misc_Unsafe {
    private static final String THIS = "sun/misc/Unsafe";

    private static JavaWrapper getFieldOffset(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean shouldBeStatic) {
        JavaClass owner = java_lang_Class.getJavaClass(args[0].asObject().getField("clazz", "Ljava/lang/Class;"));
        int slot = args[0].asObject().getField("slot", "I").asInt();
        FieldNode fieldNode = owner.getClassNode().fields.get(slot);
        if (Modifier.isStatic(fieldNode.access) != shouldBeStatic) {
            throw context.getVM().newThrowable(VMSymbols.java_lang_IllegalArgumentException);
        }
        if (shouldBeStatic || args[0].getJavaClass() == context.getVM().getSystemDictionary().getJavaLangClass()) {
            // If the field is static (which means the base is an instanceof java/lang/Class)
            // or the field belongs to an instance of java/lang/Class
            // we need to determine the special offset
            long offset = args[0].asObject().getField("clazz", "Ljava/lang/Class;").asObject().getOffsetByField(fieldNode);
            return context.getVM().newLong(offset);
        }
//        System.out.println("Offset of field " + owner.getClassNode().name + " " + fieldNode.name + fieldNode.desc + " is " + owner.getOffsetByField(fieldNode));
        return context.getVM().newLong(owner.getOffsetByField(fieldNode));
    }

    private static JavaWrapper doGetObject(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean isVolatile) {
        long objectFieldOffset = args[1].asLong();
        if (!args[0].is(JavaValueType.ARRAY)) {
            JavaObject target = args[0].asObject();
            FieldNode targetField;
            JavaClass clazz = target.getJavaClass();
            if (clazz == context.getVM().getSystemDictionary().getJavaLangClass()) {
                targetField = target.getFieldByOffset(objectFieldOffset);
                if (Modifier.isStatic(targetField.access)) {
                    clazz = java_lang_Class.getJavaClass(target);
                }
            } else {
                targetField = clazz.getFieldByOffset(objectFieldOffset);
            }
//            System.out.println("Getting object " + target + " " + clazz.getClassNode().name + " " + targetField.name + " " + targetField.desc);
            return target.getField(targetField.name, targetField.desc);
        } else if (args[0].is(JavaValueType.ARRAY)) {
            JavaArray arr = (JavaArray) args[0].get();
            return arr.get((int) ((objectFieldOffset - 16) / 4));
        }
        throw new ExecutionException("Unsupported type" + args[0]);
    }

    private static void doSetObject(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean isVolatile) {
        long objectFieldOffset = args[1].asLong();
        if (!args[0].is(JavaValueType.ARRAY)) {
            JavaObject target = args[0].asObject();
            FieldNode targetField;
            JavaClass clazz = target.getJavaClass();
            if (clazz == context.getVM().getSystemDictionary().getJavaLangClass()) {
                targetField = target.getFieldByOffset(objectFieldOffset);
                if (Modifier.isStatic(targetField.access)) {
                    clazz = java_lang_Class.getJavaClass(target);
                }
            } else {
                targetField = clazz.getFieldByOffset(objectFieldOffset);
            }
            target.setField(targetField.name, targetField.desc, args[2]);
            return;
        } else if (args[0].is(JavaValueType.ARRAY)) {
            JavaArray arr = (JavaArray) args[0].get();
            arr.set((int) ((objectFieldOffset - 16) / 4), args[2]);
            return;
        }
        throw new ExecutionException("Unsupported type" + args[0]);
    }

    private static JavaWrapper doGetInt(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean isVolatile) {
        long objectFieldOffset = args[1].asLong();
        JavaObject target = args[0].asObject();
        FieldNode targetField;
        JavaClass clazz = target.getJavaClass();
        if (clazz == context.getVM().getSystemDictionary().getJavaLangClass()) {
            targetField = target.getFieldByOffset(objectFieldOffset);
            if (Modifier.isStatic(targetField.access)) {
                clazz = java_lang_Class.getJavaClass(target);
            }
        } else {
            targetField = clazz.getFieldByOffset(objectFieldOffset);
        }
//        System.out.println("Getting int " + target + " " + clazz.getClassNode().name + " " + targetField.name + " " + targetField.desc);
        if (!targetField.desc.equals("I")) {
            throw new ExecutionException("weird, field type wasn't int: " + clazz.getClassNode().name + " " + targetField.name + targetField.desc);
        }
        return target.getField(targetField.name, targetField.desc);
    }

    private static void doSetInt(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean isVolatile) {
        long objectFieldOffset = args[1].asLong();
        JavaObject target = args[0].asObject();
        FieldNode targetField;
        JavaClass clazz = target.getJavaClass();
        if (clazz == context.getVM().getSystemDictionary().getJavaLangClass()) {
            targetField = target.getFieldByOffset(objectFieldOffset);
            if (Modifier.isStatic(targetField.access)) {
                clazz = java_lang_Class.getJavaClass(target);
            }
        } else {
            targetField = clazz.getFieldByOffset(objectFieldOffset);
        }
        if (!targetField.desc.equals("I")) {
            throw new ExecutionException("weird, field type wasn't int: " + clazz.getClassNode().name + " " + targetField.name + targetField.desc);
        }
        target.setField(targetField.name, targetField.desc, args[2]);
    }

    private static void doSetBoolean(MethodExecution context, JavaWrapper inst, JavaWrapper[] args, boolean isVolatile) {
        long objectFieldOffset = args[1].asLong();
        JavaObject target = args[0].asObject();
        FieldNode targetField;
        JavaClass clazz = target.getJavaClass();
        if (clazz == context.getVM().getSystemDictionary().getJavaLangClass()) {
            targetField = target.getFieldByOffset(objectFieldOffset);
            if (Modifier.isStatic(targetField.access)) {
                clazz = java_lang_Class.getJavaClass(target);
            }
        } else {
            targetField = clazz.getFieldByOffset(objectFieldOffset);
        }
        if (!targetField.desc.equals("Z")) {
            throw new ExecutionException("weird, field type wasn't boolean: " + clazz.getClassNode().name + " " + targetField.name + targetField.desc);
        }
        target.setField(targetField.name, targetField.desc, args[2]);
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "staticFieldBase", "(Ljava/lang/reflect/Field;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass owner = java_lang_Class.getJavaClass(args[0].asObject().getField("clazz", "Ljava/lang/Class;"));
//            System.out.println("Static field base of " + args[0].asObject().toString() + " is " + owner);
            return owner.getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "staticFieldOffset", "(Ljava/lang/reflect/Field;)J", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return getFieldOffset(ctx, inst, args, true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "objectFieldOffset", "(Ljava/lang/reflect/Field;)J", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return getFieldOffset(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getObjectVolatile", "(Ljava/lang/Object;J)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return doGetObject(ctx, inst, args, true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "getObject", "(Ljava/lang/Object;J)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return doGetObject(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "putObjectVolatile", "(Ljava/lang/Object;JLjava/lang/Object;)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            doSetObject(ctx, inst, args, true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "putObject", "(Ljava/lang/Object;JLjava/lang/Object;)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            doSetObject(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getIntVolatile", "(Ljava/lang/Object;J)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return doGetInt(ctx, inst, args, true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "getInt", "(Ljava/lang/Object;J)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return doGetInt(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "putIntVolatile", "(Ljava/lang/Object;JI)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            doSetInt(ctx, inst, args, true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "putInt", "(Ljava/lang/Object;JI)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            doSetInt(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "putBoolean", "(Ljava/lang/Object;JZ)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            doSetBoolean(ctx, inst, args, false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "compareAndSwapObject", "(Ljava/lang/Object;JLjava/lang/Object;Ljava/lang/Object;)Z", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long objectFieldOffset = args[1].asLong();
            JavaWrapper expected = args[2];
            if (args[0].is(JavaValueType.ARRAY)) {
                JavaArray arr = (JavaArray) args[0].get();
                int index = (int) ((objectFieldOffset - 16) / 4);
                JavaWrapper actual = arr.get(index);
                if ((actual.is(JavaValueType.NULL) ? 0 : actual.asObject().getHashCode()) != (expected.is(JavaValueType.NULL) ? 0 : expected.asObject().getHashCode())) {
                    return vm.FALSE;
                } else {
                    arr.set(index, args[3]);
                    return vm.TRUE;
                }
            }
            JavaObject target = args[0].asObject();
            FieldNode targetField;
            JavaClass clazz = target.getJavaClass();
            if (clazz == vm.getSystemDictionary().getJavaLangClass()) {
                targetField = target.getFieldByOffset(objectFieldOffset);
                if (Modifier.isStatic(targetField.access)) {
                    clazz = java_lang_Class.getJavaClass(target);
                }
            } else {
                targetField = clazz.getFieldByOffset(objectFieldOffset);
            }
            JavaWrapper actual = target.getField(targetField.name, targetField.desc);
            if (actual != expected) {
//                System.out.println("CAS failed: " + expected + " " + actual + " " + targetField.name + " " + targetField.desc + " " + target + " " + clazz.getClassNode().name);
                return vm.FALSE;
            } else {
                target.setField(targetField.name, targetField.desc, args[3]);
                return vm.TRUE;
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "compareAndSwapInt", "(Ljava/lang/Object;JII)Z", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            int expected = args[2].asInt();
            long objectFieldOffset = args[1].asLong();
            JavaObject target = args[0].asObject();
            FieldNode targetField;
            JavaClass clazz = target.getJavaClass();
            if (clazz == vm.getSystemDictionary().getJavaLangClass()) {
                targetField = target.getFieldByOffset(objectFieldOffset);
                if (Modifier.isStatic(targetField.access)) {
                    clazz = java_lang_Class.getJavaClass(target);
                }
            } else {
                targetField = clazz.getFieldByOffset(objectFieldOffset);
            }
            if (!targetField.desc.equals("I")) {
                throw new ExecutionException("weird, field type wasn't int: " + clazz.getClassNode().name + " " + targetField.name + targetField.desc);
            }

            int actual = target.getField(targetField.name, targetField.desc).asInt();
            if (actual != expected) {
                return vm.FALSE;
            } else {
                target.setField(targetField.name, targetField.desc, args[3]);
                return vm.TRUE;
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "compareAndSwapLong", "(Ljava/lang/Object;JJJ)Z", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long expected = args[2].asLong();
            long objectFieldOffset = args[1].asLong();
            JavaObject target = args[0].asObject();
            FieldNode targetField;
            JavaClass clazz = target.getJavaClass();
            if (clazz == vm.getSystemDictionary().getJavaLangClass()) {
                targetField = target.getFieldByOffset(objectFieldOffset);
                if (Modifier.isStatic(targetField.access)) {
                    clazz = java_lang_Class.getJavaClass(target);
                }
            } else {
                targetField = clazz.getFieldByOffset(objectFieldOffset);
            }
            if (!targetField.desc.equals("J")) {
                throw new ExecutionException("weird, field type wasn't long: " + clazz.getClassNode().name + " " + targetField.name + targetField.desc);
            }

            long actual = target.getField(targetField.name, targetField.desc).asLong();
            if (actual != expected) {
                return vm.FALSE;
            } else {
                target.setField(targetField.name, targetField.desc, args[3]);
                return vm.TRUE;
            }
        }));

        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "ensureClassInitialized", "(Ljava/lang/Class;)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            vm.initialize(java_lang_Class.getJavaClass(args[0]));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "shouldBeInitialized", "(Ljava/lang/Class;)Z", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return java_lang_Class.asKlass(args[0]).shouldBeInitialized() ? vm.TRUE : vm.FALSE;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "defineAnonymousClass", "(Ljava/lang/Class;[B[Ljava/lang/Object;)Ljava/lang/Class;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            byte[] bytes = ArrayConversionHelper.convertByteArray(args[1].asArray());
            if (!args[2].is(JavaValueType.NULL) && args[2].asArray().length() > 0) {
                JavaArray arr = args[2].asArray();
                for (int i = 0; i < arr.length(); i++) {
                    if (!arr.get(i).is(JavaValueType.NULL)) {
                        // todo cp patching (asm??!?!?!)
//                        throw new ExecutionException("CP patches not supported yet: " + arr);
                    }
                }
            }
            ClassReader classReader = new ClassReader(bytes);
            ClassNode classNode = new ClassNode();
            classReader.accept(classNode, ClassReader.EXPAND_FRAMES);
            int i = 0;
            File out = new File("generated\\" + classNode.name.replaceAll("/", ".") + ".class");
            while (out.exists()) {
                out = new File("generated\\" + classNode.name.replaceAll("/", ".") + (i++) + ".class");
            }
            try {
                FileUtils.writeByteArrayToFile(out, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new JavaClass(vm, classNode, Type.getObjectType(classNode.name)).getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "defineClass", "(Ljava/lang/String;[BIILjava/lang/ClassLoader;Ljava/security/ProtectionDomain;)Ljava/lang/Class;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            byte[] bytes = ArrayConversionHelper.convertByteArray(args[1].asArray());
            ClassReader classReader = new ClassReader(bytes, args[2].asInt(), args[3].asInt());
            ClassNode classNode = new ClassNode();
            classReader.accept(classNode, ClassReader.EXPAND_FRAMES);
            int i = 0;
            File out = new File("generated\\" + classNode.name.replaceAll("/", ".") + ".class");
            while (out.exists()) {
                out = new File("generated\\" + classNode.name.replaceAll("/", ".") + (i++) + ".class");
            }
            try {
                FileUtils.writeByteArrayToFile(out, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            vm.registerClass(classReader, classNode);
            return new JavaClass(vm, classNode, Type.getObjectType(classNode.name)).getOop();
        }));

        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "arrayBaseOffset", "(Ljava/lang/Class;)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            // todo AHHHHHHHHHH
            return JavaWrapper.createInteger(vm, 16);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "arrayIndexScale", "(Ljava/lang/Class;)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            // todo AHHHHHHHHHH
            return JavaWrapper.createInteger(vm, 4);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "addressSize", "()I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            // todo AHHHHHHHHHH
            return JavaWrapper.createInteger(vm, 4);
        }));


        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "allocateMemory", "(J)J", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long size = args[0].asLong();
            long address = vm.getMemory().allocateMemory(size);
            return vm.newLong(address);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "putLong", "(JJ)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long address = args[0].asLong();
            long value = args[1].asLong();
            vm.getMemory().putLong(address, value);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "putChar", "(JC)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long address = args[0].asLong();
            char value = args[1].asChar();
            vm.getMemory().putChar(address, value);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "getLong", "(J)J", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long address = args[0].asLong();
            return vm.newLong(vm.getMemory().getLong(args[0].asLong()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/misc/Unsafe", "getByte", "(J)B", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long address = args[0].asLong();
            return vm.newByte(vm.getMemory().getByte(address));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "freeMemory", "(J)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long address = args[0].asLong();
            vm.getMemory().freeMemory(address);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "copyMemory", "(Ljava/lang/Object;JLjava/lang/Object;JJ)V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long srcAddr = args[1].asLong();
            long dstAddr = args[3].asLong();
            long len = args[4].asLong();
            boolean isSrcNull = args[0].is(JavaValueType.NULL);
            boolean isDstNull = args[2].is(JavaValueType.NULL);
            if (isSrcNull && isDstNull) {
                // copying raw offsets (note, offset could be address of object)
                vm.getMemory().copy(srcAddr, dstAddr, len);
            } else if (!isSrcNull && isDstNull) {
                if (!args[0].is(JavaValueType.ARRAY) || !args[0].asArray().getJavaClass().getComponentType().isPrimitive()) {
                    throw vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException); // copying from non-primitive arrays is not allowed
                }
                vm.getMemory().copy(args[0].asArray(), srcAddr - 16, dstAddr, len); // array base offset ugliness
            } else {
                throw new ExecutionException("Unsupported copy: " + isSrcNull + " " + isDstNull);
            }
        }));

        // Fence
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "loadFence", "()V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "storeFence", "()V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/misc/Unsafe", "fullFence", "()V", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
        }));
    }
}
