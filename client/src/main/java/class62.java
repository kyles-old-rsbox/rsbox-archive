import io.rsbox.client.ClientLauncher;

import java.math.BigInteger;

public class class62 {
	static final BigInteger field493;
	static final BigInteger field494;

	static {
		field493 = new BigInteger("10001", 16);
		field494 = new BigInteger(ClientLauncher.INSTANCE.getRSA_MODULUS(), 16);
	}

	class62() throws Throwable {
		throw new Error();
	}

	static void method1339(class453 var0, int var1) {
		boolean var3 = var0.method8014(1) == 1;
		if (var3) {
			class102.field1020[++class102.field1007 - 1] = var1;
		}

		int var4 = var0.method8014(2);
		class93 var5 = client.field1763[var1];
		if (var4 == 0) {
			if (var3) {
				var5.field919 = false;
			} else if (var1 == client.field1764) {
				throw new RuntimeException();
			} else {
				class102.field1016[var1] = (class36.field241 + var5.field861[0] >> 13 << 14) + (var5.field914 << 28) + (class169.field1536 + var5.field873[0] >> 13);
				if (var5.field868 != -1) {
					class102.field1014[var1] = var5.field868;
				} else {
					class102.field1014[var1] = var5.field860;
				}

				class102.field1018[var1] = var5.field835;
				client.field1763[var1] = null;
				if (var0.method8014(1) != 0) {
					class399.method7221(var0, var1);
				}

			}
		} else {
			int var6;
			int var7;
			int var8;
			if (var4 == 1) {
				var6 = var0.method8014(3);
				var7 = var5.field861[0];
				var8 = var5.field873[0];
				if (var6 == 0) {
					--var7;
					--var8;
				} else if (var6 == 1) {
					--var8;
				} else if (var6 == 2) {
					++var7;
					--var8;
				} else if (var6 == 3) {
					--var7;
				} else if (var6 == 4) {
					++var7;
				} else if (var6 == 5) {
					--var7;
					++var8;
				} else if (var6 == 6) {
					++var8;
				} else if (var6 == 7) {
					++var7;
					++var8;
				}

				if (var1 != client.field1764 || var5.field827 >= 1536 && var5.field802 >= 1536 && var5.field827 < 11776 && var5.field802 < 11776) {
					if (var3) {
						var5.field919 = true;
						var5.field920 = var7;
						var5.field892 = var8;
					} else {
						var5.field919 = false;
						var5.method1938(var7, var8, class102.field1010[var1]);
					}
				} else {
					var5.method1919(var7, var8);
					var5.field919 = false;
				}

			} else if (var4 == 2) {
				var6 = var0.method8014(4);
				var7 = var5.field861[0];
				var8 = var5.field873[0];
				if (var6 == 0) {
					var7 -= 2;
					var8 -= 2;
				} else if (var6 == 1) {
					--var7;
					var8 -= 2;
				} else if (var6 == 2) {
					var8 -= 2;
				} else if (var6 == 3) {
					++var7;
					var8 -= 2;
				} else if (var6 == 4) {
					var7 += 2;
					var8 -= 2;
				} else if (var6 == 5) {
					var7 -= 2;
					--var8;
				} else if (var6 == 6) {
					var7 += 2;
					--var8;
				} else if (var6 == 7) {
					var7 -= 2;
				} else if (var6 == 8) {
					var7 += 2;
				} else if (var6 == 9) {
					var7 -= 2;
					++var8;
				} else if (var6 == 10) {
					var7 += 2;
					++var8;
				} else if (var6 == 11) {
					var7 -= 2;
					var8 += 2;
				} else if (var6 == 12) {
					--var7;
					var8 += 2;
				} else if (var6 == 13) {
					var8 += 2;
				} else if (var6 == 14) {
					++var7;
					var8 += 2;
				} else if (var6 == 15) {
					var7 += 2;
					var8 += 2;
				}

				if (client.field1764 == var1 && (var5.field827 < 1536 || var5.field802 < 1536 || var5.field827 >= 11776 || var5.field802 >= 11776)) {
					var5.method1919(var7, var8);
					var5.field919 = false;
				} else if (var3) {
					var5.field919 = true;
					var5.field920 = var7;
					var5.field892 = var8;
				} else {
					var5.field919 = false;
					var5.method1938(var7, var8, class102.field1010[var1]);
				}

			} else {
				var6 = var0.method8014(1);
				int var9;
				int var10;
				int var11;
				int var12;
				if (var6 == 0) {
					var7 = var0.method8014(12);
					var8 = var7 >> 10;
					var9 = var7 >> 5 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var7 & 31;
					if (var10 > 15) {
						var10 -= 32;
					}

					var11 = var5.field861[0] + var9;
					var12 = var5.field873[0] + var10;
					if (client.field1764 != var1 || var5.field827 >= 1536 && var5.field802 >= 1536 && var5.field827 < 11776 && var5.field802 < 11776) {
						if (var3) {
							var5.field919 = true;
							var5.field920 = var11;
							var5.field892 = var12;
						} else {
							var5.field919 = false;
							var5.method1938(var11, var12, class102.field1010[var1]);
						}
					} else {
						var5.method1919(var11, var12);
						var5.field919 = false;
					}

					var5.field914 = (byte)(var5.field914 + var8 & 3);
					if (var1 == client.field1764) {
						class55.field396 = var5.field914;
					}

				} else {
					var7 = var0.method8014(30);
					var8 = var7 >> 28;
					var9 = var7 >> 14 & 16383;
					var10 = var7 & 16383;
					var11 = (class36.field241 + var5.field861[0] + var9 & 16383) - class36.field241;
					var12 = (var5.field873[0] + class169.field1536 + var10 & 16383) - class169.field1536;
					if (var1 != client.field1764 || var5.field827 >= 1536 && var5.field802 >= 1536 && var5.field827 < 11776 && var5.field802 < 11776) {
						if (var3) {
							var5.field919 = true;
							var5.field920 = var11;
							var5.field892 = var12;
						} else {
							var5.field919 = false;
							var5.method1938(var11, var12, class102.field1010[var1]);
						}
					} else {
						var5.method1919(var11, var12);
						var5.field919 = false;
					}

					var5.field914 = (byte)(var8 + var5.field914 & 3);
					if (var1 == client.field1764) {
						class55.field396 = var5.field914;
					}

				}
			}
		}
	}
}
