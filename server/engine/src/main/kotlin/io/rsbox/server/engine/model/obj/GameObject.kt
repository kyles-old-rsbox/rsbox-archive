package io.rsbox.server.engine.model.obj

import io.rsbox.server.cache.GameCache
import io.rsbox.server.cache.config.ObjectConfig
import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.coord.Tile

class GameObject(
    val id: Int,
    val tile: Tile,
    var shape: Int,
    var rotation: Int
) {

    private val cache: GameCache by inject()

    val data = cache.configArchive.objectConfigs[id]!!

    val clipType = data.clipType
    val impenetrable = data.impenetrable

    fun blocksPath() = clipType != 0
    fun blocksProjectile() = impenetrable
}