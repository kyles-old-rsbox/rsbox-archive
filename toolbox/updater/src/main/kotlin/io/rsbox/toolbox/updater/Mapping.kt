package io.rsbox.toolbox.updater

class Mapping(val from: Any, val to: Any) {

    var score = 0

    fun merge(other: Mapping) {
        score += other.score
    }
}