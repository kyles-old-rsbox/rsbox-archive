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

import io.rsbox.toolbox.asm.values.JavaWrapper;

import java.util.LinkedList;
import java.util.Objects;

public class ClassLoaderData {
    public static final ClassLoaderData NULL_LOADER_DATA = new ClassLoaderData(null, false, new Dependencies());
    private static final LinkedList<ClassLoaderData> classLoaderDatas = new LinkedList<>();
    private static final Object classLoaderDataLock = new Object();
    private final Handle loader;
    private final boolean isAnonymous;
    private final Dependencies dependencies;

    private ClassLoaderData(Handle loader, boolean isAnonymous, Dependencies dependencies) {
        this.loader = loader;
        this.isAnonymous = isAnonymous;
        this.dependencies = dependencies;
    }

    public static ClassLoaderData classLoaderDataOrNull(JavaWrapper loader) {
        return loader == null ? NULL_LOADER_DATA : loader.getVM().getJavaLangClassLoader().loaderData(loader);
    }

    public static ClassLoaderData findOrCreate(Handle loader) {
        ClassLoaderData cachedData = loader.get().getVM().getJavaLangClassLoader().loaderData(loader.get());
        if (cachedData != null) {
            return cachedData;
        }

        return add(loader, false);
    }

    private static ClassLoaderData add(Handle loader, boolean isAnonymous) {
        ClassLoaderData data = new ClassLoaderData(loader, isAnonymous, new Dependencies());

        if (!isAnonymous) {
            ClassLoaderData old = loader.get().compareAndSwapMetadata(VMSymbols.METADATA_LOADER_DATA, data, null);
            if (old != null) {
                return old;
            }
        }

        synchronized (classLoaderDataLock) {
            classLoaderDatas.addFirst(data);
        }

        return data;
    }

    public static ClassLoaderData classLoaderData(JavaWrapper oop) {
        return classLoaderDataOrNull(oop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassLoaderData that = (ClassLoaderData) o;
        return Objects.equals(loader, that.loader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loader);
    }

    public static class Dependencies {

    }
}
