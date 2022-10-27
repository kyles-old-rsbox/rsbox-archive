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
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.List;

public class java_net_Inet4AddressImpl {
    private final VirtualMachine _vm;

    public java_net_Inet4AddressImpl(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/net/Inet4AddressImpl", "lookupAllHostAddr", "(Ljava/lang/String;)[Ljava/net/InetAddress;", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            String host = _vm.convertJavaObjectToString(args[0]);
            System.out.println("[Networking] Resolving host " + host);
            List<InetAddress> resolved = _vm.getNetwork().resolve(host);

            if (resolved.isEmpty()) {
                throw _vm.newThrowable(VMSymbols.java_net_UnknownHostException, host);
            }

            JavaWrapper array = JavaWrapper.createArray(JavaClass.forName(_vm, "[Ljava/net/InetAddress;"), new JavaWrapper[resolved.size()]);
            for (int i = 0; i < resolved.size(); i++) {
                InetAddress address = resolved.get(i);
                if (address instanceof Inet4Address) {
                    array.asArray().set(i, _vm.getNetwork().createInet4Address((Inet4Address) address));
                } else {
                    throw new UnsupportedOperationException("IPv6 addressees are not supported yet (" + address + ")");
                }
            }
            return array;
        }));
    }
}
