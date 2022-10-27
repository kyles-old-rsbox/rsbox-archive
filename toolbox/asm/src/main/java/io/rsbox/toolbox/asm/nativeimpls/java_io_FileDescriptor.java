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

public class java_io_FileDescriptor {
    private static final String THIS = "java/io/FileDescriptor";

    public static JavaWrapper getHandle(JavaWrapper fileDescriptor) {
        return fileDescriptor.asObject().getField("handle", "J");
    }

    public static int getFd(JavaWrapper fileDescriptor) {
        return fileDescriptor.asObject().getField("fd", "I").asInt();
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));

        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "set", "(I)J", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return vm.newLong(args[0].asInt());
        }));
    }
}
