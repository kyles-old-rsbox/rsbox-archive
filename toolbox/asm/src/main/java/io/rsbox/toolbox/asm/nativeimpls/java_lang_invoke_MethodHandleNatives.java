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

package io.rsbox.toolbox.asm.nativeimpls;

import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.CallInfo;
import io.rsbox.toolbox.asm.internals.FieldDescriptor;
import io.rsbox.toolbox.asm.internals.KlassHandle;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaMethod;
import io.rsbox.toolbox.asm.utils.Utils;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class java_lang_invoke_MethodHandleNatives {
    public static final String OBJECT_SIG = "Ljava/lang/Object;";
    public static final int OBJECT_SIG_LEN = OBJECT_SIG.length();
    static final int
            MN_IS_METHOD = 0x00010000, // method (not constructor)
            MN_IS_CONSTRUCTOR = 0x00020000, // constructor
            MN_IS_FIELD = 0x00040000, // field
            MN_IS_TYPE = 0x00080000, // nested type
            MN_CALLER_SENSITIVE = 0x00100000, // @CallerSensitive annotation detected
            MN_REFERENCE_KIND_SHIFT = 24, // refKind
            MN_REFERENCE_KIND_MASK = 0x0F000000 >> MN_REFERENCE_KIND_SHIFT,
    // The SEARCH_* bits are not for MN.flags but for the matchFlags argument of MHN.getMembers:
    MN_SEARCH_SUPERCLASSES = 0x00100000,
            MN_SEARCH_INTERFACES = 0x00200000;
    static final String CONSTRUCTOR_NAME = "<init>";  // the ever-popular
    // modifiers exported by the JVM:
    static final int RECOGNIZED_MODIFIERS = 0xFFFF;
    // private flags, not part of RECOGNIZED_MODIFIERS:
    static final int
            IS_METHOD = MN_IS_METHOD,        // method (not constructor)
            IS_CONSTRUCTOR = MN_IS_CONSTRUCTOR,   // constructor
            IS_FIELD = MN_IS_FIELD,         // field
            IS_TYPE = MN_IS_TYPE,          // nested type
            CALLER_SENSITIVE = MN_CALLER_SENSITIVE; // @CallerSensitive annotation detected
    static final int ALL_ACCESS = Modifier.PUBLIC | Modifier.PRIVATE | Modifier.PROTECTED;
    static final int ALL_KINDS = IS_METHOD | IS_CONSTRUCTOR | IS_FIELD | IS_TYPE;
    static final int IS_INVOCABLE = IS_METHOD | IS_CONSTRUCTOR;
    static final int IS_FIELD_OR_METHOD = IS_METHOD | IS_FIELD;
    static final int SEARCH_ALL_SUPERS = MN_SEARCH_SUPERCLASSES | MN_SEARCH_INTERFACES;
    /**
     * Basic types as encoded in the JVM.  These code values are not
     * intended for use outside this class.  They are used as part of
     * a private interface between the JVM and this class.
     */
    static final int
            T_BOOLEAN = 4,
            T_CHAR = 5,
            T_FLOAT = 6,
            T_DOUBLE = 7,
            T_BYTE = 8,
            T_SHORT = 9,
            T_INT = 10,
            T_LONG = 11,
            T_OBJECT = 12,
    //T_ARRAY    = 13
    T_VOID = 14,
    //T_ADDRESS  = 15
    T_ILLEGAL = 99;
    /**
     * Constant pool entry types.
     */
    static final byte
            CONSTANT_Utf8 = 1,
            CONSTANT_Integer = 3,
            CONSTANT_Float = 4,
            CONSTANT_Long = 5,
            CONSTANT_Double = 6,
            CONSTANT_Class = 7,
            CONSTANT_String = 8,
            CONSTANT_Fieldref = 9,
            CONSTANT_Methodref = 10,
            CONSTANT_InterfaceMethodref = 11,
            CONSTANT_NameAndType = 12,
            CONSTANT_MethodHandle = 15,  // JSR 292
            CONSTANT_MethodType = 16,  // JSR 292
            CONSTANT_InvokeDynamic = 18,
            CONSTANT_LIMIT = 19;   // Limit to tags found in classfiles
    /**
     * Access modifier flags.
     */
    static final char
            ACC_PUBLIC = 0x0001,
            ACC_PRIVATE = 0x0002,
            ACC_PROTECTED = 0x0004,
            ACC_STATIC = 0x0008,
            ACC_FINAL = 0x0010,
            ACC_SYNCHRONIZED = 0x0020,
            ACC_VOLATILE = 0x0040,
            ACC_TRANSIENT = 0x0080,
            ACC_NATIVE = 0x0100,
            ACC_INTERFACE = 0x0200,
            ACC_ABSTRACT = 0x0400,
            ACC_STRICT = 0x0800,
            ACC_SYNTHETIC = 0x1000,
            ACC_ANNOTATION = 0x2000,
            ACC_ENUM = 0x4000,
    // aliases:
    ACC_SUPER = ACC_SYNCHRONIZED,
            ACC_BRIDGE = ACC_VOLATILE,
            ACC_VARARGS = ACC_TRANSIENT;
    /**
     * Constant pool reference-kind codes, as used by CONSTANT_MethodHandle CP entries.
     */
    static final byte
            REF_NONE = 0,  // null value
            REF_getField = 1,
            REF_getStatic = 2,
            REF_putField = 3,
            REF_putStatic = 4,
            REF_invokeVirtual = 5,
            REF_invokeStatic = 6,
            REF_invokeSpecial = 7,
            REF_newInvokeSpecial = 8,
            REF_invokeInterface = 9,
            REF_LIMIT = 10;
    private static final String THIS = "java/lang/invoke/MethodHandleNatives";

    public static void registerNatives(VirtualMachine vm) {
        // lol lazy
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, "java/lang/invoke/LambdaForm", "computeInitialPreparedForms", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return;
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getConstant", "(I)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            switch (args[0].asInt()) {
                case 4: // GC_COUNT_GWT
                    return JavaWrapper.createInteger(vm, 0);
                default:
                    throw new ExecutionException("Unexpected value " + args[0].asInt());
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "objectFieldOffset", "(Ljava/lang/invoke/MemberName;)J", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return vm.newLong(java_lang_invoke_MemberName.vmindex(args[0]));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getMembers", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Class;I[Ljava/lang/invoke/MemberName;)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return JavaWrapper.createInteger(vm, java_lang_invoke_MemberName.vmindex(args[0]));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "init", "(Ljava/lang/invoke/MemberName;Ljava/lang/Object;)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            if (args[0].is(JavaValueType.NULL))
                throw vm.newThrowable(VMSymbols.java_lang_InternalError, "mname is null");
            if (args[1].is(JavaValueType.NULL))
                throw vm.newThrowable(VMSymbols.java_lang_InternalError, "target is null");
            initMemberName(vm, args[0], args[1]);
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "resolve", "(Ljava/lang/invoke/MemberName;Ljava/lang/Class;)Ljava/lang/invoke/MemberName;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            // todo verify access again
            // todo lol actually resolve

            try {
                if (args[0].get().getMetadata(JavaObject.VMTARGET) != null) {
                    return args[0];
                }

                KlassHandle caller = new KlassHandle(args[1].is(JavaValueType.NULL) ? null : java_lang_Class.asKlass(args[1]));
                JavaClass defc = java_lang_Class.asKlass(java_lang_invoke_MemberName.clazz(args[0]));
                String name = vm.convertJavaObjectToString(java_lang_invoke_MemberName.name(args[0]));
                JavaWrapper typeObj = java_lang_invoke_MemberName.type(args[0]);
                String type = lookupSignature(vm, typeObj, false);
                int flags = java_lang_invoke_MemberName.flags(args[0]);
                int refKind = (flags >> MN_REFERENCE_KIND_SHIFT) & MN_REFERENCE_KIND_MASK;
//                System.out.println("Resolving " + args[0].asObject().hashCode() + ": " + defc.getName() + " " + name + " " + type + " " + typeObj.getJavaClass());
                switch (flags & ALL_KINDS) {
                    case IS_METHOD: {
                        CallInfo result = new CallInfo();
                        if (refKind == REF_invokeStatic) {
                            vm.getLinkResolver().resolveStaticCall(result, new KlassHandle(defc), name, type, caller, caller.notNull(), false);
                        } else if (refKind == REF_invokeVirtual) {
                            vm.getLinkResolver().resolve_virtual_call(result, null, new KlassHandle(defc), new KlassHandle(defc), name, type, caller, caller.notNull(), false);
                        } else if (refKind == REF_invokeSpecial) {
                            vm.getLinkResolver().resolve_special_call(result, null, new KlassHandle(defc), name, type, caller, caller.notNull());
                        } else {
                            throw new ExecutionException("Unexpected refKind " + refKind);
                        }
                        JavaWrapper mname2 = initMethodMemberName(vm, args[0], result);
                        return mname2;
                    }
                    case IS_FIELD: {
                        FieldDescriptor result = new FieldDescriptor();
                        {
                            vm.getLinkResolver().resolveField(result, new KlassHandle(defc), name, type, caller, Opcodes.NOP, false, false);
                        }
                        JavaWrapper mname2 = initFieldMemberName(vm, args[0], result, refKindIsSetter(refKind));
                        return mname2;
                    }
                    default:
                        throw new ExecutionException("Unexpected");
                }
            } catch (Throwable t) {
                Utils.sneakyThrow(t);
                return null;
            }
        }));
    }

    private static boolean refKindIsSetter(int ref_kind) {
        return refKindIsField(ref_kind) && !refKindIsGetter(ref_kind);
    }

    private static boolean refKindIsField(int ref_kind) {
        return (ref_kind <= REF_putStatic);
    }

    private static boolean refKindIsGetter(int ref_kind) {
        return (ref_kind <= REF_getStatic);
    }

    private static JavaWrapper initMemberName(VirtualMachine vm, JavaWrapper mname, JavaWrapper accessibleObject) {
        if (java_lang_reflect_Field.isInstance(vm, accessibleObject)) {
            throw new ExecutionException("Unsupported field");
        } else if (java_lang_reflect_Method.isInstance(vm, accessibleObject)) {
            JavaWrapper clazz = java_lang_reflect_Method.clazz(accessibleObject);
            int slot = java_lang_reflect_Method.slot(accessibleObject);
            KlassHandle k = new KlassHandle(java_lang_Class.asKlass(clazz));
            if (!k.isNull() && !k.get().isArray()) {
                JavaMethod method = k.get().getMethodById(slot);
                if (method == null || (Arrays.asList("invoke", "invokeExact", "invokeBasic", "linkToVirtual", "linkToStatic", "linkToSpecial", "linkToInterface").contains(method.getName())))
                    return null;            // do not resolve unless there is a concrete signature
                CallInfo info = new CallInfo(method, k.get());
//                System.out.println("Initting: " + method);
                JavaWrapper mem = initMethodMemberName(vm, mname, info);

                return mem;
            }
            return null;
        } else if (java_lang_reflect_Constructor.isInstance(vm, accessibleObject)) {
            throw new ExecutionException("Unsupported constructor");
        } else {
            throw new ExecutionException("Unsupported " + accessibleObject.getJavaClass());
        }
    }

    private static JavaWrapper initFieldMemberName(VirtualMachine vm, JavaWrapper mname, FieldDescriptor fd, boolean is_setter) {
        int flags = (fd.getFlags() & VirtualMachine.JVM_RECOGNIZED_FIELD_MODIFIERS);
        flags |= IS_FIELD | ((fd.is_static() ? REF_getStatic : REF_getField) << MN_REFERENCE_KIND_SHIFT);
        if (is_setter) flags += ((REF_putField - REF_getField) << MN_REFERENCE_KIND_SHIFT);
        java_lang_invoke_MemberName.set_flags(mname, JavaWrapper.createInteger(vm, flags));
        java_lang_invoke_MemberName.set_vmtarget(mname, fd.fieldHolder());
        java_lang_invoke_MemberName.set_vmindex(mname, fd.getIndex()); // todo bad
        java_lang_invoke_MemberName.set_clazz(mname, fd.fieldHolder().getOop());
        JavaWrapper type = field_signature_type_or_null(vm, fd.signature());
        String name = field_name_or_null(fd.name());
//        System.out.println("Init field: " + name + " " + type + " " + fd.signature());
        if (name != null)
            java_lang_invoke_MemberName.set_name(mname, vm.getString(name));
        if (type != null)
            java_lang_invoke_MemberName.set_type(mname, type);
        // Note:  name and type can be lazily computed by resolve_MemberName,
        // if Java code needs them as resolved String and Class objects.
        // Note that the incoming type oop might be pre-resolved (non-null).
        // The base clazz and field offset (vmindex) must be eagerly stored,
        // because they unambiguously identify the field.
        // Although the fieldDescriptor::_index would also identify the field,
        // we do not use it, because it is harder to decode.
        // TO DO: maybe intern mname_oop
        return mname;
    }

    private static JavaWrapper initMethodMemberName(VirtualMachine vm, JavaWrapper mname, CallInfo result) {
        JavaMethod m = result.getResolvedMethod().get();

        int vmindex = -4;
        int flags = m.getMethodNode().access & VirtualMachine.JVM_RECOGNIZED_METHOD_MODIFIERS;

        switch (result.getCallKind()) {
            case DIRECT_CALL: {
                vmindex = JavaMethod.nonvirtual_vtable_index;
                if (m.isStatic()) {
                    flags |= IS_METHOD | (REF_invokeStatic << MN_REFERENCE_KIND_SHIFT);
                } else if (m.isInitializer()) {
                    flags |= IS_CONSTRUCTOR | (REF_invokeSpecial << MN_REFERENCE_KIND_SHIFT);
                } else {
                    flags |= IS_METHOD | (REF_invokeSpecial << MN_REFERENCE_KIND_SHIFT);
                }
                break;
            }
            case VTABLE_CALL: {
                flags |= IS_METHOD | (REF_invokeVirtual << MN_REFERENCE_KIND_SHIFT);
                if (m.getDeclaringClass().isInterface()) {
                    throw new ExecutionException("Unsupported");
                }
                break;
            }
            default: {
                throw new ExecutionException("Unexpected");
            }
        }

//        if (m->caller_sensitive()) {
//            flags |= CALLER_SENSITIVE;
//        }

        java_lang_invoke_MemberName.set_flags(mname, JavaWrapper.createInteger(vm, flags));
        java_lang_invoke_MemberName.set_vmtarget(mname, m);
        java_lang_invoke_MemberName.set_vmindex(mname, vmindex);   // vtable/itable index
        java_lang_invoke_MemberName.set_clazz(mname, m.getDeclaringClass().getOop());

        return mname;
    }

    private static String field_name_or_null(String s) {
        if (s == null) return null;
        return s;
    }

    private static JavaWrapper field_signature_type_or_null(VirtualMachine vm, String s) {
        if (s == null) return null;
        Type type = Type.getType(s);
        if (VirtualMachine.isJavaPrimitive(type)) {
            return JavaClass.getPrimitiveClass(vm, type.getClassName()).getOop();
        }
        // Here are some more short cuts for common types.
        // They are optional, since reference types can be resolved lazily.
        if (type.getSort() == Type.OBJECT) {
            if (s.equals(OBJECT_SIG)) {
                return vm.getSystemDictionary().getJavaLangObject().getOop();
            } else if (s.equals("Ljava/lang/Class;")) {
                return vm.getSystemDictionary().getJavaLangClass().getOop();
            } else if (s.equals("Ljava/lang/String;")) {
                return vm.getSystemDictionary().getJavaLangString().getOop();
            }
        }
        return null;
    }

    public static boolean isBasicTypeSignature(String sig) {
        int len = sig.length();
        for (int i = 0; i < len; i++) {
            switch (sig.charAt(i)) {
                case 'L': {
                    if (sig.indexOf(OBJECT_SIG, i) != i) {
                        return false;
                    }
                    i += OBJECT_SIG_LEN - 1;
                }
                case '(':
                case ')':
                case 'V':
                case 'I':
                case 'J':
                case 'F':
                case 'D':
                    continue;
                    //case '[':
                    //case 'Z': case 'B': case 'C': case 'S':
                default:
                    return false;
            }
        }

        return true;
    }

    public static String lookupBasicTypeSignature(VirtualMachine vm, String sig, boolean keepLastArg) {
        if (sig == null) {
            return null;
        } else if (isBasicTypeSignature(sig)) {
            return sig;
        } else if (sig.charAt(0) != '(') {
            throw new ExecutionException("Unexpected");
        } else {
            StringBuilder buffer = new StringBuilder();
            buffer.append("(");
            int keep_arg_pos = -1;

            Type[] argtypes = Type.getArgumentTypes(sig);
            Type returnType = Type.getReturnType(sig);

            Type[] types = new Type[argtypes.length + 1];
            System.arraycopy(argtypes, 0, types, 0, argtypes.length);
            types[types.length - 1] = returnType;

            if (keepLastArg)
                keep_arg_pos = argtypes.length - 1;
            for (int i = 0; i < types.length; i++) {
                Type type = types[i];
                int sort = type.getSort();
                if (i == types.length - 1) {
                    buffer.append(")");
                }
                if (i == keep_arg_pos) {
                    buffer.append(type.getDescriptor());
                } else if (sort == Type.OBJECT || sort == Type.ARRAY) {
                    buffer.append(OBJECT_SIG);
                } else {
                    if (vm.isSubwordType(type))
                        type = Type.INT_TYPE;
                    buffer.append(type.getDescriptor());
                }
            }

            return buffer.toString();
        }
    }

    // convert the external string or reflective type to an internal signature
    private static String lookupSignature(VirtualMachine vm, JavaWrapper type_str, boolean internIfNotFound) {
        if (java_lang_invoke_MethodType.isInstance(vm, type_str)) {
            return java_lang_invoke_MethodType.asSignature(type_str, internIfNotFound);
        } else if (java_lang_Class.isInstance(vm, type_str)) {
            return java_lang_Class.asSignature(type_str, false);
        } else if (java_lang_String.isInstance(vm, type_str)) {
            return vm.convertJavaObjectToString(type_str);
        } else {
            throw vm.newThrowable(VMSymbols.java_lang_NoSuchMethodError, "unrecognized type");
        }
    }
}