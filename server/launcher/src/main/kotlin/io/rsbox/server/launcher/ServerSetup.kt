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
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.config.XteaConfig
import io.rsbox.server.util.security.RSA
import org.koin.core.context.startKoin
import org.tinylog.kotlin.Logger
import java.io.File
import java.util.zip.ZipFile
import kotlin.system.exitProcess

object ServerSetup {

    private val DATA_DIR = File("data/")

    @JvmStatic
    fun main(args: Array<String>) {
        Logger.info("Setting up RSBox server...")

        if(DATA_DIR.exists() && DATA_DIR.listFiles()!!.size > 1) {
            Logger.error("The data/ directory already exists. Please remove it and re-run the setup gradle task.")
            exitProcess(0)
        }

        startKoin { modules(DI_MODULES) }

        /*
         * Setup Steps
         */
        createDirs()
        extractDataArchive()
        createConfigs()
        createRSAKeyPair()
        testGameCache()

        Logger.info("The RSBox server setup has completed successfully.\n" +
                " You may now start the server using the 'start server' gradle task.\n" +
                "For help or any additional questions, please join our discord server.")
    }

    private fun createDirs() {
        Logger.info("Creating default directory structure.")

        listOf(
            "cache/",
            "cache/",
            "logs/",
            "saves/",
            "rsa/",
            "configs/",
            "content/"
        ).map { DATA_DIR.resolve(it) }.forEach { dir ->
            if(!dir.exists()) {
                Logger.info("Creating missing directory: ${dir.path}.")
                dir.mkdirs()
            }
        }
    }

    private fun extractDataArchive() {
        Logger.info("Extracting default data archive.")
        val file = File("data.zip")
        ZipFile(file).use { zip ->
            zip.entries().asSequence().forEach { entry ->
                if(!entry.isDirectory) {
                    zip.getInputStream(entry).use { input ->
                        File(entry.name).outputStream().use { output ->
                            Logger.info("Extracting file: ${entry.name}.")
                            input.copyTo(output)
                        }
                    }
                }
            }
        }
        Logger.info("Successfully extracted default data archive.")
    }

    private fun createConfigs() {
        Logger.info("Creating default server.toml configuration file.")
        ServerConfig.SERVER_NAME

        Logger.info("Loading region XTEA keys configuration file.")
        XteaConfig.xteas.size
    }

    private fun createRSAKeyPair() {
        Logger.info("Preparing RSA encryption generation.")
        RSA.generateNewKeyPair()
    }

    private fun testGameCache() {
        get<GameCache>().load()
    }
}