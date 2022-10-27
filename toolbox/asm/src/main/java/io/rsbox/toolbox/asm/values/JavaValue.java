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

package io.rsbox.toolbox.asm.values;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import org.objectweb.asm.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JavaValue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Object metadataLock = new Object();
    /*
     * @Deprecated until field slots work
     */
    @Deprecated
    private volatile Map<String, Object> metadata;

    public static JavaWrapper forPrimitive(VirtualMachine vm, Type type) {
        if (type.getSort() == Type.METHOD || type.getSort() == Type.VOID) {
            throw new ExecutionException("An internal error occurred: Cannot create primitive for " + type.getSort());
        }
        switch (type.getSort()) {
            case Type.BOOLEAN:
                return vm.newBoolean(false);
            case Type.BYTE:
                return vm.newByte((byte) 0);
            case Type.CHAR:
                return vm.newChar('\u0000');
            case Type.DOUBLE:
                return JavaWrapper.createDouble(vm, 0.0D);
            case Type.FLOAT:
                return JavaWrapper.createFloat(vm, 0.0F);
            case Type.INT:
                return JavaWrapper.createInteger(vm, 0);
            case Type.LONG:
                return vm.newLong(0L);
            case Type.SHORT:
                return vm.newShort((short) 0);
            case Type.OBJECT:
            case Type.ARRAY:
                return vm.getNull();
            default:
                throw new ExecutionException("Did not expect primitive type " + type.getSize());
        }
    }

    public abstract boolean is(JavaValueType type);

    public byte asByte() {
        throw new ExecutionException("Cannot call byteValue()");
    }

    public char asChar() {
        throw new ExecutionException("Cannot call charValue()");
    }

    public short asShort() {
        throw new ExecutionException("Cannot call shortValue()");
    }

    public int asInt() {
        throw new ExecutionException("Cannot call intValue()");
    }

    public float asFloat() {
        throw new ExecutionException("Cannot call floatValue()");
    }

    public double asDouble() {
        throw new ExecutionException("Cannot call doubleValue()");
    }

    public long asLong() {
        throw new ExecutionException("Cannot call longValue()");
    }

    public boolean asBoolean() {
        throw new ExecutionException("Cannot call booleanValue()");
    }

    public VirtualMachine getVM() {
        return null;
    }

    public String type() {
        throw new ExecutionException(new UnsupportedOperationException());
    }

    public abstract JavaClass getJavaClass();

    public JavaClass getOriginalClass() {
        return getJavaClass();
    }

    public boolean isInstanceOf(Type type) {
        JavaClass s = getOriginalClass();
        JavaClass t = JavaClass.forName(s.getVM(), type);
        return t.isAssignableFrom(s);
    }

    /**
     * Get the size of this object
     *
     * @return Either 1, or 2
     */
    public abstract int getSize();

    public Condition getCondition() {
        return condition;
    }

    public Lock getLock() {
        return lock;
    }

    @Deprecated
    public <T> T getMetadata(String key) {
        synchronized (metadataLock) {
            if (metadata == null) {
                return null;
            }
            return (T) metadata.get(key);
        }
    }

    @Deprecated
    public void setMetadata(String key, Object data) {
        synchronized (metadataLock) {
            if (metadata == null) {
                metadata = new HashMap<>(4);
            }
            metadata.put(key, data);
        }
    }

    @Deprecated
    public Map<String, Object> getMetadata() {
        synchronized (metadataLock) {
            if (metadata == null) {
                return null;
            }
            return new HashMap<>(metadata);
        }
    }

    @Deprecated
    public void setMetadata(Map<String, Object> metadata0) {
        if (metadata0 != null) {
            synchronized (metadataLock) {
                if (metadata == null) {
                    metadata = new HashMap<>(4);
                }
                metadata.clear();
                metadata.putAll(metadata0);
            }
        }
    }

    public <T> T compareAndSwapMetadata(String key, T data, T expected) {
        synchronized (metadataLock) {
            // metadata == null implies that expected needs to be null
            if (metadata == null) {
                if (expected == null) {
                    return null;
                }
                metadata = new HashMap<>();
            }
            T old = (T) metadata.get(key);
            if (old == expected) {
                metadata.put(key, data);
                return (T) data;
            }
            return (T) old;
        }
    }
}
