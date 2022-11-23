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
			MouseManager.method773(0, "", var4);
			return 1;
		} else if (var0 == CS2Opcodes.ANIM) {
			class387.field4452 -= 2;
			class442.method7921(class291.localPlayer, class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
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

				PacketBufferNode var13 = class185.method3435(class274.field3075, client.packetWriter.isaacRandom);
				var13.buffer.writeInt(var11);
				client.packetWriter.add(var13);
				return 1;
			} else {
				PacketBufferNode var16;
				if (var0 == CS2Opcodes.RESUME_NAMEDIALOG) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3105, client.packetWriter.isaacRandom);
					var16.buffer.writeByte(var4.length() + 1);
					var16.buffer.writeString(var4);
					client.packetWriter.add(var16);
					return 1;
				} else if (var0 == CS2Opcodes.RESUME_STRINGDIALOG) {
					var4 = class57.field405[--class126.field1220];
					var16 = class185.method3435(class274.field3137, client.packetWriter.isaacRandom);
					var16.buffer.writeByte(var4.length() + 1);
					var16.buffer.writeString(var4);
					client.packetWriter.add(var16);
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
						class57.field404[++class387.field4452 - 1] = class413.clientPreferences.method1777() ? 1 : 0;
						return 1;
					} else if (var0 == CS2Opcodes.SETREMOVEROOFS) {
						class413.clientPreferences.method1703(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == CS2Opcodes.OPENURL) {
						var4 = class57.field405[--class126.field1220];
						boolean var5 = class57.field404[--class387.field4452] == 1;
						class115.method2229(var4, var5, false);
						return 1;
					} else if (var0 == CS2Opcodes.RESUME_OBJDIALOG) {
						var9 = class57.field404[--class387.field4452];
						var16 = class185.method3435(class274.field3124, client.packetWriter.isaacRandom);
						var16.buffer.writeShort(var9);
						client.packetWriter.add(var16);
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
							PacketBufferNode var7 = class185.method3435(class274.field3108, client.packetWriter.isaacRandom);
							var7.buffer.writeShort(1 + Buffer.method1887(var15) + Buffer.method1887(var6));
							var7.buffer.writeString(var6);
							var7.buffer.method8264(var9);
							var7.buffer.writeString(var15);
							client.packetWriter.add(var7);
							return 1;
						}
					} else if (var0 == CS2Opcodes.SETSHIFTCLICKDROP) {
						client.field1648 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWMOUSEOVERTEXT) {
						client.field1797 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.RENDERSELF) {
						client.field1739 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes._3120) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 1;
						} else {
							client.field1768 &= -2;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3121) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 2;
						} else {
							client.field1768 &= -3;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3122) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 4;
						} else {
							client.field1768 &= -5;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3123) {
						if (class57.field404[--class387.field4452] == 1) {
							client.field1768 |= 8;
						} else {
							client.field1768 &= -9;
						}

						return 1;
					} else if (var0 == CS2Opcodes._3124) {
						client.field1768 = 0;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWMOUSECROSS) {
						client.field1752 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETSHOWLOADINGMESSAGES) {
						client.field1762 = class57.field404[--class387.field4452] == 1;
						return 1;
					} else if (var0 == CS2Opcodes.SETTAPTODROP) {
						client.method8647(class57.field404[--class387.field4452] == 1);
						return 1;
					} else if (var0 == CS2Opcodes.GETTAPTODROP) {
						class57.field404[++class387.field4452 - 1] = client.method4477() ? 1 : 0;
						return 1;
					} else if (var0 == CS2Opcodes._3129) {
						class387.field4452 -= 2;
						client.field1727 = class57.field404[class387.field4452];
						client.field1767 = class57.field404[1 + class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3130) {
						class387.field4452 -= 2;
						return 1;
					} else if (var0 == CS2Opcodes._3131) {
						--class387.field4452;
						return 1;
					} else if (var0 == CS2Opcodes.GETCANVASSIZE) {
						class57.field404[++class387.field4452 - 1] = class31.canvasWidth;
						class57.field404[++class387.field4452 - 1] = class12.canvasHeight;
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
						client.field1811 = 3;
						client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3137) {
						client.field1811 = 2;
						client.field1898 = class57.field404[--class387.field4452];
						return 1;
					} else if (var0 == CS2Opcodes._3138) {
						client.field1811 = 0;
						return 1;
					} else if (var0 == CS2Opcodes._3139) {
						client.field1811 = 1;
						return 1;
					} else if (var0 == CS2Opcodes._3140) {
						client.field1811 = 3;
						client.field1898 = var2 ? class138.field1284.field3517 : class153.field1414.field3517;
						return 1;
					} else {
						boolean var17;
						if (var0 == CS2Opcodes.SETHIDEUSERNAME) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.clientPreferences.method1755(var17);
							return 1;
						} else if (var0 == CS2Opcodes.GETHIDEUSERNAME) {
							class57.field404[++class387.field4452 - 1] = class413.clientPreferences.method1706() ? 1 : 0;
							return 1;
						} else if (var0 == CS2Opcodes.SETREMEMBERUSERNAME) {
							var17 = class57.field404[--class387.field4452] == 1;
							client.isUsernameRemembered = var17;
							if (!var17) {
								class413.clientPreferences.setRememberedUsername("");
							}

							return 1;
						} else if (var0 == CS2Opcodes.GETREMEMBERUSERNAME) {
							class57.field404[++class387.field4452 - 1] = client.isUsernameRemembered ? 1 : 0;
							return 1;
						} else if (var0 == CS2Opcodes.SHOW_IOS_REVIEW) {
							return 1;
						} else if (var0 == CS2Opcodes.SETTITLEMUSICDISABLED) {
							var17 = class57.field404[--class387.field4452] == 1;
							class413.clientPreferences.method1707(!var17);
							return 1;
						} else if (var0 == CS2Opcodes.GETTITLEMUSICDISABLED) {
							class57.field404[++class387.field4452 - 1] = class413.clientPreferences.method1708() ? 0 : 1;
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
							class57.field404[++class387.field4452 - 1] = Login.field622;
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
							client.method4524(class57.field404[--class387.field4452]);
							return 1;
						} else if (var0 == CS2Opcodes.GETBRIGHTNESS) {
							class57.field404[++class387.field4452 - 1] = client.method6543();
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
		if (class413.clientPreferences.method1752() != 0 && var1 != 0 && client.soundEffectCount < 50) {
			client.field1895[client.soundEffectCount] = var0;
			client.field1896[client.soundEffectCount] = var1;
			client.field1897[client.soundEffectCount] = var2;
			client.field1899[client.soundEffectCount] = null;
			client.field1734[client.soundEffectCount] = 0;
			++client.soundEffectCount;
		}

	}

	static int method5217(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.VIEWPORT_SETFOV) {
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
		} else if (var0 == CS2Opcodes.VIEWPORT_SETZOOM) {
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
		} else if (var0 == CS2Opcodes.VIEWPORT_CLAMPFOV) {
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
		} else if (var0 == CS2Opcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (client.field1821 != null) {
				MouseManager.method795(0, 0, client.field1821.field3448, client.field1821.field3476, false);
				class57.field404[++class387.field4452 - 1] = client.field1917;
				class57.field404[++class387.field4452 - 1] = client.field1678;
			} else {
				class57.field404[++class387.field4452 - 1] = -1;
				class57.field404[++class387.field4452 - 1] = -1;
			}

			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETZOOM) {
			class57.field404[++class387.field4452 - 1] = client.field1909;
			class57.field404[++class387.field4452 - 1] = client.field1801;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETFOV) {
			class57.field404[++class387.field4452 - 1] = class57.method2667(client.field1907);
			class57.field404[++class387.field4452 - 1] = class57.method2667(client.field1792);
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETX) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETY) {
			class57.field404[++class387.field4452 - 1] = 0;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETWIDTH) {
			class57.field404[++class387.field4452 - 1] = class31.canvasWidth;
			return 1;
		} else if (var0 == CS2Opcodes.VIEWPORT_GETHEIGHT) {
			class57.field404[++class387.field4452 - 1] = class12.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
