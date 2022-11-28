public class Scene {
	public static boolean field2559;
	public static int selectedSceneX;
	public static int selectedSceneY;
	static boolean field2525;
	static boolean field2531;
	static boolean[][] field2554;
	static boolean[][][][] field2553;
	static class219[] field2538;
	static class219[][] field2535;
	static class227[] field2524;
	static NodeDeque field2546;
	static int field2494;
	static int field2495;
	static int field2499;
	static int field2502;
	static int field2507;
	static int field2509;
	static int field2510;
	static int field2511;
	static int field2512;
	static int field2513;
	static int field2514;
	static int field2516;
	static int field2520;
	static int field2521;
	static int field2522;
	static int field2523;
	static int field2526;
	static int field2527;
	static int field2528;
	static int field2533;
	static int field2536;
	static int field2537;
	static int field2541;
	static int field2555;
	static int field2556;
	static int field2557;
	static int field2560;
	static int[] field2532;
	static final int[] field2539;
	static final int[] field2540;
	static final int[] field2542;
	static final int[] field2543;
	static final int[] field2544;
	static final int[] field2545;
	static final int[] field2547;
	class224[][][] field2529;
	class227[] field2515;
	int field2496;
	int field2497;
	int field2501;
	int field2517;
	int field2534;
	int[][] field2551;
	int[][] field2552;
	int[][][] field2498;
	int[][][] field2503;

	static {
		field2559 = true;
		field2502 = 0;
		field2509 = 0;
		field2524 = new class227[100];
		field2525 = false;
		field2526 = 0;
		field2527 = 0;
		field2528 = 0;
		selectedSceneX = -1;
		selectedSceneY = -1;
		field2531 = false;
		field2536 = 4;
		field2532 = new int[field2536];
		field2535 = new class219[field2536][500];
		field2537 = 0;
		field2538 = new class219[500];
		field2546 = new NodeDeque();
		field2540 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
		field2547 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
		field2542 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
		field2543 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
		field2544 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
		field2545 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
		field2539 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
		field2553 = new boolean[8][32][51][51];
	}

	public Scene(int var1, int var2, int var3, int[][][] var4) {
		this.field2534 = 0;
		this.field2501 = 0;
		this.field2515 = new class227[5000];
		this.field2551 = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
		this.field2552 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
		this.field2517 = var1;
		this.field2496 = var2;
		this.field2497 = var3;
		this.field2529 = new class224[var1][var2][var3];
		this.field2503 = new int[var1][var2 + 1][var3 + 1];
		this.field2498 = var4;
		this.method4122();
	}

	public void method4122() {
		int var1;
		int var2;
		for (var1 = 0; var1 < this.field2517; ++var1) {
			for (var2 = 0; var2 < this.field2496; ++var2) {
				for (int var3 = 0; var3 < this.field2497; ++var3) {
					this.field2529[var1][var2][var3] = null;
				}
			}
		}

		for (var1 = 0; var1 < field2536; ++var1) {
			for (var2 = 0; var2 < field2532[var1]; ++var2) {
				field2535[var1][var2] = null;
			}

			field2532[var1] = 0;
		}

		for (var1 = 0; var1 < this.field2501; ++var1) {
			this.field2515[var1] = null;
		}

		this.field2501 = 0;

		for (var1 = 0; var1 < field2524.length; ++var1) {
			field2524[var1] = null;
		}

	}

	public void method4123(int var1) {
		this.field2534 = var1;

		for (int var2 = 0; var2 < this.field2496; ++var2) {
			for (int var3 = 0; var3 < this.field2497; ++var3) {
				if (this.field2529[var1][var2][var3] == null) {
					this.field2529[var1][var2][var3] = new class224(var1, var2, var3);
				}
			}
		}

	}

	public void method4124(int var1, int var2) {
		class224 var3 = this.field2529[0][var1][var2];

		for (int var4 = 0; var4 < 3; ++var4) {
			class224 var5 = this.field2529[var4][var1][var2] = this.field2529[var4 + 1][var1][var2];
			if (var5 != null) {
				--var5.field2680;

				for (int var6 = 0; var6 < var5.field2670; ++var6) {
					class227 var7 = var5.field2671[var6];
					long var9 = var7.field2719;
					int var11 = (int)(var9 >>> 14 & 3L);
					boolean var8 = var11 == 2;
					if (var8 && var7.field2713 == var1 && var7.field2715 == var2) {
						--var7.field2717;
					}
				}
			}
		}

		if (this.field2529[0][var1][var2] == null) {
			this.field2529[0][var1][var2] = new class224(0, var1, var2);
		}

		this.field2529[0][var1][var2].field2682 = var3;
		this.field2529[3][var1][var2] = null;
	}

	public static void method4210(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		class219 var8 = new class219();
		var8.field2614 = var2 / 128;
		var8.field2599 = var3 / 128;
		var8.field2600 = var4 / 128;
		var8.field2601 = var5 / 128;
		var8.field2602 = var1;
		var8.field2603 = var2;
		var8.field2606 = var3;
		var8.field2618 = var4;
		var8.field2598 = var5;
		var8.field2609 = var6;
		var8.field2608 = var7;
		field2535[var0][field2532[var0]++] = var8;
	}

	public void method4126(int var1, int var2, int var3, int var4) {
		class224 var5 = this.field2529[var1][var2][var3];
		if (var5 != null) {
			this.field2529[var1][var2][var3].field2674 = var4;
		}
	}

	public void method4127(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
		class226 var21;
		int var22;
		if (var4 == 0) {
			var21 = new class226(var11, var12, var13, var14, -1, var19, false);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.field2529[var22][var2][var3] == null) {
					this.field2529[var22][var2][var3] = new class224(var22, var2, var3);
				}
			}

			this.field2529[var1][var2][var3].field2664 = var21;
		} else if (var4 != 1) {
			class211 var23 = new class211(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.field2529[var22][var2][var3] == null) {
					this.field2529[var22][var2][var3] = new class224(var22, var2, var3);
				}
			}

			this.field2529[var1][var2][var3].field2662 = var23;
		} else {
			var21 = new class226(var15, var16, var17, var18, var6, var20, var7 == var8 && var7 == var9 && var7 == var10);

			for (var22 = var1; var22 >= 0; --var22) {
				if (this.field2529[var22][var2][var3] == null) {
					this.field2529[var22][var2][var3] = new class224(var22, var2, var3);
				}
			}

			this.field2529[var1][var2][var3].field2664 = var21;
		}
	}

	public void method4128(int var1, int var2, int var3, int var4, class212 var5, long var6, int var8) {
		if (var5 != null) {
			class196 var9 = new class196();
			var9.field2108 = var5;
			var9.field2106 = var2 * 128 + 64;
			var9.field2111 = var3 * 128 + 64;
			var9.field2107 = var4;
			var9.field2109 = var6;
			var9.field2110 = var8;
			if (this.field2529[var1][var2][var3] == null) {
				this.field2529[var1][var2][var3] = new class224(var1, var2, var3);
			}

			this.field2529[var1][var2][var3].field2668 = var9;
		}
	}

	public void method4129(int var1, int var2, int var3, int var4, class212 var5, long var6, class212 var8, class212 var9) {
		class208 var10 = new class208();
		var10.field2371 = var5;
		var10.field2372 = var2 * 128 + 64;
		var10.field2370 = var3 * 128 + 64;
		var10.field2373 = var4;
		var10.field2374 = var6;
		var10.field2369 = var8;
		var10.field2368 = var9;
		int var11 = 0;
		class224 var12 = this.field2529[var1][var2][var3];
		if (var12 != null) {
			for (int var13 = 0; var13 < var12.field2670; ++var13) {
				if ((var12.field2671[var13].field2720 & 256) == 256 && var12.field2671[var13].field2711 instanceof class209) {
					class209 var14 = (class209)var12.field2671[var13].field2711;
					var14.method4067();
					if (var14.field2489 > var11) {
						var11 = var14.field2489;
					}
				}
			}
		}

		var10.field2375 = var11;
		if (this.field2529[var1][var2][var3] == null) {
			this.field2529[var1][var2][var3] = new class224(var1, var2, var3);
		}

		this.field2529[var1][var2][var3].field2669 = var10;
	}

	public void method4228(int var1, int var2, int var3, int var4, class212 var5, class212 var6, int var7, int var8, long var9, int var11) {
		if (var5 != null || var6 != null) {
			class229 var12 = new class229();
			var12.field2735 = var9;
			var12.field2736 = var11;
			var12.field2729 = var2 * 128 + 64;
			var12.field2730 = var3 * 128 + 64;
			var12.field2737 = var4;
			var12.field2728 = var5;
			var12.field2734 = var6;
			var12.field2733 = var7;
			var12.field2732 = var8;

			for (int var13 = var1; var13 >= 0; --var13) {
				if (this.field2529[var13][var2][var3] == null) {
					this.field2529[var13][var2][var3] = new class224(var13, var2, var3);
				}
			}

			this.field2529[var1][var2][var3].field2663 = var12;
		}
	}

	public void method4141(int var1, int var2, int var3, int var4, class212 var5, class212 var6, int var7, int var8, int var9, int var10, long var11, int var13) {
		if (var5 != null) {
			class217 var14 = new class217();
			var14.field2584 = var11;
			var14.field2583 = var13;
			var14.field2579 = var2 * 128 + 64;
			var14.field2578 = var3 * 128 + 64;
			var14.field2575 = var4;
			var14.field2582 = var5;
			var14.field2585 = var6;
			var14.field2576 = var7;
			var14.field2577 = var8;
			var14.field2580 = var9;
			var14.field2581 = var10;

			for (int var15 = var1; var15 >= 0; --var15) {
				if (this.field2529[var15][var2][var3] == null) {
					this.field2529[var15][var2][var3] = new class224(var15, var2, var3);
				}
			}

			this.field2529[var1][var2][var3].field2667 = var14;
		}
	}

	public boolean method4166(int var1, int var2, int var3, int var4, int var5, int var6, class212 var7, int var8, long var9, int var11) {
		if (var7 == null) {
			return true;
		} else {
			int var12 = var2 * 128 + var5 * 64;
			int var13 = var3 * 128 + var6 * 64;
			return this.method4135(var1, var2, var3, var5, var6, var12, var13, var4, var7, var8, false, var9, var11);
		}
	}

	public boolean method4133(int var1, int var2, int var3, int var4, int var5, class212 var6, int var7, long var8, boolean var10) {
		if (var6 == null) {
			return true;
		} else {
			int var11 = var2 - var5;
			int var12 = var3 - var5;
			int var13 = var2 + var5;
			int var14 = var3 + var5;
			if (var10) {
				if (var7 > 640 && var7 < 1408) {
					var14 += 128;
				}

				if (var7 > 1152 && var7 < 1920) {
					var13 += 128;
				}

				if (var7 > 1664 || var7 < 384) {
					var12 -= 128;
				}

				if (var7 > 128 && var7 < 896) {
					var11 -= 128;
				}
			}

			var11 /= 128;
			var12 /= 128;
			var13 /= 128;
			var14 /= 128;
			return this.method4135(var1, var11, var12, var13 - var11 + 1, var14 - var12 + 1, var2, var3, var4, var6, var7, true, var8, 0);
		}
	}

	public boolean method4134(int var1, int var2, int var3, int var4, int var5, class212 var6, int var7, long var8, int var10, int var11, int var12, int var13) {
		return var6 == null ? true : this.method4135(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
	}

	boolean method4135(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class212 var9, int var10, boolean var11, long var12, int var14) {
		int var16;
		for (int var15 = var2; var15 < var2 + var4; ++var15) {
			for (var16 = var3; var16 < var3 + var5; ++var16) {
				if (var15 < 0 || var16 < 0 || var15 >= this.field2496 || var16 >= this.field2497) {
					return false;
				}

				class224 var17 = this.field2529[var1][var15][var16];
				if (var17 != null && var17.field2670 >= 5) {
					return false;
				}
			}
		}

		class227 var21 = new class227();
		var21.field2719 = var12;
		var21.field2720 = var14;
		var21.field2717 = var1;
		var21.field2707 = var6;
		var21.field2710 = var7;
		var21.field2709 = var8;
		var21.field2711 = var9;
		var21.field2712 = var10;
		var21.field2713 = var2;
		var21.field2715 = var3;
		var21.field2716 = var2 + var4 - 1;
		var21.field2708 = var3 + var5 - 1;

		for (var16 = var2; var16 < var2 + var4; ++var16) {
			for (int var22 = var3; var22 < var3 + var5; ++var22) {
				int var18 = 0;
				if (var16 > var2) {
					++var18;
				}

				if (var16 < var2 + var4 - 1) {
					var18 += 4;
				}

				if (var22 > var3) {
					var18 += 8;
				}

				if (var22 < var3 + var5 - 1) {
					var18 += 2;
				}

				for (int var19 = var1; var19 >= 0; --var19) {
					if (this.field2529[var19][var16][var22] == null) {
						this.field2529[var19][var16][var22] = new class224(var19, var16, var22);
					}
				}

				class224 var23 = this.field2529[var1][var16][var22];
				var23.field2671[var23.field2670] = var21;
				var23.field2672[var23.field2670] = var18;
				var23.field2681 |= var18;
				++var23.field2670;
			}
		}

		if (var11) {
			this.field2515[this.field2501++] = var21;
		}

		return true;
	}

	public void method4136() {
		for (int var1 = 0; var1 < this.field2501; ++var1) {
			class227 var2 = this.field2515[var1];
			this.method4137(var2);
			this.field2515[var1] = null;
		}

		this.field2501 = 0;
	}

	void method4137(class227 var1) {
		for (int var2 = var1.field2713; var2 <= var1.field2716; ++var2) {
			for (int var3 = var1.field2715; var3 <= var1.field2708; ++var3) {
				class224 var4 = this.field2529[var1.field2717][var2][var3];
				if (var4 != null) {
					int var5;
					for (var5 = 0; var5 < var4.field2670; ++var5) {
						if (var4.field2671[var5] == var1) {
							--var4.field2670;

							for (int var6 = var5; var6 < var4.field2670; ++var6) {
								var4.field2671[var6] = var4.field2671[var6 + 1];
								var4.field2672[var6] = var4.field2672[var6 + 1];
							}

							var4.field2671[var4.field2670] = null;
							break;
						}
					}

					var4.field2681 = 0;

					for (var5 = 0; var5 < var4.field2670; ++var5) {
						var4.field2681 |= var4.field2672[var5];
					}
				}
			}
		}

	}

	public void method4138(int var1, int var2, int var3, int var4) {
		class224 var5 = this.field2529[var1][var2][var3];
		if (var5 != null) {
			class217 var6 = var5.field2667;
			if (var6 != null) {
				var6.field2580 = var6.field2580 * var4 / 16;
				var6.field2581 = var6.field2581 * var4 / 16;
			}
		}
	}

	public void method4232(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 != null) {
			var4.field2663 = null;
		}
	}

	public void method4125(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 != null) {
			var4.field2667 = null;
		}
	}

	public void method4170(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 != null) {
			for (int var5 = 0; var5 < var4.field2670; ++var5) {
				class227 var6 = var4.field2671[var5];
				if (class234.method1417(var6.field2719) && var6.field2713 == var2 && var6.field2715 == var3) {
					this.method4137(var6);
					return;
				}
			}

		}
	}

	public void method4142(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 != null) {
			var4.field2668 = null;
		}
	}

	public void method4143(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 != null) {
			var4.field2669 = null;
		}
	}

	public class229 method4144(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 == null ? null : var4.field2663;
	}

	public class217 method4145(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 == null ? null : var4.field2667;
	}

	public class227 method4276(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 == null) {
			return null;
		} else {
			for (int var5 = 0; var5 < var4.field2670; ++var5) {
				class227 var6 = var4.field2671[var5];
				if (class234.method1417(var6.field2719) && var6.field2713 == var2 && var6.field2715 == var3) {
					return var6;
				}
			}

			return null;
		}
	}

	public class196 method4147(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 != null && var4.field2668 != null ? var4.field2668 : null;
	}

	public long method4185(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 != null && var4.field2663 != null ? var4.field2663.field2735 : 0L;
	}

	public long method4149(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 != null && var4.field2667 != null ? var4.field2667.field2584 : 0L;
	}

	public long method4150(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		if (var4 == null) {
			return 0L;
		} else {
			for (int var5 = 0; var5 < var4.field2670; ++var5) {
				class227 var6 = var4.field2671[var5];
				if (class234.method1417(var6.field2719) && var6.field2713 == var2 && var6.field2715 == var3) {
					return var6.field2719;
				}
			}

			return 0L;
		}
	}

	public long method4151(int var1, int var2, int var3) {
		class224 var4 = this.field2529[var1][var2][var3];
		return var4 != null && var4.field2668 != null ? var4.field2668.field2109 : 0L;
	}

	public int method4156(int var1, int var2, int var3, long var4) {
		class224 var6 = this.field2529[var1][var2][var3];
		if (var6 == null) {
			return -1;
		} else if (var6.field2663 != null && var6.field2663.field2735 == var4) {
			return var6.field2663.field2736 & 255;
		} else if (var6.field2667 != null && var6.field2667.field2584 == var4) {
			return var6.field2667.field2583 & 255;
		} else if (var6.field2668 != null && var6.field2668.field2109 == var4) {
			return var6.field2668.field2110 & 255;
		} else {
			for (int var7 = 0; var7 < var6.field2670; ++var7) {
				if (var6.field2671[var7].field2719 == var4) {
					return var6.field2671[var7].field2720 & 255;
				}
			}

			return -1;
		}
	}

	public void method4153(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.field2517; ++var4) {
			for (int var5 = 0; var5 < this.field2496; ++var5) {
				for (int var6 = 0; var6 < this.field2497; ++var6) {
					class224 var7 = this.field2529[var4][var5][var6];
					if (var7 != null) {
						class229 var8 = var7.field2663;
						class201 var10;
						if (var8 != null && var8.field2728 instanceof class201) {
							class201 var9 = (class201)var8.field2728;
							this.method4285(var9, var4, var5, var6, 1, 1);
							if (var8.field2734 instanceof class201) {
								var10 = (class201)var8.field2734;
								this.method4285(var10, var4, var5, var6, 1, 1);
								class201.method3795(var9, var10, 0, 0, 0, false);
								var8.field2734 = var10.method3796(var10.field2239, var10.field2240, var1, var2, var3);
							}

							var8.field2728 = var9.method3796(var9.field2239, var9.field2240, var1, var2, var3);
						}

						for (int var12 = 0; var12 < var7.field2670; ++var12) {
							class227 var14 = var7.field2671[var12];
							if (var14 != null && var14.field2711 instanceof class201) {
								class201 var11 = (class201)var14.field2711;
								this.method4285(var11, var4, var5, var6, var14.field2716 - var14.field2713 + 1, var14.field2708 - var14.field2715 + 1);
								var14.field2711 = var11.method3796(var11.field2239, var11.field2240, var1, var2, var3);
							}
						}

						class196 var13 = var7.field2668;
						if (var13 != null && var13.field2108 instanceof class201) {
							var10 = (class201)var13.field2108;
							this.method4249(var10, var4, var5, var6);
							var13.field2108 = var10.method3796(var10.field2239, var10.field2240, var1, var2, var3);
						}
					}
				}
			}
		}

	}

	void method4249(class201 var1, int var2, int var3, int var4) {
		class224 var5;
		class201 var6;
		if (var3 < this.field2496) {
			var5 = this.field2529[var2][var3 + 1][var4];
			if (var5 != null && var5.field2668 != null && var5.field2668.field2108 instanceof class201) {
				var6 = (class201)var5.field2668.field2108;
				class201.method3795(var1, var6, 128, 0, 0, true);
			}
		}

		if (var4 < this.field2496) {
			var5 = this.field2529[var2][var3][var4 + 1];
			if (var5 != null && var5.field2668 != null && var5.field2668.field2108 instanceof class201) {
				var6 = (class201)var5.field2668.field2108;
				class201.method3795(var1, var6, 0, 0, 128, true);
			}
		}

		if (var3 < this.field2496 && var4 < this.field2497) {
			var5 = this.field2529[var2][var3 + 1][var4 + 1];
			if (var5 != null && var5.field2668 != null && var5.field2668.field2108 instanceof class201) {
				var6 = (class201)var5.field2668.field2108;
				class201.method3795(var1, var6, 128, 0, 128, true);
			}
		}

		if (var3 < this.field2496 && var4 > 0) {
			var5 = this.field2529[var2][var3 + 1][var4 - 1];
			if (var5 != null && var5.field2668 != null && var5.field2668.field2108 instanceof class201) {
				var6 = (class201)var5.field2668.field2108;
				class201.method3795(var1, var6, 128, 0, -128, true);
			}
		}

	}

	void method4285(class201 var1, int var2, int var3, int var4, int var5, int var6) {
		boolean var7 = true;
		int var8 = var3;
		int var9 = var3 + var5;
		int var10 = var4 - 1;
		int var11 = var4 + var6;

		for (int var12 = var2; var12 <= var2 + 1; ++var12) {
			if (var12 != this.field2517) {
				for (int var13 = var8; var13 <= var9; ++var13) {
					if (var13 >= 0 && var13 < this.field2496) {
						for (int var14 = var10; var14 <= var11; ++var14) {
							if (var14 >= 0 && var14 < this.field2497 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var13 != var3)) {
								class224 var15 = this.field2529[var12][var13][var14];
								if (var15 != null) {
									int var16 = (this.field2498[var12][var13][var14] + this.field2498[var12][var13 + 1][var14] + this.field2498[var12][var13][var14 + 1] + this.field2498[var12][var13 + 1][var14 + 1]) / 4 - (this.field2498[var2][var3][var4] + this.field2498[var2][var3 + 1][var4] + this.field2498[var2][var3][var4 + 1] + this.field2498[var2][var3 + 1][var4 + 1]) / 4;
									class229 var17 = var15.field2663;
									if (var17 != null) {
										class201 var18;
										if (var17.field2728 instanceof class201) {
											var18 = (class201)var17.field2728;
											class201.method3795(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
										}

										if (var17.field2734 instanceof class201) {
											var18 = (class201)var17.field2734;
											class201.method3795(var1, var18, (var13 - var3) * 128 + (1 - var5) * 64, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
										}
									}

									for (int var23 = 0; var23 < var15.field2670; ++var23) {
										class227 var19 = var15.field2671[var23];
										if (var19 != null && var19.field2711 instanceof class201) {
											class201 var20 = (class201)var19.field2711;
											int var21 = var19.field2716 - var19.field2713 + 1;
											int var22 = var19.field2708 - var19.field2715 + 1;
											class201.method3795(var1, var20, (var19.field2713 - var3) * 128 + (var21 - var5) * 64, var16, (var19.field2715 - var4) * 128 + (var22 - var6) * 64, var7);
										}
									}
								}
							}
						}
					}
				}

				--var8;
				var7 = false;
			}
		}

	}

	public void method4248(int[] var1, int var2, int var3, int var4, int var5, int var6) {
		class224 var7 = this.field2529[var4][var5][var6];
		if (var7 != null) {
			class226 var8 = var7.field2664;
			int var10;
			if (var8 != null) {
				int var9 = var8.field2699;
				if (var9 != 0) {
					for (var10 = 0; var10 < 4; ++var10) {
						var1[var2] = var9;
						var1[var2 + 1] = var9;
						var1[var2 + 2] = var9;
						var1[var2 + 3] = var9;
						var2 += var3;
					}

				}
			} else {
				class211 var18 = var7.field2662;
				if (var18 != null) {
					var10 = var18.field2472;
					int var11 = var18.field2478;
					int var12 = var18.field2479;
					int var13 = var18.field2480;
					int[] var14 = this.field2551[var10];
					int[] var15 = this.field2552[var11];
					int var16 = 0;
					int var17;
					if (var12 != 0) {
						for (var17 = 0; var17 < 4; ++var17) {
							var1[var2] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 1] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 2] = var14[var15[var16++]] == 0 ? var12 : var13;
							var1[var2 + 3] = var14[var15[var16++]] == 0 ? var12 : var13;
							var2 += var3;
						}
					} else {
						for (var17 = 0; var17 < 4; ++var17) {
							if (var14[var15[var16++]] != 0) {
								var1[var2] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 1] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 2] = var13;
							}

							if (var14[var15[var16++]] != 0) {
								var1[var2 + 3] = var13;
							}

							var2 += var3;
						}
					}

				}
			}
		}
	}

	public static void method4157(int[] var0, int var1, int var2, int var3, int var4) {
		field2557 = 0;
		field2541 = 0;
		field2507 = var3;
		field2560 = var4;
		field2520 = var3 / 2;
		field2495 = var4 / 2;
		boolean[][][][] var5 = new boolean[var0.length][32][53][53];

		int var6;
		int var7;
		int var8;
		int var9;
		int var11;
		int var12;
		for (var6 = 128; var6 <= 383; var6 += 32) {
			for (var7 = 0; var7 < 2048; var7 += 64) {
				field2556 = class221.field2644[var6];
				field2521 = class221.field2645[var6];
				field2522 = class221.field2644[var7];
				field2523 = class221.field2645[var7];
				var8 = (var6 - 128) / 32;
				var9 = var7 / 64;

				for (int var10 = -26; var10 < 26; ++var10) {
					for (var11 = -26; var11 < 26; ++var11) {
						var12 = var10 * 128;
						int var13 = var11 * 128;
						boolean var14 = false;

						for (int var15 = -var1; var15 <= var2; var15 += 128) {
							if (method4158(var12, var0[var8] + var15, var13)) {
								var14 = true;
								break;
							}
						}

						var5[var8][var9][var10 + 25 + 1][var11 + 25 + 1] = var14;
					}
				}
			}
		}

		for (var6 = 0; var6 < 8; ++var6) {
			for (var7 = 0; var7 < 32; ++var7) {
				for (var8 = -25; var8 < 25; ++var8) {
					for (var9 = -25; var9 < 25; ++var9) {
						boolean var16 = false;

						label76:
						for (var11 = -1; var11 <= 1; ++var11) {
							for (var12 = -1; var12 <= 1; ++var12) {
								if (var5[var6][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
									var16 = true;
									break label76;
								}

								if (var5[var6][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
									var16 = true;
									break label76;
								}

								if (var5[var6 + 1][var7][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
									var16 = true;
									break label76;
								}

								if (var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 25 + 1][var9 + var12 + 25 + 1]) {
									var16 = true;
									break label76;
								}
							}
						}

						field2553[var6][var7][var8 + 25][var9 + 25] = var16;
					}
				}
			}
		}

	}

	static boolean method4158(int var0, int var1, int var2) {
		int var3 = var2 * field2522 + var0 * field2523 >> 16;
		int var4 = var2 * field2523 - var0 * field2522 >> 16;
		int var5 = var1 * field2556 + var4 * field2521 >> 16;
		int var6 = var1 * field2521 - var4 * field2556 >> 16;
		if (var5 >= 50 && var5 <= 3500) {
			int var7 = field2520 + var3 * 128 / var5;
			int var8 = field2495 + var6 * 128 / var5;
			return var7 >= field2557 && var7 <= field2507 && var8 >= field2541 && var8 <= field2560;
		} else {
			return false;
		}
	}

	public void method4159(int var1, int var2, int var3, boolean var4) {
		if (!shouldSendMove() || var4) {
			field2525 = true;
			field2531 = var4;
			field2526 = var1;
			field2527 = var2;
			field2528 = var3;
			selectedSceneX = -1;
			selectedSceneY = -1;
		}
	}

	public void method4160() {
		field2531 = true;
	}

	public static boolean shouldSendMove() {
		return field2531 && selectedSceneX != -1;
	}

	public static void method4162() {
		selectedSceneX = -1;
		field2531 = false;
	}

	public void method4297(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 < 0) {
			var1 = 0;
		} else if (var1 >= this.field2496 * 128) {
			var1 = this.field2496 * 128 - 1;
		}

		if (var3 < 0) {
			var3 = 0;
		} else if (var3 >= this.field2497 * 128) {
			var3 = this.field2497 * 128 - 1;
		}

		if (var4 < 128) {
			var4 = 128;
		} else if (var4 > 383) {
			var4 = 383;
		}

		++field2499;
		field2556 = class221.field2644[var4];
		field2521 = class221.field2645[var4];
		field2522 = class221.field2644[var5];
		field2523 = class221.field2645[var5];
		field2554 = field2553[(var4 - 128) / 32][var5 / 64];
		field2510 = var1;
		field2494 = var2;
		field2533 = var3;
		field2513 = var1 / 128;
		field2516 = var3 / 128;
		field2509 = var6;
		field2511 = field2513 - 25;
		if (field2511 < 0) {
			field2511 = 0;
		}

		field2555 = field2516 - 25;
		if (field2555 < 0) {
			field2555 = 0;
		}

		field2512 = field2513 + 25;
		if (field2512 > this.field2496) {
			field2512 = this.field2496;
		}

		field2514 = field2516 + 25;
		if (field2514 > this.field2497) {
			field2514 = this.field2497;
		}

		this.method4204();
		field2502 = 0;

		int var7;
		class224[][] var8;
		int var9;
		int var10;
		for (var7 = this.field2534; var7 < this.field2517; ++var7) {
			var8 = this.field2529[var7];

			for (var9 = field2511; var9 < field2512; ++var9) {
				for (var10 = field2555; var10 < field2514; ++var10) {
					class224 var11 = var8[var9][var10];
					if (var11 != null) {
						if (var11.field2674 > var6 || !field2554[var9 - field2513 + 25][var10 - field2516 + 25] && this.field2498[var7][var9][var10] - var2 < 2000) {
							var11.field2675 = false;
							var11.field2676 = false;
							var11.field2678 = 0;
						} else {
							var11.field2675 = true;
							var11.field2676 = true;
							if (var11.field2670 > 0) {
								var11.field2660 = true;
							} else {
								var11.field2660 = false;
							}

							++field2502;
						}
					}
				}
			}
		}

		int var12;
		int var13;
		int var14;
		class224 var15;
		int var16;
		for (var7 = this.field2534; var7 < this.field2517; ++var7) {
			var8 = this.field2529[var7];

			for (var9 = -25; var9 <= 0; ++var9) {
				var10 = field2513 + var9;
				var16 = field2513 - var9;
				if (var10 >= field2511 || var16 < field2512) {
					for (var12 = -25; var12 <= 0; ++var12) {
						var13 = field2516 + var12;
						var14 = field2516 - var12;
						if (var10 >= field2511) {
							if (var13 >= field2555) {
								var15 = var8[var10][var13];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, true);
								}
							}

							if (var14 < field2514) {
								var15 = var8[var10][var14];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, true);
								}
							}
						}

						if (var16 < field2512) {
							if (var13 >= field2555) {
								var15 = var8[var16][var13];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, true);
								}
							}

							if (var14 < field2514) {
								var15 = var8[var16][var14];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, true);
								}
							}
						}

						if (field2502 == 0) {
							field2525 = false;
							return;
						}
					}
				}
			}
		}

		for (var7 = this.field2534; var7 < this.field2517; ++var7) {
			var8 = this.field2529[var7];

			for (var9 = -25; var9 <= 0; ++var9) {
				var10 = field2513 + var9;
				var16 = field2513 - var9;
				if (var10 >= field2511 || var16 < field2512) {
					for (var12 = -25; var12 <= 0; ++var12) {
						var13 = field2516 + var12;
						var14 = field2516 - var12;
						if (var10 >= field2511) {
							if (var13 >= field2555) {
								var15 = var8[var10][var13];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, false);
								}
							}

							if (var14 < field2514) {
								var15 = var8[var10][var14];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, false);
								}
							}
						}

						if (var16 < field2512) {
							if (var13 >= field2555) {
								var15 = var8[var16][var13];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, false);
								}
							}

							if (var14 < field2514) {
								var15 = var8[var16][var14];
								if (var15 != null && var15.field2675) {
									this.method4132(var15, false);
								}
							}
						}

						if (field2502 == 0) {
							field2525 = false;
							return;
						}
					}
				}
			}
		}

		field2525 = false;
	}

	void method4132(class224 var1, boolean var2) {
		field2546.method6355(var1);

		while (true) {
			class224 var3;
			int var4;
			int var5;
			int var6;
			int var7;
			class224[][] var8;
			class224 var9;
			int var11;
			int var14;
			int var15;
			int var16;
			int var24;
			int var25;
			do {
				do {
					do {
						do {
							do {
								do {
									while (true) {
										class229 var10;
										class227 var12;
										int var17;
										int var18;
										boolean var20;
										int var21;
										class224 var36;
										while (true) {
											do {
												var3 = (class224)field2546.method6375();
												if (var3 == null) {
													return;
												}
											} while(!var3.field2676);

											var4 = var3.field2661;
											var5 = var3.field2677;
											var6 = var3.field2680;
											var7 = var3.field2666;
											var8 = this.field2529[var6];
											if (!var3.field2675) {
												break;
											}

											if (var2) {
												if (var6 > 0) {
													var9 = this.field2529[var6 - 1][var4][var5];
													if (var9 != null && var9.field2676) {
														continue;
													}
												}

												if (var4 <= field2513 && var4 > field2511) {
													var9 = var8[var4 - 1][var5];
													if (var9 != null && var9.field2676 && (var9.field2675 || (var3.field2681 & 1) == 0)) {
														continue;
													}
												}

												if (var4 >= field2513 && var4 < field2512 - 1) {
													var9 = var8[var4 + 1][var5];
													if (var9 != null && var9.field2676 && (var9.field2675 || (var3.field2681 & 4) == 0)) {
														continue;
													}
												}

												if (var5 <= field2516 && var5 > field2555) {
													var9 = var8[var4][var5 - 1];
													if (var9 != null && var9.field2676 && (var9.field2675 || (var3.field2681 & 8) == 0)) {
														continue;
													}
												}

												if (var5 >= field2516 && var5 < field2514 - 1) {
													var9 = var8[var4][var5 + 1];
													if (var9 != null && var9.field2676 && (var9.field2675 || (var3.field2681 & 2) == 0)) {
														continue;
													}
												}
											} else {
												var2 = true;
											}

											var3.field2675 = false;
											if (var3.field2682 != null) {
												var9 = var3.field2682;
												if (var9.field2664 != null) {
													if (!this.method4201(0, var4, var5)) {
														this.method4172(var9.field2664, 0, field2556, field2521, field2522, field2523, var4, var5);
													}
												} else if (var9.field2662 != null && !this.method4201(0, var4, var5)) {
													this.method4191(var9.field2662, field2556, field2521, field2522, field2523, var4, var5);
												}

												var10 = var9.field2663;
												if (var10 != null) {
													var10.field2728.method4116(0, field2556, field2521, field2522, field2523, var10.field2729 - field2510, var10.field2737 - field2494, var10.field2730 - field2533, var10.field2735);
												}

												for (var11 = 0; var11 < var9.field2670; ++var11) {
													var12 = var9.field2671[var11];
													if (var12 != null) {
														var12.field2711.method4116(var12.field2712, field2556, field2521, field2522, field2523, var12.field2707 - field2510, var12.field2709 - field2494, var12.field2710 - field2533, var12.field2719);
													}
												}
											}

											var20 = false;
											if (var3.field2664 != null) {
												if (!this.method4201(var7, var4, var5)) {
													var20 = true;
													if (var3.field2664.field2700 != 12345678 || field2525 && var6 <= field2526) {
														this.method4172(var3.field2664, var7, field2556, field2521, field2522, field2523, var4, var5);
													}
												}
											} else if (var3.field2662 != null && !this.method4201(var7, var4, var5)) {
												var20 = true;
												this.method4191(var3.field2662, field2556, field2521, field2522, field2523, var4, var5);
											}

											var21 = 0;
											var11 = 0;
											class229 var31 = var3.field2663;
											class217 var13 = var3.field2667;
											if (var31 != null || var13 != null) {
												if (field2513 == var4) {
													++var21;
												} else if (field2513 < var4) {
													var21 += 2;
												}

												if (field2516 == var5) {
													var21 += 3;
												} else if (field2516 > var5) {
													var21 += 6;
												}

												var11 = field2540[var21];
												var3.field2684 = field2542[var21];
											}

											if (var31 != null) {
												if ((var31.field2733 & field2547[var21]) != 0) {
													if (var31.field2733 == 16) {
														var3.field2678 = 3;
														var3.field2679 = field2543[var21];
														var3.field2673 = 3 - var3.field2679;
													} else if (var31.field2733 == 32) {
														var3.field2678 = 6;
														var3.field2679 = field2544[var21];
														var3.field2673 = 6 - var3.field2679;
													} else if (var31.field2733 == 64) {
														var3.field2678 = 12;
														var3.field2679 = field2545[var21];
														var3.field2673 = 12 - var3.field2679;
													} else {
														var3.field2678 = 9;
														var3.field2679 = field2539[var21];
														var3.field2673 = 9 - var3.field2679;
													}
												} else {
													var3.field2678 = 0;
												}

												if ((var31.field2733 & var11) != 0 && !this.method4295(var7, var4, var5, var31.field2733)) {
													var31.field2728.method4116(0, field2556, field2521, field2522, field2523, var31.field2729 - field2510, var31.field2737 - field2494, var31.field2730 - field2533, var31.field2735);
												}

												if ((var31.field2732 & var11) != 0 && !this.method4295(var7, var4, var5, var31.field2732)) {
													var31.field2734.method4116(0, field2556, field2521, field2522, field2523, var31.field2729 - field2510, var31.field2737 - field2494, var31.field2730 - field2533, var31.field2735);
												}
											}

											if (var13 != null && !this.method4245(var7, var4, var5, var13.field2582.field2489)) {
												if ((var13.field2576 & var11) != 0) {
													var13.field2582.method4116(0, field2556, field2521, field2522, field2523, var13.field2579 - field2510 + var13.field2580, var13.field2575 - field2494, var13.field2578 - field2533 + var13.field2581, var13.field2584);
												} else if (var13.field2576 == 256) {
													var14 = var13.field2579 - field2510;
													var15 = var13.field2575 - field2494;
													var16 = var13.field2578 - field2533;
													var17 = var13.field2577;
													if (var17 != 1 && var17 != 2) {
														var18 = var14;
													} else {
														var18 = -var14;
													}

													int var19;
													if (var17 != 2 && var17 != 3) {
														var19 = var16;
													} else {
														var19 = -var16;
													}

													if (var19 < var18) {
														var13.field2582.method4116(0, field2556, field2521, field2522, field2523, var14 + var13.field2580, var15, var16 + var13.field2581, var13.field2584);
													} else if (var13.field2585 != null) {
														var13.field2585.method4116(0, field2556, field2521, field2522, field2523, var14, var15, var16, var13.field2584);
													}
												}
											}

											if (var20) {
												class196 var22 = var3.field2668;
												if (var22 != null) {
													var22.field2108.method4116(0, field2556, field2521, field2522, field2523, var22.field2106 - field2510, var22.field2107 - field2494, var22.field2111 - field2533, var22.field2109);
												}

												class208 var23 = var3.field2669;
												if (var23 != null && var23.field2375 == 0) {
													if (var23.field2369 != null) {
														var23.field2369.method4116(0, field2556, field2521, field2522, field2523, var23.field2372 - field2510, var23.field2373 - field2494, var23.field2370 - field2533, var23.field2374);
													}

													if (var23.field2368 != null) {
														var23.field2368.method4116(0, field2556, field2521, field2522, field2523, var23.field2372 - field2510, var23.field2373 - field2494, var23.field2370 - field2533, var23.field2374);
													}

													if (var23.field2371 != null) {
														var23.field2371.method4116(0, field2556, field2521, field2522, field2523, var23.field2372 - field2510, var23.field2373 - field2494, var23.field2370 - field2533, var23.field2374);
													}
												}
											}

											var14 = var3.field2681;
											if (var14 != 0) {
												if (var4 < field2513 && (var14 & 4) != 0) {
													var36 = var8[var4 + 1][var5];
													if (var36 != null && var36.field2676) {
														field2546.method6355(var36);
													}
												}

												if (var5 < field2516 && (var14 & 2) != 0) {
													var36 = var8[var4][var5 + 1];
													if (var36 != null && var36.field2676) {
														field2546.method6355(var36);
													}
												}

												if (var4 > field2513 && (var14 & 1) != 0) {
													var36 = var8[var4 - 1][var5];
													if (var36 != null && var36.field2676) {
														field2546.method6355(var36);
													}
												}

												if (var5 > field2516 && (var14 & 8) != 0) {
													var36 = var8[var4][var5 - 1];
													if (var36 != null && var36.field2676) {
														field2546.method6355(var36);
													}
												}
											}
											break;
										}

										if (var3.field2678 != 0) {
											var20 = true;

											for (var21 = 0; var21 < var3.field2670; ++var21) {
												if (var3.field2671[var21].field2722 != field2499 && (var3.field2672[var21] & var3.field2678) == var3.field2679) {
													var20 = false;
													break;
												}
											}

											if (var20) {
												var10 = var3.field2663;
												if (!this.method4295(var7, var4, var5, var10.field2733)) {
													var10.field2728.method4116(0, field2556, field2521, field2522, field2523, var10.field2729 - field2510, var10.field2737 - field2494, var10.field2730 - field2533, var10.field2735);
												}

												var3.field2678 = 0;
											}
										}

										if (!var3.field2660) {
											break;
										}

										try {
											int var34 = var3.field2670;
											var3.field2660 = false;
											var21 = 0;

											label563:
											for (var11 = 0; var11 < var34; ++var11) {
												var12 = var3.field2671[var11];
												if (var12.field2722 != field2499) {
													for (var24 = var12.field2713; var24 <= var12.field2716; ++var24) {
														for (var14 = var12.field2715; var14 <= var12.field2708; ++var14) {
															var36 = var8[var24][var14];
															if (var36.field2675) {
																var3.field2660 = true;
																continue label563;
															}

															if (var36.field2678 != 0) {
																var16 = 0;
																if (var24 > var12.field2713) {
																	++var16;
																}

																if (var24 < var12.field2716) {
																	var16 += 4;
																}

																if (var14 > var12.field2715) {
																	var16 += 8;
																}

																if (var14 < var12.field2708) {
																	var16 += 2;
																}

																if ((var16 & var36.field2678) == var3.field2673) {
																	var3.field2660 = true;
																	continue label563;
																}
															}
														}
													}

													field2524[var21++] = var12;
													var24 = field2513 - var12.field2713;
													var14 = var12.field2716 - field2513;
													if (var14 > var24) {
														var24 = var14;
													}

													var15 = field2516 - var12.field2715;
													var16 = var12.field2708 - field2516;
													if (var16 > var15) {
														var12.field2718 = var24 + var16;
													} else {
														var12.field2718 = var24 + var15;
													}
												}
											}

											while (var21 > 0) {
												var11 = -50;
												var25 = -1;

												for (var24 = 0; var24 < var21; ++var24) {
													class227 var35 = field2524[var24];
													if (var35.field2722 != field2499) {
														if (var35.field2718 > var11) {
															var11 = var35.field2718;
															var25 = var24;
														} else if (var35.field2718 == var11) {
															var15 = var35.field2707 - field2510;
															var16 = var35.field2710 - field2533;
															var17 = field2524[var25].field2707 - field2510;
															var18 = field2524[var25].field2710 - field2533;
															if (var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
																var25 = var24;
															}
														}
													}
												}

												if (var25 == -1) {
													break;
												}

												class227 var33 = field2524[var25];
												var33.field2722 = field2499;
												if (!this.method4173(var7, var33.field2713, var33.field2716, var33.field2715, var33.field2708, var33.field2711.field2489)) {
													var33.field2711.method4116(var33.field2712, field2556, field2521, field2522, field2523, var33.field2707 - field2510, var33.field2709 - field2494, var33.field2710 - field2533, var33.field2719);
												}

												for (var14 = var33.field2713; var14 <= var33.field2716; ++var14) {
													for (var15 = var33.field2715; var15 <= var33.field2708; ++var15) {
														class224 var26 = var8[var14][var15];
														if (var26.field2678 != 0) {
															field2546.method6355(var26);
														} else if ((var14 != var4 || var15 != var5) && var26.field2676) {
															field2546.method6355(var26);
														}
													}
												}
											}

											if (!var3.field2660) {
												break;
											}
										} catch (Exception var28) {
											var3.field2660 = false;
											break;
										}
									}
								} while(!var3.field2676);
							} while(var3.field2678 != 0);

							if (var4 > field2513 || var4 <= field2511) {
								break;
							}

							var9 = var8[var4 - 1][var5];
						} while(var9 != null && var9.field2676);

						if (var4 < field2513 || var4 >= field2512 - 1) {
							break;
						}

						var9 = var8[var4 + 1][var5];
					} while(var9 != null && var9.field2676);

					if (var5 > field2516 || var5 <= field2555) {
						break;
					}

					var9 = var8[var4][var5 - 1];
				} while(var9 != null && var9.field2676);

				if (var5 < field2516 || var5 >= field2514 - 1) {
					break;
				}

				var9 = var8[var4][var5 + 1];
			} while(var9 != null && var9.field2676);

			var3.field2676 = false;
			--field2502;
			class208 var32 = var3.field2669;
			if (var32 != null && var32.field2375 != 0) {
				if (var32.field2369 != null) {
					var32.field2369.method4116(0, field2556, field2521, field2522, field2523, var32.field2372 - field2510, var32.field2373 - field2494 - var32.field2375, var32.field2370 - field2533, var32.field2374);
				}

				if (var32.field2368 != null) {
					var32.field2368.method4116(0, field2556, field2521, field2522, field2523, var32.field2372 - field2510, var32.field2373 - field2494 - var32.field2375, var32.field2370 - field2533, var32.field2374);
				}

				if (var32.field2371 != null) {
					var32.field2371.method4116(0, field2556, field2521, field2522, field2523, var32.field2372 - field2510, var32.field2373 - field2494 - var32.field2375, var32.field2370 - field2533, var32.field2374);
				}
			}

			if (var3.field2684 != 0) {
				class217 var29 = var3.field2667;
				if (var29 != null && !this.method4245(var7, var4, var5, var29.field2582.field2489)) {
					if ((var29.field2576 & var3.field2684) != 0) {
						var29.field2582.method4116(0, field2556, field2521, field2522, field2523, var29.field2579 - field2510 + var29.field2580, var29.field2575 - field2494, var29.field2578 - field2533 + var29.field2581, var29.field2584);
					} else if (var29.field2576 == 256) {
						var11 = var29.field2579 - field2510;
						var25 = var29.field2575 - field2494;
						var24 = var29.field2578 - field2533;
						var14 = var29.field2577;
						if (var14 != 1 && var14 != 2) {
							var15 = var11;
						} else {
							var15 = -var11;
						}

						if (var14 != 2 && var14 != 3) {
							var16 = var24;
						} else {
							var16 = -var24;
						}

						if (var16 >= var15) {
							var29.field2582.method4116(0, field2556, field2521, field2522, field2523, var11 + var29.field2580, var25, var24 + var29.field2581, var29.field2584);
						} else if (var29.field2585 != null) {
							var29.field2585.method4116(0, field2556, field2521, field2522, field2523, var11, var25, var24, var29.field2584);
						}
					}
				}

				class229 var27 = var3.field2663;
				if (var27 != null) {
					if ((var27.field2732 & var3.field2684) != 0 && !this.method4295(var7, var4, var5, var27.field2732)) {
						var27.field2734.method4116(0, field2556, field2521, field2522, field2523, var27.field2729 - field2510, var27.field2737 - field2494, var27.field2730 - field2533, var27.field2735);
					}

					if ((var27.field2733 & var3.field2684) != 0 && !this.method4295(var7, var4, var5, var27.field2733)) {
						var27.field2728.method4116(0, field2556, field2521, field2522, field2523, var27.field2729 - field2510, var27.field2737 - field2494, var27.field2730 - field2533, var27.field2735);
					}
				}
			}

			class224 var30;
			if (var6 < this.field2517 - 1) {
				var30 = this.field2529[var6 + 1][var4][var5];
				if (var30 != null && var30.field2676) {
					field2546.method6355(var30);
				}
			}

			if (var4 < field2513) {
				var30 = var8[var4 + 1][var5];
				if (var30 != null && var30.field2676) {
					field2546.method6355(var30);
				}
			}

			if (var5 < field2516) {
				var30 = var8[var4][var5 + 1];
				if (var30 != null && var30.field2676) {
					field2546.method6355(var30);
				}
			}

			if (var4 > field2513) {
				var30 = var8[var4 - 1][var5];
				if (var30 != null && var30.field2676) {
					field2546.method6355(var30);
				}
			}

			if (var5 > field2516) {
				var30 = var8[var4][var5 - 1];
				if (var30 != null && var30.field2676) {
					field2546.method6355(var30);
				}
			}
		}
	}

	void method4172(class226 var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9;
		int var10 = var9 = (var7 << 7) - field2510;
		int var11;
		int var12 = var11 = (var8 << 7) - field2533;
		int var13;
		int var14 = var13 = var10 + 128;
		int var15;
		int var16 = var15 = var12 + 128;
		int var17 = this.field2498[var2][var7][var8] - field2494;
		int var18 = this.field2498[var2][var7 + 1][var8] - field2494;
		int var19 = this.field2498[var2][var7 + 1][var8 + 1] - field2494;
		int var20 = this.field2498[var2][var7][var8 + 1] - field2494;
		int var21 = var12 * var5 + var10 * var6 >> 16;
		var12 = var12 * var6 - var10 * var5 >> 16;
		var10 = var21;
		var21 = var17 * var4 - var12 * var3 >> 16;
		var12 = var17 * var3 + var12 * var4 >> 16;
		var17 = var21;
		if (var12 >= 50) {
			var21 = var11 * var5 + var14 * var6 >> 16;
			var11 = var11 * var6 - var14 * var5 >> 16;
			var14 = var21;
			var21 = var18 * var4 - var11 * var3 >> 16;
			var11 = var18 * var3 + var11 * var4 >> 16;
			var18 = var21;
			if (var11 >= 50) {
				var21 = var16 * var5 + var13 * var6 >> 16;
				var16 = var16 * var6 - var13 * var5 >> 16;
				var13 = var21;
				var21 = var19 * var4 - var16 * var3 >> 16;
				var16 = var19 * var3 + var16 * var4 >> 16;
				var19 = var21;
				if (var16 >= 50) {
					var21 = var15 * var5 + var9 * var6 >> 16;
					var15 = var15 * var6 - var9 * var5 >> 16;
					var9 = var21;
					var21 = var20 * var4 - var15 * var3 >> 16;
					var15 = var20 * var3 + var15 * var4 >> 16;
					if (var15 >= 50) {
						int var22 = class221.field2634 + var10 * class221.field2630 / var12;
						int var23 = class221.field2620 + var17 * class221.field2630 / var12;
						int var24 = class221.field2634 + var14 * class221.field2630 / var11;
						int var25 = class221.field2620 + var18 * class221.field2630 / var11;
						int var26 = class221.field2634 + var13 * class221.field2630 / var16;
						int var27 = class221.field2620 + var19 * class221.field2630 / var16;
						int var28 = class221.field2634 + var9 * class221.field2630 / var15;
						int var29 = class221.field2620 + var21 * class221.field2630 / var15;
						class221.field2623 = 0;
						int var30;
						if ((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
							class221.field2628 = false;
							if (var26 < 0 || var28 < 0 || var24 < 0 || var26 > class221.field2633 || var28 > class221.field2633 || var24 > class221.field2633) {
								class221.field2628 = true;
							}

							if (field2525 && method4213(field2527, field2528, var27, var29, var25, var26, var28, var24)) {
								selectedSceneX = var7;
								selectedSceneY = var8;
							}

							if (var1.field2704 == -1) {
								if (var1.field2700 != 12345678) {
									class221.method4398(var27, var29, var25, var26, var28, var24, var1.field2700, var1.field2701, var1.field2698);
								}
							} else if (!field2559) {
								if (var1.field2702) {
									class221.method4388(var27, var29, var25, var26, var28, var24, var1.field2700, var1.field2701, var1.field2698, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2704);
								} else {
									class221.method4388(var27, var29, var25, var26, var28, var24, var1.field2700, var1.field2701, var1.field2698, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.field2704);
								}
							} else {
								var30 = class221.field2629.method4372(var1.field2704);
								class221.method4398(var27, var29, var25, var26, var28, var24, method4167(var30, var1.field2700), method4167(var30, var1.field2701), method4167(var30, var1.field2698));
							}
						}

						if ((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
							class221.field2628 = false;
							if (var22 < 0 || var24 < 0 || var28 < 0 || var22 > class221.field2633 || var24 > class221.field2633 || var28 > class221.field2633) {
								class221.field2628 = true;
							}

							if (field2525 && method4213(field2527, field2528, var23, var25, var29, var22, var24, var28)) {
								selectedSceneX = var7;
								selectedSceneY = var8;
							}

							if (var1.field2704 == -1) {
								if (var1.field2703 != 12345678) {
									class221.method4398(var23, var25, var29, var22, var24, var28, var1.field2703, var1.field2698, var1.field2701);
								}
							} else if (!field2559) {
								class221.method4388(var23, var25, var29, var22, var24, var28, var1.field2703, var1.field2698, var1.field2701, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.field2704);
							} else {
								var30 = class221.field2629.method4372(var1.field2704);
								class221.method4398(var23, var25, var29, var22, var24, var28, method4167(var30, var1.field2703), method4167(var30, var1.field2698), method4167(var30, var1.field2701));
							}
						}

					}
				}
			}
		}
	}

	void method4191(class211 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		int var8 = var1.field2473.length;

		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		for (var9 = 0; var9 < var8; ++var9) {
			var10 = var1.field2473[var9] - field2510;
			var11 = var1.field2481[var9] - field2494;
			var12 = var1.field2468[var9] - field2533;
			var13 = var12 * var4 + var10 * var5 >> 16;
			var12 = var12 * var5 - var10 * var4 >> 16;
			var10 = var13;
			var13 = var11 * var3 - var12 * var2 >> 16;
			var12 = var11 * var2 + var12 * var3 >> 16;
			if (var12 < 50) {
				return;
			}

			if (var1.field2475 != null) {
				class211.field2483[var9] = var10;
				class211.field2466[var9] = var13;
				class211.field2471[var9] = var12;
			}

			class211.field2477[var9] = class221.field2634 + var10 * class221.field2630 / var12;
			class211.field2482[var9] = class221.field2620 + var13 * class221.field2630 / var12;
		}

		class221.field2623 = 0;
		var8 = var1.field2484.length;

		for (var9 = 0; var9 < var8; ++var9) {
			var10 = var1.field2484[var9];
			var11 = var1.field2467[var9];
			var12 = var1.field2485[var9];
			var13 = class211.field2477[var10];
			int var14 = class211.field2477[var11];
			int var15 = class211.field2477[var12];
			int var16 = class211.field2482[var10];
			int var17 = class211.field2482[var11];
			int var18 = class211.field2482[var12];
			if ((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
				class221.field2628 = false;
				if (var13 < 0 || var14 < 0 || var15 < 0 || var13 > class221.field2633 || var14 > class221.field2633 || var15 > class221.field2633) {
					class221.field2628 = true;
				}

				if (field2525 && method4213(field2527, field2528, var16, var17, var18, var13, var14, var15)) {
					selectedSceneX = var6;
					selectedSceneY = var7;
				}

				if (var1.field2475 != null && var1.field2475[var9] != -1) {
					if (!field2559) {
						if (var1.field2476) {
							class221.method4388(var16, var17, var18, var13, var14, var15, var1.field2469[var9], var1.field2470[var9], var1.field2474[var9], class211.field2483[0], class211.field2483[1], class211.field2483[3], class211.field2466[0], class211.field2466[1], class211.field2466[3], class211.field2471[0], class211.field2471[1], class211.field2471[3], var1.field2475[var9]);
						} else {
							class221.method4388(var16, var17, var18, var13, var14, var15, var1.field2469[var9], var1.field2470[var9], var1.field2474[var9], class211.field2483[var10], class211.field2483[var11], class211.field2483[var12], class211.field2466[var10], class211.field2466[var11], class211.field2466[var12], class211.field2471[var10], class211.field2471[var11], class211.field2471[var12], var1.field2475[var9]);
						}
					} else {
						int var19 = class221.field2629.method4372(var1.field2475[var9]);
						class221.method4398(var16, var17, var18, var13, var14, var15, method4167(var19, var1.field2469[var9]), method4167(var19, var1.field2470[var9]), method4167(var19, var1.field2474[var9]));
					}
				} else if (var1.field2469[var9] != 12345678) {
					class221.method4398(var16, var17, var18, var13, var14, var15, var1.field2469[var9], var1.field2470[var9], var1.field2474[var9]);
				}
			}
		}

	}

	static final int method4167(int var0, int var1) {
		var1 = var1 * (var0 & 127) >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}

	static boolean method4213(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 < var2 && var1 < var3 && var1 < var4) {
			return false;
		} else if (var1 > var2 && var1 > var3 && var1 > var4) {
			return false;
		} else if (var0 < var5 && var0 < var6 && var0 < var7) {
			return false;
		} else if (var0 > var5 && var0 > var6 && var0 > var7) {
			return false;
		} else {
			int var8 = (var1 - var2) * (var6 - var5) - (var0 - var5) * (var3 - var2);
			int var9 = (var1 - var3) * (var7 - var6) - (var0 - var6) * (var4 - var3);
			int var10 = (var1 - var4) * (var5 - var7) - (var0 - var7) * (var2 - var4);
			if (var8 == 0) {
				if (var9 != 0) {
					return var9 < 0 ? var10 <= 0 : var10 >= 0;
				} else {
					return true;
				}
			} else {
				return var8 < 0 ? var9 <= 0 && var10 <= 0 : var9 >= 0 && var10 >= 0;
			}
		}
	}

	void method4204() {
		int var1 = field2532[field2509];
		class219[] var2 = field2535[field2509];
		field2537 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			class219 var4 = var2[var3];
			int var5;
			int var6;
			int var7;
			int var9;
			boolean var13;
			if (var4.field2602 == 1) {
				var5 = var4.field2614 - field2513 + 25;
				if (var5 >= 0 && var5 <= 50) {
					var6 = var4.field2600 - field2516 + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.field2601 - field2516 + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					var13 = false;

					while (var6 <= var7) {
						if (field2554[var5][var6++]) {
							var13 = true;
							break;
						}
					}

					if (var13) {
						var9 = field2510 - var4.field2603;
						if (var9 > 32) {
							var4.field2607 = 1;
						} else {
							if (var9 >= -32) {
								continue;
							}

							var4.field2607 = 2;
							var9 = -var9;
						}

						var4.field2612 = (var4.field2618 - field2533 << 8) / var9;
						var4.field2613 = (var4.field2598 - field2533 << 8) / var9;
						var4.field2615 = (var4.field2609 - field2494 << 8) / var9;
						var4.field2611 = (var4.field2608 - field2494 << 8) / var9;
						field2538[field2537++] = var4;
					}
				}
			} else if (var4.field2602 == 2) {
				var5 = var4.field2600 - field2516 + 25;
				if (var5 >= 0 && var5 <= 50) {
					var6 = var4.field2614 - field2513 + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.field2599 - field2513 + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					var13 = false;

					while (var6 <= var7) {
						if (field2554[var6++][var5]) {
							var13 = true;
							break;
						}
					}

					if (var13) {
						var9 = field2533 - var4.field2618;
						if (var9 > 32) {
							var4.field2607 = 3;
						} else {
							if (var9 >= -32) {
								continue;
							}

							var4.field2607 = 4;
							var9 = -var9;
						}

						var4.field2610 = (var4.field2603 - field2510 << 8) / var9;
						var4.field2605 = (var4.field2606 - field2510 << 8) / var9;
						var4.field2615 = (var4.field2609 - field2494 << 8) / var9;
						var4.field2611 = (var4.field2608 - field2494 << 8) / var9;
						field2538[field2537++] = var4;
					}
				}
			} else if (var4.field2602 == 4) {
				var5 = var4.field2609 - field2494;
				if (var5 > 128) {
					var6 = var4.field2600 - field2516 + 25;
					if (var6 < 0) {
						var6 = 0;
					}

					var7 = var4.field2601 - field2516 + 25;
					if (var7 > 50) {
						var7 = 50;
					}

					if (var6 <= var7) {
						int var8 = var4.field2614 - field2513 + 25;
						if (var8 < 0) {
							var8 = 0;
						}

						var9 = var4.field2599 - field2513 + 25;
						if (var9 > 50) {
							var9 = 50;
						}

						boolean var10 = false;

						label146:
						for (int var11 = var8; var11 <= var9; ++var11) {
							for (int var12 = var6; var12 <= var7; ++var12) {
								if (field2554[var11][var12]) {
									var10 = true;
									break label146;
								}
							}
						}

						if (var10) {
							var4.field2607 = 5;
							var4.field2610 = (var4.field2603 - field2510 << 8) / var5;
							var4.field2605 = (var4.field2606 - field2510 << 8) / var5;
							var4.field2612 = (var4.field2618 - field2533 << 8) / var5;
							var4.field2613 = (var4.field2598 - field2533 << 8) / var5;
							field2538[field2537++] = var4;
						}
					}
				}
			}
		}

	}

	boolean method4201(int var1, int var2, int var3) {
		int var4 = this.field2503[var1][var2][var3];
		if (var4 == -field2499) {
			return false;
		} else if (var4 == field2499) {
			return true;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			if (this.method4174(var5 + 1, this.field2498[var1][var2][var3], var6 + 1) && this.method4174(var5 + 128 - 1, this.field2498[var1][var2 + 1][var3], var6 + 1) && this.method4174(var5 + 128 - 1, this.field2498[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method4174(var5 + 1, this.field2498[var1][var2][var3 + 1], var6 + 128 - 1)) {
				this.field2503[var1][var2][var3] = field2499;
				return true;
			} else {
				this.field2503[var1][var2][var3] = -field2499;
				return false;
			}
		}
	}

	boolean method4295(int var1, int var2, int var3, int var4) {
		if (!this.method4201(var1, var2, var3)) {
			return false;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			int var7 = this.field2498[var1][var2][var3] - 1;
			int var8 = var7 - 120;
			int var9 = var7 - 230;
			int var10 = var7 - 238;
			if (var4 < 16) {
				if (var4 == 1) {
					if (var5 > field2510) {
						if (!this.method4174(var5, var7, var6)) {
							return false;
						}

						if (!this.method4174(var5, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method4174(var5, var8, var6)) {
							return false;
						}

						if (!this.method4174(var5, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method4174(var5, var9, var6)) {
						return false;
					}

					if (!this.method4174(var5, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 2) {
					if (var6 < field2533) {
						if (!this.method4174(var5, var7, var6 + 128)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method4174(var5, var8, var6 + 128)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method4174(var5, var9, var6 + 128)) {
						return false;
					}

					if (!this.method4174(var5 + 128, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 4) {
					if (var5 < field2510) {
						if (!this.method4174(var5 + 128, var7, var6)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var7, var6 + 128)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method4174(var5 + 128, var8, var6)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var8, var6 + 128)) {
							return false;
						}
					}

					if (!this.method4174(var5 + 128, var9, var6)) {
						return false;
					}

					if (!this.method4174(var5 + 128, var9, var6 + 128)) {
						return false;
					}

					return true;
				}

				if (var4 == 8) {
					if (var6 > field2533) {
						if (!this.method4174(var5, var7, var6)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var7, var6)) {
							return false;
						}
					}

					if (var1 > 0) {
						if (!this.method4174(var5, var8, var6)) {
							return false;
						}

						if (!this.method4174(var5 + 128, var8, var6)) {
							return false;
						}
					}

					if (!this.method4174(var5, var9, var6)) {
						return false;
					}

					if (!this.method4174(var5 + 128, var9, var6)) {
						return false;
					}

					return true;
				}
			}

			if (!this.method4174(var5 + 64, var10, var6 + 64)) {
				return false;
			} else if (var4 == 16) {
				return this.method4174(var5, var9, var6 + 128);
			} else if (var4 == 32) {
				return this.method4174(var5 + 128, var9, var6 + 128);
			} else if (var4 == 64) {
				return this.method4174(var5 + 128, var9, var6);
			} else if (var4 == 128) {
				return this.method4174(var5, var9, var6);
			} else {
				return true;
			}
		}
	}

	boolean method4245(int var1, int var2, int var3, int var4) {
		if (!this.method4201(var1, var2, var3)) {
			return false;
		} else {
			int var5 = var2 << 7;
			int var6 = var3 << 7;
			return this.method4174(var5 + 1, this.field2498[var1][var2][var3] - var4, var6 + 1) && this.method4174(var5 + 128 - 1, this.field2498[var1][var2 + 1][var3] - var4, var6 + 1) && this.method4174(var5 + 128 - 1, this.field2498[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method4174(var5 + 1, this.field2498[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
		}
	}

	boolean method4173(int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7;
		int var8;
		if (var2 == var3 && var4 == var5) {
			if (!this.method4201(var1, var2, var4)) {
				return false;
			} else {
				var7 = var2 << 7;
				var8 = var4 << 7;
				return this.method4174(var7 + 1, this.field2498[var1][var2][var4] - var6, var8 + 1) && this.method4174(var7 + 128 - 1, this.field2498[var1][var2 + 1][var4] - var6, var8 + 1) && this.method4174(var7 + 128 - 1, this.field2498[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method4174(var7 + 1, this.field2498[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
			}
		} else {
			for (var7 = var2; var7 <= var3; ++var7) {
				for (var8 = var4; var8 <= var5; ++var8) {
					if (this.field2503[var1][var7][var8] == -field2499) {
						return false;
					}
				}
			}

			var7 = (var2 << 7) + 1;
			var8 = (var4 << 7) + 2;
			int var9 = this.field2498[var1][var2][var4] - var6;
			if (!this.method4174(var7, var9, var8)) {
				return false;
			} else {
				int var10 = (var3 << 7) - 1;
				if (!this.method4174(var10, var9, var8)) {
					return false;
				} else {
					int var11 = (var5 << 7) - 1;
					if (!this.method4174(var7, var9, var11)) {
						return false;
					} else if (!this.method4174(var10, var9, var11)) {
						return false;
					} else {
						return true;
					}
				}
			}
		}
	}

	boolean method4174(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < field2537; ++var4) {
			class219 var5 = field2538[var4];
			int var6;
			int var7;
			int var8;
			int var9;
			int var10;
			if (var5.field2607 == 1) {
				var6 = var5.field2603 - var1;
				if (var6 > 0) {
					var7 = var5.field2618 + (var5.field2612 * var6 >> 8);
					var8 = var5.field2598 + (var5.field2613 * var6 >> 8);
					var9 = var5.field2609 + (var5.field2615 * var6 >> 8);
					var10 = var5.field2608 + (var5.field2611 * var6 >> 8);
					if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field2607 == 2) {
				var6 = var1 - var5.field2603;
				if (var6 > 0) {
					var7 = var5.field2618 + (var5.field2612 * var6 >> 8);
					var8 = var5.field2598 + (var5.field2613 * var6 >> 8);
					var9 = var5.field2609 + (var5.field2615 * var6 >> 8);
					var10 = var5.field2608 + (var5.field2611 * var6 >> 8);
					if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field2607 == 3) {
				var6 = var5.field2618 - var3;
				if (var6 > 0) {
					var7 = var5.field2603 + (var5.field2610 * var6 >> 8);
					var8 = var5.field2606 + (var5.field2605 * var6 >> 8);
					var9 = var5.field2609 + (var5.field2615 * var6 >> 8);
					var10 = var5.field2608 + (var5.field2611 * var6 >> 8);
					if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field2607 == 4) {
				var6 = var3 - var5.field2618;
				if (var6 > 0) {
					var7 = var5.field2603 + (var5.field2610 * var6 >> 8);
					var8 = var5.field2606 + (var5.field2605 * var6 >> 8);
					var9 = var5.field2609 + (var5.field2615 * var6 >> 8);
					var10 = var5.field2608 + (var5.field2611 * var6 >> 8);
					if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
						return true;
					}
				}
			} else if (var5.field2607 == 5) {
				var6 = var2 - var5.field2609;
				if (var6 > 0) {
					var7 = var5.field2603 + (var5.field2610 * var6 >> 8);
					var8 = var5.field2606 + (var5.field2605 * var6 >> 8);
					var9 = var5.field2618 + (var5.field2612 * var6 >> 8);
					var10 = var5.field2598 + (var5.field2613 * var6 >> 8);
					if (var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
