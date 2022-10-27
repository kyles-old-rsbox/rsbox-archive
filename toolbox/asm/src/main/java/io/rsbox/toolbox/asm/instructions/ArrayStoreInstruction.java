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
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.List;

public class ArrayStoreInstruction extends Instruction {
    private final int _sort;

    public ArrayStoreInstruction(int sort) {
        if (sort == Type.VOID || sort == Type.ARRAY || sort == Type.METHOD) {
            throw new InternalError("Tried to register ArrayStoreInstruction with illegal sort: " + sort);
        }
        this._sort = sort;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        JavaWrapper storeValue = stack.pop();
        JavaWrapper arrayIndexValue = stack.pop();
        JavaWrapper arrayValue = stack.pop();

        if (!arrayValue.is(JavaValueType.ARRAY)) {
            throw new ExecutionException("Expecting to find Array on type, instead found " + arrayValue.getJavaClass() + " on " + arrayValue);
        }

        if (ExecutionUtils.areValuesUnknown(arrayValue, arrayIndexValue)) {
            if (arrayValue.is(JavaValueType.UNKNOWN)) {
                ((JavaUnknown) arrayValue.get()).merge("Array store operation on this at " + arrayIndexValue + " value " + storeValue);
            } else if (arrayIndexValue.is(JavaValueType.UNKNOWN)) {
                arrayValue.set(new JavaUnknown(execution.getVM(), arrayValue.getJavaClass(), "Array store operation"));
            } else {
                throw new ExecutionException("An internal error occurred: Unhandled condition");
            }
            return;
        }

        if (!arrayIndexValue.is(JavaValueType.INTEGER)) {
            throw new ExecutionException("Expecting to find Integer on stack");
        }
        if (!arrayValue.is(JavaValueType.ARRAY)) {
            throw new ExecutionException("Expecting to find Array on stack, found " + arrayValue);
        }

        int index = arrayIndexValue.asInt();
        JavaArray array = ((JavaArray) arrayValue.get());

        array.set(index, storeValue);
    }
}
