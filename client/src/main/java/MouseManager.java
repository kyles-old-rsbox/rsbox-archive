import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public class MouseManager implements MouseListener, MouseMotionListener, FocusListener {
	public static int field277;
	public static int field283;
	public static int field284;
	public static int field285;
	public static int field289;
	public static int field293;
	public static String field296;
	public static long field279;
	public static long field286;
	public static volatile int idleTicks;
	static class336 field295;
	static MouseManager field292;
	static int field298;
	static volatile int field275;
	static volatile int field280;
	static volatile int field281;
	static volatile int field287;
	static volatile int field288;
	static volatile int field291;
	static volatile long field282;
	static volatile long field290;

	static {
		field292 = new MouseManager();
		idleTicks = 0;
		field291 = 0;
		field280 = -1;
		field281 = -1;
		field282 = -1L;
		field289 = 0;
		field284 = 0;
		field285 = 0;
		field286 = 0L;
		field287 = 0;
		field275 = 0;
		field288 = 0;
		field290 = 0L;
		field277 = 0;
		field283 = 0;
		field293 = 0;
		field279 = 0L;
	}

	static void method773(int var0, String var1, String var2) {
		MessagesManager.method1858(var0, var1, var2, (String)null);
	}

	MouseManager() {
	}

	public static void method799(boolean var0) {
		if (null != class324.field3787) {
			try {
				Buffer var2 = new Buffer(4);
				var2.writeByte(var0 ? 2 : 3);
				var2.writeMedium(0);
				class324.field3787.write(var2.data, 0, 4);
			} catch (IOException var5) {
				try {
					class324.field3787.method7259();
				} catch (Exception var4) {
				}

				++class324.field3775;
				class324.field3787 = null;
			}

		}
	}

	public static void method4616() {
		synchronized(field292) {
			field289 = field291;
			field284 = field280;
			field285 = field281;
			field286 = field282;
			field277 = field287;
			field283 = field275;
			field293 = field288;
			field279 = field290;
			field287 = 0;
		}
	}

	final int method772(MouseEvent var1) {
		int var3 = var1.getButton();
		if (!var1.isAltDown() && var3 != 2) {
			return !var1.isMetaDown() && var3 != 3 ? 1 : 2;
		} else {
			return 4;
		}
	}

	public final synchronized void mousePressed(MouseEvent var1) {
		if (null != field292) {
			idleTicks = 0;
			field275 = var1.getX();
			field288 = var1.getY();
			field290 = class272.method2046();
			field287 = this.method772(var1);
			if (0 != field287) {
				field291 = field287;
			}
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void mouseReleased(MouseEvent var1) {
		if (null != field292) {
			idleTicks = 0;
			field291 = 0;
		}

		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final void mouseClicked(MouseEvent var1) {
		if (var1.isPopupTrigger()) {
			var1.consume();
		}

	}

	public final synchronized void mouseEntered(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void mouseExited(MouseEvent var1) {
		if (field292 != null) {
			idleTicks = 0;
			field280 = -1;
			field281 = -1;
			field282 = var1.getWhen();
		}

	}

	public final synchronized void mouseDragged(MouseEvent var1) {
		this.mouseMoved(var1);
	}

	public final synchronized void mouseMoved(MouseEvent var1) {
		if (null != field292) {
			idleTicks = 0;
			field280 = var1.getX();
			field281 = var1.getY();
			field282 = var1.getWhen();
		}

	}

	public final void focusGained(FocusEvent var1) {
	}

	public final synchronized void focusLost(FocusEvent var1) {
		if (field292 != null) {
			field291 = 0;
		}

	}

	static final void method795(int var0, int var1, int var2, int var3, boolean var4) {
		if (var2 < 1) {
			var2 = 1;
		}

		if (var3 < 1) {
			var3 = 1;
		}

		int var6 = var3 - 334;
		int var7;
		if (var6 < 0) {
			var7 = client.field1907;
		} else if (var6 >= 100) {
			var7 = client.field1792;
		} else {
			var7 = client.field1907 + var6 * (client.field1792 - client.field1907) / 100;
		}

		int var8 = 512 * var7 * var3 / (var2 * 334);
		int var9;
		int var10;
		short var11;
		if (var8 < client.field1705) {
			var11 = client.field1705;
			var7 = 334 * var2 * var11 / (var3 * 512);
			if (var7 > client.field1912) {
				var7 = client.field1912;
				var9 = var7 * var3 * 512 / (var11 * 334);
				var10 = (var2 - var9) / 2;
				if (var4) {
					class481.method8715();
					class481.method8660(var0, var1, var10, var3, -16777216);
					class481.method8660(var2 + var0 - var10, var1, var10, var3, -16777216);
				}

				var0 += var10;
				var2 -= var10 * 2;
			}
		} else if (var8 > client.field1914) {
			var11 = client.field1914;
			var7 = 334 * var2 * var11 / (var3 * 512);
			if (var7 < client.field1744) {
				var7 = client.field1744;
				var9 = var11 * var2 * 334 / (var7 * 512);
				var10 = (var3 - var9) / 2;
				if (var4) {
					class481.method8715();
					class481.method8660(var0, var1, var2, var10, -16777216);
					class481.method8660(var0, var3 + var1 - var10, var2, var10, -16777216);
				}

				var1 += var10;
				var3 -= var10 * 2;
			}
		}

		client.field1919 = var3 * var7 / 334;
		if (client.field1917 != var2 || var3 != client.field1678) {
			class336.method6282(var2, var3);
		}

		client.field1915 = var0;
		client.field1634 = var1;
		client.field1917 = var2;
		client.field1678 = var3;
	}

	static final void method790(int var0, int var1, int var2, int var3) {
		if (0 == client.isItemSelected && !client.isSpellSelected) {
			client.method351(class338.field4029, "", 23, 0, var0 - var2, var1 - var3);
		}

		long var5 = -1L;
		long var7 = -1L;

		int var9;
		for (var9 = 0; var9 < class234.method1116(); ++var9) {
			long var10 = class234.field2766[var9];
			if (var7 != var10) {
				var7 = var10;
				int var14 = class234.method7552(class234.field2766[var9]);
				int var15 = var14;
				int var16 = class234.method134(var9);
				long var19 = class234.field2766[var9];
				int var18 = (int)(var19 >>> 14 & 3L);
				int var27 = class234.method1610(class234.field2766[var9]);
				int var20 = var27;
				int var24;
				if (var18 == 2 && class145.field1333.method4156(class55.field396, var14, var16, var10) >= 0) {
					class195 var21 = InterfaceParent.method1866(var27);
					if (var21.field2094 != null) {
						var21 = var21.method3588();
					}

					if (var21 == null) {
						continue;
					}

					class101 var22 = null;

					for (class101 var23 = (class101)client.pendingSpawns.method6364(); null != var23; var23 = (class101)client.pendingSpawns.method6358()) {
						if (var23.field993 == class55.field396 && var15 == var23.field999 && var23.field994 == var16 && var23.field998 == var20) {
							var22 = var23;
							break;
						}
					}

					if (client.isItemSelected == 1) {
						client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(65535) + var21.field2063, 1, var20, var15, var16);
					} else if (client.isSpellSelected) {
						if ((class120.field1161 & 4) == 4) {
							client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(65535) + var21.field2063, 2, var20, var15, var16);
						}
					} else {
						String[] var36 = var21.field2060;
						if (var36 != null) {
							for (var24 = 4; var24 >= 0; --var24) {
								if ((var22 == null || var22.method1996(var24)) && var36[var24] != null) {
									short var30 = 0;
									if (var24 == 0) {
										var30 = 3;
									}

									if (var24 == 1) {
										var30 = 4;
									}

									if (var24 == 2) {
										var30 = 5;
									}

									if (var24 == 3) {
										var30 = 6;
									}

									if (var24 == 4) {
										var30 = 1001;
									}

									client.method351(var36[var24], class96.method4510(65535) + var21.field2063, var30, var20, var15, var16);
								}
							}
						}

						client.method351(class338.field4182, class96.method4510(65535) + var21.field2063, 1002, var21.field2052, var15, var16);
					}
				}

				class93 var25;
				int var28;
				class81 var37;
				int[] var38;
				if (var18 == 1) {
					class81 var32 = client.npcs[var20];
					if (null == var32) {
						continue;
					}

					if (1 == var32.field709.field2262 && (var32.field827 & 127) == 64 && (var32.field802 & 127) == 64) {
						for (var28 = 0; var28 < client.npcCount; ++var28) {
							var37 = client.npcs[client.field1692[var28]];
							if (null != var37 && var37 != var32 && 1 == var37.field709.field2262 && var37.field827 == var32.field827 && var32.field802 == var37.field802) {
								class295.method5541(var37, client.field1692[var28], var15, var16);
							}
						}

						var28 = PlayerManager.playerCount;
						var38 = PlayerManager.field1013;

						for (var24 = 0; var24 < var28; ++var24) {
							var25 = client.players[var38[var24]];
							if (null != var25 && var25.field827 == var32.field827 && var32.field802 == var25.field802) {
								class117.method2256(var25, var38[var24], var15, var16);
							}
						}
					}

					class295.method5541(var32, var20, var15, var16);
				}

				if (var18 == 0) {
					class93 var33 = client.players[var20];
					if (null == var33) {
						continue;
					}

					if ((var33.field827 & 127) == 64 && 64 == (var33.field802 & 127)) {
						for (var28 = 0; var28 < client.npcCount; ++var28) {
							var37 = client.npcs[client.field1692[var28]];
							if (var37 != null && var37.field709.field2262 == 1 && var33.field827 == var37.field827 && var37.field802 == var33.field802) {
								class295.method5541(var37, client.field1692[var28], var15, var16);
							}
						}

						var28 = PlayerManager.playerCount;
						var38 = PlayerManager.field1013;

						for (var24 = 0; var24 < var28; ++var24) {
							var25 = client.players[var38[var24]];
							if (var25 != null && var33 != var25 && var25.field827 == var33.field827 && var33.field802 == var25.field802) {
								class117.method2256(var25, var38[var24], var15, var16);
							}
						}
					}

					if (var20 != client.combatTargetPlayerIndex) {
						class117.method2256(var33, var20, var15, var16);
					} else {
						var5 = var10;
					}
				}

				if (var18 == 3) {
					NodeDeque var34 = client.groundItems[class55.field396][var15][var16];
					if (var34 != null) {
						for (class104 var35 = (class104)var34.method6363(); var35 != null; var35 = (class104)var34.method6378()) {
							class198 var39 = class278.method5388(var35.field1043);
							if (client.isItemSelected == 1) {
								client.method351(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(16748608) + var39.field2131, 16, var35.field1043, var15, var16);
							} else if (client.isSpellSelected) {
								if ((class120.field1161 & 1) == 1) {
									client.method351(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(16748608) + var39.field2131, 17, var35.field1043, var15, var16);
								}
							} else {
								String[] var29 = var39.field2148;

								for (int var40 = 4; var40 >= 0; --var40) {
									if (var35.method2028(var40)) {
										if (var29 != null && null != var29[var40]) {
											byte var26 = 0;
											if (var40 == 0) {
												var26 = 18;
											}

											if (var40 == 1) {
												var26 = 19;
											}

											if (var40 == 2) {
												var26 = 20;
											}

											if (var40 == 3) {
												var26 = 21;
											}

											if (var40 == 4) {
												var26 = 22;
											}

											client.method351(var29[var40], class96.method4510(16748608) + var39.field2131, var26, var35.field1043, var15, var16);
										} else if (var40 == 2) {
											client.method351(class338.field3949, class96.method4510(16748608) + var39.field2131, 20, var35.field1043, var15, var16);
										}
									}
								}

								client.method351(class338.field4182, class96.method4510(16748608) + var39.field2131, 1004, var35.field1043, var15, var16);
							}
						}
					}
				}
			}
		}

		if (var5 != -1L) {
			var9 = class234.method7552(var5);
			int var31 = class234.method3636(var5);
			class93 var11 = client.players[client.combatTargetPlayerIndex];
			class117.method2256(var11, client.combatTargetPlayerIndex, var9, var31);
		}

	}

	static final boolean method796(class300 var0) {
		if (null == var0.field3591) {
			return false;
		} else {
			for (int var2 = 0; var2 < var0.field3591.length; ++var2) {
				int var3 = class262.method5150(var0, var2);
				int var4 = var0.field3592[var2];
				if (var0.field3591[var2] == 2) {
					if (var3 >= var4) {
						return false;
					}
				} else if (3 == var0.field3591[var2]) {
					if (var3 <= var4) {
						return false;
					}
				} else if (var0.field3591[var2] == 4) {
					if (var4 == var3) {
						return false;
					}
				} else if (var3 != var4) {
					return false;
				}
			}

			return true;
		}
	}
}
