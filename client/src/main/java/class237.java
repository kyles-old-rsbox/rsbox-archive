public class class237 implements class248 {
	static int field2807;
	int field2801;
	int field2802;
	int field2803;
	int field2804;
	int field2805;
	int field2806;

	class237() {
	}

	public void method4986(class254 var1) {
		if (var1.field2936 > this.field2805) {
			var1.field2936 = this.field2805;
		}

		if (var1.field2930 < this.field2805) {
			var1.field2930 = this.field2805;
		}

		if (var1.field2937 > this.field2806) {
			var1.field2937 = this.field2806;
		}

		if (var1.field2939 < this.field2806) {
			var1.field2939 = this.field2806;
		}

	}

	public boolean method4976(int var1, int var2, int var3) {
		if (var1 >= this.field2803 && var1 < this.field2803 + this.field2802) {
			return this.field2801 == var2 >> 6 && this.field2804 == var3 >> 6;
		} else {
			return false;
		}
	}

	public boolean method4963(int var1, int var2) {
		return var1 >> 6 == this.field2805 && var2 >> 6 == this.field2806;
	}

	public int[] method4979(int var1, int var2, int var3) {
		if (!this.method4976(var1, var2, var3)) {
			return null;
		} else {
			int[] var5 = new int[]{var2 + (this.field2805 * 64 - this.field2801 * 64), this.field2806 * 64 - this.field2804 * 64 + var3};
			return var5;
		}
	}

	public class295 method4966(int var1, int var2) {
		if (!this.method4963(var1, var2)) {
			return null;
		} else {
			int var4 = var1 + (this.field2801 * 64 - this.field2805 * 64);
			int var5 = this.field2804 * 64 - this.field2806 * 64 + var2;
			return new class295(this.field2803, var4, var5);
		}
	}

	public void method4967(Buffer var1) {
		this.field2803 = var1.method8141();
		this.field2802 = var1.method8141();
		this.field2801 = var1.readUnsignedShort();
		this.field2804 = var1.readUnsignedShort();
		this.field2805 = var1.readUnsignedShort();
		this.field2806 = var1.readUnsignedShort();
		this.method4626();
	}

	void method4626() {
	}
}
