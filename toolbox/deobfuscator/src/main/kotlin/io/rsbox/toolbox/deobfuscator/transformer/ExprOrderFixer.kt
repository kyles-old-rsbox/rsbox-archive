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

package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.collect.MultimapBuilder
import io.rsbox.toolbox.asm.*
import io.rsbox.toolbox.deobfuscator.Transformer
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.Type.INT_TYPE
import org.objectweb.asm.Type.LONG_TYPE
import org.objectweb.asm.tree.*
import org.objectweb.asm.tree.analysis.*
import org.tinylog.kotlin.Logger
import java.math.BigInteger
import kotlin.math.absoluteValue

class ExprOrderFixer : Transformer {

    private var count = 0

    override fun run(pool: ClassPool) {
        Logger.info("Calculating euclidean multiplier decoder values...")

        val multipliers = EuclideanMultipliers(pool).calculateDecoders()
        val decoders = multipliers.decoders.mapKeys { it.key }.mapValues { it.value.toLong() }

        pool.allClasses.forEach { c ->
            c.methods.forEach { m ->
                m.maxStack += 2
                m.cancelOutMultipliers(decoders)
                m.solveConstantMath()
                m.maxStack -= 2
                count++
            }
        }

        Logger.info("Removed $count euclidean constant multipliers.")
    }

