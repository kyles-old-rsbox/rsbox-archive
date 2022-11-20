public class class141 implements class360 {
	public static class292 field1300;
	public static final class141 field1301;
	public static final class141 field1302;
	public static final class141 field1303;
	public static final class141 field1304;
	public static final class141 field1306;
	static int js5Port;
	final int field1308;
	public final int field1305;

	static {
		field1302 = new class141(0, 0);
		field1306 = new class141(1, 1);
		field1301 = new class141(4, 2);
		field1303 = new class141(3, 3);
		field1304 = new class141(2, 4);
	}

	class141(int var1, int var2) {
		this.field1305 = var1;
		this.field1308 = var2;
	}

	public int rsOrdinal() {
		return this.field1308;
	}

	static boolean method2474(int var0, int var1) {
		return var0 != 4 || var1 < 8;
	}

	static int method2477(int var0, class78 var1, boolean var2) {
		class300 var4 = var2 ? class138.field1284 : class153.field1414;
		if (var0 == CS2Opcodes.CC_GETSCROLLX) {
			class57.field404[++class387.field4452 - 1] = var4.field3481;
			return 1;
		} else if (var0 == CS2Opcodes.CC_GETSCROLLY) {
			class57.field404[++class387.field4452 - 1] = var4.field3482;
			return 1;
		} else {
			class297 var8;
			if (var0 == CS2Opcodes.CC_GETTEXT) {
				if (var4.field3462 == 12) {
					var8 = var4.method5877();
					if (var8 != null) {
						class57.field405[++class126.field1220 - 1] = var8.method5755().method7028();
						return 1;
					}
				}

				class57.field405[++class126.field1220 - 1] = var4.field3522;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETSCROLLWIDTH) {
				class57.field404[++class387.field4452 - 1] = var4.field3483;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETSCROLLHEIGHT) {
				class57.field404[++class387.field4452 - 1] = var4.field3492;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETMODELZOOM) {
				class57.field404[++class387.field4452 - 1] = var4.field3562;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETMODELANGLE_X) {
				class57.field404[++class387.field4452 - 1] = var4.field3601;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETMODELANGLE_Z) {
				class57.field404[++class387.field4452 - 1] = var4.field3514;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETMODELANGLE_Y) {
				class57.field404[++class387.field4452 - 1] = var4.field3513;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETTRANS) {
				class57.field404[++class387.field4452 - 1] = var4.field3612;
				return 1;
			} else if (var0 == CS2Opcodes._1610) {
				class57.field404[++class387.field4452 - 1] = var4.field3588;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETCOLOUR) {
				class57.field404[++class387.field4452 - 1] = var4.field3485;
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETFILLCOLOUR) {
				class57.field404[++class387.field4452 - 1] = var4.field3495;
				return 1;
			} else if (var0 == CS2Opcodes._1613) {
				class57.field404[++class387.field4452 - 1] = var4.field3490.rsOrdinal();
				return 1;
			} else if (var0 == CS2Opcodes.CC_GETMODELTRANSPARENT) {
				class57.field404[++class387.field4452 - 1] = var4.field3519 ? 1 : 0;
				return 1;
			} else {
				class302 var5;
				if (var0 == CS2Opcodes.CC_INPUTUNK1) {
					var5 = var4.method5954();
					class57.field404[++class387.field4452 - 1] = var5 != null ? var5.field3617 : 0;
				}

				if (var0 == CS2Opcodes.CC_INPUTUNK2) {
					var5 = var4.method5954();
					class57.field404[++class387.field4452 - 1] = var5 != null ? var5.field3619 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK1) {
					var8 = var4.method5877();
					class57.field405[++class126.field1220 - 1] = null != var8 ? var8.method5609().method7028() : "";
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK2) {
					var5 = var4.method5954();
					class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3618 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK3) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5619() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK4) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5620() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK5) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5621() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK6) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = null != var8 && var8.method5593() ? 1 : 0;
					return 1;
				} else if (var0 != CS2Opcodes.CC_INPUTFIELDUNK7) {
					if (var0 == CS2Opcodes.CC_INPUTFIELDUNK8) {
						var8 = var4.method5877();
						class57.field405[++class126.field1220 - 1] = var8 != null ? var8.method5610().method7012() : "";
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK9) {
						var8 = var4.method5877();
						int var6 = var8 != null ? var8.method5691() : 0;
						int var7 = null != var8 ? var8.method5614() : 0;
						class57.field404[++class387.field4452 - 1] = Math.min(var6, var7);
						class57.field404[++class387.field4452 - 1] = Math.max(var6, var7);
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK10) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5614() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK11) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5823() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK12) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5622() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK13) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5747() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK14) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5625() : 0;
						return 1;
					} else {
						class34 var9;
						if (var0 == CS2Opcodes.CC_INPUTFIELDUNK15) {
							var9 = var4.method5879();
							class57.field404[class387.field4452 - 1] = var9 != null ? var9.method617(class57.field404[class387.field4452 - 1]) : 0;
							return 1;
						} else if (var0 == CS2Opcodes.CC_INPUTFIELDUNK16) {
							var9 = var4.method5879();
							class57.field404[class387.field4452 - 1] = null != var9 ? var9.method618((char)class57.field404[class387.field4452 - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null && var8.method5612() ? 1 : 0;
					return 1;
				}
			}
		}
	}

	static int method2478(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.CLIENTVARP_MOUSEBUTTONMODE) {
			boolean var4 = class57.field404[--class387.field4452] == 1;
			client.method197(var4);
			return 1;
		} else {
			return 2;
		}
	}
}
