public class class295 {
	public int field3374;
	public int field3375;
	public int field3376;

	public class295(int var1, int var2, int var3) {
		this.field3374 = var1;
		this.field3376 = var2;
		this.field3375 = var3;
	}

	public static String method5540(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var4 = var0[var1];
			return null == var4 ? "null" : var4.toString();
		} else {
			int var9 = var1 + var2;
			int var5 = 0;

			for (int var6 = var1; var6 < var9; ++var6) {
				CharSequence var7 = var0[var6];
				if (null == var7) {
					var5 += 4;
				} else {
					var5 += var7.length();
				}
			}

			StringBuilder var10 = new StringBuilder(var5);

			for (int var11 = var1; var11 < var9; ++var11) {
				CharSequence var8 = var0[var11];
				if (null == var8) {
					var10.append("null");
				} else {
					var10.append(var8);
				}
			}

			return var10.toString();
		}
	}

	public class295(class295 var1) {
		this.field3374 = var1.field3374;
		this.field3376 = var1.field3376;
		this.field3375 = var1.field3375;
	}

	public class295(int var1) {
		if (var1 == -1) {
			this.field3374 = -1;
		} else {
			this.field3374 = var1 >> 28 & 3;
			this.field3376 = var1 >> 14 & 16383;
			this.field3375 = var1 & 16383;
		}

	}

	public static class412 method5542() {
		synchronized(class412.field4560) {
			if (class412.field4562 == 0) {
				return new class412();
			} else {
				class412.field4560[--class412.field4562].method7420();
				return class412.field4560[class412.field4562];
			}
		}
	}

	public int method5522() {
		int var3 = this.field3374;
		int var4 = this.field3376;
		int var5 = this.field3375;
		int var2 = var3 << 28 | var4 << 14 | var5;
		return var2;
	}

	static void method5524(int var0, class392 var1, class336 var2) {
		class334 var4 = new class334();
		var4.field3860 = 1;
		var4.field4681 = (long)var0;
		var4.field3862 = var1;
		var4.field3863 = var2;
		synchronized(class322.field3759) {
			class322.field3759.method6355(var4);
		}

		synchronized(class322.field3762) {
			if (class322.field3761 == 0) {
				class322.field3763 = new Thread(new class322());
				class322.field3763.setDaemon(true);
				class322.field3763.start();
				class322.field3763.setPriority(5);
			}

			class322.field3761 = 600;
		}
	}

	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else {
			return !(var1 instanceof class295) ? false : this.method5523((class295)var1);
		}
	}

	boolean method5523(class295 var1) {
		if (this.field3374 != var1.field3374) {
			return false;
		} else if (this.field3376 != var1.field3376) {
			return false;
		} else {
			return this.field3375 == var1.field3375;
		}
	}

	public int hashCode() {
		return this.method5522();
	}

	public String toString() {
		return this.method5528(",");
	}

	String method5528(String var1) {
		return this.field3374 + var1 + (this.field3376 >> 6) + var1 + (this.field3375 >> 6) + var1 + (this.field3376 & 63) + var1 + (this.field3375 & 63);
	}

	static final void method5541(class81 var0, int var1, int var2, int var3) {
		class203 var5 = var0.field709;
		if (client.menuOptionsCount < 400) {
			if (null != var5.field2278) {
				var5 = var5.method3857();
			}

			if (var5 != null) {
				if (var5.field2282) {
					if (!var5.field2287 || client.followerIndex == var1) {
						String var6 = var0.method1620();
						int var7;
						int var10;
						if (0 != var5.field2291 && 0 != var0.field877) {
							var7 = -1 != var0.field877 ? var0.field877 : var5.field2291;
							var10 = class291.localPlayer.combatLevel;
							int var11 = var10 - var7;
							String var9;
							if (var11 < -9) {
								var9 = class96.method4510(16711680);
							} else if (var11 < -6) {
								var9 = class96.method4510(16723968);
							} else if (var11 < -3) {
								var9 = class96.method4510(16740352);
							} else if (var11 < 0) {
								var9 = class96.method4510(16756736);
							} else if (var11 > 9) {
								var9 = class96.method4510(65280);
							} else if (var11 > 6) {
								var9 = class96.method4510(4259584);
							} else if (var11 > 3) {
								var9 = class96.method4510(8453888);
							} else if (var11 > 0) {
								var9 = class96.method4510(12648192);
							} else {
								var9 = class96.method4510(16776960);
							}

							var6 = var6 + var9 + " " + class96.field964 + class338.field4060 + var7 + class96.field958;
						}

						if (var5.field2287 && client.field1794) {
							client.method351(class338.field4182, class96.method4510(16776960) + var6, 1003, var1, var2, var3);
						}

						if (client.isItemSelected == 1) {
							client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(16776960) + var6, 7, var1, var2, var3);
						} else if (client.isSpellSelected) {
							if ((class120.field1161 & 2) == 2) {
								client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(16776960) + var6, 8, var1, var2, var3);
							}
						} else {
							var7 = var5.field2287 && client.field1794 ? 2000 : 0;
							String[] var8 = var5.field2284;
							int var12;
							if (null != var8) {
								for (var12 = 4; var12 >= 0; --var12) {
									if (var0.method1639(var12) && var8[var12] != null && !var8[var12].equalsIgnoreCase(class338.field4056)) {
										var10 = 0;
										if (var12 == 0) {
											var10 = var7 + 9;
										}

										if (var12 == 1) {
											var10 = var7 + 10;
										}

										if (var12 == 2) {
											var10 = var7 + 11;
										}

										if (var12 == 3) {
											var10 = var7 + 12;
										}

										if (var12 == 4) {
											var10 = var7 + 13;
										}

										client.method351(var8[var12], class96.method4510(16776960) + var6, var10, var1, var2, var3);
									}
								}
							}

							if (var8 != null) {
								for (var12 = 4; var12 >= 0; --var12) {
									if (var0.method1639(var12) && null != var8[var12] && var8[var12].equalsIgnoreCase(class338.field4056)) {
										short var13 = 0;
										if (client.npcAttackOption != AttackOption.HIDDEN) {
											if (client.npcAttackOption == AttackOption.field698 || client.npcAttackOption == AttackOption.field705 && var5.field2291 > class291.localPlayer.combatLevel) {
												var13 = 2000;
											}

											var10 = 0;
											if (var12 == 0) {
												var10 = var13 + 9;
											}

											if (var12 == 1) {
												var10 = var13 + 10;
											}

											if (var12 == 2) {
												var10 = var13 + 11;
											}

											if (var12 == 3) {
												var10 = var13 + 12;
											}

											if (var12 == 4) {
												var10 = var13 + 13;
											}

											client.method351(var8[var12], class96.method4510(16776960) + var6, var10, var1, var2, var3);
										}
									}
								}
							}

							if (!var5.field2287 || !client.field1794) {
								client.method351(class338.field4182, class96.method4510(16776960) + var6, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
