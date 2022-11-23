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

package io.rsbox.server.config

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec
import com.uchuhimo.konf.Item
import com.uchuhimo.konf.source.toml
import com.uchuhimo.konf.source.toml.toToml
import io.rsbox.server.common.inject
import java.io.File

class ServerConfig {

    var config = Config()
        private set

    private val file = File("data/server.toml")

    fun load() {
        if(!file.exists()) {
            config = Config { addSpec(Spec) }
            save()
        }
        config = Config { addSpec(Spec) }.from.toml.file(file)
        save()
    }

    fun save() {
        config.toToml.toFile(file)
    }

    operator fun <T> get(item: Item<T>): T = config[item]

    operator fun <T> set(item: Item<T>, value: T) {
        config[item] = value
    }

    object Spec : ConfigSpec("server") {
        val serverName by optional("RSBOX", "server-name")
        val revision by optional(209, "revision")
        val devMode by optional(true, "dev-mode")
        val tickRate by optional(600L, "tick-rate")
        val maxLoginsPerTick by optional(25, "max-logins-per-tick")
        val maxLogoutsPerTick by optional(10, "max-logouts-per-tick")
        val maxPacketsPerTick by optional(25, "max-packets-per-tick")
        val renderDistance by optional(15, "render-distance")

        object Network : ConfigSpec("network") {
            val address by optional("0.0.0.0", "address")
            val port by optional(43594, "port")
        }

        object Defaults : ConfigSpec("defaults") {

            object HomeTile : ConfigSpec("home-tile") {
                val x by optional(3221, "x")
                val y by optional(3218, "y")
                val level by optional(0, "level")
            }

            object SpawnTile : ConfigSpec("spawn-tile") {
                val x by optional(3094, "x")
                val y by optional(3106, "y")
                val level by optional(0, "level")
            }
        }
    }

    companion object {

        private val config: ServerConfig by inject()

        init {
            config.load()
        }

        val SERVER_NAME get() = config[Spec.serverName]
        val REVISION get() = config[Spec.revision]
        val DEV_MODE get() = config[Spec.devMode]
        val TICK_RATE get() = config[Spec.tickRate]
        val MAX_LOGINS_PER_TICK get() = config[Spec.maxLoginsPerTick]
        val MAX_LOGOUTS_PER_TICK get() = config[Spec.maxLogoutsPerTick]
        val MAX_PACKETS_PER_TICK get() = config[Spec.maxPacketsPerTick]
        val RENDER_DISTANCE get() = config[Spec.renderDistance]

        val NETWORK = NetworkCompanion(config)
        class NetworkCompanion(private val config: ServerConfig) {
            val ADDRESS get() = config[Spec.Network.address]
            val PORT get() = config[Spec.Network.port]
        }

        val DEFAULTS = DefaultsCompanion(config)
        class DefaultsCompanion(private val config: ServerConfig) {

            val HOME_TILE = HomeTileCompanion(config)
            class HomeTileCompanion(private val config: ServerConfig) {
                val X get() = config[Spec.Defaults.HomeTile.x]
                val Y get() = config[Spec.Defaults.HomeTile.y]
                val LEVEL get() = config[Spec.Defaults.HomeTile.level]
            }

            val SPAWN_TILE = SpawnTileCompanion(config)
            class SpawnTileCompanion(private val config: ServerConfig) {
                val X get() = config[Spec.Defaults.SpawnTile.x]
                val Y get() = config[Spec.Defaults.SpawnTile.y]
                val LEVEL get() = config[Spec.Defaults.SpawnTile.level]
            }
        }
    }
}