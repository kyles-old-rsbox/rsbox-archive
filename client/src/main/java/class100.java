final class class100 implements class301 {
	static long field987;
	// $FF: synthetic field
	final class300 val$cc;

	class100(class300 var1) {
		this.val$cc = var1;
	}

	public void method5987() {
		if (null != this.val$cc && this.val$cc.method5880().field3686 != null) {
			class79 var2 = new class79();
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
		if (var0 != 1200 && var0 != 1205 && 1212 != var0) {
			if (1201 == var0) {
				var4.field3504 = 2;
				var4.field3505 = class57.field404[--class387.field4452];
				return 1;
			} else if (1202 == var0) {
				var4.field3504 = 3;
				var4.field3505 = class291.field3364.field911.method6029();
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
			if (var0 == 1205) {
				var4.field3520 = 0;
			} else if (1212 == var0 | var7.field2142 == 1) {
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
		if (0 != var0) {
			int var4 = var0 >> 8;
			int var5 = var0 >> 4 & 7;
			int var6 = var0 & 15;
			client.field1895[client.field1894] = var4;
			client.field1896[client.field1894] = var5;
			client.field1897[client.field1894] = 0;
			client.field1899[client.field1894] = null;
			int var7 = (var1 - 64) / 128;
			int var8 = (var2 - 64) / 128;
			client.field1734[client.field1894] = var6 + (var7 << 16) + (var8 << 8);
			++client.field1894;
		}
	}

	static void method1989() {
		if (client.field1804) {
			class300 var1 = class253.method5043(class106.field1066, client.field1805);
			if (null != var1 && null != var1.field3598) {
				class79 var2 = new class79();
				var2.field694 = var1;
				var2.field686 = var1.field3598;
				class57.method5433(var2);
			}

			client.field1806 = -1;
			client.field1804 = false;
			class136.method2438(var1);
		}
	}
}