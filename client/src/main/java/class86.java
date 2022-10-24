public class class86 {
	class488[] field758;
	int field764;
	int field766;
	int field767;
	int field769;
	int field774;
	int field776;
	int[] field759;
	int[] field762;
	int[] field763;
	int[] field765;
	int[] field770;
	int[] field771;
	int[] field772;
	int[] field773;
	int[] field775;

	class86(class488[] var1) {
		this.field762 = new int[256];
		this.field766 = 0;
		this.field764 = 0;
		this.field769 = 0;
		this.field767 = 0;
		this.field776 = 0;
		this.field774 = 0;
		this.field758 = var1;
		this.method1832();
	}

	void method1832() {
		this.field765 = new int[256];

		int var2;
		for (var2 = 0; var2 < 64; ++var2) {
			this.field765[var2] = 262144 * var2;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field765[var2 + 64] = 16711680 + 1024 * var2;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field765[var2 + 128] = var2 * 4 + 16776960;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field765[var2 + 192] = 16777215;
		}

		this.field775 = new int[256];

		for (var2 = 0; var2 < 64; ++var2) {
			this.field775[var2] = 1024 * var2;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field775[var2 + 64] = var2 * 4 + 65280;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field775[128 + var2] = 65535 + var2 * 262144;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field775[var2 + 192] = 16777215;
		}

		this.field759 = new int[256];

		for (var2 = 0; var2 < 64; ++var2) {
			this.field759[var2] = 4 * var2;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field759[64 + var2] = 262144 * var2 + 255;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field759[var2 + 128] = var2 * 1024 + 16711935;
		}

		for (var2 = 0; var2 < 64; ++var2) {
			this.field759[var2 + 192] = 16777215;
		}

		this.field770 = new int[256];
		this.field767 = 0;
		this.field772 = new int[32768];
		this.field773 = new int[32768];
		this.method1824((class488)null);
		this.field763 = new int[32768];
		this.field771 = new int[32768];
	}

	void method1806() {
		this.field765 = null;
		this.field775 = null;
		this.field759 = null;
		this.field770 = null;
		this.field772 = null;
		this.field773 = null;
		this.field763 = null;
		this.field771 = null;
		this.field767 = 0;
		this.field776 = 0;
	}

	void method1807(int var1, int var2) {
		if (this.field763 == null) {
			this.method1832();
		}

		if (0 == this.field774) {
			this.field774 = var2;
		}

		int var4 = var2 - this.field774;
		if (var4 >= 256) {
			var4 = 0;
		}

		this.field774 = var2;
		if (var4 > 0) {
			this.method1808(var4);
		}

		this.method1836(var1);
	}

	final void method1808(int var1) {
		this.field767 += var1 * 128;
		int var3;
		if (this.field767 > this.field772.length) {
			this.field767 -= this.field772.length;
			var3 = (int)(Math.random() * 12.0D);
			this.method1824(this.field758[var3]);
		}

		var3 = 0;
		int var4 = var1 * 128;
		int var5 = (256 - var1) * 128;

		int var7;
		for (int var6 = 0; var6 < var5; ++var6) {
			var7 = this.field763[var4 + var3] - this.field772[this.field767 + var3 & this.field772.length - 1] * var1 / 6;
			if (var7 < 0) {
				var7 = 0;
			}

			this.field763[var3++] = var7;
		}

		byte var16 = 10;
		var7 = 128 - var16;

		int var8;
		int var11;
		for (var8 = 256 - var1; var8 < 256; ++var8) {
			int var9 = var8 * 128;

			for (int var10 = 0; var10 < 128; ++var10) {
				var11 = (int)(Math.random() * 100.0D);
				if (var11 < 50 && var10 > var16 && var10 < var7) {
					this.field763[var9 + var10] = 255;
				} else {
					this.field763[var9 + var10] = 0;
				}
			}
		}

		if (this.field764 > 0) {
			this.field764 -= 4 * var1;
		}

		if (this.field769 > 0) {
			this.field769 -= var1 * 4;
		}

		if (0 == this.field764 && 0 == this.field769) {
			var8 = (int)(Math.random() * (double)(2000 / var1));
			if (var8 == 0) {
				this.field764 = 1024;
			}

			if (1 == var8) {
				this.field769 = 1024;
			}
		}

		for (var8 = 0; var8 < 256 - var1; ++var8) {
			this.field762[var8] = this.field762[var8 + var1];
		}

		for (var8 = 256 - var1; var8 < 256; ++var8) {
			this.field762[var8] = (int)(Math.sin((double)this.field766 / 14.0D) * 16.0D + Math.sin((double)this.field766 / 15.0D) * 14.0D + Math.sin((double)this.field766 / 16.0D) * 12.0D);
			++this.field766;
		}

		this.field776 += var1;
		var8 = (var1 + (client.field1645 & 1)) / 2;
		if (var8 > 0) {
			short var17 = 128;
			byte var18 = 2;
			var11 = 128 - var18 - var18;

			int var12;
			int var13;
			int var14;
			for (var12 = 0; var12 < this.field776 * 100; ++var12) {
				var13 = (int)(Math.random() * (double)var11) + var18;
				var14 = (int)(Math.random() * (double)var17) + var17;
				this.field763[(var14 << 7) + var13] = 192;
			}

			this.field776 = 0;

			int var15;
			for (var12 = 0; var12 < 256; ++var12) {
				var13 = 0;
				var14 = 128 * var12;

				for (var15 = -var8; var15 < 128; ++var15) {
					if (var8 + var15 < 128) {
						var13 += this.field763[var8 + var15 + var14];
					}

					if (var15 - (1 + var8) >= 0) {
						var13 -= this.field763[var15 + var14 - (1 + var8)];
					}

					if (var15 >= 0) {
						this.field771[var15 + var14] = var13 / (1 + 2 * var8);
					}
				}
			}

			for (var12 = 0; var12 < 128; ++var12) {
				var13 = 0;

				for (var14 = -var8; var14 < 256; ++var14) {
					var15 = var14 * 128;
					if (var8 + var14 < 256) {
						var13 += this.field771[var12 + var15 + var8 * 128];
					}

					if (var14 - (var8 + 1) >= 0) {
						var13 -= this.field771[var12 + var15 - 128 * (1 + var8)];
					}

					if (var14 >= 0) {
						this.field763[var15 + var12] = var13 / (1 + 2 * var8);
					}
				}
			}
		}

	}

	final int method1809(int var1, int var2, int var3) {
		int var5 = 256 - var3;
		return (var5 * (var1 & 16711935) + (var2 & 16711935) * var3 & -16711936) + (var3 * (var2 & 65280) + (var1 & 65280) * var5 & 16711680) >> 8;
	}

	final void method1836(int var1) {
		int var3 = this.field770.length;
		if (this.field764 > 0) {
			this.method1810(this.field764, this.field775);
		} else if (this.field769 > 0) {
			this.method1810(this.field769, this.field759);
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				this.field770[var4] = this.field765[var4];
			}
		}

		this.method1811(var1);
	}

	final void method1810(int var1, int[] var2) {
		int var4 = this.field770.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			if (var1 > 768) {
				this.field770[var5] = this.method1809(this.field765[var5], var2[var5], 1024 - var1);
			} else if (var1 > 256) {
				this.field770[var5] = var2[var5];
			} else {
				this.field770[var5] = this.method1809(var2[var5], this.field765[var5], 256 - var1);
			}
		}

	}

	final void method1811(int var1) {
		int var3 = 0;

		for (int var4 = 1; var4 < 255; ++var4) {
			int var5 = (256 - var4) * this.field762[var4] / 256;
			int var6 = var1 + var5;
			int var7 = 0;
			int var8 = 128;
			if (var6 < 0) {
				var7 = -var6;
				var6 = 0;
			}

			if (var6 + 128 >= class6.field18.field4981) {
				var8 = class6.field18.field4981 - var6;
			}

			int var9 = var6 + class6.field18.field4981 * (var4 + 8);
			var3 += var7;

			for (int var10 = var7; var10 < var8; ++var10) {
				int var11 = this.field763[var3++];
				int var12 = var9 % class481.field4993;
				if (0 != var11 && var12 >= class481.field4997 && var12 < class481.field4996) {
					int var13 = var11;
					int var14 = 256 - var11;
					var11 = this.field770[var11];
					int var15 = class6.field18.field4980[var9];
					class6.field18.field4980[var9++] = -16777216 | ((var11 & 16711935) * var13 + (var15 & 16711935) * var14 & -16711936) + (var14 * (var15 & 65280) + var13 * (var11 & 65280) & 16711680) >> 8;
				} else {
					++var9;
				}
			}

			var3 += 128 - var8;
		}

	}

	static Class method1835(String var0) throws ClassNotFoundException {
		if (var0.equals("B")) {
			return Byte.TYPE;
		} else if (var0.equals("I")) {
			return Integer.TYPE;
		} else if (var0.equals("S")) {
			return Short.TYPE;
		} else if (var0.equals("J")) {
			return Long.TYPE;
		} else if (var0.equals("Z")) {
			return Boolean.TYPE;
		} else if (var0.equals("F")) {
			return Float.TYPE;
		} else if (var0.equals("D")) {
			return Double.TYPE;
		} else if (var0.equals("C")) {
			return Character.TYPE;
		} else {
			return var0.equals("void") ? Void.TYPE : Class.forName(var0);
		}
	}

	final void method1824(class488 var1) {
		int var3;
		for (var3 = 0; var3 < this.field772.length; ++var3) {
			this.field772[var3] = 0;
		}

		int var4;
		for (var3 = 0; var3 < 5000; ++var3) {
			var4 = (int)(Math.random() * 128.0D * 256.0D);
			this.field772[var4] = (int)(Math.random() * 256.0D);
		}

		int var5;
		int var6;
		for (var3 = 0; var3 < 20; ++var3) {
			for (var4 = 1; var4 < 255; ++var4) {
				for (var5 = 1; var5 < 127; ++var5) {
					var6 = (var4 << 7) + var5;
					this.field773[var6] = (this.field772[128 + var6] + this.field772[1 + var6] + this.field772[var6 - 1] + this.field772[var6 - 128]) / 4;
				}
			}

			int[] var9 = this.field772;
			this.field772 = this.field773;
			this.field773 = var9;
		}

		if (null != var1) {
			var3 = 0;

			for (var4 = 0; var4 < var1.field5019; ++var4) {
				for (var5 = 0; var5 < var1.field5017; ++var5) {
					if (var1.field5022[var3++] != 0) {
						var6 = var5 + 16 + var1.field5020;
						int var7 = 16 + var4 + var1.field5021;
						int var8 = (var7 << 7) + var6;
						this.field772[var8] = 0;
					}
				}
			}
		}

	}

	static class218 method1819(int var0) {
		class218 var2 = (class218)class189.field2001.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			class319 var4 = class37.field250;
			class319 var5 = class189.field1993;
			boolean var6 = true;
			int[] var7 = var4.method6098(var0);

			for (int var8 = 0; var8 < var7.length; ++var8) {
				byte[] var9 = var4.method6131(var0, var7[var8]);
				if (var9 == null) {
					var6 = false;
				} else {
					int var10 = (var9[0] & 255) << 8 | var9[1] & 255;
					byte[] var11 = var5.method6131(var10, 0);
					if (var11 == null) {
						var6 = false;
					}
				}
			}

			class218 var3;
			if (!var6) {
				var3 = null;
			} else {
				try {
					var3 = new class218(var4, var5, var0, false);
				} catch (Exception var13) {
					var3 = null;
				}
			}

			if (null != var3) {
				class189.field2001.method5434(var3, (long)var0);
			}

			return var3;
		}
	}
}
