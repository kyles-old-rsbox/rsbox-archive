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
import io.rsbox.toolbox.asm.utils.BiLongIntegerFunction;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.List;

public class LongIntegerMathInstruction extends Instruction {
    private final BiLongIntegerFunction _function;

    public LongIntegerMathInstruction(BiLongIntegerFunction function) {
        this._function = function;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        JavaValue b = stack.pop().get();
        JavaValue a = stack.pop().get();

        if (ExecutionUtils.areValuesUnknown(a, b)) {
            stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().LONG, JavaUnknown.UnknownCause.LONG_INTEGER_MATH, b, a)));
            return;
        }

        if (!b.is(JavaValueType.INTEGER)) {
            throw new ExecutionException("Expected to find integer on stack");
        }
        if (!a.is(JavaValueType.LONG)) {
            throw new ExecutionException("Expected to find long on stack");
        }

        stack.push(execution.getVM().newLong(_function.apply(a.asLong(), b.asInt())));
    }
}
