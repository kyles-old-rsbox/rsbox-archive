public class class277 {
	static final byte[] field3164;
	class460 field3167;
	int field3159;
	int field3168;
	int[] field3156;
	int[] field3158;
	int[] field3160;
	int[] field3161;
	long field3163;

	static {
		field3164 = new byte[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}

	class277() {
		this.field3167 = new class460((byte[])null);
	}

	class277(byte[] var1) {
		this.field3167 = new class460((byte[])null);
		this.method5226(var1);
	}

	void method5226(byte[] var1) {
		this.field3167.field4881 = var1;
		this.field3167.field4878 = 10;
		int var2 = this.field3167.method8122();
		this.field3168 = this.field3167.method8122();
		this.field3159 = 500000;
		this.field3156 = new int[var2];

		class460 var10000;
		int var3;
		int var5;
		for (var3 = 0; var3 < var2; var10000.field4878 += var5) {
			int var4 = this.field3167.method8126();
			var5 = this.field3167.method8126();
			if (var4 == 1297379947) {
				this.field3156[var3] = this.field3167.field4878;
				++var3;
			}

			var10000 = this.field3167;
		}

		this.field3163 = 0L;
		this.field3158 = new int[var2];

		for (var3 = 0; var3 < var2; ++var3) {
			this.field3158[var3] = this.field3156[var3];
		}

		this.field3161 = new int[var2];
		this.field3160 = new int[var2];
	}

	void method5256() {
		this.field3167.field4881 = null;
		this.field3156 = null;
		this.field3158 = null;
		this.field3161 = null;
		this.field3160 = null;
	}

	boolean method5228() {
		return this.field3167.field4881 != null;
	}

	int method5227() {
		return this.field3158.length;
	}

	void method5230(int var1) {
		this.field3167.field4878 = this.field3158[var1];
	}

	void method5231(int var1) {
		this.field3158[var1] = this.field3167.field4878;
	}

	void method5254() {
		this.field3167.field4878 = -1;
	}

	void method5233(int var1) {
		int var2 = this.field3167.method8235();
		int[] var10000 = this.field3161;
		var10000[var1] += var2;
	}

	int method5234(int var1) {
		int var2 = this.method5235(var1);
		return var2;
	}

	int method5235(int var1) {
		byte var2 = this.field3167.field4881[this.field3167.field4878];
		int var5;
		if (var2 < 0) {
			var5 = var2 & 255;
			this.field3160[var1] = var5;
			++this.field3167.field4878;
		} else {
			var5 = this.field3160[var1];
		}

		if (var5 != 240 && var5 != 247) {
			return this.method5236(var1, var5);
		} else {
			int var3 = this.field3167.method8235();
			if (var5 == 247 && var3 > 0) {
				int var4 = this.field3167.field4881[this.field3167.field4878] & 255;
				if (var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
					++this.field3167.field4878;
					this.field3160[var1] = var4;
					return this.method5236(var1, var4);
				}
			}

			class460 var10000 = this.field3167;
			var10000.field4878 += var3;
			return 0;
		}
	}

	int method5236(int var1, int var2) {
		int var4;
		if (var2 == 255) {
			int var7 = this.field3167.method8141();
			var4 = this.field3167.method8235();
			class460 var10000;
			if (var7 == 47) {
				var10000 = this.field3167;
				var10000.field4878 += var4;
				return 1;
			} else if (var7 == 81) {
				int var5 = this.field3167.method8312();
				var4 -= 3;
				int var6 = this.field3161[var1];
				this.field3163 += (long)var6 * (long)(this.field3159 - var5);
				this.field3159 = var5;
				var10000 = this.field3167;
				var10000.field4878 += var4;
				return 2;
			} else {
				var10000 = this.field3167;
				var10000.field4878 += var4;
				return 3;
			}
		} else {
			byte var3 = field3164[var2 - 128];
			var4 = var2;
			if (var3 >= 1) {
				var4 = var2 | this.field3167.method8141() << 8;
			}

			if (var3 >= 2) {
				var4 |= this.field3167.method8141() << 16;
			}

			return var4;
		}
	}

	long method5237(int var1) {
		return this.field3163 + (long)var1 * (long)this.field3159;
	}

	int method5238() {
		int var1 = this.field3158.length;
		int var2 = -1;
		int var3 = Integer.MAX_VALUE;

		for (int var4 = 0; var4 < var1; ++var4) {
			if (this.field3158[var4] >= 0 && this.field3161[var4] < var3) {
				var2 = var4;
				var3 = this.field3161[var4];
			}
		}

		return var2;
	}

	boolean method5239() {
		int var1 = this.field3158.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			if (this.field3158[var2] >= 0) {
				return false;
			}
		}

		return true;
	}

	void method5270(long var1) {
		this.field3163 = var1;
		int var3 = this.field3158.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			this.field3161[var4] = 0;
			this.field3160[var4] = 0;
			this.field3167.field4878 = this.field3156[var4];
			this.method5233(var4);
			this.field3158[var4] = this.field3167.field4878;
		}

	}
}
