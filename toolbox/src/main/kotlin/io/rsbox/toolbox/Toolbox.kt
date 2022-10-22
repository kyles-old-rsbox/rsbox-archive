package io.rsbox.toolbox

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import io.rsbox.toolbox.command.DeobfuscateCommand

object Toolbox {

    @JvmStatic
    fun main(args: Array<String>) = RootCommand().subcommands(
        DeobfuscateCommand()
    ).main(args)

    class RootCommand : CliktCommand(
        name = "toolbox",
        help = "RSBox Toolbox and SDK.",
        invokeWithoutSubcommand = true,
        printHelpOnEmptyArgs = true
    ) {
        override fun run() {}
    }
}