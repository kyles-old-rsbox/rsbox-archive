public final class class77 extends class212 {
	static class86 field670;
	static int field662;
	static int field669;
	boolean field667;
	class189 field664;
	int field658;
	int field659;
	int field660;
	int field661;
	int field663;
	int field665;
	int field666;
	int field671;

	class77(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.field663 = 0;
		this.field666 = 0;
		this.field667 = false;
		this.field665 = var1;
		this.field660 = var2;
		this.field661 = var3;
		this.field658 = var4;
		this.field671 = var5;
		this.field659 = var6 + var7;
		int var8 = class207.method803(this.field665).field2359;
		if (var8 != -1) {
			this.field667 = false;
			this.field664 = class160.method2660(var8);
		} else {
			this.field667 = true;
		}

	}

	final void method1571(int var1) {
		if (!this.field667) {
			this.field666 += var1;
			if (!this.field664.method3486()) {
				while (this.field666 > this.field664.field2000[this.field663]) {
					this.field666 -= this.field664.field2000[this.field663];
					++this.field663;
					if (this.field663 >= this.field664.field1998.length) {
						this.field667 = true;
						break;
					}
				}
			} else {
				this.field663 += var1;
				if (this.field663 >= this.field664.method3476()) {
					this.field667 = true;
				}
			}

		}
	}

	protected final class209 method4112() {
		class207 var2 = class207.method803(this.field665);
		class209 var3;
		if (!this.field667) {
			var3 = var2.method3972(this.field663);
		} else {
			var3 = var2.method3972(-1);
		}

		return null == var3 ? null : var3;
	}

	static class118 method1579(int var0) {
		class118 var2 = (class118)class217.method4362(class118.method4508(), var0);
		if (null == var2) {
			var2 = class118.field1141;
		}

		return var2;
	}
}
