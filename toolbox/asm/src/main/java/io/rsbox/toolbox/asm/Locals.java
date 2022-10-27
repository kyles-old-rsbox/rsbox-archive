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

package io.rsbox.toolbox.asm;

import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class Locals {
    public JavaWrapper[] _values = new JavaWrapper[16];

    public JavaWrapper get(int index) {
        if (index >= _values.length) {
            throw new ExecutionException("Illegal local variable number");
        }
        JavaWrapper value = _values[index];
        if (value == null) {
            throw new ExecutionException("Accessing value from uninitialized register " + index);
        }
        return value;
    }

    public JavaWrapper remove(int index) {
        if (index >= _values.length) {
            throw new ExecutionException("Illegal local variable number");
        }
        JavaWrapper value = _values[index];
        if (value == null) {
            throw new ExecutionException("Accessing value from uninitialized register " + index);
        }
        _values[index] = null;
        return value;
    }

    public void set(int index, JavaWrapper value) {
        if (index >= _values.length) {
            int newSize = (1 << (Integer.highestOneBit(_values.length) + 1));
            JavaWrapper[] copy = new JavaWrapper[newSize];
            System.arraycopy(_values, 0, copy, 0, _values.length);
            _values = copy;
        }

        _values[index] = value;
    }

    public int size() {
        return _values.length;
    }

    JavaWrapper[] internalArray() {
        JavaWrapper[] copy = new JavaWrapper[_values.length];
        System.arraycopy(_values, 0, copy, 0, _values.length);
        return copy;
    }

    public Locals copy() {
        Locals newLocals = new Locals();
        newLocals._values = new JavaWrapper[_values.length];
        for (int i = 0; i < _values.length; i++) {
            newLocals._values[i] = _values[i];
        }
        return newLocals;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < _values.length; i++) {
            if (_values[i] != null) {
                builder.append(i).append(": ").append(_values[i].get()).append(" ");
            }
        }
        return builder.toString();
    }
}
