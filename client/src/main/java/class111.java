import client.Client;

public class class111 extends class393 {
	public static boolean field1097;
	final boolean field1100;

	public class111(boolean var1) {
		this.field1100 = var1;
	}

	int method2137(class396 var1, class396 var2) {
		if (var1.field4491 == Client.field1868 && Client.field1868 == var2.field4491) {
			return this.field1100 ? var1.field4490 - var2.field4490 : var2.field4490 - var1.field4490;
		} else {
			return this.method7162(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method2137((class396)var1, (class396)var2);
	}

	public static class376 method2143(class319 var0, class319 var1, String var2, String var3) {
		int var5 = var0.method6124(var2);
		int var6 = var0.method6170(var5, var3);
		return class378.method6805(var0, var1, var5, var6);
	}

	static final int method2142(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var4 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var4;
	}
}
