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

package io.rsbox.server.util.buffer

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.util.ByteProcessor
import java.io.IOException
import java.nio.charset.Charset
import kotlin.math.pow

/**
 * Converts a netty [ByteBuf] to a [JagByteBuf]
 * @receiver ByteBuf
 * @return JagByteBuf
 */
fun ByteBuf.toJagBuf(): JagByteBuf = JagByteBuf(this)

/**
 * A wrapper of the netty [ByteBuf] which provides endian and transform supports which Jagex uses as buffer
 * obfuscation in their Old School RuneScape client.
 *
 * Additionally, this wrapper class provides easy to use bit-mode access to be able to directly read and write bits
 * from the buffer.
 *
 * @property buffer ByteBuf
 * @constructor
 */
class JagByteBuf(private val buffer: ByteBuf = Unpooled.buffer()) {

    private var writerBitIndex = 0
    private var readerBitIndex = 0
    private var writerMode: AccessMode = BYTE_ACCESS
    private var readerMode: AccessMode = BYTE_ACCESS

    fun release() = buffer.release()

    fun readerIndex() = buffer.readerIndex()

    fun writerIndex() = buffer.writerIndex()

    fun readerIndex(index: Int) = buffer.readerIndex(index)

    fun writerIndex(index: Int) = buffer.writerIndex(index)

    /**
     * The number of bytes written to buffer.
     * @return Int
     */
    fun readableBytes(): Int = buffer.readableBytes()

    /**
     * The number of bytes remaining on the buffer.
     * @return Int
     */
    fun writeableBytes(): Int = buffer.writableBytes()

    /**
     * Converts this [JagByteBuf] back to a standard netty [ByteBuf]
     * @return ByteBuf
     */
    fun toByteBuf(): ByteBuf = buffer

    /**
     * Sets the writer mode to either BIT or BYTE access.
     * @param accessMode AccessMode
     */
    fun switchWriteAccess(accessMode: AccessMode) {
        when(accessMode) {
            is BYTE_ACCESS -> {
                if(writerMode === BYTE_ACCESS) return
                writerMode = BYTE_ACCESS
                buffer.writerIndex((writerBitIndex + 7) / 8)
            }
            is BIT_ACCESS -> {
                if(writerMode === BIT_ACCESS) return
                writerMode = BIT_ACCESS
                writerBitIndex = buffer.writerIndex() * 8
            }
        }
    }

    /**
     * Sets the reader mode to either BIT or BYTE access.
     * @param accessMode AccessMode
     */
    fun switchReadAccess(accessMode: AccessMode) {
        when(accessMode) {
            is BYTE_ACCESS -> {
                if(readerMode === BYTE_ACCESS) return
                readerMode = BYTE_ACCESS
                buffer.readerIndex((readerBitIndex + 7) / 8)
            }
            is BIT_ACCESS -> {
                if(readerMode === BIT_ACCESS) return
                readerMode = BIT_ACCESS
                readerBitIndex = buffer.readerIndex() * 8
            }
        }
    }

    /**
     * =========================================================
     * = WRITER METHODS
     * =========================================================
     */

    fun writeByte(value: Number, endian: DataEndian = BIG, transform: DataTransform = NONE) {
        write(BYTE, endian, transform, value)
    }

    fun writeShort(value: Number, endian: DataEndian = BIG, transform: DataTransform = NONE) {
        write(SHORT, endian, transform, value)
    }

    fun writeMedium(value: Number, endian: DataEndian = BIG, transform: DataTransform = NONE) {
        write(MEDIUM, endian, transform, value)
    }

    fun writeInt(value: Number, endian: DataEndian = BIG, transform: DataTransform = NONE) {
        write(INT, endian, transform, value)
    }

    fun writeLong(value: Number, endian: DataEndian = BIG, transform: DataTransform = NONE) {
        write(LONG, endian, transform, value)
    }

    fun writeSmart(value: Int) {
        if(value >= 0x80) {
            buffer.writeShort(value + 0x8000)
        } else {
            buffer.writeByte(value)
        }
    }

    fun writeString(value: String, charset: Charset = CP1252) {
        buffer.writeCharSequence(value, charset)
        buffer.writeByte(0)
    }

    fun writeJagString(value: String, charset: Charset = CP1252) {
        buffer.writeByte(0)
        writeString(value, charset)
    }

    fun writeBytes(bytes: ByteArray) {
        buffer.writeBytes(bytes)
    }

    fun writeBytes(bytes: ByteArray, position: Int, length: Int) {
        for(i in position until position + length) {
            buffer.writeByte(bytes[i].toInt())
        }
    }

