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
import io.rsbox.server.cache.MapObjectDefinition
import io.rsbox.server.cache.MapTerrainDefinition
import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.collision.CollisionMap
import io.rsbox.server.engine.model.coord.Region
import io.rsbox.server.engine.model.list.PlayerList
import io.rsbox.server.engine.model.obj.GameObject
import io.rsbox.server.engine.queue.QueueList
import org.tinylog.kotlin.Logger

class World {

    private val cache: GameCache by inject()

    val players = PlayerList()

    val collisionMap = CollisionMap()

    internal val queue = QueueList()
    fun queue(block: suspend () -> Unit) = queue.queue(block)

    fun load() {
        Logger.info("Loading game world.")

        /*
         * Load the world map from cache.
         */
        cache.mapArchive.regions.forEach { (regionId, def) ->
            val region = Region(regionId)
            loadMapTerrain(region, def.terrain)
            loadMapObjects(region, def.objects)
        }
    }

    private fun loadMapTerrain(region: Region, terrain: MapTerrainDefinition) {
        terrain.tileFlags.forEachIndexed { level, levelFlags ->
            levelFlags.forEachIndexed { x, xFlags ->
                xFlags.forEachIndexed { y, flag ->
                    var z = level
                    if(flag.toInt() and 0x1 == 0x1) {
                        if(terrain.tileFlags[1][x][y].toInt() and 0x2 == 0x2) {
                            z--
                        }
                        if(z >= 0) {
                            val tile = region.toTile(level).translate(x, y)
                            collisionMap.setFloor(tile, true)
                        }
                    }
                }
            }
        }
    }

    private fun loadMapObjects(region: Region, objs: List<MapObjectDefinition>) {
        objs.forEach { obj ->
            val tile = region.toTile(obj.plane).translate(obj.localX, obj.localY)
            val gameObject = GameObject(
                obj.id,
                tile,
                obj.shape,
                obj.rotation
            )
            collisionMap.setObject(gameObject, true)
        }
    }

    companion object {
        const val MAX_LEVEL = 4
    }
}