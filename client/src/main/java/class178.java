public class class178 extends class437 {
	public static class319 field1593;
	public static int field1592;
	static class284 field1590;
	static int field1595;
	public int field1591;

	static {
		field1590 = new class284(64);
	}

	static void method2835(String[] var0, short[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var5 = (var2 + var3) / 2;
			int var6 = var2;
			String var7 = var0[var5];
			var0[var5] = var0[var3];
			var0[var3] = var7;
			short var8 = var1[var5];
			var1[var5] = var1[var3];
			var1[var3] = var8;

			for (int var9 = var2; var9 < var3; ++var9) {
				if (null == var7 || var0[var9] != null && var0[var9].compareTo(var7) < (var9 & 1)) {
					String var10 = var0[var9];
					var0[var9] = var0[var6];
					var0[var6] = var10;
					short var11 = var1[var9];
					var1[var9] = var1[var6];
					var1[var6++] = var11;
				}
			}

			var0[var3] = var0[var6];
			var0[var6] = var7;
			var1[var3] = var1[var6];
			var1[var6] = var8;
			method2835(var0, var1, var2, var6 - 1);
			method2835(var0, var1, var6 + 1, var3);
		}

	}

	class178() {
		this.field1591 = 0;
	}

	void method2837(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method2828(var1, var3);
		}
	}

	void method2828(class460 var1, int var2) {
		if (var2 == 5) {
			this.field1591 = var1.method8122();
		}

	}

	public static void method2666() {
		field1590.method5437();
	}

	static boolean method2827(char var0) {
		for (int var2 = 0; var2 < class75.field641.length(); ++var2) {
			if (var0 == class75.field641.charAt(var2)) {
				return true;
			}
		}

		return false;
	}
}