    fun writeBytes(bytes: ByteArray, transform: DataTransform = NONE) {
        if(transform == NONE) {
            writeBytes(bytes)
        } else {
            for(b in bytes) {
                write(BYTE, BIG, transform, b)
            }
        }
    }

    fun writeBytes(bytes: ByteArray, position: Int, length: Int, transform: DataTransform = NONE) {
        for(i in position until position + length) {
            write(BYTE, BIG, transform, bytes[i].toInt())
        }
    }

    fun writeBytes(buffer: ByteBuf) {
        val bytes = ByteArray(buffer.readableBytes())
        buffer.markReaderIndex()
        try {
            buffer.readBytes(bytes)
        } finally {
            buffer.resetReaderIndex()
        }
        writeBytes(bytes)
    }

    fun writeBytesReversed(bytes: ByteArray) {
        for(i in bytes.indices.reversed()) {
            buffer.writeByte(bytes[i].toInt())
        }
    }

    fun writeBytesReversed(bytes: ByteArray, transform: DataTransform = NONE) {
        if(transform == NONE) {
            writeBytesReversed(bytes)
        } else {
            for(i in bytes.indices.reversed()) {
                write(BYTE, BIG, transform, bytes[i])
            }
        }
    }

    fun writeBytesReversed(buffer: ByteBuf) {
        val bytes = ByteArray(buffer.readableBytes())
        buffer.markReaderIndex()
        try {
            buffer.readBytes(bytes)
        } finally {
            buffer.resetReaderIndex()
        }
        writeBytesReversed(bytes)
    }

    fun writeBit(value: Int) {
        writeBits(value, 1)
    }

    fun writeBoolean(flag: Boolean) {
        writeBit(if(flag) 1 else 0)
    }

    private fun write(type: DataType, endian: DataEndian, transform: DataTransform, value: Number) {
        if(type == SMART) {
            writeSmart(value.toInt())
            return
        }

        if(writerMode != BYTE_ACCESS) throw IllegalStateException("Can not write bytes while in BIT_ACCESS mode.")
        val longValue = value.toLong()
        val length = type.size
        when(endian) {
            BIG -> for(i in length - 1 downTo 0) {
                if(i == 0 && transform != NONE) {
                    when (transform) {
                        ADD -> buffer.writeByte((longValue + 128).toByte().toInt())
                        NEG -> buffer.writeByte((-longValue).toByte().toInt())
                        SUB -> buffer.writeByte((128 - longValue).toByte().toInt())
                        else -> throw IllegalArgumentException("Unknown transformation type.")
                    }
                } else {
                    buffer.writeByte((longValue shr i * 8).toByte().toInt())
                }
            }
            LITTLE -> for(i in 0 until length) {
                if(i == 0 && transform != NONE) {
                    when(transform) {
                        ADD -> buffer.writeByte((longValue + 128).toByte().toInt())
                        NEG -> buffer.writeByte((-longValue).toByte().toInt())
                        SUB -> buffer.writeByte((128 - longValue).toByte().toInt())
                        else -> throw IllegalArgumentException("Unknown transformation type.")
                    }
                } else {
                    buffer.writeByte((longValue shr i * 8).toByte().toInt())
                }
            }
            MIDDLE -> {
                if(transform != NONE) throw IllegalArgumentException("Middle endian can not have a transformation.")
                if(type != INT) throw IllegalArgumentException("Middle endian only supports Integer data types.")
                buffer.writeByte((longValue shr 8).toByte().toInt())
                buffer.writeByte(longValue.toByte().toInt())
                buffer.writeByte((longValue shr 24).toByte().toInt())
                buffer.writeByte((longValue shr 16).toByte().toInt())
            }
            INVERSE_MIDDLE -> {
                if(transform != NONE) throw IllegalArgumentException("Inverse Middle endian can not have a transformation.")
                if(type != INT) throw IllegalArgumentException("Inverse Middle endian only supports Integer data types.")
                buffer.writeByte((longValue shr 16).toByte().toInt())
                buffer.writeByte((longValue shr 24).toByte().toInt())
                buffer.writeByte(longValue.toByte().toInt())
                buffer.writeByte((longValue shr 8).toByte().toInt())
            }
        }
    }

