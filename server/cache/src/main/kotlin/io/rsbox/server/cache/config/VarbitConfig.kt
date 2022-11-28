package io.rsbox.server.cache.config

import io.netty.buffer.ByteBuf

data class VarbitConfig(override val id: Int) : Config(id) {
    var varp: Int = 0
    var lsb: Int = 0
    var msb: Int = 0

    companion object : ConfigCompanion<VarbitConfig>() {
        override val id: Int = 14

        override fun decode(id: Int, data: ByteBuf): VarbitConfig {
            val varbitConfig = VarbitConfig(id)
            decoder@ while(true) {
                when(val opcode = data.readUnsignedByte().toInt()) {
                    0 -> break@decoder
                    1 -> {
                        varbitConfig.varp = data.readUnsignedShort()
                        varbitConfig.lsb = data.readUnsignedByte().toInt()
                        varbitConfig.msb = data.readUnsignedByte().toInt()
                    }
                    else -> throw IllegalStateException("Unknown opcode: $opcode.")
                }
            }
            return varbitConfig
        }
    }
}