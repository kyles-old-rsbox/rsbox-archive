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

import io.guthix.js5.container.XTEA_ZERO_KEY
import io.netty.buffer.Unpooled
import io.rsbox.server.cache.disk.Container
import io.rsbox.server.cache.disk.FileStore
import io.rsbox.server.cache.model.Archive
import java.io.File

class Cache(path: File) : AutoCloseable {

    val filestore = FileStore(path)

    val archiveCount: Int get() = filestore.archiveCount

    fun readArchive(archive: Int, xteaKeys: IntArray = XTEA_ZERO_KEY): Archive {
        val data = filestore.read(255, archive)
        if(data == Unpooled.EMPTY_BUFFER) {
            throw IllegalStateException("Archive $archive does not exist.")
        }
        val container = Container.decode(data, xteaKeys)
        return Archive.decode(container)
    }

    override fun close() {
        filestore.close()
    }

}