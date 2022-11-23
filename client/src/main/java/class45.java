public class class45 {
	public static class350 field329;
	public static String field328;

	static {
		field329 = new class350();
	}

	class45() throws Throwable {
		throw new Error();
	}

	public static void method333() {
		field329 = new class350();
	}

	static int method952(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_FIND_LISTENED) {
			if (class127.field1224 != null) {
				class57.field404[++class387.field4452 - 1] = 1;
				class12.field55 = class127.field1224;
			} else {
				class57.field404[++class387.field4452 - 1] = 0;
			}

			return 1;
		} else {
			int var4;
			if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_FIND_AFFINED) {
				var4 = class57.field404[--class387.field4452];
				if (client.field1738[var4] != null) {
					class57.field404[++class387.field4452 - 1] = 1;
					class12.field55 = client.field1738[var4];
				} else {
					class57.field404[++class387.field4452 - 1] = 0;
				}

				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETCLANNAME) {
				class57.field405[++class126.field1220 - 1] = class12.field55.field1372;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETALLOWUNAFFINED) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1364 ? 1 : 0;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETRANKTALK) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1367;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETRANKKICK) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1357;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETRANKLOOTSHARE) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1377;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETCOINSHARE) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1368;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDCOUNT) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1369;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDDISPLAYNAME) {
				var4 = class57.field404[--class387.field4452];
				class57.field405[++class126.field1220 - 1] = class12.field55.field1373[var4];
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDRANK) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = class12.field55.field1381[var4];
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETBANNEDCOUNT) {
				class57.field404[++class387.field4452 - 1] = class12.field55.field1378;
				return 1;
			} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETBANNEDDISPLAYNAME) {
				var4 = class57.field404[--class387.field4452];
				class57.field405[++class126.field1220 - 1] = class12.field55.field1371[var4];
				return 1;
			} else {
				int var6;
				int var7;
				if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDEXTRAINFO) {
					class387.field4452 -= 3;
					var4 = class57.field404[class387.field4452];
					var7 = class57.field404[class387.field4452 + 1];
					var6 = class57.field404[2 + class387.field4452];
					class57.field404[++class387.field4452 - 1] = class12.field55.method2562(var4, var7, var6);
					return 1;
				} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETCURRENTOWNER_SLOT) {
					class57.field404[++class387.field4452 - 1] = class12.field55.field1376;
					return 1;
				} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETREPLACEMENTOWNER_SLOT) {
					class57.field404[++class387.field4452 - 1] = class12.field55.field1370;
					return 1;
				} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDSLOT) {
					class57.field404[++class387.field4452 - 1] = class12.field55.method2525(class57.field405[--class126.field1220]);
					return 1;
				} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETSORTEDAFFINEDSLOT) {
					class57.field404[class387.field4452 - 1] = class12.field55.method2528()[class57.field404[class387.field4452 - 1]];
					return 1;
				} else if (var0 == CS2Opcodes.AFFINEDCLANSETTINGS_ADDBANNED_FROMCHANNEL) {
					class387.field4452 -= 2;
					var4 = class57.field404[class387.field4452];
					var7 = class57.field404[1 + class387.field4452];
					class190.method3514(var7, var4);
					return 1;
				} else if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDJOINRUNEDAY) {
					var4 = class57.field404[--class387.field4452];
					class57.field404[++class387.field4452 - 1] = class12.field55.field1374[var4];
					return 1;
				} else {
					if (var0 == CS2Opcodes.AFFINEDCLANSETTINGS_SETMUTED_FROMCHANNEL) {
						class387.field4452 -= 3;
						var4 = class57.field404[class387.field4452];
						boolean var5 = class57.field404[1 + class387.field4452] == 1;
						var6 = class57.field404[2 + class387.field4452];
						class349.method6447(var6, var4, var5);
					}

					if (var0 == CS2Opcodes.ACTIVECLANSETTINGS_GETAFFINEDMUTED) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = class12.field55.field1375[var4] ? 1 : 0;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_FIND_LISTENED) {
						if (null != class188.field1982) {
							class57.field404[++class387.field4452 - 1] = 1;
							class442.field4776 = class188.field1982;
						} else {
							class57.field404[++class387.field4452 - 1] = 0;
						}

						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_FIND_AFFINED) {
						var4 = class57.field404[--class387.field4452];
						if (null != client.field1883[var4]) {
							class57.field404[++class387.field4452 - 1] = 1;
							class442.field4776 = client.field1883[var4];
							class115.field1134 = var4;
						} else {
							class57.field404[++class387.field4452 - 1] = 0;
						}

						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETCLANNAME) {
						class57.field405[++class126.field1220 - 1] = class442.field4776.field1350;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETRANKKICK) {
						class57.field404[++class387.field4452 - 1] = class442.field4776.field1351;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETRANKTALK) {
						class57.field404[++class387.field4452 - 1] = class442.field4776.field1345;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETUSERCOUNT) {
						class57.field404[++class387.field4452 - 1] = class442.field4776.method2512();
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETUSERDISPLAYNAME) {
						var4 = class57.field404[--class387.field4452];
						class57.field405[++class126.field1220 - 1] = ((class133)class442.field4776.field1347.get(var4)).field1254.getName();
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETUSERRANK) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = ((class133)class442.field4776.field1347.get(var4)).field1256;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETUSERWORLD) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = ((class133)class442.field4776.field1347.get(var4)).field1249;
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_KICKUSER) {
						var4 = class57.field404[--class387.field4452];
						class414.method7518(class115.field1134, var4);
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETUSERSLOT) {
						class57.field404[++class387.field4452 - 1] = class442.field4776.method2505(class57.field405[--class126.field1220]);
						return 1;
					} else if (var0 == CS2Opcodes.ACTIVECLANCHANNEL_GETSORTEDUSERSLOT) {
						class57.field404[class387.field4452 - 1] = class442.field4776.method2502()[class57.field404[class387.field4452 - 1]];
						return 1;
					} else if (var0 == CS2Opcodes.CLANPROFILE_FIND) {
						class57.field404[++class387.field4452 - 1] = class174.field1567 != null ? 1 : 0;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	static void method943(int var0) {
		if (var0 == -1 && !client.field1781) {
			class279.field3201.method5365();
			class279.field3202 = 1;
			class7.field29 = null;
		} else if (var0 != -1 && var0 != client.field1748 && class413.clientPreferences.method1716() != 0 && !client.field1781) {
			class336 var2 = class43.field311;
			int var3 = class413.clientPreferences.method1716();
			class279.field3202 = 1;
			class7.field29 = var2;
			class279.field3203 = var0;
			class279.field3204 = 0;
			MessagesManager.field1092 = var3;
			class337.field3889 = false;
			class13.field67 = 2;
		}

		client.field1748 = var0;
	}

	static final boolean method951(int var0) {
		if (var0 < 0) {
			return false;
		} else {
			int var2 = client.field1788[var0];
			if (var2 >= 2000) {
				var2 -= 2000;
			}

			return var2 == 1007;
		}
	}
}
