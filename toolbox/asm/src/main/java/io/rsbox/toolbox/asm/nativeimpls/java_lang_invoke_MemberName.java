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

import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class java_lang_invoke_MemberName {
    public static JavaWrapper clazz(JavaWrapper memberName) {
        return memberName.asObject().getField("clazz", "Ljava/lang/Class;");
    }

    public static JavaWrapper name(JavaWrapper memberName) {
        return memberName.asObject().getField("name", "Ljava/lang/String;");
    }

    public static JavaWrapper type(JavaWrapper memberName) {
        return memberName.asObject().getField("type", "Ljava/lang/Object;");
    }

    public static int flags(JavaWrapper memberName) {
        return ((JavaObject) memberName.get()).getField("flags", "I").asInt();
    }

    public static void set_flags(JavaWrapper memberName, JavaWrapper flag) {
        memberName.asObject().setField("flags", "I", flag);
    }

    public static void set_vmtarget(JavaWrapper memberName, Object m) {
        memberName.asObject().setMetadata(JavaObject.VMTARGET, m);
    }

    public static void set_vmindex(JavaWrapper memberName, int vmindex) {
        memberName.asObject().setMetadata(JavaObject.VMINDEX, vmindex);
    }

    public static void set_clazz(JavaWrapper memberName, JavaWrapper oop) {
        memberName.asObject().setField("clazz", "Ljava/lang/Class;", oop);
    }

    public static void set_name(JavaWrapper memberName, JavaWrapper oop) {
        memberName.asObject().setField("name", "Ljava/lang/String;", oop);
    }

    public static void set_type(JavaWrapper memberName, JavaWrapper oop) {
        memberName.asObject().setField("type", "Ljava/lang/Object;", oop);
    }

    public static int vmindex(JavaWrapper memberName) {
        Integer x = (Integer) memberName.asObject().getMetadata(JavaObject.VMINDEX);
        return x == null ? 0 : x;
    }

    public static Object get_vmtarget(JavaWrapper vmentry) {
        return vmentry.asObject().getMetadata(JavaObject.VMTARGET);
    }
}
