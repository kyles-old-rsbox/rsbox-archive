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

package io.rsbox.toolbox.asm.internals;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaMethod;
import io.rsbox.toolbox.asm.mirrors.JavaMethodHandle;
import io.rsbox.toolbox.asm.nativeimpls.java_lang_invoke_MethodHandleNatives;
import io.rsbox.toolbox.asm.values.JavaValueType;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Modifier;

public class LinkResolver {
    private final VirtualMachine vm;

    public LinkResolver(VirtualMachine vm) {
        this.vm = vm;
    }

    public void resolve_special_call(CallInfo result, Handle recv, KlassHandle resolved_klass, String method_name,
                                     String method_signature, KlassHandle current_klass, boolean check_access) {
        MethodHandle resolved_method = new MethodHandle();
        linktime_resolve_special_method(resolved_method, resolved_klass, method_name, method_signature, current_klass, check_access);
        runtime_resolve_special_method(result, resolved_method, resolved_klass, current_klass, recv, check_access);
    }

    public void resolve_interface_method(MethodHandle resolved_method,
                                                KlassHandle resolved_klass,
                                                String method_name,
                                                String method_signature,
                                                KlassHandle current_klass,
                                                boolean check_access,
                                                boolean nostatics) {

        // check if klass is interface
        if (!resolved_klass.get().isInterface()) {
            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, String.format("Found class %s, but interface was expected", "tmp"));
        }

        // lookup method in this interface or its super, java.lang.Object
        // JDK8: also look for static methods
        lookupMethodInClasses(resolved_method, resolved_klass, method_name, method_signature, false, true);

        if (resolved_method.isNull() && !resolved_klass.get().isArray()) {
            // lookup method in all the super-interfaces
            lookupMethodsInInterfaces(resolved_method, resolved_klass, method_name, method_signature);
        }

        if (resolved_method.isNull()) {
            // no method found
            throw new RuntimeException("implement me");
//            throw vm.newThrowable(VMSymbols.java_lang_NoSuchMethodError, );
        }

        if (check_access) {
            // JDK8 adds non-public interface methods, and accessability check requirement

            // check if method can be accessed by the referring class
//            check_method_accessability(current_klass,
//                    resolved_klass,
//                    KlassHandle(THREAD, resolved_method->method_holder()),
//                    resolved_method,
//                    CHECK);

//            HandleMark hm(THREAD);
//            Handle loader (THREAD, InstanceKlass::cast(current_klass())->class_loader());
//            Handle class_loader (THREAD, resolved_method->method_holder()->class_loader());
//            {
//                ResourceMark rm(THREAD);
//                Symbol* failed_type_symbol =
//                        SystemDictionary::check_signature_loaders(method_signature, loader,
//                    class_loader, true, CHECK);
//                if (failed_type_symbol != NULL) {
//        const char* msg = "loader constraint violation: when resolving "
//                    "interface method \"%s\" the class loader (instance of %s) of the "
//                    "current class, %s, and the class loader (instance of %s) for "
//                    "the method's defining class, %s, have different Class objects for the type %s "
//                    "used in the signature";
//        char* sig = Method::name_and_sig_as_C_string(resolved_klass(),method_name,method_signature);
//        const char* loader1 = SystemDictionary::loader_name(loader());
//        char* current = InstanceKlass::cast(current_klass())->name()->as_C_string();
//        const char* loader2 = SystemDictionary::loader_name(class_loader());
//        char* target = InstanceKlass::cast(resolved_method->method_holder())
//                       ->name()->as_C_string();
//        char* failed_type_name = failed_type_symbol->as_C_string();
//                    size_t buflen = strlen(msg) + strlen(sig) + strlen(loader1) +
//                            strlen(current) + strlen(loader2) + strlen(target) +
//                            strlen(failed_type_name) + 1;
//        char* buf = NEW_RESOURCE_ARRAY_IN_THREAD(THREAD, char, buflen);
//                    jio_snprintf(buf, buflen, msg, sig, loader1, current, loader2,
//                            target, failed_type_name);
//                    THROW_MSG(vmSymbols::java_lang_LinkageError(), buf);
//                }
//            }

            // todo implement me
        }

