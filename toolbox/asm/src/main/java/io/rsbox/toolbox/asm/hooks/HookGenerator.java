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

package io.rsbox.toolbox.asm.hooks;

import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import io.rsbox.toolbox.asm.values.prim.JDouble;
import io.rsbox.toolbox.asm.values.prim.JFloat;
import io.rsbox.toolbox.asm.values.prim.JInteger;
import io.rsbox.toolbox.asm.values.prim.JLong;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Supplier;

public class HookGenerator {
    public static HookedMethod generateNopHook(String owner, String name, String desc) {
        Type type = Type.getReturnType(desc);
        if (type.getSort() != Type.VOID)
            throw new UnsupportedOperationException("Cannot nop hook a method which doesn't return void");

        return new HookedMethod(owner, name, desc, Cause.NONE, Effect.NONE).bind((context, instance, args) -> {

        });
    }

    public static HookedMethod generateUnknownHandlingVoidHook(VirtualMachine vm, String owner, String name, String desc, boolean isStatic, Cause cause, Effect effect, HookedMethod.VoidHook hook) {
        Type returnType = Type.getReturnType(desc);
        if (returnType.getSort() != Type.VOID)
            throw new UnsupportedOperationException("Cannot nop hook a method which doesn't return void");

        return new HookedMethod(owner, name, desc, cause, effect).bind((ctx, inst, args) -> {
            if (!isStatic && inst == null) {
                throw vm.newThrowable(VMSymbols.java_lang_NullPointerException);
            }
            if (ExecutionUtils.areValuesUnknown(inst, args)) {
                //todo log
                return;
            }
            hook.execute(ctx, inst, args);
        });
    }

    public static HookedMethod generateUnknownHandlingHook(VirtualMachine vm, String owner, String name, String desc, boolean isStatic, Cause cause, Effect effect, HookedMethod.Hook hook) {
        Type returnType = Type.getReturnType(desc);
        if (returnType.getSort() == Type.VOID)
            throw new UnsupportedOperationException("Cannot nop hook a method which doesn't return void");

        JavaClass returnClass = JavaClass.forName(vm, returnType);
        Type[] argumentTypes = Type.getArgumentTypes(desc);

        return new HookedMethod(owner, name, desc, cause, effect).bind((ctx, inst, args) -> {
            if (!isStatic && inst == null) {
                throw vm.newThrowable(VMSymbols.java_lang_NullPointerException);
            }
            if (ExecutionUtils.areValuesUnknown(inst, args)) {
                return JavaWrapper.wrap(new JavaUnknown(vm, returnClass, "Calling " + name + " on " + inst + " " + Arrays.toString(args)));
            }

            return hook.execute(ctx, inst, args);
        });
    }

    public static HookedMethod generateDefaultingHook(Method method, Cause cause, Effect effect) {
        return generateDefaultingHook(method, cause, effect, null);
    }

    public static HookedMethod generateDefaultingHook(Method method, Cause cause, Effect effect, Supplier<JavaWrapper> value) {
        Class<?> srcClass = method.getDeclaringClass();
        String internalName = Type.getInternalName(srcClass);

        HookedMethod hookedMethod = new HookedMethod(internalName, method.getName(), Type.getMethodDescriptor(method), cause, effect);

        if (method.getReturnType() == void.class) {
            hookedMethod.bind((context, instance, args) -> {

            });
        } else {
            hookedMethod.bind((context, instance, args) -> {
                return value.get();
            });
        }

        return hookedMethod;
    }

    //    private static JavaValue convertArray(MethodExecution context, Class<?> retType, Object retVal) {
//        JavaClass mirror = JavaClass.forName(context.getVM(), Type.getType(retType));
//
//        if (mirror.internalGetType().getDimensions() != 1) {
//            throw new ExecutionException("");
//        }
//
//        if (retType == byte[].class) {
//            return new JavaObject(ExecutionUtils.convert((byte[]) retVal), mirror, mirror.internalGetType().getDescriptor());
//        } else if (retType == char[].class) {
//            return new JavaObject(ExecutionUtils.convert((char[]) retVal), mirror, mirror.internalGetType().getDescriptor());
//        }
//
//        return new JavaObject(ExecutionUtils.convert((Object[]) retVal, mirror.getComponentType(), mirror.getComponentType().internalGetType().getInternalName()), mirror, mirror.internalGetType().getDescriptor());
//    }
//
    private static JavaValue convertObject(MethodExecution execution, Class<?> retType, Object retVal) {
        JavaClass mirror = JavaClass.forName(execution.getVM(), Type.getType(retType));
        if (retType == int.class) {
            return new JInteger(execution.getVM(), (int) retVal);
        } else if (retType == char.class) {
            return execution.getVM().newChar((char) retVal).get();
        } else if (retType == byte.class) {
            return execution.getVM().newByte((byte) retVal).get();
        } else if (retType == short.class) {
            return execution.getVM().newShort((short) retVal).get();
        } else if (retType == boolean.class) {
            return ((boolean) retVal) ? execution.getVM().TRUE.get() : execution.getVM().FALSE.get();
        } else if (retType == float.class) {
            return new JFloat(execution.getVM(), (float) retVal);
        } else if (retType == long.class) {
            return new JLong(execution.getVM(), (long) retVal);
        } else if (retType == double.class) {
            return new JDouble(execution.getVM(), (double) retVal);
        } else if (retVal == null) {
            return execution.getVM().getNull().get();
        } else if (retType.isArray()) {
//            return convertArray(context, retType, retVal);
        } else {
//            return new JavaObject(retVal, mirror, mirror.internalGetType().getInternalName());
        }

        throw new ExecutionException("Unsupported " + retType + " " + retVal);
    }
}
