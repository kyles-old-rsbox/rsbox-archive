import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class class243 {
	public static class265 field2848;
	static class336 field2846;
	class228 field2840;
	int field2844;
	int field2845;
	int field2849;
	int field2853;
	HashMap field2851;
	LinkedList field2847;
	List field2850;
	final HashMap field2852;

	static {
		field2848 = new class265(37748736, 256);
	}

	static long method3974(int var0, int var1, int var2) {
		return (long)(var2 << 16 | var0 << 8 | var1);
	}

	static class473 method2611(int var0, int var1, int var2) {
		return (class473)field2848.method5177(method3974(var0, var1, var2));
	}

	static void method3411() {
		field2848.method5185();
	}

	class243(int var1, int var2, int var3, HashMap var4) {
		this.field2844 = var1;
		this.field2845 = var2;
		this.field2847 = new LinkedList();
		this.field2850 = new LinkedList();
		this.field2851 = new HashMap();
		this.field2853 = var3 | -16777216;
		this.field2852 = var4;
	}

	void method4735(int var1, int var2, int var3) {
		class473 var5 = method2611(this.field2844, this.field2845, this.field2849);
		if (var5 != null) {
			if (var3 == this.field2849 * 64) {
				var5.method8483(var1, var2);
			} else {
				var5.method8484(var1, var2, var3, var3);
			}

		}
	}

	void method4736(class228 var1, List var2) {
		this.field2851.clear();
		this.field2840 = var1;
		this.method4749(var2);
	}

	void method4737(HashSet var1, List var2) {
		this.field2851.clear();
		Iterator var4 = var1.iterator();

		while (var4.hasNext()) {
			class244 var5 = (class244)var4.next();
			if (var5.method4664() == this.field2844 && var5.method4657() == this.field2845) {
				this.field2847.add(var5);
			}
		}

		this.method4749(var2);
	}

	void method4738(int var1, int var2, int var3, int var4, class239 var5) {
		for (int var7 = var1; var7 < var1 + var3; ++var7) {
			label49:
			for (int var8 = var2; var8 < var2 + var4; ++var8) {
				for (int var9 = 0; var9 < var5.field2813; ++var9) {
					class253[] var10 = var5.field2812[var9][var7][var8];
					if (var10 != null && 0 != var10.length) {
						class253[] var11 = var10;

						for (int var12 = 0; var12 < var11.length; ++var12) {
							class253 var13 = var11[var12];
							class195 var14 = class89.method1866(var13.field2927);
							if (class143.method2494(var14)) {
								this.method4739(var14, var9, var7, var8, var5);
								continue label49;
							}
						}
					}
				}
			}
		}

	}

	void method4739(class195 var1, int var2, int var3, int var4, class239 var5) {
		class295 var7 = new class295(var2, var3 + this.field2844 * 64, var4 + this.field2845 * 64);
		class295 var8 = null;
		if (null != this.field2840) {
			var8 = new class295(var2 + this.field2840.field2815, this.field2840.field2821 * 64 + var3, var4 + this.field2840.field2809 * 64);
		} else {
			class244 var9 = (class244)var5;
			var8 = new class295(var9.field2815 + var2, var9.field2821 * 64 + var3 + var9.method4874() * 8, var4 + var9.field2809 * 64 + var9.method4884() * 8);
		}

		class160 var10;
		Object var11;
		if (var1.field2094 != null) {
			var11 = new class232(var8, var7, var1.field2052, this);
		} else {
			var10 = class90.method1885(var1.field2081);
			var11 = new class249(var8, var7, var10.field1481, this.method4761(var10));
		}

		var10 = class90.method1885(((class251)var11).method5024());
		if (var10.field1471) {
			this.field2851.put(new class295(0, var3, var4), var11);
		}

	}

	void method4740() {
		Iterator var2 = this.field2851.values().iterator();

		while (var2.hasNext()) {
			class251 var3 = (class251)var2.next();
			if (var3 instanceof class232) {
				((class232)var3).method4543();
			}
		}

	}

	void method4749(List var1) {
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			class249 var4 = (class249)var3.next();
			if (class90.method1885(var4.field2898).field1471 && var4.field2915.field3376 >> 6 == this.field2844 && this.field2845 == var4.field2915.field3375 >> 6) {
				class249 var5 = new class249(var4.field2915, var4.field2915, var4.field2898, this.method4822(var4.field2898));
				this.field2850.add(var5);
			}
		}

	}

	void method4742() {
		if (null != this.field2840) {
			this.field2840.method4651();
		} else {
			Iterator var2 = this.field2847.iterator();

			while (var2.hasNext()) {
				class244 var3 = (class244)var2.next();
				var3.method4651();
			}
		}

	}

	static final void method4768(class460 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var8;
		if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
			class82.field714[var1][var2][var3] = 0;

			while (true) {
				var8 = client.field1932 < 209 ? var0.method8141() : var0.method8122();
				if (var8 == 0) {
					if (var1 == 0) {
						class82.field719[0][var2][var3] = -class8.method53(var2 + 932731 + var4, var5 + var3 + 556238) * 8;
					} else {
						class82.field719[var1][var2][var3] = class82.field719[var1 - 1][var2][var3] - 240;
					}
					break;
				}

				if (var8 == 1) {
					int var9 = var0.method8141();
					if (var9 == 1) {
						var9 = 0;
					}

					if (var1 == 0) {
						class82.field719[0][var2][var3] = -var9 * 8;
					} else {
						class82.field719[var1][var2][var3] = class82.field719[var1 - 1][var2][var3] - var9 * 8;
					}
					break;
				}

				if (var8 <= 49) {
					class82.field723[var1][var2][var3] = client.field1932 < 209 ? (short)var0.method8287() : (short)var0.method8204();
					class82.field718[var1][var2][var3] = (byte)((var8 - 2) / 4);
					class179.field1597[var1][var2][var3] = (byte)(var6 + (var8 - 2) & 3);
				} else if (var8 <= 81) {
					class82.field714[var1][var2][var3] = (byte)(var8 - 49);
				} else {
					class82.field716[var1][var2][var3] = (short)(var8 - 81);
				}
			}
		} else {
			while (true) {
				var8 = client.field1932 < 209 ? var0.method8141() : var0.method8122();
				if (var8 == 0) {
					break;
				}

				if (var8 == 1) {
					var0.method8141();
					break;
				}

				if (var8 <= 49) {
					if (client.field1932 < 209) {
						var0.method8287();
					} else {
						var0.method8204();
					}
				}
			}
		}

	}

	boolean method4743(class319 var1) {
		this.field2851.clear();
		if (this.field2840 != null) {
			this.field2840.method4650(var1);
			if (this.field2840.method4649()) {
				this.method4738(0, 0, 64, 64, this.field2840);
				return true;
			} else {
				return false;
			}
		} else {
			boolean var3 = true;

			Iterator var4;
			class244 var5;
			for (var4 = this.field2847.iterator(); var4.hasNext(); var3 &= var5.method4649()) {
				var5 = (class244)var4.next();
				var5.method4650(var1);
			}

			if (var3) {
				var4 = this.field2847.iterator();

				while (var4.hasNext()) {
					var5 = (class244)var4.next();
					this.method4738(var5.method4876() * 8, var5.method4877() * 8, 8, 8, var5);
				}
			}

			return var3;
		}
	}

	void method4744(int var1, class240 var2, class488[] var3, class319 var4, class319 var5) {
		this.field2849 = var1;
		if (null != this.field2840 || !this.field2847.isEmpty()) {
			if (method2611(this.field2844, this.field2845, var1) == null) {
				boolean var7 = true;
				var7 &= this.method4743(var4);
				int var9;
				if (this.field2840 != null) {
					var9 = this.field2840.field2814;
				} else {
					var9 = ((class239)this.field2847.getFirst()).field2814;
				}

				var7 &= var5.method6091(var9);
				if (var7) {
					byte[] var8 = var5.method6103(var9);
					class241 var10;
					if (var8 == null) {
						var10 = new class241();
					} else {
						var10 = new class241(class32.method712(var8).field4952);
					}

					class473 var12 = new class473(this.field2849 * 64, this.field2849 * 64);
					var12.method8476();
					if (this.field2840 != null) {
						this.method4844(var2, var3, var10);
					} else {
						this.method4747(var2, var3, var10);
					}

					int var13 = this.field2844;
					int var14 = this.field2845;
					int var15 = this.field2849;
					field2848.method5170(var12, method3974(var13, var14, var15), 4 * var12.field4952.length);
					this.method4742();
				}
			}
		}
	}

	void method4820(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.method4756(var1, var2, var4, var3);
		this.method4760(var1, var2, var4, var3);
	}

	void method4779(HashSet var1, int var2, int var3) {
		Iterator var5 = this.field2851.values().iterator();

		while (var5.hasNext()) {
			class251 var6 = (class251)var5.next();
			if (var6.method5014()) {
				int var7 = var6.method5024();
				if (var1.contains(var7)) {
					class160 var8 = class90.method1885(var7);
					this.method4803(var8, var6.field2910, var6.field2914, var2, var3);
				}
			}
		}

		this.method4755(var1, var2, var3);
	}

	void method4844(class240 var1, class488[] var2, class241 var3) {
		int var5;
		int var6;
		for (var5 = 0; var5 < 64; ++var5) {
			for (var6 = 0; var6 < 64; ++var6) {
				this.method4786(var5, var6, this.field2840, var1, var3);
				this.method4828(var5, var6, this.field2840, var1);
			}
		}

		for (var5 = 0; var5 < 64; ++var5) {
			for (var6 = 0; var6 < 64; ++var6) {
				this.method4748(var5, var6, this.field2840, var1, var2);
			}
		}

	}

	void method4747(class240 var1, class488[] var2, class241 var3) {
		Iterator var5 = this.field2847.iterator();

		class244 var6;
		int var7;
		int var8;
		while (var5.hasNext()) {
			var6 = (class244)var5.next();

			for (var7 = var6.method4876() * 8; var7 < var6.method4876() * 8 + 8; ++var7) {
				for (var8 = var6.method4877() * 8; var8 < var6.method4877() * 8 + 8; ++var8) {
					this.method4786(var7, var8, var6, var1, var3);
					this.method4828(var7, var8, var6, var1);
				}
			}
		}

		var5 = this.field2847.iterator();

		while (var5.hasNext()) {
			var6 = (class244)var5.next();

			for (var7 = var6.method4876() * 8; var7 < var6.method4876() * 8 + 8; ++var7) {
				for (var8 = var6.method4877() * 8; var8 < var6.method4877() * 8 + 8; ++var8) {
					this.method4748(var7, var8, var6, var1, var2);
				}
			}
		}

	}

	void method4748(int var1, int var2, class239 var3, class240 var4, class488[] var5) {
		this.method4753(var1, var2, var3);
		this.method4745(var1, var2, var3, var5);
	}

	void method4786(int var1, int var2, class239 var3, class240 var4, class241 var5) {
		int var7 = var3.field2816[0][var1][var2] - 1;
		int var8 = var3.field2808[0][var1][var2] - 1;
		if (var7 == -1 && var8 == -1) {
			class481.method8660(this.field2849 * var1, (63 - var2) * this.field2849, this.field2849, this.field2849, this.field2853);
		}

		int var9 = 16711935;
		int var10;
		if (var8 != -1) {
			int var11 = this.field2853;
			class199 var13 = (class199)class199.field2183.method5439((long)var8);
			class199 var12;
			if (null != var13) {
				var12 = var13;
			} else {
				byte[] var22 = class199.field2188.method6175(4, var8);
				var13 = new class199();
				if (var22 != null) {
					var13.method3717(new class460(var22), var8);
				}

				var13.method3716();
				class199.field2183.method5434(var13, (long)var8);
				var12 = var13;
			}

			if (var12 == null) {
				var10 = var11;
			} else if (var12.field2187 >= 0) {
				var10 = var12.field2187 | -16777216;
			} else {
				int var15;
				int var23;
				if (var12.field2185 >= 0) {
					var15 = class221.field2629.method4372(var12.field2185);
					byte var16 = 96;
					int var14;
					if (var15 == -2) {
						var14 = 12345678;
					} else if (var15 == -1) {
						if (var16 < 0) {
							var16 = 0;
						} else if (var16 > 127) {
							var16 = 127;
						}

						var23 = 127 - var16;
						var14 = var23;
					} else {
						var23 = (var15 & 127) * var16 / 128;
						if (var23 < 2) {
							var23 = 2;
						} else if (var23 > 126) {
							var23 = 126;
						}

						var14 = (var15 & 65408) + var23;
					}

					var10 = class221.field2640[var14] | -16777216;
				} else if (var12.field2184 == 16711935) {
					var10 = var11;
				} else {
					var15 = var12.field2194;
					var23 = var12.field2182;
					int var17 = var12.field2190;
					if (var17 > 179) {
						var23 /= 2;
					}

					if (var17 > 192) {
						var23 /= 2;
					}

					if (var17 > 217) {
						var23 /= 2;
					}

					if (var17 > 243) {
						var23 /= 2;
					}

					int var18 = var17 / 2 + (var15 / 4 << 10) + (var23 / 32 << 7);
					byte var20 = 96;
					int var19;
					if (var18 == -2) {
						var19 = 12345678;
					} else {
						int var24;
						if (var18 == -1) {
							if (var20 < 0) {
								var20 = 0;
							} else if (var20 > 127) {
								var20 = 127;
							}

							var24 = 127 - var20;
							var19 = var24;
						} else {
							var24 = (var18 & 127) * var20 / 128;
							if (var24 < 2) {
								var24 = 2;
							} else if (var24 > 126) {
								var24 = 126;
							}

							var19 = var24 + (var18 & 65408);
						}
					}

					var10 = class221.field2640[var19] | -16777216;
				}
			}

			var9 = var10;
		}

		if (var8 > -1 && 0 == var3.field2818[0][var1][var2]) {
			class481.method8660(var1 * this.field2849, this.field2849 * (63 - var2), this.field2849, this.field2849, var9);
		} else {
			var10 = this.method4751(var1, var2, var3, var5);
			if (var8 == -1) {
				class481.method8660(this.field2849 * var1, (63 - var2) * this.field2849, this.field2849, this.field2849, var10);
			} else {
				var4.method4701(this.field2849 * var1, (63 - var2) * this.field2849, var10, var9, this.field2849, this.field2849, var3.field2818[0][var1][var2], var3.field2819[0][var1][var2]);
			}
		}
	}

	void method4828(int var1, int var2, class239 var3, class240 var4) {
		for (int var6 = 1; var6 < var3.field2813; ++var6) {
			int var7 = var3.field2808[var6][var1][var2] - 1;
			if (var7 > -1) {
				int var9 = this.field2853;
				class199 var11 = (class199)class199.field2183.method5439((long)var7);
				class199 var10;
				if (var11 != null) {
					var10 = var11;
				} else {
					byte[] var21 = class199.field2188.method6175(4, var7);
					var11 = new class199();
					if (var21 != null) {
						var11.method3717(new class460(var21), var7);
					}

					var11.method3716();
					class199.field2183.method5434(var11, (long)var7);
					var10 = var11;
				}

				int var8;
				if (var10 == null) {
					var8 = var9;
				} else if (var10.field2187 >= 0) {
					var8 = var10.field2187 | -16777216;
				} else {
					int var13;
					int var22;
					if (var10.field2185 >= 0) {
						var13 = class221.field2629.method4372(var10.field2185);
						byte var14 = 96;
						int var12;
						if (var13 == -2) {
							var12 = 12345678;
						} else if (var13 == -1) {
							if (var14 < 0) {
								var14 = 0;
							} else if (var14 > 127) {
								var14 = 127;
							}

							var22 = 127 - var14;
							var12 = var22;
						} else {
							var22 = (var13 & 127) * var14 / 128;
							if (var22 < 2) {
								var22 = 2;
							} else if (var22 > 126) {
								var22 = 126;
							}

							var12 = (var13 & 65408) + var22;
						}

						var8 = class221.field2640[var12] | -16777216;
					} else if (var10.field2184 == 16711935) {
						var8 = var9;
					} else {
						var13 = var10.field2194;
						var22 = var10.field2182;
						int var15 = var10.field2190;
						if (var15 > 179) {
							var22 /= 2;
						}

						if (var15 > 192) {
							var22 /= 2;
						}

						if (var15 > 217) {
							var22 /= 2;
						}

						if (var15 > 243) {
							var22 /= 2;
						}

						int var16 = (var22 / 32 << 7) + (var13 / 4 << 10) + var15 / 2;
						byte var18 = 96;
						int var17;
						if (var16 == -2) {
							var17 = 12345678;
						} else {
							int var23;
							if (var16 == -1) {
								if (var18 < 0) {
									var18 = 0;
								} else if (var18 > 127) {
									var18 = 127;
								}

								var23 = 127 - var18;
								var17 = var23;
							} else {
								var23 = (var16 & 127) * var18 / 128;
								if (var23 < 2) {
									var23 = 2;
								} else if (var23 > 126) {
									var23 = 126;
								}

								var17 = (var16 & 65408) + var23;
							}
						}

						var8 = class221.field2640[var17] | -16777216;
					}
				}

				if (var3.field2818[var6][var1][var2] == 0) {
					class481.method8660(var1 * this.field2849, this.field2849 * (63 - var2), this.field2849, this.field2849, var8);
				} else {
					var4.method4701(this.field2849 * var1, this.field2849 * (63 - var2), 0, var8, this.field2849, this.field2849, var3.field2818[var6][var1][var2], var3.field2819[var6][var1][var2]);
				}
			}
		}

	}

	int method4751(int var1, int var2, class239 var3, class241 var4) {
		return 0 == var3.field2816[0][var1][var2] ? this.field2853 : var4.method4726(var1, var2);
	}

	void method4745(int var1, int var2, class239 var3, class488[] var4) {
		for (int var6 = 0; var6 < var3.field2813; ++var6) {
			class253[] var7 = var3.field2812[var6][var1][var2];
			if (var7 != null && var7.length != 0) {
				class253[] var8 = var7;

				for (int var9 = 0; var9 < var8.length; ++var9) {
					class253 var10 = var8[var9];
					int var12 = var10.field2929;
					boolean var11 = var12 >= class306.field3667.field3670 && var12 <= class306.field3657.field3670;
					if (var11 || class87.method1851(var10.field2929)) {
						class195 var13 = class89.method1866(var10.field2927);
						if (var13.field2075 != -1) {
							if (var13.field2075 != 46 && 52 != var13.field2075) {
								var4[var13.field2075].method8757(this.field2849 * var1, this.field2849 * (63 - var2), this.field2849 * 2, this.field2849 * 2);
							} else {
								var4[var13.field2075].method8757(var1 * this.field2849, (63 - var2) * this.field2849, 1 + this.field2849 * 2, 1 + this.field2849 * 2);
							}
						}
					}
				}
			}
		}

	}

	void method4753(int var1, int var2, class239 var3) {
		for (int var5 = 0; var5 < var3.field2813; ++var5) {
			class253[] var6 = var3.field2812[var5][var1][var2];
			if (null != var6 && 0 != var6.length) {
				class253[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					class253 var9 = var7[var8];
					if (class239.method4679(var9.field2929)) {
						class195 var10 = class89.method1866(var9.field2927);
						int var11 = var10.field2072 != 0 ? -3407872 : -3355444;
						if (var9.field2929 == class306.field3660.field3670) {
							this.method4767(var1, var2, var9.field2926, var11);
						}

						if (var9.field2929 == class306.field3659.field3670) {
							this.method4767(var1, var2, var9.field2926, -3355444);
							this.method4767(var1, var2, var9.field2926 + 1, var11);
						}

						if (class306.field3663.field3670 == var9.field2929) {
							if (var9.field2926 == 0) {
								class481.method8666(var1 * this.field2849, this.field2849 * (63 - var2), 1, var11);
							}

							if (var9.field2926 == 1) {
								class481.method8666(this.field2849 + this.field2849 * var1 - 1, this.field2849 * (63 - var2), 1, var11);
							}

							if (var9.field2926 == 2) {
								class481.method8666(var1 * this.field2849 + this.field2849 - 1, this.field2849 * (63 - var2) + this.field2849 - 1, 1, var11);
							}

							if (var9.field2926 == 3) {
								class481.method8666(this.field2849 * var1, this.field2849 * (63 - var2) + this.field2849 - 1, 1, var11);
							}
						}

						if (class306.field3651.field3670 == var9.field2929) {
							int var12 = var9.field2926 % 2;
							int var13;
							if (var12 == 0) {
								for (var13 = 0; var13 < this.field2849; ++var13) {
									class481.method8666(this.field2849 * var1 + var13, (64 - var2) * this.field2849 - 1 - var13, 1, var11);
								}
							} else {
								for (var13 = 0; var13 < this.field2849; ++var13) {
									class481.method8666(this.field2849 * var1 + var13, var13 + this.field2849 * (63 - var2), 1, var11);
								}
							}
						}
					}
				}
			}
		}

	}

	void method4756(int var1, int var2, HashSet var3, int var4) {
		float var6 = (float)var4 / 64.0F;
		float var7 = var6 / 2.0F;
		Iterator var8 = this.field2851.entrySet().iterator();

		while (var8.hasNext()) {
			Entry var9 = (Entry)var8.next();
			class295 var10 = (class295)var9.getKey();
			int var11 = (int)((float)var1 + var6 * (float)var10.field3376 - var7);
			int var12 = (int)((float)(var2 + var4) - (float)var10.field3375 * var6 - var7);
			class251 var13 = (class251)var9.getValue();
			if (var13 != null && var13.method5014()) {
				var13.field2910 = var11;
				var13.field2914 = var12;
				class160 var14 = class90.method1885(var13.method5024());
				if (!var3.contains(var14.method2646())) {
					this.method4757(var13, var11, var12, var6);
				}
			}
		}

	}

	void method4755(HashSet var1, int var2, int var3) {
		Iterator var5 = this.field2850.iterator();

		while (var5.hasNext()) {
			class251 var6 = (class251)var5.next();
			if (var6.method5014()) {
				class160 var7 = class90.method1885(var6.method5024());
				if (null != var7 && var1.contains(var7.method2646())) {
					this.method4803(var7, var6.field2910, var6.field2914, var2, var3);
				}
			}
		}

	}

	void method4803(class160 var1, int var2, int var3, int var4, int var5) {
		class473 var7 = var1.method2644(false);
		if (null != var7) {
			var7.method8526(var2 - var7.field4959 / 2, var3 - var7.field4951 / 2);
			if (var4 % var5 < var5 / 2) {
				class481.method8658(var2, var3, 15, 16776960, 128);
				class481.method8658(var2, var3, 7, 16777215, 256);
			}

		}
	}

	void method4757(class251 var1, int var2, int var3, float var4) {
		class160 var6 = class90.method1885(var1.method5024());
		this.method4758(var6, var2, var3);
		this.method4763(var1, var6, var2, var3, var4);
	}

	void method4758(class160 var1, int var2, int var3) {
		class473 var5 = var1.method2644(false);
		if (null != var5) {
			int var6 = this.method4796(var5, var1.field1483);
			int var7 = this.method4762(var5, var1.field1484);
			var5.method8526(var2 + var6, var3 + var7);
		}

	}

	void method4763(class251 var1, class160 var2, int var3, int var4, float var5) {
		class260 var7 = var1.method5030();
		if (var7 != null) {
			if (var7.field2967.method4098(var5)) {
				class376 var8 = (class376)this.field2852.get(var7.field2967);
				var8.method6870(var7.field2971, var3 - var7.field2968 / 2, var4, var7.field2968, var7.field2969, -16777216 | var2.field1475, 0, 1, 0, var8.field4435 / 2);
			}
		}
	}

	void method4760(int var1, int var2, HashSet var3, int var4) {
		float var6 = (float)var4 / 64.0F;
		Iterator var7 = this.field2850.iterator();

		while (var7.hasNext()) {
			class251 var8 = (class251)var7.next();
			if (var8.method5014()) {
				int var9 = var8.field2915.field3376 % 64;
				int var10 = var8.field2915.field3375 % 64;
				var8.field2910 = (int)((float)var9 * var6 + (float)var1);
				var8.field2914 = (int)(var6 * (float)(63 - var10) + (float)var2);
				if (!var3.contains(var8.method5024())) {
					this.method4757(var8, var8.field2910, var8.field2914, var6);
				}
			}
		}

	}

	int method4796(class473 var1, class194 var2) {
		switch(var2.field2046) {
		case 0:
			return -var1.field4959 / 2;
		case 1:
			return 0;
		default:
			return -var1.field4959;
		}
	}

	int method4762(class473 var1, class183 var2) {
		switch(var2.field1941) {
		case 0:
			return 0;
		case 1:
			return -var1.field4951 / 2;
		default:
			return -var1.field4951;
		}
	}

	class260 method4822(int var1) {
		class160 var3 = class90.method1885(var1);
		return this.method4761(var3);
	}

	class260 method4761(class160 var1) {
		if (var1.field1470 != null && this.field2852 != null && this.field2852.get(class210.field2456) != null) {
			class210 var3 = class210.method4099(var1.field1472);
			if (var3 == null) {
				return null;
			} else {
				class376 var4 = (class376)this.field2852.get(var3);
				if (var4 == null) {
					return null;
				} else {
					int var5 = var4.method6869(var1.field1470, 1000000);
					String[] var6 = new String[var5];
					var4.method6909(var1.field1470, (int[])null, var6);
					int var7 = var6.length * var4.field4435 / 2;
					int var8 = 0;
					String[] var9 = var6;

					for (int var10 = 0; var10 < var9.length; ++var10) {
						String var11 = var9[var10];
						int var12 = var4.method6894(var11);
						if (var12 > var8) {
							var8 = var12;
						}
					}

					return new class260(var1.field1470, var8, var7, var3);
				}
			}
		} else {
			return null;
		}
	}

	List method4765(int var1, int var2, int var3, int var4, int var5) {
		LinkedList var7 = new LinkedList();
		if (var4 >= var1 && var5 >= var2) {
			if (var4 < var1 + var3 && var5 < var2 + var3) {
				Iterator var8 = this.field2851.values().iterator();

				class251 var9;
				while (var8.hasNext()) {
					var9 = (class251)var8.next();
					if (var9.method5014() && var9.method5029(var4, var5)) {
						var7.add(var9);
					}
				}

				var8 = this.field2850.iterator();

				while (var8.hasNext()) {
					var9 = (class251)var8.next();
					if (var9.method5014() && var9.method5029(var4, var5)) {
						var7.add(var9);
					}
				}

				return var7;
			} else {
				return var7;
			}
		} else {
			return var7;
		}
	}

	List method4766() {
		LinkedList var2 = new LinkedList();
		var2.addAll(this.field2850);
		var2.addAll(this.field2851.values());
		return var2;
	}

	void method4767(int var1, int var2, int var3, int var4) {
		var3 %= 4;
		if (var3 == 0) {
			class481.method8667(var1 * this.field2849, this.field2849 * (63 - var2), this.field2849, var4);
		}

		if (var3 == 1) {
			class481.method8666(this.field2849 * var1, (63 - var2) * this.field2849, this.field2849, var4);
		}

		if (var3 == 2) {
			class481.method8667(this.field2849 + this.field2849 * var1 - 1, this.field2849 * (63 - var2), this.field2849, var4);
		}

		if (var3 == 3) {
			class481.method8666(this.field2849 * var1, this.field2849 + this.field2849 * (63 - var2) - 1, this.field2849, var4);
		}

	}
}
