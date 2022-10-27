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

package io.rsbox.toolbox.asm.values;

import io.rsbox.toolbox.asm.VirtualMachine;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import org.objectweb.asm.Type;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JavaUnknown extends JavaValue {
    private final VirtualMachine vm;
    // todo make setter/ctor later
    public Type _desc;
    private JavaClass _class;
    private String _cause;

    public JavaUnknown(VirtualMachine vm, JavaClass type, String cause) {
        this._class = type;
        this._cause = cause;
        this.vm = vm;
        if (!VirtualMachine.UNKNOWNS_ALLOWED)
            throw new RuntimeException("creating javaunknown " + cause);
    }

    public JavaUnknown(VirtualMachine vm, JavaClass type, UnknownCause cause, JavaValue... sources) {
        this._class = type;
        this._cause = cause.format(sources);
        this.vm = vm;
        if (!VirtualMachine.UNKNOWNS_ALLOWED)
            throw new RuntimeException("creating javaunknown " + cause);
    }

    @Override
    public boolean is(JavaValueType type) {
        return type == JavaValueType.UNKNOWN || is0(type);
    }

    private boolean is0(JavaValueType type) {
        switch (type) {
            case PRIMITIVE:
                return _class.isPrimitive();
            case OBJECT:
                return !_class.isPrimitive();
            case FLOAT:
                return _class == vm.FLOAT;
            case LONG:
                return _class == vm.LONG;
            case DOUBLE:
                return _class == vm.DOUBLE;
            case INTEGER:
                return _class == vm.INTEGER || _class == vm.BOOLEAN || _class == vm.BYTE || _class == vm.CHARACTER || _class == vm.SHORT;
            case BOOLEAN:
                return _class == vm.BOOLEAN;
            case BYTE:
                return _class == vm.BYTE;
            case CHARACTER:
                return _class == vm.CHARACTER;
            case SHORT:
                return _class == vm.SHORT;
            case WIDE:
                return _class == vm.DOUBLE || _class == vm.LONG;
        }
        return false;
    }

    @Override
    public String type() {
        return _class.isPrimitive() ? this._class.internalGetType().getClassName() : this._class.internalGetType().getDescriptor();
    }

    @Override
    public String toString() {
        return "JavaUnknown(type=" + type() + ",cause=" + _cause + ")";
    }

    public void merge(String s) {
        _cause += ";" + s;
    }

    @Override
    public JavaClass getJavaClass() {
        return this._class;
    }

    @Override
    public int getSize() {
        return 1;
    }

    public enum UnknownCause {
        IFNULL_COMPARISON {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        IFNONNULL_COMPARISON {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        ANEWARRAY {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0];
            }
        },
        IFLT {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        IFGT {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        IFGE {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        IFNE {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        IFEQ {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " resulting in " + values[1] + " and " + values[2];
            }
        },
        I2C {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0];
            }
        },
        LOOKUPSWITCH {
            @Override
            String format(JavaValue... values) {
                StringBuilder builder = new StringBuilder(name());
                builder.append(" on ").append(values[0]).append(" resulting in ");
                builder.append(Arrays.stream(values, 1, values.length).map(n -> n == null ? "null" : n.toString()).collect(Collectors.joining("and")));
                return builder.toString();
            }
        },
        IF_ICMPGT {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        IF_ACMPNE {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        IF_ACMPEQ {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        IF_ICMPLT {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        IF_ICMPGE {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        IF_ICMPNE {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1] + " resulting in " + values[2] + " and " + values[3];
            }
        },
        INTEGER_MATH {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1];
            }
        },
        LONG_MATH {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1];
            }
        },
        LONG_INTEGER_MATH {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1];
            }
        },
        DOUBLE_MATH {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1];
            }
        },
        FLOAT_MATH {
            @Override
            String format(JavaValue... values) {
                return name() + " on " + values[0] + " and " + values[1];
            }
        };

        abstract String format(JavaValue... values);
    }
}
