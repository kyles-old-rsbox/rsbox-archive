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

public class VMSymbols {
    public static final int MAX_SYMBOL_LENGTH = (1 << 16) - 1;
    public static final String java_lang_IncompatibleClassChangeError = "java/lang/IncompatibleClassChangeError";
    public static final String java_lang_NoSuchMethodError = "java/lang/NoSuchMethodError";
    public static final String java_lang_NoSuchFieldError = "java/lang/NoSuchFieldError";
    public static final String java_lang_InternalError = "java/lang/InternalError";
    public static final String java_lang_NullPointerException = "java/lang/NullPointerException";
    public static final String java_lang_ClassCastException = "java/lang/ClassCastException";
    public static final String INVOKE_NAME = "invoke";
    public static final String INVOKE_BASIC_NAME = "invokeBasic";
    public static final String LINK_TO_VIRTUAL_NAME = "linkToVirtual";
    public static final String LINK_TO_STATIC_NAME = "linkToStatic";
    public static final String LINK_TO_SPECIAL_NAME = "linkToSpecial";
    public static final String LINK_TO_INTERFACE_NAME = "linkToInterface";
    public static final String java_lang_ArithmeticException = "java/lang/ArithmeticException";
    public static final String java_lang_ArrayIndexOutOfBoundsException = "java/lang/ArrayIndexOutOfBoundsException";
    public static final String java_lang_ArrayStoreException = "java/lang/ArrayStoreException";
    public static final String java_lang_ClassNotFoundException = "java/lang/ClassNotFoundException";
    public static final String java_lang_NoClassDefFoundError = "java/lang/NoClassDefFoundError";
    public static final String java_lang_IllegalArgumentException = "java/lang/IllegalArgumentException";
    public static final String java_lang_OutOfMemoryError = "java/lang/OutOfMemoryError";
    public static final String java_util_concurrent_ConcurrentHashMap = "java/util/concurrent/ConcurrentHashMap";
    public static final String java_util_zip_DataFormatException = "java/util/zip/DataFormatException";
    public static final String java_util_concurrent_ConcurrentHashMap_sig = "L" + java_util_concurrent_ConcurrentHashMap + ";";
    public static final String java_lang_CloneNotSupportedException = "java/lang/CloneNotSupportedException";
    public static final String java_io_FileNotFoundException = "java/io/FileNotFoundException";
    public static final String java_lang_InterruptedExecption = "java/lang/InterruptedException";
    public static final String java_net_UnknownHostException = "java/net/UnknownHostException";
    public static final String java_net_SocketException = "java/net/SocketException";
    public static final String java_io_IOException = "java/io/IOException";
    public static final String java_lang_Class = "java/lang/Class";
    public static final String java_lang_Class_forName0_name = "forName0";
    public static final String java_lang_Class_forName0_sig = "(Ljava/lang/String;ZLjava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Class;";
    public static final String java_lang_ClassLoader = "java/lang/ClassLoader";
    public static final String java_lang_ClassLoader_parallelLockMap_name = "parallelLockMap";
    public static final String java_lang_ClassLoader_parallelLockMap_sig = java_util_concurrent_ConcurrentHashMap_sig;
    @Deprecated
    public static final String METADATA_KLASS = "metadata/klass";
    @Deprecated
    public static final String METADATA_FIELD = "metadata/field";
    @Deprecated
    public static final String METADATA_LOADER_DATA = "metadata/loaderdata";
    public static final String java_lang_Throwable = "java/lang/Throwable";

    public enum VMIntrinsics {
        NONE,
        INVOKE,
        INVOKE_GENERIC,
        INVOKE_BASIC,
        LINK_TO_VIRTUAL,
        LINK_TO_STATIC,
        LINK_TO_SPECIAL,
        LINK_TO_INTERFACE;

        public static final VMIntrinsics FIRST_MH_SIG_POLY = INVOKE_GENERIC;
        public static final VMIntrinsics FIRST_MH_STATIC = LINK_TO_VIRTUAL;
        public static final VMIntrinsics LAST_MH_SIG_POLY = LINK_TO_INTERFACE;
    }
}
