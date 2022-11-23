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

package io.rsbox.server.engine.event

import kotlin.reflect.KClass

object EventBus {

    val events = mutableMapOf<KClass<out Event>, MutableList<EventSubscriber<*>>>()

    @Suppress("UNCHECKED_CAST")
    inline fun <reified T : Event> postEvent(event: T) {
        val events = (EventBus.events[event::class] as? List<EventSubscriber<T>>) ?: return
        events.forEach { subscriber ->
            subscriber.action(event)
        }
    }

    inline fun <reified T : Event> subscribe(noinline block: T.() -> Unit) {
        events.computeIfAbsent(T::class) { mutableListOf() }.add(EventSubscriber(block))
    }

    fun unsubscribe(listener: EventSubscriber<out Event>) {
        events.values.forEach { it.remove(listener) }
    }

}