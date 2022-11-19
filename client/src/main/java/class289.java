import client.Client;

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
		if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERTYPE) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].method6409();
			return 1;
		} else if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERITEM) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].field4254;
			return 1;
		} else if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERPRICE) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].field4253;
			return 1;
		} else if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERCOUNT) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].field4256;
			return 1;
		} else if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].field4255;
			return 1;
		} else if (var0 == CS2Opcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1924[var4].field4258;
			return 1;
		} else {
			int var13;
			if (var0 == CS2Opcodes.STOCKMARKET_ISOFFEREMPTY) {
				var4 = class57.field404[--class387.field4452];
				var13 = Client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == CS2Opcodes.STOCKMARKET_ISOFFERSTABLE) {
				var4 = class57.field404[--class387.field4452];
				var13 = Client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == CS2Opcodes.STOCKMARKET_ISOFFERFINISHED) {
				var4 = class57.field404[--class387.field4452];
				var13 = Client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == CS2Opcodes.STOCKMARKET_ISOFFERADDING) {
				var4 = class57.field404[--class387.field4452];
				var13 = Client.field1924[var4].method6407();
				class57.field404[++class387.field4452 - 1] = var13 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var14;
				if (var0 == CS2Opcodes.TRADINGPOST_SORTBY_NAME) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (class242.field2835 != null) {
						class242.field2835.method6309(class337.field3888, var14);
					}

					return 1;
				} else if (var0 == CS2Opcodes.TRADINGPOST_SORTBY_PRICE) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (class242.field2835 != null) {
						class242.field2835.method6309(class337.field3887, var14);
					}

					return 1;
				} else if (var0 == CS2Opcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					class387.field4452 -= 2;
					var14 = 1 == class57.field404[class387.field4452];
					boolean var5 = class57.field404[1 + class387.field4452] == 1;
					if (class242.field2835 != null) {
						Client.field1925.field614 = var5;
						class242.field2835.method6309(Client.field1925, var14);
					}

					return 1;
				} else if (var0 == CS2Opcodes.TRADINGPOST_SORTBY_AGE) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (null != class242.field2835) {
						class242.field2835.method6309(class337.field3884, var14);
					}

					return 1;
				} else if (var0 == CS2Opcodes.TRADINGPOST_SORTBY_COUNT) {
					var14 = class57.field404[--class387.field4452] == 1;
					if (null != class242.field2835) {
						class242.field2835.method6309(class337.field3885, var14);
					}

					return 1;
				} else if (var0 == CS2Opcodes.TRADINGPOST_GETTOTALOFFERS) {
					class57.field404[++class387.field4452 - 1] = null == class242.field2835 ? 0 : class242.field2835.field3886.size();
					return 1;
				} else {
					class328 var12;
					if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERWORLD) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3806;
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERNAME) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field405[++class126.field1220 - 1] = var12.method6244();
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field405[++class126.field1220 - 1] = var12.method6245();
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERAGE) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						long var6 = class272.method2046() - class100.field987 - var12.field3805;
						int var8 = (int)(var6 / 3600000L);
						int var9 = (int)((var6 - (long)(var8 * 3600000)) / 60000L);
						int var10 = (int)((var6 - (long)(var8 * 3600000) - (long)(var9 * 60000)) / 1000L);
						String var11 = var8 + ":" + var9 / 10 + var9 % 10 + ":" + var10 / 10 + var10 % 10;
						class57.field405[++class126.field1220 - 1] = var11;
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERCOUNT) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3807.field4256;
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERPRICE) {
						var4 = class57.field404[--class387.field4452];
						var12 = (class328)class242.field2835.field3886.get(var4);
						class57.field404[++class387.field4452 - 1] = var12.field3807.field4253;
						return 1;
					} else if (var0 == CS2Opcodes.TRADINGPOST_GETOFFERITEM) {
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
