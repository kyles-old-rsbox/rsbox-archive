public class class142 {
	static class488 field1319;
	class350 field1320;
	int field1310;
	long field1311;

	public static Object method2479(byte[] var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0.length > 136) {
			class289 var3 = new class289();
			var3.method5509(var0);
			return var3;
		} else if (var1) {
			int var4 = var0.length;
			byte[] var5 = new byte[var4];
			System.arraycopy(var0, 0, var5, 0, var4);
			return var5;
		} else {
			return var0;
		}
	}

	public class142(Buffer var1) {
		this.field1310 = -1;
		this.field1320 = new class350();
		this.method2480(var1);
	}

	void method2480(Buffer var1) {
		this.field1311 = var1.readLong();
		this.field1310 = var1.method8126();

		for (int var3 = var1.method8141(); var3 != 0; var3 = var1.method8141()) {
			Object var4;
			if (var3 == 3) {
				var4 = new class174(this);
			} else if (var3 == 1) {
				var4 = new class132(this);
			} else if (var3 == 13) {
				var4 = new class139(this);
			} else if (var3 == 4) {
				var4 = new class155(this);
			} else if (var3 == 6) {
				var4 = new class151(this);
			} else if (var3 == 5) {
				var4 = new class146(this);
			} else if (var3 == 2) {
				var4 = new class145(this);
			} else if (var3 == 7) {
				var4 = new class144(this);
			} else if (var3 == 14) {
				var4 = new class153(this);
			} else if (var3 == 8) {
				var4 = new class154(this);
			} else if (var3 == 9) {
				var4 = new class180(this);
			} else if (var3 == 10) {
				var4 = new class131(this);
			} else if (var3 == 11) {
				var4 = new class138(this);
			} else if (var3 == 12) {
				var4 = new class152(this);
			} else {
				if (var3 != 15) {
					throw new RuntimeException("");
				}

				var4 = new class135(this);
			}

			((class140)var4).method2467(var1);
			this.field1320.method6462((class427)var4);
		}

	}

	public void method2481(class148 var1) {
		if (var1.field1360 == this.field1311 && this.field1310 == var1.field1361) {
			for (class140 var3 = (class140)this.field1320.method6465(); null != var3; var3 = (class140)this.field1320.method6467()) {
				var3.method2468(var1);
			}

			++var1.field1361;
		} else {
			throw new RuntimeException("");
		}
	}

	static final void method2486(class90 var0, int var1, int var2, int var3, int var4, int var5) {
		if (var0 != null && var0.method1869()) {
			if (var0 instanceof class81) {
				class203 var7 = ((class81)var0).field709;
				if (null != var7.field2278) {
					var7 = var7.method3857();
				}

				if (var7 == null) {
					return;
				}
			}

			int var76 = PlayerManager.playerCount;
			int[] var8 = PlayerManager.field1013;
			byte var9 = 0;
			if (var1 < var76 && client.field1645 == var0.field872 && class260.method5147((class93)var0)) {
				class93 var10 = (class93)var0;
				if (var1 < var76) {
					client.method2451(var0, 15 + var0.field809);
					class384 var11 = (class384)client.field1934.get(class442.field4769);
					byte var12 = 9;
					var11.method6955(var10.field910.method8451(), var2 + client.field1809, var3 + client.field1747 - var12, 16777215, 0);
					var9 = 18;
				}
			}

			int var77 = -2;
			int var16;
			int var23;
			int var24;
			if (!var0.field834.method6531()) {
				client.method2451(var0, 15 + var0.field809);

				for (class91 var88 = (class91)var0.field834.method6465(); null != var88; var88 = (class91)var0.field834.method6467()) {
					class99 var78 = var88.method1896(client.field1645);
					if (var78 == null) {
						if (var88.method1891()) {
							var88.method7825();
						}
					} else {
						class158 var13 = var88.field880;
						class473 var14 = var13.method2625();
						class473 var15 = var13.method2631();
						int var17 = 0;
						if (null != var14 && var15 != null) {
							if (var13.field1444 * 2 < var15.field4959) {
								var17 = var13.field1444;
							}

							var16 = var15.field4959 - var17 * 2;
						} else {
							var16 = var13.field1453;
						}

						int var18 = 255;
						boolean var19 = true;
						int var20 = client.field1645 - var78.field986;
						int var21 = var78.field982 * var16 / var13.field1453;
						int var22;
						int var94;
						if (var78.field983 > var20) {
							var22 = 0 == var13.field1454 ? 0 : var20 / var13.field1454 * var13.field1454;
							var23 = var16 * var78.field980 / var13.field1453;
							var94 = (var21 - var23) * var22 / var78.field983 + var23;
						} else {
							var94 = var21;
							var22 = var78.field983 + var13.field1450 - var20;
							if (var13.field1448 >= 0) {
								var18 = (var22 << 8) / (var13.field1450 - var13.field1448);
							}
						}

						if (var78.field982 > 0 && var94 < 1) {
							var94 = 1;
						}

						if (var14 != null && null != var15) {
							if (var16 == var94) {
								var94 += var17 * 2;
							} else {
								var94 += var17;
							}

							var22 = var14.field4951;
							var77 += var22;
							var23 = var2 + client.field1809 - (var16 >> 1);
							var24 = client.field1747 + var3 - var77;
							var23 -= var17;
							if (var18 >= 0 && var18 < 255) {
								var14.method8491(var23, var24, var18);
								class481.method8724(var23, var24, var23 + var94, var24 + var22);
								var15.method8491(var23, var24, var18);
							} else {
								var14.method8526(var23, var24);
								class481.method8724(var23, var24, var23 + var94, var22 + var24);
								var15.method8526(var23, var24);
							}

							class481.method8653(var2, var3, var2 + var4, var3 + var5);
							var77 += 2;
						} else {
							var77 += 5;
							if (client.field1809 > -1) {
								var22 = client.field1809 + var2 - (var16 >> 1);
								var23 = client.field1747 + var3 - var77;
								class481.method8660(var22, var23, var94, 5, 65280);
								class481.method8660(var94 + var22, var23, var16 - var94, 5, 16711680);
							}

							var77 += 2;
						}
					}
				}
			}

			if (var77 == -2) {
				var77 += 7;
			}

			var77 += var9;
			if (var1 < var76) {
				class93 var89 = (class93)var0;
				if (var89.field913) {
					return;
				}

				if (var89.field894 != -1 || -1 != var89.field893) {
					client.method2451(var0, var0.field809 + 15);
					if (client.field1809 > -1) {
						if (-1 != var89.field894) {
							var77 += 25;
							class212.field2488[var89.field894].method8526(client.field1809 + var2 - 12, var3 + client.field1747 - var77);
						}

						if (-1 != var89.field893) {
							var77 += 25;
							class264.field2999[var89.field893].method8526(var2 + client.field1809 - 12, var3 + client.field1747 - var77);
						}
					}
				}

				if (var1 >= 0 && client.hintArrowType == 10 && var8[var1] == client.field1654) {
					client.method2451(var0, 15 + var0.field809);
					if (client.field1809 > -1) {
						var77 += class176.field1585[1].field4951;
						class176.field1585[1].method8526(var2 + client.field1809 - 12, client.field1747 + var3 - var77);
					}
				}
			} else {
				class203 var90 = ((class81)var0).field709;
				if (null != var90.field2278) {
					var90 = var90.method3857();
				}

				if (var90.field2292 >= 0 && var90.field2292 < class264.field2999.length) {
					client.method2451(var0, var0.field809 + 15);
					if (client.field1809 > -1) {
						class264.field2999[var90.field2292].method8526(var2 + client.field1809 - 12, client.field1747 + var3 - 30);
					}
				}

				if (1 == client.hintArrowType && client.field1692[var1 - var76] == client.field1879 && client.field1645 % 20 < 10) {
					client.method2451(var0, 15 + var0.field809);
					if (client.field1809 > -1) {
						class176.field1585[0].method8526(var2 + client.field1809 - 12, client.field1747 + var3 - 28);
					}
				}
			}

			if (var0.field822 != null && (var1 >= var76 || !var0.field820 && (client.field1871 == 4 || !var0.field842 && (0 == client.field1871 || 3 == client.field1871 || client.field1871 == 1 && ((class93)var0).method1907())))) {
				client.method2451(var0, var0.field809);
				if (client.field1809 > -1 && client.field1661 < client.field1735) {
					client.field1659[client.field1661] = class114.field1127.method6894(var0.field822) / 2;
					client.field1721[client.field1661] = class114.field1127.field4435;
					client.field1736[client.field1661] = client.field1809;
					client.field1908[client.field1661] = client.field1747;
					client.field1740[client.field1661] = var0.field801;
					client.field1741[client.field1661] = var0.field819;
					client.field1649[client.field1661] = var0.field843;
					client.field1743[client.field1661] = var0.field822;
					++client.field1661;
				}
			}

			for (int var79 = 0; var79 < 4; ++var79) {
				int var91 = var0.field831[var79];
				int var80 = var0.field829[var79];
				class206 var92 = null;
				int var81 = 0;
				if (var80 >= 0) {
					if (var91 <= client.field1645) {
						continue;
					}

					var92 = class169.method2715(var0.field829[var79]);
					var81 = var92.field2327;
					if (null != var92 && null != var92.field2348) {
						var92 = var92.method3929();
						if (null == var92) {
							var0.field831[var79] = -1;
							continue;
						}
					}
				} else if (var91 < 0) {
					continue;
				}

				var16 = var0.field832[var79];
				class206 var82 = null;
				if (var16 >= 0) {
					var82 = class169.method2715(var16);
					if (null != var82 && var82.field2348 != null) {
						var82 = var82.method3929();
					}
				}

				if (var91 - var81 <= client.field1645) {
					if (null == var92) {
						var0.field831[var79] = -1;
					} else {
						client.method2451(var0, var0.field809 / 2);
						if (client.field1809 > -1) {
							boolean var93 = true;
							if (var79 == 1) {
								client.field1747 -= 20;
							}

							if (var79 == 2) {
								client.field1809 -= 15;
								client.field1747 -= 10;
							}

							if (var79 == 3) {
								client.field1809 += 15;
								client.field1747 -= 10;
							}

							class473 var83 = null;
							class473 var84 = null;
							class473 var85 = null;
							class473 var86 = null;
							var23 = 0;
							var24 = 0;
							int var25 = 0;
							int var26 = 0;
							int var27 = 0;
							int var28 = 0;
							int var29 = 0;
							int var30 = 0;
							class473 var31 = null;
							class473 var32 = null;
							class473 var33 = null;
							class473 var34 = null;
							int var35 = 0;
							int var36 = 0;
							int var37 = 0;
							int var38 = 0;
							int var39 = 0;
							int var40 = 0;
							int var41 = 0;
							int var42 = 0;
							int var43 = 0;
							var83 = var92.method3954();
							int var44;
							if (var83 != null) {
								var23 = var83.field4959;
								var44 = var83.field4951;
								if (var44 > var43) {
									var43 = var44;
								}

								var27 = var83.field4954;
							}

							var84 = var92.method3944();
							if (var84 != null) {
								var24 = var84.field4959;
								var44 = var84.field4951;
								if (var44 > var43) {
									var43 = var44;
								}

								var28 = var84.field4954;
							}

							var85 = var92.method3936();
							if (var85 != null) {
								var25 = var85.field4959;
								var44 = var85.field4951;
								if (var44 > var43) {
									var43 = var44;
								}

								var29 = var85.field4954;
							}

							var86 = var92.method3963();
							if (null != var86) {
								var26 = var86.field4959;
								var44 = var86.field4951;
								if (var44 > var43) {
									var43 = var44;
								}

								var30 = var86.field4954;
							}

							if (null != var82) {
								var31 = var82.method3954();
								if (var31 != null) {
									var35 = var31.field4959;
									var44 = var31.field4951;
									if (var44 > var43) {
										var43 = var44;
									}

									var39 = var31.field4954;
								}

								var32 = var82.method3944();
								if (var32 != null) {
									var36 = var32.field4959;
									var44 = var32.field4951;
									if (var44 > var43) {
										var43 = var44;
									}

									var40 = var32.field4954;
								}

								var33 = var82.method3936();
								if (var33 != null) {
									var37 = var33.field4959;
									var44 = var33.field4951;
									if (var44 > var43) {
										var43 = var44;
									}

									var41 = var33.field4954;
								}

								var34 = var82.method3963();
								if (null != var34) {
									var38 = var34.field4959;
									var44 = var34.field4951;
									if (var44 > var43) {
										var43 = var44;
									}

									var42 = var34.field4954;
								}
							}

							class376 var87 = var92.method3938();
							if (var87 == null) {
								var87 = class346.field4250;
							}

							class376 var45;
							if (var82 != null) {
								var45 = var82.method3938();
								if (null == var45) {
									var45 = class346.field4250;
								}
							} else {
								var45 = class346.field4250;
							}

							String var46 = null;
							String var47 = null;
							boolean var48 = false;
							int var49 = 0;
							var46 = var92.method3937(var0.field830[var79]);
							int var95 = var87.method6894(var46);
							if (null != var82) {
								var47 = var82.method3937(var0.field833[var79]);
								var49 = var45.method6894(var47);
							}

							int var50 = 0;
							int var51 = 0;
							if (var24 > 0) {
								if (null == var85 && null == var86) {
									var50 = 1;
								} else {
									var50 = 1 + var95 / var24;
								}
							}

							if (null != var82 && var36 > 0) {
								if (var33 == null && null == var34) {
									var51 = 1;
								} else {
									var51 = 1 + var49 / var36;
								}
							}

							int var52 = 0;
							int var53 = var52;
							if (var23 > 0) {
								var52 += var23;
							}

							var52 += 2;
							int var54 = var52;
							if (var25 > 0) {
								var52 += var25;
							}

							int var55 = var52;
							int var56 = var52;
							int var57;
							if (var24 > 0) {
								var57 = var50 * var24;
								var52 += var57;
								var56 += (var57 - var95) / 2;
							} else {
								var52 += var95;
							}

							var57 = var52;
							if (var26 > 0) {
								var52 += var26;
							}

							int var58 = 0;
							int var59 = 0;
							int var60 = 0;
							int var61 = 0;
							int var62 = 0;
							int var63;
							if (null != var82) {
								var52 += 2;
								var58 = var52;
								if (var35 > 0) {
									var52 += var35;
								}

								var52 += 2;
								var59 = var52;
								if (var37 > 0) {
									var52 += var37;
								}

								var60 = var52;
								var62 = var52;
								if (var36 > 0) {
									var63 = var36 * var51;
									var52 += var63;
									var62 += (var63 - var49) / 2;
								} else {
									var52 += var49;
								}

								var61 = var52;
								if (var38 > 0) {
									var52 += var38;
								}
							}

							var63 = var0.field831[var79] - client.field1645;
							int var64 = var92.field2345 - var63 * var92.field2345 / var92.field2327;
							int var65 = var63 * var92.field2350 / var92.field2327 + -var92.field2350;
							int var66 = client.field1809 + var2 - (var52 >> 1) + var64;
							int var67 = var3 + client.field1747 - 12 + var65;
							int var68 = var67;
							int var69 = var67 + var43;
							int var70 = var92.field2339 + var67 + 15;
							int var71 = var70 - var87.field4436;
							int var72 = var70 + var87.field4437;
							if (var71 < var67) {
								var68 = var71;
							}

							if (var72 > var69) {
								var69 = var72;
							}

							int var73 = 0;
							int var74;
							int var75;
							if (var82 != null) {
								var73 = var82.field2339 + var67 + 15;
								var74 = var73 - var45.field4436;
								var75 = var73 + var45.field4437;
								if (var74 < var68) {
									;
								}

								if (var75 > var69) {
									;
								}
							}

							var74 = 255;
							if (var92.field2344 >= 0) {
								var74 = (var63 << 8) / (var92.field2327 - var92.field2344);
							}

							if (var74 >= 0 && var74 < 255) {
								if (var83 != null) {
									var83.method8491(var66 + var53 - var27, var67, var74);
								}

								if (null != var85) {
									var85.method8491(var54 + var66 - var29, var67, var74);
								}

								if (var84 != null) {
									for (var75 = 0; var75 < var50; ++var75) {
										var84.method8491(var75 * var24 + (var66 + var55 - var28), var67, var74);
									}
								}

								if (var86 != null) {
									var86.method8491(var66 + var57 - var30, var67, var74);
								}

								var87.method6867(var46, var66 + var56, var70, var92.field2336, 0, var74);
								if (var82 != null) {
									if (null != var31) {
										var31.method8491(var66 + var58 - var39, var67, var74);
									}

									if (var33 != null) {
										var33.method8491(var59 + var66 - var41, var67, var74);
									}

									if (null != var32) {
										for (var75 = 0; var75 < var51; ++var75) {
											var32.method8491(var60 + var66 - var40 + var75 * var36, var67, var74);
										}
									}

									if (var34 != null) {
										var34.method8491(var61 + var66 - var42, var67, var74);
									}

									var45.method6867(var47, var62 + var66, var73, var82.field2336, 0, var74);
								}
							} else {
								if (null != var83) {
									var83.method8526(var66 + var53 - var27, var67);
								}

								if (var85 != null) {
									var85.method8526(var66 + var54 - var29, var67);
								}

								if (null != var84) {
									for (var75 = 0; var75 < var50; ++var75) {
										var84.method8526(var66 + var55 - var28 + var24 * var75, var67);
									}
								}

								if (null != var86) {
									var86.method8526(var66 + var57 - var30, var67);
								}

								var87.method6875(var46, var56 + var66, var70, var92.field2336 | -16777216, 0);
								if (var82 != null) {
									if (var31 != null) {
										var31.method8526(var66 + var58 - var39, var67);
									}

									if (var33 != null) {
										var33.method8526(var66 + var59 - var41, var67);
									}

									if (var32 != null) {
										for (var75 = 0; var75 < var51; ++var75) {
											var32.method8526(var75 * var36 + (var66 + var60 - var40), var67);
										}
									}

									if (null != var34) {
										var34.method8526(var61 + var66 - var42, var67);
									}

									var45.method6875(var47, var62 + var66, var73, var82.field2336 | -16777216, 0);
								}
							}
						}
					}
				}
			}

		}
	}
}
