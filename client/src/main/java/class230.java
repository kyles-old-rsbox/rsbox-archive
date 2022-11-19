import client.Client;

public class class230 extends class427 {
	class216 field2747;
	int field2740;
	int field2744;
	int[] field2745;
	int[][] field2746;

	public class230(int var1, byte[] var2) {
		this.field2740 = var1;
		class460 var3 = new class460(var2);
		this.field2744 = var3.method8141();
		this.field2745 = new int[this.field2744];
		this.field2746 = new int[this.field2744][];

		int var4;
		for (var4 = 0; var4 < this.field2744; ++var4) {
			this.field2745[var4] = var3.method8141();
		}

		for (var4 = 0; var4 < this.field2744; ++var4) {
			this.field2746[var4] = new int[var3.method8141()];
		}

		for (var4 = 0; var4 < this.field2744; ++var4) {
			for (int var5 = 0; var5 < this.field2746[var4].length; ++var5) {
				this.field2746[var4][var5] = var3.method8141();
			}
		}

		if (var3.field4878 < var3.field4881.length) {
			var4 = var3.method8122();
			if (var4 > 0) {
				this.field2747 = new class216(var3, var4);
			}
		}

	}

	public int method4529() {
		return this.field2744;
	}

	public class216 method4530() {
		return this.field2747;
	}

	static final void method4536(int var0, int var1, int var2) {
		if (var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
			int var4 = class144.method2498(var0, var1, class55.field396) - var2;
			var0 -= class215.field2568;
			var4 -= class32.field204;
			var1 -= class323.field3766;
			int var5 = class221.field2644[class414.field4588];
			int var6 = class221.field2645[class414.field4588];
			int var7 = class221.field2644[class237.field2807];
			int var8 = class221.field2645[class237.field2807];
			int var9 = var1 * var7 + var0 * var8 >> 16;
			var1 = var8 * var1 - var0 * var7 >> 16;
			var0 = var9;
			var9 = var4 * var6 - var5 * var1 >> 16;
			var1 = var6 * var1 + var5 * var4 >> 16;
			if (var1 >= 50) {
				Client.field1809 = var0 * Client.field1919 / var1 + Client.field1917 / 2;
				Client.field1747 = Client.field1919 * var9 / var1 + Client.field1678 / 2;
			} else {
				Client.field1809 = -1;
				Client.field1747 = -1;
			}

		} else {
			Client.field1809 = -1;
			Client.field1747 = -1;
		}
	}
}
