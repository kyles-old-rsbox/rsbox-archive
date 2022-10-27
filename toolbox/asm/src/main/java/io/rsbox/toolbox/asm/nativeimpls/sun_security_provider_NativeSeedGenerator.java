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
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;

import java.security.SecureRandom;

public class sun_security_provider_NativeSeedGenerator {
    private final VirtualMachine _vm;

    public sun_security_provider_NativeSeedGenerator(VirtualMachine vm) {
        _vm = vm;
        registerNatives();
    }

    private void registerNatives() {
        _vm.hook(HookGenerator.generateUnknownHandlingHook(_vm, "sun/security/provider/NativeSeedGenerator", "nativeGenerateSeed", "([B)Z", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bytes = ArrayConversionHelper.convertByteArray(args[0].asArray());
            secureRandom.nextBytes(bytes);
            for (int i = 0; i < bytes.length; i++) {
                args[0].asArray().set(i, _vm.newByte(bytes[i]));
            }
            return _vm.newBoolean(true);
        }));
    }
}
