import client.Client;

public class class405 {
	float[] field4520;
	int field4519;

	class405(float[] var1, int var2) {
		this.field4520 = var1;
		this.field4519 = var2;
	}

	static float method45(float[] var0, int var1, float var2) {
		float var4 = var0[var1];

		for (int var5 = var1 - 1; var5 >= 0; --var5) {
			var4 = var2 * var4 + var0[var5];
		}

		return var4;
	}

	static int method7368(class300 var0) {
		if (11 != var0.field3462) {
			--class126.field1220;
			class57.field404[++class387.field4452 - 1] = -1;
			return 1;
		} else {
			String var2 = class57.field405[--class126.field1220];
			class57.field404[++class387.field4452 - 1] = var0.method5868(var2);
			return 1;
		}
	}

	static final class89 method7370(int var0, int var1, int var2) {
		class89 var4 = new class89();
		var4.field796 = var1;
		var4.field797 = var2;
		Client.field1810.method7857(var4, (long)var0);
		class82.method1699(var1);
		class300 var5 = class282.method5426(var0);
		class136.method2438(var5);
		if (null != Client.field1641) {
			class136.method2438(Client.field1641);
			Client.field1641 = null;
		}

		class26.method349(class300.field3593[var0 >> 16], var5, false);
		class134.method2421(var1);
		if (-1 != Client.field1893) {
			class217.method4361(Client.field1893, 1);
		}

		return var4;
	}
}
