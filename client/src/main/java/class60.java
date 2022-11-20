public class class60 extends class427 {
	static boolean field464;
	static boolean[] field447;
	static byte[] field468;
	static class46[] field460;
	static class50[] field474;
	static class52[] field459;
	static class76[] field458;
	static float[] field449;
	static float[] field453;
	static float[] field470;
	static float[] field471;
	static float[] field472;
	static float[] field473;
	static float[] field475;
	static int field454;
	static int field456;
	static int field457;
	static int field461;
	static int[] field455;
	static int[] field463;
	static int[] field477;
	boolean field452;
	boolean field462;
	byte[] field478;
	byte[][] field480;
	float[] field465;
	int field448;
	int field450;
	int field451;
	int field466;
	int field467;
	int field469;
	int field476;
	int field479;

	static {
		field464 = false;
	}

	static float method1331(int var0) {
		int var1 = var0 & 2097151;
		int var2 = var0 & Integer.MIN_VALUE;
		int var3 = (var0 & 2145386496) >> 21;
		if (var2 != 0) {
			var1 = -var1;
		}

		return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
	}

	static void method1328(byte[] var0, int var1) {
		field468 = var0;
		field454 = var1;
		field461 = 0;
	}

	static int method1299() {
		int var0 = field468[field454] >> field461 & 1;
		++field461;
		field454 += field461 >> 3;
		field461 &= 7;
		return var0;
	}

	static int method1323(int var0) {
		int var1 = 0;

		int var2;
		int var3;
		for (var2 = 0; var0 >= 8 - field461; var0 -= var3) {
			var3 = 8 - field461;
			int var4 = (1 << var3) - 1;
			var1 += (field468[field454] >> field461 & var4) << var2;
			field461 = 0;
			++field454;
			var2 += var3;
		}

		if (var0 > 0) {
			var3 = (1 << var0) - 1;
			var1 += (field468[field454] >> field461 & var3) << var2;
			field461 += var0;
		}

		return var1;
	}

	void method1317(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		this.field469 = var2.method8126();
		this.field466 = var2.method8126();
		this.field450 = var2.method8126();
		this.field451 = var2.method8126();
		if (this.field451 < 0) {
			this.field451 = ~this.field451;
			this.field452 = true;
		}

		int var3 = var2.method8126();
		this.field480 = new byte[var3][];

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = 0;

			int var6;
			do {
				var6 = var2.method8141();
				var5 += var6;
			} while(var6 >= 255);

			byte[] var7 = new byte[var5];
			var2.method8333(var7, 0, var5);
			this.field480[var4] = var7;
		}

	}

	static void method1302(byte[] var0) {
		method1328(var0, 0);
		field456 = 1 << method1323(4);
		field457 = 1 << method1323(4);
		field453 = new float[field457];

		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		for (var1 = 0; var1 < 2; ++var1) {
			var2 = var1 != 0 ? field457 : field456;
			var3 = var2 >> 1;
			var4 = var2 >> 2;
			var5 = var2 >> 3;
			float[] var6 = new float[var3];

			for (int var7 = 0; var7 < var4; ++var7) {
				var6[var7 * 2] = (float)Math.cos((double)(var7 * 4) * 3.141592653589793D / (double)var2);
				var6[var7 * 2 + 1] = -((float)Math.sin((double)(var7 * 4) * 3.141592653589793D / (double)var2));
			}

			float[] var18 = new float[var3];

			for (int var8 = 0; var8 < var4; ++var8) {
				var18[var8 * 2] = (float)Math.cos((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
				var18[var8 * 2 + 1] = (float)Math.sin((double)(var8 * 2 + 1) * 3.141592653589793D / (double)(var2 * 2));
			}

			float[] var19 = new float[var4];

			for (int var9 = 0; var9 < var5; ++var9) {
				var19[var9 * 2] = (float)Math.cos((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2);
				var19[var9 * 2 + 1] = -((float)Math.sin((double)(var9 * 4 + 2) * 3.141592653589793D / (double)var2));
			}

			int[] var20 = new int[var5];
			int var10 = class8.method51(var5 - 1);

			for (int var11 = 0; var11 < var5; ++var11) {
				int var15 = var11;
				int var16 = var10;

				int var17;
				for (var17 = 0; var16 > 0; --var16) {
					var17 = var17 << 1 | var15 & 1;
					var15 >>>= 1;
				}

				var20[var11] = var17;
			}

			if (var1 != 0) {
				field473 = var6;
				field449 = var18;
				field475 = var19;
				field477 = var20;
			} else {
				field470 = var6;
				field471 = var18;
				field472 = var19;
				field455 = var20;
			}
		}

		var1 = method1323(8) + 1;
		field458 = new class76[var1];

		for (var2 = 0; var2 < var1; ++var2) {
			field458[var2] = new class76();
		}

		var2 = method1323(6) + 1;

		for (var3 = 0; var3 < var2; ++var3) {
			method1323(16);
		}

		var2 = method1323(6) + 1;
		field459 = new class52[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			field459[var3] = new class52();
		}

		var3 = method1323(6) + 1;
		field460 = new class46[var3];

		for (var4 = 0; var4 < var3; ++var4) {
			field460[var4] = new class46();
		}

		var4 = method1323(6) + 1;
		field474 = new class50[var4];

		for (var5 = 0; var5 < var4; ++var5) {
			field474[var5] = new class50();
		}

		var5 = method1323(6) + 1;
		field447 = new boolean[var5];
		field463 = new int[var5];

		for (int var21 = 0; var21 < var5; ++var21) {
			field447[var21] = method1299() != 0;
			method1323(16);
			method1323(16);
			field463[var21] = method1323(8);
		}

	}

	float[] method1303(int var1) {
		method1328(this.field480[var1], 0);
		method1299();
		int var2 = method1323(class8.method51(field463.length - 1));
		boolean var3 = field447[var2];
		int var4 = var3 ? field457 : field456;
		boolean var5 = false;
		boolean var6 = false;
		if (var3) {
			var5 = method1299() != 0;
			var6 = method1299() != 0;
		}

		int var7 = var4 >> 1;
		int var8;
		int var9;
		int var10;
		if (var3 && !var5) {
			var8 = (var4 >> 2) - (field456 >> 2);
			var9 = (var4 >> 2) + (field456 >> 2);
			var10 = field456 >> 1;
		} else {
			var8 = 0;
			var9 = var7;
			var10 = var4 >> 1;
		}

		int var11;
		int var12;
		int var13;
		if (var3 && !var6) {
			var11 = var4 - (var4 >> 2) - (field456 >> 2);
			var12 = var4 - (var4 >> 2) + (field456 >> 2);
			var13 = field456 >> 1;
		} else {
			var11 = var7;
			var12 = var4;
			var13 = var4 >> 1;
		}

		class50 var14 = field474[field463[var2]];
		int var16 = var14.field355;
		int var17 = var14.field352[var16];
		boolean var15 = !field459[var17].method1032();
		boolean var45 = var15;

		for (var17 = 0; var17 < var14.field353; ++var17) {
			class46 var18 = field460[var14.field354[var17]];
			float[] var19 = field453;
			var18.method954(var19, var4 >> 1, var45);
		}

		int var40;
		if (!var15) {
			var17 = var14.field355;
			var40 = var14.field352[var17];
			field459[var40].method1041(field453, var4 >> 1);
		}

		int var42;
		if (var15) {
			for (var17 = var4 >> 1; var17 < var4; ++var17) {
				field453[var17] = 0.0F;
			}
		} else {
			var17 = var4 >> 1;
			var40 = var4 >> 2;
			var42 = var4 >> 3;
			float[] var43 = field453;

			int var21;
			for (var21 = 0; var21 < var17; ++var21) {
				var43[var21] *= 0.5F;
			}

			for (var21 = var17; var21 < var4; ++var21) {
				var43[var21] = -var43[var4 - var21 - 1];
			}

			float[] var44 = var3 ? field473 : field470;
			float[] var22 = var3 ? field449 : field471;
			float[] var23 = var3 ? field475 : field472;
			int[] var24 = var3 ? field477 : field455;

			int var25;
			float var26;
			float var27;
			float var28;
			float var29;
			for (var25 = 0; var25 < var40; ++var25) {
				var26 = var43[var25 * 4] - var43[var4 - var25 * 4 - 1];
				var27 = var43[var25 * 4 + 2] - var43[var4 - var25 * 4 - 3];
				var28 = var44[var25 * 2];
				var29 = var44[var25 * 2 + 1];
				var43[var4 - var25 * 4 - 1] = var26 * var28 - var27 * var29;
				var43[var4 - var25 * 4 - 3] = var26 * var29 + var27 * var28;
			}

			float var30;
			float var31;
			for (var25 = 0; var25 < var42; ++var25) {
				var26 = var43[var17 + 3 + var25 * 4];
				var27 = var43[var17 + 1 + var25 * 4];
				var28 = var43[var25 * 4 + 3];
				var29 = var43[var25 * 4 + 1];
				var43[var17 + 3 + var25 * 4] = var26 + var28;
				var43[var17 + 1 + var25 * 4] = var27 + var29;
				var30 = var44[var17 - 4 - var25 * 4];
				var31 = var44[var17 - 3 - var25 * 4];
				var43[var25 * 4 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
				var43[var25 * 4 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
			}

			var25 = class8.method51(var4 - 1);

			int var47;
			int var48;
			int var49;
			int var50;
			for (var47 = 0; var47 < var25 - 3; ++var47) {
				var48 = var4 >> var47 + 2;
				var49 = 8 << var47;

				for (var50 = 0; var50 < 2 << var47; ++var50) {
					int var51 = var4 - var48 * 2 * var50;
					int var52 = var4 - var48 * (var50 * 2 + 1);

					for (int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
						int var33 = var32 * 4;
						float var34 = var43[var51 - 1 - var33];
						float var35 = var43[var51 - 3 - var33];
						float var36 = var43[var52 - 1 - var33];
						float var37 = var43[var52 - 3 - var33];
						var43[var51 - 1 - var33] = var34 + var36;
						var43[var51 - 3 - var33] = var35 + var37;
						float var38 = var44[var32 * var49];
						float var39 = var44[var32 * var49 + 1];
						var43[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
						var43[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
					}
				}
			}

			for (var47 = 1; var47 < var42 - 1; ++var47) {
				var48 = var24[var47];
				if (var47 < var48) {
					var49 = var47 * 8;
					var50 = var48 * 8;
					var30 = var43[var49 + 1];
					var43[var49 + 1] = var43[var50 + 1];
					var43[var50 + 1] = var30;
					var30 = var43[var49 + 3];
					var43[var49 + 3] = var43[var50 + 3];
					var43[var50 + 3] = var30;
					var30 = var43[var49 + 5];
					var43[var49 + 5] = var43[var50 + 5];
					var43[var50 + 5] = var30;
					var30 = var43[var49 + 7];
					var43[var49 + 7] = var43[var50 + 7];
					var43[var50 + 7] = var30;
				}
			}

			for (var47 = 0; var47 < var17; ++var47) {
				var43[var47] = var43[var47 * 2 + 1];
			}

			for (var47 = 0; var47 < var42; ++var47) {
				var43[var4 - 1 - var47 * 2] = var43[var47 * 4];
				var43[var4 - 2 - var47 * 2] = var43[var47 * 4 + 1];
				var43[var4 - var40 - 1 - var47 * 2] = var43[var47 * 4 + 2];
				var43[var4 - var40 - 2 - var47 * 2] = var43[var47 * 4 + 3];
			}

			for (var47 = 0; var47 < var42; ++var47) {
				var27 = var23[var47 * 2];
				var28 = var23[var47 * 2 + 1];
				var29 = var43[var17 + var47 * 2];
				var30 = var43[var17 + var47 * 2 + 1];
				var31 = var43[var4 - 2 - var47 * 2];
				float var53 = var43[var4 - 1 - var47 * 2];
				float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
				var43[var17 + var47 * 2] = (var29 + var31 + var54) * 0.5F;
				var43[var4 - 2 - var47 * 2] = (var29 + var31 - var54) * 0.5F;
				var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
				var43[var17 + var47 * 2 + 1] = (var30 - var53 + var54) * 0.5F;
				var43[var4 - 1 - var47 * 2] = (-var30 + var53 + var54) * 0.5F;
			}

			for (var47 = 0; var47 < var40; ++var47) {
				var43[var47] = var43[var47 * 2 + var17] * var22[var47 * 2] + var43[var47 * 2 + 1 + var17] * var22[var47 * 2 + 1];
				var43[var17 - 1 - var47] = var43[var47 * 2 + var17] * var22[var47 * 2 + 1] - var43[var47 * 2 + 1 + var17] * var22[var47 * 2];
			}

			for (var47 = 0; var47 < var40; ++var47) {
				var43[var4 - var40 + var47] = -var43[var47];
			}

			for (var47 = 0; var47 < var40; ++var47) {
				var43[var47] = var43[var40 + var47];
			}

			for (var47 = 0; var47 < var40; ++var47) {
				var43[var40 + var47] = -var43[var40 - var47 - 1];
			}

			for (var47 = 0; var47 < var40; ++var47) {
				var43[var17 + var47] = var43[var4 - var47 - 1];
			}

			float[] var10000;
			for (var47 = var8; var47 < var9; ++var47) {
				var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
				var10000 = field453;
				var10000[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
			}

			for (var47 = var11; var47 < var12; ++var47) {
				var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				var10000 = field453;
				var10000[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
			}
		}

		float[] var41 = null;
		if (this.field479 > 0) {
			var40 = this.field479 + var4 >> 2;
			var41 = new float[var40];
			int var20;
			if (!this.field462) {
				for (var42 = 0; var42 < this.field467; ++var42) {
					var20 = (this.field479 >> 1) + var42;
					var41[var42] += this.field465[var20];
				}
			}

			if (!var15) {
				for (var42 = var8; var42 < var4 >> 1; ++var42) {
					var20 = var41.length - (var4 >> 1) + var42;
					var41[var20] += field453[var42];
				}
			}
		}

		float[] var46 = this.field465;
		this.field465 = field453;
		field453 = var46;
		this.field479 = var4;
		this.field467 = var12 - (var4 >> 1);
		this.field462 = var15;
		return var41;
	}

	static boolean method1304(class319 var0) {
		if (!field464) {
			byte[] var1 = var0.method6175(0, 0);
			if (var1 == null) {
				return false;
			}

			method1302(var1);
			field464 = true;
		}

		return true;
	}

	static class60 method1324(class319 var0, int var1, int var2) {
		if (!method1304(var0)) {
			var0.method6089(var1, var2);
			return null;
		} else {
			byte[] var3 = var0.method6175(var1, var2);
			return var3 == null ? null : new class60(var3);
		}
	}

	class60(byte[] var1) {
		this.method1317(var1);
	}

	class39 method1305(int[] var1) {
		if (var1 != null && var1[0] <= 0) {
			return null;
		} else {
			if (this.field478 == null) {
				this.field479 = 0;
				this.field465 = new float[field457];
				this.field478 = new byte[this.field466];
				this.field476 = 0;
				this.field448 = 0;
			}

			for (; this.field448 < this.field480.length; ++this.field448) {
				if (var1 != null && var1[0] <= 0) {
					return null;
				}

				float[] var2 = this.method1303(this.field448);
				if (var2 != null) {
					int var3 = this.field476;
					int var4 = var2.length;
					if (var4 > this.field466 - var3) {
						var4 = this.field466 - var3;
					}

					for (int var5 = 0; var5 < var4; ++var5) {
						int var6 = (int)(128.0F + var2[var5] * 128.0F);
						if ((var6 & -256) != 0) {
							var6 = ~var6 >> 31;
						}

						this.field478[var3++] = (byte)(var6 - 128);
					}

					if (var1 != null) {
						var1[0] -= var3 - this.field476;
					}

					this.field476 = var3;
				}
			}

			this.field465 = null;
			byte[] var7 = this.field478;
			this.field478 = null;
			return new class39(this.field469, var7, this.field450, this.field451, this.field452);
		}
	}
}