    fun writeBits(value: Int, count: Int) {
        var numberOfBits = count
        if(numberOfBits !in 1..32) throw IllegalArgumentException("Can not write more than 32 bits at a time.")
        if(writerMode !== BIT_ACCESS) throw IllegalStateException("Can not write bits while in BYTE_ACCESS mode.")

        var byteOffset = writerBitIndex shr 3
        var bitOffset = 8 - (writerBitIndex and 7)
        writerBitIndex += numberOfBits

        var requiredSlots = byteOffset - buffer.writerIndex() + 1
        requiredSlots += (numberOfBits + 7) / 8
        buffer.ensureWritable(requiredSlots)

        while(numberOfBits > bitOffset) {
            var bitValue = buffer.getByte(byteOffset).toInt()
            bitValue = bitValue and BIT_MASK[bitOffset].inv()
            bitValue = bitValue or (value shr numberOfBits - bitOffset and BIT_MASK[bitOffset])
            buffer.setByte(byteOffset++, bitValue)
            numberOfBits -= bitOffset
            bitOffset = 8
        }

        var bitValue = buffer.getByte(byteOffset).toInt()
        if(numberOfBits == bitOffset) {
            bitValue = bitValue and BIT_MASK[bitOffset].inv()
            bitValue = bitValue or (value and BIT_MASK[bitOffset])
            buffer.setByte(byteOffset, bitValue)
        } else {
            bitValue = bitValue and (BIT_MASK[numberOfBits] shl bitOffset - numberOfBits).inv()
            bitValue = bitValue or (value and BIT_MASK[numberOfBits] shl bitOffset - numberOfBits)
            buffer.setByte(byteOffset, bitValue)
        }
    }

    /**
     * =========================================================
     * = READER METHODS
     * =========================================================
     */

    fun readUnsignedByte(endian: DataEndian = BIG, transform: DataTransform = NONE): Short {
        return readUnsigned(BYTE, endian, transform).toShort()
    }

    fun readUnsignedShort(endian: DataEndian = BIG, transform: DataTransform = NONE): Int {
        return readUnsigned(SHORT, endian, transform).toInt()
    }

    fun readUnsignedMedium(endian: DataEndian = BIG, transform: DataTransform = NONE): Int {
        return readUnsigned(MEDIUM, endian, transform).toInt()
    }

    fun readUnsignedInt(endian: DataEndian = BIG, transform: DataTransform = NONE): Long {
        return readUnsigned(INT, endian, transform)
    }

    fun readByte(endian: DataEndian = BIG, transform: DataTransform = NONE): Byte {
        return readSigned(BYTE, endian, transform).toByte()
    }

    fun readShort(endian: DataEndian = BIG, transform: DataTransform = NONE): Short {
        return readSigned(SHORT, endian, transform).toShort()
    }

    fun readMedium(endian: DataEndian = BIG, transform: DataTransform = NONE): Int {
        return readSigned(MEDIUM, endian, transform).toInt()
    }

    fun readInt(endian: DataEndian = BIG, transform: DataTransform = NONE): Int {
        return readSigned(INT, endian, transform).toInt()
    }

    fun readLong(endian: DataEndian = BIG, transform: DataTransform = NONE): Long {
        return readSigned(LONG, endian, transform)
    }

    fun readSmart(): Int {
        val peek = buffer.getByte(buffer.readerIndex()).toInt()
        return if(peek < 0x80) {
            buffer.readByte().toInt()
        } else buffer.readShort() - 0x8000
    }

    fun readSignedSmart(): Int {
        val peek = buffer.getByte(buffer.readerIndex()).toInt()
        return if(peek < 0x80) {
            buffer.readByte() - 0x40
        } else buffer.readShort() - 0xC000
    }

    fun readString(charset: Charset = CP1252): String {
        val end = buffer.forEachByte(ByteProcessor.FIND_NUL)
        if(end == -1) throw IOException("String is missing null terminator byte.")
        val value = buffer.toString(buffer.readerIndex(), end - buffer.readerIndex(), charset)
        buffer.readerIndex(end + 1)
        return value
    }

    fun readJagString(charset: Charset = CP1252): String {
        val start = buffer.readUnsignedByte().toInt()
        if(start != 0) throw IOException("String is missing the starting null byte")
        return readString(charset)
    }

    fun readBytes(bytes: ByteArray) {
        for(i in bytes.indices) {
            bytes[i] = buffer.readByte()
        }
    }

    fun readBytes(bytes: ByteArray, transform: DataTransform = NONE) {
        if(transform == NONE) {
            readBytesReversed(bytes)
        } else {
            for(i in bytes.indices) {
                bytes[i] = readSigned(BYTES, BIG, transform).toByte()
            }
        }
    }

    fun readBytesReversed(bytes: ByteArray) {
        for(i in bytes.indices.reversed()) {
            bytes[i] = buffer.readByte()
        }
    }

