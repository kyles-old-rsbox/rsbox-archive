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

package io.rsbox.toolbox.asm.instructions;

import io.rsbox.toolbox.asm.Locals;
import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.Stack;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import java.util.List;

public class LocalStoreInstruction extends Instruction {

    private final int _sort;

    public LocalStoreInstruction(int sort) {
        if (sort == Type.VOID || sort == Type.ARRAY || sort == Type.METHOD || sort == Type.BYTE || sort == Type.BOOLEAN || sort == Type.SHORT || sort == Type.CHAR) {
            throw new InternalError("Tried to register LocalStoreInstruction with illegal sort: " + sort);
        }
        this._sort = sort;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        VarInsnNode varInsnNode = (VarInsnNode) currentInsn;
        JavaWrapper top = stack.pop();

        switch (_sort) {
            case Type.INT:
                if (!top.is(JavaValueType.INTEGER)) {
                    throw new ExecutionException("Register " + varInsnNode.var + " contains wrong type. Expected INTEGER, got (" + top.get().getClass() + ")");
                }
                locals.set(varInsnNode.var, top);
                break;
            case Type.FLOAT:
                if (!top.is(JavaValueType.FLOAT)) {
                    throw new ExecutionException("Register " + varInsnNode.var + " contains wrong type. Expected FLOAT, got (" + top.get().getClass() + ")");
                }
                locals.set(varInsnNode.var, top);
                break;
            case Type.OBJECT:
                if (!top.is(JavaValueType.OBJECT) && !top.is(JavaValueType.UNINITIALIZED)) {
                    throw new ExecutionException("Register " + varInsnNode.var + " contains wrong type. Expected OBJECT, got (" + top.get().getClass() + ")");
                }
                locals.set(varInsnNode.var, top);
                break;
            case Type.DOUBLE:
                if (!top.is(JavaValueType.DOUBLE)) {
                    throw new ExecutionException("Register " + varInsnNode.var + " contains wrong type. Expected DOUBLE, got (" + top.get().getClass() + ")");
                }
                locals.set(varInsnNode.var, top);
                break;
            case Type.LONG:
                if (!top.is(JavaValueType.LONG)) {
                    throw new ExecutionException("Register " + varInsnNode.var + " contains wrong type. Expected LONG, got (" + top.get().getClass() + ")");
                }
                locals.set(varInsnNode.var, top);
                break;
            default:
                throw new ExecutionException("An internal error occurred: Unhandled sort " + _sort);
        }
    }
}
