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

import io.rsbox.server.common.PathConstants.SERVER_CONFIG_PATH
import kotlinx.serialization.Serializable
import net.peanuuutz.tomlkt.Toml
import java.io.FileOutputStream
import java.io.FileWriter
import java.nio.file.Paths
import kotlin.io.path.readText
import kotlin.io.path.writeText

@Serializable
data class ServerConfig(
    val serverName: String = "RSBox",
    val revision: Int = 209,
    val network: Network = Network()
) {
    @Serializable
    data class Network(
        val address: String = "127.0.0.1",
        val port: Int = 43594
    )

    companion object {

        internal fun loadConfig(): ServerConfig {
            if(!SERVER_CONFIG_PATH.exists()) {
                /*
                 * Create a default configuration file.
                 */
                Toml.encodeToString(serializer(), ServerConfig()).also {
                    Paths.get(SERVER_CONFIG_PATH.path).writeText(it)
                }
            }
            return Toml.decodeFromString(serializer(), Paths.get(SERVER_CONFIG_PATH.path).readText())
        }

    }
}