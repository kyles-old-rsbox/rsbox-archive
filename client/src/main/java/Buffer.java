import java.math.BigInteger;

public class Buffer extends class427 {
	public static int field4885;
	static int[] field4883;
	static long[] field4882;
	public byte[] data;
	public int offset;

	static {
		field4883 = new int[256];

		int var2;
		for (int var1 = 0; var1 < 256; ++var1) {
			int var0 = var1;

			for (var2 = 0; var2 < 8; ++var2) {
				if (1 == (var0 & 1)) {
					var0 = var0 >>> 1 ^ -306674912;
				} else {
					var0 >>>= 1;
				}
			}

			field4883[var1] = var0;
		}

		field4882 = new long[256];

		for (var2 = 0; var2 < 256; ++var2) {
			long var4 = (long)var2;

			for (int var3 = 0; var3 < 8; ++var3) {
				if (1L == (var4 & 1L)) {
					var4 = var4 >>> 1 ^ -3932672073523589310L;
				} else {
					var4 >>>= 1;
				}
			}

			field4882[var2] = var4;
		}

	}

	public Buffer(int var1) {
		this.data = class378.method765(var1);
		this.offset = 0;
	}

	public Buffer(byte[] var1) {
		this.data = var1;
		this.offset = 0;
	}

	public void method8103() {
		if (this.data != null) {
			class205.method3927(this.data);
		}

		this.data = null;
	}

	public void writeByte(int var1) {
		this.data[++this.offset - 1] = (byte)var1;
	}

