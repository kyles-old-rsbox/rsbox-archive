public final class class235 {
	int field2781;
	int field2782;
	int field2783;
	int field2786;
	// $FF: synthetic field
	final class246 this$0;

	class235(class246 var1) {
		this.this$0 = var1;
	}

	static void method4586(class300 var0, int var1, int var2, boolean var3) {
		int var5 = var0.field3448;
		int var6 = var0.field3476;
		if (0 == var0.field3508) {
			var0.field3448 = var0.field3486;
		} else if (var0.field3508 == 1) {
			var0.field3448 = var1 - var0.field3486;
		} else if (var0.field3508 == 2) {
			var0.field3448 = var0.field3486 * var1 >> 14;
		}

		if (var0.field3468 == 0) {
			var0.field3476 = var0.field3472;
		} else if (var0.field3468 == 1) {
			var0.field3476 = var2 - var0.field3472;
		} else if (var0.field3468 == 2) {
			var0.field3476 = var0.field3472 * var2 >> 14;
		}

		if (4 == var0.field3508) {
			var0.field3448 = var0.field3476 * var0.field3477 / var0.field3511;
		}

		if (4 == var0.field3468) {
			var0.field3476 = var0.field3511 * var0.field3448 / var0.field3477;
		}

		if (1337 == var0.field3464) {
			client.field1821 = var0;
		}

		if (var0.field3462 == 12) {
			var0.method5877().method5565(var0.field3448, var0.field3476);
		}

		if (var3 && null != var0.field3586 && (var0.field3448 != var5 || var0.field3476 != var6)) {
			ClientScript var7 = new ClientScript();
			var7.field694 = var0;
			var7.args = var0.field3586;
			client.field1765.method6355(var7);
		}

	}
}
