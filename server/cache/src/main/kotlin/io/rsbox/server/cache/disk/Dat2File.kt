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

import io.netty.buffer.ByteBuf
import io.netty.buffer.DefaultByteBufHolder
import io.netty.buffer.Unpooled
import java.io.File
import java.nio.channels.FileChannel
import java.nio.file.StandardOpenOption
import kotlin.math.ceil

class Dat2File(file: File) : AutoCloseable {

    private val channel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE)

    val size get() = channel.size()

    fun read(idxInfo: IdxFile.Info): ByteBuf {
        val data = Unpooled.compositeBuffer(ceil(idxInfo.size.toDouble() / 520).toInt())
        var sectorCount = 0
        var remainingBytes = idxInfo.size
        var offset = idxInfo.sector * 520L
        do {
            val sectorBuf = Unpooled.buffer(520)
            sectorBuf.writeBytes(channel, offset, sectorBuf.writableBytes())
            val sector = Sector.decode(sectorBuf)
            if(remainingBytes > sector.data.writerIndex()) {
                data.addComponent(true, sector.data)
                remainingBytes -= sector.data.writerIndex()
                offset = sector.nextSector * 520L
                sectorCount++
            } else {
                data.addComponent(true, sector.data.slice(0, remainingBytes))
                remainingBytes = 0
            }
        } while(remainingBytes > 0)
        return data
    }

    override fun close() {
        channel.close()
    }

    data class Sector(
        val archive: Int,
        val group: Int,
        val offset: Int,
        val nextSector: Int,
        val data: ByteBuf
    ) : DefaultByteBufHolder(data) {
        companion object {
            fun decode(buf: ByteBuf): Sector {
                val group = buf.readUnsignedShort()
                val offset = buf.readUnsignedShort()
                val nextSector = buf.readUnsignedMedium()
                val archive = buf.readUnsignedByte().toInt()
                val data = buf.slice(8, 512)
                return Sector(archive, group, offset, nextSector, data)
            }
        }
    }
}