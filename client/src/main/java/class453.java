public class class453 extends class460 {
	static final int[] field4857;
	class479 field4856;
	int field4858;

	static {
		field4857 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
	}

	public class453(int var1) {
		super(var1);
	}

	public void method8006(int[] var1) {
		this.field4856 = new class479(var1);
	}

	public void method8025(class479 var1) {
		this.field4856 = var1;
	}

	public void method8008(int var1) {
		super.field4881[++super.field4878 - 1] = (byte)(var1 + this.field4856.method8639());
	}

	public int method8009() {
		return super.field4881[++super.field4878 - 1] - this.field4856.method8639() & 255;
	}

	public boolean method8007() {
		int var2 = super.field4881[super.field4878] - this.field4856.method8632() & 255;
		return var2 >= 128;
	}

	public int method8011() {
		int var2 = super.field4881[++super.field4878 - 1] - this.field4856.method8639() & 255;
		return var2 < 128 ? var2 : (var2 - 128 << 8) + (super.field4881[++super.field4878 - 1] - this.field4856.method8639() & 255);
	}

	public void method8017(byte[] var1, int var2, int var3) {
		for (int var5 = 0; var5 < var3; ++var5) {
			var1[var2 + var5] = (byte)(super.field4881[++super.field4878 - 1] - this.field4856.method8639());
		}

	}

	public void method8013() {
		this.field4858 = super.field4878 * 8;
	}

	public int method8014(int var1) {
		int var3 = this.field4858 >> 3;
		int var4 = 8 - (this.field4858 & 7);
		int var5 = 0;

		for (this.field4858 += var1; var1 > var4; var4 = 8) {
			var5 += (super.field4881[var3++] & field4857[var4]) << var1 - var4;
			var1 -= var4;
		}

		if (var4 == var1) {
			var5 += super.field4881[var3] & field4857[var4];
		} else {
			var5 += super.field4881[var3] >> var4 - var1 & field4857[var1];
		}

		return var5;
	}

	public void method8010() {
		super.field4878 = (7 + this.field4858) / 8;
	}

	public int method8044(int var1) {
		return 8 * var1 - this.field4858;
	}
}
