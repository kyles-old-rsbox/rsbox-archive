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

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.internals.FieldDescriptor;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.utils.PrimitiveUtils;
import io.rsbox.toolbox.asm.utils.TypeHelper;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.InnerClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// This entire class is basically a reimplementation of java/lang/Class
// Viewer discretion is advised
public class JavaClass {
    private static final int ANNOTATION = 0x00002000;
    private static final int ENUM = 0x00004000;
    private static final int SYNTHETIC = 0x00001000;
    private final VirtualMachine _vm;
    private final ClassNode classNode;
    private final boolean isPrimitive;
    private final boolean isInterface;
    private final Type _type;
    private final boolean isArray;
    private final JavaClass componentType;
    private final Lock initializataionLock = new ReentrantLock();
    private final Condition initializationCondition = initializataionLock.newCondition();
    private String _name;
    private int _modifiers = -1;
    private JavaClass[] _declaredClasses;
    private JavaClass _declaringClass;
    private JavaClass[] _interfaces;
    private volatile JavaWrapper oop;

    // class initialization related
    private final Lock lock = new ReentrantLock();
    private volatile InitializationState initializationState = InitializationState.NOT_INITIALIZED;
    private volatile Thread initalizationThread = null;

    // unsafe operations
    private final BiMap<Long, FieldNode> fieldOffsets = HashBiMap.create();
    private final BiMap<Long, FieldNode> objectFieldOffsets = HashBiMap.create();
    private final long nextSlot;

    // cache
    private final Map<String, FieldNode> fieldCache = new HashMap<>();
    private final Map<String, MethodNode> methodCache = new HashMap<>();

    public JavaClass(VirtualMachine vm, ClassNode classNode, Type descriptor) {
        this._vm = vm;
        this.classNode = classNode;
        this.isPrimitive = false;
        this.isArray = false;
        this.isInterface = Modifier.isInterface(classNode.access);
        this._type = descriptor;
        this.componentType = null;

        this._vm.cacheClass(this);

        long nextSlot = 0;
        if (getSuperclass() != null) {
            objectFieldOffsets.putAll(getSuperclass().objectFieldOffsets);
            nextSlot = getSuperclass().nextSlot;
        }

        for (FieldNode fieldNode : classNode.fields) {
            if (!Modifier.isStatic(fieldNode.access)) {
                objectFieldOffsets.put(nextSlot++, fieldNode);
            }
        }

        this.nextSlot = nextSlot;

        fieldOffsets.putAll(objectFieldOffsets);
        for (FieldNode fieldNode : classNode.fields) {
            if (Modifier.isStatic(fieldNode.access)) {
                fieldOffsets.put(nextSlot++, fieldNode);
            }
        }

        for (FieldNode fieldNode : classNode.fields) {
            fieldCache.put(fieldNode.name + "." + fieldNode.desc, fieldNode);
        }

        for (MethodNode methodNode : classNode.methods) {
            methodCache.put(methodNode.name + "." + methodNode.desc, methodNode);
        }
    }


    public Pair<JavaClass, JavaField> findFieldNode(String name, String desc, boolean recursive) {
        FieldNode result = fieldCache.get(name + "." + desc);
        if (result != null) {
            return Pair.of(this, new JavaField(this, result));
        } else {
            if (!recursive) {
                return null;
            }
            Pair<JavaClass, JavaField> parentResult;
            for (JavaClass intf : getInterfaces()) {
                parentResult = intf.findFieldNode(name, desc, true);
                if (parentResult != null) {
                    return parentResult;
                }
            }
            JavaClass superClass = getSuperclass();
            return superClass != null ? superClass.findFieldNode(name, desc, true) : null;
        }
    }

    public MethodNode findMethodNode(String name, String desc, boolean recursive) {
        MethodNode result = methodCache.get(name + "." + desc);
        if (result != null) {
            return result;
        } else {
            JavaClass superClass = getSuperclass();
            return recursive && superClass != null ? superClass.findMethodNode(name, desc, true) : null;
        }
    }

