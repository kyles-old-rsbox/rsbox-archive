import client.Client;

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
		if (var0 == CS2Opcodes.MES) {
			var4 = class57.field405[--class126.field1220];
			class42.method773(0, "", var4);
			return 1;
		} else if (var0 == CS2Opcodes.ANIM) {
			class387.field4452 -= 2;
			class442.method7921(class291.field3364, class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
			return 1;
		} else if (var0 == CS2Opcodes.IF_CLOSE) {
			if (!class57.field411) {
				class57.field410 = true;
			}

			return 1;
		} else {
			int var11;
			if (var0 == CS2Opcodes.RESUME_COUNTDIALOG) {
				var4 = class57.field405[--class126.field1220];
				var11 = 0;
				if (class246.method4930(var4)) {
					var11 = class359.method1905(var4);
				}

				class263 var13 = class185.method3435(class274.field3075, Client.field1778.field1071);
				var13.field2984.method8241(var11);
				Client.field1778.method2078(var13);
				return 1;
			} else {
				class263 var16;
				if (var0 == CS2Opcodes.RESUME_NAMEDIALOG) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3105, Client.field1778.field1071);
					var16.field2984.method8104(var4.length() + 1);
					var16.field2984.method8111(var4);
					Client.field1778.method2078(var16);
					return 1;
				} else if (var0 == CS2Opcodes.RESUME_STRINGDIALOG) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3137, Client.field1778.field1071);
					var16.field2984.method8104(var4.length() + 1);
					var16.field2984.method8111(var4);
					Client.field1778.method2078(var16);
					return 1;
				} else {
					int var9;
					String var15;
					if (var0 == CS2Opcodes.OPPLAYER) {
						var9 = class57.field404[--class387.field4452];
						var15 = class57.field405[--class126.field1220];
						class96.method1959(var9, var15);
						return 1;
					} else if (var0 == CS2Opcodes.IF_DRAGPICKUP) {
						class387.field4452 -= 3;
						var9 = class57.field404[class387.field4452];
						var11 = class57.field404[1 + class387.field4452];
						int var10 = class57.field404[2 + class387.field4452];
						class300 var14 = class282.method5426(var10);
						class311.method6051(var14, var9, var11);
						return 1;
					} else if (var0 == CS2Opcodes.CC_DRAGPICKUP) {
						class387.field4452 -= 2;
						var9 = class57.field404[class387.field4452];
						var11 = class57.field404[class387.field4452 + 1];
						class300 var12 = var2 ? class138.field1284 : class153.field1414;
						class311.method6051(var12, var9, var11);
						return 1;
					} else if (var0 == CS2Opcodes.SETMOUSECAM) {
						class95.field944 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.GETREMOVEROOFS) {
						class57.field404[++class387.field4452 - 1] = class413.field4575.method1777() ? 1 : 0;
						return 1;
					} else if (var0 == CS2Opcodes.SETREMOVEROOFS) {
						class413.field4575.method1703(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == CS2Opcodes.OPENURL) {
						var4 = class57.field405[--class126.field1220];
						boolean var5 = class57.field404[--class387.field4452] == 1;
						class115.method2229(var4, var5, false);
						return 1;
					} else if (var0 == CS2Opcodes.RESUME_OBJDIALOG) {
						var9 = class57.field404[--class387.field4452];
						var16 = class185.method3435(class274.field3124, Client.field1778.field1071);
						var16.field2984.method8181(var9);
						Client.field1778.method2078(var16);
						return 1;
					} else if (var0 == CS2Opcodes.BUG_REPORT) {
						var9 = class57.field404[--class387.field4452];
						class126.field1220 -= 2;
						var15 = class57.field405[class126.field1220];
						String var6 = class57.field405[1 + class126.field1220];
						if (var15.length() > 500) {
							return 1;
						} else if (var6.length() > 500) {
							return 1;
						} else {
							class263 var7 = class185.method3435(class274.field3108, Client.field1778.field1071);
							var7.field2984.method8181(1 + class460.method1887(var15) + class460.method1887(var6));
							var7.field2984.method8111(var6);
							var7.field2984.method8264(var9);
							var7.field2984.method8111(var15);
							Client.field1778.method2078(var7);
							return 1;
						}
					} else if (var0 == CS2Opcodes.SETSHIFTCLICKDROP) {
						Client.field1648 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWMOUSEOVERTEXT) {
						Client.field1797 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.RENDERSELF) {
						Client.field1739 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes._3120) {
						if (class57.field404[--class387.field4452] == 1) {
							Client.field1768 |= 1;
						} else {
							Client.field1768 &= -2;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3121) {
						if (class57.field404[--class387.field4452] == 1) {
							Client.field1768 |= 2;
						} else {
							Client.field1768 &= -3;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3122) {
						if (class57.field404[--class387.field4452] == 1) {
							Client.field1768 |= 4;
						} else {
							Client.field1768 &= -5;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3123) {
						if (class57.field404[--class387.field4452] == 1) {
							Client.field1768 |= 8;
						} else {
							Client.field1768 &= -9;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3124) {
						Client.field1768 = 0;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWMOUSECROSS) {
						Client.field1752 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWLOADINGMESSAGES) {
						Client.field1762 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETTAPTODROP) {
						Client.method8647(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == CS2Opcodes.GETTAPTODROP) {
						class57.field404[++class387.field4452 - 1] = Client.method4477() ? 1 : 0;
						return 1;
					} else if (var0 == CS2Opcodes._3129) {
						class387.field4452 -= 2;
						Client.field1727 = class57.field404[class387.field4452];
						Client.field1767 = class57.field404[1 + class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3130) {
						class387.field4452 -= 2;
						return 1;
					} else if (var0 == CS2Opcodes._3131) {
						--class387.field4452;
						return 1;
					} else if (var0 == CS2Opcodes.GETCANVASSIZE) {
						class57.field404[++class387.field4452 - 1] = class31.field193;
						class57.field404[++class387.field4452 - 1] = class12.field57;
						return 1;
					} else if (var0 == CS2Opcodes.MOBILE_SETFPS) {
						--class387.field4452;
						return 1;
					} else if (var0 == CS2Opcodes.MOBILE_OPENSTORE) {
						return 1;
					} else if (var0 == CS2Opcodes.MOBILE_OPENSTORECATEGORY) {
						class387.field4452 -= 2;
						return 1;
					} else if (var0 == CS2Opcodes._3136) {
						Client.field1811 = 3;
						Client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3137) {
						Client.field1811 = 2;
						Client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3138) {
						Client.field1811 = 0;
						return 1;
					} else if (var0 == CS2Opcodes._3139) {
						Client.field1811 = 1;
						return 1;
					} else if (var0 == CS2Opcodes._3140) {
						Client.field1811 = 3;
						Client.field1898 = var2 ? class138.field1284.field3517 : class153.field1414.field3517;
						return 1;
					} else {
						boolean var17;
						if (var0 == CS2Opcodes.SETHIDEUSERNAME) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.field4575.method1755(var17);
							return 1;
						} else if (var0 == CS2Opcodes.GETHIDEUSERNAME) {
							class57.field404[++class387.field4452 - 1] = class413.field4575.method1706() ? 1 : 0;
							return 1;
						} else if (var0 == CS2Opcodes.SETREMEMBERUSERNAME) {
							var17 = class57.field404[--class387.field4452] == 1;
							Client.field1891 = var17;
							if (!var17) {
								class413.field4575.method1710("");
							}

							return 1;
						} else if (var0 == CS2Opcodes.GETREMEMBERUSERNAME) {
							class57.field404[++class387.field4452 - 1] = Client.field1891 ? 1 : 0;
							return 1;
						} else if (var0 == CS2Opcodes.SHOW_IOS_REVIEW) {
							return 1;
						} else if (var0 == CS2Opcodes.SETTITLEMUSICDISABLED) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.field4575.method1707(!var17);
							return 1;
						} else if (var0 == CS2Opcodes.GETTITLEMUSICDISABLED) {
							class57.field404[++class387.field4452 - 1] = class413.field4575.method1708() ? 0 : 1;
							return 1;
						} else if (var0 == CS2Opcodes._3148) {
							return 1;
						} else if (var0 == CS2Opcodes._3149) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3150) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3151) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3152) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3153) {
							class57.field404[++class387.field4452 - 1] = class75.field622;
							return 1;
						} else if (var0 == CS2Opcodes._3154) {
							class57.field404[++class387.field4452 - 1] = class28.method399();
							return 1;
						} else if (var0 == CS2Opcodes._3155) {
							--class126.field1220;
							return 1;
						} else if (var0 == CS2Opcodes._3156) {
							return 1;
						} else if (var0 == CS2Opcodes._3157) {
							class387.field4452 -= 2;
							return 1;
						} else if (var0 == CS2Opcodes._3158) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3159) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3160) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3161) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3162) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3163) {
							--class126.field1220;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3164) {
							--class387.field4452;
							class57.field405[++class126.field1220 - 1] = "";
							return 1;
						} else if (var0 == CS2Opcodes._3165) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3166) {
							class387.field4452 -= 2;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3167) {
							class387.field4452 -= 2;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3168) {
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
						} else if (var0 == CS2Opcodes._3169) {
							return 1;
						} else if (var0 == CS2Opcodes.LOCAL_NOTIFICATION) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3171) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3172) {
							--class387.field4452;
							return 1;
						} else if (var0 == CS2Opcodes._3173) {
							--class387.field4452;
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3174) {
							--class387.field4452;
							return 1;
						} else if (var0 == CS2Opcodes._3175) {
							class57.field404[++class387.field4452 - 1] = 0;
							return 1;
						} else if (var0 == CS2Opcodes._3176) {
							return 1;
						} else if (var0 == CS2Opcodes._3177) {
							return 1;
						} else if (var0 == CS2Opcodes._3178) {
							--class126.field1220;
							return 1;
						} else if (var0 == CS2Opcodes._3179) {
							return 1;
						} else if (var0 == CS2Opcodes._3180) {
							--class126.field1220;
							return 1;
						} else if (var0 == CS2Opcodes.SETBRIGHTNESS) {
							Client.method4524(class57.field404[--class387.field4452]);
							return 1;
						} else if (var0 == CS2Opcodes.GETBRIGHTNESS) {
							class57.field404[++class387.field4452 - 1] = Client.method6543();
							return 1;
						} else if (var0 == CS2Opcodes._3189) {
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
		if (class413.field4575.method1752() != 0 && var1 != 0 && Client.field1894 < 50) {
			Client.field1895[Client.field1894] = var0;
			Client.field1896[Client.field1894] = var1;
			Client.field1897[Client.field1894] = var2;
			Client.field1899[Client.field1894] = null;
			Client.field1734[Client.field1894] = 0;
			++Client.field1894;
		}

	}

	static int method5217(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.VIEWPORT_SETFOV) {
			class387.field4452 -= 2;
			Client.field1907 = (short)class57.method6050(class57.field404[class387.field4452]);
			if (Client.field1907 <= 0) {
				Client.field1907 = 256;
			}

			Client.field1792 = (short)class57.method6050(class57.field404[1 + class387.field4452]);
			if (Client.field1792 <= 0) {
				Client.field1792 = 256;
			}

			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_SETZOOM) {
			class387.field4452 -= 2;
			Client.field1909 = (short)class57.field404[class387.field4452];
			if (Client.field1909 <= 0) {
				Client.field1909 = 256;
			}

			Client.field1801 = (short)class57.field404[class387.field4452 + 1];
			if (Client.field1801 <= 0) {
				Client.field1801 = 320;
			}

			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_CLAMPFOV) {
			class387.field4452 -= 4;
			Client.field1744 = (short)class57.field404[class387.field4452];
			if (Client.field1744 <= 0) {
				Client.field1744 = 1;
			}

			Client.field1912 = (short)class57.field404[1 + class387.field4452];
			if (Client.field1912 <= 0) {
				Client.field1912 = 32767;
			} else if (Client.field1912 < Client.field1744) {
				Client.field1912 = Client.field1744;
			}

			Client.field1705 = (short)class57.field404[2 + class387.field4452];
			if (Client.field1705 <= 0) {
				Client.field1705 = 1;
			}

			Client.field1914 = (short)class57.field404[class387.field4452 + 3];
			if (Client.field1914 <= 0) {
				Client.field1914 = 32767;
			} else if (Client.field1914 < Client.field1705) {
				Client.field1914 = Client.field1705;
			}

			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.field1821 != null) {
				class42.method795(0, 0, Client.field1821.field3448, Client.field1821.field3476, false);
				class57.field404[++class387.field4452 - 1] = Client.field1917;
				class57.field404[++class387.field4452 - 1] = Client.field1678;
			} else {
				class57.field404[++class387.field4452 - 1] = -1;
				class57.field404[++class387.field4452 - 1] = -1;
			}

			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETZOOM) {
			class57.field404[++class387.field4452 - 1] = Client.field1909;
			class57.field404[++class387.field4452 - 1] = Client.field1801;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETFOV) {
			class57.field404[++class387.field4452 - 1] = class57.method2667(Client.field1907);
			class57.field404[++class387.field4452 - 1] = class57.method2667(Client.field1792);
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETX) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETY) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETWIDTH) {
			class57.field404[++class387.field4452 - 1] = class31.field193;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETHEIGHT) {
			class57.field404[++class387.field4452 - 1] = class12.field57;
			return 1;
		} else {
			return 2;
		}
	}
}
