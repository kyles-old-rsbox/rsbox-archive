import client.Client;

public class class263 extends class427 {
	static class263[] field2986;
	static int field2988;
	class274 field2989;
	int field2985;
	public class453 field2984;
	public int field2987;

	static {
		field2986 = new class263[300];
		field2988 = 0;
	}

	class263() {
	}

	public static class263 method5167() {
		class263 var1 = class210.method4096();
		var1.field2989 = null;
		var1.field2985 = 0;
		var1.field2984 = new class453(5000);
		return var1;
	}

	public void method5153() {
		if (field2988 < field2986.length) {
			field2986[++field2988 - 1] = this;
		}
	}

	static final void method5159(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		class300 var10;
		if (var2 == 57 || var2 == 1007) {
			var10 = class253.method5043(var1, var0);
			if (var10 != null) {
				class272.method5220(var3, var1, var0, var4, var6);
			}
		}

		class263 var12;
		class81 var15;
		if (var2 == 1003) {
			Client.field1657 = var7;
			Client.field1749 = var8;
			Client.field1751 = 2;
			Client.field1904 = 0;
			var15 = Client.field1902[var3];
			if (var15 != null) {
				class203 var11 = var15.field709;
				if (null != var11.field2278) {
					var11 = var11.method3857();
				}

				if (var11 != null) {
					var12 = class185.method3435(class274.field3060, Client.field1778.field1071);
					var12.field2984.method8161(var11.field2260);
					Client.field1778.method2078(var12);
				}
			}
		}

		class263 var16;
		if (var2 == 31) {
			var16 = class185.method3435(class274.field3096, Client.field1778.field1071);
			var16.field2984.method8337(class6.field23);
			var16.field2984.method8353(class213.field2493);
			var16.field2984.method8353(var1);
			var16.field2984.method8181(var0);
			var16.field2984.method8159(var4);
			var16.field2984.method8181(class54.field385);
			Client.field1778.method2078(var16);
			Client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			Client.field1888 = var0;
		}

		if (var2 == 1002) {
			Client.field1657 = var7;
			Client.field1749 = var8;
			Client.field1751 = 2;
			Client.field1904 = 0;
			var16 = class185.method3435(class274.field3126, Client.field1778.field1071);
			var16.field2984.method8181(var3);
			Client.field1778.method2078(var16);
		}

		class93 var17;
		class263 var18;
		if (var2 == 50) {
			var17 = Client.field1763[var3];
			if (null != var17) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var18 = class185.method3435(class274.field3089, Client.field1778.field1071);
				var18.field2984.method8181(var3);
				var18.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 14) {
			var17 = Client.field1763[var3];
			if (null != var17) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var18 = class185.method3435(class274.field3143, Client.field1778.field1071);
				var18.field2984.method8353(class213.field2493);
				var18.field2984.method8161(class6.field23);
				var18.field2984.method8161(class54.field385);
				var18.field2984.method8337(var3);
				var18.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 46) {
			var17 = Client.field1763[var3];
			if (null != var17) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var18 = class185.method3435(class274.field3044, Client.field1778.field1071);
				var18.field2984.method8337(var3);
				var18.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 15) {
			var17 = Client.field1763[var3];
			if (var17 != null) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var18 = class185.method3435(class274.field3145, Client.field1778.field1071);
				var18.field2984.method8155(class106.field1066);
				var18.field2984.method8159(Client.field1806);
				var18.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				var18.field2984.method8337(Client.field1805);
				var18.field2984.method8161(var3);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 41) {
			var16 = class185.method3435(class274.field3098, Client.field1778.field1071);
			var16.field2984.method8159(var4);
			var16.field2984.method8241(var1);
			var16.field2984.method8181(var0);
			Client.field1778.method2078(var16);
			Client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			Client.field1888 = var0;
		}

		if (var2 == 47) {
			var17 = Client.field1763[var3];
			if (null != var17) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var18 = class185.method3435(class274.field3042, Client.field1778.field1071);
				var18.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
				var18.field2984.method8159(var3);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 1004) {
			Client.field1657 = var7;
			Client.field1749 = var8;
			Client.field1751 = 2;
			Client.field1904 = 0;
			var16 = class185.method3435(class274.field3138, Client.field1778.field1071);
			var16.field2984.method8181(var0 + class36.field241);
			var16.field2984.method8337(var3);
			var16.field2984.method8181(class169.field1536 + var1);
			Client.field1778.method2078(var16);
		}

		if (var2 == 37) {
			var16 = class185.method3435(class274.field3125, Client.field1778.field1071);
			var16.field2984.method8181(var0);
			var16.field2984.method8161(var4);
			var16.field2984.method8171(var1);
			Client.field1778.method2078(var16);
			Client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			Client.field1888 = var0;
		}

		if (var2 == 42) {
			var16 = class185.method3435(class274.field3103, Client.field1778.field1071);
			var16.field2984.method8159(var4);
			var16.field2984.method8353(var1);
			var16.field2984.method8159(var0);
			Client.field1778.method2078(var16);
			Client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			Client.field1888 = var0;
		}

		if (var2 == 40) {
			var16 = class185.method3435(class274.field3072, Client.field1778.field1071);
			var16.field2984.method8353(var1);
			var16.field2984.method8181(var0);
			var16.field2984.method8161(var4);
			Client.field1778.method2078(var16);
			Client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			Client.field1888 = var0;
		}

		if (var2 == 58) {
			var10 = class253.method5043(var1, var0);
			if (var10 != null) {
				if (null != var10.field3573) {
					class79 var19 = new class79();
					var19.field694 = var10;
					var19.field690 = var3;
					var19.field685 = var6;
					var19.field686 = var10.field3573;
					class57.method5433(var19);
				}

				var18 = class185.method3435(class274.field3131, Client.field1778.field1071);
				var18.field2984.method8161(Client.field1806);
				var18.field2984.method8161(var0);
				var18.field2984.method8155(class106.field1066);
				var18.field2984.method8181(var4);
				var18.field2984.method8171(var1);
				var18.field2984.method8159(Client.field1805);
				Client.field1778.method2078(var18);
			}
		}

		if (var2 == 1) {
			Client.field1657 = var7;
			Client.field1749 = var8;
			Client.field1751 = 2;
			Client.field1904 = 0;
			Client.field1889 = var0;
			Client.field1890 = var1;
			var16 = class185.method3435(class274.field3123, Client.field1778.field1071);
			var16.field2984.method8337(class6.field23);
			var16.field2984.method8337(class54.field385);
			var16.field2984.method8181(var1 + class169.field1536);
			var16.field2984.method8161(class36.field241 + var0);
			var16.field2984.method8155(class213.field2493);
			var16.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
			var16.field2984.method8337(var3);
			Client.field1778.method2078(var16);
		}

		if (var2 == 38) {
			class100.method1989();
			var10 = class282.method5426(var1);
			Client.field1802 = 1;
			class6.field23 = var0;
			class213.field2493 = var1;
			class54.field385 = var4;
			class136.method2438(var10);
			Client.field1803 = class96.method4510(16748608) + class278.method5388(var4).field2131 + class96.method4510(16777215);
			if (null == Client.field1803) {
				Client.field1803 = class338.field3899;
			}

		} else {
			if (var2 == 21) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3054, Client.field1778.field1071);
				var16.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8159(var1 + class169.field1536);
				var16.field2984.method8159(class36.field241 + var0);
				var16.field2984.method8161(var3);
				Client.field1778.method2078(var16);
			}

