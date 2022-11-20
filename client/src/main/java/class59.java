import java.util.Random;

public class class59 {
	static int[] field423;
	static int[] field438;
	static int[] field439;
	static int[] field440;
	static int[] field442;
	static int[] field443;
	static int[] field444;
	static int[] field445;
	class35 field422;
	class35 field424;
	class35 field425;
	class35 field426;
	class35 field427;
	class35 field430;
	class35 field434;
	class35 field435;
	class35 field437;
	class67 field433;
	int field428;
	int field429;
	int field432;
	int field436;
	int[] field421;
	int[] field431;
	int[] field446;

	static {
		field439 = new int[32768];
		Random var0 = new Random(0L);

		int var1;
		for (var1 = 0; var1 < 32768; ++var1) {
			field439[var1] = (var0.nextInt() & 2) - 1;
		}

		field440 = new int[32768];

		for (var1 = 0; var1 < 32768; ++var1) {
			field440[var1] = (int)(Math.sin((double)var1 / 5215.1903D) * 16384.0D);
		}

		field438 = new int[220500];
		field442 = new int[5];
		field443 = new int[5];
		field444 = new int[5];
		field445 = new int[5];
		field423 = new int[5];
	}

	class59() {
		this.field446 = new int[]{0, 0, 0, 0, 0};
		this.field421 = new int[]{0, 0, 0, 0, 0};
		this.field431 = new int[]{0, 0, 0, 0, 0};
		this.field432 = 0;
		this.field429 = 100;
		this.field436 = 500;
		this.field428 = 0;
	}

	final int[] method1291(int var1, int var2) {
		class386.method6969(field438, 0, var1);
		if (var2 < 10) {
			return field438;
		} else {
			double var3 = (double)var1 / ((double)var2 + 0.0D);
			this.field430.method662();
			this.field422.method662();
			int var5 = 0;
			int var6 = 0;
			int var7 = 0;
			if (this.field434 != null) {
				this.field434.method662();
				this.field424.method662();
				var5 = (int)((double)(this.field434.field227 - this.field434.field226) * 32.768D / var3);
				var6 = (int)((double)this.field434.field226 * 32.768D / var3);
			}

			int var8 = 0;
			int var9 = 0;
			int var10 = 0;
			if (this.field425 != null) {
				this.field425.method662();
				this.field426.method662();
				var8 = (int)((double)(this.field425.field227 - this.field425.field226) * 32.768D / var3);
				var9 = (int)((double)this.field425.field226 * 32.768D / var3);
			}

			int var11;
			for (var11 = 0; var11 < 5; ++var11) {
				if (this.field446[var11] != 0) {
					field442[var11] = 0;
					field443[var11] = (int)((double)this.field431[var11] * var3);
					field444[var11] = (this.field446[var11] << 14) / 100;
					field445[var11] = (int)((double)(this.field430.field227 - this.field430.field226) * 32.768D * Math.pow(1.0057929410678534D, (double)this.field421[var11]) / var3);
					field423[var11] = (int)((double)this.field430.field226 * 32.768D / var3);
				}
			}

			int var12;
			int var13;
			int var14;
			int var15;
			int[] var10000;
			for (var11 = 0; var11 < var1; ++var11) {
				var12 = this.field430.method658(var1);
				var13 = this.field422.method658(var1);
				if (this.field434 != null) {
					var14 = this.field434.method658(var1);
					var15 = this.field424.method658(var1);
					var12 += this.method1292(var7, var15, this.field434.field228) >> 1;
					var7 += (var14 * var5 >> 16) + var6;
				}

				if (this.field425 != null) {
					var14 = this.field425.method658(var1);
					var15 = this.field426.method658(var1);
					var13 = var13 * ((this.method1292(var10, var15, this.field425.field228) >> 1) + 32768) >> 15;
					var10 += (var14 * var8 >> 16) + var9;
				}

				for (var14 = 0; var14 < 5; ++var14) {
					if (this.field446[var14] != 0) {
						var15 = var11 + field443[var14];
						if (var15 < var1) {
							var10000 = field438;
							var10000[var15] += this.method1292(field442[var14], var13 * field444[var14] >> 15, this.field430.field228);
							var10000 = field442;
							var10000[var14] += (var12 * field445[var14] >> 16) + field423[var14];
						}
					}
				}
			}

			int var16;
			if (this.field427 != null) {
				this.field427.method662();
				this.field437.method662();
				var11 = 0;
				boolean var19 = false;
				boolean var20 = true;

				for (var14 = 0; var14 < var1; ++var14) {
					var15 = this.field427.method658(var1);
					var16 = this.field437.method658(var1);
					if (var20) {
						var12 = this.field427.field226 + ((this.field427.field227 - this.field427.field226) * var15 >> 8);
					} else {
						var12 = this.field427.field226 + ((this.field427.field227 - this.field427.field226) * var16 >> 8);
					}

					var11 += 256;
					if (var11 >= var12) {
						var11 = 0;
						var20 = !var20;
					}

					if (var20) {
						field438[var14] = 0;
					}
				}
			}

			if (this.field432 > 0 && this.field429 > 0) {
				var11 = (int)((double)this.field432 * var3);

				for (var12 = var11; var12 < var1; ++var12) {
					var10000 = field438;
					var10000[var12] += field438[var12 - var11] * this.field429 / 100;
				}
			}

			if (this.field433.field550[0] > 0 || this.field433.field550[1] > 0) {
				this.field435.method662();
				var11 = this.field435.method658(var1 + 1);
				var12 = this.field433.method1401(0, (float)var11 / 65536.0F);
				var13 = this.field433.method1401(1, (float)var11 / 65536.0F);
				if (var1 >= var12 + var13) {
					var14 = 0;
					var15 = var13;
					if (var13 > var1 - var12) {
						var15 = var1 - var12;
					}

					int var17;
					while (var14 < var15) {
						var16 = (int)((long)field438[var14 + var12] * (long)class67.field540 >> 16);

						for (var17 = 0; var17 < var12; ++var17) {
							var16 += (int)((long)field438[var14 + var12 - 1 - var17] * (long)class67.field545[0][var17] >> 16);
						}

						for (var17 = 0; var17 < var14; ++var17) {
							var16 -= (int)((long)field438[var14 - 1 - var17] * (long)class67.field545[1][var17] >> 16);
						}

						field438[var14] = var16;
						var11 = this.field435.method658(var1 + 1);
						++var14;
					}

					boolean var21 = true;
					var15 = 128;

					while (true) {
						if (var15 > var1 - var12) {
							var15 = var1 - var12;
						}

						int var18;
						while (var14 < var15) {
							var17 = (int)((long)field438[var14 + var12] * (long)class67.field540 >> 16);

							for (var18 = 0; var18 < var12; ++var18) {
								var17 += (int)((long)field438[var14 + var12 - 1 - var18] * (long)class67.field545[0][var18] >> 16);
							}

							for (var18 = 0; var18 < var13; ++var18) {
								var17 -= (int)((long)field438[var14 - 1 - var18] * (long)class67.field545[1][var18] >> 16);
							}

							field438[var14] = var17;
							var11 = this.field435.method658(var1 + 1);
							++var14;
						}

						if (var14 >= var1 - var12) {
							while (var14 < var1) {
								var17 = 0;

								for (var18 = var14 + var12 - var1; var18 < var12; ++var18) {
									var17 += (int)((long)field438[var14 + var12 - 1 - var18] * (long)class67.field545[0][var18] >> 16);
								}

								for (var18 = 0; var18 < var13; ++var18) {
									var17 -= (int)((long)field438[var14 - 1 - var18] * (long)class67.field545[1][var18] >> 16);
								}

								field438[var14] = var17;
								this.field435.method658(var1 + 1);
								++var14;
							}
							break;
						}

						var12 = this.field433.method1401(0, (float)var11 / 65536.0F);
						var13 = this.field433.method1401(1, (float)var11 / 65536.0F);
						var15 += 128;
					}
				}
			}

			for (var11 = 0; var11 < var1; ++var11) {
				if (field438[var11] < -32768) {
					field438[var11] = -32768;
				}

				if (field438[var11] > 32767) {
					field438[var11] = 32767;
				}
			}

			return field438;
		}
	}

