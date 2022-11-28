package io.rsbox.server.engine.model.collision

import io.rsbox.server.engine.model.coord.Tile
import io.rsbox.server.engine.model.obj.GameObject
import io.rsbox.server.engine.model.obj.ObjectShape
import org.rsmod.pathfinder.AbsoluteCoords
import org.rsmod.pathfinder.ZoneFlags
import org.rsmod.pathfinder.flag.CollisionFlag

class CollisionMap {

    val flags = ZoneFlags()

    /**
     * === OBJECT COLLISION METHODS ===
     */

    fun addObject(obj: GameObject) {
        changeObject(obj, add = true)
    }

    fun removeObject(obj: GameObject) {
        changeObject(obj, add = false)
    }

    fun addFloorDecor(tile: Tile) {
        changeFloorDecor(tile, true)
    }

    private fun changeObject(obj: GameObject, add: Boolean) {
        val data = obj.data
        val tile = obj.tile
        val shape = obj.shape
        val rotation = obj.rotation
        val clipType = data.clipType
        val impenetrable = data.impenetrable
        val blockPath = clipType != 0
        val blockProjectile = impenetrable

        if (shape in ObjectShape.WALL_SHAPES && clipType != 0) {
            changeWall(tile, rotation, shape, blockProjectile, add)
        } else if (shape in ObjectShape.NORMAL_SHAPES && clipType != 0) {
            var width = data.width.toInt()
            var length = data.length.toInt()
            if (rotation == 1 || rotation == 3) {
                width = data.length.toInt()
                length = data.width.toInt()
            }
            changeNormal(tile, width, length, blockPath, blockProjectile, add)
        } else if (shape in ObjectShape.GROUND_DECOR_SHAPES && clipType == 1) {
            changeFloorDecor(tile, add)
        }
    }

    private fun changeWall(
        tile: Tile,
        rotation: Int,
        shape: Int,
        blockProjectile: Boolean,
        add: Boolean
    ) {
        when (shape) {
            ObjectShape.WALL -> {
                when (rotation) {
                    0 -> {
                        change(tile, CollisionFlag.WALL_WEST, add)
                        change(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(-1, 0), CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    1 -> {
                        change(tile, CollisionFlag.WALL_NORTH, add)
                        change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                            change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER, add)
                        }
                    }
                    2 -> {
                        change(tile, CollisionFlag.WALL_EAST, add)
                        change(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(1, 0), CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    3 -> {
                        change(tile, CollisionFlag.WALL_SOUTH, add)
                        change(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER, add)
                            change(tile.translate(0, -1), CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                        }
                    }
                }
            }
            ObjectShape.WALL_CORNER_DIAG, ObjectShape.WALL_CORNER -> {
                when (rotation) {
                    0 -> {
                        change(tile, CollisionFlag.WALL_NORTH_WEST, add)
                        change(tile.translate(-1, 1), CollisionFlag.WALL_SOUTH_EAST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_NORTH_WEST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(-1, 1), CollisionFlag.WALL_SOUTH_EAST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    1 -> {
                        change(tile, CollisionFlag.WALL_NORTH_EAST, add)
                        change(tile.translate(1, 1), CollisionFlag.WALL_SOUTH_WEST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_NORTH_EAST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(1, 1), CollisionFlag.WALL_SOUTH_WEST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    2 -> {
                        change(tile, CollisionFlag.WALL_SOUTH_EAST, add)
                        change(tile.translate(1, -1), CollisionFlag.WALL_NORTH_WEST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_SOUTH_EAST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(1, -1), CollisionFlag.WALL_NORTH_WEST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    3 -> {
                        change(tile, CollisionFlag.WALL_SOUTH_WEST, add)
                        change(tile.translate(-1, -1), CollisionFlag.WALL_NORTH_EAST, add)
                        if (blockProjectile) {
                            change(tile, CollisionFlag.WALL_SOUTH_WEST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(-1, -1), CollisionFlag.WALL_NORTH_EAST_PROJECTILE_BLOCKER, add)
                        }
                    }
                }
            }
            ObjectShape.UNFINISHED_WALL -> {
                when (rotation) {
                    0 -> {
                        change(tile, CollisionFlag.WALL_WEST or CollisionFlag.WALL_NORTH, add)
                        change(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                        change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                        if (blockProjectile) {
                            val flag =
                                CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER or CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER
                            change(tile, flag, add)
                            change(tile.translate(-1, 0), CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER, add)
                        }
                    }
                    1 -> {
                        change(tile, CollisionFlag.WALL_NORTH or CollisionFlag.WALL_EAST, add)
                        change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH, add)
                        change(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                        if (blockProjectile) {
                            val flag =
                                CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER or CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER
                            change(tile, flag, add)
                            change(tile.translate(0, 1), CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER, add)
                            change(tile.translate(1, 0), CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                        }
                    }
                    2 -> {
                        change(tile, CollisionFlag.WALL_EAST or CollisionFlag.WALL_SOUTH, add)
                        change(tile.translate(1, 0), CollisionFlag.WALL_WEST, add)
                        change(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                        if (blockProjectile) {
                            val flag =
                                CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER or CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER
                            change(tile, flag, add)
                            change(tile.translate(1, 0), CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER, add)
                            change(tile.translate(0, -1), CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                        }
                    }
                    3 -> {
                        change(tile, CollisionFlag.WALL_SOUTH or CollisionFlag.WALL_WEST, add)
                        change(tile.translate(0, -1), CollisionFlag.WALL_NORTH, add)
                        change(tile.translate(-1, 0), CollisionFlag.WALL_EAST, add)
                        if (blockProjectile) {
                            val flag =
                                CollisionFlag.WALL_SOUTH_PROJECTILE_BLOCKER or CollisionFlag.WALL_WEST_PROJECTILE_BLOCKER
                            change(tile, flag, add)
                            change(tile.translate(0, -1), CollisionFlag.WALL_NORTH_PROJECTILE_BLOCKER, add)
                            change(tile.translate(-1, 0), CollisionFlag.WALL_EAST_PROJECTILE_BLOCKER, add)
                        }
                    }
                }
            }
        }
    }

    private fun changeNormal(
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
                change(translatedTile, CollisionFlag.OBJECT, add)
                if (blockProjectile) {
                    change(translatedTile, CollisionFlag.OBJECT_PROJECTILE_BLOCKER, add)
                }
                if (blockPath) {
                    change(translatedTile, CollisionFlag.OBJECT_ROUTE_BLOCKER, add)
                }
            }
        }
    }

    private fun changeFloorDecor(tile: Tile, add: Boolean) {
        change(tile, CollisionFlag.FLOOR_DECORATION, add)
    }

    private fun change(tile: Tile, mask: Int, add: Boolean) = when (add) {
        true -> flags.add(AbsoluteCoords(tile.x, tile.y, tile.level), mask)
        false -> flags.remove(AbsoluteCoords(tile.x, tile.y, tile.level), mask)
    }
}