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

package io.rsbox.toolbox.updater.util

import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.Executors

class AsyncExecutor(private val threads: Int = Runtime.getRuntime().availableProcessors() - 3) {

    private val taskQueue = ConcurrentLinkedQueue<() -> Unit>()
    private val executor = Executors.newFixedThreadPool(threads)

    fun queueTask(block: () -> Unit) {
        taskQueue.add(block)
    }

    fun runTasks() {
        while(taskQueue.isNotEmpty()) {
            executor.execute {
                val task = taskQueue.poll() ?: return@execute
                task()
            }
        }
        executor.shutdown()
    }

}