	public void writeShort(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)var1;
	}

	public void writeMedium(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)var1;
	}

	public void writeInt(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 24);
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)var1;
	}

	public void method8108(long var1) {
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 40));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 32));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 24));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 16));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 8));
		this.data[++this.offset - 1] = (byte)((int)var1);
	}

	public void writeLong(long var1) {
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 56));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 48));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 40));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 32));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 24));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 16));
		this.data[++this.offset - 1] = (byte)((int)(var1 >> 8));
		this.data[++this.offset - 1] = (byte)((int)var1);
	}

	public void method8110(boolean var1) {
		this.writeByte(var1 ? 1 : 0);
	}

	public static int method1887(String var0) {
		return var0.length() + 1;
	}

	public void writeString(String var1) {
		int var3 = var1.indexOf(0);
		if (var3 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.offset += class287.method5453(var1, 0, var1.length(), this.data, this.offset);
			this.data[++this.offset - 1] = 0;
		}
	}

	public void method8112(String var1) {
		int var3 = var1.indexOf(0);
		if (var3 >= 0) {
			throw new IllegalArgumentException("");
		} else {
			this.data[++this.offset - 1] = 0;
			this.offset += class287.method5453(var1, 0, var1.length(), this.data, this.offset);
			this.data[++this.offset - 1] = 0;
		}
	}

	public void method8199(CharSequence var1) {
		int var4 = var1.length();
		int var5 = 0;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			char var7 = var1.charAt(var6);
			if (var7 <= 127) {
				++var5;
			} else if (var7 <= 2047) {
				var5 += 2;
			} else {
				var5 += 3;
			}
		}

		this.data[++this.offset - 1] = 0;
		this.method8232(var5);
		var5 = this.offset * 109870945;
		byte[] var13 = this.data;
		int var8 = this.offset;
		int var9 = var1.length();
		int var10 = var8;

		for (int var11 = 0; var11 < var9; ++var11) {
			char var12 = var1.charAt(var11);
			if (var12 <= 127) {
				var13[var10++] = (byte)var12;
			} else if (var12 <= 2047) {
				var13[var10++] = (byte)(192 | var12 >> 6);
				var13[var10++] = (byte)(128 | var12 & '?');
			} else {
				var13[var10++] = (byte)(224 | var12 >> '\f');
				var13[var10++] = (byte)(128 | var12 >> 6 & 63);
				var13[var10++] = (byte)(128 | var12 & '?');
			}
		}

		var6 = var10 - var8;
		this.offset = (var6 * 109870945 + var5) * 891446433;
	}

	public void writeBytes(byte[] var1, int var2, int var3) {
		for (int var5 = var2; var5 < var3 + var2; ++var5) {
			this.data[++this.offset - 1] = var1[var5];
		}

	}

	public void writeBytes(Buffer var1) {
		this.writeBytes(var1.data, 0, var1.offset);
	}

	public void method8105(int var1) {
		if (var1 < 0) {
			throw new IllegalArgumentException();
		} else {
			this.data[this.offset - var1 - 4] = (byte)(var1 >> 24);
			this.data[this.offset - var1 - 3] = (byte)(var1 >> 16);
			this.data[this.offset - var1 - 2] = (byte)(var1 >> 8);
			this.data[this.offset - var1 - 1] = (byte)var1;
		}
	}

	public void writeLengthShort(int var1) {
		if (var1 >= 0 && var1 <= 65535) {
			this.data[this.offset - var1 - 2] = (byte)(var1 >> 8);
			this.data[this.offset - var1 - 1] = (byte)var1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void method8151(int var1) {
		if (var1 >= 0 && var1 <= 255) {
			this.data[this.offset - var1 - 1] = (byte)var1;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void method8247(int var1) {
		if (var1 >= 0 && var1 < 128) {
			this.writeByte(var1);
		} else if (var1 >= 0 && var1 < 32768) {
			this.writeShort(var1 + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void method8232(int var1) {
		if (0 != (var1 & -128)) {
			if (0 != (var1 & -16384)) {
				if ((var1 & -2097152) != 0) {
					if ((var1 & -268435456) != 0) {
						this.writeByte(var1 >>> 28 | 128);
					}

					this.writeByte(var1 >>> 21 | 128);
				}

				this.writeByte(var1 >>> 14 | 128);
			}

			this.writeByte(var1 >>> 7 | 128);
		}

		this.writeByte(var1 & 127);
	}

	public int method8141() {
		return this.data[++this.offset - 1] & 255;
	}

	public byte method8287() {
		return this.data[++this.offset - 1];
	}

	public int readUnsignedShort() {
		this.offset += 2;
		return (this.data[this.offset - 1] & 255) + ((this.data[this.offset - 2] & 255) << 8);
	}

	public int method8204() {
		this.offset += 2;
		int var2 = ((this.data[this.offset - 2] & 255) << 8) + (this.data[this.offset - 1] & 255);
		if (var2 > 32767) {
			var2 -= 65536;
		}

		return var2;
	}

	public int method8312() {
		this.offset += 3;
		return ((this.data[this.offset - 3] & 255) << 16) + ((this.data[this.offset - 2] & 255) << 8) + (this.data[this.offset - 1] & 255);
	}

	public int method8125() {
		this.offset += 3;
		int var2 = ((this.data[this.offset - 3] & 255) << 16) + ((this.data[this.offset - 2] & 255) << 8) + (this.data[this.offset - 1] & 255);
		if (var2 > 8388607) {
			var2 -= 16777216;
		}

		return var2;
	}

	public int readInt() {
		this.offset += 4;
		return ((this.data[this.offset - 2] & 255) << 8) + ((this.data[this.offset - 4] & 255) << 24) + ((this.data[this.offset - 3] & 255) << 16) + (this.data[this.offset - 1] & 255);
	}

	public long readLong() {
		long var2 = (long)this.readInt() & 4294967295L;
		long var4 = (long)this.readInt() & 4294967295L;
		return var4 + (var2 << 32);
	}

	public float method8128() {
		return Float.intBitsToFloat(this.readInt());
	}

	public boolean method8129() {
		return (this.method8141() & 1) == 1;
	}

	public String method8305() {
		if (this.data[this.offset] == 0) {
			++this.offset;
			return null;
		} else {
			return this.readString();
		}
	}

	public String readString() {
		int var2 = this.offset;

		while (this.data[++this.offset - 1] != 0) {
		}

		int var3 = this.offset - var2 - 1;
		return var3 == 0 ? "" : class126.method2371(this.data, var2, var3);
	}

	public String method8132() {
		byte var2 = this.data[++this.offset - 1];
		if (var2 != 0) {
			throw new IllegalStateException("");
		} else {
			int var3 = this.offset;

			while (this.data[++this.offset - 1] != 0) {
			}

			int var4 = this.offset - var3 - 1;
			return var4 == 0 ? "" : class126.method2371(this.data, var3, var4);
		}
	}

	public String method8133() {
		byte var2 = this.data[++this.offset - 1];
		if (var2 != 0) {
			throw new IllegalStateException("");
		} else {
			int var3 = this.method8235();
			if (this.offset + var3 > this.data.length) {
				throw new IllegalStateException("");
			} else {
				byte[] var5 = this.data;
				int var6 = this.offset;
				char[] var7 = new char[var3];
				int var8 = 0;
				int var9 = var6;

				int var12;
				for (int var10 = var6 + var3; var9 < var10; var7[var8++] = (char)var12) {
					int var11 = var5[var9++] & 255;
					if (var11 < 128) {
						if (var11 == 0) {
							var12 = 65533;
						} else {
							var12 = var11;
						}
					} else if (var11 < 192) {
						var12 = 65533;
					} else if (var11 < 224) {
						if (var9 < var10 && (var5[var9] & 192) == 128) {
							var12 = (var11 & 31) << 6 | var5[var9++] & 63;
							if (var12 < 128) {
								var12 = 65533;
							}
						} else {
							var12 = 65533;
						}
					} else if (var11 < 240) {
						if (var9 + 1 < var10 && (var5[var9] & 192) == 128 && (var5[var9 + 1] & 192) == 128) {
							var12 = (var11 & 15) << 12 | (var5[var9++] & 63) << 6 | var5[var9++] & 63;
							if (var12 < 2048) {
								var12 = 65533;
							}
						} else {
							var12 = 65533;
						}
					} else if (var11 < 248) {
						if (var9 + 2 < var10 && 128 == (var5[var9] & 192) && (var5[var9 + 1] & 192) == 128 && 128 == (var5[var9 + 2] & 192)) {
							var12 = (var11 & 7) << 18 | (var5[var9++] & 63) << 12 | (var5[var9++] & 63) << 6 | var5[var9++] & 63;
							if (var12 >= 65536 && var12 <= 1114111) {
								var12 = 65533;
							} else {
								var12 = 65533;
							}
						} else {
							var12 = 65533;
						}
					} else {
						var12 = 65533;
					}
				}

				String var4 = new String(var7, 0, var8);
				this.offset += var3;
				return var4;
			}
		}
	}

	public void method8333(byte[] var1, int var2, int var3) {
		for (int var5 = var2; var5 < var3 + var2; ++var5) {
			var1[var5] = this.data[++this.offset - 1];
		}

	}

	public int method8219() {
		int var2 = this.data[this.offset] & 255;
		return var2 < 128 ? this.method8141() - 64 : this.readUnsignedShort() - 49152;
	}

	public int method8207() {
		int var2 = this.data[this.offset] & 255;
		return var2 < 128 ? this.method8141() : this.readUnsignedShort() - 32768;
	}

	public int method8359() {
		int var2 = this.data[this.offset] & 255;
		return var2 < 128 ? this.method8141() - 1 : this.readUnsignedShort() - 32769;
	}

	public int method8138() {
		int var2 = 0;

		int var3;
		for (var3 = this.method8207(); var3 == 32767; var3 = this.method8207()) {
			var2 += 32767;
		}

		var2 += var3;
		return var2;
	}

	public int method8139() {
		return this.data[this.offset] < 0 ? this.readInt() & Integer.MAX_VALUE : this.readUnsignedShort();
	}

	public int method8140() {
		if (this.data[this.offset] < 0) {
			return this.readInt() & Integer.MAX_VALUE;
		} else {
			int var2 = this.readUnsignedShort();
			return var2 == 32767 ? -1 : var2;
		}
	}

	public int method8235() {
		byte var2 = this.data[++this.offset - 1];

		int var3;
		for (var3 = 0; var2 < 0; var2 = this.data[++this.offset - 1]) {
			var3 = (var3 | var2 & 127) << 7;
		}

		return var3 | var2;
	}

	public int method8142() {
		int var3 = 0;
		int var4 = 0;

		int var2;
		do {
			var2 = this.method8141();
			var3 |= (var2 & 127) << var4;
			var4 += 7;
		} while(var2 > 127);

		return var3;
	}

	public void method8143(int[] var1) {
		int var3 = this.offset / 8;
		this.offset = 0;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.readInt();
			int var6 = this.readInt();
			int var7 = 0;
			int var8 = -1640531527;

			for (int var9 = 32; var9-- > 0; var6 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var7 + var1[var7 >>> 11 & 3]) {
				var5 += var6 + (var6 << 4 ^ var6 >>> 5) ^ var7 + var1[var7 & 3];
				var7 += var8;
			}

			this.offset -= 8;
			this.writeInt(var5);
			this.writeInt(var6);
		}

	}

	public void method8144(int[] var1) {
		int var3 = this.offset / 8;
		this.offset = 0;

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = this.readInt();
			int var6 = this.readInt();
			int var7 = -957401312;
			int var8 = -1640531527;

			for (int var9 = 32; var9-- > 0; var5 -= (var6 << 4 ^ var6 >>> 5) + var6 ^ var1[var7 & 3] + var7) {
				var6 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var7 + var1[var7 >>> 11 & 3];
				var7 -= var8;
			}

			this.offset -= 8;
			this.writeInt(var5);
			this.writeInt(var6);
		}

	}

	public void encryptXTEA(int[] var1, int var2, int var3) {
		int var5 = this.offset;
		this.offset = var2;
		int var6 = (var3 - var2) / 8;

		for (int var7 = 0; var7 < var6; ++var7) {
			int var8 = this.readInt();
			int var9 = this.readInt();
			int var10 = 0;
			int var11 = -1640531527;

			for (int var12 = 32; var12-- > 0; var9 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var10 >>> 11 & 3] + var10) {
				var8 += var9 + (var9 << 4 ^ var9 >>> 5) ^ var1[var10 & 3] + var10;
				var10 += var11;
			}

			this.offset -= 8;
			this.writeInt(var8);
			this.writeInt(var9);
		}

		this.offset = var5;
	}

	public void method8146(int[] var1, int var2, int var3) {
		int var5 = this.offset;
		this.offset = var2;
		int var6 = (var3 - var2) / 8;

		for (int var7 = 0; var7 < var6; ++var7) {
			int var8 = this.readInt();
			int var9 = this.readInt();
			int var10 = -957401312;
			int var11 = -1640531527;

			for (int var12 = 32; var12-- > 0; var8 -= var9 + (var9 << 4 ^ var9 >>> 5) ^ var1[var10 & 3] + var10) {
				var9 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var10 >>> 11 & 3] + var10;
				var10 -= var11;
			}

			this.offset -= 8;
			this.writeInt(var8);
			this.writeInt(var9);
		}

		this.offset = var5;
	}

	public void encryptRSA(BigInteger var1, BigInteger var2) {
		int var4 = this.offset;
		this.offset = 0;
		byte[] var5 = new byte[var4];
		this.method8333(var5, 0, var4);
		BigInteger var6 = new BigInteger(var5);
		BigInteger var7 = var6.modPow(var1, var2);
		byte[] var8 = var7.toByteArray();
		this.offset = 0;
		this.writeShort(var8.length);
		this.writeBytes(var8, 0, var8.length);
	}

	public int method8233(int var1) {
		int var3 = class241.method4729(this.data, var1, this.offset);
		this.writeInt(var3);
		return var3;
	}

	public boolean method8246() {
		this.offset -= 4;
		int var2 = class241.method4729(this.data, 0, this.offset);
		int var3 = this.readInt();
		return var2 == var3;
	}

	public void method8348(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 + 128);
	}

	public void method8264(int var1) {
		this.data[++this.offset - 1] = (byte)(0 - var1);
	}

	public void method8152(int var1) {
		this.data[++this.offset - 1] = (byte)(128 - var1);
	}

	public int method8153() {
		return this.data[++this.offset - 1] - 128 & 255;
	}

	public int readUnsignedByteNeg() {
		return 0 - this.data[++this.offset - 1] & 255;
	}

	public int readUnsignedByteSub() {
		return 128 - this.data[++this.offset - 1] & 255;
	}

	public byte method8335() {
		return (byte)(this.data[++this.offset - 1] - 128);
	}

	public byte method8187() {
		return (byte)(0 - this.data[++this.offset - 1]);
	}

	public byte method8158() {
		return (byte)(128 - this.data[++this.offset - 1]);
	}

	public void method8159(int var1) {
		this.data[++this.offset - 1] = (byte)var1;
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
	}

	public void method8337(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)(var1 + 128);
	}

	public void method8161(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 + 128);
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
	}

	public int readUnsignedShortLE() {
		this.offset += 2;
		return (this.data[this.offset - 2] & 255) + ((this.data[this.offset - 1] & 255) << 8);
	}

	public int readUnsignedShortAdd() {
		this.offset += 2;
		return ((this.data[this.offset - 2] & 255) << 8) + (this.data[this.offset - 1] - 128 & 255);
	}

	public int method8164() {
		this.offset += 2;
		return (this.data[this.offset - 2] - 128 & 255) + ((this.data[this.offset - 1] & 255) << 8);
	}

	public int method8183() {
		this.offset += 2;
		int var2 = (this.data[this.offset - 1] - 128 & 255) + ((this.data[this.offset - 2] & 255) << 8);
		if (var2 > 32767) {
			var2 -= 65536;
		}

		return var2;
	}

	public int method8166() {
		this.offset += 2;
		int var2 = ((this.data[this.offset - 1] & 255) << 8) + (this.data[this.offset - 2] - 128 & 255);
		if (var2 > 32767) {
			var2 -= 65536;
		}

		return var2;
	}

	public void method8167(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
		this.data[++this.offset - 1] = (byte)var1;
	}

	public int method8148() {
		this.offset += 3;
		return ((this.data[this.offset - 2] & 255) << 8) + ((this.data[this.offset - 1] & 255) << 16) + (this.data[this.offset - 3] & 255);
	}

	public int method8169() {
		this.offset += 3;
		return ((this.data[this.offset - 3] & 255) << 8) + ((this.data[this.offset - 2] & 255) << 16) + (this.data[this.offset - 1] & 255);
	}

	public int method8156() {
		this.offset += 3;
		int var2 = ((this.data[this.offset - 3] & 255) << 16) + ((this.data[this.offset - 1] & 255) << 8) + (this.data[this.offset - 2] & 255);
		if (var2 > 8388607) {
			var2 -= 16777216;
		}

		return var2;
	}

	public void writeIntLE(int var1) {
		this.data[++this.offset - 1] = (byte)var1;
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
		this.data[++this.offset - 1] = (byte)(var1 >> 24);
	}

	public void writeIntLEAlt(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
		this.data[++this.offset - 1] = (byte)var1;
		this.data[++this.offset - 1] = (byte)(var1 >> 24);
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
	}

	public void writeIntAlt(int var1) {
		this.data[++this.offset - 1] = (byte)(var1 >> 16);
		this.data[++this.offset - 1] = (byte)(var1 >> 24);
		this.data[++this.offset - 1] = (byte)var1;
		this.data[++this.offset - 1] = (byte)(var1 >> 8);
	}

	public int readIntLE() {
		this.offset += 4;
		return (this.data[this.offset - 4] & 255) + ((this.data[this.offset - 3] & 255) << 8) + ((this.data[this.offset - 1] & 255) << 24) + ((this.data[this.offset - 2] & 255) << 16);
	}

	public int method8175() {
		this.offset += 4;
		return (this.data[this.offset - 3] & 255) + ((this.data[this.offset - 4] & 255) << 8) + ((this.data[this.offset - 1] & 255) << 16) + ((this.data[this.offset - 2] & 255) << 24);
	}

	public int readIntIME() {
		this.offset += 4;
		return (this.data[this.offset - 2] & 255) + ((this.data[this.offset - 1] & 255) << 8) + ((this.data[this.offset - 4] & 255) << 16) + ((this.data[this.offset - 3] & 255) << 24);
	}

	public void method8195(byte[] var1, int var2, int var3) {
		for (int var5 = var3 + var2 - 1; var5 >= var2; --var5) {
			var1[var5] = (byte)(this.data[++this.offset - 1] - 128);
		}

	}
}
