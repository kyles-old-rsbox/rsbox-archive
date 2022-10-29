public class class177 extends class437 {
	static class284 field1587;
	static int[] field1588;
	public int field1586;

	static {
		field1587 = new class284(64);
	}

	class177() {
		this.field1586 = 0;
	}

	public static void method804(class319 var0) {
		class359.field4313 = var0;
	}

	void method2814(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method2815(var1, var3);
		}
	}

	void method2815(class460 var1, int var2) {
		if (var2 == 2) {
			this.field1586 = var1.method8122();
		}

	}
}
