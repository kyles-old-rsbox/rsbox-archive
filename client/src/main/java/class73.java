import java.util.List;

public class class73 {
	static class367 field603;
	static int field602;
	static List field605;
	int field594;
	int field595;
	int field597;
	int field598;
	int field600;
	String field599;
	String field604;

	public static void method1488() {
		if (null != MouseManager.field292) {
			synchronized(MouseManager.field292) {
				MouseManager.field292 = null;
			}
		}

	}

	static final void method1486(class300[] var0, int var1) {
		for (int var3 = 0; var3 < var0.length; ++var3) {
			class300 var4 = var0[var3];
			if (null != var4 && var1 == var4.field3596 && (!var4.field3459 || !client.method343(var4))) {
				if (var4.field3462 == 0) {
					if (!var4.field3459 && client.method343(var4) && class219.field2616 != var4) {
						continue;
					}

					method1486(var0, var4.field3517);
					if (var4.field3602 != null) {
						method1486(var4.field3602, var4.field3517);
					}

					InterfaceParent var5 = (InterfaceParent)client.parentInterfaces.method7855((long)var4.field3517);
					if (var5 != null) {
						class378.method6804(var5.field796);
					}
				}

				if (var4.field3462 == 6) {
					int var6;
					if (var4.field3575 != -1 || var4.field3509 != -1) {
						boolean var9 = MouseManager.method796(var4);
						if (var9) {
							var6 = var4.field3509;
						} else {
							var6 = var4.field3575;
						}

						if (var6 != -1) {
							class189 var7 = class160.method2660(var6);
							if (!var7.method3486()) {
								for (var4.field3518 += client.field1701; var4.field3518 > var7.field2000[var4.field3471]; class136.method2438(var4)) {
									var4.field3518 -= var7.field2000[var4.field3471];
									++var4.field3471;
									if (var4.field3471 >= var7.field1998.length) {
										var4.field3471 -= var7.field2012;
										if (var4.field3471 < 0 || var4.field3471 >= var7.field1998.length) {
											var4.field3471 = 0;
										}
									}
								}
							} else {
								var4.field3471 += client.field1701;
								int var8 = var7.method3476();
								if (var4.field3471 >= var8) {
									var4.field3471 -= var7.field2012;
									if (var4.field3471 < 0 || var4.field3471 >= var8) {
										var4.field3471 = 0;
									}
								}

								class136.method2438(var4);
							}
						}
					}

					if (var4.field3512 != 0 && !var4.field3459) {
						int var10 = var4.field3512 >> 16;
						var6 = var4.field3512 << 16 >> 16;
						var10 *= client.field1701;
						var6 *= client.field1701;
						var4.field3601 = var4.field3601 + var10 & 2047;
						var4.field3513 = var6 + var4.field3513 & 2047;
						class136.method2438(var4);
					}
				}
			}
		}

	}

