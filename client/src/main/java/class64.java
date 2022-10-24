public class class64 {
	static class245 field504;
	static class473[] field505;
	int field506;
	int field507;
	int[][] field508;

	public class64(int var1, int var2) {
		if (var2 != var1) {
			int var4 = var1;
			int var5 = var2;
			if (var2 > var1) {
				var4 = var2;
				var5 = var1;
			}

			while (0 != var5) {
				int var6 = var4 % var5;
				var4 = var5;
				var5 = var6;
			}

			var1 /= var4;
			var2 /= var4;
			this.field506 = var1;
			this.field507 = var2;
			this.field508 = new int[var1][14];

			for (int var7 = 0; var7 < var1; ++var7) {
				int[] var8 = this.field508[var7];
				double var9 = 6.0D + (double)var7 / (double)var1;
				int var11 = (int)Math.floor(var9 - 7.0D + 1.0D);
				if (var11 < 0) {
					var11 = 0;
				}

				int var12 = (int)Math.ceil(var9 + 7.0D);
				if (var12 > 14) {
					var12 = 14;
				}

				for (double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
					double var15 = 3.141592653589793D * ((double)var11 - var9);
					double var17 = var13;
					if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
						var17 = var13 * (Math.sin(var15) / var15);
					}

					var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
					var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
				}
			}

		}
	}

	byte[] method1368(byte[] var1) {
		if (null != this.field508) {
			int var3 = (int)((long)var1.length * (long)this.field507 / (long)this.field506) + 14;
			int[] var4 = new int[var3];
			int var5 = 0;
			int var6 = 0;

			int var7;
			for (var7 = 0; var7 < var1.length; ++var7) {
				byte var8 = var1[var7];
				int[] var9 = this.field508[var6];

				int var10;
				for (var10 = 0; var10 < 14; ++var10) {
					var4[var5 + var10] += var8 * var9[var10];
				}

				var6 += this.field507;
				var10 = var6 / this.field506;
				var5 += var10;
				var6 -= this.field506 * var10;
			}

			var1 = new byte[var3];

			for (var7 = 0; var7 < var3; ++var7) {
				int var11 = 32768 + var4[var7] >> 16;
				if (var11 < -128) {
					var1[var7] = -128;
				} else if (var11 > 127) {
					var1[var7] = 127;
				} else {
					var1[var7] = (byte)var11;
				}
			}
		}

		return var1;
	}

	int method1370(int var1) {
		if (null != this.field508) {
			var1 = (int)((long)this.field507 * (long)var1 / (long)this.field506);
		}

		return var1;
	}

	int method1372(int var1) {
		if (null != this.field508) {
			var1 = (int)((long)this.field507 * (long)var1 / (long)this.field506) + 6;
		}

		return var1;
	}

	static void method1377(int var0, int var1) {
		long var3 = (long)(var1 + (var0 << 16));
		class335 var5 = (class335)class324.field3782.method7855(var3);
		if (var5 != null) {
			class324.field3781.method6579(var5);
		}
	}

	static final void method1378() {
		if (class105.field1046) {
			if (class73.field603 != null) {
				class73.field603.method7297();
			}

			class91.method1892();
			class105.field1046 = false;
		}

	}
}
