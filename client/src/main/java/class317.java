public class class317 {
	static int[] field3726;

	class317() throws Throwable {
		throw new Error();
	}

	static void method6080(byte[] var0) {
		Buffer var2 = new Buffer(var0);
		var2.offset = var0.length - 2;
		class475.field4968 = var2.readUnsignedShort();
		class450.field4840 = new int[class475.field4968];
		class315.field3720 = new int[class475.field4968];
		class467.field4921 = new int[class475.field4968];
		class475.field4966 = new int[class475.field4968];
		class451.field4844 = new byte[class475.field4968][];
		var2.offset = var0.length - 7 - class475.field4968 * 8;
		class475.field4967 = var2.readUnsignedShort();
		class475.field4971 = var2.readUnsignedShort();
		int var3 = (var2.readUnsignedByte() & 255) + 1;

		int var4;
		for (var4 = 0; var4 < class475.field4968; ++var4) {
			class450.field4840[var4] = var2.readUnsignedShort();
		}

		for (var4 = 0; var4 < class475.field4968; ++var4) {
			class315.field3720[var4] = var2.readUnsignedShort();
		}

		for (var4 = 0; var4 < class475.field4968; ++var4) {
			class467.field4921[var4] = var2.readUnsignedShort();
		}

		for (var4 = 0; var4 < class475.field4968; ++var4) {
			class475.field4966[var4] = var2.readUnsignedShort();
		}

		var2.offset = var0.length - 7 - class475.field4968 * 8 - 3 * (var3 - 1);
		class475.field4970 = new int[var3];

		for (var4 = 1; var4 < var3; ++var4) {
			class475.field4970[var4] = var2.method8312();
			if (class475.field4970[var4] == 0) {
				class475.field4970[var4] = 1;
			}
		}

		var2.offset = 0;

		for (var4 = 0; var4 < class475.field4968; ++var4) {
			int var5 = class467.field4921[var4];
			int var6 = class475.field4966[var4];
			int var7 = var5 * var6;
			byte[] var8 = new byte[var7];
			class451.field4844[var4] = var8;
			int var9 = var2.readUnsignedByte();
			int var10;
			if (var9 == 0) {
				for (var10 = 0; var10 < var7; ++var10) {
					var8[var10] = var2.readByte();
				}
			} else if (var9 == 1) {
				for (var10 = 0; var10 < var5; ++var10) {
					for (int var11 = 0; var11 < var6; ++var11) {
						var8[var10 + var11 * var5] = var2.readByte();
					}
				}
			}
		}

	}
}
