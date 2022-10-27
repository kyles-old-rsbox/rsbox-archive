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

import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.internals.VMSymbols;

public class JavaMethodHandle {
    public static VMSymbols.VMIntrinsics signaturePolymorphicNameId(String name) {
        switch (name) {
            case VMSymbols.INVOKE_NAME:
                return VMSymbols.VMIntrinsics.INVOKE_GENERIC;
            case VMSymbols.INVOKE_BASIC_NAME:
                return VMSymbols.VMIntrinsics.INVOKE_BASIC;
            case VMSymbols.LINK_TO_VIRTUAL_NAME:
                return VMSymbols.VMIntrinsics.LINK_TO_VIRTUAL;
            case VMSymbols.LINK_TO_STATIC_NAME:
                return VMSymbols.VMIntrinsics.LINK_TO_STATIC;
            case VMSymbols.LINK_TO_SPECIAL_NAME:
                return VMSymbols.VMIntrinsics.LINK_TO_SPECIAL;
            case VMSymbols.LINK_TO_INTERFACE_NAME:
                return VMSymbols.VMIntrinsics.LINK_TO_INTERFACE;
        }

        // todo this is not official
        if (name.startsWith("invoke")) {
            return VMSymbols.VMIntrinsics.INVOKE_GENERIC;
        }

        return VMSymbols.VMIntrinsics.NONE;
    }

    public static String signaturePolymorphicIntrinsicName(VMSymbols.VMIntrinsics id) {
        switch (id) {
            case INVOKE_BASIC:
                return VMSymbols.INVOKE_BASIC_NAME;
            case LINK_TO_VIRTUAL:
                return VMSymbols.LINK_TO_VIRTUAL_NAME;
            case LINK_TO_STATIC:
                return VMSymbols.LINK_TO_STATIC_NAME;
            case LINK_TO_SPECIAL:
                return VMSymbols.LINK_TO_SPECIAL_NAME;
            case LINK_TO_INTERFACE:
                return VMSymbols.LINK_TO_INTERFACE_NAME;
        }
        throw new ExecutionException("Unsupported vm intrinsic " + id);
    }

    public static boolean isSignaturePolymorphicIntrinsic(VMSymbols.VMIntrinsics id) {
        return id != VMSymbols.VMIntrinsics.INVOKE_GENERIC;
    }

    public static boolean isSignaturePolymorphicStatic(VMSymbols.VMIntrinsics id) {
        return id != null && id.ordinal() >= VMSymbols.VMIntrinsics.FIRST_MH_STATIC.ordinal() && id.ordinal() <= VMSymbols.VMIntrinsics.LAST_MH_SIG_POLY.ordinal();
    }

    public static boolean isIntrinsicStatic(VMSymbols.VMIntrinsics id) {
        return id == VMSymbols.VMIntrinsics.LINK_TO_VIRTUAL
                || id == VMSymbols.VMIntrinsics.LINK_TO_INTERFACE
                || id == VMSymbols.VMIntrinsics.LINK_TO_SPECIAL
                || id == VMSymbols.VMIntrinsics.LINK_TO_STATIC;
    }
}