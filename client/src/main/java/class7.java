public class class7 implements class27 {
	public static class319 field29;
	static class488 field24;
	static int field28;

	class7() {
	}

	public class28 method354() {
		return new class22();
	}

	static final void method46(String var0) {
		if (null != class73.field603) {
			PacketMessage var2 = class185.method3435(ClientPacket.field3073, client.serverConnection.isaacRandom);
			var2.buffer.writeByte(Buffer.method1887(var0));
			var2.buffer.writeString(var0);
			client.serverConnection.add(var2);
		}
	}
}