    public FieldNode getFieldByOffset(long offset) {
        return fieldOffsets.get(offset);
    }

    public long getOffsetByField(FieldNode field) {
        return fieldOffsets.inverse().get(field);
    }

    public BiMap<Long, FieldNode> getFieldOffsets() {
        return fieldOffsets;
    }

    public long getNextSlot() {
        return nextSlot;
    }

    private JavaClass(VirtualMachine vm, JavaClass elementType, Type arrayDescriptor) {
        this._vm = vm;
        this.classNode = new ClassNode();
        this.classNode.visit(52, Opcodes.ACC_PUBLIC, arrayDescriptor.getInternalName(), null, "java/lang/Object", new String[]{"java/io/Serializable", "java/lang/Cloneable"});
        this.isPrimitive = false;
        this.isArray = true;
        this.isInterface = false;
        this._type = arrayDescriptor;
        this.componentType = elementType;

        if (this.componentType.isPrimitive()) {
            this._name = arrayDescriptor.getDescriptor();
        }

        this._vm.cacheClass(this);
        nextSlot = -1;
    }

    public JavaClass(VirtualMachine vm, Type primitiveType, String primitiveName) {
        this._vm = vm;
        this.classNode = null;
        this.isPrimitive = true;
        this.isArray = false;
        this.isInterface = false;
        this._type = primitiveType;
        this._name = primitiveName;
        this.componentType = null;
        nextSlot = -1;
    }

    public synchronized static JavaClass forName(VirtualMachine vm, String name) {
        return forName(vm, TypeHelper.parseType(vm, name));
    }

    public synchronized static JavaClass forName(VirtualMachine vm, Type descriptor) {
        if (descriptor.getSort() == Type.OBJECT || descriptor.getSort() == Type.ARRAY) {
            String strdesc = descriptor.getDescriptor();
            if (!strdesc.endsWith(";") && !strdesc.startsWith("[")) {
                strdesc = "L" + strdesc + ";";
            }
            JavaClass lookup = vm.forName(strdesc);
            if (lookup != null) {
                return lookup;
            }
            if (descriptor.getSort() == Type.OBJECT) {
                ClassNode classNode = vm.lookupClass(descriptor.getInternalName());
                if (classNode == null) {
                    return null;
                }
                return new JavaClass(vm, classNode, descriptor);
            } else {
                return new JavaClass(vm, forName(vm, Type.getType(descriptor.getDescriptor().substring(1))), descriptor);
            }
        } else {
            return JavaClass.getPrimitiveClass(vm, descriptor.getClassName());
        }
    }

    public static JavaClass getJavaClass(VirtualMachine virtualMachine, Class<?> clazz) {
        Type type = Type.getType(clazz);
        if (clazz.isPrimitive()) {
            return JavaClass.getPrimitiveClass(virtualMachine, clazz.getName());
        } else if (clazz.isArray()) {
            if (type.getElementType().getSort() == Type.OBJECT) {
                return JavaClass.forName(virtualMachine, type);
            } else {
                return JavaClass.forName(virtualMachine, type);
            }
        } else {
            return JavaClass.forName(virtualMachine, type);
        }
    }

    private static boolean isAsciiDigit(char c) {
        return '0' <= c && c <= '9';
    }

    public static JavaClass getPrimitiveClass(VirtualMachine vm, String name) {
        return vm.getLookupMap().get(PrimitiveUtils.getPrimitiveByName(name));
    }

    public VirtualMachine getVM() {
        return this._vm;
    }

    public JavaClass[] getDeclaredClasses() {
        JavaClass[] declaredClasses = this._declaredClasses;
        if (declaredClasses == null)
            this._declaredClasses = declaredClasses = getDeclaredClasses0();
        return declaredClasses;
    }

