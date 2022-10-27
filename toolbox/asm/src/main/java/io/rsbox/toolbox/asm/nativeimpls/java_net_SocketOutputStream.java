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
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;

import java.io.IOException;

public class java_net_SocketOutputStream {
    private final VirtualMachine _vm;

    public java_net_SocketOutputStream(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/net/SocketOutputStream", "init", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/net/SocketOutputStream", "socketWrite0", "(Ljava/io/FileDescriptor;[BII)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            byte[] bytes = ArrayConversionHelper.convertByteArray(args[1].asArray());
            try {
                _vm.getNetwork().socketWrite(java_io_FileDescriptor.getFd(args[0]), bytes, args[2].asInt(), args[3].asInt());
            } catch (IOException e) {
                throw _vm.newThrowable(VMSymbols.java_io_IOException);
            }
        }));
    }
}
