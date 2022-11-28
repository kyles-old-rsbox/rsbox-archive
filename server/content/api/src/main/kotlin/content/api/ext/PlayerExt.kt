package content.api.ext

import content.api.annotation.EventDslMarker
import io.rsbox.server.engine.event.EventBus.subscribe
import io.rsbox.server.engine.event.impl.PlayerLoginEvent
import io.rsbox.server.engine.event.impl.PlayerLogoutEvent

@EventDslMarker
fun on_login(block: PlayerLoginEvent.() -> Unit) = subscribe(block)

@EventDslMarker
fun on_logout(block: PlayerLogoutEvent.() -> Unit) = subscribe(block)