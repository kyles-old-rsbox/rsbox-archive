public class class458 extends class437 {
	public static class284 field4871;
	public static class319 field4873;
	public int[][] field4872;
	public Object[][] field4874;

	static {
		field4871 = new class284(64);
	}

	class458() {
	}

	void method8079(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method8082(var1, var3);
		}
	}

	void method8082(Buffer var1, int var2) {
		if (var2 == 1) {
			int var4 = var1.readUnsignedByte();
			if (null == this.field4872) {
				this.field4872 = new int[var4][];
			}

			for (int var5 = var1.readUnsignedByte(); var5 != 255; var5 = var1.readUnsignedByte()) {
				int var6 = var5 & 127;
				boolean var7 = 0 != (var5 & 128);
				int[] var8 = new int[var1.readUnsignedByte()];

				for (int var9 = 0; var9 < var8.length; ++var9) {
					var8[var9] = var1.method8207();
				}

				this.field4872[var6] = var8;
				if (var7) {
					if (null == this.field4874) {
						this.field4874 = new Object[this.field4872.length][];
					}

					Object[][] var18 = this.field4874;
					int var12 = var1.method8207();
					Object[] var13 = new Object[var8.length * var12];

					for (int var14 = 0; var14 < var12; ++var14) {
						for (int var15 = 0; var15 < var8.length; ++var15) {
							int var16 = var8.length * var14 + var15;
							class451 var17 = class213.method4117(var8[var15]);
							var13[var16] = var17.method7974(var1);
						}
					}

					var18[var6] = var13;
				}
			}
		}

	}

	void method8081() {
	}

	static final void method8090(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, class200 var7) {
		if (!client.isLowDetail || 0 != (class82.field714[0][var1][var2] & 2) || (class82.field714[var0][var1][var2] & 16) == 0) {
			if (var0 < class82.field724) {
				class82.field724 = var0;
			}

			class195 var9 = InterfaceParent.method1866(var3);
			int var10;
			int var11;
			if (var4 != 1 && var4 != 3) {
				var10 = var9.field2100;
				var11 = var9.field2069;
			} else {
				var10 = var9.field2069;
				var11 = var9.field2100;
			}

			int var12;
			int var13;
			if (var1 + var10 <= 104) {
				var12 = (var10 >> 1) + var1;
				var13 = var1 + (var10 + 1 >> 1);
			} else {
				var12 = var1;
				var13 = var1 + 1;
			}

			int var14;
			int var15;
			if (var11 + var2 <= 104) {
				var14 = var2 + (var11 >> 1);
				var15 = (var11 + 1 >> 1) + var2;
			} else {
				var14 = var2;
				var15 = var2 + 1;
			}

			int[][] var16 = class82.field719[var0];
			int var17 = var16[var13][var15] + var16[var12][var15] + var16[var12][var14] + var16[var13][var14] >> 2;
			int var18 = (var1 << 7) + (var10 << 6);
			int var19 = (var2 << 7) + (var11 << 6);
			long var20 = class207.method3982(var1, var2, 2, 0 == var9.field2072, var3);
			int var22 = var5 + (var4 << 6);
			if (1 == var9.field2093) {
				var22 += 256;
			}

			int var24;
			int var25;
			if (var9.method3578()) {
				class70 var23 = new class70();
				var23.field558 = var0;
				var23.field559 = var1 * 128;
				var23.field570 = var2 * 128;
				var24 = var9.field2100;
				var25 = var9.field2069;
				if (var4 == 1 || var4 == 3) {
					var24 = var9.field2069;
					var25 = var9.field2100;
				}

				var23.field568 = (var24 + var1) * 128;
				var23.field562 = 128 * (var2 + var25);
				var23.field564 = var9.field2097;
				var23.field560 = var9.field2098 * 128;
				var23.field566 = var9.field2086;
				var23.field567 = var9.field2102;
				var23.field561 = var9.field2101;
				if (null != var9.field2094) {
					var23.field571 = var9;
					var23.method1419();
				}

				class70.field563.method6355(var23);
				if (var23.field561 != null) {
					var23.field557 = var23.field566 + (int)(Math.random() * (double)(var23.field567 - var23.field566));
				}
			}

			Object var35;
			if (var5 == 22) {
				if (!client.isLowDetail || 0 != var9.field2072 || var9.field2070 == 1 || var9.field2068) {
					if (var9.field2076 == -1 && null == var9.field2094) {
						var35 = var9.method3584(22, var4, var16, var18, var17, var19);
					} else {
						var35 = new class61(var3, 22, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
					}

					var6.method4128(var0, var1, var2, var17, (class212)var35, var20, var22);
					if (1 == var9.field2070 && null != var7) {
						var7.method3739(var1, var2);
					}

				}
			} else if (var5 != 10 && var5 != 11) {
				int[] var10000;
				if (var5 >= 12) {
					if (var9.field2076 == -1 && null == var9.field2094) {
						var35 = var9.method3584(var5, var4, var16, var18, var17, var19);
					} else {
						var35 = new class61(var3, var5, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
					}

					var6.method4166(var0, var1, var2, var17, 1, 1, (class212)var35, 0, var20, var22);
					if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
						var10000 = class128.field1231[var0][var1];
						var10000[var2] |= 2340;
					}

					if (0 != var9.field2070 && null != var7) {
						var7.method3737(var1, var2, var10, var11, var9.field2071);
					}

				} else if (var5 == 0) {
					if (-1 == var9.field2076 && null == var9.field2094) {
						var35 = var9.method3584(0, var4, var16, var18, var17, var19);
					} else {
						var35 = new class61(var3, 0, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
					}

					var6.method4228(var0, var1, var2, var17, (class212)var35, (class212)null, class82.field721[var4], 0, var20, var22);
					if (var4 == 0) {
						if (var9.field2084) {
							class30.field160[var0][var1][var2] = 50;
							class30.field160[var0][var1][var2 + 1] = 50;
						}

						if (var9.field2091) {
							var10000 = class128.field1231[var0][var1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 1) {
						if (var9.field2084) {
							class30.field160[var0][var1][var2 + 1] = 50;
							class30.field160[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var9.field2091) {
							var10000 = class128.field1231[var0][var1];
							var10000[var2 + 1] |= 1170;
						}
					} else if (var4 == 2) {
						if (var9.field2084) {
							class30.field160[var0][var1 + 1][var2] = 50;
							class30.field160[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var9.field2091) {
							var10000 = class128.field1231[var0][var1 + 1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 3) {
						if (var9.field2084) {
							class30.field160[var0][var1][var2] = 50;
							class30.field160[var0][var1 + 1][var2] = 50;
						}

						if (var9.field2091) {
							var10000 = class128.field1231[var0][var1];
							var10000[var2] |= 1170;
						}
					}

					if (0 != var9.field2070 && null != var7) {
						var7.method3736(var1, var2, var5, var4, var9.field2071);
					}

					if (16 != var9.field2077) {
						var6.method4138(var0, var1, var2, var9.field2077);
					}

				} else if (var5 == 1) {
					if (-1 == var9.field2076 && null == var9.field2094) {
						var35 = var9.method3584(1, var4, var16, var18, var17, var19);
					} else {
						var35 = new class61(var3, 1, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
					}

					var6.method4228(var0, var1, var2, var17, (class212)var35, (class212)null, class82.field722[var4], 0, var20, var22);
					if (var9.field2084) {
						if (var4 == 0) {
							class30.field160[var0][var1][var2 + 1] = 50;
						} else if (var4 == 1) {
							class30.field160[var0][var1 + 1][var2 + 1] = 50;
						} else if (var4 == 2) {
							class30.field160[var0][var1 + 1][var2] = 50;
						} else if (var4 == 3) {
							class30.field160[var0][var1][var2] = 50;
						}
					}

					if (var9.field2070 != 0 && var7 != null) {
						var7.method3736(var1, var2, var5, var4, var9.field2071);
					}

				} else {
					int var29;
					if (var5 == 2) {
						var29 = var4 + 1 & 3;
						Object var30;
						Object var31;
						if (var9.field2076 == -1 && var9.field2094 == null) {
							var30 = var9.method3584(2, var4 + 4, var16, var18, var17, var19);
							var31 = var9.method3584(2, var29, var16, var18, var17, var19);
						} else {
							var30 = new class61(var3, 2, var4 + 4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
							var31 = new class61(var3, 2, var29, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
						}

						var6.method4228(var0, var1, var2, var17, (class212)var30, (class212)var31, class82.field721[var4], class82.field721[var29], var20, var22);
						if (var9.field2091) {
							if (var4 == 0) {
								var10000 = class128.field1231[var0][var1];
								var10000[var2] |= 585;
								var10000 = class128.field1231[var0][var1];
								var10000[var2 + 1] |= 1170;
							} else if (var4 == 1) {
								var10000 = class128.field1231[var0][var1];
								var10000[var2 + 1] |= 1170;
								var10000 = class128.field1231[var0][var1 + 1];
								var10000[var2] |= 585;
							} else if (var4 == 2) {
								var10000 = class128.field1231[var0][var1 + 1];
								var10000[var2] |= 585;
								var10000 = class128.field1231[var0][var1];
								var10000[var2] |= 1170;
							} else if (var4 == 3) {
								var10000 = class128.field1231[var0][var1];
								var10000[var2] |= 1170;
								var10000 = class128.field1231[var0][var1];
								var10000[var2] |= 585;
							}
						}

						if (var9.field2070 != 0 && var7 != null) {
							var7.method3736(var1, var2, var5, var4, var9.field2071);
						}

						if (var9.field2077 != 16) {
							var6.method4138(var0, var1, var2, var9.field2077);
						}

					} else if (var5 == 3) {
						if (-1 == var9.field2076 && var9.field2094 == null) {
							var35 = var9.method3584(3, var4, var16, var18, var17, var19);
						} else {
							var35 = new class61(var3, 3, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
						}

						var6.method4228(var0, var1, var2, var17, (class212)var35, (class212)null, class82.field722[var4], 0, var20, var22);
						if (var9.field2084) {
							if (var4 == 0) {
								class30.field160[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								class30.field160[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								class30.field160[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								class30.field160[var0][var1][var2] = 50;
							}
						}

						if (var9.field2070 != 0 && var7 != null) {
							var7.method3736(var1, var2, var5, var4, var9.field2071);
						}

					} else if (var5 == 9) {
						if (-1 == var9.field2076 && null == var9.field2094) {
							var35 = var9.method3584(var5, var4, var16, var18, var17, var19);
						} else {
							var35 = new class61(var3, var5, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
						}

						var6.method4166(var0, var1, var2, var17, 1, 1, (class212)var35, 0, var20, var22);
						if (0 != var9.field2070 && var7 != null) {
							var7.method3737(var1, var2, var10, var11, var9.field2071);
						}

						if (var9.field2077 != 16) {
							var6.method4138(var0, var1, var2, var9.field2077);
						}

					} else if (var5 == 4) {
						if (-1 == var9.field2076 && var9.field2094 == null) {
							var35 = var9.method3584(4, var4, var16, var18, var17, var19);
						} else {
							var35 = new class61(var3, 4, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
						}

						var6.method4141(var0, var1, var2, var17, (class212)var35, (class212)null, class82.field721[var4], 0, 0, 0, var20, var22);
					} else {
						long var32;
						Object var34;
						if (var5 == 5) {
							var29 = 16;
							var32 = var6.method4185(var0, var1, var2);
							if (var32 != 0L) {
								var29 = InterfaceParent.method1866(class234.method1610(var32)).field2077;
							}

							if (-1 == var9.field2076 && null == var9.field2094) {
								var34 = var9.method3584(4, var4, var16, var18, var17, var19);
							} else {
								var34 = new class61(var3, 4, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
							}

							var6.method4141(var0, var1, var2, var17, (class212)var34, (class212)null, class82.field721[var4], 0, class82.field713[var4] * var29, var29 * class82.field725[var4], var20, var22);
						} else if (var5 == 6) {
							var29 = 8;
							var32 = var6.method4185(var0, var1, var2);
							if (var32 != 0L) {
								var29 = InterfaceParent.method1866(class234.method1610(var32)).field2077 / 2;
							}

							if (var9.field2076 == -1 && null == var9.field2094) {
								var34 = var9.method3584(4, var4 + 4, var16, var18, var17, var19);
							} else {
								var34 = new class61(var3, 4, var4 + 4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
							}

							var6.method4141(var0, var1, var2, var17, (class212)var34, (class212)null, 256, var4, var29 * class82.field715[var4], var29 * class82.field726[var4], var20, var22);
						} else if (var5 == 7) {
							var24 = var4 + 2 & 3;
							if (var9.field2076 == -1 && null == var9.field2094) {
								var35 = var9.method3584(4, var24 + 4, var16, var18, var17, var19);
							} else {
								var35 = new class61(var3, 4, var24 + 4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
							}

							var6.method4141(var0, var1, var2, var17, (class212)var35, (class212)null, 256, var24, 0, 0, var20, var22);
						} else if (var5 == 8) {
							var29 = 8;
							var32 = var6.method4185(var0, var1, var2);
							if (var32 != 0L) {
								var29 = InterfaceParent.method1866(class234.method1610(var32)).field2077 / 2;
							}

							int var28 = var4 + 2 & 3;
							Object var27;
							if (-1 == var9.field2076 && null == var9.field2094) {
								var34 = var9.method3584(4, var4 + 4, var16, var18, var17, var19);
								var27 = var9.method3584(4, var28 + 4, var16, var18, var17, var19);
							} else {
								var34 = new class61(var3, 4, var4 + 4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
								var27 = new class61(var3, 4, var28 + 4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
							}

							var6.method4141(var0, var1, var2, var17, (class212)var34, (class212)var27, 256, var4, class82.field715[var4] * var29, class82.field726[var4] * var29, var20, var22);
						}
					}
				}
			} else {
				if (-1 == var9.field2076 && var9.field2094 == null) {
					var35 = var9.method3584(10, var4, var16, var18, var17, var19);
				} else {
					var35 = new class61(var3, 10, var4, var0, var1, var2, var9.field2076, var9.field2099, (class212)null);
				}

				if (var35 != null && var6.method4166(var0, var1, var2, var17, var10, var11, (class212)var35, var5 == 11 ? 256 : 0, var20, var22) && var9.field2084) {
					var24 = 15;
					if (var35 instanceof class209) {
						var24 = ((class209)var35).method3994() / 4;
						if (var24 > 30) {
							var24 = 30;
						}
					}

					for (var25 = 0; var25 <= var10; ++var25) {
						for (int var26 = 0; var26 <= var11; ++var26) {
							if (var24 > class30.field160[var0][var25 + var1][var26 + var2]) {
								class30.field160[var0][var1 + var25][var26 + var2] = (byte)var24;
							}
						}
					}
				}

				if (0 != var9.field2070 && var7 != null) {
					var7.method3737(var1, var2, var10, var11, var9.field2071);
				}

			}
		}
	}
}
