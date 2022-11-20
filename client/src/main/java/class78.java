public class class78 extends class437 {
	static boolean field683;
	static class284 field675;
	static class300[] field682;
	static int field684;
	class421[] field681;
	int field672;
	int field677;
	int field678;
	int field679;
	int[] field674;
	int[] field680;
	String field673;
	String[] field676;

	static {
		field675 = new class284(128);
	}

	class78() {
	}

	public static class182 method1593(int var0) {
		class182 var2 = (class182)class182.field1627.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class182.field1622.method6175(3, var0);
			var2 = new class182();
			if (var3 != null) {
				var2.method2846(new Buffer(var3));
			}

			class182.field1627.method5434(var2, (long)var0);
			return var2;
		}
	}

	class421[] method1581(int var1) {
		return new class421[var1];
	}
}
