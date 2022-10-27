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

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveUtils {
    private static final Map<String, Class<?>> nameToPrimitive = new HashMap<>();
    private static final Map<Class<?>, Object> defaultPrimitiveValues = new HashMap<>();

    static {
        defaultPrimitiveValues.put(Integer.TYPE, 0);
        defaultPrimitiveValues.put(Long.TYPE, 0L);
        defaultPrimitiveValues.put(Double.TYPE, 0D);
        defaultPrimitiveValues.put(Float.TYPE, 0F);
        defaultPrimitiveValues.put(Boolean.TYPE, false);
        defaultPrimitiveValues.put(Character.TYPE, '\0');
        defaultPrimitiveValues.put(Byte.TYPE, (byte) 0);
        defaultPrimitiveValues.put(Short.TYPE, (short) 0);
        defaultPrimitiveValues.put(Object.class, null);
        nameToPrimitive.put("int", Integer.TYPE);
        nameToPrimitive.put("long", Long.TYPE);
        nameToPrimitive.put("double", Double.TYPE);
        nameToPrimitive.put("float", Float.TYPE);
        nameToPrimitive.put("boolean", Boolean.TYPE);
        nameToPrimitive.put("char", Character.TYPE);
        nameToPrimitive.put("byte", Byte.TYPE);
        nameToPrimitive.put("short", Short.TYPE);
        nameToPrimitive.put("void", Void.TYPE);
    }

    public static Class<?> getPrimitiveByName(String name) {
        return nameToPrimitive.get(name);
    }

    public static Object getDefaultValue(Class<?> primitive) {
        return defaultPrimitiveValues.get(primitive);
    }

    public static Class<?> getPrimitiveByNewArrayId(int id) {
        switch (id) {
            case Opcodes.T_BOOLEAN:
                return boolean.class;
            case Opcodes.T_CHAR:
                return char.class;
            case Opcodes.T_FLOAT:
                return float.class;
            case Opcodes.T_DOUBLE:
                return double.class;
            case Opcodes.T_BYTE:
                return byte.class;
            case Opcodes.T_SHORT:
                return short.class;
            case Opcodes.T_INT:
                return int.class;
            case Opcodes.T_LONG:
                return long.class;
        }
        throw new IllegalArgumentException("Unknown type " + id);
    }

    public static boolean isPrimitive(Type type) {
        return type.getSort() >= Type.BOOLEAN && type.getSort() <= Type.DOUBLE;
    }
}
