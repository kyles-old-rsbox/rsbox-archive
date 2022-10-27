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
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import jdk.internal.misc.SharedSecrets;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Filesystem {

    private final VirtualMachine _vm;

    // filesystem
    private final Map<File, File> map = new HashMap<>();
    private final AtomicInteger fds = new AtomicInteger();

    // zipfiles
    private final Map<Long, ZipFile> openedZipFiles = new HashMap<>();
    private final Object openedZipFilesLock = new Object();
    private final Map<Long, ZipEntry0> openedEntries = new HashMap<>();
    private final Object openedEntriesLock = new Object();
    private final Map<Long, List<Long>> zipFileToEntry = new HashMap<>();
    private final Object zipFileToEntryLock = new Object();

    public Filesystem(VirtualMachine vm) {
        _vm = vm;
    }

    public int nextFd() {
        return fds.incrementAndGet();
    }

    public void map(File original, File mapped) {
        map.put(original, mapped);
    }

    public File map(File input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        return null;
    }

    public void closeZip(long address) {
        synchronized (openedZipFilesLock) {
            ZipFile backingFile = openedZipFiles.remove(address);
            List<Long> entries;
            synchronized (zipFileToEntryLock) {
                entries = zipFileToEntry.remove(address);
            }

            if (entries != null) {
                try {
                    Field jzfile = ZipFile.class.getDeclaredField("jzfile");
                    jzfile.setAccessible(true);
                    long nativeAddr = jzfile.getLong(backingFile);
                    Method freeEntry = ZipFile.class.getDeclaredMethod("freeEntry", long.class, long.class);
                    freeEntry.setAccessible(true);
                    for (Long l : entries) {
                        ZipEntry0 backingEntry;
                        synchronized (openedEntriesLock) {
                            backingEntry = openedEntries.remove(l);
                        }
                        freeEntry.invoke(null, nativeAddr, backingEntry.nativeAddr);
                    }
                } catch (ReflectiveOperationException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public long openZipfile(String file, int mode, long lastModified, boolean usemmap) {
        File actualFile = _vm.getFilesystem().map(new File(file));
        if (actualFile != null && actualFile.exists()) {
            System.out.println("[Filesystem] Opening " + actualFile + " (" + file + ")");
            try {
                ZipFile backingFile = new ZipFile(actualFile);
                long handle;

                synchronized (openedZipFilesLock) {
                    do {
                        handle = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
                    } while (openedZipFiles.containsKey(handle));
                    openedZipFiles.put(handle, backingFile);
                }

                Field jzfile = ZipFile.class.getDeclaredField("jzfile");
                jzfile.setAccessible(true);
                Method getNextEntry = ZipFile.class.getDeclaredMethod("getNextEntry", long.class, int.class);
                getNextEntry.setAccessible(true);
                Method getZipEntry = ZipFile.class.getDeclaredMethod("getZipEntry", String.class, long.class);
                getZipEntry.setAccessible(true);
                Method getEntryBytes = ZipFile.class.getDeclaredMethod("getEntryBytes", long.class, int.class);
                getEntryBytes.setAccessible(true);
                Method getEntryTime = ZipFile.class.getDeclaredMethod("getEntryTime", long.class);
                getEntryTime.setAccessible(true);
                Method getEntryFlag = ZipFile.class.getDeclaredMethod("getEntryFlag", long.class);
                getEntryFlag.setAccessible(true);

                long nativeAddr = jzfile.getLong(backingFile);

                for (int i = 0; i < backingFile.size(); i++) {
                    long nativeEntryAddr = (long) getNextEntry.invoke(null, nativeAddr, i);
                    ZipEntry entry = (ZipEntry) getZipEntry.invoke(backingFile, null, nativeEntryAddr);
                    byte[] name = (byte[]) getEntryBytes.invoke(null, nativeEntryAddr, 0);
                    byte[] extra = (byte[]) getEntryBytes.invoke(null, nativeEntryAddr, 1);
                    byte[] comment = (byte[]) getEntryBytes.invoke(null, nativeEntryAddr, 2);
                    long time = (long) getEntryTime.invoke(null, nativeEntryAddr);
                    int flags = (int) getEntryFlag.invoke(null, nativeEntryAddr);

                    ZipEntry0 entry0 = new ZipEntry0(nativeEntryAddr, entry, name, extra, comment, time, flags);

                    long entryHandle;
                    synchronized (openedEntriesLock) {
                        do {
                            entryHandle = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
                        } while (openedEntries.containsKey(entryHandle));
                        openedEntries.put(entryHandle, entry0);
                    }
                    synchronized (zipFileToEntryLock) {
                        zipFileToEntry.computeIfAbsent(handle, key -> new ArrayList<>()).add(entryHandle);
                    }
                }

                return handle;
            } catch (IOException | ReflectiveOperationException ex) {
                // todo
                throw new ExecutionException("unhandled exception while opening zipfile", ex);
            }
        } else {
            System.out.println("[Filesystem] Could not find " + file);
            return -1;
        }
    }

    public int getZipTotal(long address) {
        ZipFile zipFile = getZipFile(address);
        return zipFile.size();
    }

    public boolean getZipStartsWithLOC(long address) {
        ZipFile zipFile = getZipFile(address);
        return SharedSecrets.getJavaUtilZipFileAccess().startsWithLocHeader(zipFile);
    }

    public long getZipNextEntry(long address, int index) {
        List<Long> entries = getZipFileEntries(address);
        return entries.get(index);
    }

    public long getZipEntryTime(long address) {
        return getZipEntry(address).time;
    }

    public long getZipEntryCrc(long address) {
        return getZipEntry(address).entry.getCrc();
    }

    public long getZipEntryCSize(long address) {
        return getZipEntry(address).entry.getCompressedSize();
    }

    public long getZipEntrySize(long address) {
        return getZipEntry(address).entry.getSize();
    }

    public int getZipEntryMethod(long address) {
        return getZipEntry(address).entry.getMethod();
    }

    public int getZipEntryFlag(long address) {
        return getZipEntry(address).flag;
    }

    public byte[] getZipCommentBytes(long address) {
        try {
            ZipFile instance = getZipFile(address);
            Field jzfile = ZipFile.class.getDeclaredField("jzfile");
            jzfile.setAccessible(true);
            long jzfileVal = jzfile.getLong(instance);
            Method getCommentBytes = ZipFile.class.getDeclaredMethod("getCommentBytes", long.class);
            getCommentBytes.setAccessible(true);
            return (byte[]) getCommentBytes.invoke(null, jzfileVal);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public ZipFile getZipFile(long address) {
        synchronized (openedZipFilesLock) {
            return openedZipFiles.get(address);
        }
    }

    public List<Long> getZipFileEntries(long address) {
        synchronized (zipFileToEntryLock) {
            return zipFileToEntry.get(address);
        }
    }

    public ZipEntry0 getZipEntry(long address) {
        synchronized (openedEntriesLock) {
            return openedEntries.get(address);
        }
    }

    public byte[] getZipEntryBytes(long address, int type) {
        switch (type) {
            case 0:
                return getZipEntry(address).name;
            case 1:
                return getZipEntry(address).extra;
            case 2:
                return getZipEntry(address).comment;
            default:
                return null;
        }
    }

    public long getZipGetEntry(long address, byte[] name, boolean addSlash) {
        List<Long> entries = getZipFileEntries(address);
        for (Long l : entries) {
            if (Arrays.equals(getZipEntry(l).name, name)) {
                return l;
            }
        }
        if (addSlash && name[name.length - 1] != '/') {
            byte[] newName = Arrays.copyOf(name, name.length + 1);
            newName[newName.length - 1] = '/';
            return getZipGetEntry(address, name, false);
        }
        return 0;
    }

    public int zipRead(long address, long entry, long pos, byte[] target, int off, int len) {
        try {
            ZipFile zipFile = getZipFile(address);
            Field jzfile = ZipFile.class.getDeclaredField("jzfile");
            jzfile.setAccessible(true);
            long nativeAddr = jzfile.getLong(zipFile);
            ZipEntry0 backingEntry = getZipEntry(entry);
            Method read = ZipFile.class.getDeclaredMethod("read", long.class, long.class, long.class, byte[].class, int.class, int.class);
            read.setAccessible(true);
            return (int) read.invoke(null, nativeAddr, backingEntry.nativeAddr, pos, target, off, len);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public JavaWrapper getZipGetMetaInfEntryNames(long address) {
        List<Long> entries = getZipFileEntries(address);

        String want = "META-INF/";

        List<String> found = new ArrayList<>();
        entries: for (long entryAddress : entries) {
            ZipEntry0 entry = getZipEntry(entryAddress);
            if (entry.name.length < want.length()) {
                continue;
            }
            for (int i = 0; i < want.length(); i++) {
                char nameChar = (char) entry.name[i];
                if (nameChar >= 'a' && nameChar <= 'z') {
                    nameChar += 'A' - 'a';
                }
                if (want.charAt(i) != nameChar) {
                    continue entries;
                }
            }
            found.add(new String(entry.name, StandardCharsets.UTF_8));
        }

        JavaWrapper array = JavaWrapper.createArray(JavaClass.forName(_vm, "[Ljava/lang/String;"), new JavaWrapper[found.size()]);
        for (int i = 0; i < found.size(); i++) {
            array.asArray().set(i, _vm.getStringInterned(found.get(i)));
        }
        return array;
    }

    private static class ZipEntry0 {
        private long nativeAddr;
        private ZipEntry entry;
        private byte[] name;
        private byte[] extra;
        private byte[] comment;
        private long time;
        private int flag;

        public ZipEntry0(long nativeAddr, ZipEntry entry, byte[] name, byte[] extra, byte[] comment, long time, int flag) {
            this.nativeAddr = nativeAddr;
            this.entry = entry;
            this.name = name;
            this.extra = extra;
            this.comment = comment;
            this.time = time;
            this.flag = flag;
        }
    }
}
