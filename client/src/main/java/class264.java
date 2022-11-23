import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

@class308
public final class class264 {
	static class473[] field2999;
	static int field2998;
	static final HashMap field2994;

	static {
		field2994 = new HashMap();
		TimeZone var0;
		synchronized(field2994) {
			TimeZone var2 = (TimeZone)field2994.get("Europe/London");
			if (var2 == null) {
				var2 = TimeZone.getTimeZone("Europe/London");
				field2994.put("Europe/London", var2);
			}

			var0 = var2;
		}

		Calendar.getInstance(var0);
	}

	class264() throws Throwable {
		throw new Error();
	}

	static void method5168(int var0, int var1) {
		int[] var3 = new int[4];
		int[] var4 = new int[4];
		var3[0] = var0;
		var4[0] = var1;
		int var5 = 1;

		for (int var6 = 0; var6 < 4; ++var6) {
			if (class72.field585[var6] != var0) {
				var3[var5] = class72.field585[var6];
				var4[var5] = class72.field584[var6];
				++var5;
			}
		}

		class72.field585 = var3;
		class72.field584 = var4;
		class12.method91(class399.field4502, 0, class399.field4502.length - 1, class72.field585, class72.field584);
	}

	static final void method5166(class300[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		class481.method8653(var2, var3, var4, var5);
		class221.method4389();

		for (int var10 = 0; var10 < var0.length; ++var10) {
			class300 var11 = var0[var10];
			if (var11 != null && (var11.field3596 == var1 || var1 == -1412584499 && var11 == client.field1874)) {
				int var12;
				if (var8 == -1) {
					client.field1863[client.field1858] = var6 + var11.field3473;
					client.field1864[client.field1858] = var7 + var11.field3551;
					client.field1710[client.field1858] = var11.field3448;
					client.field1658[client.field1858] = var11.field3476;
					var12 = ++client.field1858 - 1;
				} else {
					var12 = var8;
				}

				var11.field3609 = var12;
				var11.field3610 = client.field1645;
				if (!var11.field3459 || !client.method343(var11)) {
					if (var11.field3464 > 0) {
						method5169(var11);
					}

					int var13 = var6 + var11.field3473;
					int var14 = var7 + var11.field3551;
					int var15 = var11.field3612;
					int var16;
					int var17;
					if (var11 == client.field1874) {
						if (var1 != -1412584499 && !var11.field3550) {
							class78.field682 = var0;
							class374.field4385 = var6;
							class47.field341 = var7;
							continue;
						}

						if (client.field1833 && client.field1827) {
							var16 = MouseManager.field284;
							var17 = MouseManager.field285;
							var16 -= client.field1824;
							var17 -= client.field1825;
							if (var16 < client.field1746) {
								var16 = client.field1746;
							}

							if (var16 + var11.field3448 > client.field1823.field3448 + client.field1746) {
								var16 = client.field1823.field3448 + client.field1746 - var11.field3448;
							}

							if (var17 < client.field1829) {
								var17 = client.field1829;
							}

							if (var11.field3476 + var17 > client.field1823.field3476 + client.field1829) {
								var17 = client.field1823.field3476 + client.field1829 - var11.field3476;
							}

							var13 = var16;
							var14 = var17;
						}

						if (!var11.field3550) {
							var15 = 128;
						}
					}

					int var18;
					int var19;
					int var21;
					int var22;
					int var23;
					int var31;
					if (var11.field3462 == 2) {
						var16 = var2;
						var17 = var3;
						var18 = var4;
						var19 = var5;
					} else if (var11.field3462 == 9) {
						var31 = var13;
						var21 = var14;
						var22 = var11.field3448 + var13;
						var23 = var11.field3476 + var14;
						if (var22 < var13) {
							var31 = var22;
							var22 = var13;
						}

						if (var23 < var14) {
							var21 = var23;
							var23 = var14;
						}

						++var22;
						++var23;
						var16 = var31 > var2 ? var31 : var2;
						var17 = var21 > var3 ? var21 : var3;
						var18 = var22 < var4 ? var22 : var4;
						var19 = var23 < var5 ? var23 : var5;
					} else {
						var31 = var13 + var11.field3448;
						var21 = var11.field3476 + var14;
						var16 = var13 > var2 ? var13 : var2;
						var17 = var14 > var3 ? var14 : var3;
						var18 = var31 < var4 ? var31 : var4;
						var19 = var21 < var5 ? var21 : var5;
					}

					if (!var11.field3459 || var16 < var18 && var17 < var19) {
						if (var11.field3464 != 0) {
							if (var11.field3464 == 1336) {
								if (class413.clientPreferences.method1711()) {
									var14 += 15;
									class353.field4289.method6868("Fps:" + class31.field174, var11.field3448 + var13, var14, 16776960, -1);
									var14 += 15;
									Runtime var41 = Runtime.getRuntime();
									var21 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
									var22 = 16776960;
									if (var21 > 327680 && !client.isLowDetail) {
										var22 = 16711680;
									}

									class353.field4289.method6868("Mem:" + var21 + "k", var13 + var11.field3448, var14, var22, -1);
									var14 += 15;
								}
								continue;
							}

							if (1337 == var11.field3464) {
								client.field1798 = var13;
								client.field1799 = var14;
								class9.method63(var13, var14, var11.field3448, var11.field3476);
								client.field1860[var11.field3609] = true;
								class481.method8653(var2, var3, var4, var5);
								continue;
							}

							if (var11.field3464 == 1338) {
								class73.method1487(var11, var13, var14, var12);
								class481.method8653(var2, var3, var4, var5);
								continue;
							}

							if (1339 == var11.field3464) {
								class125.method2358(var11, var13, var14, var12);
								class481.method8653(var2, var3, var4, var5);
								continue;
							}

							if (var11.field3464 == 1400) {
								class4.field10.method7663(var13, var14, var11.field3448, var11.field3476, client.field1645);
							}

							if (1401 == var11.field3464) {
								class4.field10.method7596(var13, var14, var11.field3448, var11.field3476);
							}

							if (1402 == var11.field3464) {
								class77.field670.method1807(var13, client.field1645);
							}
						}

						if (var11.field3462 == 0) {
							if (!var11.field3459 && client.method343(var11) && var11 != class219.field2616) {
								continue;
							}

							if (!var11.field3459) {
								if (var11.field3482 > var11.field3492 - var11.field3476) {
									var11.field3482 = var11.field3492 - var11.field3476;
								}

								if (var11.field3482 < 0) {
									var11.field3482 = 0;
								}
							}

							method5166(var0, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
							if (var11.field3602 != null) {
								method5166(var11.field3602, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
							}

							InterfaceParent var20 = (InterfaceParent)client.parentInterfaces.method7855((long)var11.field3517);
							if (null != var20) {
								class41.method763(var20.field796, var16, var17, var18, var19, var13, var14, var12);
							}

							class481.method8653(var2, var3, var4, var5);
							class221.method4389();
						} else if (var11.field3462 == 11) {
							if (client.method343(var11) && var11 != class219.field2616) {
								continue;
							}

							if (var11.field3602 != null) {
								method5166(var11.field3602, var11.field3517, var16, var17, var18, var19, var13 - var11.field3481, var14 - var11.field3482, var12);
							}

							class481.method8653(var2, var3, var4, var5);
							class221.method4389();
						}

						if (client.isResizable || client.field1800[var12] || client.field1867 > 1) {
							if (var11.field3462 == 0 && !var11.field3459 && var11.field3492 > var11.field3476) {
								client.method1783(var11.field3448 + var13, var14, var11.field3482, var11.field3476, var11.field3492);
							}

							if (var11.field3462 != 1) {
								int var24;
								int var25;
								int var26;
								int var27;
								if (2 == var11.field3462) {
									var31 = 0;

									for (var21 = 0; var21 < var11.field3472; ++var21) {
										for (var22 = 0; var22 < var11.field3486; ++var22) {
											var23 = var22 * (var11.field3528 + 32) + var13;
											var24 = var14 + (var11.field3529 + 32) * var21;
											if (var31 < 20) {
												var23 += var11.field3530[var31];
												var24 += var11.field3531[var31];
											}

											if (var11.field3461[var31] <= 0) {
												if (null != var11.field3526 && var31 < 20) {
													class473 var45 = var11.method5857(var31);
													if (null != var45) {
														var45.method8526(var23, var24);
													} else if (class300.field3458) {
														class136.method2438(var11);
													}
												}
											} else {
												boolean var42 = false;
												boolean var43 = false;
												var27 = var11.field3461[var31] - 1;
												if (var23 + 32 > var2 && var23 < var4 && var24 + 32 > var3 && var24 < var5 || var11 == class183.field1943 && var31 == client.field1737) {
													class473 var28;
													if (client.isItemSelected == 1 && class6.field23 == var31 && var11.field3517 == class213.field2493) {
														var28 = class71.method1436(var27, var11.field3456[var31], 2, 0, 2, false);
													} else {
														var28 = class71.method1436(var27, var11.field3456[var31], 1, 3153952, 2, false);
													}

													if (null != var28) {
														if (class183.field1943 == var11 && var31 == client.field1737) {
															var25 = MouseManager.field284 - client.field1638;
															var26 = MouseManager.field285 - client.field1757;
															if (var25 < 5 && var25 > -5) {
																var25 = 0;
															}

															if (var26 < 5 && var26 > -5) {
																var26 = 0;
															}

															if (client.field1786 < 5) {
																var25 = 0;
																var26 = 0;
															}

															var28.method8491(var23 + var25, var24 + var26, 128);
															if (var1 != -1) {
																class300 var29 = var0[var1 & 65535];
																int var30;
																if (var26 + var24 < class481.field4995 && var29.field3482 > 0) {
																	var30 = (class481.field4995 - var24 - var26) * client.field1701 / 3;
																	if (var30 > client.field1701 * 10) {
																		var30 = client.field1701 * 10;
																	}

																	if (var30 > var29.field3482) {
																		var30 = var29.field3482;
																	}

																	var29.field3482 -= var30;
																	client.field1757 += var30;
																	class136.method2438(var29);
																}

																if (var26 + var24 + 32 > class481.field4998 && var29.field3482 < var29.field3492 - var29.field3476) {
																	var30 = client.field1701 * (var24 + var26 + 32 - class481.field4998) / 3;
																	if (var30 > client.field1701 * 10) {
																		var30 = client.field1701 * 10;
																	}

																	if (var30 > var29.field3492 - var29.field3476 - var29.field3482) {
																		var30 = var29.field3492 - var29.field3476 - var29.field3482;
																	}

																	var29.field3482 += var30;
																	client.field1757 -= var30;
																	class136.method2438(var29);
																}
															}
														} else if (class132.field1247 == var11 && var31 == client.field1888) {
															var28.method8491(var23, var24, 128);
														} else {
															var28.method8526(var23, var24);
														}
													} else {
														class136.method2438(var11);
													}
												}
											}

											++var31;
										}
									}
								} else if (var11.field3462 == 3) {
									if (MouseManager.method796(var11)) {
										var31 = var11.field3495;
										if (var11 == class219.field2616 && var11.field3567 != 0) {
											var31 = var11.field3567;
										}
									} else {
										var31 = var11.field3485;
										if (class219.field2616 == var11 && var11.field3487 != 0) {
											var31 = var11.field3487;
										}
									}

									if (var11.field3489) {
										switch(var11.field3490.field4930) {
										case 1:
											class481.method8686(var13, var14, var11.field3448, var11.field3476, var11.field3485, var11.field3495);
											break;
										case 2:
											class481.method8685(var13, var14, var11.field3448, var11.field3476, var11.field3485, var11.field3495, 255 - (var11.field3612 & 255), 255 - (var11.field3588 & 255));
											break;
										default:
											if (var15 == 0) {
												class481.method8660(var13, var14, var11.field3448, var11.field3476, var31);
											} else {
												class481.method8659(var13, var14, var11.field3448, var11.field3476, var31, 256 - (var15 & 255));
											}
										}
									} else if (var15 == 0) {
										class481.method8664(var13, var14, var11.field3448, var11.field3476, var31);
									} else {
										class481.method8668(var13, var14, var11.field3448, var11.field3476, var31, 256 - (var15 & 255));
									}
								} else {
									class376 var38;
									if (var11.field3462 == 4) {
										var38 = var11.method5856();
										if (null == var38) {
											if (class300.field3458) {
												class136.method2438(var11);
											}
										} else {
											String var48 = var11.field3522;
											if (MouseManager.method796(var11)) {
												var21 = var11.field3495;
												if (class219.field2616 == var11 && 0 != var11.field3567) {
													var21 = var11.field3567;
												}

												if (var11.field3523.length() > 0) {
													var48 = var11.field3523;
												}
											} else {
												var21 = var11.field3485;
												if (var11 == class219.field2616 && 0 != var11.field3487) {
													var21 = var11.field3487;
												}
											}

											if (var11.field3459 && -1 != var11.field3445) {
												class198 var49 = class278.method5388(var11.field3445);
												var48 = var49.field2131;
												if (var48 == null) {
													var48 = class338.field3899;
												}

												if ((1 == var49.field2142 || 1 != var11.field3599) && var11.field3599 != -1) {
													var48 = class96.method4510(16748608) + var48 + class96.field965 + " " + 'x' + class34.method650(var11.field3599);
												}
											}

											if (client.field1641 == var11) {
												var48 = class338.field4062;
												var21 = var11.field3485;
											}

											if (!var11.field3459) {
												var48 = class11.method76(var48, var11);
											}

											var38.method6870(var48, var13, var14, var11.field3448, var11.field3476, var21, var11.field3488 ? 0 : -1, var11.field3525, var11.field3572, var11.field3524);
										}
									} else if (var11.field3462 == 5) {
										class473 var40;
										if (!var11.field3459) {
											var40 = var11.method5852(MouseManager.method796(var11), class28.urlRequester);
											if (null != var40) {
												var40.method8526(var13, var14);
											} else if (class300.field3458) {
												class136.method2438(var11);
											}
										} else {
											if (-1 != var11.field3445) {
												var40 = class71.method1436(var11.field3445, var11.field3599, var11.field3500, var11.field3501, var11.field3520, false);
											} else {
												var40 = var11.method5852(false, class28.urlRequester);
											}

											if (var40 == null) {
												if (class300.field3458) {
													class136.method2438(var11);
												}
											} else {
												var21 = var40.field4956;
												var22 = var40.field4957;
												if (!var11.field3499) {
													var23 = var11.field3448 * 4096 / var21;
													if (var11.field3498 != 0) {
														var40.method8504(var11.field3448 / 2 + var13, var11.field3476 / 2 + var14, var11.field3498, var23);
													} else if (var15 != 0) {
														var40.method8493(var13, var14, var11.field3448, var11.field3476, 256 - (var15 & 255));
													} else if (var11.field3448 == var21 && var11.field3476 == var22) {
														var40.method8526(var13, var14);
													} else {
														var40.method8487(var13, var14, var11.field3448, var11.field3476);
													}
												} else {
													class481.method8724(var13, var14, var11.field3448 + var13, var14 + var11.field3476);
													var23 = (var21 - 1 + var11.field3448) / var21;
													var24 = (var22 - 1 + var11.field3476) / var22;

													for (var25 = 0; var25 < var23; ++var25) {
														for (var26 = 0; var26 < var24; ++var26) {
															if (var11.field3498 != 0) {
																var40.method8504(var25 * var21 + var13 + var21 / 2, var22 / 2 + var14 + var26 * var22, var11.field3498, 4096);
															} else if (var15 != 0) {
																var40.method8491(var13 + var21 * var25, var22 * var26 + var14, 256 - (var15 & 255));
															} else {
																var40.method8526(var25 * var21 + var13, var14 + var26 * var22);
															}
														}
													}

													class481.method8653(var2, var3, var4, var5);
												}
											}
										}
									} else {
										class198 var35;
										if (6 == var11.field3462) {
											boolean var46 = MouseManager.method796(var11);
											if (var46) {
												var21 = var11.field3509;
											} else {
												var21 = var11.field3575;
											}

											class209 var44 = null;
											var23 = 0;
											if (-1 != var11.field3445) {
												var35 = class278.method5388(var11.field3445);
												if (var35 != null) {
													var35 = var35.method3651(var11.field3599);
													var44 = var35.method3648(1);
													if (null != var44) {
														var44.method4067();
														var23 = var44.field2489 / 2;
													} else {
														class136.method2438(var11);
													}
												}
											} else if (5 == var11.field3504) {
												if (0 == var11.field3505) {
													var44 = client.playerAppearance.method6003((class189)null, -1, (class189)null, -1);
												} else {
													var44 = class291.localPlayer.method4112();
												}
											} else if (var21 == -1) {
												var44 = var11.method5858((class189)null, -1, var46, class291.localPlayer.appearance);
												if (null == var44 && class300.field3458) {
													class136.method2438(var11);
												}
											} else {
												class189 var50 = class160.method2660(var21);
												var44 = var11.method5858(var50, var11.field3471, var46, class291.localPlayer.appearance);
												if (var44 == null && class300.field3458) {
													class136.method2438(var11);
												}
											}

											class221.method4432(var13 + var11.field3448 / 2, var11.field3476 / 2 + var14);
											var24 = var11.field3562 * class221.field2644[var11.field3601] >> 16;
											var25 = var11.field3562 * class221.field2645[var11.field3601] >> 16;
											if (null != var44) {
												if (!var11.field3459) {
													var44.method4074(0, var11.field3513, 0, var11.field3601, 0, var24, var25);
												} else {
													var44.method4067();
													if (var11.field3534) {
														var44.method3996(0, var11.field3513, var11.field3514, var11.field3601, var11.field3510, var23 + var24 + var11.field3548, var25 + var11.field3548, var11.field3562);
													} else {
														var44.method4074(0, var11.field3513, var11.field3514, var11.field3601, var11.field3510, var11.field3548 + var24 + var23, var25 + var11.field3548);
													}
												}
											}

											class221.method4391();
										} else {
											if (7 == var11.field3462) {
												var38 = var11.method5856();
												if (null == var38) {
													if (class300.field3458) {
														class136.method2438(var11);
													}
													continue;
												}

												var21 = 0;

												for (var22 = 0; var22 < var11.field3472; ++var22) {
													for (var23 = 0; var23 < var11.field3486; ++var23) {
														if (var11.field3461[var21] > 0) {
															var35 = class278.method5388(var11.field3461[var21] - 1);
															String var32;
															if (1 != var35.field2142 && var11.field3456[var21] == 1) {
																var32 = class96.method4510(16748608) + var35.field2131 + class96.field965;
															} else {
																var32 = class96.method4510(16748608) + var35.field2131 + class96.field965 + " " + 'x' + class34.method650(var11.field3456[var21]);
															}

															var26 = var23 * (115 + var11.field3528) + var13;
															var27 = var14 + (var11.field3529 + 12) * var22;
															if (var11.field3525 == 0) {
																var38.method6875(var32, var26, var27, var11.field3485, var11.field3488 ? 0 : -1);
															} else if (1 == var11.field3525) {
																var38.method6955(var32, var11.field3448 / 2 + var26, var27, var11.field3485, var11.field3488 ? 0 : -1);
															} else {
																var38.method6868(var32, var11.field3448 + var26 - 1, var27, var11.field3485, var11.field3488 ? 0 : -1);
															}
														}

														++var21;
													}
												}
											}

											class376 var33;
											if (8 == var11.field3462 && var11 == class219.field2617 && client.field1929 == client.field1670) {
												var31 = 0;
												var21 = 0;
												var33 = class353.field4289;
												String var34 = var11.field3522;

												String var47;
												for (var34 = class11.method76(var34, var11); var34.length() > 0; var21 += var33.field4435 + 1) {
													var25 = var34.indexOf(class96.field966);
													if (var25 != -1) {
														var47 = var34.substring(0, var25);
														var34 = var34.substring(var25 + 4);
													} else {
														var47 = var34;
														var34 = "";
													}

													var26 = var33.method6894(var47);
													if (var26 > var31) {
														var31 = var26;
													}
												}

												var31 += 6;
												var21 += 7;
												var25 = var13 + var11.field3448 - 5 - var31;
												var26 = var11.field3476 + var14 + 5;
												if (var25 < var13 + 5) {
													var25 = var13 + 5;
												}

												if (var25 + var31 > var4) {
													var25 = var4 - var31;
												}

												if (var21 + var26 > var5) {
													var26 = var5 - var21;
												}

												class481.method8660(var25, var26, var31, var21, 16777120);
												class481.method8664(var25, var26, var31, var21, 0);
												var34 = var11.field3522;
												var27 = 2 + var33.field4435 + var26;

												for (var34 = class11.method76(var34, var11); var34.length() > 0; var27 += var33.field4435 + 1) {
													int var36 = var34.indexOf(class96.field966);
													if (var36 != -1) {
														var47 = var34.substring(0, var36);
														var34 = var34.substring(var36 + 4);
													} else {
														var47 = var34;
														var34 = "";
													}

													var33.method6875(var47, var25 + 3, var27, 0, -1);
												}
											}

											if (9 == var11.field3462) {
												if (var11.field3494) {
													var31 = var13;
													var21 = var14 + var11.field3476;
													var22 = var13 + var11.field3448;
													var23 = var14;
												} else {
													var31 = var13;
													var21 = var14;
													var22 = var11.field3448 + var13;
													var23 = var11.field3476 + var14;
												}

												if (var11.field3493 == 1) {
													class481.method8670(var31, var21, var22, var23, var11.field3485);
												} else {
													class380.method6806(var31, var21, var22, var23, var11.field3485, var11.field3493);
												}
											} else if (var11.field3462 == 12) {
												class297 var39 = var11.method5877();
												class302 var37 = var11.method5954();
												if (var39 != null && var37 != null && var39.method5699()) {
													var33 = var11.method5856();
													if (var33 != null) {
														client.field1852.method8427(var13, var14, var11.field3448, var11.field3476, var39.method5617(), var39.method5685(), 0, 0, var39.method5614(), var39.method5691(), var39.method5613());
														var23 = var11.field3488 ? var11.field3501 : -1;
														if (!var39.method5593() && var39.method5755().method7031()) {
															client.field1852.method8428(var37.field3618, var23, var37.field3617, var37.field3619);
															client.field1852.method8426(var39.method5609(), var33);
														} else {
															client.field1852.method8428(var11.field3485, var23, var37.field3617, var37.field3619);
															client.field1852.method8426(var39.method5755(), var33);
														}

														class481.method8653(var2, var3, var4, var5);
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

	static final void method5169(class300 var0) {
		int var2 = var0.field3464;
		if (var2 == 324) {
			if (-1 == client.field1682) {
				client.field1682 = var0.field3560;
				client.field1686 = var0.field3496;
			}

			if (client.playerAppearance.field3639 == 1) {
				var0.field3560 = client.field1682;
			} else {
				var0.field3560 = client.field1686;
			}

		} else if (var2 == 325) {
			if (-1 == client.field1682) {
				client.field1682 = var0.field3560;
				client.field1686 = var0.field3496;
			}

			if (1 == client.playerAppearance.field3639) {
				var0.field3560 = client.field1686;
			} else {
				var0.field3560 = client.field1682;
			}

		} else if (var2 == 327) {
			var0.field3601 = 150;
			var0.field3513 = (int)(Math.sin((double)client.field1645 / 40.0D) * 256.0D) & 2047;
			var0.field3504 = 5;
			var0.field3505 = 0;
		} else if (var2 == 328) {
			var0.field3601 = 150;
			var0.field3513 = (int)(Math.sin((double)client.field1645 / 40.0D) * 256.0D) & 2047;
			var0.field3504 = 5;
			var0.field3505 = 1;
		}
	}
}
