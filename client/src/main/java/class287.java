public class class287 {
	static int field3343;

	class287() throws Throwable {
		throw new Error();
	}

	public static int method5453(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
		int var6 = var2 - var1;

		for (int var7 = 0; var7 < var6; ++var7) {
			char var8 = var0.charAt(var1 + var7);
			if (var8 > 0 && var8 < 128 || var8 >= 160 && var8 <= 255) {
				var3[var4 + var7] = (byte)var8;
			} else if (8364 == var8) {
				var3[var4 + var7] = -128;
			} else if (8218 == var8) {
				var3[var7 + var4] = -126;
			} else if (402 == var8) {
				var3[var7 + var4] = -125;
			} else if (8222 == var8) {
				var3[var7 + var4] = -124;
			} else if (var8 == 8230) {
				var3[var7 + var4] = -123;
			} else if (var8 == 8224) {
				var3[var7 + var4] = -122;
			} else if (var8 == 8225) {
				var3[var4 + var7] = -121;
			} else if (var8 == 710) {
				var3[var7 + var4] = -120;
			} else if (var8 == 8240) {
				var3[var7 + var4] = -119;
			} else if (352 == var8) {
				var3[var7 + var4] = -118;
			} else if (8249 == var8) {
				var3[var7 + var4] = -117;
			} else if (var8 == 338) {
				var3[var4 + var7] = -116;
			} else if (var8 == 381) {
				var3[var7 + var4] = -114;
			} else if (8216 == var8) {
				var3[var7 + var4] = -111;
			} else if (8217 == var8) {
				var3[var7 + var4] = -110;
			} else if (var8 == 8220) {
				var3[var7 + var4] = -109;
			} else if (8221 == var8) {
				var3[var4 + var7] = -108;
			} else if (var8 == 8226) {
				var3[var4 + var7] = -107;
			} else if (var8 == 8211) {
				var3[var7 + var4] = -106;
			} else if (8212 == var8) {
				var3[var7 + var4] = -105;
			} else if (var8 == 732) {
				var3[var4 + var7] = -104;
			} else if (8482 == var8) {
				var3[var7 + var4] = -103;
			} else if (var8 == 353) {
				var3[var7 + var4] = -102;
			} else if (var8 == 8250) {
				var3[var7 + var4] = -101;
			} else if (339 == var8) {
				var3[var4 + var7] = -100;
			} else if (382 == var8) {
				var3[var7 + var4] = -98;
			} else if (376 == var8) {
				var3[var7 + var4] = -97;
			} else {
				var3[var7 + var4] = 63;
			}
		}

		return var6;
	}
}
