public class class201 extends class212 {
	static int field2223;
	static int[] field2208;
	static int[] field2227;
	static int[] field2247;
	static int[] field2248;
	boolean field2241;
	byte field2224;
	byte[] field2218;
	byte[] field2219;
	byte[] field2220;
	byte[] field2226;
	byte[] field2233;
	class231[] field2237;
	class231[] field2238;
	class233[] field2236;
	int field2210;
	int field2214;
	int field2225;
	int field2242;
	int field2243;
	int field2244;
	int field2245;
	int field2246;
	int[] field2211;
	int[] field2213;
	int[] field2215;
	int[] field2216;
	int[] field2217;
	int[] field2230;
	int[] field2231;
	int[] field2249;
	int[][] field2207;
	int[][] field2212;
	int[][] field2232;
	int[][] field2235;
	short[] field2209;
	short[] field2222;
	short[] field2229;
	short[] field2234;
	short[] field2251;
	public short field2239;
	public short field2240;

	static {
		field2247 = new int[10000];
		field2248 = new int[10000];
		field2223 = 0;
		field2208 = class221.field2644;
		field2227 = class221.field2645;
	}

	class201() {
		this.field2210 = 0;
		this.field2214 = 0;
		this.field2224 = 0;
		this.field2241 = false;
	}

	public static class201 method3774(class319 var0, int var1, int var2) {
		byte[] var3 = var0.method6175(var1, var2);
		return var3 == null ? null : new class201(var3);
	}

	class201(byte[] var1) {
		this.field2210 = 0;
		this.field2214 = 0;
		this.field2224 = 0;
		this.field2241 = false;
		Buffer var2 = new Buffer(10);
		var2.writeShort(-2);
		if (var1[var1.length - 1] == -3 && var1[var1.length - 2] == -1) {
			this.method3781(var1);
		} else if (var1[var1.length - 1] == -2 && var1[var1.length - 2] == -1) {
			this.method3814(var1);
		} else if (var1[var1.length - 1] == -1 && var1[var1.length - 2] == -1) {
			this.method3783(var1);
		} else {
			this.method3779(var1);
		}

	}

	void method3781(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		Buffer var3 = new Buffer(var1);
		Buffer var4 = new Buffer(var1);
		Buffer var5 = new Buffer(var1);
		Buffer var6 = new Buffer(var1);
		Buffer var7 = new Buffer(var1);
		Buffer var8 = new Buffer(var1);
		var2.offset = var1.length - 26;
		int var9 = var2.readUnsignedShort();
		int var10 = var2.readUnsignedShort();
		int var11 = var2.method8141();
		int var12 = var2.method8141();
		int var13 = var2.method8141();
		int var14 = var2.method8141();
		int var15 = var2.method8141();
		int var16 = var2.method8141();
		int var17 = var2.method8141();
		int var18 = var2.method8141();
		int var19 = var2.readUnsignedShort();
		int var20 = var2.readUnsignedShort();
		int var21 = var2.readUnsignedShort();
		int var22 = var2.readUnsignedShort();
		int var23 = var2.readUnsignedShort();
		int var24 = var2.readUnsignedShort();
		int var25 = 0;
		int var26 = 0;
		int var27 = 0;
		int var28;
		if (var11 > 0) {
			this.field2226 = new byte[var11];
			var2.offset = 0;

			for (var28 = 0; var28 < var11; ++var28) {
				byte var29 = this.field2226[var28] = var2.method8287();
				if (var29 == 0) {
					++var25;
				}

				if (var29 >= 1 && var29 <= 3) {
					++var26;
				}

				if (var29 == 2) {
					++var27;
				}
			}
		}

		var28 = var11 + var9;
		int var30 = var28;
		if (var12 == 1) {
			var28 += var10;
		}

		int var31 = var28;
		var28 += var10;
		int var32 = var28;
		if (var13 == 255) {
			var28 += var10;
		}

		int var33 = var28;
		if (var15 == 1) {
			var28 += var10;
		}

		int var34 = var28;
		var28 += var24;
		int var35 = var28;
		if (var14 == 1) {
			var28 += var10;
		}

		int var36 = var28;
		var28 += var22;
		int var37 = var28;
		if (var16 == 1) {
			var28 += var10 * 2;
		}

		int var38 = var28;
		var28 += var23;
		int var39 = var28;
		var28 += var10 * 2;
		int var40 = var28;
		var28 += var19;
		int var41 = var28;
		var28 += var20;
		int var42 = var28;
		var28 += var21;
		int var43 = var28;
		var28 += var25 * 6;
		int var44 = var28;
		var28 += var26 * 6;
		int var45 = var28;
		var28 += var26 * 6;
		int var46 = var28;
		var28 += var26 * 2;
		int var47 = var28;
		var28 += var26;
		int var48 = var28;
		var28 += var26 * 2 + var27 * 2;
		this.field2210 = var9;
		this.field2214 = var10;
		this.field2225 = var11;
		this.field2211 = new int[var9];
		this.field2249 = new int[var9];
		this.field2213 = new int[var9];
		this.field2215 = new int[var10];
		this.field2216 = new int[var10];
		this.field2217 = new int[var10];
		if (var17 == 1) {
			this.field2230 = new int[var9];
		}

		if (var12 == 1) {
			this.field2218 = new byte[var10];
		}

		if (var13 == 255) {
			this.field2219 = new byte[var10];
		} else {
			this.field2224 = (byte)var13;
		}

		if (var14 == 1) {
			this.field2220 = new byte[var10];
		}

		if (var15 == 1) {
			this.field2231 = new int[var10];
		}

		if (var16 == 1) {
			this.field2209 = new short[var10];
		}

		if (var16 == 1 && var11 > 0) {
			this.field2233 = new byte[var10];
		}

		if (var18 == 1) {
			this.field2207 = new int[var9][];
			this.field2235 = new int[var9][];
		}

		this.field2234 = new short[var10];
		if (var11 > 0) {
			this.field2229 = new short[var11];
			this.field2222 = new short[var11];
			this.field2251 = new short[var11];
		}

		var2.offset = var11;
		var3.offset = var40;
		var4.offset = var41;
		var5.offset = var42;
		var6.offset = var34;
		int var50 = 0;
		int var51 = 0;
		int var52 = 0;

		int var53;
		int var54;
		int var55;
		int var56;
		int var57;
		for (var53 = 0; var53 < var9; ++var53) {
			var54 = var2.method8141();
			var55 = 0;
			if ((var54 & 1) != 0) {
				var55 = var3.method8219();
			}

			var56 = 0;
			if ((var54 & 2) != 0) {
				var56 = var4.method8219();
			}

			var57 = 0;
			if ((var54 & 4) != 0) {
				var57 = var5.method8219();
			}

			this.field2211[var53] = var50 + var55;
			this.field2249[var53] = var51 + var56;
			this.field2213[var53] = var52 + var57;
			var50 = this.field2211[var53];
			var51 = this.field2249[var53];
			var52 = this.field2213[var53];
			if (var17 == 1) {
				this.field2230[var53] = var6.method8141();
			}
		}

		if (var18 == 1) {
			for (var53 = 0; var53 < var9; ++var53) {
				var54 = var6.method8141();
				this.field2207[var53] = new int[var54];
				this.field2235[var53] = new int[var54];

				for (var55 = 0; var55 < var54; ++var55) {
					this.field2207[var53][var55] = var6.method8141();
					this.field2235[var53][var55] = var6.method8141();
				}
			}
		}

		var2.offset = var39;
		var3.offset = var30;
		var4.offset = var32;
		var5.offset = var35;
		var6.offset = var33;
		var7.offset = var37;
		var8.offset = var38;

		for (var53 = 0; var53 < var10; ++var53) {
			this.field2234[var53] = (short)var2.readUnsignedShort();
			if (var12 == 1) {
				this.field2218[var53] = var3.method8287();
			}

			if (var13 == 255) {
				this.field2219[var53] = var4.method8287();
			}

			if (var14 == 1) {
				this.field2220[var53] = var5.method8287();
			}

			if (var15 == 1) {
				this.field2231[var53] = var6.method8141();
			}

			if (var16 == 1) {
				this.field2209[var53] = (short)(var7.readUnsignedShort() - 1);
			}

			if (this.field2233 != null && this.field2209[var53] != -1) {
				this.field2233[var53] = (byte)(var8.method8141() - 1);
			}
		}

		var2.offset = var36;
		var3.offset = var31;
		var53 = 0;
		var54 = 0;
		var55 = 0;
		var56 = 0;

		int var58;
		for (var57 = 0; var57 < var10; ++var57) {
			var58 = var3.method8141();
			if (var58 == 1) {
				var53 = var2.method8219() + var56;
				var54 = var2.method8219() + var53;
				var55 = var2.method8219() + var54;
				var56 = var55;
				this.field2215[var57] = var53;
				this.field2216[var57] = var54;
				this.field2217[var57] = var55;
			}

			if (var58 == 2) {
				var54 = var55;
				var55 = var2.method8219() + var56;
				var56 = var55;
				this.field2215[var57] = var53;
				this.field2216[var57] = var54;
				this.field2217[var57] = var55;
			}

			if (var58 == 3) {
				var53 = var55;
				var55 = var2.method8219() + var56;
				var56 = var55;
				this.field2215[var57] = var53;
				this.field2216[var57] = var54;
				this.field2217[var57] = var55;
			}

			if (var58 == 4) {
				int var59 = var53;
				var53 = var54;
				var54 = var59;
				var55 = var2.method8219() + var56;
				var56 = var55;
				this.field2215[var57] = var53;
				this.field2216[var57] = var59;
				this.field2217[var57] = var55;
			}
		}

		var2.offset = var43;
		var3.offset = var44;
		var4.offset = var45;
		var5.offset = var46;
		var6.offset = var47;
		var7.offset = var48;

		for (var57 = 0; var57 < var11; ++var57) {
			var58 = this.field2226[var57] & 255;
			if (var58 == 0) {
				this.field2229[var57] = (short)var2.readUnsignedShort();
				this.field2222[var57] = (short)var2.readUnsignedShort();
				this.field2251[var57] = (short)var2.readUnsignedShort();
			}
		}

		var2.offset = var28;
		var57 = var2.method8141();
		if (var57 != 0) {
			new class222();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.method8126();
		}

	}

