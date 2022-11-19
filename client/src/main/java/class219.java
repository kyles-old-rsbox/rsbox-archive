import client.Client;

public final class class219 {
	static class300 field2616;
	static class300 field2617;
	int field2598;
	int field2599;
	int field2600;
	int field2601;
	int field2602;
	int field2603;
	int field2605;
	int field2606;
	int field2607;
	int field2608;
	int field2609;
	int field2610;
	int field2611;
	int field2612;
	int field2613;
	int field2614;
	int field2615;
	int field2618;

	class219() {
	}

	static final void method4370(class90 var0) {
		boolean var2 = var0.field858 == Client.field1645 || -1 == var0.field852 || 0 != var0.field804;
		if (!var2) {
			class189 var3 = class160.method2660(var0.field852);
			if (null != var3 && !var3.method3486()) {
				var2 = var0.field845 + 1 > var3.field2000[var0.field844];
			} else {
				var2 = true;
			}
		}

		if (var2) {
			int var9 = var0.field858 - var0.field857;
			int var4 = Client.field1645 - var0.field857;
			int var5 = var0.field866 * 64 + var0.field815 * 128;
			int var6 = var0.field855 * 128 + var0.field866 * 64;
			int var7 = var0.field854 * 128 + var0.field866 * 64;
			int var8 = var0.field866 * 64 + var0.field853 * 128;
			var0.field827 = (var7 * var4 + (var9 - var4) * var5) / var9;
			var0.field802 = (var6 * (var9 - var4) + var4 * var8) / var9;
		}

		var0.field837 = 0;
		var0.field860 = var0.field859;
		var0.field826 = var0.field860;
	}
}
