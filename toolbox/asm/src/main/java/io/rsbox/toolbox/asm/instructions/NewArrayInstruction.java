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
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.ArrayHelper;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.IntInsnNode;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public class NewArrayInstruction extends Instruction {
    private static Type[] MAPPING = new Type[12];

    static {
        MAPPING[T_BOOLEAN] = Type.BOOLEAN_TYPE;
        MAPPING[T_CHAR] = Type.CHAR_TYPE;
        MAPPING[T_FLOAT] = Type.FLOAT_TYPE;
        MAPPING[T_DOUBLE] = Type.DOUBLE_TYPE;
        MAPPING[T_BYTE] = Type.BYTE_TYPE;
        MAPPING[T_SHORT] = Type.SHORT_TYPE;
        MAPPING[T_INT] = Type.INT_TYPE;
        MAPPING[T_LONG] = Type.LONG_TYPE;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        IntInsnNode cast = (IntInsnNode) currentInsn;

        JavaValue lengthValue = stack.pop().get();

        if (!lengthValue.is(JavaValueType.UNKNOWN)) {
            stack.push(ArrayHelper.newInstance(execution.getVM(), MAPPING[cast.operand], lengthValue.asInt()));
        } else {
            stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), JavaClass.forName(execution.getVM(), MAPPING[cast.operand]), JavaUnknown.UnknownCause.ANEWARRAY, lengthValue)));
        }
    }
}
