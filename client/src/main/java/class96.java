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
		int var3 = PlayerManager.localPlayerCount;
		int[] var4 = PlayerManager.localPlayerIndexes;
		boolean var5 = false;
		DisplayName var6 = new DisplayName(var1, class234.gameEngineMode);

		for (int var7 = 0; var7 < var3; ++var7) {
			PlayerEntity var8 = client.localPlayers[var4[var7]];
			if (null != var8 && class291.localPlayer != var8 && null != var8.displayName && var8.displayName.equals(var6)) {
				PacketMessage var9;
				if (var0 == 1) {
					var9 = class185.create(ClientPacket.field3110, client.serverConnection.isaacRandom);
					var9.buffer.writeByteSUB(0);
					var9.buffer.writeShortLEADD(var4[var7]);
					client.serverConnection.add(var9);
				} else if (var0 == 4) {
					var9 = class185.create(ClientPacket.field3042, client.serverConnection.isaacRandom);
					var9.buffer.writeByteSUB(0);
					var9.buffer.writeShortLE(var4[var7]);
					client.serverConnection.add(var9);
				} else if (var0 == 6) {
					var9 = class185.create(ClientPacket.field3070, client.serverConnection.isaacRandom);
					var9.buffer.writeShortLEADD(var4[var7]);
					var9.buffer.writeByteSUB(0);
					client.serverConnection.add(var9);
				} else if (var0 == 7) {
					var9 = class185.create(ClientPacket.field3089, client.serverConnection.isaacRandom);
					var9.buffer.writeShort(var4[var7]);
					var9.buffer.writeByte(0);
					client.serverConnection.add(var9);
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
