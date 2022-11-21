import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class class9 {
	public static short[] field39;
	final int field37;
	final String field36;

	class9(HttpURLConnection var1) throws IOException {
		this.field37 = var1.getResponseCode();
		var1.getResponseMessage();
		var1.getHeaderFields();
		StringBuilder var2 = new StringBuilder();
		InputStream var3 = this.field37 >= 300 ? var1.getErrorStream() : var1.getInputStream();
		if (var3 != null) {
			InputStreamReader var4 = new InputStreamReader(var3);
			BufferedReader var5 = new BufferedReader(var4);

			String var6;
			while ((var6 = var5.readLine()) != null) {
				var2.append(var6);
			}

			var3.close();
		}

		this.field36 = var2.toString();
	}

	class9(String var1) {
		this.field37 = 400;
		this.field36 = "";
	}

	public int method54() {
		return this.field37;
	}

	public String method55() {
		return this.field36;
	}

	static final void method57(byte[] var0, int var1, int var2, int var3, int var4, class200[] var5) {
		int var8;
		int var9;
		for (int var7 = 0; var7 < 4; ++var7) {
			for (var8 = 0; var8 < 64; ++var8) {
				for (var9 = 0; var9 < 64; ++var9) {
					if (var8 + var1 > 0 && var8 + var1 < 103 && var2 + var9 > 0 && var2 + var9 < 103) {
						int[] var10000 = var5[var7].field2205[var8 + var1];
						var10000[var9 + var2] &= -16777217;
					}
				}
			}
		}

		Buffer var11 = new Buffer(var0);

		for (var8 = 0; var8 < 4; ++var8) {
			for (var9 = 0; var9 < 64; ++var9) {
				for (int var10 = 0; var10 < 64; ++var10) {
					class243.method4768(var11, var8, var1 + var9, var2 + var10, var3, var4, 0);
				}
			}
		}

	}

	static final void method56(PacketBuffer var0) {
		for (int var2 = 0; var2 < PlayerManager.field1007; ++var2) {
			int var3 = PlayerManager.field1020[var2];
			class93 var4 = client.players[var3];
			int var5 = var0.method8141();
			if (0 != (var5 & 4)) {
				var5 += var0.method8141() << 8;
			}

			byte var6 = class197.field2119.field2117;
			int var7;
			if (0 != (var5 & 16)) {
				var4.field835 = var0.method8164();
				if (class78.field683) {
					var4.field835 += var0.readUnsignedByteSub() << 16;
					var7 = 16777215;
				} else {
					var7 = 65535;
				}

				if (var7 == var4.field835) {
					var4.field835 = -1;
				}
			}

			if (0 != (var5 & 2)) {
				var4.field822 = var0.readString();
				if (var4.field822.charAt(0) == '~') {
					var4.field822 = var4.field822.substring(1);
					MouseManager.method773(2, var4.field910.method8451(), var4.field822);
				} else if (class291.field3364 == var4) {
					MouseManager.method773(2, var4.field910.method8451(), var4.field822);
				}

				var4.field842 = false;
				var4.field801 = 0;
				var4.field819 = 0;
				var4.field843 = 150;
			}

			if ((var5 & 64) != 0) {
				var7 = var0.readUnsignedByteNeg();
				byte[] var8 = new byte[var7];
				Buffer var9 = new Buffer(var8);
				var0.method8333(var8, 0, var7);
				PlayerManager.field1011[var3] = var9;
				var4.method1906(var9);
			}

			if ((var5 & 4096) != 0) {
				var6 = var0.method8287();
			}

			int var15;
			if (0 != (var5 & 8)) {
				var7 = var0.readUnsignedShortAdd();
				if (var7 == 65535) {
					var7 = -1;
				}

				var15 = var0.method8153();
				class442.method7921(var4, var7, var15);
			}

			if (0 != (var5 & 2048)) {
				var4.field862 = client.field1645 + var0.readUnsignedShortLE();
				var4.field863 = client.field1645 + var0.method8164();
				var4.field864 = var0.method8287();
				var4.field865 = var0.method8335();
				var4.field850 = var0.method8287();
				var4.field867 = (byte)var0.readUnsignedByteSub();
			}

			if ((var5 & 1) != 0) {
				var4.field868 = var0.readUnsignedShort();
				if (0 == var4.field871) {
					var4.field860 = var4.field868;
					var4.field868 = -1;
				}
			}

			if (0 != (var5 & 16384)) {
				var4.field815 = var0.method8187();
				var4.field855 = var0.method8335();
				var4.field854 = var0.method8335();
				var4.field853 = var0.method8187();
				var4.field857 = var0.method8164() + client.field1645;
				var4.field858 = var0.readUnsignedShortLE() + client.field1645;
				var4.field859 = var0.readUnsignedShort();
				if (var4.field919) {
					var4.field815 += var4.field920;
					var4.field855 += var4.field892;
					var4.field854 += var4.field920;
					var4.field853 += var4.field892;
					var4.field871 = 0;
				} else {
					var4.field815 += var4.field861[0];
					var4.field855 += var4.field873[0];
					var4.field854 += var4.field861[0];
					var4.field853 += var4.field873[0];
					var4.field871 = 1;
				}

				var4.field876 = 0;
			}

			int var10;
			int var11;
			int var14;
			if (0 != (var5 & 32)) {
				var7 = var0.readUnsignedByteSub();
				int var12;
				int var13;
				int var16;
				if (var7 > 0) {
					for (var15 = 0; var15 < var7; ++var15) {
						var10 = -1;
						var11 = -1;
						var12 = -1;
						var16 = var0.method8207();
						if (var16 == 32767) {
							var16 = var0.method8207();
							var11 = var0.method8207();
							var10 = var0.method8207();
							var12 = var0.method8207();
						} else if (var16 != 32766) {
							var11 = var0.method8207();
						} else {
							var16 = -1;
						}

						var13 = var0.method8207();
						var4.method1877(var16, var11, var10, var12, client.field1645, var13);
					}
				}

				var15 = var0.readUnsignedByteSub();
				if (var15 > 0) {
					for (var16 = 0; var16 < var15; ++var16) {
						var10 = var0.method8207();
						var11 = var0.method8207();
						if (var11 != 32767) {
							var12 = var0.method8207();
							var13 = var0.readUnsignedByteSub();
							var14 = var11 > 0 ? var0.method8141() : var13;
							var4.method1867(var10, client.field1645, var11, var12, var13, var14);
						} else {
							var4.method1872(var10);
						}
					}
				}
			}

			if (0 != (var5 & 8192)) {
				var4.field848 = var0.method8164();
				var7 = var0.readIntIME();
				var4.field824 = var7 >> 16;
				var4.field851 = (var7 & 65535) + client.field1645;
				var4.field856 = 0;
				var4.field807 = 0;
				if (var4.field851 > client.field1645) {
					var4.field856 = -1;
				}

				if (65535 == var4.field848) {
					var4.field848 = -1;
				}
			}

			if ((var5 & 512) != 0) {
				for (var7 = 0; var7 < 3; ++var7) {
					var4.field897[var7] = var0.readString();
				}
			}

			if (0 != (var5 & 128)) {
				var7 = var0.readUnsignedShortAdd();
				class333 var19 = (class333)class217.method4362(class333.method5480(), var0.method8153());
				boolean var21 = var0.readUnsignedByteSub() == 1;
				var10 = var0.readUnsignedByteNeg();
				var11 = var0.offset;
				if (var4.field910 != null && null != var4.field911) {
					boolean var20 = false;
					if (var19.field3858 && class217.friends.method1049(var4.field910)) {
						var20 = true;
					}

					if (!var20 && client.field1830 == 0 && !var4.field913) {
						PlayerManager.field1021.offset = 0;
						var0.method8195(PlayerManager.field1021.data, 0, var10);
						PlayerManager.field1021.offset = 0;
						String var17 = class384.method6864(class158.method2630(class307.method5489(PlayerManager.field1021)));
						var4.field822 = var17.trim();
						var4.field801 = var7 >> 8;
						var4.field819 = var7 & 255;
						var4.field843 = 150;
						var4.field842 = var21;
						var4.field820 = var4 != class291.field3364 && var19.field3858 && client.field1873 != "" && var17.toLowerCase().indexOf(client.field1873) == -1;
						if (var19.field3857) {
							var14 = var21 ? 91 : 1;
						} else {
							var14 = var21 ? 90 : 2;
						}

						if (var19.field3856 != -1) {
							MouseManager.method773(var14, class96.method5151(var19.field3856) + var4.field910.method8451(), var17);
						} else {
							MouseManager.method773(var14, var4.field910.method8451(), var17);
						}
					}
				}

				var0.offset = var11 + var10;
			}

			if ((var5 & 1024) != 0) {
				PlayerManager.field1010[var3] = (class197)class217.method4362(class197.method7499(), var0.method8158());
			}

			if (var4.field919) {
				if (var6 == 127) {
					var4.method1919(var4.field920, var4.field892);
				} else {
					class197 var18;
					if (var6 != class197.field2119.field2117) {
						var18 = (class197)class217.method4362(class197.method7499(), var6);
					} else {
						var18 = PlayerManager.field1010[var3];
					}

					var4.method1938(var4.field920, var4.field892, var18);
				}
			}
		}

	}

	static void method64(int var0) {
		if (client.gameState != var0) {
			if (30 == client.gameState) {
				client.field1877.method3521();
			}

			if (client.gameState == 0) {
				class133.field1257.method472();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
				class43.setLoginState(0);
				client.field1668 = 0;
				client.field1669 = 0;
				client.timer.method6843(var0);
				if (var0 != 20) {
					class49.method996(false);
				}
			}

			if (var0 != 20 && var0 != 40 && null != class218.field2589) {
				class218.field2589.method7259();
				class218.field2589 = null;
			}

			if (client.gameState == 25) {
				client.field1725 = 0;
				client.field1700 = 0;
				client.field1631 = 1;
				client.field1702 = 0;
				client.field1703 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					int var4 = 11 == client.gameState ? 4 : 0;
					class404.method7362(class243.field2846, class155.field1425, false, var4);
				} else if (var0 == 11) {
					class404.method7362(class243.field2846, class155.field1425, false, 4);
				} else if (var0 == 50) {
					Login.setLoginResponseString("", "Updating date of birth...", "");
					class404.method7362(class243.field2846, class155.field1425, false, 7);
				} else {
					class333.method6267();
				}
			} else {
				boolean var2 = class413.clientPreferences.method1797() >= client.field1637;
				int var3 = var2 ? 0 : 12;
				class404.method7362(class243.field2846, class155.field1425, true, var3);
			}

			client.gameState = var0;
		}
	}

	static final void method63(int var0, int var1, int var2, int var3) {
		++client.field1745;
		if (client.destinationX == class291.field3364.field827 >> 7 && client.destinationY == class291.field3364.field802 >> 7) {
			client.destinationX = 0;
		}

		class353.method6566();
		if (client.combatTargetPlayerIndex >= 0 && null != client.players[client.combatTargetPlayerIndex]) {
			class17.method200(client.players[client.combatTargetPlayerIndex], false);
		}

		class315.method6071(true);
		int var5 = PlayerManager.playerCount;
		int[] var6 = PlayerManager.field1013;

		int var7;
		for (var7 = 0; var7 < var5; ++var7) {
			if (client.combatTargetPlayerIndex != var6[var7] && var6[var7] != client.localPlayerIndex) {
				class17.method200(client.players[var6[var7]], true);
			}
		}

		class315.method6071(false);
		class19.method228();
		class203.method3865();
		MouseManager.method795(var0, var1, var2, var3, true);
		var0 = client.field1915;
		var1 = client.field1634;
		var2 = client.field1917;
		var3 = client.field1678;
		class481.method8653(var0, var1, var2 + var0, var1 + var3);
		class221.method4389();
		var5 = client.field1761;
		if (client.field1733 / 256 > var5) {
			var5 = client.field1733 / 256;
		}

		if (client.field1699[4] && 128 + client.field1808[4] > var5) {
			var5 = 128 + client.field1808[4];
		}

		int var18 = client.field1672 & 2047;
		class83.method1795(class32.field203, class178.field1595, class101.field1004, var5, var18, client.method3449(var5), var3);
		if (!client.field1900) {
			var7 = class335.method6272();
		} else {
			var7 = class222.method4476();
		}

		int var8 = class215.field2568;
		int var9 = class32.field204;
		int var10 = class323.field3766;
		int var11 = class414.field4588;
		int var12 = class237.field2807;

		int var13;
		int var14;
		for (var13 = 0; var13 < 5; ++var13) {
			if (client.field1699[var13]) {
				var14 = (int)(Math.random() * (double)(1 + 2 * client.field1903[var13]) - (double)client.field1903[var13] + Math.sin((double)client.field1905[var13] / 100.0D * (double)client.field1906[var13]) * (double)client.field1808[var13]);
				if (var13 == 0) {
					class215.field2568 += var14;
				}

				if (var13 == 1) {
					class32.field204 += var14;
				}

				if (var13 == 2) {
					class323.field3766 += var14;
				}

				if (var13 == 3) {
					class237.field2807 = var14 + class237.field2807 & 2047;
				}

				if (var13 == 4) {
					class414.field4588 += var14;
					if (class414.field4588 < 128) {
						class414.field4588 = 128;
					}

					if (class414.field4588 > 383) {
						class414.field4588 = 383;
					}
				}
			}
		}

		var13 = MouseManager.field284;
		var14 = MouseManager.field285;
		if (0 != MouseManager.field277) {
			var13 = MouseManager.field283;
			var14 = MouseManager.field293;
		}

		int var15;
		if (var13 >= var0 && var13 < var2 + var0 && var14 >= var1 && var14 < var3 + var1) {
			var15 = var13 - var0;
			int var16 = var14 - var1;
			class234.field2767 = var15;
			class234.field2768 = var16;
			class234.field2778 = true;
			class234.field2771 = 0;
			class234.field2774 = false;
		} else {
			class234.field2778 = false;
			class234.field2771 = 0;
		}

		class349.method6457();
		class481.method8660(var0, var1, var2, var3, 0);
		class349.method6457();
		var15 = class221.field2630;
		class221.field2630 = client.field1919;
		class145.field1333.method4297(class215.field2568, class32.field204, class323.field3766, class414.field4588, class237.field2807, var7);
		class221.field2630 = var15;
		class349.method6457();
		class145.field1333.method4136();
		class123.method2326(var0, var1, var2, var3);
		if (2 == client.hintArrowType) {
			class230.method4536((client.field1655 - class36.field241 << 7) + client.field1866, client.field1684 + (client.field1656 - class169.field1536 << 7), client.field1913 * 2);
			if (client.field1809 > -1 && client.field1645 % 20 < 10) {
				class176.field1585[0].method8526(var0 + client.field1809 - 12, var1 + client.field1747 - 28);
			}
		}

		((class215)class221.field2629).method4313(client.field1701);
		class31.method598();
		class215.field2568 = var8;
		class32.field204 = var9;
		class323.field3766 = var10;
		class414.field4588 = var11;
		class237.field2807 = var12;
		if (client.isLoading) {
			byte var17 = 0;
			int var19 = var17 + class324.field3780 + class324.field3778;
			if (var19 == 0) {
				client.isLoading = false;
			}
		}

		if (client.isLoading) {
			class481.method8660(var0, var1, var2, var3, 0);
			class131.method2399(class338.field3902, false);
		}

	}
}
