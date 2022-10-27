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
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;

import java.util.List;

public class LdcInstruction extends Instruction {
    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        LdcInsnNode cast = (LdcInsnNode) currentInsn;

        Object load = cast.cst;
        if (load instanceof Type) {
            Type type = (Type) load;
            if (type.getSort() == Type.OBJECT || type.getSort() == Type.ARRAY) {
                String bytecodeName = type.getInternalName();
                Type actualType = TypeHelper.parseType(execution.getVM(), bytecodeName);
                if (actualType == null) {
                    throw new ExecutionException("An internal error occurred: Unexpected null Type while loading class");
                }
                stack.push(JavaClass.forName(execution.getVM(), actualType).getOop());
            } else {
                throw new ExecutionException("An internal error occurred: Unexpected sort on loaded type: " + load);
            }
        } else if (load instanceof Integer) {
            stack.push(JavaWrapper.createInteger(execution.getVM(), (Integer) load));
        } else if (load instanceof Float) {
            stack.push(JavaWrapper.createFloat(execution.getVM(), (Float) load));
        } else if (load instanceof Double) {
            stack.push(JavaWrapper.createDouble(execution.getVM(), (Double) load));
        } else if (load instanceof Long) {
            stack.push(execution.getVM().newLong((Long) load));
        } else if (load instanceof String) {
            stack.push(execution.getVM().getStringInterned((String) load));
        } else {
            throw new ExecutionException("An internal error occurred: Unexpected ldc type " + (load == null ? "null" : load.getClass()));
        }
    }
}
