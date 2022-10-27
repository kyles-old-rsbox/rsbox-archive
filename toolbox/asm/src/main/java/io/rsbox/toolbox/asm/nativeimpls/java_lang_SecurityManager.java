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
import io.rsbox.toolbox.asm.StackTraceHolder;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.util.List;

public class java_lang_SecurityManager {

    private final VirtualMachine _vm;

    public java_lang_SecurityManager(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/lang/SecurityManager", "getClassContext", "()[Ljava/lang/Class;", false, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            List<StackTraceHolder> stacktrace = _vm.getStacktrace();
            stacktrace.remove(0);

            JavaWrapper array = JavaWrapper.createArray(JavaClass.forName(_vm, "[Ljava/lang/Class;"), new JavaWrapper[stacktrace.size()]);
            // todo remove hidden frames like NativeMethodAccessorImpl
            for (int i = 0; i < stacktrace.size(); i++) {
                StackTraceHolder holder = stacktrace.get(i);
                array.asArray().set(i, JavaClass.forName(_vm, holder.getClassNode().name).getOop());
            }

            return array;
        }));
    }
}
