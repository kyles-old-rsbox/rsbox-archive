public class class244 extends class239 {
	static int field2859;
	int field2854;
	int field2855;
	int field2856;
	int field2857;

	class244() {
	}

	void method4872(class460 var1) {
		int var3 = var1.method8141();
		if (var3 != class256.field2948.field2947) {
			throw new IllegalStateException("");
		} else {
			super.field2815 = var1.method8141();
			super.field2813 = var1.method8141();
			super.field2821 = var1.method8122();
			super.field2809 = var1.method8122();
			this.field2857 = var1.method8141();
			this.field2855 = var1.method8141();
			super.field2810 = var1.method8122();
			super.field2811 = var1.method8122();
			this.field2856 = var1.method8141();
			this.field2854 = var1.method8141();
			super.field2814 = var1.method8140();
			super.field2820 = var1.method8140();
		}
	}

	void method4655(class460 var1) {
		super.field2813 = Math.min(super.field2813, 4);
		super.field2816 = new short[1][64][64];
		super.field2808 = new short[super.field2813][64][64];
		super.field2818 = new byte[super.field2813][64][64];
		super.field2819 = new byte[super.field2813][64][64];
		super.field2812 = new class253[super.field2813][64][64][];
		int var3 = var1.method8141();
		if (class250.field2904.field2901 != var3) {
			throw new IllegalStateException("");
		} else {
			int var4 = var1.method8141();
			int var5 = var1.method8141();
			int var6 = var1.method8141();
			int var7 = var1.method8141();
			if (var4 == super.field2810 && var5 == super.field2811 && var6 == this.field2856 && this.field2854 == var7) {
				for (int var8 = 0; var8 < 8; ++var8) {
					for (int var9 = 0; var9 < 8; ++var9) {
						this.method4656(this.field2856 * 8 + var8, this.field2854 * 8 + var9, var1);
					}
				}

			} else {
				throw new IllegalStateException("");
			}
		}
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class244)) {
			return false;
		} else {
			class244 var2 = (class244)var1;
			if (var2.field2810 == super.field2810 && var2.field2811 == super.field2811) {
				return var2.field2856 == this.field2856 && var2.field2854 == this.field2854;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.field2810 | super.field2811 << 8 | this.field2856 << 16 | this.field2854 << 24;
	}

	int method4874() {
		return this.field2857;
	}

	int method4884() {
		return this.field2855;
	}

	int method4876() {
		return this.field2856;
	}

	int method4877() {
		return this.field2854;
	}
}
