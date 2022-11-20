public class class198 extends class437 {
	public static class319 field2125;
	static class284 field2126;
	static class284 field2163;
	static class284 field2173;
	class421 field2174;
	int field2121;
	int field2123;
	int field2127;
	int field2141;
	int field2147;
	int field2150;
	int field2151;
	int field2153;
	int field2154;
	int field2155;
	int field2156;
	int field2157;
	int field2158;
	int field2161;
	int field2167;
	int field2168;
	int field2169;
	int field2177;
	int field2180;
	int[] field2136;
	int[] field2164;
	public boolean field2162;
	public boolean field2175;
	public int field2128;
	public int field2129;
	public int field2130;
	public int field2137;
	public int field2138;
	public int field2139;
	public int field2140;
	public int field2142;
	public int field2143;
	public int field2144;
	public int field2145;
	public int field2146;
	public int field2152;
	public int field2159;
	public int field2165;
	public int field2166;
	public int field2170;
	public int field2171;
	public int field2172;
	public int field2179;
	public String field2131;
	public String[] field2148;
	public String[] field2149;
	public short[] field2132;
	public short[] field2133;
	public short[] field2135;
	public short[] field2160;

	static {
		field2126 = new class284(64);
		field2173 = new class284(50);
		field2163 = new class284(200);
	}

	class198() {
		this.field2131 = class338.field3899;
		this.field2144 = 2000;
		this.field2137 = 0;
		this.field2138 = 0;
		this.field2139 = 0;
		this.field2140 = 0;
		this.field2128 = 0;
		this.field2142 = 0;
		this.field2143 = 1;
		this.field2130 = -1;
		this.field2145 = -1;
		this.field2146 = -1;
		this.field2162 = false;
		this.field2148 = new String[]{null, null, class338.field3949, null, null};
		this.field2149 = new String[]{null, null, null, null, class338.field3893};
		this.field2177 = -2;
		this.field2121 = -1;
		this.field2157 = -1;
		this.field2153 = 0;
		this.field2154 = -1;
		this.field2155 = -1;
		this.field2156 = 0;
		this.field2150 = -1;
		this.field2158 = -1;
		this.field2161 = -1;
		this.field2141 = -1;
		this.field2180 = -1;
		this.field2127 = -1;
		this.field2165 = -1;
		this.field2166 = -1;
		this.field2167 = 128;
		this.field2168 = 128;
		this.field2169 = 128;
		this.field2159 = 0;
		this.field2171 = 0;
		this.field2172 = 0;
		this.field2170 = 0;
		this.field2175 = false;
		this.field2147 = -1;
		this.field2123 = -1;
		this.field2152 = -1;
		this.field2179 = -1;
	}

	void method3643() {
		if (1 == this.field2142) {
			this.field2170 = 0;
		}

	}

	void method3649(Buffer var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3645(var1, var3);
		}
	}

	void method3645(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field2151 = var1.readUnsignedShort();
		} else if (var2 == 2) {
			this.field2131 = var1.readString();
		} else if (var2 == 4) {
			this.field2144 = var1.readUnsignedShort();
		} else if (var2 == 5) {
			this.field2137 = var1.readUnsignedShort();
		} else if (var2 == 6) {
			this.field2138 = var1.readUnsignedShort();
		} else if (var2 == 7) {
			this.field2140 = var1.readUnsignedShort();
			if (this.field2140 > 32767) {
				this.field2140 -= 65536;
			}
		} else if (var2 == 8) {
			this.field2128 = var1.readUnsignedShort();
			if (this.field2128 > 32767) {
				this.field2128 -= 65536;
			}
		} else if (var2 == 9) {
			var1.readString();
		} else if (var2 == 11) {
			this.field2142 = 1;
		} else if (var2 == 12) {
			this.field2143 = var1.method8126();
		} else if (var2 == 13) {
			this.field2130 = var1.method8141();
		} else if (var2 == 14) {
			this.field2145 = var1.method8141();
		} else if (var2 == 16) {
			this.field2162 = true;
		} else if (var2 == 23) {
			this.field2121 = var1.readUnsignedShort();
			this.field2153 = var1.method8141();
		} else if (var2 == 24) {
			this.field2157 = var1.readUnsignedShort();
		} else if (var2 == 25) {
			this.field2154 = var1.readUnsignedShort();
			this.field2156 = var1.method8141();
		} else if (var2 == 26) {
			this.field2155 = var1.readUnsignedShort();
		} else if (var2 == 27) {
			this.field2146 = var1.method8141();
		} else if (var2 >= 30 && var2 < 35) {
			this.field2148[var2 - 30] = var1.readString();
			if (this.field2148[var2 - 30].equalsIgnoreCase(class338.field3894)) {
				this.field2148[var2 - 30] = null;
			}
		} else if (var2 >= 35 && var2 < 40) {
			this.field2149[var2 - 35] = var1.readString();
		} else {
			int var4;
			int var5;
			if (var2 == 40) {
				var4 = var1.method8141();
				this.field2132 = new short[var4];
				this.field2133 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field2132[var5] = (short)var1.readUnsignedShort();
					this.field2133[var5] = (short)var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var4 = var1.method8141();
				this.field2160 = new short[var4];
				this.field2135 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field2160[var5] = (short)var1.readUnsignedShort();
					this.field2135[var5] = (short)var1.readUnsignedShort();
				}
			} else if (var2 == 42) {
				this.field2177 = var1.method8287();
			} else if (var2 == 65) {
				this.field2175 = true;
			} else if (var2 == 75) {
				this.field2170 = var1.method8204();
			} else if (var2 == 78) {
				this.field2150 = var1.readUnsignedShort();
			} else if (var2 == 79) {
				this.field2158 = var1.readUnsignedShort();
			} else if (var2 == 90) {
				this.field2161 = var1.readUnsignedShort();
			} else if (var2 == 91) {
				this.field2180 = var1.readUnsignedShort();
			} else if (var2 == 92) {
				this.field2141 = var1.readUnsignedShort();
			} else if (var2 == 93) {
				this.field2127 = var1.readUnsignedShort();
			} else if (var2 == 94) {
				var1.readUnsignedShort();
			} else if (var2 == 95) {
				this.field2139 = var1.readUnsignedShort();
			} else if (var2 == 97) {
				this.field2165 = var1.readUnsignedShort();
			} else if (var2 == 98) {
				this.field2166 = var1.readUnsignedShort();
			} else if (var2 >= 100 && var2 < 110) {
				if (null == this.field2136) {
					this.field2136 = new int[10];
					this.field2164 = new int[10];
				}

				this.field2136[var2 - 100] = var1.readUnsignedShort();
				this.field2164[var2 - 100] = var1.readUnsignedShort();
			} else if (var2 == 110) {
				this.field2167 = var1.readUnsignedShort();
			} else if (var2 == 111) {
				this.field2168 = var1.readUnsignedShort();
			} else if (var2 == 112) {
				this.field2169 = var1.readUnsignedShort();
			} else if (var2 == 113) {
				this.field2159 = var1.method8287();
			} else if (var2 == 114) {
				this.field2171 = var1.method8287() * 5;
			} else if (var2 == 115) {
				this.field2172 = var1.method8141();
			} else if (var2 == 139) {
				this.field2147 = var1.readUnsignedShort();
			} else if (var2 == 140) {
				this.field2123 = var1.readUnsignedShort();
			} else if (var2 == 148) {
				this.field2152 = var1.readUnsignedShort();
			} else if (var2 == 149) {
				this.field2179 = var1.readUnsignedShort();
			} else if (var2 == 249) {
				this.field2174 = class233.method4559(var1, this.field2174);
			}
		}

	}

	void method3646(class198 var1, class198 var2) {
		this.field2151 = var1.field2151;
		this.field2144 = var1.field2144;
		this.field2137 = var1.field2137;
		this.field2138 = var1.field2138;
		this.field2139 = var1.field2139;
		this.field2140 = var1.field2140;
		this.field2128 = var1.field2128;
		this.field2132 = var1.field2132;
		this.field2133 = var1.field2133;
		this.field2160 = var1.field2160;
		this.field2135 = var1.field2135;
		this.field2131 = var2.field2131;
		this.field2162 = var2.field2162;
		this.field2143 = var2.field2143;
		this.field2142 = 1;
	}

	void method3650(class198 var1, class198 var2) {
		this.field2151 = var1.field2151;
		this.field2144 = var1.field2144;
		this.field2137 = var1.field2137;
		this.field2138 = var1.field2138;
		this.field2139 = var1.field2139;
		this.field2140 = var1.field2140;
		this.field2128 = var1.field2128;
		this.field2132 = var2.field2132;
		this.field2133 = var2.field2133;
		this.field2160 = var2.field2160;
		this.field2135 = var2.field2135;
		this.field2131 = var2.field2131;
		this.field2162 = var2.field2162;
		this.field2142 = var2.field2142;
		this.field2130 = var2.field2130;
		this.field2145 = var2.field2145;
		this.field2146 = var2.field2146;
		this.field2121 = var2.field2121;
		this.field2157 = var2.field2157;
		this.field2150 = var2.field2150;
		this.field2154 = var2.field2154;
		this.field2155 = var2.field2155;
		this.field2158 = var2.field2158;
		this.field2161 = var2.field2161;
		this.field2141 = var2.field2141;
		this.field2180 = var2.field2180;
		this.field2127 = var2.field2127;
		this.field2172 = var2.field2172;
		this.field2148 = var2.field2148;
		this.field2170 = var2.field2170;
		this.field2149 = new String[5];
		if (null != var2.field2149) {
			for (int var4 = 0; var4 < 4; ++var4) {
				this.field2149[var4] = var2.field2149[var4];
			}
		}

		this.field2149[4] = class338.field4131;
		this.field2143 = 0;
	}

	void method3666(class198 var1, class198 var2) {
		this.field2151 = var1.field2151;
		this.field2144 = var1.field2144;
		this.field2137 = var1.field2137;
		this.field2138 = var1.field2138;
		this.field2139 = var1.field2139;
		this.field2140 = var1.field2140;
		this.field2128 = var1.field2128;
		this.field2132 = var1.field2132;
		this.field2133 = var1.field2133;
		this.field2160 = var1.field2160;
		this.field2135 = var1.field2135;
		this.field2142 = var1.field2142;
		this.field2131 = var2.field2131;
		this.field2143 = 0;
		this.field2162 = false;
		this.field2175 = false;
	}

	public final class201 method3665(int var1) {
		int var4;
		if (null != this.field2136 && var1 > 1) {
			int var3 = -1;

			for (var4 = 0; var4 < 10; ++var4) {
				if (var1 >= this.field2164[var4] && 0 != this.field2164[var4]) {
					var3 = this.field2136[var4];
				}
			}

			if (var3 != -1) {
				return class278.method5388(var3).method3665(1);
			}
		}

		class201 var5 = class201.method3774(field2125, this.field2151, 0);
		if (null == var5) {
			return null;
		} else {
			if (128 != this.field2167 || this.field2168 != 128 || this.field2169 != 128) {
				var5.method3776(this.field2167, this.field2168, this.field2169);
			}

			if (this.field2132 != null) {
				for (var4 = 0; var4 < this.field2132.length; ++var4) {
					var5.method3790(this.field2132[var4], this.field2133[var4]);
				}
			}

			if (null != this.field2160) {
				for (var4 = 0; var4 < this.field2160.length; ++var4) {
					var5.method3791(this.field2160[var4], this.field2135[var4]);
				}
			}

			return var5;
		}
	}

	public final class209 method3648(int var1) {
		if (this.field2136 != null && var1 > 1) {
			int var3 = -1;

			for (int var4 = 0; var4 < 10; ++var4) {
				if (var1 >= this.field2164[var4] && this.field2164[var4] != 0) {
					var3 = this.field2136[var4];
				}
			}

			if (var3 != -1) {
				return class278.method5388(var3).method3648(1);
			}
		}

		class209 var6 = (class209)field2173.method5439((long)this.field2129);
		if (null != var6) {
			return var6;
		} else {
			class201 var7 = class201.method3774(field2125, this.field2151, 0);
			if (var7 == null) {
				return null;
			} else {
				if (this.field2167 != 128 || this.field2168 != 128 || 128 != this.field2169) {
					var7.method3776(this.field2167, this.field2168, this.field2169);
				}

				int var5;
				if (this.field2132 != null) {
					for (var5 = 0; var5 < this.field2132.length; ++var5) {
						var7.method3790(this.field2132[var5], this.field2133[var5]);
					}
				}

				if (null != this.field2160) {
					for (var5 = 0; var5 < this.field2160.length; ++var5) {
						var7.method3791(this.field2160[var5], this.field2135[var5]);
					}
				}

				var6 = var7.method3796(64 + this.field2159, this.field2171 + 768, -50, -10, -50);
				var6.field2407 = true;
				field2173.method5434(var6, (long)this.field2129);
				return var6;
			}
		}
	}

	public class198 method3651(int var1) {
		if (null != this.field2136 && var1 > 1) {
			int var3 = -1;

			for (int var4 = 0; var4 < 10; ++var4) {
				if (var1 >= this.field2164[var4] && this.field2164[var4] != 0) {
					var3 = this.field2136[var4];
				}
			}

			if (var3 != -1) {
				return class278.method5388(var3);
			}
		}

		return this;
	}

	public final boolean method3694(int var1) {
		int var3 = this.field2121;
		int var4 = this.field2157;
		int var5 = this.field2150;
		if (var1 == 1) {
			var3 = this.field2154;
			var4 = this.field2155;
			var5 = this.field2158;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var6 = true;
			if (!field2125.method6089(var3, 0)) {
				var6 = false;
			}

			if (var4 != -1 && !field2125.method6089(var4, 0)) {
				var6 = false;
			}

			if (var5 != -1 && !field2125.method6089(var5, 0)) {
				var6 = false;
			}

			return var6;
		}
	}

	public final class201 method3647(int var1) {
		int var3 = this.field2121;
		int var4 = this.field2157;
		int var5 = this.field2150;
		if (var1 == 1) {
			var3 = this.field2154;
			var4 = this.field2155;
			var5 = this.field2158;
		}

		if (var3 == -1) {
			return null;
		} else {
			class201 var6 = class201.method3774(field2125, var3, 0);
			if (var4 != -1) {
				class201 var7 = class201.method3774(field2125, var4, 0);
				if (var5 != -1) {
					class201 var8 = class201.method3774(field2125, var5, 0);
					class201[] var9 = new class201[]{var6, var7, var8};
					var6 = new class201(var9, 3);
				} else {
					class201[] var11 = new class201[]{var6, var7};
					var6 = new class201(var11, 2);
				}
			}

			if (var1 == 0 && 0 != this.field2153) {
				var6.method3822(0, this.field2153, 0);
			}

			if (var1 == 1 && this.field2156 != 0) {
				var6.method3822(0, this.field2156, 0);
			}

			int var10;
			if (null != this.field2132) {
				for (var10 = 0; var10 < this.field2132.length; ++var10) {
					var6.method3790(this.field2132[var10], this.field2133[var10]);
				}
			}

			if (null != this.field2160) {
				for (var10 = 0; var10 < this.field2160.length; ++var10) {
					var6.method3791(this.field2160[var10], this.field2135[var10]);
				}
			}

			return var6;
		}
	}

	public final boolean method3692(int var1) {
		int var3 = this.field2161;
		int var4 = this.field2141;
		if (var1 == 1) {
			var3 = this.field2180;
			var4 = this.field2127;
		}

		if (var3 == -1) {
			return true;
		} else {
			boolean var5 = true;
			if (!field2125.method6089(var3, 0)) {
				var5 = false;
			}

			if (var4 != -1 && !field2125.method6089(var4, 0)) {
				var5 = false;
			}

			return var5;
		}
	}

	public final class201 method3655(int var1) {
		int var3 = this.field2161;
		int var4 = this.field2141;
		if (var1 == 1) {
			var3 = this.field2180;
			var4 = this.field2127;
		}

		if (var3 == -1) {
			return null;
		} else {
			class201 var5 = class201.method3774(field2125, var3, 0);
			if (var4 != -1) {
				class201 var6 = class201.method3774(field2125, var4, 0);
				class201[] var7 = new class201[]{var5, var6};
				var5 = new class201(var7, 2);
			}

			int var8;
			if (null != this.field2132) {
				for (var8 = 0; var8 < this.field2132.length; ++var8) {
					var5.method3790(this.field2132[var8], this.field2133[var8]);
				}
			}

			if (null != this.field2160) {
				for (var8 = 0; var8 < this.field2160.length; ++var8) {
					var5.method3791(this.field2160[var8], this.field2135[var8]);
				}
			}

			return var5;
		}
	}

	public int method3656(int var1, int var2) {
		return class353.method6569(this.field2174, var1, var2);
	}

	public String method3657(int var1, String var2) {
		return class369.method6734(this.field2174, var1, var2);
	}

	public int method3658() {
		if (this.field2177 != -1 && this.field2149 != null) {
			if (this.field2177 >= 0) {
				return null != this.field2149[this.field2177] ? this.field2177 : -1;
			} else {
				return class338.field3893.equalsIgnoreCase(this.field2149[4]) ? 4 : -1;
			}
		} else {
			return -1;
		}
	}

	public static void method4555() {
		field2126.method5437();
		field2173.method5437();
		field2163.method5437();
	}

	public static void method716() {
		field2163.method5437();
	}

	public static void method5207(boolean var0) {
		if (class6.field16 != var0) {
			method4555();
			class6.field16 = var0;
		}

	}

	boolean method3653() {
		return this.field2133 != null;
	}

	boolean method3689() {
		return this.field2135 != null;
	}

	static void method3654() {
		for (InterfaceParent var1 = (InterfaceParent)client.parentInterfaces.first(); var1 != null; var1 = (InterfaceParent)client.parentInterfaces.next()) {
			int var2 = var1.field796;
			if (class246.method4928(var2)) {
				boolean var3 = true;
				class300[] var4 = class300.field3593[var2];

				int var5;
				for (var5 = 0; var5 < var4.length; ++var5) {
					if (var4[var5] != null) {
						var3 = var4[var5].field3459;
						break;
					}
				}

				if (!var3) {
					var5 = (int)var1.field4681;
					class300 var6 = class282.method5426(var5);
					if (null != var6) {
						class136.method2438(var6);
					}
				}
			}
		}

	}
}
