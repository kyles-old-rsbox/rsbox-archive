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

import io.rsbox.toolbox.asm.exceptions.AbortException;
import io.rsbox.toolbox.asm.exceptions.ConvertedException;
import io.rsbox.toolbox.asm.exceptions.ExecutionException;
import io.rsbox.toolbox.asm.exceptions.VMException;
import io.rsbox.toolbox.asm.ext.Filesystem;
import io.rsbox.toolbox.asm.ext.Memory;
import io.rsbox.toolbox.asm.ext.net.Network;
import io.rsbox.toolbox.asm.hooks.HookGenerator;
import io.rsbox.toolbox.asm.hooks.HookedFieldGetter;
import io.rsbox.toolbox.asm.hooks.HookedFieldSetter;
import io.rsbox.toolbox.asm.hooks.HookedMethod;
import io.rsbox.toolbox.asm.instructions.*;
import io.rsbox.toolbox.asm.internals.LinkResolver;
import io.rsbox.toolbox.asm.internals.SystemDictionary;
import io.rsbox.toolbox.asm.internals.VMSymbols;
import io.rsbox.toolbox.asm.mirrors.JavaClass;
import io.rsbox.toolbox.asm.mirrors.JavaField;
import io.rsbox.toolbox.asm.nativeimpls.*;
import io.rsbox.toolbox.asm.oops.Oop;
import io.rsbox.toolbox.asm.oops.ThreadOop;
import io.rsbox.toolbox.asm.utils.*;
import io.rsbox.toolbox.asm.values.*;
import io.rsbox.toolbox.asm.values.prim.JDouble;
import io.rsbox.toolbox.asm.values.prim.JFloat;
import io.rsbox.toolbox.asm.values.prim.JInteger;
import io.rsbox.toolbox.asm.values.prim.JLong;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.*;

public class VirtualMachine {
    public static final int JVM_RECOGNIZED_CLASS_MODIFIERS = Opcodes.ACC_PUBLIC |
            Opcodes.ACC_FINAL |
            Opcodes.ACC_SUPER |
            Opcodes.ACC_INTERFACE |
            Opcodes.ACC_ABSTRACT |
            Opcodes.ACC_ANNOTATION |
            Opcodes.ACC_ENUM |
            Opcodes.ACC_SYNTHETIC;
    public static final int JVM_RECOGNIZED_METHOD_MODIFIERS = Opcodes.ACC_PUBLIC |
            Opcodes.ACC_PRIVATE |
            Opcodes.ACC_PROTECTED |
            Opcodes.ACC_STATIC |
            Opcodes.ACC_FINAL |
            Opcodes.ACC_SYNCHRONIZED |
            Opcodes.ACC_BRIDGE |
            Opcodes.ACC_VARARGS |
            Opcodes.ACC_NATIVE |
            Opcodes.ACC_ABSTRACT |
            Opcodes.ACC_STRICT |
            Opcodes.ACC_SYNTHETIC;
    public static final int JVM_RECOGNIZED_FIELD_MODIFIERS = Opcodes.ACC_PUBLIC |
            Opcodes.ACC_PRIVATE |
            Opcodes.ACC_PROTECTED |
            Opcodes.ACC_PROTECTED |
            Opcodes.ACC_STATIC |
            Opcodes.ACC_FINAL |
            Opcodes.ACC_VOLATILE |
            Opcodes.ACC_TRANSIENT |
            Opcodes.ACC_ENUM |
            Opcodes.ACC_SYNTHETIC;
    public static boolean UNKNOWNS_ALLOWED = true;
    public static boolean TRACE = false;
    public static boolean DEBUG = false;
    public static boolean DEBUG_PRINT_EXCEPTIONS = false;
    public static List<String> DEBUG_CLASSES = Arrays.asList();
    public static List<String> DEBUG_METHODS_WITH_DESC = Arrays.asList();
    public final JavaWrapper TRUE = JavaWrapper.wrap(new JInteger(this, Type.BOOLEAN_TYPE, 1));
    public final JavaWrapper FALSE = JavaWrapper.wrap(new JInteger(this, Type.BOOLEAN_TYPE, 0));
    public final JavaClass INTEGER = new JavaClass(this, Type.INT_TYPE, "int");
    public final JavaClass LONG = new JavaClass(this, Type.LONG_TYPE, "long");
    public final JavaClass DOUBLE = new JavaClass(this, Type.DOUBLE_TYPE, "double");
    public final JavaClass FLOAT = new JavaClass(this, Type.FLOAT_TYPE, "float");
    public final JavaClass BOOLEAN = new JavaClass(this, Type.BOOLEAN_TYPE, "boolean");
    public final JavaClass CHARACTER = new JavaClass(this, Type.CHAR_TYPE, "char");
    public final JavaClass BYTE = new JavaClass(this, Type.BYTE_TYPE, "byte");
    public final JavaClass SHORT = new JavaClass(this, Type.SHORT_TYPE, "short");
    public final JavaClass VOID = new JavaClass(this, Type.VOID_TYPE, "void");
    private final Instruction[] INSTRUCTION_HANDLERS = new Instruction[255];
    private final Map<String, HookedMethod> HookedMethods = new HashMap<>();
    private final ReadWriteLock methodHookLock = new ReentrantReadWriteLock();
    private final Map<String, HookedFieldGetter> fieldGetterHooks = new ConcurrentHashMap<>();
    private final Map<String, HookedFieldSetter> fieldSetterHooks = new ConcurrentHashMap<>();
    private final Map<String, ClassNode> _classpath = new ConcurrentHashMap<>();
    private final Map<ClassNode, ConstantPool> _constantPools = new ConcurrentHashMap<>();
    private final Map<String, JavaClass> _classCache = new ConcurrentHashMap<>();
    private final Map<String, JavaWrapper> internedStrings = new ConcurrentHashMap<>();
    private final java_lang_ClassLoader _java_lang_classLoader = new java_lang_ClassLoader(this);
    private final JavaWrapper NULL = JavaWrapper.wrap(new JavaNull());
    private final Map<Class<?>, JavaClass> PRIMITIVE_TO_JAVACLASS_MAP;
    // todo when threading is a thing, move this
    private Map<Thread, ArrayDeque<StackTraceHolder>> _stacktrace = new ConcurrentHashMap<>();
    public Map<Thread, AbstractInsnNode> currentInsn = new ConcurrentHashMap<>();
    ThreadLocal<Integer> depth = ThreadLocal.withInitial(() -> 0);
    private io.rsbox.toolbox.asm.nativeimpls.java_lang_invoke_MethodHandle java_lang_invoke_MethodHandle;
    private JavaWrapper systemThreadGroup;
    private JavaWrapper mainThreadGroup;
    private JavaWrapper mainThread;
    private LinkResolver linkResolver = new LinkResolver(this);
    private SystemDictionary systemDictionary;
    private Filesystem filesystem = new Filesystem(this);
    private Memory memory = new Memory(this);
    private Network network = new Network(this);

    {
        Map<Class<?>, JavaClass> primitiveToJavaClass = new HashMap<>();
        primitiveToJavaClass.put(int.class, INTEGER);
        primitiveToJavaClass.put(long.class, LONG);
        primitiveToJavaClass.put(boolean.class, BOOLEAN);
        primitiveToJavaClass.put(byte.class, BYTE);
        primitiveToJavaClass.put(short.class, SHORT);
        primitiveToJavaClass.put(double.class, DOUBLE);
        primitiveToJavaClass.put(float.class, FLOAT);
        primitiveToJavaClass.put(char.class, CHARACTER);
        primitiveToJavaClass.put(void.class, VOID);
        PRIMITIVE_TO_JAVACLASS_MAP = Collections.unmodifiableMap(primitiveToJavaClass);
    }

    public VirtualMachine(Collection<byte[]> jvmFiles) {
        initInstructions();
        load(jvmFiles);

        systemDictionary = new SystemDictionary(this);
        registerNatives();
    }

    public void fullInitialization() {
        long start = System.nanoTime();
        initialize(getSystemDictionary().getJavaLangString());
        initialize(getSystemDictionary().getJavaLangSystem());
        initialize(getSystemDictionary().getJavaLangThreadGroup());
        systemThreadGroup = newInstance(getSystemDictionary().getJavaLangThreadGroup(), "()V");
        mainThreadGroup = newInstance(getSystemDictionary().getJavaLangThreadGroup(), "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", systemThreadGroup, getString("main"));
        initialize(getSystemDictionary().getJavaLangThread());
        mainThread = createMainThread();
        initialize(getSystemDictionary().getJavaLangClass());
        initialize(getSystemDictionary().getJavaLangReflectMethod());
        initialize(getSystemDictionary().getJavaLangRefFinalizer());

        internalExecute(
                getSystemDictionary().getJavaLangSystem().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangSystem().getClassNode(), "initializeSystemClass", "()V"),
                null, new JavaWrapper[0], null);

