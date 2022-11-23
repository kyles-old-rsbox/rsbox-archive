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

import com.google.common.util.concurrent.ThreadFactoryBuilder
import io.rsbox.server.common.inject
import io.rsbox.server.engine.model.Privilege
import io.rsbox.server.engine.model.World
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.net.StatusResponse
import io.rsbox.server.engine.net.game.GameProtocol
import io.rsbox.server.engine.net.login.LoginRequest
import io.rsbox.server.engine.net.login.LoginResponse
import io.rsbox.server.engine.service.Service
import io.rsbox.server.util.security.SHA256
import kotlinx.coroutines.*
import org.tinylog.kotlin.Logger
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue

class LoginService : Service, Runnable {

    private val world: World by inject()

    private val executor = Executors.newFixedThreadPool(
        LOGIN_THREADS,
        ThreadFactoryBuilder()
            .setDaemon(false)
            .setNameFormat("login-thread")
            .build()
    )

    private val queue = LinkedBlockingQueue<LoginRequest>()

    override fun start() {
        repeat(LOGIN_THREADS) {
            executor.execute(this::run)
        }
    }

    override fun stop() {
        queue.clear()
        executor.shutdown()
    }

    fun submit(request: LoginRequest) {
        queue.add(request)
    }

    override fun run() {
        while(true) {
            val request = queue.take()

            val session = request.session

            val player = Player(session)
            player.username = request.username
            player.passwordHash = SHA256.hash(request.password ?: "")
            player.displayName = request.username
            player.privilege = Privilege.DEVELOPER
            session.xteas = request.xteas
            session.reconnectXteas = request.reconnectXteas
            player.login()
        }
    }

    private fun Player.login() {
        session.encoderIsaac.init(IntArray(4) { session.xteas[it] + 50 })
        session.decoderIsaac.init(session.xteas)

        world.players.addPlayer(this)
        LoginResponse(this).also { session.writeAndFlush(it) }
        session.protocol.set(GameProtocol(session))

        this.onLogin()
    }

    companion object {
        private const val LOGIN_THREADS = 4
    }
}