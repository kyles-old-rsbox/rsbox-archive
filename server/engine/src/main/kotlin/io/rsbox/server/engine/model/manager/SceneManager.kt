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

package io.rsbox.server.engine.model.manager

import io.rsbox.server.engine.model.coord.Chunk
import io.rsbox.server.engine.model.coord.Region
import io.rsbox.server.engine.model.coord.Scene.Companion.REBUILD_DISTANCE
import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.net.packet.server.RebuildRegionNormalPacket
import kotlin.math.abs

class SceneManager(private val player: Player) {

    var baseTile: Tile = player.tile

    val regions: List<Region> get() {
        val results = mutableListOf<Region>()
        val baseChunk = baseTile.toChunk()

        val lx = (baseChunk.x - 6) / Chunk.SIZE
        val ly = (baseChunk.y - 6) / Chunk.SIZE
        val rx = (baseChunk.x + 6) / Chunk.SIZE
        val ry = (baseChunk.y + 6) / Chunk.SIZE

        for(x in lx..rx) {
            for(y in ly..ry) {
                results.add(Region(x, y))
            }
        }

        return results
    }

    fun init() {
        baseTile = player.tile
        player.session.write(RebuildRegionNormalPacket(player, gpi = true))
    }

    private fun shouldRebuild(): Boolean {
       return abs(baseTile.x - player.tile.x) > REBUILD_DISTANCE
               || abs(baseTile.y - player.tile.y) > REBUILD_DISTANCE
    }

    suspend fun cycle() {
        if(shouldRebuild()) {
            baseTile = player.tile
            player.session.write(RebuildRegionNormalPacket(player, gpi = false))
        }
    }
}