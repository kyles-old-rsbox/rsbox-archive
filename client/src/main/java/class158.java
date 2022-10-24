public class class158 extends class437 {
	public static class284 field1443;
	public static class284 field1456;
	static class319 field1441;
	static class319 field1452;
	static int field1440;
	static int field1451;
	int field1442;
	int field1449;
	public int field1444;
	public int field1446;
	public int field1447;
	public int field1448;
	public int field1450;
	public int field1453;
	public int field1454;
	public int field1457;

	static {
		field1456 = new class284(64);
		field1443 = new class284(64);
	}

	class158() {
		this.field1446 = 255;
		this.field1447 = 255;
		this.field1448 = -1;
		this.field1454 = 1;
		this.field1450 = 70;
		this.field1449 = -1;
		this.field1442 = -1;
		this.field1453 = 30;
		this.field1444 = 0;
	}

	public static void method1416(class319 var0, class319 var1) {
		field1452 = var0;
		field1441 = var1;
	}

	void method2623(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (0 == var3) {
				return;
			}

			this.method2609(var1, var3);
		}
	}

	void method2609(class460 var1, int var2) {
		if (1 == var2) {
			var1.method8122();
		} else if (var2 == 2) {
			this.field1446 = var1.method8141();
		} else if (3 == var2) {
			this.field1447 = var1.method8141();
		} else if (var2 == 4) {
			this.field1448 = 0;
		} else if (5 == var2) {
			this.field1450 = var1.method8122();
		} else if (6 == var2) {
			var1.method8141();
		} else if (7 == var2) {
			this.field1449 = var1.method8140();
		} else if (8 == var2) {
			this.field1442 = var1.method8140();
		} else if (var2 == 11) {
			this.field1448 = var1.method8122();
		} else if (14 == var2) {
			this.field1453 = var1.method8141();
		} else if (15 == var2) {
			this.field1444 = var1.method8141();
		}

	}

	public static class203 method2632(int var0) {
		class203 var2 = (class203)class203.field2267.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class203.field2293.method6175(9, var0);
			var2 = new class203();
			var2.field2260 = var0;
			if (null != var3) {
				var2.method3853(new class460(var3));
			}

			var2.method3852();
			class203.field2267.method5434(var2, (long)var0);
			return var2;
		}
	}

	public class473 method2631() {
		if (this.field1449 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field1443.method5439((long)this.field1449);
			if (var2 != null) {
				return var2;
			} else {
				var2 = class389.method7014(field1441, this.field1449, 0);
				if (null != var2) {
					field1443.method5434(var2, (long)this.field1449);
				}

				return var2;
			}
		}
	}

	public class473 method2625() {
		if (this.field1442 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field1443.method5439((long)this.field1442);
			if (var2 != null) {
				return var2;
			} else {
				var2 = class389.method7014(field1441, this.field1442, 0);
				if (null != var2) {
					field1443.method5434(var2, (long)this.field1442);
				}

				return var2;
			}
		}
	}

	public static String method2630(String var0) {
		int var2 = var0.length();
		char[] var3 = new char[var2];
		byte var4 = 2;

		for (int var5 = 0; var5 < var2; ++var5) {
			char var6 = var0.charAt(var5);
			if (0 == var4) {
				var6 = Character.toLowerCase(var6);
			} else if (var4 == 2 || Character.isUpperCase(var6)) {
				var6 = class159.method2639(var6);
			}

			if (Character.isLetter(var6)) {
				var4 = 0;
			} else if (var6 != '.' && '?' != var6 && var6 != '!') {
				if (Character.isSpaceChar(var6)) {
					if (2 != var4) {
						var4 = 1;
					}
				} else {
					var4 = 1;
				}
			} else {
				var4 = 2;
			}

			var3[var5] = var6;
		}

		return new String(var3);
	}

	static final int method2633(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (-1 == var0) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = var1 * (var0 & 127) / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1 + (var0 & 65408);
		}
	}
}
