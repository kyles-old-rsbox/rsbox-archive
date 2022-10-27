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

import java.io.File;

public class java_io_UnixFileSystem {
    private static final String THIS = "java/io/UnixFileSystem";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "java/io/UnixFileSystem", "getBooleanAttributes", "(Ljava/io/File;)I", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            String path = vm.convertJavaObjectToString(args[0].asObject().getField("path", "Ljava/lang/String;"));
            File file = vm.getFilesystem().map(new File(path));
            if (file != null && file.exists()) {
                System.out.println("[Filesystem] Getting boolean attributes of " + file + " (" + path + ")");
                int result = 0x01; // BA_EXISTS;
                if (file.isDirectory()) {
                    result |= 0x04;
                }
                if (file.isFile()) {
                    result |= 0x02;
                }
                if (file.isHidden()) {
                    result |= 0x08;
                }
                return vm.newInt(result);
            }
            System.out.println("[Filesystem] Could not get boolean attributes of file " + path);
            return vm.newInt(0);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "java/io/UnixFileSystem", "canonicalize0", "(Ljava/lang/String;)Ljava/lang/String;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return args[0];
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "java/io/UnixFileSystem", "canonicalizeWithPrefix0", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return args[1];
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, "java/io/UnixFileSystem", "getLastModifiedTime", "(Ljava/io/File;)J", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            return vm.newLong(new File(vm.convertJavaObjectToString(args[0].asObject().getField("path", "Ljava/lang/String;"))).lastModified());
        }));
    }
}
