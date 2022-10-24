public class class233 {
	static class64 field2759;
	int field2760;
	int field2761;
	int field2765;

	class233() {
	}

	static final class421 method4559(class460 var0, class421 var1) {
		int var3 = var0.method8141();
		int var4;
		if (var1 == null) {
			var4 = class282.method953(var3);
			var1 = new class421(var4);
		}

		for (var4 = 0; var4 < var3; ++var4) {
			boolean var5 = var0.method8141() == 1;
			int var6 = var0.method8312();
			Object var7;
			if (var5) {
				var7 = new class418(var0.method8131());
			} else {
				var7 = new class426(var0.method8126());
			}

			var1.method7781((class427)var7, (long)var6);
		}

		return var1;
	}

	static void method4557(int var0, int var1, int var2, int var3) {
		class87 var5 = (class87)class87.field782.method7855((long)var0);
		if (null == var5) {
			var5 = new class87();
			class87.field782.method7857(var5, (long)var0);
		}

		if (var5.field779.length <= var1) {
			int[] var6 = new int[var1 + 1];
			int[] var7 = new int[1 + var1];

			int var8;
			for (var8 = 0; var8 < var5.field779.length; ++var8) {
				var6[var8] = var5.field779[var8];
				var7[var8] = var5.field783[var8];
			}

			for (var8 = var5.field779.length; var8 < var1; ++var8) {
				var6[var8] = -1;
				var7[var8] = 0;
			}

			var5.field779 = var6;
			var5.field783 = var7;
		}

		var5.field779[var1] = var2;
		var5.field783[var1] = var3;
	}

	static String method4558(int var0) {
		if (var0 < 0) {
			return "";
		} else {
			return client.field1923[var0].length() > 0 ? client.field1791[var0] + class338.field4064 + client.field1923[var0] : client.field1791[var0];
		}
	}
}
