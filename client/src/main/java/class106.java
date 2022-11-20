import java.io.File;
import java.io.RandomAccessFile;

public class class106 {
	static int field1066;
	static String field1050;
	boolean field1048;
	boolean field1049;
	boolean field1051;
	boolean field1052;
	class118 field1057;
	class118 field1058;
	class119[] field1061;
	float field1053;
	float field1054;
	float field1062;
	float field1063;
	float[] field1055;
	float[] field1056;
	float[] field1059;
	int field1047;
	int field1060;
	int field1064;

	public static File method2066(String var0) {
		if (!class170.field1543) {
			throw new RuntimeException("");
		} else {
			File var2 = (File)class170.field1538.get(var0);
			if (var2 != null) {
				return var2;
			} else {
				File var3 = new File(class170.field1539, var0);
				RandomAccessFile var4 = null;

				try {
					File var5 = new File(var3.getParent());
					if (!var5.exists()) {
						throw new RuntimeException("");
					} else {
						var4 = new RandomAccessFile(var3, "rw");
						int var6 = var4.read();
						var4.seek(0L);
						var4.write(var6);
						var4.seek(0L);
						var4.close();
						class170.field1538.put(var0, var3);
						return var3;
					}
				} catch (Exception var9) {
					try {
						if (null != var4) {
							var4.close();
							var4 = null;
						}
					} catch (Exception var8) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	class106() {
		this.field1055 = new float[4];
		this.field1056 = new float[4];
		this.field1051 = true;
		this.field1047 = 0;
	}

	int method2049(Buffer var1, int var2) {
		int var4 = var1.readUnsignedShort();
		class322.method6186(var1.method8141());
		this.field1058 = class77.method1579(var1.method8141());
		this.field1057 = class77.method1579(var1.method8141());
		this.field1049 = var1.method8141() != 0;
		this.field1061 = new class119[var4];
		class119 var5 = null;

		int var6;
		for (var6 = 0; var6 < var4; ++var6) {
			class119 var7 = new class119();
			var7.method2268(var1, var2);
			this.field1061[var6] = var7;
			if (null != var5) {
				var5.field1156 = var7;
			}

			var5 = var7;
		}

		this.field1060 = this.field1061[0].field1153;
		this.field1064 = this.field1061[this.method2055() - 1].field1153;
		this.field1059 = new float[this.method2052() + 1];

		for (var6 = this.method2072(); var6 <= this.method2051(); ++var6) {
			this.field1059[var6 - this.method2072()] = class144.method2499(this, (float)var6);
		}

		this.field1061 = null;
		this.field1062 = class144.method2499(this, (float)(this.method2072() - 1));
		this.field1063 = class144.method2499(this, (float)(this.method2051() + 1));
		return var4;
	}

	public float method2060(int var1) {
		if (var1 < this.method2072()) {
			return this.field1062;
		} else {
			return var1 > this.method2051() ? this.field1063 : this.field1059[var1 - this.method2072()];
		}
	}

	int method2072() {
		return this.field1060;
	}

	int method2051() {
		return this.field1064;
	}

	int method2052() {
		return this.method2051() - this.method2072();
	}

	int method2053(float var1) {
		if (this.field1047 >= 0 && (float)this.field1061[this.field1047].field1153 <= var1 && (null == this.field1061[this.field1047].field1156 || (float)this.field1061[this.field1047].field1156.field1153 > var1)) {
			return this.field1047;
		} else if (var1 >= (float)this.method2072() && var1 <= (float)this.method2051()) {
			int var3 = this.method2055();
			int var4 = this.field1047;
			if (var3 > 0) {
				int var5 = 0;
				int var6 = var3 - 1;

				do {
					int var7 = var6 + var5 >> 1;
					if (var1 < (float)this.field1061[var7].field1153) {
						if (var1 > (float)this.field1061[var7 - 1].field1153) {
							var4 = var7 - 1;
							break;
						}

						var6 = var7 - 1;
					} else {
						if (var1 <= (float)this.field1061[var7].field1153) {
							var4 = var7;
							break;
						}

						if (var1 < (float)this.field1061[var7 + 1].field1153) {
							var4 = var7;
							break;
						}

						var5 = var7 + 1;
					}
				} while(var5 <= var6);
			}

			if (var4 != this.field1047) {
				this.field1047 = var4;
				this.field1051 = true;
			}

			return this.field1047;
		} else {
			return -1;
		}
	}

	class119 method2054(float var1) {
		int var3 = this.method2053(var1);
		return var3 >= 0 && var3 < this.field1061.length ? this.field1061[var3] : null;
	}

	int method2055() {
		return this.field1061 == null ? 0 : this.field1061.length;
	}
}
