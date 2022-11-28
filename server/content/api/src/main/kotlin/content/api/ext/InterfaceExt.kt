package content.api.ext

import content.api.annotation.EventDslMarker
import io.rsbox.server.engine.event.EventBus.subscribe
import io.rsbox.server.engine.event.impl.IfButtonClickEvent
import io.rsbox.server.engine.queue.QueuePriority

@EventDslMarker
fun on_button_click(button: Int = -1, parent: Int = -1, child: Int = -1, block: suspend IfButtonClickEvent.() -> Unit) = subscribe<IfButtonClickEvent> {
    if((button == -1 || this.button == button)
        && (parent == -1 || this.parent == parent)
        && (child == -1 || this.child == child)) {
            player.queue(QueuePriority.WEAK) { this.block() }
    }
}