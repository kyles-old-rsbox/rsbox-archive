package io.rsbox.toolbox.deobfuscator.transformer

import com.google.common.collect.HashMultiset
import com.google.common.collect.MultimapBuilder
import io.rsbox.toolbox.deobfuscator.Transformer
import io.rsbox.toolbox.deobfuscator.asm.ClassPool
import io.rsbox.toolbox.deobfuscator.asm.append
import io.rsbox.toolbox.deobfuscator.asm.identifier
import io.rsbox.toolbox.deobfuscator.asm.prepend
import io.rsbox.toolbox.deobfuscator.transformer.MultiplierRemover.MulMath.isFactor
import io.rsbox.toolbox.deobfuscator.transformer.MultiplierRemover.MulMath.isMultiplier
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type
import org.objectweb.asm.Type.INT_TYPE
import org.objectweb.asm.Type.LONG_TYPE
import org.objectweb.asm.tree.*
import org.objectweb.asm.tree.analysis.*
import org.objectweb.asm.util.Printer
import org.tinylog.kotlin.Logger
import java.math.BigInteger
import kotlin.math.absoluteValue

class MultiplierRemover : Transformer {

    private val multipliers = Multipliers()

    override fun run(pool: ClassPool) {
        findMultiplierDecoders(pool)
        removeMultiplierEncoders(pool)
    }

    /**
     * ===== MULTIPLIER FINDER =====
     */

