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

package io.rsbox.server.engine.service

import org.tinylog.kotlin.Logger
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class ServiceManager {

    private val services = mutableSetOf<Service>()

    init {

    }

    fun start() {
        services.forEach { service ->
            Logger.info("Starting engine service: ${service::class.simpleName}.")
            service.start()
        }
    }

    fun stop() {
        services.forEach { service ->
            Logger.info("Stopping engine service: ${service::class.simpleName}.")
            service.stop()
        }
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Service> get(service: KClass<T>): T {
        return services.firstOrNull { it::class == service } as? T
            ?: throw IllegalArgumentException("Unknown registered service: ${service.simpleName}.")
    }

    private inline fun <reified T : Service> register() {
        services.add(T::class.createInstance())
    }
}