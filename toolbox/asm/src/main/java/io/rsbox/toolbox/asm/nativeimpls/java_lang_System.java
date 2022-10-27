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
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_System {
    private static final String THIS = "java/lang/System";

    public static void putProp(VirtualMachine vm, JavaWrapper prop, String key, String val) {
        vm.internalExecute(vm.getSystemDictionary().getJavaUtilProperties().getClassNode(),
                ASMHelper.findMethod(vm.getSystemDictionary().getJavaUtilProperties().getClassNode(), "setProperty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;"),
                prop,
                new JavaWrapper[]{vm.getStringInterned(key), vm.getStringInterned(val)},
                null
        );
    }

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setIn0", "(Ljava/io/InputStream;)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            vm.getSystemDictionary().getJavaLangSystem().setStaticField("in", "Ljava/io/InputStream;", args[0]);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setOut0", "(Ljava/io/PrintStream;)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            vm.getSystemDictionary().getJavaLangSystem().setStaticField("out", "Ljava/io/PrintStream;", args[0]);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setErr0", "(Ljava/io/PrintStream;)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            vm.getSystemDictionary().getJavaLangSystem().setStaticField("err", "Ljava/io/PrintStream;", args[0]);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "currentTimeMillis", "()J", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo let vm decide
            return vm.newLong(System.currentTimeMillis());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "nanoTime", "()J", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo let vm decide
            return vm.newLong(System.nanoTime());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "arraycopy", "(Ljava/lang/Object;ILjava/lang/Object;II)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            JavaArray src = ((JavaArray) args[0].get());
            JavaArray dst = ((JavaArray) args[2].get());
            int srcStart = args[1].asInt();
            int dstStart = args[3].asInt();
            int amnt = args[4].asInt();
            JavaWrapper[] tmp = new JavaWrapper[amnt];
            for (int count = 0, i = srcStart; count < amnt; count++, i++) {
                tmp[count] = src.get(i);
            }
            for (int count = 0, j = dstStart; count < amnt; count++, j++) {
                dst.set(j, tmp[count]);
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "identityHashCode", "(Ljava/lang/Object;)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newInt(args[0].is(JavaValueType.NULL) ? 0 : args[0].asObject().getHashCode());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "initProperties", "(Ljava/util/Properties;)Ljava/util/Properties;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo so many more properties
            putProp(vm, args[0], "file.encoding", "UTF-8");
            putProp(vm, args[0], "file.separator", "\\");
            putProp(vm, args[0], "path.separator", ";");
            putProp(vm, args[0], "line.separator", "\r\n");
            putProp(vm, args[0], "java.home", "C:\\java_home_dir");
            putProp(vm, args[0], "user.dir", "C:\\user_dir");
            putProp(vm, args[0], "sun.reflect.inflationThreshold", String.valueOf(Integer.MAX_VALUE));
            putProp(vm, args[0], "os.name", "Windows 10");
            putProp(vm, args[0], "os.arch", "x86_64");
            putProp(vm, args[0], "os.version", "10.0");
            putProp(vm, args[0], "sun.boot.class.path", "C:\\java_home_dir\\lib\\jce.jar");
            putProp(vm, args[0], "java.io.tmpdir", "C:\\temp_dir\\");
            putProp(vm, args[0], "sun.jnu.encoding", "Cp1252");
            putProp(vm, args[0], "java.awt.headless", "true");
            putProp(vm, args[0], "java.class.version", "50.0");
            putProp(vm, args[0], "awt.toolkit", "sun.awt.windows.WToolkit");
            return args[0];
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "mapLibraryName", "(Ljava/lang/String;)Ljava/lang/String;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo let vm decide
            return vm.getString(vm.convertJavaObjectToString(args[0]) + ".dll");
        }));
    }
}
