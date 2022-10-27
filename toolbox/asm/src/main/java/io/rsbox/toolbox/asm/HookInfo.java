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

package io.rsbox.toolbox.asm;

import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class HookInfo {
    private ClassNode classNode;
    private MethodNode methodNode;
    private List<JavaWrapper> params;
    private JavaWrapper instance;
    private JavaWrapper returnValue;

    public HookInfo(ClassNode classNode, MethodNode methodNode) {
        this.classNode = classNode;
        this.methodNode = methodNode;
    }

    public HookInfo(ClassNode classNode, MethodNode methodNode, JavaWrapper instance, List<JavaWrapper> params) {
        this.classNode = classNode;
        this.methodNode = methodNode;
        this.instance = instance;
        this.params = params;
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    public MethodNode getMethodNode() {
        return methodNode;
    }

    public void setClassNode(ClassNode classNode) {
        this.classNode = classNode;
    }

    public void setMethodNode(MethodNode methodNode) {
        this.methodNode = methodNode;
    }

    public JavaWrapper getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(JavaWrapper returnValue) {
        this.returnValue = returnValue;
    }

    public boolean is(String owner, String name, String desc) {
        return classNode.name.equals(owner) && (methodNode != null) && methodNode.name.equals(name) && methodNode.desc.equals(desc);
    }

    public List<JavaWrapper> getParams() {
        return params;
    }

    public JavaWrapper getInstance() {
        return instance;
    }
}
