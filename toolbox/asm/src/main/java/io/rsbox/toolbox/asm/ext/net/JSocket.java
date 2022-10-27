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

package io.rsbox.toolbox.asm.ext.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JSocket {
    private final int _fd;

    private volatile InputStream _fromExternal;
    private volatile OutputStream _toExternal;

    private final ReadWriteLock _streamRedirectorLock = new ReentrantReadWriteLock();

    JSocket(int fd) {
        _fd = fd;
    }

    public int getFd() {
        return _fd;
    }

    /**
     * Set the source that this socket will read from. Can only be called once
     */
    public void setInput(InputStream inputStream) {
        _streamRedirectorLock.writeLock().lock();
        try {
            if (_fromExternal != null) {
                throw new IllegalArgumentException("input is already set");
            }
            _fromExternal = inputStream;
        } finally {
            _streamRedirectorLock.writeLock().unlock();
        }
    }

    /**
     * Set the destination that this socket will write to
     */
    public void setOutput(OutputStream outputStream) {
        _streamRedirectorLock.writeLock().lock();
        try {
            if (_toExternal != null) {
                throw new IllegalArgumentException("output is already set");
            }
            _toExternal = outputStream;
        } finally {
            _streamRedirectorLock.writeLock().unlock();
        }
    }

    public InputStream getInputStream() {
        _streamRedirectorLock.readLock().lock();
        try {
            return _fromExternal;
        } finally {
            _streamRedirectorLock.readLock().unlock();
        }
    }

    public OutputStream getOutputStream() {
        _streamRedirectorLock.readLock().lock();
        try {
            return _toExternal;
        } finally {
            _streamRedirectorLock.readLock().unlock();
        }
    }

    public boolean isConnected() {
        _streamRedirectorLock.readLock().lock();
        try {
            return _fromExternal != null && _toExternal != null;
        } finally {
            _streamRedirectorLock.readLock().unlock();
        }
    }
}
