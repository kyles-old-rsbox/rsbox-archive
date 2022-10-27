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

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

public class StackTraceHolder {
    private ClassNode _class;
    private MethodNode _method;
    private AbstractInsnNode _instruction;

    public StackTraceHolder(ClassNode clazz, MethodNode method, AbstractInsnNode instruction) {
        this._class = clazz;
        this._method = method;
        this._instruction = instruction;
    }

    public ClassNode getClassNode() {
        return _class;
    }

    public MethodNode getMethod() {
        return _method;
    }

    public AbstractInsnNode getInstruction() {
        return _instruction;
    }

    public void setInstruction(AbstractInsnNode instruction) {
        this._instruction = instruction;
    }

    @Override
    public String toString() {
        return "at " + _class.name + "." + _method.name + _method.desc;
    }
}
