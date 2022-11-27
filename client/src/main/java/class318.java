import java.io.IOException;

public class class318 implements class360 {
	public static final class318 field3727;
	public static final class318 field3728;
	public static final class318 field3729;
	public static final class318 field3731;
	static int field3732;
	final int field3730;

	static {
		field3731 = new class318(-1);
		field3727 = new class318(0);
		field3729 = new class318(1);
		field3728 = new class318(2);
	}

	class318(int var1) {
		this.field3730 = var1;
	}

	public int rsOrdinal() {
		return this.field3730;
	}

	static final void method6083(boolean var0) {
		class349.method6457();
		++client.serverConnection.field1077;
		if (client.serverConnection.field1077 >= 50 || var0) {
			client.serverConnection.field1077 = 0;
			if (!client.field1697 && client.serverConnection.method2082() != null) {
				PacketMessage var2 = class185.method3435(ClientPacket.NO_TIMEOUT, client.serverConnection.isaacRandom);
				client.serverConnection.add(var2);

				try {
					client.serverConnection.flush();
				} catch (IOException var4) {
					client.field1697 = true;
				}
			}

		}
	}
}
