package io.rsbox.toolbox.updater

import com.google.common.collect.HashMultimap

class NodeMappings {

    private var mappings = HashMultimap.create<Any, Mapping>()

    private fun getMapping(from: Any, to: Any): Mapping {
        mappings.get(from).forEach { mapping ->
            if(mapping.to == to) {
                return mapping
            }
        }
        return Mapping(from, to).also { mappings.put(from, it) }
    }

    private fun getBest(from: Any): Mapping? {
        var highest: Mapping? = null
        mappings.get(from).forEach { mapping ->
            if(highest == null || mapping.score > highest!!.score) {
                highest = mapping
            } else if(mapping.score == highest!!.score) {
                highest = mapping
            }
        }
        return highest
    }

    fun merge(other: NodeMappings) {
        other.mappings.entries().forEach {
            val from = it.key
            val mapping = it.value
            getMapping(from, mapping.to).merge(mapping)
        }
    }

    fun map(from: Any, to: Any): Mapping {
        val mapping = getMapping(from, to)
        mapping.score++
        return mapping
    }

    fun reduce() {
        val sorted = mutableListOf(*mappings.values().toTypedArray())
        sorted.sortWith(compareBy { it.score })
        sorted.reverse()

        val reducedMappings = HashMultimap.create<Any, Mapping>()
        val reversedMappings = hashMapOf<Any, Any>()

        sorted.forEach { mapping ->
            if(reducedMappings.containsKey(mapping.from)) return@forEach
            if(reversedMappings.containsKey(mapping.to)) return@forEach
            reducedMappings.put(mapping.from, mapping)
            reversedMappings[mapping.to] = mapping.from
        }

        mappings = reducedMappings
    }

    fun get(from: Any) = getBest(from)

    fun getMappings(from: Any) = mappings.get(from)

    fun asMappingMap(): Map<Any, Any?> {
        val result = hashMapOf<Any, Any?>()
        mappings.keySet().forEach { from ->
            result[from] = getBest(from)
        }
        return result
    }


}