    // Implementation based on OpenJDK (src/share/vm/prims/jvm.cpp!JVM_GetDeclaredClasses)
    private JavaClass[] getDeclaredClasses0() {
        if (isPrimitive() || isArray()) {
            return new JavaClass[0];
        }
        if (classNode.innerClasses == null || classNode.innerClasses.size() == 0) {
            return new JavaClass[0];
        }
        List<JavaClass> declaredClasses = new ArrayList<>();
        for (InnerClassNode innerClassNode : classNode.innerClasses) {
            // This seems to be the only requirement
            if (innerClassNode.outerName != null && innerClassNode.outerName.equals(classNode.name)) {
                // Sanity check?
                if (innerClassNode.name != null && !innerClassNode.name.isEmpty()) {
                    JavaClass attempted = JavaClass.forName(_vm, TypeHelper.parseType(_vm, innerClassNode.name));
                    if (attempted != null) {
                        declaredClasses.add(attempted);
                    }
                }
            }
        }

        return declaredClasses.toArray(new JavaClass[declaredClasses.size()]);
    }

    public final boolean isArray() {
        return this.isArray;
    }

    public final boolean isInterface() {
        return this.isInterface;
    }

    public final boolean isSuper() {
        return (this.classNode.access & Opcodes.ACC_SUPER) != 0;
    }

    public final boolean isPrimitive() {
        return this.isPrimitive;
    }

    public boolean isAnnotation() {
        return (getModifiers() & ANNOTATION) != 0;
    }

    public boolean isSynthetic() {
        return (getModifiers() & SYNTHETIC) != 0;
    }

    public boolean isEnum() {
        return (this.getModifiers() & ENUM) != 0 &&
                this.getSuperclass().classNode != null &&
                this.getSuperclass().classNode.name.equals("java/lang/Enum");
    }

    public JavaClass getSuperclass() {
        if (isArray()) {
            return JavaClass.forName(_vm, Type.getType("Ljava/lang/Object;"));
        }
        if (isInterface() || isPrimitive() || classNode.name.equals("java/lang/Object")) {
            return null;
        }

        return JavaClass.forName(_vm, TypeHelper.parseType(_vm, classNode.superName));
    }

    /**
     * Returns the Java language modifiers for this class or interface, encoded
     * in an integer. The modifiers consist of the Java Virtual Machine's
     * constants for {@code public}, {@code protected},
     * {@code private}, {@code final}, {@code static},
     * {@code abstract} and {@code interface}; they should be decoded
     * using the methods of class {@code Modifier}.
     * <p>
     * <p> If the underlying class is an array class, then its
     * {@code public}, {@code private} and {@code protected}
     * modifiers are the same as those of its component type.  If this
     * {@code Class} represents a primitive type or void, its
     * {@code public} modifier is always {@code true}, and its
     * {@code protected} and {@code private} modifiers are always
     * {@code false}. If this object represents an array class, a
     * primitive type or void, then its {@code final} modifier is always
     * {@code true} and its interface modifier is always
     * {@code false}. The values of its other modifiers are not determined
     * by this specification.
     * <p>
     * <p> The modifier encodings are defined in <em>The Java Virtual Machine
     * Specification</em>, table 4.1.
     *
     * @return the {@code int} representing the modifiers for this class
     * @see java.lang.reflect.Modifier
     * @since JDK1.1
     */
    public int getModifiers() {
        int modifiers = this._modifiers;
        if (modifiers == -1)
            this._modifiers = modifiers = getModifiers0();
        return modifiers;
    }

