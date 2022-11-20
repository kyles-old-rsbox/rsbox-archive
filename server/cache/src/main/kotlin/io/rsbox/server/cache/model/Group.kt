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
import io.netty.buffer.CompositeByteBuf
import io.netty.buffer.Unpooled
import io.rsbox.server.cache.disk.Container

data class Group(
    val id: Int,
    val version: Int,
    val chunks: Int,
    val nameHash: Int,
    val compression: Compression,
    val files: Map<Int, File> = mapOf()
) {

    data class Info(
        val id: Int,
        val version: Int,
        val crc: Int,
        val nameHash: Int,
        val compressedSize: Int,
        val uncompressedSize: Int,
        val files: Map<Int, File.Info>
    )

    data class Data(
        val chunks: Int,
        val compression: Compression,
        val fileData: List<ByteBuf>
    ) {
        companion object {
            fun decode(container: Container, fileCount: Int) = if(fileCount == 1) {
                Data(1, container.compression, listOf(container.data))
            } else {
                val fileSizes = IntArray(fileCount)
                val chunkCount = container.data.getUnsignedByte(container.data.readableBytes() - 1).toInt()
                val chunkSizes = Array(chunkCount) { IntArray(fileCount) }
                container.data.readerIndex(container.data.readableBytes() - 1 - chunkCount * fileCount * 4)
                for(chunk in 0 until chunkCount) {
                    var groupFileSize = 0
                    for(file in 0 until fileCount) {
                        groupFileSize += container.data.readInt()
                        chunkSizes[chunk][file] = groupFileSize
                        fileSizes[file] += groupFileSize
                    }
                }
                val fileData = Array<CompositeByteBuf>(fileCount) {
                    Unpooled.compositeBuffer(chunkCount)
                }
                container.data.readerIndex(0)
                for(chunk in 0 until chunkCount) {
                    for(file in 0 until fileCount) {
                        val size = chunkSizes[chunk][file]
                        fileData[file].addComponent(
                            true,
                            container.data.slice(container.data.readerIndex(), size)
                        )
                        container.data.readerIndex(container.data.readerIndex() + size)
                    }
                }
                Data(
                    chunkCount,
                    container.compression,
                    fileData.map { it.asReadOnly() }
                )
            }
        }
    }
}