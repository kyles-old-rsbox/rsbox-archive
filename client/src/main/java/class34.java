import java.util.Arrays;

public class class34 {
	int[] field216;
	int[] field219;

	public class34() {
		this.field216 = new int[112];
		this.field219 = new int[192];
		Arrays.fill(this.field216, 3);
		Arrays.fill(this.field219, 3);
	}

	public void method615(int var1, int var2) {
		if (this.method623(var1) && this.method625(var2)) {
			this.field216[var1] = var2;
		}

	}

	public void method616(char var1, int var2) {
		if (this.method624(var1) && this.method625(var2)) {
			this.field219[var1] = var2;
		}

	}

	static String method644(Buffer var0, int var1) {
		try {
			int var3 = var0.method8207();
			if (var3 > var1) {
				var3 = var1;
			}

			byte[] var4 = new byte[var3];
			var0.offset += class307.field3673.method6057(var0.data, var0.offset, var4, 0, var3);
			String var5 = class126.method2371(var4, 0, var3);
			return var5;
		} catch (Exception var7) {
			return "Cabbage";
		}
	}

	public int method617(int var1) {
		return this.method623(var1) ? this.field216[var1] : 0;
	}

	public int method618(char var1) {
		return this.method624(var1) ? this.field219[var1] : 0;
	}

	public boolean method619(int var1) {
		return this.method623(var1) && (1 == this.field216[var1] || 3 == this.field216[var1]);
	}

	public boolean method620(char var1) {
		return this.method624(var1) && (1 == this.field219[var1] || 3 == this.field219[var1]);
	}

	public boolean method638(int var1) {
		return this.method623(var1) && (this.field216[var1] == 2 || 3 == this.field216[var1]);
	}

	public boolean method635(char var1) {
		return this.method624(var1) && (this.field219[var1] == 2 || this.field219[var1] == 3);
	}

	boolean method623(int var1) {
		if (var1 >= 0 && var1 < 112) {
			return true;
		} else {
			System.out.println("Invalid keycode: " + var1);
			return false;
		}
	}

	boolean method624(char var1) {
		if (var1 >= 0 && var1 < 192) {
			return true;
		} else {
			System.out.println("Invalid keychar: " + var1);
			return false;
		}
	}

	boolean method625(int var1) {
		if (var1 >= 0 && var1 < 4) {
			return true;
		} else {
			System.out.println("Invalid mode: " + var1);
			return false;
		}
	}

