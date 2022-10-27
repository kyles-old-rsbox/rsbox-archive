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

package io.rsbox.toolbox.asm.values.prim;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaValueType;
import org.objectweb.asm.Type;

public final class JInteger extends JPrimitive {
    private final VirtualMachine _vm;

    private final Type _type; // can be INTEGER, CHARACTER, SHORT, BYTE, BOOLEAN
    private final int _value;

    @Deprecated
    public JInteger(VirtualMachine vm, int value) {
        this._vm = vm;
        this._value = value;
        _type = null;
    }

    public JInteger(VirtualMachine vm, Type type, int value) {
        _vm = vm;
        _type = type;
        _value = value;
    }

    @Override
    public final boolean asBoolean() {
        return this._value != 0;
    }

    @Override
    public final char asChar() {
        return (char) _value;
    }

    @Override
    public final byte asByte() {
        return (byte) _value;
    }

    @Override
    public final short asShort() {
        return (short) _value;
    }

    @Override
    public final int asInt() {
        return (int) _value;
    }

    @Override
    public final float asFloat() {
        return (float) _value;
    }

    @Override
    public final long asLong() {
        return (long) _value;
    }

    @Override
    public final double asDouble() {
        return (double) _value;
    }

    @Override
    public final int getSize() {
        return 1;
    }

    @Override
    public final JavaClass getJavaClass() {
        return _vm.INTEGER;
    }

    public final Type getType() {
        return _type;
    }

    @Override
    public final Object rawValue() {
        return _value;
    }

    @Override
    public final String toString() {
        return "JavaInteger(value=" + _value + ")";
    }

    @Override
    public boolean is(JavaValueType type) {
        return type == JavaValueType.PRIMITIVE || type == JavaValueType.INTEGER || type == JavaValueType.BOOLEAN || type == JavaValueType.BYTE || type == JavaValueType.CHARACTER || type == JavaValueType.SHORT;
    }
}
