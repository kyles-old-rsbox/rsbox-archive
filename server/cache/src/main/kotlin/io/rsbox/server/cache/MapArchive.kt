package io.rsbox.server.cache

import io.guthix.buffer.readIncrShortSmart
import io.guthix.buffer.readUnsignedShortSmart
import io.guthix.js5.Js5Archive
import io.netty.buffer.ByteBuf
import io.rsbox.server.cache.MapTerrainDefinition.Companion.LINK_BELOW_TILE_MASK
import java.io.FileNotFoundException
import kotlin.experimental.and
import kotlin.math.cos

class MapArchive(val regions: Map<Int, RegionDefinition>) {
    companion object {
        const val id: Int = 5

        fun load(archive: Js5Archive, xteas: List<MapXtea>): MapArchive {
            val regions = mutableMapOf<Int, RegionDefinition>()
            xteas.forEach {
                val mapFile = archive.readGroup("m${it.x}_${it.y}")[0] ?: throw FileNotFoundException(
                    "Map file not found for map m${it.x}_${it.y}."
                )
                val locFile = archive.readGroup("l${it.x}_${it.y}", it.key)[0] ?: throw FileNotFoundException(
                    "Loc file not found for loc l${it.x}_${it.y}."
                )
                regions[it.id] = RegionDefinition.decode(mapFile.data, locFile.data, it.x, it.y)
            }
            return MapArchive(regions)
        }
    }
}

class RegionDefinition(
    val x: Int,
    val y: Int,
    val terrain: MapTerrainDefinition,
    val objects: List<MapObjectDefinition>
) {
    companion object {
        const val FLOOR_COUNT: Int = 4

        const val SIZE: Int = 64

        fun decode(landData: ByteBuf, mapData: ByteBuf, x: Int, y: Int): RegionDefinition {
            val mapTerrainDefinitions = MapTerrainDefinition.decode(landData, x, y)
            val mapObjectDefinitions = MapObjectDefinition.decode(mapData, mapTerrainDefinitions.tileFlags)
            return RegionDefinition(x, y, mapTerrainDefinitions, mapObjectDefinitions)
        }
    }
}

