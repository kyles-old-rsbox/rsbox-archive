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

import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.Map;

public class MethodExecution {
    private final VirtualMachine _virtualMachine;
    private final ClassNode _classNode;
    private final MethodNode _methodNode;
    private final ExecutionOptions _options;

    private final InstructionSnapshot[] _instructions;
    public Map<AbstractInsnNode, Integer> Visited = new HashMap<>();
    private JavaWrapper _returnValue;

    public MethodExecution(VirtualMachine vm, ClassNode classNode, MethodNode methodNode, ExecutionOptions options) {
        this._virtualMachine = vm;
        this._classNode = classNode;
        this._methodNode = methodNode;
        this._instructions = new InstructionSnapshot[methodNode.instructions.size()];
        this._options = options;
    }

    public InstructionSnapshot[] getInstructions() {
        return this._instructions;
    }

    public ClassNode getClassNode() {
        return this._classNode;
    }

    public MethodNode getMethodNode() {
        return this._methodNode;
    }

    public ExecutionOptions getOptions() {
        return this._options;
    }

    public JavaWrapper getReturnValue() {
        return this._returnValue;
    }

    void setReturnValue(JavaWrapper value) {
        this._returnValue = value;
    }

    public VirtualMachine getVM() {
        return _virtualMachine;
    }
}
