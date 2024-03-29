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

import io.rsbox.server.engine.model.world.World
import io.rsbox.server.engine.model.worldlist.WorldList
import io.rsbox.server.engine.net.NetworkServer
import io.rsbox.server.engine.net.game.GamePackets
import io.rsbox.server.engine.net.http.HttpServer
import io.rsbox.server.engine.service.ServiceManager
import io.rsbox.server.engine.serializer.FilePlayerSerializer
import io.rsbox.server.engine.serializer.PlayerSerializer
import io.rsbox.server.util.security.RSA
import org.koin.dsl.module

val EngineModule = module {
    single { RSA() }
    single { Engine() }
    single { NetworkServer() }
    single { HttpServer() }
    single { WorldList() }
    single { World() }
    single { ServiceManager() }
    single { GamePackets() }
    single<PlayerSerializer> { FilePlayerSerializer() }
}