			if (var2 == 36) {
				var16 = class185.method3435(class274.field3107, Client.field1778.field1071);
				var16.field2984.method8241(var1);
				var16.field2984.method8337(var0);
				var16.field2984.method8159(var4);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			int var13;
			class300 var20;
			if (var2 == 28) {
				var16 = class185.method3435(class274.field3039, Client.field1778.field1071);
				var16.field2984.method8241(var1);
				Client.field1778.method2078(var16);
				var20 = class282.method5426(var1);
				if (null != var20 && var20.field3613 != null && 5 == var20.field3613[0][0]) {
					var13 = var20.field3613[0][1];
					class293.field3370[var13] = 1 - class293.field3370[var13];
					class147.method2521(var13);
				}
			}

			if (var2 == 44) {
				var17 = Client.field1763[var3];
				if (null != var17) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3110, Client.field1778.field1071);
					var18.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
					var18.field2984.method8161(var3);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 39) {
				var16 = class185.method3435(class274.field3086, Client.field1778.field1071);
				var16.field2984.method8171(var1);
				var16.field2984.method8159(var4);
				var16.field2984.method8181(var0);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 35) {
				var16 = class185.method3435(class274.field3091, Client.field1778.field1071);
				var16.field2984.method8241(var1);
				var16.field2984.method8161(var4);
				var16.field2984.method8181(var0);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 19) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3106, Client.field1778.field1071);
				var16.field2984.method8161(var1 + class169.field1536);
				var16.field2984.method8159(var3);
				var16.field2984.method8348(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8181(var0 + class36.field241);
				Client.field1778.method2078(var16);
			}

			if (var2 == 22) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3084, Client.field1778.field1071);
				var16.field2984.method8161(class36.field241 + var0);
				var16.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8161(var3);
				var16.field2984.method8161(class169.field1536 + var1);
				Client.field1778.method2078(var16);
			}

			if (var2 == 11) {
				var15 = Client.field1902[var3];
				if (var15 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3056, Client.field1778.field1071);
					var18.field2984.method8337(var3);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 7) {
				var15 = Client.field1902[var3];
				if (var15 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3111, Client.field1778.field1071);
					var18.field2984.method8161(class6.field23);
					var18.field2984.method8159(class54.field385);
					var18.field2984.method8337(var3);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					var18.field2984.method8241(class213.field2493);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 6) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3053, Client.field1778.field1071);
				var16.field2984.method8161(class36.field241 + var0);
				var16.field2984.method8348(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8337(var3);
				var16.field2984.method8161(var1 + class169.field1536);
				Client.field1778.method2078(var16);
			}

			if (var2 == 1005) {
				var10 = class282.method5426(var1);
				if (var10 != null && var10.field3456[var0] >= 100000) {
					class42.method773(27, "", var10.field3456[var0] + " x " + class278.method5388(var4).field2131);
				} else {
					var18 = class185.method3435(class274.field3139, Client.field1778.field1071);
					var18.field2984.method8159(var4);
					Client.field1778.method2078(var18);
				}

				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 49) {
				var17 = Client.field1763[var3];
				if (var17 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3070, Client.field1778.field1071);
					var18.field2984.method8161(var3);
					var18.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 8) {
				var15 = Client.field1902[var3];
				if (var15 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3119, Client.field1778.field1071);
					var18.field2984.method8161(var3);
					var18.field2984.method8337(Client.field1805);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					var18.field2984.method8337(Client.field1806);
					var18.field2984.method8353(class106.field1066);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
				class4.field10.method7630(var2, var3, new class295(var0), new class295(var1));
			}

			if (var2 == 1001) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3064, Client.field1778.field1071);
				var16.field2984.method8161(var1 + class169.field1536);
				var16.field2984.method8181(var0 + class36.field241);
				var16.field2984.method8161(var3);
				var16.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var16);
			}

			if (var2 == 45) {
				var17 = Client.field1763[var3];
				if (var17 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3090, Client.field1778.field1071);
					var18.field2984.method8337(var3);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 43) {
				var16 = class185.method3435(class274.field3130, Client.field1778.field1071);
				var16.field2984.method8337(var4);
				var16.field2984.method8155(var1);
				var16.field2984.method8159(var0);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 30 && Client.field1641 == null) {
				Client.method7985(var1, var0);
				Client.field1641 = class253.method5043(var1, var0);
				class136.method2438(Client.field1641);
			}

			if (var2 == 48) {
				var17 = Client.field1763[var3];
				if (null != var17) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3141, Client.field1778.field1071);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					var18.field2984.method8181(var3);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 17) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3087, Client.field1778.field1071);
				var16.field2984.method8159(Client.field1805);
				var16.field2984.method8159(class169.field1536 + var1);
				var16.field2984.method8171(class106.field1066);
				var16.field2984.method8348(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8159(var0 + class36.field241);
				var16.field2984.method8159(var3);
				var16.field2984.method8337(Client.field1806);
				Client.field1778.method2078(var16);
			}

			if (var2 == 20) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3092, Client.field1778.field1071);
				var16.field2984.method8181(class36.field241 + var0);
				var16.field2984.method8161(class169.field1536 + var1);
				var16.field2984.method8159(var3);
				var16.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var16);
			}

			if (var2 == 34) {
				var16 = class185.method3435(class274.field3104, Client.field1778.field1071);
				var16.field2984.method8337(var0);
				var16.field2984.method8181(var4);
				var16.field2984.method8155(var1);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 24) {
				var10 = class282.method5426(var1);
				if (null != var10) {
					boolean var14 = true;
					if (var10.field3464 > 0) {
						var14 = class157.method2603(var10);
					}

					if (var14) {
						var12 = class185.method3435(class274.field3039, Client.field1778.field1071);
						var12.field2984.method8241(var1);
						Client.field1778.method2078(var12);
					}
				}
			}

			if (var2 == 29) {
				var16 = class185.method3435(class274.field3039, Client.field1778.field1071);
				var16.field2984.method8241(var1);
				Client.field1778.method2078(var16);
				var20 = class282.method5426(var1);
				if (null != var20 && null != var20.field3613 && 5 == var20.field3613[0][0]) {
					var13 = var20.field3613[0][1];
					if (class293.field3370[var13] != var20.field3592[0]) {
						class293.field3370[var13] = var20.field3592[0];
						class147.method2521(var13);
					}
				}
			}

			if (var2 == 3) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3121, Client.field1778.field1071);
				var16.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8337(class36.field241 + var0);
				var16.field2984.method8161(var1 + class169.field1536);
				var16.field2984.method8181(var3);
				Client.field1778.method2078(var16);
			}

			if (var2 == 16) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3057, Client.field1778.field1071);
				var16.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8337(var1 + class169.field1536);
				var16.field2984.method8159(class54.field385);
				var16.field2984.method8161(var3);
				var16.field2984.method8171(class213.field2493);
				var16.field2984.method8159(class6.field23);
				var16.field2984.method8181(var0 + class36.field241);
				Client.field1778.method2078(var16);
			}

			if (var2 == 12) {
				var15 = Client.field1902[var3];
				if (null != var15) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3078, Client.field1778.field1071);
					var18.field2984.method8159(var3);
					var18.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 2) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3093, Client.field1778.field1071);
				var16.field2984.method8353(class106.field1066);
				var16.field2984.method8337(var3);
				var16.field2984.method8159(class169.field1536 + var1);
				var16.field2984.method8337(Client.field1806);
				var16.field2984.method8161(Client.field1805);
				var16.field2984.method8161(var0 + class36.field241);
				var16.field2984.method8152(Client.field1876.method3895(82) ? 1 : 0);
				Client.field1778.method2078(var16);
			}

			if (var2 == 33) {
				var16 = class185.method3435(class274.field3067, Client.field1778.field1071);
				var16.field2984.method8181(var4);
				var16.field2984.method8181(var0);
				var16.field2984.method8241(var1);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 13) {
				var15 = Client.field1902[var3];
				if (var15 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3048, Client.field1778.field1071);
					var18.field2984.method8161(var3);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 5) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3050, Client.field1778.field1071);
				var16.field2984.method8337(var1 + class169.field1536);
				var16.field2984.method8337(class36.field241 + var0);
				var16.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8159(var3);
				Client.field1778.method2078(var16);
			}

			if (var2 == 10) {
				var15 = Client.field1902[var3];
				if (null != var15) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3122, Client.field1778.field1071);
					var18.field2984.method8337(var3);
					var18.field2984.method8104(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 23) {
				if (Client.field1784) {
					class145.field1333.method4160();
				} else {
					class145.field1333.method4159(class55.field396, var0, var1, true);
				}
			}

			if (var2 == 18) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3080, Client.field1778.field1071);
				var16.field2984.method8181(var3);
				var16.field2984.method8161(var0 + class36.field241);
				var16.field2984.method8348(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8159(var1 + class169.field1536);
				Client.field1778.method2078(var16);
			}

			if (var2 == 32) {
				var16 = class185.method3435(class274.field3041, Client.field1778.field1071);
				var16.field2984.method8159(Client.field1805);
				var16.field2984.method8161(var0);
				var16.field2984.method8155(var1);
				var16.field2984.method8241(class106.field1066);
				var16.field2984.method8159(var4);
				Client.field1778.method2078(var16);
				Client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				Client.field1888 = var0;
			}

			if (var2 == 4) {
				Client.field1657 = var7;
				Client.field1749 = var8;
				Client.field1751 = 2;
				Client.field1904 = 0;
				Client.field1889 = var0;
				Client.field1890 = var1;
				var16 = class185.method3435(class274.field3132, Client.field1778.field1071);
				var16.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
				var16.field2984.method8181(class36.field241 + var0);
				var16.field2984.method8337(var3);
				var16.field2984.method8159(var1 + class169.field1536);
				Client.field1778.method2078(var16);
			}

			if (var2 == 9) {
				var15 = Client.field1902[var3];
				if (null != var15) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3069, Client.field1778.field1071);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					var18.field2984.method8181(var3);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 51) {
				var17 = Client.field1763[var3];
				if (var17 != null) {
					Client.field1657 = var7;
					Client.field1749 = var8;
					Client.field1751 = 2;
					Client.field1904 = 0;
					Client.field1889 = var0;
					Client.field1890 = var1;
					var18 = class185.method3435(class274.field3095, Client.field1778.field1071);
					var18.field2984.method8337(var3);
					var18.field2984.method8264(Client.field1876.method3895(82) ? 1 : 0);
					Client.field1778.method2078(var18);
				}
			}

			if (var2 == 26) {
				class339.method6316();
			}

			if (var2 == 25) {
				var10 = class253.method5043(var1, var0);
				if (var10 != null) {
					class100.method1989();
					class247.method4960(var1, var0, class290.method2693(class190.method3528(var10)), var4);
					Client.field1802 = 0;
					Client.field1653 = class323.method6203(var10);
					if (null == Client.field1653) {
						Client.field1653 = class338.field3899;
					}

					if (var10.field3459) {
						Client.field1754 = var10.field3545 + class96.method4510(16777215);
					} else {
						Client.field1754 = class96.method4510(65280) + var10.field3594 + class96.method4510(16777215);
					}
				}

			} else {
				if (0 != Client.field1802) {
					Client.field1802 = 0;
					class136.method2438(class282.method5426(class213.field2493));
				}

				if (Client.field1804) {
					class100.method1989();
				}

				if (null != class132.field1247 && 0 == Client.field1840) {
					class136.method2438(class132.field1247);
				}

			}
		}
	}
}
