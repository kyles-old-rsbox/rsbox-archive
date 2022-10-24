public class class293 {
	public static int[] field3368;
	public static int[] field3370;
	static int[] field3372;

	static {
		field3372 = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			field3372[var1] = var0 - 1;
			var0 += var0;
		}

		field3368 = new int[4000];
		field3370 = new int[4000];
	}

	class293() throws Throwable {
		throw new Error();
	}

	public static int method1557(int var0) {
		class184 var2 = class451.method7975(var0);
		int var3 = var2.field1945;
		int var4 = var2.field1946;
		int var5 = var2.field1948;
		int var6 = field3372[var5 - var4];
		return field3370[var3] >> var4 & var6;
	}

	static final int method5502(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
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
