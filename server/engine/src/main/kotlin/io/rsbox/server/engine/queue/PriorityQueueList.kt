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

package io.rsbox.server.engine.queue

import io.rsbox.server.engine.coroutine.EngineCoroutineTask
import kotlinx.coroutines.withContext
import java.util.*

class PriorityQueueList(
    private var currentQueue: QueueTask? = null,
    private var currentPriority: QueuePriority = QueuePriority.WEAK,
    private val pending: LinkedList<QueueBlock> = LinkedList()
) {

    val size: Int get() = pending.size + (if (currentQueue != null) 1 else 0)

    val paused: Boolean get() = currentQueue == null

    internal fun queue(priority: QueuePriority, block: suspend () -> Unit) {
        if (!changePriority(priority)) return
        if (size >= MAX_ACTIVE_QUEUES) {
            pending.removeLast()
        }
        val queueBlock = QueueBlock(block)
        pending.add(queueBlock)
    }

    suspend fun pollPending() {
        if (currentQueue != null) return
        val ctx = pending.poll() ?: return
        val task = EngineCoroutineTask()
        val block = suspend { withContext(task) { ctx.block() } }
        task.launch(block)
        currentQueue = QueueTask(task)
    }

    internal fun clear() {
        currentQueue = null
        currentPriority = QueuePriority.WEAK
        pending.clear()
    }

    fun processCurrent() {
        val queue = currentQueue ?: return
        queue.task.cycle()
        if (queue.task.paused) {
            discardCurrent()
        }
    }

    fun discardCurrent() {
        currentQueue = null
        if (pending.isEmpty()) {
            currentPriority = QueuePriority.WEAK
        }
    }

    private fun changePriority(priority: QueuePriority): Boolean {
        if (priority == currentPriority) return true
        if (!priority.isStronger(currentPriority)) return false
        if (priority != currentPriority) {
            clear()
            currentPriority
        }
        return true
    }

    private fun QueuePriority.isStronger(other: QueuePriority): Boolean = when (this) {
        QueuePriority.NORMAL -> other == QueuePriority.WEAK
        QueuePriority.STRONG -> true
        else -> false
    }

    companion object {
        private const val MAX_ACTIVE_QUEUES = 2
    }
}