	void method3814(byte[] var1) {
		boolean var2 = false;
		boolean var3 = false;
		Buffer var4 = new Buffer(var1);
		Buffer var5 = new Buffer(var1);
		Buffer var6 = new Buffer(var1);
		Buffer var7 = new Buffer(var1);
		Buffer var8 = new Buffer(var1);
		var4.offset = var1.length - 23;
		int var9 = var4.readUnsignedShort();
		int var10 = var4.readUnsignedShort();
		int var11 = var4.method8141();
		int var12 = var4.method8141();
		int var13 = var4.method8141();
		int var14 = var4.method8141();
		int var15 = var4.method8141();
		int var16 = var4.method8141();
		int var17 = var4.method8141();
		int var18 = var4.readUnsignedShort();
		int var19 = var4.readUnsignedShort();
		int var20 = var4.readUnsignedShort();
		int var21 = var4.readUnsignedShort();
		int var22 = var4.readUnsignedShort();
		byte var23 = 0;
		int var47 = var23 + var9;
		int var25 = var47;
		var47 += var10;
		int var26 = var47;
		if (var13 == 255) {
			var47 += var10;
		}

		int var27 = var47;
		if (var15 == 1) {
			var47 += var10;
		}

		int var28 = var47;
		if (var12 == 1) {
			var47 += var10;
		}

		int var29 = var47;
		var47 += var22;
		int var30 = var47;
		if (var14 == 1) {
			var47 += var10;
		}

		int var31 = var47;
		var47 += var21;
		int var32 = var47;
		var47 += var10 * 2;
		int var33 = var47;
		var47 += var11 * 6;
		int var34 = var47;
		var47 += var18;
		int var35 = var47;
		var47 += var19;
		int var10000 = var47 + var20;
		this.field2210 = var9;
		this.field2214 = var10;
		this.field2225 = var11;
		this.field2211 = new int[var9];
		this.field2249 = new int[var9];
		this.field2213 = new int[var9];
		this.field2215 = new int[var10];
		this.field2216 = new int[var10];
		this.field2217 = new int[var10];
		if (var11 > 0) {
			this.field2226 = new byte[var11];
			this.field2229 = new short[var11];
			this.field2222 = new short[var11];
			this.field2251 = new short[var11];
		}

		if (var16 == 1) {
			this.field2230 = new int[var9];
		}

		if (var12 == 1) {
			this.field2218 = new byte[var10];
			this.field2233 = new byte[var10];
			this.field2209 = new short[var10];
		}

		if (var13 == 255) {
			this.field2219 = new byte[var10];
		} else {
			this.field2224 = (byte)var13;
		}

		if (var14 == 1) {
			this.field2220 = new byte[var10];
		}

		if (var15 == 1) {
			this.field2231 = new int[var10];
		}

		if (var17 == 1) {
			this.field2207 = new int[var9][];
			this.field2235 = new int[var9][];
		}

		this.field2234 = new short[var10];
		var4.offset = var23;
		var5.offset = var34;
		var6.offset = var35;
		var7.offset = var47;
		var8.offset = var29;
		int var37 = 0;
		int var38 = 0;
		int var39 = 0;

		int var40;
		int var41;
		int var42;
		int var43;
		int var44;
		for (var40 = 0; var40 < var9; ++var40) {
			var41 = var4.method8141();
			var42 = 0;
			if ((var41 & 1) != 0) {
				var42 = var5.method8219();
			}

			var43 = 0;
			if ((var41 & 2) != 0) {
				var43 = var6.method8219();
			}

			var44 = 0;
			if ((var41 & 4) != 0) {
				var44 = var7.method8219();
			}

			this.field2211[var40] = var37 + var42;
			this.field2249[var40] = var38 + var43;
			this.field2213[var40] = var39 + var44;
			var37 = this.field2211[var40];
			var38 = this.field2249[var40];
			var39 = this.field2213[var40];
			if (var16 == 1) {
				this.field2230[var40] = var8.method8141();
			}
		}

		if (var17 == 1) {
			for (var40 = 0; var40 < var9; ++var40) {
				var41 = var8.method8141();
				this.field2207[var40] = new int[var41];
				this.field2235[var40] = new int[var41];

				for (var42 = 0; var42 < var41; ++var42) {
					this.field2207[var40][var42] = var8.method8141();
					this.field2235[var40][var42] = var8.method8141();
				}
			}
		}

		var4.offset = var32;
		var5.offset = var28;
		var6.offset = var26;
		var7.offset = var30;
		var8.offset = var27;

		for (var40 = 0; var40 < var10; ++var40) {
			this.field2234[var40] = (short)var4.readUnsignedShort();
			if (var12 == 1) {
				var41 = var5.method8141();
				if ((var41 & 1) == 1) {
					this.field2218[var40] = 1;
					var2 = true;
				} else {
					this.field2218[var40] = 0;
				}

				if ((var41 & 2) == 2) {
					this.field2233[var40] = (byte)(var41 >> 2);
					this.field2209[var40] = this.field2234[var40];
					this.field2234[var40] = 127;
					if (this.field2209[var40] != -1) {
						var3 = true;
					}
				} else {
					this.field2233[var40] = -1;
					this.field2209[var40] = -1;
				}
			}

			if (var13 == 255) {
				this.field2219[var40] = var6.method8287();
			}

			if (var14 == 1) {
				this.field2220[var40] = var7.method8287();
			}

			if (var15 == 1) {
				this.field2231[var40] = var8.method8141();
			}
		}

		var4.offset = var31;
		var5.offset = var25;
		var40 = 0;
		var41 = 0;
		var42 = 0;
		var43 = 0;

		int var45;
		int var46;
		for (var44 = 0; var44 < var10; ++var44) {
			var45 = var5.method8141();
			if (var45 == 1) {
				var40 = var4.method8219() + var43;
				var41 = var4.method8219() + var40;
				var42 = var4.method8219() + var41;
				var43 = var42;
				this.field2215[var44] = var40;
				this.field2216[var44] = var41;
				this.field2217[var44] = var42;
			}

			if (var45 == 2) {
				var41 = var42;
				var42 = var4.method8219() + var43;
				var43 = var42;
				this.field2215[var44] = var40;
				this.field2216[var44] = var41;
				this.field2217[var44] = var42;
			}

			if (var45 == 3) {
				var40 = var42;
				var42 = var4.method8219() + var43;
				var43 = var42;
				this.field2215[var44] = var40;
				this.field2216[var44] = var41;
				this.field2217[var44] = var42;
			}

			if (var45 == 4) {
				var46 = var40;
				var40 = var41;
				var41 = var46;
				var42 = var4.method8219() + var43;
				var43 = var42;
				this.field2215[var44] = var40;
				this.field2216[var44] = var46;
				this.field2217[var44] = var42;
			}
		}

		var4.offset = var33;

		for (var44 = 0; var44 < var11; ++var44) {
			this.field2226[var44] = 0;
			this.field2229[var44] = (short)var4.readUnsignedShort();
			this.field2222[var44] = (short)var4.readUnsignedShort();
			this.field2251[var44] = (short)var4.readUnsignedShort();
		}

		if (this.field2233 != null) {
			boolean var48 = false;

			for (var45 = 0; var45 < var10; ++var45) {
				var46 = this.field2233[var45] & 255;
				if (var46 != 255) {
					if ((this.field2229[var46] & '\uffff') == this.field2215[var45] && (this.field2222[var46] & '\uffff') == this.field2216[var45] && (this.field2251[var46] & '\uffff') == this.field2217[var45]) {
						this.field2233[var45] = -1;
					} else {
						var48 = true;
					}
				}
			}

			if (!var48) {
				this.field2233 = null;
			}
		}

		if (!var3) {
			this.field2209 = null;
		}

		if (!var2) {
			this.field2218 = null;
		}

	}

