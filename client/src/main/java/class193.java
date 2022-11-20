public class class193 extends class437 {
	static class284 field2040;
	boolean field2039;
	char field2042;
	public int field2043;
	public String field2041;

	static {
		field2040 = new class284(64);
	}

	class193() {
		this.field2039 = true;
	}

	public static void method5223(class319 var0) {
		class19.field97 = var0;
	}

	void method3565() {
	}

	void method3553(Buffer var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3564(var1, var3);
		}
	}

	void method3564(Buffer var1, int var2) {
		if (var2 == 1) {
			byte var5 = var1.method8287();
			int var6 = var5 & 255;
			if (var6 == 0) {
				throw new IllegalArgumentException("" + Integer.toString(var6, 16));
			}

			if (var6 >= 128 && var6 < 160) {
				char var7 = class349.field4270[var6 - 128];
				if (var7 == 0) {
					var7 = '?';
				}

				var6 = var7;
			}

			char var4 = (char)var6;
			this.field2042 = var4;
		} else if (var2 == 2) {
			this.field2043 = var1.method8126();
		} else if (var2 == 4) {
			this.field2039 = false;
		} else if (var2 == 5) {
			this.field2041 = var1.readString();
		}

	}

	public boolean method3567() {
		return this.field2042 == 's';
	}

	public static void method6197() {
		field2040.method5437();
	}
}
