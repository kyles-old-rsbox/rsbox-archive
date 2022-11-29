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

package io.rsbox.client

import org.tinylog.kotlin.Logger
import java.io.File

object ClientLauncher {

    private val executable = File("native-client/src/main/resources/bin/osclient.exe")

    @JvmStatic
    fun main(args: Array<String>) {
        Logger.info("Launching native client process.")

        val process = ProcessBuilder().command(executable.absolutePath).start()
        Logger.info("Started process: osclient.exe with PID: ${process.pid().toInt()}.")

        /*
         * Wait for process to terminate.
         */
        process.waitFor()
        Logger.info("Native client process has exited.")
    }
}