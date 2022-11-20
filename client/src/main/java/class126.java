public class class126 implements class360 {
	static int field1220;
	static final class126 field1208;
	static final class126 field1210;
	static final class126 field1211;
	static final class126 field1212;
	static final class126 field1213;
	static final class126 field1219;
	final int field1214;
	final int field1215;
	final int field1216;

	static {
		field1219 = new class126(0, 0, (String)null, 0);
		field1212 = new class126(1, 1, (String)null, 9);
		field1210 = new class126(2, 2, (String)null, 3);
		field1211 = new class126(3, 3, (String)null, 6);
		field1208 = new class126(4, 4, (String)null, 1);
		field1213 = new class126(5, 5, (String)null, 3);
	}

	public static class112 method2372(class319 var0, class319 var1, int var2, boolean var3) {
		boolean var5 = true;
		byte[] var6 = var0.method6131(var2 >> 16 & 65535, var2 & 65535);
		if (var6 == null) {
			var5 = false;
			return null;
		} else {
			int var7 = (var6[1] & 255) << 8 | var6[2] & 255;
			byte[] var8;
			if (var3) {
				var8 = var1.method6131(0, var7);
			} else {
				var8 = var1.method6131(var7, 0);
			}

			if (null == var8) {
				var5 = false;
			}

			if (!var5) {
				return null;
			} else {
				try {
					return new class112(var0, var1, var2, var3);
				} catch (Exception var10) {
					return null;
				}
			}
		}
	}

	class126(int var1, int var2, String var3, int var4) {
		this.field1214 = var1;
		this.field1215 = var2;
		this.field1216 = var4;
	}

	int method2367() {
		return this.field1216;
	}

	public int rsOrdinal() {
		return this.field1215;
	}

	public static String method2371(byte[] var0, int var1, int var2) {
		char[] var4 = new char[var2];
		int var5 = 0;

		for (int var6 = 0; var6 < var2; ++var6) {
			int var7 = var0[var1 + var6] & 255;
			if (var7 != 0) {
				if (var7 >= 128 && var7 < 160) {
					char var8 = class349.field4270[var7 - 128];
					if (var8 == 0) {
						var8 = '?';
					}

					var7 = var8;
				}

				var4[var5++] = (char)var7;
			}
		}

		return new String(var4, 0, var5);
	}
}
