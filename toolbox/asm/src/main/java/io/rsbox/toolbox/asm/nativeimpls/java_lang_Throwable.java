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

import io.rsbox.toolbox.asm.*;
import io.rsbox.toolbox.asm.hooks.*;
import io.rsbox.toolbox.asm.mirrors.*;
import io.rsbox.toolbox.asm.values.*;
import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.StackTraceHolder;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.*;

import java.lang.reflect.*;
import java.util.*;

/*
 * Throwables are interesting. Calling fillInStackTrace() will cause the VM to generate the backtrace,
 * but not actually modify the Throwable's accessible fields (the backtrace field will be modified though)
 *
 * Only when getStackTrace() or printStackTrace() is called, is getStackTraceElement() called to lazily fetch the stacktrace
 */
public class java_lang_Throwable {
    private static final String THIS = "java/lang/Throwable";
    public static final String METADATA_BACKTRACE = "backtrace";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "fillInStackTrace", "(I)Ljava/lang/Throwable;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            List<StackTraceHolder> stacktrace = vm.getStacktrace();

            while (!stacktrace.isEmpty()) {
                StackTraceHolder holder = stacktrace.get(0);
                if (holder.getMethod().name.equalsIgnoreCase("fillInStackTrace0") ||
                        holder.getMethod().name.equalsIgnoreCase("fillInStackTrace")) {
                    stacktrace.remove(0);
                    continue;
                }
                if (holder.getMethod().name.equals("<init>") && vm.getSystemDictionary().getJavaLangThrowable().isAssignableFrom(JavaClass.forName(vm, holder.getClassNode().name))) {
                    stacktrace.remove(0);
                    continue;
                }
                break;
            }

            inst.get().setMetadata(METADATA_BACKTRACE, stacktrace);

            return inst;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getStackTraceDepth", "()I", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return JavaWrapper.createInteger(vm, ((List) inst.get().getMetadata(METADATA_BACKTRACE)).size());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getStackTraceElement", "(I)Ljava/lang/StackTraceElement;", false, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            JavaClass stackTraceElementClazz = JavaClass.forName(vm, "java/lang/StackTraceElement");

            List<StackTraceHolder> holders = inst.get().getMetadata(METADATA_BACKTRACE);
            List<StackTraceElement> elements = convert(holders);

            StackTraceElement elem = elements.get(args[0].asInt());

            return vm.newInstance(stackTraceElementClazz, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
                    vm.getString(elem.getClassName()),
                    vm.getString(elem.getMethodName()),
                    vm.getString(elem.getFileName()),
                    vm.newInt(elem.getLineNumber())
            );
        }));
    }

    public static List<StackTraceElement> convert(List<StackTraceHolder> stackTraceHolder) {
        if (stackTraceHolder == null) {
            return new ArrayList<>();
        }

        List<StackTraceElement> result = new ArrayList<>();

        for (StackTraceHolder elem : stackTraceHolder) {
            int lineNumber = -1;
            if (Modifier.isNative(elem.getMethod().access)) {
                lineNumber = -2;
            } else {
                if (elem.getInstruction() != null) {
                    AbstractInsnNode target = elem.getInstruction();
                    List<LineNumberNode> lines = new ArrayList<>();
                    for (MethodNode m : elem.getClassNode().methods) {
                        if (m.instructions != null && m.instructions.getFirst() != null) {
                            for (AbstractInsnNode i = m.instructions.getFirst(); i.getNext() != null; i = i.getNext()) {
                                if (i instanceof LineNumberNode) {
                                    lines.add((LineNumberNode) i);
                                }
                            }
                        }
                    }
                    outer:
                    for (AbstractInsnNode i = target.getPrevious(); i != null; i = i.getPrevious()) {
                        if (i instanceof LabelNode) {
                            for (LineNumberNode ln : lines) {
                                if (ln.start.getLabel().equals(((LabelNode) i).getLabel())) {
                                    lineNumber = ln.line;
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }
            result.add(new StackTraceElement(
                    elem.getClassNode().name.replace('/', '.'),
                    elem.getMethod().name,
                    elem.getClassNode().sourceFile,
                    lineNumber
            ));
        }

        return result;
    }
}
