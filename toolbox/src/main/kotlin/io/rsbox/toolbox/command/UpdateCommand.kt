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

package io.rsbox.toolbox.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file
import io.rsbox.toolbox.updater.Updater

class UpdateCommand : CliktCommand(
    name = "update",
    help = "Updates class,method,field and variable names from a previous refactored jar file."
) {

    private val prevJarFile by argument("prev-jar", help = "File path to the previous refactored jar.").file(mustExist = true, canBeDir = false)
    private val curJarFile by argument("cur-jar", help = "File path to the current/latest deobbed jar.").file(mustExist = true, canBeDir = false)
    private val outputJarFile by argument("output-jar", help = "File path to save the new updated jar.").file(canBeDir = false)

    override fun run() {
        val args = mutableListOf<String>()
        args.add(prevJarFile.absolutePath)
        args.add(curJarFile.absolutePath)
        args.add(outputJarFile.absolutePath)
        Updater.main(args.toTypedArray())
    }
}