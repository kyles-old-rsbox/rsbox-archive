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

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;

public class ArrayConversionHelper {
    public static JavaWrapper convert(VirtualMachine vm, Object array) {
        if (array == null) {
            return vm.getNull();
        }
        if (array instanceof Object[])
            return convertObjectArray(vm, (Object[]) array);
        if (array instanceof boolean[])
            return convertBooleanArray(vm, (boolean[]) array);
        if (array instanceof byte[])
            return convertByteArray(vm, (byte[]) array);
        if (array instanceof char[])
            return convertCharArray(vm, (char[]) array);
        if (array instanceof short[])
            return convertShortArray(vm, (short[]) array);
        if (array instanceof int[])
            return convertIntArray(vm, (int[]) array);
        if (array instanceof long[])
            return convertLongArray(vm, (long[]) array);
        if (array instanceof float[])
            return convertFloatArray(vm, (float[]) array);
        if (array instanceof double[])
            return convertDoubleArray(vm, (double[]) array);
        if (array == null)
            throw new NullPointerException();
        throw new IllegalArgumentException();
    }

    public static JavaWrapper convertBooleanArray(VirtualMachine vm, boolean[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = vm.newBoolean(array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[Z"), resultingArray);
    }

    public static JavaWrapper convertByteArray(VirtualMachine vm, byte[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = vm.newByte(array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[B"), resultingArray);
    }

    public static JavaWrapper convertCharArray(VirtualMachine vm, char[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = vm.newChar(array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[C"), resultingArray);
    }

    public static JavaWrapper convertShortArray(VirtualMachine vm, short[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = vm.newShort(array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[S"), resultingArray);
    }

    public static JavaWrapper convertIntArray(VirtualMachine vm, int[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = JavaWrapper.createInteger(vm, array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[I"), resultingArray);
    }

    public static JavaWrapper convertLongArray(VirtualMachine vm, long[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = vm.newLong(array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[J"), resultingArray);
    }

    public static JavaWrapper convertFloatArray(VirtualMachine vm, float[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = JavaWrapper.createFloat(vm, array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[F"), resultingArray);
    }

    public static JavaWrapper convertDoubleArray(VirtualMachine vm, double[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = JavaWrapper.createDouble(vm, array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, "[D"), resultingArray);
    }

    public static JavaWrapper convertObjectArray(VirtualMachine vm, Object[] array) {
        if (array == null) {
            return vm.getNull();
        }
        JavaWrapper[] resultingArray = new JavaWrapper[array.length];
        for (int i = 0; i < array.length; i++) {
            resultingArray[i] = convert(vm, array[i]);
        }
        return JavaWrapper.createArray(JavaClass.forName(vm, Type.getType(array.getClass())), resultingArray);
    }

    public static byte[] convertByteArray(JavaArray array) {
        byte[] resultingArray = new byte[array.length()];
        for (int i = 0; i < array.length(); i++) {
            resultingArray[i] = array.get(i).asByte();
        }
        return resultingArray;
    }

    public static char[] convertCharArray(JavaArray array) {
        char[] resultingArray = new char[array.length()];
        for (int i = 0; i < array.length(); i++) {
            resultingArray[i] = array.get(i).asChar();
        }
        return resultingArray;
    }

    public static int[] convertIntArray(JavaArray array) {
        int[] resultingArray = new int[array.length()];
        for (int i = 0; i < array.length(); i++) {
            resultingArray[i] = array.get(i).asInt();
        }
        return resultingArray;
    }
}