	void method3783(byte[] var1) {
		Buffer var2 = new Buffer(var1);
		Buffer var3 = new Buffer(var1);
		Buffer var4 = new Buffer(var1);
		Buffer var5 = new Buffer(var1);
		Buffer var6 = new Buffer(var1);
		Buffer var7 = new Buffer(var1);
		Buffer var8 = new Buffer(var1);
		var2.offset = var1.length - 23;
		int var9 = var2.readUnsignedShort();
		int var10 = var2.readUnsignedShort();
		int var11 = var2.method8141();
		int var12 = var2.method8141();
		int var13 = var2.method8141();
		int var14 = var2.method8141();
		int var15 = var2.method8141();
		int var16 = var2.method8141();
		int var17 = var2.method8141();
		int var18 = var2.readUnsignedShort();
		int var19 = var2.readUnsignedShort();
		int var20 = var2.readUnsignedShort();
		int var21 = var2.readUnsignedShort();
		int var22 = var2.readUnsignedShort();
		int var23 = 0;
		int var24 = 0;
		int var25 = 0;
		int var26;
		if (var11 > 0) {
			this.field2226 = new byte[var11];
			var2.offset = 0;

			for (var26 = 0; var26 < var11; ++var26) {
				byte var27 = this.field2226[var26] = var2.method8287();
				if (var27 == 0) {
					++var23;
				}

				if (var27 >= 1 && var27 <= 3) {
					++var24;
				}

				if (var27 == 2) {
					++var25;
				}
			}
		}

		var26 = var11 + var9;
		int var28 = var26;
		if (var12 == 1) {
			var26 += var10;
		}

		int var29 = var26;
		var26 += var10;
		int var30 = var26;
		if (var13 == 255) {
			var26 += var10;
		}

		int var31 = var26;
		if (var15 == 1) {
			var26 += var10;
		}

		int var32 = var26;
		if (var17 == 1) {
			var26 += var9;
		}

		int var33 = var26;
		if (var14 == 1) {
			var26 += var10;
		}

		int var34 = var26;
		var26 += var21;
		int var35 = var26;
		if (var16 == 1) {
			var26 += var10 * 2;
		}

		int var36 = var26;
		var26 += var22;
		int var37 = var26;
		var26 += var10 * 2;
		int var38 = var26;
		var26 += var18;
		int var39 = var26;
		var26 += var19;
		int var40 = var26;
		var26 += var20;
		int var41 = var26;
		var26 += var23 * 6;
		int var42 = var26;
		var26 += var24 * 6;
		int var43 = var26;
		var26 += var24 * 6;
		int var44 = var26;
		var26 += var24 * 2;
		int var45 = var26;
		var26 += var24;
		int var46 = var26;
		var26 += var24 * 2 + var25 * 2;
		this.field2210 = var9;
		this.field2214 = var10;
		this.field2225 = var11;
		this.field2211 = new int[var9];
		this.field2249 = new int[var9];
		this.field2213 = new int[var9];
		this.field2215 = new int[var10];
		this.field2216 = new int[var10];
		this.field2217 = new int[var10];
		if (var17 == 1) {
			this.field2230 = new int[var9];
		}

		if (var12 == 1) {
			this.field2218 = new byte[var10];
		}

		if (var13 == 255) {
			this.field2219 = new byte[var10];
		} else {
			this.field2224 = (byte)var13;
		}

		if (var14 == 1) {
			this.field2220 = new byte[var10];
		}

		if (var15 == 1) {
			this.field2231 = new int[var10];
		}

		if (var16 == 1) {
			this.field2209 = new short[var10];
		}

		if (var16 == 1 && var11 > 0) {
			this.field2233 = new byte[var10];
		}

		this.field2234 = new short[var10];
		if (var11 > 0) {
			this.field2229 = new short[var11];
			this.field2222 = new short[var11];
			this.field2251 = new short[var11];
		}

		var2.offset = var11;
		var3.offset = var38;
		var4.offset = var39;
		var5.offset = var40;
		var6.offset = var32;
		int var48 = 0;
		int var49 = 0;
		int var50 = 0;

		int var51;
		int var52;
		int var53;
		int var54;
		int var55;
		for (var51 = 0; var51 < var9; ++var51) {
			var52 = var2.method8141();
			var53 = 0;
			if ((var52 & 1) != 0) {
				var53 = var3.method8219();
			}

			var54 = 0;
			if ((var52 & 2) != 0) {
				var54 = var4.method8219();
			}

			var55 = 0;
			if ((var52 & 4) != 0) {
				var55 = var5.method8219();
			}

			this.field2211[var51] = var48 + var53;
			this.field2249[var51] = var49 + var54;
			this.field2213[var51] = var50 + var55;
			var48 = this.field2211[var51];
			var49 = this.field2249[var51];
			var50 = this.field2213[var51];
			if (var17 == 1) {
				this.field2230[var51] = var6.method8141();
			}
		}

		var2.offset = var37;
		var3.offset = var28;
		var4.offset = var30;
		var5.offset = var33;
		var6.offset = var31;
		var7.offset = var35;
		var8.offset = var36;

		for (var51 = 0; var51 < var10; ++var51) {
			this.field2234[var51] = (short)var2.readUnsignedShort();
			if (var12 == 1) {
				this.field2218[var51] = var3.method8287();
			}

			if (var13 == 255) {
				this.field2219[var51] = var4.method8287();
			}

			if (var14 == 1) {
				this.field2220[var51] = var5.method8287();
			}

			if (var15 == 1) {
				this.field2231[var51] = var6.method8141();
			}

			if (var16 == 1) {
				this.field2209[var51] = (short)(var7.readUnsignedShort() - 1);
			}

			if (this.field2233 != null && this.field2209[var51] != -1) {
				this.field2233[var51] = (byte)(var8.method8141() - 1);
			}
		}

		var2.offset = var34;
		var3.offset = var29;
		var51 = 0;
		var52 = 0;
		var53 = 0;
		var54 = 0;

		int var56;
		for (var55 = 0; var55 < var10; ++var55) {
			var56 = var3.method8141();
			if (var56 == 1) {
				var51 = var2.method8219() + var54;
				var52 = var2.method8219() + var51;
				var53 = var2.method8219() + var52;
				var54 = var53;
				this.field2215[var55] = var51;
				this.field2216[var55] = var52;
				this.field2217[var55] = var53;
			}

			if (var56 == 2) {
				var52 = var53;
				var53 = var2.method8219() + var54;
				var54 = var53;
				this.field2215[var55] = var51;
				this.field2216[var55] = var52;
				this.field2217[var55] = var53;
			}

			if (var56 == 3) {
				var51 = var53;
				var53 = var2.method8219() + var54;
				var54 = var53;
				this.field2215[var55] = var51;
				this.field2216[var55] = var52;
				this.field2217[var55] = var53;
			}

			if (var56 == 4) {
				int var57 = var51;
				var51 = var52;
				var52 = var57;
				var53 = var2.method8219() + var54;
				var54 = var53;
				this.field2215[var55] = var51;
				this.field2216[var55] = var57;
				this.field2217[var55] = var53;
			}
		}

		var2.offset = var41;
		var3.offset = var42;
		var4.offset = var43;
		var5.offset = var44;
		var6.offset = var45;
		var7.offset = var46;

		for (var55 = 0; var55 < var11; ++var55) {
			var56 = this.field2226[var55] & 255;
			if (var56 == 0) {
				this.field2229[var55] = (short)var2.readUnsignedShort();
				this.field2222[var55] = (short)var2.readUnsignedShort();
				this.field2251[var55] = (short)var2.readUnsignedShort();
			}
		}

		var2.offset = var26;
		var55 = var2.method8141();
		if (var55 != 0) {
			new class222();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.readUnsignedShort();
			var2.method8126();
		}

	}

