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
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;

/**
 * Array holds static helper functions that allow you to create and
 * manipulate arrays by reflection. Operations know how to perform widening
 * conversions, but throw {@link IllegalArgumentException} if you attempt
 * a narrowing conversion. Also, when accessing primitive arrays, this
 * class performs object wrapping and unwrapping as necessary.<p>
 * <p>
 * <B>Note:</B> This class returns and accepts types as Classes, even
 * primitive types; there are Class types defined that represent each
 * different primitive type.  They are <code>java.lang.Boolean.TYPE,
 * java.lang.Byte.TYPE,</code>, also available as <code>boolean.class,
 * byte.class</code>, etc.  These are not to be confused with the
 * classes <code>java.lang.Boolean, java.lang.Byte</code>, etc., which are
 * real classes. Note also that the shorthand <code>Object[].class</code>
 * is a convenient way to get array Classes.<p>
 * <p>
 * <B>Performance note:</B> This class performs best when it does not have
 * to convert primitive types.  The further along the chain it has to convert,
 * the worse performance will be.  You're best off using the array as whatever
 * type it already is, and then converting the result.  You will do even
 * worse if you do this and use the generic set() function.
 *
 * @author John Keiser
 * @author Eric Blake (ebb9@email.byu.edu)
 * @author Per Bothner (bothner@cygnus.com)
 * @status updated to 1.4
 * @see java.lang.Boolean#TYPE
 * @see java.lang.Byte#TYPE
 * @see java.lang.Short#TYPE
 * @see java.lang.Character#TYPE
 * @see java.lang.Integer#TYPE
 * @see java.lang.Long#TYPE
 * @see java.lang.Float#TYPE
 * @see java.lang.Double#TYPE
 * @since 1.1
 */
public final class ArrayHelper {

    // todo just create it
    public static JavaWrapper newInstance(VirtualMachine vm, Type type, int length) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
                return ArrayConversionHelper.convertBooleanArray(vm, new boolean[length]);
            case Type.BYTE:
                return ArrayConversionHelper.convertByteArray(vm, new byte[length]);
            case Type.CHAR:
                return ArrayConversionHelper.convertCharArray(vm, new char[length]);
            case Type.SHORT:
                return ArrayConversionHelper.convertShortArray(vm, new short[length]);
            case Type.INT:
                return ArrayConversionHelper.convertIntArray(vm, new int[length]);
            case Type.LONG:
                return ArrayConversionHelper.convertLongArray(vm, new long[length]);
            case Type.FLOAT:
                return ArrayConversionHelper.convertFloatArray(vm, new float[length]);
            case Type.DOUBLE:
                return ArrayConversionHelper.convertDoubleArray(vm, new double[length]);
            case Type.OBJECT:
            case Type.ARRAY:
                return JavaWrapper.createArray(JavaClass.forName(vm, "[" + type.getDescriptor()), new JavaWrapper[length]);
        }
        // assert componentType == void.class
        throw new ExecutionException("Unexpected " + type);
    }

    private static JavaWrapper createMultiArray(VirtualMachine vm, Type type, int[] dimensions, int index) {
        JavaWrapper retval = newInstance(vm, Type.getType(type.getDescriptor().substring(1)), dimensions[index]);
        if (index == dimensions.length - 1)
            return retval;
        for (int i = 0; i < dimensions[index]; i++) {
            retval.asArray().set(i, createMultiArray(vm, Type.getType(type.getDescriptor().substring(1)), dimensions, index + 1));
        }
        return retval;
    }

    public static JavaWrapper newInstance(VirtualMachine vm, Type componentType, int[] dimensions) {
        if (dimensions.length <= 0)
            throw new IllegalArgumentException("Empty dimensions array.");
        return createMultiArray(vm, componentType, dimensions, 0);
    }
}