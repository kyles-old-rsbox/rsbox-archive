public class class452 extends class437 {
	public static class284 field4852;
	static class319 field4853;
	int[][] field4851;
	Object[][] field4854;
	public int field4855;

	static {
		field4852 = new class284(64);
	}

	class452() {
		this.field4855 = -1;
	}

	public static void method6816(class319 var0) {
		field4853 = var0;
	}

	void method7988(Buffer var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method7996(var1, var3);
		}
	}

	public Object[] method7989(int var1) {
		return this.field4854 == null ? null : this.field4854[var1];
	}

	void method7996(Buffer var1, int var2) {
		if (var2 == 3) {
			int var4 = var1.method8141();
			if (this.field4854 == null) {
				this.field4854 = new Object[var4][];
				this.field4851 = new int[var4][];
			}

			for (int var5 = var1.method8141(); var5 != 255; var5 = var1.method8141()) {
				int var6 = var1.method8141();
				int[] var7 = new int[var6];

				for (int var8 = 0; var8 < var6; ++var8) {
					var7[var8] = var1.method8207();
				}

				Object[][] var17 = this.field4854;
				int var11 = var1.method8207();
				Object[] var12 = new Object[var11 * var7.length];

				for (int var13 = 0; var13 < var11; ++var13) {
					for (int var14 = 0; var14 < var7.length; ++var14) {
						int var15 = var7.length * var13 + var14;
						class451 var16 = class213.method4117(var7[var14]);
						var12[var15] = var16.method7974(var1);
					}
				}

				var17[var5] = var12;
				this.field4851[var5] = var7;
			}
		} else if (var2 == 4) {
			this.field4855 = var1.method8142();
		}

	}

	void method7991() {
	}
}
