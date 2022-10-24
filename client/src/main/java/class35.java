public class class35 {
	int field223;
	int field225;
	int field226;
	int field227;
	int field228;
	int field230;
	int field231;
	int field232;
	int field233;
	int[] field224;
	int[] field229;

	class35() {
		this.field225 = 2;
		this.field224 = new int[2];
		this.field229 = new int[2];
		this.field224[0] = 0;
		this.field224[1] = 65535;
		this.field229[0] = 0;
		this.field229[1] = 65535;
	}

	final void method657(class460 var1) {
		this.field228 = var1.method8141();
		this.field226 = var1.method8126();
		this.field227 = var1.method8126();
		this.method663(var1);
	}

	final void method663(class460 var1) {
		this.field225 = var1.method8141();
		this.field224 = new int[this.field225];
		this.field229 = new int[this.field225];

		for (int var2 = 0; var2 < this.field225; ++var2) {
			this.field224[var2] = var1.method8122();
			this.field229[var2] = var1.method8122();
		}

	}

	final void method662() {
		this.field223 = 0;
		this.field230 = 0;
		this.field231 = 0;
		this.field232 = 0;
		this.field233 = 0;
	}

	final int method658(int var1) {
		if (this.field233 >= this.field223) {
			this.field232 = this.field229[this.field230++] << 15;
			if (this.field230 >= this.field225) {
				this.field230 = this.field225 - 1;
			}

			this.field223 = (int)((double)this.field224[this.field230] / 65536.0D * (double)var1);
			if (this.field223 > this.field233) {
				this.field231 = ((this.field229[this.field230] << 15) - this.field232) / (this.field223 - this.field233);
			}
		}

		this.field232 += this.field231;
		++this.field233;
		return this.field232 - this.field231 >> 15;
	}
}
