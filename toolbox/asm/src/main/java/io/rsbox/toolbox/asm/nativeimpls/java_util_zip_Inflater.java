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

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZStream;
import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.utils.ArrayConversionHelper;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.jcraft.jzlib.JZlib.*;

public class java_util_zip_Inflater {
    private static final String THIS = "java/util/zip/Inflater";

    public static void registerNatives(VirtualMachine vm) {
        Lock nativesLock = new ReentrantLock();
        Map<Long, Inflater> natives = new HashMap<>();

        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "initIDs", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "init", "(Z)J", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = new Inflater();
            int ret = inflater.init(JZlib.MAX_WBITS, args[0].asPrimitive().asBoolean());
            switch (ret) {
                case JZlib.Z_OK: {
                    nativesLock.lock();
                    try {
                        long address;
                        do {
                            address = ThreadLocalRandom.current().nextLong();
                        } while (natives.containsKey(address));
                        natives.put(address, inflater);
                        return vm.newLong(address);
                    } finally {
                        nativesLock.unlock();
                    }
                }
                case JZlib.Z_MEM_ERROR: {
                    throw vm.newThrowable(VMSymbols.java_lang_OutOfMemoryError);
                }
                default: {
                    String msg = ((inflater.msg != null) ? inflater.msg :
                            (ret == Z_VERSION_ERROR) ?
                                    "zlib returned Z_VERSION_ERROR: " +
                                            "compile time and runtime zlib implementations differ" :
                                    (ret == Z_STREAM_ERROR) ?
                                            "inflateInit2 returned Z_STREAM_ERROR" :
                                            "unknown error initializing zlib library");
                    throw vm.newThrowable(VMSymbols.java_lang_InternalError, msg);
                }
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "setDictionary", "(J[BII)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = natives.get(args[0].asLong());

            byte[] origDictionary = ArrayConversionHelper.convertByteArray((JavaArray) args[1].get());
            byte[] actualDictionary = Arrays.copyOfRange(origDictionary, args[2].asInt(), args[2].asInt() + args[3].asInt());

            int result = inflater.setDictionary(actualDictionary, args[3].asInt());
            switch (result) {
                case Z_OK: {
                    return;
                }
                case Z_STREAM_ERROR:
                case Z_DATA_ERROR: {
                    throw vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException, inflater.msg);
                }
                default: {
                    throw vm.newThrowable(VMSymbols.java_lang_InternalError, inflater.msg);
                }
            }
        }));

        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "inflateBytes", "(J[BII)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = natives.get(args[0].asLong());

            JavaArray thisBuf = (JavaArray) ((JavaObject) inst.get()).getField("buf", "[B").get();
            int thisOff = ((JavaObject) inst.get()).getField("off", "I").asInt();
            int thisLen = ((JavaObject) inst.get()).getField("len", "I").asInt();

            byte[] in_buf = ArrayConversionHelper.convertByteArray(thisBuf);
            byte[] out_buf = ArrayConversionHelper.convertByteArray((JavaArray) args[1].get());

            inflater.next_in = in_buf;
            inflater.next_out = out_buf;
            inflater.avail_in = thisLen;
            inflater.avail_out = args[3].asInt();
            inflater.next_in_index = thisOff;
            inflater.next_out_index = args[2].asInt();

            int ret = inflater.inflate(JZlib.Z_PARTIAL_FLUSH);
            args[1].set(ArrayConversionHelper.convertByteArray(vm, out_buf).get());

            switch (ret) {
                case Z_STREAM_END: {
                    ((JavaObject) inst.get()).setField("finished", "Z", vm.TRUE);
                }
                case Z_OK: {
                    thisOff += thisLen - inflater.avail_in;
                    ((JavaObject) inst.get()).setField("off", "I", JavaWrapper.createInteger(vm, thisOff));
                    ((JavaObject) inst.get()).setField("len", "I", JavaWrapper.createInteger(vm, inflater.avail_in));
                    return JavaWrapper.createInteger(vm, args[3].asInt() - inflater.avail_out);
                }
                case Z_NEED_DICT: {
                    ((JavaObject) inst.get()).setField("needDict", "Z", vm.TRUE);
                    thisOff += thisLen - inflater.avail_in;
                    ((JavaObject) inst.get()).setField("off", "I", JavaWrapper.createInteger(vm, thisOff));
                    ((JavaObject) inst.get()).setField("len", "I", JavaWrapper.createInteger(vm, inflater.avail_in));
                    return JavaWrapper.createInteger(vm, 0);
                }
                case Z_BUF_ERROR: {
                    return JavaWrapper.createInteger(vm, 0);
                }
                case Z_DATA_ERROR: {
                    throw vm.newThrowable(VMSymbols.java_util_zip_DataFormatException, inflater.msg);
                }
                case Z_MEM_ERROR: {
                    throw vm.newThrowable(VMSymbols.java_lang_OutOfMemoryError);
                }
                default: {
                    throw vm.newThrowable(VMSymbols.java_lang_InternalError, inflater.msg);
                }
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingHook(vm, THIS, "getAdler", "(J)I", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = natives.get(args[0].asLong());
            return JavaWrapper.createInteger(vm, (int) inflater.getAdler());
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "reset", "(J)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = natives.get(args[0].asLong());
            try {
                Field istate = ZStream.class.getDeclaredField("istate");
                istate.setAccessible(true);
                Object inflate = istate.get(inflater);
                Method inflateReset = inflate.getClass().getDeclaredMethod("inflateReset");
                inflateReset.setAccessible(true);
                if (((Integer) inflateReset.invoke(inflate)) != Z_OK) {
                    throw vm.newThrowable(VMSymbols.java_lang_InternalError, inflater.msg);
                }
            } catch (ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }));
        vm.hook(HookGenerator.generateUnknownHandlingVoidHook(vm, THIS, "end", "(J)V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            Inflater inflater = natives.get(args[0].asLong());
            if (inflater.end() != Z_OK) {
                throw vm.newThrowable(VMSymbols.java_lang_InternalError, inflater.msg);
            } else {
                nativesLock.lock();
                try {
                    natives.remove(args[0].asLong());
                } finally {
                    nativesLock.unlock();
                }
            }
        }));
    }
}
