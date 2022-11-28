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

package io.rsbox.server.engine.model.entity.update

import io.rsbox.server.engine.model.Privilege
import io.rsbox.server.engine.model.entity.Player
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.NEG
import io.rsbox.server.util.buffer.toJagBuf
import java.lang.Integer.max

class PlayerUpdateFlag(order: Int, mask: Int, val encode: JagByteBuf.(Player) -> Unit) : UpdateFlag(order, mask) {
    companion object {

        /**
         * == Appearance Flag ==
         */
        val APPEARANCE = PlayerUpdateFlag(order = 3, mask = 0x40) { player ->
            val buf = player.session.ctx.alloc().buffer().toJagBuf()

            buf.writeByte(player.appearance.gender.id)
            buf.writeByte(player.skullIcon)
            buf.writeByte(player.prayerIcon)

            for(i in 0 until 12) {
                if(STYLE_OFFSETS[i] == -1) {
                    buf.writeByte(0)
                } else {
                    buf.writeShort(0x100 + player.appearance.styles[STYLE_OFFSETS[i]])
                }
            }

            for(i in 0 until 5) {
                buf.writeByte(max(0, player.appearance.colors[i]))
            }

            player.stanceAnimations.forEach { anim ->
                buf.writeShort(anim)
            }

            val displayNamePrefix = if(player.privilege.id > 0) "<img=${player.privilege.id - Privilege.MODERATOR.id}> " else ""
            buf.writeString(displayNamePrefix + player.displayName)
            buf.writeByte(3)
            buf.writeShort(0)
            buf.writeByte(if(player.invisible) 1 else 0)
            buf.writeShort(0)
            repeat(3) { buf.writeString("") }
            buf.writeByte(player.appearance.gender.id)

            this.writeByte(buf.writerIndex(), transform = NEG)
            this.writeBytes(buf.toByteBuf())
            buf.release()
        }

        val MOVEMENT = PlayerUpdateFlag(order = 4, mask = 0x1000) { player ->
            this.writeByte(player.movementState.id)
        }

        private val STYLE_OFFSETS = intArrayOf(-1, -1, -1, -1, 2, -1, 3, 5, 0, 4, 6, 1)
    }
}