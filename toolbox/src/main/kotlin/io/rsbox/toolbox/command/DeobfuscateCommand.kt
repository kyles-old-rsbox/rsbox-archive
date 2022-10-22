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