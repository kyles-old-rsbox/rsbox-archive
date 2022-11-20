public class class187 extends class437 {
	public static class284 field1977;
	public static class319 field1978;
	class421 field1976;

	static {
		field1977 = new class284(64);
	}

	class187() {
	}

	void method3455() {
	}

	void method3459(Buffer var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3448(var1, var3);
		}
	}

	void method3448(Buffer var1, int var2) {
		if (var2 == 249) {
			this.field1976 = class233.method4559(var1, this.field1976);
		}

	}

	public int method3451(int var1, int var2) {
		return class353.method6569(this.field1976, var1, var2);
	}

	public String method3450(int var1, String var2) {
		return class369.method6734(this.field1976, var1, var2);
	}
}
