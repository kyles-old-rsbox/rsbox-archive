public class class55 extends class204 {
	static int field396;

	public static class177 method1123(int var0) {
		class177 var2 = (class177)class177.field1587.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class359.field4313.method6175(5, var0);
			var2 = new class177();
			if (null != var3) {
				var2.method2814(new Buffer(var3));
			}

			class177.field1587.method5434(var2, (long)var0);
			return var2;
		}
	}

	static void method1117(int var0, int var1, int var2, int var3) {
		for (class70 var5 = (class70)class70.field563.method6364(); var5 != null; var5 = (class70)class70.field563.method6358()) {
			if (var5.field564 != -1 || null != var5.field561) {
				int var6 = 0;
				if (var1 > var5.field568) {
					var6 += var1 - var5.field568;
				} else if (var1 < var5.field559) {
					var6 += var5.field559 - var1;
				}

				if (var2 > var5.field562) {
					var6 += var2 - var5.field562;
				} else if (var2 < var5.field570) {
					var6 += var5.field570 - var2;
				}

				if (var6 - 64 <= var5.field560 && class413.clientPreferences.method1736() != 0 && var0 == var5.field558) {
					var6 -= 64;
					if (var6 < 0) {
						var6 = 0;
					}

					int var7 = (var5.field560 - var6) * class413.clientPreferences.method1736() / var5.field560;
					if (var5.field565 == null) {
						if (var5.field564 >= 0) {
							class33 var8 = class33.method610(class11.field48, var5.field564, 0);
							if (var8 != null) {
								class39 var9 = var8.method605().method752(class233.field2759);
								class44 var10 = class44.method829(var9, 100, var7);
								var10.method813(-1);
								class451.field4849.method718(var10);
								var5.field565 = var10;
							}
						}
					} else {
						var5.field565.method814(var7);
					}

					if (var5.field569 == null) {
						if (var5.field561 != null && (var5.field557 -= var3) <= 0) {
							int var12 = (int)(Math.random() * (double)var5.field561.length);
							class33 var13 = class33.method610(class11.field48, var5.field561[var12], 0);
							if (var13 != null) {
								class39 var14 = var13.method605().method752(class233.field2759);
								class44 var11 = class44.method829(var14, 100, var7);
								var11.method813(0);
								class451.field4849.method718(var11);
								var5.field569 = var11;
								var5.field557 = var5.field566 + (int)(Math.random() * (double)(var5.field567 - var5.field566));
							}
						}
					} else {
						var5.field569.method814(var7);
						if (!var5.field569.method7826()) {
							var5.field569 = null;
						}
					}
				} else {
					if (null != var5.field565) {
						class451.field4849.method737(var5.field565);
						var5.field565 = null;
					}

					if (null != var5.field569) {
						class451.field4849.method737(var5.field569);
						var5.field569 = null;
					}
				}
			}
		}

	}

	class55() {
	}

	public boolean method3887(int var1, int var2, int var3, class200 var4) {
		return var2 == super.field2305 && super.field2303 == var3;
	}
}
