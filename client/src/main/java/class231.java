public class class231 {
	static class181 field2748;
	int field2749;
	int field2750;
	int field2751;
	int field2752;

	class231() {
	}

	class231(class231 var1) {
		this.field2752 = var1.field2752;
		this.field2749 = var1.field2749;
		this.field2750 = var1.field2750;
		this.field2751 = var1.field2751;
	}

	static final byte[] method4537(byte[] var0) {
		Buffer var2 = new Buffer(var0);
		int var3 = var2.readUnsignedByte();
		int var4 = var2.readInt();
		if (var4 < 0 || class319.field3744 != 0 && var4 > class319.field3744) {
			throw new RuntimeException();
		} else if (var3 == 0) {
			byte[] var5 = new byte[var4];
			var2.readBytes(var5, 0, var4);
			return var5;
		} else {
			int var7 = var2.readInt();
			if (var7 >= 0 && (class319.field3744 == 0 || var7 <= class319.field3744)) {
				byte[] var6 = new byte[var7];
				if (var3 == 1) {
					class455.method8049(var6, var7, var0, var4, 9);
				} else {
					class319.field3745.method8735(var2, var6);
				}

				return var6;
			} else {
				throw new RuntimeException();
			}
		}
	}
}
