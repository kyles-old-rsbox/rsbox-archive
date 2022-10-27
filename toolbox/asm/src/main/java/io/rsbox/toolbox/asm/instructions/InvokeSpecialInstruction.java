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
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;
import java.util.List;

public class InvokeSpecialInstruction extends Instruction {
    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        MethodInsnNode cast = (MethodInsnNode) currentInsn;

        Type returnType = Type.getReturnType(cast.desc);

        JavaWrapper[] args = new JavaWrapper[TypeHelper.getNumberOfArguments(cast.desc)];
        for (int i = args.length - 1; i >= 0; i--) {
            args[i] = stack.pop();
        }

        JavaWrapper instance = stack.pop();

        JavaWrapper provided;
        ClassNode targetNode;

        ClassNode specifiedClass = execution.getVM().lookupClass(cast.owner);
        if (cast.name.equals("<init>")) {
            // sometimes we might not be able to resolve the class because the instance is Unsafe.defineAnonymousClass()'d
            // therefore, we load it from the instance itself when possible
            if (cast.owner.equals(instance.getJavaClass().getClassNode().name)) {
                targetNode = instance.getJavaClass().getClassNode();
            } else {
                targetNode = specifiedClass;
            }
        } else if (Modifier.isInterface(specifiedClass.access) || !execution.getClassNode().superName.equals(cast.owner)) {
            targetNode = specifiedClass;
        } else if ((execution.getClassNode().access & Opcodes.ACC_SUPER) != Opcodes.ACC_SUPER) {
            targetNode = specifiedClass;
        } else {
            targetNode = execution.getVM().lookupClass(execution.getClassNode().superName);
        }
        if (targetNode != null) {
            MethodNode target = ASMHelper.findMethod(targetNode, cast.name, cast.desc);
            while (target == null) {
                // todo permissionssssssss
                if (targetNode.name.equalsIgnoreCase("java/lang/Object"))
                    break;
                targetNode = execution.getVM().lookupClass(targetNode.superName);
                if (targetNode == null)
                    break;
                target = ASMHelper.findMethod(targetNode, cast.name, cast.desc);
            }

            if (target != null) {
                provided = execution.getVM().internalExecute(targetNode, target, instance, args, currentInsn);
            } else {
                throw new ExecutionException("IncompatibleClassChangeError: Method not found " + cast.owner + "." + cast.name + "." + cast.desc);
            }
        } else {
            if (cast.name.equals("<init>")) {
                throw new ExecutionException("Could not initialize class " + cast.owner + " " + cast.name + cast.desc);
            }
            provided = JavaWrapper.wrap(new JavaUnknown(execution.getVM(), JavaClass.forName(execution.getVM(), returnType), "Invocation on " + cast.owner + " " + cast.name + cast.desc));
        }


        if (returnType.getSort() != Type.VOID) {
            stack.push(provided);
        }
    }
}