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
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.ClassLoaderData;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_ClassLoader {
    private static final String THIS = "java/lang/ClassLoader";

    private final VirtualMachine _vm;

    public java_lang_ClassLoader(VirtualMachine virtualMachine) {
        _vm = virtualMachine;
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "findBuiltinLib", "(Ljava/lang/String;)Ljava/lang/String;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            JavaWrapper arg0 = args[0];
            return arg0;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "findLoadedClass0", "(Ljava/lang/String;)Ljava/lang/Class;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            JavaClass clazz = JavaClass.forName(vm, TypeHelper.getTypeByFQN(vm, vm.convertJavaObjectToString(args[0])));
            if (clazz == null) {
                System.out.println("[ClassLoader] Could not find class " + vm.convertJavaObjectToString(args[0]));
                return vm.getNull();
            }
            return clazz.getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "findBootstrapClass", "(Ljava/lang/String;)Ljava/lang/Class;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo eventually classloaders
            JavaClass clazz = JavaClass.forName(vm, TypeHelper.getTypeByFQN(vm, vm.convertJavaObjectToString(args[0])));
            if (clazz == null) {
                System.out.println("[ClassLoader] Could not find class " + vm.convertJavaObjectToString(args[0]));
                return vm.getNull();
            }
            return clazz.getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "java/lang/ClassLoader$NativeLibrary", "load", "(Ljava/lang/String;Z)V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            System.out.println("[ClassLoader] An attempt was made to load the library " + vm.convertJavaObjectToString(args[0]));
            inst.asObject().setField("loaded", "Z", vm.newBoolean(true));
            return;
        }));
    }


    public JavaWrapper nonReflectionClassLoader(JavaWrapper classLoader) {
        if (classLoader != null) {
            if (classLoader.getJavaClass().isAssignableFrom(_vm.getSystemDictionary().getSunReflectDelegatingClassLoader())) {

            }
        }
        return null;
    }

    public ClassLoaderData loaderData(JavaWrapper oop) {
        return oop.asObject().getMetadata(VMSymbols.METADATA_LOADER_DATA);
    }

    public boolean parallelCapable(JavaWrapper oop) {
        return oop.asObject().getField(VMSymbols.java_lang_ClassLoader_parallelLockMap_name, VMSymbols.java_lang_ClassLoader_parallelLockMap_sig) != null;
    }
}