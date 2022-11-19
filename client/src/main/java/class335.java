import client.Client;

public class class335 extends class437 {
	public static class348 field3867;
	public byte field3868;
	public class336 field3866;
	public int field3865;

	class335() {
	}

	static final int method6272() {
		if (class413.field4575.method1777()) {
			return class55.field396;
		} else {
			int var1 = 3;
			if (class414.field4588 < 310) {
				int var2;
				int var3;
				if (Client.field1722 == 1) {
					var2 = class32.field203 >> 7;
					var3 = class101.field1004 >> 7;
				} else {
					var2 = class291.field3364.field827 >> 7;
					var3 = class291.field3364.field802 >> 7;
				}

				int var4 = class215.field2568 >> 7;
				int var5 = class323.field3766 >> 7;
				if (var4 < 0 || var5 < 0 || var4 >= 104 || var5 >= 104) {
					return class55.field396;
				}

				if (var2 < 0 || var3 < 0 || var2 >= 104 || var3 >= 104) {
					return class55.field396;
				}

				if (0 != (class82.field714[class55.field396][var4][var5] & 4)) {
					var1 = class55.field396;
				}

				int var6;
				if (var2 > var4) {
					var6 = var2 - var4;
				} else {
					var6 = var4 - var2;
				}

				int var7;
				if (var3 > var5) {
					var7 = var3 - var5;
				} else {
					var7 = var5 - var3;
				}

				int var8;
				int var9;
				if (var6 > var7) {
					var8 = var7 * 65536 / var6;
					var9 = 32768;

					while (var2 != var4) {
						if (var4 < var2) {
							++var4;
						} else if (var4 > var2) {
							--var4;
						}

						if (0 != (class82.field714[class55.field396][var4][var5] & 4)) {
							var1 = class55.field396;
						}

						var9 += var8;
						if (var9 >= 65536) {
							var9 -= 65536;
							if (var5 < var3) {
								++var5;
							} else if (var5 > var3) {
								--var5;
							}

							if (0 != (class82.field714[class55.field396][var4][var5] & 4)) {
								var1 = class55.field396;
							}
						}
					}
				} else if (var7 > 0) {
					var8 = var6 * 65536 / var7;
					var9 = 32768;

					while (var3 != var5) {
						if (var5 < var3) {
							++var5;
						} else if (var5 > var3) {
							--var5;
						}

						if (0 != (class82.field714[class55.field396][var4][var5] & 4)) {
							var1 = class55.field396;
						}

						var9 += var8;
						if (var9 >= 65536) {
							var9 -= 65536;
							if (var4 < var2) {
								++var4;
							} else if (var4 > var2) {
								--var4;
							}

							if (0 != (class82.field714[class55.field396][var4][var5] & 4)) {
								var1 = class55.field396;
							}
						}
					}
				}
			}

			if (class291.field3364.field827 >= 0 && class291.field3364.field802 >= 0 && class291.field3364.field827 < 13312 && class291.field3364.field802 < 13312) {
				if ((class82.field714[class55.field396][class291.field3364.field827 >> 7][class291.field3364.field802 >> 7] & 4) != 0) {
					var1 = class55.field396;
				}

				return var1;
			} else {
				return class55.field396;
			}
		}
	}

	static final void method6271(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		class101 var11 = null;

		for (class101 var12 = (class101) Client.field1777.method6364(); null != var12; var12 = (class101) Client.field1777.method6358()) {
			if (var0 == var12.field993 && var12.field999 == var1 && var2 == var12.field994 && var3 == var12.field992) {
				var11 = var12;
				break;
			}
		}

		if (var11 == null) {
			var11 = new class101();
			var11.field993 = var0;
			var11.field992 = var3;
			var11.field999 = var1;
			var11.field994 = var2;
			Client.method3540(var11);
			Client.field1777.method6355(var11);
		}

		var11.field998 = var4;
		var11.field1000 = var5;
		var11.field991 = var6;
		var11.field1006 = var8;
		var11.field1003 = var9;
		var11.method1995(var7);
	}
}
