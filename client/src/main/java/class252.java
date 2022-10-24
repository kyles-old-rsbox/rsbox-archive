public class class252 implements class360 {
	static class336 field2922;
	static final class252 field2916;
	static final class252 field2917;
	static final class252 field2919;
	static final class252 field2923;
	final byte field2921;
	final int field2920;

	static {
		field2916 = new class252(2, (byte)0);
		field2917 = new class252(3, (byte)1);
		field2923 = new class252(1, (byte)2);
		field2919 = new class252(0, (byte)3);
	}

	class252(int var1, byte var2) {
		this.field2920 = var1;
		this.field2921 = var2;
	}

	public int method6663() {
		return this.field2921;
	}

	static int method5040(int var0) {
		class71 var2 = (class71)class110.field1093.get(var0);
		return null == var2 ? 0 : var2.method1429();
	}

	static class300 method5039(class300 var0) {
		int var3 = class190.method3528(var0);
		int var2 = var3 >> 17 & 7;
		int var4 = var2;
		if (0 == var2) {
			return null;
		} else {
			for (int var5 = 0; var5 < var4; ++var5) {
				var0 = class282.method5426(var0.field3596);
				if (null == var0) {
					return null;
				}
			}

			return var0;
		}
	}
}
