package io.rsbox.server.engine.model.collision

import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.obj.GameObject
import io.rsbox.server.engine.model.obj.ObjectShape
import org.rsmod.pathfinder.AbsoluteCoords
import org.rsmod.pathfinder.ZoneFlags
import org.rsmod.pathfinder.flag.CollisionFlag

class CollisionMap {

    private val zoneFlags = ZoneFlags()

    val flags get() = zoneFlags.flags

    fun add(tile: Tile, flag: Int) {
        zoneFlags.add(AbsoluteCoords(tile.x, tile.y, tile.level), flag)
    }

    fun remove(tile: Tile, flag: Int) {
        zoneFlags.remove(AbsoluteCoords(tile.x, tile.y, tile.level), flag)
    }

    fun setObject(obj: GameObject, add: Boolean) {
        val data = obj.data
        val tile = obj.tile
        val shape = obj.shape
        val rotation = obj.rotation
        val clipType = data.clipType
        val blockPath = data.clipType != 0
        val blockProjectile = data.impenetrable

        if (shape in ObjectShape.WALL_SHAPES && clipType != 0) {
            setWall(tile, rotation, shape, blockProjectile, add)
        } else if (shape in ObjectShape.NORMAL_SHAPES && clipType != 0) {
            var width = data.width.toInt()
            var length = data.length.toInt()
            if (rotation == 1 || rotation == 3) {
                width = data.length.toInt()
                length = data.width.toInt()
            }
            setNormal(tile, width, length, blockPath, blockProjectile, add)
        } else if (shape in ObjectShape.GROUND_DECOR_SHAPES && clipType == 1) {
            setFloorDecoration(tile, add)
        }
    }

    fun setWall(
        tile: Tile,
        rotation: Int,
        shape: Int,
        blocksProjectile: Boolean,
        add: Boolean
    ) {
        if(shape == ObjectShape.WALL) {
            when(rotation) {
                0 -> {
                    set(tile, CollisionFlag.WALL_WEST, add)
                    set(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(-1, 0), CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                    }
                }
                1 -> {
                    set(tile, CollisionFlag.WALL_NORTH, add)
                    set(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                        set(tile.translate(0, 1), CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                    }
                }
                2 -> {
                    set(tile, CollisionFlag.WALL_EAST, add)
                    set(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(1, 0), CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                    }
                }
                3 -> {
                    set(tile, CollisionFlag.WALL_SOUTH, add)
                    set(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER, add)
                        set(tile.translate(0, -1), CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                    }
                }
            }
        }
        else if(shape == ObjectShape.WALL_CORNER_DIAG || shape == ObjectShape.WALL_CORNER) {
            when(rotation) {
                0 -> {
                    set(tile, CollisionFlag.WALL_NORTH_WEST, add)
                    set(tile.translate(-1, 1), CollisionFlag.WALL_SOUTH_EAST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_NORTH_WEST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(-1, 1), CollisionFlag.WALL_SOUTH_EAST_PROJECTILE_BLOCKER, add)
                    }
                }
                1 -> {
                    set(tile, CollisionFlag.WALL_NORTH_EAST, add)
                    set(tile.translate(1, 1), CollisionFlag.WALL_SOUTH_WEST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_NORTH_EAST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(1, 1), CollisionFlag.WALL_SOUTH_WEST_PROJECTILE_BLOCKER, add)
                    }
                }
                2 -> {
                    set(tile, CollisionFlag.WALL_SOUTH_EAST, add)
                    set(tile.translate(1, -1), CollisionFlag.WALL_NORTH_WEST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_SOUTH_EAST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(1, -1), CollisionFlag.WALL_NORTH_WEST_PROJECTILE_BLOCKER, add)
                    }
                }
                3 -> {
                    set(tile, CollisionFlag.WALL_SOUTH_WEST, add)
                    set(tile.translate(-1, -1), CollisionFlag.WALL_NORTH_EAST, add)
                    if(blocksProjectile) {
                        set(tile, CollisionFlag.WALL_SOUTH_WEST_PROJECTILE_BLOCKER, add)
                        set(tile.translate(-1, -1), CollisionFlag.WALL_NORTH_EAST_PROJECTILE_BLOCKER, add)
                    }
                }
            }
        }
        else if(shape == ObjectShape.UNFINISHED_WALL) {
            when(rotation) {
                0 -> {
                    set(tile, CollisionFlag.WALL_WEST or CollisionFlag.WALL_NORTH, add)
                    set(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                    set(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                }
                1 -> {
                    set(tile, CollisionFlag.WALL_NORTH or CollisionFlag.WALL_EAST, add)
                    set(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                    set(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                }
                2 -> {
                    set(tile, CollisionFlag.WALL_EAST or CollisionFlag.WALL_SOUTH, add)
                    set(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                    set(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                }
                3 -> {
                    set(tile, CollisionFlag.WALL_SOUTH or CollisionFlag.WALL_WEST, add)
                    set(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                    set(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                }
            }
        }
    }

    fun setNormal(
        tile: Tile,
        width: Int,
        length: Int,
        blockPath: Boolean,
        blockProjectile: Boolean,
        add: Boolean
    ) {
        for (x in 0 until width) {
            for (y in 0 until length) {
                val translatedTile = tile.translate(x, y)
                set(translatedTile, CollisionFlag.OBJECT, add)
                if (blockProjectile) {
                    set(translatedTile, CollisionFlag.OBJECT_PROJECTILE_BLOCKER, add)
                }
                if (blockPath) {
                    set(translatedTile, CollisionFlag.OBJECT_ROUTE_BLOCKER, add)
                }
            }
        }
    }

    fun setFloor(tile: Tile, add: Boolean) {
        set(tile, CollisionFlag.FLOOR, add)
    }

    fun setFloorDecoration(tile: Tile, add: Boolean) {
        set(tile, CollisionFlag.FLOOR_DECORATION, add)
    }

    fun setRoof(tile: Tile, add: Boolean) {
        set(tile, CollisionFlag.ROOF, add)
    }

    fun set(tile: Tile, flag: Int, add: Boolean) = when (add) {
        true -> add(tile, flag)
        false -> remove(tile, flag)
    }
}