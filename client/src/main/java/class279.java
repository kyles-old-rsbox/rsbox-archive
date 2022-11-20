public class class279 {
	public static class278 field3201;
	public static class319 field3199;
	public static class319 field3200;
	public static class319 field3206;
	public static int field3202;
	public static int field3203;
	public static int field3204;

	static {
		field3202 = 0;
	}

	class279() throws Throwable {
		throw new Error();
	}

	public static boolean method5005(class319 var0, class319 var1, class319 var2, class278 var3) {
		field3206 = var0;
		field3199 = var1;
		field3200 = var2;
		field3201 = var3;
		return true;
	}

	public static void method332(class319 var0, int var1, int var2, int var3, boolean var4) {
		field3202 = 1;
		class7.field29 = var0;
		field3203 = var1;
		field3204 = var2;
		MessagesManager.field1092 = var3;
		class337.field3889 = var4;
		class13.field67 = 10000;
	}

	public static boolean method5389(char var0) {
		if (var0 >= ' ' && var0 < 127 || var0 > 127 && var0 < 160 || var0 > 160 && var0 <= 255) {
			return true;
		} else {
			if (var0 != 0) {
				char[] var2 = class349.field4270;

				for (int var3 = 0; var3 < var2.length; ++var3) {
					char var4 = var2[var3];
					if (var4 == var0) {
						return true;
					}
				}
			}

			return false;
		}
	}

	public static void method3434(int var0, class319 var1, String var2, String var3, int var4, boolean var5) {
		int var7 = var1.method6124(var2);
		int var8 = var1.method6170(var7, var3);
		field3202 = 1;
		class7.field29 = var1;
		field3203 = var7;
		field3204 = var8;
		MessagesManager.field1092 = var4;
		class337.field3889 = var5;
		class13.field67 = var0;
	}

	static void method5396() {
		if (client.isUsernameRemembered && Login.username != null && Login.username.length() > 0) {
			Login.field640 = 1;
		} else {
			Login.field640 = 0;
		}

	}
}
