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

package io.rsbox.toolbox.asm.values;

import io.rsbox.toolbox.asm.mirrors.JavaClass;

import java.util.EnumSet;

public class JavaUninitialized extends JavaValue {
    private static final EnumSet<JavaValueType> TYPES = EnumSet.of(JavaValueType.UNINITIALIZED);
    private final JavaClass _class;
    private final String _bytecodeType;
    private JavaObject value;
    public JavaUninitialized(JavaClass clazz, String originalType) {
        this._class = clazz;
        this._bytecodeType = originalType;
        this.value = new JavaObject(clazz, originalType);
    }

    @Override
    public boolean is(JavaValueType type) {
        return TYPES.contains(type);
    }

    public JavaObject initializedValue() {
        return this.value;
    }

    @Override
    public JavaClass getJavaClass() {
        return this._class;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String type() {
        return this._bytecodeType;
    }

    @Override
    public String toString() {
        return "JavaUninitialized(type=" + _bytecodeType + ", val=" + value + ")";
    }
}
