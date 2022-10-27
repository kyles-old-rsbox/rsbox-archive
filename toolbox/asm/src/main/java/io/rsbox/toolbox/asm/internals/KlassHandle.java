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

import io.rsbox.toolbox.asm.mirrors.JavaClass;

// KlassHandle
public class KlassHandle {
    private JavaClass handle;

    public KlassHandle(JavaClass handle) {
        this.handle = handle;
    }

    public JavaClass get() {
        return this.handle;
    }

    public boolean notNull() {
        return handle != null;
    }

    public boolean isNull() {
        return handle == null;
    }
}
