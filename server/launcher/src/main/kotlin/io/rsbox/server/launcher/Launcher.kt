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

package io.rsbox.server.launcher

import io.rsbox.server.common.get
import io.rsbox.server.common.inject
import io.rsbox.server.config.CONFIG_MODULE
import io.rsbox.server.config.ServerConfig
import org.koin.core.context.startKoin
import org.tinylog.kotlin.Logger
import java.io.File
import kotlin.system.exitProcess

class Launcher {

    private fun checkSetup(): Boolean = File("data/").let {
        it.exists() && it.listFiles()!!.isNotEmpty()
    }

    private fun launch() {
        if(!checkSetup()) {
            Logger.error("RSBox has not been setup yet. Please run the 'rsbox:setup' gradle task before running.")
            exitProcess(0)
        }

        Logger.info("Initializing RSBox server.")

        loadConfigs()

    }

    private fun loadConfigs() {
        Logger.info("Loading server configuration files.")

        /*
         * Get the 'ServerConfig' instance from DI to load it.
         */
        get<ServerConfig>()

        Logger.info("Successfully loaded configuration files.")
    }

    companion object {

        private val launcher: Launcher by inject()

        @JvmStatic
        fun main(args: Array<String>) {
            startKoin { modules(
                LAUNCHER_MODULE,
                CONFIG_MODULE
            ) }
            launcher.launch()
        }
    }
}