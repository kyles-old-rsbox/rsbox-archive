public class class67 {
	static float field539;
	static float[][] field544;
	static int field540;
	static int[][] field545;
	int[] field543;
	int[] field550;
	int[][][] field541;
	int[][][] field542;

	static {
		field544 = new float[2][8];
		field545 = new int[2][8];
	}

	class67() {
		this.field550 = new int[2];
		this.field541 = new int[2][2][4];
		this.field542 = new int[2][2][4];
		this.field543 = new int[2];
	}

	float method1398(int var1, int var2, float var3) {
		float var4 = (float)this.field542[var1][0][var2] + var3 * (float)(this.field542[var1][1][var2] - this.field542[var1][0][var2]);
		var4 *= 0.0015258789F;
		return 1.0F - (float)Math.pow(10.0D, (double)(-var4 / 20.0F));
	}

	static float method1395(float var0) {
		float var1 = 32.703197F * (float)Math.pow(2.0D, (double)var0);
		return var1 * 3.1415927F / 11025.0F;
	}

	float method1396(int var1, int var2, float var3) {
		float var4 = (float)this.field541[var1][0][var2] + var3 * (float)(this.field541[var1][1][var2] - this.field541[var1][0][var2]);
		var4 *= 1.2207031E-4F;
		return method1395(var4);
	}

	int method1401(int var1, float var2) {
		float var3;
		if (var1 == 0) {
			var3 = (float)this.field543[0] + (float)(this.field543[1] - this.field543[0]) * var2;
			var3 *= 0.0030517578F;
			field539 = (float)Math.pow(0.1D, (double)(var3 / 20.0F));
			field540 = (int)(field539 * 65536.0F);
		}

		if (this.field550[var1] == 0) {
			return 0;
		} else {
			var3 = this.method1398(var1, 0, var2);
			field544[var1][0] = var3 * -2.0F * (float)Math.cos((double)this.method1396(var1, 0, var2));
			field544[var1][1] = var3 * var3;

			float[] var10000;
			int var4;
			for (var4 = 1; var4 < this.field550[var1]; ++var4) {
				var3 = this.method1398(var1, var4, var2);
				float var5 = var3 * -2.0F * (float)Math.cos((double)this.method1396(var1, var4, var2));
				float var6 = var3 * var3;
				field544[var1][var4 * 2 + 1] = field544[var1][var4 * 2 - 1] * var6;
				field544[var1][var4 * 2] = field544[var1][var4 * 2 - 1] * var5 + field544[var1][var4 * 2 - 2] * var6;

				for (int var7 = var4 * 2 - 1; var7 >= 2; --var7) {
					var10000 = field544[var1];
					var10000[var7] += field544[var1][var7 - 1] * var5 + field544[var1][var7 - 2] * var6;
				}

				var10000 = field544[var1];
				var10000[1] += field544[var1][0] * var5 + var6;
				var10000 = field544[var1];
				var10000[0] += var5;
			}

			if (var1 == 0) {
				for (var4 = 0; var4 < this.field550[0] * 2; ++var4) {
					var10000 = field544[0];
					var10000[var4] *= field539;
				}
			}

			for (var4 = 0; var4 < this.field550[var1] * 2; ++var4) {
				field545[var1][var4] = (int)(field544[var1][var4] * 65536.0F);
			}

			return this.field550[var1] * 2;
		}
	}

	final void method1397(Buffer var1, class35 var2) {
		int var3 = var1.readUnsignedByte();
		this.field550[0] = var3 >> 4;
		this.field550[1] = var3 & 15;
		if (var3 != 0) {
			this.field543[0] = var1.readUnsignedShort();
			this.field543[1] = var1.readUnsignedShort();
			int var4 = var1.readUnsignedByte();

			int var5;
			int var6;
			for (var5 = 0; var5 < 2; ++var5) {
				for (var6 = 0; var6 < this.field550[var5]; ++var6) {
					this.field541[var5][0][var6] = var1.readUnsignedShort();
					this.field542[var5][0][var6] = var1.readUnsignedShort();
				}
			}

			for (var5 = 0; var5 < 2; ++var5) {
				for (var6 = 0; var6 < this.field550[var5]; ++var6) {
					if ((var4 & 1 << var5 * 4 << var6) != 0) {
						this.field541[var5][1][var6] = var1.readUnsignedShort();
						this.field542[var5][1][var6] = var1.readUnsignedShort();
					} else {
						this.field541[var5][1][var6] = this.field541[var5][0][var6];
						this.field542[var5][1][var6] = this.field542[var5][0][var6];
					}
				}
			}

			if (var4 != 0 || this.field543[1] != this.field543[0]) {
				var2.method663(var1);
			}
		} else {
			int[] var7 = this.field543;
			this.field543[1] = 0;
			var7[0] = 0;
		}

	}
}
