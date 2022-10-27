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

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_invoke_MethodType {
    public static boolean isInstance(VirtualMachine vm, JavaWrapper oop) {
        return oop != null && oop.getJavaClass() == vm.getSystemDictionary().getJavaLangInvokeMethodType();
    }

    public static String asSignature(JavaWrapper oop, boolean internIfNotFound) {
        StringBuilder stringBuilder = new StringBuilder();
        printSignature(oop, stringBuilder);

        return stringBuilder.toString();
    }

    public static JavaWrapper ptypes(JavaWrapper oop) {
        return ((JavaObject) oop.get()).getField("ptypes", "[Ljava/lang/Class;");
    }

    public static JavaWrapper rtype(JavaWrapper oop) {
        return ((JavaObject) oop.get()).getField("rtype", "Ljava/lang/Class;");
    }

    public static void printSignature(JavaWrapper oop, StringBuilder stringBuilder) {
        stringBuilder.append("(");

        JavaArray ptypes = ptypes(oop).asArray();
        for (int i = 0, limit = ptypes.length(); i < limit; i++) {
            java_lang_Class.printSignature(ptypes.get(i), stringBuilder);
        }

        stringBuilder.append(")");
        java_lang_Class.printSignature(rtype(oop), stringBuilder);
    }
}
