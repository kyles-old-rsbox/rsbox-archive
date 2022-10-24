import java.util.Comparator;

final class class327 implements Comparator {
	int method6235(class328 var1, class328 var2) {
		return var1.field3805 < var2.field3805 ? -1 : (var1.field3805 == var2.field3805 ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.method6235((class328)var1, (class328)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	static void method6242(class300 var0, int var1, int var2) {
		if (0 == var0.field3465) {
			var0.field3473 = var0.field3469;
		} else if (1 == var0.field3465) {
			var0.field3473 = var0.field3469 + (var1 - var0.field3448) / 2;
		} else if (var0.field3465 == 2) {
			var0.field3473 = var1 - var0.field3448 - var0.field3469;
		} else if (var0.field3465 == 3) {
			var0.field3473 = var0.field3469 * var1 >> 14;
		} else if (4 == var0.field3465) {
			var0.field3473 = (var1 * var0.field3469 >> 14) + (var1 - var0.field3448) / 2;
		} else {
			var0.field3473 = var1 - var0.field3448 - (var1 * var0.field3469 >> 14);
		}

		if (0 == var0.field3466) {
			var0.field3551 = var0.field3470;
		} else if (var0.field3466 == 1) {
			var0.field3551 = var0.field3470 + (var2 - var0.field3476) / 2;
		} else if (var0.field3466 == 2) {
			var0.field3551 = var2 - var0.field3476 - var0.field3470;
		} else if (var0.field3466 == 3) {
			var0.field3551 = var2 * var0.field3470 >> 14;
		} else if (4 == var0.field3466) {
			var0.field3551 = (var2 - var0.field3476) / 2 + (var0.field3470 * var2 >> 14);
		} else {
			var0.field3551 = var2 - var0.field3476 - (var2 * var0.field3470 >> 14);
		}

	}
}
