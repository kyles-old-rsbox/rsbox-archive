public class class349 {
	public static final char[] field4270;
	static String field4269;

	static {
		field4270 = new char[]{'\u20ac', '\u0000', '\u201a', '\u0192', '\u201e', '\u2026', '\u2020', '\u2021', '\u02c6', '\u2030', '\u0160', '\u2039', '\u0152', '\u0000', '\u017d', '\u0000', '\u0000', '\u2018', '\u2019', '\u201c', '\u201d', '\u2022', '\u2013', '\u2014', '\u02dc', '\u2122', '\u0161', '\u203a', '\u0153', '\u0000', '\u017e', '\u0178'};
	}

	class349() throws Throwable {
		throw new Error();
	}

	static final void method6457() {
		if (null != class88.field794) {
			class88.field794.method405();
		}

		if (class91.field886 != null) {
			class91.field886.method405();
		}

	}

	static final void method6447(int var0, int var1, boolean var2) {
		if (null != client.field1883[var0]) {
			if (var1 >= 0 && var1 < client.field1883[var0].method2512()) {
				class133 var4 = (class133)client.field1883[var0].field1347.get(var1);
				class263 var5 = class185.method3435(class274.field3133, client.field1778.field1071);
				var5.field2984.method8104(4 + class460.method1887(var4.field1254.method8451()));
				var5.field2984.method8104(var0);
				var5.field2984.method8181(var1);
				var5.field2984.method8110(var2);
				var5.field2984.method8111(var4.field1254.method8451());
				client.field1778.method2078(var5);
			}
		}
	}
}
