import java.util.Comparator;

final class class326 implements Comparator {
	static class319 field3804;

	static void method6234(String[] var0, int[] var1, int var2, int var3) {
		if (var2 < var3) {
			int var5 = (var3 + var2) / 2;
			int var6 = var2;
			String var7 = var0[var5];
			var0[var5] = var0[var3];
			var0[var3] = var7;
			int var8 = var1[var5];
			var1[var5] = var1[var3];
			var1[var3] = var8;

			for (int var9 = var2; var9 < var3; ++var9) {
				if (null == var7 || var0[var9] != null && var0[var9].compareTo(var7) < (var9 & 1)) {
					String var10 = var0[var9];
					var0[var9] = var0[var6];
					var0[var6] = var10;
					int var11 = var1[var9];
					var1[var9] = var1[var6];
					var1[var6++] = var11;
				}
			}

			var0[var3] = var0[var6];
			var0[var6] = var7;
			var1[var3] = var1[var6];
			var1[var6] = var8;
			method6234(var0, var1, var2, var6 - 1);
			method6234(var0, var1, var6 + 1, var3);
		}

	}

	class326() {
	}

	int method6226(class328 var1, class328 var2) {
		return var1.field3807.field4256 < var2.field3807.field4256 ? -1 : (var1.field3807.field4256 == var2.field3807.field4256 ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.method6226((class328)var1, (class328)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}
}
