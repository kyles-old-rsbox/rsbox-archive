public class class228 extends class239 {
	class228() {
	}

	void method4518(Buffer var1) {
		int var3 = var1.readUnsignedByte();
		if (class256.field2950.field2947 != var3) {
			throw new IllegalStateException("");
		} else {
			super.field2815 = var1.readUnsignedByte();
			super.field2813 = var1.readUnsignedByte();
			super.field2821 = var1.readUnsignedShort();
			super.field2809 = var1.readUnsignedShort();
			super.field2810 = var1.readUnsignedShort();
			super.field2811 = var1.readUnsignedShort();
			super.field2814 = var1.method8140();
			super.field2820 = var1.method8140();
		}
	}

	void method4655(Buffer var1) {
		super.field2813 = Math.min(super.field2813, 4);
		super.field2816 = new short[1][64][64];
		super.field2808 = new short[super.field2813][64][64];
		super.field2818 = new byte[super.field2813][64][64];
		super.field2819 = new byte[super.field2813][64][64];
		super.field2812 = new class253[super.field2813][64][64][];
		int var3 = var1.readUnsignedByte();
		if (var3 != class250.field2900.field2901) {
			throw new IllegalStateException("");
		} else {
			int var4 = var1.readUnsignedByte();
			int var5 = var1.readUnsignedByte();
			if (var4 == super.field2810 && var5 == super.field2811) {
				for (int var6 = 0; var6 < 64; ++var6) {
					for (int var7 = 0; var7 < 64; ++var7) {
						this.method4656(var6, var7, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class228)) {
			return false;
		} else {
			class228 var2 = (class228)var1;
			return super.field2810 == var2.field2810 && super.field2811 == var2.field2811;
		}
	}

	public int hashCode() {
		return super.field2810 | super.field2811 << 8;
	}

	static void resetWorld() {
		client.serverConnection.reset();
		client.serverConnection.buffer.offset = 0;
		client.serverConnection.serverPacket = null;
		client.serverConnection.field1079 = null;
		client.serverConnection.field1072 = null;
		client.serverConnection.field1080 = null;
		client.serverConnection.serverPacketLength = 0;
		client.serverConnection.field1070 = 0;
		client.rebootTimer = 0;
		client.menuOptionsCount = 0;
		client.isMenuOpen = false;
		client.minimapState = 0;
		client.destinationX = 0;

		int var1;
		for (var1 = 0; var1 < 2048; ++var1) {
			client.players[var1] = null;
		}

		class291.localPlayer = null;

		for (var1 = 0; var1 < client.npcs.length; ++var1) {
			class81 var2 = client.npcs[var1];
			if (null != var2) {
				var2.interacting = -1;
				var2.field836 = false;
			}
		}

		class87.method2410();
		class9.method64(30);

		for (var1 = 0; var1 < 100; ++var1) {
			client.field1860[var1] = true;
		}

		client.method206();
	}

	static final void method4515(int var0, int var1) {
		if (client.menuOptionsCount >= 2 || client.isItemSelected != 0 || client.isSpellSelected) {
			if (client.field1797) {
				int var3 = client.method5125();
				String var4;
				if (client.isItemSelected == 1 && client.menuOptionsCount < 2) {
					var4 = class338.field3898 + class338.field4064 + client.field1803 + " " + class96.field963;
				} else if (client.isSpellSelected && client.menuOptionsCount < 2) {
					var4 = client.field1653 + class338.field4064 + client.field1754 + " " + class96.field963;
				} else {
					var4 = class233.method4558(var3);
				}

				if (client.menuOptionsCount > 2) {
					var4 = var4 + class96.method4510(16777215) + " " + '/' + " " + (client.menuOptionsCount - 2) + class338.field4058;
				}

				class114.field1127.method6860(var4, var0 + 4, var1 + 15, 16777215, 0, client.field1645 / 1000);
			}
		}
	}
}
