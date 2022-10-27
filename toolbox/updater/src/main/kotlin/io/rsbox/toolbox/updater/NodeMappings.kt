package io.rsbox.toolbox.updater

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap
import io.rsbox.toolbox.asm.identifier
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldNode
import org.objectweb.asm.tree.MethodNode
import java.util.*

class NodeMappings {

    var mappings = HashMultimap.create<Any, Mapping>()

    var score = 0

    lateinit var fromMethod: MethodNode
    lateinit var toMethod: MethodNode

    fun getMapping(from: Any, to: Any): Mapping {
        mappings.get(from).forEach { mapping ->
            if(mapping.to == to) {
                return mapping
            }
        }
        return Mapping(from, to).also { mappings.put(from, it) }
    }

    private fun getHighest(from: Any): Any? {
        var highest: Mapping? = null
        mappings.get(from).forEach { mapping ->
            if(highest == null || mapping.score > highest!!.score) {
                highest = mapping
            } else if(mapping.score == highest!!.score && from.id > highest!!.to.id) {
                highest = mapping
            }
        }
        return highest?.to
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
        val sorted = mutableListOf<Mapping>().also {
            it.addAll(mappings.values())
        }
        Collections.sort(sorted, kotlin.Comparator { a, b ->
            val score = a.score.compareTo(b.score)
            if(score != 0) return@Comparator score

            if(a.weight != b.weight) {
                return@Comparator a.weight.compareTo(b.weight)
            }

            return@Comparator a.from.id.compareTo(b.from.id)
        })
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

    fun get(from: Any) = getHighest(from)

    fun getMappings(from: Any) = mappings.get(from)

    fun asMappingMap(): Map<Any, Any?> {
        val result = hashMapOf<Any, Any?>()
        mappings.keySet().forEach { from ->
            result[from] = getHighest(from)
        }
        return result
    }

    private val Any.id: String get() = when(this) {
        is ClassNode -> this.identifier
        is MethodNode -> this.identifier
        is FieldNode -> this.identifier
        else -> this.toString()
    }
}