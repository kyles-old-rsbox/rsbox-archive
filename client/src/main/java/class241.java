public final class class241 {
	final int[] field2828;

	class241() {
		this.field2828 = new int[4096];
	}

	class241(int[] var1) {
		this.field2828 = var1;
	}

	final int method4726(int var1, int var2) {
		return this.field2828[var2 * 64 + var1];
	}

	public static int method4729(byte[] var0, int var1, int var2) {
		int var4 = -1;

		for (int var5 = var1; var5 < var2; ++var5) {
			var4 = var4 >>> 8 ^ class460.field4883[(var4 ^ var0[var5]) & 255];
		}

		var4 = ~var4;
		return var4;
	}
}
