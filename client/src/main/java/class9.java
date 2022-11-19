import client.Client;

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

		class460 var11 = new class460(var0);

		for (var8 = 0; var8 < 4; ++var8) {
			for (var9 = 0; var9 < 64; ++var9) {
				for (int var10 = 0; var10 < 64; ++var10) {
					class243.method4768(var11, var8, var1 + var9, var2 + var10, var3, var4, 0);
				}
			}
		}

	}

	static final void method56(class453 var0) {
		for (int var2 = 0; var2 < class102.field1007; ++var2) {
			int var3 = class102.field1020[var2];
			class93 var4 = Client.field1763[var3];
			int var5 = var0.method8141();
			if (0 != (var5 & 4)) {
				var5 += var0.method8141() << 8;
			}

			byte var6 = class197.field2119.field2117;
			int var7;
			if (0 != (var5 & 16)) {
				var4.field835 = var0.method8164();
				if (class78.field683) {
					var4.field835 += var0.method8341() << 16;
					var7 = 16777215;
				} else {
					var7 = 65535;
				}

				if (var7 == var4.field835) {
					var4.field835 = -1;
				}
			}

			if (0 != (var5 & 2)) {
				var4.field822 = var0.method8131();
				if (var4.field822.charAt(0) == '~') {
					var4.field822 = var4.field822.substring(1);
					class42.method773(2, var4.field910.method8451(), var4.field822);
				} else if (class291.field3364 == var4) {
					class42.method773(2, var4.field910.method8451(), var4.field822);
				}

				var4.field842 = false;
				var4.field801 = 0;
				var4.field819 = 0;
				var4.field843 = 150;
			}

			if ((var5 & 64) != 0) {
				var7 = var0.method8154();
				byte[] var8 = new byte[var7];
				class460 var9 = new class460(var8);
				var0.method8333(var8, 0, var7);
				class102.field1011[var3] = var9;
				var4.method1906(var9);
			}

			if ((var5 & 4096) != 0) {
				var6 = var0.method8287();
			}

			int var15;
			if (0 != (var5 & 8)) {
				var7 = var0.method8202();
				if (var7 == 65535) {
					var7 = -1;
				}

				var15 = var0.method8153();
				class442.method7921(var4, var7, var15);
			}

			if (0 != (var5 & 2048)) {
				var4.field862 = Client.field1645 + var0.method8162();
				var4.field863 = Client.field1645 + var0.method8164();
				var4.field864 = var0.method8287();
				var4.field865 = var0.method8335();
				var4.field850 = var0.method8287();
				var4.field867 = (byte)var0.method8341();
			}

			if ((var5 & 1) != 0) {
				var4.field868 = var0.method8122();
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
				var4.field857 = var0.method8164() + Client.field1645;
				var4.field858 = var0.method8162() + Client.field1645;
				var4.field859 = var0.method8122();
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
				var7 = var0.method8341();
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
						var4.method1877(var16, var11, var10, var12, Client.field1645, var13);
					}
				}

				var15 = var0.method8341();
				if (var15 > 0) {
					for (var16 = 0; var16 < var15; ++var16) {
						var10 = var0.method8207();
						var11 = var0.method8207();
						if (var11 != 32767) {
							var12 = var0.method8207();
							var13 = var0.method8341();
							var14 = var11 > 0 ? var0.method8141() : var13;
							var4.method1867(var10, Client.field1645, var11, var12, var13, var14);
						} else {
							var4.method1872(var10);
						}
					}
				}
			}

			if (0 != (var5 & 8192)) {
				var4.field848 = var0.method8164();
				var7 = var0.method8176();
				var4.field824 = var7 >> 16;
				var4.field851 = (var7 & 65535) + Client.field1645;
				var4.field856 = 0;
				var4.field807 = 0;
				if (var4.field851 > Client.field1645) {
					var4.field856 = -1;
				}

				if (65535 == var4.field848) {
					var4.field848 = -1;
				}
			}

			if ((var5 & 512) != 0) {
				for (var7 = 0; var7 < 3; ++var7) {
					var4.field897[var7] = var0.method8131();
				}
			}

			if (0 != (var5 & 128)) {
				var7 = var0.method8202();
				class333 var19 = (class333)class217.method4362(class333.method5480(), var0.method8153());
				boolean var21 = var0.method8341() == 1;
				var10 = var0.method8154();
				var11 = var0.field4878;
				if (var4.field910 != null && null != var4.field911) {
					boolean var20 = false;
					if (var19.field3858 && class217.field2588.method1049(var4.field910)) {
						var20 = true;
					}

					if (!var20 && Client.field1830 == 0 && !var4.field913) {
						class102.field1021.field4878 = 0;
						var0.method8195(class102.field1021.field4881, 0, var10);
						class102.field1021.field4878 = 0;
						String var17 = class384.method6864(class158.method2630(class307.method5489(class102.field1021)));
						var4.field822 = var17.trim();
						var4.field801 = var7 >> 8;
						var4.field819 = var7 & 255;
						var4.field843 = 150;
						var4.field842 = var21;
						var4.field820 = var4 != class291.field3364 && var19.field3858 && Client.field1873 != "" && var17.toLowerCase().indexOf(Client.field1873) == -1;
						if (var19.field3857) {
							var14 = var21 ? 91 : 1;
						} else {
							var14 = var21 ? 90 : 2;
						}

						if (var19.field3856 != -1) {
							class42.method773(var14, class96.method5151(var19.field3856) + var4.field910.method8451(), var17);
						} else {
							class42.method773(var14, var4.field910.method8451(), var17);
						}
					}
				}

				var0.field4878 = var11 + var10;
			}

			if ((var5 & 1024) != 0) {
				class102.field1010[var3] = (class197)class217.method4362(class197.method7499(), var0.method8158());
			}

			if (var4.field919) {
				if (var6 == 127) {
					var4.method1919(var4.field920, var4.field892);
				} else {
					class197 var18;
					if (var6 != class197.field2119.field2117) {
						var18 = (class197)class217.method4362(class197.method7499(), var6);
					} else {
						var18 = class102.field1010[var3];
					}

					var4.method1938(var4.field920, var4.field892, var18);
				}
			}
		}

	}

	static void method64(int var0) {
		if (Client.field1766 != var0) {
			if (30 == Client.field1766) {
				Client.field1877.method3521();
			}

			if (Client.field1766 == 0) {
				class133.field1257.method472();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
				class43.method801(0);
				Client.field1668 = 0;
				Client.field1669 = 0;
				Client.field1698.method6843(var0);
				if (var0 != 20) {
					class49.method996(false);
				}
			}

			if (var0 != 20 && var0 != 40 && null != class218.field2589) {
				class218.field2589.method7259();
				class218.field2589 = null;
			}

			if (Client.field1766 == 25) {
				Client.field1725 = 0;
				Client.field1700 = 0;
				Client.field1631 = 1;
				Client.field1702 = 0;
				Client.field1703 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					int var4 = 11 == Client.field1766 ? 4 : 0;
					class404.method7362(class243.field2846, class155.field1425, false, var4);
				} else if (var0 == 11) {
					class404.method7362(class243.field2846, class155.field1425, false, 4);
				} else if (var0 == 50) {
					class75.method5452("", "Updating date of birth...", "");
					class404.method7362(class243.field2846, class155.field1425, false, 7);
				} else {
					class333.method6267();
				}
			} else {
				boolean var2 = class413.field4575.method1797() >= Client.field1637;
				int var3 = var2 ? 0 : 12;
				class404.method7362(class243.field2846, class155.field1425, true, var3);
			}

			Client.field1766 = var0;
		}
	}

	static final void method63(int var0, int var1, int var2, int var3) {
		++Client.field1745;
		if (Client.field1889 == class291.field3364.field827 >> 7 && Client.field1890 == class291.field3364.field802 >> 7) {
			Client.field1889 = 0;
		}

		class353.method6566();
		if (Client.field1775 >= 0 && null != Client.field1763[Client.field1775]) {
			class17.method200(Client.field1763[Client.field1775], false);
		}

		class315.method6071(true);
		int var5 = class102.field1012;
		int[] var6 = class102.field1013;

		int var7;
		for (var7 = 0; var7 < var5; ++var7) {
			if (Client.field1775 != var6[var7] && var6[var7] != Client.field1764) {
				class17.method200(Client.field1763[var6[var7]], true);
			}
		}

		class315.method6071(false);
		class19.method228();
		class203.method3865();
		class42.method795(var0, var1, var2, var3, true);
		var0 = Client.field1915;
		var1 = Client.field1634;
		var2 = Client.field1917;
		var3 = Client.field1678;
		class481.method8653(var0, var1, var2 + var0, var1 + var3);
		class221.method4389();
		var5 = Client.field1761;
		if (Client.field1733 / 256 > var5) {
			var5 = Client.field1733 / 256;
		}

		if (Client.field1699[4] && 128 + Client.field1808[4] > var5) {
			var5 = 128 + Client.field1808[4];
		}

		int var18 = Client.field1672 & 2047;
		class83.method1795(class32.field203, class178.field1595, class101.field1004, var5, var18, Client.method3449(var5), var3);
		if (!Client.field1900) {
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
			if (Client.field1699[var13]) {
				var14 = (int)(Math.random() * (double)(1 + 2 * Client.field1903[var13]) - (double) Client.field1903[var13] + Math.sin((double) Client.field1905[var13] / 100.0D * (double) Client.field1906[var13]) * (double) Client.field1808[var13]);
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

		var13 = class42.field284;
		var14 = class42.field285;
		if (0 != class42.field277) {
			var13 = class42.field283;
			var14 = class42.field293;
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
		class221.field2630 = Client.field1919;
		class145.field1333.method4297(class215.field2568, class32.field204, class323.field3766, class414.field4588, class237.field2807, var7);
		class221.field2630 = var15;
		class349.method6457();
		class145.field1333.method4136();
		class123.method2326(var0, var1, var2, var3);
		if (2 == Client.field1652) {
			class230.method4536((Client.field1655 - class36.field241 << 7) + Client.field1866, Client.field1684 + (Client.field1656 - class169.field1536 << 7), Client.field1913 * 2);
			if (Client.field1809 > -1 && Client.field1645 % 20 < 10) {
				class176.field1585[0].method8526(var0 + Client.field1809 - 12, var1 + Client.field1747 - 28);
			}
		}

		((class215)class221.field2629).method4313(Client.field1701);
		class31.method598();
		class215.field2568 = var8;
		class32.field204 = var9;
		class323.field3766 = var10;
		class414.field4588 = var11;
		class237.field2807 = var12;
		if (Client.field1828) {
			byte var17 = 0;
			int var19 = var17 + class324.field3780 + class324.field3778;
			if (var19 == 0) {
				Client.field1828 = false;
			}
		}

		if (Client.field1828) {
			class481.method8660(var0, var1, var2, var3, 0);
			class131.method2399(class338.field3902, false);
		}

	}
}
