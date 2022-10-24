public class class103 implements class360 {
	static class433 field1034;
	static final class103 field1025;
	static final class103 field1026;
	static final class103 field1028;
	static final class103 field1029;
	static final class103 field1030;
	static final class103 field1032;
	final int field1027;
	final int field1036;

	static {
		field1032 = new class103(0, -1);
		field1026 = new class103(1, 2);
		field1030 = new class103(2, 3);
		field1028 = new class103(3, 4);
		field1029 = new class103(4, 5);
		field1025 = new class103(5, 6);
	}

	static class103[] method2745() {
		return new class103[]{field1028, field1026, field1029, field1030, field1032, field1025};
	}

	class103(int var1, int var2) {
		this.field1027 = var1;
		this.field1036 = var2;
	}

	public int method6663() {
		return this.field1036;
	}

	static void method2025() {
		for (class70 var1 = (class70)class70.field563.method6364(); null != var1; var1 = (class70)class70.field563.method6358()) {
			if (var1.field565 != null) {
				class451.field4849.method737(var1.field565);
				var1.field565 = null;
			}

			if (var1.field569 != null) {
				class451.field4849.method737(var1.field569);
				var1.field569 = null;
			}
		}

		class70.field563.method6354();
	}
}
