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

package io.rsbox.toolbox.asm.ext;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.values.JavaArray;
import org.objectweb.asm.Type;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Memory {

    private final VirtualMachine _vm;
    private final NavigableMap<Long, ByteBuffer> memory = new TreeMap<>();

    public Memory(VirtualMachine vm) {
        _vm = vm;
    }

    public long allocateMemory(long size) {
        long address;
        while (true) {
            address = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
            if (memory.size() == 0) {
                break;
            }
            Long start = memory.floorKey(address);
            if (start == null) {
                // we picked an address which was less than the earliest address
                long lowest = memory.firstKey();
                if (address + size < lowest) {
                    break;
                } else {
                    continue;
                }
            }
            int startSize = memory.get(start).capacity();
            if (start + startSize >= address) {
                continue;
            }
            break;
        }

        if (size != (int) size) {
            throw new ExecutionException("Allocating too much memory");
        }

        ByteBuffer allocated = ByteBuffer.allocateDirect((int) size);
        allocated.order(ByteOrder.LITTLE_ENDIAN);
        memory.put(address, allocated);
        return address;
    }

    public void putLong(long address, long value) {
        ByteBuffer buf = getBufferForAddress(address);
        int offset = (int) (address - memory.floorKey(address));
        buf.putLong(offset, value);
    }

    public void putChar(long address, char value) {
        ByteBuffer buf = getBufferForAddress(address);
        int offset = (int) (address - memory.floorKey(address));
        buf.putChar(offset, value);
    }

    public long getLong(long address) {
        ByteBuffer buf = getBufferForAddress(address);
        int offset = (int) (address - memory.floorKey(address));
        return buf.getLong(offset);
    }

    public byte getByte(long address) {
        ByteBuffer buf = getBufferForAddress(address);
        int offset = (int) (address - memory.floorKey(address));
        return buf.get(offset);
    }

    public void freeMemory(long address) {
        memory.remove(memory.floorKey(address));
    }

    public ByteBuffer getBufferForAddress(long address) {
        return memory.get(memory.floorKey(address));
    }

    private long getOffset(long unmapped) {
        return unmapped - memory.floorKey(unmapped);
    }

    public void copy(long srcAddr, long dstAddr, long len) {
        int intLen = (int) len;
        ByteBuffer src = getBufferForAddress(srcAddr);
        ByteBuffer dst = getBufferForAddress(dstAddr);
        if (src == null || dst == null) {
            throw new ExecutionException("Strange.. copying from null src/dst: " + srcAddr + " " + dstAddr);
        }
        if (intLen != len) {
            throw new ExecutionException("Copying too much memory: " + len);
        }

        int srcOffset = (int) getOffset(srcAddr);
        int dstOffset = (int) getOffset(dstAddr);
        byte[] contents = new byte[intLen];
        src.get(contents, srcOffset, intLen);
        dst.put(contents, dstOffset, intLen);
    }
    public void copy(JavaArray src, long srcOffset, long dstAddr, long len) {
        int intLen = (int) len;
        ByteBuffer dst = getBufferForAddress(dstAddr);
        if (dst == null) {
            throw new ExecutionException("Strange.. copying from null dst: " + dstAddr);
        }
        if (intLen != len) {
            throw new ExecutionException("Copying too much memory: " + len);
        }

        int dstOffset = (int) getOffset(dstAddr);

        switch (src.getJavaClass().internalGetType().getElementType().getSort()) {
            case Type.CHAR: {
                if (srcOffset % 2 != 0) {
                    throw new ExecutionException("Splitting char");
                }
//                System.out.println("Copying to " + dstAddr + " " + dst);
//                System.out.println(srcOffset + " " + src.length());
                dst.position(dstOffset);
                for (int i = ((int) srcOffset / 2); i < src.length(); i++) {
                    dst.putChar(src.get(i).asChar());
                }
                break;
            }
            default:
                throw new ExecutionException("Copying from unsupported array type " + src.getJavaClass());
        }
    }
}
