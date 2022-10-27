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
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.MethodNode;

public class java_security_AccessController {
    private static final String THIS = "java/security/AccessController";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "doPrivileged", "(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaObject obj = ((JavaObject) args[0].get());
            MethodNode methodNode = ASMHelper.findMethod(obj.getJavaClass().getClassNode(), "run", "()Ljava/lang/Object;");
            if (methodNode == null) {
                throw new ExecutionException("unexpected null method " + obj + " " + obj.getJavaClass());
            }
            // todo oops
            return vm.internalExecute(obj.getJavaClass().getClassNode(), methodNode, args[0], new JavaWrapper[0], vm.currentInsn.get(Thread.currentThread()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "doPrivileged", "(Ljava/security/PrivilegedAction;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaObject obj = ((JavaObject) args[0].get());
            MethodNode methodNode = ASMHelper.findMethod(obj.getJavaClass().getClassNode(), "run", "()Ljava/lang/Object;");
            if (methodNode == null) {
                throw new ExecutionException("unexpected null method " + obj + " " + obj.getJavaClass());
            }
            // todo oops
            return vm.internalExecute(obj.getJavaClass().getClassNode(), methodNode, args[0], new JavaWrapper[0], vm.currentInsn.get(Thread.currentThread()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "doPrivileged", "(Ljava/security/PrivilegedAction;Ljava/security/AccessControlContext;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaObject obj = ((JavaObject) args[0].get());
            MethodNode methodNode = ASMHelper.findMethod(obj.getJavaClass().getClassNode(), "run", "()Ljava/lang/Object;");
            if (methodNode == null) {
                throw new ExecutionException("unexpected null method " + obj + " " + obj.getJavaClass());
            }
            // todo oops
            return vm.internalExecute(obj.getJavaClass().getClassNode(), methodNode, args[0], new JavaWrapper[0], vm.currentInsn.get(Thread.currentThread()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "doPrivileged", "(Ljava/security/PrivilegedExceptionAction;Ljava/security/AccessControlContext;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaObject obj = ((JavaObject) args[0].get());
            MethodNode methodNode = ASMHelper.findMethod(obj.getJavaClass().getClassNode(), "run", "()Ljava/lang/Object;");
            if (methodNode == null) {
                throw new ExecutionException("unexpected null method " + obj + " " + obj.getJavaClass());
            }
            // todo oops
            return vm.internalExecute(obj.getJavaClass().getClassNode(), methodNode, args[0], new JavaWrapper[0], vm.currentInsn.get(Thread.currentThread()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getStackAccessControlContext", "()Ljava/security/AccessControlContext;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return vm.getNull();
        }));
    }
}
