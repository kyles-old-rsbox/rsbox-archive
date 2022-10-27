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

package io.rsbox.toolbox.asm.oops;

import io.rsbox.toolbox.asm.ExecutionOptions;
import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.utils.ASMHelper;
import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadOop extends Oop {
    private static final Map<Thread, ThreadOop> THREAD_TO_OOP_MAP = new HashMap<>();

    private final boolean isMainThread;
    private final Thread backingThread;
    private JavaWrapper thread;

    public ThreadOop(JavaWrapper thread) {
        this(thread, false);
    }

    private ThreadOop(JavaWrapper thread, boolean mainThread) {
        super(null); // todo oops
        this.thread = thread;
        this.isMainThread = mainThread;
        if (isMainThread) {
            backingThread = Thread.currentThread();
        } else {
            backingThread = new NativeThread();
        }
        THREAD_TO_OOP_MAP.put(backingThread, this);
    }

    public static ThreadOop forThread(Thread thread) {
        return THREAD_TO_OOP_MAP.get(thread);
    }

    public static ThreadOop forCurrentThread() {
        return forThread(Thread.currentThread()) == null ? new ThreadOop(null, true) : forThread(Thread.currentThread());
    }

    public JavaWrapper getThread() {
        return this.thread;
    }

    public void setThread(JavaWrapper wrapper) {
        if (this.thread != null) {
            throw new ExecutionException("Cannot set already non-null thread");
        }
        this.thread = wrapper;
    }

    public static void shutdown() {
        for (ThreadOop oop : THREAD_TO_OOP_MAP.values()) {
            if (oop.isMainThread) {
                oop.thread = null;
            } else {
                oop.backingThread.stop();
            }
        }
        THREAD_TO_OOP_MAP.clear();
    }

    public void start() {
        if (this.isMainThread) {
            throw new ExecutionException("Cannot re-start main thread");
        } else {
            try {
                Method m = Thread.class.getDeclaredMethod("start0");
                m.setAccessible(true);
                m.invoke(this.backingThread);
            } catch (ReflectiveOperationException e) {
                throw new ExecutionException(e);
            }
        }
    }

    public void setPriority(int priority) {
        try {
            Method m = Thread.class.getDeclaredMethod("setPriority0", int.class);
            m.setAccessible(true);
            m.invoke(this.backingThread, priority);
        } catch (ReflectiveOperationException e) {
            throw new ExecutionException(e);
        }
    }

    public boolean isAlive() {
        return this.backingThread.isAlive();
    }

    public void setInterrupted() {

    }

    public void yield() {
        if (Thread.currentThread() != backingThread) {
            throw new ExecutionException("Yield called on wrong thread: " + Thread.currentThread() + " vs " + backingThread);
        }
        Thread.yield();
    }

    private class NativeThread extends Thread {
        NativeThread() {
            super("JavaVM Native Thread: " + thread.getJavaClass().getName());
        }

        public void run() {
            VirtualMachine vm = thread.getJavaClass().getVM();
            try {
                vm.execute(thread.getJavaClass().getClassNode(), ASMHelper.findMethod(thread.getJavaClass().getClassNode(), "run", "()V"), thread, Collections.emptyList(), new ExecutionOptions());
            } catch (Throwable t) {
                if (!(t instanceof ThreadDeath)) {
                    t.printStackTrace(System.out);
                }
            } finally {
                /*
                    From Thread#join()

                     * <p> This implementation uses a loop of {@code this.wait} calls
                     * conditioned on {@code this.isAlive}. As a thread terminates the
                     * {@code this.notifyAll} method is invoked. It is recommended that
                     * applications not use {@code wait}, {@code notify}, or
                     * {@code notifyAll} on {@code Thread} instances.
                 */
                try {
                    thread.get().getLock().lock();
                    vm.execute(vm.getSystemDictionary().getJavaLangObject().getClassNode(), ASMHelper.findMethod(vm.getSystemDictionary().getJavaLangObject().getClassNode(), "notifyAll", "()V"), thread, Collections.emptyList(), new ExecutionOptions());
                } finally {
                    thread.get().getLock().unlock();
                }
            }
        }
    }
}
