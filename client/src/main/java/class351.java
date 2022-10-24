public class class351 {
	public static char[] field4277;
	static char[] field4275;
	static char[] field4276;
	static class488 field4278;
	static int[] field4274;

	static {
		field4277 = new char[64];

		int var0;
		for (var0 = 0; var0 < 26; ++var0) {
			field4277[var0] = (char)(var0 + 65);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4277[var0] = (char)(97 + var0 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4277[var0] = (char)(var0 + 48 - 52);
		}

		field4277[62] = '+';
		field4277[63] = '/';
		field4275 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field4275[var0] = (char)(65 + var0);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4275[var0] = (char)(var0 + 97 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4275[var0] = (char)(48 + var0 - 52);
		}

		field4275[62] = '*';
		field4275[63] = '-';
		field4276 = new char[64];

		for (var0 = 0; var0 < 26; ++var0) {
			field4276[var0] = (char)(65 + var0);
		}

		for (var0 = 26; var0 < 52; ++var0) {
			field4276[var0] = (char)(97 + var0 - 26);
		}

		for (var0 = 52; var0 < 62; ++var0) {
			field4276[var0] = (char)(var0 + 48 - 52);
		}

		field4276[62] = '-';
		field4276[63] = '_';
		field4274 = new int[128];

		for (var0 = 0; var0 < field4274.length; ++var0) {
			field4274[var0] = -1;
		}

		for (var0 = 65; var0 <= 90; ++var0) {
			field4274[var0] = var0 - 65;
		}

		for (var0 = 97; var0 <= 122; ++var0) {
			field4274[var0] = 26 + (var0 - 97);
		}

		for (var0 = 48; var0 <= 57; ++var0) {
			field4274[var0] = var0 - 48 + 52;
		}

		int[] var2 = field4274;
		field4274[43] = 62;
		var2[42] = 62;
		int[] var1 = field4274;
		field4274[47] = 63;
		var1[45] = 63;
	}

	class351() throws Throwable {
		throw new Error();
	}
}
