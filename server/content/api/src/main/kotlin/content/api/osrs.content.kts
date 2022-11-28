package content.api

import content.api.ext.on_button_click
import content.api.ext.on_login
import io.rsbox.server.engine.coroutine.wait
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.ui.DisplayMode
import io.rsbox.server.engine.model.ui.GameInterface
import io.rsbox.server.engine.model.ui.InterfaceType

on_login {
    player.setDisplayName()
    player.openWelcomeInterface()
}

fun Player.setDisplayName() {
    val hasDisplayName = displayName.isNotBlank()
    runClientScript(1105, if(hasDisplayName) 1 else 0)
    runClientScript(423, displayName)
    if(hasDisplayName) {
        varps.setVarbit(8119, 1)
    }
}

on_button_click(button = 1, parent = 378, child = 78) {
    wait(ticks = 1)
    player.openGameInterface()
}

fun Player.openWelcomeInterface() {
    ui.init(DisplayMode.FULLSCREEN)
    ui.openTopInterface(165)
    ui.openInterface(165, 2, 162)
    ui.openInterface(165, 7, 651)
    ui.openInterface(165, 6, 708)
    ui.openInterface(165, 31, 163)
    ui.openInterface(165, 10, 303)
    ui.openInterface(165, 32, 160)
    ui.openInterface(165, 12, 122)
    ui.openInterface(165, 39, 728)
    ui.openInterface(165, 37, 378, InterfaceType.MODAL)
    ui.openInterface(165, 17, 320)
    ui.openInterface(165, 18, 629)
    ui.openInterface(629, 33, 712)
    ui.openInterface(165, 19, 149)
    ui.openInterface(165, 20, 387)
    ui.openInterface(165, 21, 541)
    ui.openInterface(165, 22, 218)
    ui.openInterface(165, 25, 429)
    ui.openInterface(165, 24, 109)
    ui.openInterface(165, 26, 182)
    ui.openInterface(165, 27, 116)
    ui.openInterface(165, 28, 216)
    ui.openInterface(165, 29, 239)
    ui.openInterface(165, 23, 707)
    ui.openInterface(707, 7, 7)
    ui.openInterface(165, 32, 160)
    ui.openInterface(165, 16, 593)

    runClientScript(233, -1, 2100, 0, 1897, 330, -200, 5, 28238, 24772664)
    runClientScript(233, 8446, 1200, 0, 177, 1999, 0, 0, 38593, 2472665)
}

fun Player.openGameInterface() {
    ui.updateDisplayMode()
    GameInterface.values().forEach { gameInterface ->
        ui.openInterface(gameInterface)
    }
}