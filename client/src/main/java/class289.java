import java.nio.ByteBuffer;

public class class289 extends class294 {
	public static long field3358;
	static class473[] field3357;
	ByteBuffer field3360;

	class289() {
	}

	byte[] method5516() {
		byte[] var2 = new byte[this.field3360.capacity()];
		this.field3360.position(0);
		this.field3360.get(var2);
		return var2;
	}

	void method5509(byte[] var1) {
		this.field3360 = ByteBuffer.allocateDirect(var1.length);
		this.field3360.position(0);
		this.field3360.put(var1);
	}

	static int method5464(int var0, class78 var1, boolean var2) {
		int var4;
		if (3903 == var0) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].method6409();
			return 1;
		} else if (3904 == var0) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].field4254;
			return 1;
		} else if (var0 == 3905) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].field4253;
			return 1;
		} else if (var0 == 3906) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].field4256;
			return 1;
		} else if (var0 == 3907) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].field4255;
			return 1;
		} else if (3908 == var0) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = client.field1924[var4].field4258;
			return 1;
		} else {
			int var13;
			if (3910 == var0) {
				var4 = class57.field404[--class387.field4452];
				var13 = client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == 3911) {
				var4 = class57.field404[--class387.field4452];
				var13 = client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = 2 == var13 ? 1 : 0;
				return 1;
			} else if (3912 == var0) {
				var4 = class57.field404[--class387.field4452];
				var13 = client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = 5 == var13 ? 1 : 0;
				return 1;
			} else if (var0 == 3913) {
				var4 = class57.field404[--class387.field4452];
				var13 = client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var14;
				if (var0 == 3914) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (class242.field2835 != null) {
						class242.field2835.method6309(class337.field3888, var14);
					}

					return 1;
				} else if (var0 == 3915) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (class242.field2835 != null) {
						class242.field2835.method6309(class337.field3887, var14);
					}

					return 1;
				} else if (3916 == var0) {
					class387.field4452 -= 2;
					var14 = 1 == class57.field404[class387.field4452];
					boolean var5 = class57.field404[1 + class387.field4452] == 1;
					if (class242.field2835 != null) {
						client.field1925.field614 = var5;
						class242.field2835.method6309(client.field1925, var14);
					}

					return 1;
				} else if (3917 == var0) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (null != class242.field2835) {
						class242.field2835.method6309(class337.field3884, var14);
					}

					return 1;
				} else if (var0 == 3918) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (null != class242.field2835) {
						class242.field2835.method6309(class337.field3885, var14);
					}

					return 1;
				} else if (3919 == var0) {
					class57.field404[++class387.field4452 - 1] = null == class242.field2835 ? 0 : class242.field2835.field3886.size();
					return 1;
				} else {
					class328 var12;
					if (3920 == var0) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3806;
						return 1;
					} else if (3921 == var0) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field405[++class126.field1220 - 1] = var12.method6244();
						return 1;
					} else if (var0 == 3922) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field405[++class126.field1220 - 1] = var12.method6245();
						return 1;
					} else if (3923 == var0) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						long var6 = class272.method2046() - class100.field987 - var12.field3805;
						int var8 = (int)(var6 / 3600000L);
						int var9 = (int)((var6 - (long)(3600000 * var8)) / 60000L);
						int var10 = (int)((var6 - (long)(3600000 * var8) - (long)(60000 * var9)) / 1000L);
						String var11 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var10 / 10 + var10 % 10;
						class57.field405[++class126.field1220 - 1] = var11;
						return 1;
					} else if (var0 == 3924) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3807.field4256;
						return 1;
					} else if (var0 == 3925) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3807.field4253;
						return 1;
					} else if (3926 == var0) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3807.field4254;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}
