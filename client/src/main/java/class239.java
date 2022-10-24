import java.util.LinkedList;

public abstract class class239 {
	public static boolean field2817;
	boolean field2822;
	boolean field2823;
	byte[][][] field2818;
	byte[][][] field2819;
	class253[][][][] field2812;
	int field2809;
	int field2810;
	int field2811;
	int field2813;
	int field2814;
	int field2815;
	int field2820;
	int field2821;
	short[][][] field2808;
	short[][][] field2816;

	static {
		field2817 = true;
	}

	class239() {
		this.field2814 = -1;
		this.field2820 = -1;
		new LinkedList();
		this.field2822 = false;
		this.field2823 = false;
	}

	boolean method4649() {
		return this.field2822 && this.field2823;
	}

	void method4650(class319 var1) {
		if (!this.method4649()) {
			byte[] var3 = var1.method6175(this.field2814, this.field2820);
			if (null != var3) {
				this.method4655(new class460(var3));
				this.field2822 = true;
				this.field2823 = true;
			}

		}
	}

	public static boolean method4679(int var0) {
		return var0 >= class306.field3660.field3670 && var0 <= class306.field3663.field3670 || class306.field3651.field3670 == var0;
	}

	void method4651() {
		this.field2816 = (short[][][])null;
		this.field2808 = (short[][][])null;
		this.field2818 = (byte[][][])null;
		this.field2819 = (byte[][][])null;
		this.field2812 = (class253[][][][])null;
		this.field2822 = false;
		this.field2823 = false;
	}

	void method4656(int var1, int var2, class460 var3) {
		int var5 = var3.method8141();
		if (0 != var5) {
			if ((var5 & 1) != 0) {
				this.method4653(var1, var2, var3, var5);
			} else {
				this.method4654(var1, var2, var3, var5);
			}

		}
	}

	static void method4680(int var0) {
		class87 var2 = (class87)class87.field782.method7855((long)var0);
		if (null != var2) {
			for (int var3 = 0; var3 < var2.field779.length; ++var3) {
				var2.field779[var3] = -1;
				var2.field783[var3] = 0;
			}

		}
	}

	void method4653(int var1, int var2, class460 var3, int var4) {
		boolean var6 = (var4 & 2) != 0;
		if (var6) {
			this.field2808[0][var1][var2] = field2817 ? (short)var3.method8122() : (short)var3.method8141();
		}

		this.field2816[0][var1][var2] = field2817 ? (short)var3.method8122() : (short)var3.method8141();
	}

	void method4654(int var1, int var2, class460 var3, int var4) {
		int var6 = 1 + ((var4 & 24) >> 3);
		boolean var7 = 0 != (var4 & 2);
		boolean var8 = 0 != (var4 & 4);
		this.field2816[0][var1][var2] = field2817 ? (short)var3.method8122() : (short)var3.method8141();
		int var9;
		int var10;
		int var12;
		if (var7) {
			var9 = var3.method8141();

			for (var10 = 0; var10 < var9; ++var10) {
				int var11 = field2817 ? var3.method8122() : var3.method8141();
				if (var11 != 0) {
					this.field2808[var10][var1][var2] = (short)var11;
					var12 = var3.method8141();
					this.field2818[var10][var1][var2] = (byte)(var12 >> 2);
					this.field2819[var10][var1][var2] = (byte)(var12 & 3);
				}
			}
		}

		if (var8) {
			for (var9 = 0; var9 < var6; ++var9) {
				var10 = var3.method8141();
				if (0 != var10) {
					class253[] var15 = this.field2812[var9][var1][var2] = new class253[var10];

					for (var12 = 0; var12 < var10; ++var12) {
						int var13 = var3.method8140();
						int var14 = var3.method8141();
						var15[var12] = new class253(var13, var14 >> 2, var14 & 3);
					}
				}
			}
		}

	}

	int method4664() {
		return this.field2810;
	}

	int method4657() {
		return this.field2811;
	}

	abstract void method4655(class460 var1);
}
