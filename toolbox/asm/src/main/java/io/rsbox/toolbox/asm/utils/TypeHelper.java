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
import org.objectweb.asm.Type;

import java.util.HashSet;
import java.util.Set;

/**
 * Because Java is absolutely crazy with its lack of verification of class names once you're at the bytecode level
 * and its' smart idea to have primitives be their own little thing, names get really complicated, really fast
 */
public class TypeHelper {
    private static final Set<String> PRIMITIVE_CLASS_NAMES = new HashSet<>();

    static {
        PRIMITIVE_CLASS_NAMES.add("int");
        PRIMITIVE_CLASS_NAMES.add("long");
        PRIMITIVE_CLASS_NAMES.add("double");
        PRIMITIVE_CLASS_NAMES.add("float");
        PRIMITIVE_CLASS_NAMES.add("boolean");
        PRIMITIVE_CLASS_NAMES.add("char");
        PRIMITIVE_CLASS_NAMES.add("byte");
        PRIMITIVE_CLASS_NAMES.add("short");
        PRIMITIVE_CLASS_NAMES.add("void");
    }

    private TypeHelper() {

    }

    public static int getNumberOfArguments(String methodDesc) {
        char[] buf = methodDesc.toCharArray();

        int off = 1;
        int size = 0;
        while (true) {
            char car = buf[off++];
            if (car == ')') {
                break;
            } else if (car == 'L') {
                while (buf[off++] != ';') ;
                ++size;
            } else if (car != '[') {
                ++size;
            }
        }

        return size;
    }

    /**
     * Attempts to parse a type descriptor independent of whether it is an internal name or a descriptor.
     * What could possibly go wrong?
     *
     * @param name
     * @return
     */
    public static Type parseType(VirtualMachine virtualMachine, String name) {
        if (PRIMITIVE_CLASS_NAMES.contains(name)) {
            if (virtualMachine.lookupClass(name) != null) {
                return Type.getObjectType(name);
            } else {
                return null;
            }
        }
        Type type = getTypeByInternalName(virtualMachine, name);
        if (type == null) {
            return getTypeByDescriptor(name);
        } else {
            return type;
        }
    }

    public static String getInternalName(Type type) {
        if (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY) {
            String asmInternalName = type.getInternalName();
            if (asmInternalName.charAt(0) == '[') {
                int off = 1;
                while (asmInternalName.charAt(off) == '[') {
                    off++;
                }
                return asmInternalName.substring(off, asmInternalName.length() - 1);
            } else if (asmInternalName.charAt(0) == 'L' && asmInternalName.charAt(asmInternalName.length() - 1) == ';') {
                return asmInternalName.substring(1, asmInternalName.length() - 1);
            } else {
                return asmInternalName;
            }
        }
        return null;
    }

    public static Type getTypeByDescriptor(String desc) {
        return Type.getType(desc);
    }

    public static Type getTypeByInternalName(VirtualMachine virtualMachine, String internalName) {
        // Is array
        if (internalName.charAt(0) == '[') {
            return getTypeByDescriptor(internalName);
        }
        for (char c : internalName.toCharArray()) {
            if (c == '[' || c == ';' || c == '.') {
                return null;
            }
        }
        if (PRIMITIVE_CLASS_NAMES.contains(internalName)) {
            if (virtualMachine.lookupClass(internalName) != null) {
                return Type.getObjectType(internalName);
            } else {
                return null;
            }
        }
        return Type.getObjectType(internalName);
    }

    /**
     * Gets a type based on the fully-qualified-name. Needs a copy of the {@link VirtualMachine} that this applies to
     * Why? You can load a class called <code>int</code> and then suddenly <code>int</code> is a valid FQN.
     * <p>
     * Fortunately, {@link Class#getPrimitiveClass(String)} is sane and will always resolve to the right <code>int</code>
     * class
     * <p>
     * This method should emulate the behaviour of {@link Class#forName(String)};
     * <p>
     * Note: {@link Class#forName(String)} with a parameter of <code>name[]</code> does not resolve
     *
     * @param virtualMachine The VM that this lookup belongs to
     * @param fqn            The fully-qualified-name of the target
     * @return A {@link Type} representing the FQN, or null if the FQN is illegal
     */
    public static Type getTypeByFQN(VirtualMachine virtualMachine, String fqn) {
        if (fqn.endsWith("[]")) {
            return null;
        }
        if (PRIMITIVE_CLASS_NAMES.contains(fqn)) {
            if (virtualMachine.lookupClass(fqn) != null) {
                return Type.getObjectType(fqn);
            } else {
                return null;
            }
        }
        return Type.getObjectType(fqn.replace('.', '/'));
    }
}
