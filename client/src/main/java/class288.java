public class class288 extends class427 {
	byte[] field3350;
	byte[] field3351;
	byte[] field3353;
	class286[] field3352;
	class39[] field3348;
	int field3356;
	int[] field3354;
	short[] field3349;

	class288(byte[] var1) {
		this.field3348 = new class39[128];
		this.field3349 = new short[128];
		this.field3350 = new byte[128];
		this.field3351 = new byte[128];
		this.field3352 = new class286[128];
		this.field3353 = new byte[128];
		this.field3354 = new int[128];
		Buffer var2 = new Buffer(var1);

		int var3;
		for (var3 = 0; 0 != var2.data[var3 + var2.offset]; ++var3) {
		}

		byte[] var4 = new byte[var3];

		int var5;
		for (var5 = 0; var5 < var3; ++var5) {
			var4[var5] = var2.readByte();
		}

		++var2.offset;
		++var3;
		var5 = var2.offset;
		var2.offset += var3;

		int var6;
		for (var6 = 0; 0 != var2.data[var2.offset + var6]; ++var6) {
		}

		byte[] var7 = new byte[var6];

		int var8;
		for (var8 = 0; var8 < var6; ++var8) {
			var7[var8] = var2.readByte();
		}

		++var2.offset;
		++var6;
		var8 = var2.offset;
		var2.offset += var6;

		int var9;
		for (var9 = 0; var2.data[var9 + var2.offset] != 0; ++var9) {
		}

		byte[] var10 = new byte[var9];

		for (int var11 = 0; var11 < var9; ++var11) {
			var10[var11] = var2.readByte();
		}

		++var2.offset;
		++var9;
		byte[] var36 = new byte[var9];
		int var12;
		int var14;
		if (var9 > 1) {
			var36[1] = 1;
			int var13 = 1;
			var12 = 2;

			for (var14 = 2; var14 < var9; ++var14) {
				int var15 = var2.readUnsignedByte();
				if (var15 == 0) {
					var13 = var12++;
				} else {
					if (var15 <= var13) {
						--var15;
					}

					var13 = var15;
				}

				var36[var14] = (byte)var13;
			}
		} else {
			var12 = var9;
		}

		class286[] var37 = new class286[var12];

		class286 var38;
		for (var14 = 0; var14 < var37.length; ++var14) {
			var38 = var37[var14] = new class286();
			int var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field3341 = new byte[var16 * 2];
			}

			var16 = var2.readUnsignedByte();
			if (var16 > 0) {
				var38.field3339 = new byte[var16 * 2 + 2];
				var38.field3339[1] = 64;
			}
		}

		var14 = var2.readUnsignedByte();
		byte[] var45 = var14 > 0 ? new byte[var14 * 2] : null;
		var14 = var2.readUnsignedByte();
		byte[] var39 = var14 > 0 ? new byte[var14 * 2] : null;

		int var17;
		for (var17 = 0; var2.data[var17 + var2.offset] != 0; ++var17) {
		}

		byte[] var18 = new byte[var17];

		int var19;
		for (var19 = 0; var19 < var17; ++var19) {
			var18[var19] = var2.readByte();
		}

		++var2.offset;
		++var17;
		var19 = 0;

		int var20;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			this.field3349[var20] = (short)var19;
		}

		var19 = 0;

		short[] var48;
		for (var20 = 0; var20 < 128; ++var20) {
			var19 += var2.readUnsignedByte();
			var48 = this.field3349;
			var48[var20] = (short)(var48[var20] + (var19 << 8));
		}

		var20 = 0;
		int var21 = 0;
		int var22 = 0;

		int var23;
		for (var23 = 0; var23 < 128; ++var23) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				var22 = var2.method8235();
			}

			var48 = this.field3349;
			var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
			this.field3354[var23] = var22;
			--var20;
		}

		var20 = 0;
		var21 = 0;
		var23 = 0;

		int var24;
		for (var24 = 0; var24 < 128; ++var24) {
			if (this.field3354[var24] != 0) {
				if (var20 == 0) {
					if (var21 < var4.length) {
						var20 = var4[var21++];
					} else {
						var20 = -1;
					}

					var23 = var2.data[var5++] - 1;
				}

				this.field3353[var24] = (byte)var23;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var24 = 0;

		for (int var25 = 0; var25 < 128; ++var25) {
			if (this.field3354[var25] != 0) {
				if (var20 == 0) {
					if (var21 < var7.length) {
						var20 = var7[var21++];
					} else {
						var20 = -1;
					}

					var24 = var2.data[var8++] + 16 << 2;
				}

				this.field3351[var25] = (byte)var24;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		class286 var40 = null;

		int var26;
		for (var26 = 0; var26 < 128; ++var26) {
			if (0 != this.field3354[var26]) {
				if (var20 == 0) {
					var40 = var37[var36[var21]];
					if (var21 < var10.length) {
						var20 = var10[var21++];
					} else {
						var20 = -1;
					}
				}

				this.field3352[var26] = var40;
				--var20;
			}
		}

		var20 = 0;
		var21 = 0;
		var26 = 0;

		int var27;
		for (var27 = 0; var27 < 128; ++var27) {
			if (var20 == 0) {
				if (var21 < var18.length) {
					var20 = var18[var21++];
				} else {
					var20 = -1;
				}

				if (this.field3354[var27] > 0) {
					var26 = var2.readUnsignedByte() + 1;
				}
			}

			this.field3350[var27] = (byte)var26;
			--var20;
		}

		this.field3356 = var2.readUnsignedByte() + 1;

		class286 var28;
		int var29;
		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3341 != null) {
				for (var29 = 1; var29 < var28.field3341.length; var29 += 2) {
					var28.field3341[var29] = var2.readByte();
				}
			}

			if (null != var28.field3339) {
				for (var29 = 3; var29 < var28.field3339.length - 2; var29 += 2) {
					var28.field3339[var29] = var2.readByte();
				}
			}
		}

		if (null != var45) {
			for (var27 = 1; var27 < var45.length; var27 += 2) {
				var45[var27] = var2.readByte();
			}
		}

		if (var39 != null) {
			for (var27 = 1; var27 < var39.length; var27 += 2) {
				var39[var27] = var2.readByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3339 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field3339.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field3339[var29] = (byte)var19;
				}
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3341 != null) {
				var19 = 0;

				for (var29 = 2; var29 < var28.field3341.length; var29 += 2) {
					var19 = var19 + 1 + var2.readUnsignedByte();
					var28.field3341[var29] = (byte)var19;
				}
			}
		}

		byte var30;
		int var32;
		int var33;
		int var34;
		int var42;
		byte var44;
		if (null != var45) {
			var19 = var2.readUnsignedByte();
			var45[0] = (byte)var19;

			for (var27 = 2; var27 < var45.length; var27 += 2) {
				var19 = var19 + 1 + var2.readUnsignedByte();
				var45[var27] = (byte)var19;
			}

			var44 = var45[0];
			byte var41 = var45[1];

			for (var29 = 0; var29 < var44; ++var29) {
				this.field3350[var29] = (byte)(this.field3350[var29] * var41 + 32 >> 6);
			}

			for (var29 = 2; var29 < var45.length; var29 += 2) {
				var30 = var45[var29];
				byte var31 = var45[var29 + 1];
				var32 = (var30 - var44) * var41 + (var30 - var44) / 2;

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = class282.method5210(var32, var30 - var44);
					this.field3350[var33] = (byte)(32 + this.field3350[var33] * var34 >> 6);
					var32 += var31 - var41;
				}

				var44 = var30;
				var41 = var31;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				this.field3350[var42] = (byte)(32 + var41 * this.field3350[var42] >> 6);
			}

			var38 = null;
		}

		if (null != var39) {
			var19 = var2.readUnsignedByte();
			var39[0] = (byte)var19;

			for (var27 = 2; var27 < var39.length; var27 += 2) {
				var19 = var19 + 1 + var2.readUnsignedByte();
				var39[var27] = (byte)var19;
			}

			var44 = var39[0];
			int var47 = var39[1] << 1;

			for (var29 = 0; var29 < var44; ++var29) {
				var42 = (this.field3351[var29] & 255) + var47;
				if (var42 < 0) {
					var42 = 0;
				}

				if (var42 > 128) {
					var42 = 128;
				}

				this.field3351[var29] = (byte)var42;
			}

			int var43;
			for (var29 = 2; var29 < var39.length; var29 += 2) {
				var30 = var39[var29];
				var43 = var39[var29 + 1] << 1;
				var32 = (var30 - var44) / 2 + var47 * (var30 - var44);

				for (var33 = var44; var33 < var30; ++var33) {
					var34 = class282.method5210(var32, var30 - var44);
					int var35 = var34 + (this.field3351[var33] & 255);
					if (var35 < 0) {
						var35 = 0;
					}

					if (var35 > 128) {
						var35 = 128;
					}

					this.field3351[var33] = (byte)var35;
					var32 += var43 - var47;
				}

				var44 = var30;
				var47 = var43;
			}

			for (var42 = var44; var42 < 128; ++var42) {
				var43 = var47 + (this.field3351[var42] & 255);
				if (var43 < 0) {
					var43 = 0;
				}

				if (var43 > 128) {
					var43 = 128;
				}

				this.field3351[var42] = (byte)var43;
			}

			Object var46 = null;
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field3335 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3341 != null) {
				var28.field3336 = var2.readUnsignedByte();
			}

			if (var28.field3339 != null) {
				var28.field3337 = var2.readUnsignedByte();
			}

			if (var28.field3335 > 0) {
				var28.field3338 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var37[var27].field3340 = var2.readUnsignedByte();
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3340 > 0) {
				var28.field3333 = var2.readUnsignedByte();
			}
		}

		for (var27 = 0; var27 < var12; ++var27) {
			var28 = var37[var27];
			if (var28.field3333 > 0) {
				var28.field3334 = var2.readUnsignedByte();
			}
		}

	}

	boolean method5455(class49 var1, byte[] var2, int[] var3) {
		boolean var5 = true;
		int var6 = 0;
		class39 var7 = null;

		for (int var8 = 0; var8 < 128; ++var8) {
			if (var2 == null || 0 != var2[var8]) {
				int var9 = this.field3354[var8];
				if (var9 != 0) {
					if (var6 != var9) {
						var6 = var9--;
						if ((var9 & 1) == 0) {
							var7 = var1.method988(var9 >> 2, var3);
						} else {
							var7 = var1.method985(var9 >> 2, var3);
						}

						if (null == var7) {
							var5 = false;
						}
					}

					if (var7 != null) {
						this.field3348[var8] = var7;
						this.field3354[var8] = 0;
					}
				}
			}
		}

		return var5;
	}

	void method5454() {
		this.field3354 = null;
	}
}
