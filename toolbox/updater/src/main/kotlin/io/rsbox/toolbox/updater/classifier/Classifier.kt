package io.rsbox.toolbox.updater.classifier

interface Classifier<T> {
    val name: String
    val weight: Double
    fun score(from: T, to: T): Double
}

fun <T> classifier(name: String, weight: Double, score: (from: T, to: T) -> Double): Classifier<T> {
    return object : Classifier<T> {
        override val name = name
        override val weight = weight
        override fun score(from: T, to: T): Double {
            return score(from, to)
        }
    }
}