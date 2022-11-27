public class ClientPreferences extends class140 {
	int field1403;
	// $FF: synthetic field
	final class142 this$0;

	static void savePreferences() {
		class464 var1 = null;

		try {
			var1 = class161.method2668("", class368.field4353.field3820, true);
			Buffer var2 = class413.clientPreferences.method1702();
			var1.method8370(var2.data, 0, var2.offset);
		} catch (Exception var4) {
		}

		try {
			if (var1 != null) {
				var1.method8372(true);
			}
		} catch (Exception var3) {
		}

	}

	ClientPreferences(class142 var1) {
		this.this$0 = var1;
		this.field1403 = -1;
	}

	void method2467(Buffer var1) {
		this.field1403 = var1.readUnsignedShort();
	}

	void method2468(class148 var1) {
		var1.method2533(this.field1403);
	}
}
