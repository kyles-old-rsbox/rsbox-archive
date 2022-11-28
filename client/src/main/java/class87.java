public class class87 extends class427 {
	static boolean field781;
	static NodeHashTable field782;
	int[] field779;
	int[] field783;

	static {
		field782 = new NodeHashTable(32);
	}

	class87() {
		this.field779 = new int[]{-1};
		this.field783 = new int[]{0};
	}

	public static boolean method1851(int var0) {
		return class306.field3669.field3670 == var0;
	}

	static void method2410() {
		field782 = new NodeHashTable(32);
	}

	static class121 method1855(int var0) {
		class121 var2 = (class121)class217.fromValue(class121.method135(), var0);
		if (var2 == null) {
			var2 = class121.field1170;
		}

		return var2;
	}

	static int method1849(int var0, class78 var1, boolean var2) {
		boolean var4 = true;
		class300 var5;
		if (var0 >= 2000) {
			var0 -= 1000;
			var5 = class282.method5426(class57.field404[--class387.field4452]);
			var4 = false;
		} else {
			var5 = var2 ? class138.field1284 : class153.field1414;
		}

		int var12;
		if (var0 == CS2Opcodes.CC_SETOP) {
			var12 = class57.field404[--class387.field4452] - 1;
			if (var12 >= 0 && var12 <= 9) {
				var5.method5860(var12, class57.field405[--class126.field1220]);
				return 1;
			} else {
				--class126.field1220;
				return 1;
			}
		} else {
			int var7;
			if (var0 == CS2Opcodes.CC_SETDRAGGABLE) {
				class387.field4452 -= 2;
				var12 = class57.field404[class387.field4452];
				var7 = class57.field404[1 + class387.field4452];
				var5.field3547 = class253.method5043(var12, var7);
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETDRAGGABLEBEHAVIOR) {
				var5.field3550 = class57.field404[--class387.field4452] == 1;
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETDRAGDEADZONE) {
				var5.field3600 = class57.field404[--class387.field4452];
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETDRAGDEADTIME) {
				var5.field3604 = class57.field404[--class387.field4452];
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETOPBASE) {
				var5.field3545 = class57.field405[--class126.field1220];
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETTARGETVERB) {
				var5.field3515 = class57.field405[--class126.field1220];
				return 1;
			} else if (var0 == CS2Opcodes.CC_CLEAROPS) {
				var5.field3546 = null;
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETSHIFTCLICKOP) {
				var5.field3614 = class57.field404[--class387.field4452] == 1;
				return 1;
			} else if (var0 == CS2Opcodes._1309) {
				--class387.field4452;
				return 1;
			} else {
				int var8;
				byte[] var10;
				if (var0 != CS2Opcodes.CC_SETOPKEY) {
					byte var6;
					if (var0 == CS2Opcodes.CC_SETOPTKEY) {
						class387.field4452 -= 2;
						var6 = 10;
						var10 = new byte[]{(byte)class57.field404[class387.field4452]};
						byte[] var11 = new byte[]{(byte)class57.field404[1 + class387.field4452]};
						class227.method4512(var5, var6, var10, var11);
						return 1;
					} else if (var0 == CS2Opcodes.CC_SETOPKEYRATE) {
						class387.field4452 -= 3;
						var12 = class57.field404[class387.field4452] - 1;
						var7 = class57.field404[class387.field4452 + 1];
						var8 = class57.field404[2 + class387.field4452];
						if (var12 >= 0 && var12 <= 9) {
							class57.method2259(var5, var12, var7, var8);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == CS2Opcodes.CC_SETOPTKEYRATE) {
						var6 = 10;
						var7 = class57.field404[--class387.field4452];
						var8 = class57.field404[--class387.field4452];
						class57.method2259(var5, var6, var7, var8);
						return 1;
					} else if (var0 == CS2Opcodes.CC_SETOPKEYIGNOREHELD) {
						--class387.field4452;
						var12 = class57.field404[class387.field4452] - 1;
						if (var12 >= 0 && var12 <= 9) {
							class57.method6459(var5, var12);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == CS2Opcodes.CC_SETOPTKEYIGNOREHELD) {
						var6 = 10;
						class57.method6459(var5, var6);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var9 = null;
					var10 = null;
					if (var4) {
						class387.field4452 -= 10;

						for (var8 = 0; var8 < 10 && class57.field404[var8 + class387.field4452] >= 0; var8 += 2) {
						}

						if (var8 > 0) {
							var9 = new byte[var8 / 2];
							var10 = new byte[var8 / 2];

							for (var8 -= 2; var8 >= 0; var8 -= 2) {
								var9[var8 / 2] = (byte)class57.field404[var8 + class387.field4452];
								var10[var8 / 2] = (byte)class57.field404[1 + var8 + class387.field4452];
							}
						}
					} else {
						class387.field4452 -= 2;
						var9 = new byte[]{(byte)class57.field404[class387.field4452]};
						var10 = new byte[]{(byte)class57.field404[class387.field4452 + 1]};
					}

					var8 = class57.field404[--class387.field4452] - 1;
					if (var8 >= 0 && var8 <= 9) {
						class227.method4512(var5, var8, var9, var10);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}
}
