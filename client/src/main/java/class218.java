public class class218 extends class437 {
	static AbstractSocket field2589;
	static long field2591;
	class223[] field2595;

	public class218(class319 var1, class319 var2, int var3, boolean var4) {
		NodeDeque var5 = new NodeDeque();
		int var6 = var1.method6099(var3);
		this.field2595 = new class223[var6];
		int[] var7 = var1.method6098(var3);

		for (int var8 = 0; var8 < var7.length; ++var8) {
			byte[] var9 = var1.method6175(var3, var7[var8]);
			class230 var10 = null;
			int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

			for (class230 var12 = (class230)var5.method6364(); null != var12; var12 = (class230)var5.method6358()) {
				if (var11 == var12.field2740) {
					var10 = var12;
					break;
				}
			}

			if (var10 == null) {
				byte[] var13;
				if (var4) {
					var13 = var2.method6131(0, var11);
				} else {
					var13 = var2.method6131(var11, 0);
				}

				var10 = new class230(var11, var13);
				var5.method6355(var10);
			}

			this.field2595[var7[var8]] = new class223(var9, var10);
		}

	}

	public boolean method4367(int var1) {
		return this.field2595[var1].field2659;
	}

	static int method4369(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.CLIENTCLOCK) {
			class57.field404[++class387.field4452 - 1] = client.field1645;
			return 1;
		} else {
			int var4;
			int var5;
			if (var0 == CS2Opcodes.INV_GETOBJ) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				class57.field404[++class387.field4452 - 1] = class459.method8101(var4, var5);
				return 1;
			} else if (var0 == CS2Opcodes.INV_GETNUM) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = class145.method2500(var4, var5);
				return 1;
			} else if (var0 == CS2Opcodes.INV_TOTAL) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[class387.field4452 + 1];
				class57.field404[++class387.field4452 - 1] = class257.method5139(var4, var5);
				return 1;
			} else if (var0 == CS2Opcodes.INV_SIZE) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = class55.method1123(var4).field1586;
				return 1;
			} else if (var0 == CS2Opcodes.STAT) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = client.field1780[var4];
				return 1;
			} else if (var0 == CS2Opcodes.STAT_BASE) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = client.field1817[var4];
				return 1;
			} else if (var0 == CS2Opcodes.STAT_XP) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = client.field1782[var4];
				return 1;
			} else {
				int var6;
				if (var0 == CS2Opcodes.COORD) {
					var4 = class55.field396;
					var5 = class36.sceneBaseX + (class291.localPlayer.field827 >> 7);
					var6 = class169.sceneBaseY + (class291.localPlayer.field802 >> 7);
					class57.field404[++class387.field4452 - 1] = (var5 << 14) + (var4 << 28) + var6;
					return 1;
				} else if (var0 == CS2Opcodes.COORDX) {
					var4 = class57.field404[--class387.field4452];
					class57.field404[++class387.field4452 - 1] = var4 >> 14 & 16383;
					return 1;
				} else if (var0 == CS2Opcodes.COORDY) {
					var4 = class57.field404[--class387.field4452];
					class57.field404[++class387.field4452 - 1] = var4 >> 28;
					return 1;
				} else if (var0 == CS2Opcodes.COORDZ) {
					var4 = class57.field404[--class387.field4452];
					class57.field404[++class387.field4452 - 1] = var4 & 16383;
					return 1;
				} else if (var0 == CS2Opcodes.MAP_MEMBERS) {
					class57.field404[++class387.field4452 - 1] = client.field1635 ? 1 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.INVOTHER_GETOBJ) {
					class387.field4452 -= 2;
					var4 = 32768 + class57.field404[class387.field4452];
					var5 = class57.field404[1 + class387.field4452];
					class57.field404[++class387.field4452 - 1] = class459.method8101(var4, var5);
					return 1;
				} else if (var0 == CS2Opcodes.INVOTHER_GETNUM) {
					class387.field4452 -= 2;
					var4 = class57.field404[class387.field4452] + 32768;
					var5 = class57.field404[1 + class387.field4452];
					class57.field404[++class387.field4452 - 1] = class145.method2500(var4, var5);
					return 1;
				} else if (var0 == CS2Opcodes.INVOTHER_TOTAL) {
					class387.field4452 -= 2;
					var4 = 32768 + class57.field404[class387.field4452];
					var5 = class57.field404[1 + class387.field4452];
					class57.field404[++class387.field4452 - 1] = class257.method5139(var4, var5);
					return 1;
				} else if (var0 == CS2Opcodes.STAFFMODLEVEL) {
					if (client.privilegeLevel >= 2) {
						class57.field404[++class387.field4452 - 1] = client.privilegeLevel;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.REBOOTTIMER) {
					class57.field404[++class387.field4452 - 1] = client.rebootTimer;
					return 1;
				} else if (var0 == CS2Opcodes.MAP_WORLD) {
					class57.field404[++class387.field4452 - 1] = client.worldId;
					return 1;
				} else if (var0 == CS2Opcodes.RUNENERGY_VISIBLE) {
					class57.field404[++class387.field4452 - 1] = client.field1816;
					return 1;
				} else if (var0 == CS2Opcodes.RUNWEIGHT_VISIBLE) {
					class57.field404[++class387.field4452 - 1] = client.field1859;
					return 1;
				} else if (var0 == CS2Opcodes.PLAYERMOD) {
					if (client.isPlayerMod) {
						class57.field404[++class387.field4452 - 1] = 1;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.WORLDFLAGS) {
					class57.field404[++class387.field4452 - 1] = client.field1633;
					return 1;
				} else if (var0 == CS2Opcodes.MOVECOORD) {
					class387.field4452 -= 4;
					var4 = class57.field404[class387.field4452];
					var5 = class57.field404[1 + class387.field4452];
					var6 = class57.field404[2 + class387.field4452];
					int var7 = class57.field404[class387.field4452 + 3];
					var4 += var5 << 14;
					var4 += var6 << 28;
					var4 += var7;
					class57.field404[++class387.field4452 - 1] = var4;
					return 1;
				} else if (var0 == CS2Opcodes.MOUSE_GETX) {
					class57.field404[++class387.field4452 - 1] = client.field1647;
					return 1;
				} else if (var0 == CS2Opcodes.MOUSE_GETY) {
					class57.field404[++class387.field4452 - 1] = client.field1773;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}