    // Implementation based on OpenJDK (src/share/vm/prims/jvm.cpp!JVM_GetClassModifiers)
    // As well as the parser (src/share/vm/classfile/classFileParser.cpp)
    // And the constant accepted flags (src/share/vm/prims/jvm.cpp)
    private int getModifiers0() {
        if (isPrimitive()) {
            // JavaDoc makes no mention of abstract, but JVM seems to return it
            // Also seems fixed, so we'll just leave it at that
            return Modifier.ABSTRACT | Modifier.FINAL | Modifier.PUBLIC;
        }
        if (isArray()) {
            if (classNode == null) {
                // No backing class
                // JavaDoc makes no mention of abstract, but JVM seems to return it
                // Also seems fixed, so we'll just leave it at that
                return Modifier.PUBLIC | Modifier.FINAL | Modifier.ABSTRACT;
            } else {
                // Public/Private/Protected are same as backing class's
                // Use getComponentType() because the component type may be an inner class AND THEN WHAT DO YOU DO!?!??
                return Modifier.FINAL | Modifier.ABSTRACT | (getComponentType().getModifiers() & (Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED));
            }
        } else {
            int rawModifiers;
            if (this.getEnclosingClass() == null) {
                rawModifiers = classNode.access;
                rawModifiers &= VirtualMachine.JVM_RECOGNIZED_CLASS_MODIFIERS;
                if ((rawModifiers & Opcodes.ACC_INTERFACE) == Opcodes.ACC_INTERFACE && classNode.version < Opcodes.V1_6) {
                    // Backwards compatibility
                    rawModifiers |= Opcodes.ACC_ABSTRACT;
                }
            } else {
                ClassNode enclosingNode = this.getEnclosingClass().classNode;
                InnerClassNode innerClassNode = ASMHelper.findInnerClassNode(enclosingNode, classNode.name);
                rawModifiers = innerClassNode.access;
            }
            // Skip verification because yolo
            rawModifiers &= ~Opcodes.ACC_SUPER; // Strip out super flag
            return rawModifiers;
        }
    }

    public final String getName() {
        String name = this._name;
        if (name == null)
            this._name = name = getName0();
        return name;
    }

    public final String getSimpleName() {
        if (isArray())
            return getComponentType().getSimpleName() + "[]";

        String simpleName = getSimpleBinaryName();
        if (simpleName == null) { // top level class
            simpleName = getName();
            return simpleName.substring(simpleName.lastIndexOf(".") + 1); // strip the package name
        }
        // According to JLS3 "Binary Compatibility" (13.1) the binary
        // name of non-package classes (not top level) is the binary
        // name of the immediately enclosing class followed by a '$' followed by:
        // (for nested and inner classes): the simple name.
        // (for local classes): 1 or more digits followed by the simple name.
        // (for anonymous classes): 1 or more digits.

        // Since getSimpleBinaryName() will strip the binary name of
        // the immediatly enclosing class, we are now looking at a
        // string that matches the regular expression "\$[0-9]*"
        // followed by a simple name (considering the simple of an
        // anonymous class to be the empty string).

        // Remove leading "\$[0-9]*" from the name
        int length = simpleName.length();
        if (length < 1 || simpleName.charAt(0) != '$')
            throw new InternalError("Malformed class name");
        int index = 1;
        while (index < length && isAsciiDigit(simpleName.charAt(index)))
            index++;
        // Eventually, this is the empty string iff this is an anonymous class
        return simpleName.substring(index);
    }

    // Returns null if none is found
    public final JavaClass getComponentType() {
        return componentType;
    }

    private String getSimpleBinaryName() {
        JavaClass enclosingClass = getEnclosingClass();
        if (enclosingClass == null) // top level class
            return null;
        // Otherwise, strip the enclosing class' name
        try {
            return getName().substring(enclosingClass.getName().length());
        } catch (IndexOutOfBoundsException ex) {
            throw new InternalError("Malformed class name", ex);
        }
    }

    public JavaClass getDeclaringClass() {
        JavaClass declaringClass = this._declaringClass;
        if (declaringClass == null)
            this._declaringClass = declaringClass = getDeclaringClass0();
        return declaringClass;
    }

