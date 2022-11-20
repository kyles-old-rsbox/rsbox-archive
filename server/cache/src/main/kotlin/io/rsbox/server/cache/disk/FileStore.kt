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

class FileStore(private val dir: File) : AutoCloseable {

    private val dat2File = Dat2File(dir.resolve("main_file_cache.dat2"))
    private val idxFiles = hashMapOf<Int, IdxFile>()

    var archiveCount: Int = 0
        private set

    init {
        idxFiles[255] = IdxFile(255, dir.resolve("main_file_cache.idx255"))
        for(i in 0 until 255) {
            val file = dir.resolve("main_file_cache.idx$i")
            if(!file.exists()) {
                archiveCount = i
                break
            }
        }
    }

    fun read(archive: Int, group: Int): ByteBuf {
        if(archive >= archiveCount && archive != 255) {
            throw IllegalStateException("Can not read archive: $archive, group: $group")
        }
        val idxFile = idxFiles.getOrPut(archive) { IdxFile(archive, dir.resolve("main_file_cache.idx$archive")) }
        val idx = idxFile.read(group)
        if(idx.size == 0) {
            println("Warning: Could not read [Archive: $archive, Group: $group]. Idx file does not exist.")
            return Unpooled.EMPTY_BUFFER
        }
        return dat2File.read(idx)
    }

    override fun close() {
        dat2File.close()
        idxFiles.values.forEach { it.close() }
    }
}
