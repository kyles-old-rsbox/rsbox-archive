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

package io.rsbox.toolbox.asm.values;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.nativeimpls.java_lang_Class;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.NameHelper;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class JavaObject extends JavaValue {
    public static final String CLASS_OBJ_METADATA = "class";
    public static final String FIELD_OBJ_METADATA = "field";
    public static final String VMTARGET = "vmtarget";
    public static final String VMINDEX = "vmindex";
    public Map<String, Object> metadata = new HashMap<>();
    private int hashcode;
    private JavaClass originalClass;
    private JavaClass _class;
    private String _bytecodeType;
    private Map<String, JavaWrapper> fields = new HashMap<>();

    private final BiMap<Long, FieldNode> classOffsets = HashBiMap.create();

    public JavaObject(JavaClass clazz) {
        this(clazz, clazz.internalGetType().getInternalName());
    }

    public JavaObject(JavaClass clazz, String originalType) {
        if (clazz == null) {
            throw new ExecutionException("Null clazz: " + originalType);
        }
        this._class = clazz;
        this.originalClass = clazz;
        this._bytecodeType = originalType;
        this.hashcode = System.identityHashCode(this);
    }

    // bleh
    @Deprecated
    public void doSpecialInitializationForClass() {
        if (getJavaClass() == getJavaClass().getVM().getSystemDictionary().getJavaLangClass()) {
            // this is an instance of java/lang/Class, populate special offsets
            classOffsets.putAll(getJavaClass().getFieldOffsets());
            long nextSlot = getJavaClass().getNextSlot();
            ClassNode classNode = java_lang_Class.getJavaClass(this).getClassNode();
            if (classNode == null) {
                throw new ExecutionException("null classnode for " + java_lang_Class.getJavaClass(this));
            }
            for (FieldNode fieldNode : classNode.fields) {
                if (Modifier.isStatic(fieldNode.access)) {
                    classOffsets.put(nextSlot++, fieldNode);
                }
            }
        }
    }

    @Deprecated
    public FieldNode getFieldByOffset(long offset) {
        return classOffsets.get(offset);
    }

    @Deprecated
    public long getOffsetByField(FieldNode field) {
        return classOffsets.inverse().get(field);
    }


    public JavaWrapper getField(String name, String type) {
        JavaWrapper result = fields.get(NameHelper.nameAndType(name, type));
        if (result == null) {
            return JavaValue.forPrimitive(_class.getVM(), TypeHelper.getTypeByDescriptor(type));
        }
        return result;
    }

    public void setField(String name, String type, JavaWrapper wrapper) {
        fields.put(NameHelper.nameAndType(name, type), wrapper);
    }

    @Override
    public boolean is(JavaValueType type) {
        return type == JavaValueType.OBJECT;
    }

    public String type() {
        return this._bytecodeType;
    }

    @Override
    public JavaClass getJavaClass() {
        return this._class;
    }

    public String toString() {
        MethodNode toString = null;
        JavaClass now = _class;
        while (true) {
            toString = ASMHelper.findMethod(now.getClassNode(), "toString", "()Ljava/lang/String;");
            if (toString != null) {
                break;
            }
            now = now.getSuperclass();
            if (now == null) {
                break;
            }
        }
        try {
            if (!_class.getClassNode().name.equals("java/lang/Class")) {
                boolean oldDebug = VirtualMachine.DEBUG;
                try {
                    VirtualMachine.DEBUG = false;
                    JavaWrapper val = _class.getVM().getString("noop");
                    if (getJavaClass().getClassNode().name.contains("java/lang/reflect/Field")) {
                        val = _class.getVM().internalExecute(now.getClassNode(), toString, JavaWrapper.wrap(this), null, null);
                    }
                    return "JavaObject(type=" + _bytecodeType + ",id=" + hashcode + ",val=" + _class.getVM().convertJavaObjectToString(val) + ")";
                } finally {
                    VirtualMachine.DEBUG = oldDebug;
                }
            } else {
                return "JavaObject(type=" + _bytecodeType + ",id=" + hashcode + ",class=" + java_lang_Class.getJavaClass(this).getName() + ")";
            }
        } catch (Throwable t) {
            return "JavaObject(type=" + _bytecodeType + ",id=" + hashcode + ",err=" + t.getMessage() + ")";
        }
    }

    public String javaToString() {
        MethodNode toString;
        JavaClass now = _class;
        while (true) {
            toString = ASMHelper.findMethod(now.getClassNode(), "toString", "()Ljava/lang/String;");
            if (toString != null) {
                break;
            }
            now = now.getSuperclass();
            if (now == null) {
                break;
            }
        }
        boolean oldDebug = VirtualMachine.DEBUG;
        try {
            VirtualMachine.DEBUG = false;
            JavaWrapper val = _class.getVM().internalExecute(now.getClassNode(), toString, JavaWrapper.wrap(this), null, null);
            return _class.getVM().convertJavaObjectToString(val);
        } finally {
            VirtualMachine.DEBUG = oldDebug;
        }
    }

    public JavaObject vmClone() {
        JavaObject clone = new JavaObject(_class, _bytecodeType);
        clone.fields.putAll(fields);
        clone.metadata.putAll(metadata);
        return clone;
    }

    @Override
    public JavaClass getOriginalClass() {
        return originalClass;
    }

    public int getHashCode() {
        return hashcode;
    }

    @Override
    public int getSize() {
        return 1;
    }

    public JavaValue checkcast(JavaClass other) {
//        JavaObject clone = new JavaObject(other, _bytecodeType);
//        clone.originalClass = originalClass;
//        clone.fields = fields;
//        clone.metadata = metadata;
//        clone.hashcode = hashcode;
//        return clone;
        this._class = other;
        return this;
    }
}