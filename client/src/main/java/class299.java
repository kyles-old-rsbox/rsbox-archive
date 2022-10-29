public class class299 extends class51 {
	public static boolean[] field3442;
	public static class319 field3439;
	class278 field3443;
	class343 field3440;
	class38 field3441;

	class299(class278 var1) {
		this.field3440 = new class343();
		this.field3441 = new class38();
		this.field3443 = var1;
	}

	protected class51 method1007() {
		class296 var1 = (class296)this.field3440.method6364();
		if (var1 == null) {
			return null;
		} else {
			return (class51)(null != var1.field3397 ? var1.field3397 : this.method1004());
		}
	}

	protected class51 method1004() {
		class296 var1;
		do {
			var1 = (class296)this.field3440.method6358();
			if (null == var1) {
				return null;
			}
		} while(var1.field3397 == null);

		return var1.field3397;
	}

	protected int method1003() {
		return 0;
	}

	protected void method1005(int[] var1, int var2, int var3) {
		this.field3441.method1005(var1, var2, var3);

		for (class296 var6 = (class296)this.field3440.method6364(); var6 != null; var6 = (class296)this.field3440.method6358()) {
			if (!this.field3443.method5300(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field3398) {
						this.method5838(var6, var1, var4, var5, var4 + var5);
						var6.field3398 -= var5;
						break;
					}

					this.method5838(var6, var1, var4, var6.field3398, var4 + var5);
					var4 += var6.field3398;
					var5 -= var6.field3398;
				} while(!this.field3443.method5301(var6, var1, var4, var5));
			}
		}

	}

	protected void method1001(int var1) {
		this.field3441.method1001(var1);

		for (class296 var3 = (class296)this.field3440.method6364(); null != var3; var3 = (class296)this.field3440.method6358()) {
			if (!this.field3443.method5300(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field3398) {
						this.method5844(var3, var2);
						var3.field3398 -= var2;
						break;
					}

					this.method5844(var3, var3.field3398);
					var2 -= var3.field3398;
				} while(!this.field3443.method5301(var3, (int[])null, 0, var2));
			}
		}

	}

	void method5838(class296 var1, int[] var2, int var3, int var4, int var5) {
		if ((this.field3443.field3181[var1.field3381] & 4) != 0 && var1.field3393 < 0) {
			int var7 = this.field3443.field3186[var1.field3381] / class49.field348;

			while (true) {
				int var8 = (var7 + 1048575 - var1.field3382) / var7;
				if (var8 > var4) {
					var1.field3382 += var7 * var4;
					break;
				}

				var1.field3397.method1005(var2, var3, var8);
				var3 += var8;
				var4 -= var8;
				var1.field3382 += var7 * var8 - 1048576;
				int var9 = class49.field348 / 100;
				int var10 = 262144 / var7;
				if (var10 < var9) {
					var9 = var10;
				}

				class44 var11 = var1.field3397;
				if (this.field3443.field3196[var1.field3381] == 0) {
					var1.field3397 = class44.method811(var1.field3387, var11.method826(), var11.method857(), var11.method818());
				} else {
					var1.field3397 = class44.method811(var1.field3387, var11.method826(), 0, var11.method818());
					this.field3443.method5385(var1, var1.field3380.field3349[var1.field3384] < 0);
					var1.field3397.method822(var9, var11.method857());
				}

				if (var1.field3380.field3349[var1.field3384] < 0) {
					var1.field3397.method813(-1);
				}

				var11.method815(var9);
				var11.method1005(var2, var3, var5 - var3);
				if (var11.method817()) {
					this.field3441.method718(var11);
				}
			}
		}

		var1.field3397.method1005(var2, var3, var4);
	}

	void method5844(class296 var1, int var2) {
		if (0 != (this.field3443.field3181[var1.field3381] & 4) && var1.field3393 < 0) {
			int var4 = this.field3443.field3186[var1.field3381] / class49.field348;
			int var5 = (var4 + 1048575 - var1.field3382) / var4;
			var1.field3382 = var2 * var4 + var1.field3382 & 1048575;
			if (var5 <= var2) {
				if (0 == this.field3443.field3196[var1.field3381]) {
					var1.field3397 = class44.method811(var1.field3387, var1.field3397.method826(), var1.field3397.method857(), var1.field3397.method818());
				} else {
					var1.field3397 = class44.method811(var1.field3387, var1.field3397.method826(), 0, var1.field3397.method818());
					this.field3443.method5385(var1, var1.field3380.field3349[var1.field3384] < 0);
				}

				if (var1.field3380.field3349[var1.field3384] < 0) {
					var1.field3397.method813(-1);
				}

				var2 = var1.field3382 / var4;
			}
		}

		var1.field3397.method1001(var2);
	}
}
