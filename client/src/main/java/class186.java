public class class186 extends class427 {
	static int[] field1961;
	boolean field1966;
	boolean field1974;
	int field1965;
	int field1971;
	int field1972;
	int[] field1963;
	int[] field1967;
	int[] field1968;
	int[] field1969;
	int[] field1973;

	class186(Buffer var1) {
		this.field1974 = false;
		this.field1965 = var1.readUnsignedShort();
		this.field1966 = var1.method8141() == 1;
		int var2 = var1.method8141();
		if (var2 >= 1 && var2 <= 4) {
			this.field1967 = new int[var2];

			int var3;
			for (var3 = 0; var3 < var2; ++var3) {
				this.field1967[var3] = var1.readUnsignedShort();
			}

			if (var2 > 1) {
				this.field1963 = new int[var2 - 1];

				for (var3 = 0; var3 < var2 - 1; ++var3) {
					this.field1963[var3] = var1.method8141();
				}
			}

			if (var2 > 1) {
				this.field1969 = new int[var2 - 1];

				for (var3 = 0; var3 < var2 - 1; ++var3) {
					this.field1969[var3] = var1.method8141();
				}
			}

			this.field1968 = new int[var2];

			for (var3 = 0; var3 < var2; ++var3) {
				this.field1968[var3] = var1.method8126();
			}

			this.field1971 = var1.method8141();
			this.field1972 = var1.method8141();
			this.field1973 = null;
		} else {
			throw new RuntimeException();
		}
	}

	boolean method3437(double var1, int var3, class319 var4) {
		int var5;
		for (var5 = 0; var5 < this.field1967.length; ++var5) {
			if (var4.method6096(this.field1967[var5]) == null) {
				return false;
			}
		}

		var5 = var3 * var3;
		this.field1973 = new int[var5];

		for (int var6 = 0; var6 < this.field1967.length; ++var6) {
			class488 var7 = class412.method7415(var4, this.field1967[var6]);
			var7.method8753();
			byte[] var8 = var7.field5022;
			int[] var9 = var7.field5023;
			int var10 = this.field1968[var6];
			if ((var10 & -16777216) == 16777216) {
			}

			if ((var10 & -16777216) == 33554432) {
			}

			int var11;
			int var12;
			int var13;
			int var14;
			if ((var10 & -16777216) == 50331648) {
				var11 = var10 & 16711935;
				var12 = var10 >> 8 & 255;

				for (var13 = 0; var13 < var9.length; ++var13) {
					var14 = var9[var13];
					if ((var14 & 65535) == var14 >> 8) {
						var14 &= 255;
						var9[var13] = var11 * var14 >> 8 & 16711935 | var12 * var14 & 65280;
					}
				}
			}

			for (var11 = 0; var11 < var9.length; ++var11) {
				var9[var11] = class221.method4472(var9[var11], var1);
			}

			if (var6 == 0) {
				var11 = 0;
			} else {
				var11 = this.field1963[var6 - 1];
			}

			if (var11 == 0) {
				if (var7.field5017 == var3) {
					for (var12 = 0; var12 < var5; ++var12) {
						this.field1973[var12] = var9[var8[var12] & 255];
					}
				} else if (var7.field5017 == 64 && var3 == 128) {
					var12 = 0;

					for (var13 = 0; var13 < var3; ++var13) {
						for (var14 = 0; var14 < var3; ++var14) {
							this.field1973[var12++] = var9[var8[(var14 >> 1) + (var13 >> 1 << 6)] & 255];
						}
					}
				} else {
					if (var7.field5017 != 128 || var3 != 64) {
						throw new RuntimeException();
					}

					var12 = 0;

					for (var13 = 0; var13 < var3; ++var13) {
						for (var14 = 0; var14 < var3; ++var14) {
							this.field1973[var12++] = var9[var8[(var14 << 1) + (var13 << 1 << 7)] & 255];
						}
					}
				}
			}

			if (var11 == 1) {
			}

			if (var11 == 2) {
			}

			if (var11 == 3) {
			}
		}

		return true;
	}

	void method3438() {
		this.field1973 = null;
	}

	void method3439(int var1) {
		if (this.field1973 != null) {
			short var2;
			int var3;
			int var4;
			int var5;
			int var6;
			int var7;
			int[] var10;
			if (this.field1971 == 1 || this.field1971 == 3) {
				if (field1961 == null || field1961.length < this.field1973.length) {
					field1961 = new int[this.field1973.length];
				}

				if (this.field1973.length == 4096) {
					var2 = 64;
				} else {
					var2 = 128;
				}

				var3 = this.field1973.length;
				var4 = var2 * var1 * this.field1972;
				var5 = var3 - 1;
				if (this.field1971 == 1) {
					var4 = -var4;
				}

				for (var6 = 0; var6 < var3; ++var6) {
					var7 = var6 + var4 & var5;
					field1961[var6] = this.field1973[var7];
				}

				var10 = this.field1973;
				this.field1973 = field1961;
				field1961 = var10;
			}

			if (this.field1971 == 2 || this.field1971 == 4) {
				if (field1961 == null || field1961.length < this.field1973.length) {
					field1961 = new int[this.field1973.length];
				}

				if (this.field1973.length == 4096) {
					var2 = 64;
				} else {
					var2 = 128;
				}

				var3 = this.field1973.length;
				var4 = var1 * this.field1972;
				var5 = var2 - 1;
				if (this.field1971 == 2) {
					var4 = -var4;
				}

				for (var6 = 0; var6 < var3; var6 += var2) {
					for (var7 = 0; var7 < var2; ++var7) {
						int var8 = var6 + var7;
						int var9 = var6 + (var7 + var4 & var5);
						field1961[var8] = this.field1973[var9];
					}
				}

				var10 = this.field1973;
				this.field1973 = field1961;
				field1961 = var10;
			}

		}
	}
}
