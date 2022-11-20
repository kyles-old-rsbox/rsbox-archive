public class class180 extends class140 {
	static int worldPort;
	int field1606;
	long field1607;
	// $FF: synthetic field
	final class142 this$0;

	static class78 method2844(int var0) {
		class78 var2 = (class78)class78.field675.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class202.field2255.method6175(var0, 0);
			if (null == var3) {
				return null;
			} else {
				var2 = class31.method597(var3);
				class78.field675.method5434(var2, (long)var0);
				return var2;
			}
		}
	}

	class180(class142 var1) {
		this.this$0 = var1;
	}

	void method2467(Buffer var1) {
		this.field1606 = var1.method8126();
		this.field1607 = var1.readLong();
	}

	void method2468(class148 var1) {
		var1.method2540(this.field1606, this.field1607);
	}
}
