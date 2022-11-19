public class class247 implements class248 {
	int field2882;
	int field2883;
	int field2884;
	int field2885;
	int field2886;
	int field2887;
	int field2888;
	int field2889;
	int field2890;
	int field2891;

	class247() {
	}

	public void method4986(class254 var1) {
		if (var1.field2936 > this.field2886) {
			var1.field2936 = this.field2886;
		}

		if (var1.field2930 < this.field2886) {
			var1.field2930 = this.field2886;
		}

		if (var1.field2937 > this.field2891) {
			var1.field2937 = this.field2891;
		}

		if (var1.field2939 < this.field2891) {
			var1.field2939 = this.field2891;
		}

	}

	public boolean method4976(int var1, int var2, int var3) {
		if (var1 >= this.field2889 && var1 < this.field2883 + this.field2889) {
			return var2 >= (this.field2888 << 3) + (this.field2884 << 6) && var2 <= (this.field2888 << 3) + (this.field2884 << 6) + 7 && var3 >= (this.field2885 << 6) + (this.field2882 << 3) && var3 <= (this.field2885 << 6) + (this.field2882 << 3) + 7;
		} else {
			return false;
		}
	}

	public boolean method4963(int var1, int var2) {
		return var1 >= (this.field2886 << 6) + (this.field2890 << 3) && var1 <= (this.field2886 << 6) + (this.field2890 << 3) + 7 && var2 >= (this.field2891 << 6) + (this.field2887 << 3) && var2 <= 7 + (this.field2891 << 6) + (this.field2887 << 3);
	}

	public int[] method4979(int var1, int var2, int var3) {
		if (!this.method4976(var1, var2, var3)) {
			return null;
		} else {
			int[] var5 = new int[]{this.field2890 * 8 - this.field2888 * 8 + var2 + (this.field2886 * 64 - this.field2884 * 64), this.field2887 * 8 - this.field2882 * 8 + this.field2891 * 64 - this.field2885 * 64 + var3};
			return var5;
		}
	}

	public class295 method4966(int var1, int var2) {
		if (!this.method4963(var1, var2)) {
			return null;
		} else {
			int var4 = this.field2888 * 8 - this.field2890 * 8 + this.field2884 * 64 - this.field2886 * 64 + var1;
			int var5 = this.field2885 * 64 - this.field2891 * 64 + var2 + (this.field2882 * 8 - this.field2887 * 8);
			return new class295(this.field2889, var4, var5);
		}
	}

	public void method4967(class460 var1) {
		this.field2889 = var1.method8141();
		this.field2883 = var1.method8141();
		this.field2884 = var1.method8122();
		this.field2888 = var1.method8141();
		this.field2885 = var1.method8122();
		this.field2882 = var1.method8141();
		this.field2886 = var1.method8122();
		this.field2890 = var1.method8141();
		this.field2891 = var1.method8122();
		this.field2887 = var1.method8141();
		this.method4938();
	}

	void method4938() {
	}

	static void method4960(int var0, int var1, int var2, int var3) {
		class300 var5 = class253.method5043(var0, var1);
		if (var5 != null && var5.field3563 != null) {
			class79 var6 = new class79();
			var6.field694 = var5;
			var6.field686 = var5.field3563;
			class57.method5433(var6);
		}

		client.field1806 = var3;
		client.field1804 = true;
		class106.field1066 = var0;
		client.field1805 = var1;
		class120.field1161 = var2;
		class136.method2438(var5);
	}
}
