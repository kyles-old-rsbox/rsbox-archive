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

package io.rsbox.server.content

import org.tinylog.kotlin.Logger
import java.io.File

object ContentManager {

    private val CONTENT_DIR = File("data/content/")

    private val modules = hashMapOf<String, ContentModule>()

    fun load() {
        Logger.info("Loading content modules.")

        CONTENT_DIR.listFiles()?.filter { it.name.endsWith(".jar") }?.forEach {
            val module = ContentModule(it.nameWithoutExtension)
            module.load()
            modules[module.name] = module
        }

        Logger.info("Loaded ${modules.size} content modules.")
    }

    fun getModule(name: String) = modules[name]

    fun reloadModule(name: String) {
        val module = getModule(name) ?: throw IllegalArgumentException("Could not find content module: $name.")
        module.reload()
    }
}