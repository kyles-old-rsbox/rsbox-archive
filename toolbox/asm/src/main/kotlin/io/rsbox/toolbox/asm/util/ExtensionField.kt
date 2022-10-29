/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.rsbox.toolbox.asm.util

import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

class ExtensionField<R, T>(private val init: (R) -> T = { throw IllegalStateException("Property not initialized!") }) {
    private val store = mutableWeakIdentityHashMap<R, T>()

    operator fun getValue(self: R, prop: KProperty<*>): T = store[self] ?: setValue(self, prop, init(self))

    operator fun setValue(self: R, prop: KProperty<*>, value: T): T = value.apply {
        store[self] = this
    }
}

class NullableExtensionField<R, T>(private val init: (R) -> T? = { null }) {
    private val store = mutableWeakIdentityHashMap<R, T?>()

    operator fun getValue(self: R, prop: KProperty<*>): T? = store[self] ?: setValue(self, prop, init(self))

    operator fun setValue(self: R, prop: KProperty<*>, value: T?): T? = value.apply {
        store[self] = this
    }
}

fun <T, R> field(init: (R) -> T) = ExtensionField(init)
fun <T, R> field() = ExtensionField<R, T>()

fun <T, R> nullField(init: (R) -> T?) = NullableExtensionField(init)
fun <T, R> nullField() = NullableExtensionField<R, T?>()

class WeakIdentityHashMap<K, V> : Map<K, V> {
    private val refQueue = ReferenceQueue<K>()
    private val backingStore = hashMapOf<WeakIdentityReference, V>()

    override val entries: Set<Map.Entry<K, V>> = referenceAwareFunction {
        hashSetOf<WeakIdentityHashEntry>().apply {
            backingStore.entries.forEach { reference ->
                reference.key.get()?.let { key ->
                    WeakIdentityHashEntry(key, reference.value).apply {
                        add(this)
                    }
                }
            }
        }
    }

    override val keys: Set<K> = referenceAwareFunction {
        mutableSetOf<K>().apply {
            backingStore.keys.forEach { key ->
                key.get()?.let {
                    add(it)
                }
            }
        }
    }

    override val size: Int = referenceAwareFunction(backingStore::size)

    override val values: Collection<V> = referenceAwareFunction(backingStore::values)

    override fun containsKey(key: K): Boolean = referenceAwareFunction {
        backingStore.containsKey(WeakIdentityReference(key))
    }

    override fun containsValue(value: V): Boolean = referenceAwareFunction {
        backingStore.containsValue(value)
    }

    override operator fun get(key: K): V? = referenceAwareFunction {
        backingStore[WeakIdentityReference(key)]
    }

    operator fun set(key: K, value: V): V? = referenceAwareFunction {
        WeakIdentityReference(key).run {
            backingStore.put(this, value)
        }
    }

    fun remove(key: K): V? = referenceAwareFunction {
        WeakIdentityReference(key).run {
            backingStore.remove(this)
        }
    }

    override fun isEmpty(): Boolean = referenceAwareFunction(backingStore::isEmpty)

    fun clear() = backingStore.clear().also {
        reap()
    }

    override fun hashCode(): Int = referenceAwareFunction(backingStore::hashCode)

    override fun equals(other: Any?): Boolean {
        if (other !is WeakIdentityHashMap<*, *>) {
            return false
        }

        return backingStore == other
    }

    private fun <T> referenceAwareFunction(block: () -> T) = reap().run {
        block()
    }

    @Synchronized
    private fun reap() {
        var zombie = refQueue.poll()

        while (zombie != null) {
            backingStore.remove(zombie)
            zombie = refQueue.poll()
        }
    }

    inner class WeakIdentityHashEntry(override val key: K, override val value: V) : Map.Entry<K, V>

    private inner class WeakIdentityReference(obj: K) : WeakReference<K>(obj, refQueue) {
        private val hash: Int = System.identityHashCode(obj)

        override fun hashCode(): Int = hash

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            if (other is WeakReference<*>) {
                if (this.get() === other.get())
                    return true
            }
            return false
        }
    }
}

/**
 * Kotlin stdlib style initializer function for the [WeakIdentityHashMap]
 */
fun<K, V> mutableWeakIdentityHashMap() = WeakIdentityHashMap<K, V>()