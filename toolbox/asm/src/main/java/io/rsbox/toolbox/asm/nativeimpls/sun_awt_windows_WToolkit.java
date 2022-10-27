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

public class sun_awt_windows_WToolkit {
    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/awt/windows/WToolkit", "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "sun/awt/windows/WToolkit", "startToolkitThread", "(Ljava/lang/Runnable;Ljava/lang/ThreadGroup;)Z", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // stub
            args[0].asObject().setField("inited", "Z", vm.newBoolean(true));
            return vm.newBoolean(true);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/awt/windows/WToolkit", "setDynamicLayoutNative", "(Z)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // stub
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "sun/awt/windows/WToolkit", "setExtraMouseButtonsEnabledNative", "(Z)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // stub
        }));
    }
}
