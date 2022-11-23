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

import io.rsbox.server.cache.GameCache
import io.rsbox.server.common.get
import io.rsbox.server.common.inject
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.config.XteaConfig
import io.rsbox.server.content.ContentManager
import io.rsbox.server.engine.Engine
import io.rsbox.server.util.security.RSA
import org.koin.core.context.startKoin
import org.tinylog.kotlin.Logger
import java.io.File
import kotlin.system.exitProcess

object ServerLauncher {

    private val engine: Engine by inject()

    @JvmStatic
    fun main(args: Array<String>) {
        /*
         * Check if the server has been setup.
         */
        if(!File("data/").exists()) {
            Logger.error("RSBox server has not been setup. Please run the gradle task: 'rsbox > setup server' and try starting server again.")
            exitProcess(0)
        }

        Logger.info("Initializing...")

        /*
         * Start dependency injector
         */
        startKoin { modules(DI_MODULES) }

        checkDirs()
        loadConfigs()
        loadRSA()
        loadGameCache()
        engine.start()
        ContentManager.load()

        Logger.info("RSBox server startup completed successfully.")
    }

    private fun checkDirs() {
        Logger.info("Checking required directories.")

        listOf(
            "data/",
            "data/cache/",
            "data/configs/",
            "data/logs/",
            "data/saves/",
            "data/rsa/",
            "data/content/",
        ).map { File(it) }.forEach { dir ->
            if(!dir.exists()) {
                Logger.error("Please run the 'setup server' gradle task before starting the server.")
                exitProcess(0)
            }
        }
    }

    private fun loadConfigs() {
        Logger.info("Loading configuration file: server.toml.")
        ServerConfig.SERVER_NAME

        Logger.info("Loading configuration file: xteas.json.")
        XteaConfig.xteas.values.size.also {
            Logger.info("Successfully loaded $it region XTEA keys.")
        }
    }

    private fun loadRSA() {
        Logger.info("Loading RSA encryption keys.")
        get<RSA>().load()
    }

    private fun loadGameCache() {
        Logger.info("Preparing to load game cache files.")
        get<GameCache>().load()
    }
}