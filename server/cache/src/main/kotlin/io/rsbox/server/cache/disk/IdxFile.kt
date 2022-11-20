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
import io.netty.buffer.Unpooled
import java.io.File
import java.nio.channels.FileChannel
import java.nio.file.StandardOpenOption

class IdxFile(val archive: Int, file: File) : AutoCloseable {

    private val channel = FileChannel.open(file.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE)

    val size get() = channel.size()

    fun read(group: Int): Info {
        val offset = group.toLong() * 6L
        if(offset < 0 || offset >= size) {
            throw IllegalStateException("Could not read IDX info for archive: $archive, group: $group.")
        }
        val buf = Unpooled.buffer(6)
        buf.writeBytes(channel, offset, buf.writableBytes())
        return Info.decode(buf)
    }

    override fun close() {
        channel.close()
    }

    data class Info(val sector: Int, val size: Int) {
        companion object {
            fun decode(buf: ByteBuf): Info {
                val size = buf.readUnsignedMedium()
                val sector = buf.readUnsignedMedium()
                return Info(sector, size)
            }
        }
    }
}