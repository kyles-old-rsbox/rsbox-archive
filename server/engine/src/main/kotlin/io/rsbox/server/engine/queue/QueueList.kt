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

class QueueList internal constructor(
    private val queues: MutableList<QueueTask> = mutableListOf(),
    private val pending: Queue<QueueBlock> = LinkedList()
) : List<QueueTask> by queues {

    internal fun queue(block: suspend () -> Unit) {
        val queueBlock = QueueBlock(block)
        pending.add(queueBlock)
    }

    internal suspend fun cycle() {
        cycleQueues()
        addPending()
    }

    private fun cycleQueues() {
        queues.forEach { it.task.cycle() }
        queues.removeIf { it.task.paused }
    }

    private fun addPending() {
        while (pending.isNotEmpty()) {
            val ctx = pending.poll() ?: break
            val task = EngineCoroutineTask()
            val block = suspend { withContext(task) { ctx.block() } }
            val queueTask = QueueTask(task)
            task.launch(block)
            if (!queueTask.task.paused) {
                queues.add(queueTask)
            }
        }
    }
}