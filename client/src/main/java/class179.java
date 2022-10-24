public class class179 {
	static byte[][][] field1597;
	static class408 field1602;
	static int field1601;
	public short[] field1600;
	public short[] field1603;

	public class179(int var1) {
		class198 var2 = class278.method5388(var1);
		if (var2.method3653()) {
			this.field1603 = new short[var2.field2133.length];
			System.arraycopy(var2.field2133, 0, this.field1603, 0, this.field1603.length);
		}

		if (var2.method3689()) {
			this.field1600 = new short[var2.field2135.length];
			System.arraycopy(var2.field2135, 0, this.field1600, 0, this.field1600.length);
		}

	}

	static int method2843(int var0, class78 var1, boolean var2) {
		if (var0 == 5000) {
			class57.field404[++class387.field4452 - 1] = client.field1871;
			return 1;
		} else if (var0 == 5001) {
			class387.field4452 -= 3;
			client.field1871 = class57.field404[class387.field4452];
			class297.field3431 = class363.method6675(class57.field404[1 + class387.field4452]);
			if (null == class297.field3431) {
				class297.field3431 = class486.field5006;
			}

			client.field1872 = class57.field404[2 + class387.field4452];
			class263 var12 = class185.method3435(class274.field3142, client.field1778.field1071);
			var12.field2984.method8104(client.field1871);
			var12.field2984.method8104(class297.field3431.field5005);
			var12.field2984.method8104(client.field1872);
			client.field1778.method2078(var12);
			return 1;
		} else {
			String var4;
			int var5;
			int var6;
			class263 var7;
			if (5002 == var0) {
				var4 = class57.field405[--class126.field1220];
				class387.field4452 -= 2;
				var5 = class57.field404[class387.field4452];
				var6 = class57.field404[class387.field4452 + 1];
				var7 = class185.method3435(class274.field3112, client.field1778.field1071);
				var7.field2984.method8104(class460.method1887(var4) + 2);
				var7.field2984.method8111(var4);
				var7.field2984.method8104(var5 - 1);
				var7.field2984.method8104(var6);
				client.field1778.method2078(var7);
				return 1;
			} else {
				int var8;
				class63 var9;
				if (var0 == 5003) {
					class387.field4452 -= 2;
					var8 = class57.field404[class387.field4452];
					var5 = class57.field404[1 + class387.field4452];
					var9 = class110.method6313(var8, var5);
					if (null != var9) {
						class57.field404[++class387.field4452 - 1] = var9.field496;
						class57.field404[++class387.field4452 - 1] = var9.field495;
						class57.field405[++class126.field1220 - 1] = null != var9.field500 ? var9.field500 : "";
						class57.field405[++class126.field1220 - 1] = var9.field498 != null ? var9.field498 : "";
						class57.field405[++class126.field1220 - 1] = var9.field503 != null ? var9.field503 : "";
						class57.field404[++class387.field4452 - 1] = var9.method1343() ? 1 : (var9.method1346() ? 2 : 0);
					} else {
						class57.field404[++class387.field4452 - 1] = -1;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
						class57.field405[++class126.field1220 - 1] = "";
						class57.field405[++class126.field1220 - 1] = "";
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else {
					class63 var10;
					if (5004 == var0) {
						var8 = class57.field404[--class387.field4452];
						var10 = class110.method204(var8);
						if (var10 != null) {
							class57.field404[++class387.field4452 - 1] = var10.field497;
							class57.field404[++class387.field4452 - 1] = var10.field495;
							class57.field405[++class126.field1220 - 1] = null != var10.field500 ? var10.field500 : "";
							class57.field405[++class126.field1220 - 1] = null != var10.field498 ? var10.field498 : "";
							class57.field405[++class126.field1220 - 1] = null != var10.field503 ? var10.field503 : "";
							class57.field404[++class387.field4452 - 1] = var10.method1343() ? 1 : (var10.method1346() ? 2 : 0);
						} else {
							class57.field404[++class387.field4452 - 1] = -1;
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field404[++class387.field4452 - 1] = 0;
						}

						return 1;
					} else if (5005 == var0) {
						if (class297.field3431 == null) {
							class57.field404[++class387.field4452 - 1] = -1;
						} else {
							class57.field404[++class387.field4452 - 1] = class297.field3431.field5005;
						}

						return 1;
					} else {
						class263 var13;
						if (5008 == var0) {
							var4 = class57.field405[--class126.field1220];
							var5 = class57.field404[--class387.field4452];
							var13 = class307.method6040(var5, var4, class94.field940, -1);
							client.field1778.method2078(var13);
							return 1;
						} else if (5009 == var0) {
							class126.field1220 -= 2;
							var4 = class57.field405[class126.field1220];
							String var14 = class57.field405[1 + class126.field1220];
							var13 = class185.method3435(class274.field3120, client.field1778.field1071);
							var13.field2984.method8181(0);
							int var11 = var13.field2984.field4878;
							var13.field2984.method8111(var4);
							class282.method5406(var13.field2984, var14);
							var13.field2984.method8117(var13.field2984.field4878 - var11);
							client.field1778.method2078(var13);
							return 1;
						} else if (var0 == 5010) {
							var4 = class57.field405[--class126.field1220];
							class387.field4452 -= 2;
							var5 = class57.field404[class387.field4452];
							var6 = class57.field404[1 + class387.field4452];
							var7 = class307.method6040(var5, var4, class94.field940, var6);
							client.field1778.method2078(var7);
							return 1;
						} else if (5015 != var0) {
							if (var0 == 5016) {
								class57.field404[++class387.field4452 - 1] = client.field1872;
								return 1;
							} else if (var0 == 5017) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class252.method5040(var8);
								return 1;
							} else if (5018 == var0) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class132.method2409(var8);
								return 1;
							} else if (5019 == var0) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class282.method5416(var8);
								return 1;
							} else if (var0 == 5020) {
								var4 = class57.field405[--class126.field1220];
								class31.method506(var4);
								return 1;
							} else if (5021 == var0) {
								client.field1873 = class57.field405[--class126.field1220].toLowerCase().trim();
								return 1;
							} else if (5022 == var0) {
								class57.field405[++class126.field1220 - 1] = client.field1873;
								return 1;
							} else if (5023 == var0) {
								var4 = class57.field405[--class126.field1220];
								System.out.println(var4);
								return 1;
							} else if (var0 == 5030) {
								class387.field4452 -= 2;
								var8 = class57.field404[class387.field4452];
								var5 = class57.field404[class387.field4452 + 1];
								var9 = class110.method6313(var8, var5);
								if (var9 != null) {
									class57.field404[++class387.field4452 - 1] = var9.field496;
									class57.field404[++class387.field4452 - 1] = var9.field495;
									class57.field405[++class126.field1220 - 1] = null != var9.field500 ? var9.field500 : "";
									class57.field405[++class126.field1220 - 1] = null != var9.field498 ? var9.field498 : "";
									class57.field405[++class126.field1220 - 1] = var9.field503 != null ? var9.field503 : "";
									class57.field404[++class387.field4452 - 1] = var9.method1343() ? 1 : (var9.method1346() ? 2 : 0);
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								} else {
									class57.field404[++class387.field4452 - 1] = -1;
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								}

								return 1;
							} else if (5031 == var0) {
								var8 = class57.field404[--class387.field4452];
								var10 = class110.method204(var8);
								if (var10 != null) {
									class57.field404[++class387.field4452 - 1] = var10.field497;
									class57.field404[++class387.field4452 - 1] = var10.field495;
									class57.field405[++class126.field1220 - 1] = var10.field500 != null ? var10.field500 : "";
									class57.field405[++class126.field1220 - 1] = null != var10.field498 ? var10.field498 : "";
									class57.field405[++class126.field1220 - 1] = null != var10.field503 ? var10.field503 : "";
									class57.field404[++class387.field4452 - 1] = var10.method1343() ? 1 : (var10.method1346() ? 2 : 0);
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								} else {
									class57.field404[++class387.field4452 - 1] = -1;
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								}

								return 1;
							} else {
								return 2;
							}
						} else {
							if (class291.field3364 != null && null != class291.field3364.field910) {
								var4 = class291.field3364.field910.method8451();
							} else {
								var4 = "";
							}

							class57.field405[++class126.field1220 - 1] = var4;
							return 1;
						}
					}
				}
			}
		}
	}

	static boolean method2842() {
		return client.field1796 || client.field1876.method3895(81);
	}
}