	void method3779(byte[] var1) {
		boolean var2 = false;
		boolean var3 = false;
		Buffer var4 = new Buffer(var1);
		Buffer var5 = new Buffer(var1);
		Buffer var6 = new Buffer(var1);
		Buffer var7 = new Buffer(var1);
		Buffer var8 = new Buffer(var1);
		var4.offset = var1.length - 18;
		int var9 = var4.readUnsignedShort();
		int var10 = var4.readUnsignedShort();
		int var11 = var4.method8141();
		int var12 = var4.method8141();
		int var13 = var4.method8141();
		int var14 = var4.method8141();
		int var15 = var4.method8141();
		int var16 = var4.method8141();
		int var17 = var4.readUnsignedShort();
		int var18 = var4.readUnsignedShort();
		int var19 = var4.readUnsignedShort();
		int var20 = var4.readUnsignedShort();
		byte var21 = 0;
		int var45 = var21 + var9;
		int var23 = var45;
		var45 += var10;
		int var24 = var45;
		if (var13 == 255) {
			var45 += var10;
		}

		int var25 = var45;
		if (var15 == 1) {
			var45 += var10;
		}

		int var26 = var45;
		if (var12 == 1) {
			var45 += var10;
		}

		int var27 = var45;
		if (var16 == 1) {
			var45 += var9;
		}

		int var28 = var45;
		if (var14 == 1) {
			var45 += var10;
		}

		int var29 = var45;
		var45 += var20;
		int var30 = var45;
		var45 += var10 * 2;
		int var31 = var45;
		var45 += var11 * 6;
		int var32 = var45;
		var45 += var17;
		int var33 = var45;
		var45 += var18;
		int var10000 = var45 + var19;
		this.field2210 = var9;
		this.field2214 = var10;
		this.field2225 = var11;
		this.field2211 = new int[var9];
		this.field2249 = new int[var9];
		this.field2213 = new int[var9];
		this.field2215 = new int[var10];
		this.field2216 = new int[var10];
		this.field2217 = new int[var10];
		if (var11 > 0) {
			this.field2226 = new byte[var11];
			this.field2229 = new short[var11];
			this.field2222 = new short[var11];
			this.field2251 = new short[var11];
		}

		if (var16 == 1) {
			this.field2230 = new int[var9];
		}

		if (var12 == 1) {
			this.field2218 = new byte[var10];
			this.field2233 = new byte[var10];
			this.field2209 = new short[var10];
		}

		if (var13 == 255) {
			this.field2219 = new byte[var10];
		} else {
			this.field2224 = (byte)var13;
		}

		if (var14 == 1) {
			this.field2220 = new byte[var10];
		}

		if (var15 == 1) {
			this.field2231 = new int[var10];
		}

		this.field2234 = new short[var10];
		var4.offset = var21;
		var5.offset = var32;
		var6.offset = var33;
		var7.offset = var45;
		var8.offset = var27;
		int var35 = 0;
		int var36 = 0;
		int var37 = 0;

		int var38;
		int var39;
		int var40;
		int var41;
		int var42;
		for (var38 = 0; var38 < var9; ++var38) {
			var39 = var4.method8141();
			var40 = 0;
			if ((var39 & 1) != 0) {
				var40 = var5.method8219();
			}

			var41 = 0;
			if ((var39 & 2) != 0) {
				var41 = var6.method8219();
			}

			var42 = 0;
			if ((var39 & 4) != 0) {
				var42 = var7.method8219();
			}

			this.field2211[var38] = var35 + var40;
			this.field2249[var38] = var36 + var41;
			this.field2213[var38] = var37 + var42;
			var35 = this.field2211[var38];
			var36 = this.field2249[var38];
			var37 = this.field2213[var38];
			if (var16 == 1) {
				this.field2230[var38] = var8.method8141();
			}
		}

		var4.offset = var30;
		var5.offset = var26;
		var6.offset = var24;
		var7.offset = var28;
		var8.offset = var25;

		for (var38 = 0; var38 < var10; ++var38) {
			this.field2234[var38] = (short)var4.readUnsignedShort();
			if (var12 == 1) {
				var39 = var5.method8141();
				if ((var39 & 1) == 1) {
					this.field2218[var38] = 1;
					var2 = true;
				} else {
					this.field2218[var38] = 0;
				}

				if ((var39 & 2) == 2) {
					this.field2233[var38] = (byte)(var39 >> 2);
					this.field2209[var38] = this.field2234[var38];
					this.field2234[var38] = 127;
					if (this.field2209[var38] != -1) {
						var3 = true;
					}
				} else {
					this.field2233[var38] = -1;
					this.field2209[var38] = -1;
				}
			}

			if (var13 == 255) {
				this.field2219[var38] = var6.method8287();
			}

			if (var14 == 1) {
				this.field2220[var38] = var7.method8287();
			}

			if (var15 == 1) {
				this.field2231[var38] = var8.method8141();
			}
		}

		var4.offset = var29;
		var5.offset = var23;
		var38 = 0;
		var39 = 0;
		var40 = 0;
		var41 = 0;

		int var43;
		int var44;
		for (var42 = 0; var42 < var10; ++var42) {
			var43 = var5.method8141();
			if (var43 == 1) {
				var38 = var4.method8219() + var41;
				var39 = var4.method8219() + var38;
				var40 = var4.method8219() + var39;
				var41 = var40;
				this.field2215[var42] = var38;
				this.field2216[var42] = var39;
				this.field2217[var42] = var40;
			}

			if (var43 == 2) {
				var39 = var40;
				var40 = var4.method8219() + var41;
				var41 = var40;
				this.field2215[var42] = var38;
				this.field2216[var42] = var39;
				this.field2217[var42] = var40;
			}

			if (var43 == 3) {
				var38 = var40;
				var40 = var4.method8219() + var41;
				var41 = var40;
				this.field2215[var42] = var38;
				this.field2216[var42] = var39;
				this.field2217[var42] = var40;
			}

			if (var43 == 4) {
				var44 = var38;
				var38 = var39;
				var39 = var44;
				var40 = var4.method8219() + var41;
				var41 = var40;
				this.field2215[var42] = var38;
				this.field2216[var42] = var44;
				this.field2217[var42] = var40;
			}
		}

		var4.offset = var31;

		for (var42 = 0; var42 < var11; ++var42) {
			this.field2226[var42] = 0;
			this.field2229[var42] = (short)var4.readUnsignedShort();
			this.field2222[var42] = (short)var4.readUnsignedShort();
			this.field2251[var42] = (short)var4.readUnsignedShort();
		}

		if (this.field2233 != null) {
			boolean var46 = false;

			for (var43 = 0; var43 < var10; ++var43) {
				var44 = this.field2233[var43] & 255;
				if (var44 != 255) {
					if ((this.field2229[var44] & '\uffff') == this.field2215[var43] && (this.field2222[var44] & '\uffff') == this.field2216[var43] && (this.field2251[var44] & '\uffff') == this.field2217[var43]) {
						this.field2233[var43] = -1;
					} else {
						var46 = true;
					}
				}
			}

			if (!var46) {
				this.field2233 = null;
			}
		}

		if (!var3) {
			this.field2209 = null;
		}

		if (!var2) {
			this.field2218 = null;
		}

	}

