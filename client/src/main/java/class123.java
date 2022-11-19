import client.Client;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public class class123 {
	boolean field1193;
	boolean[] field1190;
	/** @deprecated */
	String[] field1194;
	Map field1192;
	long field1196;

	class123() {
		this.field1193 = false;
		int var1 = class174.field1564.method6099(19);
		this.field1192 = new HashMap();
		this.field1190 = new boolean[var1];

		int var2;
		for (var2 = 0; var2 < var1; ++var2) {
			class173 var4 = (class173)class173.field1561.method5439((long)var2);
			class173 var3;
			if (var4 != null) {
				var3 = var4;
			} else {
				byte[] var5 = class173.field1560.method6175(19, var2);
				var4 = new class173();
				if (var5 != null) {
					var4.method2738(new class460(var5));
				}

				class173.field1561.method5434(var4, (long)var2);
				var3 = var4;
			}

			this.field1190[var2] = var3.field1562;
		}

		var2 = 0;
		if (class174.field1564.method6276(15)) {
			var2 = class174.field1564.method6099(15);
		}

		this.field1194 = new String[var2];
		this.method2313();
	}

	void method2343(int var1, int var2) {
		this.field1192.put(var1, var2);
		if (this.field1190[var1]) {
			this.field1193 = true;
		}

	}

	int method2305(int var1) {
		Object var3 = this.field1192.get(var1);
		return var3 instanceof Integer ? (Integer)var3 : -1;
	}

	void method2306(int var1, String var2) {
		this.field1192.put(var1, var2);
	}

	String method2307(int var1) {
		Object var3 = this.field1192.get(var1);
		return var3 instanceof String ? (String)var3 : "";
	}

	/** @deprecated */
	@Deprecated
	void method2308(int var1, String var2) {
		this.field1194[var1] = var2;
	}

	/** @deprecated */
	@Deprecated
	String method2304(int var1) {
		return this.field1194[var1];
	}

	void method2310() {
		int var2;
		for (var2 = 0; var2 < this.field1190.length; ++var2) {
			if (!this.field1190[var2]) {
				this.field1192.remove(var2);
			}
		}

		for (var2 = 0; var2 < this.field1194.length; ++var2) {
			this.field1194[var2] = null;
		}

	}

	class464 method2311(boolean var1) {
		return class161.method2668("2", class368.field4353.field3820, var1);
	}

	void method2312() {
		class464 var2 = this.method2311(true);

		try {
			int var3 = 3;
			int var4 = 0;
			Iterator var5 = this.field1192.entrySet().iterator();

			while (var5.hasNext()) {
				Entry var6 = (Entry)var5.next();
				int var7 = (Integer)var6.getKey();
				if (this.field1190[var7]) {
					Object var8 = var6.getValue();
					var3 += 3;
					if (var8 instanceof Integer) {
						var3 += 4;
					} else if (var8 instanceof String) {
						var3 += class460.method1887((String)var8);
					}

					++var4;
				}
			}

			class460 var24 = new class460(var3);
			var24.method8104(2);
			var24.method8181(var4);
			Iterator var25 = this.field1192.entrySet().iterator();

			while (var25.hasNext()) {
				Entry var13 = (Entry)var25.next();
				int var14 = (Integer)var13.getKey();
				if (this.field1190[var14]) {
					var24.method8181(var14);
					Object var9 = var13.getValue();
					class451 var10 = class451.method7973(var9.getClass());
					var24.method8104(var10.field4846);
					class451.method7981(var9, var24);
				}
			}

			var2.method8370(var24.field4881, 0, var24.field4878);
		} catch (Exception var22) {
		} finally {
			try {
				var2.method8374();
			} catch (Exception var21) {
			}

		}

		this.field1193 = false;
		this.field1196 = class272.method2046();
	}

	void method2313() {
		class464 var2 = this.method2311(false);

		label224: {
			try {
				byte[] var3 = new byte[(int)var2.method8373()];

				int var5;
				for (int var4 = 0; var4 < var3.length; var4 += var5) {
					var5 = var2.method8369(var3, var4, var3.length - var4);
					if (var5 == -1) {
						throw new EOFException();
					}
				}

				class460 var15 = new class460(var3);
				if (var15.field4881.length - var15.field4878 < 1) {
					return;
				}

				int var16 = var15.method8141();
				if (var16 >= 0 && var16 <= 2) {
					int var8;
					int var9;
					int var10;
					int var17;
					if (var16 >= 2) {
						var17 = var15.method8122();
						var8 = 0;

						while (true) {
							if (var8 >= var17) {
								break label224;
							}

							var9 = var15.method8122();
							var10 = var15.method8141();
							class451 var11 = (class451)class217.method4362(class451.method7984(), var10);
							Object var12 = var11.method7974(var15);
							if (this.field1190[var9]) {
								this.field1192.put(var9, var12);
							}

							++var8;
						}
					} else {
						var17 = var15.method8122();

						for (var8 = 0; var8 < var17; ++var8) {
							var9 = var15.method8122();
							var10 = var15.method8126();
							if (this.field1190[var9]) {
								this.field1192.put(var9, var10);
							}
						}

						var8 = var15.method8122();
						var9 = 0;

						while (true) {
							if (var9 >= var8) {
								break label224;
							}

							var15.method8122();
							var15.method8131();
							++var9;
						}
					}
				}
			} catch (Exception var26) {
				break label224;
			} finally {
				try {
					var2.method8374();
				} catch (Exception var25) {
				}

			}

			return;
		}

		this.field1193 = false;
	}

	void method2314() {
		if (this.field1193 && this.field1196 < class272.method2046() - 60000L) {
			this.method2312();
		}

	}

	boolean method2316() {
		return this.field1193;
	}

	static final void method2326(int var0, int var1, int var2, int var3) {
		Client.field1661 = 0;
		boolean var5 = false;
		int var6 = -1;
		int var7 = -1;
		int var8 = class102.field1012;
		int[] var9 = class102.field1013;

		int var10;
		for (var10 = 0; var10 < Client.field1691 + var8; ++var10) {
			Object var11;
			if (var10 < var8) {
				var11 = Client.field1763[var9[var10]];
				if (var9[var10] == Client.field1775) {
					var5 = true;
					var6 = var10;
					continue;
				}

				if (var11 == class291.field3364) {
					var7 = var10;
					continue;
				}
			} else {
				var11 = Client.field1902[Client.field1692[var10 - var8]];
			}

			class142.method2486((class90)var11, var10, var0, var1, var2, var3);
		}

		if (Client.field1739 && var7 != -1) {
			class142.method2486(class291.field3364, var7, var0, var1, var2, var3);
		}

		if (var5) {
			class142.method2486(Client.field1763[Client.field1775], var6, var0, var1, var2, var3);
		}

		for (var10 = 0; var10 < Client.field1661; ++var10) {
			int var20 = Client.field1736[var10];
			int var12 = Client.field1908[var10];
			int var13 = Client.field1659[var10];
			int var14 = Client.field1721[var10];
			boolean var15 = true;

			while (var15) {
				var15 = false;

				for (int var16 = 0; var16 < var10; ++var16) {
					if (var12 + 2 > Client.field1908[var16] - Client.field1721[var16] && var12 - var14 < Client.field1908[var16] + 2 && var20 - var13 < Client.field1659[var16] + Client.field1736[var16] && var13 + var20 > Client.field1736[var16] - Client.field1659[var16] && Client.field1908[var16] - Client.field1721[var16] < var12) {
						var12 = Client.field1908[var16] - Client.field1721[var16];
						var15 = true;
					}
				}
			}

			Client.field1809 = Client.field1736[var10];
			Client.field1747 = Client.field1908[var10] = var12;
			String var21 = Client.field1743[var10];
			if (0 == Client.field1753) {
				int var17 = 16776960;
				if (Client.field1740[var10] < 6) {
					var17 = Client.field1870[Client.field1740[var10]];
				}

				if (Client.field1740[var10] == 6) {
					var17 = Client.field1745 % 20 < 10 ? 16711680 : 16776960;
				}

				if (7 == Client.field1740[var10]) {
					var17 = Client.field1745 % 20 < 10 ? 255 : '\uffff';
				}

				if (8 == Client.field1740[var10]) {
					var17 = Client.field1745 % 20 < 10 ? '\ub000' : 8454016;
				}

				int var18;
				if (9 == Client.field1740[var10]) {
					var18 = 150 - Client.field1649[var10];
					if (var18 < 50) {
						var17 = var18 * 1280 + 16711680;
					} else if (var18 < 100) {
						var17 = 16776960 - 327680 * (var18 - 50);
					} else if (var18 < 150) {
						var17 = 65280 + 5 * (var18 - 100);
					}
				}

				if (Client.field1740[var10] == 10) {
					var18 = 150 - Client.field1649[var10];
					if (var18 < 50) {
						var17 = 16711680 + var18 * 5;
					} else if (var18 < 100) {
						var17 = 16711935 - (var18 - 50) * 327680;
					} else if (var18 < 150) {
						var17 = 255 + 327680 * (var18 - 100) - 5 * (var18 - 100);
					}
				}

				if (11 == Client.field1740[var10]) {
					var18 = 150 - Client.field1649[var10];
					if (var18 < 50) {
						var17 = 16777215 - var18 * 327685;
					} else if (var18 < 100) {
						var17 = 327685 * (var18 - 50) + 65280;
					} else if (var18 < 150) {
						var17 = 16777215 - (var18 - 100) * 327680;
					}
				}

				if (0 == Client.field1741[var10]) {
					class114.field1127.method6955(var21, var0 + Client.field1809, var1 + Client.field1747, var17, 0);
				}

				if (Client.field1741[var10] == 1) {
					class114.field1127.method6872(var21, var0 + Client.field1809, Client.field1747 + var1, var17, 0, Client.field1745);
				}

				if (2 == Client.field1741[var10]) {
					class114.field1127.method6873(var21, Client.field1809 + var0, Client.field1747 + var1, var17, 0, Client.field1745);
				}

				if (3 == Client.field1741[var10]) {
					class114.field1127.method6874(var21, Client.field1809 + var0, var1 + Client.field1747, var17, 0, Client.field1745, 150 - Client.field1649[var10]);
				}

				if (4 == Client.field1741[var10]) {
					var18 = (150 - Client.field1649[var10]) * (class114.field1127.method6894(var21) + 100) / 150;
					class481.method8724(var0 + Client.field1809 - 50, var1, Client.field1809 + var0 + 50, var3 + var1);
					class114.field1127.method6875(var21, Client.field1809 + var0 + 50 - var18, var1 + Client.field1747, var17, 0);
					class481.method8653(var0, var1, var2 + var0, var3 + var1);
				}

				if (Client.field1741[var10] == 5) {
					var18 = 150 - Client.field1649[var10];
					int var19 = 0;
					if (var18 < 25) {
						var19 = var18 - 25;
					} else if (var18 > 125) {
						var19 = var18 - 125;
					}

					class481.method8724(var0, var1 + Client.field1747 - class114.field1127.field4435 - 1, var0 + var2, 5 + var1 + Client.field1747);
					class114.field1127.method6955(var21, var0 + Client.field1809, var19 + var1 + Client.field1747, var17, 0);
					class481.method8653(var0, var1, var2 + var0, var3 + var1);
				}
			} else {
				class114.field1127.method6955(var21, Client.field1809 + var0, Client.field1747 + var1, 16776960, 0);
			}
		}

	}
}
