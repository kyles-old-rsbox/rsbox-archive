public class class46 {
	int field331;
	int field332;
	int field333;
	int field334;
	int field335;
	int field337;
	int[] field336;

	class46() {
		this.field333 = class60.method1323(16);
		this.field332 = class60.method1323(24);
		this.field335 = class60.method1323(24);
		this.field334 = class60.method1323(24) + 1;
		this.field337 = class60.method1323(6) + 1;
		this.field331 = class60.method1323(8);
		int[] var1 = new int[this.field337];

		int var2;
		for (var2 = 0; var2 < this.field337; ++var2) {
			int var3 = 0;
			int var4 = class60.method1323(3);
			boolean var5 = class60.method1299() != 0;
			if (var5) {
				var3 = class60.method1323(5);
			}

			var1[var2] = var3 << 3 | var4;
		}

		this.field336 = new int[this.field337 * 8];

		for (var2 = 0; var2 < this.field337 * 8; ++var2) {
			this.field336[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? class60.method1323(8) : -1;
		}

	}

	void method954(float[] var1, int var2, boolean var3) {
		int var4;
		for (var4 = 0; var4 < var2; ++var4) {
			var1[var4] = 0.0F;
		}

		if (!var3) {
			var4 = class60.field458[this.field331].field653;
			int var5 = this.field335 - this.field332;
			int var6 = var5 / this.field334;
			int[] var7 = new int[var6];

			for (int var8 = 0; var8 < 8; ++var8) {
				int var9 = 0;

				while (var9 < var6) {
					int var10;
					int var11;
					if (var8 == 0) {
						var10 = class60.field458[this.field331].method1562();

						for (var11 = var4 - 1; var11 >= 0; --var11) {
							if (var9 + var11 < var6) {
								var7[var9 + var11] = var10 % this.field337;
							}

							var10 /= this.field337;
						}
					}

					for (var10 = 0; var10 < var4; ++var10) {
						var11 = var7[var9];
						int var12 = this.field336[var11 * 8 + var8];
						if (var12 >= 0) {
							int var13 = this.field332 + var9 * this.field334;
							class76 var14 = class60.field458[var12];
							int var15;
							if (this.field333 == 0) {
								var15 = this.field334 / var14.field653;

								for (int var16 = 0; var16 < var15; ++var16) {
									float[] var17 = var14.method1559();

									for (int var18 = 0; var18 < var14.field653; ++var18) {
										var1[var13 + var16 + var18 * var15] += var17[var18];
									}
								}
							} else {
								var15 = 0;

								while (var15 < this.field334) {
									float[] var19 = var14.method1559();

									for (int var20 = 0; var20 < var14.field653; ++var20) {
										var1[var13 + var15] += var19[var20];
										++var15;
									}
								}
							}
						}

						++var9;
						if (var9 >= var6) {
							break;
						}
					}
				}
			}

		}
	}
}
