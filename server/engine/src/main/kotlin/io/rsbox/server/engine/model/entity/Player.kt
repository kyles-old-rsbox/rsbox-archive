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

package io.rsbox.server.engine.model.entity

import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.model.PrivilegeLevel
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.net.Session
import org.tinylog.kotlin.Logger

class Player internal constructor(val session: Session) : LivingEntity() {

    init {
        session.player = this
    }

    lateinit var username: String
    lateinit var passwordHash: String
    lateinit var displayName: String
    var pid: Int = -1
    var skullIcon: Int = -1
    var prayerIcon: Int = -1
    var privilegeLevel = PrivilegeLevel.PLAYER

    var stanceAnimations = intArrayOf(808, 823, 819, 820, 821, 822, 824)

    override var tile = Tile(
        ServerConfig.DEFAULTS.HOME_TILE.X,
        ServerConfig.DEFAULTS.HOME_TILE.Y,
        ServerConfig.DEFAULTS.HOME_TILE.LEVEL
    )

    override var prevTile = tile
    override var followTile = tile

    override suspend fun cycle() {
        queueCycle()
    }
}