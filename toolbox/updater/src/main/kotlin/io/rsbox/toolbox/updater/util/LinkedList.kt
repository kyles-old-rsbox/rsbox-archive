package io.rsbox.toolbox.updater.util

import java.util.LinkedList

fun <T> linkedListOf(vararg elements: T): LinkedList<T> = LinkedList<T>().also { it.addAll(elements) }
inline fun <reified T> Iterable<T>.toLinkedList() = linkedListOf(*this.toMutableList().toTypedArray())
inline fun <reified T> Collection<T>.toLinkedList() = linkedListOf(*this.toTypedArray())