    // Implementation based on OpenJDK (src/share/vm/prims/jvm.cpp!JVM_GetDeclaringClass)
    private JavaClass getDeclaringClass0() {
        if (isPrimitive() || isArray()) {
            return null;
        }
        if (classNode.innerClasses == null || classNode.innerClasses.size() == 0) {
            return null;
        }

        ClassNode found = null;

        for (InnerClassNode innerClassNode : classNode.innerClasses) {
            // This seems to be the only requirement
            if (innerClassNode.name != null && innerClassNode.name.equals(classNode.name)) {
                // Sanity check?
                if (innerClassNode.outerName != null && !innerClassNode.outerName.isEmpty()) {
                    ClassNode node = _vm.lookupClass(innerClassNode.outerName);
                    if (node != null) {
                        found = node;
                        break;
                    } else {
                        // todo throw exception or not?
                        // Utils.sneakyThrow(new ClassNotFoundException(innerClassNode.innerName));
                    }
                }
            }
        }

        // there's something here about anonymous classes and enclosing methods. todo figure out what it means

        if (found != null) {
            boolean legal = false;

            if (found.innerClasses != null) {
                for (InnerClassNode innerClassNode : found.innerClasses) {
                    if (innerClassNode.name.equals(classNode.name)) {
                        legal = true;
                    }
                }
            }

            if (legal) {
                return JavaClass.forName(_vm, TypeHelper.parseType(_vm, found.name));
            } else {
                // Utils.sneakyThrow(new IncompatibleClassChangeError(found.name + " and " + classNode.name + " disagree on InnerClasses attribute")); todo throw?
            }
        }

        return null;
    }

    public JavaClass getEnclosingClass() {
        // There are five kinds of classes (or interfaces):
        // a) Top level classes
        // b) Nested classes (static member classes)
        // c) Inner classes (non-static member classes)
        // d) Local classes (named classes declared within a method)
        // e) Anonymous classes


        // JVM Spec 4.8.6: A class must have an EnclosingMethod
        // attribute if and only if it is a local class or an
        // anonymous class.
        EnclosingMethodInfo enclosingInfo = getEnclosingMethodInfo();
        JavaClass enclosingCandidate;

        if (enclosingInfo == null) {
            // This is a top level or a nested class or an inner class (a, b, or c)
            enclosingCandidate = getDeclaringClass();
        } else {
            JavaClass enclosingClass = enclosingInfo.getEnclosingClass();
            // This is a local class or an anonymous class (d or e)
            if (enclosingClass == this || enclosingClass == null) //todo does == work here?
                throw new InternalError("Malformed enclosing method information");
            else
                enclosingCandidate = enclosingClass;
        }

        // todo access checks?
//        if (enclosingCandidate != null)
//            enclosingCandidate.checkPackageAccess(ClassLoader.getClassLoader(Reflection.getCallerClass()), true);
        return enclosingCandidate;
    }

    private String getName0() {
        // is primitive
        if (isPrimitive) {
            throw new ExecutionException("An internal error occurred: getName0() on primitive JavaClass");
        }
        if (isArray()) {
            return this._type.getDescriptor().replace('/', '.');
        }
        return this.classNode.name.replace('/', '.');
    }

    public String getCanonicalName() {
        if (isArray()) {
            String canonicalName = getComponentType().getCanonicalName();
            if (canonicalName != null)
                return canonicalName + "[]";
            else
                return null;
        }
        if (isLocalOrAnonymousClass())
            return null;
        JavaClass enclosingClass = getEnclosingClass();
        if (enclosingClass == null) { // top level class
            return getName();
        } else {
            String enclosingName = enclosingClass.getCanonicalName();
            if (enclosingName == null)
                return null;
            return enclosingName + "." + getSimpleName();
        }
    }

    /**
     * Returns {@code true} if this is a local class or an anonymous
     * class.  Returns {@code false} otherwise.
     */
    private boolean isLocalOrAnonymousClass() {
        // JVM Spec 4.8.6: A class must have an EnclosingMethod
        // attribute if and only if it is a local class or an
        // anonymous class.
        return getEnclosingMethodInfo() != null;
    }

