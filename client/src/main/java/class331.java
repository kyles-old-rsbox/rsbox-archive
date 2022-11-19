public class class331 {
	static {
		int var0 = 0;
		int var1 = 0;
		class330[] var2 = new class330[]{class330.field3823, class330.field3824};
		class330[] var3 = var2;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			class330 var5 = var3[var4];
			if (var5.field3825 > var0) {
				var0 = var5.field3825;
			}

			if (var5.field3826 > var1) {
				var1 = var5.field3826;
			}
		}

	}

	class331() throws Throwable {
		throw new Error();
	}

	static final void method6260(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (client.field1636 && var0 != class55.field396) {
				return;
			}

			long var8 = 0L;
			boolean var10 = true;
			boolean var11 = false;
			boolean var12 = false;
			if (var1 == 0) {
				var8 = class145.field1333.method4185(var0, var2, var3);
			}

			if (var1 == 1) {
				var8 = class145.field1333.method4149(var0, var2, var3);
			}

			if (var1 == 2) {
				var8 = class145.field1333.method4150(var0, var2, var3);
			}

			if (var1 == 3) {
				var8 = class145.field1333.method4151(var0, var2, var3);
			}

			int var13;
			if (0L != var8) {
				var13 = class145.field1333.method4156(var0, var2, var3, var8);
				int var40 = class234.method1610(var8);
				int var41 = var13 & 31;
				int var42 = var13 >> 6 & 3;
				class195 var14;
				if (var1 == 0) {
					class145.field1333.method4232(var0, var2, var3);
					var14 = class89.method1866(var40);
					if (var14.field2070 != 0) {
						client.field1884[var0].method3759(var2, var3, var41, var42, var14.field2071);
					}
				}

				if (var1 == 1) {
					class145.field1333.method4125(var0, var2, var3);
				}

				if (var1 == 2) {
					class145.field1333.method4170(var0, var2, var3);
					var14 = class89.method1866(var40);
					if (var14.field2100 + var2 > 103 || var14.field2100 + var3 > 103 || var14.field2069 + var2 > 103 || var3 + var14.field2069 > 103) {
						return;
					}

					if (var14.field2070 != 0) {
						client.field1884[var0].method3741(var2, var3, var14.field2100, var14.field2069, var42, var14.field2071);
					}
				}

				if (var1 == 3) {
					class145.field1333.method4142(var0, var2, var3);
					var14 = class89.method1866(var40);
					if (var14.field2070 == 1) {
						client.field1884[var0].method3743(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var13 = var0;
				if (var0 < 3 && 2 == (class82.field714[1][var2][var3] & 2)) {
					var13 = var0 + 1;
				}

				class214 var43 = class145.field1333;
				class200 var15 = client.field1884[var0];
				class195 var16 = class89.method1866(var4);
				int var17;
				int var18;
				if (var5 != 1 && var5 != 3) {
					var17 = var16.field2100;
					var18 = var16.field2069;
				} else {
					var17 = var16.field2069;
					var18 = var16.field2100;
				}

				int var19;
				int var20;
				if (var2 + var17 <= 104) {
					var19 = (var17 >> 1) + var2;
					var20 = var2 + (var17 + 1 >> 1);
				} else {
					var19 = var2;
					var20 = var2 + 1;
				}

				int var21;
				int var22;
				if (var18 + var3 <= 104) {
					var21 = var3 + (var18 >> 1);
					var22 = var3 + (var18 + 1 >> 1);
				} else {
					var21 = var3;
					var22 = var3 + 1;
				}

				int[][] var23 = class82.field719[var13];
				int var24 = var23[var20][var22] + var23[var19][var21] + var23[var20][var21] + var23[var19][var22] >> 2;
				int var25 = (var17 << 6) + (var2 << 7);
				int var26 = (var18 << 6) + (var3 << 7);
				long var27 = class207.method3982(var2, var3, 2, var16.field2072 == 0, var4);
				int var29 = (var5 << 6) + var6;
				if (1 == var16.field2093) {
					var29 += 256;
				}

				Object var30;
				if (var6 == 22) {
					if (-1 == var16.field2076 && var16.field2094 == null) {
						var30 = var16.method3598(22, var5, var23, var25, var24, var26);
					} else {
						var30 = new class61(var4, 22, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
					}

					var43.method4128(var0, var2, var3, var24, (class212)var30, var27, var29);
					if (1 == var16.field2070) {
						var15.method3739(var2, var3);
					}
				} else if (var6 != 10 && var6 != 11) {
					if (var6 >= 12) {
						if (var16.field2076 == -1 && null == var16.field2094) {
							var30 = var16.method3598(var6, var5, var23, var25, var24, var26);
						} else {
							var30 = new class61(var4, var6, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
						}

						var43.method4166(var0, var2, var3, var24, 1, 1, (class212)var30, 0, var27, var29);
						if (var16.field2070 != 0) {
							var15.method3737(var2, var3, var17, var18, var16.field2071);
						}
					} else if (var6 == 0) {
						if (var16.field2076 == -1 && var16.field2094 == null) {
							var30 = var16.method3598(0, var5, var23, var25, var24, var26);
						} else {
							var30 = new class61(var4, 0, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
						}

						var43.method4228(var0, var2, var3, var24, (class212)var30, (class212)null, class82.field721[var5], 0, var27, var29);
						if (0 != var16.field2070) {
							var15.method3736(var2, var3, var6, var5, var16.field2071);
						}
					} else if (var6 == 1) {
						if (var16.field2076 == -1 && var16.field2094 == null) {
							var30 = var16.method3598(1, var5, var23, var25, var24, var26);
						} else {
							var30 = new class61(var4, 1, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
						}

						var43.method4228(var0, var2, var3, var24, (class212)var30, (class212)null, class82.field722[var5], 0, var27, var29);
						if (var16.field2070 != 0) {
							var15.method3736(var2, var3, var6, var5, var16.field2071);
						}
					} else {
						int var36;
						if (var6 == 2) {
							var36 = var5 + 1 & 3;
							Object var31;
							Object var32;
							if (-1 == var16.field2076 && null == var16.field2094) {
								var31 = var16.method3598(2, var5 + 4, var23, var25, var24, var26);
								var32 = var16.method3598(2, var36, var23, var25, var24, var26);
							} else {
								var31 = new class61(var4, 2, var5 + 4, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
								var32 = new class61(var4, 2, var36, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
							}

							var43.method4228(var0, var2, var3, var24, (class212)var31, (class212)var32, class82.field721[var5], class82.field721[var36], var27, var29);
							if (var16.field2070 != 0) {
								var15.method3736(var2, var3, var6, var5, var16.field2071);
							}
						} else if (var6 == 3) {
							if (-1 == var16.field2076 && null == var16.field2094) {
								var30 = var16.method3598(3, var5, var23, var25, var24, var26);
							} else {
								var30 = new class61(var4, 3, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
							}

							var43.method4228(var0, var2, var3, var24, (class212)var30, (class212)null, class82.field722[var5], 0, var27, var29);
							if (0 != var16.field2070) {
								var15.method3736(var2, var3, var6, var5, var16.field2071);
							}
						} else if (var6 == 9) {
							if (-1 == var16.field2076 && null == var16.field2094) {
								var30 = var16.method3598(var6, var5, var23, var25, var24, var26);
							} else {
								var30 = new class61(var4, var6, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
							}

							var43.method4166(var0, var2, var3, var24, 1, 1, (class212)var30, 0, var27, var29);
							if (0 != var16.field2070) {
								var15.method3737(var2, var3, var17, var18, var16.field2071);
							}
						} else if (var6 == 4) {
							if (-1 == var16.field2076 && var16.field2094 == null) {
								var30 = var16.method3598(4, var5, var23, var25, var24, var26);
							} else {
								var30 = new class61(var4, 4, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
							}

							var43.method4141(var0, var2, var3, var24, (class212)var30, (class212)null, class82.field721[var5], 0, 0, 0, var27, var29);
						} else {
							Object var33;
							long var37;
							if (var6 == 5) {
								var36 = 16;
								var37 = var43.method4185(var0, var2, var3);
								if (var37 != 0L) {
									var36 = class89.method1866(class234.method1610(var37)).field2077;
								}

								if (var16.field2076 == -1 && var16.field2094 == null) {
									var33 = var16.method3598(4, var5, var23, var25, var24, var26);
								} else {
									var33 = new class61(var4, 4, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
								}

								var43.method4141(var0, var2, var3, var24, (class212)var33, (class212)null, class82.field721[var5], 0, class82.field713[var5] * var36, var36 * class82.field725[var5], var27, var29);
							} else if (var6 == 6) {
								var36 = 8;
								var37 = var43.method4185(var0, var2, var3);
								if (0L != var37) {
									var36 = class89.method1866(class234.method1610(var37)).field2077 / 2;
								}

								if (-1 == var16.field2076 && null == var16.field2094) {
									var33 = var16.method3598(4, var5 + 4, var23, var25, var24, var26);
								} else {
									var33 = new class61(var4, 4, var5 + 4, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
								}

								var43.method4141(var0, var2, var3, var24, (class212)var33, (class212)null, 256, var5, var36 * class82.field715[var5], var36 * class82.field726[var5], var27, var29);
							} else if (var6 == 7) {
								int var39 = var5 + 2 & 3;
								if (var16.field2076 == -1 && null == var16.field2094) {
									var30 = var16.method3598(4, var39 + 4, var23, var25, var24, var26);
								} else {
									var30 = new class61(var4, 4, var39 + 4, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
								}

								var43.method4141(var0, var2, var3, var24, (class212)var30, (class212)null, 256, var39, 0, 0, var27, var29);
							} else if (var6 == 8) {
								var36 = 8;
								var37 = var43.method4185(var0, var2, var3);
								if (var37 != 0L) {
									var36 = class89.method1866(class234.method1610(var37)).field2077 / 2;
								}

								int var35 = var5 + 2 & 3;
								Object var34;
								if (var16.field2076 == -1 && var16.field2094 == null) {
									var33 = var16.method3598(4, var5 + 4, var23, var25, var24, var26);
									var34 = var16.method3598(4, var35 + 4, var23, var25, var24, var26);
								} else {
									var33 = new class61(var4, 4, var5 + 4, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
									var34 = new class61(var4, 4, var35 + 4, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
								}

								var43.method4141(var0, var2, var3, var24, (class212)var33, (class212)var34, 256, var5, var36 * class82.field715[var5], var36 * class82.field726[var5], var27, var29);
							}
						}
					}
				} else {
					if (var16.field2076 == -1 && var16.field2094 == null) {
						var30 = var16.method3598(10, var5, var23, var25, var24, var26);
					} else {
						var30 = new class61(var4, 10, var5, var13, var2, var3, var16.field2076, var16.field2099, (class212)null);
					}

					if (var30 != null) {
						var43.method4166(var0, var2, var3, var24, var17, var18, (class212)var30, var6 == 11 ? 256 : 0, var27, var29);
					}

					if (var16.field2070 != 0) {
						var15.method3737(var2, var3, var17, var18, var16.field2071);
					}
				}
			}
		}

	}
}
