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
import io.rsbox.toolbox.asm.hooks.HookedMethod;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.oops.ThreadOop;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.*;

import java.util.concurrent.TimeUnit;

public class java_lang_Object {
    private static final String THIS = "java/lang/Object";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getClass", "()Ljava/lang/Class;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return inst.getJavaClass().getOop();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "hashCode", "()I", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newInt(inst.asObject().getHashCode());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "clone", "()Ljava/lang/Object;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            if (!inst.getJavaClass().isArray()) {
                if (!vm.getSystemDictionary().getJavalangCloneable().isAssignableFrom(inst.getJavaClass())) {
                    throw vm.newThrowable(VMSymbols.java_lang_CloneNotSupportedException, inst.getJavaClass().getCanonicalName());
                }
                // todo special handling for membernames?
                // todo register finalizer
                return JavaWrapper.wrap(inst.asObject().vmClone());
            }

            if (inst.is(JavaValueType.ARRAY)) {
                JavaArray old = inst.asArray();
                JavaArray array = new JavaArray(inst.getJavaClass(), new JavaWrapper[old.length()]);
                for (int i = 0; i < old.length(); i++) {
                    array.set(i, old.get(i));
                }

                return JavaWrapper.wrap(array);
            } else {
                throw new ExecutionException("Unexpected");
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "notify", "()V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            inst.get().getCondition().signal();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "notifyAll", "()V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            inst.get().getCondition().signalAll();
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "wait", "(J)V", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            long wait = args[0].asLong();
            try {
                if (wait == 0) {
                    inst.get().getCondition().await();
                } else {
                    inst.get().getCondition().await(wait, TimeUnit.MILLISECONDS);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                ThreadOop.forThread(Thread.currentThread()).setInterrupted();
            }
        }));
        vm.hook(new HookedMethod("java/lang/Object", "<init>", "()V", Cause.NONE, Effect.NONE).bind((ctx, inst, args) -> {
            JavaValue arg0 = inst.get();
            if (ExecutionUtils.areValuesUnknown(arg0)) {
                throw new ExecutionException("Unknown value while initializing?!?!");
            }
            if (!(arg0 instanceof JavaUninitialized)) {
                throw new ExecutionException("Cannot call <init> on initialized object: " + arg0);
            }
            JavaUninitialized uninitialized = (JavaUninitialized) arg0;
            if (vm.getSystemDictionary().getJavaLangThread().isAssignableFrom(uninitialized.getJavaClass())) {
                ThreadOop threadOop = new ThreadOop(inst);
                uninitialized.initializedValue().setMetadata("oop", threadOop);
            }
            inst.set(uninitialized.initializedValue());
        }));
    }
}
