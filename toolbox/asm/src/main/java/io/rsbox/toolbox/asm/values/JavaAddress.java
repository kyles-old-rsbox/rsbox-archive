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

import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.EnumSet;

public class JavaAddress extends JavaValue {
    private static final EnumSet<JavaValueType> TYPES = EnumSet.of(JavaValueType.ADDRESS);
    private final AbstractInsnNode value;


    public JavaAddress(AbstractInsnNode value) {
        this.value = value;
    }

    @Override
    public boolean is(JavaValueType type) {
        return TYPES.contains(type);
    }

    @Override
    public JavaClass getJavaClass() {
        throw new ExecutionException("cannot get class of javaaddress");
    }

    @Override
    public int getSize() {
        return 1;
    }

    public AbstractInsnNode getReturnAddres() {
        return value;
    }

    public String toString() {
        return "JavaAddress(addr=" + value + ")";
    }
}
