public final class class8 {
	static int field34;

	class8() throws Throwable {
		throw new Error();
	}

	public static ProofOfWorkMessage getPowChallengeType(class25 var0) {
		switch(var0.field126) {
		case 0:
			return new class1();
		default:
			throw new IllegalArgumentException();
		}
	}

	public static int method51(int var0) {
		int var2 = 0;
		if (var0 < 0 || var0 >= 65536) {
			var0 >>>= 16;
			var2 += 16;
		}

		if (var0 >= 256) {
			var0 >>>= 8;
			var2 += 8;
		}

		if (var0 >= 16) {
			var0 >>>= 4;
			var2 += 4;
		}

		if (var0 >= 4) {
			var0 >>>= 2;
			var2 += 2;
		}

		if (var0 >= 1) {
			var0 >>>= 1;
			++var2;
		}

		return var2 + var0;
	}

	static final int method53(int var0, int var1) {
		int var3 = class82.method6259(var0 + 45365, var1 + 91923, 4) - 128 + (class82.method6259(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (class82.method6259(var0, var1, 1) - 128 >> 2);
		var3 = 35 + (int)((double)var3 * 0.3D);
		if (var3 < 10) {
			var3 = 10;
		} else if (var3 > 60) {
			var3 = 60;
		}

		return var3;
	}
}
