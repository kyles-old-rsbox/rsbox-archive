public class class143 {
	class350 field1323;
	long field1321;
	long field1324;

	public class143(class460 var1) {
		this.field1324 = -1L;
		this.field1323 = new class350();
		this.method2495(var1);
	}

	void method2495(class460 var1) {
		this.field1321 = var1.method8127();
		this.field1324 = var1.method8127();

		for (int var3 = var1.method8141(); var3 != 0; var3 = var1.method8141()) {
			Object var4;
			if (var3 == 1) {
				var4 = new class134(this);
			} else if (var3 == 4) {
				var4 = new class169(this);
			} else if (var3 == 3) {
				var4 = new class136(this);
			} else if (var3 == 2) {
				var4 = new class150(this);
			} else {
				if (var3 != 5) {
					throw new RuntimeException("");
				}

				var4 = new class156(this);
			}

			((class137)var4).method2441(var1);
			this.field1323.method6462((class427)var4);
		}

	}

	public void method2490(class147 var1) {
		if (this.field1321 == var1.field4681 && var1.field1349 == this.field1324) {
			for (class137 var3 = (class137)this.field1323.method6465(); var3 != null; var3 = (class137)this.field1323.method6467()) {
				var3.method2442(var1);
			}

			++var1.field1349;
		} else {
			throw new RuntimeException("");
		}
	}

	static boolean method2494(class195 var0) {
		if (null != var0.field2094) {
			int[] var2 = var0.field2094;

			for (int var3 = 0; var3 < var2.length; ++var3) {
				int var4 = var2[var3];
				class195 var5 = class89.method1866(var4);
				if (var5.field2081 != -1) {
					return true;
				}
			}
		} else if (var0.field2081 != -1) {
			return true;
		}

		return false;
	}

	static final void method2492(class300 var0, int var1, int var2) {
		if (client.field1709 == 0 || 3 == client.field1709) {
			if (!client.field1784 && (class42.field277 == 1 || !class95.field944 && 4 == class42.field277)) {
				class298 var4 = var0.method5859(true);
				if (null == var4) {
					return;
				}

				int var5 = class42.field283 - var1;
				int var6 = class42.field293 - var2;
				if (var4.method5837(var5, var6)) {
					var5 -= var4.field3435 / 2;
					var6 -= var4.field3433 / 2;
					int var7 = client.field1672 & 2047;
					int var8 = class221.field2644[var7];
					int var9 = class221.field2645[var7];
					int var10 = var5 * var9 + var8 * var6 >> 11;
					int var11 = var9 * var6 - var5 * var8 >> 11;
					int var12 = var10 + class291.field3364.field827 >> 7;
					int var13 = class291.field3364.field802 - var11 >> 7;
					class263 var14 = class185.method3435(class274.field3052, client.field1778.field1071);
					var14.field2984.method8104(18);
					var14.field2984.method8161(var13 + class169.field1536);
					var14.field2984.method8264(client.field1876.method3895(82) ? (client.field1876.method3895(81) ? 2 : 1) : 0);
					var14.field2984.method8337(class36.field241 + var12);
					var14.field2984.method8104(var5);
					var14.field2984.method8104(var6);
					var14.field2984.method8181(client.field1672);
					var14.field2984.method8104(57);
					var14.field2984.method8104(0);
					var14.field2984.method8104(0);
					var14.field2984.method8104(89);
					var14.field2984.method8181(class291.field3364.field827);
					var14.field2984.method8181(class291.field3364.field802);
					var14.field2984.method8104(63);
					client.field1778.method2078(var14);
					client.field1889 = var12;
					client.field1890 = var13;
				}
			}

		}
	}

	static int method2496(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.GETWINDOWMODE) {
			class57.field404[++class387.field4452 - 1] = class2.method11();
			return 1;
		} else {
			int var4;
			if (var0 == CS2Opcodes.SETWINDOWMODE) {
				var4 = class57.field404[--class387.field4452];
				if (var4 == 1 || var4 == 2) {
					class164.method2692(var4);
				}

				return 1;
			} else if (var0 == CS2Opcodes.GETDEFAULTWINDOWMODE) {
				class57.field404[++class387.field4452 - 1] = class413.field4575.method1726();
				return 1;
			} else if (var0 != CS2Opcodes.SETDEFAULTWINDOWMODE) {
				if (var0 == CS2Opcodes._5310) {
					--class387.field4452;
					return 1;
				} else {
					return 2;
				}
			} else {
				var4 = class57.field404[--class387.field4452];
				if (var4 == 1 || var4 == 2) {
					class413.field4575.method1778(var4);
				}

				return 1;
			}
		}
	}
}
