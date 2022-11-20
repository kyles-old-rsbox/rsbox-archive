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

package io.rsbox.server.cache.disk

import io.guthix.js5.container.XTEA_ZERO_KEY
import io.guthix.js5.container.xteaDecrypt
import io.netty.buffer.ByteBuf
import io.netty.buffer.DefaultByteBufHolder
import io.netty.buffer.Unpooled
import io.rsbox.server.cache.model.Compression

data class Container(
    val data: ByteBuf,
    val compression: Compression = Compression.NONE,
    val version: Int? = null
) : DefaultByteBufHolder(data) {
    companion object {
        fun decode(buf: ByteBuf, xteaKeys: IntArray = XTEA_ZERO_KEY): Container {
            val compression = Compression.fromId(buf.readUnsignedByte().toInt())
            val compSize = buf.readInt()
            val size = compression.headerSize + compSize
            val data = if(!xteaKeys.all { it == 0 }) {
                buf.xteaDecrypt(xteaKeys, end = buf.readerIndex() + size)
            } else {
                buf.slice(buf.readerIndex(), buf.readableBytes())
            }
            val decompressedData = if(compression != Compression.NONE) {
                val decompSize = data.readInt()
                val decompBuf = compression.decompress(data, decompSize)
                if(decompBuf.writerIndex() != decompSize) {
                    throw IllegalStateException()
                }
                Unpooled.wrappedBuffer(decompBuf)
            } else {
                data.slice(0, compSize)
            }
            data.readerIndex(size)
            val version = if(data.readableBytes() >= 2) {
                data.readShort().toInt()
            } else {
                null
            }
            return Container(decompressedData, compression, version)
        }
    }
}