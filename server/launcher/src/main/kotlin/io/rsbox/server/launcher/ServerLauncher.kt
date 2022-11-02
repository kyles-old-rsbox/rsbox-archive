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

import org.koin.core.context.startKoin
import org.tinylog.kotlin.Logger
import java.io.File
import kotlin.system.exitProcess

object ServerLauncher {

    @JvmStatic
    fun main(args: Array<String>) {
        init()
        launch()
    }

    private fun init() {
        /*
         * Check if the server has been setup.
         */
        if(!File("data/").exists()) {
            Logger.error("RSBox server has not been setup. Please run the gradle task: 'rsbox > setup server' and try starting server again.")
            exitProcess(0)
        }

        /*
         * Start dependency injector
         */
        startKoin { modules(DI_MODULES) }

        /*
         * Load configurations.
         */
    }

    private fun launch() {

    }
}