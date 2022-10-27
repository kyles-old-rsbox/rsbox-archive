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
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.oops.ThreadOop;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_Thread {
    private static final String THIS = "java/lang/Thread";

    public static ThreadOop getThreadOop(JavaWrapper thread) {
        return thread.get().getMetadata("oop");
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "currentThread", "()Ljava/lang/Thread;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return ThreadOop.forThread(Thread.currentThread()).getThread();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setPriority0", "(I)V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            getThreadOop(inst).setPriority(args[0].asInt());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "isAlive", "()Z", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newBoolean(getThreadOop(inst).isAlive());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "start0", "()V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            getThreadOop(inst).start();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "yield", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            ThreadOop.forThread(Thread.currentThread()).yield();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "sleep", "(J)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            try {
                Thread.sleep(args[0].asLong());
            } catch (InterruptedException e) {
                throw vm.newThrowable(VMSymbols.java_lang_InterruptedExecption);
            }
        }));
    }
}
