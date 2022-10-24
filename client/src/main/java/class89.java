public class class89 extends class427 {
	boolean field795;
	int field796;
	int field797;

	class89() {
		this.field795 = false;
	}

	public static class195 method1866(int var0) {
		class195 var2 = (class195)class195.field2055.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class195.field2053.method6175(6, var0);
			var2 = new class195();
			var2.field2052 = var0;
			if (null != var3) {
				var2.method3580(new class460(var3));
			}

			var2.method3582();
			if (var2.field2085) {
				var2.field2070 = 0;
				var2.field2071 = false;
			}

			class195.field2055.method5434(var2, (long)var0);
			return var2;
		}
	}
}
