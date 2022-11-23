public class class33 {
	class59[] field211;
	int field210;
	int field213;

	public static class33 method610(class319 var0, int var1, int var2) {
		byte[] var3 = var0.method6175(var1, var2);
		return var3 == null ? null : new class33(new Buffer(var3));
	}

	class33(Buffer var1) {
		this.field211 = new class59[10];

		for (int var2 = 0; var2 < 10; ++var2) {
			int var3 = var1.readUnsignedByte();
			if (var3 != 0) {
				--var1.offset;
				this.field211[var2] = new class59();
				this.field211[var2].method1293(var1);
			}
		}

		this.field210 = var1.readUnsignedShort();
		this.field213 = var1.readUnsignedShort();
	}

	public class39 method605() {
		byte[] var1 = this.method607();
		return new class39(22050, var1, this.field210 * 22050 / 1000, this.field213 * 22050 / 1000);
	}

	public final int method606() {
		int var1 = 9999999;

		int var2;
		for (var2 = 0; var2 < 10; ++var2) {
			if (this.field211[var2] != null && this.field211[var2].field428 / 20 < var1) {
				var1 = this.field211[var2].field428 / 20;
			}
		}

		if (this.field210 < this.field213 && this.field210 / 20 < var1) {
			var1 = this.field210 / 20;
		}

		if (var1 != 9999999 && var1 != 0) {
			for (var2 = 0; var2 < 10; ++var2) {
				if (this.field211[var2] != null) {
					class59 var10000 = this.field211[var2];
					var10000.field428 -= var1 * 20;
				}
			}

			if (this.field210 < this.field213) {
				this.field210 -= var1 * 20;
				this.field213 -= var1 * 20;
			}

			return var1;
		} else {
			return 0;
		}
	}

	final byte[] method607() {
		int var1 = 0;

		int var2;
		for (var2 = 0; var2 < 10; ++var2) {
			if (this.field211[var2] != null && this.field211[var2].field436 + this.field211[var2].field428 > var1) {
				var1 = this.field211[var2].field436 + this.field211[var2].field428;
			}
		}

		if (var1 == 0) {
			return new byte[0];
		} else {
			var2 = var1 * 22050 / 1000;
			byte[] var3 = new byte[var2];

			for (int var4 = 0; var4 < 10; ++var4) {
				if (this.field211[var4] != null) {
					int var5 = this.field211[var4].field436 * 22050 / 1000;
					int var6 = this.field211[var4].field428 * 22050 / 1000;
					int[] var7 = this.field211[var4].method1291(var5, this.field211[var4].field436);

					for (int var8 = 0; var8 < var5; ++var8) {
						int var9 = var3[var8 + var6] + (var7[var8] >> 8);
						if ((var9 + 128 & -256) != 0) {
							var9 = var9 >> 31 ^ 127;
						}

						var3[var8 + var6] = (byte)var9;
					}
				}
			}

			return var3;
		}
	}
}
