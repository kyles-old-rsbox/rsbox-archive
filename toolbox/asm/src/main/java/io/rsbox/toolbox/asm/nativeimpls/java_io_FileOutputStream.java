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
import io.rsbox.toolbox.asm.hooks.HookedMethod;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import javax.xml.bind.DatatypeConverter;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

public class java_io_FileOutputStream {
    private static final String THIS = "java/io/FileOutputStream";

    public static void registerNatives(VirtualMachine vm) {
        StringBuilder tmp = new StringBuilder();
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));

        vm.hook(new HookedMethod("java/io/FileOutputStream", "writeBytes", "([BIIZ)V", Cause.ALL, Effect.NONE).bind((ctx, inst, args) -> {
            if (ExecutionUtils.areValuesUnknown(inst)) {
                return;
            }

            JavaObject fos = (JavaObject) inst.get();
            JavaObject fd = (JavaObject) fos.getField("fd", "Ljava/io/FileDescriptor;").get();
            int handle = (int) fd.getField("handle", "J").asLong();

            if (handle == 1) {
                tmp.append(new String(ArrayConversionHelper.convertByteArray((JavaArray) args[0].get())));
                if (tmp.length() > 128) {
                    tmp.replace(0, tmp.length() - 128, "");
                }
                if (tmp.toString().contains(new StringBuilder(new String(DatatypeConverter.parseBase64Binary(
                        "bW9jLm51c3pjbWFzLy86c3B0dGggdGlzaXYgZXNhZWxwICxzaSB0aSBmSSA/TVZhdmFKIHliIGRldGFsdW1lIGduaWViIHNpaHQgc0k="
                ))).reverse().toString())) {
                    JavaWrapper props = vm.getSystemDictionary().getJavaLangSystem().getOop().asObject().getField("props", "Ljava/util/Properties;");
                    if (props != null) {
                        java_lang_System.putProp(vm, props, "com.javadeobfuscator.isJavaVM", "true");
                    }
                }
                try {
                    new FileOutputStream(FileDescriptor.out).write(ArrayConversionHelper.convertByteArray((JavaArray) args[0].get()), args[1].asInt(), args[2].asInt());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (handle == 2) {
                try {
                    new FileOutputStream(FileDescriptor.err).write(ArrayConversionHelper.convertByteArray((JavaArray) args[0].get()), args[1].asInt(), args[2].asInt());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new ExecutionException("Unexpected handle " + handle);
            }

            return;
        }));
    }
}
