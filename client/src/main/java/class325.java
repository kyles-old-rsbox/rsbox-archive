public class class325 {
	class325() throws Throwable {
		throw new Error();
	}

	public static int method3731(int var0, int var1) {
		return var1 + (var0 << 8);
	}

	public static int method1275(int var0, int var1) {
		return (-3 - var0 << 8) + var1;
	}

	static int method6221(int var0, class78 var1, boolean var2) {
		int var4;
		if (var0 == CS2Opcodes.OC_NAME) {
			var4 = class57.field404[--class387.field4452];
			class57.field405[++class126.field1220 - 1] = class278.method5388(var4).field2131;
			return 1;
		} else {
			int var5;
			class198 var6;
			if (var0 == CS2Opcodes.OC_OP) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class278.method5388(var4);
				if (var5 >= 1 && var5 <= 5 && null != var6.field2148[var5 - 1]) {
					class57.field405[++class126.field1220 - 1] = var6.field2148[var5 - 1];
				} else {
					class57.field405[++class126.field1220 - 1] = "";
				}

				return 1;
			} else if (var0 == CS2Opcodes.OC_IOP) {
				class387.field4452 -= 2;
				var4 = class57.field404[class387.field4452];
				var5 = class57.field404[1 + class387.field4452];
				var6 = class278.method5388(var4);
				if (var5 >= 1 && var5 <= 5 && null != var6.field2149[var5 - 1]) {
					class57.field405[++class126.field1220 - 1] = var6.field2149[var5 - 1];
				} else {
					class57.field405[++class126.field1220 - 1] = "";
				}

				return 1;
			} else if (var0 == CS2Opcodes.OC_COST) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2143;
				return 1;
			} else if (var0 == CS2Opcodes.OC_STACKABLE) {
				var4 = class57.field404[--class387.field4452];
				class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2142 == 1 ? 1 : 0;
				return 1;
			} else {
				class198 var7;
				if (var0 == CS2Opcodes.OC_CERT) {
					var4 = class57.field404[--class387.field4452];
					var7 = class278.method5388(var4);
					if (-1 == var7.field2166 && var7.field2165 >= 0) {
						class57.field404[++class387.field4452 - 1] = var7.field2165;
					} else {
						class57.field404[++class387.field4452 - 1] = var4;
					}

					return 1;
				} else if (var0 == CS2Opcodes.OC_UNCERT) {
					var4 = class57.field404[--class387.field4452];
					var7 = class278.method5388(var4);
					if (var7.field2166 >= 0 && var7.field2165 >= 0) {
						class57.field404[++class387.field4452 - 1] = var7.field2165;
					} else {
						class57.field404[++class387.field4452 - 1] = var4;
					}

					return 1;
				} else if (var0 == CS2Opcodes.OC_MEMBERS) {
					var4 = class57.field404[--class387.field4452];
					class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2162 ? 1 : 0;
					return 1;
				} else if (var0 == CS2Opcodes.OC_PLACEHOLDER) {
					var4 = class57.field404[--class387.field4452];
					var7 = class278.method5388(var4);
					if (-1 == var7.field2179 && var7.field2152 >= 0) {
						class57.field404[++class387.field4452 - 1] = var7.field2152;
					} else {
						class57.field404[++class387.field4452 - 1] = var4;
					}

					return 1;
				} else if (var0 == CS2Opcodes.OC_UNPLACEHOLDER) {
					var4 = class57.field404[--class387.field4452];
					var7 = class278.method5388(var4);
					if (var7.field2179 >= 0 && var7.field2152 >= 0) {
						class57.field404[++class387.field4452 - 1] = var7.field2152;
					} else {
						class57.field404[++class387.field4452 - 1] = var4;
					}

					return 1;
				} else if (var0 == CS2Opcodes.OC_FIND) {
					String var8 = class57.field405[--class126.field1220];
					var5 = class57.field404[--class387.field4452];
					class312.method6063(var8, var5 == 1);
					class57.field404[++class387.field4452 - 1] = class157.field1437;
					return 1;
				} else if (var0 != CS2Opcodes.OC_FINDNEXT) {
					if (var0 == CS2Opcodes.OC_FINDRESET) {
						class369.field4362 = 0;
						return 1;
					} else if (var0 == CS2Opcodes.OC_SHIFTCLICKOP) {
						var4 = class57.field404[--class387.field4452];
						var5 = class278.method5388(var4).method3658();
						if (var5 == -1) {
							class57.field404[++class387.field4452 - 1] = var5;
						} else {
							class57.field404[++class387.field4452 - 1] = var5 + 1;
						}

						return 1;
					} else if (var0 == CS2Opcodes.OC_WEARPOS) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2130;
						return 1;
					} else if (var0 == CS2Opcodes.OC_WEARPOS2) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2145;
						return 1;
					} else if (var0 == CS2Opcodes.OC_WEARPOS3) {
						var4 = class57.field404[--class387.field4452];
						class57.field404[++class387.field4452 - 1] = class278.method5388(var4).field2146;
						return 1;
					} else if (var0 == CS2Opcodes.OC_WEIGHT) {
						var4 = class57.field404[--class387.field4452];
						var7 = class278.method5388(var4);
						class57.field404[++class387.field4452 - 1] = var7.field2170;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (null != PlayerManager.field1009 && class369.field4362 < class157.field1437) {
						class57.field404[++class387.field4452 - 1] = PlayerManager.field1009[++class369.field4362 - 1] & '\uffff';
					} else {
						class57.field404[++class387.field4452 - 1] = -1;
					}

					return 1;
				}
			}
		}
	}
}
