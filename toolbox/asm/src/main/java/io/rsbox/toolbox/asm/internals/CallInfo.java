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

import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaMethod;

public class CallInfo {
    private KlassHandle resolvedKlass;
    private KlassHandle selectedKlass;
    private MethodHandle resolvedMethod;
    private MethodHandle selectedMethod;
    private CallKind callKind;
    private int callIndex;

    public CallInfo() {

    }

    // utility query for unreflecting a method
    public CallInfo(JavaMethod resolved_method, JavaClass resolved_klass) {
        JavaClass resolved_method_holder = resolved_method.getDeclaringClass();
        if (resolved_klass == null) { // 2nd argument defaults to holder of 1st
            resolved_klass = resolved_method_holder;
        }
        resolvedKlass = new KlassHandle(resolved_klass);
        selectedKlass = new KlassHandle(resolved_klass);
        resolvedMethod = new MethodHandle(resolved_method);
        selectedMethod = new MethodHandle(resolved_method);
        // classify:
//        CallKind kind = CallKind.UNKNOWN_KIND;
//        int index = resolved_method -> vtable_index();
//        if (resolved_method -> can_be_statically_bound()) {
//            kind = CallInfo::direct_call;
//        } else if (!resolved_method_holder -> is_interface()) {
//            // Could be an Object method inherited into an interface, but still a vtable call.
//            kind = CallInfo::vtable_call;
//        } else if (!resolved_klass -> is_interface()) {
//            // A default or miranda method.  Compute the vtable index.
//            ResourceMark rm;
//            klassVtable * vt = InstanceKlass::cast (resolved_klass) -> vtable();
//            index = LinkResolver::vtable_index_of_interface_method (resolved_klass,
//                    resolved_method);
//            assert (index >= 0 ,"we should have valid vtable index at this point");
//
//            kind = CallInfo::vtable_call;
//        } else if (resolved_method -> has_vtable_index()) {
//            // Can occur if an interface redeclares a method of Object.
//            kind = CallInfo::vtable_call;
//        } else {
//            // A regular interface call.
//            kind = CallInfo::itable_call;
//            index = resolved_method -> itable_index();
//        }
//        assert (index == Method::nonvirtual_vtable_index || index >= 0,err_msg("bad index %d", index));
        callKind = CallKind.DIRECT_CALL; // todo stuff
//        _resolved_appendix = Handle();
//        DEBUG_ONLY(verify());
    }

    public KlassHandle getResolvedKlass() {
        return resolvedKlass;
    }

    public KlassHandle getSelectedKlass() {
        return selectedKlass;
    }

    public MethodHandle getResolvedMethod() {
        return resolvedMethod;
    }

    public MethodHandle getSelectedMethod() {
        return selectedMethod;
    }

    public CallKind getCallKind() {
        return callKind;
    }

    public int getCallIndex() {
        return callIndex;
    }

    public void setStatic(KlassHandle resolved_klass, MethodHandle resolved_method) {
        int vtable_index = /*Method::nonvirtual_vtable_index*/ -2;
        setCommon(resolved_klass, resolved_klass, resolved_method, resolved_method, CallKind.DIRECT_CALL, vtable_index);
    }

    public void setVirtual(KlassHandle resolved_klass, KlassHandle selected_klass, MethodHandle resolved_method, MethodHandle selected_method, int vtable_index) {
//        System.out.println("Selected method is " + selected_method.get().getDeclaringClass().getClassNode().name + " " + selected_method.get().getMethodNode().name + selected_method.get().getMethodNode().desc + " " + Integer.toHexString(selected_method.get().getMethodNode().access));
        CallKind kind = CallKind.VTABLE_CALL; //(vtable_index >= 0 && !resolved_method->can_be_statically_bound() ? CallInfo::vtable_call : CallInfo::direct_call);
        setCommon(resolved_klass, selected_klass, resolved_method, selected_method, kind, vtable_index);
    }

    private void setCommon(KlassHandle resolvedKlass, KlassHandle selectedKlass, MethodHandle resolvedMethod, MethodHandle selectedMethod, CallKind callKind, int index) {
        this.resolvedKlass = resolvedKlass;
        this.selectedKlass = selectedKlass;
        this.resolvedMethod = resolvedMethod;
        this.selectedMethod = selectedMethod;
        this.callKind = callKind;
        this.callIndex = index;
    }

    public enum CallKind {
        DIRECT_CALL,
        VTABLE_CALL,
        ITABLE_CALL,
        UNKNOWN_KIND
    }
}
