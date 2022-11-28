package io.rsbox.server.engine.net.packet.server

import io.rsbox.server.engine.net.Session
import io.rsbox.server.engine.net.game.Codec
import io.rsbox.server.engine.net.game.Packet
import io.rsbox.server.engine.net.game.PacketType
import io.rsbox.server.engine.net.game.ServerPacket
import io.rsbox.server.util.buffer.ADD
import io.rsbox.server.util.buffer.JagByteBuf
import io.rsbox.server.util.buffer.SUB

@ServerPacket(opcode = 31, type = PacketType.FIXED)
class SyncVarpSmall(val id: Int, val value: Int) : Packet {
    companion object : Codec<SyncVarpSmall> {
        override fun encode(session: Session, packet: SyncVarpSmall, out: JagByteBuf) {
            out.writeByte(packet.value, transform = SUB)
            out.writeShort(packet.id, transform = ADD)
        }
    }
}