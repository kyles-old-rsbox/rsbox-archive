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

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import org.objectweb.asm.ClassReader;

public class ConstantPool {
    private final VirtualMachine _vm;
    private final ClassReader classReader;

    // todo load constants lazily (to prevent abuse with large constant pools)
    public ConstantPool(VirtualMachine virtualMachine, ClassReader classReader) {
        _vm = virtualMachine;
        this.classReader = classReader;
    }

    public int getSize() {
        return this.classReader.getItemCount();
    }

    public String getUTF8At(int i) {
        if (i < 0 || i > this.classReader.getItemCount()) {
            throw _vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException, "Constant pool index out of bounds");
        }
        if (i == 0) {
            throw _vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException, "Wrong type at constant pool index");
        }
        int index = classReader.getItem(i);
        if (index == 0) {
            throw _vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException, "Wrong type at constant pool index"); // long/double take 2 slots, this item might not exist
        }
        if (classReader.readByte(index - 1) != 1) {
            throw _vm.newThrowable(VMSymbols.java_lang_IllegalArgumentException, "Wrong type at constant pool index");
        }

        ByteArrayDataInput din = ByteStreams.newDataInput(classReader.b);
        din.skipBytes(index);
        String result = din.readUTF();
        return result;
    }
}
