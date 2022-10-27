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
import io.rsbox.toolbox.asm.hooks.HookedMethod;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_Runtime {
    private final VirtualMachine _vm;

    public java_lang_Runtime(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(new HookedMethod("java/lang/Runtime", "availableProcessors", "()I", Cause.ALL, Effect.NONE).bind((ctx, inst, args) -> {
            return JavaWrapper.createInteger(_vm, 8);
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/Runtime", "totalMemory", "()J", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return _vm.newLong((long) 8e+9);
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/Runtime", "freeMemory", "()J", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return _vm.newLong((long) 8e+9);
        }));
    }
}
