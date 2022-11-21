public class class445 implements class360 {
	public static final class445 field4787;
	public static final class445 field4791;
	static final class445 field4788;
	static final class445 field4789;
	static final class445 field4790;
	static final class445 field4793;
	final int field4786;
	final int field4792;

	static {
		field4791 = new class445(1, 0);
		field4787 = new class445(0, 2);
		field4788 = new class445(5, 5);
		field4789 = new class445(4, 6);
		field4790 = new class445(3, 7);
		field4793 = new class445(2, 8);
	}

	class445(int var1, int var2) {
		this.field4792 = var1;
		this.field4786 = var2;
	}

	public int rsOrdinal() {
		return this.field4786;
	}

	public boolean method7938() {
		return this == field4787;
	}

	static int method7936(int var0, class78 var1, boolean var2) {
		int var5 = -1;
		class300 var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var5 = class57.field404[--class387.field4452];
			var4 = class282.method5426(var5);
		} else {
			var4 = var2 ? class138.field1284 : class153.field1414;
		}

		int var11;
		if (var0 == CS2Opcodes.CC_SETSCROLLPOS) {
			class387.field4452 -= 2;
			var11 = class57.field404[class387.field4452];
			int var7 = class57.field404[class387.field4452 + 1];
			if (12 == var4.field3462) {
				class297 var8 = var4.method5877();
				if (var8 != null && var8.method5739(var11, var7)) {
					class136.method2438(var4);
				}
			} else {
				var4.field3481 = var11;
				if (var4.field3481 > var4.field3483 - var4.field3448) {
					var4.field3481 = var4.field3483 - var4.field3448;
				}

				if (var4.field3481 < 0) {
					var4.field3481 = 0;
				}

				var4.field3482 = var7;
				if (var4.field3482 > var4.field3492 - var4.field3476) {
					var4.field3482 = var4.field3492 - var4.field3476;
				}

				if (var4.field3482 < 0) {
					var4.field3482 = 0;
				}

				class136.method2438(var4);
			}

			return 1;
		} else if (var0 == CS2Opcodes.CC_SETCOLOUR) {
			var4.field3485 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETFILL) {
			var4.field3489 = class57.field404[--class387.field4452] == 1;
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETTRANS) {
			var4.field3612 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETLINEWID) {
			var4.field3493 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETGRAPHIC) {
			var4.field3560 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SET2DANGLE) {
			var4.field3498 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETTILING) {
			var4.field3499 = class57.field404[--class387.field4452] == 1;
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETMODEL) {
			var4.field3504 = 1;
			var4.field3505 = class57.field404[--class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETMODELANGLE) {
			class387.field4452 -= 6;
			var4.field3510 = class57.field404[class387.field4452];
			var4.field3548 = class57.field404[1 + class387.field4452];
			var4.field3601 = class57.field404[class387.field4452 + 2];
			var4.field3513 = class57.field404[class387.field4452 + 3];
			var4.field3514 = class57.field404[4 + class387.field4452];
			var4.field3562 = class57.field404[5 + class387.field4452];
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETMODELANIM) {
			var11 = class57.field404[--class387.field4452];
			if (var4.field3575 != var11) {
				var4.field3575 = var11;
				var4.field3471 = 0;
				var4.field3518 = 0;
				class136.method2438(var4);
			}

			return 1;
		} else if (var0 == CS2Opcodes.CC_SETMODELORTHOG) {
			var4.field3534 = class57.field404[--class387.field4452] == 1;
			class136.method2438(var4);
			return 1;
		} else if (var0 == CS2Opcodes.CC_SETTEXT) {
			String var15 = class57.field405[--class126.field1220];
			if (!var15.equals(var4.field3522)) {
				var4.field3522 = var15;
				class136.method2438(var4);
			}

			return 1;
		} else {
			class297 var12;
			if (var0 == CS2Opcodes.CC_SETTEXTFONT) {
				var4.field3521 = class57.field404[--class387.field4452];
				if (var4.field3462 == 12) {
					var12 = var4.method5877();
					if (var12 != null) {
						var12.method5576();
					}
				}

				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETTEXTALIGN) {
				class387.field4452 -= 3;
				if (var4.field3462 == 12) {
					var12 = var4.method5877();
					if (null != var12) {
						var12.method5570(class57.field404[class387.field4452], class57.field404[class387.field4452 + 1]);
						var12.method5571(class57.field404[class387.field4452 + 2]);
					}
				} else {
					var4.field3525 = class57.field404[class387.field4452];
					var4.field3572 = class57.field404[1 + class387.field4452];
					var4.field3524 = class57.field404[class387.field4452 + 2];
				}

				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETTEXTSHADOW) {
				var4.field3488 = class57.field404[--class387.field4452] == 1;
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETOUTLINE) {
				var4.field3500 = class57.field404[--class387.field4452];
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETGRAPHICSHADOW) {
				var4.field3501 = class57.field404[--class387.field4452];
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETVFLIP) {
				var4.field3467 = class57.field404[--class387.field4452] == 1;
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETHFLIP) {
				var4.field3503 = class57.field404[--class387.field4452] == 1;
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETSCROLLSIZE) {
				class387.field4452 -= 2;
				var4.field3483 = class57.field404[class387.field4452];
				var4.field3492 = class57.field404[1 + class387.field4452];
				class136.method2438(var4);
				if (var5 != -1 && var4.field3462 == 0) {
					class26.method349(class300.field3593[var5 >> 16], var4, false);
				}

				return 1;
			} else if (var0 == CS2Opcodes.CC_RESUME_PAUSEBUTTON) {
				client.method7985(var4.field3517, var4.field3484);
				client.field1641 = var4;
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETCLICKMASK) {
				var4.field3496 = class57.field404[--class387.field4452];
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETFILLCOLOUR) {
				var4.field3495 = class57.field404[--class387.field4452];
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETFILLGRADIENT) {
				var4.field3588 = class57.field404[--class387.field4452];
				class136.method2438(var4);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETFILLMODE) {
				var11 = class57.field404[--class387.field4452];
				class469 var13 = (class469)class217.method4362(class469.method6570(), var11);
				if (var13 != null) {
					var4.field3490 = var13;
					class136.method2438(var4);
				}

				return 1;
			} else {
				boolean var6;
				if (var0 == CS2Opcodes.CC_SETLINEDIRECTION) {
					var6 = class57.field404[--class387.field4452] == 1;
					var4.field3494 = var6;
					return 1;
				} else if (var0 == CS2Opcodes.CC_SETMODELTRANSPARENT) {
					var6 = class57.field404[--class387.field4452] == 1;
					var4.field3519 = var6;
					return 1;
				} else if (var0 == CS2Opcodes.CC_SETHTTPSPRITE) {
					var4.field3497 = class57.field405[--class126.field1220];
					class136.method2438(var4);
					return 1;
				} else if (var0 == CS2Opcodes.CC_SETCRM_URL) {
					var4.method5863(class57.field405[--class126.field1220], class28.urlRequester, client.method2417());
					return 1;
				} else if (var0 == CS2Opcodes.CC_SETCRM_TEXTFONT) {
					class387.field4452 -= 2;
					var4.method5875(class57.field404[class387.field4452], class57.field404[class387.field4452 + 1]);
					return 1;
				} else if (var0 == CS2Opcodes.CC_SETCRM_SERVERTARGETS) {
					var4.method5866(class57.field405[--class126.field1220], class57.field404[--class387.field4452]);
					return 1;
				} else {
					class302 var14;
					if (var0 == 1133) {
						--class387.field4452;
						var14 = var4.method5954();
						if (var14 != null) {
							var14.field3617 = class57.field404[class387.field4452];
							class136.method2438(var4);
						}

						return 1;
					} else if (var0 == 1134) {
						--class387.field4452;
						var14 = var4.method5954();
						if (var14 != null) {
							var14.field3619 = class57.field404[class387.field4452];
							class136.method2438(var4);
						}

						return 1;
					} else if (var0 == 1135) {
						--class126.field1220;
						var12 = var4.method5877();
						if (null != var12) {
							var4.field3523 = class57.field405[class126.field1220];
						}

						return 1;
					} else if (var0 == 1136) {
						--class387.field4452;
						var14 = var4.method5954();
						if (var14 != null) {
							var14.field3618 = class57.field404[class387.field4452];
							class136.method2438(var4);
						}

						return 1;
					} else if (var0 == 1137) {
						--class387.field4452;
						var12 = var4.method5877();
						if (null != var12 && var12.method5566(class57.field404[class387.field4452])) {
							class136.method2438(var4);
						}

						return 1;
					} else if (var0 == 1138) {
						--class387.field4452;
						var12 = var4.method5877();
						if (null != var12 && var12.method5567(class57.field404[class387.field4452])) {
							class136.method2438(var4);
						}

						return 1;
					} else if (var0 == 1139) {
						--class387.field4452;
						var12 = var4.method5877();
						if (var12 != null && var12.method5568(class57.field404[class387.field4452])) {
							class136.method2438(var4);
						}

						return 1;
					} else {
						class297 var10;
						if (var0 == 1140) {
							var6 = class57.field404[--class387.field4452] == 1;
							client.field1877.method3521();
							var10 = var4.method5877();
							if (null != var10 && var10.method5560(var6)) {
								if (var6) {
									client.field1877.method3515(var4);
								}

								class136.method2438(var4);
							}

							return 1;
						} else if (var0 == 1141) {
							var6 = class57.field404[--class387.field4452] == 1;
							if (!var6 && client.field1877.method3516() == var4) {
								client.field1877.method3521();
								class136.method2438(var4);
							}

							var10 = var4.method5877();
							if (var10 != null) {
								var10.method5636(var6);
							}

							return 1;
						} else if (var0 == 1142) {
							class387.field4452 -= 2;
							var12 = var4.method5877();
							if (null != var12 && var12.method5584(class57.field404[class387.field4452], class57.field404[1 + class387.field4452])) {
								class136.method2438(var4);
							}

							return 1;
						} else if (var0 == 1143) {
							--class387.field4452;
							var12 = var4.method5877();
							if (null != var12 && var12.method5584(class57.field404[class387.field4452], class57.field404[class387.field4452])) {
								class136.method2438(var4);
							}

							return 1;
						} else if (var0 == 1144) {
							--class387.field4452;
							var12 = var4.method5877();
							if (var12 != null) {
								var12.method5573(class57.field404[class387.field4452]);
								class136.method2438(var4);
							}

							return 1;
						} else if (var0 == 1145) {
							--class387.field4452;
							var12 = var4.method5877();
							if (null != var12) {
								var12.method5572(class57.field404[class387.field4452]);
							}

							return 1;
						} else if (var0 == 1146) {
							--class387.field4452;
							var12 = var4.method5877();
							if (var12 != null) {
								var12.method5729(class57.field404[class387.field4452]);
							}

							return 1;
						} else if (var0 == 1147) {
							--class387.field4452;
							var12 = var4.method5877();
							if (null != var12) {
								var12.method5574(class57.field404[class387.field4452]);
								class136.method2438(var4);
							}

							return 1;
						} else {
							class34 var9;
							if (var0 == 1148) {
								class387.field4452 -= 2;
								var9 = var4.method5879();
								if (var9 != null) {
									var9.method615(class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
								}

								return 1;
							} else if (var0 == 1149) {
								class387.field4452 -= 2;
								var9 = var4.method5879();
								if (null != var9) {
									var9.method616((char)class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
								}

								return 1;
							} else {
								return 2;
							}
						}
					}
				}
			}
		}
	}
}
