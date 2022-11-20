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

package io.rsbox.server.cache

import io.guthix.js5.Js5Archive
import io.guthix.js5.Js5Cache
import io.guthix.js5.Js5File
import io.guthix.js5.Js5Group
import io.guthix.js5.container.XTEA_ZERO_KEY
import io.guthix.js5.container.disk.Js5DiskStore
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import org.tinylog.kotlin.Logger
import java.io.File

class GameCache : AutoCloseable {

    lateinit var cache: Js5Cache private set
    lateinit var filestore: Js5DiskStore private set

    val archiveCount get() = cache.archiveCount

    fun read(archive: Int, group: Int) = filestore.read(archive, group).retain()

    fun readArchive(archive: Int): Js5Archive {
        return cache.readArchive(archive)
    }

    fun readGroup(archive: Int, group: Int, xteaKey: IntArray = XTEA_ZERO_KEY): Js5Group {
        return readArchive(archive).readGroup(group, xteaKey)
    }

    fun readFile(archive: Int, group: Int, file: Int, xteaKey: IntArray = XTEA_ZERO_KEY): ByteBuf {
        return readGroup(archive, group, xteaKey)[file]?.data?.retain() ?: Unpooled.EMPTY_BUFFER
    }

    fun load() {
        Logger.info("Loading game cache files.")

        filestore = Js5DiskStore.open(CACHE_DIR.toPath())
        cache = Js5Cache(filestore)

        Logger.info("Successfully loaded ${cache.archiveCount} game cache archives.")
    }

    override fun close() {
        cache.close()
        filestore.close()
    }

    companion object {
        private val CACHE_DIR = File("data/cache/")
    }
}