	static void load() {
		int var1;
		if (client.field1793 == 0) {
			class145.field1333 = new Scene(4, 104, 104, class82.field719);

			for (var1 = 0; var1 < 4; ++var1) {
				client.field1884[var1] = new class200(104, 104);
			}

			class309.field3678 = new class473(512, 512);
			Login.field623 = class338.field3905;
			Login.field622 = 5;
			client.field1793 = 20;
		} else if (client.field1793 == 20) {
			Login.field623 = class338.field4119;
			Login.field622 = 10;
			client.field1793 = 30;
		} else if (client.field1793 == 30) {
			class139.field1286 = client.method5506(0, false, true, true, false);
			MouseManager.field295 = client.method5506(1, false, true, true, false);
			class174.field1564 = client.method5506(2, true, false, true, false);
			class333.field3859 = client.method5506(3, false, true, true, false);
			class11.field48 = client.method5506(4, false, true, true, false);
			class58.cache_regionMaps = client.method5506(5, true, true, true, false);
			class43.field311 = client.method5506(6, true, true, true, false);
			class252.field2922 = client.method5506(7, false, true, true, false);
			class155.field1425 = client.method5506(8, false, true, true, false);
			client.field1665 = client.method5506(9, false, true, true, false);
			class243.field2846 = client.method5506(10, false, true, true, false);
			ProofOfWorkRequest.field12 = client.method5506(11, false, true, true, false);
			class202.field2255 = client.method5506(12, false, true, true, false);
			class136.field1275 = client.method5506(13, true, false, true, false);
			class71.field578 = client.method5506(14, false, true, true, false);
			class147.field1352 = client.method5506(15, false, true, true, false);
			class371.field4369 = client.method5506(17, true, true, true, false);
			class324.field3783 = client.method5506(18, false, true, true, false);
			class304.field3634 = client.method5506(19, false, true, true, false);
			class145.field1338 = client.method5506(20, false, true, true, false);
			class255.field2944 = client.method5506(21, false, true, true, true);
			Login.field623 = class338.field3907;
			Login.field622 = 20;
			client.field1793 = 40;
		} else if (40 == client.field1793) {
			byte var37 = 0;
			var1 = var37 + class139.field1286.method6274() * 4 / 100;
			var1 += MouseManager.field295.method6274() * 4 / 100;
			var1 += class174.field1564.method6274() * 2 / 100;
			var1 += class333.field3859.method6274() * 2 / 100;
			var1 += class11.field48.method6274() * 6 / 100;
			var1 += class58.cache_regionMaps.method6274() * 4 / 100;
			var1 += class43.field311.method6274() * 2 / 100;
			var1 += class252.field2922.method6274() * 55 / 100;
			var1 += class155.field1425.method6274() * 2 / 100;
			var1 += client.field1665.method6274() * 2 / 100;
			var1 += class243.field2846.method6274() * 2 / 100;
			var1 += ProofOfWorkRequest.field12.method6274() * 2 / 100;
			var1 += class202.field2255.method6274() * 2 / 100;
			var1 += class136.field1275.method6274() * 2 / 100;
			var1 += class71.field578.method6274() * 2 / 100;
			var1 += class147.field1352.method6274() * 2 / 100;
			var1 += class304.field3634.method6274() / 100;
			var1 += class324.field3783.method6274() / 100;
			var1 += class145.field1338.method6274() / 100;
			var1 += class255.field2944.method6274() / 100;
			var1 += class371.field4369.method6273() && class371.field4369.method6092() ? 1 : 0;
			if (var1 != 100) {
				if (var1 != 0) {
					Login.field623 = class338.field3932 + var1 + "%";
				}

				Login.field622 = 30;
			} else {
				client.method5128(class139.field1286, "Animations");
				client.method5128(MouseManager.field295, "Skeletons");
				client.method5128(class11.field48, "Sound FX");
				client.method5128(class58.cache_regionMaps, "Maps");
				client.method5128(class43.field311, "Music Tracks");
				client.method5128(class252.field2922, "Models");
				client.method5128(class155.field1425, "Sprites");
				client.method5128(ProofOfWorkRequest.field12, "Music Jingles");
				client.method5128(class71.field578, "Music Samples");
				client.method5128(class147.field1352, "Music Patches");
				client.method5128(class304.field3634, "World Map");
				client.method5128(class324.field3783, "World Map Geography");
				client.method5128(class145.field1338, "World Map Ground");
				class179.field1602 = new class408();
				class179.field1602.method7402(class371.field4369);
				Login.field623 = class338.field3909;
				Login.field622 = 30;
				client.field1793 = 45;
			}
		} else if (45 == client.field1793) {
			class174.method2744(22050, !client.isLowDetail, 2);
			class278 var39 = new class278();
			var39.method5296(9, 128);
			class91.field886 = class215.method4334(class31.field169, 0, 22050);
			class91.field886.method398(var39);
			class279.method5005(class147.field1352, class71.field578, class11.field48, var39);
			class88.field794 = class215.method4334(class31.field169, 1, 2048);
			class451.field4849 = new class38();
			class88.field794.method398(class451.field4849);
			class233.field2759 = new class64(22050, class49.field348);
			Login.field623 = class338.field3910;
			Login.field622 = 35;
			client.field1793 = 50;
			class103.field1034 = new class433(class155.field1425, class136.field1275);
		} else if (client.field1793 == 50) {
			var1 = class442.method7918().length;
			client.field1934 = class103.field1034.method7853(class442.method7918());
			if (client.field1934.size() < var1) {
				Login.field623 = class338.field3911 + client.field1934.size() * 100 / var1 + "%";
				Login.field622 = 40;
			} else {
				class346.field4250 = (class376)client.field1934.get(class442.field4779);
				class353.fontPlain12 = (class376)client.field1934.get(class442.field4769);
				class114.field1127 = (class376)client.field1934.get(class442.field4780);
				MoveSpeed.platformInfo = client.field1807.method7886();
				Login.field623 = class338.field4011;
				Login.field622 = 40;
				client.field1793 = 60;
			}
		} else {
			class336 var2;
			class336 var3;
			int var4;
			int var40;
			if (client.field1793 == 60) {
				var2 = class243.field2846;
				var3 = class155.field1425;
				var4 = 0;
				String[] var5 = Login.field649;

				int var6;
				String var36;
				for (var6 = 0; var6 < var5.length; ++var6) {
					var36 = var5[var6];
					if (var2.method6108(var36, "")) {
						++var4;
					}
				}

				var5 = Login.field632;

				for (var6 = 0; var6 < var5.length; ++var6) {
					var36 = var5[var6];
					if (var3.method6108(var36, "")) {
						++var4;
					}
				}

				var40 = Login.field632.length + Login.field649.length;
				if (var4 < var40) {
					Login.field623 = class338.field3913 + var4 * 100 / var40 + "%";
					Login.field622 = 50;
				} else {
					Login.field623 = class338.field4070;
					Login.field622 = 50;
					class9.method64(5);
					client.field1793 = 70;
				}
			} else if (client.field1793 != 70) {
				if (80 == client.field1793) {
					var1 = 0;
					if (class122.field1185 == null) {
						class122.field1185 = class389.method7014(class155.field1425, class179.field1602.field4534, 0);
					} else {
						++var1;
					}

					if (class139.field1292 == null) {
						class139.field1292 = class389.method7014(class155.field1425, class179.field1602.field4535, 0);
					} else {
						++var1;
					}

					if (class91.field883 == null) {
						class91.field883 = class134.method2422(class155.field1425, class179.field1602.field4533, 0);
					} else {
						++var1;
					}

					if (class212.field2488 == null) {
						class212.field2488 = class397.method7205(class155.field1425, class179.field1602.field4536, 0);
					} else {
						++var1;
					}

					if (null == class264.field2999) {
						class264.field2999 = class397.method7205(class155.field1425, class179.field1602.field4537, 0);
					} else {
						++var1;
					}

					if (class176.field1585 == null) {
						class176.field1585 = class397.method7205(class155.field1425, class179.field1602.field4538, 0);
					} else {
						++var1;
					}

					if (class210.field2462 == null) {
						class210.field2462 = class397.method7205(class155.field1425, class179.field1602.field4539, 0);
					} else {
						++var1;
					}

					if (class205.field2326 == null) {
						class205.field2326 = class397.method7205(class155.field1425, class179.field1602.field4540, 0);
					} else {
						++var1;
					}

					if (null == class64.field505) {
						class64.field505 = class397.method7205(class155.field1425, class179.field1602.field4541, 0);
					} else {
						++var1;
					}

					if (class420.field4661 == null) {
						class420.field4661 = class134.method2422(class155.field1425, class179.field1602.field4542, 0);
					} else {
						++var1;
					}

					if (class124.field1199 == null) {
						class124.field1199 = class134.method2422(class155.field1425, class179.field1602.field4543, 0);
					} else {
						++var1;
					}

					if (var1 < 11) {
						Login.field623 = class338.field3917 + var1 * 100 / 12 + "%";
						Login.field622 = 70;
					} else {
						class384.field4438 = class124.field1199;
						class139.field1292.method8477();
						int var34 = (int)(Math.random() * 21.0D) - 10;
						int var35 = (int)(Math.random() * 21.0D) - 10;
						var4 = (int)(Math.random() * 21.0D) - 10;
						var40 = (int)(Math.random() * 41.0D) - 20;
						class91.field883[0].method8754(var34 + var40, var35 + var40, var40 + var4);
						Login.field623 = class338.field4004;
						Login.field622 = 70;
						client.field1793 = 90;
					}
				} else if (90 == client.field1793) {
					if (!client.field1665.method6092()) {
						Login.field623 = class338.field4012 + "0%";
						Login.field622 = 90;
					} else {
						class25.field123 = new class215(client.field1665, class155.field1425, 20, class413.clientPreferences.method1717(), client.isLowDetail ? 64 : 128);
						class221.method4393(class25.field123);
						class221.method4394(class413.clientPreferences.method1717());
						client.field1793 = 100;
					}
				} else if (client.field1793 == 100) {
					var1 = class25.field123.method4306();
					if (var1 < 100) {
						Login.field623 = class338.field4012 + var1 + "%";
						Login.field622 = 90;
					} else {
						Login.field623 = class338.field4172;
						Login.field622 = 90;
						client.field1793 = 110;
					}
				} else if (110 == client.field1793) {
					class74.mouseRecorder = new class84();
					class31.field169.method2731(class74.mouseRecorder, 10);
					Login.field623 = class338.field3921;
					Login.field622 = 92;
					client.field1793 = 120;
				} else if (client.field1793 == 120) {
					if (!class243.field2846.method6108("huffman", "")) {
						Login.field623 = class338.field4019 + 0 + "%";
						Login.field622 = 94;
					} else {
						class311 var38 = new class311(class243.field2846.method6148("huffman", ""));
						class307.field3673 = var38;
						Login.field623 = class338.field3923;
						Login.field622 = 94;
						client.field1793 = 130;
					}
				} else if (client.field1793 == 130) {
					if (!class333.field3859.method6092()) {
						Login.field623 = class338.field4021 + class333.field3859.method6303() * 4 / 5 + "%";
						Login.field622 = 96;
					} else if (!class202.field2255.method6092()) {
						Login.field623 = class338.field4021 + (80 + class202.field2255.method6303() / 6) + "%";
						Login.field622 = 96;
					} else if (!class136.field1275.method6092()) {
						Login.field623 = class338.field4021 + (96 + class136.field1275.method6303() / 50) + "%";
						Login.field622 = 96;
					} else {
						Login.field623 = class338.field3938;
						Login.field622 = 98;
						client.field1793 = 140;
					}
				} else if (140 == client.field1793) {
					Login.field622 = 100;
					if (!class304.field3634.method6110(class242.field2838.field2837)) {
						Login.field623 = class338.field3926 + class304.field3634.method6111(class242.field2838.field2837) / 10 + "%";
					} else {
						if (ProofOfWorkRequest.field10 == null) {
							ProofOfWorkRequest.field10 = new class420();
							ProofOfWorkRequest.field10.method7741(class304.field3634, class324.field3783, class145.field1338, class114.field1127, client.field1934, class91.field883);
						}

						Login.field623 = class338.field3927;
						client.field1793 = 150;
					}
				} else if (150 == client.field1793) {
					class9.method64(10);
				}
			} else if (!class174.field1564.method6092()) {
				Login.field623 = class338.field3915 + class174.field1564.method6303() + "%";
				Login.field622 = 60;
			} else if (!class255.field2944.method6092()) {
				Login.field623 = class338.field3915 + (80 + class202.field2255.method6303() / 6) + "%";
				Login.field622 = 60;
			} else {
				class199.method4997(class174.field1564);
				class185.method5209(class174.field1564);
				class336 var30 = class174.field1564;
				var2 = class252.field2922;
				class182.field1622 = var30;
				class182.field1619 = var2;
				class182.field1626 = class182.field1622.method6099(3);
				var3 = class174.field1564;
				class336 var32 = class252.field2922;
				boolean var31 = client.isLowDetail;
				class195.field2053 = var3;
				class195.field2054 = var32;
				class195.field2082 = var31;
				class336 var33 = class174.field1564;
				class336 var7 = class252.field2922;
				class203.field2293 = var33;
				class203.field2257 = var7;
				class336 var8 = class174.field1564;
				class187.field1978 = var8;
				class336 var9 = class174.field1564;
				class336 var10 = class252.field2922;
				boolean var11 = client.field1635;
				class376 var12 = class346.field4250;
				class298.field3438 = var9;
				class198.field2125 = var10;
				class6.field16 = var11;
				class435.field4713 = class298.field3438.method6099(10);
				class145.field1336 = var12;
				class336 var13 = class174.field1564;
				class336 var14 = class139.field1286;
				class336 var15 = MouseManager.field295;
				class189.field1989 = var13;
				class37.field250 = var14;
				class189.field1993 = var15;
				class336 var16 = class174.field1564;
				class336 var17 = class252.field2922;
				class207.field2363 = var16;
				class207.field2352 = var17;
				class184.method2019(class174.field1564);
				class336 var18 = class174.field1564;
				class178.field1593 = var18;
				class178.field1592 = class178.field1593.method6099(16);
				class336 var19 = class333.field3859;
				class336 var20 = class252.field2922;
				class336 var21 = class155.field1425;
				class336 var22 = class136.field1275;
				class105.field1044 = var19;
				class202.field2254 = var20;
				class299.field3439 = var21;
				class246.field2881 = var22;
				class300.field3593 = new class300[class105.field1044.method6100()][];
				class299.field3442 = new boolean[class105.field1044.method6100()];
				class177.method804(class174.field1564);
				class336 var23 = class174.field1564;
				class192.field2034 = var23;
				class20.method250(class174.field1564);
				class336 var24 = class174.field1564;
				class193.method5223(class174.field1564);
				class336 var25 = class174.field1564;
				class458.field4873 = var25;
				class452.method6816(class174.field1564);
				class28.field148 = new class448(class368.field4353, 54, class94.field940, class174.field1564);
				class191.field2026 = new class448(class368.field4353, 47, class94.field940, class174.field1564);
				class66.varcs = new class123();
				class206.method2590(class174.field1564, class155.field1425, class136.field1275);
				class158.method1416(class174.field1564, class155.field1425);
				class336 var26 = class174.field1564;
				class336 var27 = class155.field1425;
				class160.field1467 = var27;
				if (var26.method6092()) {
					class160.field1469 = var26.method6099(35);
					class160.field1464 = new class160[class160.field1469];

					for (int var28 = 0; var28 < class160.field1469; ++var28) {
						byte[] var29 = var26.method6175(35, var28);
						class160.field1464[var28] = new class160(var28);
						if (null != var29) {
							class160.field1464[var28].method2649(new Buffer(var29));
							class160.field1464[var28].method2647();
						}
					}
				}

				Login.field623 = class338.field3916;
				Login.field622 = 60;
				client.field1793 = 80;
			}
		}
	}

