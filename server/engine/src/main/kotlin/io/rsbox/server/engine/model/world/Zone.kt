package io.rsbox.server.engine.model.world

import io.rsbox.server.engine.model.coord.Chunk

class Zone(private val chunk: Chunk) {

    val x get() = chunk.x

    val y get() = chunk.y

    val level get() = chunk.level

    constructor(x: Int, y: Int, level: Int = 0) : this(Chunk(x, y, level))

    companion object {
        const val SIZE = 8
        const val ZONES_PER_REGION = 13
        const val ZONE_VIEW_RADIUS = 3
    }
}