public class class153 extends class140 {
	static class300 field1414;
	boolean field1413;
	int field1412;
	// $FF: synthetic field
	final class142 this$0;

	class153(class142 var1) {
		this.this$0 = var1;
		this.field1412 = -1;
	}

	void method2467(class460 var1) {
		this.field1412 = var1.method8122();
		this.field1413 = var1.method8141() == 1;
	}

	void method2468(class148 var1) {
		var1.method2551(this.field1412, this.field1413);
	}

	static int method2594(int var0, class78 var1, boolean var2) {
		int var4;
		int var5;
		int var7;
		if (3400 == var0) {
			class387.field4452 -= 2;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			class192 var6 = class175.method2755(var4);
			if ('s' != var6.field2030) {
			}

			for (var7 = 0; var7 < var6.field2033; ++var7) {
				if (var5 == var6.field2036[var7]) {
					class57.field405[++class126.field1220 - 1] = var6.field2027[var7];
					var6 = null;
					break;
				}
			}

			if (var6 != null) {
				class57.field405[++class126.field1220 - 1] = var6.field2031;
			}

			return 1;
		} else if (var0 != 3408) {
			if (3411 == var0) {
				var4 = class57.field404[--class387.field4452];
				class192 var11 = class175.method2755(var4);
				class57.field404[++class387.field4452 - 1] = var11.method3548();
				return 1;
			} else {
				return 2;
			}
		} else {
			class387.field4452 -= 4;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[class387.field4452 + 1];
			int var10 = class57.field404[2 + class387.field4452];
			var7 = class57.field404[class387.field4452 + 3];
			class192 var8 = class175.method2755(var10);
			if (var8.field2037 == var4 && var5 == var8.field2030) {
				for (int var9 = 0; var9 < var8.field2033; ++var9) {
					if (var8.field2036[var9] == var7) {
						if (var5 == 115) {
							class57.field405[++class126.field1220 - 1] = var8.field2027[var9];
						} else {
							class57.field404[++class387.field4452 - 1] = var8.field2035[var9];
						}

						var8 = null;
						break;
					}
				}

				if (null != var8) {
					if (var5 == 115) {
						class57.field405[++class126.field1220 - 1] = var8.field2031;
					} else {
						class57.field404[++class387.field4452 - 1] = var8.field2029;
					}
				}

				return 1;
			} else {
				if (115 == var5) {
					class57.field405[++class126.field1220 - 1] = class338.field3899;
				} else {
					class57.field404[++class387.field4452 - 1] = 0;
				}

				return 1;
			}
		}
	}

	static final void method2595(class300 var0, class198 var1, int var2, int var3, boolean var4) {
		String[] var6 = var1.field2149;
		byte var7 = -1;
		String var8 = null;
		if (null != var6 && var6[var3] != null) {
			if (var3 == 0) {
				var7 = 33;
			} else if (var3 == 1) {
				var7 = 34;
			} else if (var3 == 2) {
				var7 = 35;
			} else if (3 == var3) {
				var7 = 36;
			} else {
				var7 = 37;
			}

			var8 = var6[var3];
		} else if (4 == var3) {
			var7 = 37;
			var8 = class338.field3893;
		}

		if (-1 != var7 && null != var8) {
			class105.method2042(var8, class96.method4510(16748608) + var1.field2131, var7, 0, var2, var0.field3517, var1.field2129, var4);
		}

	}
}
