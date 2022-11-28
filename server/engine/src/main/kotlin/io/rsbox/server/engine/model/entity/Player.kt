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
import io.rsbox.server.engine.event.EventBus
import io.rsbox.server.engine.event.impl.PlayerLoginEvent
import io.rsbox.server.engine.model.Privilege
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.entity.update.PlayerUpdateFlag
import io.rsbox.server.engine.model.manager.GpiManager
import io.rsbox.server.engine.model.manager.InterfaceManager
import io.rsbox.server.engine.model.manager.SceneManager
import io.rsbox.server.engine.model.manager.VarpManager
import io.rsbox.server.engine.model.ui.DisplayMode
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.packet.server.RunClientScriptPacket
import org.rsmod.pathfinder.SmartPathFinder
import org.rsmod.pathfinder.collision.CollisionStrategies
import org.rsmod.pathfinder.flag.CollisionFlag
import org.tinylog.kotlin.Logger
import kotlin.random.Random
import kotlin.random.nextLong

class Player internal constructor(val session: Session) : LivingEntity() {

    init {
        session.player = this
    }

    /*
     * Player State Managers
     */
    val gpi = GpiManager(this)
    val scene = SceneManager(this)
    val ui = InterfaceManager(this)
    val varps = VarpManager(this)

    val pathfinder get() = SmartPathFinder(flags = world.zoneFlags.flags, defaultFlag = CollisionFlag.BLOCK_PLAYERS)

    lateinit var username: String
    lateinit var passwordHash: String
    lateinit var displayName: String
    var pid: Int = -1
    var uuid: Long = Random.nextLong(0..Long.MAX_VALUE)
    var member = true
    var skullIcon: Int = -1
    var prayerIcon: Int = -1
    var privilege = Privilege.PLAYER
    var displayMode = DisplayMode.FIXED
    var appearance = Appearance.DEFAULT
    var stanceAnimations = intArrayOf(808, 823, 819, 820, 821, 822, 824)
    val updateFlags = sortedSetOf<PlayerUpdateFlag>()

    override val size = 1

    override var tile = Tile(
        ServerConfig.DEFAULTS.HOME_TILE.X,
        ServerConfig.DEFAULTS.HOME_TILE.Y,
        ServerConfig.DEFAULTS.HOME_TILE.LEVEL
    )

    override var prevTile = tile
    override var followTile = tile

    var running = false

    internal fun init() {
        gpi.init()
        scene.init()
    }

    internal fun onLogin() {
        this.init()
        updateFlags.add(PlayerUpdateFlag.APPEARANCE)
        Logger.info("[$username] has connected to server. index=$index")
        EventBus.postEvent(PlayerLoginEvent(this))
    }

    internal fun onLogout() {
        world.players.removePlayer(this)
        Logger.info("[$username] has disconnected from server. index=$index")
        EventBus.postEvent(PlayerLoginEvent(this))
    }

    override suspend fun cycle() {
        queueCycle()
    }

    fun runClientScript(id: Int, vararg args: Any) {
        session.write(RunClientScriptPacket(id, *args))
    }

    fun isOnline() = index > 0

    fun findPath(dest: Tile): MutableList<Tile> {
        val result = mutableListOf<Tile>()
        val route = pathfinder.findPath(tile.x, tile.y, dest.x, dest.y, dest.level)
        var cur = tile
        route.forEach { waypoint ->
            val waypointTile = Tile(waypoint.x, waypoint.y, cur.level)
            while(!cur.sameAs(waypointTile)) {
                cur = cur.translate(cur.directionTo(waypointTile))
                result.add(cur)
            }
        }
        return result
    }
}