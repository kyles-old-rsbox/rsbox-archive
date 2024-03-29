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
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import io.rsbox.toolbox.deobfuscator.Deobfuscator

class DeobfuscateCommand : CliktCommand(
    name = "deobfuscate",
    help = "Deobfuscates a vanilla Jagex gamepack for Old School RuneScape."
) {

    private val inputFile by argument("input-jar", help = "File path to the input jar").file(mustExist = true, canBeDir = false)
    private val outputFile by argument("output-jar", help = "File path to output deobfuscated jar.").file(canBeDir = false)
    private val runTestClient by option("--test", "-t", help = "Enable running a test client using output jar.").flag(default = false)

    override fun run() {
        val args = mutableListOf<String>()
        args.add(inputFile.absolutePath)
        args.add(outputFile.absolutePath)
        if(runTestClient) {
            args.add("--test")
        }
        Deobfuscator.main(args.toTypedArray())
    }
}