	final int method1292(int var1, int var2, int var3) {
		if (var3 == 1) {
			return (var1 & 32767) < 16384 ? var2 : -var2;
		} else if (var3 == 2) {
			return field440[var1 & 32767] * var2 >> 14;
		} else if (var3 == 3) {
			return ((var1 & 32767) * var2 >> 14) - var2;
		} else {
			return var3 == 4 ? field439[var1 / 2607 & 32767] * var2 : 0;
		}
	}

	final void method1293(Buffer var1) {
		this.field430 = new class35();
		this.field430.method657(var1);
		this.field422 = new class35();
		this.field422.method657(var1);
		int var2 = var1.method8141();
		if (var2 != 0) {
			--var1.offset;
			this.field434 = new class35();
			this.field434.method657(var1);
			this.field424 = new class35();
			this.field424.method657(var1);
		}

		var2 = var1.method8141();
		if (var2 != 0) {
			--var1.offset;
			this.field425 = new class35();
			this.field425.method657(var1);
			this.field426 = new class35();
			this.field426.method657(var1);
		}

		var2 = var1.method8141();
		if (var2 != 0) {
			--var1.offset;
			this.field427 = new class35();
			this.field427.method657(var1);
			this.field437 = new class35();
			this.field437.method657(var1);
		}

		for (int var3 = 0; var3 < 10; ++var3) {
			int var4 = var1.method8207();
			if (var4 == 0) {
				break;
			}

			this.field446[var3] = var4;
			this.field421[var3] = var1.method8219();
			this.field431[var3] = var1.method8207();
		}

		this.field432 = var1.method8207();
		this.field429 = var1.method8207();
		this.field436 = var1.readUnsignedShort();
		this.field428 = var1.readUnsignedShort();
		this.field433 = new class67();
		this.field435 = new class35();
		this.field433.method1397(var1, this.field435);
	}
}