	public class201(class201[] var1, int var2) {
		this.field2210 = 0;
		this.field2214 = 0;
		this.field2224 = 0;
		this.field2241 = false;
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		boolean var9 = false;
		this.field2210 = 0;
		this.field2214 = 0;
		this.field2225 = 0;
		this.field2224 = -1;

		int var10;
		class201 var11;
		for (var10 = 0; var10 < var2; ++var10) {
			var11 = var1[var10];
			if (var11 != null) {
				this.field2210 += var11.field2210;
				this.field2214 += var11.field2214;
				this.field2225 += var11.field2225;
				if (var11.field2219 != null) {
					var4 = true;
				} else {
					if (this.field2224 == -1) {
						this.field2224 = var11.field2224;
					}

					if (this.field2224 != var11.field2224) {
						var4 = true;
					}
				}

				var3 |= var11.field2218 != null;
				var5 |= var11.field2220 != null;
				var6 |= var11.field2231 != null;
				var7 |= var11.field2209 != null;
				var8 |= var11.field2233 != null;
				var9 |= var11.field2207 != null;
			}
		}

		this.field2211 = new int[this.field2210];
		this.field2249 = new int[this.field2210];
		this.field2213 = new int[this.field2210];
		this.field2230 = new int[this.field2210];
		this.field2215 = new int[this.field2214];
		this.field2216 = new int[this.field2214];
		this.field2217 = new int[this.field2214];
		if (var3) {
			this.field2218 = new byte[this.field2214];
		}

		if (var4) {
			this.field2219 = new byte[this.field2214];
		}

		if (var5) {
			this.field2220 = new byte[this.field2214];
		}

		if (var6) {
			this.field2231 = new int[this.field2214];
		}

		if (var7) {
			this.field2209 = new short[this.field2214];
		}

		if (var8) {
			this.field2233 = new byte[this.field2214];
		}

		if (var9) {
			this.field2207 = new int[this.field2210][];
			this.field2235 = new int[this.field2210][];
		}

		this.field2234 = new short[this.field2214];
		if (this.field2225 > 0) {
			this.field2226 = new byte[this.field2225];
			this.field2229 = new short[this.field2225];
			this.field2222 = new short[this.field2225];
			this.field2251 = new short[this.field2225];
		}

		this.field2210 = 0;
		this.field2214 = 0;
		this.field2225 = 0;

		for (var10 = 0; var10 < var2; ++var10) {
			var11 = var1[var10];
			if (var11 != null) {
				int var12;
				for (var12 = 0; var12 < var11.field2214; ++var12) {
					if (var3 && var11.field2218 != null) {
						this.field2218[this.field2214] = var11.field2218[var12];
					}

					if (var4) {
						if (var11.field2219 != null) {
							this.field2219[this.field2214] = var11.field2219[var12];
						} else {
							this.field2219[this.field2214] = var11.field2224;
						}
					}

					if (var5 && var11.field2220 != null) {
						this.field2220[this.field2214] = var11.field2220[var12];
					}

					if (var6 && var11.field2231 != null) {
						this.field2231[this.field2214] = var11.field2231[var12];
					}

					if (var7) {
						if (var11.field2209 != null) {
							this.field2209[this.field2214] = var11.field2209[var12];
						} else {
							this.field2209[this.field2214] = -1;
						}
					}

					if (var8) {
						if (var11.field2233 != null && var11.field2233[var12] != -1) {
							this.field2233[this.field2214] = (byte)(var11.field2233[var12] + this.field2225);
						} else {
							this.field2233[this.field2214] = -1;
						}
					}

					this.field2234[this.field2214] = var11.field2234[var12];
					this.field2215[this.field2214] = this.method3797(var11, var11.field2215[var12]);
					this.field2216[this.field2214] = this.method3797(var11, var11.field2216[var12]);
					this.field2217[this.field2214] = this.method3797(var11, var11.field2217[var12]);
					++this.field2214;
				}

				for (var12 = 0; var12 < var11.field2225; ++var12) {
					byte var13 = this.field2226[this.field2225] = var11.field2226[var12];
					if (var13 == 0) {
						this.field2229[this.field2225] = (short)this.method3797(var11, var11.field2229[var12]);
						this.field2222[this.field2225] = (short)this.method3797(var11, var11.field2222[var12]);
						this.field2251[this.field2225] = (short)this.method3797(var11, var11.field2251[var12]);
					}

					++this.field2225;
				}
			}
		}

	}

	final int method3797(class201 var1, int var2) {
		int var3 = -1;
		int var4 = var1.field2211[var2];
		int var5 = var1.field2249[var2];
		int var6 = var1.field2213[var2];

		for (int var7 = 0; var7 < this.field2210; ++var7) {
			if (var4 == this.field2211[var7] && var5 == this.field2249[var7] && var6 == this.field2213[var7]) {
				var3 = var7;
				break;
			}
		}

		if (var3 == -1) {
			this.field2211[this.field2210] = var4;
			this.field2249[this.field2210] = var5;
			this.field2213[this.field2210] = var6;
			if (var1.field2230 != null) {
				this.field2230[this.field2210] = var1.field2230[var2];
			}

			if (var1.field2207 != null) {
				this.field2207[this.field2210] = var1.field2207[var2];
				this.field2235[this.field2210] = var1.field2235[var2];
			}

			var3 = this.field2210++;
		}

		return var3;
	}

