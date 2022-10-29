public class class368 {
	static class329 field4353;

	class368() throws Throwable {
		throw new Error();
	}

	public static int method6733(float[] var0, int var1, float var2, boolean var3, float var4, boolean var5, float[] var6) {
		float var8 = 0.0F;

		for (int var9 = 0; var9 < var1 + 1; ++var9) {
			var8 += Math.abs(var0[var9]);
		}

		float var25 = (Math.abs(var2) + Math.abs(var4)) * (float)(var1 + 1) * class127.field1227;
		if (var8 <= var25) {
			return -1;
		} else {
			float[] var10 = new float[var1 + 1];

			int var11;
			for (var11 = 0; var11 < var1 + 1; ++var11) {
				var10[var11] = var0[var11] * (1.0F / var8);
			}

			while (Math.abs(var10[var1]) < var25) {
				--var1;
			}

			var11 = 0;
			if (var1 == 0) {
				return var11;
			} else if (var1 == 1) {
				var6[0] = -var10[0] / var10[1];
				boolean var12 = var3 ? var2 < var6[0] + var25 : var2 < var6[0] - var25;
				boolean var13 = var5 ? var4 > var6[0] - var25 : var4 > var6[0] + var25;
				var11 = var12 && var13 ? 1 : 0;
				if (var11 > 0) {
					if (var3 && var6[0] < var2) {
						var6[0] = var2;
					} else if (var5 && var6[0] > var4) {
						var6[0] = var4;
					}
				}

				return var11;
			} else {
				class405 var22 = new class405(var10, var1);
				float[] var23 = new float[var1 + 1];

				for (int var14 = 1; var14 <= var1; ++var14) {
					var23[var14 - 1] = var10[var14] * (float)var14;
				}

				float[] var24 = new float[var1 + 1];
				int var15 = method6733(var23, var1 - 1, var2, false, var4, false, var24);
				if (var15 == -1) {
					return 0;
				} else {
					boolean var16 = false;
					float var18 = 0.0F;
					float var19 = 0.0F;
					float var20 = 0.0F;

					for (int var21 = 0; var21 <= var15; ++var21) {
						if (var11 > var1) {
							return var11;
						}

						float var17;
						if (var21 == 0) {
							var17 = var2;
							var19 = class405.method45(var10, var1, var2);
							if (Math.abs(var19) <= var25 && var3) {
								var6[var11++] = var2;
							}
						} else {
							var17 = var20;
							var19 = var18;
						}

						if (var21 == var15) {
							var20 = var4;
							var16 = false;
						} else {
							var20 = var24[var21];
						}

						var18 = class405.method45(var10, var1, var20);
						if (var16) {
							var16 = false;
						} else if (Math.abs(var18) < var25) {
							if (var21 != var15 || var5) {
								var6[var11++] = var20;
								var16 = true;
							}
						} else if (var19 < 0.0F && var18 > 0.0F || var19 > 0.0F && var18 < 0.0F) {
							var6[var11++] = class415.method7530(var22, var17, var20, 0.0F);
							if (var11 > 1 && var6[var11 - 2] >= var6[var11 - 1] - var25) {
								var6[var11 - 2] = 0.5F * (var6[var11 - 1] + var6[var11 - 2]);
								--var11;
							}
						}
					}

					return var11;
				}
			}
		}
	}

	static final void method6731() {
		client.field1778.method2080();
		client.method2354();
		class145.field1333.method4122();

		for (int var1 = 0; var1 < 4; ++var1) {
			client.field1884[var1].method3735();
		}

		client.field1877.method3521();
		System.gc();
		class279.field3202 = 1;
		class7.field29 = null;
		class279.field3203 = -1;
		class279.field3204 = -1;
		class110.field1092 = 0;
		class337.field3889 = false;
		class13.field67 = 2;
		client.field1748 = -1;
		client.field1781 = false;
		class103.method2025();
		class9.method64(10);
	}

	static final void method6732(int var0) {
		method6731();
		switch(var0) {
		case 1:
			class75.method230();
			break;
		case 2:
			class75.method12();
		}

	}
}
