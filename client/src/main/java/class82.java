public final class class82 {
	static byte[][][] field714;
	static byte[][][] field718;
	static int field724;
	static int field727;
	static int field728;
	static int[][] field717;
	static int[][][] field719;
	static short[][][] field716;
	static short[][][] field723;
	static final int[] field713;
	static final int[] field715;
	static final int[] field721;
	static final int[] field722;
	static final int[] field725;
	static final int[] field726;

	static {
		field719 = new int[4][105][105];
		field714 = new byte[4][104][104];
		field724 = 99;
		field721 = new int[]{1, 2, 4, 8};
		field722 = new int[]{16, 32, 64, 128};
		field713 = new int[]{1, 0, -1, 0};
		field725 = new int[]{0, -1, 0, 1};
		field715 = new int[]{1, -1, -1, 1};
		field726 = new int[]{-1, -1, 1, 1};
		field727 = (int)(Math.random() * 17.0D) - 8;
		field728 = (int)(Math.random() * 33.0D) - 16;
	}

	class82() throws Throwable {
		throw new Error();
	}

	static void method1589() {
		field724 = 99;
		field716 = new short[4][104][104];
		field723 = new short[4][104][104];
		field718 = new byte[4][104][104];
		class179.field1597 = new byte[4][104][104];
		class128.field1231 = new int[4][105][105];
		class30.field160 = new byte[4][105][105];
		field717 = new int[105][105];
		class30.field162 = new int[104];
		class53.field381 = new int[104];
		class403.field4509 = new int[104];
		class133.field1250 = new int[104];
		class406.field4527 = new int[104];
	}

	static void method1271() {
		field716 = (short[][][])null;
		field723 = (short[][][])null;
		field718 = (byte[][][])null;
		class179.field1597 = (byte[][][])null;
		class128.field1231 = (int[][][])null;
		class30.field160 = (byte[][][])null;
		field717 = (int[][])null;
		class30.field162 = null;
		class53.field381 = null;
		class403.field4509 = null;
		class133.field1250 = null;
		class406.field4527 = null;
	}

	static final void method1668(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, class200[] var9) {
		Buffer var10 = new Buffer(var0);
		int var11 = -1;

		while (true) {
			int var12 = var10.method8138();
			if (var12 == 0) {
				return;
			}

			var11 += var12;
			int var13 = 0;

			while (true) {
				int var14 = var10.method8207();
				if (var14 == 0) {
					break;
				}

				var13 += var14 - 1;
				int var15 = var13 & 63;
				int var16 = var13 >> 6 & 63;
				int var17 = var13 >> 12;
				int var18 = var10.readUnsignedByte();
				int var19 = var18 >> 2;
				int var20 = var18 & 3;
				if (var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
					class195 var21 = InterfaceParent.method1866(var11);
					int var22 = var2 + AttackOption.method1613(var16 & 7, var15 & 7, var7, var21.field2100, var21.field2069, var20);
					int var23 = var3 + class213.method4119(var16 & 7, var15 & 7, var7, var21.field2100, var21.field2069, var20);
					if (var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
						int var24 = var1;
						if (2 == (field714[1][var22][var23] & 2)) {
							var24 = var1 - 1;
						}

						class200 var25 = null;
						if (var24 >= 0) {
							var25 = var9[var24];
						}

						class458.method8090(var1, var22, var23, var11, var7 + var20 & 3, var19, var8, var25);
					}
				}
			}
		}
	}

	static final int method6259(int var0, int var1, int var2) {
		int var4 = var0 / var2;
		int var5 = var0 & var2 - 1;
		int var6 = var1 / var2;
		int var7 = var1 & var2 - 1;
		int var8 = method431(var4, var6);
		int var9 = method431(var4 + 1, var6);
		int var10 = method431(var4, var6 + 1);
		int var11 = method431(var4 + 1, var6 + 1);
		int var13 = 65536 - class221.field2645[var5 * 1024 / var2] >> 1;
		int var12 = (var8 * (65536 - var13) >> 16) + (var9 * var13 >> 16);
		int var15 = 65536 - class221.field2645[var5 * 1024 / var2] >> 1;
		int var14 = ((65536 - var15) * var10 >> 16) + (var11 * var15 >> 16);
		int var17 = 65536 - class221.field2645[var7 * 1024 / var2] >> 1;
		int var16 = (var14 * var17 >> 16) + (var12 * (65536 - var17) >> 16);
		return var16;
	}

	static final int method431(int var0, int var1) {
		int var3 = method4727(var0 - 1, var1 - 1) + method4727(var0 + 1, var1 - 1) + method4727(var0 - 1, var1 + 1) + method4727(var0 + 1, var1 + 1);
		int var4 = method4727(var0 - 1, var1) + method4727(var0 + 1, var1) + method4727(var0, var1 - 1) + method4727(var0, var1 + 1);
		int var5 = method4727(var0, var1);
		return var5 / 4 + var4 / 8 + var3 / 16;
	}

	static final int method4727(int var0, int var1) {
		int var3 = var0 + var1 * 57;
		var3 ^= var3 << 13;
		int var4 = 1376312589 + (var3 * var3 * 15731 + 789221) * var3 & Integer.MAX_VALUE;
		return var4 >> 19 & 255;
	}

	static final void method1699(int var0) {
		if (class246.method4928(var0)) {
			class300[] var2 = class300.field3593[var0];

			for (int var3 = 0; var3 < var2.length; ++var3) {
				class300 var4 = var2[var3];
				if (var4 != null) {
					var4.field3471 = 0;
					var4.field3518 = 0;
				}
			}

		}
	}
}
