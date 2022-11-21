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

package io.rsbox.server.engine.service.account

import io.rsbox.server.engine.service.Service
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class LoginService : Service {

    override fun start() {

    }

    override fun stop() {

    }

    private class LoginRequestQueue {

        private val scope = MainScope()
        private val queue = Channel<Job>(Channel.UNLIMITED)

        init {
            scope.launch(Dispatchers.Default) {
                for(job in queue) job.join()
            }
        }

        fun queue(
            context: CoroutineContext = EmptyCoroutineContext,
            block: suspend CoroutineScope.() -> Unit
        ) {
            val job = scope.launch(context, CoroutineStart.LAZY, block)
            queue.trySend(job)
        }

        fun cancel() {
            queue.cancel()
            scope.cancel()
        }
    }
}