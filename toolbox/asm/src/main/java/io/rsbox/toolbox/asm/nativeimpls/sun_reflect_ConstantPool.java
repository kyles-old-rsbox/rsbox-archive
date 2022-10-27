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
import io.rsbox.toolbox.asm.ConstantPool;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class sun_reflect_ConstantPool {
    private static final String THIS = "sun/reflect/ConstantPool";

    public static JavaClass getJavaClass(JavaWrapper constantPool) {
        return constantPool.getMetadata("oop");
    }

    public static void setJavaClass(JavaWrapper constantPool, JavaClass javaClass) {
        constantPool.setMetadata("oop", javaClass);
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getSize0", "(Ljava/lang/Object;)I", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass javaClass = getJavaClass(inst);
            ConstantPool constantPool = vm.getConstantPool(javaClass.getClassNode());
            if (constantPool == null) {
                throw new ExecutionException("No constantpool found for " + javaClass.getClassNode().name + " " + Integer.toHexString(System.identityHashCode(javaClass.getClassNode())));
            }
            return vm.newInt(constantPool.getSize());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getUTF8At0", "(Ljava/lang/Object;I)Ljava/lang/String;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            JavaClass javaClass = getJavaClass(inst);
            ConstantPool constantPool = vm.getConstantPool(javaClass.getClassNode());
            if (constantPool == null) {
                throw new ExecutionException("No constantpool found for " + javaClass.getClassNode().name + " " + Integer.toHexString(System.identityHashCode(javaClass.getClassNode())));
            }
            return vm.getStringInterned(constantPool.getUTF8At(args[1].asInt()));
        }));
    }
}
