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
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.net.StatusResponse
import io.rsbox.server.engine.net.game.GameProtocol
import io.rsbox.server.engine.net.login.LoginRequest
import io.rsbox.server.engine.net.login.LoginResponse
import io.rsbox.server.engine.service.Service
import io.rsbox.server.engine.serializer.PlayerSerializer
import kotlinx.coroutines.*
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue

class LoginService : Service, Runnable {

    private val serializer: PlayerSerializer by inject()

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

            val player = serializer.load(request)
            if(player == null) {
                session.writeAndClose(StatusResponse.INVALID_CREDENTIALS)
                return
            }

            session.xteas = request.xteas
            session.reconnectXteas = request.reconnectXteas
            session.encoderIsaac.init(IntArray(4) { session.xteas[it] + 50 })
            session.decoderIsaac.init(session.xteas)

            player.prevTile = player.tile
            player.followTile = player.tile

            player.login()
        }
    }

    private fun Player.login() {
        world.players.addPlayer(this)

        val response = LoginResponse(this)
        session.writeAndFlush(response).addListener {
            if(it.isSuccess) {
                session.protocol.set(GameProtocol(session))
                this.onLogin()
            }
        }
    }

    companion object {
        private const val LOGIN_THREADS = 2
    }
}