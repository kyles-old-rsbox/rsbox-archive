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
import io.rsbox.toolbox.asm.utils.BiDoubleFunction;
import io.rsbox.toolbox.asm.utils.ExecutionUtils;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.List;

public class DoubleMathInstruction extends Instruction {
    private final BiDoubleFunction _function;
    private final boolean _returnInt;

    public DoubleMathInstruction(BiDoubleFunction function, boolean returnInt) {
        this._function = function;
        this._returnInt = returnInt;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        JavaValue b = stack.pop().get();
        JavaValue a = stack.pop().get();

        if (ExecutionUtils.areValuesUnknown(a, b)) {
            stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().DOUBLE, JavaUnknown.UnknownCause.DOUBLE_MATH, b, a)));
            return;
        }

        if (!a.is(JavaValueType.DOUBLE) || !b.is(JavaValueType.DOUBLE)) {
            throw new ExecutionException("Expected to find double on stack");
        }

        double result = _function.apply(a.asDouble(), b.asDouble());
        if (!_returnInt) {
            stack.push(JavaWrapper.createDouble(execution.getVM(), result));
        } else {
            stack.push(JavaWrapper.createInteger(execution.getVM(), (int) result));
        }
    }
}
