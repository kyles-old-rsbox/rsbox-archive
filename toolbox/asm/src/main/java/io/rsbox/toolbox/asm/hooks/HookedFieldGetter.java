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

package io.rsbox.toolbox.asm.hooks;

import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.values.JavaWrapper;

public class HookedFieldGetter {
    private String _owner;
    private String _name;
    private String _desc;

    private HookedFieldGetter.Hook _handler;

    public HookedFieldGetter(String owner, String name, String desc) {
        this._owner = owner;
        this._name = name;
        this._desc = desc;
    }

    public HookedFieldGetter bind(HookedFieldGetter.Hook handler) {
        _handler = handler;
        return this;
    }

    public String getOwner() {
        return _owner;
    }

    public String getName() {
        return _name;
    }

    public String getDesc() {
        return _desc;
    }

    public JavaWrapper get(MethodExecution context, JavaWrapper instance) {
        return _handler.get(context, instance);
    }

    public interface Hook {
        JavaWrapper get(MethodExecution context, JavaWrapper instance);
    }
}
