import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class class11 extends Canvas {
	static class336 field48;
	static int field45;
	static int field47;
	Component field44;

	class11(Component var1) {
		this.field44 = var1;
	}

	public final void update(Graphics var1) {
		this.field44.update(var1);
	}

	public final void paint(Graphics var1) {
		this.field44.paint(var1);
	}

	public static String method86(int var0, boolean var1) {
		if (var1 && var0 >= 0) {
			int var4 = var0;
			String var3;
			if (var1 && var0 >= 0) {
				int var5 = 2;

				for (int var6 = var0 / 10; 0 != var6; ++var5) {
					var6 /= 10;
				}

				char[] var7 = new char[var5];
				var7[0] = '+';

				for (int var8 = var5 - 1; var8 > 0; --var8) {
					int var9 = var4;
					var4 /= 10;
					int var10 = var9 - var4 * 10;
					if (var10 >= 10) {
						var7[var8] = (char)(var10 + 87);
					} else {
						var7[var8] = (char)(var10 + 48);
					}
				}

				var3 = new String(var7);
			} else {
				var3 = Integer.toString(var0, 10);
			}

			return var3;
		} else {
			return Integer.toString(var0);
		}
	}

	static int method84(int var0, class78 var1, boolean var2) {
		int var4;
		int var5;
		if (var0 == 100) {
			class387.field4452 -= 3;
			var4 = class57.field404[class387.field4452];
			var5 = class57.field404[1 + class387.field4452];
			int var6 = class57.field404[class387.field4452 + 2];
			if (0 == var5) {
				throw new RuntimeException();
			} else {
				class300 var7 = class282.method5426(var4);
				if (null == var7.field3602) {
					var7.field3602 = new class300[1 + var6];
				}

				if (var7.field3602.length <= var6) {
					class300[] var8 = new class300[1 + var6];

					for (int var9 = 0; var9 < var7.field3602.length; ++var9) {
						var8[var9] = var7.field3602[var9];
					}

					var7.field3602 = var8;
				}

				if (var6 > 0 && var7.field3602[var6 - 1] == null) {
					throw new RuntimeException("" + (var6 - 1));
				} else {
					class300 var13 = new class300();
					var13.field3462 = var5;
					var13.field3596 = var13.field3517 = var7.field3517;
					var13.field3484 = var6;
					var13.field3459 = true;
					if (var5 == 12) {
						var13.method5921();
						var13.method5877().method5607(new class92(var13));
						var13.method5877().method5606(new class100(var13));
					}

					var7.field3602[var6] = var13;
					if (var2) {
						class138.field1284 = var13;
					} else {
						class153.field1414 = var13;
					}

					class136.method2438(var7);
					return 1;
				}
			}
		} else {
			class300 var10;
			if (var0 == 101) {
				var10 = var2 ? class138.field1284 : class153.field1414;
				class300 var11 = class282.method5426(var10.field3517);
				var11.field3602[var10.field3484] = null;
				class136.method2438(var11);
				return 1;
			} else if (var0 == 102) {
				var10 = class282.method5426(class57.field404[--class387.field4452]);
				var10.field3602 = null;
				class136.method2438(var10);
				return 1;
			} else if (var0 != 200) {
				if (var0 == 201) {
					var10 = class282.method5426(class57.field404[--class387.field4452]);
					if (null != var10) {
						class57.field404[++class387.field4452 - 1] = 1;
						if (var2) {
							class138.field1284 = var10;
						} else {
							class153.field1414 = var10;
						}
					} else {
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else {
					return 2;
				}
			} else {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				class300 var12 = class253.method5043(var4, var5);
				if (var12 != null && -1 != var5) {
					class57.field404[++class387.field4452 - 1] = 1;
					if (var2) {
						class138.field1284 = var12;
					} else {
						class153.field1414 = var12;
					}
				} else {
					class57.field404[++class387.field4452 - 1] = 0;
				}

				return 1;
			}
		}
	}

	static String method76(String var0, class300 var1) {
		if (var0.indexOf("%") != -1) {
			for (int var3 = 1; var3 <= 5; ++var3) {
				while (true) {
					int var4 = var0.indexOf("%" + var3);
					if (var4 == -1) {
						break;
					}

					var0 = var0.substring(0, var4) + class176.method2812(class262.method5150(var1, var3 - 1)) + var0.substring(2 + var4);
				}
			}
		}

		return var0;
	}
}
