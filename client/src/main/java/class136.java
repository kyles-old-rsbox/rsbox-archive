public class class136 extends class137 {
	static class336 field1275;
	static class488 field1272;
	static int[] regionMapArchiveIds;
	int field1274;
	// $FF: synthetic field
	final class143 this$0;

	class136(class143 var1) {
		this.this$0 = var1;
		this.field1274 = -1;
	}

	void method2441(Buffer var1) {
		this.field1274 = var1.readUnsignedShort();
		var1.readUnsignedByte();
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

	}

	void method2442(class147 var1) {
		var1.method2504(this.field1274);
	}

	public static void method2438(class300 var0) {
		if (var0 != null && client.field1882 == var0.field3610) {
			client.field1860[var0.field3609] = true;
		}

	}

	public static void method2439(int var0, int var1, int var2, boolean var3) {
		PacketMessage var5 = class185.create(ClientPacket.field3040, client.serverConnection.isaacRandom);
		var5.buffer.writeByteSUB(var2);
		var5.buffer.writeIntAlt(var3 ? client.field1729 : 0);
		var5.buffer.writeShortLEADD(var0);
		var5.buffer.writeShortLE(var1);
		client.serverConnection.add(var5);
	}
}
