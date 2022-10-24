public class class270 {
	class270() throws Throwable {
		throw new Error();
	}

	static int method5208(class72 var0, class72 var1, int var2, boolean var3) {
		if (1 == var2) {
			int var5 = var0.field593;
			int var6 = var1.field593;
			if (!var3) {
				if (var5 == -1) {
					var5 = 2001;
				}

				if (-1 == var6) {
					var6 = 2001;
				}
			}

			return var5 - var6;
		} else if (2 == var2) {
			return var0.field580 - var1.field580;
		} else if (var2 == 3) {
			if (var0.field588.equals("-")) {
				if (var1.field588.equals("-")) {
					return 0;
				} else {
					return var3 ? -1 : 1;
				}
			} else if (var1.field588.equals("-")) {
				return var3 ? 1 : -1;
			} else {
				return var0.field588.compareTo(var1.field588);
			}
		} else if (4 == var2) {
			return var0.method1437() ? (var1.method1437() ? 0 : 1) : (var1.method1437() ? -1 : 0);
		} else if (5 == var2) {
			return var0.method1439() ? (var1.method1439() ? 0 : 1) : (var1.method1439() ? -1 : 0);
		} else if (6 == var2) {
			return var0.method1440() ? (var1.method1440() ? 0 : 1) : (var1.method1440() ? -1 : 0);
		} else if (7 == var2) {
			return var0.method1447() ? (var1.method1447() ? 0 : 1) : (var1.method1447() ? -1 : 0);
		} else {
			return var0.field590 - var1.field590;
		}
	}
}
