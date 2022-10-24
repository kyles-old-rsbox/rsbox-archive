public class class232 extends class251 {
	class260 field2758;
	int field2753;
	int field2754;
	int field2755;
	final class243 field2757;
	final int field2756;

	class232(class295 var1, class295 var2, int var3, class243 var4) {
		super(var1, var2);
		this.field2756 = var3;
		this.field2757 = var4;
		this.method4543();
	}

	void method4543() {
		this.field2755 = class89.method1866(this.field2756).method3588().field2081;
		this.field2758 = this.field2757.method4761(class90.method1885(this.field2755));
		class160 var2 = class90.method1885(this.method5024());
		class473 var3 = var2.method2644(false);
		if (var3 != null) {
			this.field2753 = var3.field4959;
			this.field2754 = var3.field4951;
		} else {
			this.field2753 = 0;
			this.field2754 = 0;
		}

	}

	public static int method4556(int var0, int var1) {
		int var3;
		for (var3 = 1; var1 > 1; var1 >>= 1) {
			if (0 != (var1 & 1)) {
				var3 *= var0;
			}

			var0 *= var0;
		}

		if (1 == var1) {
			return var0 * var3;
		} else {
			return var3;
		}
	}

	public int method5024() {
		return this.field2755;
	}

	class260 method5030() {
		return this.field2758;
	}

	int method5012() {
		return this.field2753;
	}

	int method5013() {
		return this.field2754;
	}
}
