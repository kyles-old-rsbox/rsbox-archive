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

package io.rsbox.toolbox.asm.utils;

import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.values.JavaArray;
import io.rsbox.toolbox.asm.values.JavaObject;
import io.rsbox.toolbox.asm.values.JavaValue;
import io.rsbox.toolbox.asm.values.prim.JDouble;
import io.rsbox.toolbox.asm.values.prim.JFloat;
import io.rsbox.toolbox.asm.values.prim.JInteger;
import io.rsbox.toolbox.asm.values.prim.JLong;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.util.Printer;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceMethodVisitor;

import java.io.*;

public class Utils {
    private static final ThreadLocal<Printer> printer = ThreadLocal.withInitial(() -> new Textifier());
    private static final ThreadLocal<TraceMethodVisitor> methodPrinter = ThreadLocal.withInitial(() -> new TraceMethodVisitor(printer.get()));

    public static long copy(InputStream from, OutputStream to) throws IOException {
        byte[] buf = new byte[4096];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                break;
            }
            to.write(buf, 0, r);
            total += r;
        }
        return total;
    }

    public static void sneakyThrow(Throwable t) {
        Utils.<Error>sneakyThrow0(t);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
        throw (T) t;
    }

    public static String prettyprint(AbstractInsnNode insnNode) {
        insnNode.accept(methodPrinter.get());
        StringWriter sw = new StringWriter();
        printer.get().print(new PrintWriter(sw));
        printer.get().getText().clear();
        return sw.toString().trim();
    }

    public static boolean isObjectOfType(Type type, JavaValue object) {
        switch (type.getSort()) {
            case Type.BOOLEAN:
                if (!(object instanceof JInteger)) {
                    throw new ExecutionException("Expected JavaBoolean, got " + object);
                }
                break;
            case Type.CHAR:
                if (!(object instanceof JInteger)) {
                    throw new ExecutionException("Expected JavaCharacter, got " + object);
                }
                break;
            case Type.BYTE:
                if (!(object instanceof JInteger)) {
                    throw new ExecutionException("Expected JavaByte, got " + object);
                }
                break;
            case Type.SHORT:
                if (!(object instanceof JInteger)) {
                    throw new ExecutionException("Expected JavaShort, got " + object);
                }
                break;
            case Type.INT:
                if (!(object instanceof JInteger)) {
                    throw new ExecutionException("Expected JavaInteger, got " + object);
                }
                break;
            case Type.FLOAT:
                if (!(object instanceof JFloat)) {
                    throw new ExecutionException("Expected JavaFloat, got " + object);
                }
                break;
            case Type.LONG:
                if (!(object instanceof JLong)) {
                    throw new ExecutionException("Expected JavaLong, got " + object);
                }
                break;
            case Type.DOUBLE:
                if (!(object instanceof JDouble)) {
                    throw new ExecutionException("Expected JavaDouble, got " + object);
                }
                break;
            case Type.ARRAY:
            case Type.OBJECT:
                if (!(object instanceof JavaObject) && !(object instanceof JavaArray)) {
                    throw new ExecutionException("Expected JavaObject/JavaArray, got " + object);
                }
                break;
        }
        return true;
    }
}
