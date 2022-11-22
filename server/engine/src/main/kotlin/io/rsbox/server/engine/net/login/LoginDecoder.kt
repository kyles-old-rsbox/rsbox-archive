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

package io.rsbox.server.engine.net.login

import io.guthix.buffer.readString
import io.guthix.buffer.readVersionedString
import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.rsbox.server.common.inject
import io.rsbox.server.config.ServerConfig
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.StatusResponse
import io.rsbox.server.util.security.RSA
import io.rsbox.server.util.security.Xtea
import org.tinylog.kotlin.Logger
import java.math.BigInteger

class LoginDecoder(private val session: Session) {

    private val rsa: RSA by inject()

    private var stage = Stage.HANDSHAKE
    private var payloadSize = 0
    private var retries = 0
    private var reconnecting = false

    fun decode(buf: ByteBuf, out: MutableList<Any>) {
        try {
            when(stage) {
                Stage.HANDSHAKE -> readHandshake(buf, out)
                Stage.HEADER -> readHeader(buf, out)
                Stage.PAYLOAD -> readPayload(buf, out)
            }
        } catch(e : LoginError) {
            stage = Stage.HANDSHAKE
            buf.readBytes(buf.readableBytes())
            session.writeAndClose(e.status)
            return
        }
    }

    private fun readHandshake(buf: ByteBuf, out: MutableList<Any>) {
        val opcode = buf.readUnsignedByte().toInt()
        reconnecting = opcode == LOGIN_RECONNECT
        stage = Stage.HEADER
    }

    private fun readHeader(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() < Short.SIZE_BYTES) {
            retry()
            return
        }

        payloadSize = buf.readUnsignedShort()
        if(payloadSize == 0) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }

        retries = 0
        stage = Stage.PAYLOAD
    }

    private fun readPayload(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() < payloadSize) {
            retry()
            return
        }

        val clientRevision = buf.readInt()
        if(clientRevision != ServerConfig.REVISION) {
            throw LoginError(StatusResponse.OUT_OF_DATE)
        }

        buf.skipBytes(Int.SIZE_BYTES)
        val clientType = buf.readUnsignedByte().toInt()
        buf.skipBytes(Byte.SIZE_BYTES)
        buf.skipBytes(Byte.SIZE_BYTES)

        val rsaBuf = run {
            val length = buf.readUnsignedShort()
            buf.decryptRSA(rsa.exponent, rsa.modulus, length)
        }

        val payload = ByteArray(buf.readableBytes())
        buf.readBytes(payload)

        /*
         * ======== RSA BUFFER DECODE ========
         */

        val decryptCheck = rsaBuf.readByte().toInt()
        if(decryptCheck != 1) {
            throw LoginError(StatusResponse.BAD_SESSION_ID)
        }

        val xteas = IntArray(4) { rsaBuf.readInt() }
        val seed = rsaBuf.readLong()

        if(seed != session.seed) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }

        val authCode: Int?
        val password: String?
        var reconnectXteas: IntArray? = null

        if(reconnecting) {
            reconnectXteas = IntArray(4)  { rsaBuf.readInt() }
            authCode = null
            password = null
        } else {
            authCode = when(rsaBuf.readByte().toInt()) {
                0 -> rsaBuf.readInt()
                1,3 -> {
                    val value = rsaBuf.readUnsignedMedium()
                    rsaBuf.skipBytes(Byte.SIZE_BYTES)
                    value
                }
                else -> {
                    rsaBuf.skipBytes(Int.SIZE_BYTES)
                    -1
                }
            }

            rsaBuf.skipBytes(Byte.SIZE_BYTES)
            password = rsaBuf.readString()
        }

        /*
         * ======== XTEA BUFFER DECODE ========
         */

        val xteaBuf = Unpooled.wrappedBuffer(Xtea.decipher(payload, xteas))

        val username = xteaBuf.readString()
        if(username.isBlank() || Regex("[^a-zA-Z0-9\\d ]").containsMatchIn(username)) {
            throw LoginError(StatusResponse.INVALID_CREDENTIALS)
        }

        val flags = xteaBuf.readByte().toInt()
        val isResizable = (flags shr 1) == 1
        val clientWidth = xteaBuf.readUnsignedShort()
        val clientHeight = xteaBuf.readUnsignedShort()

        ByteArray(24) { xteaBuf.readByte() }

        xteaBuf.readString()
        xteaBuf.readInt()

        xteaBuf.skipBytes(18)
        xteaBuf.readVersionedString()
        xteaBuf.readVersionedString()
        xteaBuf.readVersionedString()
        xteaBuf.readVersionedString()
        xteaBuf.skipBytes(3)
        xteaBuf.readVersionedString()
        xteaBuf.readVersionedString()
        xteaBuf.skipBytes(2)
        repeat(3) { xteaBuf.skipBytes(4) }
        xteaBuf.skipBytes(4)
        xteaBuf.readVersionedString()
        xteaBuf.readVersionedString()
        xteaBuf.skipBytes(1)

        repeat(22) {
            xteaBuf.skipBytes(Int.SIZE_BYTES)
        }

        buf.readBytes(buf.readableBytes())

        val request = LoginRequest(
            session,
            username,
            password,
            authCode,
            seed,
            xteas,
            reconnectXteas,
            reconnecting
        )
        out.add(request)

        /*
         * Reset states
         */
        stage = Stage.HANDSHAKE
        payloadSize = 0
        reconnecting = false
        retries = 0
    }

    private class LoginError(val status: StatusResponse) : Exception()

    private enum class Stage {
        HANDSHAKE,
        HEADER,
        PAYLOAD
    }

    private fun retry() {
        retries++
        if(retries >= MAX_RETRIES) {
            throw LoginError(StatusResponse.COULD_NOT_COMPLETE_LOGIN)
        }
    }

    private fun ByteBuf.decryptRSA(exponent: BigInteger, modulus: BigInteger, length: Int): ByteBuf {
        val bytes = ByteArray(length)
        readBytes(bytes)
        return Unpooled.wrappedBuffer(BigInteger(bytes).modPow(exponent, modulus).toByteArray())
    }

    companion object {
        private const val LOGIN_NORMAL = 16
        private const val LOGIN_RECONNECT = 18
        private const val MAX_RETRIES = 5
    }
}