        if (nostatics && resolved_method.get().isStatic()) {
//            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, String.format("Expected instance not static method %s", nameAndSigAsCString(resolved_klass, resolved_method)));
            throw new RuntimeException("implement me");
        }
    }


    public void linktime_resolve_special_method(MethodHandle resolved_method, KlassHandle resolved_klass,
                                                       String method_name, String method_signature,
                                                       KlassHandle current_klass, boolean check_access) {

        // Invokespecial is called for multiple special reasons:
        // <init>
        // local private method invocation, for classes and interfaces
        // superclass.method, which can also resolve to a default method
        // and the selected method is recalculated relative to the direct superclass
        // superinterface.method, which explicitly does not check shadowing

        if (!resolved_klass.get().isInterface()) {
            resolveMethod(resolved_method, resolved_klass, method_name, method_signature, current_klass, check_access, false);
        } else {
            resolve_interface_method(resolved_method, resolved_klass, method_name, method_signature, current_klass, check_access, true);
        }

        // check if method name is <init>, that it is found in same klass as static type
        if (resolved_method.get().getName().equals("<init>") &&
                resolved_method.get().getDeclaringClass() != resolved_klass.get()) {
//            throw vm.newThrowable(VMSymbols.java_lang_NoSuchMethodError, String.format("%s: method %s%s not found", resolved_klass.get().getExternalName(), resolved_method));
            throw new RuntimeException("implement me");
        }

        // check if invokespecial's interface method reference is in an indirect superinterface
        if (!current_klass.isNull() && resolved_klass.get().isInterface()) {
//            Klass *klass_to_check = !InstanceKlass::cast(current_klass())->is_anonymous() ?
//                    current_klass() :
//                    InstanceKlass::cast(current_klass())->host_klass();
//            // As of the fix for 4486457 we disable verification for all of the
//            // dynamically-generated bytecodes associated with the 1.4
//            // reflection implementation, not just those associated with
//            // sun/reflect/SerializationConstructorAccessor.
//            bool is_reflect = JDK_Version::is_gte_jdk14x_version() &&
//                    UseNewReflection &&
//                    klass_to_check->is_subclass_of(
//                            SystemDictionary::reflect_MagicAccessorImpl_klass());
//
//            if (!is_reflect &&
//                    !InstanceKlass::cast(klass_to_check)->is_same_or_direct_interface(resolved_klass())) {
//                ResourceMark rm(THREAD);
//                char buf[200];
//                jio_snprintf(buf, sizeof(buf),
//                        "Interface method reference: %s, is in an indirect superinterface of %s",
//                        Method::name_and_sig_as_C_string(resolved_klass(),
//                        resolved_method->name(),
//                        resolved_method->signature()),
//                current_klass->external_name());
//                THROW_MSG(vmSymbols::java_lang_IncompatibleClassChangeError(), buf);
//            }
            // todo implement me
        }

        // check if not static
        if (resolved_method.get().isStatic()) {
//            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, String.format("Expecting non-static method %s", nameAndSigAsCString()));
            throw new RuntimeException("implement me");
        }
    }

    // throws runtime exceptions
    void runtime_resolve_special_method(CallInfo result, MethodHandle resolved_method, KlassHandle resolved_klass,
                                                      KlassHandle current_klass, Handle recv, boolean check_access) {

        // resolved method is selected method unless we have an old-style lookup
        // for a superclass method
        // Invokespecial for a superinterface, resolved method is selected method,
        // no checks for shadowing
        MethodHandle sel_method = new MethodHandle(resolved_method.get());

        if (check_access &&
                // check if the method is not <init>
                !resolved_method.get().getName().equals("<init>")) {

            // check if this is an old-style super call and do a new lookup if so
            // a) check if ACC_SUPER flag is set for the current class
            if ((current_klass.get().isSuper() || !/*AllowNonVirtualCalls*/ false) &&
                    // b) check if the class of the resolved_klass is a superclass
                    // (not supertype in order to exclude interface classes) of the current class.
                    // This check is not performed for super.invoke for interface methods
                    // in super interfaces.
                    current_klass.get().isSubclassOf(resolved_klass.get()) &&
                            current_klass.get() != resolved_klass.get()) {
                // Lookup super method
                KlassHandle super_klass = new KlassHandle(current_klass.get().getSuperclass());
                lookup_instance_method_in_klasses(sel_method, super_klass,
                        resolved_method.get().getName(),
                        resolved_method.get().getDescriptor());
                // check if found
                if (sel_method.isNull()) {
//                    throw vm.newThrowable(VMSymbols.java_lang_AbstractMethodError, nameAndSigAsCString());
                    throw new RuntimeException("implement me");
                }
            }

            // Check that the class of objectref (the receiver) is the current class or interface,
            // or a subtype of the current class or interface (the sender), otherwise invokespecial
            // throws IllegalAccessError.
            // The verifier checks that the sender is a subtype of the class in the I/MR operand.
            // The verifier also checks that the receiver is a subtype of the sender, if the sender is
            // a class.  If the sender is an interface, the check has to be performed at runtime.
//            InstanceKlass* sender = InstanceKlass::cast(current_klass());
//            sender = sender->is_anonymous() ? InstanceKlass::cast(sender->host_klass()) : sender;
//            if (sender->is_interface() && recv.not_null()) {
//                Klass* receiver_klass = recv->klass();
//                if (!receiver_klass->is_subtype_of(sender)) {
//                    ResourceMark rm(THREAD);
//                    char buf[500];
//                    jio_snprintf(buf, sizeof(buf),
//                            "Receiver class %s must be the current class or a subtype of interface %s",
//                            receiver_klass->name()->as_C_string(),
//                            sender->name()->as_C_string());
//                    THROW_MSG(vmSymbols::java_lang_IllegalAccessError(), buf);
//                }
//            }
            // todo implement me
        }

        // check if not static
        if (sel_method.get().isStatic()) {
//            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, String.format("Expecting non-static method %s", nameAndSigAsCString()));
            throw new RuntimeException("implement me");
        }

        // check if abstract
        if (sel_method.get().isAbstract()) {
//            throw vm.newThrowable(VMSymbols.java_lang_AbstractMethodError, nameAndSigAsCString(resolved_klass.get(), sel_method.get()));
            throw new RuntimeException("implement me");
        }

        // setup result
        result.setStatic(resolved_klass, sel_method);
    }

    public void resolve_virtual_call(CallInfo result, JavaWrapper recv, KlassHandle receiver_klass, KlassHandle resolved_klass,
                                     String method_name, String method_signature, KlassHandle current_klass,
                                     boolean check_access, boolean check_null_and_abstract) {
        MethodHandle resolved_method = new MethodHandle();
        linktime_resolve_virtual_method(resolved_method, resolved_klass, method_name, method_signature, current_klass, check_access);
        runtime_resolve_virtual_method(result, resolved_method, resolved_klass, recv, receiver_klass, check_null_and_abstract);
    }


    // throws linktime exceptions
    void linktime_resolve_virtual_method(MethodHandle resolved_method, KlassHandle resolved_klass,
                                         String method_name, String method_signature,
                                         KlassHandle current_klass, boolean check_access) {
        // normal method resolution
        resolveMethod(resolved_method, resolved_klass, method_name, method_signature, current_klass, check_access, true);

        // check if private interface method
        if (resolved_klass.get().isInterface() && resolved_method.get().isPrivate()) {
            String fmt = String.format("private interface method requires invokespecial, not invokevirtual: method %s, caller-class:%s", "tmp", "tmp");
            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, fmt);
        }

        // check if not static
        if (resolved_method.get().isStatic()) {
            String fmt = String.format("Expecting non-static method %s", "tmp");
            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, fmt);
        }
    }

    // throws runtime exceptions
    void runtime_resolve_virtual_method(CallInfo result,
                                        MethodHandle resolved_method,
                                        KlassHandle resolved_klass,
                                        JavaWrapper recv,
                                        KlassHandle recv_klass,
                                        boolean check_null_and_abstract
    ) {
        // setup default return values
        int vtable_index = JavaMethod.invalid_vtable_index;
        MethodHandle selected_method = new MethodHandle();

        // runtime method resolution
        if (check_null_and_abstract && recv.is(JavaValueType.NULL)) { // check if receiver exists
            throw vm.newThrowable(VMSymbols.java_lang_NullPointerException);
        }

        // do lookup based on receiver klass using the vtable index
        if (resolved_method.get().getDeclaringClass().isInterface()) { // default or miranda method
//            vtable_index = vtable_index_of_interface_method(resolved_klass,
//                    resolved_method);
//            assert(vtable_index >= 0 , "we should have valid vtable index at this point");
//
//            InstanceKlass* inst = InstanceKlass::cast(recv_klass());
//            selected_method = methodHandle(THREAD, inst->method_at_vtable(vtable_index));
            throw new ExecutionException("Unsupported");
        } else {
//            // at this point we are sure that resolved_method is virtual and not
//            // a default or miranda method; therefore, it must have a valid vtable index.
//            assert(!resolved_method->has_itable_index(), "");
//            vtable_index = resolved_method->vtable_index();
//            // We could get a negative vtable_index for final methods,
//            // because as an optimization they are they are never put in the vtable,
//            // unless they override an existing method.
//            // If we do get a negative, it means the resolved method is the the selected
//            // method, and it can never be changed by an override.
//            if (vtable_index == Method::nonvirtual_vtable_index) {
//                assert(resolved_method->can_be_statically_bound(), "cannot override this method");
//                selected_method = resolved_method;
//            } else {
//                // recv_klass might be an arrayKlassOop but all vtables start at
//                // the same place. The cast is to avoid virtual call and assertion.
//                InstanceKlass* inst = (InstanceKlass*)recv_klass();
//                selected_method = methodHandle(THREAD, inst->method_at_vtable(vtable_index));
//            }

//            vtable_index = -2; //resolved_method.get().getClassNode().methods.indexOf(resolved_method.get().getMethodNode());
            selected_method = resolved_method;
        }

        // check if method exists
        if (selected_method.isNull()) {
            throw new ExecutionException("asdf");
//            ResourceMark rm(THREAD);
//            THROW_MSG(vmSymbols::java_lang_AbstractMethodError(),
//                    Method::name_and_sig_as_C_string(resolved_klass(),
//                    resolved_method->name(),
//                    resolved_method->signature()));
        }

        // check if abstract
        if (check_null_and_abstract && selected_method.get().isAbstract()) {
            throw new ExecutionException("asdf");
//            ResourceMark rm(THREAD);
//            THROW_MSG(vmSymbols::java_lang_AbstractMethodError(),
//                    Method::name_and_sig_as_C_string(resolved_klass(),
//                    selected_method->name(),
//                    selected_method->signature()));
        }
        // setup result
        result.setVirtual(resolved_klass, recv_klass, resolved_method, selected_method, vtable_index);
    }

    // returns first instance method
    // Looks up method in classes, then looks up local default methods
    public void lookup_instance_method_in_klasses(MethodHandle result, KlassHandle klass, String name, String signature) {
        JavaMethod result_oop = klass.get().findMethod(name, signature); // find_overpass
        result.set(result_oop);
        while (!result.isNull() && result.get().isStatic() && result.get().getDeclaringClass().getSuperclass() != null) {
            KlassHandle super_klass = new KlassHandle(result.get().getDeclaringClass().getSuperclass());
            result.set(super_klass.get().findMethod(name, signature)); // find_overpass
        }

        if (klass.get().isArray()) {
            // Only consider klass and super klass for arrays
            return;
        }

        if (result.isNull()) {
//            List<JavaMethod> defaultMethods = klass.get().getDefaultMethods();
//            result.set(klass.findMethod(defaultMethods, name, signature));
            throw new RuntimeException("implement me");
        }
    }

    public void resolveStaticCall(CallInfo result, KlassHandle resolvedClass, String methodName, String methodDesc, KlassHandle currentClass, boolean checkAccess, boolean initialize) {
        MethodHandle resolvedMethod = new MethodHandle();
        linktimeResolveStaticMethod(resolvedMethod, resolvedClass, methodName, methodDesc, currentClass, checkAccess);

        if (initialize && resolvedClass.get().shouldBeInitialized()) {
            vm.initialize(resolvedClass.get());
            linktimeResolveStaticMethod(resolvedMethod, resolvedClass, methodName, methodDesc, currentClass, checkAccess);
        }

        result.setStatic(resolvedClass, resolvedMethod);
    }

    public void linktimeResolveStaticMethod(MethodHandle resolvedMethod, KlassHandle resolvedClass, String methodName, String methodDesc, KlassHandle currentClass, boolean checkAccess) {
        if (!resolvedClass.get().isInterface()) {
            resolveMethod(resolvedMethod, resolvedClass, methodName, methodDesc, currentClass, checkAccess, false);
        } else {

        }

        if (!Modifier.isStatic(resolvedMethod.get().getMethodNode().access)) {
            String fmt = String.format("Expected static method %s", resolvedClass.get().getClassNode().name + "." + resolvedMethod.get().getMethodNode().name + resolvedMethod.get().getMethodNode().desc);
            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, fmt);
        }
    }

    public void resolveMethod(MethodHandle resolvedMethod, KlassHandle resolvedClass, String methodName, String methodSignature, KlassHandle currentClass, boolean checkAccess, boolean requireMethodRef) {
        if (requireMethodRef && resolvedClass.get().isInterface()) {
            String fmt = String.format("Found interface %s, but class was expected",
                    resolvedClass.get().getClassNode().name);
            throw vm.newThrowable(VMSymbols.java_lang_IncompatibleClassChangeError, fmt);
        }

        lookupMethodInClasses(resolvedMethod, resolvedClass, methodName, methodSignature, true, false);

        if (resolvedMethod.isNull() && !resolvedClass.get().isArray()) {
            lookupMethodsInInterfaces(resolvedMethod, resolvedClass, methodName, methodSignature);

            if (resolvedMethod.isNull()) {
                lookupPolymorphicMethod(resolvedMethod, resolvedClass, methodName, methodSignature, currentClass, null, null);
            }
        }

        if (resolvedMethod.isNull()) {
            String fmt = String.format("%s.%s%s",
                    resolvedClass.get().getClassNode().name, methodName, methodSignature);
            throw vm.newThrowable(VMSymbols.java_lang_NoSuchMethodError, fmt);
        }

        if (checkAccess) {
            // todo security stuff
        }
    }

    public void lookupMethodsInInterfaces(MethodHandle result, KlassHandle klass, String name, String signature) {
        // todo maybe should implement
        return;
    }

    public void lookupPolymorphicMethod(MethodHandle result, KlassHandle klass, String name, String fullSignature, KlassHandle currentClass, Object appendixOrNull, Object methodTypeResult) {
        VMSymbols.VMIntrinsics id = JavaMethodHandle.signaturePolymorphicNameId(name);

        if (/* EnableInvokeDynamic && */ klass.get() == vm.getSystemDictionary().getJavaLangInvokeMethodHandle()) {
            if (JavaMethodHandle.isSignaturePolymorphicIntrinsic(id)) {
                boolean keepLastArg = JavaMethodHandle.isSignaturePolymorphicStatic(id);
                String basicSignature = java_lang_invoke_MethodHandleNatives.lookupBasicTypeSignature(vm, fullSignature, keepLastArg);
                MethodHandle result1 = vm.getSystemDictionary().findMethodHandleIntrinsic(id, basicSignature);
                if (result1 != null) {
                    result.set(result1.get());
                }
            } else {
                throw new ExecutionException("Unsupported");
            }
        }
    }

    public void lookupMethodInClasses(MethodHandle result, KlassHandle klass, String name, String signature, boolean checkPolymorphism, boolean inImethodResolve) {
        JavaMethod resultOop = klass.get().uncachedLookupMethod(name, signature);
        if (klass.get().isArray()) {
            result.set(resultOop);
            return;
        }

        if (inImethodResolve &&
                resultOop != null &&
                klass.get().isInterface() &&
                (resultOop.isStatic() || !resultOop.isPublic()) &&
                resultOop.getDeclaringClass() == vm.getSystemDictionary().getJavaLangObject()) {
            resultOop = null;
        }

        if (resultOop == null) {
            resultOop = klass.get().findMethod(name, signature);
        }

        if (resultOop == null) {
            // Check default methods

        }

        if (checkPolymorphism && /* EnableInvokeDynamic */ resultOop != null) {
            // if is polymorphic, ignore
        }

        result.set(resultOop);
    }

    public void resolveField(FieldDescriptor fd, KlassHandle resolvedKlass, String field, String sig, KlassHandle currentKlass, int bytecode, boolean checkAccess, boolean initializeClass) {
        boolean is_static = bytecode == Opcodes.GETSTATIC || bytecode == Opcodes.PUTSTATIC;
        boolean is_put = bytecode == Opcodes.PUTFIELD || bytecode == Opcodes.PUTSTATIC;

        if (resolvedKlass.isNull()) {
            throw vm.newThrowable(VMSymbols.java_lang_NoSuchFieldError, field);
        }

        KlassHandle selKlass = new KlassHandle(resolvedKlass.get().findField(field, sig, fd));
        if (selKlass.isNull()) {
            throw vm.newThrowable(VMSymbols.java_lang_NoSuchFieldError, field);
        }

        if (!checkAccess) {
            return;
        }

        throw new ExecutionException("Checking access is unsupported");
    }
}
