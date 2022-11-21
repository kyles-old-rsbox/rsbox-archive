public class class154 extends class140 {
	int field1416;
	int field1417;
	// $FF: synthetic field
	final class142 this$0;

	public static class452 method2596(int var0) {
		class452 var2 = (class452)class452.field4852.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class452.field4853.method6175(38, var0);
			var2 = new class452();
			if (null != var3) {
				var2.method7988(new Buffer(var3));
			}

			var2.method7991();
			class452.field4852.method5434(var2, (long)var0);
			return var2;
		}
	}

	class154(class142 var1) {
		this.this$0 = var1;
	}

	void method2467(Buffer var1) {
		this.field1417 = var1.readInt();
		this.field1416 = var1.readInt();
	}

	void method2468(class148 var1) {
		var1.method2565(this.field1417, this.field1416);
	}
}
