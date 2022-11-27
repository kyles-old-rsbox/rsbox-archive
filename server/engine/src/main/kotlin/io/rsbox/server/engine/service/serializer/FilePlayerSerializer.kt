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

package io.rsbox.server.engine.service.serializer

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec
import com.uchuhimo.konf.source.toml
import com.uchuhimo.konf.source.toml.toToml
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.model.Privilege
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.ui.DisplayMode
import io.rsbox.server.engine.net.login.LoginRequest
import io.rsbox.server.util.security.SHA256
import org.tinylog.kotlin.Logger
import java.io.File
import kotlin.random.Random
import kotlin.random.nextLong

class FilePlayerSerializer : PlayerSerializer {

    override fun create(request: LoginRequest): Boolean {
        Logger.info("Creating new player account. [username: ${request.username}].")
        val filteredUsername = request.username.filterUsername()
        val passwordHash = SHA256.hash(request.password ?: "")
        if(filteredUsername.isBlank()) return false

        val file = File("data/saves/${filteredUsername.replace(" ", "_")}.toml")
        if(file.exists()) {
            return false
        }

        val config = Config { addSpec(Spec) }
        config[Spec.username] = filteredUsername
        config[Spec.password] = passwordHash
        config[Spec.displayName] = filteredUsername
        config[Spec.uuid] = Random.nextLong(0L..Long.MAX_VALUE)
        config[Spec.displayMode] = DisplayMode.FIXED
        config[Spec.privilege] = Privilege.ADMINISTRATOR
        config[Spec.member] = true

        config[Spec.Tile.x] = ServerConfig.DEFAULTS.HOME_TILE.X
        config[Spec.Tile.y] = ServerConfig.DEFAULTS.HOME_TILE.Y
        config[Spec.Tile.level] = ServerConfig.DEFAULTS.HOME_TILE.LEVEL

        config[Spec.HomeTile.x] = ServerConfig.DEFAULTS.HOME_TILE.X
        config[Spec.HomeTile.y] = ServerConfig.DEFAULTS.HOME_TILE.Y
        config[Spec.HomeTile.level] = ServerConfig.DEFAULTS.HOME_TILE.LEVEL

        config.toToml.toFile(file)
        return true
    }

    override fun load(request: LoginRequest): Player? {
        val filteredUsername = request.username.filterUsername()
        val passwordHash = SHA256.hash(request.password ?: "")
        if(filteredUsername.isBlank()) return null

        val file = File("data/saves/${filteredUsername.replace(" ", "_")}.toml")
        if(!file.exists()) {
            if(!create(request)) {
                return null
            }
        }

        val config = Config { addSpec(Spec) }.from.toml.file(file)

        if(passwordHash != config[Spec.password]) {
            return null
        }

        val player = Player(request.session)
        player.username = config[Spec.username]
        player.displayName = config[Spec.displayName]
        player.passwordHash = config[Spec.password]
        player.uuid = config[Spec.uuid]
        player.privilege = config[Spec.privilege]
        player.displayMode = config[Spec.displayMode]
        player.member = config[Spec.member]

        return player
    }

    override fun save(player: Player): Boolean {
        val filteredUsername = player.username.filterUsername()
        val file = File("data/saves/${filteredUsername.replace(" ", "_")}.toml")
        if(!file.exists()) {
            return false
        }

        val config = Config { addSpec(Spec) }
        config[Spec.username] = player.username
        config[Spec.password] = player.passwordHash
        config[Spec.displayName] = player.displayName
        config[Spec.uuid] = player.uuid
        config[Spec.displayMode] = player.displayMode
        config[Spec.privilege] = player.privilege
        config[Spec.member] = player.member

        config[Spec.Tile.x] = player.tile.x
        config[Spec.Tile.y] = player.tile.y
        config[Spec.Tile.level] = player.tile.level

        config.toToml.toFile(file)
        return true
    }

    private fun String.filterUsername() = this.replace(Regex("[^a-zA-Z0-9\\d ]"), "")

    private object Spec : ConfigSpec("player") {
        val username by required<String>("username")
        val displayName by required<String>("display-name")
        val password by required<String>("password")
        val privilege by required<Privilege>("privilege")
        val member by required<Boolean>("member")
        val uuid by required<Long>("uuid")
        val displayMode by required<DisplayMode>("display-mode")

        object Tile : ConfigSpec("tile") {
            val x by required<Int>("x")
            val y by required<Int>("y")
            val level by required<Int>("level")
        }

        object HomeTile : ConfigSpec("home-tile") {
            val x by required<Int>("x")
            val y by required<Int>("y")
            val level by required<Int>("level")
        }
    }
}