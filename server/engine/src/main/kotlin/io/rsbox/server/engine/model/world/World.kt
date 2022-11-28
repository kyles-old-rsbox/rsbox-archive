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

package io.rsbox.server.engine.model.world

import io.rsbox.server.cache.GameCache
import io.rsbox.server.cache.MapTerrainDefinition
import io.rsbox.server.cache.RegionDefinition
import io.rsbox.server.common.inject
import io.rsbox.server.config.XteaConfig
import io.rsbox.server.engine.model.coord.Chunk
import io.rsbox.server.engine.model.coord.Region
import io.rsbox.server.engine.model.list.PlayerList
import io.rsbox.server.engine.queue.QueueList
import org.rsmod.pathfinder.AbsoluteCoords
import org.rsmod.pathfinder.ZoneFlags
import org.rsmod.pathfinder.flag.CollisionFlag
import org.tinylog.kotlin.Logger

class World {

    private val cache: GameCache by inject()

    val players = PlayerList()

    internal val zoneFlags = ZoneFlags()

    internal val queue = QueueList()
    fun queue(block: suspend () -> Unit) = queue.queue(block)

    fun load() {
        Logger.info("Loading game world.")

        var count = 0
        cache.mapArchive.regions.forEach { (regionId, def) ->
            val region = Region(regionId)
            region.loadTerrainCollision(def)
            count++
        }

        Logger.info("Loaded $count region collision maps.")
    }

    private fun Region.loadTerrainCollision(def: RegionDefinition) {
        def.terrain.renderRules.forEachIndexed { level, levelRenderRules ->
            levelRenderRules.forEachIndexed { x, xRenderRules ->
                xRenderRules.forEachIndexed { y, yRenderRules ->
                    var adjustedLevel = level
                    if(yRenderRules.toInt() and MapTerrainDefinition.BLOCKED_TILE_MASK.toInt() == 1) {
                        if(def.terrain.renderRules[1][x][y].toInt() and MapTerrainDefinition.LINK_BELOW_TILE_MASK.toInt() == 2) {
                            adjustedLevel--
                        }
                        if(adjustedLevel >= 0) {
                            val translated = this.toTile(adjustedLevel).translate(x, y)
                            zoneFlags.add(AbsoluteCoords(translated.x, translated.y, translated.level), CollisionFlag.FLOOR)
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val MAX_LEVEL = 4
    }
}