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

public class FieldType {
    public static boolean isArray(String desc) {
        return desc.length() > 1 && desc.charAt(0) == '[' && isValidArraySignature(desc);
    }

    public static boolean isObject(String desc) {
        return desc.length() >= 2 && desc.charAt(0) == 'L' && desc.charAt(desc.length() - 1) == ';';
    }

    private static boolean isValidArraySignature(String desc) {
        int i = 1;
        while (i < desc.length() - 1 && desc.charAt(i) == '[') i++;
        switch (desc.charAt(i)) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'Z':
                return i + 1 == desc.length();
            case 'L':
                return desc.charAt(desc.length() - 1) == ';';
        }

        return false;
    }
}
