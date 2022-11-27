public abstract class class204 {
	static int[] regions;
	public int field2303;
	public int field2305;
	public int field2307;
	public int field2308;

	protected class204() {
	}

	static int method3891(int var0, class78 var1, boolean var2) {
		class300 var4;
		if (var0 != CS2Opcodes.CC_CALLONRESIZE && var0 != CS2Opcodes.IF_CALLONRESIZE) {
			int var8;
			if (var0 == CS2Opcodes.CC_TRIGGEROP) {
				var4 = var2 ? class138.field1284 : class153.field1414;
				var8 = class57.field404[--class387.field4452];
				if (var8 >= 1 && var8 <= 10) {
					class98 var6 = new class98(var8, var4.field3517, var4.field3484, var4.field3445);
					class57.field412.add(var6);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else if (var0 == CS2Opcodes.IF_TRIGGEROP) {
				class387.field4452 -= 3;
				int var9 = class57.field404[class387.field4452];
				var8 = class57.field404[1 + class387.field4452];
				int var10 = class57.field404[class387.field4452 + 2];
				if (var10 >= 1 && var10 <= 10) {
					class98 var7 = new class98(var10, var9, var8, class282.method5426(var9).field3445);
					class57.field412.add(var7);
					return 1;
				} else {
					throw new RuntimeException();
				}
			} else {
				return 2;
			}
		} else if (class57.field400 >= 10) {
			throw new RuntimeException();
		} else {
			if (var0 >= 2000) {
				var4 = class282.method5426(class57.field404[--class387.field4452]);
			} else {
				var4 = var2 ? class138.field1284 : class153.field1414;
			}

			if (null == var4.field3586) {
				return 0;
			} else {
				ClientScript var5 = new ClientScript();
				var5.field694 = var4;
				var5.args = var4.field3586;
				var5.field695 = 1 + class57.field400;
				client.field1765.method6355(var5);
				return 1;
			}
		}
	}

	public abstract boolean method3887(int var1, int var2, int var3, class200 var4);
}
