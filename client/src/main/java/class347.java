public class class347 {
	public static String[] field4261;
	static class181 js5Socket;
	byte field4260;
	public int field4253;
	public int field4254;
	public int field4255;
	public int field4256;
	public int field4258;

	public class347() {
	}

	public class347(Buffer var1, boolean var2) {
		this.field4260 = var1.method8287();
		this.field4254 = var1.readUnsignedShort();
		this.field4253 = var1.readInt();
		this.field4256 = var1.readInt();
		this.field4255 = var1.readInt();
		this.field4258 = var1.readInt();
		if (var2) {
			int var4 = 0;
			boolean var5 = false;

			while (true) {
				int var6 = var1.method8141();
				if (var6 == 255) {
					Integer var3 = var5 ? var4 : null;
					this.method6418(var3);
					break;
				}

				if (var6 != 0) {
					throw new IllegalStateException("");
				}

				while (true) {
					int var7 = var1.method8141();
					if (var7 == 255) {
						break;
					}

					--var1.offset;
					if (var1.readUnsignedShort() != 0) {
						throw new IllegalStateException("");
					}

					if (var5) {
						throw new IllegalStateException("");
					}

					var4 = var1.readInt();
					var5 = true;
				}
			}
		}

	}

	void method6418(Integer var1) {
	}

	public int method6407() {
		return this.field4260 & 7;
	}

	public int method6409() {
		return 8 == (this.field4260 & 8) ? 1 : 0;
	}

	void method6417(int var1) {
		this.field4260 &= -8;
		this.field4260 = (byte)(this.field4260 | var1 & 7);
	}

	void method6411(int var1) {
		this.field4260 &= -9;
		if (var1 == 1) {
			this.field4260 = (byte)(this.field4260 | 8);
		}

	}

	public static boolean method6422(char var0) {
		return var0 >= '0' && var0 <= '9';
	}
}
