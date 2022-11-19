import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class class442 {
	public static final class442 field4769;
	public static final class442 field4770;
	public static final class442 field4771;
	public static final class442 field4773;
	public static final class442 field4779;
	public static final class442 field4780;
	static class147 field4776;
	String field4774;

	static {
		field4779 = new class442("p11_full");
		field4769 = new class442("p12_full");
		field4780 = new class442("b12_full");
		field4771 = new class442("verdana_11pt_regular");
		field4770 = new class442("verdana_13pt_regular");
		field4773 = new class442("verdana_15pt_regular");
	}

	public static class442[] method7918() {
		return new class442[]{field4779, field4770, field4773, field4780, field4769, field4771};
	}

	class442(String var1) {
		this.field4774 = var1;
	}

	static void method7923(class31 var0, class376 var1) {
		int var5;
		int var6;
		int var35;
		int var36;
		if (class75.field643) {
			class205 var33 = client.field1876;
			class205 var4 = var33;

			while (true) {
				if (!var4.method3911()) {
					if (class42.field277 != 1 && (class95.field944 || class42.field277 != 4)) {
						break;
					}

					var5 = 280 + class75.field618;
					if (class42.field283 >= var5 && class42.field283 <= var5 + 14 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(0, 0);
						break;
					}

					if (class42.field283 >= var5 + 15 && class42.field283 <= var5 + 80 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(0, 1);
						break;
					}

					var6 = class75.field618 + 390;
					if (class42.field283 >= var6 && class42.field283 <= var6 + 14 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(1, 0);
						break;
					}

					if (class42.field283 >= var6 + 15 && class42.field283 <= var6 + 80 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(1, 1);
						break;
					}

					var35 = class75.field618 + 500;
					if (class42.field283 >= var35 && class42.field283 <= var35 + 14 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(2, 0);
						break;
					}

					if (class42.field283 >= var35 + 15 && class42.field283 <= var35 + 80 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(2, 1);
						break;
					}

					var36 = class75.field618 + 610;
					if (class42.field283 >= var36 && class42.field283 <= var36 + 14 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(3, 0);
						break;
					}

					if (class42.field283 >= var36 + 15 && class42.field283 <= var36 + 80 && class42.field293 >= 4 && class42.field293 <= 18) {
						class264.method5168(3, 1);
						break;
					}

					if (class42.field283 >= class75.field618 + 708 && class42.field293 >= 4 && class42.field283 <= 50 + class75.field618 + 708 && class42.field293 <= 20) {
						class75.method199();
						break;
					}

					if (class75.field626 != -1) {
						class72 var37 = class399.field4502[class75.field626];
						client.method3066(var37);
						class75.method199();
					} else {
						if (class75.field645 > 0 && null != class227.field2723 && class42.field283 >= 0 && class42.field283 <= class227.field2723.field5017 && class42.field293 >= class12.field57 / 2 - 50 && class42.field293 <= class12.field57 / 2 + 50) {
							--class75.field645;
						}

						if (class75.field645 < class75.field616 && class7.field24 != null && class42.field283 >= class31.field193 - class7.field24.field5017 - 5 && class42.field283 <= class31.field193 && class42.field293 >= class12.field57 / 2 - 50 && class42.field293 <= class12.field57 / 2 + 50) {
							++class75.field645;
						}
					}
					break;
				}

				if (var4.field2317 == 13) {
					class75.method199();
					break;
				}

				if (var4.field2317 == 96) {
					if (class75.field645 > 0 && class227.field2723 != null) {
						--class75.field645;
					}
				} else if (97 == var4.field2317 && class75.field645 < class75.field616 && class7.field24 != null) {
					++class75.field645;
				}
			}

		} else {
			if ((class42.field277 == 1 || !class95.field944 && 4 == class42.field277) && class42.field283 >= 765 + class75.field618 - 50 && class42.field293 >= 453) {
				class413.field4575.method1707(!class413.field4575.method1708());
				if (!class413.field4575.method1708()) {
					class336 var3 = class43.field311;
					int var20 = var3.method6124("scape main");
					var5 = var3.method6170(var20, "");
					class279.method332(var3, var20, var5, 255, false);
				} else {
					class279.field3201.method5365();
					class279.field3202 = 1;
					class7.field29 = null;
				}
			}

			if (5 != client.field1766) {
				if (-1L == class75.field647) {
					class75.field647 = class272.method2046() + 1000L;
				}

				long var21 = class272.method2046();
				boolean var34;
				if (client.field1930 != null && client.field1910 < client.field1930.size()) {
					while (true) {
						if (client.field1910 >= client.field1930.size()) {
							var34 = true;
							break;
						}

						class97 var23 = (class97)client.field1930.get(client.field1910);
						if (!var23.method1962()) {
							var34 = false;
							break;
						}

						++client.field1910;
					}
				} else {
					var34 = true;
				}

				if (var34 && -1L == class75.field639) {
					class75.field639 = var21;
					if (class75.field639 > class75.field647) {
						class75.field647 = class75.field639;
					}
				}

				if (10 == client.field1766 || client.field1766 == 11) {
					if (class353.field4303 == class94.field940) {
						if (1 == class42.field277 || !class95.field944 && class42.field277 == 4) {
							var6 = 5 + class75.field618;
							short var7 = 463;
							byte var8 = 100;
							byte var24 = 35;
							if (class42.field283 >= var6 && class42.field283 <= var6 + var8 && class42.field293 >= var7 && class42.field293 <= var24 + var7) {
								if (class328.method6247()) {
									class75.field643 = true;
									class75.field645 = 0;
									class75.field616 = 0;
								}

								return;
							}
						}

						if (null != class96.field962 && class328.method6247()) {
							class75.field643 = true;
							class75.field645 = 0;
							class75.field616 = 0;
						}
					}

					var6 = class42.field277;
					var35 = class42.field283;
					var36 = class42.field293;
					if (var6 == 0) {
						var35 = class42.field284;
						var36 = class42.field285;
					}

					if (!class95.field944 && var6 == 4) {
						var6 = 1;
					}

					class205 var9 = client.field1876;
					class205 var10 = var9;
					int var39;
					short var40;
					if (class75.field619 == 0) {
						boolean var44 = false;

						while (var10.method3911()) {
							if (var10.field2317 == 84) {
								var44 = true;
							}
						}

						var39 = class11.field47 - 80;
						var40 = 291;
						if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20) {
							class115.method2229(class140.method2473("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var39 = class11.field47 + 80;
						if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20 || var44) {
							if (0 != (client.field1633 & 33554432)) {
								class75.field648 = "";
								class75.field624 = class338.field4128;
								class75.field630 = class338.field4129;
								class75.field631 = class338.field4130;
								class74.method1490(1);
								class279.method5396();
							} else if ((client.field1633 & 4) != 0) {
								if (0 != (client.field1633 & 1024)) {
									class75.field624 = class338.field4125;
									class75.field630 = class338.field4203;
									class75.field631 = class338.field4033;
								} else {
									class75.field624 = class338.field4039;
									class75.field630 = class338.field4120;
									class75.field631 = class338.field4121;
								}

								class75.field648 = class338.field4118;
								class74.method1490(1);
								class279.method5396();
							} else if (0 != (client.field1633 & 1024)) {
								class75.field624 = class338.field4107;
								class75.field630 = class338.field3922;
								class75.field631 = class338.field4124;
								class75.field648 = class338.field4118;
								class74.method1490(1);
								class279.method5396();
							} else {
								class367.method6730(false);
							}
						}
					} else {
						int var11;
						short var12;
						if (class75.field619 == 1) {
							while (true) {
								if (!var10.method3911()) {
									var11 = class11.field47 - 80;
									var12 = 321;
									if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
										class367.method6730(false);
									}

									var11 = class11.field47 + 80;
									if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
										class74.method1490(0);
									}
									break;
								}

								if (84 == var10.field2317) {
									class367.method6730(false);
								} else if (var10.field2317 == 13) {
									class74.method1490(0);
								}
							}
						} else {
							short var38;
							if (2 == class75.field619) {
								var38 = 201;
								var11 = var38 + 52;
								if (var6 == 1 && var36 >= var11 - 12 && var36 < var11 + 2) {
									class75.field640 = 0;
								}

								var11 += 15;
								if (var6 == 1 && var36 >= var11 - 12 && var36 < var11 + 2) {
									class75.field640 = 1;
								}

								var11 += 15;
								var38 = 361;
								if (null != class444.field4785) {
									var39 = class444.field4785.field4531 / 2;
									if (var6 == 1 && var35 >= class444.field4785.field4529 - var39 && var35 <= var39 + class444.field4785.field4529 && var36 >= var38 - 15 && var36 < var38) {
										switch(class75.field646) {
										case 1:
											class75.method5452(class338.field4167, class338.field4010, class338.field4169);
											class74.method1490(5);
											return;
										case 2:
											class115.method2229("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var39 = class11.field47 - 80;
								var40 = 321;
								if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20) {
									class75.field633 = class75.field633.trim();
									if (class75.field633.length() == 0) {
										class75.method5452(class338.field3973, class338.field3965, class338.field3981);
										return;
									}

									if (class75.field650.length() == 0) {
										class75.method5452(class338.field4014, class338.field4015, class338.field3988);
										return;
									}

									class75.method5452(class338.field4074, class338.field4134, class338.field4135);
									class49.method996(false);
									class9.method64(20);
									return;
								}

								var39 = 180 + class75.field627 + 80;
								if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20) {
									class74.method1490(0);
									class75.field633 = "";
									class75.field650 = "";
									class340.field4220 = 0;
									class349.field4269 = "";
									class75.field621 = true;
								}

								var39 = class11.field47 + -117;
								var40 = 277;
								class75.field637 = var35 >= var39 && var35 < class346.field4251 + var39 && var36 >= var40 && var36 < class75.field636 + var40;
								if (var6 == 1 && class75.field637) {
									client.field1891 = !client.field1891;
									if (!client.field1891 && class413.field4575.method1722() != null) {
										class413.field4575.method1710((String)null);
									}
								}

								var39 = 24 + class11.field47;
								var40 = 277;
								class75.field638 = var35 >= var39 && var35 < class346.field4251 + var39 && var36 >= var40 && var36 < class75.field636 + var40;
								if (var6 == 1 && class75.field638) {
									class413.field4575.method1755(!class413.field4575.method1706());
									if (!class413.field4575.method1706()) {
										class75.field633 = "";
										class413.field4575.method1710((String)null);
										class279.method5396();
									}
								}

								while (true) {
									Transferable var42;
									int var43;
									do {
										while (true) {
											label1372:
											do {
												while (true) {
													while (var10.method3911()) {
														if (13 != var10.field2317) {
															if (0 != class75.field640) {
																continue label1372;
															}

															class178.method2827(var10.field2321);
															if (var10.field2317 == 85 && class75.field633.length() > 0) {
																class75.field633 = class75.field633.substring(0, class75.field633.length() - 1);
															}

															if (84 == var10.field2317 || var10.field2317 == 80) {
																class75.field640 = 1;
															}

															if (class205.method3926(var10.field2321) && class75.field633.length() < 320) {
																class75.field633 = class75.field633 + var10.field2321;
															}
														} else {
															class74.method1490(0);
															class75.field633 = "";
															class75.field650 = "";
															class340.field4220 = 0;
															class349.field4269 = "";
															class75.field621 = true;
														}
													}

													return;
												}
											} while(1 != class75.field640);

											if (var10.field2317 == 85 && class75.field650.length() > 0) {
												class75.field650 = class75.field650.substring(0, class75.field650.length() - 1);
											} else if (84 == var10.field2317 || 80 == var10.field2317) {
												class75.field640 = 0;
												if (var10.field2317 == 84) {
													class75.field633 = class75.field633.trim();
													if (class75.field633.length() == 0) {
														class75.method5452(class338.field3973, class338.field3965, class338.field3981);
														return;
													}

													if (class75.field650.length() == 0) {
														class75.method5452(class338.field4014, class338.field4015, class338.field3988);
														return;
													}

													class75.method5452(class338.field4074, class338.field4134, class338.field4135);
													class49.method996(false);
													class9.method64(20);
													return;
												}
											}

											if ((var10.method3895(82) || var10.method3895(87)) && 67 == var10.field2317) {
												Clipboard var41 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var42 = var41.getContents(class133.field1257);
												var43 = 20 - class75.field650.length();
												break;
											}

											if (class279.method5389(var10.field2321) && class205.method3926(var10.field2321) && class75.field650.length() < 20) {
												class75.field650 = class75.field650 + var10.field2321;
											}
										}
									} while(var43 <= 0);

									try {
										String var17 = (String)var42.getTransferData(DataFlavor.stringFlavor);
										int var18 = Math.min(var43, var17.length());

										for (int var19 = 0; var19 < var18; ++var19) {
											if (!class279.method5389(var17.charAt(var19)) || !class205.method3926(var17.charAt(var19))) {
												class74.method1490(3);
												return;
											}
										}

										class75.field650 = class75.field650 + var17.substring(0, var18);
									} catch (UnsupportedFlavorException var31) {
									} catch (IOException var32) {
									}
								}
							} else if (3 == class75.field619) {
								var11 = 180 + class75.field627;
								var12 = 276;
								if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
									class337.method6314(false);
								}

								var11 = class75.field627 + 180;
								var12 = 326;
								if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
									class75.method5452(class338.field4167, class338.field4010, class338.field4169);
									class74.method1490(5);
									return;
								}
							} else {
								int var25;
								if (class75.field619 == 4) {
									var11 = 180 + class75.field627 - 80;
									var12 = 321;
									if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
										class349.field4269.trim();
										if (class349.field4269.length() != 6) {
											class75.method5452(class338.field3987, class338.field3931, class338.field3939);
											return;
										}

										class340.field4220 = Integer.parseInt(class349.field4269);
										class349.field4269 = "";
										class49.method996(true);
										class75.method5452(class338.field4074, class338.field4134, class338.field4135);
										class9.method64(20);
										return;
									}

									if (var6 == 1 && var35 >= 180 + class75.field627 - 9 && var35 <= 130 + 180 + class75.field627 && var36 >= 263 && var36 <= 296) {
										class75.field621 = !class75.field621;
									}

									if (var6 == 1 && var35 >= class75.field627 + 180 - 34 && var35 <= 34 + 180 + class75.field627 && var36 >= 351 && var36 <= 363) {
										class115.method2229(class140.method2473("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
									}

									var11 = 80 + class75.field627 + 180;
									if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
										class74.method1490(0);
										class75.field633 = "";
										class75.field650 = "";
										class340.field4220 = 0;
										class349.field4269 = "";
									}

									while (var10.method3911()) {
										boolean var13 = false;

										for (var25 = 0; var25 < class75.field642.length(); ++var25) {
											if (var10.field2321 == class75.field642.charAt(var25)) {
												var13 = true;
												break;
											}
										}

										if (13 == var10.field2317) {
											class74.method1490(0);
											class75.field633 = "";
											class75.field650 = "";
											class340.field4220 = 0;
											class349.field4269 = "";
										} else {
											if (85 == var10.field2317 && class349.field4269.length() > 0) {
												class349.field4269 = class349.field4269.substring(0, class349.field4269.length() - 1);
											}

											if (var10.field2317 == 84) {
												class349.field4269.trim();
												if (class349.field4269.length() != 6) {
													class75.method5452(class338.field3987, class338.field3931, class338.field3939);
													return;
												}

												class340.field4220 = Integer.parseInt(class349.field4269);
												class349.field4269 = "";
												class49.method996(true);
												class75.method5452(class338.field4074, class338.field4134, class338.field4135);
												class9.method64(20);
												return;
											}

											if (var13 && class349.field4269.length() < 6) {
												class349.field4269 = class349.field4269 + var10.field2321;
											}
										}
									}
								} else {
									int var26;
									if (class75.field619 == 5) {
										var11 = 180 + class75.field627 - 80;
										var12 = 321;
										if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
											class352.method6544();
											return;
										}

										var11 = 180 + class75.field627 + 80;
										if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
											class367.method6730(true);
										}

										var40 = 361;
										if (null != class256.field2949) {
											var25 = class256.field2949.field4531 / 2;
											if (var6 == 1 && var35 >= class256.field2949.field4529 - var25 && var35 <= class256.field2949.field4529 + var25 && var36 >= var40 - 15 && var36 < var40) {
												class115.method2229(class140.method2473("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
											}
										}

										while (var10.method3911()) {
											boolean var45 = false;

											for (var26 = 0; var26 < class75.field641.length(); ++var26) {
												if (var10.field2321 == class75.field641.charAt(var26)) {
													var45 = true;
													break;
												}
											}

											if (var10.field2317 == 13) {
												class367.method6730(true);
											} else {
												if (85 == var10.field2317 && class75.field633.length() > 0) {
													class75.field633 = class75.field633.substring(0, class75.field633.length() - 1);
												}

												if (var10.field2317 == 84) {
													class352.method6544();
													return;
												}

												if (var45 && class75.field633.length() < 320) {
													class75.field633 = class75.field633 + var10.field2321;
												}
											}
										}
									} else if (class75.field619 != 6) {
										if (7 == class75.field619) {
											if (class87.field781 && !client.field1640) {
												var11 = class11.field47 - 150;
												var39 = 40 + 25 + var11 + 240;
												var40 = 231;
												var25 = var40 + 40;
												if (var6 == 1 && var35 >= var11 && var35 <= var39 && var36 >= var40 && var36 <= var25) {
													class75.field634 = class85.method1803(var11, var35);
												}

												var26 = class75.field627 + 180 - 80;
												short var16 = 321;
												boolean var27;
												if (var6 == 1 && var35 >= var26 - 75 && var35 <= var26 + 75 && var36 >= var16 - 20 && var36 <= var16 + 20) {
													var27 = class185.method3433();
													if (var27) {
														class9.method64(50);
														return;
													}
												}

												var26 = 80 + class75.field627 + 180;
												if (var6 == 1 && var35 >= var26 - 75 && var35 <= var26 + 75 && var36 >= var16 - 20 && var36 <= var16 + 20) {
													class75.field635 = new String[8];
													class367.method6730(true);
												}

												while (var10.method3911()) {
													if (101 == var10.field2317) {
														class75.field635[class75.field634] = null;
													}

													if (85 == var10.field2317) {
														if (null == class75.field635[class75.field634] && class75.field634 > 0) {
															--class75.field634;
														}

														class75.field635[class75.field634] = null;
													}

													if (var10.field2321 >= '0' && var10.field2321 <= '9') {
														class75.field635[class75.field634] = "" + var10.field2321;
														if (class75.field634 < 7) {
															++class75.field634;
														}
													}

													if (84 == var10.field2317) {
														var27 = class185.method3433();
														if (var27) {
															class9.method64(50);
														}

														return;
													}
												}
											} else {
												var11 = 180 + class75.field627 - 80;
												var12 = 321;
												if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
													class115.method2229(class140.method2473("secure", true) + "m=dob/set_dob.ws", true, false);
													class75.method5452(class338.field4153, class338.field4165, class338.field4166);
													class74.method1490(6);
													return;
												}

												var11 = class75.field627 + 180 + 80;
												if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
													class367.method6730(true);
												}
											}
										} else if (class75.field619 == 8) {
											var11 = 180 + class75.field627 - 80;
											var12 = 321;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class115.method2229("https://www.jagex.com/terms/privacy", true, false);
												class75.method5452(class338.field4153, class338.field4165, class338.field4166);
												class74.method1490(6);
												return;
											}

											var11 = 80 + class75.field627 + 180;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class367.method6730(true);
											}
										} else if (class75.field619 == 9) {
											var11 = 180 + class75.field627;
											var12 = 311;
											if (var9.field2317 == 84 || var9.field2317 == 13 || var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class337.method6314(false);
											}
										} else if (class75.field619 == 10) {
											var11 = class75.field627 + 180;
											var12 = 209;
											if (84 == var9.field2317 || var6 == 1 && var35 >= var11 - 109 && var35 <= var11 + 109 && var36 >= var12 && var36 <= var12 + 68) {
												class75.method5452(class338.field4074, class338.field4134, class338.field4135);
												client.field1758 = class445.field4787;
												class49.method996(false);
												class9.method64(20);
											}
										} else if (class75.field619 == 12) {
											var11 = class11.field47;
											var12 = 233;
											class407 var28 = var1.method6865(0, 30, class338.field4196, var11, var12);
											class407 var14 = var1.method6865(32, 32, class338.field4196, var11, var12);
											class407 var15 = var1.method6865(70, 34, class338.field4196, var11, var12);
											var39 = var12 + 17;
											class407 var29 = var1.method6865(0, 34, class338.field4197, var11, var39);
											if (var6 == 1) {
												if (var28.method7375(var35, var36)) {
													class115.method2229("https://www.jagex.com/terms", true, false);
												} else if (var14.method7375(var35, var36)) {
													class115.method2229("https://www.jagex.com/terms/privacy", true, false);
												} else if (var15.method7375(var35, var36) || var29.method7375(var35, var36)) {
													class115.method2229("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
												}
											}

											var11 = class11.field47 - 80;
											var12 = 311;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												client.method3393();
												class337.method6314(true);
											}

											var11 = class11.field47 + 80;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class75.field619 = 13;
											}
										} else if (13 == class75.field619) {
											var11 = class11.field47;
											var12 = 321;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class337.method6314(true);
											}
										} else if (14 == class75.field619) {
											String var30 = "";
											switch(class75.field628) {
											case 0:
												var30 = "https://support.runescape.com/hc/en-gb/articles/115002238729-Account-Bans";
												break;
											case 1:
												var30 = "https://support.runescape.com/hc/en-gb/articles/206103939-My-account-is-locked";
												break;
											case 2:
												var30 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
												break;
											default:
												class367.method6730(false);
											}

											var39 = 180 + class75.field627;
											var40 = 276;
											if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20) {
												class115.method2229(var30, true, false);
												class75.method5452(class338.field4153, class338.field4165, class338.field4166);
												class74.method1490(6);
												return;
											}

											var39 = 180 + class75.field627;
											var40 = 326;
											if (var6 == 1 && var35 >= var39 - 75 && var35 <= var39 + 75 && var36 >= var40 - 20 && var36 <= var40 + 20) {
												class367.method6730(false);
											}
										} else if (24 == class75.field619) {
											var11 = class75.field627 + 180;
											var12 = 301;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class337.method6314(false);
											}
										} else if (class75.field619 == 26) {
											var11 = 180 + class75.field627 - 80;
											var12 = 321;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class115.method2229(class140.method2473("secure", true) + "m=dob/set_dob.ws", true, false);
												class75.method5452(class338.field4153, class338.field4165, class338.field4166);
												class74.method1490(6);
												return;
											}

											var11 = 180 + class75.field627 + 80;
											if (var6 == 1 && var35 >= var11 - 75 && var35 <= var11 + 75 && var36 >= var12 - 20 && var36 <= var12 + 20) {
												class367.method6730(true);
											}
										}
									} else {
										while (true) {
											do {
												if (!var10.method3911()) {
													var38 = 321;
													if (var6 == 1 && var36 >= var38 - 20 && var36 <= var38 + 20) {
														class367.method6730(true);
													}

													return;
												}
											} while(84 != var10.field2317 && var10.field2317 != 13);

											class367.method6730(true);
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

	static void method7921(class93 var0, int var1, int var2) {
		if (var1 == var0.field852 && var1 != -1) {
			int var4 = class160.method2660(var1).field2013;
			if (var4 == 1) {
				var0.field844 = 0;
				var0.field845 = 0;
				var0.field804 = var2;
				var0.field875 = 0;
			}

			if (var4 == 2) {
				var0.field875 = 0;
			}
		} else if (var1 == -1 || var0.field852 == -1 || class160.method2660(var1).field2006 >= class160.method2660(var0.field852).field2006) {
			var0.field852 = var1;
			var0.field844 = 0;
			var0.field845 = 0;
			var0.field804 = var2;
			var0.field875 = 0;
			var0.field876 = var0.field871;
		}

	}

	static final void method7920() {
		class49.method1000();
		if (class73.field603 != null) {
			class73.field603.method6708();
		}

	}
}
