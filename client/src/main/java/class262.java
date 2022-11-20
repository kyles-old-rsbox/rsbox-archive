public class class262 {
	class262() throws Throwable {
		throw new Error();
	}

	public static byte[] method5149(CharSequence var0) {
		int var2 = var0.length();
		byte[] var3 = new byte[var2];

		for (int var4 = 0; var4 < var2; ++var4) {
			char var5 = var0.charAt(var4);
			if (var5 > 0 && var5 < 128 || var5 >= 160 && var5 <= 255) {
				var3[var4] = (byte)var5;
			} else if (var5 == 8364) {
				var3[var4] = -128;
			} else if (var5 == 8218) {
				var3[var4] = -126;
			} else if (var5 == 402) {
				var3[var4] = -125;
			} else if (var5 == 8222) {
				var3[var4] = -124;
			} else if (var5 == 8230) {
				var3[var4] = -123;
			} else if (var5 == 8224) {
				var3[var4] = -122;
			} else if (var5 == 8225) {
				var3[var4] = -121;
			} else if (var5 == 710) {
				var3[var4] = -120;
			} else if (var5 == 8240) {
				var3[var4] = -119;
			} else if (var5 == 352) {
				var3[var4] = -118;
			} else if (var5 == 8249) {
				var3[var4] = -117;
			} else if (var5 == 338) {
				var3[var4] = -116;
			} else if (var5 == 381) {
				var3[var4] = -114;
			} else if (var5 == 8216) {
				var3[var4] = -111;
			} else if (var5 == 8217) {
				var3[var4] = -110;
			} else if (var5 == 8220) {
				var3[var4] = -109;
			} else if (var5 == 8221) {
				var3[var4] = -108;
			} else if (var5 == 8226) {
				var3[var4] = -107;
			} else if (var5 == 8211) {
				var3[var4] = -106;
			} else if (var5 == 8212) {
				var3[var4] = -105;
			} else if (var5 == 732) {
				var3[var4] = -104;
			} else if (var5 == 8482) {
				var3[var4] = -103;
			} else if (var5 == 353) {
				var3[var4] = -102;
			} else if (var5 == 8250) {
				var3[var4] = -101;
			} else if (var5 == 339) {
				var3[var4] = -100;
			} else if (var5 == 382) {
				var3[var4] = -98;
			} else if (var5 == 376) {
				var3[var4] = -97;
			} else {
				var3[var4] = 63;
			}
		}

		return var3;
	}

	static final void method5148(int var0) {
		int[] var2 = class309.field3678.field4952;
		int var3 = var2.length;

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			var2[var4] = 0;
		}

		int var5;
		int var6;
		for (var4 = 1; var4 < 103; ++var4) {
			var5 = 2048 * (103 - var4) + 24628;

			for (var6 = 1; var6 < 103; ++var6) {
				if (0 == (class82.field714[var0][var6][var4] & 24)) {
					class145.field1333.method4248(var2, var5, 512, var0, var6, var4);
				}

				if (var0 < 3 && 0 != (class82.field714[var0 + 1][var6][var4] & 8)) {
					class145.field1333.method4248(var2, var5, 512, var0 + 1, var6, var4);
				}

				var5 += 4;
			}
		}

		var4 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
		var5 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
		class309.field3678.method8476();

		int var7;
		for (var6 = 1; var6 < 103; ++var6) {
			for (var7 = 1; var7 < 103; ++var7) {
				if ((class82.field714[var0][var7][var6] & 24) == 0) {
					class138.method2457(var0, var7, var6, var4, var5);
				}

				if (var0 < 3 && 0 != (class82.field714[var0 + 1][var7][var6] & 8)) {
					class138.method2457(var0 + 1, var7, var6, var4, var5);
				}
			}
		}

		client.field1885 = 0;

		for (var6 = 0; var6 < 104; ++var6) {
			for (var7 = 0; var7 < 104; ++var7) {
				long var8 = class145.field1333.method4151(class55.field396, var6, var7);
				if (0L != var8) {
					int var10 = class234.method1610(var8);
					int var11 = InterfaceParent.method1866(var10).field2081;
					if (var11 >= 0 && class90.method1885(var11).field1463) {
						client.field1818[client.field1885] = class90.method1885(var11).method2644(false);
						client.field1834[client.field1885] = var6;
						client.field1887[client.field1885] = var7;
						++client.field1885;
					}
				}
			}
		}

		class6.field18.method8624();
	}

	static final int method5150(class300 var0, int var1) {
		if (var0.field3613 != null && var1 < var0.field3613.length) {
			try {
				int[] var3 = var0.field3613[var1];
				int var4 = 0;
				int var5 = 0;
				byte var6 = 0;

				while (true) {
					int var7 = var3[var5++];
					int var8 = 0;
					byte var9 = 0;
					if (var7 == 0) {
						return var4;
					}

					if (var7 == 1) {
						var8 = client.field1780[var3[var5++]];
					}

					if (var7 == 2) {
						var8 = client.field1817[var3[var5++]];
					}

					if (var7 == 3) {
						var8 = client.field1782[var3[var5++]];
					}

					int var10;
					class300 var11;
					int var12;
					int var13;
					if (var7 == 4) {
						var10 = var3[var5++] << 16;
						var10 += var3[var5++];
						var11 = class282.method5426(var10);
						var12 = var3[var5++];
						if (var12 != -1 && (!class278.method5388(var12).field2162 || client.field1635)) {
							for (var13 = 0; var13 < var11.field3461.length; ++var13) {
								if (var11.field3461[var13] == var12 + 1) {
									var8 += var11.field3456[var13];
								}
							}
						}
					}

					if (var7 == 5) {
						var8 = class293.field3370[var3[var5++]];
					}

					if (var7 == 6) {
						var8 = class321.field3756[client.field1817[var3[var5++]] - 1];
					}

					if (var7 == 7) {
						var8 = class293.field3370[var3[var5++]] * 100 / 46875;
					}

					if (var7 == 8) {
						var8 = class291.field3364.field905;
					}

					if (var7 == 9) {
						for (var10 = 0; var10 < 25; ++var10) {
							if (class321.field3754[var10]) {
								var8 += client.field1817[var10];
							}
						}
					}

					if (var7 == 10) {
						var10 = var3[var5++] << 16;
						var10 += var3[var5++];
						var11 = class282.method5426(var10);
						var12 = var3[var5++];
						if (var12 != -1 && (!class278.method5388(var12).field2162 || client.field1635)) {
							for (var13 = 0; var13 < var11.field3461.length; ++var13) {
								if (var12 + 1 == var11.field3461[var13]) {
									var8 = 999999999;
									break;
								}
							}
						}
					}

					if (var7 == 11) {
						var8 = client.field1816;
					}

					if (var7 == 12) {
						var8 = client.field1859;
					}

					if (var7 == 13) {
						var10 = class293.field3370[var3[var5++]];
						int var14 = var3[var5++];
						var8 = (var10 & 1 << var14) != 0 ? 1 : 0;
					}

					if (var7 == 14) {
						var10 = var3[var5++];
						var8 = class293.method1557(var10);
					}

					if (var7 == 15) {
						var9 = 1;
					}

					if (var7 == 16) {
						var9 = 2;
					}

					if (var7 == 17) {
						var9 = 3;
					}

					if (var7 == 18) {
						var8 = (class291.field3364.field827 >> 7) + class36.field241;
					}

					if (var7 == 19) {
						var8 = class169.field1536 + (class291.field3364.field802 >> 7);
					}

					if (var7 == 20) {
						var8 = var3[var5++];
					}

					if (var9 == 0) {
						if (var6 == 0) {
							var4 += var8;
						}

						if (var6 == 1) {
							var4 -= var8;
						}

						if (var6 == 2 && var8 != 0) {
							var4 /= var8;
						}

						if (var6 == 3) {
							var4 *= var8;
						}

						var6 = 0;
					} else {
						var6 = var9;
					}
				}
			} catch (Exception var15) {
				return -1;
			}
		} else {
			return -2;
		}
	}
}