        internalExecute(
                getSystemDictionary().getJavaLangClassLoader().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangClassLoader().getClassNode(), "getSystemClassLoader", "()Ljava/lang/ClassLoader;"),
                null, new JavaWrapper[0], null);

        long end = System.nanoTime();
        System.out.println("Initialization of VM took " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
    }

    public void quickInitialization() {
        long start = System.nanoTime();
        systemThreadGroup = newInstance(getSystemDictionary().getJavaLangThreadGroup(), "()V");
        mainThreadGroup = newInstance(getSystemDictionary().getJavaLangThreadGroup(), "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V", systemThreadGroup, getString("main"));
        mainThread = createMainThread();
        long end = System.nanoTime();
        System.out.println("Initialization of VM took " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms");
    }

    public static boolean isJavaPrimitive(Type t) {
        return T_BOOLEAN <= t.getSort() && t.getSort() <= T_DOUBLE;
    }

    public static boolean isSubwordType(Type t) {
        // these guys are processed exactly like T_INT in calling sequences:
        return (t.getSort() == T_BOOLEAN || t.getSort() == T_CHAR || t.getSort() == T_BYTE || t.getSort() == T_SHORT);
    }

    private static String hash(String owner, String name, String desc) {
        return owner + "." + name + "." + desc;
    }

    public JavaWrapper getStringInterned(String str) {
        if (str == null) {
            return getNull();
        }
        return internedStrings.computeIfAbsent(str, this::getString);
    }

    public JavaWrapper getString(String str) {
        if (str == null) {
            return getNull();
        }

        JavaObject obj = new JavaObject(getSystemDictionary().getJavaLangString());
        obj.setField("value", "[C", ArrayConversionHelper.convertCharArray(this, str.toCharArray()));
        return JavaWrapper.wrap(obj);
    }

    private void initInstructions() {
        INSTRUCTION_HANDLERS[NOP] = new NopInstruction();
        INSTRUCTION_HANDLERS[ACONST_NULL] = new AconstNullInstruction();
        INSTRUCTION_HANDLERS[ICONST_M1] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, -1));
        INSTRUCTION_HANDLERS[ICONST_0] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 0));
        INSTRUCTION_HANDLERS[ICONST_1] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 1));
        INSTRUCTION_HANDLERS[ICONST_2] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 2));
        INSTRUCTION_HANDLERS[ICONST_3] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 3));
        INSTRUCTION_HANDLERS[ICONST_4] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 4));
        INSTRUCTION_HANDLERS[ICONST_5] = new LoadOneWordInstruction((vm) -> JavaWrapper.createInteger(vm, 5));
        INSTRUCTION_HANDLERS[LCONST_0] = new LoadTwoWordInstruction((vm) -> vm.newLong(0));
        INSTRUCTION_HANDLERS[LCONST_1] = new LoadTwoWordInstruction((vm) -> vm.newLong(1));
        INSTRUCTION_HANDLERS[FCONST_0] = new LoadOneWordInstruction((vm) -> JavaWrapper.createFloat(vm, 0));
        INSTRUCTION_HANDLERS[FCONST_1] = new LoadOneWordInstruction((vm) -> JavaWrapper.createFloat(vm, 1));
        INSTRUCTION_HANDLERS[FCONST_2] = new LoadOneWordInstruction((vm) -> JavaWrapper.createFloat(vm, 2));
        INSTRUCTION_HANDLERS[DCONST_0] = new LoadTwoWordInstruction((vm) -> JavaWrapper.createDouble(vm, 0));
        INSTRUCTION_HANDLERS[DCONST_1] = new LoadTwoWordInstruction((vm) -> JavaWrapper.createDouble(vm, 1));
        INSTRUCTION_HANDLERS[BIPUSH] = new BipushInstruction();
        INSTRUCTION_HANDLERS[SIPUSH] = new SipushInstruction();
        INSTRUCTION_HANDLERS[LDC] = new LdcInstruction();
        INSTRUCTION_HANDLERS[ILOAD] = new LocalLoadInstruction(Type.INT);
        INSTRUCTION_HANDLERS[LLOAD] = new LocalLoadInstruction(Type.LONG);
        INSTRUCTION_HANDLERS[FLOAD] = new LocalLoadInstruction(Type.FLOAT);
        INSTRUCTION_HANDLERS[DLOAD] = new LocalLoadInstruction(Type.DOUBLE);
        INSTRUCTION_HANDLERS[ALOAD] = new LocalLoadInstruction(Type.OBJECT);
        INSTRUCTION_HANDLERS[IALOAD] = new ArrayLoadInstruction(Type.INT);
        INSTRUCTION_HANDLERS[LALOAD] = new ArrayLoadInstruction(Type.LONG);
        INSTRUCTION_HANDLERS[FALOAD] = new ArrayLoadInstruction(Type.FLOAT);
        INSTRUCTION_HANDLERS[DALOAD] = new ArrayLoadInstruction(Type.DOUBLE);
        INSTRUCTION_HANDLERS[AALOAD] = new ArrayLoadInstruction(Type.OBJECT);
        INSTRUCTION_HANDLERS[BALOAD] = new ArrayLoadInstruction(Type.BYTE);
        INSTRUCTION_HANDLERS[CALOAD] = new ArrayLoadInstruction(Type.CHAR);
        INSTRUCTION_HANDLERS[SALOAD] = new ArrayLoadInstruction(Type.SHORT);
        INSTRUCTION_HANDLERS[ISTORE] = new LocalStoreInstruction(Type.INT);
        INSTRUCTION_HANDLERS[LSTORE] = new LocalStoreInstruction(Type.LONG);
        INSTRUCTION_HANDLERS[FSTORE] = new LocalStoreInstruction(Type.FLOAT);
        INSTRUCTION_HANDLERS[DSTORE] = new LocalStoreInstruction(Type.DOUBLE);
        INSTRUCTION_HANDLERS[ASTORE] = new LocalStoreInstruction(Type.OBJECT);
        INSTRUCTION_HANDLERS[IASTORE] = new ArrayStoreInstruction(Type.INT);
        INSTRUCTION_HANDLERS[LASTORE] = new ArrayStoreInstruction(Type.LONG);
        INSTRUCTION_HANDLERS[FASTORE] = new ArrayStoreInstruction(Type.FLOAT);
        INSTRUCTION_HANDLERS[DASTORE] = new ArrayStoreInstruction(Type.DOUBLE);
        INSTRUCTION_HANDLERS[AASTORE] = new ArrayStoreInstruction(Type.OBJECT);
        INSTRUCTION_HANDLERS[BASTORE] = new ArrayStoreInstruction(Type.BYTE);
        INSTRUCTION_HANDLERS[CASTORE] = new ArrayStoreInstruction(Type.CHAR);
        INSTRUCTION_HANDLERS[SASTORE] = new ArrayStoreInstruction(Type.SHORT);
        INSTRUCTION_HANDLERS[NEWARRAY] = new NewArrayInstruction();

        INSTRUCTION_HANDLERS[IADD] = new IntegerMathInstruction((a, b) -> a + b);
        INSTRUCTION_HANDLERS[ISUB] = new IntegerMathInstruction((a, b) -> a - b);
        INSTRUCTION_HANDLERS[IMUL] = new IntegerMathInstruction((a, b) -> a * b);
        INSTRUCTION_HANDLERS[IDIV] = new IntegerMathInstruction((a, b) -> a / b, true);
        INSTRUCTION_HANDLERS[IREM] = new IntegerMathInstruction((a, b) -> a % b);
        INSTRUCTION_HANDLERS[ISHL] = new IntegerMathInstruction((a, b) -> a << b);
        INSTRUCTION_HANDLERS[ISHR] = new IntegerMathInstruction((a, b) -> a >> b);
        INSTRUCTION_HANDLERS[IUSHR] = new IntegerMathInstruction((a, b) -> a >>> b);
        INSTRUCTION_HANDLERS[IAND] = new IntegerMathInstruction((a, b) -> a & b);
        INSTRUCTION_HANDLERS[IOR] = new IntegerMathInstruction((a, b) -> a | b);
        INSTRUCTION_HANDLERS[IXOR] = new IntegerMathInstruction((a, b) -> a ^ b);

        INSTRUCTION_HANDLERS[LADD] = new LongMathInstruction((a, b) -> a + b, false);
        INSTRUCTION_HANDLERS[LSUB] = new LongMathInstruction((a, b) -> a - b, false);
        INSTRUCTION_HANDLERS[LMUL] = new LongMathInstruction((a, b) -> a * b, false);
        INSTRUCTION_HANDLERS[LDIV] = new LongMathInstruction((a, b) -> a / b, false);
        INSTRUCTION_HANDLERS[LREM] = new LongMathInstruction((a, b) -> a % b, false);
        INSTRUCTION_HANDLERS[LSHL] = new LongIntegerMathInstruction((a, b) -> a << b);
        INSTRUCTION_HANDLERS[LSHR] = new LongIntegerMathInstruction((a, b) -> a >> b);
        INSTRUCTION_HANDLERS[LUSHR] = new LongIntegerMathInstruction((a, b) -> a >>> b);
        INSTRUCTION_HANDLERS[LAND] = new LongMathInstruction((a, b) -> a & b, false);
        INSTRUCTION_HANDLERS[LOR] = new LongMathInstruction((a, b) -> a | b, false);
        INSTRUCTION_HANDLERS[LXOR] = new LongMathInstruction((a, b) -> a ^ b, false);
        INSTRUCTION_HANDLERS[LCMP] = new LongMathInstruction(Long::compare, true);

        INSTRUCTION_HANDLERS[DADD] = new DoubleMathInstruction((a, b) -> a + b, false);
        INSTRUCTION_HANDLERS[DSUB] = new DoubleMathInstruction((a, b) -> a - b, false);
        INSTRUCTION_HANDLERS[DMUL] = new DoubleMathInstruction((a, b) -> a * b, false);
        INSTRUCTION_HANDLERS[DDIV] = new DoubleMathInstruction((a, b) -> a / b, false);
        INSTRUCTION_HANDLERS[DREM] = new DoubleMathInstruction((a, b) -> a % b, false);
        INSTRUCTION_HANDLERS[DCMPL] = new DoubleMathInstruction((x, y) -> {
            if (Double.isNaN(x) || Double.isNaN(y)) return 1;
            return Double.compare(x, y);
        }, true);
        INSTRUCTION_HANDLERS[DCMPG] = new DoubleMathInstruction((x, y) -> {
            if (Double.isNaN(x) || Double.isNaN(y)) return -1;
            return Double.compare(x, y);
        }, true);

        INSTRUCTION_HANDLERS[FADD] = new FloatMathInstruction((a, b) -> a + b, false);
        INSTRUCTION_HANDLERS[FSUB] = new FloatMathInstruction((a, b) -> a - b, false);
        INSTRUCTION_HANDLERS[FMUL] = new FloatMathInstruction((a, b) -> a * b, false);
        INSTRUCTION_HANDLERS[FDIV] = new FloatMathInstruction((a, b) -> a / b, false);
        INSTRUCTION_HANDLERS[FREM] = new FloatMathInstruction((a, b) -> a % b, false);
        INSTRUCTION_HANDLERS[FCMPL] = new FloatMathInstruction((x, y) -> {
            if (Float.isNaN(x) || Float.isNaN(y)) return 1;
            return Float.compare(x, y);
        }, true);
        INSTRUCTION_HANDLERS[FCMPG] = new FloatMathInstruction((x, y) -> {
            if (Float.isNaN(x) || Float.isNaN(y)) return -1;
            return Float.compare(x, y);
        }, true);

        INSTRUCTION_HANDLERS[NEW] = new NewInstruction();

        INSTRUCTION_HANDLERS[IFEQ] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() == 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFNE] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() != 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFLT] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() < 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFGE] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() >= 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFGT] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() > 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFLE] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.asInt() <= 0 ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPEQ] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() == bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPNE] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() != bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPLT] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() < bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPGE] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() >= bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPGT] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() > bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ICMPLE] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av.asInt() <= bv.asInt() ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ACMPEQ] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av == bv ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IF_ACMPNE] = new DoublePredicateInstruction((a, b) -> {
            JavaValue av = a.get();
            JavaValue bv = b.get();
            return ExecutionUtils.areValuesUnknown(av, bv) ? MaybeBoolean.MAYBE : av != bv ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFNULL] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : value.is(JavaValueType.NULL) ? MaybeBoolean.YES : MaybeBoolean.NO;
        });
        INSTRUCTION_HANDLERS[IFNONNULL] = new SinglePredicateInstruction(wrapper -> {
            JavaValue value = wrapper.get();
            return value.is(JavaValueType.UNKNOWN) ? MaybeBoolean.MAYBE : !value.is(JavaValueType.NULL) ? MaybeBoolean.YES : MaybeBoolean.NO;
        });

        INSTRUCTION_HANDLERS[INVOKEVIRTUAL] = new InvocationInstruction(false);
        INSTRUCTION_HANDLERS[INVOKESPECIAL] = new InvokeSpecialInstruction();
        INSTRUCTION_HANDLERS[INVOKESTATIC] = new InvocationInstruction(true);
        INSTRUCTION_HANDLERS[INVOKEINTERFACE] = new InvocationInstruction(false);
        INSTRUCTION_HANDLERS[INVOKEDYNAMIC] = new InvokeDynamicInstruction();
        INSTRUCTION_HANDLERS[CHECKCAST] = new CheckcastInstruction();

        INSTRUCTION_HANDLERS[D2I] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper doubleValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(doubleValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().INTEGER, "d2i " + doubleValue)));
                    return;
                }
                stack.push(JavaWrapper.createInteger(execution.getVM(), (int) doubleValue.asDouble()));
            }
        };
        INSTRUCTION_HANDLERS[F2I] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper floatValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(floatValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().INTEGER, "f2i " + floatValue)));
                    return;
                }
                stack.push(JavaWrapper.createInteger(execution.getVM(), (int) floatValue.asFloat()));
            }
        };
        INSTRUCTION_HANDLERS[L2F] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper longValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(longValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().FLOAT, "l2f " + longValue)));
                    return;
                }
                stack.push(JavaWrapper.createFloat(execution.getVM(), (float) longValue.asLong()));
            }
        };
        INSTRUCTION_HANDLERS[F2D] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper floatValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(floatValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().DOUBLE, "l2f " + floatValue)));
                    return;
                }
                stack.push(JavaWrapper.createDouble(execution.getVM(), floatValue.asFloat()));
            }
        };
        INSTRUCTION_HANDLERS[D2L] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper doubleValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(doubleValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().LONG, "l2f " + doubleValue)));
                    return;
                }
                stack.push(execution.getVM().newLong(doubleValue.asLong()));
            }
        };
        INSTRUCTION_HANDLERS[L2I] = new Instruction() {
            @Override
            public void execute(MethodExecution execution, AbstractInsnNode currentInsn, io.rsbox.toolbox.asm.Stack stack, Locals locals, List<AbstractInsnNode> branchTo) {
                JavaWrapper longValue = stack.pop();
                if (ExecutionUtils.areValuesUnknown(longValue)) {
                    stack.push(JavaWrapper.wrap(new JavaUnknown(execution.getVM(), execution.getVM().INTEGER, "l2f " + longValue)));
                    return;
                }
                stack.push(JavaWrapper.createInteger(execution.getVM(), (int) longValue.asLong()));
            }
        };
    }

    public ConstantPool getConstantPool(ClassNode classNode) {
        return _constantPools.get(classNode);
    }

    public void pushStacktrace(ClassNode classNode, MethodNode methodNode, AbstractInsnNode insn) {
        if (classNode == null || methodNode == null) {
            throw new NullPointerException();
        }
        _stacktrace.computeIfAbsent(Thread.currentThread(), key -> new ArrayDeque<>()).push(new StackTraceHolder(classNode, methodNode, insn));
    }

    public void popStacktrace() {
        _stacktrace.computeIfAbsent(Thread.currentThread(), key -> new ArrayDeque<>()).pop();
    }

    public List<StackTraceHolder> getStacktrace() {
        return new ArrayList<>(_stacktrace.computeIfAbsent(Thread.currentThread(), key -> new ArrayDeque<>()));
    }

    public JavaWrapper intern(JavaWrapper in) {
        return internedStrings.computeIfAbsent(convertJavaObjectToString(in), this::getString);
    }

    public String convertJavaObjectToString(JavaWrapper in) {
        if (in.is(JavaValueType.NULL)) {
            return null;
        }
        return new String(ArrayConversionHelper.convertCharArray(in.asObject().getField("value", "[C").asArray()));
    }

    public java_lang_invoke_MethodHandle getJavaLangInvokeMethodHandle() {
        return java_lang_invoke_MethodHandle;
    }

    private void registerNatives() {
        java_lang_String.registerNatives(this);
        java_lang_Double.registerNatives(this);
        java_lang_Float.registerNatives(this);
        java_lang_Throwable.registerNatives(this);
        java_lang_reflect_Array.registerNatives(this);
        java_lang_StrictMath.registerNatives(this);
        java_awt_Font.registerNatives(this);
        sun_awt_windows_WToolkit.registerNatives(this);
        sun_java2d_Disposer.registerNatives(this);
        java_util_zip_Inflater.registerNatives(this);
        java_util_zip_CRC32.registerNatives(this);
        java_io_FileInputStream.registerNatives(this);
        java_io_FileOutputStream.registerNatives(this);
        java_io_WinNTFileSystem.registerNatives(this);
        java_io_UnixFileSystem.registerNatives(this);
        java_io_FileDescriptor.registerNatives(this);
        java_security_AccessController.registerNatives(this);
        sun_reflect_Reflection.registerNatives(this);
        sun_reflect_NativeMethodAccessorImpl.registerNatives(this);
        sun_reflect_NativeConstructorAccessorImpl.registerNatives(this);
        sun_reflect_ConstantPool.registerNatives(this);
        sun_misc_URLClassPath.registerNatives(this);
        java_lang_invoke_MethodHandle = new java_lang_invoke_MethodHandle(this);
        hook(new HookedMethod("javax/crypto/JarVerifier", "testSignatures", "(Ljava/security/cert/X509Certificate;Ljava/security/cert/CertificateFactory;)V", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                // temp disable
                return null;
            }
        }));
        hook(new HookedMethod("javax/crypto/JarVerifier", "verify", "()V", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                // temp disable
                return null;
            }
        }));
        hook(new HookedMethod("javax/crypto/JceSecurity", "canUseProvider", "(Ljava/security/Provider;)Z", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                // temp disable
                return newBoolean(true);
            }
        }));
        hook(new HookedMethod("java/lang/String", "charAt", "(I)C", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                JavaArray value = instance.asObject().getField("value", "[C").asArray();
                int index = args[0].asPrimitive().asInt();
                if (index < 0 || index >= value.length()) {
                    throw newThrowable("java/lang/StringIndexOutOfBoundsException", "String index out of range: " + index);
                }
                return value.get(index);
            }
        }));
        hook(new HookedMethod("java/lang/String", "hashCode", "()I", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                JavaArray value = instance.asObject().getField("value", "[C").asArray();
                JavaWrapper hash = instance.asObject().getField("hash", "I");
                if (hash.asInt() == 0 || value.length() > 0) {
                    hash = newInt(convertJavaObjectToString(instance).hashCode());
                    instance.asObject().setField("hash", "I", hash);
                }
                return hash;
            }
        }));
        hook(new HookedMethod("java/lang/Integer", "parseInt", "(Ljava/lang/String;I)I", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                try {
                    return newInt(Integer.parseInt(convertJavaObjectToString(args[0]), args[1].asInt()));
                } catch (NumberFormatException e) {
                    throw newThrowable("java/lang/NumberFormatException", e.getMessage());
                }
            }
        }));
        hook(new HookedMethod("java/lang/Math", "min", "(II)I", Cause.NONE, Effect.NONE).bind(new HookedMethod.Hook() {
            @Override
            public JavaWrapper execute(MethodExecution context, JavaWrapper instance, JavaWrapper[] args) {
                return newInt(Math.min(args[0].asInt(), args[1].asInt()));
            }
        }));
        new sun_nio_fs_WindowsNativeDispatcher(this);
        new sun_security_provider_NativeSeedGenerator(this);
        new java_lang_SecurityManager(this);
        new java_util_zip_ZipFile(this);
        new java_util_jar_JarFile(this);
        new sun_misc_Perf(this);
        new java_net_NetworkInterface(this);
        new java_lang_Runtime(this);
        new java_net_InetAddress(this);
        new java_net_Inet4Address(this);
        new java_net_Inet4AddressImpl(this);
        new java_net_Inet6Address(this);
        new java_net_InetAddressImplFactory(this);
        new java_net_DualStackPlainSocketImpl(this);
        new java_net_SocketInputStream(this);
        new java_net_SocketOutputStream(this);
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/Class", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            new java_lang_Class(this).registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/ClassLoader", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            java_lang_ClassLoader.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/Object", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            java_lang_Object.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/System", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            java_lang_System.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/Thread", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            java_lang_Thread.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "java/lang/invoke/MethodHandleNatives", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            java_lang_invoke_MethodHandleNatives.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "sun/misc/Unsafe", "registerNatives", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {
            sun_misc_Unsafe.registerNatives(this);
        }));
        hook(HookGenerator.generateUnknownHandlingVoidHook(this, "sun/misc/VM", "initialize", "()V", true, Cause.NONE, Effect.NONE, (ctx, inst, args) -> {

        }));

        hook(new HookedMethod("java/util/concurrent/atomic/AtomicLong", "VMSupportsCS8", "()Z", Cause.ALL, Effect.NONE).bind((ctx, inst, args) -> {
            // do we?
            return newBoolean(true);
        }));

        hook(new HookedMethod("sun/misc/Signal", "findSignal", "(Ljava/lang/String;)I", Cause.NONE, Effect.NONE).bind((ctx, inst, args) -> {
            // todo
            return JavaWrapper.createInteger(this, 0);
        }));
        hook(new HookedMethod("sun/misc/Signal", "handle0", "(IJ)J", Cause.NONE, Effect.NONE).bind((ctx, inst, args) -> {
            // todo
            return newLong(0);
        }));
        hook(new HookedMethod("sun/io/Win32ErrorMode", "setErrorMode", "(J)J", Cause.NONE, Effect.NONE).bind((ctx, inst, args) -> {
            // todo
            return newLong(0);
        }));
    }

    private JavaWrapper createMainThread() {
        JavaUninitialized unit = new JavaUninitialized(getSystemDictionary().getJavaLangThread(), getSystemDictionary().getJavaLangThread().internalGetType().getInternalName());
        unit.initializedValue().setMetadata("oop", ThreadOop.forCurrentThread());
        unit.initializedValue().setField("priority", "I", JavaWrapper.createInteger(this, 5));
        unit.initializedValue().setField("status", "I", JavaWrapper.createInteger(this, 1)); // RUNNING?
        JavaWrapper instance = JavaWrapper.wrap(unit);
        ThreadOop.forCurrentThread().setThread(instance);
        ClassNode node = getSystemDictionary().getJavaLangThread().getClassNode();

        initialize(getSystemDictionary().getJavaLangThread());

        MethodNode init = ASMHelper.findMethod(node, "<init>", "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V");
        if (init != null) {
            internalExecute(node, init, instance, new JavaWrapper[]{mainThreadGroup, getString("main")}, null);
        } else {
            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Unknown ctor init " + "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V");
        }
        return instance;
    }

    public LinkResolver getLinkResolver() {
        return this.linkResolver;
    }

    public Filesystem getFilesystem() {
        return filesystem;
    }

    public Memory getMemory() {
        return memory;
    }

    public Network getNetwork() {
        return network;
    }

    public SystemDictionary getSystemDictionary() {
        return systemDictionary;
    }

    public JavaWrapper newBoolean(boolean input) {
        return input ? TRUE : FALSE;
    }

    public JavaWrapper newBoxedBoolean(boolean input) {
        return internalExecute(
                getSystemDictionary().getJavaLangBoolean().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangBoolean().getClassNode(), "valueOf", "(Z)Ljava/lang/Boolean;"),
                null,
                new JavaWrapper[]{newBoolean(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newChar(char input) {
        return JavaWrapper.wrap(new JInteger(this, Type.CHAR_TYPE, input));
    }

    public JavaWrapper newBoxedChar(char input) {
        return internalExecute(
                getSystemDictionary().getJavaLangCharacter().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangCharacter().getClassNode(), "valueOf", "(C)Ljava/lang/Character;"),
                null,
                new JavaWrapper[]{newChar(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newByte(byte input) {
        return JavaWrapper.wrap(new JInteger(this, Type.BYTE_TYPE, input));
    }

    public JavaWrapper newBoxedByte(byte input) {
        return internalExecute(
                getSystemDictionary().getJavaLangByte().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangByte().getClassNode(), "valueOf", "(B)Ljava/lang/Byte;"),
                null,
                new JavaWrapper[]{newByte(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newShort(short input) {
        return JavaWrapper.wrap(new JInteger(this, Type.SHORT_TYPE, input));
    }

    public JavaWrapper newBoxedShort(short input) {
        return internalExecute(
                getSystemDictionary().getJavaLangShort().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangShort().getClassNode(), "valueOf", "(S)Ljava/lang/Short;"),
                null,
                new JavaWrapper[]{newShort(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newInt(int input) {
        return JavaWrapper.wrap(new JInteger(this, Type.INT_TYPE, input));
    }

    public JavaWrapper newBoxedInt(int input) {
        return internalExecute(
                getSystemDictionary().getJavaLangInteger().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangInteger().getClassNode(), "valueOf", "(I)Ljava/lang/Integer;"),
                null,
                new JavaWrapper[]{newInt(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newFloat(float input) {
        return JavaWrapper.wrap(new JFloat(this, input));
    }

    public JavaWrapper newBoxedFloat(float input) {
        return internalExecute(
                getSystemDictionary().getJavaLangFloat().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangFloat().getClassNode(), "valueOf", "(F)Ljava/lang/Float;"),
                null,
                new JavaWrapper[]{newFloat(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newLong(long input) {
        return JavaWrapper.wrap(new JLong(this, input));
    }

    public JavaWrapper newBoxedLong(long input) {
        return internalExecute(
                getSystemDictionary().getJavaLangLong().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangLong().getClassNode(), "valueOf", "(J)Ljava/lang/Long;"),
                null,
                new JavaWrapper[]{newLong(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public JavaWrapper newDouble(double input) {
        return JavaWrapper.wrap(new JDouble(this, input));
    }

    public JavaWrapper newBoxedDouble(double input) {
        return internalExecute(
                getSystemDictionary().getJavaLangDouble().getClassNode(),
                ASMHelper.findMethod(getSystemDictionary().getJavaLangDouble().getClassNode(), "valueOf", "(D)Ljava/lang/Double;"),
                null,
                new JavaWrapper[]{newDouble(input)},
                currentInsn.get(Thread.currentThread())
        );
    }

    public java_lang_ClassLoader getJavaLangClassLoader() {
        return _java_lang_classLoader;
    }

    public void initialize(JavaClass clazz) {
        // JLS §5.5
        clazz.getInitializationLock().lock();
        if (clazz.getInitializationState() == JavaClass.InitializationState.BEING_INITIALIZED) {
            if (clazz.getInitalizationThread() == Thread.currentThread()) {
                clazz.getInitializationLock().unlock();
                return;
            }
            while (true) {
                try {
                    // "Thread interrupt status is unaffected by execution of the initialization procedure."
                    clazz.getInitializationCondition().await();
                    break;
                } catch (InterruptedException ignored) {
                }
            }
            clazz.getInitializationLock().unlock();
            // "at which time repeat this procedure"
            initialize(clazz);
            return;
        } else if (clazz.getInitializationState() == JavaClass.InitializationState.INITIALIZED) {
            clazz.getInitializationLock().unlock();
            return;
        } else if (clazz.getInitializationState() == JavaClass.InitializationState.ERROR) {
            try {
                throw newThrowable(VMSymbols.java_lang_NoClassDefFoundError, clazz.getClassNode().name);
            } finally {
                clazz.getInitializationLock().unlock();
            }
        } else {
            clazz.setInitializationState(JavaClass.InitializationState.BEING_INITIALIZED, Thread.currentThread());
            clazz.getInitializationLock().unlock();
            for (FieldNode fieldNode : clazz.getClassNode().fields) {
                if (fieldNode.value != null && Modifier.isFinal(fieldNode.access) && Modifier.isStatic(fieldNode.access)) {
                    switch (fieldNode.desc) {
                        case "J":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newLong((Long) fieldNode.value));
                            break;
                        case "F":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newFloat((Float) fieldNode.value));
                            break;
                        case "D":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newDouble((Double) fieldNode.value));
                            break;
                        case "I":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newInt((Integer) fieldNode.value));
                            break;
                        case "S":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newShort(((Integer) fieldNode.value).shortValue()));
                            break;
                        case "C":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newChar((char) ((Integer) fieldNode.value).intValue()));
                            break;
                        case "B":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newByte(((Integer) fieldNode.value).byteValue()));
                            break;
                        case "Z":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, newBoolean((Integer) fieldNode.value != 0));
                            break;
                        case "Ljava/lang/String;":
                            clazz.setStaticField(fieldNode.name, fieldNode.desc, getString((String) fieldNode.value));
                            break;
                    }
                }
            }

            if (!clazz.isInterface()) {
                List<JavaClass> needsInitialization = new ArrayList<>();
                JavaClass superClass = clazz.getSuperclass();
                if (superClass != null) {
                    needsInitialization.add(superClass);

                    Predicate<JavaClass> shouldInit = intf -> {
                        boolean init = false;
                        for (MethodNode mn : intf.getClassNode().methods) {
                            if (!Modifier.isAbstract(mn.access) && !Modifier.isStatic(mn.access)) {
                                init = true;
                            }
                        }
                        return init;
                    };

                    List<JavaClass> intfInitOrder = new ArrayList<>();

                    java.util.Stack<JavaClass> dfs = new java.util.Stack<>();
                    for (JavaClass intf : clazz.getInterfaces()) {
                        if (shouldInit.test(intf)) {
                            dfs.push(intf);
                        }
                    }
                    while (!dfs.isEmpty()) {
                        JavaClass intf = dfs.pop();
                        for (JavaClass intf1 : intf.getInterfaces()) {
                            if (shouldInit.test(intf1)) {
                                dfs.push(intf1);
                            }
                        }
                        intfInitOrder.add(0, intf);
                    }

                    needsInitialization.addAll(intfInitOrder);
                }

                for (JavaClass javaClass : needsInitialization) {
                    try {
                        initialize(javaClass);
                    } catch (VMException ex) {
                        clazz.getInitializationLock().lock();
                        clazz.setInitializationState(JavaClass.InitializationState.ERROR, null);
                        clazz.getInitializationCondition().signalAll();
                        clazz.getInitializationLock().unlock();
                        throw ex;
                    }
                }
            }

            MethodNode clinit = ASMHelper.findMethod(clazz.getClassNode(), "<clinit>", "()V");
            if (clinit != null) {
                try {
                    internalExecute(clazz.getClassNode(), clinit, null, new JavaWrapper[0], currentInsn.get(Thread.currentThread()));
                } catch (VMException ex) {
                    if (DEBUG_PRINT_EXCEPTIONS) {
                        printException(ex);
                    }
                    JavaWrapper err = ex.getWrapped();
                    if (!getSystemDictionary().getJavaLangError().isAssignableFrom(err.getJavaClass())) {
                        err = newExceptionInInitializerError(err);
                    }
                    clazz.getInitializationLock().lock();
                    clazz.setInitializationState(JavaClass.InitializationState.ERROR, null);
                    clazz.getInitializationCondition().signalAll();
                    clazz.getInitializationLock().unlock();
                    throw new VMException(err);
                }
            }
            clazz.getInitializationLock().lock();
            clazz.setInitializationState(JavaClass.InitializationState.INITIALIZED, null);
            clazz.getInitializationCondition().signalAll();
            clazz.getInitializationLock().unlock();
        }
    }

    public JavaWrapper newInstanceWithOop(JavaClass clazz, Oop oop, String ctorsig, JavaWrapper... args) {
        JavaUninitialized unit = new JavaUninitialized(clazz, clazz.internalGetType().getInternalName());
        unit.initializedValue().setMetadata("oop", oop);
        JavaWrapper instance = JavaWrapper.wrap(unit);
        if (oop instanceof ThreadOop) {
            ((ThreadOop) oop).setThread(instance);
        }
        ClassNode node = clazz.getClassNode();

        initialize(clazz);

        MethodNode init = ASMHelper.findMethod(node, "<init>", ctorsig);
        if (init != null) {
            internalExecute(node, init, instance, args, null);
        } else {
            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Unknown ctor init " + ctorsig);
        }
        return instance;
    }

    public JavaWrapper newInstance(JavaClass clazz, String ctorsig, JavaWrapper... args) {
        JavaWrapper instance = JavaWrapper.wrap(new JavaUninitialized(clazz, clazz.internalGetType().getInternalName()));
        ClassNode node = clazz.getClassNode();

        initialize(clazz);

        MethodNode init = ASMHelper.findMethod(node, "<init>", ctorsig);
        if (init != null) {
            internalExecute(node, init, instance, args, null);
        } else {
            StringBuilder validCtors = new StringBuilder();
            for (MethodNode mn : node.methods) {
                if (mn.name.equals("<init>")) {
                    validCtors.append(mn.desc).append(" ");
                }
            }
            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Unknown ctor init " + ctorsig + " valid " + validCtors);
        }
        return instance;
    }

    @Deprecated
    public JavaClass forName(String name) {
        return _classCache.get(name);
    }

    @Deprecated
    public void cacheClass(JavaClass javaClass) {
        if (!javaClass.isPrimitive()) {
            _classCache.put(javaClass.internalGetType().getDescriptor(), javaClass);
        }
    }

    public VirtualMachine hook(HookedMethod method) {
        String key = hash(method.getOwner(), method.getName(), method.getDesc());
        Lock lock = methodHookLock.writeLock();
        lock.lock();
        try {
            if (HookedMethods.containsKey(key)) {
                throw new IllegalStateException("Hook already exists for " + key + " (thread " + Thread.currentThread().getId() + ")");
            }
            HookedMethods.put(key, method);
            return this;
        } finally {
            lock.unlock();
        }
    }

    public VirtualMachine hook(HookedFieldGetter field) {
        String key = hash(field.getOwner(), field.getName(), field.getDesc());
        if (fieldGetterHooks.containsKey(key)) {
            throw new IllegalStateException("Hook already exists for " + key + " (thread " + Thread.currentThread().getId() + ")");
        }
        fieldGetterHooks.put(key, field);
        return this;
    }

    public VirtualMachine hook(HookedFieldSetter field) {
        String key = hash(field.getOwner(), field.getName(), field.getDesc());
        if (fieldSetterHooks.containsKey(key)) {
            throw new IllegalStateException("Hook already exists for " + key);
        }
        fieldSetterHooks.put(key, field);
        return this;
    }

    public VirtualMachine classpath(Collection<ClassNode> classNodes) {
        classNodes.forEach(node -> _classpath.putIfAbsent(node.name, node));

        return this;
    }

    public VirtualMachine load(Collection<byte[]> bytes) {
        for (byte[] b : bytes) {
            ClassReader reader = new ClassReader(b);
            ClassNode node = new ClassNode();
            reader.accept(node, ClassReader.SKIP_FRAMES);
            _classpath.putIfAbsent(node.name, node);
            _constantPools.putIfAbsent(node, new ConstantPool(this, reader));
        }

        return this;
    }

    public MethodExecution execute(ClassNode classNode, MethodNode methodNode) throws VMException {
        return execute(classNode, methodNode, new ExecutionOptions());
    }

    public MethodExecution execute(ClassNode classNode, MethodNode methodNode, ExecutionOptions options) throws VMException {
        JavaWrapper instance = null;
        List<JavaWrapper> args = new ArrayList<>();

        if (!Modifier.isStatic(methodNode.access)) {
            instance = JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, TypeHelper.getTypeByInternalName(this, classNode.name)), "Instance"));
        }

        for (Type type : Type.getArgumentTypes(methodNode.desc)) {
            if (type.getSort() == Type.VOID || type.getSort() == Type.METHOD) {
                throw new IllegalArgumentException("Unexpected type in desc");
            } else {
                args.add(JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, type), "arg")));
            }
        }

        return execute(classNode, methodNode, instance, args, options);
    }

    public MethodExecution execute(ClassNode classNode, MethodNode methodNode, JavaValue instance, List<JavaValue> params) throws VMException {
        return execute(classNode, methodNode, JavaWrapper.wrap(instance), params.stream().map(JavaWrapper::wrap).collect(Collectors.toList()), new ExecutionOptions());
    }

    public MethodExecution execute(ClassNode classNode, MethodNode methodNode, JavaWrapper instance, List<JavaWrapper> params) throws VMException {
        return execute(classNode, methodNode, instance, params, new ExecutionOptions());
    }

    public MethodExecution execute(ClassNode classNode, MethodNode methodNode, JavaWrapper instance, List<JavaWrapper> params, ExecutionOptions options) throws VMException {
        MethodExecution execution = new MethodExecution(this, classNode, methodNode, options);

        HookInfo info = new HookInfo(classNode, methodNode, instance, params);
        beforeCallHooks.forEach(c -> c.accept(info));
        if (info.getReturnValue() != null) {
            execution.setReturnValue(info.getReturnValue());
            return execution;
        }

        io.rsbox.toolbox.asm.Stack stack = new io.rsbox.toolbox.asm.Stack();
        Locals locals = new Locals();
        if (!Modifier.isStatic(methodNode.access)) {
            if (instance == null)
                throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("NullPointerException");

            locals.set(0, instance);
        }
        int index = Modifier.isStatic(methodNode.access) ? 0 : 1;

        Type[] argTypes = Type.getArgumentTypes(methodNode.desc);

        int startTypeInd = 0;

        if (params != null) {
            for (JavaWrapper arg : params) {
                locals.set(index++, arg);
                startTypeInd++;
                if (arg.is(JavaValueType.WIDE)) {
                    locals.set(index++, JavaWrapper.createTop());
                }
            }
        }

        for (int i = startTypeInd; i < argTypes.length; i++) {
            locals.set(index++, JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, argTypes[i]), "arg")));
            if (JavaClass.forName(this, argTypes[i]) == DOUBLE || JavaClass.forName(this, argTypes[i]) == LONG) {
                locals.set(index++, JavaWrapper.createTop());
            }
        }

        JavaWrapper returnValue;

        HookedMethod hookedMethod = getHook(classNode.name, methodNode.name, methodNode.desc);
        if (hookedMethod != null) {
            depth.set(depth.get() + 1);
            try {
                if (TRACE) {
                    System.out.println(StringUtils.repeat("\t", depth.get()) + "Executing hook " + StringEscapeUtils.escapeJava(classNode.name) + "." + StringEscapeUtils.escapeJava(methodNode.name + "." + methodNode.desc));
                }
                returnValue = hookedMethod.execute(execution, instance, params.toArray(new JavaWrapper[params.size()]), null);
            } finally {
                depth.set(depth.get() - 1);
            }
        } else {
            try {
                returnValue = execute(execution, stack, locals, instance, methodNode.instructions.getFirst(), false);
            } catch (VMException e) {
//                JavaWrapper wrapper = e.getWrapped();
//                StacktraceException ste = wrapper.get().getMetadata("throwable");
//                ste.setBackingMessage(convertJavaObjectToString(((JavaObject) wrapper.get()).getField("detailMessage", "Ljava/lang/String;")));
                // todo what
                throw e;
            } catch (AbortException e) {
                returnValue = null;
            }
        }
        info.setReturnValue(returnValue);
        afterCallHooks.forEach(c -> c.accept(info));
        execution.setReturnValue(info.getReturnValue());
        return execution;
    }

    public List<Consumer<HookInfo>> beforeCallHooks = new ArrayList<>();
    public List<Consumer<HookInfo>> afterCallHooks = new ArrayList<>();
    public Map<Object, Consumer<ExecutionOptions.BreakpointInfo>> breakpoints = new HashMap<>();

    public Object addBreakpoint(Consumer<ExecutionOptions.BreakpointInfo> bp) {
        Object token = new Object();
        breakpoints.put(token, bp);
        return token;
    }

    public JavaWrapper internalExecute(ClassNode classNode, MethodNode methodNode, JavaWrapper instance, JavaWrapper[] params, AbstractInsnNode prev) {
        MethodExecution execution = new MethodExecution(this, classNode, methodNode, null);

        HookInfo info = new HookInfo(classNode, methodNode, instance, params == null ? Collections.emptyList() : Arrays.asList(params));
        beforeCallHooks.forEach(c -> c.accept(info));
        if (info.getReturnValue() != null) {
            return info.getReturnValue();
        }

        io.rsbox.toolbox.asm.Stack stack = new io.rsbox.toolbox.asm.Stack();
        Locals locals = new Locals();
        if (!Modifier.isStatic(methodNode.access)) {
            if (instance == null)
                throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("NullPointerException");

            locals.set(0, instance);
        }
        int index = Modifier.isStatic(methodNode.access) ? 0 : 1;

        Type[] argTypes = Type.getArgumentTypes(methodNode.desc);

        int startTypeInd = 0;

        if (params != null) {
            for (JavaWrapper arg : params) {
                locals.set(index++, arg);
                startTypeInd++;
                if (arg.is(JavaValueType.WIDE)) {
                    locals.set(index++, JavaWrapper.createTop());
                }
            }
        }

        for (int i = startTypeInd; i < argTypes.length; i++) {
            locals.set(index++, JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, argTypes[i]), "arg")));
            if (argTypes[i].getSort() == Type.DOUBLE || argTypes[i].getSort() == Type.LONG) {
                locals.set(index++, JavaWrapper.createTop());
            }
        }

        if (_stacktrace.computeIfAbsent(Thread.currentThread(), key -> new ArrayDeque<>()).size() > 0) {
            _stacktrace.get(Thread.currentThread()).peekFirst().setInstruction(currentInsn.get(Thread.currentThread()));
        }


        HookedMethod hookedMethod = getHook(classNode.name, methodNode.name, methodNode.desc);
        JavaWrapper result;
        if (hookedMethod != null) {
            depth.set(depth.get() + 1);
            try {
                if (TRACE) {
                    System.out.println(StringUtils.repeat("\t", depth.get()) + "Executing hook " + StringEscapeUtils.escapeJava(classNode.name) + "." + StringEscapeUtils.escapeJava(methodNode.name + "." + methodNode.desc));
                }
                result = hookedMethod.execute(execution, instance, params, prev);
            } finally {
                depth.set(depth.get() - 1);
            }
        } else {
            result = execute(execution, stack, locals, instance, methodNode.instructions.getFirst(), false);
        }
        HookInfo info1 = new HookInfo(classNode, methodNode);
        info1.setReturnValue(result);
        afterCallHooks.forEach(c -> c.accept(info1));
        return result;
    }

    /*
     * Main executor. This will go through each instruction and execute the instruction using a switch statement
     */
    private JavaWrapper execute(MethodExecution execution, io.rsbox.toolbox.asm.Stack stack, Locals locals, JavaWrapper curInstance, AbstractInsnNode now, boolean isBranch) {
        if (Modifier.isNative(execution.getMethodNode().access)) {
            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("UnsatisfiedLinkError: " + execution.getClassNode().name + " " + execution.getMethodNode().name + execution.getMethodNode().desc);
        }
        depth.set(depth.get() + 1);
        if (!isBranch)
            pushStacktrace(execution.getClassNode(), execution.getMethodNode(), now);
        try {
            Lock needToUnlock = null;
            try {
                if (Modifier.isSynchronized(execution.getMethodNode().access)) {
                    if (curInstance == null) {
                        JavaClass jc = JavaClass.forName(this, execution.getClassNode().name);
                        needToUnlock = jc.getLock();
                    } else {
                        needToUnlock = curInstance.get().getLock();
                    }
                }

                if (needToUnlock != null) {
                    needToUnlock.lock();
                }

                execution.Visited.merge(now, 1, Integer::sum);
                if (execution.Visited.get(now) > 500) {
                    return JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, Type.getReturnType(execution.getMethodNode().desc)), "Stack Overflow on " + stack + " " + locals));
                }

                ClassNode classNode = execution.getClassNode();
                MethodNode method = execution.getMethodNode();
                InstructionSnapshot[] snapshots = execution.getInstructions();

                List<AbstractInsnNode> branchTo = new ArrayList<>();

                if (TRACE) {
                    System.out.println(Thread.currentThread().getId() + StringUtils.repeat("\t", depth.get()) + "Executing " + StringEscapeUtils.escapeJava(classNode.name) + "." + StringEscapeUtils.escapeJava(method.name + "." + method.desc));
                }
                Thread currentThread = Thread.currentThread();
                forever:
                while (true) {
                    try {
                        if (now == null) {
                            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Falling off end of code in " + StringEscapeUtils.escapeJava(classNode.name) + " " + StringEscapeUtils.escapeJava(method.name) + StringEscapeUtils.escapeJava(method.desc));
                        }
                        currentInsn.put(currentThread, now);
                        if (
                                (DEBUG
                                        && (DEBUG_CLASSES.isEmpty() || DEBUG_CLASSES.contains(classNode.name))
                                        && (DEBUG_METHODS_WITH_DESC.isEmpty() || DEBUG_METHODS_WITH_DESC.contains(method.name + method.desc)))
                                        || false
                                ) {
                            System.out.println("\tStack: " + stack);
                            System.out.println("\tLocals: " + locals);
                            System.out.println();
                            System.out.println(method.instructions.indexOf(now) + " " + Utils.prettyprint(now));
                        }
                        if (now.getOpcode() != -1 && INSTRUCTION_HANDLERS[now.getOpcode()] != null) {
                            branchTo.clear();
                            INSTRUCTION_HANDLERS[now.getOpcode()].execute(execution, now, stack, locals, branchTo);
                            if (branchTo.size() == 1) {
                                now = branchTo.get(0);
                            } else if (branchTo.size() > 1) {
                                JavaUnknown unknown = new JavaUnknown(this, JavaClass.forName(this, TypeHelper.getTypeByInternalName(this, "java/lang/Object")), "Multiple possibilities on " + Utils.prettyprint(now));
                                for (AbstractInsnNode node : branchTo) {
                                    unknown.merge(execute(execution, stack.copy(), locals.copy(), curInstance, node, true).toString());
                                }
                                return JavaWrapper.wrap(unknown);
                            }
                        } else {
                            switch (now.getOpcode()) {
                                case POP:
                                    stack.pop();
                                    break;
                                case POP2: {
                                    JavaWrapper wrapper = stack.pop();
                                    if (!wrapper.is(JavaValueType.WIDE)) {
                                        stack.pop();
                                    }
                                    break;
                                }
                                case DUP:
                                    stack.push(stack.peek());
                                    break;
                                case DUP_X1: {
                                    JavaWrapper obj = stack.peek();
                                    if (obj.is(JavaValueType.WIDE)) {
                                        throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Dup with wide value");
                                    }
                                    JavaWrapper a = stack.pop();
                                    JavaWrapper b = stack.pop();
                                    stack.push(a);
                                    stack.push(b);
                                    stack.push(a);
                                    break;
                                }
                                case DUP_X2: {
                                    JavaWrapper obj = stack.peek();
                                    if (obj.is(JavaValueType.WIDE)) {
                                        throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Dup with wide value");
                                    }
                                    JavaWrapper a = stack.pop();
                                    JavaWrapper b = stack.pop();
                                    JavaWrapper c = stack.pop();
                                    stack.push(a);
                                    stack.push(c);
                                    stack.push(b);
                                    stack.push(a);
                                    break;
                                }
                                case DUP2: {
                                    JavaWrapper a = stack.pop();
                                    if (a.is(JavaValueType.WIDE)) {
                                        stack.push(a);
                                        stack.push(a);
                                    } else {
                                        JavaWrapper b = stack.pop();
                                        stack.push(b);
                                        stack.push(a);
                                        stack.push(b);
                                        stack.push(a);
                                    }
                                    break;
                                }
                                case DUP2_X1: {
                                    JavaWrapper obj = stack.pop();
                                    if (obj.is(JavaValueType.WIDE)) {
                                        JavaWrapper c = stack.pop();
                                        stack.push(obj);
                                        stack.push(c);
                                        stack.push(obj);
                                    } else {
                                        JavaWrapper b = stack.pop();
                                        JavaWrapper c = stack.pop();
                                        stack.push(b);
                                        stack.push(obj);
                                        stack.push(c);
                                        stack.push(b);
                                        stack.push(obj);
                                    }
                                    break;
                                }
                                case DUP2_X2: {
                                    JavaWrapper obj = stack.pop();
                                    if (obj.is(JavaValueType.WIDE)) {
                                        JavaWrapper c = stack.pop();
                                        if (c.is(JavaValueType.WIDE)) {
                                            stack.push(obj);
                                            stack.push(c);
                                            stack.push(obj);
                                        } else {
                                            JavaWrapper d = stack.pop();
                                            stack.pushAll(obj, d, c, obj);
                                        }
                                    } else {
                                        JavaWrapper b = stack.pop();
                                        JavaWrapper c = stack.pop();
                                        if (c.is(JavaValueType.WIDE)) {
                                            stack.pushAll(b, obj, c, b, obj);
                                        } else {
                                            JavaWrapper d = stack.pop();
                                            stack.pushAll(b, obj, d, c, b, obj);
                                        }
                                    }
                                    break;
                                }
                                case SWAP: {
                                    JavaWrapper a = stack.pop();
                                    JavaWrapper b = stack.pop();
                                    stack.push(a);
                                    stack.push(b);
                                    break;
                                }
                                case INEG: {
                                    JavaWrapper value = stack.pop();
                                    if (!value.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.createInteger(this, -value.get().asInt()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, INTEGER, "INEG " + value)));
                                    }
                                    break;
                                }
                                case LNEG: {
                                    JavaWrapper value = stack.pop();
                                    if (!value.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(newLong(-value.get().asLong()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, LONG, "LNEG " + value)));
                                    }
                                    break;
                                }
                                case FNEG: {
                                    JavaWrapper value = stack.pop();
                                    if (!value.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.createFloat(this, -value.get().asFloat()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, FLOAT, "FNET " + value)));
                                    }
                                    break;
                                }
                                case DNEG: {
                                    stack.pop();
                                    JavaWrapper value = stack.pop();
                                    if (!value.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.createDouble(this, -value.get().asDouble()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, DOUBLE, "DNEG " + value)));
                                    }
                                    break;
                                }
                                case IINC: {
                                    IincInsnNode cast = (IincInsnNode) now;
                                    if (locals.get(cast.var).get() instanceof JInteger) {
                                        JInteger integer = (JInteger) locals.get(cast.var).get();
                                        locals.set(cast.var, JavaWrapper.createInteger(this, integer.asInt() + cast.incr));
                                    }
                                    break;
                                }
                                case I2L: {
                                    JavaWrapper top = stack.pop();
                                    if (!top.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(newLong(top.get().asInt()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, LONG, "I2L " + top.get())));
                                    }
                                    break;
                                }
                                case I2F: {
                                    JavaWrapper top = stack.pop();
                                    if (!top.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.createFloat(this, top.get().asInt()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, FLOAT, "I2F " + top.get())));
                                    }
                                    break;
                                }
                                case I2D: {
                                    JavaWrapper top = stack.pop();
                                    if (!top.get().is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.createDouble(this, top.get().asInt()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, DOUBLE, "I2D " + top.get())));
                                    }
                                    break;
                                }
