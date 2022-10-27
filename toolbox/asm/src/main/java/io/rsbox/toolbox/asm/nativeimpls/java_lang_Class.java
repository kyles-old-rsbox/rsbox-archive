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
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaField;
import io.rsbox.toolbox.asm.mirrors.JavaMethod;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class java_lang_Class {
    private static final String THIS = "java/lang/Class";
    private final VirtualMachine vm;

    public java_lang_Class(VirtualMachine vm) {
        this.vm = vm;
    }

    public static JavaClass asKlass(JavaWrapper wrapper) {
        if (wrapper == null) {
            return null;
        }
        return wrapper.asObject().getMetadata(VMSymbols.METADATA_KLASS);
    }

    public static boolean isInstance(VirtualMachine vm, JavaWrapper JavaWrapper) {
        return JavaWrapper != null && JavaWrapper.getJavaClass() == vm.getSystemDictionary().getJavaLangClass();
    }

    public static boolean isPrimitive(JavaWrapper JavaWrapper) {
        return asKlass(JavaWrapper).isPrimitive();
    }

//    public JavaClass findClassFromCaller(String name, boolean init, JavaWrapper loader, JavaWrapper caller) {
//        if (name.length() > VMSymbols.MAX_SYMBOL_LENGTH) {
//            throw vm.newThrowable(VMSymbols.java_lang_ClassNotFoundException, name);
//        }
//
//        JavaWrapper protectionDomain = null;
//        if (caller != null && loader != null) {
//            protectionDomain = asKlass(caller).getProtectionDomain();
//        }
//
//        return findClassFromClassLoader(name, init, new Handle(loader), new Handle(protectionDomain), false);
//    }
//
//    public JavaClass findClassFromClassLoader(String name, boolean init, Handle loader, Handle protectionDomain, boolean throwError) {
//        JavaClass klass = vm.getSystemDictionary().resolveOrFail(name, loader, protectionDomain, throwError);
//
//        // todo
//        if (init /* && klass.isInstance() */) {
//            vm.initialize(klass);
//        }
//
//        return klass;
//    }

    public static void printSignature(JavaWrapper javaClass, StringBuilder stringBuilder) {
        String name;
        boolean is_instance = false;
        if (isPrimitive(javaClass)) {
            name = asKlass(javaClass).internalGetType().getDescriptor();
        } else {
            is_instance = !asKlass(javaClass).isArray(); //todo this is bad
            name = asKlass(javaClass).internalGetType().getInternalName(); // todo this will also break on arrays
        }
        if (name == null) {
            stringBuilder.append("<null>");
            return;
        }
        if (is_instance) stringBuilder.append("L");
        stringBuilder.append(name);
        if (is_instance) stringBuilder.append(";");
    }

//    public boolean isAssignableFrom(JavaClass thisKlass, JavaClass otherKlass) {
//        if (otherKlass == null) {
//            throw new NullPointerException();
//        }
//        if (isPrimitive(thisKlass)) {
//            return other._type.getSort() == _type.getSort();
//        }
//        if (thisKlass.equals(otherKlass)) {
//            return true;
//        }
//
//        if (otherKlass.isArray()) {
//            if (thisKlass.isArray()) {
//                return thisKlass.getComponentType().isAssignableFrom(otherKlass.getComponentType());
//            } else if (thisKlass.isInterface()) {
//                return thisKlass.getName().equals("java.io.Serializable") || thisKlass.getName().equals("java.lang.Cloneable");
//            } else {
//                return thisKlass == _vm.getJavaLangObject();
//            }
//        } else if (otherKlass.isInterface()) {
//            if (thisKlass.isInterface()) {
//                if (thisKlass == otherKlass) {
//                    return true;
//                }
//
//                Deque<JavaClass> toCheck = new ArrayDeque<>();
//                toCheck.addAll(Arrays.asList(otherKlass.getInterfaces()));
//                while (!toCheck.isEmpty()) {
//                    JavaClass pop = toCheck.pop();
//                    if (pop != null) {
//                        if (pop == thisKlass) {
//                            return true;
//                        }
//                        toCheck.addAll(Arrays.asList(pop.getInterfaces()));
//                    }
//                }
//                return false;
//            } else {
//                return thisKlass == _vm.getJavaLangObject();
//            }
//        } else {
//            if (thisKlass.isInterface()) {
//                Deque<JavaClass> toCheck = new ArrayDeque<>();
//                if (otherKlass.getSuperclass() != null)
//                    toCheck.add(otherKlass.getSuperclass());
//                toCheck.addAll(Arrays.asList(otherKlass.getInterfaces()));
//                while (!toCheck.isEmpty()) {
//                    JavaClass pop = toCheck.pop();
//                    if (pop != null) {
//                        if (pop == thisKlass) {
//                            return true;
//                        }
//                        if (pop.getSuperclass() != null)
//                            toCheck.add(pop.getSuperclass());
//                        toCheck.addAll(Arrays.asList(pop.getInterfaces()));
//                    }
//                }
//                return false;
//            } else {
//                Deque<JavaClass> toCheck = new ArrayDeque<>();
//                if (otherKlass.getSuperclass() != null)
//                    toCheck.add(otherKlass.getSuperclass());
//                while (!toCheck.isEmpty()) {
//                    JavaClass pop = toCheck.pop();
//                    if (pop != null) {
//                        if (pop == thisKlass) {
//                            return true;
//                        }
//
//                        if (pop.getSuperclass() != null)
//                            toCheck.add(pop.getSuperclass());
//                    }
//                }
//                return false;
//            }
//        }
//    }

    public static String asSignature(JavaWrapper javaClass, boolean internIfNotFound) {
        if (isPrimitive(javaClass)) {
            return asKlass(javaClass).internalGetType().getDescriptor();
        } else {
            if (asKlass(javaClass).isArray()) {
                return asKlass(javaClass).getName();
            } else {
                // todo is anonymous
                return "L" + asKlass(javaClass).getClassNode().name + ";";
            }
        }
    }

    public static JavaClass getJavaClass(JavaWrapper classObj) {
        return classObj.asObject().getMetadata(VMSymbols.METADATA_KLASS);
    }

    public static JavaClass getJavaClass(JavaObject classObj) {
        return ((JavaObject) classObj).getMetadata(VMSymbols.METADATA_KLASS);
    }

    public static boolean verifyFixClassname(StringBuilder in) {
        boolean found = false;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c == '/') {
                found = true;
            } else if (c == '.') {
                in.setCharAt(i, '/');
            }
        }
        return found;
    }

    public static boolean verifyClassname(String in, boolean allowArrayClass) {
        // todo
        return true;
    }

    public void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, VMSymbols.java_lang_Class, VMSymbols.java_lang_Class_forName0_name, VMSymbols.java_lang_Class_forName0_sig, true, Cause.NONE, Effect.NONE, (ctx, instance, args) -> {
            JavaWrapper name = args[0];
            if (name == null) {
                throw vm.newThrowable(VMSymbols.java_lang_NullPointerException);
            }
            String originalName = vm.convertJavaObjectToString(name);
            StringBuilder mutableName = new StringBuilder(originalName);
            if (verifyFixClassname(mutableName)) {
                throw vm.newThrowable(VMSymbols.java_lang_ClassNotFoundException, originalName);
            }
            String finalName = mutableName.toString();
            if (!verifyClassname(finalName, true)) {
                throw vm.newThrowable(VMSymbols.java_lang_ClassNotFoundException, originalName);
            }

            JavaWrapper initialize = args[1];
            JavaWrapper classLoader = args[2];
            JavaWrapper caller = args[3];

//            return findClassFromCaller(finalName, initialize.asPrimitive().asBoolean(), classLoader, caller);


            // todo classloader and caller are still unused
            String lookupName = vm.convertJavaObjectToString(name);
            JavaClass klass = JavaClass.forName(vm, TypeHelper.getTypeByFQN(vm, lookupName));
            if (klass == null) {
                throw vm.newThrowable(VMSymbols.java_lang_ClassNotFoundException, lookupName);
            }

            if (initialize.asPrimitive().asBoolean()) {
                vm.initialize(klass);
            }
            return klass.getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isInstance", "(Ljava/lang/Object;)Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(args[0].get() instanceof JavaObject ? asKlass(inst).isAssignableFrom(args[0].getJavaClass()) : false);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isAssignableFrom", "(Ljava/lang/Class;)Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(asKlass(inst).isAssignableFrom(asKlass(args[0])));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isInterface", "()Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(asKlass(inst).isInterface());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isArray", "()Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(asKlass(inst).isArray());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isPrimitive", "()Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(asKlass(inst).isPrimitive());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getName0", "()Ljava/lang/String;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return vm.getStringInterned(asKlass(inst).getName());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getSuperclass", "()Ljava/lang/Class;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass superClass = asKlass(inst).getSuperclass();
            return superClass == null ? vm.getNull() : superClass.getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getInterfaces0", "()[Ljava/lang/Class;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass[] interfaces = asKlass(inst).getInterfaces();
            JavaWrapper[] converted = new JavaWrapper[interfaces.length];
            for (int i = 0; i < interfaces.length; i++) {
                converted[i] = interfaces[i].getOop();
            }
            return JavaWrapper.createArray(JavaClass.forName(vm, "[Ljava/lang/Class;"), converted);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getComponentType", "()Ljava/lang/Class;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return asKlass(inst).getComponentType().getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getModifiers", "()I", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return JavaWrapper.createInteger(vm, asKlass(inst).getModifiers());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getSigners", "()[Ljava/lang/Object;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            throw new ExecutionException("Unsupported");
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setSigners", "([Ljava/lang/Object;)V", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            throw new ExecutionException("Unsupported");
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getEnclosingMethod0", "()[Ljava/lang/Object;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            Object[] enclosingMethodInfo = asKlass(inst).getEnclosingMethod0();
            if (enclosingMethodInfo == null) {
                return vm.getNull();
            }
            JavaWrapper[] array = new JavaWrapper[3];
            array[0] = ((JavaClass) enclosingMethodInfo[0]).getOop();
            array[1] = vm.getString((String) enclosingMethodInfo[1]);
            array[2] = vm.getString((String) enclosingMethodInfo[2]);
            return JavaWrapper.createArray(vm.getSystemDictionary().getJavaLangObject(), array);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getDeclaringClass0", "()Ljava/lang/Class;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = asKlass(inst);
            return clazz.getDeclaringClass() == null ? vm.getNull() : clazz.getDeclaringClass().getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getProtectionDomain0", "()Ljava/security/ProtectionDomain;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            if (inst.is(JavaValueType.NULL)) {
                throw vm.newThrowable(VMSymbols.java_lang_NullPointerException);
            }
            if (asKlass(inst).isPrimitive()) {
                return vm.getNull();
            }

            // Todo actually do classloaders properly and protectiondomains properly
            JavaWrapper url = vm.newInstance(JavaClass.forName(vm, "Ljava/net/URL;"), "(Ljava/lang/String;)V", vm.getString("file:/currentjar.zip"));
            JavaWrapper codeSource = vm.newInstance(JavaClass.forName(vm, "Ljava/security/CodeSource;"), "(Ljava/net/URL;[Ljava/security/CodeSigner;)V", url, vm.getNull());
            JavaWrapper protectionDomain = vm.newInstance(JavaClass.forName(vm, "Ljava/security/ProtectionDomain;"), "(Ljava/security/CodeSource;Ljava/security/PermissionCollection;Ljava/lang/ClassLoader;[Ljava/security/Principal;)V", codeSource, vm.getNull(), vm.getNull(), vm.getNull());
            return protectionDomain;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return JavaClass.getPrimitiveClass(vm, vm.convertJavaObjectToString(args[0])).getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getGenericSignature0", "()Ljava/lang/String;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            throw new ExecutionException("Unsupported");
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getRawAnnotations", "()[B", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            throw new ExecutionException("Unsupported");
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getRawTypeAnnotations", "()[B", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            throw new ExecutionException("Unsupported");
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getConstantPool", "()Lsun/reflect/ConstantPool;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaWrapper constantPool = vm.newInstance(JavaClass.forName(vm, "sun/reflect/ConstantPool"), "()V");
            sun_reflect_ConstantPool.setJavaClass(constantPool, asKlass(inst));
            return constantPool;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getDeclaredFields0", "(Z)[Ljava/lang/reflect/Field;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = asKlass(inst);
            List<JavaField> fields = clazz.getDeclaredFields0(args[0].asPrimitive().asBoolean());
            JavaArray array = new JavaArray(JavaClass.forName(vm, TypeHelper.getTypeByDescriptor("[Ljava/lang/reflect/Field;")), new JavaWrapper[fields.size()]);
            for (int i = 0; i < fields.size(); i++) {
                array.set(i, fields.get(i).getOop());
            }
            return JavaWrapper.wrap(array);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getDeclaredMethods0", "(Z)[Ljava/lang/reflect/Method;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = asKlass(inst);
            List<JavaMethod> methods = clazz.getDeclaredMethods0(args[0].asPrimitive().asBoolean());
            JavaArray array = new JavaArray(JavaClass.forName(vm, TypeHelper.getTypeByDescriptor("[Ljava/lang/reflect/Method;")), new JavaWrapper[methods.size()]);
            for (int i = 0; i < methods.size(); i++) {
                array.set(i, methods.get(i).getOop());
            }
            return JavaWrapper.wrap(array);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getDeclaredConstructors0", "(Z)[Ljava/lang/reflect/Constructor;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = inst.get().getMetadata(VMSymbols.METADATA_KLASS);
            List<MethodNode> fields = clazz.getDeclaredConstructors0(args[0].asPrimitive().asBoolean());
            JavaArray array = new JavaArray(JavaClass.forName(vm, TypeHelper.getTypeByDescriptor("[Ljava/lang/reflect/Constructor;")), new JavaWrapper[fields.size()]);
            for (int i = 0; i < fields.size(); i++) {
                MethodNode ctor = fields.get(i);
                Type[] argumentTypes = Type.getArgumentTypes(ctor.desc);
                JavaArray parameterTypes = new JavaArray(JavaClass.forName(vm, TypeHelper.getTypeByDescriptor("[Ljava/lang/Class;")), new JavaWrapper[argumentTypes.length]);
                for (int j = 0; j < argumentTypes.length; j++) {
                    parameterTypes.set(j, JavaClass.forName(vm, argumentTypes[j]).getOop());
                }

                JavaArray checkedExceptions = new JavaArray(JavaClass.forName(vm, TypeHelper.getTypeByDescriptor("[Ljava/lang/Class;")), new JavaWrapper[ctor.exceptions == null ? 0 : ctor.exceptions.size()]);
                if (ctor.exceptions != null) {
                    for (int j = 0; j < ctor.exceptions.size(); j++) {
                        checkedExceptions.set(j, JavaClass.forName(vm, TypeHelper.parseType(vm, ctor.exceptions.get(j))).getOop());
                    }
                }

                JavaClass fieldClazz = JavaClass.forName(clazz.getVM(), TypeHelper.getTypeByDescriptor("Ljava/lang/reflect/Constructor;"));
                JavaWrapper JavaWrapperField = clazz.getVM().newInstance(fieldClazz, "(Ljava/lang/Class;[Ljava/lang/Class;[Ljava/lang/Class;IILjava/lang/String;[B[B)V",
                        clazz.getOop(),
                        JavaWrapper.wrap(parameterTypes),
                        JavaWrapper.wrap(checkedExceptions),
                        JavaWrapper.createInteger(clazz.getVM(), ctor.access),
                        JavaWrapper.createInteger(clazz.getVM(), clazz.getClassNode().methods.indexOf(ctor)),
                        clazz.getVM().getString(ctor.signature == null ? "" : ctor.signature),
                        ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0]),
                        ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0])
                );

                array.set(i, JavaWrapper.wrap(JavaWrapperField.get()));
            }
            return JavaWrapper.wrap(array);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getDeclaredClasses0", "()[Ljava/lang/reflect/Method;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = asKlass(inst);
            JavaClass[] declaredClasses = clazz.getDeclaredClasses();
            JavaWrapper[] array = new JavaWrapper[declaredClasses.length];
            for (int i = 0; i < declaredClasses.length; i++) {
                array[i] = declaredClasses[i].getOop();
            }
            return JavaWrapper.createArray(JavaClass.forName(vm, "[Ljava/lang/reflect/Method;"), array);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "desiredAssertionStatus0", "(Ljava/lang/Class;)Z", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            // todo allow assertions?
            return vm.newBoolean(false);
        }));
    }
}
