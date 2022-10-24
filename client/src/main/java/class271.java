public class class271 {
	public static final class271 field3018;
	public static final class271 field3019;
	public static final class271 field3020;
	public static final class271 field3021;
	public static final class271 field3022;
	public static final class271 field3023;
	public static final class271 field3024;
	public static final class271 field3025;
	public static final class271 field3026;
	public static final class271 field3028;
	public static final class271 field3029;
	public static final class271 field3030;
	public static final class271 field3031;
	public static final class271 field3033;
	static String field3032;

	static {
		field3021 = new class271();
		field3019 = new class271();
		field3020 = new class271();
		field3028 = new class271();
		field3022 = new class271();
		field3023 = new class271();
		field3018 = new class271();
		field3031 = new class271();
		field3026 = new class271();
		field3025 = new class271();
		field3024 = new class271();
		field3029 = new class271();
		field3030 = new class271();
		field3033 = new class271();
	}

	public static class271[] method1667() {
		return new class271[]{field3021, field3019, field3020, field3028, field3022, field3023, field3018, field3031, field3026, field3025, field3024, field3029, field3030, field3033};
	}

	class271() {
	}

	static int method5211(int var0, class78 var1, boolean var2) {
		String var4;
		if (3100 == var0) {
			var4 = class57.field405[--class126.field1220];
			class42.method773(0, "", var4);
			return 1;
		} else if (var0 == 3101) {
			class387.field4452 -= 2;
			class442.method7921(class291.field3364, class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
			return 1;
		} else if (var0 == 3103) {
			if (!class57.field411) {
				class57.field410 = true;
			}

			return 1;
		} else {
			int var11;
			if (3104 == var0) {
				var4 = class57.field405[--class126.field1220];
				var11 = 0;
				if (class246.method4930(var4)) {
					var11 = class359.method1905(var4);
				}

				class263 var13 = class185.method3435(class274.field3075, client.field1778.field1071);
				var13.field2984.method8241(var11);
				client.field1778.method2078(var13);
				return 1;
			} else {
				class263 var16;
				if (3105 == var0) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3105, client.field1778.field1071);
					var16.field2984.method8104(var4.length() + 1);
					var16.field2984.method8111(var4);
					client.field1778.method2078(var16);
					return 1;
				} else if (3106 == var0) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3137, client.field1778.field1071);
					var16.field2984.method8104(var4.length() + 1);
					var16.field2984.method8111(var4);
					client.field1778.method2078(var16);
					return 1;
				} else {
					int var9;
					String var15;
					if (3107 == var0) {
						var9 = class57.field404[--class387.field4452];
						var15 = class57.field405[--class126.field1220];
						class96.method1959(var9, var15);
						return 1;
					} else if (3108 == var0) {
						class387.field4452 -= 3;
						var9 = class57.field404[class387.field4452];
						var11 = class57.field404[1 + class387.field4452];
						int var10 = class57.field404[2 + class387.field4452];
						class300 var14 = class282.method5426(var10);
						class311.method6051(var14, var9, var11);
						return 1;
					} else if (3109 == var0) {
						class387.field4452 -= 2;
						var9 = class57.field404[class387.field4452];
						var11 = class57.field404[class387.field4452 + 1];
						class300 var12 = var2 ? class138.field1284 : class153.field1414;
						class311.method6051(var12, var9, var11);
						return 1;
					} else if (var0 == 3110) {
						class95.field944 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3111) {
						class57.field404[++class387.field4452 - 1] = class413.field4575.method1777() ? 1 : 0;
						return 1;
					} else if (3112 == var0) {
						class413.field4575.method1703(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == 3113) {
						var4 = class57.field405[--class126.field1220];
						boolean var5 = class57.field404[--class387.field4452] == 1;
						class115.method2229(var4, var5, false);
						return 1;
					} else if (3115 == var0) {
						var9 = class57.field404[--class387.field4452];
						var16 = class185.method3435(class274.field3124, client.field1778.field1071);
						var16.field2984.method8181(var9);
						client.field1778.method2078(var16);
						return 1;
					} else if (var0 == 3116) {
						var9 = class57.field404[--class387.field4452];
						class126.field1220 -= 2;
						var15 = class57.field405[class126.field1220];
						String var6 = class57.field405[1 + class126.field1220];
						if (var15.length() > 500) {
							return 1;
						} else if (var6.length() > 500) {
							return 1;
						} else {
							class263 var7 = class185.method3435(class274.field3108, client.field1778.field1071);
							var7.field2984.method8181(1 + class460.method1887(var15) + class460.method1887(var6));
							var7.field2984.method8111(var6);
							var7.field2984.method8264(var9);
							var7.field2984.method8111(var15);
							client.field1778.method2078(var7);
							return 1;
						}
					} else if (3117 == var0) {
						client.field1648 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3118) {
						client.field1797 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3119) {
						client.field1739 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3120) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 1;
						} else {
							client.field1768 &= -2;
						}

						return 1;
					} else if (3121 == var0) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 2;
						} else {
							client.field1768 &= -3;
						}

						return 1;
					} else if (3122 == var0) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 4;
						} else {
							client.field1768 &= -5;
						}

						return 1;
					} else if (3123 == var0) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 8;
						} else {
							client.field1768 &= -9;
						}

						return 1;
					} else if (3124 == var0) {
						client.field1768 = 0;
						return 1;
					} else if (3125 == var0) {
						client.field1752 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3126) {
						client.field1762 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == 3127) {
						client.method8647(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == 3128) {
						class57.field404[++class387.field4452 - 1] = client.method4477() ? 1 : 0;
						return 1;
					} else if (3129 == var0) {
						class387.field4452 -= 2;
						client.field1727 = class57.field404[class387.field4452];
						client.field1767 = class57.field404[1 + class387.field4452];
						return 1;
					} else if (var0 == 3130) {
						class387.field4452 -= 2;
						return 1;
					} else if (3131 == var0) {
						--class387.field4452;
						return 1;
					} else if (3132 == var0) {
						class57.field404[++class387.field4452 - 1] = class31.field193;
						class57.field404[++class387.field4452 - 1] = class12.field57;
						return 1;
					} else if (3133 == var0) {
						--class387.field4452;
						return 1;
					} else if (3134 == var0) {
						return 1;
					} else if (var0 == 3135) {
						class387.field4452 -= 2;
						return 1;
					} else if (3136 == var0) {
						client.field1811 = 3;
						client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == 3137) {
						client.field1811 = 2;
						client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == 3138) {
						client.field1811 = 0;
						return 1;
					} else if (var0 == 3139) {
						client.field1811 = 1;
						return 1;
					} else if (3140 == var0) {
						client.field1811 = 3;
						client.field1898 = var2 ? -1917711801 * class138.field1284.field3517 * 633110391 : class153.field1414.field3517 * 633110391 * -1917711801;
						return 1;
					} else {
						boolean var17;
						if (var0 == 3141) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.field4575.method1755(var17);
							return 1;
						} else if (3142 == var0) {
							class57.field404[++class387.field4452 - 1] = class413.field4575.method1706() ? 1 : 0;
							return 1;
						} else if (3143 == var0) {
							var17 = class57.field404[--class387.field4452] == 1;
							client.field1891 = var17;
							if (!var17) {
								class413.field4575.method1710("");
							}

							return 1;
						} else if (3144 == var0) {
							class57.field404[++class387.field4452 - 1] = client.field1891 ? 1 : 0;
							return 1;
						} else if (var0 == 3145) {
							return 1;
						} else if (3146 == var0) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.field4575.method1707(!var17);
							return 1;
						} else if (var0 == 3147) {
							class57.field404[++class387.field4452 - 1] = class413.field4575.method1708() ? 0 : 1;
							return 1;
						} else if (3148 == var0) {
							return 1;
						} else if (3149 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3150 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3151 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3152 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3153) {
							class57.field404[++class387.field4452 - 1] = class75.field622;
							return 1;
						} else if (var0 == 3154) {
							class57.field404[++class387.field4452 - 1] = class28.method399();
							return 1;
						} else if (3155 == var0) {
							--class126.field1220;
							return 1;
						} else if (var0 == 3156) {
							return 1;
						} else if (var0 == 3157) {
							class387.field4452 -= 2;
							return 1;
						} else if (var0 == 3158) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3159) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3160) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3161 == var0) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3162 == var0) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3163) {
							--class126.field1220;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3164) {
							--class387.field4452;
							class57.field405[++class126.field1220 - 1] = "";
							return 1;
						} else if (3165 == var0) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3166 == var0) {
							class387.field4452 -= 2;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3167) {
							class387.field4452 -= 2;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3168) {
							class387.field4452 -= 2;
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							return 1;
						} else if (3169 == var0) {
							return 1;
						} else if (3170 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3171 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == 3172) {
							--class387.field4452;
							return 1;
						} else if (3173 == var0) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3174 == var0) {
							--class387.field4452;
							return 1;
						} else if (3175 == var0) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (3176 == var0) {
							return 1;
						} else if (var0 == 3177) {
							return 1;
						} else if (var0 == 3178) {
							--class126.field1220;
							return 1;
						} else if (3179 == var0) {
							return 1;
						} else if (3180 == var0) {
							--class126.field1220;
							return 1;
						} else if (var0 == 3181) {
							client.method4524(class57.field404[--class387.field4452]);
							return 1;
						} else if (var0 == 3182) {
							class57.field404[++class387.field4452 - 1] = client.method6543();
							return 1;
						} else if (var0 == 3189) {
							var9 = class57.field404[--class387.field4452];
							class189 var8 = class160.method2660(var9);
							if (var8.method3486()) {
								class195.method3594(var8.field1994);
							}

							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		}
	}

	static void method5212(int var0, int var1, int var2) {
		if (class413.field4575.method1752() != 0 && 0 != var1 && client.field1894 < 50) {
			client.field1895[client.field1894] = var0;
			client.field1896[client.field1894] = var1;
			client.field1897[client.field1894] = var2;
			client.field1899[client.field1894] = null;
			client.field1734[client.field1894] = 0;
			++client.field1894;
		}

	}

	static int method5217(int var0, class78 var1, boolean var2) {
		if (6200 == var0) {
			class387.field4452 -= 2;
			client.field1907 = (short)class57.method6050(class57.field404[class387.field4452]);
			if (client.field1907 <= 0) {
				client.field1907 = 256;
			}

			client.field1792 = (short)class57.method6050(class57.field404[1 + class387.field4452]);
			if (client.field1792 <= 0) {
				client.field1792 = 256;
			}

			return 1;
		} else if (6201 == var0) {
			class387.field4452 -= 2;
			client.field1909 = (short)class57.field404[class387.field4452];
			if (client.field1909 <= 0) {
				client.field1909 = 256;
			}

			client.field1801 = (short)class57.field404[class387.field4452 + 1];
			if (client.field1801 <= 0) {
				client.field1801 = 320;
			}

			return 1;
		} else if (var0 == 6202) {
			class387.field4452 -= 4;
			client.field1744 = (short)class57.field404[class387.field4452];
			if (client.field1744 <= 0) {
				client.field1744 = 1;
			}

			client.field1912 = (short)class57.field404[1 + class387.field4452];
			if (client.field1912 <= 0) {
				client.field1912 = 32767;
			} else if (client.field1912 < client.field1744) {
				client.field1912 = client.field1744;
			}

			client.field1705 = (short)class57.field404[2 + class387.field4452];
			if (client.field1705 <= 0) {
				client.field1705 = 1;
			}

			client.field1914 = (short)class57.field404[class387.field4452 + 3];
			if (client.field1914 <= 0) {
				client.field1914 = 32767;
			} else if (client.field1914 < client.field1705) {
				client.field1914 = client.field1705;
			}

			return 1;
		} else if (var0 == 6203) {
			if (client.field1821 != null) {
				class42.method795(0, 0, client.field1821.field3448, client.field1821.field3476, false);
				class57.field404[++class387.field4452 - 1] = client.field1917;
				class57.field404[++class387.field4452 - 1] = client.field1678;
			} else {
				class57.field404[++class387.field4452 - 1] = -1;
				class57.field404[++class387.field4452 - 1] = -1;
			}

			return 1;
		} else if (6204 == var0) {
			class57.field404[++class387.field4452 - 1] = client.field1909;
			class57.field404[++class387.field4452 - 1] = client.field1801;
			return 1;
		} else if (var0 == 6205) {
			class57.field404[++class387.field4452 - 1] = class57.method2667(client.field1907);
			class57.field404[++class387.field4452 - 1] = class57.method2667(client.field1792);
			return 1;
		} else if (var0 == 6220) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			class57.field404[++class387.field4452 - 1] = class31.field193;
			return 1;
		} else if (6223 == var0) {
			class57.field404[++class387.field4452 - 1] = class12.field57;
			return 1;
		} else {
			return 2;
		}
	}
}
