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

    private var reconnecting = false
    private lateinit var username: String
    private var password: String? = null
    private var authCode: Int? = null
    private lateinit var xteas: IntArray
    private var reconnectXteas: IntArray? = null

    fun decode(buf: ByteBuf, out: MutableList<Any>) {
        try {
            when(stage) {
                Stage.HANDSHAKE -> readHandshake(buf, out)
                Stage.HEADER -> readHeader(buf, out)
                Stage.PAYLOAD -> readPayload(buf, out)
            }
        } catch(e : LoginError) {
            session.writeAndFlush(e.status).addListener {
                if(it.isSuccess) session.disconnect()
            }
        } catch(e : Exception) {
            Logger.error(e) { "An error occurred while logging in." }
            session.disconnect()
        }
    }

    private fun readHandshake(buf: ByteBuf, out: MutableList<Any>) {
        val opcode = buf.readUnsignedByte().toInt()
        if(opcode != LOGIN_NORMAL && opcode != LOGIN_RECONNECT) {
            throw LoginError(StatusResponse.FAILED_TO_LOGIN)
        }
        reconnecting = opcode == LOGIN_RECONNECT
        stage = Stage.HEADER
    }

    private fun readHeader(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() < Short.SIZE_BYTES) return
        payloadSize = buf.readUnsignedShort()
        stage = Stage.PAYLOAD
    }

    private fun readPayload(buf: ByteBuf, out: MutableList<Any>) {
        if(buf.readableBytes() < payloadSize) return

        // Check Revision
        val clientRevision = buf.readInt()
        if(clientRevision != ServerConfig.REVISION) {
            throw LoginError(StatusResponse.OUT_OF_DATE)
        }

        buf.skipBytes(Int.SIZE_BYTES)
        buf.skipBytes(Byte.SIZE_BYTES)
        buf.skipBytes(Byte.SIZE_BYTES)
        buf.skipBytes(Byte.SIZE_BYTES)

        /*
         * == RSA BUFFER ==
         */
        val rsaBuf = run {
            val length = buf.readUnsignedShort()
            val data = ByteArray(length)
            buf.readBytes(data)
            val decryptData = BigInteger(data).modPow(rsa.exponent, rsa.modulus)
            Unpooled.wrappedBuffer(decryptData.toByteArray())
        }

        val payloadData = ByteArray(buf.readableBytes())
        buf.readBytes(payloadData)

        // Read data from RSA encrypted buffer.
        readRSABuf(rsaBuf)

        /*
         * == XTEA BUFFER ==
         */
        val xteaData = Xtea.decipher(payloadData, xteas)
        val xteaBuf = Unpooled.wrappedBuffer(xteaData)

        // Read data from the XTEA encrypted buffer.
        readXTEABuf(xteaBuf)

        /*
         * Submit the login request network message for the engine
         * to process.
         */
        LoginRequest(
            session,
            username,
            password,
            authCode,
            session.seed,
            xteas,
            reconnectXteas,
            reconnecting
        ).also { out.add(it) }
    }

    private fun readRSABuf(buf: ByteBuf) {
        val decryptionCheck = buf.readUnsignedByte().toInt()
        if(decryptionCheck != 1) {
            Logger.warn("Invalid RSA public/private key. Failed to decrypt the RSA login request. Make sure the client's modulus is correct.")
            throw LoginError(StatusResponse.BAD_SESSION_ID)
        }

        xteas = IntArray(4) { buf.readInt() }
        val clientSeed = buf.readLong()

        if(clientSeed != session.seed) {
            throw LoginError(StatusResponse.MALFORMED_PACKET)
        }

        if(reconnecting) {
            reconnectXteas = IntArray(4) { buf.readInt() }
            password = null
            authCode = null
        } else {
            authCode = when(buf.readByte().toInt()) {
                1,3 -> {
                    val value = buf.readUnsignedMedium()
                    buf.skipBytes(Byte.SIZE_BYTES)
                    value
                }
                2 -> {
                    buf.skipBytes(Int.SIZE_BYTES)
                    -1
                }
                else -> buf.readInt()
            }
            buf.skipBytes(Byte.SIZE_BYTES)
            password = buf.readString()
        }
    }

    private fun readXTEABuf(buf: ByteBuf) {
        username = buf.readString()
        if(username.isBlank()) {
            throw LoginError(StatusResponse.INVALID_CREDENTIALS)
        }

        /*
         * Skip the rest of the payload bytes.
         */
        buf.skipBytes(buf.readableBytes())
    }

    private class LoginError(val status: StatusResponse) : Exception()

    private enum class Stage {
        HANDSHAKE,
        HEADER,
        PAYLOAD
    }

    companion object {
        private const val LOGIN_NORMAL = 16
        private const val LOGIN_RECONNECT = 18
    }
}