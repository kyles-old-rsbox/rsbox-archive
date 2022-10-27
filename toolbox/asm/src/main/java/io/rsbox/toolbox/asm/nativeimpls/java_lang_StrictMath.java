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
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_StrictMath {
    private static final String THIS = "java/lang/StrictMath";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "log", "(D)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return JavaWrapper.createDouble(vm, StrictMath.log(args[0].asDouble()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "cos", "(D)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return vm.newDouble(StrictMath.cos(args[0].asDouble()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "sqrt", "(D)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return vm.newDouble(StrictMath.sqrt(args[0].asDouble()));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "pow", "(DD)D", true, Cause.ALL, Effect.ALL, (ctx, inst, args) -> {
            return JavaWrapper.createDouble(vm, StrictMath.pow(args[0].asDouble(), args[1].asDouble()));
        }));
    }
}
