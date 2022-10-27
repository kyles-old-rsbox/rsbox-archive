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
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaMethodHandle;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaUnknown;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Arrays;
import java.util.List;

public class InvocationInstruction extends Instruction {

    private final boolean _isStatic;

    public InvocationInstruction(boolean isStatic) {
        this._isStatic = isStatic;
    }

    @Override
    public void execute(MethodExecution execution, AbstractInsnNode currentInsn, Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
        MethodInsnNode cast = (MethodInsnNode) currentInsn;

        Type returnType = Type.getReturnType(cast.desc);

        JavaWrapper[] args = new JavaWrapper[TypeHelper.getNumberOfArguments(cast.desc)];
        for (int i = args.length - 1; i >= 0; i--) {
            args[i] = stack.pop();
        }

        JavaWrapper instance = null;
        if (!_isStatic) {
            instance = stack.pop();
            if (instance.is(JavaValueType.NULL)) {
                throw execution.getVM().newThrowable(VMSymbols.java_lang_NullPointerException);
            }
        }

        JavaWrapper provided;

        ClassNode targetNode;
        if (instance != null) { //bleh
            if (instance.getJavaClass().isArray()) {
                targetNode = execution.getVM().getSystemDictionary().getJavaLangObject().getClassNode();
            } else {
                targetNode = instance.asObject().getOriginalClass().getClassNode();
            }
        } else {
            targetNode = execution.getVM().lookupClass(cast.owner);
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

            VMSymbols.VMIntrinsics id = JavaMethodHandle.signaturePolymorphicNameId(cast.name);
            if (id != VMSymbols.VMIntrinsics.NONE) {
                if (cast.owner.equals("java/lang/invoke/MethodHandle")) {
                    targetNode = execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandle().getClassNode();
                    target = ASMHelper.findMethod(execution.getVM().getSystemDictionary().getJavaLangInvokeMethodHandle().getClassNode(), cast.name, cast.desc);
                    if (target == null) {
                        target = new MethodNode(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL | Opcodes.ACC_NATIVE, cast.name, cast.desc, null, null);
                        if (JavaMethodHandle.isIntrinsicStatic(id)) {
                            target.access |= Opcodes.ACC_STATIC;
                        }
                        targetNode.methods.add(target);
                        execution.getVM().getJavaLangInvokeMethodHandle().hookPolymorphicSignature(target);
                    }
                }
            }

            if (target != null) {
                if (_isStatic) {
                    execution.getVM().initialize(JavaClass.forName(execution.getVM(), targetNode.name));
                }
                provided = execution.getVM().internalExecute(targetNode, target, instance, args, currentInsn);

                if (returnType.getSort() != Type.VOID && provided == null) {
                    throw new ExecutionException("Null result from " + targetNode.name + " " + target.name + target.desc + " " + Arrays.toString(args));
                }
            } else {
                throw new ExecutionException("IncompatibleClassChangeError: Method not found " + cast.owner + "." + cast.name + "." + cast.desc);
            }
        } else {
            provided = JavaWrapper.wrap(new JavaUnknown(execution.getVM(), JavaClass.forName(execution.getVM(), returnType), "Invocation on " + cast.owner + " " + cast.name + cast.desc));
        }

        if (returnType.getSort() != Type.VOID) {
            // todo verify
            stack.push(provided);
        }
    }
}