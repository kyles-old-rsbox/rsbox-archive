public class class192 extends class437 {
	public static class319 field2034;
	static class284 field2028;
	public char field2030;
	public char field2037;
	public int field2029;
	public int field2033;
	public int[] field2035;
	public int[] field2036;
	public String field2031;
	public String[] field2027;

	static {
		field2028 = new class284(64);
	}

	class192() {
		this.field2031 = class338.field3899;
		this.field2033 = 0;
	}

	void method3538(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method3539(var1, var3);
		}
	}

	void method3539(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field2037 = (char)var1.readUnsignedByte();
		} else if (var2 == 2) {
			this.field2030 = (char)var1.readUnsignedByte();
		} else if (var2 == 3) {
			this.field2031 = var1.readString();
		} else if (var2 == 4) {
			this.field2029 = var1.readInt();
		} else {
			int var4;
			if (var2 == 5) {
				this.field2033 = var1.readUnsignedShort();
				this.field2036 = new int[this.field2033];
				this.field2027 = new String[this.field2033];

				for (var4 = 0; var4 < this.field2033; ++var4) {
					this.field2036[var4] = var1.readInt();
					this.field2027[var4] = var1.readString();
				}
			} else if (var2 == 6) {
				this.field2033 = var1.readUnsignedShort();
				this.field2036 = new int[this.field2033];
				this.field2035 = new int[this.field2033];

				for (var4 = 0; var4 < this.field2033; ++var4) {
					this.field2036[var4] = var1.readInt();
					this.field2035[var4] = var1.readInt();
				}
			}
		}

	}

	public int method3548() {
		return this.field2033;
	}
}
