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

package io.rsbox.toolbox.asm.instructions;

import io.rsbox.toolbox.asm.Locals;
import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.Stack;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.Utils;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InvokeDynamicInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvokeDynamicInstruction extends Instruction {

    private final Map<AbstractInsnNode, JavaWrapper> dynamicinvokerMap = new HashMap<>();
    private final Object dynamicinvokerLock = new Object();

    private JavaWrapper findMethodType(VirtualMachine vm, String desc, AbstractInsnNode currentInsn) {
        if (desc.length() > 0 && desc.charAt(0) == '(') {
            Type[] args = Type.getArgumentTypes(desc);
            Type ret = Type.getReturnType(desc);

            JavaWrapper rt = JavaClass.forName(vm, ret).getOop();
            JavaWrapper[] pts = new JavaWrapper[args.length];
            for (int i = 0; i < args.length; i++) {
                pts[i] = JavaClass.forName(vm, args[i]).getOop();
            }

            JavaWrapper[] params = new JavaWrapper[]{rt, JavaWrapper.createArray(JavaClass.forName(vm, "[Ljava/lang/Class;"), pts)};

            // call java.lang.invoke.MethodHandleNatives::findMethodType(Class rt, Class[] pts) -> MethodType
            ClassNode mhn = vm.getSystemDictionary().getJavaLangInvokeMethodHandleNatives().getClassNode();
            MethodNode linkMethodHandleConstant = ASMHelper.findMethod(mhn, "findMethodHandleType", "(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/invoke/MethodType;");
            return vm.internalExecute(mhn, linkMethodHandleConstant, null, params, currentInsn);
        } else {
            return JavaClass.forName(vm, desc).getOop();
        }
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        InvokeDynamicInsnNode cast = (InvokeDynamicInsnNode) currentInsn;

        JavaWrapper dynamicinvoker = dynamicinvokerMap.get(cast);
        if (dynamicinvoker == null) {
            dynamicinvoker = loadCallsite(execution, currentInsn, cast);
            synchronized (dynamicinvokerLock) {
                if (dynamicinvokerMap.containsKey(cast)) {
                    dynamicinvoker = dynamicinvokerMap.get(cast);
                } else {
                    dynamicinvokerMap.put(cast, dynamicinvoker);
                }
            }
        }

        Type[] argumentTypes = Type.getArgumentTypes(cast.desc);
        Type returnType = Type.getReturnType(cast.desc);

        JavaWrapper[] args = new JavaWrapper[argumentTypes.length];
        for (int i = argumentTypes.length - 1; i >= 0; i--) {
            args[i] = stack.pop();
        }

        ClassNode classNode = execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandle().getClassNode();
        MethodNode methodNode = ASMHelper.findMethod(execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandle().getClassNode(), "invokeExact", cast.desc);
        if (methodNode == null) {
            methodNode = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL | Opcodes.ACC_NATIVE, "invokeExact", cast.desc, null, null);
            classNode.methods.add(methodNode);
            execution.getVM().getJavaLangInvokeMethodHandle().hookPolymorphicSignature(methodNode);
        }

        JavaValue result = execution.getVM().internalExecute(
                classNode,
                methodNode,
                dynamicinvoker,
                args,
                currentInsn
        ).get();

        if (returnType.getSort() != Type.VOID) {
            if (result.is(JavaValueType.UNKNOWN)) {
                stack.push(result instanceof JavaWrapper ? (JavaWrapper) result : JavaWrapper.wrap(result));
            } else {
                if (Utils.isObjectOfType(returnType, result)) {
                    stack.push(result instanceof JavaWrapper ? (JavaWrapper) result : JavaWrapper.wrap(result));
                }
            }
        }
    }

    private JavaWrapper loadCallsite(MethodExecution execution, AbstractInsnNode currentInsn, InvokeDynamicInsnNode cast) {

        Handle handle = cast.bsm;
        JavaWrapper[] bsmArgs = new JavaWrapper[cast.bsmArgs.length];
        for (int i = 0; i < cast.bsmArgs.length; i++) {
            Object bsmArg = cast.bsmArgs[i];
            if (bsmArg instanceof Integer) {
                bsmArgs[i] = execution.getVM().newBoxedInt((Integer) bsmArg);
            } else if (bsmArg instanceof Float) {
                bsmArgs[i] = execution.getVM().newBoxedFloat((Float) bsmArg);
            } else if (bsmArg instanceof Long) {
                bsmArgs[i] = execution.getVM().newBoxedLong((Long) bsmArg);
            } else if (bsmArg instanceof Double) {
                bsmArgs[i] = execution.getVM().newBoxedDouble((Double) bsmArg);
            } else if (bsmArg instanceof Type) {
                Type type = (Type) bsmArg;
                if (type.getSort() == Type.METHOD) {
                    String methodType = type.getDescriptor();
                    bsmArgs[i] = findMethodType(execution.getVM(), methodType, currentInsn);
                } else {
                    JavaClass jc = JavaClass.forName(execution.getVM(), (Type) bsmArg);
                    bsmArgs[i] = jc.getOop();
                }
            } else if (bsmArg instanceof String) {
                bsmArgs[i] = execution.getVM().getStringInterned((String) bsmArg);
            } else if (bsmArg instanceof Handle) {
                Handle cstBsmArg = (Handle) bsmArg;

                JavaWrapper[] params = new JavaWrapper[5];
                params[0] = JavaClass.forName(execution.getVM(), execution.getClassNode().name).getOop();
                params[1] = JavaWrapper.createInteger(execution.getVM(), cstBsmArg.getTag());
                params[2] = JavaClass.forName(execution.getVM(), cstBsmArg.getOwner()).getOop();
                params[3] = execution.getVM().getString(cstBsmArg.getName());
                params[4] = findMethodType(execution.getVM(), cstBsmArg.getDesc(), currentInsn);

                ClassNode mhn = execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandleNatives().getClassNode();
                MethodNode linkMethodHandleConstant = ASMHelper.findMethod(mhn, "linkMethodHandleConstant", "(Ljava/lang/Class;ILjava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;");
                bsmArgs[i] = execution.getVM().internalExecute(mhn, linkMethodHandleConstant, null, params, currentInsn);
            } else {
                throw new ExecutionException("Unsupported bsm arg " + bsmArg + " " + bsmArg.getClass());
            }
        }

        JavaWrapper[] params = new JavaWrapper[5];
        params[0] = JavaClass.forName(execution.getVM(), execution.getClassNode().name).getOop();
        params[1] = JavaWrapper.createInteger(execution.getVM(), handle.getTag());
        params[2] = JavaClass.forName(execution.getVM(), handle.getOwner()).getOop();
        params[3] = execution.getVM().getString(handle.getName());
        params[4] = findMethodType(execution.getVM(), handle.getDesc(), currentInsn);

        ClassNode mhn = execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandleNatives().getClassNode();
        MethodNode linkMethodHandleConstant = ASMHelper.findMethod(mhn, "linkMethodHandleConstant", "(Ljava/lang/Class;ILjava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/invoke/MethodHandle;");
        JavaWrapper methodHandle = execution.getVM().internalExecute(mhn, linkMethodHandleConstant, null, params, currentInsn);

        params = new JavaWrapper[6];
        params[0] = JavaClass.forName(execution.getVM(), execution.getClassNode().name).getOop();
        params[1] = methodHandle;
        params[2] = execution.getVM().getStringInterned(cast.name);
        params[3] = findMethodType(execution.getVM(), cast.desc, currentInsn);
        params[4] = JavaWrapper.createArray(JavaClass.forName(execution.getVM(), "[Ljava/lang/Object;"), bsmArgs);
        params[5] = JavaWrapper.createArray(JavaClass.forName(execution.getVM(), "[Ljava/lang/Object;"), new JavaWrapper[1]);

        MethodNode linkCallSite = ASMHelper.findMethod(mhn, "linkCallSite", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/invoke/MemberName;");
        execution.getVM().internalExecute(mhn, linkCallSite, null, params, currentInsn);

        return params[5].asArray().get(0);
    }
}