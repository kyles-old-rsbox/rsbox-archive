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

package io.rsbox.server.engine

import io.rsbox.server.common.inject
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.coroutine.EngineCoroutineScope
import io.rsbox.server.engine.model.World
import io.rsbox.server.engine.net.NetworkServer
import io.rsbox.server.engine.net.http.HttpServer
import io.rsbox.server.engine.service.ServiceManager
import io.rsbox.server.engine.sync.SyncTaskList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.tinylog.kotlin.Logger
import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

class Engine {

    private val networkServer: NetworkServer by inject()
    private val httpServer: HttpServer by inject()
    private val engineCoroutine: EngineCoroutineScope by inject()
    private val world: World by inject()
    private val serviceManager: ServiceManager by inject()

    private val syncTasks = SyncTaskList()
    private var running = false
    private var prevCycleNanos = 0L

    fun start() {
        Logger.info("Starting RSBox engine.")

        running = true

        serviceManager.start()
        world.load()
        engineCoroutine.start()
        networkServer.start()
        httpServer.start()
    }

    fun stop() {
        Logger.info("Stopping RSBox engine.")

        running = false

        networkServer.stop()
        httpServer.stop()
    }

    private fun CoroutineScope.start() = launch {
        while(running) {
            val activeNanos = measureNanoTime { cycle() } + prevCycleNanos
            val activeMillis = TimeUnit.NANOSECONDS.toMillis(activeNanos)
            val idleMillis = if(activeMillis > ServerConfig.TICK_RATE) {
                val curCycle = activeMillis / ServerConfig.TICK_RATE
                (curCycle + 1) * ServerConfig.TICK_RATE - activeMillis
            } else {
                ServerConfig.TICK_RATE - activeMillis
            }
            if(activeMillis > ServerConfig.TICK_RATE) {
                Logger.warn("Cycle took longer than expected. Is the server lagging? (Active: ${activeMillis}ms, Idle: ${idleMillis}ms).")
            }
            prevCycleNanos = activeNanos - TimeUnit.MILLISECONDS.toNanos(activeMillis)
            delay(idleMillis)
        }
    }

    /**
     * The root game engine cycle/tick method.
     */
    private suspend fun cycle() {
        world.players.forEach { it.session.cycle() }
        world.players.forEach { it.cycle() }
        world.queue.cycle()
        syncTasks.forEach { it.execute() }
        world.players.forEach { it.session.flush() }
    }
}