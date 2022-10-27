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

package io.rsbox.toolbox.asm.values.prim;

import io.rsbox.toolbox.asm.values.JavaValue;

public abstract class JPrimitive extends JavaValue {

    public abstract boolean asBoolean();

    public abstract char asChar();

    public abstract byte asByte();

    public abstract short asShort();

    public abstract int asInt();

    public abstract float asFloat();

    public abstract long asLong();

    public abstract double asDouble();

    public abstract Object rawValue();
}
