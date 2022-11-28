package io.rsbox.server.engine.model.manager

import io.rsbox.server.cache.GameCache
import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.entity.Player

class VarpManager(private val player: Player) {

    private val cache: GameCache by inject()

    private val varps = hashMapOf<Int, Int>()
    internal val changed = hashSetOf<Int>()

    fun getVarp(id: Int): Int {
        return this[id] ?: 0
    }

    fun setVarp(id: Int, value: Int) {
        this[id] = value
    }

    fun setVarp(id: Int, flag: Boolean, falseValue: Int = 0, trueValue: Int = 1) {
        setVarp(id, if(flag) trueValue else falseValue)
    }

    fun toggleVarp(id: Int, value1: Int = 0, value2: Int = 1) {
        val newValue = if(getVarp(id) == value1) value2 else value1
        setVarp(id, newValue)
    }

    fun getVarbit(id: Int): Int {
        val varbitConfig = cache.configArchive.varbitConfigs[id]!!
        val value = this[varbitConfig.varp] ?: 0
        return value.getBits(varbitConfig.lsb, varbitConfig.msb)
    }

    fun setVarbit(id: Int, value: Int) {
        val varbitConfig = cache.configArchive.varbitConfigs[id]!!
        val curValue = this[varbitConfig.varp] ?: 0
        val newValue = curValue.setBits(varbitConfig.lsb, varbitConfig.msb, value)
        this[varbitConfig.varp] = newValue
    }

    fun setVarbit(id: Int, flag: Boolean, falseValue: Int = 0, trueValue: Int = 1) {
        setVarbit(id, if(flag) trueValue else falseValue)
    }

    fun toggleVarbit(id: Int, value1: Int = 0, value2: Int = 1) {

    }

    private operator fun get(id: Int) = varps[id]

    private operator fun set(id: Int, value: Int): Int? {
        if((varps[id] ?: -1) != value) changed.add(id)
        if(value == 0) return varps.remove(id)
        return varps.put(id, value)
    }

    private fun Int.getBits(lsb: Int, msb: Int): Int {
        val size = BIT_SIZES[msb - lsb]
        return (this shr lsb) and size
    }

    private fun Int.setBits(lsb: Int, msb: Int, value: Int): Int {
        val size = BIT_SIZES[msb - lsb] shl lsb
        return (this and size.inv()) or ((value shl lsb) and size)
    }

    companion object {
        private val BIT_SIZES = IntArray(Int.SIZE_BYTES).apply {
            var size = 2
            for(i in indices) {
                this[i] = size - 1
                size += size
            }
        }
    }
}