	public class201(class201 var1, boolean var2, boolean var3, boolean var4, boolean var5) {
		this.field2210 = 0;
		this.field2214 = 0;
		this.field2224 = 0;
		this.field2241 = false;
		this.field2210 = var1.field2210;
		this.field2214 = var1.field2214;
		this.field2225 = var1.field2225;
		int var6;
		if (var2) {
			this.field2211 = var1.field2211;
			this.field2249 = var1.field2249;
			this.field2213 = var1.field2213;
		} else {
			this.field2211 = new int[this.field2210];
			this.field2249 = new int[this.field2210];
			this.field2213 = new int[this.field2210];

			for (var6 = 0; var6 < this.field2210; ++var6) {
				this.field2211[var6] = var1.field2211[var6];
				this.field2249[var6] = var1.field2249[var6];
				this.field2213[var6] = var1.field2213[var6];
			}
		}

		if (var3) {
			this.field2234 = var1.field2234;
		} else {
			this.field2234 = new short[this.field2214];

			for (var6 = 0; var6 < this.field2214; ++var6) {
				this.field2234[var6] = var1.field2234[var6];
			}
		}

		if (!var4 && var1.field2209 != null) {
			this.field2209 = new short[this.field2214];

			for (var6 = 0; var6 < this.field2214; ++var6) {
				this.field2209[var6] = var1.field2209[var6];
			}
		} else {
			this.field2209 = var1.field2209;
		}

		if (var5) {
			this.field2220 = var1.field2220;
		} else {
			this.field2220 = new byte[this.field2214];
			if (var1.field2220 == null) {
				for (var6 = 0; var6 < this.field2214; ++var6) {
					this.field2220[var6] = 0;
				}
			} else {
				for (var6 = 0; var6 < this.field2214; ++var6) {
					this.field2220[var6] = var1.field2220[var6];
				}
			}
		}

		this.field2215 = var1.field2215;
		this.field2216 = var1.field2216;
		this.field2217 = var1.field2217;
		this.field2218 = var1.field2218;
		this.field2219 = var1.field2219;
		this.field2233 = var1.field2233;
		this.field2224 = var1.field2224;
		this.field2226 = var1.field2226;
		this.field2229 = var1.field2229;
		this.field2222 = var1.field2222;
		this.field2251 = var1.field2251;
		this.field2230 = var1.field2230;
		this.field2231 = var1.field2231;
		this.field2232 = var1.field2232;
		this.field2212 = var1.field2212;
		this.field2237 = var1.field2237;
		this.field2236 = var1.field2236;
		this.field2238 = var1.field2238;
		this.field2207 = var1.field2207;
		this.field2235 = var1.field2235;
		this.field2239 = var1.field2239;
		this.field2240 = var1.field2240;
	}

	public class201 method3782() {
		class201 var1 = new class201();
		if (this.field2218 != null) {
			var1.field2218 = new byte[this.field2214];

			for (int var2 = 0; var2 < this.field2214; ++var2) {
				var1.field2218[var2] = this.field2218[var2];
			}
		}

		var1.field2210 = this.field2210;
		var1.field2214 = this.field2214;
		var1.field2225 = this.field2225;
		var1.field2211 = this.field2211;
		var1.field2249 = this.field2249;
		var1.field2213 = this.field2213;
		var1.field2215 = this.field2215;
		var1.field2216 = this.field2216;
		var1.field2217 = this.field2217;
		var1.field2219 = this.field2219;
		var1.field2220 = this.field2220;
		var1.field2233 = this.field2233;
		var1.field2234 = this.field2234;
		var1.field2209 = this.field2209;
		var1.field2224 = this.field2224;
		var1.field2226 = this.field2226;
		var1.field2229 = this.field2229;
		var1.field2222 = this.field2222;
		var1.field2251 = this.field2251;
		var1.field2230 = this.field2230;
		var1.field2231 = this.field2231;
		var1.field2232 = this.field2232;
		var1.field2212 = this.field2212;
		var1.field2237 = this.field2237;
		var1.field2236 = this.field2236;
		var1.field2239 = this.field2239;
		var1.field2240 = this.field2240;
		return var1;
	}

	public class201 method3798(int[][] var1, int var2, int var3, int var4, boolean var5, int var6) {
		this.method3848();
		int var7 = var2 + this.field2243;
		int var8 = var2 + this.field2244;
		int var9 = var4 + this.field2246;
		int var10 = var4 + this.field2245;
		if (var7 >= 0 && var8 + 128 >> 7 < var1.length && var9 >= 0 && var10 + 128 >> 7 < var1[0].length) {
			var7 >>= 7;
			var8 = var8 + 127 >> 7;
			var9 >>= 7;
			var10 = var10 + 127 >> 7;
			if (var1[var7][var9] == var3 && var1[var8][var9] == var3 && var1[var7][var10] == var3 && var1[var8][var10] == var3) {
				return this;
			} else {
				class201 var11;
				if (var5) {
					var11 = new class201();
					var11.field2210 = this.field2210;
					var11.field2214 = this.field2214;
					var11.field2225 = this.field2225;
					var11.field2211 = this.field2211;
					var11.field2213 = this.field2213;
					var11.field2215 = this.field2215;
					var11.field2216 = this.field2216;
					var11.field2217 = this.field2217;
					var11.field2218 = this.field2218;
					var11.field2219 = this.field2219;
					var11.field2220 = this.field2220;
					var11.field2233 = this.field2233;
					var11.field2234 = this.field2234;
					var11.field2209 = this.field2209;
					var11.field2224 = this.field2224;
					var11.field2226 = this.field2226;
					var11.field2229 = this.field2229;
					var11.field2222 = this.field2222;
					var11.field2251 = this.field2251;
					var11.field2230 = this.field2230;
					var11.field2231 = this.field2231;
					var11.field2232 = this.field2232;
					var11.field2212 = this.field2212;
					var11.field2239 = this.field2239;
					var11.field2240 = this.field2240;
					var11.field2249 = new int[var11.field2210];
				} else {
					var11 = this;
				}

				int var12;
				int var13;
				int var14;
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				int var20;
				int var21;
				if (var6 == 0) {
					for (var12 = 0; var12 < var11.field2210; ++var12) {
						var13 = this.field2211[var12] + var2;
						var14 = this.field2213[var12] + var4;
						var15 = var13 & 127;
						var16 = var14 & 127;
						var17 = var13 >> 7;
						var18 = var14 >> 7;
						var19 = var1[var17][var18] * (128 - var15) + var1[var17 + 1][var18] * var15 >> 7;
						var20 = var1[var17][var18 + 1] * (128 - var15) + var1[var17 + 1][var18 + 1] * var15 >> 7;
						var21 = var19 * (128 - var16) + var20 * var16 >> 7;
						var11.field2249[var12] = this.field2249[var12] + var21 - var3;
					}
				} else {
					for (var12 = 0; var12 < var11.field2210; ++var12) {
						var13 = (-this.field2249[var12] << 16) / super.field2489;
						if (var13 < var6) {
							var14 = this.field2211[var12] + var2;
							var15 = this.field2213[var12] + var4;
							var16 = var14 & 127;
							var17 = var15 & 127;
							var18 = var14 >> 7;
							var19 = var15 >> 7;
							var20 = var1[var18][var19] * (128 - var16) + var1[var18 + 1][var19] * var16 >> 7;
							var21 = var1[var18][var19 + 1] * (128 - var16) + var1[var18 + 1][var19 + 1] * var16 >> 7;
							int var22 = var20 * (128 - var17) + var21 * var17 >> 7;
							var11.field2249[var12] = this.field2249[var12] + (var22 - var3) * (var6 - var13) / var6;
						}
					}
				}

				var11.method3809();
				return var11;
			}
		} else {
			return this;
		}
	}