	static int method621(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.FRIEND_COUNT) {
			if (class217.friends.field377 == 0) {
				class57.field404[++class387.field4452 - 1] = -2;
			} else if (1 == class217.friends.field377) {
				class57.field404[++class387.field4452 - 1] = -1;
			} else {
				class57.field404[++class387.field4452 - 1] = class217.friends.field380.method7339();
			}

			return 1;
		} else {
			int var4;
			if (var0 == CS2Opcodes.FRIEND_GETNAME) {
				var4 = class57.field404[--class387.field4452];
				if (class217.friends.method1085() && var4 >= 0 && var4 < class217.friends.field380.method7339()) {
					class380 var9 = (class380)class217.friends.field380.method7296(var4);
					class57.field405[++class126.field1220 - 1] = var9.method7249();
					class57.field405[++class126.field1220 - 1] = var9.method7234();
				} else {
					class57.field405[++class126.field1220 - 1] = "";
					class57.field405[++class126.field1220 - 1] = "";
				}

				return 1;
			} else if (var0 == CS2Opcodes.FRIEND_GETWORLD) {
				var4 = class57.field404[--class387.field4452];
				if (class217.friends.method1085() && var4 >= 0 && var4 < class217.friends.field380.method7339()) {
					class57.field404[++class387.field4452 - 1] = ((class396)class217.friends.field380.method7296(var4)).field4491;
				} else {
					class57.field404[++class387.field4452 - 1] = 0;
				}

				return 1;
			} else if (var0 == CS2Opcodes.FRIEND_GETRANK) {
				var4 = class57.field404[--class387.field4452];
				if (class217.friends.method1085() && var4 >= 0 && var4 < class217.friends.field380.method7339()) {
					class57.field404[++class387.field4452 - 1] = ((class396)class217.friends.field380.method7296(var4)).field4492;
				} else {
					class57.field404[++class387.field4452 - 1] = 0;
				}

				return 1;
			} else {
				String var6;
				if (var0 == CS2Opcodes.FRIEND_SETRANK) {
					var6 = class57.field405[--class126.field1220];
					int var7 = class57.field404[--class387.field4452];
					class53.method2855(var6, var7);
					return 1;
				} else if (var0 == CS2Opcodes.FRIEND_ADD) {
					var6 = class57.field405[--class126.field1220];
					class217.friends.method1050(var6);
					return 1;
				} else if (var0 == CS2Opcodes.FRIEND_DEL) {
					var6 = class57.field405[--class126.field1220];
					class217.friends.method1069(var6);
					return 1;
				} else if (var0 == CS2Opcodes.IGNORE_ADD) {
					var6 = class57.field405[--class126.field1220];
					class217.friends.method1052(var6);
					return 1;
				} else if (var0 == CS2Opcodes.IGNORE_DEL) {
					var6 = class57.field405[--class126.field1220];
					class217.friends.method1055(var6);
					return 1;
				} else if (var0 == CS2Opcodes.FRIEND_TEST) {
					var6 = class57.field405[--class126.field1220];
					var6 = class208.method3985(var6);
					class57.field404[++class387.field4452 - 1] = class217.friends.method1071(new DisplayName(var6, class234.gameEngineMode), false) ? 1 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATDISPLAYNAME) {
					if (null != class73.field603) {
						class57.field405[++class126.field1220 - 1] = class73.field603.field4348;
					} else {
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATCOUNT) {
					if (class73.field603 != null) {
						class57.field404[++class387.field4452 - 1] = class73.field603.method7339();
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATUSERNAME) {
					var4 = class57.field404[--class387.field4452];
					if (null != class73.field603 && var4 < class73.field603.method7339()) {
						class57.field405[++class126.field1220 - 1] = class73.field603.method7296(var4).method7232().getName();
					} else {
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATUSERWORLD) {
					var4 = class57.field404[--class387.field4452];
					if (class73.field603 != null && var4 < class73.field603.method7339()) {
						class57.field404[++class387.field4452 - 1] = ((class396)class73.field603.method7296(var4)).method7173();
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATUSERRANK) {
					var4 = class57.field404[--class387.field4452];
					if (class73.field603 != null && var4 < class73.field603.method7339()) {
						class57.field404[++class387.field4452 - 1] = ((class396)class73.field603.method7296(var4)).field4492;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATMINKICK) {
					class57.field404[++class387.field4452 - 1] = class73.field603 != null ? class73.field603.field4350 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_KICKUSER) {
					var6 = class57.field405[--class126.field1220];
					class7.method46(var6);
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATRANK) {
					class57.field404[++class387.field4452 - 1] = class73.field603 != null ? class73.field603.field4352 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_JOINCHAT) {
					var6 = class57.field405[--class126.field1220];
					class190.method3532(var6);
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_LEAVECHAT) {
					client.method2589();
					return 1;
				} else if (var0 == CS2Opcodes.IGNORE_COUNT) {
					if (!class217.friends.method1085()) {
						class57.field404[++class387.field4452 - 1] = -1;
					} else {
						class57.field404[++class387.field4452 - 1] = class217.friends.field376.method7339();
					}

					return 1;
				} else if (var0 == CS2Opcodes.IGNORE_GETNAME) {
					var4 = class57.field404[--class387.field4452];
					if (class217.friends.method1085() && var4 >= 0 && var4 < class217.friends.field376.method7339()) {
						class398 var5 = (class398)class217.friends.field376.method7296(var4);
						class57.field405[++class126.field1220 - 1] = var5.method7249();
						class57.field405[++class126.field1220 - 1] = var5.method7234();
					} else {
						class57.field405[++class126.field1220 - 1] = "";
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				} else if (var0 == CS2Opcodes.IGNORE_TEST) {
					var6 = class57.field405[--class126.field1220];
					var6 = class208.method3985(var6);
					class57.field404[++class387.field4452 - 1] = class217.friends.method1049(new DisplayName(var6, class234.gameEngineMode)) ? 1 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CLAN_ISSELF) {
					var4 = class57.field404[--class387.field4452];
					if (class73.field603 != null && var4 < class73.field603.method7339() && class73.field603.method7296(var4).method7232().equals(class291.localPlayer.displayName)) {
						class57.field404[++class387.field4452 - 1] = 1;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_GETCHATOWNERNAME) {
					if (class73.field603 != null && null != class73.field603.field4349) {
						class57.field405[++class126.field1220 - 1] = class73.field603.field4349;
					} else {
						class57.field405[++class126.field1220 - 1] = "";
					}

					return 1;
				} else if (var0 == CS2Opcodes.CLAN_ISFRIEND) {
					var4 = class57.field404[--class387.field4452];
					if (null != class73.field603 && var4 < class73.field603.method7339() && ((class373)class73.field603.method7296(var4)).method6752()) {
						class57.field404[++class387.field4452 - 1] = 1;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else if (var0 != CS2Opcodes.CLAN_ISIGNORE) {
					if (var0 == CS2Opcodes._3628) {
						class217.friends.field380.method7342();
						return 1;
					} else {
						boolean var8;
						if (var0 == CS2Opcodes._3629) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class471(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3630) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class485(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3631) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class114(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3632) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class124(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3633) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class120(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3634) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class116(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3635) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class128(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3636) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class105(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3637) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class117(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3638) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class111(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3639) {
							class217.friends.field380.method7297();
							return 1;
						} else if (var0 == CS2Opcodes._3640) {
							class217.friends.field376.method7342();
							return 1;
						} else if (var0 == CS2Opcodes._3641) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field376.method7307(new class471(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3642) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field376.method7307(new class485(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3643) {
							class217.friends.field376.method7297();
							return 1;
						} else if (var0 == CS2Opcodes._3644) {
							if (null != class73.field603) {
								class73.field603.method7342();
							}

							return 1;
						} else if (var0 == CS2Opcodes._3645) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class471(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3646) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class485(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3647) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class114(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3648) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class124(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3649) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class120(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3650) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (null != class73.field603) {
								class73.field603.method7307(new class116(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3651) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (null != class73.field603) {
								class73.field603.method7307(new class128(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3652) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (class73.field603 != null) {
								class73.field603.method7307(new class105(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3653) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (null != class73.field603) {
								class73.field603.method7307(new class117(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3654) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (null != class73.field603) {
								class73.field603.method7307(new class111(var8));
							}

							return 1;
						} else if (var0 == CS2Opcodes._3655) {
							if (null != class73.field603) {
								class73.field603.method7297();
							}

							return 1;
						} else if (var0 == CS2Opcodes._3656) {
							var8 = class57.field404[--class387.field4452] == 1;
							class217.friends.field380.method7307(new class122(var8));
							return 1;
						} else if (var0 == CS2Opcodes._3657) {
							var8 = class57.field404[--class387.field4452] == 1;
							if (null != class73.field603) {
								class73.field603.method7307(new class122(var8));
							}

							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var4 = class57.field404[--class387.field4452];
					if (null != class73.field603 && var4 < class73.field603.method7339() && ((class373)class73.field603.method7296(var4)).method6755()) {
						class57.field404[++class387.field4452 - 1] = 1;
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				}
			}
		}
	}

	static final String method650(int var0) {
		String var2 = Integer.toString(var0);

		for (int var3 = var2.length() - 3; var3 > 0; var3 -= 3) {
			var2 = var2.substring(0, var3) + class96.field959 + var2.substring(var3);
		}

		if (var2.length() > 9) {
			return " " + class96.method4510(65408) + var2.substring(0, var2.length() - 8) + class338.field4065 + " " + class96.field964 + var2 + class96.field958 + class96.field965;
		} else {
			return var2.length() > 6 ? " " + class96.method4510(16777215) + var2.substring(0, var2.length() - 4) + class338.field4067 + " " + class96.field964 + var2 + class96.field958 + class96.field965 : " " + class96.method4510(16776960) + var2 + class96.field965;
		}
	}
}
