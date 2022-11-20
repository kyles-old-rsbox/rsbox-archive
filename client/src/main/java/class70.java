public final class class70 extends class427 {
	static NodeDeque field563;
	class195 field571;
	class44 field565;
	class44 field569;
	int field557;
	int field558;
	int field559;
	int field560;
	int field562;
	int field564;
	int field566;
	int field567;
	int field568;
	int field570;
	int[] field561;

	static {
		field563 = new NodeDeque();
	}

	class70() {
	}

	void method1419() {
		int var2 = this.field564;
		class195 var3 = this.field571.method3588();
		if (var3 != null) {
			this.field564 = var3.field2097;
			this.field560 = var3.field2098 * 128;
			this.field566 = var3.field2086;
			this.field567 = var3.field2102;
			this.field561 = var3.field2101;
		} else {
			this.field564 = -1;
			this.field560 = 0;
			this.field566 = 0;
			this.field567 = 0;
			this.field561 = null;
		}

		if (this.field564 != var2 && null != this.field565) {
			class451.field4849.method737(this.field565);
			this.field565 = null;
		}

	}
}
