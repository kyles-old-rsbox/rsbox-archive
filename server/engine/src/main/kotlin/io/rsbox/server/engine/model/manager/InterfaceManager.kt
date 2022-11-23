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

package io.rsbox.server.engine.model.manager

import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.engine.model.ui.DisplayMode
import io.rsbox.server.engine.model.ui.GameInterface
import io.rsbox.server.engine.model.ui.InterfaceType
import io.rsbox.server.engine.net.packet.server.IfMoveSubPacket
import io.rsbox.server.engine.net.packet.server.IfOpenSubPacket
import io.rsbox.server.engine.net.packet.server.IfOpenTopPacket

class InterfaceManager(private val player: Player) {

    private val interfaces = hashMapOf<Int, Int>()
    private var modal: Int = -1
    private var currentDisplayMode = DisplayMode.RESIZABLE_CLASSIC

    fun init() {
        openTopInterface(currentDisplayMode.id)

        GameInterface.values().forEach { gameInterface ->
            openInterface(gameInterface)
        }

        updateDisplayMode()
    }

    private fun open(parent: Int, child: Int, interfaceId: Int) {
        val component = (parent shl 16) or child
        if(interfaces.containsKey(component)) close(component)
        interfaces[component] = interfaceId
    }

    private fun close(component: Int) {
        interfaces.remove(component)
    }

    private fun openModal(parent: Int, child: Int, interfaceId: Int) {
        open(parent, child, interfaceId)
        modal = interfaceId
    }

    fun openTopInterface(interfaceId: Int) {
        open(interfaceId, 0, interfaceId)
        player.session.writeAndFlush(IfOpenTopPacket(interfaceId))
    }

    fun openInterface(parent: Int, child: Int, interfaceId: Int, type: InterfaceType) {
        if(type == InterfaceType.MODAL) {
            openModal(parent, child, interfaceId)
        } else {
            open(parent, child, interfaceId)
        }
        player.session.writeAndFlush(IfOpenSubPacket(parent, child, interfaceId, type))
    }

    fun openInterface(interfaceId: Int, gameInterface: GameInterface) {
        val parent = currentDisplayMode.id
        val child = gameInterface.getChildId(currentDisplayMode) ?: return
        openInterface(parent, child, interfaceId, InterfaceType.MODAL)
    }

    fun openInterface(gameInterface: GameInterface) {
        val parent = currentDisplayMode.id
        val child = gameInterface.getChildId(currentDisplayMode) ?: return
        openInterface(parent, child, gameInterface.interfaceId, gameInterface.type)
    }

    fun updateDisplayMode() {
        openTopInterface(player.displayMode.id)

        interfaces.keys.forEach { component ->
            val fromParent = component shr 16
            val fromChild = component and 0xFFFF
            val toParent = player.displayMode.id
            val toChild = GameInterface.fromChild(currentDisplayMode, fromChild)?.getChildId(player.displayMode)
            if(toChild != null) {
                player.session.write(IfMoveSubPacket(fromParent, fromChild, toParent, toChild))
            }
        }

        currentDisplayMode = player.displayMode
    }
}