import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class class83 {
	static int field732;
	boolean field730;
	boolean field733;
	boolean field735;
	boolean field741;
	double field737;
	int field731;
	int field736;
	int field738;
	int field739;
	int field740;
	int field743;
	String field742;
	LinkedHashMap parameters;

	static {
		field732 = 10;
	}

	class83() {
		this.field733 = false;
		this.field735 = false;
		this.field737 = 0.8D;
		this.field731 = 127;
		this.field738 = 127;
		this.field740 = 127;
		this.field739 = -1;
		this.field742 = null;
		this.field743 = 1;
		this.parameters = new LinkedHashMap();
		this.method1701(true);
	}

	class83(Buffer var1) {
		this.field733 = false;
		this.field735 = false;
		this.field737 = 0.8D;
		this.field731 = 127;
		this.field738 = 127;
		this.field740 = 127;
		this.field739 = -1;
		this.field742 = null;
		this.field743 = 1;
		this.parameters = new LinkedHashMap();
		if (var1 != null && var1.data != null) {
			int var2 = var1.readUnsignedByte();
			if (var2 >= 0 && var2 <= field732) {
				if (var1.readUnsignedByte() == 1) {
					this.field730 = true;
				}

				if (var2 > 1) {
					this.field741 = var1.readUnsignedByte() == 1;
				}

				if (var2 > 3) {
					this.field743 = var1.readUnsignedByte();
				}

				if (var2 > 2) {
					int var3 = var1.readUnsignedByte();

					for (int var4 = 0; var4 < var3; ++var4) {
						int var5 = var1.readInt();
						int var6 = var1.readInt();
						this.parameters.put(var5, var6);
					}
				}

				if (var2 > 4) {
					this.field742 = var1.method8305();
				}

				if (var2 > 5) {
					this.field733 = var1.readBoolean();
				}

				if (var2 > 6) {
					this.field737 = (double)var1.readUnsignedByte() / 100.0D;
					this.field731 = var1.readUnsignedByte();
					this.field738 = var1.readUnsignedByte();
					this.field740 = var1.readUnsignedByte();
				}

				if (var2 > 7) {
					this.field739 = var1.readUnsignedByte();
				}

				if (var2 > 8) {
					this.field735 = var1.readUnsignedByte() == 1;
				}

				if (var2 > 9) {
					this.field736 = var1.readInt();
				}
			} else {
				this.method1701(true);
			}
		} else {
			this.method1701(true);
		}

	}

	void method1701(boolean var1) {
	}

	Buffer method1702() {
		Buffer var2 = new Buffer(100);
		var2.writeByte(field732);
		var2.writeByte(this.field730 ? 1 : 0);
		var2.writeByte(this.field741 ? 1 : 0);
		var2.writeByte(this.field743);
		var2.writeByte(this.parameters.size());
		Iterator var3 = this.parameters.entrySet().iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry)var3.next();
			var2.writeInt((Integer)var4.getKey());
			var2.writeInt((Integer)var4.getValue());
		}

		var2.writeString(this.field742 != null ? this.field742 : "");
		var2.method8110(this.field733);
		var2.writeByte((int)(this.field737 * 100.0D));
		var2.writeByte(this.field731);
		var2.writeByte(this.field738);
		var2.writeByte(this.field740);
		var2.writeByte(this.field739);
		var2.writeByte(this.field735 ? 1 : 0);
		var2.writeInt(this.field736);
		return var2;
	}

	void method1703(boolean var1) {
		this.field730 = var1;
		ClientPreferences.savePreferences();
	}

	boolean method1777() {
		return this.field730;
	}

	void method1755(boolean var1) {
		this.field733 = var1;
		ClientPreferences.savePreferences();
	}

	boolean method1706() {
		return this.field733;
	}

	void method1707(boolean var1) {
		this.field741 = var1;
		ClientPreferences.savePreferences();
	}

	boolean method1708() {
		return this.field741;
	}

	void method1709(boolean var1) {
		this.field735 = var1;
		ClientPreferences.savePreferences();
	}

	void method1759() {
		this.method1709(!this.field735);
	}

	boolean method1711() {
		return this.field735;
	}

	void method1712(int var1) {
		this.field736 = var1;
		ClientPreferences.savePreferences();
	}

	int method1766() {
		return this.field736;
	}

	void method1714(double var1) {
		this.field737 = var1;
		ClientPreferences.savePreferences();
	}

	double method1717() {
		return this.field737;
	}

	void method1715(int var1) {
		this.field731 = var1;
		ClientPreferences.savePreferences();
	}

	int method1716() {
		return this.field731;
	}

	void method1704(int var1) {
		this.field738 = var1;
		ClientPreferences.savePreferences();
	}

	int method1752() {
		return this.field738;
	}

	void method1719(int var1) {
		this.field740 = var1;
		ClientPreferences.savePreferences();
	}

	int method1736() {
		return this.field740;
	}

	void setRememberedUsername(String var1) {
		this.field742 = var1;
		ClientPreferences.savePreferences();
	}

	String method1722() {
		return this.field742;
	}

	void method1723(int var1) {
		this.field739 = var1;
		ClientPreferences.savePreferences();
	}

	int method1797() {
		return this.field739;
	}

	void method1778(int var1) {
		this.field743 = var1;
		ClientPreferences.savePreferences();
	}

	int method1726() {
		return this.field743;
	}

	static int method1796(int var0, class78 var1, boolean var2) {
		class300 var4 = class282.method5426(class57.field404[--class387.field4452]);
		if (var0 == CS2Opcodes.IF_GETSCROLLX) {
			class57.field404[++class387.field4452 - 1] = var4.field3481;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETSCROLLY) {
			class57.field404[++class387.field4452 - 1] = var4.field3482;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETTEXT) {
			class57.field405[++class126.field1220 - 1] = var4.field3522;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETSCROLLWIDTH) {
			class57.field404[++class387.field4452 - 1] = var4.field3483;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETSCROLLHEIGHT) {
			class57.field404[++class387.field4452 - 1] = var4.field3492;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETMODELZOOM) {
			class57.field404[++class387.field4452 - 1] = var4.field3562;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETMODELANGLE_X) {
			class57.field404[++class387.field4452 - 1] = var4.field3601;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETMODELANGLE_Z) {
			class57.field404[++class387.field4452 - 1] = var4.field3514;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETMODELANGLE_Y) {
			class57.field404[++class387.field4452 - 1] = var4.field3513;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETTRANS) {
			class57.field404[++class387.field4452 - 1] = var4.field3612;
			return 1;
		} else if (var0 == CS2Opcodes._2610) {
			class57.field404[++class387.field4452 - 1] = var4.field3588;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETCOLOUR) {
			class57.field404[++class387.field4452 - 1] = var4.field3485;
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETFILLCOLOUR) {
			class57.field404[++class387.field4452 - 1] = var4.field3495;
			return 1;
		} else if (var0 == CS2Opcodes._2613) {
			class57.field404[++class387.field4452 - 1] = var4.field3490.rsOrdinal();
			return 1;
		} else if (var0 == CS2Opcodes.IF_GETMODELTRANSPARENT) {
			class57.field404[++class387.field4452 - 1] = var4.field3519 ? 1 : 0;
			return 1;
		} else {
			class302 var5;
			if (var0 == CS2Opcodes.IF_INPUTUNK1) {
				var5 = var4.method5954();
				class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3617 : 0;
			}

			if (var0 == CS2Opcodes.IF_INPUTUNK2) {
				var5 = var4.method5954();
				class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3619 : 0;
				return 1;
			} else {
				class297 var8;
				if (var0 == CS2Opcodes.IF_INPUTFIELDUNK1) {
					var8 = var4.method5877();
					class57.field405[++class126.field1220 - 1] = var8 != null ? var8.method5609().method7028() : "";
					return 1;
				} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK2) {
					var5 = var4.method5954();
					class57.field404[++class387.field4452 - 1] = null != var5 ? var5.field3618 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK3) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5619() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK4) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5620() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK5) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5621() : 0;
					return 1;
				} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK6) {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = null != var8 && var8.method5593() ? 1 : 0;
					return 1;
				} else if (var0 != CS2Opcodes.IF_INPUTFIELDUNK7) {
					if (var0 == CS2Opcodes.IF_INPUTFIELDUNK8) {
						var8 = var4.method5877();
						class57.field405[++class126.field1220 - 1] = null != var8 ? var8.method5610().method7012() : "";
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK9) {
						var8 = var4.method5877();
						int var6 = var8 != null ? var8.method5691() : 0;
						int var7 = null != var8 ? var8.method5614() : 0;
						class57.field404[++class387.field4452 - 1] = Math.min(var6, var7);
						class57.field404[++class387.field4452 - 1] = Math.max(var6, var7);
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK10) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5614() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK11) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5823() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK12) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5622() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK13) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = null != var8 ? var8.method5747() : 0;
						return 1;
					} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK14) {
						var8 = var4.method5877();
						class57.field404[++class387.field4452 - 1] = var8 != null ? var8.method5625() : 0;
						return 1;
					} else {
						class34 var9;
						if (var0 == CS2Opcodes.IF_INPUTFIELDUNK15) {
							var9 = var4.method5879();
							class57.field404[class387.field4452 - 1] = null != var9 ? var9.method617(class57.field404[class387.field4452 - 1]) : 0;
							return 1;
						} else if (var0 == CS2Opcodes.IF_INPUTFIELDUNK16) {
							var9 = var4.method5879();
							class57.field404[class387.field4452 - 1] = null != var9 ? var9.method618((char)class57.field404[class387.field4452 - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var8 = var4.method5877();
					class57.field404[++class387.field4452 - 1] = null != var8 && var8.method5612() ? 1 : 0;
					return 1;
				}
			}
		}
	}

	static final void method1795(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var9 = var6 - 334;
		if (var9 < 0) {
			var9 = 0;
		} else if (var9 > 100) {
			var9 = 100;
		}

		int var10 = client.field1909 + var9 * (client.field1801 - client.field1909) / 100;
		int var8 = var5 * var10 / 256;
		var9 = 2048 - var3 & 2047;
		var10 = 2048 - var4 & 2047;
		int var11 = 0;
		int var12 = 0;
		int var13 = var8;
		int var14;
		int var15;
		int var16;
		if (var9 != 0) {
			var14 = class221.field2644[var9];
			var15 = class221.field2645[var9];
			var16 = var15 * var12 - var14 * var8 >> 16;
			var13 = var14 * var12 + var8 * var15 >> 16;
			var12 = var16;
		}

		if (var10 != 0) {
			var14 = class221.field2644[var10];
			var15 = class221.field2645[var10];
			var16 = var15 * var11 + var14 * var13 >> 16;
			var13 = var13 * var15 - var14 * var11 >> 16;
			var11 = var16;
		}

		if (client.field1900) {
			class226.field2706 = var0 - var11;
			class94.field938 = var1 - var12;
			class302.field3620 = var2 - var13;
			class300.field3615 = var3;
			class32.field206 = var4;
		} else {
			class215.field2568 = var0 - var11;
			class32.field204 = var1 - var12;
			class323.field3766 = var2 - var13;
			class414.field4588 = var3;
			class237.field2807 = var4;
		}

		if (1 == client.field1722 && client.privilegeLevel >= 2 && 0 == client.field1645 % 50 && (class291.localPlayer.field827 >> 7 != class32.field203 >> 7 || class101.field1004 >> 7 != class291.localPlayer.field802 >> 7)) {
			var14 = class291.localPlayer.field914;
			var15 = (class32.field203 >> 7) + class36.sceneBaseX;
			var16 = class169.sceneBaseY + (class101.field1004 >> 7);
			class136.method2439(var15, var16, var14, true);
		}

	}

	static final void method1761(class300[] var0, int var1) {
		for (int var3 = 0; var3 < var0.length; ++var3) {
			class300 var4 = var0[var3];
			if (null != var4) {
				if (0 == var4.field3462) {
					if (null != var4.field3602) {
						method1761(var4.field3602, var1);
					}

					InterfaceParent var5 = (InterfaceParent)client.parentInterfaces.method7855((long)var4.field3517);
					if (null != var5) {
						class217.method4361(var5.field796, var1);
					}
				}

				ClientScript var6;
				if (var1 == 0 && var4.field3584 != null) {
					var6 = new ClientScript();
					var6.field694 = var4;
					var6.args = var4.field3584;
					class57.runClientScript(var6);
				}

				if (var1 == 1 && null != var4.field3479) {
					if (var4.field3484 >= 0) {
						class300 var7 = class282.method5426(var4.field3517);
						if (var7 == null || var7.field3602 == null || var4.field3484 >= var7.field3602.length || var7.field3602[var4.field3484] != var4) {
							continue;
						}
					}

					var6 = new ClientScript();
					var6.field694 = var4;
					var6.args = var4.field3479;
					class57.runClientScript(var6);
				}
			}
		}

	}
}
