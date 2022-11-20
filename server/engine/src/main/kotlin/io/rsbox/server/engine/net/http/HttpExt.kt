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

package io.rsbox.server.engine.net.http

import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.HttpHeaderNames
import io.netty.handler.codec.http.HttpResponseStatus
import io.netty.handler.codec.http.HttpVersion

fun ChannelHandlerContext.writeHttpError(status: HttpResponseStatus, error: String = "Failed: $status\r\n") {
    val response = DefaultFullHttpResponse(
        HttpVersion.HTTP_1_1,
        status,
        Unpooled.copiedBuffer(error, Charsets.UTF_8)
    )
    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8")
    writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)
}

fun ChannelHandlerContext.writeHttpFile(file: ByteArray, name: String) {
    val response = DefaultFullHttpResponse(
        HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
        Unpooled.wrappedBuffer(file)
    )
    response.headers().set(HttpHeaderNames.SERVER, "JaGeX/3.1")
    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/octet-stream")
    response.headers().set(HttpHeaderNames.CONTENT_LENGTH, file.size)
    response.headers().set(HttpHeaderNames.CONTENT_DISPOSITION, name)
    response.headers().set(HttpHeaderNames.CONTENT_ENCODING, "lzma")

    channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)
}

fun ChannelHandlerContext.writeHttpText(text: ByteArray) {
    val response = DefaultFullHttpResponse(
        HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
        Unpooled.wrappedBuffer(text)
    )
    response.headers().set(HttpHeaderNames.SERVER, "JaGeX/3.1")
    response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=ISO-8859-1")
    response.headers().set(HttpHeaderNames.CONTENT_LENGTH, text.size)

    channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE)
}