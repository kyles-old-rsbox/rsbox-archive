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

package io.rsbox.server.cache.model

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufInputStream
import io.netty.buffer.Unpooled
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream
import java.io.ByteArrayInputStream
import java.io.SequenceInputStream
import java.util.zip.GZIPInputStream

sealed class Compression(val id: Int) {

    companion object {
        fun fromId(id: Int) = when(id) {
            0 -> NONE
            1 -> BZIP2
            2 -> GZIP
            else -> throw IllegalArgumentException("Unknown compression ID: $id.")
        }
    }

    val headerSize: Int get() = when(this) {
        is NONE -> 0
        else -> 4
    }

    abstract fun decompress(buf: ByteBuf, size: Int): ByteBuf

    /**
     * === None Compression ===
     */
    object NONE : Compression(0) {
        override fun decompress(buf: ByteBuf, size: Int): ByteBuf {
            return buf.slice(buf.readerIndex(), size)
        }
    }

    /**
     * === BZIP2 Compression ===
     */
    object BZIP2 : Compression(1) {
        override fun decompress(buf: ByteBuf, size: Int): ByteBuf {
            val data = Unpooled.buffer(size)
            val input = SequenceInputStream(ByteArrayInputStream("BZh1".toByteArray(Charsets.US_ASCII)), ByteBufInputStream(buf))
            BZip2CompressorInputStream(input).use { data.writeBytes(it, size) }
            return data
        }
    }

    /**
     * === GZIP Compression ===
     */
    object GZIP : Compression(2) {
        override fun decompress(buf: ByteBuf, size: Int): ByteBuf {
            val data = Unpooled.buffer(size)
            GZIPInputStream(ByteBufInputStream(buf)).use { input ->
                while(input.available() == 1) {
                    data.writeBytes(input, size)
                }
            }
            return data
        }
    }
}