    fun readBytesReversed(bytes: ByteArray, transform: DataTransform = NONE) {
        if(transform == NONE) {
            readBytesReversed(bytes)
        } else {
            for(i in bytes.indices.reversed()) {
                bytes[i] = readSigned(BYTE, BIG, transform).toByte()
            }
        }
    }

    fun readBit(): Int = readBits(1)

    fun readBoolean(): Boolean = readBit() == 1

    private fun read(type: DataType, endian: DataEndian, transform: DataTransform): Long {
        if(readerMode != BYTE_ACCESS) throw IllegalStateException("Can not read bytes while in BIT_ACCESS mode.")
        var longValue: Long = 0
        val length = type.size
        when(endian) {
            BIG -> for(i in length - 1 downTo 0) {
                longValue = if(i == 0 && transform != NONE) {
                    when(transform) {
                        ADD -> longValue or ((buffer.readByte().toLong() - 128 and 0xFFL))
                        NEG -> longValue or (-buffer.readByte().toLong() and 0xFFL)
                        SUB -> longValue or ((128 - buffer.readByte().toLong() and 0xFFL))
                        else -> throw IllegalArgumentException("Unknown transformation type.")
                    }
                } else {
                    longValue or (buffer.readByte().toLong() and 0xFFL shl i * 8)
                }
            }
            LITTLE -> for(i in 0 until length) {
                longValue = if(i == 0 && transform != NONE) {
                    when(transform) {
                        ADD -> longValue or (buffer.readByte().toLong() - 128 and 0xFF)
                        NEG -> longValue or (-buffer.readByte().toLong() and 0xFF)
                        SUB -> longValue or (128 - buffer.readByte().toLong() and 0xFF)
                        else -> throw IllegalArgumentException("Unknown transformation type.")
                    }
                } else {
                    longValue or (buffer.readByte().toLong() and 0xFFL shl i * 8)
                }
            }
            MIDDLE -> {
                if(transform != NONE) throw IllegalArgumentException("Middle endian can not have a transformation.")
                if(type != INT) throw IllegalArgumentException("Middle endian only supports Integer data types.")
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 8).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 24).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 16).toLong()
            }
            INVERSE_MIDDLE -> {
                if(transform != NONE) throw IllegalArgumentException("Inverse Middle endian can not have a transformation.")
                if(type != INT) throw IllegalArgumentException("Inverse Middle endian only supports Integer data types.")
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 16).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 24).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF).toLong()
                longValue = longValue or (buffer.readByte().toInt() and 0xFF shl 8).toLong()
            }
            else -> throw IllegalArgumentException("Unknown endian type.")
        }
        return longValue
    }

    private fun readSigned(type: DataType, endian: DataEndian, transform: DataTransform): Long {
        var longValue = read(type, endian, transform)
        if(type != LONG) {
            val max = (2.0.pow((type.size * 8 - 1).toDouble()) - 1).toInt()
            if(longValue > max) {
                longValue -= ((max + 1) * 2).toLong()
            }
        }
        return longValue
    }

    private fun readUnsigned(type: DataType, endian: DataEndian, transform: DataTransform): Long {
        val longValue = read(type, endian, transform)
        if(type == LONG) throw IllegalArgumentException("Long data types must be read as signed.")
        return longValue and -0x1L
    }

    fun readBits(count: Int): Int {
        var amountOfBits = count
        if(amountOfBits !in 0..32) throw IllegalArgumentException("Can not read more than 32 bits and less than 1 bits.")
        if(readerMode != BIT_ACCESS) throw IllegalStateException("Can not read bits while in BYTE_ACCESS mode.")

        var byteOffset = readerBitIndex shr 3
        var bitOffset = 8 - (readerBitIndex and 7)
        var value = 0
        readerBitIndex += amountOfBits

        while(amountOfBits > bitOffset) {
            value += buffer.getByte(byteOffset++).toInt() and BIT_MASK[bitOffset] shl amountOfBits - bitOffset
            amountOfBits -= bitOffset
            bitOffset = 8
        }

        value += if(amountOfBits == bitOffset) {
            buffer.getByte(byteOffset).toInt() and BIT_MASK[bitOffset]
        } else {
            buffer.getByte(byteOffset).toInt() shr bitOffset - amountOfBits and BIT_MASK[amountOfBits]
        }

        return value
    }

    companion object {

        val CP1252: Charset by lazy { Charset.forName("windows-1252") }
        val CESU8: Charset by lazy { Charset.forName("CESU-8") }

        private val BIT_MASK = IntArray(32).apply {
            for(i in 0 until size) {
                set(i, (1 shl i) - 1)
            }
        }
    }
}