	static final void method1487(class300 var0, int var1, int var2, int var3) {
		class349.method6457();
		class298 var5 = var0.method5859(false);
		if (null != var5) {
			class481.method8653(var1, var2, var1 + var5.field3435, var2 + var5.field3433);
			if (client.minimapState != 2 && 5 != client.minimapState) {
				int var6 = client.field1672 & 2047;
				int var7 = 48 + class291.field3364.field827 / 32;
				int var8 = 464 - class291.field3364.field802 / 32;
				class309.field3678.method8502(var1, var2, var5.field3435, var5.field3433, var7, var8, var6, 256, var5.field3432, var5.field3434);

				int var9;
				int var10;
				int var11;
				for (var9 = 0; var9 < client.field1885; ++var9) {
					var10 = 4 * client.field1834[var9] + 2 - class291.field3364.field827 / 32;
					var11 = 4 * client.field1887[var9] + 2 - class291.field3364.field802 / 32;
					class275.method5224(var1, var2, var10, var11, client.field1818[var9], var5);
				}

				int var12;
				int var13;
				for (var9 = 0; var9 < 104; ++var9) {
					for (var10 = 0; var10 < 104; ++var10) {
						NodeDeque var15 = client.groundItems[class55.field396][var9][var10];
						if (null != var15) {
							var12 = var9 * 4 + 2 - class291.field3364.field827 / 32;
							var13 = 2 + var10 * 4 - class291.field3364.field802 / 32;
							class275.method5224(var1, var2, var12, var13, class64.field505[0], var5);
						}
					}
				}

				for (var9 = 0; var9 < client.npcCount; ++var9) {
					class81 var16 = client.npcs[client.field1692[var9]];
					if (var16 != null && var16.method1869()) {
						class203 var18 = var16.field709;
						if (null != var18 && null != var18.field2278) {
							var18 = var18.method3857();
						}

						if (var18 != null && var18.field2285 && var18.field2282) {
							var12 = var16.field827 / 32 - class291.field3364.field827 / 32;
							var13 = var16.field802 / 32 - class291.field3364.field802 / 32;
							class275.method5224(var1, var2, var12, var13, class64.field505[1], var5);
						}
					}
				}

				var9 = PlayerManager.playerCount;
				int[] var19 = PlayerManager.field1013;

				for (var11 = 0; var11 < var9; ++var11) {
					class93 var17 = client.players[var19[var11]];
					if (var17 != null && var17.method1869() && !var17.field913 && var17 != class291.field3364) {
						var13 = var17.field827 / 32 - class291.field3364.field827 / 32;
						int var14 = var17.field802 / 32 - class291.field3364.field802 / 32;
						if (var17.method1907()) {
							class275.method5224(var1, var2, var13, var14, class64.field505[3], var5);
						} else if (class291.field3364.field921 != 0 && var17.field921 != 0 && var17.field921 == class291.field3364.field921) {
							class275.method5224(var1, var2, var13, var14, class64.field505[4], var5);
						} else if (var17.method1939()) {
							class275.method5224(var1, var2, var13, var14, class64.field505[5], var5);
						} else if (var17.method1951()) {
							class275.method5224(var1, var2, var13, var14, class64.field505[6], var5);
						} else {
							class275.method5224(var1, var2, var13, var14, class64.field505[2], var5);
						}
					}
				}

				if (0 != client.hintArrowType && client.field1645 % 20 < 10) {
					if (client.hintArrowType == 1 && client.field1879 >= 0 && client.field1879 < client.npcs.length) {
						class81 var20 = client.npcs[client.field1879];
						if (null != var20) {
							var12 = var20.field827 / 32 - class291.field3364.field827 / 32;
							var13 = var20.field802 / 32 - class291.field3364.field802 / 32;
							class41.method764(var1, var2, var12, var13, class210.field2462[1], var5);
						}
					}

					if (client.hintArrowType == 2) {
						var11 = 2 + (client.field1655 * 4 - class36.field241 * 4) - class291.field3364.field827 / 32;
						var12 = 2 + (client.field1656 * 4 - class169.field1536 * 4) - class291.field3364.field802 / 32;
						class41.method764(var1, var2, var11, var12, class210.field2462[1], var5);
					}

					if (10 == client.hintArrowType && client.field1654 >= 0 && client.field1654 < client.players.length) {
						class93 var21 = client.players[client.field1654];
						if (null != var21) {
							var12 = var21.field827 / 32 - class291.field3364.field827 / 32;
							var13 = var21.field802 / 32 - class291.field3364.field802 / 32;
							class41.method764(var1, var2, var12, var13, class210.field2462[1], var5);
						}
					}
				}

				if (0 != client.destinationX) {
					var11 = 2 + client.destinationX * 4 - class291.field3364.field827 / 32;
					var12 = 2 + client.destinationY * 4 - class291.field3364.field802 / 32;
					class275.method5224(var1, var2, var11, var12, class210.field2462[0], var5);
				}

				if (!class291.field3364.field913) {
					class481.method8660(var5.field3435 / 2 + var1 - 1, var2 + var5.field3433 / 2 - 1, 3, 3, 16777215);
				}
			} else {
				class481.method8713(var1, var2, 0, var5.field3432, var5.field3434);
			}

			client.field1861[var3] = true;
		}
	}

	class73() {
	}
}