class MapTerrainDefinition(
    val tileHeights: Array<Array<IntArray>>,
    val tileFlags: Array<Array<ShortArray>>,
    val overlayIds: Array<Array<ByteArray>>,
    val overlayPaths: Array<Array<ShortArray>>,
    val overlayRotations: Array<Array<ShortArray>>,
    val underlayIds: Array<Array<ShortArray>>
) {
    companion object {
        const val BLOCKED_TILE_MASK: Short = 0x1
        const val LINK_BELOW_TILE_MASK: Short = 0x2
        const val ROOF_TILE_MASK: Short = 0x4
        private const val JAGEX_CIRCULAR_ANGLE = 2048
        private const val ANGULAR_RATIO = 360.0 / JAGEX_CIRCULAR_ANGLE
        private val JAGEX_RADIAN = Math.toRadians(ANGULAR_RATIO)
        private val COS = IntArray(JAGEX_CIRCULAR_ANGLE) {
            ((0xFFFF + 1) * cos(it.toDouble() * JAGEX_RADIAN).toInt())
        }

        fun decode(data: ByteBuf, baseX: Int, baseY: Int): MapTerrainDefinition {
            val tileHeights = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    IntArray(
                        RegionDefinition.SIZE
                    )
                }
            }
            val renderRules = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    ShortArray(
                        RegionDefinition.SIZE
                    )
                }
            }
            val overlayIds = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    ByteArray(
                        RegionDefinition.SIZE
                    )
                }
            }
            val overlayPaths = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    ShortArray(
                        RegionDefinition.SIZE
                    )
                }
            }
            val overlayRotations = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    ShortArray(RegionDefinition.SIZE)
                }
            }
            val underlayIds = Array(RegionDefinition.FLOOR_COUNT) {
                Array(RegionDefinition.SIZE) {
                    ShortArray(
                        RegionDefinition.SIZE
                    )
                }
            }
            for (z in 0 until RegionDefinition.FLOOR_COUNT) {
                for (x in 0 until RegionDefinition.SIZE) {
                    for (y in 0 until RegionDefinition.SIZE) {
                        loop@ while (true) {
                            val opcode = data.readUnsignedShort()
                            when {
                                opcode == 0 -> break@loop
                                opcode == 1 -> {
                                    val height = data.readUnsignedByte().toInt()
                                    tileHeights[z][x][y] = height
                                    break@loop
                                }
                                opcode <= 49 -> {
                                    overlayIds[z][x][y] = data.readShort().toByte()
                                    overlayPaths[z][x][y] = ((opcode - 2) / 4).toShort()
                                    overlayRotations[z][x][y] = ((opcode - 2) and 0x3).toShort()
                                }
                                opcode <= 81 -> {
                                    renderRules[z][x][y] = (opcode - 49).toShort()
                                }
                                else -> {
                                    underlayIds[z][x][y] = (opcode - 81).toShort()
                                }
                            }
                        }
                    }
                }
            }
            return MapTerrainDefinition(tileHeights, renderRules, overlayIds, overlayPaths, overlayRotations, underlayIds)
        }

        private fun calcZ0Height(baseX: Int, baseY: Int, x: Int, y: Int): Int {
            val xc = x + baseX + 932731
            val yc = y + baseY + 556238
            var height = interpolateNoise(45365 + xc, yc + 91923, 4) - 128 +
                    (interpolateNoise(10294 + xc, 37821 + yc, 2) - 128 shr 1) +
                    (interpolateNoise(xc, yc, 1) - 128 shr 2)
            height = (height * 0.3).toInt() + 35
            if (height < 10) height = 10 else if (height > 60) height = 60
            return -height * 8
        }

        private fun interpolateNoise(x: Int, y: Int, frequency: Int): Int {
            val intX = x / frequency
            val fracX = x and (frequency - 1)
            val intY = y / frequency
            val fracY = y and (frequency - 1)
            val v1 = smoothNoise2d(intX, intY)
            val v2 = smoothNoise2d(intX + 1, intY)
            val v3 = smoothNoise2d(intX, intY + 1)
            val v4 = smoothNoise2d(1 + intX, 1 + intY)
            val i1 = interpolate(v1, v2, fracX, frequency)
            val i2 = interpolate(v3, v4, fracX, frequency)
            return interpolate(i1, i2, fracY, frequency)
        }

        private fun smoothNoise2d(x: Int, y: Int): Int {
            val corners = noise(x - 1, y - 1) + noise(x + 1, y - 1) + noise(x - 1, 1 + y) +
                    noise(x + 1, y + 1)
            val sides = noise(x - 1, y) + noise(1 + x, y) + noise(x, y - 1) + noise(x, 1 + y)
            val center = noise(x, y)
            return corners / 16 + sides / 8 + center / 4
        }

        private fun noise(x: Int, y: Int): Int {
            var n = x + y * 57
            n = n xor (n shl 13)
            return (n * n * 15731 + 789221) * n + 1376312589 and (Int.MAX_VALUE shr 19) and 0xFF
        }

        private fun interpolate(a: Int, b: Int, x: Int, y: Int): Int {
            val f = (0xFFFF + 1) - COS[(JAGEX_CIRCULAR_ANGLE / 2) * x / y] shr 1
            return (f * b shr 16) + (a * ((0xFFFF + 1) - f) shr 16)
        }
    }
}

data class MapObjectDefinition(
    val id: Int,
    val plane: Int,
    val localX: Int,
    val localY: Int,
    val shape: Int,
    val rotation: Int
) {
    companion object {
        fun decode(data: ByteBuf, renderRules: Array<Array<ShortArray>>): List<MapObjectDefinition> {
            val objects = mutableListOf<MapObjectDefinition>()
            var id = -1
            var offset = data.readIncrShortSmart()
            while(offset != 0) {
                id += offset
                var position = 0
                var positionOffset = data.readUnsignedShortSmart().toInt()
                while(positionOffset != 0) {
                    position += positionOffset - 1
                    val localY = position and 0x3F
                    val localX = (position shr 6) and 0x3F
                    var level = (position shr 12) and 0x3

                    if ((renderRules[1][localX][localY] and LINK_BELOW_TILE_MASK) == LINK_BELOW_TILE_MASK) {
                        level--
                    }
                    if (level < 0) {
                        data.readUnsignedByte()
                    } else {
                        val attributes = data.readUnsignedByte().toInt()
                        val shape = attributes shr 2
                        val rotation = attributes and 0x3
                        objects.add(MapObjectDefinition(id, level, localX, localY, shape, rotation))
                    }
                    positionOffset = data.readUnsignedShortSmart().toInt()
                }
                offset = data.readIncrShortSmart()
            }
            return objects
        }
    }
}

data class MapXtea(val id: Int, val key: IntArray) {

    val x: Int get() = id shr 8
    val y: Int get() = id and 0xFF

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MapXtea
        if (id != other.id) return false
        if (!key.contentEquals(other.key)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + key.contentHashCode()
        return result
    }
}