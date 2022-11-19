public class class136 extends class137 {
	static class336 field1275;
	static class488 field1272;
	static int[] field1271;
	int field1274;
	// $FF: synthetic field
	final class143 this$0;

	class136(class143 var1) {
		this.this$0 = var1;
		this.field1274 = -1;
	}

	void method2441(class460 var1) {
		this.field1274 = var1.method8122();
		var1.method8141();
		if (var1.method8141() != 255) {
			--var1.field4878;
			var1.method8127();
		}

	}

	void method2442(class147 var1) {
		var1.method2504(this.field1274);
	}

	public static void method2438(class300 var0) {
		if (var0 != null && client.field1882 == var0.field3610) {
			client.field1860[var0.field3609] = true;
		}

	}

	public static void method2439(int var0, int var1, int var2, boolean var3) {
		class263 var5 = class185.method3435(class274.field3040, client.field1778.field1071);
		var5.field2984.method8152(var2);
		var5.field2984.method8155(var3 ? client.field1729 : 0);
		var5.field2984.method8161(var0);
		var5.field2984.method8159(var1);
		client.field1778.method2078(var5);
	}
}
