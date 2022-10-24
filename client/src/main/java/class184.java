public class class184 extends class437 {
	public static class284 field1947;
	static final int[] field1949;
	public int field1945;
	public int field1946;
	public int field1948;

	static {
		field1947 = new class284(64);
		field1949 = new int[32];
		int var0 = 2;

		for (int var1 = 0; var1 < 32; ++var1) {
			field1949[var1] = var0 - 1;
			var0 += var0;
		}

	}

	class184() {
	}

	public static void method2019(class319 var0) {
		class326.field3804 = var0;
	}

	void method3405(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3403(var1, var3);
		}
	}

	void method3403(class460 var1, int var2) {
		if (1 == var2) {
			this.field1945 = var1.method8122();
			this.field1946 = var1.method8141();
			this.field1948 = var1.method8141();
		}

	}
}
