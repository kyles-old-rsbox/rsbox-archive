public class class410 {
	public static final class410 field4551;
	public static final class410 field4552;
	public static final class410 field4554;

	static {
		field4554 = new class410();
		field4551 = new class410();
		field4552 = new class410();
	}

	class410() {
	}

	public static void method7410(int var0, int var1) {
		class184 var3 = class451.method7975(var0);
		int var4 = var3.field1945;
		int var5 = var3.field1946;
		int var6 = var3.field1948;
		int var7 = class293.field3372[var6 - var5];
		if (var1 < 0 || var1 > var7) {
			var1 = 0;
		}

		var7 <<= var5;
		class293.varps[var4] = class293.varps[var4] & ~var7 | var1 << var5 & var7;
	}
}
