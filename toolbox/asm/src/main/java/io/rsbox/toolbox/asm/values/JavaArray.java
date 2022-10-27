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

public class JavaArray extends JavaValue {

    private JavaClass originalClazz;
    private JavaClass clazz;
    private JavaWrapper[] values;

    public JavaArray(JavaClass clazz, JavaWrapper[] values) {
        this.originalClazz = clazz;
        this.clazz = clazz;
        this.values = values;
    }

    @Override
    public boolean is(JavaValueType type) {
        return type == JavaValueType.ARRAY || type == JavaValueType.OBJECT;
    }

    @Override
    public JavaClass getJavaClass() {
        return this.clazz;
    }

    @Override
    public JavaClass getOriginalClass() {
        return this.originalClazz;
    }

    @Override
    public int getSize() {
        return 1;
    }

    public void set(int index, JavaWrapper copy) {
        values[index] = copy;
    }

    public JavaWrapper get(int index) {
        JavaWrapper val = values[index];
        return val == null ? JavaValue.forPrimitive(clazz.getVM(), clazz.internalGetType()) : val;
    }

    public int length() {
        return values.length;
    }

    public JavaWrapper[] rawArray() {
        return this.values;
    }

    public JavaValue checkcast(JavaClass other) {
        this.clazz = other;
        return this;
    }
}
