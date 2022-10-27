package io.rsbox.toolbox.updater

import java.lang.Integer.max

class Mapping(val from: Any, val to: Any) {

    var score = 0
    var executed = false

    var weight = 0
        set(value) {
            if(value > field) {
                field = value
            }
        }

    fun merge(other: Mapping) {
        score += other.score
        executed = executed or other.executed
        weight = max(weight, other.weight)
    }
}