import client.Client;

public abstract class class175 {
	class175() {
	}

	public static class192 method2755(int var0) {
		class192 var2 = (class192)class192.field2028.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class192.field2034.method6175(8, var0);
			var2 = new class192();
			if (var3 != null) {
				var2.method3538(new class460(var3));
			}

			class192.field2028.method5434(var2, (long)var0);
			return var2;
		}
	}

	static class459 method2752(int var0) {
		class459 var2 = (class459) Client.field1927.method5439((long)var0);
		if (var2 == null) {
			var2 = new class459(class255.field2944, var0);
		}

		return var2;
	}

	public abstract int method2746(int var1, int var2);

	public abstract void method2748();
}
