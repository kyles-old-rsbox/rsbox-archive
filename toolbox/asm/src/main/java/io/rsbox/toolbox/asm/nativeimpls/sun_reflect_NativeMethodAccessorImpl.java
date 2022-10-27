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
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.PrimitiveUtils;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class sun_reflect_NativeMethodAccessorImpl {
    private static final String THIS = "sun/reflect/NativeMethodAccessorImpl";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "invoke0", "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaObject method = ((JavaObject) args[0].get());
            JavaWrapper classObj = method.getField("clazz", "Ljava/lang/Class;");
            JavaClass clazz = java_lang_Class.getJavaClass(classObj);
            ClassNode classNode = clazz.getClassNode();
            MethodNode methodNode = clazz.getClassNode().methods.get(method.getField("slot", "I").asInt());

            Type[] types = Type.getArgumentTypes(methodNode.desc);
            JavaWrapper[] ctorargs = new JavaWrapper[types.length];

            if (!args[2].is(JavaValueType.NULL)) {
                JavaArray providedArgs = ((JavaArray) args[2].get());
                for (int i = 0; i < types.length; i++) {
                    JavaWrapper wrapper = providedArgs.get(i);
                    if (wrapper.is(JavaValueType.PRIMITIVE)) {
                        ctorargs[i] = wrapper;
                    } else {
                        switch (types[i].getSort()) {
                            case Type.BOOLEAN:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "Z");
                                break;
                            case Type.CHAR:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "C");
                                break;
                            case Type.BYTE:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "B");
                                break;
                            case Type.SHORT:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "S");
                                break;
                            case Type.INT:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "I");
                                break;
                            case Type.FLOAT:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "F");
                                break;
                            case Type.LONG:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "J");
                                break;
                            case Type.DOUBLE:
                                ctorargs[i] = ((JavaObject) wrapper.get()).getField("value", "D");
                                break;
                            case Type.ARRAY:
                            case Type.OBJECT:
                                ctorargs[i] = wrapper;
                                break;
                        }
                    }
                }
            }
            if (!args[1].is(JavaValueType.NULL)) {
                classNode = args[1].getJavaClass().getClassNode();
                ClassNode now = classNode;
                MethodNode newNode = ASMHelper.findMethod(classNode, methodNode.name, methodNode.desc);
                while (newNode == null) {
                    now = vm.lookupClass(now.superName);
                    if (now == null) {
                        break;
                    }
                    newNode = ASMHelper.findMethod(classNode, methodNode.name, methodNode.desc);
                }
                if (newNode != null) {
                    methodNode = newNode;
                }
            }
            Type expectedReturnType = Type.getReturnType(methodNode.desc);
            JavaWrapper result = vm.internalExecute(classNode, methodNode, args[1], ctorargs, vm.currentInsn.get(Thread.currentThread()));
            if (result == null) {
                if (expectedReturnType.getSort() == Type.VOID) {
                    return vm.getNull();
                } else {
                    throw new ExecutionException("No return value for non-void method");
                }
            } else {
                // we need to box the result if it's a primitive
                if (PrimitiveUtils.isPrimitive(expectedReturnType)) {
                    switch (expectedReturnType.getSort()) {
                        case Type.BOOLEAN:
                            result = vm.newBoxedBoolean(result.asPrimitive().asBoolean());
                            break;
                        case Type.BYTE:
                            result = vm.newBoxedByte(result.asByte());
                            break;
                        case Type.CHAR:
                            result = vm.newBoxedChar(result.asChar());
                            break;
                        case Type.SHORT:
                            result = vm.newBoxedShort(result.asShort());
                            break;
                        case Type.INT:
                            result = vm.newBoxedInt(result.asInt());
                            break;
                        case Type.FLOAT:
                            result = vm.newBoxedFloat(result.asFloat());
                            break;
                        case Type.LONG:
                            result = vm.newBoxedLong(result.asLong());
                            break;
                        case Type.DOUBLE:
                            result = vm.newBoxedDouble(result.asDouble());
                            break;
                    }
                }
            }
            return result;
        }));
    }
}