//                        case L2F: {
//                            JavaValue value = stack.pop();
//                            if (VERIFY && !(value instanceof JavaTop)) {
//                                throw new ExecutionException("Expected JavaTop");
//                            }
//                            stack.push(new JavaFloat((float) stack.pop().longValue()));
//                            break;
//                        }
//					case L2D:
//					{
//						stack.add(1, new JavaDouble(stack.remove(1).longValue()));
//						break;
//					}
//                        case F2I: {
//                            stack.push(new JavaInteger((int) stack.pop().floatValue()));
//                            break;
//                        }
//                        case F2L: {
//                            stack.push(new JavaLong((long) stack.pop().floatValue()));
//                            stack.push(new JavaTop());
//                            break;
//                        }
//                        case F2D: {
//                            JavaValue value = stack.pop();
//                            if (value.isKnown()) {
//                                stack.push(new JavaDouble((double) stack.pop().floatValue()));
//                            } else {
//                                stack.push(new JavaUnknown(JavaDouble.class, "F2D " + value));
//                            }
//                            stack.push(new JavaTop());
//                            break;
//                        }
//                        case D2I: {
//                            JavaValue value = stack.pop();
//                            if (VERIFY && !(value instanceof JavaTop)) {
//                                throw new ExecutionException("Expected JavaTop");
//                            }
//                            stack.push(new JavaInteger((int) stack.pop().doubleValue()));
//                            break;
//                        }
//					case D2L:
//					{
//						stack.add(1, new JavaLong((long) stack.remove(1).doubleValue()));
//						break;
//					}
//                        case D2F: {
//                            JavaValue value = stack.pop();
//                            if (VERIFY && !(value instanceof JavaTop)) {
//                                throw new ExecutionException("Expected JavaTop");
//                            }
//                            stack.push(new JavaFloat((float) stack.pop().doubleValue()));
//                            break;
//                        }
                                case I2B: {
                                    stack.push(newByte(stack.pop().get().asByte()));
                                    break;
                                }
                                case I2C: {
                                    JavaValue intValue = stack.pop().get();
                                    if (!intValue.is(JavaValueType.UNKNOWN)) {
                                        stack.push(newChar(intValue.asChar()));
                                    } else {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, CHARACTER, JavaUnknown.UnknownCause.I2C, intValue)));
                                    }
                                    break;
                                }
                                case I2S: {
                                    stack.push(newShort(stack.pop().asPrimitive().asShort()));
                                    break;
                                }
                                case GOTO: {
                                    JumpInsnNode cast = (JumpInsnNode) now;
                                    now = cast.label;
                                    break;
                                }
                                case JSR: {
                                    JumpInsnNode cast = (JumpInsnNode) now;
                                    stack.push(JavaWrapper.wrap(new JavaAddress(now)));
                                    now = cast.label;
                                    break;
                                }
                                case RET: {
                                    VarInsnNode cast = (VarInsnNode) now;
                                    JavaValue value = locals.get(cast.var).get();
                                    if (!(value instanceof JavaAddress)) {
                                        throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Expected address on stack");
                                    }
                                    now = ((JavaAddress) value).getReturnAddres();
                                    break;
                                }
                                case TABLESWITCH: {
                                    int x = stack.pop().get().asInt();
                                    TableSwitchInsnNode cast = (TableSwitchInsnNode) now;
                                    if (x - cast.min < cast.labels.size() && x - cast.min >= 0) {
                                        now = cast.labels.get(x - cast.min);
                                    } else {
                                        now = cast.dflt;
                                    }
                                    break;
                                }
                                case LOOKUPSWITCH: {
                                    LookupSwitchInsnNode cast = (LookupSwitchInsnNode) now;
                                    JavaWrapper indexValue = stack.pop();
                                    if (!indexValue.is(JavaValueType.UNKNOWN)) {
                                        Integer index = indexValue.asInt();
                                        if (cast.keys.indexOf(index) != -1) {
                                            now = cast.labels.get(cast.keys.indexOf(index));
                                        } else {
                                            now = cast.dflt;
                                        }
                                    } else {
                                        List<JavaWrapper> results = new ArrayList<>();
                                        results.add(indexValue);
                                        results.add(execute(execution, stack.copy(), locals.copy(), curInstance, cast.dflt, true));
                                        for (LabelNode labelNode : cast.labels) {
                                            results.add(execute(execution, stack.copy(), locals.copy(), curInstance, labelNode, true));
                                        }
                                        return JavaWrapper.wrap(new JavaUnknown(this, JavaClass.forName(this, TypeHelper.getTypeByInternalName(this, "java/lang/Object")), JavaUnknown.UnknownCause.LOOKUPSWITCH, results.toArray(new JavaValue[results.size()])));
                                    }
                                    break;
                                }
                                case LRETURN:
                                case DRETURN:
                                case IRETURN:
                                case FRETURN:
                                case ARETURN: {
                                    return stack.pop();
                                }
                                case RETURN: {
                                    return null;
                                }
                                case GETSTATIC: {
                                    FieldInsnNode cast = (FieldInsnNode) now;

                                    JavaClass ownerClass = JavaClass.forName(this, cast.owner);

                                    Pair<JavaClass, JavaField> targetField = ownerClass.findFieldNode(cast.name, cast.desc, true);
                                    if (targetField == null) {
                                        throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("null target field for " + cast.owner + " " + cast.name + " " + cast.desc);
                                    }
                                    initialize(targetField.getLeft());

                                    HookedFieldGetter hook = getHookedFieldGetter(targetField.getLeft().getClassNode().name, cast.name, cast.desc);
                                    JavaWrapper value;
                                    if (hook != null) {
                                        value = hook.get(execution, null);
                                    } else {
                                        value = targetField.getLeft().getStaticField(cast.name, cast.desc);
                                    }

                                    stack.push(value);
                                    break;
                                }
                                case PUTSTATIC: {
                                    FieldInsnNode cast = (FieldInsnNode) now;
                                    JavaWrapper obj = stack.pop();

                                    JavaClass ownerClass = JavaClass.forName(this, cast.owner);

                                    Pair<JavaClass, JavaField> targetField = ownerClass.findFieldNode(cast.name, cast.desc, true);
                                    initialize(targetField.getLeft());

                                    HookedFieldSetter hook = getHookedFieldSetter(targetField.getLeft().getClassNode().name, cast.name, cast.desc);
                                    if (hook != null) {
                                        hook.set(execution, null, obj);
                                    } else {
                                        targetField.getLeft().setStaticField(cast.name, cast.desc, obj);
                                    }
                                    break;
                                }
                                case GETFIELD: {
                                    JavaWrapper obj = stack.pop();
                                    FieldInsnNode cast = (FieldInsnNode) now;

                                    JavaClass ownerClass = JavaClass.forName(this, cast.owner);

                                    Pair<JavaClass, JavaField> targetField = ownerClass.findFieldNode(cast.name, cast.desc, true);
                                    HookedFieldGetter hook = getHookedFieldGetter(targetField.getLeft().getClassNode().name, cast.name, cast.desc);

                                    JavaWrapper value;
                                    if (hook != null) {
                                        value = hook.get(execution, obj);
                                    } else {
                                        value = ((JavaObject) obj.get()).getField(cast.name, cast.desc);
                                    }

                                    stack.push(value);
                                    break;
                                }
                                case PUTFIELD: {
                                    JavaWrapper obj = stack.pop();
                                    JavaWrapper instance = stack.pop();
                                    FieldInsnNode cast = (FieldInsnNode) now;

                                    JavaClass ownerClass = JavaClass.forName(this, cast.owner);

                                    Pair<JavaClass, JavaField> targetField = ownerClass.findFieldNode(cast.name, cast.desc, true);
                                    HookedFieldSetter hook = getHookedFieldSetter(targetField.getLeft().getClassNode().name, cast.name, cast.desc);

                                    if (hook != null) {
                                        hook.set(execution, instance, obj);
                                    } else {
                                        if (instance.get() instanceof JavaUninitialized) {
                                            ((JavaUninitialized) instance.get()).initializedValue().setField(cast.name, cast.desc, obj);
                                        } else {
                                            ((JavaObject) instance.get()).setField(cast.name, cast.desc, obj);
                                        }
                                    }
                                    break;
                                }
                                case ANEWARRAY: {
                                    TypeInsnNode typeInsnNode = (TypeInsnNode) now;
                                    int len = stack.pop().get().asInt();
                                    String type;
                                    // todo TypeHelper should do this
                                    if (typeInsnNode.desc.startsWith("[") || (typeInsnNode.desc.startsWith("L") && typeInsnNode.desc.endsWith(";"))) {
                                        type = "[" + typeInsnNode.desc;
                                    } else {
                                        type = "[L" + typeInsnNode.desc + ";";
                                    }
                                    stack.push(JavaWrapper.createArray(JavaClass.forName(this, Type.getType(type)), new JavaWrapper[len]));
                                    break;
                                }
                                case ARRAYLENGTH: {
                                    JavaWrapper obj = stack.pop();
                                    if (obj.is(JavaValueType.UNKNOWN)) {
                                        stack.push(JavaWrapper.wrap(new JavaUnknown(this, INTEGER, "ArrayLength on (" + obj + ")")));
                                    } else {
                                        if (!obj.is(JavaValueType.ARRAY)) {
                                            throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Not array");
                                        }
                                        stack.push(newInt(obj.asArray().length()));
                                    }
                                    break;
                                }
                                case ATHROW: {
                                    JavaWrapper throwable = stack.pop();
                                    if (throwable.is(JavaValueType.NULL)) {
                                        throw newThrowable(VMSymbols.java_lang_NullPointerException);
                                    }
                                    if (!getSystemDictionary().getJavaLangThrowable().isAssignableFrom(throwable.getJavaClass())) {
                                        throw new io.rsbox.toolbox.asm.exceptions.ExecutionException("Expected throwable, got " + throwable.getJavaClass());
                                    }
                                    throw new VMException(throwable);
                                }
                                case INSTANCEOF: {
                                    TypeInsnNode cast = (TypeInsnNode) now;
                                    JavaValue obj = stack.pop().get();

                                    if (obj.isInstanceOf(TypeHelper.parseType(this, cast.desc))) {
                                        stack.push(JavaWrapper.createInteger(this, 1));
                                    } else {
                                        stack.push(JavaWrapper.createInteger(this, 0));
                                    }

                                    break;
                                }
                                case MONITORENTER: {
                                    JavaValue inst = stack.pop().get();
                                    inst.getLock().lock();
                                    break;
                                }
                                case MONITOREXIT: {
                                    JavaValue inst = stack.pop().get();
                                    inst.getLock().unlock();
                                    break;
                                }
                                case MULTIANEWARRAY: {
                                    MultiANewArrayInsnNode cast = (MultiANewArrayInsnNode) now;
                                    int[] sizes = new int[cast.dims];
                                    for (int i = cast.dims - 1; i >= 0; i--) {
                                        sizes[i] = stack.pop().asPrimitive().asInt();
                                    }
                                    Type type = Type.getType(cast.desc);
                                    JavaWrapper created = ArrayHelper.newInstance(this, type, sizes);
                                    stack.push(created);
                                    break;
                                }
                                case -1: {
                                    break;
                                }
                                default: {
                                    throw new ExecutionException("Unknown opcode " + now.getClass().getSimpleName() + " " + Integer.toHexString(now.getOpcode()) + " " + now);
                                }
                            }
                        }

                        ExecutionOptions.BreakpointInfo bpinfo = new ExecutionOptions.BreakpointInfo(now, stack, locals);
                        breakpoints.values().forEach(k -> k.accept(bpinfo));

                        if (execution.getOptions() != null && execution.getOptions().shouldRecord(now)) {
                            execution.getOptions().notify(now, bpinfo);
//                                if (snapshots[method.instructions.indexOf(now)] == null) {
//                                    InstructionSnapshot current = new InstructionSnapshot();
//                                    current.merge(stack.copy(), locals.copy());
//                                    snapshots[method.instructions.indexOf(now)] = current;
//                                } else {
//                                    snapshots[method.instructions.indexOf(now)].merge(stack.copy(), locals.copy());
//                                }
                        }

                        now = now.getNext();
                    } catch (VMException t) {
                        if (DEBUG_PRINT_EXCEPTIONS) {
                            printException(t);
                        }
                        JavaWrapper wrapper = t.getWrapped();
                        if (method.tryCatchBlocks != null) {
                            for (TryCatchBlockNode tcbn : method.tryCatchBlocks) {
                                if (method.instructions.indexOf(tcbn.start) <= method.instructions.indexOf(now) && method.instructions.indexOf(now) < method.instructions.indexOf(tcbn.end)) {
                                    if (tcbn.type == null || tcbn.type.equals("java/lang/Throwable")) {
                                        stack.clear();
                                        stack.push(wrapper);
                                        now = tcbn.handler;
                                        continue forever;
                                    } else {
                                        JavaClass type = wrapper.getJavaClass();
                                        JavaClass target = JavaClass.forName(this, TypeHelper.parseType(this, tcbn.type));
                                        if (target.isAssignableFrom(type)) {
                                            stack.clear();
                                            stack.push(wrapper);
                                            now = tcbn.handler;
                                            continue forever;
                                        }
                                    }
                                }
                            }
                        }

                        throw t;
                    }
                }
            } catch (AbortException | VMException e) {
                throw e;
            } catch (Throwable e) {
                try {
                    Field field = Throwable.class.getDeclaredField("suppressedExceptions");
                    field.setAccessible(true);
                    List list = (List) field.get(e);
                    boolean has = false;
                    for (Object o : list) {
                        if (o instanceof ConvertedException) {
                            has = true;
                        }
                    }
                    if (!has) {
                        e.addSuppressed(convertException(newThrowable(VMSymbols.java_lang_Throwable)));
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                throw e;
            } finally {
                if (needToUnlock != null) {
                    needToUnlock.unlock();
                }
            }
        } finally {
            depth.set(depth.get() - 1);
            if (!isBranch)
                popStacktrace();
        }
    }

    public ClassNode lookupClass(String internalName) {
        if (internalName == null) {
            return null;
        }
        return _classpath.get(internalName);
    }

    public HookedMethod getHook(String owner, String name, String desc) {
        Lock lock = methodHookLock.readLock();
        lock.lock();
        try {
            return HookedMethods.get(hash(owner, name, desc));
        } finally {
            lock.unlock();
        }
    }

    public HookedFieldGetter getHookedFieldGetter(String owner, String name, String desc) {
        return fieldGetterHooks.get(hash(owner, name, desc));
    }

    public HookedFieldSetter getHookedFieldSetter(String owner, String name, String desc) {
        return fieldSetterHooks.get(hash(owner, name, desc));
    }

    public JavaWrapper getNull() {
        return NULL;
    }

    public VMException newThrowable(String clazz, String fmt) {
        return new VMException(newInstance(JavaClass.forName(this, clazz), "(Ljava/lang/String;)V", getString(fmt)));
    }

    public VMException newThrowable(String clazz) {
        return new VMException(newInstance(JavaClass.forName(this, clazz), "()V"));
    }

    public Map<Class<?>, JavaClass> getLookupMap() {
        return PRIMITIVE_TO_JAVACLASS_MAP;
    }

    public JavaWrapper newExceptionInInitializerError(JavaWrapper err) {
        return newInstance(JavaClass.forName(this, "java/lang/ExceptionInInitializerError"), "(Ljava/lang/Throwable;)V", err);
    }

    public void registerClass(ClassReader classReader, ClassNode classNode) {
        _constantPools.put(classNode, new ConstantPool(this, classReader));
        _classpath.put(classNode.name, classNode);
    }

    public void shutdown() {
        ThreadOop.shutdown();
    }

    public void printException(VMException e) {
        internalExecute(getSystemDictionary().getJavaLangThrowable().getClassNode(), ASMHelper.findMethod(getSystemDictionary().getJavaLangThrowable().getClassNode(), "printStackTrace", "()V"), e.getWrapped(), new JavaWrapper[]{}, null);
    }

    public String exceptionToString(VMException e) {
        JavaWrapper stringWriter = newInstance(JavaClass.forName(this, "java/io/StringWriter"), "()V");
        JavaWrapper printWriter = newInstance(JavaClass.forName(this, "java/io/PrintWriter"), "(Ljava/io/Writer;)V", stringWriter);
        internalExecute(getSystemDictionary().getJavaLangThrowable().getClassNode(), ASMHelper.findMethod(getSystemDictionary().getJavaLangThrowable().getClassNode(), "printStackTrace", "(Ljava/io/PrintStream;)V"), e.getWrapped(), new JavaWrapper[]{printWriter}, null);
        return convertJavaObjectToString(internalExecute(stringWriter.getJavaClass().getClassNode(), ASMHelper.findMethod(stringWriter.getJavaClass().getClassNode(), "toString", "()Ljava/lang/String;"), stringWriter, new JavaWrapper[]{}, null)).trim();
    }

    /**
     * Converts a {@link VMException} into a {@link Throwable}. All properties of Throwable will be preserved,
     * but custom properties declared by subclasses of Throwable will not. This function is provided as a helper method
     * to quickly extract useful information from VMException
     */
    public ConvertedException convertException(VMException e) {
        return convertException(e.getWrapped());
    }

    /**
     * Converts a {@link VMException} into a {@link Throwable}. All properties of Throwable will be preserved,
     * but custom properties declared by subclasses of Throwable will not. This function is provided as a helper method
     * to quickly extract useful information from VMException
     */
    public ConvertedException convertException(JavaWrapper e) {
        if (!getSystemDictionary().getJavaLangThrowable().isAssignableFrom(e.getJavaClass())) {
            return null;
        }

        String message = e.getJavaClass().getName();
        JavaWrapper wrappedMessage = e.asObject().getField("detailMessage", "Ljava/lang/String;");
        if (wrappedMessage != null) {
            message += ": " + convertJavaObjectToString(wrappedMessage);
        }
        ConvertedException root = new ConvertedException(message);

        List<StackTraceElement> stacktrace = java_lang_Throwable.convert(e.getMetadata(java_lang_Throwable.METADATA_BACKTRACE));
        root.setStackTrace(stacktrace.toArray(new StackTraceElement[stacktrace.size()]));

        JavaWrapper cause = e.asObject().getField("cause", "Ljava/lang/Throwable;");
        if (!cause.is(JavaValueType.NULL) && cause.get() != e.get()) {
            root.initCause(convertException(cause));
        }

        JavaWrapper suppressedExceptions = e.asObject().getField("suppressedExceptions", "Ljava/util/List;");
        JavaWrapper suppressedSentinel = getSystemDictionary().getJavaLangThrowable().getStaticField("SUPPRESSED_SENTINEL", "Ljava/util/List;");

        if (suppressedExceptions != suppressedSentinel) {
            if (!suppressedExceptions.getJavaClass().getClassNode().name.equals("java/util/ArrayList")) {
                throw new RuntimeException("Expected ArrayList"); // todo this is super lazy defensive programming
            }

            JavaArray backingArray = suppressedExceptions.asObject().getField("elementData", "[Ljava/lang/Object;").asArray();
            for (int i = 0; i < backingArray.getSize(); i++) {
                JavaWrapper suppressedException = backingArray.get(i);
                if (!suppressedException.is(JavaValueType.NULL)) {
                    root.addSuppressed(convertException(suppressedException));
                }
            }
        }

        return root;
    }
}
