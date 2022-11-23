public class class203 extends class437 {
	public static class319 field2257;
	public static class319 field2293;
	static class284 field2259;
	static class284 field2267;
	class421 field2300;
	int field2276;
	int field2279;
	int field2288;
	int field2290;
	int field2295;
	int field2296;
	int[] field2275;
	int[] field2283;
	short[] field2258;
	short[] field2263;
	short[] field2280;
	short[] field2281;
	public boolean field2282;
	public boolean field2285;
	public boolean field2287;
	public boolean field2289;
	public boolean field2298;
	public int field2256;
	public int field2260;
	public int field2262;
	public int field2264;
	public int field2265;
	public int field2266;
	public int field2268;
	public int field2269;
	public int field2270;
	public int field2271;
	public int field2272;
	public int field2273;
	public int field2274;
	public int field2277;
	public int field2286;
	public int field2291;
	public int field2292;
	public int field2294;
	public int field2297;
	public int field2299;
	public int[] field2278;
	public String field2261;
	public String[] field2284;

	static {
		field2267 = new class284(64);
		field2259 = new class284(50);
	}

	class203() {
		this.field2261 = class338.field3899;
		this.field2262 = 1;
		this.field2265 = -1;
		this.field2266 = -1;
		this.field2264 = -1;
		this.field2268 = -1;
		this.field2269 = -1;
		this.field2270 = -1;
		this.field2271 = -1;
		this.field2272 = -1;
		this.field2286 = -1;
		this.field2274 = -1;
		this.field2256 = -1;
		this.field2273 = -1;
		this.field2277 = -1;
		this.field2297 = -1;
		this.field2294 = -1;
		this.field2284 = new String[5];
		this.field2285 = true;
		this.field2291 = -1;
		this.field2279 = 128;
		this.field2288 = 128;
		this.field2289 = false;
		this.field2290 = 0;
		this.field2276 = 0;
		this.field2292 = -1;
		this.field2299 = 32;
		this.field2295 = -1;
		this.field2296 = -1;
		this.field2282 = true;
		this.field2298 = true;
		this.field2287 = false;
	}

	void method3852() {
	}

	void method3853(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method3854(var1, var3);
		}
	}

	void method3854(Buffer var1, int var2) {
		int var4;
		int var5;
		if (var2 == 1) {
			var4 = var1.readUnsignedByte();
			this.field2283 = new int[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2283[var5] = var1.readUnsignedShort();
			}
		} else if (var2 == 2) {
			this.field2261 = var1.readString();
		} else if (var2 == 12) {
			this.field2262 = var1.readUnsignedByte();
		} else if (var2 == 13) {
			this.field2265 = var1.readUnsignedShort();
		} else if (var2 == 14) {
			this.field2268 = var1.readUnsignedShort();
		} else if (var2 == 15) {
			this.field2266 = var1.readUnsignedShort();
		} else if (var2 == 16) {
			this.field2264 = var1.readUnsignedShort();
		} else if (var2 == 17) {
			this.field2268 = var1.readUnsignedShort();
			this.field2269 = var1.readUnsignedShort();
			this.field2270 = var1.readUnsignedShort();
			this.field2271 = var1.readUnsignedShort();
		} else if (var2 == 18) {
			var1.readUnsignedShort();
		} else if (var2 >= 30 && var2 < 35) {
			this.field2284[var2 - 30] = var1.readString();
			if (this.field2284[var2 - 30].equalsIgnoreCase(class338.field3894)) {
				this.field2284[var2 - 30] = null;
			}
		} else if (var2 == 40) {
			var4 = var1.readUnsignedByte();
			this.field2280 = new short[var4];
			this.field2281 = new short[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2280[var5] = (short)var1.readUnsignedShort();
				this.field2281[var5] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 41) {
			var4 = var1.readUnsignedByte();
			this.field2263 = new short[var4];
			this.field2258 = new short[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2263[var5] = (short)var1.readUnsignedShort();
				this.field2258[var5] = (short)var1.readUnsignedShort();
			}
		} else if (var2 == 60) {
			var4 = var1.readUnsignedByte();
			this.field2275 = new int[var4];

			for (var5 = 0; var5 < var4; ++var5) {
				this.field2275[var5] = var1.readUnsignedShort();
			}
		} else if (var2 == 93) {
			this.field2285 = false;
		} else if (var2 == 95) {
			this.field2291 = var1.readUnsignedShort();
		} else if (var2 == 97) {
			this.field2279 = var1.readUnsignedShort();
		} else if (var2 == 98) {
			this.field2288 = var1.readUnsignedShort();
		} else if (var2 == 99) {
			this.field2289 = true;
		} else if (var2 == 100) {
			this.field2290 = var1.readByte();
		} else if (var2 == 101) {
			this.field2276 = var1.readByte() * 5;
		} else if (var2 == 102) {
			this.field2292 = var1.readUnsignedShort();
		} else if (var2 == 103) {
			this.field2299 = var1.readUnsignedShort();
		} else if (var2 != 106 && var2 != 118) {
			if (var2 == 107) {
				this.field2282 = false;
			} else if (var2 == 109) {
				this.field2298 = false;
			} else if (var2 == 111) {
				this.field2287 = true;
			} else if (var2 == 114) {
				this.field2272 = var1.readUnsignedShort();
			} else if (var2 == 115) {
				this.field2272 = var1.readUnsignedShort();
				this.field2286 = var1.readUnsignedShort();
				this.field2274 = var1.readUnsignedShort();
				this.field2256 = var1.readUnsignedShort();
			} else if (var2 == 116) {
				this.field2273 = var1.readUnsignedShort();
			} else if (var2 == 117) {
				this.field2273 = var1.readUnsignedShort();
				this.field2277 = var1.readUnsignedShort();
				this.field2297 = var1.readUnsignedShort();
				this.field2294 = var1.readUnsignedShort();
			} else if (var2 == 249) {
				this.field2300 = class233.method4559(var1, this.field2300);
			}
		} else {
			this.field2295 = var1.readUnsignedShort();
			if (65535 == this.field2295) {
				this.field2295 = -1;
			}

			this.field2296 = var1.readUnsignedShort();
			if (65535 == this.field2296) {
				this.field2296 = -1;
			}

			var4 = -1;
			if (var2 == 118) {
				var4 = var1.readUnsignedShort();
				if (var4 == 65535) {
					var4 = -1;
				}
			}

			var5 = var1.readUnsignedByte();
			this.field2278 = new int[var5 + 2];

			for (int var6 = 0; var6 <= var5; ++var6) {
				this.field2278[var6] = var1.readUnsignedShort();
				if (this.field2278[var6] == 65535) {
					this.field2278[var6] = -1;
				}
			}

			this.field2278[var5 + 1] = var4;
		}

	}

	public final class209 method3855(class189 var1, int var2, class189 var3, int var4) {
		if (null != this.field2278) {
			class203 var13 = this.method3857();
			return var13 == null ? null : var13.method3855(var1, var2, var3, var4);
		} else {
			class209 var6 = (class209)field2259.method5439((long)this.field2260);
			if (var6 == null) {
				boolean var7 = false;

				for (int var8 = 0; var8 < this.field2283.length; ++var8) {
					if (!field2257.method6089(this.field2283[var8], 0)) {
						var7 = true;
					}
				}

				if (var7) {
					return null;
				}

				class201[] var9 = new class201[this.field2283.length];

				int var10;
				for (var10 = 0; var10 < this.field2283.length; ++var10) {
					var9[var10] = class201.method3774(field2257, this.field2283[var10], 0);
				}

				class201 var11;
				if (1 == var9.length) {
					var11 = var9[0];
				} else {
					var11 = new class201(var9, var9.length);
				}

				if (null != this.field2280) {
					for (var10 = 0; var10 < this.field2280.length; ++var10) {
						var11.method3790(this.field2280[var10], this.field2281[var10]);
					}
				}

				if (null != this.field2263) {
					for (var10 = 0; var10 < this.field2263.length; ++var10) {
						var11.method3791(this.field2263[var10], this.field2258[var10]);
					}
				}

				var6 = var11.method3796(this.field2290 + 64, 850 + this.field2276, -30, -50, -30);
				field2259.method5434(var6, (long)this.field2260);
			}

			class209 var12;
			if (null != var1 && null != var3) {
				var12 = var1.method3472(var6, var2, var3, var4);
			} else if (null != var1) {
				var12 = var1.method3479(var6, var2);
			} else if (null != var3) {
				var12 = var3.method3479(var6, var4);
			} else {
				var12 = var6.method3988(true);
			}

			if (128 != this.field2279 || 128 != this.field2288) {
				var12.method4062(this.field2279, this.field2288, this.field2279);
			}

			return var12;
		}
	}

	public final class201 method3885() {
		if (null != this.field2278) {
			class203 var2 = this.method3857();
			return var2 == null ? null : var2.method3885();
		} else if (null == this.field2275) {
			return null;
		} else {
			boolean var6 = false;

			for (int var3 = 0; var3 < this.field2275.length; ++var3) {
				if (!field2257.method6089(this.field2275[var3], 0)) {
					var6 = true;
				}
			}

			if (var6) {
				return null;
			} else {
				class201[] var7 = new class201[this.field2275.length];

				for (int var4 = 0; var4 < this.field2275.length; ++var4) {
					var7[var4] = class201.method3774(field2257, this.field2275[var4], 0);
				}

				class201 var8;
				if (1 == var7.length) {
					var8 = var7[0];
				} else {
					var8 = new class201(var7, var7.length);
				}

				int var5;
				if (null != this.field2280) {
					for (var5 = 0; var5 < this.field2280.length; ++var5) {
						var8.method3790(this.field2280[var5], this.field2281[var5]);
					}
				}

				if (this.field2263 != null) {
					for (var5 = 0; var5 < this.field2263.length; ++var5) {
						var8.method3791(this.field2263[var5], this.field2258[var5]);
					}
				}

				return var8;
			}
		}
	}

	public final class203 method3857() {
		int var2 = -1;
		if (this.field2295 != -1) {
			var2 = class293.method1557(this.field2295);
		} else if (-1 != this.field2296) {
			var2 = class293.field3370[this.field2296];
		}

		int var3;
		if (var2 >= 0 && var2 < this.field2278.length - 1) {
			var3 = this.field2278[var2];
		} else {
			var3 = this.field2278[this.field2278.length - 1];
		}

		return var3 != -1 ? class158.method2632(var3) : null;
	}

	public boolean method3870() {
		if (null == this.field2278) {
			return true;
		} else {
			int var2 = -1;
			if (this.field2295 != -1) {
				var2 = class293.method1557(this.field2295);
			} else if (-1 != this.field2296) {
				var2 = class293.field3370[this.field2296];
			}

			if (var2 >= 0 && var2 < this.field2278.length) {
				return -1 != this.field2278[var2];
			} else {
				return this.field2278[this.field2278.length - 1] != -1;
			}
		}
	}

	public int method3859(int var1, int var2) {
		class421 var5 = this.field2300;
		int var4;
		if (null == var5) {
			var4 = var2;
		} else {
			class426 var6 = (class426)var5.method7788((long)var1);
			if (null == var6) {
				var4 = var2;
			} else {
				var4 = var6.field4680;
			}
		}

		return var4;
	}

	public String method3860(int var1, String var2) {
		return class369.method6734(this.field2300, var1, var2);
	}

	public static void method334() {
		field2267.method5437();
		field2259.method5437();
	}

	static final void method3865() {
		for (class77 var1 = (class77)client.graphics.method6364(); null != var1; var1 = (class77)client.graphics.method6358()) {
			if (class55.field396 == var1.field660 && !var1.field667) {
				if (client.field1645 >= var1.field659) {
					var1.method1571(client.field1701);
					if (var1.field667) {
						var1.method7825();
					} else {
						class145.field1333.method4133(var1.field660, var1.field661, var1.field658, var1.field671, 60, var1, 0, -1L, false);
					}
				}
			} else {
				var1.method7825();
			}
		}

	}
}
