public class class213 {
	static int field2493;

	class213() throws Throwable {
		throw new Error();
	}

	public static class451 method4117(int var0) {
		int var2 = class450.field4841[var0];
		if (var2 == 1) {
			return class451.field4848;
		} else if (var2 == 2) {
			return class451.field4850;
		} else {
			return var2 == 3 ? class451.field4842 : null;
		}
	}

	public static class193 method4120(int var0) {
		class193 var2 = (class193)class193.field2040.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class19.field97.method6175(11, var0);
			var2 = new class193();
			if (var3 != null) {
				var2.method3553(new Buffer(var3));
			}

			var2.method3565();
			class193.field2040.method5434(var2, (long)var0);
			return var2;
		}
	}

	public static int method4119(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var7 = var3;
			var3 = var4;
			var4 = var7;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var1;
		} else if (var2 == 1) {
			return 7 - var0 - (var3 - 1);
		} else {
			return var2 == 2 ? 7 - var1 - (var4 - 1) : var0;
		}
	}

	static class459 method4118(int var0) {
		class459 var2 = (class459)client.field1926.method5439((long)var0);
		if (var2 == null) {
			var2 = new class459(class255.field2944, class444.method7142(var0), class444.method6199(var0));
			client.field1926.method5434(var2, (long)var0);
		}

		return var2;
	}
}
