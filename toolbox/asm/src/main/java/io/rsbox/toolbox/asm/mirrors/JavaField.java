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
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import java.lang.reflect.Modifier;

public class JavaField {
    private final JavaClass clazz;
    private final FieldNode field;

    public JavaField(JavaClass klass, FieldNode methodNode) {
        this.clazz = klass;
        this.field = methodNode;
    }

    public int getModifiers() {
        return field.access & VirtualMachine.JVM_RECOGNIZED_FIELD_MODIFIERS;
    }

    public String getName() {
        return field.name;
    }

    public JavaClass getDeclaringClass() {
        return this.clazz;
    }

    public JavaClass getType() {
        Type type = Type.getType(field.desc);
        return JavaClass.forName(clazz.getVM(), type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
        result = prime * result + ((field == null) ? 0 : field.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JavaField other = (JavaField) obj;
        if (clazz == null) {
            if (other.clazz != null)
                return false;
        } else if (!clazz.equals(other.clazz))
            return false;
        if (field == null) {
            if (other.field != null)
                return false;
        } else if (!field.equals(other.field))
            return false;
        return true;
    }

    public FieldNode getFieldNode() {
        return field;
    }

    @Override
    public String toString() {
        int mod = getModifiers();
        return (((mod == 0) ? "" : (Modifier.toString(mod) + " "))
                + getType().getTypeName() + " "
                + getDeclaringClass().getTypeName() + "."
                + getName());
    }

    public ClassNode getClassNode() {
        return clazz.getClassNode();
    }

    public JavaWrapper getOop() {
        JavaWrapper oopType = getType().getOop();
        JavaClass fieldClazz = JavaClass.forName(clazz.getVM(), TypeHelper.getTypeByDescriptor("Ljava/lang/reflect/Field;"));
        JavaWrapper oopField = clazz.getVM().newInstance(fieldClazz, "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;IILjava/lang/String;[B)V",
                clazz.getOop(),
                clazz.getVM().getStringInterned(getName()),
                oopType,
                JavaWrapper.createInteger(clazz.getVM(), getModifiers()),
                JavaWrapper.createInteger(clazz.getVM(), getSlot()),
                clazz.getVM().getString(""),
                ArrayConversionHelper.convertByteArray(clazz.getVM(), new byte[0])
        );
        return oopField;
    }

    public int getSlot() {
        return clazz.getClassNode().fields.indexOf(field);
    }
}