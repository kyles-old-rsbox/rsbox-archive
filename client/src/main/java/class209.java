public class class209 extends class212 {
	static boolean field2442;
	static boolean[] field2420;
	static boolean[] field2421;
	static byte[] field2379;
	static byte[] field2414;
	static char[] field2429;
	static char[][] field2430;
	static class209 field2437;
	static class209 field2452;
	static class412 field2380;
	static class412 field2381;
	static class412 field2382;
	static int field2377;
	static int field2439;
	static int field2441;
	static int[] field2386;
	static int[] field2399;
	static int[] field2400;
	static int[] field2403;
	static int[] field2408;
	static int[] field2418;
	static int[] field2422;
	static int[] field2426;
	static int[] field2427;
	static int[] field2431;
	static int[] field2433;
	static int[] field2435;
	static int[] field2436;
	static int[] field2438;
	static int[] field2445;
	static int[] field2446;
	static int[] field2451;
	static int[][] field2432;
	byte field2376;
	byte[] field2387;
	byte[] field2394;
	byte[] field2396;
	int field2383;
	int field2395;
	int field2398;
	int field2405;
	int field2410;
	int field2411;
	int field2413;
	int field2415;
	int field2416;
	int field2424;
	int field2425;
	int field2447;
	int field2449;
	int[] field2378;
	int[] field2384;
	int[] field2385;
	int[] field2388;
	int[] field2389;
	int[] field2390;
	int[] field2391;
	int[] field2392;
	int[] field2393;
	int[] field2401;
	int[] field2402;
	int[] field2434;
	int[][] field2404;
	int[][] field2406;
	int[][] field2412;
	int[][] field2448;
	short[] field2397;
	public boolean field2407;
	public byte field2417;
	public byte field2440;
	public byte field2453;
	public byte field2454;
	public int field2409;
	public short field2455;

	static {
		field2437 = new class209();
		field2414 = new byte[1];
		field2452 = new class209();
		field2379 = new byte[1];
		field2380 = new class412();
		field2381 = new class412();
		field2382 = new class412();
		field2420 = new boolean[6500];
		field2421 = new boolean[6500];
		field2422 = new int[6500];
		field2435 = new int[6500];
		field2408 = new int[6500];
		field2403 = new int[6500];
		field2426 = new int[6500];
		field2427 = new int[6500];
		field2429 = new char[6000];
		field2430 = new char[6000][512];
		field2431 = new int[12];
		field2432 = new int[12][2000];
		field2433 = new int[2000];
		field2400 = new int[2000];
		field2418 = new int[12];
		field2436 = new int[10];
		field2386 = new int[10];
		field2438 = new int[10];
		field2442 = true;
		field2445 = class221.field2644;
		field2446 = class221.field2645;
		field2451 = class221.field2640;
		field2399 = class221.field2631;
	}

	class209() {
		this.field2383 = 0;
		this.field2409 = 0;
		this.field2376 = 0;
		this.field2425 = 0;
		this.field2407 = false;
		this.field2416 = -1;
		this.field2449 = -1;
		this.field2398 = -1;
	}

	public class209(class209[] var1, int var2) {
		this.field2383 = 0;
		this.field2409 = 0;
		this.field2376 = 0;
		this.field2425 = 0;
		this.field2407 = false;
		this.field2416 = -1;
		this.field2449 = -1;
		this.field2398 = -1;
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		this.field2383 = 0;
		this.field2409 = 0;
		this.field2425 = 0;
		this.field2376 = -1;

		int var7;
		class209 var8;
		for (var7 = 0; var7 < var2; ++var7) {
			var8 = var1[var7];
			if (var8 != null) {
				this.field2383 += var8.field2383;
				this.field2409 += var8.field2409;
				this.field2425 += var8.field2425;
				if (var8.field2394 != null) {
					var3 = true;
				} else {
					if (this.field2376 == -1) {
						this.field2376 = var8.field2376;
					}

					if (this.field2376 != var8.field2376) {
						var3 = true;
					}
				}

				var4 |= var8.field2387 != null;
				var5 |= var8.field2397 != null;
				var6 |= var8.field2396 != null;
			}
		}

		this.field2384 = new int[this.field2383];
		this.field2378 = new int[this.field2383];
		this.field2385 = new int[this.field2383];
		this.field2388 = new int[this.field2409];
		this.field2389 = new int[this.field2409];
		this.field2390 = new int[this.field2409];
		this.field2391 = new int[this.field2409];
		this.field2392 = new int[this.field2409];
		this.field2393 = new int[this.field2409];
		if (var3) {
			this.field2394 = new byte[this.field2409];
		}

		if (var4) {
			this.field2387 = new byte[this.field2409];
		}

		if (var5) {
			this.field2397 = new short[this.field2409];
		}

		if (var6) {
			this.field2396 = new byte[this.field2409];
		}

		if (this.field2425 > 0) {
			this.field2434 = new int[this.field2425];
			this.field2401 = new int[this.field2425];
			this.field2402 = new int[this.field2425];
		}

		this.field2383 = 0;
		this.field2409 = 0;
		this.field2425 = 0;

		for (var7 = 0; var7 < var2; ++var7) {
			var8 = var1[var7];
			if (var8 != null) {
				int var9;
				for (var9 = 0; var9 < var8.field2409; ++var9) {
					this.field2388[this.field2409] = var8.field2388[var9] + this.field2383;
					this.field2389[this.field2409] = var8.field2389[var9] + this.field2383;
					this.field2390[this.field2409] = var8.field2390[var9] + this.field2383;
					this.field2391[this.field2409] = var8.field2391[var9];
					this.field2392[this.field2409] = var8.field2392[var9];
					this.field2393[this.field2409] = var8.field2393[var9];
					if (var3) {
						if (var8.field2394 != null) {
							this.field2394[this.field2409] = var8.field2394[var9];
						} else {
							this.field2394[this.field2409] = var8.field2376;
						}
					}

					if (var4 && var8.field2387 != null) {
						this.field2387[this.field2409] = var8.field2387[var9];
					}

					if (var5) {
						if (var8.field2397 != null) {
							this.field2397[this.field2409] = var8.field2397[var9];
						} else {
							this.field2397[this.field2409] = -1;
						}
					}

					if (var6) {
						if (var8.field2396 != null && var8.field2396[var9] != -1) {
							this.field2396[this.field2409] = (byte)(var8.field2396[var9] + this.field2425);
						} else {
							this.field2396[this.field2409] = -1;
						}
					}

					++this.field2409;
				}

				for (var9 = 0; var9 < var8.field2425; ++var9) {
					this.field2434[this.field2425] = var8.field2434[var9] + this.field2383;
					this.field2401[this.field2425] = var8.field2401[var9] + this.field2383;
					this.field2402[this.field2425] = var8.field2402[var9] + this.field2383;
					++this.field2425;
				}

				for (var9 = 0; var9 < var8.field2383; ++var9) {
					this.field2384[this.field2383] = var8.field2384[var9];
					this.field2378[this.field2383] = var8.field2378[var9];
					this.field2385[this.field2383] = var8.field2385[var9];
					++this.field2383;
				}
			}
		}

	}

	public class209 method4011(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
		this.method4067();
		int var7 = var2 - this.field2410;
		int var8 = var2 + this.field2410;
		int var9 = var4 - this.field2410;
		int var10 = var4 + this.field2410;
		if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
			var7 >>= 7;
			var8 = var8 + 127 >> 7;
			var9 >>= 7;
			var10 = var10 + 127 >> 7;
			if (var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
				return this;
			} else {
				class209 var11;
				if (var5) {
					var11 = new class209();
					var11.field2383 = this.field2383;
					var11.field2409 = this.field2409;
					var11.field2425 = this.field2425;
					var11.field2384 = this.field2384;
					var11.field2385 = this.field2385;
					var11.field2388 = this.field2388;
					var11.field2389 = this.field2389;
					var11.field2390 = this.field2390;
					var11.field2391 = this.field2391;
					var11.field2392 = this.field2392;
					var11.field2393 = this.field2393;
					var11.field2394 = this.field2394;
					var11.field2387 = this.field2387;
					var11.field2396 = this.field2396;
					var11.field2397 = this.field2397;
					var11.field2376 = this.field2376;
					var11.field2434 = this.field2434;
					var11.field2401 = this.field2401;
					var11.field2402 = this.field2402;
					var11.field2448 = this.field2448;
					var11.field2404 = this.field2404;
					var11.field2407 = this.field2407;
					var11.field2378 = new int[var11.field2383];
				} else {
					var11 = this;
				}

				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				int var20;
				int var21;
				if (var6 == 0) {
					for (var12 = 0; var12 < var11.field2383; ++var12) {
						var13 = this.field2384[var12] + var2;
						var14 = this.field2385[var12] + var4;
						var15 = var13 & 127;
						var16 = var14 & 127;
						var17 = var13 >> 7;
						var18 = var14 >> 7;
						var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
						var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
						var21 = var19 * (128 - var16) + var20 * var16 >> 7;
						var11.field2378[var12] = this.field2378[var12] + var21 - var3;
					}
				} else {
					for (var12 = 0; var12 < var11.field2383; ++var12) {
						var13 = (-this.field2378[var12] << 16) / super.field2489;
						if (var13 < var6) {
							var14 = this.field2384[var12] + var2;
							var15 = this.field2385[var12] + var4;
							var16 = var14 & 127;
							var17 = var15 & 127;
							var18 = var14 >> 7;
							var19 = var15 >> 7;
							var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
							var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
							int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
							var11.field2378[var12] = this.field2378[var12] + (var22 - var3) * (var6 - var13) / var6;
						}
					}
				}

				var11.method3995();
				return var11;
			}
		} else {
			return this;
		}
	}

	public class209 method3988(boolean var1) {
		if (!var1 && field2414.length < this.field2409) {
			field2414 = new byte[this.field2409 + 100];
		}

		return this.method3990(var1, field2437, field2414);
	}

	public class209 method3997(boolean var1) {
		if (!var1 && field2379.length < this.field2409) {
			field2379 = new byte[this.field2409 + 100];
		}

		return this.method3990(var1, field2452, field2379);
	}

	class209 method3990(boolean var1, class209 var2, byte[] var3) {
		var2.field2383 = this.field2383;
		var2.field2409 = this.field2409;
		var2.field2425 = this.field2425;
		if (var2.field2384 == null || var2.field2384.length < this.field2383) {
			var2.field2384 = new int[this.field2383 + 100];
			var2.field2378 = new int[this.field2383 + 100];
			var2.field2385 = new int[this.field2383 + 100];
		}

		int var4;
		for (var4 = 0; var4 < this.field2383; ++var4) {
			var2.field2384[var4] = this.field2384[var4];
			var2.field2378[var4] = this.field2378[var4];
			var2.field2385[var4] = this.field2385[var4];
		}

		if (var1) {
			var2.field2387 = this.field2387;
		} else {
			var2.field2387 = var3;
			if (this.field2387 == null) {
				for (var4 = 0; var4 < this.field2409; ++var4) {
					var2.field2387[var4] = 0;
				}
			} else {
				for (var4 = 0; var4 < this.field2409; ++var4) {
					var2.field2387[var4] = this.field2387[var4];
				}
			}
		}

		var2.field2388 = this.field2388;
		var2.field2389 = this.field2389;
		var2.field2390 = this.field2390;
		var2.field2391 = this.field2391;
		var2.field2392 = this.field2392;
		var2.field2393 = this.field2393;
		var2.field2394 = this.field2394;
		var2.field2396 = this.field2396;
		var2.field2397 = this.field2397;
		var2.field2376 = this.field2376;
		var2.field2434 = this.field2434;
		var2.field2401 = this.field2401;
		var2.field2402 = this.field2402;
		var2.field2448 = this.field2448;
		var2.field2404 = this.field2404;
		var2.field2412 = this.field2412;
		var2.field2406 = this.field2406;
		var2.field2407 = this.field2407;
		var2.method3995();
		var2.field2454 = 0;
		return var2;
	}

	void method4039(int var1) {
		if (this.field2416 == -1) {
			int var2 = 0;
			int var3 = 0;
			int var4 = 0;
			int var5 = 0;
			int var6 = 0;
			int var7 = 0;
			int var8 = field2446[var1];
			int var9 = field2445[var1];

			for (int var10 = 0; var10 < this.field2383; ++var10) {
				int var11 = class221.method4430(this.field2384[var10], this.field2385[var10], var8, var9);
				int var12 = this.field2378[var10];
				int var13 = class221.method4410(this.field2384[var10], this.field2385[var10], var8, var9);
				if (var11 < var2) {
					var2 = var11;
				}

				if (var11 > var5) {
					var5 = var11;
				}

				if (var12 < var3) {
					var3 = var12;
				}

				if (var12 > var6) {
					var6 = var12;
				}

				if (var13 < var4) {
					var4 = var13;
				}

				if (var13 > var7) {
					var7 = var13;
				}
			}

			this.field2413 = (var5 + var2) / 2;
			this.field2405 = (var6 + var3) / 2;
			this.field2415 = (var7 + var4) / 2;
			this.field2416 = (var5 - var2 + 1) / 2;
			this.field2449 = (var6 - var3 + 1) / 2;
			this.field2398 = (var7 - var4 + 1) / 2;
			boolean var14 = true;
			if (this.field2416 < 32) {
				this.field2416 = 32;
			}

			if (this.field2398 < 32) {
				this.field2398 = 32;
			}

			if (this.field2407) {
				boolean var15 = true;
				this.field2416 += 8;
				this.field2398 += 8;
			}

		}
	}

	public void method4067() {
		if (this.field2395 != 1) {
			this.field2395 = 1;
			super.field2489 = 0;
			this.field2424 = 0;
			this.field2410 = 0;

			for (int var1 = 0; var1 < this.field2383; ++var1) {
				int var2 = this.field2384[var1];
				int var3 = this.field2378[var1];
				int var4 = this.field2385[var1];
				if (-var3 > super.field2489) {
					super.field2489 = -var3;
				}

				if (var3 > this.field2424) {
					this.field2424 = var3;
				}

				int var5 = var2 * var2 + var4 * var4;
				if (var5 > this.field2410) {
					this.field2410 = var5;
				}
			}

			this.field2410 = (int)(Math.sqrt((double)this.field2410) + 0.99D);
			this.field2447 = (int)(Math.sqrt((double)(this.field2410 * this.field2410 + super.field2489 * super.field2489)) + 0.99D);
			this.field2411 = this.field2447 + (int)(Math.sqrt((double)(this.field2410 * this.field2410 + this.field2424 * this.field2424)) + 0.99D);
		}
	}

	void method3993() {
		if (this.field2395 != 2) {
			this.field2395 = 2;
			this.field2410 = 0;

			for (int var1 = 0; var1 < this.field2383; ++var1) {
				int var2 = this.field2384[var1];
				int var3 = this.field2378[var1];
				int var4 = this.field2385[var1];
				int var5 = var2 * var2 + var4 * var4 + var3 * var3;
				if (var5 > this.field2410) {
					this.field2410 = var5;
				}
			}

			this.field2410 = (int)(Math.sqrt((double)this.field2410) + 0.99D);
			this.field2447 = this.field2410;
			this.field2411 = this.field2410 + this.field2410;
		}
	}

	public int method3994() {
		this.method4067();
		return this.field2410;
	}

	public void method3995() {
		this.field2395 = 0;
		this.field2416 = -1;
	}

	public void method4033(class218 var1, int var2) {
		if (this.field2448 != null) {
			if (var2 != -1) {
				class223 var3 = var1.field2595[var2];
				class230 var4 = var3.field2650;
				field2439 = 0;
				field2377 = 0;
				field2441 = 0;

				for (int var5 = 0; var5 < var3.field2654; ++var5) {
					int var6 = var3.field2658[var5];
					this.method4003(var4.field2745[var6], var4.field2746[var6], var3.field2656[var5], var3.field2657[var5], var3.field2649[var5]);
				}

				this.method3995();
			}
		}
	}

	public void method4057(class112 var1, int var2) {
		class230 var3 = var1.field1104;
		class216 var4 = var3.method4530();
		if (var4 != null) {
			var3.method4530().method4341(var1, var2);
			this.method4069(var3.method4530(), var1.method2147());
		}

		if (var1.method2152()) {
			this.method3998(var1, var2);
		}

		this.method3995();
	}

	void method3998(class112 var1, int var2) {
		class230 var3 = var1.field1104;

		for (int var4 = 0; var4 < var3.field2744; ++var4) {
			int var5 = var3.field2745[var4];
			if (var5 == 5 && var1.field1102 != null && var1.field1102[var4] != null && var1.field1102[var4][0] != null && this.field2404 != null && this.field2387 != null) {
				class106 var6 = var1.field1102[var4][0];
				int[] var7 = var3.field2746[var4];
				int var8 = var7.length;

				for (int var9 = 0; var9 < var8; ++var9) {
					int var10 = var7[var9];
					if (var10 < this.field2404.length) {
						int[] var11 = this.field2404[var10];

						for (int var12 = 0; var12 < var11.length; ++var12) {
							int var13 = var11[var12];
							int var14 = (int)((float)(this.field2387[var13] & 255) + var6.method2060(var2) * 255.0F);
							if (var14 < 0) {
								var14 = 0;
							} else if (var14 > 255) {
								var14 = 255;
							}

							this.field2387[var13] = (byte)var14;
						}
					}
				}
			}
		}

	}

	void method4069(class216 var1, int var2) {
		this.method4018(var1, var2);
	}

	public void method4088(class218 var1, int var2, class218 var3, int var4, int[] var5) {
		if (var2 != -1) {
			if (var5 != null && var4 != -1) {
				class223 var6 = var1.field2595[var2];
				class223 var7 = var3.field2595[var4];
				class230 var8 = var6.field2650;
				field2439 = 0;
				field2377 = 0;
				field2441 = 0;
				byte var9 = 0;
				int var13 = var9 + 1;
				int var10 = var5[var9];

				int var11;
				int var12;
				for (var11 = 0; var11 < var6.field2654; ++var11) {
					for (var12 = var6.field2658[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 != var10 || var8.field2745[var12] == 0) {
						this.method4003(var8.field2745[var12], var8.field2746[var12], var6.field2656[var11], var6.field2657[var11], var6.field2649[var11]);
					}
				}

				field2439 = 0;
				field2377 = 0;
				field2441 = 0;
				var9 = 0;
				var13 = var9 + 1;
				var10 = var5[var9];

				for (var11 = 0; var11 < var7.field2654; ++var11) {
					for (var12 = var7.field2658[var11]; var12 > var10; var10 = var5[var13++]) {
					}

					if (var12 == var10 || var8.field2745[var12] == 0) {
						this.method4003(var8.field2745[var12], var8.field2746[var12], var7.field2656[var11], var7.field2657[var11], var7.field2649[var11]);
					}
				}

				this.method3995();
			} else {
				this.method4033(var1, var2);
			}
		}
	}

	public void method4055(class230 var1, class112 var2, int var3, boolean[] var4, boolean var5, boolean var6) {
		class216 var7 = var1.method4530();
		if (var7 != null) {
			var7.method4342(var2, var3, var4, var5);
			if (var6) {
				this.method4069(var7, var2.method2147());
			}
		}

		if (!var5 && var2.method2152()) {
			this.method3998(var2, var3);
		}

	}

	public void method4002(class218 var1, int var2, int[] var3, boolean var4) {
		if (var3 == null) {
			this.method4033(var1, var2);
		} else {
			class223 var5 = var1.field2595[var2];
			class230 var6 = var5.field2650;
			byte var7 = 0;
			int var11 = var7 + 1;
			int var8 = var3[var7];
			field2439 = 0;
			field2377 = 0;
			field2441 = 0;

			for (int var9 = 0; var9 < var5.field2654; ++var9) {
				int var10;
				for (var10 = var5.field2658[var9]; var10 > var8; var8 = var3[var11++]) {
				}

				if (var4) {
					if (var10 == var8 || var6.field2745[var10] == 0) {
						this.method4003(var6.field2745[var10], var6.field2746[var10], var5.field2656[var9], var5.field2657[var9], var5.field2649[var9]);
					}
				} else if (var10 != var8 || var6.field2745[var10] == 0) {
					this.method4003(var6.field2745[var10], var6.field2746[var10], var5.field2656[var9], var5.field2657[var9], var5.field2649[var9]);
				}
			}

		}
	}

	void method4003(int var1, int[] var2, int var3, int var4, int var5) {
		int var6 = var2.length;
		int var7;
		int var8;
		int var11;
		int var12;
		if (var1 == 0) {
			var7 = 0;
			field2439 = 0;
			field2377 = 0;
			field2441 = 0;

			for (var8 = 0; var8 < var6; ++var8) {
				int var9 = var2[var8];
				if (var9 < this.field2448.length) {
					int[] var10 = this.field2448[var9];

					for (var11 = 0; var11 < var10.length; ++var11) {
						var12 = var10[var11];
						field2439 += this.field2384[var12];
						field2377 += this.field2378[var12];
						field2441 += this.field2385[var12];
						++var7;
					}
				}
			}

			if (var7 > 0) {
				field2439 = field2439 / var7 + var3;
				field2377 = field2377 / var7 + var4;
				field2441 = field2441 / var7 + var5;
			} else {
				field2439 = var3;
				field2377 = var4;
				field2441 = var5;
			}

		} else {
			int[] var10000;
			int[] var18;
			int var19;
			if (var1 == 1) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.field2448.length) {
						var18 = this.field2448[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.field2384;
							var10000[var11] += var3;
							var10000 = this.field2378;
							var10000[var11] += var4;
							var10000 = this.field2385;
							var10000[var11] += var5;
						}
					}
				}

			} else if (var1 == 2) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.field2448.length) {
						var18 = this.field2448[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.field2384;
							var10000[var11] -= field2439;
							var10000 = this.field2378;
							var10000[var11] -= field2377;
							var10000 = this.field2385;
							var10000[var11] -= field2441;
							var12 = (var3 & 255) * 8;
							int var13 = (var4 & 255) * 8;
							int var14 = (var5 & 255) * 8;
							int var15;
							int var16;
							int var17;
							if (var14 != 0) {
								var15 = field2445[var14];
								var16 = field2446[var14];
								var17 = this.field2378[var11] * var15 + this.field2384[var11] * var16 >> 16;
								this.field2378[var11] = this.field2378[var11] * var16 - this.field2384[var11] * var15 >> 16;
								this.field2384[var11] = var17;
							}

							if (var12 != 0) {
								var15 = field2445[var12];
								var16 = field2446[var12];
								var17 = this.field2378[var11] * var16 - this.field2385[var11] * var15 >> 16;
								this.field2385[var11] = this.field2378[var11] * var15 + this.field2385[var11] * var16 >> 16;
								this.field2378[var11] = var17;
							}

							if (var13 != 0) {
								var15 = field2445[var13];
								var16 = field2446[var13];
								var17 = this.field2385[var11] * var15 + this.field2384[var11] * var16 >> 16;
								this.field2385[var11] = this.field2385[var11] * var16 - this.field2384[var11] * var15 >> 16;
								this.field2384[var11] = var17;
							}

							var10000 = this.field2384;
							var10000[var11] += field2439;
							var10000 = this.field2378;
							var10000[var11] += field2377;
							var10000 = this.field2385;
							var10000[var11] += field2441;
						}
					}
				}

			} else if (var1 == 3) {
				for (var7 = 0; var7 < var6; ++var7) {
					var8 = var2[var7];
					if (var8 < this.field2448.length) {
						var18 = this.field2448[var8];

						for (var19 = 0; var19 < var18.length; ++var19) {
							var11 = var18[var19];
							var10000 = this.field2384;
							var10000[var11] -= field2439;
							var10000 = this.field2378;
							var10000[var11] -= field2377;
							var10000 = this.field2385;
							var10000[var11] -= field2441;
							this.field2384[var11] = this.field2384[var11] * var3 / 128;
							this.field2378[var11] = this.field2378[var11] * var4 / 128;
							this.field2385[var11] = this.field2385[var11] * var5 / 128;
							var10000 = this.field2384;
							var10000[var11] += field2439;
							var10000 = this.field2378;
							var10000[var11] += field2377;
							var10000 = this.field2385;
							var10000[var11] += field2441;
						}
					}
				}

			} else if (var1 == 5) {
				if (this.field2404 != null && this.field2387 != null) {
					for (var7 = 0; var7 < var6; ++var7) {
						var8 = var2[var7];
						if (var8 < this.field2404.length) {
							var18 = this.field2404[var8];

							for (var19 = 0; var19 < var18.length; ++var19) {
								var11 = var18[var19];
								var12 = (this.field2387[var11] & 255) + var3 * 8;
								if (var12 < 0) {
									var12 = 0;
								} else if (var12 > 255) {
									var12 = 255;
								}

								this.field2387[var11] = (byte)var12;
							}
						}
					}
				}

			}
		}
	}

	public void method4083() {
		for (int var1 = 0; var1 < this.field2383; ++var1) {
			int var2 = this.field2384[var1];
			this.field2384[var1] = this.field2385[var1];
			this.field2385[var1] = -var2;
		}

		this.method3995();
	}

	public void method4005() {
		for (int var1 = 0; var1 < this.field2383; ++var1) {
			this.field2384[var1] = -this.field2384[var1];
			this.field2385[var1] = -this.field2385[var1];
		}

		this.method3995();
	}

	public void method4006() {
		for (int var1 = 0; var1 < this.field2383; ++var1) {
			int var2 = this.field2385[var1];
			this.field2385[var1] = this.field2384[var1];
			this.field2384[var1] = -var2;
		}

		this.method3995();
	}

	public void method4007(int var1) {
		int var2 = field2445[var1];
		int var3 = field2446[var1];

		for (int var4 = 0; var4 < this.field2383; ++var4) {
			int var5 = this.field2378[var4] * var3 - this.field2385[var4] * var2 >> 16;
			this.field2385[var4] = this.field2378[var4] * var2 + this.field2385[var4] * var3 >> 16;
			this.field2378[var4] = var5;
		}

		this.method3995();
	}

	public void method4008(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.field2383; ++var4) {
			int[] var10000 = this.field2384;
			var10000[var4] += var1;
			var10000 = this.field2378;
			var10000[var4] += var2;
			var10000 = this.field2385;
			var10000[var4] += var3;
		}

		this.method3995();
	}

	public void method4062(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.field2383; ++var4) {
			this.field2384[var4] = this.field2384[var4] * var1 / 128;
			this.field2378[var4] = this.field2378[var4] * var2 / 128;
			this.field2385[var4] = this.field2385[var4] * var3 / 128;
		}

		this.method3995();
	}

	public final void method4074(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (this.field2395 != 2 && this.field2395 != 1) {
			this.method3993();
		}

		int var8 = class221.field2634;
		int var9 = class221.field2620;
		int var10 = field2445[var1];
		int var11 = field2446[var1];
		int var12 = field2445[var2];
		int var13 = field2446[var2];
		int var14 = field2445[var3];
		int var15 = field2446[var3];
		int var16 = field2445[var4];
		int var17 = field2446[var4];
		int var18 = var6 * var16 + var7 * var17 >> 16;

		for (int var19 = 0; var19 < this.field2383; ++var19) {
			int var20 = this.field2384[var19];
			int var21 = this.field2378[var19];
			int var22 = this.field2385[var19];
			int var23;
			if (var3 != 0) {
				var23 = var21 * var14 + var20 * var15 >> 16;
				var21 = var21 * var15 - var20 * var14 >> 16;
				var20 = var23;
			}

			if (var1 != 0) {
				var23 = var21 * var11 - var22 * var10 >> 16;
				var22 = var21 * var10 + var22 * var11 >> 16;
				var21 = var23;
			}

			if (var2 != 0) {
				var23 = var22 * var12 + var20 * var13 >> 16;
				var22 = var22 * var13 - var20 * var12 >> 16;
				var20 = var23;
			}

			var20 += var5;
			var21 += var6;
			var22 += var7;
			var23 = var21 * var17 - var22 * var16 >> 16;
			var22 = var21 * var16 + var22 * var17 >> 16;
			field2408[var19] = var22 - var18;
			field2422[var19] = var8 + var20 * class221.field2630 / var22;
			field2435[var19] = var9 + var23 * class221.field2630 / var22;
			if (this.field2425 > 0) {
				field2403[var19] = var20;
				field2426[var19] = var23;
				field2427[var19] = var22;
			}
		}

		try {
			this.method4079(false, false, false, 0L);
		} catch (Exception var25) {
		}

	}

	public final void method3996(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (this.field2395 != 2 && this.field2395 != 1) {
			this.method3993();
		}

		int var9 = class221.field2634;
		int var10 = class221.field2620;
		int var11 = field2445[var1];
		int var12 = field2446[var1];
		int var13 = field2445[var2];
		int var14 = field2446[var2];
		int var15 = field2445[var3];
		int var16 = field2446[var3];
		int var17 = field2445[var4];
		int var18 = field2446[var4];
		int var19 = var6 * var17 + var7 * var18 >> 16;

		for (int var20 = 0; var20 < this.field2383; ++var20) {
			int var21 = this.field2384[var20];
			int var22 = this.field2378[var20];
			int var23 = this.field2385[var20];
			int var24;
			if (var3 != 0) {
				var24 = var22 * var15 + var21 * var16 >> 16;
				var22 = var22 * var16 - var21 * var15 >> 16;
				var21 = var24;
			}

			if (var1 != 0) {
				var24 = var22 * var12 - var23 * var11 >> 16;
				var23 = var22 * var11 + var23 * var12 >> 16;
				var22 = var24;
			}

			if (var2 != 0) {
				var24 = var23 * var13 + var21 * var14 >> 16;
				var23 = var23 * var14 - var21 * var13 >> 16;
				var21 = var24;
			}

			var21 += var5;
			var22 += var6;
			var23 += var7;
			var24 = var22 * var18 - var23 * var17 >> 16;
			var23 = var22 * var17 + var23 * var18 >> 16;
			field2408[var20] = var23 - var19;
			field2422[var20] = var9 + var21 * class221.field2630 / var8;
			field2435[var20] = var10 + var24 * class221.field2630 / var8;
			if (this.field2425 > 0) {
				field2403[var20] = var21;
				field2426[var20] = var24;
				field2427[var20] = var23;
			}
		}

		try {
			this.method4079(false, false, false, 0L);
		} catch (Exception var26) {
		}

	}

	void method4116(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		if (this.field2395 != 1) {
			this.method4067();
		}

		this.method4039(var1);
		int var11 = var8 * var5 - var6 * var4 >> 16;
		int var12 = var7 * var2 + var11 * var3 >> 16;
		int var13 = this.field2410 * var3 >> 16;
		int var14 = var12 + var13;
		if (var14 > 50 && var12 < 3500) {
			int var15 = var8 * var4 + var6 * var5 >> 16;
			int var16 = (var15 - this.field2410) * class221.field2630;
			if (var16 / var14 < class221.field2636) {
				int var17 = (var15 + this.field2410) * class221.field2630;
				if (var17 / var14 > class221.field2635) {
					int var18 = var7 * var3 - var11 * var2 >> 16;
					int var19 = this.field2410 * var2 >> 16;
					int var20 = var19 + (this.field2424 * var3 >> 16);
					int var21 = (var18 + var20) * class221.field2630;
					if (var21 / var14 > class221.field2637) {
						int var22 = var19 + (super.field2489 * var3 >> 16);
						int var23 = (var18 - var22) * class221.field2630;
						if (var23 / var14 < class221.field2632) {
							int var24 = var13 + (super.field2489 * var2 >> 16);
							boolean var25 = false;
							boolean var26 = false;
							if (var12 - var24 <= 50) {
								var26 = true;
							}

							boolean var27 = var26 || this.field2425 > 0;
							int var28 = class234.method5046();
							int var29 = class234.field2768;
							boolean var31 = class234.method2212();
							boolean var32 = class234.method5519(var9);
							boolean var33 = false;
							int var37;
							int var38;
							int var39;
							int var40;
							int var41;
							int var42;
							int var46;
							int var52;
							if (var32 && var31) {
								boolean var34 = false;
								if (field2442) {
									boolean var35;
									if (!class234.method2212()) {
										var35 = false;
									} else {
										class113.method2211();
										var37 = this.field2413 + var6;
										var38 = this.field2405 + var7;
										var39 = var8 + this.field2415;
										var40 = this.field2416;
										var41 = this.field2449;
										var42 = this.field2398;
										int var43 = class234.field2770 - var37;
										int var44 = class234.field2775 - var38;
										int var45 = class234.field2772 - var39;
										if (Math.abs(var43) > class234.field2773 + var40) {
											var35 = false;
										} else if (Math.abs(var44) > var41 + class435.field4721) {
											var35 = false;
										} else if (Math.abs(var45) > class25.field120 + var42) {
											var35 = false;
										} else if (Math.abs(var45 * class116.field1135 - var44 * class73.field602) > var41 * class25.field120 + class435.field4721 * var42) {
											var35 = false;
										} else if (Math.abs(var43 * class73.field602 - class287.field3343 * var45) > class25.field120 * var40 + var42 * class234.field2773) {
											var35 = false;
										} else if (Math.abs(var44 * class287.field3343 - var43 * class116.field1135) > class435.field4721 * var40 + class234.field2773 * var41) {
											var35 = false;
										} else {
											var35 = true;
										}
									}

									var34 = var35;
								} else {
									var52 = var12 - var13;
									if (var52 <= 50) {
										var52 = 50;
									}

									if (var15 > 0) {
										var16 /= var14;
										var17 /= var52;
									} else {
										var17 /= var14;
										var16 /= var52;
									}

									if (var18 > 0) {
										var23 /= var14;
										var21 /= var52;
									} else {
										var21 /= var14;
										var23 /= var52;
									}

									var46 = var28 - class221.field2634;
									var37 = var29 - class221.field2620;
									if (var46 > var16 && var46 < var17 && var37 > var23 && var37 < var21) {
										var34 = true;
									}
								}

								if (var34) {
									if (this.field2407) {
										class234.field2766[++class234.field2771 - 1] = var9;
									} else {
										var33 = true;
									}
								}
							}

							int var51 = class221.field2634;
							var52 = class221.field2620;
							var46 = 0;
							var37 = 0;
							if (var1 != 0) {
								var46 = field2445[var1];
								var37 = field2446[var1];
							}

							for (var38 = 0; var38 < this.field2383; ++var38) {
								var39 = this.field2384[var38];
								var40 = this.field2378[var38];
								var41 = this.field2385[var38];
								if (var1 != 0) {
									var42 = var41 * var46 + var39 * var37 >> 16;
									var41 = var41 * var37 - var39 * var46 >> 16;
									var39 = var42;
								}

								var39 += var6;
								var40 += var7;
								var41 += var8;
								var42 = var41 * var4 + var39 * var5 >> 16;
								var41 = var41 * var5 - var39 * var4 >> 16;
								var39 = var42;
								var42 = var40 * var3 - var41 * var2 >> 16;
								var41 = var40 * var2 + var41 * var3 >> 16;
								field2408[var38] = var41 - var12;
								if (var41 >= 50) {
									field2422[var38] = var51 + var39 * class221.field2630 / var41;
									field2435[var38] = var52 + var42 * class221.field2630 / var41;
								} else {
									field2422[var38] = -5000;
									var25 = true;
								}

								if (var27) {
									field2403[var38] = var39;
									field2426[var38] = var42;
									field2427[var38] = var41;
								}
							}

							try {
								this.method4079(var25, var33, this.field2407, var9);
							} catch (Exception var50) {
							}

						}
					}
				}
			}
		}
	}

	final void method4079(boolean var1, boolean var2, boolean var3, long var4) {
		if (this.field2411 < 6000) {
			int var6;
			for (var6 = 0; var6 < this.field2411; ++var6) {
				field2429[var6] = 0;
			}

			var6 = var3 ? 20 : 5;

			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			int var15;
			int var16;
			int var18;
			for (char var7 = 0; var7 < this.field2409; ++var7) {
				if (this.field2393[var7] != -2) {
					var8 = this.field2388[var7];
					var9 = this.field2389[var7];
					var10 = this.field2390[var7];
					var11 = field2422[var8];
					var12 = field2422[var9];
					var13 = field2422[var10];
					int var14;
					if (!var1 || var11 != -5000 && var12 != -5000 && var13 != -5000) {
						if (var2 && class18.method220(field2435[var8], field2435[var9], field2435[var10], var11, var12, var13, var6)) {
							class234.field2766[++class234.field2771 - 1] = var4;
							var2 = false;
						}

						if ((var11 - var12) * (field2435[var10] - field2435[var9]) - (field2435[var8] - field2435[var9]) * (var13 - var12) > 0) {
							field2421[var7] = false;
							if (var11 >= 0 && var12 >= 0 && var13 >= 0 && var11 <= class221.field2633 && var12 <= class221.field2633 && var13 <= class221.field2633) {
								field2420[var7] = false;
							} else {
								field2420[var7] = true;
							}

							var14 = (field2408[var8] + field2408[var9] + field2408[var10]) / 3 + this.field2447;
							field2430[var14][field2429[var14]++] = var7;
						}
					} else {
						var14 = field2403[var8];
						var15 = field2403[var9];
						var16 = field2403[var10];
						int var17 = field2426[var8];
						var18 = field2426[var9];
						int var19 = field2426[var10];
						int var20 = field2427[var8];
						int var21 = field2427[var9];
						int var22 = field2427[var10];
						var14 -= var15;
						var16 -= var15;
						var17 -= var18;
						var19 -= var18;
						var20 -= var21;
						var22 -= var21;
						int var23 = var17 * var22 - var20 * var19;
						int var24 = var20 * var16 - var14 * var22;
						int var25 = var14 * var19 - var17 * var16;
						if (var15 * var23 + var18 * var24 + var21 * var25 > 0) {
							field2421[var7] = true;
							int var26 = (field2408[var8] + field2408[var9] + field2408[var10]) / 3 + this.field2447;
							field2430[var26][field2429[var26]++] = var7;
						}
					}
				}
			}

			char[] var29;
			int var33;
			char var34;
			if (this.field2394 == null) {
				for (var33 = this.field2411 - 1; var33 >= 0; --var33) {
					var34 = field2429[var33];
					if (var34 > 0) {
						var29 = field2430[var33];

						for (var10 = 0; var10 < var34; ++var10) {
							this.method4013(var29[var10]);
						}
					}
				}

			} else {
				for (var33 = 0; var33 < 12; ++var33) {
					field2431[var33] = 0;
					field2418[var33] = 0;
				}

				for (var33 = this.field2411 - 1; var33 >= 0; --var33) {
					var34 = field2429[var33];
					if (var34 > 0) {
						var29 = field2430[var33];

						for (var10 = 0; var10 < var34; ++var10) {
							char var35 = var29[var10];
							byte var36 = this.field2394[var35];
							var13 = field2431[var36]++;
							field2432[var36][var13] = var35;
							if (var36 < 10) {
								int[] var37 = field2418;
								var37[var36] += var33;
							} else if (var36 == 10) {
								field2433[var13] = var33;
							} else {
								field2400[var13] = var33;
							}
						}
					}
				}

				var33 = 0;
				if (field2431[1] > 0 || field2431[2] > 0) {
					var33 = (field2418[1] + field2418[2]) / (field2431[1] + field2431[2]);
				}

				var8 = 0;
				if (field2431[3] > 0 || field2431[4] > 0) {
					var8 = (field2418[3] + field2418[4]) / (field2431[3] + field2431[4]);
				}

				var9 = 0;
				if (field2431[6] > 0 || field2431[8] > 0) {
					var9 = (field2418[6] + field2418[8]) / (field2431[6] + field2431[8]);
				}

				var11 = 0;
				var12 = field2431[10];
				int[] var30 = field2432[10];
				int[] var31 = field2433;
				if (var11 == var12) {
					var11 = 0;
					var12 = field2431[11];
					var30 = field2432[11];
					var31 = field2400;
				}

				if (var11 < var12) {
					var10 = var31[var11];
				} else {
					var10 = -1000;
				}

				for (var15 = 0; var15 < 10; ++var15) {
					while (var15 == 0 && var10 > var33) {
						this.method4013(var30[var11++]);
						if (var11 == var12 && var30 != field2432[11]) {
							var11 = 0;
							var12 = field2431[11];
							var30 = field2432[11];
							var31 = field2400;
						}

						if (var11 < var12) {
							var10 = var31[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 3 && var10 > var8) {
						this.method4013(var30[var11++]);
						if (var11 == var12 && var30 != field2432[11]) {
							var11 = 0;
							var12 = field2431[11];
							var30 = field2432[11];
							var31 = field2400;
						}

						if (var11 < var12) {
							var10 = var31[var11];
						} else {
							var10 = -1000;
						}
					}

					while (var15 == 5 && var10 > var9) {
						this.method4013(var30[var11++]);
						if (var11 == var12 && var30 != field2432[11]) {
							var11 = 0;
							var12 = field2431[11];
							var30 = field2432[11];
							var31 = field2400;
						}

						if (var11 < var12) {
							var10 = var31[var11];
						} else {
							var10 = -1000;
						}
					}

					var16 = field2431[var15];
					int[] var32 = field2432[var15];

					for (var18 = 0; var18 < var16; ++var18) {
						this.method4013(var32[var18]);
					}
				}

				while (var10 != -1000) {
					this.method4013(var30[var11++]);
					if (var11 == var12 && var30 != field2432[11]) {
						var11 = 0;
						var30 = field2432[11];
						var12 = field2431[11];
						var31 = field2400;
					}

					if (var11 < var12) {
						var10 = var31[var11];
					} else {
						var10 = -1000;
					}
				}

			}
		}
	}

	final void method4013(int var1) {
		if (field2421[var1]) {
			this.method4016(var1);
		} else {
			int var2 = this.field2388[var1];
			int var3 = this.field2389[var1];
			int var4 = this.field2390[var1];
			class221.field2628 = field2420[var1];
			if (this.field2387 == null) {
				class221.field2623 = 0;
			} else {
				class221.field2623 = this.field2387[var1] & 255;
			}

			this.method4031(var1, field2435[var2], field2435[var3], field2435[var4], field2422[var2], field2422[var3], field2422[var4], this.field2391[var1], this.field2392[var1], this.field2393[var1]);
		}
	}

	boolean method4014(int var1) {
		return this.field2454 > 0 && var1 < this.field2455;
	}

	final void method4031(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		if (this.field2397 != null && this.field2397[var1] != -1) {
			int var12;
			int var13;
			int var15;
			if (this.field2396 != null && this.field2396[var1] != -1) {
				int var14 = this.field2396[var1] & 255;
				var15 = this.field2434[var14];
				var12 = this.field2401[var14];
				var13 = this.field2402[var14];
			} else {
				var15 = this.field2388[var1];
				var12 = this.field2389[var1];
				var13 = this.field2390[var1];
			}

			if (this.field2393[var1] == -1) {
				class221.method4405(var2, var3, var4, var5, var6, var7, var8, var8, var8, field2403[var15], field2403[var12], field2403[var13], field2426[var15], field2426[var12], field2426[var13], field2427[var15], field2427[var12], field2427[var13], this.field2397[var1]);
			} else {
				class221.method4405(var2, var3, var4, var5, var6, var7, var8, var9, var10, field2403[var15], field2403[var12], field2403[var13], field2426[var15], field2426[var12], field2426[var13], field2427[var15], field2427[var12], field2427[var13], this.field2397[var1]);
			}
		} else {
			boolean var11 = this.method4014(var1);
			if (this.field2393[var1] == -1 && var11) {
				class221.method4403(var2, var3, var4, var5, var6, var7, field2451[this.field2391[var1]], this.field2440, this.field2417, this.field2453, this.field2454);
			} else if (this.field2393[var1] == -1) {
				class221.method4460(var2, var3, var4, var5, var6, var7, field2451[this.field2391[var1]]);
			} else if (var11) {
				class221.method4399(var2, var3, var4, var5, var6, var7, var8, var9, var10, this.field2440, this.field2417, this.field2453, this.field2454);
			} else {
				class221.method4398(var2, var3, var4, var5, var6, var7, var8, var9, var10);
			}
		}

	}

	final void method4016(int var1) {
		int var2 = class221.field2634;
		int var3 = class221.field2620;
		int var4 = 0;
		int var5 = this.field2388[var1];
		int var6 = this.field2389[var1];
		int var7 = this.field2390[var1];
		int var8 = field2427[var5];
		int var9 = field2427[var6];
		int var10 = field2427[var7];
		if (this.field2387 == null) {
			class221.field2623 = 0;
		} else {
			class221.field2623 = this.field2387[var1] & 255;
		}

		int var11;
		int var12;
		int var13;
		int var14;
		if (var8 >= 50) {
			field2436[var4] = field2422[var5];
			field2386[var4] = field2435[var5];
			field2438[var4++] = this.field2391[var1];
		} else {
			var11 = field2403[var5];
			var12 = field2426[var5];
			var13 = this.field2391[var1];
			if (var10 >= 50) {
				var14 = (50 - var8) * field2399[var10 - var8];
				field2436[var4] = var2 + (var11 + ((field2403[var7] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var7] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2393[var1] - var13) * var14 >> 16);
			}

			if (var9 >= 50) {
				var14 = (50 - var8) * field2399[var9 - var8];
				field2436[var4] = var2 + (var11 + ((field2403[var6] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var6] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2392[var1] - var13) * var14 >> 16);
			}
		}

		if (var9 >= 50) {
			field2436[var4] = field2422[var6];
			field2386[var4] = field2435[var6];
			field2438[var4++] = this.field2392[var1];
		} else {
			var11 = field2403[var6];
			var12 = field2426[var6];
			var13 = this.field2392[var1];
			if (var8 >= 50) {
				var14 = (50 - var9) * field2399[var8 - var9];
				field2436[var4] = var2 + (var11 + ((field2403[var5] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var5] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2391[var1] - var13) * var14 >> 16);
			}

			if (var10 >= 50) {
				var14 = (50 - var9) * field2399[var10 - var9];
				field2436[var4] = var2 + (var11 + ((field2403[var7] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var7] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2393[var1] - var13) * var14 >> 16);
			}
		}

		if (var10 >= 50) {
			field2436[var4] = field2422[var7];
			field2386[var4] = field2435[var7];
			field2438[var4++] = this.field2393[var1];
		} else {
			var11 = field2403[var7];
			var12 = field2426[var7];
			var13 = this.field2393[var1];
			if (var9 >= 50) {
				var14 = (50 - var10) * field2399[var9 - var10];
				field2436[var4] = var2 + (var11 + ((field2403[var6] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var6] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2392[var1] - var13) * var14 >> 16);
			}

			if (var8 >= 50) {
				var14 = (50 - var10) * field2399[var8 - var10];
				field2436[var4] = var2 + (var11 + ((field2403[var5] - var11) * var14 >> 16)) * class221.field2630 / 50;
				field2386[var4] = var3 + (var12 + ((field2426[var5] - var12) * var14 >> 16)) * class221.field2630 / 50;
				field2438[var4++] = var13 + ((this.field2391[var1] - var13) * var14 >> 16);
			}
		}

		var11 = field2436[0];
		var12 = field2436[1];
		var13 = field2436[2];
		var14 = field2386[0];
		int var15 = field2386[1];
		int var16 = field2386[2];
		class221.field2628 = false;
		if (var4 == 3) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > class221.field2633 || var12 > class221.field2633 || var13 > class221.field2633) {
				class221.field2628 = true;
			}

			this.method4031(var1, var14, var15, var16, var11, var12, var13, field2438[0], field2438[1], field2438[2]);
		}

		if (var4 == 4) {
			if (var11 < 0 || var12 < 0 || var13 < 0 || var11 > class221.field2633 || var12 > class221.field2633 || var13 > class221.field2633 || field2436[3] < 0 || field2436[3] > class221.field2633) {
				class221.field2628 = true;
			}

			int var18;
			if (this.field2397 != null && this.field2397[var1] != -1) {
				int var19;
				int var21;
				if (this.field2396 != null && this.field2396[var1] != -1) {
					int var20 = this.field2396[var1] & 255;
					var21 = this.field2434[var20];
					var18 = this.field2401[var20];
					var19 = this.field2402[var20];
				} else {
					var21 = var5;
					var18 = var6;
					var19 = var7;
				}

				short var22 = this.field2397[var1];
				if (this.field2393[var1] == -1) {
					class221.method4405(var14, var15, var16, var11, var12, var13, this.field2391[var1], this.field2391[var1], this.field2391[var1], field2403[var21], field2403[var18], field2403[var19], field2426[var21], field2426[var18], field2426[var19], field2427[var21], field2427[var18], field2427[var19], var22);
					class221.method4405(var14, var16, field2386[3], var11, var13, field2436[3], this.field2391[var1], this.field2391[var1], this.field2391[var1], field2403[var21], field2403[var18], field2403[var19], field2426[var21], field2426[var18], field2426[var19], field2427[var21], field2427[var18], field2427[var19], var22);
				} else {
					class221.method4405(var14, var15, var16, var11, var12, var13, field2438[0], field2438[1], field2438[2], field2403[var21], field2403[var18], field2403[var19], field2426[var21], field2426[var18], field2426[var19], field2427[var21], field2427[var18], field2427[var19], var22);
					class221.method4405(var14, var16, field2386[3], var11, var13, field2436[3], field2438[0], field2438[2], field2438[3], field2403[var21], field2403[var18], field2403[var19], field2426[var21], field2426[var18], field2426[var19], field2427[var21], field2427[var18], field2427[var19], var22);
				}
			} else {
				boolean var17 = this.method4014(var1);
				if (this.field2393[var1] == -1 && var17) {
					var18 = field2451[this.field2391[var1]];
					class221.method4403(var14, var15, var16, var11, var12, var13, var18, this.field2440, this.field2417, this.field2453, this.field2454);
					class221.method4403(var14, var16, field2386[3], var11, var13, field2436[3], var18, this.field2440, this.field2417, this.field2453, this.field2454);
				} else if (this.field2393[var1] == -1) {
					var18 = field2451[this.field2391[var1]];
					class221.method4460(var14, var15, var16, var11, var12, var13, var18);
					class221.method4460(var14, var16, field2386[3], var11, var13, field2436[3], var18);
				} else if (var17) {
					class221.method4399(var14, var15, var16, var11, var12, var13, field2438[0], field2438[1], field2438[2], this.field2440, this.field2453, this.field2417, this.field2454);
					class221.method4399(var14, var16, field2386[3], var11, var13, field2436[3], field2438[0], field2438[2], field2438[3], this.field2440, this.field2453, this.field2417, this.field2454);
				} else {
					class221.method4398(var14, var15, var16, var11, var12, var13, field2438[0], field2438[1], field2438[2]);
					class221.method4398(var14, var16, field2386[3], var11, var13, field2436[3], field2438[0], field2438[2], field2438[3]);
				}
			}
		}

	}

	void method4001(int var1, class412 var2) {
		float var3 = (float)this.field2384[var1];
		float var4 = (float)(-this.field2378[var1]);
		float var5 = (float)(-this.field2385[var1]);
		float var6 = 1.0F;
		this.field2384[var1] = (int)(var2.field4563[0] * var3 + var2.field4563[4] * var4 + var2.field4563[8] * var5 + var2.field4563[12] * var6);
		this.field2378[var1] = -((int)(var2.field4563[1] * var3 + var2.field4563[5] * var4 + var2.field4563[9] * var5 + var2.field4563[13] * var6));
		this.field2385[var1] = -((int)(var2.field4563[2] * var3 + var2.field4563[6] * var4 + var2.field4563[10] * var5 + var2.field4563[14] * var6));
	}

	void method4018(class216 var1, int var2) {
		if (this.field2412 != null) {
			for (int var3 = 0; var3 < this.field2383; ++var3) {
				int[] var4 = this.field2412[var3];
				if (var4 != null && var4.length != 0) {
					int[] var5 = this.field2406[var3];
					field2380.method7421();

					for (int var6 = 0; var6 < var4.length; ++var6) {
						int var7 = var4[var6];
						class113 var8 = var1.method4344(var7);
						if (var8 != null) {
							field2381.method7454((float)var5[var6] / 255.0F);
							field2382.method7422(var8.method2179(var2));
							field2382.method7426(field2381);
							field2380.method7447(field2382);
						}
					}

					this.method4001(var3, field2380);
				}
			}

		}
	}
}
