public class class134 extends class137 {
	byte field1264;
	int field1259;
	String field1258;
	// $FF: synthetic field
	final class143 this$0;

	public static class488[] method2422(class319 var0, int var1, int var2) {
		byte[] var5 = var0.method6175(var1, var2);
		boolean var4;
		if (var5 == null) {
			var4 = false;
		} else {
			class317.method6080(var5);
			var4 = true;
		}

		if (!var4) {
			return null;
		} else {
			class488[] var6 = new class488[class475.field4968];

			for (int var7 = 0; var7 < class475.field4968; ++var7) {
				class488 var8 = var6[var7] = new class488();
				var8.field5016 = class475.field4967;
				var8.field5018 = class475.field4971;
				var8.field5020 = class450.field4840[var7];
				var8.field5021 = class315.field3720[var7];
				var8.field5017 = class467.field4921[var7];
				var8.field5019 = class475.field4966[var7];
				var8.field5023 = class475.field4970;
				var8.field5022 = class451.field4844[var7];
			}

			class450.field4840 = null;
			class315.field3720 = null;
			class467.field4921 = null;
			class475.field4966 = null;
			class475.field4970 = null;
			class451.field4844 = (byte[][])null;
			return var6;
		}
	}

	class134(class143 var1) {
		this.this$0 = var1;
		this.field1258 = null;
	}

	void method2441(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			var1.readLong();
		}

		this.field1258 = var1.method8305();
		this.field1259 = var1.readUnsignedShort();
		this.field1264 = var1.readByte();
		var1.readLong();
	}

	void method2442(class147 var1) {
		class133 var3 = new class133();
		var3.field1254 = new DisplayName(this.field1258);
		var3.field1249 = this.field1259;
		var3.field1256 = this.field1264;
		var1.method2516(var3);
	}

	static void method2421(int var0) {
		if (var0 != -1) {
			if (class246.method4928(var0)) {
				class300[] var2 = class300.field3593[var0];

				for (int var3 = 0; var3 < var2.length; ++var3) {
					class300 var4 = var2[var3];
					if (null != var4.field3553) {
						ClientScript var5 = new ClientScript();
						var5.field694 = var4;
						var5.args = var4.field3553;
						class57.method1954(var5, 5000000, 0);
					}
				}

			}
		}
	}
}
