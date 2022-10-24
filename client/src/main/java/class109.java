import java.net.URL;

public class class109 {
	static int field1086;
	final URL field1087;
	volatile boolean field1084;
	volatile byte[] field1083;

	class109(URL var1) {
		this.field1087 = var1;
	}

	public boolean method2102() {
		return this.field1084;
	}

	public byte[] method2115() {
		return this.field1083;
	}

	public String method2103() {
		return this.field1087.toString();
	}

	static void method2105(class376 var0, class376 var1, class376 var2) {
		class75.field618 = (class31.field193 - 765) / 2;
		class75.field627 = 202 + class75.field618;
		class11.field47 = 180 + class75.field627;
		if (class75.field643) {
			client.method2904(var0, var1);
		} else {
			class323.field3774.method8483(class75.field618, 0);
			class91.field882.method8483(class75.field618 + 382, 0);
			class84.field745.method8755(class75.field618 + 382 - class84.field745.field5017 / 2, 18);
			int var5;
			if (0 == client.field1766 || client.field1766 == 5) {
				byte var4 = 20;
				var0.method6955(class338.field4114, 180 + class75.field627, 245 - var4, 16777215, -1);
				var5 = 253 - var4;
				class481.method8664(class75.field627 + 180 - 152, var5, 304, 34, 9179409);
				class481.method8664(180 + class75.field627 - 151, var5 + 1, 302, 32, 0);
				class481.method8660(class75.field627 + 180 - 150, 2 + var5, class75.field622 * 3, 30, 9179409);
				class481.method8660(180 + class75.field627 - 150 + class75.field622 * 3, var5 + 2, 300 - class75.field622 * 3, 30, 0);
				var0.method6955(class75.field623, class75.field627 + 180, 276 - var4, 16777215, -1);
			}

			String var6;
			String var7;
			String var8;
			short var24;
			int var25;
			short var26;
			if (client.field1766 == 20) {
				class351.field4278.method8755(class75.field627 + 180 - class351.field4278.field5017 / 2, 271 - class351.field4278.field5019 / 2);
				var24 = 201;
				var0.method6955(class75.field624, class75.field627 + 180, var24, 16776960, 0);
				var25 = var24 + 15;
				var0.method6955(class75.field630, 180 + class75.field627, var25, 16776960, 0);
				var25 += 15;
				var0.method6955(class75.field631, class75.field627 + 180, var25, 16776960, 0);
				var25 += 15;
				var25 += 7;
				if (class75.field619 != 4 && class75.field619 != 10) {
					var0.method6875(class338.field4142, 180 + class75.field627 - 110, var25, 16777215, 0);
					var26 = 200;
					var6 = class413.field4575.method1706() ? class359.method5222(class75.field633) : class75.field633;

					for (var7 = var6; var0.method6894(var7) > var26; var7 = var7.substring(0, var7.length() - 1)) {
					}

					var0.method6875(class384.method6864(var7), 180 + class75.field627 - 70, var25, 16777215, 0);
					var25 += 15;

					for (var8 = class359.method5222(class75.field650); var0.method6894(var8) > var26; var8 = var8.substring(1)) {
					}

					var0.method6875(class338.field4143 + var8, 180 + class75.field627 - 108, var25, 16777215, 0);
					var25 += 15;
				}
			}

			if (10 == client.field1766 || 11 == client.field1766 || 50 == client.field1766) {
				class351.field4278.method8755(class75.field627, 171);
				short var19;
				if (0 == class75.field619) {
					var24 = 251;
					var0.method6955(class338.field3934, class75.field627 + 180, var24, 16776960, 0);
					var25 = var24 + 30;
					var5 = class75.field627 + 180 - 80;
					var19 = 291;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var0.method6870(class338.field4146, var5 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var5 = 80 + 180 + class75.field627;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var0.method6870(class338.field4147, var5 - 73, var19 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (1 == class75.field619) {
					var0.method6955(class75.field648, 180 + class75.field627, 201, 16776960, 0);
					var24 = 236;
					var0.method6955(class75.field624, 180 + class75.field627, var24, 16777215, 0);
					var25 = var24 + 15;
					var0.method6955(class75.field630, 180 + class75.field627, var25, 16777215, 0);
					var25 += 15;
					var0.method6955(class75.field631, class75.field627 + 180, var25, 16777215, 0);
					var25 += 15;
					var5 = class75.field627 + 180 - 80;
					var19 = 321;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var0.method6955(class338.field3897, var5, 5 + var19, 16777215, 0);
					var5 = 180 + class75.field627 + 80;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var0.method6955(class338.field4149, var5, 5 + var19, 16777215, 0);
				} else if (2 == class75.field619) {
					var24 = 201;
					var0.method6955(class75.field624, class11.field47, var24, 16776960, 0);
					var25 = var24 + 15;
					var0.method6955(class75.field630, class11.field47, var25, 16776960, 0);
					var25 += 15;
					var0.method6955(class75.field631, class11.field47, var25, 16776960, 0);
					var25 += 15;
					var25 += 7;
					var0.method6875(class338.field4142, class11.field47 - 110, var25, 16777215, 0);
					var26 = 200;
					var6 = class413.field4575.method1706() ? class359.method5222(class75.field633) : class75.field633;

					for (var7 = var6; var0.method6894(var7) > var26; var7 = var7.substring(1)) {
					}

					var0.method6875(class384.method6864(var7) + (class75.field640 == 0 & client.field1645 % 40 < 20 ? class96.method4510(16776960) + class96.field960 : ""), class11.field47 - 70, var25, 16777215, 0);
					var25 += 15;

					for (var8 = class359.method5222(class75.field650); var0.method6894(var8) > var26; var8 = var8.substring(1)) {
					}

					var0.method6875(class338.field4143 + var8 + (class75.field640 == 1 & client.field1645 % 40 < 20 ? class96.method4510(16776960) + class96.field960 : ""), class11.field47 - 108, var25, 16777215, 0);
					var25 += 15;
					var24 = 277;
					int var9 = class11.field47 + -117;
					boolean var11 = client.field1891;
					boolean var12 = class75.field637;
					class488 var10 = var11 ? (var12 ? class362.field4317 : class166.field1525) : (var12 ? class84.field749 : class75.field629);
					var10.method8755(var9, var24);
					var9 += 5 + var10.field5017;
					var1.method6875(class338.field4150, var9, var24 + 13, 16776960, 0);
					var9 = 24 + class11.field47;
					boolean var15 = class413.field4575.method1706();
					boolean var16 = class75.field638;
					class488 var14 = var15 ? (var16 ? class362.field4317 : class166.field1525) : (var16 ? class84.field749 : class75.field629);
					var14.method8755(var9, var24);
					var9 += 5 + var14.field5017;
					var1.method6875(class338.field4151, var9, var24 + 13, 16776960, 0);
					var25 = var24 + 15;
					int var17 = class11.field47 - 80;
					short var18 = 321;
					class136.field1272.method8755(var17 - 73, var18 - 20);
					var0.method6955(class338.field4148, var17, var18 + 5, 16777215, 0);
					var17 = class11.field47 + 80;
					class136.field1272.method8755(var17 - 73, var18 - 20);
					var0.method6955(class338.field4149, var17, 5 + var18, 16777215, 0);
					var24 = 357;
					switch(class75.field646) {
					case 2:
						class20.field105 = class338.field4163;
						break;
					default:
						class20.field105 = class338.field4093;
					}

					class444.field4785 = new class407(class11.field47, var24, var1.method6894(class20.field105), 11);
					class256.field2949 = new class407(class11.field47, var24, var1.method6894(class338.field3892), 11);
					var1.method6955(class20.field105, class11.field47, var24, 16777215, 0);
				} else if (3 == class75.field619) {
					var24 = 201;
					var0.method6955(class338.field4152, 180 + class75.field627, var24, 16776960, 0);
					var25 = var24 + 20;
					var1.method6955(class338.field4198, 180 + class75.field627, var25, 16776960, 0);
					var25 += 15;
					var1.method6955(class338.field3908, class75.field627 + 180, var25, 16776960, 0);
					var25 += 15;
					var5 = 180 + class75.field627;
					var19 = 276;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var2.method6955(class338.field4155, var5, var19 + 5, 16777215, 0);
					var5 = class75.field627 + 180;
					var19 = 326;
					class136.field1272.method8755(var5 - 73, var19 - 20);
					var2.method6955(class338.field4036, var5, 5 + var19, 16777215, 0);
				} else {
					int var22;
					short var28;
					int var29;
					if (4 == class75.field619) {
						var0.method6955(class338.field4205, 180 + class75.field627, 201, 16776960, 0);
						var24 = 236;
						var0.method6955(class75.field624, 180 + class75.field627, var24, 16777215, 0);
						var25 = var24 + 15;
						var0.method6955(class75.field630, class75.field627 + 180, var25, 16777215, 0);
						var25 += 15;
						var0.method6955(class75.field631, 180 + class75.field627, var25, 16777215, 0);
						var25 += 15;
						var0.method6875(class338.field4144 + class359.method5222(class349.field4269) + (client.field1645 % 40 < 20 ? class96.method4510(16776960) + class96.field960 : ""), class75.field627 + 180 - 108, var25, 16777215, 0);
						var25 -= 8;
						var0.method6875(class338.field3900, 180 + class75.field627 - 9, var25, 16776960, 0);
						var25 += 15;
						var0.method6875(class338.field4030, class75.field627 + 180 - 9, var25, 16776960, 0);
						var5 = 180 + class75.field627 - 9 + var0.method6894(class338.field4030) + 15;
						var29 = var25 - var0.field4435;
						class488 var27;
						if (class75.field621) {
							var27 = class166.field1525;
						} else {
							var27 = class75.field629;
						}

						var27.method8755(var5, var29);
						var25 += 15;
						var22 = 180 + class75.field627 - 80;
						var28 = 321;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field3897, var22, 5 + var28, 16777215, 0);
						var22 = 80 + 180 + class75.field627;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field4149, var22, 5 + var28, 16777215, 0);
						var1.method6955(class338.field4132, class75.field627 + 180, var28 + 36, 255, 0);
					} else if (5 == class75.field619) {
						var0.method6955(class338.field4157, 180 + class75.field627, 201, 16776960, 0);
						var24 = 221;
						var2.method6955(class75.field624, 180 + class75.field627, var24, 16776960, 0);
						var25 = var24 + 15;
						var2.method6955(class75.field630, 180 + class75.field627, var25, 16776960, 0);
						var25 += 15;
						var2.method6955(class75.field631, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var25 += 14;
						var0.method6875(class338.field4158, class75.field627 + 180 - 145, var25, 16777215, 0);
						var26 = 174;
						var6 = class413.field4575.method1706() ? class359.method5222(class75.field633) : class75.field633;

						for (var7 = var6; var0.method6894(var7) > var26; var7 = var7.substring(1)) {
						}

						var0.method6875(class384.method6864(var7) + (client.field1645 % 40 < 20 ? class96.method4510(16776960) + class96.field960 : ""), class75.field627 + 180 - 34, var25, 16777215, 0);
						var25 += 15;
						var22 = 180 + class75.field627 - 80;
						var28 = 321;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field4159, var22, var28 + 5, 16777215, 0);
						var22 = 180 + class75.field627 + 80;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field4160, var22, var28 + 5, 16777215, 0);
						var28 = 356;
						var1.method6955(class338.field3892, class11.field47, var28, 268435455, 0);
					} else if (6 == class75.field619) {
						var24 = 201;
						var0.method6955(class75.field624, class75.field627 + 180, var24, 16776960, 0);
						var25 = var24 + 15;
						var0.method6955(class75.field630, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var0.method6955(class75.field631, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var5 = class75.field627 + 180;
						var19 = 321;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4160, var5, 5 + var19, 16777215, 0);
					} else if (7 == class75.field619) {
						if (class87.field781 && !client.field1640) {
							var24 = 201;
							var0.method6955(class75.field624, class11.field47, var24, 16776960, 0);
							var25 = var24 + 15;
							var0.method6955(class75.field630, class11.field47, var25, 16776960, 0);
							var25 += 15;
							var0.method6955(class75.field631, class11.field47, var25, 16776960, 0);
							var5 = class11.field47 - 150;
							var25 += 10;

							for (var29 = 0; var29 < 8; ++var29) {
								class136.field1272.method8757(var5, var25, 30, 40);
								boolean var21 = var29 == class75.field634 & client.field1645 % 40 < 20;
								var0.method6875((class75.field635[var29] == null ? "" : class75.field635[var29]) + (var21 ? class96.method4510(16776960) + class96.field960 : ""), 10 + var5, 27 + var25, 16777215, 0);
								if (1 != var29 && var29 != 3) {
									var5 += 35;
								} else {
									var5 += 50;
									var0.method6875(class384.method6864("/"), var5 - 13, var25 + 27, 16777215, 0);
								}
							}

							var29 = class11.field47 - 80;
							short var30 = 321;
							class136.field1272.method8755(var29 - 73, var30 - 20);
							var0.method6955("Submit", var29, 5 + var30, 16777215, 0);
							var29 = 80 + class11.field47;
							class136.field1272.method8755(var29 - 73, var30 - 20);
							var0.method6955(class338.field4149, var29, 5 + var30, 16777215, 0);
						} else {
							var24 = 216;
							var0.method6955(class338.field4188, class75.field627 + 180, var24, 16776960, 0);
							var25 = var24 + 15;
							var2.method6955(class338.field4189, class75.field627 + 180, var25, 16776960, 0);
							var25 += 15;
							var2.method6955(class338.field4208, 180 + class75.field627, var25, 16776960, 0);
							var25 += 15;
							var5 = 180 + class75.field627 - 80;
							var19 = 321;
							class136.field1272.method8755(var5 - 73, var19 - 20);
							var0.method6955(class338.field4211, var5, 5 + var19, 16777215, 0);
							var5 = 80 + class75.field627 + 180;
							class136.field1272.method8755(var5 - 73, var19 - 20);
							var0.method6955(class338.field4160, var5, var19 + 5, 16777215, 0);
						}
					} else if (8 == class75.field619) {
						var24 = 216;
						var0.method6955(class338.field4117, 180 + class75.field627, var24, 16776960, 0);
						var25 = var24 + 15;
						var2.method6955(class338.field4110, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var2.method6955(class338.field4031, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var5 = 180 + class75.field627 - 80;
						var19 = 321;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4032, var5, 5 + var19, 16777215, 0);
						var5 = class75.field627 + 180 + 80;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4160, var5, 5 + var19, 16777215, 0);
					} else if (9 == class75.field619) {
						var24 = 221;
						var0.method6955(class75.field624, 180 + class75.field627, var24, 16776960, 0);
						var25 = var24 + 25;
						var0.method6955(class75.field630, class75.field627 + 180, var25, 16776960, 0);
						var25 += 25;
						var0.method6955(class75.field631, class75.field627 + 180, var25, 16776960, 0);
						var5 = 180 + class75.field627;
						var19 = 311;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4155, var5, var19 + 5, 16777215, 0);
					} else if (class75.field619 == 10) {
						var25 = 180 + class75.field627;
						var26 = 209;
						var0.method6955(class338.field3934, 180 + class75.field627, var26, 16776960, 0);
						var5 = var26 + 20;
						class352.field4281.method8755(var25 - 109, var5);
						class142.field1319.method8755(var25 - 48, var5 + 18);
					} else if (12 == class75.field619) {
						var25 = class11.field47;
						var26 = 216;
						var2.method6955(class338.field4195, var25, var26, 16777215, 0);
						var5 = var26 + 17;
						var2.method6955(class338.field4196, var25, var5, 16777215, 0);
						var5 += 17;
						var2.method6955(class338.field4197, var25, var5, 16777215, 0);
						var5 += 17;
						var2.method6955(class338.field4013, var25, var5, 16777215, 0);
						var25 = class11.field47 - 80;
						var26 = 311;
						class136.field1272.method8755(var25 - 73, var26 - 20);
						var0.method6955(class338.field4201, var25, var26 + 5, 16777215, 0);
						var25 = 80 + class11.field47;
						class136.field1272.method8755(var25 - 73, var26 - 20);
						var0.method6955(class338.field3993, var25, 5 + var26, 16777215, 0);
					} else if (13 == class75.field619) {
						var24 = 231;
						var2.method6955(class338.field4199, 180 + class75.field627, var24, 16777215, 0);
						var25 = var24 + 20;
						var2.method6955(class338.field4200, class75.field627 + 180, var25, 16777215, 0);
						var5 = 180 + class75.field627;
						var24 = 311;
						class136.field1272.method8755(var5 - 73, var24 - 20);
						var0.method6955(class338.field4160, var5, 5 + var24, 16777215, 0);
					} else if (class75.field619 == 14) {
						var24 = 201;
						String var23 = "";
						var6 = "";
						var7 = "";
						switch(class75.field628) {
						case 0:
							var23 = class338.field3945;
							var6 = class338.field3946;
							var7 = class338.field3947;
							break;
						case 1:
							var23 = class338.field3984;
							var6 = class338.field3985;
							var7 = class338.field3986;
							break;
						case 2:
							var23 = class338.field4020;
							var6 = class338.field3930;
							var7 = class338.field4022;
							break;
						default:
							class367.method6730(false);
						}

						var0.method6955(var23, 180 + class75.field627, var24, 16776960, 0);
						var25 = var24 + 20;
						var0.method6955(var6, 180 + class75.field627, var25, 16776960, 0);
						var25 += 20;
						var0.method6955(var7, class75.field627 + 180, var25, 16776960, 0);
						var22 = class75.field627 + 180;
						var28 = 276;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field3929, var22, 5 + var28, 16777215, 0);
						var22 = class75.field627 + 180;
						var28 = 326;
						class136.field1272.method8755(var22 - 73, var28 - 20);
						var0.method6955(class338.field4160, var22, 5 + var28, 16777215, 0);
					} else if (class75.field619 == 24) {
						var24 = 221;
						var0.method6955(class75.field624, class75.field627 + 180, var24, 16777215, 0);
						var25 = var24 + 15;
						var0.method6955(class75.field630, class75.field627 + 180, var25, 16777215, 0);
						var25 += 15;
						var0.method6955(class75.field631, 180 + class75.field627, var25, 16777215, 0);
						var25 += 15;
						var5 = class75.field627 + 180;
						var19 = 301;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field3895, var5, 5 + var19, 16777215, 0);
					} else if (class75.field619 == 26) {
						var24 = 216;
						var0.method6955(class338.field4188, 180 + class75.field627, var24, 16776960, 0);
						var25 = var24 + 15;
						var2.method6955(class338.field4189, 180 + class75.field627, var25, 16776960, 0);
						var25 += 15;
						var2.method6955(class338.field4208, class75.field627 + 180, var25, 16776960, 0);
						var25 += 15;
						var5 = class75.field627 + 180 - 80;
						var19 = 321;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4211, var5, 5 + var19, 16777215, 0);
						var5 = class75.field627 + 180 + 80;
						class136.field1272.method8755(var5 - 73, var19 - 20);
						var0.method6955(class338.field4160, var5, 5 + var19, 16777215, 0);
					}
				}
			}

			if (client.field1766 >= 10) {
				int[] var20 = new int[4];
				class481.method8718(var20);
				class481.method8653(class75.field618, 0, 765 + class75.field618, class12.field57);
				class77.field670.method1807(class75.field618 - 22, client.field1645);
				class77.field670.method1807(765 + class75.field618 + 22 - 128, client.field1645);
				class481.method8655(var20);
			}

			class26.field133[class413.field4575.method1708() ? 1 : 0].method8755(765 + class75.field618 - 40, 463);
			if (client.field1766 > 5 && class94.field940 == class353.field4303) {
				if (class246.field2880 != null) {
					var25 = class75.field618 + 5;
					var26 = 463;
					byte var32 = 100;
					byte var31 = 35;
					class246.field2880.method8755(var25, var26);
					var0.method6955(class338.field4069 + " " + client.field1868, var25 + var32 / 2, var26 + var31 / 2 - 2, 16777215, 0);
					if (class96.field962 != null) {
						var1.method6955(class338.field3961, var25 + var32 / 2, 12 + var26 + var31 / 2, 16777215, 0);
					} else {
						var1.method6955(class338.field4213, var25 + var32 / 2, var26 + var31 / 2 + 12, 16777215, 0);
					}
				} else {
					class246.field2880 = class393.method7165(class155.field1425, "sl_button", "");
				}
			}

		}
	}

	static final void method2104(int var0, int var1) {
		if (var0 < 128) {
			var0 = 128;
		}

		if (var0 > 383) {
			var0 = 383;
		}

		if (class414.field4588 < var0) {
			class414.field4588 += class42.field298 + (var0 - class414.field4588) * class158.field1440 / 1000;
			if (class414.field4588 > var0) {
				class414.field4588 = var0;
			}
		}

		if (class414.field4588 > var0) {
			class414.field4588 -= class42.field298 + class158.field1440 * (class414.field4588 - var0) / 1000;
			if (class414.field4588 < var0) {
				class414.field4588 = var0;
			}
		}

		int var3 = var1 - class237.field2807;
		if (var3 > 1024) {
			var3 -= 2048;
		}

		if (var3 < -1024) {
			var3 += 2048;
		}

		if (var3 > 0) {
			class237.field2807 += var3 * class158.field1440 / 1000 + class42.field298;
			class237.field2807 &= 2047;
		}

		if (var3 < 0) {
			class237.field2807 -= -var3 * class158.field1440 / 1000 + class42.field298;
			class237.field2807 &= 2047;
		}

		int var4 = var1 - class237.field2807;
		if (var4 > 1024) {
			var4 -= 2048;
		}

		if (var4 < -1024) {
			var4 += 2048;
		}

		if (var4 < 0 && var3 > 0 || var4 > 0 && var3 < 0) {
			class237.field2807 = var1;
		}

	}
}
