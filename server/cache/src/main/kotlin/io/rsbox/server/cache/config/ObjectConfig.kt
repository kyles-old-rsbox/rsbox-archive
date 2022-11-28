package io.rsbox.server.cache.config

import io.guthix.buffer.readString
import io.netty.buffer.ByteBuf

data class ObjectConfig(override val id: Int) : Config(id) {
    var name: String = "null"
    var width: Short = 1
    var length: Short = 1
    var mapIconId: Int? = null
    val options: Array<String?> = arrayOfNulls(5)
    var clipType: Int = 2
    var isClipped: Boolean = true
    var modelClipped: Boolean = false
    var isHollow: Boolean = false
    var impenetrable: Boolean = true
    var accessBlock: Short = 0
    var objectModels: IntArray? = null
    var objectTypes: ShortArray? = null
    var colorReplace: IntArray? = null
    var colorFind: IntArray? = null
    var textureFind: IntArray? = null
    var textureReplace: IntArray? = null
    var anInt2088: Short? = null
    var animationId: Int? = null
    var ambient: Byte = 0
    var contrast: Int = 0
    var mapSceneId: Int? = null
    var modelSizeX: Int = 128
    var modelSizeHeight: Int = 128
    var modelSizeY: Int = 128
    var offsetX: Short = 0
    var offsetHeight: Short = 0
    var offsetY: Short = 0
    var decorDisplacement: Short = 16
    var isMirrored: Boolean = false
    var obstructsGround: Boolean = false
    var nonFlatShading: Boolean = false
    var contouredGround: Int? = null
    var supportItems: Short? = null
    var transformVarbit: Int? = null
    var transformVarp: Int? = null
    var transforms: Array<Int?>? = null
    var ambientSoundId: Int? = null
    var anInt2112: Int = 0
    var anInt2113: Int = 0
    var anInt2083: Short = 0
    var anIntArray2084: IntArray? = null
    var category: Int? = null
    var randomizeAnimationStart = false
    var params: MutableMap<Int, Any>? = null

