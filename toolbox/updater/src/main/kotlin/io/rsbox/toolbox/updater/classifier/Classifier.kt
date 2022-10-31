package io.rsbox.toolbox.updater.classifier

interface Classifier<T> {
    var name: String
    var weight: Double
    fun score(from: T, to: T): Double
}