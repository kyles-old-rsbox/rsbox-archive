public class class278 extends class51 {
	static int field3197;
	boolean field3184;
	class277 field3189;
	class296[][] field3187;
	class296[][] field3188;
	class299 field3173;
	NodeHashTable field3171;
	int field3170;
	int field3175;
	int field3192;
	int field3195;
	int[] field3169;
	int[] field3172;
	int[] field3174;
	int[] field3176;
	int[] field3178;
	int[] field3179;
	int[] field3180;
	int[] field3181;
	int[] field3182;
	int[] field3183;
	int[] field3185;
	int[] field3186;
	int[] field3190;
	int[] field3191;
	int[] field3196;
	long field3193;
	long field3194;

	public class278() {
		this.field3170 = 256;
		this.field3195 = 1000000;
		this.field3172 = new int[16];
		this.field3169 = new int[16];
		this.field3190 = new int[16];
		this.field3178 = new int[16];
		this.field3176 = new int[16];
		this.field3191 = new int[16];
		this.field3183 = new int[16];
		this.field3179 = new int[16];
		this.field3180 = new int[16];
		this.field3181 = new int[16];
		this.field3182 = new int[16];
		this.field3174 = new int[16];
		this.field3196 = new int[16];
		this.field3185 = new int[16];
		this.field3186 = new int[16];
		this.field3187 = new class296[16][128];
		this.field3188 = new class296[16][128];
		this.field3189 = new class277();
		this.field3173 = new class299(this);
		this.field3171 = new NodeHashTable(128);
		this.method5289();
	}

	public synchronized void method5271(int var1) {
		this.field3170 = var1;
	}

	int method5382() {
		return this.field3170;
	}

	public synchronized boolean method5273(class292 var1, class319 var2, class49 var3, int var4) {
		var1.method5492();
		boolean var6 = true;
		int[] var7 = null;
		if (var4 > 0) {
			var7 = new int[]{var4};
		}

		for (class440 var8 = (class440)var1.field3367.first(); var8 != null; var8 = (class440)var1.field3367.next()) {
			int var9 = (int)var8.field4681;
			class288 var10 = (class288)this.field3171.method7855((long)var9);
			if (null == var10) {
				byte[] var12 = var2.method6103(var9);
				class288 var11;
				if (var12 == null) {
					var11 = null;
				} else {
					var11 = new class288(var12);
				}

				var10 = var11;
				if (null == var11) {
					var6 = false;
					continue;
				}

				this.field3171.method7857(var11, (long)var9);
			}

			if (!var10.method5455(var3, var8.field4763, var7)) {
				var6 = false;
			}
		}

		if (var6) {
			var1.method5490();
		}

		return var6;
	}

	public static class198 method5388(int var0) {
		class198 var2 = (class198)class198.field2126.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class298.field3438.method6175(10, var0);
			var2 = new class198();
			var2.field2129 = var0;
			if (var3 != null) {
				var2.method3649(new Buffer(var3));
			}

			var2.method3643();
			if (-1 != var2.field2166) {
				var2.method3646(method5388(var2.field2166), method5388(var2.field2165));
			}

			if (-1 != var2.field2123) {
				var2.method3650(method5388(var2.field2123), method5388(var2.field2147));
			}

			if (var2.field2179 != -1) {
				var2.method3666(method5388(var2.field2179), method5388(var2.field2152));
			}

			if (!class6.field16 && var2.field2162) {
				var2.field2131 = class338.field3991;
				var2.field2175 = false;

				int var4;
				for (var4 = 0; var4 < var2.field2148.length; ++var4) {
					var2.field2148[var4] = null;
				}

				for (var4 = 0; var4 < var2.field2149.length; ++var4) {
					if (var4 != 4) {
						var2.field2149[var4] = null;
					}
				}

				var2.field2177 = -2;
				var2.field2172 = 0;
				if (null != var2.field2174) {
					boolean var7 = false;

					for (class427 var5 = var2.field2174.method7787(); null != var5; var5 = var2.field2174.method7789()) {
						class193 var6 = class213.method4120((int)var5.field4681);
						if (var6.field2039) {
							var5.method7825();
						} else {
							var7 = true;
						}
					}

					if (!var7) {
						var2.field2174 = null;
					}
				}
			}

			class198.field2126.method5434(var2, (long)var0);
			return var2;
		}
	}

	public synchronized void method5277() {
		for (class288 var2 = (class288)this.field3171.first(); null != var2; var2 = (class288)this.field3171.next()) {
			var2.method5454();
		}

	}

	synchronized void method5275() {
		for (class288 var2 = (class288)this.field3171.first(); var2 != null; var2 = (class288)this.field3171.next()) {
			var2.method7825();
		}

	}

	public synchronized void method5276(class292 var1, boolean var2) {
		this.method5365();
		this.field3189.method5226(var1.field3366);
		this.field3184 = var2;
		this.field3193 = 0L;
		int var4 = this.field3189.method5227();

		for (int var5 = 0; var5 < var4; ++var5) {
			this.field3189.method5230(var5);
			this.field3189.method5233(var5);
			this.field3189.method5231(var5);
		}

		this.field3175 = this.field3189.method5238();
		this.field3192 = this.field3189.field3161[this.field3175];
		this.field3194 = this.field3189.method5237(this.field3192);
	}

	public synchronized void method5365() {
		this.field3189.method5256();
		this.method5289();
	}

	public synchronized boolean method5278() {
		return this.field3189.method5228();
	}

	public synchronized void method5296(int var1, int var2) {
		this.method5378(var1, var2);
	}

	void method5378(int var1, int var2) {
		this.field3178[var1] = var2;
		this.field3191[var1] = var2 & -128;
		this.method5280(var1, var2);
	}

	void method5280(int var1, int var2) {
		if (var2 != this.field3176[var1]) {
			this.field3176[var1] = var2;

			for (int var4 = 0; var4 < 128; ++var4) {
				this.field3188[var1][var4] = null;
			}
		}

	}

	void method5281(int var1, int var2, int var3) {
		this.method5282(var1, var2, 64);
		if (0 != (this.field3181[var1] & 2)) {
			for (class296 var5 = (class296)this.field3173.field3440.method6363(); var5 != null; var5 = (class296)this.field3173.field3440.method6378()) {
				if (var5.field3381 == var1 && var5.field3393 < 0) {
					this.field3187[var1][var5.field3384] = null;
					this.field3187[var1][var2] = var5;
					int var6 = var5.field3396 + (var5.field3389 * var5.field3388 >> 12);
					var5.field3396 += var2 - var5.field3384 << 8;
					var5.field3388 = var6 - var5.field3396;
					var5.field3389 = 4096;
					var5.field3384 = var2;
					return;
				}
			}
		}

		class288 var10 = (class288)this.field3171.method7855((long)this.field3176[var1]);
		if (var10 != null) {
			class39 var9 = var10.field3348[var2];
			if (var9 != null) {
				class296 var7 = new class296();
				var7.field3381 = var1;
				var7.field3380 = var10;
				var7.field3387 = var9;
				var7.field3394 = var10.field3352[var2];
				var7.field3379 = var10.field3353[var2];
				var7.field3384 = var2;
				var7.field3385 = var10.field3350[var2] * var10.field3356 * var3 * var3 + 1024 >> 11;
				var7.field3386 = var10.field3351[var2] & 255;
				var7.field3396 = (var2 << 8) - (var10.field3349[var2] & 32767);
				var7.field3390 = 0;
				var7.field3399 = 0;
				var7.field3392 = 0;
				var7.field3393 = -1;
				var7.field3391 = 0;
				if (this.field3196[var1] == 0) {
					var7.field3397 = class44.method811(var9, this.method5293(var7), this.method5294(var7), this.method5295(var7));
				} else {
					var7.field3397 = class44.method811(var9, this.method5293(var7), 0, this.method5295(var7));
					this.method5385(var7, var10.field3349[var2] < 0);
				}

				if (var10.field3349[var2] < 0) {
					var7.field3397.method813(-1);
				}

				if (var7.field3379 >= 0) {
					class296 var8 = this.field3188[var1][var7.field3379];
					if (var8 != null && var8.field3393 < 0) {
						this.field3187[var1][var8.field3384] = null;
						var8.field3393 = 0;
					}

					this.field3188[var1][var7.field3379] = var7;
				}

				this.field3173.field3440.method6355(var7);
				this.field3187[var1][var2] = var7;
			}
		}
	}

	void method5385(class296 var1, boolean var2) {
		int var4 = var1.field3387.field258.length;
		int var5;
		if (var2 && var1.field3387.field261) {
			int var6 = var4 + var4 - var1.field3387.field259;
			var5 = (int)((long)var6 * (long)this.field3196[var1.field3381] >> 6);
			var4 <<= 8;
			if (var5 >= var4) {
				var5 = var4 + var4 - 1 - var5;
				var1.field3397.method820(true);
			}
		} else {
			var5 = (int)((long)var4 * (long)this.field3196[var1.field3381] >> 6);
		}

		var1.field3397.method929(var5);
	}

	void method5282(int var1, int var2, int var3) {
		class296 var5 = this.field3187[var1][var2];
		if (var5 != null) {
			this.field3187[var1][var2] = null;
			if (0 != (this.field3181[var1] & 2)) {
				for (class296 var6 = (class296)this.field3173.field3440.method6364(); var6 != null; var6 = (class296)this.field3173.field3440.method6358()) {
					if (var5.field3381 == var6.field3381 && var6.field3393 < 0 && var5 != var6) {
						var5.field3393 = 0;
						break;
					}
				}
			} else {
				var5.field3393 = 0;
			}

		}
	}

	void method5343(int var1, int var2, int var3) {
	}

	void method5284(int var1, int var2) {
	}

	void method5285(int var1, int var2) {
		this.field3183[var1] = var2;
	}

	void method5302(int var1) {
		for (class296 var3 = (class296)this.field3173.field3440.method6364(); var3 != null; var3 = (class296)this.field3173.field3440.method6358()) {
			if (var1 < 0 || var3.field3381 == var1) {
				if (null != var3.field3397) {
					var3.field3397.method815(class49.field348 / 100);
					if (var3.field3397.method817()) {
						this.field3173.field3441.method718(var3.field3397);
					}

					var3.method5553();
				}

				if (var3.field3393 < 0) {
					this.field3187[var3.field3381][var3.field3384] = null;
				}

				var3.method7825();
			}
		}

	}

	void method5287(int var1) {
		if (var1 >= 0) {
			this.field3172[var1] = 12800;
			this.field3169[var1] = 8192;
			this.field3190[var1] = 16383;
			this.field3183[var1] = 8192;
			this.field3179[var1] = 0;
			this.field3180[var1] = 8192;
			this.method5290(var1);
			this.method5272(var1);
			this.field3181[var1] = 0;
			this.field3182[var1] = 32767;
			this.field3174[var1] = 256;
			this.field3196[var1] = 0;
			this.method5292(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method5287(var1);
			}

		}
	}

	void method5291(int var1) {
		for (class296 var3 = (class296)this.field3173.field3440.method6364(); null != var3; var3 = (class296)this.field3173.field3440.method6358()) {
			if ((var1 < 0 || var3.field3381 == var1) && var3.field3393 < 0) {
				this.field3187[var3.field3381][var3.field3384] = null;
				var3.field3393 = 0;
			}
		}

	}

	void method5289() {
		this.method5302(-1);
		this.method5287(-1);

		int var2;
		for (var2 = 0; var2 < 16; ++var2) {
			this.field3176[var2] = this.field3178[var2];
		}

		for (var2 = 0; var2 < 16; ++var2) {
			this.field3191[var2] = this.field3178[var2] & -128;
		}

	}

	void method5290(int var1) {
		if (0 != (this.field3181[var1] & 2)) {
			for (class296 var3 = (class296)this.field3173.field3440.method6364(); var3 != null; var3 = (class296)this.field3173.field3440.method6358()) {
				if (var1 == var3.field3381 && this.field3187[var1][var3.field3384] == null && var3.field3393 < 0) {
					var3.field3393 = 0;
				}
			}
		}

	}

	void method5272(int var1) {
		if (0 != (this.field3181[var1] & 4)) {
			for (class296 var3 = (class296)this.field3173.field3440.method6364(); null != var3; var3 = (class296)this.field3173.field3440.method6358()) {
				if (var3.field3381 == var1) {
					var3.field3382 = 0;
				}
			}
		}

	}

	void method5339(int var1) {
		int var3 = var1 & 240;
		int var4;
		int var5;
		int var6;
		if (var3 == 128) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			var6 = var1 >> 16 & 127;
			this.method5282(var4, var5, var6);
		} else if (var3 == 144) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			var6 = var1 >> 16 & 127;
			if (var6 > 0) {
				this.method5281(var4, var5, var6);
			} else {
				this.method5282(var4, var5, 64);
			}

		} else if (var3 == 160) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			var6 = var1 >> 16 & 127;
			this.method5343(var4, var5, var6);
		} else if (var3 == 176) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			var6 = var1 >> 16 & 127;
			if (var5 == 0) {
				this.field3191[var4] = (var6 << 14) + (this.field3191[var4] & -2080769);
			}

			if (var5 == 32) {
				this.field3191[var4] = (this.field3191[var4] & -16257) + (var6 << 7);
			}

			if (var5 == 1) {
				this.field3179[var4] = (var6 << 7) + (this.field3179[var4] & -16257);
			}

			if (var5 == 33) {
				this.field3179[var4] = (this.field3179[var4] & -128) + var6;
			}

			if (var5 == 5) {
				this.field3180[var4] = (this.field3180[var4] & -16257) + (var6 << 7);
			}

			if (var5 == 37) {
				this.field3180[var4] = (this.field3180[var4] & -128) + var6;
			}

			if (var5 == 7) {
				this.field3172[var4] = (var6 << 7) + (this.field3172[var4] & -16257);
			}

			if (var5 == 39) {
				this.field3172[var4] = (this.field3172[var4] & -128) + var6;
			}

			if (var5 == 10) {
				this.field3169[var4] = (var6 << 7) + (this.field3169[var4] & -16257);
			}

			if (var5 == 42) {
				this.field3169[var4] = (this.field3169[var4] & -128) + var6;
			}

			if (var5 == 11) {
				this.field3190[var4] = (this.field3190[var4] & -16257) + (var6 << 7);
			}

			if (var5 == 43) {
				this.field3190[var4] = var6 + (this.field3190[var4] & -128);
			}

			int[] var10000;
			if (var5 == 64) {
				if (var6 >= 64) {
					var10000 = this.field3181;
					var10000[var4] |= 1;
				} else {
					var10000 = this.field3181;
					var10000[var4] &= -2;
				}
			}

			if (var5 == 65) {
				if (var6 >= 64) {
					var10000 = this.field3181;
					var10000[var4] |= 2;
				} else {
					this.method5290(var4);
					var10000 = this.field3181;
					var10000[var4] &= -3;
				}
			}

			if (var5 == 99) {
				this.field3182[var4] = (this.field3182[var4] & 127) + (var6 << 7);
			}

			if (var5 == 98) {
				this.field3182[var4] = var6 + (this.field3182[var4] & 16256);
			}

			if (var5 == 101) {
				this.field3182[var4] = (this.field3182[var4] & 127) + 16384 + (var6 << 7);
			}

			if (var5 == 100) {
				this.field3182[var4] = var6 + 16384 + (this.field3182[var4] & 16256);
			}

			if (var5 == 120) {
				this.method5302(var4);
			}

			if (var5 == 121) {
				this.method5287(var4);
			}

			if (var5 == 123) {
				this.method5291(var4);
			}

			int var7;
			if (var5 == 6) {
				var7 = this.field3182[var4];
				if (var7 == 16384) {
					this.field3174[var4] = (var6 << 7) + (this.field3174[var4] & -16257);
				}
			}

			if (var5 == 38) {
				var7 = this.field3182[var4];
				if (var7 == 16384) {
					this.field3174[var4] = var6 + (this.field3174[var4] & -128);
				}
			}

			if (var5 == 16) {
				this.field3196[var4] = (this.field3196[var4] & -16257) + (var6 << 7);
			}

			if (var5 == 48) {
				this.field3196[var4] = var6 + (this.field3196[var4] & -128);
			}

			if (var5 == 81) {
				if (var6 >= 64) {
					var10000 = this.field3181;
					var10000[var4] |= 4;
				} else {
					this.method5272(var4);
					var10000 = this.field3181;
					var10000[var4] &= -5;
				}
			}

			if (var5 == 17) {
				this.method5292(var4, (var6 << 7) + (this.field3185[var4] & -16257));
			}

			if (var5 == 49) {
				this.method5292(var4, (this.field3185[var4] & -128) + var6);
			}

		} else if (var3 == 192) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			this.method5280(var4, var5 + this.field3191[var4]);
		} else if (var3 == 208) {
			var4 = var1 & 15;
			var5 = var1 >> 8 & 127;
			this.method5284(var4, var5);
		} else if (var3 == 224) {
			var4 = var1 & 15;
			var5 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method5285(var4, var5);
		} else {
			var3 = var1 & 255;
			if (var3 == 255) {
				this.method5289();
			}
		}
	}

	void method5292(int var1, int var2) {
		this.field3185[var1] = var2;
		this.field3186[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	int method5293(class296 var1) {
		int var3 = (var1.field3389 * var1.field3388 >> 12) + var1.field3396;
		var3 += this.field3174[var1.field3381] * (this.field3183[var1.field3381] - 8192) >> 12;
		class286 var4 = var1.field3394;
		int var5;
		if (var4.field3340 > 0 && (var4.field3333 > 0 || this.field3179[var1.field3381] > 0)) {
			var5 = var4.field3333 << 2;
			int var6 = var4.field3334 << 1;
			if (var1.field3395 < var6) {
				var5 = var1.field3395 * var5 / var6;
			}

			var5 += this.field3179[var1.field3381] >> 7;
			double var7 = Math.sin((double)(var1.field3383 & 511) * 0.01227184630308513D);
			var3 += (int)((double)var5 * var7);
		}

		var5 = (int)((double)(var1.field3387.field257 * 256) * Math.pow(2.0D, (double)var3 * 3.255208333333333E-4D) / (double)class49.field348 + 0.5D);
		return var5 < 1 ? 1 : var5;
	}

	int method5294(class296 var1) {
		class286 var3 = var1.field3394;
		int var4 = 4096 + this.field3172[var1.field3381] * this.field3190[var1.field3381] >> 13;
		var4 = 16384 + var4 * var4 >> 15;
		var4 = 16384 + var1.field3385 * var4 >> 15;
		var4 = var4 * this.field3170 + 128 >> 8;
		if (var3.field3335 > 0) {
			var4 = (int)((double)var4 * Math.pow(0.5D, (double)var3.field3335 * (double)var1.field3390 * 1.953125E-5D) + 0.5D);
		}

		int var5;
		int var6;
		int var7;
		int var8;
		if (null != var3.field3341) {
			var5 = var1.field3399;
			var6 = var3.field3341[var1.field3392 + 1];
			if (var1.field3392 < var3.field3341.length - 2) {
				var7 = (var3.field3341[var1.field3392] & 255) << 8;
				var8 = (var3.field3341[2 + var1.field3392] & 255) << 8;
				var6 += (var5 - var7) * (var3.field3341[var1.field3392 + 3] - var6) / (var8 - var7);
			}

			var4 = 32 + var4 * var6 >> 6;
		}

		if (var1.field3393 > 0 && null != var3.field3339) {
			var5 = var1.field3393;
			var6 = var3.field3339[1 + var1.field3391];
			if (var1.field3391 < var3.field3339.length - 2) {
				var7 = (var3.field3339[var1.field3391] & 255) << 8;
				var8 = (var3.field3339[var1.field3391 + 2] & 255) << 8;
				var6 += (var5 - var7) * (var3.field3339[3 + var1.field3391] - var6) / (var8 - var7);
			}

			var4 = 32 + var4 * var6 >> 6;
		}

		return var4;
	}

	int method5295(class296 var1) {
		int var3 = this.field3169[var1.field3381];
		return var3 < 8192 ? 32 + var1.field3386 * var3 >> 6 : 16384 - (32 + (16384 - var3) * (128 - var1.field3386) >> 6);
	}

	protected synchronized class51 method1007() {
		return this.field3173;
	}

	protected synchronized class51 method1004() {
		return null;
	}

	protected synchronized int method1003() {
		return 0;
	}

	protected synchronized void method1005(int[] var1, int var2, int var3) {
		if (this.field3189.method5228()) {
			int var4 = this.field3195 * this.field3189.field3168 / class49.field348;

			do {
				long var5 = (long)var3 * (long)var4 + this.field3193;
				if (this.field3194 - var5 >= 0L) {
					this.field3193 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field3194 - this.field3193) - 1L) / (long)var4);
				this.field3193 += (long)var4 * (long)var7;
				this.field3173.method1005(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method5299();
			} while(this.field3189.method5228());
		}

		this.field3173.method1005(var1, var2, var3);
	}

	protected synchronized void method1001(int var1) {
		if (this.field3189.method5228()) {
			int var2 = this.field3195 * this.field3189.field3168 / class49.field348;

			do {
				long var3 = this.field3193 + (long)var1 * (long)var2;
				if (this.field3194 - var3 >= 0L) {
					this.field3193 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field3194 - this.field3193) - 1L) / (long)var2);
				this.field3193 += (long)var2 * (long)var5;
				this.field3173.method1001(var5);
				var1 -= var5;
				this.method5299();
			} while(this.field3189.method5228());
		}

		this.field3173.method1001(var1);
	}

	void method5299() {
		int var2 = this.field3175;
		int var3 = this.field3192;

		long var4;
		for (var4 = this.field3194; this.field3192 == var3; var4 = this.field3189.method5237(var3)) {
			while (this.field3189.field3161[var2] == var3) {
				this.field3189.method5230(var2);
				int var6 = this.field3189.method5234(var2);
				if (var6 == 1) {
					this.field3189.method5254();
					this.field3189.method5231(var2);
					if (this.field3189.method5239()) {
						if (!this.field3184 || var3 == 0) {
							this.method5289();
							this.field3189.method5256();
							return;
						}

						this.field3189.method5270(var4);
					}
					break;
				}

				if (0 != (var6 & 128)) {
					this.method5339(var6);
				}

				this.field3189.method5233(var2);
				this.field3189.method5231(var2);
			}

			var2 = this.field3189.method5238();
			var3 = this.field3189.field3161[var2];
		}

		this.field3175 = var2;
		this.field3192 = var3;
		this.field3194 = var4;
	}

	boolean method5300(class296 var1) {
		if (var1.field3397 == null) {
			if (var1.field3393 >= 0) {
				var1.method7825();
				if (var1.field3379 > 0 && this.field3188[var1.field3381][var1.field3379] == var1) {
					this.field3188[var1.field3381][var1.field3379] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	boolean method5301(class296 var1, int[] var2, int var3, int var4) {
		var1.field3398 = class49.field348 / 100;
		if (var1.field3393 < 0 || var1.field3397 != null && !var1.field3397.method827()) {
			int var6 = var1.field3389;
			if (var6 > 0) {
				var6 -= (int)(16.0D * Math.pow(2.0D, (double)this.field3180[var1.field3381] * 4.921259842519685E-4D) + 0.5D);
				if (var6 < 0) {
					var6 = 0;
				}

				var1.field3389 = var6;
			}

			var1.field3397.method866(this.method5293(var1));
			class286 var7 = var1.field3394;
			boolean var8 = false;
			++var1.field3395;
			var1.field3383 += var7.field3340;
			double var9 = (double)((var1.field3384 - 60 << 8) + (var1.field3388 * var1.field3389 >> 12)) * 5.086263020833333E-6D;
			if (var7.field3335 > 0) {
				if (var7.field3338 > 0) {
					var1.field3390 += (int)(128.0D * Math.pow(2.0D, (double)var7.field3338 * var9) + 0.5D);
				} else {
					var1.field3390 += 128;
				}
			}

			if (null != var7.field3341) {
				if (var7.field3336 > 0) {
					var1.field3399 += (int)(128.0D * Math.pow(2.0D, var9 * (double)var7.field3336) + 0.5D);
				} else {
					var1.field3399 += 128;
				}

				while (var1.field3392 < var7.field3341.length - 2 && var1.field3399 > (var7.field3341[2 + var1.field3392] & 255) << 8) {
					var1.field3392 += 2;
				}

				if (var7.field3341.length - 2 == var1.field3392 && 0 == var7.field3341[var1.field3392 + 1]) {
					var8 = true;
				}
			}

			if (var1.field3393 >= 0 && null != var7.field3339 && (this.field3181[var1.field3381] & 1) == 0 && (var1.field3379 < 0 || var1 != this.field3188[var1.field3381][var1.field3379])) {
				if (var7.field3337 > 0) {
					var1.field3393 += (int)(128.0D * Math.pow(2.0D, (double)var7.field3337 * var9) + 0.5D);
				} else {
					var1.field3393 += 128;
				}

				while (var1.field3391 < var7.field3339.length - 2 && var1.field3393 > (var7.field3339[2 + var1.field3391] & 255) << 8) {
					var1.field3391 += 2;
				}

				if (var7.field3339.length - 2 == var1.field3391) {
					var8 = true;
				}
			}

			if (var8) {
				var1.field3397.method815(var1.field3398);
				if (var2 != null) {
					var1.field3397.method1005(var2, var3, var4);
				} else {
					var1.field3397.method1001(var4);
				}

				if (var1.field3397.method817()) {
					this.field3173.field3441.method718(var1.field3397);
				}

				var1.method5553();
				if (var1.field3393 >= 0) {
					var1.method7825();
					if (var1.field3379 > 0 && var1 == this.field3188[var1.field3381][var1.field3379]) {
						this.field3188[var1.field3381][var1.field3379] = null;
					}
				}

				return true;
			} else {
				var1.field3397.method806(var1.field3398, this.method5294(var1), this.method5295(var1));
				return false;
			}
		} else {
			var1.method5553();
			var1.method7825();
			if (var1.field3379 > 0 && var1 == this.field3188[var1.field3381][var1.field3379]) {
				this.field3188[var1.field3381][var1.field3379] = null;
			}

			return true;
		}
	}
}
