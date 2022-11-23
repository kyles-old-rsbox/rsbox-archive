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

package io.rsbox.server.api.event

import io.rsbox.server.engine.event.EventBus.subscribe
import io.rsbox.server.engine.event.impl.PlayerLoginEvent
import io.rsbox.server.engine.event.impl.PlayerLogoutEvent

@EventSubscriberMarker
fun on_player_login(block: suspend PlayerLoginEvent.() -> Unit) = subscribe<PlayerLoginEvent> { world.queue { block() } }

@EventSubscriberMarker
fun on_player_logout(block: suspend PlayerLogoutEvent.() -> Unit) = subscribe<PlayerLogoutEvent> { world.queue { block() } }