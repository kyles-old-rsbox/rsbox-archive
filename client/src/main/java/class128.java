public class class128 extends class393 {
	static int[][][] field1231;
	final boolean field1234;

	public class128(boolean var1) {
		this.field1234 = var1;
	}

	int method2387(class396 var1, class396 var2) {
		if (0 != var1.field4491 && var2.field4491 != 0) {
			return this.field1234 ? var1.field4490 - var2.field4490 : var2.field4490 - var1.field4490;
		} else {
			return this.method7162(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method2387((class396)var1, (class396)var2);
	}

	static final void method2390(class300[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		for (int var9 = 0; var9 < var0.length; ++var9) {
			class300 var10 = var0[var9];
			if (null != var10 && var10.field3596 == var1 && (var10.method5909() || class190.method3528(var10) != 0 || var10 == client.field1823)) {
				if (var10.field3459) {
					if (client.method343(var10)) {
						continue;
					}
				} else if (0 == var10.field3462 && var10 != class219.field2616 && client.method343(var10)) {
					continue;
				}

				if (var10.field3462 == 11) {
					if (var10.method5874(class28.urlRequester)) {
						if (var10.method5876()) {
							class136.method2438(var10);
							class26.method349(var10.field3602, var10, true);
						}

						if (var10.field3589 != null) {
							ClientScript var11 = new ClientScript();
							var11.field694 = var10;
							var11.args = var10.field3589;
							client.field1765.method6355(var11);
						}
					}
				} else if (12 == var10.field3462 && var10.method5926()) {
					class136.method2438(var10);
				}

				int var27 = var6 + var10.field3473;
				int var12 = var10.field3551 + var7;
				int var13;
				int var14;
				int var15;
				int var16;
				int var19;
				int var28;
				if (var10.field3462 == 2) {
					var13 = var2;
					var14 = var3;
					var15 = var4;
					var16 = var5;
				} else {
					int var17;
					if (var10.field3462 == 9) {
						var17 = var27;
						var28 = var12;
						var19 = var27 + var10.field3448;
						int var20 = var12 + var10.field3476;
						if (var19 < var27) {
							var17 = var19;
							var19 = var27;
						}

						if (var20 < var12) {
							var28 = var20;
							var20 = var12;
						}

						++var19;
						++var20;
						var13 = var17 > var2 ? var17 : var2;
						var14 = var28 > var3 ? var28 : var3;
						var15 = var19 < var4 ? var19 : var4;
						var16 = var20 < var5 ? var20 : var5;
					} else {
						var17 = var27 + var10.field3448;
						var28 = var10.field3476 + var12;
						var13 = var27 > var2 ? var27 : var2;
						var14 = var12 > var3 ? var12 : var3;
						var15 = var17 < var4 ? var17 : var4;
						var16 = var28 < var5 ? var28 : var5;
					}
				}

				if (client.field1874 == var10) {
					client.field1783 = true;
					client.field1831 = var27;
					client.field1832 = var12;
				}

				boolean var35 = false;
				if (var10.field3540) {
					switch(client.field1811) {
					case 0:
						var35 = true;
					case 1:
					default:
						break;
					case 2:
						if (var10.field3517 >>> 16 == client.field1898) {
							var35 = true;
						}
						break;
					case 3:
						if (client.field1898 == var10.field3517) {
							var35 = true;
						}
					}
				}

				if (var35 || !var10.field3459 || var13 < var15 && var14 < var16) {
					if (var10.field3459) {
						ClientScript var18;
						if (var10.field3539) {
							if (MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16) {
								for (var18 = (ClientScript)client.field1765.method6364(); null != var18; var18 = (ClientScript)client.field1765.method6358()) {
									if (var18.field692) {
										var18.method7825();
										var18.field694.field3603 = false;
									}
								}

								class189.method3481();
								if (class78.field684 == 0) {
									client.field1874 = null;
									client.field1823 = null;
								}

								if (!client.isMenuOpen) {
									client.method5557();
								}
							}
						} else if (var10.field3449 && MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16) {
							for (var18 = (ClientScript)client.field1765.method6364(); null != var18; var18 = (ClientScript)client.field1765.method6358()) {
								if (var18.field692 && var18.args == var18.field694.field3574) {
									var18.method7825();
								}
							}
						}
					}

					var28 = MouseManager.field284;
					var19 = MouseManager.field285;
					if (MouseManager.field277 != 0) {
						var28 = MouseManager.lastPressedX;
						var19 = MouseManager.lastPressedY;
					}

					boolean var36 = var28 >= var13 && var19 >= var14 && var28 < var15 && var19 < var16;
					if (var10.field3464 == 1337) {
						if (!client.isLoading && !client.isMenuOpen && var36) {
							MouseManager.method790(var28, var19, var13, var14);
						}
					} else if (var10.field3464 == 1338) {
						class143.method2492(var10, var27, var12);
					} else {
						if (1400 == var10.field3464) {
							ProofOfWorkRequest.field10.method7657(MouseManager.field284, MouseManager.field285, var36, var27, var12, var10.field3448, var10.field3476);
						}

						if (!client.isMenuOpen && var36) {
							if (1400 == var10.field3464) {
								ProofOfWorkRequest.field10.method7628(var27, var12, var10.field3448, var10.field3476, var28, var19);
							} else {
								class63.method1361(var10, var28 - var27, var19 - var12);
							}
						}

						boolean var22;
						int var24;
						if (var35) {
							for (int var21 = 0; var21 < var10.field3541.length; ++var21) {
								var22 = false;
								boolean var23 = false;
								if (!var22 && var10.field3541[var21] != null) {
									for (var24 = 0; var24 < var10.field3541[var21].length; ++var24) {
										boolean var25 = false;
										if (null != var10.field3543) {
											var25 = client.keyHandler.isKeyDown(var10.field3541[var21][var24]);
										}

										if (client.method2448(var10.field3541[var21][var24]) || var25) {
											var22 = true;
											if (var10.field3543 != null && var10.field3543[var21] > client.field1645) {
												break;
											}

											byte var26 = var10.field3542[var21][var24];
											if (var26 == 0 || ((var26 & 8) == 0 || !client.keyHandler.isKeyDown(86) && !client.keyHandler.isKeyDown(82) && !client.keyHandler.isKeyDown(81)) && (0 == (var26 & 2) || client.keyHandler.isKeyDown(86)) && ((var26 & 1) == 0 || client.keyHandler.isKeyDown(82)) && ((var26 & 4) == 0 || client.keyHandler.isKeyDown(81))) {
												var23 = true;
												break;
											}
										}
									}
								}

								if (var23) {
									if (var21 < 10) {
										class272.method5220(var21 + 1, var10.field3517, var10.field3484, var10.field3445, "");
									} else if (var21 == 10) {
										class100.method1989();
										class247.method4960(var10.field3517, var10.field3484, class290.method2693(class190.method3528(var10)), var10.field3445);
										client.field1653 = class323.method6203(var10);
										if (client.field1653 == null) {
											client.field1653 = class338.field3899;
										}

										client.field1754 = var10.field3545 + class96.method4510(16777215);
									}

									var24 = var10.field3590[var21];
									if (var10.field3543 == null) {
										var10.field3543 = new int[var10.field3541.length];
									}

									if (null == var10.field3544) {
										var10.field3544 = new int[var10.field3541.length];
									}

									if (var24 != 0) {
										if (0 == var10.field3543[var21]) {
											var10.field3543[var21] = client.field1645 + var24 + var10.field3544[var21];
										} else {
											var10.field3543[var21] = client.field1645 + var24;
										}
									} else {
										var10.field3543[var21] = Integer.MAX_VALUE;
									}
								}

								if (!var22 && null != var10.field3543) {
									var10.field3543[var21] = 0;
								}
							}
						}

						if (var10.field3459) {
							if (MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16) {
								var36 = true;
							} else {
								var36 = false;
							}

							boolean var37 = false;
							if ((MouseManager.field289 == 1 || !class95.field944 && 4 == MouseManager.field289) && var36) {
								var37 = true;
							}

							var22 = false;
							if ((1 == MouseManager.field277 || !class95.field944 && MouseManager.field277 == 4) && MouseManager.lastPressedX >= var13 && MouseManager.lastPressedY >= var14 && MouseManager.lastPressedX < var15 && MouseManager.lastPressedY < var16) {
								var22 = true;
							}

							if (var22) {
								class311.method6051(var10, MouseManager.lastPressedX - var27, MouseManager.lastPressedY - var12);
							}

							if (var10.method5862()) {
								if (var22) {
									client.field1856.method6355(new class188(0, MouseManager.field284 - var27, MouseManager.field285 - var12, var10));
								}

								if (var37) {
									client.field1856.method6355(new class188(1, MouseManager.field284 - var27, MouseManager.field285 - var12, var10));
								}
							}

							if (var10.field3464 == 1400) {
								ProofOfWorkRequest.field10.method7742(var28, var19, var36 & var37, var36 & var22);
							}

							if (client.field1874 != null && var10 != client.field1874 && var36 && class290.method350(class190.method3528(var10))) {
								client.field1826 = var10;
							}

							if (var10 == client.field1823) {
								client.field1827 = true;
								client.field1746 = var27;
								client.field1829 = var12;
							}

							if (var10.field3552) {
								ClientScript var29;
								if (var36 && 0 != client.field1639 && null != var10.field3574) {
									var29 = new ClientScript();
									var29.field692 = true;
									var29.field694 = var10;
									var29.field688 = client.field1639;
									var29.args = var10.field3574;
									client.field1765.method6355(var29);
								}

								if (null != client.field1874 || null != class183.field1943 || client.isMenuOpen) {
									var22 = false;
									var37 = false;
									var36 = false;
								}

								if (!var10.field3491 && var22) {
									var10.field3491 = true;
									if (var10.field3611 != null) {
										var29 = new ClientScript();
										var29.field692 = true;
										var29.field694 = var10;
										var29.field693 = MouseManager.lastPressedX - var27;
										var29.field688 = MouseManager.lastPressedY - var12;
										var29.args = var10.field3611;
										client.field1765.method6355(var29);
									}
								}

								if (var10.field3491 && var37 && var10.field3555 != null) {
									var29 = new ClientScript();
									var29.field692 = true;
									var29.field694 = var10;
									var29.field693 = MouseManager.field284 - var27;
									var29.field688 = MouseManager.field285 - var12;
									var29.args = var10.field3555;
									client.field1765.method6355(var29);
								}

								if (var10.field3491 && !var37) {
									var10.field3491 = false;
									if (var10.field3556 != null) {
										var29 = new ClientScript();
										var29.field692 = true;
										var29.field694 = var10;
										var29.field693 = MouseManager.field284 - var27;
										var29.field688 = MouseManager.field285 - var12;
										var29.args = var10.field3556;
										client.field1813.method6355(var29);
									}
								}

								if (var37 && var10.field3557 != null) {
									var29 = new ClientScript();
									var29.field692 = true;
									var29.field694 = var10;
									var29.field693 = MouseManager.field284 - var27;
									var29.field688 = MouseManager.field285 - var12;
									var29.args = var10.field3557;
									client.field1765.method6355(var29);
								}

								if (!var10.field3603 && var36) {
									var10.field3603 = true;
									if (var10.field3558 != null) {
										var29 = new ClientScript();
										var29.field692 = true;
										var29.field694 = var10;
										var29.field693 = MouseManager.field284 - var27;
										var29.field688 = MouseManager.field285 - var12;
										var29.args = var10.field3558;
										client.field1765.method6355(var29);
									}
								}

								if (var10.field3603 && var36 && var10.field3559 != null) {
									var29 = new ClientScript();
									var29.field692 = true;
									var29.field694 = var10;
									var29.field693 = MouseManager.field284 - var27;
									var29.field688 = MouseManager.field285 - var12;
									var29.args = var10.field3559;
									client.field1765.method6355(var29);
								}

								if (var10.field3603 && !var36) {
									var10.field3603 = false;
									if (null != var10.field3454) {
										var29 = new ClientScript();
										var29.field692 = true;
										var29.field694 = var10;
										var29.field693 = MouseManager.field284 - var27;
										var29.field688 = MouseManager.field285 - var12;
										var29.args = var10.field3454;
										client.field1813.method6355(var29);
									}
								}

								if (var10.field3571 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3571;
									client.field1854.method6355(var29);
								}

								ClientScript var34;
								int var38;
								int var39;
								if (var10.field3565 != null && client.field1690 > var10.field3606) {
									if (var10.field3566 != null && client.field1690 - var10.field3606 <= 32) {
										label839:
										for (var38 = var10.field3606; var38 < client.field1690; ++var38) {
											var24 = client.field1931[var38 & 31];

											for (var39 = 0; var39 < var10.field3566.length; ++var39) {
												if (var10.field3566[var39] == var24) {
													var34 = new ClientScript();
													var34.field694 = var10;
													var34.args = var10.field3565;
													client.field1765.method6355(var34);
													break label839;
												}
											}
										}
									} else {
										var29 = new ClientScript();
										var29.field694 = var10;
										var29.args = var10.field3565;
										client.field1765.method6355(var29);
									}

									var10.field3606 = client.field1690;
								}

								if (var10.field3585 != null && client.field1838 > var10.field3607) {
									if (null != var10.field3568 && client.field1838 - var10.field3607 <= 32) {
										label815:
										for (var38 = var10.field3607; var38 < client.field1838; ++var38) {
											var24 = client.field1837[var38 & 31];

											for (var39 = 0; var39 < var10.field3568.length; ++var39) {
												if (var10.field3568[var39] == var24) {
													var34 = new ClientScript();
													var34.field694 = var10;
													var34.args = var10.field3585;
													client.field1765.method6355(var34);
													break label815;
												}
											}
										}
									} else {
										var29 = new ClientScript();
										var29.field694 = var10;
										var29.args = var10.field3585;
										client.field1765.method6355(var29);
									}

									var10.field3607 = client.field1838;
								}

								if (null != var10.field3569 && client.field1742 > var10.field3597) {
									if (null != var10.field3570 && client.field1742 - var10.field3597 <= 32) {
										label791:
										for (var38 = var10.field3597; var38 < client.field1742; ++var38) {
											var24 = client.field1839[var38 & 31];

											for (var39 = 0; var39 < var10.field3570.length; ++var39) {
												if (var10.field3570[var39] == var24) {
													var34 = new ClientScript();
													var34.field694 = var10;
													var34.args = var10.field3569;
													client.field1765.method6355(var34);
													break label791;
												}
											}
										}
									} else {
										var29 = new ClientScript();
										var29.field694 = var10;
										var29.args = var10.field3569;
										client.field1765.method6355(var29);
									}

									var10.field3597 = client.field1742;
								}

								if (client.field1843 > var10.field3605 && var10.field3502 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3502;
									client.field1765.method6355(var29);
								}

								if (client.field1844 > var10.field3605 && var10.field3579 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3579;
									client.field1765.method6355(var29);
								}

								if (client.field1845 > var10.field3605 && null != var10.field3580) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3580;
									client.field1765.method6355(var29);
								}

								if (client.field1846 > var10.field3605 && var10.field3581 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3581;
									client.field1765.method6355(var29);
								}

								if (client.field1847 > var10.field3605 && null != var10.field3452) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3452;
									client.field1765.method6355(var29);
								}

								if (client.field1848 > var10.field3605 && var10.field3587 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3587;
									client.field1765.method6355(var29);
								}

								if (client.field1849 > var10.field3605 && null != var10.field3561) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3561;
									client.field1765.method6355(var29);
								}

								if (client.field1642 > var10.field3605 && var10.field3583 != null) {
									var29 = new ClientScript();
									var29.field694 = var10;
									var29.args = var10.field3583;
									client.field1765.method6355(var29);
								}

								var10.field3605 = client.field1878;
								if (null != var10.field3576) {
									for (var38 = 0; var38 < client.field1822; ++var38) {
										ClientScript var30 = new ClientScript();
										var30.field694 = var10;
										var30.field689 = client.field1880[var38];
										var30.field687 = client.field1756[var38];
										var30.args = var10.field3576;
										client.field1765.method6355(var30);
									}
								}

								ClientScript var31;
								int[] var40;
								if (null != var10.field3577) {
									var40 = client.keyHandler.method3915();

									for (var24 = 0; var24 < var40.length; ++var24) {
										var31 = new ClientScript();
										var31.field694 = var10;
										var31.field689 = var40[var24];
										var31.args = var10.field3577;
										client.field1765.method6355(var31);
									}
								}

								if (var10.field3578 != null) {
									var40 = client.keyHandler.method3896();

									for (var24 = 0; var24 < var40.length; ++var24) {
										var31 = new ClientScript();
										var31.field694 = var10;
										var31.field689 = var40[var24];
										var31.args = var10.field3578;
										client.field1765.method6355(var31);
									}
								}
							}
						}

						if (!var10.field3459) {
							if (client.field1874 != null || class183.field1943 != null || client.isMenuOpen) {
								continue;
							}

							if ((var10.field3536 >= 0 || var10.field3487 != 0) && MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16) {
								if (var10.field3536 >= 0) {
									class219.field2616 = var0[var10.field3536];
								} else {
									class219.field2616 = var10;
								}
							}

							if (8 == var10.field3462 && MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16) {
								class219.field2617 = var10;
							}

							if (var10.field3492 > var10.field3476) {
								ProofOfWorkRequest.method16(var10, var10.field3448 + var27, var12, var10.field3476, var10.field3492, MouseManager.field284, MouseManager.field285);
							}
						}

						if (0 == var10.field3462) {
							method2390(var0, var10.field3517, var13, var14, var15, var16, var27 - var10.field3481, var12 - var10.field3482);
							if (null != var10.field3602) {
								method2390(var10.field3602, var10.field3517, var13, var14, var15, var16, var27 - var10.field3481, var12 - var10.field3482);
							}

							InterfaceParent var32 = (InterfaceParent)client.parentInterfaces.method7855((long)var10.field3517);
							if (var32 != null) {
								if (var32.field797 == 0 && MouseManager.field284 >= var13 && MouseManager.field285 >= var14 && MouseManager.field284 < var15 && MouseManager.field285 < var16 && !client.isMenuOpen) {
									for (ClientScript var33 = (ClientScript)client.field1765.method6364(); null != var33; var33 = (ClientScript)client.field1765.method6358()) {
										if (var33.field692) {
											var33.method7825();
											var33.field694.field3603 = false;
										}
									}

									if (0 == class78.field684) {
										client.field1874 = null;
										client.field1823 = null;
									}

									if (!client.isMenuOpen) {
										client.method5557();
									}
								}

								client.method5127(var32.field796, var13, var14, var15, var16, var27, var12);
							}
						}
					}
				}
			}
		}

	}
}
