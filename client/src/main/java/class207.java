public class class207 extends class437 {
	public static class319 field2352;
	public static class319 field2363;
	static class284 field2353;
	static class284 field2354;
	static class488[] field2367;
	int field2355;
	int field2356;
	int field2360;
	int field2362;
	int field2364;
	int field2365;
	int field2366;
	short[] field2351;
	short[] field2357;
	short[] field2358;
	short[] field2361;
	public int field2359;

	static {
		field2353 = new class284(64);
		field2354 = new class284(30);
	}

	class207() {
		this.field2359 = -1;
		this.field2362 = 128;
		this.field2364 = 128;
		this.field2360 = 0;
		this.field2365 = 0;
		this.field2366 = 0;
	}

	public static class207 method803(int var0) {
		class207 var2 = (class207)field2353.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = field2363.method6175(13, var0);
			var2 = new class207();
			var2.field2355 = var0;
			if (var3 != null) {
				var2.method3970(new Buffer(var3));
			}

			field2353.method5434(var2, (long)var0);
			return var2;
		}
	}

	void method3970(Buffer var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3971(var1, var3);
		}
	}

	void method3971(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field2356 = var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.field2359 = var1.readUnsignedShort();
		} else if (var2 == 4) {
			this.field2362 = var1.readUnsignedShort();
		} else if (var2 == 5) {
			this.field2364 = var1.readUnsignedShort();
		} else if (var2 == 6) {
			this.field2360 = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.field2365 = var1.method8141();
		} else if (var2 == 8) {
			this.field2366 = var1.method8141();
		} else {
			int var4;
			int var5;
			if (var2 == 40) {
				var4 = var1.method8141();
				this.field2358 = new short[var4];
				this.field2357 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field2358[var5] = (short)var1.readUnsignedShort();
					this.field2357[var5] = (short)var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var4 = var1.method8141();
				this.field2351 = new short[var4];
				this.field2361 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field2351[var5] = (short)var1.readUnsignedShort();
					this.field2361[var5] = (short)var1.readUnsignedShort();
				}
			}
		}

	}

	public final class209 method3972(int var1) {
		class209 var3 = (class209)field2354.method5439((long)this.field2355);
		if (null == var3) {
			class201 var4 = class201.method3774(field2352, this.field2356, 0);
			if (null == var4) {
				return null;
			}

			int var5;
			if (this.field2358 != null) {
				for (var5 = 0; var5 < this.field2358.length; ++var5) {
					var4.method3790(this.field2358[var5], this.field2357[var5]);
				}
			}

			if (this.field2351 != null) {
				for (var5 = 0; var5 < this.field2351.length; ++var5) {
					var4.method3791(this.field2351[var5], this.field2361[var5]);
				}
			}

			var3 = var4.method3796(this.field2365 + 64, 850 + this.field2366, -30, -50, -30);
			field2354.method5434(var3, (long)this.field2355);
		}

		class209 var6;
		if (this.field2359 != -1 && var1 != -1) {
			var6 = class160.method2660(this.field2359).method3471(var3, var1);
		} else {
			var6 = var3.method3997(true);
		}

		if (128 != this.field2362 || this.field2364 != 128) {
			var6.method4062(this.field2362, this.field2364, this.field2362);
		}

		if (0 != this.field2360) {
			if (this.field2360 == 90) {
				var6.method4083();
			}

			if (180 == this.field2360) {
				var6.method4083();
				var6.method4083();
			}

			if (270 == this.field2360) {
				var6.method4083();
				var6.method4083();
				var6.method4083();
			}
		}

		return var6;
	}

	public static long method3982(int var0, int var1, int var2, boolean var3, int var4) {
		long var6 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
		if (var3) {
			var6 |= 65536L;
		}

		return var6;
	}

	public static void method1967() {
		field2353.method5437();
		field2354.method5437();
	}

	static int method3983(class72 var0, class72 var1, int var2, boolean var3, int var4, boolean var5) {
		int var7 = class270.method5208(var0, var1, var2, var3);
		if (var7 != 0) {
			return var3 ? -var7 : var7;
		} else if (var4 == -1) {
			return 0;
		} else {
			int var8 = class270.method5208(var0, var1, var4, var5);
			return var5 ? -var8 : var8;
		}
	}
}
