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
import io.rsbox.toolbox.asm.hooks.HookedMethod;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.*;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodNode;

public class sun_reflect_NativeConstructorAccessorImpl {
    private static final String THIS = "sun/reflect/NativeMethodAccessorImpl";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(new HookedMethod("sun/reflect/NativeConstructorAccessorImpl", "newInstance0", "(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Ljava/lang/Object;", Cause.NONE, Effect.NONE).bind((ctx, inst, args) -> {
            JavaWrapper arg0 = args[0];
            JavaWrapper arg1 = args[1];
            if (ExecutionUtils.areValuesUnknown(arg0, arg1)) {
                return JavaWrapper.wrap(new JavaUnknown(vm, vm.getSystemDictionary().getJavaLangString(), "forName0 on " + arg0 + " " + arg1));
            }

            JavaObject constructor = ((JavaObject) arg0.get());
            JavaClass declaringClass = java_lang_Class.getJavaClass(constructor.getField("clazz", "Ljava/lang/Class;"));
            MethodNode constructorNode = declaringClass.getClassNode().methods.get(constructor.getField("slot", "I").asInt());

            Type[] types = Type.getArgumentTypes(constructorNode.desc);
            JavaWrapper[] ctorargs = new JavaWrapper[types.length];

            if (!arg1.is(JavaValueType.NULL)) {
                JavaArray providedArgs = ((JavaArray) arg1.get());
                for (int i = 0; i < types.length; i++) {
                    JavaWrapper wrapper = providedArgs.get(i);
                    if (!wrapper.is(JavaValueType.NULL) && wrapper.getJavaClass().isPrimitive()) {
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
                            case Type.OBJECT:
                            case Type.ARRAY:
                                ctorargs[i] = wrapper;
                                break;
                        }
                    }
                }
            }

            return vm.newInstance(declaringClass, constructorNode.desc, ctorargs);
        }));
    }
}
