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
import io.rsbox.toolbox.asm.StackTraceHolder;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.util.List;

public class sun_reflect_Reflection {
    private static final String THIS = "sun/reflect/Reflection";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getCallerClass", "()Ljava/lang/Class;", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            List<StackTraceHolder> stacktrace = vm.getStacktrace();
            if (stacktrace.size() < 2) {
                return vm.getNull();
            }

            StackTraceHolder shouldBeReflection = stacktrace.get(0);
            if (!shouldBeReflection.getClassNode().name.equals(THIS) || !shouldBeReflection.getMethod().name.equals("getCallerClass") || !shouldBeReflection.getMethod().desc.equals("()Ljava/lang/Class;")) {
                throw vm.newThrowable(VMSymbols.java_lang_InternalError, "JVM_GetCallerClass must only be called from Reflection.getCallerClass");
            }
//            if (!shouldBeReflection.getMethod().isCallerSensitive()) {
//                throw new WrappedException(vm.newInternalError("CallerSensitive annotation expected at frame 0"));
//            }
            StackTraceHolder shouldBeCallerSensitive = stacktrace.get(1);
//            if (!shouldBeCallerSensitive.getMethod().isCallerSensitive()) {
//                throw new WrappedException(vm.newInternalError("CallerSensitive annotation expected at frame 0"));
//            }
            // todo is_ignored_by_security_walk
            return JavaClass.forName(vm, stacktrace.get(2).getClassNode().name).getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getCallerClass", "(I)Ljava/lang/Class;", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            List<StackTraceHolder> stacktrace = vm.getStacktrace();
            if (stacktrace.size() <= args[0].asInt()) {
                return vm.getNull();
            }
            return JavaClass.forName(vm, stacktrace.get(args[0].asInt()).getClassNode().name).getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getClassAccessFlags", "(Ljava/lang/Class;)I", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return JavaWrapper.createInteger(vm, java_lang_Class.getJavaClass(args[0]).getModifiers());
        }));
    }
}
