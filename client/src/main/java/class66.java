public final class class66 extends class212 {
	static class123 field538;
	boolean field524;
	class189 field534;
	double field514;
	double field518;
	double field525;
	double field527;
	double field529;
	double field530;
	double field531;
	double field532;
	int field513;
	int field515;
	int field516;
	int field517;
	int field519;
	int field520;
	int field521;
	int field522;
	int field523;
	int field526;
	int field528;
	int field533;
	int field535;
	int field536;
	int field537;

	class66(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
		this.field524 = false;
		this.field536 = 0;
		this.field517 = 0;
		this.field535 = var1;
		this.field537 = var2;
		this.field515 = var3;
		this.field533 = var4;
		this.field513 = var5;
		this.field528 = var6;
		this.field520 = var7;
		this.field526 = var8;
		this.field522 = var9;
		this.field523 = var10;
		this.field521 = var11;
		this.field524 = false;
		int var12 = class207.method803(this.field535).field2359;
		if (var12 != -1) {
			this.field534 = class160.method2660(var12);
		} else {
			this.field534 = null;
		}

	}

	final void method1380(int var1, int var2, int var3, int var4) {
		double var6;
		if (!this.field524) {
			var6 = (double)(var1 - this.field515);
			double var8 = (double)(var2 - this.field533);
			double var10 = Math.sqrt(var8 * var8 + var6 * var6);
			this.field525 = (double)this.field515 + var6 * (double)this.field522 / var10;
			this.field514 = var8 * (double)this.field522 / var10 + (double)this.field533;
			this.field527 = (double)this.field513;
		}

		var6 = (double)(1 + this.field520 - var4);
		this.field518 = ((double)var1 - this.field525) / var6;
		this.field529 = ((double)var2 - this.field514) / var6;
		this.field530 = Math.sqrt(this.field518 * this.field518 + this.field529 * this.field529);
		if (!this.field524) {
			this.field531 = -this.field530 * Math.tan((double)this.field526 * 0.02454369D);
		}

		this.field532 = ((double)var3 - this.field527 - this.field531 * var6) * 2.0D / (var6 * var6);
	}

	final void method1381(int var1) {
		this.field524 = true;
		this.field525 += this.field518 * (double)var1;
		this.field514 += this.field529 * (double)var1;
		this.field527 += this.field531 * (double)var1 + (double)var1 * this.field532 * 0.5D * (double)var1;
		this.field531 += this.field532 * (double)var1;
		this.field519 = (int)(Math.atan2(this.field518, this.field529) * 325.949D) + 1024 & 2047;
		this.field516 = (int)(Math.atan2(this.field531, this.field530) * 325.949D) & 2047;
		if (this.field534 != null) {
			if (!this.field534.method3486()) {
				this.field517 += var1;

				while (true) {
					do {
						do {
							if (this.field517 <= this.field534.field2000[this.field536]) {
								return;
							}

							this.field517 -= this.field534.field2000[this.field536];
							++this.field536;
						} while(this.field536 < this.field534.field1998.length);

						this.field536 -= this.field534.field2012;
					} while(this.field536 >= 0 && this.field536 < this.field534.field1998.length);

					this.field536 = 0;
				}
			} else {
				this.field536 += var1;
				int var3 = this.field534.method3476();
				if (this.field536 >= var3) {
					this.field536 = var3 - this.field534.field2012;
				}
			}
		}

	}

	protected final class209 method4112() {
		class207 var2 = class207.method803(this.field535);
		class209 var3 = var2.method3972(this.field536);
		if (null == var3) {
			return null;
		} else {
			var3.method4007(this.field516);
			return var3;
		}
	}

	static final void method1392() {
		for (class101 var1 = (class101)client.field1777.method6364(); var1 != null; var1 = (class101)client.field1777.method6358()) {
			if (-1 == var1.field1003) {
				var1.field1006 = 0;
				client.method3540(var1);
			} else {
				var1.method7825();
			}
		}

	}
}
