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

public class JDouble extends JPrimitive {
    private final VirtualMachine _vm;

    private final double _value;

    public JDouble(VirtualMachine vm, double value) {
        this._value = value;
        this._vm = vm;
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
        return 2;
    }

    @Override
    public final JavaClass getJavaClass() {
        return _vm.DOUBLE;
    }

    public final Type getType() {
        return Type.DOUBLE_TYPE;
    }

    @Override
    public final Object rawValue() {
        return _value;
    }

    @Override
    public final String toString() {
        return "JavaDouble(value=" + _value + ")";
    }

    @Override
    public boolean is(JavaValueType type) {
        return type == JavaValueType.PRIMITIVE || type == JavaValueType.DOUBLE || type == JavaValueType.WIDE;
    }
}