    private fun findMultipliers(pool: ClassPool) {
        Logger.info("Analyzing method multipliers...")

        val interp = MulFinderInterpreter(multipliers)
        val analyzer = Analyzer(interp)

        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                try { analyzer.analyze(cls.name, method) }
                catch(e: Exception) {
                    Logger.warn(e, "Failed to analyze method: ${method.identifier}.")
                }
            }
        }

        /*
         * Solve the multipliers which were just found in the
         * multiplier analyzer.
         */
        multipliers.calculate()

        Logger.info("Found ${interp.puts.values.size} multipliers. Computed down to ${multipliers.decoders.values.size} unique multipliers.")
    }

    class Multipliers {

        val unsolved = MultimapBuilder.hashKeys().arrayListValues().build<String, Multiplier>()
        val solved = hashSetOf<Triple<String, String, Number>>()
        val decoders = hashMapOf<String, Number>()

        /**
         * This function recursively attempts to solve one "solvedEncoder" to get the
         * solvedDecoder pair each iteration. It does this until it cant solve anything else
         * in the unsolved multiplier map.
         */
        fun calculate() {
            while(true) {
                /*
                 * Try to get any new unsolved multipliers which
                 * were folded the last iteration.
                 */
                computeUnsolved()

                /*
                 * Pog, We are done!
                 */
                if(unsolved.isEmpty) {
                    return
                }
                // Compute one level of a decoder's multiplicative inverse number
                computeDecoder()
            }
        }

        private fun computeUnsolved() {
            val it = solved.iterator()
            for(fieldMul in it) {
                if(fieldMul.first in decoders) {
                    it.remove()
                    val number = decoders.getValue(fieldMul.first)
                    val decodedNumber = MulMath.multiply(number, fieldMul.third)
                    if(decodedNumber.isMultiplier()) {
                        unsolved.put(fieldMul.second, Multiplier.Decoder(decodedNumber))
                    }
                } else if(fieldMul.second in decoders) {
                    it.remove()
                    val number = MulMath.invert(decoders.getValue(fieldMul.second))
                    val encodedNumber = MulMath.multiply(number, fieldMul.third)
                    if(encodedNumber.isMultiplier()) {
                        unsolved.put(fieldMul.first, Multiplier.Encoder(encodedNumber))
                    }
                }
            }
        }

        private fun computeDecoder() {
            var mul = unsolved.asMap().entries.firstOrNull { m -> solved.none { it.second == m.key || it.first == m.key} }
            if(mul == null) {
               mul = unsolved.asMap().entries.first()
            }

            val field = mul.key
            val numbers = mul.value

            /*
             * Now we need to unfold the numbers so that we can associate the proper decoder value to
             * a given multiplier field.
             *
             * We do this by checking if any of the other solved decoders are factors of the one we
             * are trying to solve.
             */

            /*
             * Now we have tried our best to unfold and compute the field's decoder value,
             * We can store it as a solved field decoder. We also need to remove any unsolved multipliers which
             * are associated with the "field" since we have successfully computed the decoder to reverse/remove it.
             */
            calculateMulNumbers(numbers)?.let { decoders[field] = it } ?: run {
                Logger.warn("Failed to calculate multiplier. Field: $field, Multipliers: (${numbers.distinct().joinToString(", ") { "${it.number}:${it.decoderNumber}" }}).")
            }
            unsolved.removeAll(field)
        }

        private fun calculateMulNumbers(muls: Collection<Multiplier>): Number? {
            val uniqueMuls = muls.distinct()
            if(uniqueMuls.size == 1) {
                return uniqueMuls.single().decoderNumber
            }

            val pairs = uniqueMuls.filter { a ->
                a.isDecoder() && uniqueMuls.any { b ->
                    !b.isDecoder() && a.decoderNumber == b.decoderNumber
                }
            }
            if(pairs.isNotEmpty()) {
                return pairs.single().decoderNumber
            }

            val factors = uniqueMuls.filter { f -> uniqueMuls.all { it.isFactor(f) } }
            if(factors.size == 1) {
                return factors.single().decoderNumber
            }
            return factors.firstOrNull { it.isDecoder() }?.decoderNumber
        }
    }

    sealed class Multiplier {
        abstract val number: Number
        abstract val decoderNumber: Number

        data class Encoder(override val number: Number) : Multiplier() {
            override val decoderNumber: Number = MulMath.invert(number)
        }


        data class Decoder(override val number: Number) : Multiplier() {
            override val decoderNumber: Number = number
        }

        fun isDecoder() = this is Decoder
        fun isEncoder() = this is Encoder
    }

    open class MulValue(val src: SourceValue) : Value {
        override fun getSize(): Int = src.size
        override fun toString(): String = "Expr(${Printer.OPCODES[src.insns.first().opcode]})"
        override fun hashCode(): Int = src.hashCode()
        override fun equals(other: Any?): Boolean = other is MulValue && other.src == src

        class Two(src: SourceValue, val left: MulValue, val right: MulValue) : MulValue(src) {
            override fun toString(): String = "Expr.Two(${Printer.OPCODES[src.insns.first().opcode]}, left: ${Printer.OPCODES[left.src.insns.first().opcode]}, right: ${Printer.OPCODES[right.src.insns.first().opcode]})"
        }
    }

    class MulFinderInterpreter(private val multipliers: Multipliers) : Interpreter<MulValue>(ASM9) {

        private val interp = SourceInterpreter()

        internal val puts = hashMapOf<MulValue, MulValue>()
        private val unsolvedMulNumbers = hashSetOf<MulValue>()
        private val solvedMulNumbers = hashSetOf<MulValue>()

        override fun newValue(type: Type?) = interp.newValue(type)?.let { MulValue(it) }

        override fun newOperation(insn: AbstractInsnNode) = MulValue(interp.newOperation(insn))

        override fun merge(value1: MulValue, value2: MulValue) = MulValue(interp.merge(value1.src, value2.src))

        override fun returnOperation(insn: AbstractInsnNode, value: MulValue, expected: MulValue) {}

        override fun naryOperation(insn: AbstractInsnNode, values: MutableList<out MulValue>) = MulValue(interp.naryOperation(insn, values.map { it.src }))

        override fun ternaryOperation(insn: AbstractInsnNode, value1: MulValue, value2: MulValue, value3: MulValue) = MulValue(interp.ternaryOperation(insn, value1.src, value2.src, value3.src))

        override fun binaryOperation(insn: AbstractInsnNode, value1: MulValue, value2: MulValue) = MulValue.Two(interp.binaryOperation(insn, value1.src, value2.src), value1, value2).also {
            when(insn.opcode) {
                IMUL, LMUL -> {
                    val getter = asGetterMul(it) ?: return@also
                    if(unsolvedMulNumbers.add(getter.second)) {
                        multipliers.unsolved.put(getter.first.fieldIdentifier, Multiplier.Decoder(getter.second.mulNumber))
                    }
                }
                PUTFIELD -> {
                    puts[value2] = it
                    if(!value2.isMulNumber() && value2 is MulValue.Two) {
                        computeGetters(it.src.insn as FieldInsnNode, value2)
                    }
                }
            }
        }

        override fun unaryOperation(insn: AbstractInsnNode, value: MulValue) = MulValue(interp.unaryOperation(insn, value.src)).also {
            if(insn.opcode == PUTSTATIC) {
                puts[value] = it
                if(!value.isMulNumber() && value is MulValue.Two) {
                    computeGetters(it.src.insn as FieldInsnNode, value)
                }
            }
        }

        override fun copyOperation(insn: AbstractInsnNode, value: MulValue) = when(insn.opcode) {
            DUP, DUP2, DUP_X1, DUP2_X1 -> value
            else -> MulValue(interp.copyOperation(insn, value.src))
        }

        private fun asGetterMul(value: MulValue.Two): Pair<MulValue, MulValue>? {
            var ldc: MulValue? = null
            var getter: MulValue? = null
            if(value.left.isMulNumber() && value.right.isGetField()) {
                ldc = value.left
                getter = value.right
            } else if(value.right.isMulNumber() && value.left.isGetField()) {
                ldc = value.right
                getter = value.left
            }
            if(ldc != null && getter != null) {
                if(ldc.mulNumber.isMultiplier()) {
                    return getter to ldc
                }
            }
            return null
        }

        /**
         * Handle when a PUTFIELD has nested expressions inside it.
         * E.g. field1 = field2 * -2390482029 + field3 * 32743981
         *
         * We want to check if its not field2 * field3 but rather some other expr times a multiplier
         * constant. If it is. We can record it as a getter for the associated other expr.
         *
         * We keep doing this till eventually we reach a getter field which we can record in order
         * to try to match up encoder multiplier to the decoder multiplier.
         */
        private fun computeGetters(putFieldInsn: FieldInsnNode, value: MulValue.Two) {
            /*
             * If the PUTFIELD value is a multiplication expression. this means its a root level decoder
             * of the associated field.
             *
             * We can get the field's multiplier number and check if been seen before associated with the
             * field. If it has, we can mark it as a solved decoder.
             */
            if(value.isMultiplication()) {
                val getter = asGetterMul(value)
                if(getter != null && solvedMulNumbers.add(getter.second)) {
                    /*
                     * We can remove the multiplier number from unsolved mul map.
                     */
                    if(!multipliers.unsolved.remove(getter.first.fieldIdentifier, Multiplier.Decoder(getter.second.mulNumber))) {
                        throw IllegalStateException("Some shit really is not right. Have fun.")
                    }
                    multipliers.solved.add(Triple(putFieldInsn.identifier, getter.first.fieldIdentifier, getter.second.mulNumber))
                    return
                }
            }

            /*
             * Here we handle nested multiplier expressions by checking if its <number> * field
             * If it's not, we just record the number as a "getter" in the list.
             * If we run into a number which we have seen already as a getter, thats fine.
             *
             * Eventually once we see field * number we know this is the rootLevel decoder. Therefor
             * we check if we know the encoder number for the field by checking "fieldSetters" list.
             *
             * If we know both, we now know the encoder and decoder number for the field and we can solve
             * the multiplicative inverse for them and successfully remove it for the given field.
             */
            if(!value.isMultiplication() && !value.isAddition() && !value.isSubtraction()) {
                return
            }

            val left = value.left
            val right = value.right

            var ldc: MulValue? = null
            var other: MulValue? = null

            if(left.isMulNumber()) {
                ldc = left
                other = right
            } else if(right.isMulNumber()) {
                ldc = right
                other = left
            }

            if(ldc != null && other != null) {
                val mulNumber = ldc.mulNumber
                if(mulNumber.isMultiplier() && unsolvedMulNumbers.add(ldc)) {
                    /*
                     * If we have both the getter and setter multiplier numbers (when "setter" != null)
                     * we can add it as a solved field mul pair.
                     *
                     * Otherwise, we just record the mul number in the unsolved multipliers map. But since its not
                     * been found as a putter, we know that its folded so even tho its a getter it's still and encoder
                     * for the folded expression.
                     */
                    val getter = puts[other]
                    if(getter == null) {
                        multipliers.unsolved.put(putFieldInsn.identifier, Multiplier.Encoder(mulNumber))
                    } else {
                        multipliers.solved.add(Triple(putFieldInsn.identifier, getter.fieldIdentifier, mulNumber))
                    }
                }

                if(value.isMultiplication()) {
                    return
                }
            }

            /*
             * Now we should continue computing getters recursively if the
             * PUTFIELD instruction has multiple usages with different multipliers.
             */
            if(left is MulValue.Two) computeGetters(putFieldInsn, left)
            if(right is MulValue.Two) computeGetters(putFieldInsn, right)
        }

        val SourceValue.insn: AbstractInsnNode? get() = insns.singleOrNull()
        val FieldInsnNode.identifier: String get() = "$owner.$name"
        val MulValue.fieldIdentifier: String get() = src.insns.single().let { it as FieldInsnNode; it.identifier }
        fun MulValue.isMultiplication() = src.insn.let { it != null && it.opcode in listOf(IMUL, LMUL) }
        fun MulValue.isAddition() = src.insn.let { it != null && it.opcode in listOf(IADD, LADD) }
        fun MulValue.isSubtraction() = src.insn.let { it != null && it.opcode in listOf(ISUB, LSUB) }
        fun MulValue.isGetField() = src.insn.let { it != null && it.opcode in listOf(GETFIELD, GETSTATIC) }
        fun MulValue.isPutField() = src.insn.let { it != null && it.opcode in listOf(PUTFIELD, PUTSTATIC) }
        fun MulValue.isMulNumber() = src.insn.let { it != null && it is LdcInsnNode && (it.cst is Int || it.cst is Long) }
        val MulValue.mulNumber get() = src.insn.let { it as LdcInsnNode; it.cst as Number }
    }



    /**
     * ===== MULTIPLIER REMOVER =====
     */

    private fun removeMultipliers(pool: ClassPool) {
        Logger.info("Removing computed multipliers...")

        val decoders = multipliers.decoders.mapValues { it.value.toLong() }
        pool.classes.forEach { cls ->
            cls.methods.forEach { method ->
                method.maxStack += 2
                removeMethodMultipliers(method, decoders)
                method.maxStack -= 2
            }
        }

        Logger.info("All computed multipliers has been successfully removed.")
    }

    private fun removeMethodMultipliers(method: MethodNode, decoders: Map<String, Long>) {
        val insns = method.instructions
        for(insn in insns.iterator()) {
            if(insn !is FieldInsnNode) continue
            if(insn.desc != INT_TYPE.descriptor && insn.desc != LONG_TYPE.descriptor) continue
            val fieldIdentifier = "${insn.owner}.${insn.name}"
            val decoder = decoders[fieldIdentifier] ?: continue
            when(insn.opcode) {
                GETSTATIC, GETFIELD -> when(insn.desc) {
                    INT_TYPE.descriptor -> {
                        when(insn.next.opcode) {
                            I2L -> insns.append(insn.next, LdcInsnNode(MulMath.invert(decoder)), InsnNode(LMUL))
                            else -> insns.append(insn, LdcInsnNode(MulMath.invert(decoder.toInt())), InsnNode(IMUL))
                        }
                    }
                    LONG_TYPE.descriptor -> insns.append(insn, LdcInsnNode(MulMath.invert(decoder)), InsnNode(LMUL))
                    else -> throw RuntimeException()
                }
                PUTFIELD -> when(insn.desc) {
                    INT_TYPE.descriptor -> when(insn.previous.opcode) {
                        DUP_X1 -> {
                            insns.prepend(insn.previous, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                            insns.append(insn, LdcInsnNode(MulMath.invert(decoder.toInt())), InsnNode(IMUL))
                        }
                        DUP, DUP2, DUP_X2, DUP2_X1, DUP2_X2 -> throw RuntimeException()
                        else -> insns.prepend(insn, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                    }
                    LONG_TYPE.descriptor -> when(insn.previous.opcode) {
                        DUP2_X1 -> {
                            insns.prepend(insn.previous, LdcInsnNode(decoder), InsnNode(LMUL))
                            insns.append(insn, LdcInsnNode(MulMath.invert(decoder)), InsnNode(LMUL))
                        }
                        DUP, DUP_X1, DUP_X2, DUP2, DUP2_X2 -> throw RuntimeException()
                        else -> insns.prepend(insn, LdcInsnNode(decoder), InsnNode(LMUL))
                    }
                    else -> throw RuntimeException()
                }
                PUTSTATIC-> when(insn.desc) {
                    INT_TYPE.descriptor -> when(insn.previous.opcode) {
                        DUP -> {
                            insns.prepend(insn.previous, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                            insns.append(insn, LdcInsnNode(MulMath.invert(decoder.toInt())), InsnNode(IMUL))
                        }
                        DUP_X1, DUP_X2, DUP2, DUP2_X1, DUP2_X2 -> throw RuntimeException()
                        else -> insns.prepend(insn, LdcInsnNode(decoder.toInt()), InsnNode(IMUL))
                    }
                    LONG_TYPE.descriptor -> when(insn.previous.opcode) {
                        DUP2 -> {
                            insns.prepend(insn.previous, LdcInsnNode(decoder), InsnNode(LMUL))
                            insns.append(insn, LdcInsnNode(MulMath.invert(decoder)), InsnNode(LMUL))
                        }
                        DUP, DUP_X1, DUP_X2, DUP2_X1, DUP2_X2 -> throw RuntimeException()
                        else -> insns.prepend(insn, LdcInsnNode(decoder), InsnNode(LMUL))
                    }
                    else -> throw RuntimeException()
                }
            }
        }
    }

    /**
     * ===== OTHER UTILS =====
     */

    private object MulMath {

        private val SHIFT_32 = BigInteger.ONE.shiftLeft(32)
        private val SHIFT_64 = BigInteger.ONE.shiftLeft(64)

        fun invert(value: Int) = value.toBigInteger().modInverse(SHIFT_32).toInt()

        fun invert(value: Long) = value.toBigInteger().modInverse(SHIFT_64).toLong()

        fun invert(value: Number): Number = when(value) {
            is Int -> invert(value)
            is Long -> invert(value)
            else -> throw IllegalArgumentException()
        }

        fun isInvertible(value: Int) = value and 1 == 1

        fun isInvertible(value: Long) = isInvertible(value.toInt())

        fun isInvertible(value: Number) = when(value) {
            is Int -> isInvertible(value)
            is Long -> isInvertible(value)
            else -> throw IllegalArgumentException()
        }

        fun Number.isMultiplier() = MulMath.isInvertible(this) && MulMath.invert(this) != this

        fun multiply(left: Number, right: Number): Number = when(left) {
            is Int -> left.toInt() * right.toInt()
            is Long -> left.toLong() * right.toLong()
            else -> throw IllegalArgumentException()
        }

        fun divide(left: Multiplier, right: Multiplier): Number {
            return if(left.isDecoder() == right.isDecoder()) {
                multiply(invert(right.number), left.number)
            } else {
                multiply(right.number, left.number)
            }
        }

        fun Multiplier.isFactor(factor: Multiplier) = divide(this, factor).toLong().absoluteValue <= 0xff
    }

    private fun findMultiplierDecoders(pool: ClassPool) {}
    private fun removeMultiplierEncoders(pool: ClassPool) {}
}