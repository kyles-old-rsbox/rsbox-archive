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

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.prim.JDouble;
import io.rsbox.toolbox.asm.values.prim.JFloat;
import io.rsbox.toolbox.asm.values.prim.JInteger;
import io.rsbox.toolbox.asm.values.prim.JPrimitive;

import java.util.Map;

public class JavaWrapper extends JavaValue {

    private JavaValue _value;

    private JavaWrapper(JavaValue value) {
        this._value = value;
    }

    public static JavaWrapper wrap(JavaValue value) {
        return new JavaWrapper(value);
    }

    private static final JavaWrapper top = JavaWrapper.wrap(new JavaTop());

    public static JavaWrapper createTop() {
        return top;
    }

    public static JavaWrapper createUninitialized(JavaClass orig, String descType) {
        return JavaWrapper.wrap(new JavaUninitialized(orig, descType));
    }

    @Deprecated
    public static JavaWrapper createInteger(VirtualMachine vm, int value) {
        return JavaWrapper.wrap(new JInteger(vm, value));
    }

    @Deprecated
    public static JavaWrapper createFloat(VirtualMachine vm, float value) {
        return JavaWrapper.wrap(new JFloat(vm, value));
    }

    @Deprecated
    public static JavaWrapper createDouble(VirtualMachine vm, double value) {
        return JavaWrapper.wrap(new JDouble(vm, value));
    }

    public static JavaWrapper createArray(JavaClass type, JavaWrapper[] values) {
        return wrap(new JavaArray(type, values));
    }

    public boolean is(JavaValueType type) {
        return _value.is(type);
    }

    public byte asByte() {
        return _value.asByte();
    }

    public char asChar() {
        return _value.asChar();
    }

    public short asShort() {
        return _value.asShort();
    }

    public int asInt() {
        return _value.asInt();
    }

    public float asFloat() {
        return _value.asFloat();
    }

    public double asDouble() {
        return _value.asDouble();
    }

    public long asLong() {
        return _value.asLong();
    }

    public boolean asBoolean() {
        return _value.asBoolean();
    }

    public JavaValue get() {
        return _value;
    }

    public void set(JavaValue value) {
        this._value = value;
    }

    @Override
    public String type() {
        return _value.type();
    }

    @Override
    public JavaClass getJavaClass() {
        return _value.getJavaClass();
    }


    public String toString() {
        return _value.toString();
    }

    @Override
    public int getSize() {
        return _value.getSize();
    }

    @Override
    public <T> T getMetadata(String key) {
        return _value.getMetadata(key);
    }

    @Override
    public void setMetadata(String key, Object data) {
        _value.setMetadata(key, data);
    }

    @Override
    public Map<String, Object> getMetadata() {
        return _value.getMetadata();
    }

    @Override
    public void setMetadata(Map<String, Object> metadata0) {
        _value.setMetadata(metadata0);
    }

    @Override
    public <T> T compareAndSwapMetadata(String key, T data, T expected) {
        return _value.compareAndSwapMetadata(key, data, expected);
    }

    public JavaObject asObject() {
        if (!(_value instanceof JavaObject)) {
            throw new ExecutionException("Unexpected value: " + _value);
        }
        return (JavaObject) _value;
    }

    public JPrimitive asPrimitive() {
        return (JPrimitive) _value;
    }

    public JavaArray asArray() {
        return (JavaArray) _value;
    }
}
