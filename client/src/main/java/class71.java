public class class71 {
	protected static boolean isFocused;
	static class336 field578;
	class63[] field579;
	int field576;

	class71() {
		this.field579 = new class63[100];
	}

	class63 method1434(int var1, String var2, String var3, String var4) {
		class63 var6 = this.field579[99];

		for (int var7 = this.field576; var7 > 0; --var7) {
			if (var7 != 100) {
				this.field579[var7] = this.field579[var7 - 1];
			}
		}

		if (null == var6) {
			var6 = new class63(var1, var2, var4, var3);
		} else {
			var6.method7825();
			var6.method7889();
			var6.method1341(var1, var2, var4, var3);
		}

		this.field579[0] = var6;
		if (this.field576 < 100) {
			++this.field576;
		}

		return var6;
	}

	class63 method1428(int var1) {
		return var1 >= 0 && var1 < this.field576 ? this.field579[var1] : null;
	}

	int method1429() {
		return this.field576;
	}

	public static final class473 method1436(int var0, int var1, int var2, int var3, int var4, boolean var5) {
		if (var1 == -1) {
			var4 = 0;
		} else if (var4 == 2 && var1 != 1) {
			var4 = 1;
		}

		long var7 = ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var4 << 40) + ((long)var3 << 42);
		class473 var9;
		if (!var5) {
			var9 = (class473)class198.field2163.method5439(var7);
			if (null != var9) {
				return var9;
			}
		}

		class198 var10 = class278.method5388(var0);
		if (var1 > 1 && null != var10.field2136) {
			int var11 = -1;

			for (int var12 = 0; var12 < 10; ++var12) {
				if (var1 >= var10.field2164[var12] && var10.field2164[var12] != 0) {
					var11 = var10.field2136[var12];
				}
			}

			if (var11 != -1) {
				var10 = class278.method5388(var11);
			}
		}

		class209 var22 = var10.method3648(1);
		if (var22 == null) {
			return null;
		} else {
			class473 var23 = null;
			if (-1 != var10.field2166) {
				var23 = method1436(var10.field2165, 10, 1, 0, 0, true);
				if (null == var23) {
					return null;
				}
			} else if (-1 != var10.field2123) {
				var23 = method1436(var10.field2147, var1, var2, var3, 0, false);
				if (null == var23) {
					return null;
				}
			} else if (-1 != var10.field2179) {
				var23 = method1436(var10.field2152, var1, 0, 0, 0, false);
				if (var23 == null) {
					return null;
				}
			}

			int[] var13 = class481.field4992;
			int var14 = class481.field4993;
			int var15 = class481.field4994;
			int[] var16 = new int[4];
			class481.method8718(var16);
			var9 = new class473(36, 32);
			class481.method8651(var9.field4952, 36, 32);
			class481.method8656();
			class221.method4389();
			class221.method4432(16, 16);
			class221.field2622 = false;
			if (var10.field2179 != -1) {
				var23.method8526(0, 0);
			}

			int var17 = var10.field2144;
			if (var5) {
				var17 = (int)((double)var17 * 1.5D);
			} else if (var2 == 2) {
				var17 = (int)((double)var17 * 1.04D);
			}

			int var18 = class221.field2644[var10.field2137] * var17 >> 16;
			int var19 = var17 * class221.field2645[var10.field2137] >> 16;
			var22.method4067();
			var22.method4074(0, var10.field2138, var10.field2139, var10.field2137, var10.field2140, var18 + var22.field2489 / 2 + var10.field2128, var19 + var10.field2128);
			if (var10.field2123 != -1) {
				var23.method8526(0, 0);
			}

			if (var2 >= 1) {
				var9.method8518(1);
			}

			if (var2 >= 2) {
				var9.method8518(16777215);
			}

			if (var3 != 0) {
				var9.method8482(var3);
			}

			class481.method8651(var9.field4952, 36, 32);
			if (-1 != var10.field2166) {
				var23.method8526(0, 0);
			}

			if (var4 == 1 || var4 == 2 && var10.field2142 == 1) {
				class376 var20 = class145.field1336;
				String var21;
				if (var1 < 100000) {
					var21 = "<col=ffff00>" + var1 + "</col>";
				} else if (var1 < 10000000) {
					var21 = "<col=ffffff>" + var1 / 1000 + class338.field4068 + "</col>";
				} else {
					var21 = "<col=00ff80>" + var1 / 1000000 + class338.field4066 + "</col>";
				}

				var20.method6875(var21, 0, 9, 16776960, 1);
			}

			if (!var5) {
				class198.field2163.method5434(var9, var7);
			}

			class481.method8651(var13, var14, var15);
			class481.method8655(var16);
			class221.method4389();
			class221.field2622 = true;
			return var9;
		}
	}
}
