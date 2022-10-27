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

package io.rsbox.toolbox.asm.mirrors;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class JavaMethod extends JavaExecutable {
    public static final int itable_index_max = -10; // first itable index, growing downward
    public static final int pending_itable_index = -9;  // itable index will be assigned
    public static final int invalid_vtable_index = -4;  // distinct from any valid vtable index
    public static final int garbage_vtable_index = -3;  // not yet linked; no vtable layout yet
    public static final int nonvirtual_vtable_index = -2;  // there is no need for vtable dispatch
    static final int BRIDGE = 0x00000040;
    static final int VARARGS = 0x00000080;
    static final int SYNTHETIC = 0x00001000;
    private final JavaClass clazz;
    private final MethodNode method;
    private JavaClass[] _exceptionTypes;
    private JavaClass[] _parameterTypes;

    public JavaMethod(JavaClass klass, MethodNode methodNode) {
        this.clazz = klass;
        this.method = methodNode;
    }

    public static JavaMethod makeMethodHandleIntrinsic(VirtualMachine vm, VMSymbols.VMIntrinsics id, String signature) {
        String name = JavaMethodHandle.signaturePolymorphicIntrinsicName(id);

        // todo there's some constantpool stuff too?

        int flags = Opcodes.ACC_NATIVE | Opcodes.ACC_SYNTHETIC | Opcodes.ACC_FINAL;
        boolean mustBeStatic = JavaMethodHandle.isSignaturePolymorphicStatic(id);
        if (mustBeStatic) {
            flags |= Opcodes.ACC_STATIC;
        }

        MethodNode mn = new MethodNode();
        mn.access = flags;
        mn.name = name;
        mn.desc = signature;

        // todo other stuff?

        return new JavaMethod(vm.getSystemDictionary().getJavaLangInvokeMethodHandle(), mn);
    }

    public String getName() {
        return method.name;
    }

    public JavaClass getReturnType() {
        return JavaClass.forName(getDeclaringClass().getVM(), Type.getReturnType(method.desc));
    }

    public JavaClass[] getExceptionTypes() {
        JavaClass[] exceptionTypes = this._exceptionTypes;
        if (exceptionTypes == null)
            this._exceptionTypes = exceptionTypes = getExceptionTypes0();
        return exceptionTypes;
    }

//    @Override
//    public int hashCode() {
//        return getDeclaringClass().getName().hashCode() ^ getName().hashCode();
//    }

    private JavaClass[] getExceptionTypes0() {
        List<JavaClass> params = new ArrayList<>();

        if (method.exceptions != null) {
            for (String string : method.exceptions) {
                Type type = TypeHelper.parseType(getDeclaringClass().getVM(), string);
                params.add(JavaClass.forName(getDeclaringClass().getVM(), type));
            }
        }
        return params.toArray(new JavaClass[params.size()]);
    }

    public JavaClass[] getParameterTypes() {
        JavaClass[] parameterTypes = this._parameterTypes;
        if (parameterTypes == null)
            this._parameterTypes = parameterTypes = getParameterTypes0();
        return parameterTypes.clone();
    }

    private JavaClass[] getParameterTypes0() {
        List<JavaClass> params = new ArrayList<>();
        for (Type type : Type.getArgumentTypes(method.desc)) {
            JavaClass param = JavaClass.forName(clazz.getVM(), type);
            if (param == null) {
                throw new ExecutionException("null param " + type);
            }
            params.add(param);
        }
        return params.toArray(new JavaClass[params.size()]);
    }

    public JavaClass getDeclaringClass() {
        return this.clazz;
    }

    public MethodNode getMethodNode() {
        return this.method;
    }

    public int getModifiers() {
        int rawModifiers = this.method.access;
        rawModifiers &= VirtualMachine.JVM_RECOGNIZED_METHOD_MODIFIERS;
        return rawModifiers;
    }

    public Object invoke(JavaValue instance, Object[] args) {
        try {
            List<JavaValue> argsobjects = new ArrayList<>();
            if (args != null) {
                for (Object o : args) {
                    // I think this should be the case?
                    argsobjects.add((JavaValue) o);
                }
            }

//            if (this.clazz.getContext().provider.canInvokeMethod(this.clazz.getWrappedClassNode().classNode.name, this.method.name, this.method.desc, instance, argsobjects, this.clazz.getContext())) {
//                return this.clazz.getContext().provider.invokeMethod(this.clazz.getWrappedClassNode().classNode.name, this.method.name, this.method.desc, instance, argsobjects, this.clazz.getContext());
//            }
        } catch (ExecutionException ex) {
            throw ex;
        } catch (Throwable t) {
            throw new ExecutionException(t);
        }
        throw new ExecutionException("Could not invoke " + this.clazz.getName() + " " + method.name + method.desc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaMethod other = (JavaMethod) obj;
        if (clazz == null) {
            if (other.clazz != null)
                return false;
        } else if (!clazz.equals(other.clazz))
            return false;
        if (method == null) {
            if (other.method != null)
                return false;
        } else if (!method.equals(other.method))
            return false;
        return true;
    }

    public void setAccessible(boolean accessible) {
    }

    public String getDescriptor() {
        return this.method.desc;
    }

    public boolean isBridge() {
        return (getModifiers() & BRIDGE) != 0;
    }

    public boolean isVarArgs() {
        return (getModifiers() & VARARGS) != 0;
    }

    public boolean isSynthetic() {
        return (getModifiers() & SYNTHETIC) != 0;
    }

    public boolean isDefault() {
        return ((getModifiers() & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) ==
                Modifier.PUBLIC) && getDeclaringClass().isInterface();
    }

    @Override
    public String toString() {
        return sharedToString(Modifier.methodModifiers(),
                isDefault(),
                getParameterTypes(),
                getExceptionTypes());
    }

    @Override
    void specificToStringHeader(StringBuilder sb) {
        sb.append(getReturnType().getTypeName()).append(' ');
        sb.append(getDeclaringClass().getTypeName()).append('.');
        sb.append(getName());
    }

    public ClassNode getClassNode() {
        return getDeclaringClass().getClassNode();
    }

    public JavaWrapper getOop() {
        JavaArray parameterTypes = new JavaArray(JavaClass.forName(clazz.getVM(), TypeHelper.getTypeByDescriptor("[Ljava/lang/Class;")), new JavaWrapper[getParameterTypes().length]);
        for (int j = 0; j < getParameterTypes().length; j++) {
            parameterTypes.set(j, getParameterTypes()[j].getOop());
        }
        JavaArray checkedExceptions = new JavaArray(JavaClass.forName(clazz.getVM(), TypeHelper.getTypeByDescriptor("[Ljava/lang/Class;")), new JavaWrapper[getExceptionTypes().length]);
        for (int j = 0; j < getExceptionTypes().length; j++) {
            checkedExceptions.set(j, getExceptionTypes()[j].getOop());
        }

        JavaClass returnType = getReturnType();
        if (returnType == null) {
            throw new ExecutionException("null return type " + method.desc);
        }

        JavaClass methodClass = JavaClass.forName(clazz.getVM(), TypeHelper.getTypeByDescriptor("Ljava/lang/reflect/Method;"));
        JavaWrapper oopMethod = clazz.getVM().newInstance(methodClass, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;[Ljava/lang/Class;IILjava/lang/String;[B[B[B)V",
                clazz.getOop(),
                clazz.getVM().getStringInterned(getName()),
                JavaWrapper.wrap(parameterTypes),
                getReturnType().getOop(),
                JavaWrapper.wrap(checkedExceptions),
                JavaWrapper.createInteger(clazz.getVM(), getModifiers()),
                JavaWrapper.createInteger(clazz.getVM(), getClassNode().methods.indexOf(method)),
                clazz.getVM().getStringInterned(method.signature),
                ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0]),
                ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0]),
                ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0])
        );
        return oopMethod;
    }

    public boolean isStatic() {
        return Modifier.isStatic(method.access);
    }

    public boolean isPublic() {
        return Modifier.isPublic(method.access);
    }

    public boolean isInitializer() {
        return isObjectInitializer() || isStaticInitializer();
    }

    private boolean isStaticInitializer() {
        return method.name.equals("<clinit>");
    }

    private boolean isObjectInitializer() {
        return method.name.equals("<init>");
    }

    public boolean isPrivate() {
        return Modifier.isPrivate(method.access);
    }

    public boolean isAbstract() {
        return Modifier.isAbstract(method.access);
    }
}