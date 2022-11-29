package content.api.ext

import content.api.annotation.EventDslMarker
import io.rsbox.server.engine.event.EventBus.subscribe
import io.rsbox.server.engine.event.impl.CheatCommandEvent
import io.rsbox.server.engine.event.impl.LoginEvent
import io.rsbox.server.engine.event.impl.LogoutEvent
import io.rsbox.server.engine.model.Privilege
import io.rsbox.server.engine.queue.QueuePriority

@EventDslMarker
fun on_login(block: LoginEvent.() -> Unit) = subscribe(block)

@EventDslMarker
fun on_logout(block: LogoutEvent.() -> Unit) = subscribe(block)

@EventDslMarker
fun on_command(command: String, privilege: Privilege = Privilege.ADMINISTRATOR, block: suspend CheatCommandEvent.() -> Unit) = subscribe<CheatCommandEvent> {
    if(this.player.privilege.id < privilege.id || this.command != command) return@subscribe
    player.queue(QueuePriority.WEAK) { this.block() }
}