    companion object : ConfigCompanion<ObjectConfig>() {
        override val id: Int = 6

        override fun decode(id: Int, data: ByteBuf): ObjectConfig {
            val objectConfig = ObjectConfig(id)
            decoder@ while (true) {
                when (val opcode = data.readUnsignedByte().toInt()) {
                    0 -> break@decoder
                    1 -> {
                        val size = data.readUnsignedByte().toInt()
                        if (size > 0) {
                            objectConfig.objectModels = IntArray(size)
                            objectConfig.objectTypes = ShortArray(size)
                            for (i in 0 until size) {
                                objectConfig.objectModels!![i] = data.readUnsignedShort()
                                objectConfig.objectTypes!![i] = data.readUnsignedByte()
                            }
                        }
                    }
                    2 -> objectConfig.name = data.readString()
                    5 -> {
                        val size = data.readUnsignedByte().toInt()
                        if (size > 0) {
                            objectConfig.objectTypes = null
                            objectConfig.objectModels = IntArray(size) { data.readUnsignedShort() }
                        }
                    }
                    14 -> objectConfig.width = data.readUnsignedByte()
                    15 -> objectConfig.length = data.readUnsignedByte()
                    17 -> {
                        objectConfig.clipType = 0
                        objectConfig.impenetrable = false
                    }
                    18 -> objectConfig.impenetrable = false
                    19 -> objectConfig.anInt2088 = data.readUnsignedByte()
                    21 -> objectConfig.contouredGround = 0
                    22 -> objectConfig.nonFlatShading = true
                    23 -> objectConfig.modelClipped = true
                    24 -> {
                        objectConfig.animationId = data.readUnsignedShort()
                        if (objectConfig.animationId!!.toInt() == 65535) {
                            objectConfig.animationId = null
                        }
                    }
                    27 -> objectConfig.clipType = 1
                    28 -> objectConfig.decorDisplacement = data.readUnsignedByte()
                    29 -> objectConfig.ambient = data.readByte()
                    39 -> objectConfig.contrast = data.readByte().toInt() * 25
                    in 30..34 -> objectConfig.options[opcode - 30] = data.readString().takeIf { it != "Hidden" }
                    40 -> {
                        val colorsSize = data.readUnsignedByte().toInt()
                        val colorFind = IntArray(colorsSize)
                        val colorReplace = IntArray(colorsSize)
                        for (i in 0 until colorsSize) {
                            colorFind[i] = data.readUnsignedShort()
                            colorReplace[i] = data.readUnsignedShort()
                        }
                        objectConfig.colorFind = colorFind
                        objectConfig.colorReplace = colorReplace
                    }
                    41 -> {
                        val texturesSize = data.readUnsignedByte().toInt()
                        val textureFind = IntArray(texturesSize)
                        val textureReplace = IntArray(texturesSize)
                        for (i in 0 until texturesSize) {
                            textureFind[i] = data.readUnsignedShort()
                            textureReplace[i] = data.readUnsignedShort()
                        }
                        objectConfig.textureFind = textureFind
                        objectConfig.textureReplace = textureReplace
                    }
                    61 -> objectConfig.category = data.readUnsignedShort()
                    62 -> objectConfig.isMirrored = true
                    64 -> objectConfig.isClipped = false
                    65 -> objectConfig.modelSizeX = data.readUnsignedShort()
                    66 -> objectConfig.modelSizeHeight = data.readUnsignedShort()
                    67 -> objectConfig.modelSizeY = data.readUnsignedShort()
                    68 -> objectConfig.mapSceneId = data.readUnsignedShort()
                    69 -> objectConfig.accessBlock = data.readUnsignedByte()
                    70 -> objectConfig.offsetX = data.readShort()
                    71 -> objectConfig.offsetHeight = data.readShort()
                    72 -> objectConfig.offsetY = data.readShort()
                    73 -> objectConfig.obstructsGround = true
                    74 -> objectConfig.isHollow = true
                    75 -> objectConfig.supportItems = data.readUnsignedByte()
                    77, 92 -> {
                        val transformVarbit = data.readUnsignedShort()
                        objectConfig.transformVarbit = if (transformVarbit == 65535) null else transformVarbit
                        val transformVarp = data.readUnsignedShort()
                        objectConfig.transformVarp = if (transformVarbit == 65535) null else transformVarp
                        val lastEntry = if (opcode == 92) {
                            val entry = data.readUnsignedShort()
                            if (entry == 65535) null else entry
                        } else null
                        val size = data.readUnsignedByte().toInt()
                        val transforms = arrayOfNulls<Int?>(size + 2)
                        for (i in 0..size) {
                            val transform = data.readUnsignedShort()
                            transforms[i] = if (transform == 65535) null else transform
                        }
                        if (opcode == 92) {
                            transforms[size + 1] = lastEntry
                        }
                        objectConfig.transforms = transforms
                    }
                    78 -> {
                        objectConfig.ambientSoundId = data.readUnsignedShort()
                        objectConfig.anInt2083 = data.readUnsignedByte()
                    }
                    79 -> {
                        objectConfig.anInt2112 = data.readUnsignedShort()
                        objectConfig.anInt2113 = data.readUnsignedShort()
                        objectConfig.anInt2083 = data.readUnsignedByte()
                        val size = data.readUnsignedByte().toInt()
                        objectConfig.anIntArray2084 = IntArray(size) { data.readUnsignedShort() }
                    }
                    81 -> objectConfig.contouredGround = data.readUnsignedByte() * 256
                    82 -> objectConfig.mapIconId = data.readUnsignedShort()
                    89 -> objectConfig.randomizeAnimationStart = true
                    249 -> objectConfig.params = data.readParams()
                    else -> throw IllegalStateException("Did not recognise opcode $opcode.")
                }
            }
            if (objectConfig.anInt2088 == null) {
                objectConfig.anInt2088 = 0
                if ((objectConfig.objectModels != null && (objectConfig.objectTypes == null)
                            || objectConfig.objectTypes?.get(0)?.toInt() == 10)
                ) {
                    objectConfig.anInt2088 = 1
                }
                for (it in (0 until 5).filter { objectConfig.options[it] != null }) {
                    objectConfig.anInt2088 = 1
                }
            }
            if (objectConfig.supportItems == null) {
                objectConfig.supportItems = if (objectConfig.clipType != 0) 1 else 0
            }
            if (objectConfig.isHollow) {
                objectConfig.clipType = 0
                objectConfig.impenetrable = false
            }
            return objectConfig
        }
    }
}