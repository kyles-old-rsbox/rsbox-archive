public final class class272 {
	static long field3034;
	static long field3035;

	class272() throws Throwable {
		throw new Error();
	}

	public static final synchronized long method2046() {
		long var1 = System.currentTimeMillis();
		if (var1 < field3034) {
			field3035 += field3034 - var1;
		}

		field3034 = var1;
		return field3035 + var1;
	}

	static void method5220(int var0, int var1, int var2, int var3, String var4) {
		class300 var6 = class253.method5043(var1, var2);
		if (null != var6) {
			if (var6.field3549 != null) {
				class79 var7 = new class79();
				var7.field694 = var6;
				var7.field690 = var0;
				var7.field685 = var4;
				var7.field686 = var6.field3549;
				class57.method5433(var7);
			}

			boolean var12 = true;
			if (var6.field3464 > 0) {
				var12 = class157.method2603(var6);
			}

			if (var12) {
				int var9 = class190.method3528(var6);
				int var10 = var0 - 1;
				boolean var8 = 0 != (var9 >> var10 + 1 & 1);
				if (var8) {
					PacketBufferNode var11;
					if (var0 == 1) {
						var11 = class185.method3435(class274.field3055, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 2) {
						var11 = class185.method3435(class274.field3076, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 3) {
						var11 = class185.method3435(class274.field3085, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 4) {
						var11 = class185.method3435(class274.field3058, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 5) {
						var11 = class185.method3435(class274.field3068, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 6) {
						var11 = class185.method3435(class274.field3046, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 7) {
						var11 = class185.method3435(class274.field3116, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 8) {
						var11 = class185.method3435(class274.field3062, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 9) {
						var11 = class185.method3435(class274.field3061, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

					if (var0 == 10) {
						var11 = class185.method3435(class274.field3045, client.packetWriter.isaacRandom);
						var11.buffer.writeInt(var1);
						var11.buffer.writeShort(var2);
						var11.buffer.writeShort(var3);
						client.packetWriter.add(var11);
					}

				}
			}
		}
	}
}
