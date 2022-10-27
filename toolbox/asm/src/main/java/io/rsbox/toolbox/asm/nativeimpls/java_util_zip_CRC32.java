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
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import com.jcraft.jzlib.CRC32;

public class java_util_zip_CRC32 {
    private static final String THIS = "java/util/zip/CRC32";

    public static void registerNatives(VirtualMachine vm) {
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "update", "(II)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            CRC32 crc32 = new CRC32();
            crc32.reset(args[0].asInt());
            crc32.update(new byte[]{(byte) args[1].asInt()}, 0, 1);
            return JavaWrapper.createInteger(vm, (int) (crc32.getValue() & 0xffffffffL));
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "updateBytes", "(I[BII)I", true, Cause.ALL, Effect.NONE, (ctx, inst, args) -> {
            CRC32 crc32 = new CRC32();
            crc32.reset(args[0].asInt());
            crc32.update(ArrayConversionHelper.convertByteArray((JavaArray) args[1].get()), args[2].asInt(), args[3].asInt());
            return JavaWrapper.createInteger(vm, (int) (crc32.getValue() & 0xffffffffL));
        }));
    }
}
