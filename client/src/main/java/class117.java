import client.Client;

public class class117 extends class393 {
	final boolean field1139;

	public class117(boolean var1) {
		this.field1139 = var1;
	}

	int method2251(class396 var1, class396 var2) {
		if (var1.field4491 == Client.field1868 && Client.field1868 == var2.field4491) {
			return this.field1139 ? var1.method7232().method8457(var2.method7232()) : var2.method7232().method8457(var1.method7232());
		} else {
			return this.method7162(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.method2251((class396)var1, (class396)var2);
	}

	static final void method2256(class93 var0, int var1, int var2, int var3) {
		if (class291.field3364 != var0) {
			if (Client.field1695 < 400) {
				String var5;
				int var8;
				if (0 == var0.field912) {
					String var6 = var0.field897[0] + var0.field910 + var0.field897[1];
					var8 = var0.field905;
					int var9 = class291.field3364.field905;
					int var10 = var9 - var8;
					String var7;
					if (var10 < -9) {
						var7 = class96.method4510(16711680);
					} else if (var10 < -6) {
						var7 = class96.method4510(16723968);
					} else if (var10 < -3) {
						var7 = class96.method4510(16740352);
					} else if (var10 < 0) {
						var7 = class96.method4510(16756736);
					} else if (var10 > 9) {
						var7 = class96.method4510(65280);
					} else if (var10 > 6) {
						var7 = class96.method4510(4259584);
					} else if (var10 > 3) {
						var7 = class96.method4510(8453888);
					} else if (var10 > 0) {
						var7 = class96.method4510(12648192);
					} else {
						var7 = class96.method4510(16776960);
					}

					var5 = var6 + var7 + " " + class96.field964 + class338.field4060 + var0.field905 + class96.field958 + var0.field897[2];
				} else {
					var5 = var0.field897[0] + var0.field910 + var0.field897[1] + " " + class96.field964 + class338.field4061 + var0.field912 + class96.field958 + var0.field897[2];
				}

				int var11;
				if (Client.field1802 == 1) {
					Client.method351(class338.field3898, Client.field1803 + " " + class96.field963 + " " + class96.method4510(16777215) + var5, 14, var1, var2, var3);
				} else if (Client.field1804) {
					if ((class120.field1161 & 8) == 8) {
						Client.method351(Client.field1653, Client.field1754 + " " + class96.field963 + " " + class96.method4510(16777215) + var5, 15, var1, var2, var3);
					}
				} else {
					for (var11 = 7; var11 >= 0; --var11) {
						if (null != Client.field1772[var11]) {
							short var12 = 0;
							if (Client.field1772[var11].equalsIgnoreCase(class338.field4056)) {
								if (Client.field1812 == class80.field703) {
									continue;
								}

								if (Client.field1812 == class80.field698 || Client.field1812 == class80.field705 && var0.field905 > class291.field3364.field905) {
									var12 = 2000;
								}

								if (0 != class291.field3364.field921 && var0.field921 != 0) {
									if (var0.field921 == class291.field3364.field921) {
										var12 = 2000;
									} else {
										var12 = 0;
									}
								} else if (class80.field701 == Client.field1812 && var0.method1951()) {
									var12 = 2000;
								}
							} else if (Client.field1755[var11]) {
								var12 = 2000;
							}

							boolean var13 = false;
							var8 = Client.field1771[var11] + var12;
							Client.method351(Client.field1772[var11], class96.method4510(16777215) + var5, var8, var1, var2, var3);
						}
					}
				}

				for (var11 = 0; var11 < Client.field1695; ++var11) {
					if (Client.field1788[var11] == 23) {
						Client.field1923[var11] = class96.method4510(16777215) + var5;
						break;
					}
				}

			}
		}
	}
}
