public class class102 {
	static byte[] field1019;
	static class197[] field1010;
	static class460 field1021;
	static class460[] field1011;
	static int field1007;
	static int field1012;
	static int field1017;
	static int[] field1013;
	static int[] field1014;
	static int[] field1015;
	static int[] field1016;
	static int[] field1018;
	static int[] field1020;
	static short[] field1009;

	static {
		field1019 = new byte[2048];
		field1010 = new class197[2048];
		field1011 = new class460[2048];
		field1012 = 0;
		field1013 = new int[2048];
		field1017 = 0;
		field1015 = new int[2048];
		field1016 = new int[2048];
		field1014 = new int[2048];
		field1018 = new int[2048];
		field1007 = 0;
		field1020 = new int[2048];
		field1021 = new class460(new byte[5000]);
	}

	class102() throws Throwable {
		throw new Error();
	}

	static final void method4730(class453 var0) {
		var0.method8013();
		int var2 = client.field1764;
		class93 var3 = class291.field3364 = client.field1763[var2] = new class93();
		var3.field915 = var2;
		int var4 = var0.method8014(30);
		byte var5 = (byte)(var4 >> 28);
		int var6 = var4 >> 14 & 16383;
		int var7 = var4 & 16383;
		var3.field861[0] = var6 - class36.field241;
		var3.field827 = (var3.field861[0] << 7) + (var3.method1916() << 6);
		var3.field873[0] = var7 - class169.field1536;
		var3.field802 = (var3.field873[0] << 7) + (var3.method1916() << 6);
		class55.field396 = var3.field914 = var5;
		if (null != field1011[var2]) {
			var3.decodeAppearance(field1011[var2]);
		}

		field1012 = 0;
		field1013[++field1012 - 1] = var2;
		field1019[var2] = 0;
		field1017 = 0;

		for (int var8 = 1; var8 < 2048; ++var8) {
			if (var2 != var8) {
				int var9 = var0.method8014(18);
				int var10 = var9 >> 16;
				int var11 = var9 >> 8 & 597;
				int var12 = var9 & 597;
				field1016[var8] = (var11 << 14) + (var10 << 28) + var12;
				field1014[var8] = 0;
				field1018[var8] = -1;
				field1015[++field1017 - 1] = var8;
				field1019[var8] = 0;
			}
		}

		var0.method8010();
	}
}
