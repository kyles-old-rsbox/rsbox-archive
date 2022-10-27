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
import io.rsbox.toolbox.asm.mirrors.JavaClass;

public class sun_misc_Perf {
    private final VirtualMachine _vm;

    public sun_misc_Perf(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "sun/misc/Perf", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            registerNatives0();
        }));
    }

    private void registerNatives0() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "sun/misc/Perf", "createLong", "(Ljava/lang/String;IIJ)Ljava/nio/ByteBuffer;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            long address = _vm.getMemory().allocateMemory(8);
            return _vm.newInstance(JavaClass.forName(_vm, "java/nio/DirectByteBuffer"), "(JI)V", _vm.newLong(address), _vm.newInt(8));
        }));
    }
}
