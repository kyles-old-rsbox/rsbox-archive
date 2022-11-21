public class class475 {
	static int field4967;
	static int field4968;
	static int field4971;
	static int[] field4966;
	static int[] field4970;

	class475() throws Throwable {
		throw new Error();
	}

	public static class488[] method7371(class319 var0, String var1, String var2) {
		int var4 = var0.getGroupId(var1);
		int var5 = var0.method6170(var4, var2);
		return class134.method2422(var0, var4, var5);
	}

	static class473 method603() {
		class473 var1 = new class473();
		var1.field4956 = field4967;
		var1.field4957 = field4971;
		var1.field4954 = class450.field4840[0];
		var1.field4962 = class315.field3720[0];
		var1.field4959 = class467.field4921[0];
		var1.field4951 = field4966[0];
		int var2 = var1.field4959 * var1.field4951;
		byte[] var3 = class451.field4844[0];
		var1.field4952 = new int[var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			var1.field4952[var4] = field4970[var3[var4] & 255];
		}

		class450.field4840 = null;
		class315.field3720 = null;
		class467.field4921 = null;
		field4966 = null;
		field4970 = null;
		class451.field4844 = (byte[][])null;
		return var1;
	}

	static boolean method2719(class319 var0, int var1) {
		byte[] var3 = var0.method6103(var1);
		if (null == var3) {
			return false;
		} else {
			class317.method6080(var3);
			return true;
		}
	}
}