    public boolean isAssignableFrom(JavaClass other) {
        if (other == null) {
            throw new NullPointerException();
        }
        if (isPrimitive()) {
            return other._type.getSort() == _type.getSort();
        }
        if (equals(other)) {
            return true;
        }

        if (other.isArray()) {
            if (isArray()) {
                return getComponentType().isAssignableFrom(other.getComponentType());
            } else if (isInterface()) {
                return getName().equals("java.io.Serializable") || getName().equals("java.lang.Cloneable");
            } else {
                return this == _vm.getSystemDictionary().getJavaLangObject();
            }
        } else if (other.isInterface()) {
            if (isInterface()) {
                if (this == other) {
                    return true;
                }

                Deque<JavaClass> toCheck = new ArrayDeque<>();
                toCheck.addAll(Arrays.asList(other.getInterfaces()));
                while (!toCheck.isEmpty()) {
                    JavaClass pop = toCheck.pop();
                    if (pop != null) {
                        if (pop == this) {
                            return true;
                        }
                        toCheck.addAll(Arrays.asList(pop.getInterfaces()));
                    }
                }
                return false;
            } else {
                return this == _vm.getSystemDictionary().getJavaLangObject();
            }
        } else {
            if (isInterface()) {
                Deque<JavaClass> toCheck = new ArrayDeque<>();
                if (other.getSuperclass() != null)
                    toCheck.add(other.getSuperclass());
                toCheck.addAll(Arrays.asList(other.getInterfaces()));
                while (!toCheck.isEmpty()) {
                    JavaClass pop = toCheck.pop();
                    if (pop != null) {
                        if (pop == this) {
                            return true;
                        }
                        if (pop.getSuperclass() != null)
                            toCheck.add(pop.getSuperclass());
                        toCheck.addAll(Arrays.asList(pop.getInterfaces()));
                    }
                }
                return false;
            } else {
                Deque<JavaClass> toCheck = new ArrayDeque<>();
                if (other.getSuperclass() != null)
                    toCheck.add(other.getSuperclass());
                while (!toCheck.isEmpty()) {
                    JavaClass pop = toCheck.pop();
                    if (pop != null) {
                        if (pop == this) {
                            return true;
                        }

                        if (pop.getSuperclass() != null)
                            toCheck.add(pop.getSuperclass());
                    }
                }
                return false;
            }
        }
    }

    public List<JavaMethod> getDeclaredMethods0(boolean publicOnly) {
        if (isPrimitive()) {
            // primitives have no declared methods
            return Collections.emptyList();
        } else if (isArray()) {
            // arrays have no declared methods
            return Collections.emptyList();
        } else {
            List<JavaMethod> methods = new ArrayList<>();
            for (MethodNode methodNode : this.classNode.methods) {
                if (!methodNode.name.startsWith("<")) {
                    if (publicOnly && !Modifier.isPublic(methodNode.access)) {
                        continue;
                    }
                    methods.add(new JavaMethod(this, methodNode));
                }
            }
            // methods are not returned in any sorted order you say?!?!?!
            Collections.shuffle(methods);
            return methods;
        }
    }

    public List<JavaField> getDeclaredFields0(boolean publicOnly) {
        List<JavaField> fields = new ArrayList<>();
        for (FieldNode fieldNode : this.classNode.fields) {
            // special case
            if (fieldNode.name.equals("backtrace") && classNode.name.equals("java/lang/Throwable"))
                continue;

            if (publicOnly && !Modifier.isPublic(fieldNode.access))
                continue;

            fields.add(new JavaField(this, fieldNode));
        }
        return fields;
    }

    public List<MethodNode> getDeclaredConstructors0(boolean publicOnly) {
        List<MethodNode> fields = new ArrayList<>();
        for (MethodNode fieldNode : this.classNode.methods) {
            // special case
            if (!fieldNode.name.equals("<init>"))
                continue;

            if (publicOnly && !Modifier.isPublic(fieldNode.access))
                continue;

            fields.add(fieldNode);
        }
        return fields;

    }

    public JavaClass[] getInterfaces() {
        JavaClass[] interfaces = this._interfaces;
        if (interfaces == null)
            this._interfaces = interfaces = getInterfaces0();
        return interfaces;
    }

