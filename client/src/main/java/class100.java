final class class100 implements class301 {
	static long field987;
	// $FF: synthetic field
	final class300 val$cc;

	class100(class300 var1) {
		this.val$cc = var1;
	}

	public void method5987() {
		if (null != this.val$cc && this.val$cc.method5880().field3686 != null) {
			ClientScript var2 = new ClientScript();
			var2.method1599(this.val$cc);
			var2.method1602(this.val$cc.method5880().field3686);
			client.method7851().method6355(var2);
		}

	}

	static int method1986(int var0, class78 var1, boolean var2) {
		class300 var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = class282.method5426(class57.field404[--class387.field4452]);
		} else {
			var4 = var2 ? class138.field1284 : class153.field1414;
		}

		class136.method2438(var4);
		if (var0 != CS2Opcodes.CC_SETOBJECT && var0 != CS2Opcodes.CC_SETOBJECT_NONUM && var0 != CS2Opcodes.CC_SETOBJECT_ALWAYS_NUM) {
			if (var0 == CS2Opcodes.CC_SETNPCHEAD) {
				var4.field3504 = 2;
				var4.field3505 = class57.field404[--class387.field4452];
				return 1;
			} else if (var0 == CS2Opcodes.CC_SETPLAYERHEAD_SELF) {
				var4.field3504 = 3;
				var4.field3505 = class291.localPlayer.appearance.method6029();
				return 1;
			} else {
				return 2;
			}
		} else {
			class387.field4452 -= 2;
			int var5 = class57.field404[class387.field4452];
			int var6 = class57.field404[1 + class387.field4452];
			var4.field3445 = var5;
			var4.field3599 = var6;
			class198 var7 = class278.method5388(var5);
			var4.field3601 = var7.field2137;
			var4.field3513 = var7.field2138;
			var4.field3514 = var7.field2139;
			var4.field3510 = var7.field2140;
			var4.field3548 = var7.field2128;
			var4.field3562 = var7.field2144;
			if (var0 == CS2Opcodes.CC_SETOBJECT_NONUM) {
				var4.field3520 = 0;
			} else if (var0 == CS2Opcodes.CC_SETOBJECT_ALWAYS_NUM | var7.field2142 == 1) {
				var4.field3520 = 1;
			} else {
				var4.field3520 = 2;
			}

			if (var4.field3516 > 0) {
				var4.field3562 = var4.field3562 * 32 / var4.field3516;
			} else if (var4.field3486 > 0) {
				var4.field3562 = var4.field3562 * 32 / var4.field3486;
			}

			return 1;
		}
	}

	static void method1993(int var0, int var1, int var2) {
		if (var0 != 0) {
			int var4 = var0 >> 8;
			int var5 = var0 >> 4 & 7;
			int var6 = var0 & 15;
			client.field1895[client.soundEffectCount] = var4;
			client.field1896[client.soundEffectCount] = var5;
			client.field1897[client.soundEffectCount] = 0;
			client.field1899[client.soundEffectCount] = null;
			int var7 = (var1 - 64) / 128;
			int var8 = (var2 - 64) / 128;
			client.field1734[client.soundEffectCount] = var6 + (var7 << 16) + (var8 << 8);
			++client.soundEffectCount;
		}
	}

	static void method1989() {
		if (client.isSpellSelected) {
			class300 var1 = class253.method5043(class106.field1066, client.field1805);
			if (null != var1 && null != var1.field3598) {
				ClientScript var2 = new ClientScript();
				var2.field694 = var1;
				var2.args = var1.field3598;
				class57.runClientScript(var2);
			}

			client.field1806 = -1;
			client.isSpellSelected = false;
			class136.method2438(var1);
		}
	}
}
