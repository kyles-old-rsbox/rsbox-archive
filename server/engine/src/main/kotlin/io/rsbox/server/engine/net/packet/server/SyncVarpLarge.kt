package io.rsbox.server.engine.net.packet.server

import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.engine.net.game.ServerPacket
import io.rsbox.server.util.buffer.ADD
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.LITTLE

@ServerPacket(opcode = 76, type = PacketType.FIXED)
class SyncVarpLarge(val id: Int, val value: Int) : Packet {
    companion object : Codec<SyncVarpLarge> {
        override fun encode(session: Session, packet: SyncVarpLarge, out: JagByteBuf) {
            out.writeInt(packet.value)
            out.writeShort(packet.id, endian = LITTLE, transform = ADD)
        }
    }
}