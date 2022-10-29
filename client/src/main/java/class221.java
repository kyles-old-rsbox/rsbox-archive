public class class221 extends class481 {
	public static boolean field2622;
	public static class220 field2629;
	public static int field2630;
	public static int[] field2640;
	public static int[] field2644;
	public static int[] field2645;
	static boolean field2621;
	static boolean field2628;
	static boolean field2638;
	static int field2620;
	static int field2623;
	static int field2627;
	static int field2632;
	static int field2633;
	static int field2634;
	static int field2635;
	static int field2636;
	static int field2637;
	static int[] field2631;
	static int[] field2639;
	static int[] field2641;

	static {
		field2628 = false;
		field2638 = false;
		field2621 = false;
		field2622 = true;
		field2623 = 0;
		field2630 = 512;
		field2639 = new int[1024];
		field2640 = new int[65536];
		field2641 = new int[512];
		field2631 = new int[2048];
		field2644 = new int[2048];
		field2645 = new int[2048];

		int var0;
		for (var0 = 1; var0 < 512; ++var0) {
			field2641[var0] = 32768 / var0;
		}

		for (var0 = 1; var0 < 2048; ++var0) {
			field2631[var0] = 65536 / var0;
		}

		for (var0 = 0; var0 < 2048; ++var0) {
			field2644[var0] = (int)(65536.0D * Math.sin((double)var0 * 0.0030679615D));
			field2645[var0] = (int)(65536.0D * Math.cos((double)var0 * 0.0030679615D));
		}

	}

	class221() throws Throwable {
		throw new Error();
	}

	public static final void method4389() {
		method4448(class481.field4997, class481.field4995, class481.field4996, class481.field4998);
	}

	static final void method4448(int var0, int var1, int var2, int var3) {
		field2633 = var2 - var0;
		field2627 = var3 - var1;
		method4391();
		if (field2639.length < field2627) {
			field2639 = new int[class282.method953(field2627)];
		}

		int var4 = var1 * class481.field4993 + var0;

		for (int var5 = 0; var5 < field2627; ++var5) {
			field2639[var5] = var4;
			var4 += class481.field4993;
		}

	}

	public static final void method4391() {
		field2634 = field2633 / 2;
		field2620 = field2627 / 2;
		field2635 = -field2634;
		field2636 = field2633 - field2634;
		field2637 = -field2620;
		field2632 = field2627 - field2620;
	}

	public static final void method4432(int var0, int var1) {
		int var2 = field2639[0];
		int var3 = var2 / class481.field4993;
		int var4 = var2 - var3 * class481.field4993;
		field2634 = var0 - var4;
		field2620 = var1 - var3;
		field2635 = -field2634;
		field2636 = field2633 - field2634;
		field2637 = -field2620;
		field2632 = field2627 - field2620;
	}

	public static final void method4393(class220 var0) {
		field2629 = var0;
	}

	public static final void method4394(double var0) {
		method4395(var0, 0, 512);
	}

	static final void method4395(double var0, int var2, int var3) {
		int var4 = var2 * 128;

		for (int var5 = var2; var5 < var3; ++var5) {
			double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
			double var8 = (double)(var5 & 7) / 8.0D + 0.0625D;

			for (int var10 = 0; var10 < 128; ++var10) {
				double var11 = (double)var10 / 128.0D;
				double var13 = var11;
				double var15 = var11;
				double var17 = var11;
				if (var8 != 0.0D) {
					double var19;
					if (var11 < 0.5D) {
						var19 = var11 * (var8 + 1.0D);
					} else {
						var19 = var11 + var8 - var11 * var8;
					}

					double var21 = var11 * 2.0D - var19;
					double var23 = var6 + 0.3333333333333333D;
					if (var23 > 1.0D) {
						--var23;
					}

					double var27 = var6 - 0.3333333333333333D;
					if (var27 < 0.0D) {
						++var27;
					}

					if (var23 * 6.0D < 1.0D) {
						var13 = var21 + (var19 - var21) * 6.0D * var23;
					} else if (var23 * 2.0D < 1.0D) {
						var13 = var19;
					} else if (var23 * 3.0D < 2.0D) {
						var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
					} else {
						var13 = var21;
					}

					if (var6 * 6.0D < 1.0D) {
						var15 = var21 + (var19 - var21) * 6.0D * var6;
					} else if (var6 * 2.0D < 1.0D) {
						var15 = var19;
					} else if (var6 * 3.0D < 2.0D) {
						var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
					} else {
						var15 = var21;
					}

					if (var27 * 6.0D < 1.0D) {
						var17 = var21 + (var19 - var21) * 6.0D * var27;
					} else if (var27 * 2.0D < 1.0D) {
						var17 = var19;
					} else if (var27 * 3.0D < 2.0D) {
						var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
					} else {
						var17 = var21;
					}
				}

				int var29 = (int)(var13 * 256.0D);
				int var20 = (int)(var15 * 256.0D);
				int var30 = (int)(var17 * 256.0D);
				int var22 = (var29 << 16) + (var20 << 8) + var30;
				var22 = method4472(var22, var0);
				if (var22 == 0) {
					var22 = 1;
				}

				field2640[var4++] = var22;
			}
		}

	}

	static int method4472(int var0, double var1) {
		double var3 = (double)(var0 >> 16) / 256.0D;
		double var5 = (double)(var0 >> 8 & 255) / 256.0D;
		double var7 = (double)(var0 & 255) / 256.0D;
		var3 = Math.pow(var3, var1);
		var5 = Math.pow(var5, var1);
		var7 = Math.pow(var7, var1);
		int var9 = (int)(var3 * 256.0D);
		int var10 = (int)(var5 * 256.0D);
		int var11 = (int)(var7 * 256.0D);
		return (var9 << 16) + (var10 << 8) + var11;
	}

	public static void method4473(int var0, int var1, int var2) {
		field2628 = var0 < 0 || var0 > field2633 || var1 < 0 || var1 > field2633 || var2 < 0 || var2 > field2633;
	}

	static final void method4398(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9 = var4 - var3;
		int var10 = var1 - var0;
		int var11 = var5 - var3;
		int var12 = var2 - var0;
		int var13 = var7 - var6;
		int var14 = var8 - var6;
		int var15;
		if (var2 != var1) {
			var15 = (var5 - var4 << 14) / (var2 - var1);
		} else {
			var15 = 0;
		}

		int var16;
		if (var1 != var0) {
			var16 = (var9 << 14) / var10;
		} else {
			var16 = 0;
		}

		int var17;
		if (var2 != var0) {
			var17 = (var11 << 14) / var12;
		} else {
			var17 = 0;
		}

		int var18 = var9 * var12 - var11 * var10;
		if (var18 != 0) {
			int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
			int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
			if (var0 <= var1 && var0 <= var2) {
				if (var0 < field2627) {
					if (var1 > field2627) {
						var1 = field2627;
					}

					if (var2 > field2627) {
						var2 = field2627;
					}

					var6 = (var6 << 8) - var19 * var3 + var19;
					if (var1 < var2) {
						var5 = var3 <<= 14;
						if (var0 < 0) {
							var5 -= var17 * var0;
							var3 -= var16 * var0;
							var6 -= var20 * var0;
							var0 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var15 * var1;
							var1 = 0;
						}

						if ((var0 == var1 || var17 >= var16) && (var0 != var1 || var17 <= var15)) {
							var2 -= var1;
							var1 -= var0;
							var0 = field2639[var0];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										method4401(class481.field4992, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += class481.field4993;
									}
								}

								method4401(class481.field4992, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += class481.field4993;
							}
						} else {
							var2 -= var1;
							var1 -= var0;
							var0 = field2639[var0];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										method4401(class481.field4992, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
										var5 += var17;
										var4 += var15;
										var6 += var20;
										var0 += class481.field4993;
									}
								}

								method4401(class481.field4992, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
								var5 += var17;
								var3 += var16;
								var6 += var20;
								var0 += class481.field4993;
							}
						}
					} else {
						var4 = var3 <<= 14;
						if (var0 < 0) {
							var4 -= var17 * var0;
							var3 -= var16 * var0;
							var6 -= var20 * var0;
							var0 = 0;
						}

						var5 <<= 14;
						if (var2 < 0) {
							var5 -= var15 * var2;
							var2 = 0;
						}

						if (var0 != var2 && var17 < var16 || var0 == var2 && var15 > var16) {
							var1 -= var2;
							var2 -= var0;
							var0 = field2639[var0];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4401(class481.field4992, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += class481.field4993;
									}
								}

								method4401(class481.field4992, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += class481.field4993;
							}
						} else {
							var1 -= var2;
							var2 -= var0;
							var0 = field2639[var0];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4401(class481.field4992, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
										var5 += var15;
										var3 += var16;
										var6 += var20;
										var0 += class481.field4993;
									}
								}

								method4401(class481.field4992, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
								var4 += var17;
								var3 += var16;
								var6 += var20;
								var0 += class481.field4993;
							}
						}
					}
				}
			} else if (var1 <= var2) {
				if (var1 < field2627) {
					if (var2 > field2627) {
						var2 = field2627;
					}

					if (var0 > field2627) {
						var0 = field2627;
					}

					var7 = (var7 << 8) - var19 * var4 + var19;
					if (var2 < var0) {
						var3 = var4 <<= 14;
						if (var1 < 0) {
							var3 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var5 <<= 14;
						if (var2 < 0) {
							var5 -= var17 * var2;
							var2 = 0;
						}

						if ((var1 == var2 || var16 >= var15) && (var1 != var2 || var16 <= var17)) {
							var0 -= var2;
							var2 -= var1;
							var1 = field2639[var1];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4401(class481.field4992, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += class481.field4993;
									}
								}

								method4401(class481.field4992, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += class481.field4993;
							}
						} else {
							var0 -= var2;
							var2 -= var1;
							var1 = field2639[var1];

							while (true) {
								--var2;
								if (var2 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4401(class481.field4992, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
										var3 += var16;
										var5 += var17;
										var7 += var20;
										var1 += class481.field4993;
									}
								}

								method4401(class481.field4992, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
								var3 += var16;
								var4 += var15;
								var7 += var20;
								var1 += class481.field4993;
							}
						}
					} else {
						var5 = var4 <<= 14;
						if (var1 < 0) {
							var5 -= var16 * var1;
							var4 -= var15 * var1;
							var7 -= var20 * var1;
							var1 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var17 * var0;
							var0 = 0;
						}

						if (var16 < var15) {
							var2 -= var0;
							var0 -= var1;
							var1 = field2639[var1];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										method4401(class481.field4992, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += class481.field4993;
									}
								}

								method4401(class481.field4992, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += class481.field4993;
							}
						} else {
							var2 -= var0;
							var0 -= var1;
							var1 = field2639[var1];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var2;
										if (var2 < 0) {
											return;
										}

										method4401(class481.field4992, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
										var3 += var17;
										var4 += var15;
										var7 += var20;
										var1 += class481.field4993;
									}
								}

								method4401(class481.field4992, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
								var5 += var16;
								var4 += var15;
								var7 += var20;
								var1 += class481.field4993;
							}
						}
					}
				}
			} else if (var2 < field2627) {
				if (var0 > field2627) {
					var0 = field2627;
				}

				if (var1 > field2627) {
					var1 = field2627;
				}

				var8 = (var8 << 8) - var19 * var5 + var19;
				if (var0 < var1) {
					var4 = var5 <<= 14;
					if (var2 < 0) {
						var4 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var3 <<= 14;
					if (var0 < 0) {
						var3 -= var16 * var0;
						var0 = 0;
					}

					if (var15 < var17) {
						var1 -= var0;
						var0 -= var2;
						var2 = field2639[var2];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									method4401(class481.field4992, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += class481.field4993;
								}
							}

							method4401(class481.field4992, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += class481.field4993;
						}
					} else {
						var1 -= var0;
						var0 -= var2;
						var2 = field2639[var2];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									method4401(class481.field4992, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
									var4 += var15;
									var3 += var16;
									var8 += var20;
									var2 += class481.field4993;
								}
							}

							method4401(class481.field4992, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
							var4 += var15;
							var5 += var17;
							var8 += var20;
							var2 += class481.field4993;
						}
					}
				} else {
					var3 = var5 <<= 14;
					if (var2 < 0) {
						var3 -= var15 * var2;
						var5 -= var17 * var2;
						var8 -= var20 * var2;
						var2 = 0;
					}

					var4 <<= 14;
					if (var1 < 0) {
						var4 -= var16 * var1;
						var1 = 0;
					}

					if (var15 < var17) {
						var0 -= var1;
						var1 -= var2;
						var2 = field2639[var2];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									method4401(class481.field4992, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += class481.field4993;
								}
							}

							method4401(class481.field4992, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += class481.field4993;
						}
					} else {
						var0 -= var1;
						var1 -= var2;
						var2 = field2639[var2];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									method4401(class481.field4992, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
									var4 += var16;
									var5 += var17;
									var8 += var20;
									var2 += class481.field4993;
								}
							}

							method4401(class481.field4992, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
							var3 += var15;
							var5 += var17;
							var8 += var20;
							var2 += class481.field4993;
						}
					}
				}
			}
		}
	}

	static final void method4399(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, byte var9, byte var10, byte var11, byte var12) {
		var6 = method4400(var6, var9, var10, var11, var12);
		var7 = method4400(var7, var9, var10, var11, var12);
		var8 = method4400(var8, var9, var10, var11, var12);
		method4398(var0, var1, var2, var3, var4, var5, var6, var7, var8);
	}

	static int method4400(int var0, byte var1, byte var2, byte var3, byte var4) {
		int var5 = var0 >> 10 & 63;
		int var6 = var0 >> 7 & 7;
		int var7 = var0 & 127;
		int var8 = var4 & 255;
		if (var1 != -1) {
			var5 += (var1 - var5) * var8 >> 7;
		}

		if (var2 != -1) {
			var6 += (var2 - var6) * var8 >> 7;
		}

		if (var3 != -1) {
			var7 += (var3 - var7) * var8 >> 7;
		}

		return (var5 << 10 | var6 << 7 | var7) & 65535;
	}

	static final void method4401(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (field2628) {
			if (var5 > field2633) {
				var5 = field2633;
			}

			if (var4 < 0) {
				var4 = 0;
			}
		}

		if (var4 < var5) {
			var1 += var4;
			var6 += var7 * var4;
			int var8;
			int var9;
			int var10;
			int var11;
			if (field2622) {
				var3 = var5 - var4 >> 2;
				var7 <<= 2;
				if (field2623 == 0) {
					if (var3 > 0) {
						do {
							var8 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
							var2 = field2640[var8];
							var6 += var7;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							var0[var1++] = var2;
							--var3;
						} while(var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0) {
						var8 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
						var2 = field2640[var8];

						do {
							var0[var1++] = var2;
							--var3;
						} while(var3 > 0);
					}
				} else {
					var8 = field2623;
					var9 = 256 - field2623;
					if (var3 > 0) {
						do {
							var10 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
							var2 = field2640[var10];
							var6 += var7;
							var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & 65280) * var9 >> 8 & 65280);
							var11 = var0[var1];
							var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
							var11 = var0[var1];
							var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
							var11 = var0[var1];
							var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
							var11 = var0[var1];
							var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
							--var3;
						} while(var3 > 0);
					}

					var3 = var5 - var4 & 3;
					if (var3 > 0) {
						var10 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
						var2 = field2640[var10];
						var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & 65280) * var9 >> 8 & 65280);

						do {
							var11 = var0[var1];
							var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
							--var3;
						} while(var3 > 0);
					}
				}

			} else {
				var3 = var5 - var4;
				if (field2623 == 0) {
					do {
						var8 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
						var0[var1++] = field2640[var8];
						var6 += var7;
						--var3;
					} while(var3 > 0);
				} else {
					var8 = field2623;
					var9 = 256 - field2623;

					do {
						var10 = (var6 & (var6 >> 31 & 1) - 1) >> 8;
						var2 = field2640[var10];
						var6 += var7;
						var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & 65280) * var9 >> 8 & 65280);
						var11 = var0[var1];
						var0[var1++] = var2 + ((var11 & 16711935) * var8 >> 8 & 16711935) + ((var11 & 65280) * var8 >> 8 & 65280);
						--var3;
					} while(var3 > 0);
				}

			}
		}
	}

	public static final void method4460(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = 0;
		if (var1 != var0) {
			var7 = (var4 - var3 << 14) / (var1 - var0);
		}

		int var8 = 0;
		if (var2 != var1) {
			var8 = (var5 - var4 << 14) / (var2 - var1);
		}

		int var9 = 0;
		if (var2 != var0) {
			var9 = (var3 - var5 << 14) / (var0 - var2);
		}

		if (var0 <= var1 && var0 <= var2) {
			if (var0 < field2627) {
				if (var1 > field2627) {
					var1 = field2627;
				}

				if (var2 > field2627) {
					var2 = field2627;
				}

				if (var1 < var2) {
					var5 = var3 <<= 14;
					if (var0 < 0) {
						var5 -= var9 * var0;
						var3 -= var7 * var0;
						var0 = 0;
					}

					var4 <<= 14;
					if (var1 < 0) {
						var4 -= var8 * var1;
						var1 = 0;
					}

					if (var0 != var1 && var9 < var7 || var0 == var1 && var9 > var8) {
						var2 -= var1;
						var1 -= var0;
						var0 = field2639[var0];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									method4404(class481.field4992, var0, var6, 0, var5 >> 14, var4 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += class481.field4993;
								}
							}

							method4404(class481.field4992, var0, var6, 0, var5 >> 14, var3 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += class481.field4993;
						}
					} else {
						var2 -= var1;
						var1 -= var0;
						var0 = field2639[var0];

						while (true) {
							--var1;
							if (var1 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									method4404(class481.field4992, var0, var6, 0, var4 >> 14, var5 >> 14);
									var5 += var9;
									var4 += var8;
									var0 += class481.field4993;
								}
							}

							method4404(class481.field4992, var0, var6, 0, var3 >> 14, var5 >> 14);
							var5 += var9;
							var3 += var7;
							var0 += class481.field4993;
						}
					}
				} else {
					var4 = var3 <<= 14;
					if (var0 < 0) {
						var4 -= var9 * var0;
						var3 -= var7 * var0;
						var0 = 0;
					}

					var5 <<= 14;
					if (var2 < 0) {
						var5 -= var8 * var2;
						var2 = 0;
					}

					if (var0 != var2 && var9 < var7 || var0 == var2 && var8 > var7) {
						var1 -= var2;
						var2 -= var0;
						var0 = field2639[var0];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									method4404(class481.field4992, var0, var6, 0, var5 >> 14, var3 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += class481.field4993;
								}
							}

							method4404(class481.field4992, var0, var6, 0, var4 >> 14, var3 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += class481.field4993;
						}
					} else {
						var1 -= var2;
						var2 -= var0;
						var0 = field2639[var0];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var1;
									if (var1 < 0) {
										return;
									}

									method4404(class481.field4992, var0, var6, 0, var3 >> 14, var5 >> 14);
									var5 += var8;
									var3 += var7;
									var0 += class481.field4993;
								}
							}

							method4404(class481.field4992, var0, var6, 0, var3 >> 14, var4 >> 14);
							var4 += var9;
							var3 += var7;
							var0 += class481.field4993;
						}
					}
				}
			}
		} else if (var1 <= var2) {
			if (var1 < field2627) {
				if (var2 > field2627) {
					var2 = field2627;
				}

				if (var0 > field2627) {
					var0 = field2627;
				}

				if (var2 < var0) {
					var3 = var4 <<= 14;
					if (var1 < 0) {
						var3 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var5 <<= 14;
					if (var2 < 0) {
						var5 -= var9 * var2;
						var2 = 0;
					}

					if (var1 != var2 && var7 < var8 || var1 == var2 && var7 > var9) {
						var0 -= var2;
						var2 -= var1;
						var1 = field2639[var1];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									method4404(class481.field4992, var1, var6, 0, var3 >> 14, var5 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += class481.field4993;
								}
							}

							method4404(class481.field4992, var1, var6, 0, var3 >> 14, var4 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += class481.field4993;
						}
					} else {
						var0 -= var2;
						var2 -= var1;
						var1 = field2639[var1];

						while (true) {
							--var2;
							if (var2 < 0) {
								while (true) {
									--var0;
									if (var0 < 0) {
										return;
									}

									method4404(class481.field4992, var1, var6, 0, var5 >> 14, var3 >> 14);
									var3 += var7;
									var5 += var9;
									var1 += class481.field4993;
								}
							}

							method4404(class481.field4992, var1, var6, 0, var4 >> 14, var3 >> 14);
							var3 += var7;
							var4 += var8;
							var1 += class481.field4993;
						}
					}
				} else {
					var5 = var4 <<= 14;
					if (var1 < 0) {
						var5 -= var7 * var1;
						var4 -= var8 * var1;
						var1 = 0;
					}

					var3 <<= 14;
					if (var0 < 0) {
						var3 -= var9 * var0;
						var0 = 0;
					}

					if (var7 < var8) {
						var2 -= var0;
						var0 -= var1;
						var1 = field2639[var1];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									method4404(class481.field4992, var1, var6, 0, var3 >> 14, var4 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += class481.field4993;
								}
							}

							method4404(class481.field4992, var1, var6, 0, var5 >> 14, var4 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += class481.field4993;
						}
					} else {
						var2 -= var0;
						var0 -= var1;
						var1 = field2639[var1];

						while (true) {
							--var0;
							if (var0 < 0) {
								while (true) {
									--var2;
									if (var2 < 0) {
										return;
									}

									method4404(class481.field4992, var1, var6, 0, var4 >> 14, var3 >> 14);
									var3 += var9;
									var4 += var8;
									var1 += class481.field4993;
								}
							}

							method4404(class481.field4992, var1, var6, 0, var4 >> 14, var5 >> 14);
							var5 += var7;
							var4 += var8;
							var1 += class481.field4993;
						}
					}
				}
			}
		} else if (var2 < field2627) {
			if (var0 > field2627) {
				var0 = field2627;
			}

			if (var1 > field2627) {
				var1 = field2627;
			}

			if (var0 < var1) {
				var4 = var5 <<= 14;
				if (var2 < 0) {
					var4 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var3 <<= 14;
				if (var0 < 0) {
					var3 -= var7 * var0;
					var0 = 0;
				}

				if (var8 < var9) {
					var1 -= var0;
					var0 -= var2;
					var2 = field2639[var2];

					while (true) {
						--var0;
						if (var0 < 0) {
							while (true) {
								--var1;
								if (var1 < 0) {
									return;
								}

								method4404(class481.field4992, var2, var6, 0, var4 >> 14, var3 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += class481.field4993;
							}
						}

						method4404(class481.field4992, var2, var6, 0, var4 >> 14, var5 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += class481.field4993;
					}
				} else {
					var1 -= var0;
					var0 -= var2;
					var2 = field2639[var2];

					while (true) {
						--var0;
						if (var0 < 0) {
							while (true) {
								--var1;
								if (var1 < 0) {
									return;
								}

								method4404(class481.field4992, var2, var6, 0, var3 >> 14, var4 >> 14);
								var4 += var8;
								var3 += var7;
								var2 += class481.field4993;
							}
						}

						method4404(class481.field4992, var2, var6, 0, var5 >> 14, var4 >> 14);
						var4 += var8;
						var5 += var9;
						var2 += class481.field4993;
					}
				}
			} else {
				var3 = var5 <<= 14;
				if (var2 < 0) {
					var3 -= var8 * var2;
					var5 -= var9 * var2;
					var2 = 0;
				}

				var4 <<= 14;
				if (var1 < 0) {
					var4 -= var7 * var1;
					var1 = 0;
				}

				if (var8 < var9) {
					var0 -= var1;
					var1 -= var2;
					var2 = field2639[var2];

					while (true) {
						--var1;
						if (var1 < 0) {
							while (true) {
								--var0;
								if (var0 < 0) {
									return;
								}

								method4404(class481.field4992, var2, var6, 0, var4 >> 14, var5 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += class481.field4993;
							}
						}

						method4404(class481.field4992, var2, var6, 0, var3 >> 14, var5 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += class481.field4993;
					}
				} else {
					var0 -= var1;
					var1 -= var2;
					var2 = field2639[var2];

					while (true) {
						--var1;
						if (var1 < 0) {
							while (true) {
								--var0;
								if (var0 < 0) {
									return;
								}

								method4404(class481.field4992, var2, var6, 0, var5 >> 14, var4 >> 14);
								var4 += var7;
								var5 += var9;
								var2 += class481.field4993;
							}
						}

						method4404(class481.field4992, var2, var6, 0, var5 >> 14, var3 >> 14);
						var3 += var8;
						var5 += var9;
						var2 += class481.field4993;
					}
				}
			}
		}
	}

	static final void method4403(int var0, int var1, int var2, int var3, int var4, int var5, int var6, byte var7, byte var8, byte var9, byte var10) {
		int var11 = method4400(var6, var7, var8, var9, var10);
		var6 = field2640[var11];
		method4460(var0, var1, var2, var3, var4, var5, var6);
	}

	static final void method4404(int[] var0, int var1, int var2, int var3, int var4, int var5) {
		if (field2628) {
			if (var5 > field2633) {
				var5 = field2633;
			}

			if (var4 < 0) {
				var4 = 0;
			}
		}

		if (var4 < var5) {
			var1 += var4;
			var3 = var5 - var4 >> 2;
			if (field2623 != 0) {
				if (field2623 == 254) {
					while (true) {
						--var3;
						if (var3 < 0) {
							var3 = var5 - var4 & 3;

							while (true) {
								--var3;
								if (var3 < 0) {
									return;
								}

								var0[var1++] = var0[var1];
							}
						}

						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
						var0[var1++] = var0[var1];
					}
				} else {
					int var6 = field2623;
					int var7 = 256 - field2623;
					var2 = ((var2 & 16711935) * var7 >> 8 & 16711935) + ((var2 & 65280) * var7 >> 8 & 65280);

					while (true) {
						--var3;
						int var8;
						if (var3 < 0) {
							var3 = var5 - var4 & 3;

							while (true) {
								--var3;
								if (var3 < 0) {
									return;
								}

								var8 = var0[var1];
								var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & 65280) * var6 >> 8 & 65280);
							}
						}

						var8 = var0[var1];
						var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & 65280) * var6 >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & 65280) * var6 >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & 65280) * var6 >> 8 & 65280);
						var8 = var0[var1];
						var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & 65280) * var6 >> 8 & 65280);
					}
				}
			} else {
				while (true) {
					--var3;
					if (var3 < 0) {
						var3 = var5 - var4 & 3;

						while (true) {
							--var3;
							if (var3 < 0) {
								return;
							}

							var0[var1++] = var2;
						}
					}

					var0[var1++] = var2;
					var0[var1++] = var2;
					var0[var1++] = var2;
					var0[var1++] = var2;
				}
			}
		}
	}

	static final void method4405(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
		int[] var19 = field2629.method4374(var18);
		int var20;
		if (var19 == null) {
			var20 = field2629.method4372(var18);
			method4398(var0, var1, var2, var3, var4, var5, method4408(var20, var6), method4408(var20, var7), method4408(var20, var8));
		} else {
			field2621 = field2629.method4375(var18);
			field2638 = field2629.method4373(var18);
			var20 = var4 - var3;
			int var21 = var1 - var0;
			int var22 = var5 - var3;
			int var23 = var2 - var0;
			int var24 = var7 - var6;
			int var25 = var8 - var6;
			int var26 = 0;
			if (var1 != var0) {
				var26 = (var4 - var3 << 14) / (var1 - var0);
			}

			int var27 = 0;
			if (var2 != var1) {
				var27 = (var5 - var4 << 14) / (var2 - var1);
			}

			int var28 = 0;
			if (var2 != var0) {
				var28 = (var3 - var5 << 14) / (var0 - var2);
			}

			int var29 = var20 * var23 - var22 * var21;
			if (var29 != 0) {
				int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
				int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
				var10 = var9 - var10;
				var13 = var12 - var13;
				var16 = var15 - var16;
				var11 -= var9;
				var14 -= var12;
				var17 -= var15;
				int var32 = var11 * var12 - var14 * var9 << 14;
				int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 3 << 14) / (long)field2630);
				int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field2630);
				int var35 = var10 * var12 - var13 * var9 << 14;
				int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 3 << 14) / (long)field2630);
				int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field2630);
				int var38 = var13 * var11 - var10 * var14 << 14;
				int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 3 << 14) / (long)field2630);
				int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field2630);
				int var41;
				if (var0 <= var1 && var0 <= var2) {
					if (var0 < field2627) {
						if (var1 > field2627) {
							var1 = field2627;
						}

						if (var2 > field2627) {
							var2 = field2627;
						}

						var6 = (var6 << 9) - var30 * var3 + var30;
						if (var1 < var2) {
							var5 = var3 <<= 14;
							if (var0 < 0) {
								var5 -= var28 * var0;
								var3 -= var26 * var0;
								var6 -= var31 * var0;
								var0 = 0;
							}

							var4 <<= 14;
							if (var1 < 0) {
								var4 -= var27 * var1;
								var1 = 0;
							}

							var41 = var0 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
								var2 -= var1;
								var1 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var1;
								var1 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var4 = var3 <<= 14;
							if (var0 < 0) {
								var4 -= var28 * var0;
								var3 -= var26 * var0;
								var6 -= var31 * var0;
								var0 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var27 * var2;
								var2 = 0;
							}

							var41 = var0 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var0 == var2 || var28 >= var26) && (var0 != var2 || var27 <= var26)) {
								var1 -= var2;
								var2 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var1 -= var2;
								var2 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var1 <= var2) {
					if (var1 < field2627) {
						if (var2 > field2627) {
							var2 = field2627;
						}

						if (var0 > field2627) {
							var0 = field2627;
						}

						var7 = (var7 << 9) - var30 * var4 + var30;
						if (var2 < var0) {
							var3 = var4 <<= 14;
							if (var1 < 0) {
								var3 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var28 * var2;
								var2 = 0;
							}

							var41 = var1 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var1 != var2 && var26 < var27 || var1 == var2 && var26 > var28) {
								var0 -= var2;
								var2 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var0 -= var2;
								var2 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var5 = var4 <<= 14;
							if (var1 < 0) {
								var5 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var3 <<= 14;
							if (var0 < 0) {
								var3 -= var28 * var0;
								var0 = 0;
							}

							var41 = var1 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var26 < var27) {
								var2 -= var0;
								var0 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var0;
								var0 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4428(class481.field4992, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4428(class481.field4992, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var2 < field2627) {
					if (var0 > field2627) {
						var0 = field2627;
					}

					if (var1 > field2627) {
						var1 = field2627;
					}

					var8 = (var8 << 9) - var30 * var5 + var30;
					if (var0 < var1) {
						var4 = var5 <<= 14;
						if (var2 < 0) {
							var4 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var26 * var0;
							var0 = 0;
						}

						var41 = var2 - field2620;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var1 -= var0;
							var0 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4428(class481.field4992, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4428(class481.field4992, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var1 -= var0;
							var0 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4428(class481.field4992, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4428(class481.field4992, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					} else {
						var3 = var5 <<= 14;
						if (var2 < 0) {
							var3 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var26 * var1;
							var1 = 0;
						}

						var41 = var2 - field2620;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var0 -= var1;
							var1 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4428(class481.field4992, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4428(class481.field4992, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var0 -= var1;
							var1 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4428(class481.field4992, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4428(class481.field4992, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					}
				}
			}
		}
	}

	static final void method4428(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (field2628) {
			if (var6 > field2633) {
				var6 = field2633;
			}

			if (var5 < 0) {
				var5 = 0;
			}
		}

		if (var5 < var6) {
			var4 += var5;
			var7 += var8 * var5;
			int var17 = var6 - var5;
			int var15;
			int var16;
			int var10000;
			int var18;
			int var19;
			int var20;
			int var21;
			int var22;
			int var23;
			if (field2621) {
				var23 = var5 - field2634;
				var9 += (var12 >> 3) * var23;
				var10 += (var13 >> 3) * var23;
				var11 += (var14 >> 3) * var23;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0) {
						var18 = 0;
					} else if (var18 > 4032) {
						var18 = 4032;
					}
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0) {
						var20 = 0;
					} else if (var20 > 4032) {
						var20 = 4032;
					}
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 20) + var19;
				var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field2638) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var10000 = var2 + var16;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 12;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 4032) {
									var20 = 4032;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var10000 = var2 + var16;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 12;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 4032) {
									var20 = 4032;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 20) + var19;
							var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			} else {
				var23 = var5 - field2634;
				var9 += (var12 >> 3) * var23;
				var10 += (var13 >> 3) * var23;
				var11 += (var14 >> 3) * var23;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
					if (var18 < 0) {
						var18 = 0;
					} else if (var18 > 16256) {
						var18 = 16256;
					}
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12;
				var10 += var13;
				var11 += var14;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
					if (var20 < 0) {
						var20 = 0;
					} else if (var20 > 16256) {
						var20 = 16256;
					}
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 18) + var19;
				var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field2638) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var10000 = var2 + var16;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 14;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 16256) {
									var20 = 16256;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var10000 = var2 + var16;
							var18 = var20;
							var19 = var21;
							var9 += var12;
							var10 += var13;
							var11 += var14;
							var22 = var11 >> 14;
							if (var22 != 0) {
								var20 = var9 / var22;
								var21 = var10 / var22;
								if (var20 < 0) {
									var20 = 0;
								} else if (var20 > 16256) {
									var20 = 16256;
								}
							} else {
								var20 = 0;
								var21 = 0;
							}

							var2 = (var18 << 18) + var19;
							var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			}

		}
	}

	static final void method4388(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
		int[] var19 = field2629.method4374(var18);
		int var20;
		if (var19 == null) {
			var20 = field2629.method4372(var18);
			method4398(var0, var1, var2, var3, var4, var5, method4408(var20, var6), method4408(var20, var7), method4408(var20, var8));
		} else {
			field2621 = field2629.method4375(var18);
			field2638 = field2629.method4373(var18);
			var20 = var4 - var3;
			int var21 = var1 - var0;
			int var22 = var5 - var3;
			int var23 = var2 - var0;
			int var24 = var7 - var6;
			int var25 = var8 - var6;
			int var26 = 0;
			if (var1 != var0) {
				var26 = (var4 - var3 << 14) / (var1 - var0);
			}

			int var27 = 0;
			if (var2 != var1) {
				var27 = (var5 - var4 << 14) / (var2 - var1);
			}

			int var28 = 0;
			if (var2 != var0) {
				var28 = (var3 - var5 << 14) / (var0 - var2);
			}

			int var29 = var20 * var23 - var22 * var21;
			if (var29 != 0) {
				int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
				int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
				var10 = var9 - var10;
				var13 = var12 - var13;
				var16 = var15 - var16;
				var11 -= var9;
				var14 -= var12;
				var17 -= var15;
				int var32 = var11 * var12 - var14 * var9 << 14;
				int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 14) / (long)field2630);
				int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field2630);
				int var35 = var10 * var12 - var13 * var9 << 14;
				int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 14) / (long)field2630);
				int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field2630);
				int var38 = var13 * var11 - var10 * var14 << 14;
				int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 14) / (long)field2630);
				int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field2630);
				int var41;
				if (var0 <= var1 && var0 <= var2) {
					if (var0 < field2627) {
						if (var1 > field2627) {
							var1 = field2627;
						}

						if (var2 > field2627) {
							var2 = field2627;
						}

						var6 = (var6 << 9) - var30 * var3 + var30;
						if (var1 < var2) {
							var5 = var3 <<= 14;
							if (var0 < 0) {
								var5 -= var28 * var0;
								var3 -= var26 * var0;
								var6 -= var31 * var0;
								var0 = 0;
							}

							var4 <<= 14;
							if (var1 < 0) {
								var4 -= var27 * var1;
								var1 = 0;
							}

							var41 = var0 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
								var2 -= var1;
								var1 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var1;
								var1 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var1;
									if (var1 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var28;
											var4 += var27;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var5 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var4 = var3 <<= 14;
							if (var0 < 0) {
								var4 -= var28 * var0;
								var3 -= var26 * var0;
								var6 -= var31 * var0;
								var0 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var27 * var2;
								var2 = 0;
							}

							var41 = var0 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if ((var0 == var2 || var28 >= var26) && (var0 != var2 || var27 <= var26)) {
								var1 -= var2;
								var2 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var1 -= var2;
								var2 -= var0;
								var0 = field2639[var0];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var1;
											if (var1 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
											var5 += var27;
											var3 += var26;
											var6 += var31;
											var0 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
									var4 += var28;
									var3 += var26;
									var6 += var31;
									var0 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var1 <= var2) {
					if (var1 < field2627) {
						if (var2 > field2627) {
							var2 = field2627;
						}

						if (var0 > field2627) {
							var0 = field2627;
						}

						var7 = (var7 << 9) - var30 * var4 + var30;
						if (var2 < var0) {
							var3 = var4 <<= 14;
							if (var1 < 0) {
								var3 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var5 <<= 14;
							if (var2 < 0) {
								var5 -= var28 * var2;
								var2 = 0;
							}

							var41 = var1 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var1 != var2 && var26 < var27 || var1 == var2 && var26 > var28) {
								var0 -= var2;
								var2 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var0 -= var2;
								var2 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var2;
									if (var2 < 0) {
										while (true) {
											--var0;
											if (var0 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var26;
											var5 += var28;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var3 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						} else {
							var5 = var4 <<= 14;
							if (var1 < 0) {
								var5 -= var26 * var1;
								var4 -= var27 * var1;
								var7 -= var31 * var1;
								var1 = 0;
							}

							var3 <<= 14;
							if (var0 < 0) {
								var3 -= var28 * var0;
								var0 = 0;
							}

							var41 = var1 - field2620;
							var32 += var34 * var41;
							var35 += var37 * var41;
							var38 += var40 * var41;
							if (var26 < var27) {
								var2 -= var0;
								var0 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							} else {
								var2 -= var0;
								var0 -= var1;
								var1 = field2639[var1];

								while (true) {
									--var0;
									if (var0 < 0) {
										while (true) {
											--var2;
											if (var2 < 0) {
												return;
											}

											method4431(class481.field4992, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
											var3 += var28;
											var4 += var27;
											var7 += var31;
											var1 += class481.field4993;
											var32 += var34;
											var35 += var37;
											var38 += var40;
										}
									}

									method4431(class481.field4992, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
									var5 += var26;
									var4 += var27;
									var7 += var31;
									var1 += class481.field4993;
									var32 += var34;
									var35 += var37;
									var38 += var40;
								}
							}
						}
					}
				} else if (var2 < field2627) {
					if (var0 > field2627) {
						var0 = field2627;
					}

					if (var1 > field2627) {
						var1 = field2627;
					}

					var8 = (var8 << 9) - var30 * var5 + var30;
					if (var0 < var1) {
						var4 = var5 <<= 14;
						if (var2 < 0) {
							var4 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var3 <<= 14;
						if (var0 < 0) {
							var3 -= var26 * var0;
							var0 = 0;
						}

						var41 = var2 - field2620;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var1 -= var0;
							var0 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4431(class481.field4992, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4431(class481.field4992, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var1 -= var0;
							var0 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var0;
								if (var0 < 0) {
									while (true) {
										--var1;
										if (var1 < 0) {
											return;
										}

										method4431(class481.field4992, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var27;
										var3 += var26;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4431(class481.field4992, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var4 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					} else {
						var3 = var5 <<= 14;
						if (var2 < 0) {
							var3 -= var27 * var2;
							var5 -= var28 * var2;
							var8 -= var31 * var2;
							var2 = 0;
						}

						var4 <<= 14;
						if (var1 < 0) {
							var4 -= var26 * var1;
							var1 = 0;
						}

						var41 = var2 - field2620;
						var32 += var34 * var41;
						var35 += var37 * var41;
						var38 += var40 * var41;
						if (var27 < var28) {
							var0 -= var1;
							var1 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4431(class481.field4992, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4431(class481.field4992, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						} else {
							var0 -= var1;
							var1 -= var2;
							var2 = field2639[var2];

							while (true) {
								--var1;
								if (var1 < 0) {
									while (true) {
										--var0;
										if (var0 < 0) {
											return;
										}

										method4431(class481.field4992, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
										var4 += var26;
										var5 += var28;
										var8 += var31;
										var2 += class481.field4993;
										var32 += var34;
										var35 += var37;
										var38 += var40;
									}
								}

								method4431(class481.field4992, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
								var3 += var27;
								var5 += var28;
								var8 += var31;
								var2 += class481.field4993;
								var32 += var34;
								var35 += var37;
								var38 += var40;
							}
						}
					}
				}
			}
		}
	}

	static final void method4431(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (field2628) {
			if (var6 > field2633) {
				var6 = field2633;
			}

			if (var5 < 0) {
				var5 = 0;
			}
		}

		if (var5 < var6) {
			var4 += var5;
			var7 += var8 * var5;
			int var17 = var6 - var5;
			int var15;
			int var16;
			int var18;
			int var19;
			int var20;
			int var21;
			int var22;
			int var23;
			if (field2621) {
				var23 = var5 - field2634;
				var9 += var12 * var23;
				var10 += var13 * var23;
				var11 += var14 * var23;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12 * var17;
				var10 += var13 * var17;
				var11 += var14 * var17;
				var22 = var11 >> 12;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 20) + var19;
				var16 = ((var20 - var18) / var17 << 20) + (var21 - var19) / var17;
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field2638) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 4032) + (var2 >>> 26)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			} else {
				var23 = var5 - field2634;
				var9 += var12 * var23;
				var10 += var13 * var23;
				var11 += var14 * var23;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var18 = var9 / var22;
					var19 = var10 / var22;
				} else {
					var18 = 0;
					var19 = 0;
				}

				var9 += var12 * var17;
				var10 += var13 * var17;
				var11 += var14 * var17;
				var22 = var11 >> 14;
				if (var22 != 0) {
					var20 = var9 / var22;
					var21 = var10 / var22;
				} else {
					var20 = 0;
					var21 = 0;
				}

				var2 = (var18 << 18) + var19;
				var16 = ((var20 - var18) / var17 << 18) + (var21 - var19) / var17;
				var17 >>= 3;
				var8 <<= 3;
				var15 = var7 >> 8;
				if (field2638) {
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							var3 = var1[(var2 & 16256) + (var2 >>> 25)];
							var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				} else {
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							var7 += var8;
							var15 = var7 >> 8;
							--var17;
						} while(var17 > 0);
					}

					var17 = var6 - var5 & 7;
					if (var17 > 0) {
						do {
							if ((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
								var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & 65280) * var15 & 16711680) >> 8;
							}

							++var4;
							var2 += var16;
							--var17;
						} while(var17 > 0);
					}
				}
			}

		}
	}

	static final int method4408(int var0, int var1) {
		var1 = var1 * (var0 & 127) >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}

	static final int method4430(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var1 * var3 >> 16;
	}

	static final int method4410(int var0, int var1, int var2, int var3) {
		return var1 * var2 - var0 * var3 >> 16;
	}

	static final int method4454(int var0, int var1, int var2, int var3) {
		return var0 * var2 - var1 * var3 >> 16;
	}

	static final int method4412(int var0, int var1, int var2, int var3) {
		return var0 * var3 + var1 * var2 >> 16;
	}

	static final int method4429(int var0, int var1, int var2, int var3) {
		return var0 * var2 + var1 * var3 >> 16;
	}

	static final int method4439(int var0, int var1, int var2, int var3) {
		return var1 * var2 - var0 * var3 >> 16;
	}
}
