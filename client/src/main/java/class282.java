public class class282 {
	static int field3209;
	static int[] field3212;

	static {
		new Object();
		field3212 = new int[33];
		field3212[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field3212[var1] = var0 - 1;
			var0 += var0;
		}

	}

	public static int method5406(class460 var0, String var1) {
		int var3 = var0.field4878;
		byte[] var4 = class262.method5149(var1);
		var0.method8247(var4.length);
		var0.field4878 += class307.field3673.method6052(var4, 0, var4.length, var0.field4881, var0.field4878);
		return var0.field4878 - var3;
	}

	class282() throws Throwable {
		throw new Error();
	}

	public static int method6306(int var0) {
		return field3212[var0];
	}

	public static int method4111(int var0) {
		var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
		var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
		var0 = (var0 >>> 4) + var0 & 252645135;
		var0 += var0 >>> 8;
		var0 += var0 >>> 16;
		return var0 & 255;
	}

	public static int method651(int var0, int var1, int var2) {
		int var4 = method6306(1 + (var2 - var1));
		var4 <<= var1;
		return var0 & ~var4;
	}

	public static int method5041(int var0, int var1, int var2) {
		int var4 = method6306(1 + (var2 - var1));
		var4 <<= var1;
		var0 |= var4;
		return var0;
	}

	static int method5416(int var0) {
		class63 var2 = (class63)class110.field1089.method7788((long)var0);
		if (null == var2) {
			return -1;
		} else {
			return class110.field1088.field4305 == var2.field4725 ? -1 : ((class63)var2.field4725).field496;
		}
	}

	public static int method953(int var0) {
		--var0;
		var0 |= var0 >>> 1;
		var0 |= var0 >>> 2;
		var0 |= var0 >>> 4;
		var0 |= var0 >>> 8;
		var0 |= var0 >>> 16;
		return var0 + 1;
	}

	public static int method5210(int var0, int var1) {
		int var3 = var0 >>> 31;
		return (var3 + var0) / var1 - var3;
	}

	public static class300 method5426(int var0) {
		int var2 = var0 >> 16;
		int var3 = var0 & 65535;
		if (class300.field3593[var2] == null || class300.field3593[var2][var3] == null) {
			boolean var4 = class246.method4928(var2);
			if (!var4) {
				return null;
			}
		}

		return class300.field3593[var2][var3];
	}
}
