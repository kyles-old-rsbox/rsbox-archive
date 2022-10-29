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

package io.rsbox.toolbox.asm.tree

import org.objectweb.asm.tree.AbstractInsnNode
import org.objectweb.asm.tree.InsnList

fun InsnList.append(previous: AbstractInsnNode, vararg insns: AbstractInsnNode) {
    check(contains(previous))
    insns.reversed().forEach { insert(previous, it) }
}

fun InsnList.prepend(next: AbstractInsnNode, vararg insns: AbstractInsnNode) {
    check(contains(next))
    insns.forEach { insertBefore(next, it) }
}

fun InsnList.delete(vararg insns: AbstractInsnNode) {
    insns.forEach {
        check(contains(it))
        remove(it)
    }
}

fun InsnList.replace(old: AbstractInsnNode, replacement: AbstractInsnNode) {
    check(contains(old))
    set(old, replacement)
}