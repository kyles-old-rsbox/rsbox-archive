public class class396 extends class400 {
	public int field4490;
	public int field4491;
	public int field4492;

	class396() {
		this.field4491 = -1;
	}

	void method7178(int var1, int var2) {
		this.field4491 = var1;
		this.field4490 = var2;
	}

	public int method7173() {
		return this.field4491;
	}

	public boolean method7174() {
		return this.field4491 > 0;
	}

	static int method7176(int var0, class78 var1, boolean var2) {
		class300 var4 = class282.method5426(class57.field404[--class387.field4452]);
		if (var0 == 2500) {
			class57.field404[++class387.field4452 - 1] = var4.field3473;
			return 1;
		} else if (2501 == var0) {
			class57.field404[++class387.field4452 - 1] = var4.field3551;
			return 1;
		} else if (var0 == 2502) {
			class57.field404[++class387.field4452 - 1] = var4.field3448;
			return 1;
		} else if (2503 == var0) {
			class57.field404[++class387.field4452 - 1] = var4.field3476;
			return 1;
		} else if (2504 == var0) {
			class57.field404[++class387.field4452 - 1] = var4.field3480 ? 1 : 0;
			return 1;
		} else if (var0 == 2505) {
			class57.field404[++class387.field4452 - 1] = var4.field3596;
			return 1;
		} else {
			return 2;
		}
	}
}
