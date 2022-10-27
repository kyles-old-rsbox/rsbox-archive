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
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;

import java.util.List;

public class CheckcastInstruction extends Instruction {
    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        TypeInsnNode cast = (TypeInsnNode) currentInsn;

        Type desc = TypeHelper.parseType(execution.getVM(), cast.desc);
        JavaClass other = JavaClass.forName(execution.getVM(), desc);
        JavaWrapper wrappedValue = stack.pop();
        if (wrappedValue.is(JavaValueType.NULL)) {
            stack.push(wrappedValue);
            return;
        }

        stack.push(wrappedValue);
//        if (!wrappedValue.get().isInstanceOf(desc)) {
//            System.out.println(desc + " "+ other);
//            System.out.println(wrappedValue.getJavaClass().getName() + " cannot be cast to " + other.getName());
//            throw new ExecutionException("asdf"); //execution.getVM().newThrowable(VMSymbols.java_lang_ClassCastException, wrappedValue.getJavaClass().getName() + " cannot be cast to " + other.getName());
//        }
//
//        if (wrappedValue.get() instanceof JavaObject) {
//            stack.push(JavaWrapper.wrap(wrappedValue.asObject().checkcast(other)));
//        } else {
//            stack.push(JavaWrapper.wrap(wrappedValue.asArray().checkcast(other)));
//        }
    }
}
