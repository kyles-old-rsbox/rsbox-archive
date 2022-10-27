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
import io.rsbox.toolbox.asm.mirrors.JavaMethod;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;

public class java_lang_invoke_MethodHandle {

    private final VirtualMachine _vm;

    public java_lang_invoke_MethodHandle(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    public static JavaWrapper getLambdaForm(JavaWrapper methodHandle) {
        return methodHandle.asObject().getField("form", "Ljava/lang/invoke/LambdaForm;");
    }

    public static JavaWrapper getVMEntry(JavaWrapper lambdaForm) {
        return lambdaForm.asObject().getField("vmentry", "Ljava/lang/invoke/MemberName;");
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/invoke/MethodHandle", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", false, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            JavaWrapper type = inst.asObject().getField("type", "Ljava/lang/invoke/MethodType;");
            JavaWrapper form = inst.asObject().getField("form", "Ljava/lang/invoke/LambdaForm;");
            JavaWrapper vmentry = form.asObject().getField("vmentry", "Ljava/lang/invoke/MemberName;");
            JavaMethod target = (JavaMethod) java_lang_invoke_MemberName.get_vmtarget(vmentry);

            JavaWrapper instance = args.length > 0 ? args[0] : null;
            JavaWrapper[] params = new JavaWrapper[0];
            if (args.length > 1) {
                params = new JavaWrapper[args.length - 1];
                System.arraycopy(args, 1, params, 0, params.length);
            }

            throw new ExecutionException("unsupported");
        }));
    }

    public void hookPolymorphicSignature(MethodNode methodNode) {
        if (methodNode.name.equals("invoke") || methodNode.name.equals("invokeBasic") || methodNode.name.equals("invokeExact")) {
            Type methodType = Type.getMethodType(methodNode.desc);
            Type[] mArgs = methodType.getArgumentTypes();
            Type ret = methodType.getReturnType();

            HookedMethod.Hook hook = (ctx, inst, args) -> {
                JavaWrapper type = inst.asObject().getField("type", "Ljava/lang/invoke/MethodType;");
                JavaWrapper form = inst.asObject().getField("form", "Ljava/lang/invoke/LambdaForm;");
                JavaWrapper vmentry = form.asObject().getField("vmentry", "Ljava/lang/invoke/MemberName;");
                JavaMethod target = (JavaMethod) java_lang_invoke_MemberName.get_vmtarget(vmentry);

                JavaWrapper instance = args.length > 0 ? args[0] : null;
                JavaWrapper[] params = new JavaWrapper[0];
                if (args.length > 1) {
                    params = new JavaWrapper[args.length - 1];
                    System.arraycopy(args, 1, params, 0, params.length);
                }

                if (target.getClassNode().name.startsWith("java/lang/invoke/LambdaForm$")) {
                    // ???
                    instance = inst;
                    params = new JavaWrapper[args.length + 1];
                    System.arraycopy(args, 0, params, 1, args.length);
                    params[0] = inst;
                }

//                System.out.println("vmentry: " + vmentry);
//                System.out.println("instance: " + instance);
//                System.out.println("params: " + params.length);
//                for (JavaWrapper param : params) {
//                    System.out.println(param);
//                }

                JavaWrapper result = _vm.internalExecute(target.getClassNode(), target.getMethodNode(), instance, params, _vm.currentInsn.get(Thread.currentThread()));
                return result;
            };

            if (ret.getSort() == Type.VOID) {
                _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook::execute));
            } else {
                _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook));
            }
        } else if (methodNode.name.equals("linkToStatic")) {
            Type methodType = Type.getMethodType(methodNode.desc);
            Type[] mArgs = methodType.getArgumentTypes();
            Type ret = methodType.getReturnType();

            HookedMethod.Hook hook = (ctx, inst, args) -> {
                JavaMethod target = (JavaMethod) java_lang_invoke_MemberName.get_vmtarget(args[args.length - 1]);

                JavaWrapper[] params = new JavaWrapper[0];
                if (args.length > 1) {
                    params = new JavaWrapper[args.length - 1];
                    System.arraycopy(args, 0, params, 0, params.length);
                }
//                System.out.println("linkTostatic: " + target);
//                System.out.println("params: " + params.length);
//                for (JavaWrapper param : params) {
//                    System.out.println(param);
//                }

                return _vm.internalExecute(target.getClassNode(), target.getMethodNode(), null, params, _vm.currentInsn.get(Thread.currentThread()));
            };

            if (ret.getSort() == Type.VOID) {
                _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook::execute));
            } else {
                _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook));
            }
        } else if (methodNode.name.equals("linkToVirtual")) {
            Type methodType = Type.getMethodType(methodNode.desc);
            Type[] mArgs = methodType.getArgumentTypes();
            Type ret = methodType.getReturnType();

            HookedMethod.Hook hook = (ctx, inst, args) -> {
                JavaMethod target = (JavaMethod) java_lang_invoke_MemberName.get_vmtarget(args[args.length - 1]);

                JavaWrapper[] params = new JavaWrapper[0];
                if (args.length > 1) {
                    params = new JavaWrapper[args.length - 2];
                    System.arraycopy(args, 1, params, 0, params.length);
                }
//                System.out.println("linkToVirtual: " + target);
//                System.out.println("instance: " + args[0]);
//                System.out.println("params: " + params.length);
//                for (JavaWrapper param : params) {
//                    System.out.println(param);
//                }

                return _vm.internalExecute(target.getClassNode(), target.getMethodNode(), args[0], params, _vm.currentInsn.get(Thread.currentThread()));
            };

            if (ret.getSort() == Type.VOID) {
                _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook::execute));
            } else {
                _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/invoke/MethodHandle", methodNode.name, methodNode.desc, Modifier.isStatic(methodNode.access), Cause.ALL, Effect.ALL, hook));
            }
        }
    }
}
