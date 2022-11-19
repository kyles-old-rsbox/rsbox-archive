import client.Client;

public class class61 extends class212 {
	static String field481;
	class189 field482;
	int field483;
	int field484;
	int field485;
	int field486;
	int field487;
	int field488;
	int field489;
	int field490;

	public static String method1338(CharSequence var0) {
		int var2 = var0.length();
		StringBuilder var3 = new StringBuilder(var2);

		for (int var4 = 0; var4 < var2; ++var4) {
			char var5 = var0.charAt(var4);
			if ((var5 < 'a' || var5 > 'z') && (var5 < 'A' || var5 > 'Z') && (var5 < '0' || var5 > '9') && var5 != '.' && var5 != '-' && var5 != '*' && var5 != '_') {
				if (var5 == ' ') {
					var3.append('+');
				} else {
					byte var6 = class107.method2099(var5);
					var3.append('%');
					int var7 = var6 >> 4 & 15;
					if (var7 >= 10) {
						var3.append((char)(var7 + 55));
					} else {
						var3.append((char)(var7 + 48));
					}

					var7 = var6 & 15;
					if (var7 >= 10) {
						var3.append((char)(var7 + 55));
					} else {
						var3.append((char)(var7 + 48));
					}
				}
			} else {
				var3.append(var5);
			}
		}

		return var3.toString();
	}

	class61(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class212 var9) {
		this.field490 = var1;
		this.field484 = var2;
		this.field483 = var3;
		this.field487 = var4;
		this.field485 = var5;
		this.field486 = var6;
		if (var7 != -1) {
			this.field482 = class160.method2660(var7);
			this.field488 = 0;
			this.field489 = Client.field1645 - 1;
			if (0 == this.field482.field2013 && var9 != null && var9 instanceof class61) {
				class61 var10 = (class61)var9;
				if (var10.field482 == this.field482) {
					this.field488 = var10.field488;
					this.field489 = var10.field489;
					return;
				}
			}

			if (var8 && -1 != this.field482.field2012) {
				if (!this.field482.method3486()) {
					this.field488 = (int)(Math.random() * (double)this.field482.field1998.length);
					this.field489 -= (int)(Math.random() * (double)this.field482.field2000[this.field488]);
				} else {
					this.field488 = (int)(Math.random() * (double)this.field482.method3476());
				}
			}
		}

	}

	protected final class209 method4112() {
		int var3;
		if (null != this.field482) {
			int var2 = Client.field1645 - this.field489;
			if (var2 > 100 && this.field482.field2012 > 0) {
				var2 = 100;
			}

			if (this.field482.method3486()) {
				var3 = this.field482.method3476();
				this.field488 += var2;
				var2 = 0;
				if (this.field488 >= var3) {
					this.field488 = var3 - this.field482.field2012;
					if (this.field488 < 0 || this.field488 > var3) {
						this.field482 = null;
					}
				}
			} else {
				label81: {
					do {
						do {
							if (var2 <= this.field482.field2000[this.field488]) {
								break label81;
							}

							var2 -= this.field482.field2000[this.field488];
							++this.field488;
						} while(this.field488 < this.field482.field1998.length);

						this.field488 -= this.field482.field2012;
					} while(this.field488 >= 0 && this.field488 < this.field482.field1998.length);

					this.field482 = null;
				}
			}

			this.field489 = Client.field1645 - var2;
		}

		class195 var13 = class89.method1866(this.field490);
		if (var13.field2094 != null) {
			var13 = var13.method3588();
		}

		if (var13 == null) {
			return null;
		} else {
			int var4;
			if (1 != this.field483 && this.field483 != 3) {
				var3 = var13.field2100;
				var4 = var13.field2069;
			} else {
				var3 = var13.field2069;
				var4 = var13.field2100;
			}

			int var5 = this.field485 + (var3 >> 1);
			int var6 = this.field485 + (var3 + 1 >> 1);
			int var7 = (var4 >> 1) + this.field486;
			int var8 = this.field486 + (var4 + 1 >> 1);
			int[][] var9 = class82.field719[this.field487];
			int var10 = var9[var6][var7] + var9[var5][var7] + var9[var5][var8] + var9[var6][var8] >> 2;
			int var11 = (this.field485 << 7) + (var3 << 6);
			int var12 = (this.field486 << 7) + (var4 << 6);
			return var13.method3586(this.field484, this.field483, var9, var11, var10, var12, this.field482, this.field488);
		}
	}

	static final void method1337(int var0, int var1, int var2) {
		int var4;
		for (var4 = 0; var4 < 8; ++var4) {
			for (int var5 = 0; var5 < 8; ++var5) {
				class82.field719[var0][var1 + var4][var2 + var5] = 0;
			}
		}

		if (var1 > 0) {
			for (var4 = 1; var4 < 8; ++var4) {
				class82.field719[var0][var1][var2 + var4] = class82.field719[var0][var1 - 1][var4 + var2];
			}
		}

		if (var2 > 0) {
			for (var4 = 1; var4 < 8; ++var4) {
				class82.field719[var0][var4 + var1][var2] = class82.field719[var0][var1 + var4][var2 - 1];
			}
		}

		if (var1 > 0 && 0 != class82.field719[var0][var1 - 1][var2]) {
			class82.field719[var0][var1][var2] = class82.field719[var0][var1 - 1][var2];
		} else if (var2 > 0 && class82.field719[var0][var1][var2 - 1] != 0) {
			class82.field719[var0][var1][var2] = class82.field719[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && class82.field719[var0][var1 - 1][var2 - 1] != 0) {
			class82.field719[var0][var1][var2] = class82.field719[var0][var1 - 1][var2 - 1];
		}

	}
}
