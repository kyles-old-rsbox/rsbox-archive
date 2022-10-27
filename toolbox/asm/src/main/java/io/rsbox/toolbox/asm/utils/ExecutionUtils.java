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

package io.rsbox.toolbox.asm.utils;

import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.util.List;

public class ExecutionUtils {
    public static boolean areValuesUnknown(JavaValue instance, List<JavaValue> args) {
        if (instance.is(JavaValueType.UNKNOWN))
            return true;
        for (JavaValue value : args) {
            if (value.is(JavaValueType.UNKNOWN)) {
                return true;
            }
        }

        return false;
    }

    public static boolean areValuesUnknown(JavaValue... args) {
        for (JavaValue value : args) {
            if (value.is(JavaValueType.UNKNOWN)) {
                return true;
            }
        }

        return false;
    }

    public static boolean areValuesUnknown(JavaWrapper instance, JavaWrapper[] args) {
        if (instance != null && instance.get().is(JavaValueType.UNKNOWN))
            return true;
        if (args != null)
            for (JavaWrapper value : args) {
                if (value.get().is(JavaValueType.UNKNOWN)) {
                    return true;
                }
            }

        return false;
    }

    public static boolean areValuesUnknown(JavaWrapper instance, List<JavaWrapper> args) {
        if (instance != null && instance.get().is(JavaValueType.UNKNOWN))
            return true;
        if (args != null)
            for (JavaWrapper value : args) {
                if (value.get().is(JavaValueType.UNKNOWN)) {
                    return true;
                }
            }

        return false;
    }

    public static boolean areValuesUnknown(List<JavaWrapper> args) {
        for (JavaWrapper value : args) {
            if (value.get().is(JavaValueType.UNKNOWN)) {
                return true;
            }
        }

        return false;
    }

    public static boolean areValuesUnknown(JavaWrapper... args) {
        for (JavaWrapper value : args) {
            if (value != null && value.get().is(JavaValueType.UNKNOWN)) {
                return true;
            }
        }

        return false;
    }

//    public static String hash(String owner, String name, String desc) {
//        return owner + "." + name + "." + desc;
//    }
//
//    public static JavaValue[] convert(Object[] arr, JavaClass type, String orig) {
//        JavaValue[] converted = new JavaValue[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            converted[i] = new JavaObject(arr[i], type, orig);
//        }
//        return converted;
//    }
//
//    public static <T> T[] convert(JavaValue[] arr, Class<T> type) {
//        T[] t = (T[]) ArrayHelper.newInstance(type, arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            t[i] = (T) arr[i].value();
//        }
//        return t;
//    }
}
