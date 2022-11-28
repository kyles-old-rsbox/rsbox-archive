package content.api

import content.api.ext.on_login
import io.rsbox.server.engine.model.entity.Player

on_login {
    player.setDisplayName()
}

fun Player.setDisplayName() {
    val hasDisplayName = displayName.isNotBlank()
    runClientScript(1105, if(hasDisplayName) 1 else 0)
    runClientScript(423, displayName)
}