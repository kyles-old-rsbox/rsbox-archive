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
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class java_io_FileInputStream {
    private static final String THIS = "java/io/FileInputStream";

    public static JavaWrapper getFileDescriptor(JavaWrapper fileInputStream) {
        return fileInputStream.asObject().getField("fd", "Ljava/io/FileDescriptor;");
    }

    public static void registerNatives(VirtualMachine vm) {
        Lock nativeLock = new ReentrantLock();
        Map<Long, InputStream> natives = new HashMap<>();

        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));

        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "open0", "(Ljava/lang/String;)V", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            String filepath = vm.convertJavaObjectToString(args[0]);
            File file = new File(filepath);
            file = vm.getFilesystem().map(file);
            if (file != null && file.exists()) {
                System.out.println("[Filesystem] Opening " + file + " (" + filepath + ") for reading");
                nativeLock.lock();
                try {
                    long nextFd = 0;
                    while (natives.containsKey(nextFd)) nextFd++;
                    try {
                        natives.put(nextFd, new FileInputStream(file));
                    } catch (FileNotFoundException e) {
                        throw new ExecutionException(e);
                    }
                    inst.asObject().getField("fd", "Ljava/io/FileDescriptor;").asObject().setField("handle", "J", vm.newLong(nextFd));
                } finally {
                    nativeLock.unlock();
                }
            } else {
                System.out.println("[Filesystem] Could not find " + filepath);
                throw vm.newThrowable(VMSymbols.java_io_FileNotFoundException, filepath + " (The system cannot find the file specified)");
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "readBytes", "([BII)I", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long handle = java_io_FileDescriptor.getHandle(getFileDescriptor(inst)).asLong();
            InputStream fin = natives.get(handle);
            try {
                byte[] data = new byte[args[2].asInt()];
                int len = fin.read(data, 0, data.length);

                JavaArray original = (JavaArray) args[0].get();
                for (int i = 0, off = args[1].asInt(); i < data.length; i++, off++) {
                    original.set(off, vm.newByte(data[i]));
                }
                return JavaWrapper.createInteger(vm, len);
            } catch (IOException e) {
                throw new ExecutionException(e);
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "available", "()I", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long handle = java_io_FileDescriptor.getHandle(getFileDescriptor(inst)).asLong();
            InputStream fin = natives.get(handle);
            try {
                return JavaWrapper.createInteger(vm, fin.available());
            } catch (IOException e) {
                throw new ExecutionException(e);
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "close0", "()V", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            long handle = java_io_FileDescriptor.getHandle(getFileDescriptor(inst)).asLong();
            InputStream fin = natives.get(handle);
            try {
                fin.close();
            } catch (IOException e) {
                throw new ExecutionException(e);
            }
        }));
    }
}
