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
import io.rsbox.toolbox.asm.utils.MaybeBoolean;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;

import java.util.List;
import java.util.function.BiFunction;

public class DoublePredicateInstruction extends Instruction {

    private final BiFunction<JavaWrapper, JavaWrapper, MaybeBoolean> _handler;

    public DoublePredicateInstruction(BiFunction<JavaWrapper, JavaWrapper, MaybeBoolean> handler) {
        this._handler = handler;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        JumpInsnNode jumpInsnNode = (JumpInsnNode) currentInsn;

        JavaWrapper top = stack.pop();
        JavaWrapper bottom = stack.pop();
        MaybeBoolean result = _handler.apply(bottom, top);
        switch (result) {
            case YES:
                branchTo.add(jumpInsnNode.label);
                break;
            case MAYBE:
                branchTo.add(jumpInsnNode.label);
                branchTo.add(jumpInsnNode.getNext());
                break;
            case NO:
                break;
        }
    }
}
