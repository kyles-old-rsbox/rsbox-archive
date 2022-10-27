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

package io.rsbox.toolbox.asm.internals;

import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaField;

import java.lang.reflect.Modifier;

public class FieldDescriptor {
    private int flags; // todo make accessflags
    private int index;
    private Object constantPool;
    // javavm
    private JavaField field;

    public FieldDescriptor() {

    }

    public void reinitialize(JavaClass klass, int index) {
        flags = klass.getFieldById(index).getFieldNode().access;
        field = klass.getFieldById(index);
        this.index = index;
    }

    public int getFlags() {
        return flags;
    }

    public int getIndex() {
        return index;
    }

    public boolean is_static() {
        return Modifier.isStatic(flags);
    }

    public JavaClass fieldHolder() {
        return field.getDeclaringClass();
    }

    public String signature() {
        return field.getFieldNode().desc;
    }

    public String name() {
        return field.getFieldNode().name;
    }

    public boolean hasField() {
        return field != null;
    }
}
