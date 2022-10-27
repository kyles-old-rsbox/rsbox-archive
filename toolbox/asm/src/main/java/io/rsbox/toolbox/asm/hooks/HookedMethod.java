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

import io.rsbox.toolbox.asm.Cause;
import io.rsbox.toolbox.asm.Effect;
import io.rsbox.toolbox.asm.MethodExecution;
import io.rsbox.toolbox.asm.values.JavaWrapper;
import org.objectweb.asm.tree.AbstractInsnNode;

public class HookedMethod {
    private String _owner;
    private String _name;
    private String _desc;
    private Cause _cause;
    private Effect _effect;

    private Hook _handler;

    public HookedMethod(String owner, String name, String desc) {
        this(owner, name, desc, Cause.ALL, Effect.ALL);
    }

    public HookedMethod(String owner, String name, String desc, Cause cause, Effect effect) {
        this._owner = owner;
        this._name = name;
        this._desc = desc;
        this._cause = cause;
        this._effect = effect;
    }

    public HookedMethod bind(Hook handler) {
        _handler = handler;
        return this;
    }

    public HookedMethod bind(VoidHook handler) {
        if (!this._desc.endsWith("V"))
            throw new IllegalArgumentException("Cannot bind non-returning handler with non-void function");
        return bind((a, b, c) ->
        {
            handler.execute(a, b, c);
            return null;
        });
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

    public Cause getCause() {
        return _cause;
    }

    public Effect getEffect() {
        return _effect;
    }

    public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args, AbstractInsnNode cur) {
        try {
            context.getVM().pushStacktrace(context.getClassNode(), context.getMethodNode(), cur);
            return _handler.execute(context, instance, args);
        } finally {
            context.getVM().popStacktrace();
        }
    }

    public interface Hook {
        JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args);
    }

    public interface VoidHook {
        void execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args);
    }
}
