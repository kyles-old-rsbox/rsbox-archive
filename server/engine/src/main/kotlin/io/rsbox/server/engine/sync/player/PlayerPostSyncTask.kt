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

package io.rsbox.server.engine.sync.player

import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.world.World
import io.rsbox.server.engine.model.entity.MovementState
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.net.packet.server.SyncVarpLarge
import io.rsbox.server.engine.net.packet.server.SyncVarpSmall
import io.rsbox.server.engine.sync.SyncTask

class PlayerPostSyncTask : SyncTask {

    private val world: World by inject()

    override suspend fun execute() {
        world.players.forEach { player ->
            player.syncVarps()
            player.updateFlags.clear()
            player.clearMovement()
        }
    }

    private fun Player.syncVarps() {
        varps.changed.forEach { id ->
            writeVarp(id, varps.getVarp(id))
        }
        varps.changed.clear()
    }

    private fun Player.writeVarp(id: Int, value: Int) {
        val packet = when(value) {
            in Byte.MIN_VALUE..Byte.MAX_VALUE -> SyncVarpSmall(id, value)
            else -> SyncVarpLarge(id, value)
        }
        session.write(packet)
    }

    private fun Player.clearMovement() {
        teleportTile = null
        movementState = MovementState.NONE
    }
}