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

import io.guthix.js5.Js5Cache
import io.guthix.js5.container.Js5Container
import io.guthix.js5.container.XTEA_ZERO_KEY
import io.guthix.js5.container.disk.Js5DiskStore
import org.tinylog.kotlin.Logger
import java.io.File

class GameCache {

    val filestore = Js5DiskStore.open(CACHE_DIR.toPath())
    val cache = Js5Cache(filestore)

    fun load() {
        Logger.info("Loading game cache files.")

        val validator = cache.generateValidator(includeWhirlpool = false, includeSizes = false)
        val container = Js5Container(validator.encode())
        filestore.write(255, 255, container.encode())

        Logger.info("Successfully loaded ${cache.archiveCount} game cache archives.")
    }

    fun close() {
        filestore.close()
        cache.close()
    }

    fun readArchive(archive: Int) = cache.readArchive(archive)

    fun readGroup(archive: Int, group: Int, xteaKeys: IntArray = XTEA_ZERO_KEY) = readArchive(archive).readGroup(group, xteaKeys)

    fun readContainer(archive: Int, group: Int) = cache.readArchive(archive).readGroup(group).mapValues { it.value.data.retain() }

    companion object {
        private val CACHE_DIR = File("data/cache/")
    }
}