	void method3784() {
		int[] var1;
		int var2;
		int var10002;
		int var3;
		int var4;
		if (this.field2230 != null) {
			var1 = new int[256];
			var2 = 0;

			for (var3 = 0; var3 < this.field2210; ++var3) {
				var4 = this.field2230[var3];
				var10002 = var1[var4]++;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			this.field2232 = new int[var2 + 1][];

			for (var3 = 0; var3 <= var2; ++var3) {
				this.field2232[var3] = new int[var1[var3]];
				var1[var3] = 0;
			}

			for (var3 = 0; var3 < this.field2210; this.field2232[var4][var1[var4]++] = var3++) {
				var4 = this.field2230[var3];
			}

			this.field2230 = null;
		}

		if (this.field2231 != null) {
			var1 = new int[256];
			var2 = 0;

			for (var3 = 0; var3 < this.field2214; ++var3) {
				var4 = this.field2231[var3];
				var10002 = var1[var4]++;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			this.field2212 = new int[var2 + 1][];

			for (var3 = 0; var3 <= var2; ++var3) {
				this.field2212[var3] = new int[var1[var3]];
				var1[var3] = 0;
			}

			for (var3 = 0; var3 < this.field2214; this.field2212[var4][var1[var4]++] = var3++) {
				var4 = this.field2231[var3];
			}

			this.field2231 = null;
		}

	}

	public void method3821() {
		for (int var1 = 0; var1 < this.field2210; ++var1) {
			int var2 = this.field2211[var1];
			this.field2211[var1] = this.field2213[var1];
			this.field2213[var1] = -var2;
		}

		this.method3809();
	}

	public void method3786() {
		for (int var1 = 0; var1 < this.field2210; ++var1) {
			this.field2211[var1] = -this.field2211[var1];
			this.field2213[var1] = -this.field2213[var1];
		}

		this.method3809();
	}

	public void method3787() {
		for (int var1 = 0; var1 < this.field2210; ++var1) {
			int var2 = this.field2213[var1];
			this.field2213[var1] = this.field2211[var1];
			this.field2211[var1] = -var2;
		}

		this.method3809();
	}

	public void method3788(int var1) {
		int var2 = field2208[var1];
		int var3 = field2227[var1];

		for (int var4 = 0; var4 < this.field2210; ++var4) {
			int var5 = this.field2213[var4] * var2 + this.field2211[var4] * var3 >> 16;
			this.field2213[var4] = this.field2213[var4] * var3 - this.field2211[var4] * var2 >> 16;
			this.field2211[var4] = var5;
		}

		this.method3809();
	}

	public void method3822(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.field2210; ++var4) {
			int[] var10000 = this.field2211;
			var10000[var4] += var1;
			var10000 = this.field2249;
			var10000[var4] += var2;
			var10000 = this.field2213;
			var10000[var4] += var3;
		}

		this.method3809();
	}

	public void method3790(short var1, short var2) {
		for (int var3 = 0; var3 < this.field2214; ++var3) {
			if (this.field2234[var3] == var1) {
				this.field2234[var3] = var2;
			}
		}

	}

	public void method3791(short var1, short var2) {
		if (this.field2209 != null) {
			for (int var3 = 0; var3 < this.field2214; ++var3) {
				if (this.field2209[var3] == var1) {
					this.field2209[var3] = var2;
				}
			}

		}
	}

	public void method3792() {
		int var1;
		for (var1 = 0; var1 < this.field2210; ++var1) {
			this.field2213[var1] = -this.field2213[var1];
		}

		for (var1 = 0; var1 < this.field2214; ++var1) {
			int var2 = this.field2215[var1];
			this.field2215[var1] = this.field2217[var1];
			this.field2217[var1] = var2;
		}

		this.method3809();
	}

	public void method3776(int var1, int var2, int var3) {
		for (int var4 = 0; var4 < this.field2210; ++var4) {
			this.field2211[var4] = this.field2211[var4] * var1 / 128;
			this.field2249[var4] = this.field2249[var4] * var2 / 128;
			this.field2213[var4] = this.field2213[var4] * var3 / 128;
		}

		this.method3809();
	}

	public void method3793() {
		if (this.field2237 == null) {
			this.field2237 = new class231[this.field2210];

			int var1;
			for (var1 = 0; var1 < this.field2210; ++var1) {
				this.field2237[var1] = new class231();
			}

			for (var1 = 0; var1 < this.field2214; ++var1) {
				int var2 = this.field2215[var1];
				int var3 = this.field2216[var1];
				int var4 = this.field2217[var1];
				int var5 = this.field2211[var3] - this.field2211[var2];
				int var6 = this.field2249[var3] - this.field2249[var2];
				int var7 = this.field2213[var3] - this.field2213[var2];
				int var8 = this.field2211[var4] - this.field2211[var2];
				int var9 = this.field2249[var4] - this.field2249[var2];
				int var10 = this.field2213[var4] - this.field2213[var2];
				int var11 = var6 * var10 - var9 * var7;
				int var12 = var7 * var8 - var10 * var5;

				int var13;
				for (var13 = var5 * var9 - var8 * var6; var11 > 8192 || var12 > 8192 || var13 > 8192 || var11 < -8192 || var12 < -8192 || var13 < -8192; var13 >>= 1) {
					var11 >>= 1;
					var12 >>= 1;
				}

				int var14 = (int)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
				if (var14 <= 0) {
					var14 = 1;
				}

				var11 = var11 * 256 / var14;
				var12 = var12 * 256 / var14;
				var13 = var13 * 256 / var14;
				byte var15;
				if (this.field2218 == null) {
					var15 = 0;
				} else {
					var15 = this.field2218[var1];
				}

				if (var15 == 0) {
					class231 var16 = this.field2237[var2];
					var16.field2752 += var11;
					var16.field2749 += var12;
					var16.field2750 += var13;
					++var16.field2751;
					var16 = this.field2237[var3];
					var16.field2752 += var11;
					var16.field2749 += var12;
					var16.field2750 += var13;
					++var16.field2751;
					var16 = this.field2237[var4];
					var16.field2752 += var11;
					var16.field2749 += var12;
					var16.field2750 += var13;
					++var16.field2751;
				} else if (var15 == 1) {
					if (this.field2236 == null) {
						this.field2236 = new class233[this.field2214];
					}

					class233 var17 = this.field2236[var1] = new class233();
					var17.field2765 = var11;
					var17.field2760 = var12;
					var17.field2761 = var13;
				}
			}

		}
	}

	void method3809() {
		this.field2237 = null;
		this.field2238 = null;
		this.field2236 = null;
		this.field2241 = false;
	}

	void method3848() {
		if (!this.field2241) {
			super.field2489 = 0;
			this.field2242 = 0;
			this.field2243 = 999999;
			this.field2244 = -999999;
			this.field2245 = -99999;
			this.field2246 = 99999;

			for (int var1 = 0; var1 < this.field2210; ++var1) {
				int var2 = this.field2211[var1];
				int var3 = this.field2249[var1];
				int var4 = this.field2213[var1];
				if (var2 < this.field2243) {
					this.field2243 = var2;
				}

				if (var2 > this.field2244) {
					this.field2244 = var2;
				}

				if (var4 < this.field2246) {
					this.field2246 = var4;
				}

				if (var4 > this.field2245) {
					this.field2245 = var4;
				}

				if (-var3 > super.field2489) {
					super.field2489 = -var3;
				}

				if (var3 > this.field2242) {
					this.field2242 = var3;
				}
			}

			this.field2241 = true;
		}
	}

	static void method3795(class201 var0, class201 var1, int var2, int var3, int var4, boolean var5) {
		var0.method3848();
		var0.method3793();
		var1.method3848();
		var1.method3793();
		++field2223;
		int var6 = 0;
		int[] var7 = var1.field2211;
		int var8 = var1.field2210;

		int var9;
		for (var9 = 0; var9 < var0.field2210; ++var9) {
			class231 var10 = var0.field2237[var9];
			if (var10.field2751 != 0) {
				int var11 = var0.field2249[var9] - var3;
				if (var11 <= var1.field2242) {
					int var12 = var0.field2211[var9] - var2;
					if (var12 >= var1.field2243 && var12 <= var1.field2244) {
						int var13 = var0.field2213[var9] - var4;
						if (var13 >= var1.field2246 && var13 <= var1.field2245) {
							for (int var14 = 0; var14 < var8; ++var14) {
								class231 var15 = var1.field2237[var14];
								if (var12 == var7[var14] && var13 == var1.field2213[var14] && var11 == var1.field2249[var14] && var15.field2751 != 0) {
									if (var0.field2238 == null) {
										var0.field2238 = new class231[var0.field2210];
									}

									if (var1.field2238 == null) {
										var1.field2238 = new class231[var8];
									}

									class231 var16 = var0.field2238[var9];
									if (var16 == null) {
										var16 = var0.field2238[var9] = new class231(var10);
									}

									class231 var17 = var1.field2238[var14];
									if (var17 == null) {
										var17 = var1.field2238[var14] = new class231(var15);
									}

									var16.field2752 += var15.field2752;
									var16.field2749 += var15.field2749;
									var16.field2750 += var15.field2750;
									var16.field2751 += var15.field2751;
									var17.field2752 += var10.field2752;
									var17.field2749 += var10.field2749;
									var17.field2750 += var10.field2750;
									var17.field2751 += var10.field2751;
									++var6;
									field2247[var9] = field2223;
									field2248[var14] = field2223;
								}
							}
						}
					}
				}
			}
		}

		if (var6 >= 3 && var5) {
			for (var9 = 0; var9 < var0.field2214; ++var9) {
				if (field2247[var0.field2215[var9]] == field2223 && field2247[var0.field2216[var9]] == field2223 && field2247[var0.field2217[var9]] == field2223) {
					if (var0.field2218 == null) {
						var0.field2218 = new byte[var0.field2214];
					}

					var0.field2218[var9] = 2;
				}
			}

			for (var9 = 0; var9 < var1.field2214; ++var9) {
				if (field2248[var1.field2215[var9]] == field2223 && field2248[var1.field2216[var9]] == field2223 && field2248[var1.field2217[var9]] == field2223) {
					if (var1.field2218 == null) {
						var1.field2218 = new byte[var1.field2214];
					}

					var1.field2218[var9] = 2;
				}
			}

		}
	}

	public final class209 method3796(int var1, int var2, int var3, int var4, int var5) {
		this.method3793();
		int var6 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
		int var7 = var2 * var6 >> 8;
		class209 var8 = new class209();
		var8.field2391 = new int[this.field2214];
		var8.field2392 = new int[this.field2214];
		var8.field2393 = new int[this.field2214];
		if (this.field2225 > 0 && this.field2233 != null) {
			int[] var9 = new int[this.field2225];

			int var10;
			for (var10 = 0; var10 < this.field2214; ++var10) {
				if (this.field2233[var10] != -1) {
					++var9[this.field2233[var10] & 255];
				}
			}

			var8.field2425 = 0;

			for (var10 = 0; var10 < this.field2225; ++var10) {
				if (var9[var10] > 0 && this.field2226[var10] == 0) {
					++var8.field2425;
				}
			}

			var8.field2434 = new int[var8.field2425];
			var8.field2401 = new int[var8.field2425];
			var8.field2402 = new int[var8.field2425];
			var10 = 0;

			int var11;
			for (var11 = 0; var11 < this.field2225; ++var11) {
				if (var9[var11] > 0 && this.field2226[var11] == 0) {
					var8.field2434[var10] = this.field2229[var11] & '\uffff';
					var8.field2401[var10] = this.field2222[var11] & '\uffff';
					var8.field2402[var10] = this.field2251[var11] & '\uffff';
					var9[var11] = var10++;
				} else {
					var9[var11] = -1;
				}
			}

			var8.field2396 = new byte[this.field2214];

			for (var11 = 0; var11 < this.field2214; ++var11) {
				if (this.field2233[var11] != -1) {
					var8.field2396[var11] = (byte)var9[this.field2233[var11] & 255];
				} else {
					var8.field2396[var11] = -1;
				}
			}
		}

		for (int var16 = 0; var16 < this.field2214; ++var16) {
			byte var17;
			if (this.field2218 == null) {
				var17 = 0;
			} else {
				var17 = this.field2218[var16];
			}

			byte var18;
			if (this.field2220 == null) {
				var18 = 0;
			} else {
				var18 = this.field2220[var16];
			}

			short var12;
			if (this.field2209 == null) {
				var12 = -1;
			} else {
				var12 = this.field2209[var16];
			}

			if (var18 == -2) {
				var17 = 3;
			}

			if (var18 == -1) {
				var17 = 2;
			}

			class231 var13;
			int var14;
			class233 var19;
			if (var12 == -1) {
				if (var17 != 0) {
					if (var17 == 1) {
						var19 = this.field2236[var16];
						var14 = var1 + (var3 * var19.field2765 + var4 * var19.field2760 + var5 * var19.field2761) / (var7 + var7 / 2);
						var8.field2391[var16] = method3807(this.field2234[var16] & '\uffff', var14);
						var8.field2393[var16] = -1;
					} else if (var17 == 3) {
						var8.field2391[var16] = 128;
						var8.field2393[var16] = -1;
					} else {
						var8.field2393[var16] = -2;
					}
				} else {
					int var15 = this.field2234[var16] & '\uffff';
					if (this.field2238 != null && this.field2238[this.field2215[var16]] != null) {
						var13 = this.field2238[this.field2215[var16]];
					} else {
						var13 = this.field2237[this.field2215[var16]];
					}

					var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
					var8.field2391[var16] = method3807(var15, var14);
					if (this.field2238 != null && this.field2238[this.field2216[var16]] != null) {
						var13 = this.field2238[this.field2216[var16]];
					} else {
						var13 = this.field2237[this.field2216[var16]];
					}

					var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
					var8.field2392[var16] = method3807(var15, var14);
					if (this.field2238 != null && this.field2238[this.field2217[var16]] != null) {
						var13 = this.field2238[this.field2217[var16]];
					} else {
						var13 = this.field2237[this.field2217[var16]];
					}

					var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
					var8.field2393[var16] = method3807(var15, var14);
				}
			} else if (var17 != 0) {
				if (var17 == 1) {
					var19 = this.field2236[var16];
					var14 = var1 + (var3 * var19.field2765 + var4 * var19.field2760 + var5 * var19.field2761) / (var7 + var7 / 2);
					var8.field2391[var16] = method3828(var14);
					var8.field2393[var16] = -1;
				} else {
					var8.field2393[var16] = -2;
				}
			} else {
				if (this.field2238 != null && this.field2238[this.field2215[var16]] != null) {
					var13 = this.field2238[this.field2215[var16]];
				} else {
					var13 = this.field2237[this.field2215[var16]];
				}

				var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
				var8.field2391[var16] = method3828(var14);
				if (this.field2238 != null && this.field2238[this.field2216[var16]] != null) {
					var13 = this.field2238[this.field2216[var16]];
				} else {
					var13 = this.field2237[this.field2216[var16]];
				}

				var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
				var8.field2392[var16] = method3828(var14);
				if (this.field2238 != null && this.field2238[this.field2217[var16]] != null) {
					var13 = this.field2238[this.field2217[var16]];
				} else {
					var13 = this.field2237[this.field2217[var16]];
				}

				var14 = var1 + (var3 * var13.field2752 + var4 * var13.field2749 + var5 * var13.field2750) / (var7 * var13.field2751);
				var8.field2393[var16] = method3828(var14);
			}
		}

		this.method3784();
		var8.field2383 = this.field2210;
		var8.field2384 = this.field2211;
		var8.field2378 = this.field2249;
		var8.field2385 = this.field2213;
		var8.field2409 = this.field2214;
		var8.field2388 = this.field2215;
		var8.field2389 = this.field2216;
		var8.field2390 = this.field2217;
		var8.field2394 = this.field2219;
		var8.field2387 = this.field2220;
		var8.field2376 = this.field2224;
		var8.field2448 = this.field2232;
		var8.field2404 = this.field2212;
		var8.field2397 = this.field2209;
		var8.field2412 = this.field2207;
		var8.field2406 = this.field2235;
		return var8;
	}

	static final int method3807(int var0, int var1) {
		var1 = var1 * (var0 & 127) >> 7;
		if (var1 < 2) {
			var1 = 2;
		} else if (var1 > 126) {
			var1 = 126;
		}

		return (var0 & 65408) + var1;
	}

	static final int method3828(int var0) {
		if (var0 < 2) {
			var0 = 2;
		} else if (var0 > 126) {
			var0 = 126;
		}

		return var0;
	}
}
