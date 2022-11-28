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
import io.rsbox.server.engine.model.World
import io.rsbox.server.engine.model.entity.MovementState
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.entity.update.PlayerUpdateFlag
import io.rsbox.server.engine.sync.SyncTask

class PlayerPreSyncTask : SyncTask {

    private val world: World by inject()

    override suspend fun execute() {
        world.players.forEach { player ->
            player.updateMovement()
            player.scene.cycle()
        }
    }

    private fun Player.updateMovement() {
        prevTile = tile
        when {
            teleportTile != null -> teleport()
            path.isNotEmpty() -> step()
        }
    }

    private fun Player.teleport() {
        path.clear()
        movementState = MovementState.TELEPORT
        updateFlags.add(PlayerUpdateFlag.MOVEMENT_MODE)
        tile = teleportTile!!
        followTile = teleportTile!!.translate(0, -1)
    }

    private fun Player.step() {

    }
}