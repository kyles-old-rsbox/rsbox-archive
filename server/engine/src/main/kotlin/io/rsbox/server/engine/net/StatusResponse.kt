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

package io.rsbox.server.engine.net

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

enum class StatusResponse(val opcode: Int) : Message {
    SUCCESSFUL(0),
    DELAY(1),
    NORMAL(2),
    INVALID_CREDENTIALS(3),
    ACCOUNT_DISABLED(4),
    ACCOUNT_ONLINE(5),
    OUT_OF_DATE(6),
    WORLD_FULL(7),
    SERVER_OFFLINE(8),
    LOGIN_LIMIT_EXCEEDED(9),
    BAD_SESSION_ID(10),
    ACCOUNT_LOCKED(11),
    MEMBERS_ACCOUNT_REQUIRED(12),
    COULD_NOT_COMPLETE_LOGIN(13),
    SERVER_UPDATE(14),
    RECONNECTING(15),
    TOO_MANY_LOGIN_ATTEMPTS(16),
    MEMBERS_ONLY_AREA(17),
    WORLD_CLOSED_BETA(19),
    INVALID_LOGIN_SERVER(20),
    MALFORMED_PACKET(22),
    LOGIN_NO_RESPONSE(23),
    FAILED_TO_LOAD_PROFILE(24),
    INVALID_LOGIN_SERVER_RESPONSE(25),
    IP_ADDRESS_BLOCKED(26),
    SERVICE_UNAVAILABLE(27),
    NO_DISPLAY_NAME(31),
    ACCOUNT_INACCESSIBLE(37),
    VOTE_TO_PLAY(38),
    ENTER_AUTH_CODE(56),
    INVALID_AUTH_CODE(57),
    LOGIN_ATTEMPT_TIMEOUT(62),
    SIGNED_OUT(63),
    FAILED_TO_LOGIN(65);

    class Encoder : MessageToByteEncoder<StatusResponse>() {
        override fun encode(ctx: ChannelHandlerContext, msg: StatusResponse, out: ByteBuf) {
            out.writeByte(msg.opcode)
        }
    }
}