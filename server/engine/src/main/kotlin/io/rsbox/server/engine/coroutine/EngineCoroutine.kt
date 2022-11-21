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

package io.rsbox.server.engine.coroutine

import kotlin.coroutines.*
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn
import kotlin.coroutines.cancellation.CancellationException

private val CoroutineContext.task: EngineCoroutineTask
    get() = get(EngineCoroutineTask) ?: error("Failed to get engine coroutine task.")

suspend fun wait(ticks: Int = 1) {
    if (ticks <= 0) return
    return suspendCoroutineUninterceptedOrReturn {
        it.context.task.wait(ticks, it)
        COROUTINE_SUSPENDED
    }
}

suspend fun waitUntil(predicate: () -> Boolean) {
    if (predicate()) return
    return suspendCoroutineUninterceptedOrReturn {
        it.context.task.wait(predicate, it)
        COROUTINE_SUSPENDED
    }
}

suspend fun cancel() = coroutineContext.task.cancel()

/**
 * === COROUTINE INTERNAL CLASSES ===
 */

class EngineCoroutine<T : Any>(
    private val continuation: Continuation<T>,
    private val state: EngineCoroutineState<T>
) {

    fun resume(): Boolean {
        if(!state.resume()) {
            return false
        }

        val value = state.get()
        continuation.resume(value)
        return true
    }
}

class EngineCoroutineTask(private var coroutine: EngineCoroutine<out Any>? = null) : AbstractCoroutineContextElement(EngineCoroutineTask) {
    companion object Key : CoroutineContext.Key<EngineCoroutineTask>

    val paused: Boolean get() = coroutine == null

    fun wait(cycles: Int, continuation: Continuation<Unit>) {
        val state = EngineCoroutineCycleState(cycles)
        coroutine = EngineCoroutine(continuation, state)
    }

    fun wait(predicate: () -> Boolean, continuation: Continuation<Unit>) {
        val state = EngineCoroutinePredicateState(predicate)
        coroutine = EngineCoroutine(continuation, state)
    }

    fun cycle() {
        val coroutine = coroutine ?: return
        val resume = coroutine.resume()
        if(resume && this.coroutine === coroutine) {
            this.coroutine = null
        }
    }

    fun cancel() {
        coroutine = null
        throw CancellationException()
    }

    fun launch(action: suspend () -> Unit) {
        action.startCoroutine(EngineCoroutineContinuation)
    }
}

object EngineCoroutineContinuation : Continuation<Unit> {

    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {
        val error = result.exceptionOrNull()
        if(error != null && error !is CancellationException) {
            throw error
        }
    }
}

/**
 * === COROUTINE CONDITIONAL CLASSES ===
 */

interface EngineCoroutineState<T> {
    fun resume(): Boolean
    fun get(): T
}

class EngineCoroutineCycleState(private var cycles: Int) : EngineCoroutineState<Unit> {

    override fun resume(): Boolean {
        return --cycles == 0
    }

    override fun get() {}
}

class EngineCoroutinePredicateState(private val predicate: () -> Boolean) : EngineCoroutineState<Unit> {

    override fun resume(): Boolean {
        return predicate()
    }

    override fun get() {}
}