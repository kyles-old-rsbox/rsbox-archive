public class class195 extends class437 {
	public static boolean field2082;
	public static class284 field2056;
	public static class319 field2053;
	public static class319 field2054;
	static class201[] field2059;
	static class284 field2055;
	static class284 field2058;
	static class284 field2074;
	static int loginRetryLength;
	boolean field2065;
	boolean field2083;
	boolean field2085;
	class421 field2103;
	int field2061;
	int field2062;
	int field2073;
	int field2078;
	int field2080;
	int field2087;
	int field2088;
	int field2089;
	int field2090;
	int field2095;
	int field2096;
	int[] field2057;
	int[] field2079;
	short[] field2064;
	short[] field2066;
	short[] field2067;
	short[] field2092;
	public boolean field2068;
	public boolean field2071;
	public boolean field2084;
	public boolean field2091;
	public boolean field2099;
	public int field2052;
	public int field2069;
	public int field2070;
	public int field2072;
	public int field2075;
	public int field2076;
	public int field2077;
	public int field2081;
	public int field2086;
	public int field2093;
	public int field2097;
	public int field2098;
	public int field2100;
	public int field2102;
	public int[] field2094;
	public int[] field2101;
	public String field2063;
	public String[] field2060;

	static {
		field2082 = false;
		field2055 = new class284(4096);
		field2056 = new class284(500);
		field2074 = new class284(30);
		field2058 = new class284(30);
		field2059 = new class201[4];
	}

	class195() {
		this.field2063 = class338.field3899;
		this.field2100 = 1;
		this.field2069 = 1;
		this.field2070 = 2;
		this.field2071 = true;
		this.field2072 = -1;
		this.field2073 = -1;
		this.field2065 = false;
		this.field2091 = false;
		this.field2076 = -1;
		this.field2077 = 16;
		this.field2061 = 0;
		this.field2078 = 0;
		this.field2060 = new String[5];
		this.field2081 = -1;
		this.field2075 = -1;
		this.field2083 = false;
		this.field2084 = true;
		this.field2080 = 128;
		this.field2062 = 128;
		this.field2087 = 128;
		this.field2088 = 0;
		this.field2089 = 0;
		this.field2090 = 0;
		this.field2068 = false;
		this.field2085 = false;
		this.field2093 = -1;
		this.field2095 = -1;
		this.field2096 = -1;
		this.field2097 = -1;
		this.field2098 = 0;
		this.field2086 = 0;
		this.field2102 = 0;
		this.field2099 = true;
	}

	void method3582() {
		if (-1 == this.field2072) {
			this.field2072 = 0;
			if (null != this.field2057 && (null == this.field2079 || this.field2079[0] == 10)) {
				this.field2072 = 1;
			}

			for (int var2 = 0; var2 < 5; ++var2) {
				if (null != this.field2060[var2]) {
					this.field2072 = 1;
				}
			}
		}

		if (this.field2093 == -1) {
			this.field2093 = this.field2070 != 0 ? 1 : 0;
		}

	}

	void method3580(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method3581(var1, var3);
		}
	}

	void method3581(Buffer var1, int var2) {
		int var4;
		int var5;
		if (var2 == 1) {
			var4 = var1.readUnsignedByte();
			if (var4 > 0) {
				if (null != this.field2057 && !field2082) {
					var1.offset += var4 * 3;
				} else {
					this.field2079 = new int[var4];
					this.field2057 = new int[var4];

					for (var5 = 0; var5 < var4; ++var5) {
						this.field2057[var5] = var1.readUnsignedShort();
						this.field2079[var5] = var1.readUnsignedByte();
					}
				}
			}
		} else if (var2 == 2) {
			this.field2063 = var1.readString();
		} else if (var2 == 5) {
			var4 = var1.readUnsignedByte();
			if (var4 > 0) {
				if (null != this.field2057 && !field2082) {
					var1.offset += var4 * 2;
				} else {
					this.field2079 = null;
					this.field2057 = new int[var4];

					for (var5 = 0; var5 < var4; ++var5) {
						this.field2057[var5] = var1.readUnsignedShort();
					}
				}
			}
		} else if (var2 == 14) {
			this.field2100 = var1.readUnsignedByte();
		} else if (var2 == 15) {
			this.field2069 = var1.readUnsignedByte();
		} else if (var2 == 17) {
			this.field2070 = 0;
			this.field2071 = false;
		} else if (var2 == 18) {
			this.field2071 = false;
		} else if (var2 == 19) {
			this.field2072 = var1.readUnsignedByte();
		} else if (var2 == 21) {
			this.field2073 = 0;
		} else if (var2 == 22) {
			this.field2065 = true;
		} else if (var2 == 23) {
			this.field2091 = true;
		} else if (var2 == 24) {
			this.field2076 = var1.readUnsignedShort();
			if (this.field2076 == 65535) {
				this.field2076 = -1;
			}
		} else if (var2 == 27) {
			this.field2070 = 1;
		} else if (var2 == 28) {
			this.field2077 = var1.readUnsignedByte();
		} else if (var2 == 29) {
			this.field2061 = var1.readByte();
		} else if (var2 == 39) {
			this.field2078 = var1.readByte() * 25;
		} else if (var2 >= 30 && var2 < 35) {
			this.field2060[var2 - 30] = var1.readString();
			if (this.field2060[var2 - 30].equalsIgnoreCase(class338.field3894)) {
				this.field2060[var2 - 30] = null;
			}
		} else if (var2 == 40) {
			var4 = var1.readUnsignedByte();
			this.field2064 = new short[var4];
			this.field2092 = new short[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2064[var5] = (short)var1.readUnsignedShort();
				this.field2092[var5] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 41) {
			var4 = var1.readUnsignedByte();
			this.field2066 = new short[var4];
			this.field2067 = new short[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2066[var5] = (short)var1.readUnsignedShort();
				this.field2067[var5] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 61) {
			var1.readUnsignedShort();
		} else if (var2 == 62) {
			this.field2083 = true;
		} else if (var2 == 64) {
			this.field2084 = false;
		} else if (var2 == 65) {
			this.field2080 = var1.readUnsignedShort();
		} else if (var2 == 66) {
			this.field2062 = var1.readUnsignedShort();
		} else if (var2 == 67) {
			this.field2087 = var1.readUnsignedShort();
		} else if (var2 == 68) {
			this.field2075 = var1.readUnsignedShort();
		} else if (var2 == 69) {
			var1.readUnsignedByte();
		} else if (var2 == 70) {
			this.field2088 = var1.method8204();
		} else if (var2 == 71) {
			this.field2089 = var1.method8204();
		} else if (var2 == 72) {
			this.field2090 = var1.method8204();
		} else if (var2 == 73) {
			this.field2068 = true;
		} else if (var2 == 74) {
			this.field2085 = true;
		} else if (var2 == 75) {
			this.field2093 = var1.readUnsignedByte();
		} else if (var2 != 77 && var2 != 92) {
			if (var2 == 78) {
				this.field2097 = var1.readUnsignedShort();
				this.field2098 = var1.readUnsignedByte();
			} else if (var2 == 79) {
				this.field2086 = var1.readUnsignedShort();
				this.field2102 = var1.readUnsignedShort();
				this.field2098 = var1.readUnsignedByte();
				var4 = var1.readUnsignedByte();
				this.field2101 = new int[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field2101[var5] = var1.readUnsignedShort();
				}
			} else if (var2 == 81) {
				this.field2073 = var1.readUnsignedByte() * 256;
			} else if (var2 == 82) {
				this.field2081 = var1.readUnsignedShort();
			} else if (var2 == 89) {
				this.field2099 = false;
			} else if (var2 == 249) {
				this.field2103 = class233.method4559(var1, this.field2103);
			}
		} else {
			this.field2095 = var1.readUnsignedShort();
			if (this.field2095 == 65535) {
				this.field2095 = -1;
			}

			this.field2096 = var1.readUnsignedShort();
			if (this.field2096 == 65535) {
				this.field2096 = -1;
			}

			var4 = -1;
			if (var2 == 92) {
				var4 = var1.readUnsignedShort();
				if (var4 == 65535) {
					var4 = -1;
				}
			}

			var5 = var1.readUnsignedByte();
			this.field2094 = new int[var5 + 2];

			for (int var6 = 0; var6 <= var5; ++var6) {
				this.field2094[var6] = var1.readUnsignedShort();
				if (65535 == this.field2094[var6]) {
					this.field2094[var6] = -1;
				}
			}

			this.field2094[var5 + 1] = var4;
		}

	}

	public final boolean method3619(int var1) {
		if (null != this.field2079) {
			for (int var5 = 0; var5 < this.field2079.length; ++var5) {
				if (var1 == this.field2079[var5]) {
					return field2054.method6089(this.field2057[var5] & 65535, 0);
				}
			}

			return true;
		} else if (null == this.field2057) {
			return true;
		} else if (var1 != 10) {
			return true;
		} else {
			boolean var3 = true;

			for (int var4 = 0; var4 < this.field2057.length; ++var4) {
				var3 &= field2054.method6089(this.field2057[var4] & 65535, 0);
			}

			return var3;
		}
	}

	public final boolean method3587() {
		if (this.field2057 == null) {
			return true;
		} else {
			boolean var2 = true;

			for (int var3 = 0; var3 < this.field2057.length; ++var3) {
				var2 &= field2054.method6089(this.field2057[var3] & 65535, 0);
			}

			return var2;
		}
	}

	public final class212 method3584(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var8;
		if (null == this.field2079) {
			var8 = (long)(var2 + (this.field2052 << 10));
		} else {
			var8 = (long)(var2 + (this.field2052 << 10) + (var1 << 3));
		}

		Object var10 = (class212)field2074.method5439(var8);
		if (null == var10) {
			class201 var11 = this.method3579(var1, var2);
			if (var11 == null) {
				return null;
			}

			if (!this.field2065) {
				var10 = var11.method3796(64 + this.field2061, this.field2078 + 768, -50, -10, -50);
			} else {
				var11.field2239 = (short)(this.field2061 + 64);
				var11.field2240 = (short)(768 + this.field2078);
				var11.method3793();
				var10 = var11;
			}

			field2074.method5434((class437)var10, var8);
		}

		if (this.field2065) {
			var10 = ((class201)var10).method3782();
		}

		if (this.field2073 >= 0) {
			if (var10 instanceof class209) {
				var10 = ((class209)var10).method4011(var3, var4, var5, var6, true, this.field2073);
			} else if (var10 instanceof class201) {
				var10 = ((class201)var10).method3798(var3, var4, var5, var6, true, this.field2073);
			}
		}

		return (class212)var10;
	}

	public final class209 method3598(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
		long var8;
		if (this.field2079 == null) {
			var8 = (long)((this.field2052 << 10) + var2);
		} else {
			var8 = (long)(var2 + (var1 << 3) + (this.field2052 << 10));
		}

		class209 var10 = (class209)field2058.method5439(var8);
		if (var10 == null) {
			class201 var11 = this.method3579(var1, var2);
			if (null == var11) {
				return null;
			}

			var10 = var11.method3796(64 + this.field2061, this.field2078 + 768, -50, -10, -50);
			field2058.method5434(var10, var8);
		}

		if (this.field2073 >= 0) {
			var10 = var10.method4011(var3, var4, var5, var6, true, this.field2073);
		}

		return var10;
	}

	public final class209 method3586(int var1, int var2, int[][] var3, int var4, int var5, int var6, class189 var7, int var8) {
		long var10;
		if (null == this.field2079) {
			var10 = (long)(var2 + (this.field2052 << 10));
		} else {
			var10 = (long)(var2 + (this.field2052 << 10) + (var1 << 3));
		}

		class209 var12 = (class209)field2058.method5439(var10);
		if (null == var12) {
			class201 var13 = this.method3579(var1, var2);
			if (null == var13) {
				return null;
			}

			var12 = var13.method3796(64 + this.field2061, 768 + this.field2078, -50, -10, -50);
			field2058.method5434(var12, var10);
		}

		if (var7 == null && this.field2073 == -1) {
			return var12;
		} else {
			if (null != var7) {
				var12 = var7.method3470(var12, var8, var2);
			} else {
				var12 = var12.method3988(true);
			}

			if (this.field2073 >= 0) {
				var12 = var12.method4011(var3, var4, var5, var6, false, this.field2073);
			}

			return var12;
		}
	}

	final class201 method3579(int var1, int var2) {
		class201 var4 = null;
		boolean var5;
		int var6;
		int var8;
		if (null == this.field2079) {
			if (var1 != 10) {
				return null;
			}

			if (null == this.field2057) {
				return null;
			}

			var5 = this.field2083;
			if (var1 == 2 && var2 > 3) {
				var5 = !var5;
			}

			var6 = this.field2057.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				var8 = this.field2057[var7];
				if (var5) {
					var8 += 65536;
				}

				var4 = (class201)field2056.method5439((long)var8);
				if (null == var4) {
					var4 = class201.method3774(field2054, var8 & 65535, 0);
					if (var4 == null) {
						return null;
					}

					if (var5) {
						var4.method3792();
					}

					field2056.method5434(var4, (long)var8);
				}

				if (var6 > 1) {
					field2059[var7] = var4;
				}
			}

			if (var6 > 1) {
				var4 = new class201(field2059, var6);
			}
		} else {
			int var10 = -1;

			for (var6 = 0; var6 < this.field2079.length; ++var6) {
				if (var1 == this.field2079[var6]) {
					var10 = var6;
					break;
				}
			}

			if (var10 == -1) {
				return null;
			}

			var6 = this.field2057[var10];
			boolean var11 = this.field2083 ^ var2 > 3;
			if (var11) {
				var6 += 65536;
			}

			var4 = (class201)field2056.method5439((long)var6);
			if (var4 == null) {
				var4 = class201.method3774(field2054, var6 & 65535, 0);
				if (var4 == null) {
					return null;
				}

				if (var11) {
					var4.method3792();
				}

				field2056.method5434(var4, (long)var6);
			}
		}

		if (this.field2080 == 128 && this.field2062 == 128 && this.field2087 == 128) {
			var5 = false;
		} else {
			var5 = true;
		}

		boolean var12;
		if (this.field2088 == 0 && 0 == this.field2089 && 0 == this.field2090) {
			var12 = false;
		} else {
			var12 = true;
		}

		class201 var9 = new class201(var4, var2 == 0 && !var5 && !var12, this.field2064 == null, this.field2066 == null, true);
		if (var1 == 4 && var2 > 3) {
			var9.method3788(256);
			var9.method3822(45, 0, -45);
		}

		var2 &= 3;
		if (var2 == 1) {
			var9.method3821();
		} else if (var2 == 2) {
			var9.method3786();
		} else if (var2 == 3) {
			var9.method3787();
		}

		if (null != this.field2064) {
			for (var8 = 0; var8 < this.field2064.length; ++var8) {
				var9.method3790(this.field2064[var8], this.field2092[var8]);
			}
		}

		if (null != this.field2066) {
			for (var8 = 0; var8 < this.field2066.length; ++var8) {
				var9.method3791(this.field2066[var8], this.field2067[var8]);
			}
		}

		if (var5) {
			var9.method3776(this.field2080, this.field2062, this.field2087);
		}

		if (var12) {
			var9.method3822(this.field2088, this.field2089, this.field2090);
		}

		return var9;
	}

	public static class112 method3594(int var0) {
		class112 var2 = (class112)class189.field2010.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			var2 = class126.method2372(class37.field250, class189.field1993, var0, false);
			if (var2 != null) {
				class189.field2010.method5434(var2, (long)var0);
			}

			return var2;
		}
	}

	public final class195 method3588() {
		int var2 = -1;
		if (this.field2095 != -1) {
			var2 = class293.method1557(this.field2095);
		} else if (this.field2096 != -1) {
			var2 = class293.varps[this.field2096];
		}

		int var3;
		if (var2 >= 0 && var2 < this.field2094.length - 1) {
			var3 = this.field2094[var2];
		} else {
			var3 = this.field2094[this.field2094.length - 1];
		}

		return var3 != -1 ? InterfaceParent.method1866(var3) : null;
	}

	public int method3614(int var1, int var2) {
		return class353.method6569(this.field2103, var1, var2);
	}

	public String method3590(int var1, String var2) {
		return class369.method6734(this.field2103, var1, var2);
	}

	public static void method2401() {
		field2055.method5437();
		field2056.method5437();
		field2074.method5437();
		field2058.method5437();
	}

	public boolean method3578() {
		if (null == this.field2094) {
			return -1 != this.field2097 || this.field2101 != null;
		} else {
			for (int var2 = 0; var2 < this.field2094.length; ++var2) {
				if (-1 != this.field2094[var2]) {
					class195 var3 = InterfaceParent.method1866(this.field2094[var2]);
					if (-1 != var3.field2097 || var3.field2101 != null) {
						return true;
					}
				}
			}

			return false;
		}
	}
}