    private fun MethodNode.cancelOutMultipliers(decoders: Map<String, Long>) {
        val insnList = instructions
        for (insn in insnList.iterator()) {
            if (insn !is FieldInsnNode) continue
            if (insn.desc != INT_TYPE.descriptor && insn.desc != LONG_TYPE.descriptor) continue
            val fieldName = "${insn.owner}.${insn.name}"
            val decoder = decoders[fieldName] ?: continue
            when (insn.opcode) {
                GETFIELD, GETSTATIC -> {
                    when (insn.desc) {
                        INT_TYPE.descriptor -> {
                            when (insn.next.opcode) {
                                I2L -> insnList.append(insn.next, LdcInsnNode(Inversion.invert(decoder)), InsnNode(LMUL))
                                else -> insnList.append(insn, LdcInsnNode(Inversion.invert(decoder.toInt())), InsnNode(IMUL))
                            }
                        }
                        LONG_TYPE.descriptor -> insnList.append(insn, LdcInsnNode(Inversion.invert(decoder)), InsnNode(LMUL))
                        else -> error(insn)
                    }
                }
                PUTFIELD -> {
                    when (insn.desc) {
                        INT_TYPE.descriptor -> {
                            when (insn.previous.opcode) {
                                DUP_X1 -> {
                                    insnList.prepend(insn.previous, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                                    insnList.append(insn, LdcInsnNode(Inversion.invert(decoder.toInt())), InsnNode(IMUL))
                                }
                                DUP, DUP_X2, DUP2, DUP2_X1, DUP2_X2 -> error(insn)
                                else -> insnList.prepend(insn, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                            }
                        }
                        LONG_TYPE.descriptor -> {
                            when (insn.previous.opcode) {
                                DUP2_X1 -> {
                                    insnList.prepend(insn.previous, LdcInsnNode(decoder), InsnNode(LMUL))
                                    insnList.append(insn, LdcInsnNode(Inversion.invert(decoder)), InsnNode(LMUL))
                                }
                                DUP, DUP_X1, DUP_X2, DUP2, DUP2_X2 -> error(insn)
                                else -> insnList.prepend(insn, LdcInsnNode(decoder), InsnNode(LMUL))
                            }
                        }
                        else -> error(insn)
                    }
                }
                PUTSTATIC -> {
                    when (insn.desc) {
                        INT_TYPE.descriptor -> {
                            when (insn.previous.opcode) {
                                DUP -> {
                                    insnList.prepend(insn.previous, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                                    insnList.append(insn, LdcInsnNode(Inversion.invert(decoder.toInt())), InsnNode(IMUL))
                                }
                                DUP_X1, DUP_X2, DUP2, DUP2_X1, DUP2_X2 -> error(insn)
                                else -> insnList.prepend(insn, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                            }
                        }
                        LONG_TYPE.descriptor -> {
                            when (insn.previous.opcode) {
                                DUP2 -> {
                                    insnList.prepend(insn.previous, LdcInsnNode(decoder), InsnNode(LMUL))
                                    insnList.append(insn, LdcInsnNode(Inversion.invert(decoder)), InsnNode(LMUL))
                                }
                                DUP, DUP_X1, DUP_X2, DUP2_X1, DUP2_X2 -> error(insn)
                                else -> insnList.prepend(insn, LdcInsnNode(decoder), InsnNode(LMUL))
                            }
                        }
                        else -> error(insn)
                    }
                }
            }
        }
    }

    private fun MethodNode.solveConstantMath() {
        val insnList = instructions
        val interpreter = Inter()
        val analyzer = Analyzer(interpreter)
        analyzer.analyze(owner.name, this)
        for (mul in interpreter.constantMultiplications) {
            when (mul.insn.opcode) {
                IMUL -> associateMultiplication(insnList, mul, 1)
                LMUL -> associateMultiplication(insnList, mul, 1L)
                else -> error(mul)
            }
        }
    }

    private fun associateMultiplication(insnList: InsnList, mul: Expr.Mul, num: Int) {
        val n = num * mul.const.n.toInt()
        val other = mul.other
        when {
            other is Expr.Mul -> {
                insnList.delete(mul.insn, mul.const.insn)
                associateMultiplication(insnList, other, n)
            }
            other is Expr.Const -> {
                insnList.delete(mul.insn, mul.const.insn)
                insnList.replace(other.insn, loadInt(n * other.n.toInt()))
            }
            other is Expr.Add -> {
                insnList.delete(mul.insn, mul.const.insn)
                distributeAddition(insnList, other.a, n)
                distributeAddition(insnList, other.b, n)
            }
            n == 1 -> insnList.delete(mul.insn, mul.const.insn)
            else -> insnList.replace(mul.const.insn, loadInt(n))
        }
    }

    private fun associateMultiplication(insnList: InsnList, mul: Expr.Mul, num: Long) {
        val n = num * mul.const.n.toLong()
        val other = mul.other
        when {
            other is Expr.Mul -> {
                insnList.delete(mul.insn, mul.const.insn)
                associateMultiplication(insnList, other, n)
            }
            other is Expr.Const -> {
                insnList.delete(mul.insn, mul.const.insn)
                insnList.replace(other.insn, loadLong(n * other.n.toLong()))
            }
            other is Expr.Add -> {
                insnList.delete(mul.insn, mul.const.insn)
                distributeAddition(insnList, other.a, n)
                distributeAddition(insnList, other.b, n)
            }
            n == 1L -> insnList.delete(mul.insn, mul.const.insn)
            else -> insnList.replace(mul.const.insn, loadLong(n))
        }
    }

    private fun distributeAddition(insnList: InsnList, expr: Expr, n: Int) {
        when (expr) {
            is Expr.Const -> insnList.replace(expr.insn, loadInt(n * expr.n.toInt()))
            is Expr.Mul -> associateMultiplication(insnList, expr, n)
            else -> error(expr)
        }
    }

    private fun distributeAddition(insnList: InsnList, expr: Expr, n: Long) {
        when (expr) {
            is Expr.Const -> insnList.replace(expr.insn, loadLong(n * expr.n.toLong()))
            is Expr.Mul -> associateMultiplication(insnList, expr, n)
            else -> error(expr)
        }
    }

    private class Inter : Interpreter<Expr>(ASM6) {

        private val sourceInterpreter = SourceInterpreter()

        private val mults = LinkedHashMap<AbstractInsnNode, Expr.Mul>()

        override fun binaryOperation(insn: AbstractInsnNode, value1: Expr, value2: Expr): Expr? {
            val bv = sourceInterpreter.binaryOperation(insn, value1.sv, value2.sv) ?: return null
            if (value1 == value2) return Expr.Var(bv)
            return when (insn.opcode) {
                IMUL, LMUL -> {
                    if (value1 !is Expr.Const && value2 !is Expr.Const) {
                        Expr.Var(bv)
                    } else {
                        Expr.Mul(bv, value1, value2).also {
                            mults[insn] = it
                        }
                    }
                }
                IADD, ISUB, LADD, LSUB -> {
                    if ((value1 is Expr.Const || value1 is Expr.Mul) && (value2 is Expr.Const || value2 is Expr.Mul)) {
                        Expr.Add(bv, value1, value2)
                    } else {
                        Expr.Var(bv)
                    }
                }
                else -> Expr.Var(bv)
            }
        }

        override fun copyOperation(insn: AbstractInsnNode, value: Expr): Expr = Expr.Var(sourceInterpreter.copyOperation(insn, value.sv))

        override fun merge(value1: Expr, value2: Expr): Expr {
            if (value1 == value2) {
                return value1
            } else if (value1 is Expr.Mul && value2 is Expr.Mul && value1.insn == value2.insn) {
                if (value1.a == value2.a && value1.a is Expr.Const) {
                    return Expr.Mul(value1.sv, value1.a, merge(value1.b, value2.b)).also { mults[value1.insn] = it }
                } else if (value1.b == value2.b && value1.b is Expr.Const) {
                    return Expr.Mul(value1.sv, merge(value1.a, value2.a), value1.b).also { mults[value1.insn] = it }
                }
            } else if (value1 is Expr.Add && value2 is Expr.Add && value1.insn == value2.insn) {
                if (value1.a == value2.a && value1.a !is Expr.Var) {
                    val bb = merge(value1.b, value2.b)
                    if (bb is Expr.Const || bb is Expr.Mul) {
                        return Expr.Add(value1.sv, value1.a, bb)
                    }
                } else if (value1.b == value2.b && value2.b !is Expr.Var) {
                    val aa = merge(value1.a, value2.a)
                    if (aa is Expr.Const || aa is Expr.Mul) {
                        return Expr.Add(value1.sv, aa, value1.b)
                    }
                }
            }
            if (value1 is Expr.Mul) mults.remove(value1.insn)
            if (value2 is Expr.Mul) mults.remove(value2.insn)
            return Expr.Var(sourceInterpreter.merge(value1.sv, value2.sv))
        }

        override fun naryOperation(insn: AbstractInsnNode, values: MutableList<out Expr>): Expr? {
            return sourceInterpreter.naryOperation(insn, emptyList())?.let { Expr.Var(it) }
        }

        override fun newOperation(insn: AbstractInsnNode): Expr {
            val bv = sourceInterpreter.newOperation(insn)
            return when (insn.opcode) {
                LDC ->  {
                    val cst = (insn as LdcInsnNode).cst
                    when (cst) {
                        is Int, is Long -> Expr.Const(bv, cst as Number)
                        else -> Expr.Var(bv)
                    }
                }
                ICONST_1, LCONST_1 -> Expr.Const(bv, 1)
                ICONST_0, LCONST_0 -> Expr.Const(bv, 0)
                else -> Expr.Var(bv)
            }
        }

        override fun newValue(type: Type?): Expr? {
            return sourceInterpreter.newValue(type)?.let { Expr.Var(it) }
        }

        override fun returnOperation(insn: AbstractInsnNode, value: Expr, expected: Expr) {}

        override fun ternaryOperation(insn: AbstractInsnNode, value1: Expr, value2: Expr, value3: Expr): Expr? = null

        override fun unaryOperation(insn: AbstractInsnNode, value: Expr): Expr? {
            return sourceInterpreter.unaryOperation(insn, value.sv)?.let { Expr.Var(it) }
        }

        val constantMultiplications: Collection<Expr.Mul> get() {
            val ms = LinkedHashSet<Expr.Mul>()
            for (m in mults.values) {
                val other = m.other
                if (other is Expr.Mul) {
                    ms.remove(other)
                }
                if (other is Expr.Add && other.a is Expr.Mul) {
                    ms.remove(other.a)
                }
                if (other is Expr.Add && other.b is Expr.Mul) {
                    ms.remove(other.b)
                }
                ms.add(m)
            }
            return ms
        }
    }

    private sealed class Expr : Value {

        override fun getSize(): Int = sv.size

        abstract val sv: SourceValue

        val insn get() = sv.insns.single()

        data class Var(override val sv: SourceValue) : Expr() {

            override fun toString(): String = "(#${sv.hashCode().toString(16)})"
        }

        data class Const(override val sv: SourceValue, val n: Number) : Expr() {

            override fun toString(): String ="($n)"
        }

        data class Add(override val sv: SourceValue, val a: Expr, val b: Expr) : Expr() {

            override fun toString(): String {
                val c = if (insn.opcode == IADD || insn.opcode == LADD) '+' else '-'
                return "($a$c$b)"
            }
        }

        data class Mul(override val sv: SourceValue, val a: Expr, val b: Expr) : Expr() {

            val const get() = a as? Const ?: b as Const

            val other get() = if (const == a) b else a

            override fun toString(): String = "($a*$b)"
        }
    }

    private class EuclideanMultipliers(private val pool: ClassPool) {

        fun calculateDecoders(): Multipliers {
            val multipliers = Multipliers()
            val analyzer = Analyzer(Interpret(multipliers))

            pool.allClasses.forEach { c ->
                c.methods.forEach { m ->
                    analyzer.analyze(m.owner.name, m)
                }
            }

            multipliers.solve()

            return multipliers
        }

        private class Interpret(private val multipliers: Multipliers) : Interpreter<Valu>(ASM9) {

            private val ldcs = HashSet<Valu>()

            private val ldcs2 = HashSet<Valu>()

            private val puts = HashMap<Valu, Valu>()

            private val src = SourceInterpreter()

            override fun newValue(type: Type?) = src.newValue(type)?.let { Valu(it) }

            override fun copyOperation(insn: AbstractInsnNode, value: Valu) = when (insn.opcode) {
                DUP, DUP2, DUP2_X1, DUP_X1 -> value
                else -> Valu(src.copyOperation(insn, value.v))
            }

            override fun merge(value1: Valu, value2: Valu) = Valu(src.merge(value1.v, value2.v))

            override fun returnOperation(insn: AbstractInsnNode, value: Valu, expected: Valu) {}

            override fun ternaryOperation(insn: AbstractInsnNode, value1: Valu, value2: Valu, value3: Valu) = Valu(src.ternaryOperation(insn, value1.v, value2.v, value3.v))

            override fun naryOperation(insn: AbstractInsnNode, values: MutableList<out Valu>) = Valu(src.naryOperation(insn, values.map { it.v }))

            override fun newOperation(insn: AbstractInsnNode) = Valu(src.newOperation(insn))

            override fun unaryOperation(insn: AbstractInsnNode, value: Valu) = Valu(src.unaryOperation(insn, value.v)).also {
                if (insn.opcode == PUTSTATIC) setField(it, value)
            }

            override fun binaryOperation(insn: AbstractInsnNode, value1: Valu, value2: Valu) = Valu.Two(src.binaryOperation(insn, value1.v, value2.v), value1, value2).also {
                when (insn.opcode) {
                    IMUL, LMUL -> {
                        val fieldMul = asFieldMul(it) ?: return@also
                        if (ldcs.add(fieldMul.ldc)) {
                            multipliers.mulX.put(fieldMul.f.fieldName, Mul.dec(fieldMul.ldc.ldcNum))
                        }
                    }
                    PUTFIELD -> setField(it, value2)
                }
            }

            private fun isMultiplier(n: Number) = Inversion.isInvertible(n) && Inversion.invert(n) != n

            private fun setField(put: Valu, value: Valu) {
                puts[value] = put
                if (value.isLdcInt) {
                    //
                } else if (value is Valu.Two) {
                    distribute(put.v.insn as FieldInsnNode, value)
                }
            }

            private fun distribute(put: FieldInsnNode, value: Valu.Two) {
                if (value.isMul) {
                    val fm = asFieldMul(value)
                    if (fm != null && ldcs2.add(fm.ldc)) {
                        check(multipliers.mulX.remove(fm.f.fieldName, Mul.dec(fm.ldc.ldcNum)))
                        multipliers.decEncX.add(FieldMulAssign(put.fieldName, fm.f.fieldName, fm.ldc.ldcNum))
                        return
                    }
                }
                if (!value.isMul && !value.isAdd) return
                val a = value.a
                val b = value.b
                var ldc: Valu? = null
                var other: Valu? = null
                if (a.isLdcInt) {
                    ldc = a
                    other = b
                } else if (b.isLdcInt) {
                    ldc = b
                    other = a
                }
                if (ldc != null && other != null) {
                    val n = ldc.ldcNum
                    if (isMultiplier(n) && ldcs.add(ldc)) {
                        val getField = puts[other]
                        if (getField == null) {
                            multipliers.mulX.put(put.fieldName, Mul.enc(n))
                        } else {
                            multipliers.decEncX.add(FieldMulAssign(put.fieldName, getField.fieldName, n))
                        }
                    }
                    if (value.isMul) return
                }
                if (a is Valu.Two) distribute(put, a)
                if (b is Valu.Two) distribute(put, b)
            }

            private fun asFieldMul(value: Valu.Two): FieldMul? {
                var ldc: Valu? = null
                var get: Valu? = null
                if (value.a.isLdcInt && value.b.isGetField) {
                    ldc = value.a
                    get = value.b
                } else if (value.b.isLdcInt && value.a.isGetField) {
                    ldc = value.b
                    get = value.a
                }
                if (ldc != null && get != null) {
                    if (isMultiplier(ldc.ldcNum)) return FieldMul(get, ldc)
                }
                return null
            }

            private val Valu.isLdcInt get() = v.insn.let { it != null && it is LdcInsnNode && (it.cst is Int || it.cst is Long) }

            private val SourceValue.insn: AbstractInsnNode? get() = insns.singleOrNull()

            private val Valu.isGetField get() = v.insn.let { it != null && (it.opcode == GETSTATIC || it.opcode == GETFIELD) }

            private val Valu.ldcNum get() = v.insns.single().let { it as LdcInsnNode; it.cst as Number }

            private val FieldInsnNode.fieldName get() = "${owner}.${name}"

            private val Valu.fieldName get() = v.insns.single().let { it as FieldInsnNode; it.fieldName }

            private val Valu.isMul get() = v.insn.let { it != null && (it.opcode == IMUL || it.opcode == LMUL) }

            private val Valu.isAdd get() = v.insn.let { it != null && (it.opcode == IADD || it.opcode == LADD || it.opcode == ISUB || it.opcode == LSUB) }

            private data class FieldMul(val f: Valu, val ldc: Valu)
        }

        private open class Valu(val v: SourceValue) : Value {

            override fun equals(other: Any?) = other is Valu && v == other.v

            override fun hashCode() = v.hashCode()

            override fun getSize() = v.size

            class Two(value: SourceValue, val a: Valu, val b: Valu) : Valu(value)
        }

        private data class Mul(val dec: Boolean, val n: Number) {

            val decoder = if (dec) n else Inversion.invert(n)

            companion object {

                fun dec(n: Number) = Mul(true, n)

                fun enc(n: Number) = Mul(false, n)
            }
        }

        private data class FieldMulAssign(val put: String, val get: String, val mul: Number)

        class Multipliers {

            val decoders = HashMap<String, Number>()

            val mulX = MultimapBuilder.hashKeys().arrayListValues().build<String, Mul>()

            val decEncX = HashSet<FieldMulAssign>()

            fun solve() {
                while (true) {
                    simplify()
                    if (mulX.isEmpty) return
                    solveOne()
                }
            }

            private fun isMultiplier(n: Number) = Inversion.isInvertible(n) && Inversion.invert(n) != n

            private fun simplify() {
                val itr = decEncX.iterator()
                for (ma in itr) {
                    if (ma.put in decoders) {
                        itr.remove()
                        val dec = decoders.getValue(ma.put)
                        val decx = mul(dec, ma.mul)
                        if (isMultiplier(decx)) mulX.put(ma.get, Mul.dec(decx))
                    } else if (ma.get in decoders) {
                        itr.remove()
                        val enc = Inversion.invert(decoders.getValue(ma.get))
                        val encx = mul(enc, ma.mul)
                        if (isMultiplier(encx)) mulX.put(ma.put, Mul.enc(encx))
                    }
                }
            }

            private fun solveOne() {
                var e = mulX.asMap().entries.firstOrNull { e -> decEncX.none { it.get == e.key || it.put == e.key } }
                if (e == null) e = mulX.asMap().entries.first()
                val (f, ms) = e
                val unfoldedNumber = unfold(ms)
                if(unfoldedNumber == Int.MAX_VALUE) {
                    Logger.warn("Failed to calculate multiplier decoder value. Field: $f, Multipliers: ${e.value.joinToString(", ") { it.n.toString() + ":" + it.decoder }}.")
                    mulX.removeAll(f)
                } else {
                    decoders[f] = unfold(ms)
                    mulX.removeAll(f)
                }
            }

            private fun unfold(ms: Collection<Mul>): Number {
                val distinct = ms.distinct()
                if (distinct.size == 1) return distinct.single().decoder
                val pairs = distinct.filter { a -> a.dec && distinct.any { b -> !b.dec && a.decoder == b.decoder } }
                if (pairs.isNotEmpty()) return pairs.single().decoder
                val fs = distinct.filter { f -> distinct.all { isFactor(it, f) } }
                if (fs.size == 1) return fs.single().decoder
                if(fs.isEmpty()) {
                    distinct.forEach { mul ->

                    }
                }
                return fs.first { it.dec }.decoder
            }

            private fun isFactor(product: Mul, factor: Mul) = div(product, factor).toLong().absoluteValue <= 0xff

            private fun div(a: Mul, b: Mul): Number {
                return if (a.dec == b.dec) {
                    mul(Inversion.invert(b.n), a.n)
                } else {
                    mul(b.n, a.n)
                }
            }

            private fun mul(a: Number, b: Number): Number = when (a) {
                is Int -> a.toInt() * b.toInt()
                is Long -> a.toLong() * b.toLong()
                else -> error(a)
            }
        }
    }

    object Inversion {

        private val SHIFT_32 = BigInteger.ONE.shiftLeft(32)
        private val SHIFT_64 = BigInteger.ONE.shiftLeft(64)

        fun invert(n: Int): Int = n.toBigInteger().modInverse(SHIFT_32).toInt()

        fun invert(n: Long): Long = n.toBigInteger().modInverse(SHIFT_64).toLong()

        fun invert(n: Number): Number {
            return when (n) {
                is Int -> invert(n)
                is Long -> invert(n)
                else -> error(n)
            }
        }

        fun isInvertible(n: Int): Boolean = n and 1 == 1

        fun isInvertible(n: Long): Boolean = isInvertible(n.toInt())

        fun isInvertible(n: Number): Boolean {
            return when (n) {
                is Int, is Long -> isInvertible(n.toInt())
                else -> error(n)
            }
        }
    }

    fun AbstractInsnNode.isIf(): Boolean {
        return this is JumpInsnNode && opcode != GOTO
    }

    fun AbstractInsnNode.isReturn(): Boolean = when(opcode) {
        in IRETURN..RETURN -> true
        else -> false
    }

    fun AbstractInsnNode.pushesInt(): Boolean = when(opcode) {
        LDC -> (this as LdcInsnNode).cst is Int
        SIPUSH, BIPUSH -> true
        in ICONST_M1..ICONST_5 -> true
        else -> false
    }

    val AbstractInsnNode.pushedInt: Int get() = when {
        opcode in 2..8 -> opcode - 3
        opcode == BIPUSH || opcode == SIPUSH -> (this as IntInsnNode).operand
        this is LdcInsnNode && cst is Int -> cst as Int
        else -> throw IllegalStateException()
    }

    fun loadInt(n: Int): AbstractInsnNode = when (n) {
        in -1..5 -> InsnNode(n + 3)
        in Byte.MIN_VALUE..Byte.MAX_VALUE -> IntInsnNode(BIPUSH, n)
        in Short.MIN_VALUE..Short.MAX_VALUE -> IntInsnNode(SIPUSH, n)
        else -> LdcInsnNode(n)
    }

    fun loadLong(n: Long): AbstractInsnNode = when (n) {
        0L, 1L -> InsnNode((n + 9).toInt())
        else -> LdcInsnNode(n)
    }
}