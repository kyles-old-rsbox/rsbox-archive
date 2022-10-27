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

package io.rsbox.toolbox.asm;

import org.objectweb.asm.tree.AbstractInsnNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ExecutionOptions {

    private Map<AbstractInsnNode, Consumer<BreakpointInfo>> _watchlist = new HashMap<>();
    private List<StackTraceHolder> _stacktrace = new ArrayList<>();

    public ExecutionOptions watch(AbstractInsnNode insn, Consumer<BreakpointInfo> consumer) {
        _watchlist.put(insn, consumer);
        return this;
    }

    public boolean shouldRecord(AbstractInsnNode target) {
        return !_watchlist.isEmpty() && _watchlist.containsKey(target);
    }

    public void notify(AbstractInsnNode node, BreakpointInfo info) {
        _watchlist.get(node).accept(info);
    }

    public static class BreakpointInfo {
        private AbstractInsnNode now;
        private Stack stack;
        private Locals locals;

        public BreakpointInfo(AbstractInsnNode now, Stack stack, Locals locals) {
            this.now = now;
            this.stack = stack;
            this.locals = locals;
        }

        public Stack getStack() {
            return stack;
        }

        public Locals getLocals() {
            return locals;
        }

        public AbstractInsnNode getNow() {
            return now;
        }
    }
}