    // Implementation based on OpenJDK (src/share/vm/prims/jvm.cpp!JVM_GetClassInterfaces)
    private JavaClass[] getInterfaces0() {
        if (isPrimitive()) {
            return new JavaClass[0];
        }
        if (isArray()) {
            return new JavaClass[]{
                    JavaClass.forName(_vm, TypeHelper.parseType(_vm, "Ljava/lang/Cloneable;")),
                    JavaClass.forName(_vm, TypeHelper.parseType(_vm, "Ljava/io/Serializable;"))
            };
        }
        List<JavaClass> interfaces = new ArrayList<>();
        if (classNode.interfaces != null) {
            for (String iface : classNode.interfaces) {
                JavaClass intf = JavaClass.forName(_vm, TypeHelper.parseType(_vm, iface));
                if (intf == null) {
                    throw new ExecutionException("Could not find interface " + iface);
                }
                interfaces.add(intf);
            }
        }
        return interfaces.toArray(new JavaClass[interfaces.size()]);
    }

    public String toString() {
        return (isInterface() ? "interface " : (isPrimitive() ? "" : "class "))
                + getName();
    }

    /**
     * Return an informative string for the name of this type.
     *
     * @return an informative string for the name of this type
     * @since 1.8
     */
    public String getTypeName() {
        if (isArray()) {
            try {
                JavaClass cl = this;
                int dimensions = 0;
                while (cl.isArray()) {
                    dimensions++;
                    cl = cl.getComponentType();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(cl.getName());
                for (int i = 0; i < dimensions; i++) {
                    sb.append("[]");
                }
                return sb.toString();
            } catch (Throwable e) { /*FALLTHRU*/ }
        }
        return getName();
    }

    // Implemented based on OpenJDK (src/share/vm/prims/jvm.cpp!JVM_GetEnclosingMethodInfo)
    public Object[] getEnclosingMethod0() {
        if (isPrimitive() || isArray()) {
            return null;
        }

        if (classNode.outerClass != null) {
            Object[] result = new Object[3];
            result[0] = JavaClass.forName(_vm, TypeHelper.parseType(_vm, classNode.outerClass));
            if (classNode.outerMethod != null) {
                result[1] = classNode.outerMethod;
            }
            if (classNode.outerMethodDesc != null) {
                result[2] = classNode.outerMethodDesc;
            }

            return result;
        } else {
            return null;
        }
    }

    private EnclosingMethodInfo getEnclosingMethodInfo() {
        Object[] enclosingInfo = getEnclosingMethod0();
        if (enclosingInfo == null)
            return null;
        else {
            return new EnclosingMethodInfo(enclosingInfo);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaClass klass = (JavaClass) o;

        return klass._type.equals(_type);
    }

    @Override
    public int hashCode() {
        return _type.hashCode();
    }

    public ClassNode getClassNode() {
        return classNode;
    }

    public JavaMethod findMethod(String name, String signature) {
        MethodNode methodNode = ASMHelper.findMethod(classNode, name, signature);
        if (methodNode != null) {
            return new JavaMethod(this, methodNode);
        }
        return null;
    }

    public boolean shouldBeInitialized() {
        return !isInitialized();
    }

    private boolean isInitialized() {
        return initializationState == InitializationState.INITIALIZED;
    }

    public JavaMethod getMethodById(int slot) {
        return new JavaMethod(this, classNode.methods.get(slot));
    }

    public JavaField getFieldById(int slot) {
        return new JavaField(this, classNode.fields.get(slot));
    }

    public Type internalGetType() {
        return _type;
    }

    public void setStaticField(String name, String type, JavaWrapper wrapper) {
        getOop().asObject().setField(name, type, wrapper);
    }

    public JavaWrapper getStaticField(String name, String type) {
        return getOop().asObject().getField(name, type);
    }

    public JavaWrapper getOop() {
        if (oop == null) {
            oop = JavaWrapper.wrap(new JavaObject(_vm.getSystemDictionary().getJavaLangClass()));
            oop.get().setMetadata(VMSymbols.METADATA_KLASS, this);
            if (!isPrimitive() && !isArray()) {
                oop.asObject().doSpecialInitializationForClass();
            }
        }
        return oop;
    }

    public Lock getLock() {
        return lock;
    }

    public InitializationState getInitializationState() {
        return initializationState;
    }

    public Lock getInitializationLock() {
        return initializataionLock;
    }

    public void setInitializationState(InitializationState initializationState, Thread initalizationThread) {
        this.initializationState = initializationState;
        this.initalizationThread = initalizationThread;
    }

    public Thread getInitalizationThread() {
        return initalizationThread;
    }

    public Condition getInitializationCondition() {
        return initializationCondition;
    }

    public JavaMethod uncachedLookupMethod(String name, String signature /*, bool skipOverpass */) {
        if (this.isArray()) {
            return this.getSuperclass().uncachedLookupMethod(name, signature);
        }

        // Should be instanceklass
        JavaClass klass = this;
        while (klass != null) {
            // find static and private
            MethodNode methodNode = ASMHelper.findMethod(klass.getClassNode(), name, signature);
            if (methodNode != null) {
                return new JavaMethod(this, methodNode);
            }
            klass = klass.getSuperclass();
        }

        return null;
    }

    public JavaClass findField(String field, String sig, FieldDescriptor fd) {
        if (this.isArray()) {
            return this.getSuperclass().findField(field, sig, fd);
        }

        if (this.findLocalField(field, sig, fd)) {
            return this;
        }

        {
            JavaClass klass = this.findInterfaceField(field, sig, fd);
            if (klass != null) {
                return klass;
            }
        }

        {
            JavaClass klass = this.getSuperclass();
            if (klass != null) {
                return klass.findField(field, sig, fd);
            }
        }

        return null;
    }

    private boolean findLocalField(String field, String sig, FieldDescriptor fd) {
        FieldNode localField = ASMHelper.findField(classNode, field, sig);
        if (localField != null) {
            fd.reinitialize(this, classNode.fields.indexOf(localField));
            return true;
        }
        return false;
    }

    private JavaClass findInterfaceField(String field, String sig, FieldDescriptor fd) {
        for (JavaClass intf : this.getInterfaces()) {
            if (intf.findLocalField(field, sig, fd)) {
                return intf;
            }

            JavaClass klass = intf.findInterfaceField(field, sig, fd);
            if (klass != null) {
                return klass;
            }
        }

        return null;
    }

    public boolean isSubclassOf(JavaClass javaClass) {
        return javaClass.isAssignableFrom(this);
    }

    public List<JavaMethod> getDefaultMethods() {
        List<JavaMethod> defaults = new ArrayList<>();

        return defaults;
    }

    public enum InitializationState {
        NOT_INITIALIZED,
        BEING_INITIALIZED,
        INITIALIZED,
        ERROR
    }

    private final static class EnclosingMethodInfo {
        private JavaClass enclosingClass;
        private String name;
        private String descriptor;

        private EnclosingMethodInfo(Object[] enclosingInfo) {
            if (enclosingInfo.length != 3)
                throw new InternalError("Malformed enclosing method information");
            try {
                // The array is expected to have three elements:

                // the immediately enclosing class
                enclosingClass = (JavaClass) enclosingInfo[0];
                assert (enclosingClass != null);

                // the immediately enclosing method or constructor's
                // name (can be null).
                name = (String) enclosingInfo[1];

                // the immediately enclosing method or constructor's
                // descriptor (null iff name is).
                descriptor = (String) enclosingInfo[2];
                assert ((name != null && descriptor != null) || name == descriptor);
            } catch (ClassCastException cce) {
                throw new InternalError("Invalid type in enclosing method information", cce);
            }
        }

        boolean isPartial() {
            return enclosingClass == null || name == null || descriptor == null;
        }

        boolean isConstructor() {
            return !isPartial() && "<init>".equals(name);
        }

        boolean isMethod() {
            return !isPartial() && !isConstructor() && !"<clinit>".equals(name);
        }

        JavaClass getEnclosingClass() {
            return enclosingClass;
        }

        String getName() {
            return name;
        }

        String getDescriptor() {
            return descriptor;
        }

    }
}