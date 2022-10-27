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

import java.io.IOException;
import java.net.InetSocketAddress;

public class java_net_DualStackPlainSocketImpl {
    private final VirtualMachine _vm;

    public java_net_DualStackPlainSocketImpl(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/net/DualStackPlainSocketImpl", "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/net/DualStackPlainSocketImpl", "socket0", "(ZZ)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            return _vm.newInt(_vm.getNetwork().newSocket(args[0].asBoolean(), args[1].asBoolean()).getFd());
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/net/DualStackPlainSocketImpl", "connect0", "(ILjava/net/InetAddress;I)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            int fd = args[0].asInt();
            boolean connected = _vm.getNetwork().connect(fd, new InetSocketAddress(_vm.getNetwork().getInetAddress(args[1]), args[2].asInt()));
            if (!connected) {
                throw _vm.newThrowable(VMSymbols.java_net_SocketException, "Could not connect");
            }
            return _vm.newInt(0);
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/net/DualStackPlainSocketImpl", "localPort0", "(I)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            System.out.println("[Networking] Getting local port of socket " + args[0].asInt());
            return _vm.newInt(12345);
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/net/DualStackPlainSocketImpl", "setIntOption", "(III)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            System.out.println("[Networking] Setting option of socket " + args[0].asInt() + ": " + args[1].asInt() + " = " + args[2].asInt());
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingVoidHook(_vm, "java/net/DualStackPlainSocketImpl", "close0", "(I)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            System.out.println("[Networking] Closing socket " + args[0].asInt());
        }));
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "java/net/DualStackPlainSocketImpl", "available0", "(I)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            try {
                return _vm.newInt(_vm.getNetwork().socketAvailable(args[0].asInt()));
            } catch (IOException e) {
                throw _vm.newThrowable(VMSymbols.java_io_IOException);
            }
        }));
    }
}
