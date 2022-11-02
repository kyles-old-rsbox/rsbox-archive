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

package io.rsbox.server.config

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.toValue
import io.rsbox.server.common.inject
import java.io.File
import java.io.FileNotFoundException

class XteaConfig {

    private var config = Config()
    private val file = File("data/cache/xteas.json")

    val xteas = mutableMapOf<Int, IntArray>()

    fun load() {
        if(!file.exists()) {
            throw FileNotFoundException("Failed to load '/data/cache/xteas.json' region XTEA config file.")
        }
        val entries = config.from.json.file(file).toValue<Array<XteaEntry>>()
        entries.forEach {
            xteas[it.region] = it.key
        }
    }

    operator fun get(regionId: Int): IntArray = xteas[regionId] ?: EMPTY_KEYS

    companion object {

        private val config: XteaConfig by inject()

        val EMPTY_KEYS = IntArray(4) { 0 }

        init {
            config.load()
        }

        val xteas = config.xteas

        fun getRegionKey(regionId: Int): IntArray = config[regionId]
    }

    data class XteaEntry(val region: Int, val key: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as XteaEntry

            if (region != other.region) return false
            if (!key.contentEquals(other.key)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = region
            result = 31 * result + key.contentHashCode()
            return result
        }
    }
}