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

package io.rsbox.toolbox.asm.utils;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InnerClassNode;
import org.objectweb.asm.tree.MethodNode;

public class ASMHelper {
    private ASMHelper() {

    }

    public static MethodNode findMethod(ClassNode owner, String name, String desc) {
        int size = owner.methods.size();
        for (int i = 0; i < size; i++) {
            MethodNode methodNode = owner.methods.get(i);
            if (methodNode.name.equals(name) && methodNode.desc.equals(desc)) {
                return methodNode;
            }
        }

        return null;
    }

    public static FieldNode findField(ClassNode owner, String name, String desc) {
        int size = owner.fields.size();
        for (int i = 0; i < size; i++) {
            FieldNode fieldNode = owner.fields.get(i);
            if (fieldNode.name.equals(name) && fieldNode.desc.equals(desc)) {
                return fieldNode;
            }
        }

        return null;
    }

    public static InnerClassNode findInnerClassNode(ClassNode classNode, String name) {
        if (classNode.innerClasses == null) {
            return null;
        }
        int size = classNode.innerClasses.size();
        for (int i = 0; i < size; i++) {
            InnerClassNode innerClassNode = classNode.innerClasses.get(i);
            if (innerClassNode.name.equals(name)) {
                return innerClassNode;
            }
        }

        return null;
    }

    public static Attribute findAttribute(ClassNode classNode, String name) {
        if (classNode.attrs == null) {
            return null;
        }
        int size = classNode.attrs.size();
        for (int i = 0; i < size; i++) {
            Attribute attribute = classNode.attrs.get(i);
            if (attribute.type.equals(name)) {
                return attribute;
            }
        }

        return null;
    }
}
