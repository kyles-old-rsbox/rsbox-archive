package io.rsbox.server.engine.net.packet.client

import io.rsbox.server.engine.event.EventBus
import io.rsbox.server.engine.event.impl.IfButtonClickEvent
import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.ClientPacket
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.util.buffer.JagByteBuf

@ClientPacket(opcode = 16, type = PacketType.FIXED, length = 8)
class IfButton1Packet(val parent: Int, val child: Int, val interfaceId: Int, val slot: Int) : Packet {

    override fun handle(session: Session) {
        val event = IfButtonClickEvent(session.player, 1, parent, child, interfaceId, slot)
        EventBus.postEvent(event)
    }

    companion object : Codec<IfButton1Packet> {
        override fun decode(session: Session, buf: JagByteBuf): IfButton1Packet {
            val packed = buf.readInt()
            val first = packed shr 16
            val second = packed and 0xFFFF
            val interfaceId = buf.readShort().toInt()
            val child = buf.readShort().toInt()
            return IfButton1Packet(first, second, interfaceId, child)
        }
    }
}