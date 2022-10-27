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
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class sun_nio_fs_WindowsNativeDispatcher {
    private final VirtualMachine _vm;

    public sun_nio_fs_WindowsNativeDispatcher(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "sun/nio/fs/WindowsNativeDispatcher", "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // ignored
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "sun/nio/fs/WindowsNativeDispatcher", "FindFirstFile0", "(JLsun/nio/fs/WindowsNativeDispatcher$FirstFile;)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            ByteBuffer buffer = _vm.getMemory().getBufferForAddress(args[0].asLong());
            JavaWrapper dst = args[1];

            buffer.position(0);
            CharBuffer charBuffer = buffer.asCharBuffer();
            char[] data = new char[charBuffer.remaining()];
            charBuffer.get(data);

            String fileName = new String(data);
            fileName = fileName.substring(0, fileName.indexOf("\u0000")); // it's null terminated

            throw new ExecutionException("unsupported");
        }));
    }
}
