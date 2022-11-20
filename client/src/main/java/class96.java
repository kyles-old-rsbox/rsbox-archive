public class class96 {
	static class109 field962;
	static String field958;
	static String field959;
	static String field960;
	static String field963;
	static String field964;
	static String field965;
	static String field966;
	static String field967;

	static {
		field967 = "true";
		field959 = ",";
		field960 = "|";
		field964 = " (";
		field958 = ")";
		field963 = "->";
		field966 = "<br>";
		field965 = "</col>";
	}

	class96() throws Throwable {
		throw new Error();
	}

	static String method5151(int var0) {
		return "<img=" + var0 + ">";
	}

	static String method4510(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}

	static final void method1961(int var0, int var1, int var2) {
		if (class215.field2568 < var0) {
			class215.field2568 += (var0 - class215.field2568) * class109.field1086 / 1000 + class318.field3732;
			if (class215.field2568 > var0) {
				class215.field2568 = var0;
			}
		}

		if (class215.field2568 > var0) {
			class215.field2568 -= class318.field3732 + (class215.field2568 - var0) * class109.field1086 / 1000;
			if (class215.field2568 < var0) {
				class215.field2568 = var0;
			}
		}

		if (class32.field204 < var1) {
			class32.field204 += class109.field1086 * (var1 - class32.field204) / 1000 + class318.field3732;
			if (class32.field204 > var1) {
				class32.field204 = var1;
			}
		}

		if (class32.field204 > var1) {
			class32.field204 -= class318.field3732 + (class32.field204 - var1) * class109.field1086 / 1000;
			if (class32.field204 < var1) {
				class32.field204 = var1;
			}
		}

		if (class323.field3766 < var2) {
			class323.field3766 += (var2 - class323.field3766) * class109.field1086 / 1000 + class318.field3732;
			if (class323.field3766 > var2) {
				class323.field3766 = var2;
			}
		}

		if (class323.field3766 > var2) {
			class323.field3766 -= class318.field3732 + (class323.field3766 - var2) * class109.field1086 / 1000;
			if (class323.field3766 < var2) {
				class323.field3766 = var2;
			}
		}

	}

	static void method1959(int var0, String var1) {
		int var3 = PlayerManager.playerCount;
		int[] var4 = PlayerManager.field1013;
		boolean var5 = false;
		class472 var6 = new class472(var1, class234.field2779);

		for (int var7 = 0; var7 < var3; ++var7) {
			class93 var8 = client.players[var4[var7]];
			if (null != var8 && class291.field3364 != var8 && null != var8.field910 && var8.field910.equals(var6)) {
				PacketBufferNode var9;
				if (var0 == 1) {
					var9 = class185.method3435(class274.field3110, client.packetWriter.isaacRandom);
					var9.buffer.method8152(0);
					var9.buffer.method8161(var4[var7]);
					client.packetWriter.add(var9);
				} else if (var0 == 4) {
					var9 = class185.method3435(class274.field3042, client.packetWriter.isaacRandom);
					var9.buffer.method8152(0);
					var9.buffer.method8159(var4[var7]);
					client.packetWriter.add(var9);
				} else if (var0 == 6) {
					var9 = class185.method3435(class274.field3070, client.packetWriter.isaacRandom);
					var9.buffer.method8161(var4[var7]);
					var9.buffer.method8152(0);
					client.packetWriter.add(var9);
				} else if (var0 == 7) {
					var9 = class185.method3435(class274.field3089, client.packetWriter.isaacRandom);
					var9.buffer.writeShort(var4[var7]);
					var9.buffer.writeByte(0);
					client.packetWriter.add(var9);
				}

				var5 = true;
				break;
			}
		}

		if (!var5) {
			MouseManager.method773(4, "", class338.field4053 + var1);
		}

	}
}
