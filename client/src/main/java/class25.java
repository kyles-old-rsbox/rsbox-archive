public class class25 implements class360 {
	public static final class25 field122;
	static class215 field123;
	static int field120;
	final int field119;
	final int field126;

	static {
		field122 = new class25(0, 0);
	}

	class25(int var1, int var2) {
		this.field126 = var1;
		this.field119 = var2;
	}

	public int method6663() {
		return this.field119;
	}

	static final void method341(class90 var0, int var1) {
		int var4;
		int var5;
		int var6;
		int var12;
		if (var0.field857 >= client.field1645) {
			client.method6564(var0);
		} else if (var0.field858 >= client.field1645) {
			class219.method4370(var0);
		} else {
			var0.field839 = var0.field823;
			if (0 == var0.field871) {
				var0.field837 = 0;
			} else {
				label471: {
					if (var0.field852 != -1 && 0 == var0.field804) {
						class189 var3 = class160.method2660(var0.field852);
						if (var0.field876 > 0 && var3.field2002 == 0) {
							++var0.field837;
							break label471;
						}

						if (var0.field876 <= 0 && 0 == var3.field1992) {
							++var0.field837;
							break label471;
						}
					}

					var12 = var0.field827;
					var4 = var0.field802;
					var5 = 128 * var0.field861[var0.field871 - 1] + var0.field866 * 64;
					var6 = var0.field866 * 64 + 128 * var0.field873[var0.field871 - 1];
					if (var12 < var5) {
						if (var4 < var6) {
							var0.field860 = 1280;
						} else if (var4 > var6) {
							var0.field860 = 1792;
						} else {
							var0.field860 = 1536;
						}
					} else if (var12 > var5) {
						if (var4 < var6) {
							var0.field860 = 768;
						} else if (var4 > var6) {
							var0.field860 = 256;
						} else {
							var0.field860 = 512;
						}
					} else if (var4 < var6) {
						var0.field860 = 1024;
					} else if (var4 > var6) {
						var0.field860 = 0;
					}

					class197 var7 = var0.field803[var0.field871 - 1];
					if (var5 - var12 <= 256 && var5 - var12 >= -256 && var6 - var4 <= 256 && var6 - var4 >= -256) {
						int var8 = var0.field860 - var0.field826 & 2047;
						if (var8 > 1024) {
							var8 -= 2048;
						}

						int var9 = var0.field811;
						if (var8 >= -256 && var8 <= 256) {
							var9 = var0.field810;
						} else if (var8 >= 256 && var8 < 768) {
							var9 = var0.field813;
						} else if (var8 >= -768 && var8 <= -256) {
							var9 = var0.field812;
						}

						if (var9 == -1) {
							var9 = var0.field810;
						}

						var0.field839 = var9;
						int var10 = 4;
						boolean var11 = true;
						if (var0 instanceof class81) {
							var11 = ((class81)var0).field709.field2298;
						}

						if (var11) {
							if (var0.field826 != var0.field860 && -1 == var0.field835 && var0.field870 != 0) {
								var10 = 2;
							}

							if (var0.field871 > 2) {
								var10 = 6;
							}

							if (var0.field871 > 3) {
								var10 = 8;
							}

							if (var0.field837 > 0 && var0.field871 > 1) {
								var10 = 8;
								--var0.field837;
							}
						} else {
							if (var0.field871 > 1) {
								var10 = 6;
							}

							if (var0.field871 > 2) {
								var10 = 8;
							}

							if (var0.field837 > 0 && var0.field871 > 1) {
								var10 = 8;
								--var0.field837;
							}
						}

						if (var7 == class197.field2116) {
							var10 <<= 1;
						} else if (class197.field2113 == var7) {
							var10 >>= 1;
						}

						if (var10 >= 8) {
							if (var0.field839 == var0.field810 && var0.field814 != -1) {
								var0.field839 = var0.field814;
							} else if (var0.field811 == var0.field839 && -1 != var0.field846) {
								var0.field839 = var0.field846;
							} else if (var0.field812 == var0.field839 && -1 != var0.field816) {
								var0.field839 = var0.field816;
							} else if (var0.field839 == var0.field813 && -1 != var0.field817) {
								var0.field839 = var0.field817;
							}
						} else if (var10 <= 1) {
							if (var0.field839 == var0.field810 && -1 != var0.field818) {
								var0.field839 = var0.field818;
							} else if (var0.field839 == var0.field811 && var0.field874 != -1) {
								var0.field839 = var0.field874;
							} else if (var0.field839 == var0.field812 && var0.field849 != -1) {
								var0.field839 = var0.field849;
							} else if (var0.field839 == var0.field813 && -1 != var0.field821) {
								var0.field839 = var0.field821;
							}
						}

						if (var5 != var12 || var4 != var6) {
							if (var12 < var5) {
								var0.field827 += var10;
								if (var0.field827 > var5) {
									var0.field827 = var5;
								}
							} else if (var12 > var5) {
								var0.field827 -= var10;
								if (var0.field827 < var5) {
									var0.field827 = var5;
								}
							}

							if (var4 < var6) {
								var0.field802 += var10;
								if (var0.field802 > var6) {
									var0.field802 = var6;
								}
							} else if (var4 > var6) {
								var0.field802 -= var10;
								if (var0.field802 < var6) {
									var0.field802 = var6;
								}
							}
						}

						if (var5 == var0.field827 && var0.field802 == var6) {
							--var0.field871;
							if (var0.field876 > 0) {
								--var0.field876;
							}
						}
					} else {
						var0.field827 = var5;
						var0.field802 = var6;
						--var0.field871;
						if (var0.field876 > 0) {
							--var0.field876;
						}
					}
				}
			}
		}

		if (var0.field827 < 128 || var0.field802 < 128 || var0.field827 >= 13184 || var0.field802 >= 13184) {
			var0.field852 = -1;
			var0.field848 = -1;
			var0.field857 = 0;
			var0.field858 = 0;
			var0.field827 = var0.field866 * 64 + 128 * var0.field861[0];
			var0.field802 = var0.field866 * 64 + 128 * var0.field873[0];
			var0.method1868();
		}

		if (var0 == class291.field3364 && (var0.field827 < 1536 || var0.field802 < 1536 || var0.field827 >= 11776 || var0.field802 >= 11776)) {
			var0.field852 = -1;
			var0.field848 = -1;
			var0.field857 = 0;
			var0.field858 = 0;
			var0.field827 = var0.field866 * 64 + var0.field861[0] * 128;
			var0.field802 = var0.field866 * 64 + var0.field873[0] * 128;
			var0.method1868();
		}

		if (0 != var0.field870) {
			if (var0.field835 != -1) {
				Object var14 = null;
				var4 = class78.field683 ? 65536 : 32768;
				if (var0.field835 < var4) {
					var14 = client.field1902[var0.field835];
				} else if (var0.field835 >= var4) {
					var14 = client.field1763[var0.field835 - var4];
				}

				if (null != var14) {
					var5 = var0.field827 - ((class90)var14).field827;
					var6 = var0.field802 - ((class90)var14).field802;
					if (var5 != 0 || var6 != 0) {
						var0.field860 = (int)(Math.atan2((double)var5, (double)var6) * 325.949D) & 2047;
					}
				} else if (var0.field836) {
					var0.field835 = -1;
					var0.field836 = false;
				}
			}

			if (-1 != var0.field868 && (0 == var0.field871 || var0.field837 > 0)) {
				var0.field860 = var0.field868;
				var0.field868 = -1;
			}

			var12 = var0.field860 - var0.field826 & 2047;
			if (var12 == 0 && var0.field836) {
				var0.field835 = -1;
				var0.field836 = false;
			}

			if (var12 != 0) {
				++var0.field869;
				boolean var15;
				if (var12 > 1024) {
					var0.field826 -= var0.field838 ? var12 : var0.field870;
					var15 = true;
					if (var12 < var0.field870 || var12 > 2048 - var0.field870) {
						var0.field826 = var0.field860;
						var15 = false;
					}

					if (!var0.field838 && var0.field839 == var0.field823 && (var0.field869 > 25 || var15)) {
						if (-1 != var0.field808) {
							var0.field839 = var0.field808;
						} else {
							var0.field839 = var0.field810;
						}
					}
				} else {
					var0.field826 += var0.field838 ? var12 : var0.field870;
					var15 = true;
					if (var12 < var0.field870 || var12 > 2048 - var0.field870) {
						var0.field826 = var0.field860;
						var15 = false;
					}

					if (!var0.field838 && var0.field839 == var0.field823 && (var0.field869 > 25 || var15)) {
						if (-1 != var0.field806) {
							var0.field839 = var0.field806;
						} else {
							var0.field839 = var0.field810;
						}
					}
				}

				var0.field826 &= 2047;
				var0.field838 = false;
			} else {
				var0.field869 = 0;
			}
		}

		class74.method1496(var0);
	}

	static final void method344(boolean var0, class453 var1) {
		client.field1706 = var0;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (!client.field1706) {
			int var3 = var1.method8202();
			var4 = var1.method8162();
			var5 = var1.method8122();
			class36.field238 = new int[var5][4];

			for (var6 = 0; var6 < var5; ++var6) {
				for (var7 = 0; var7 < 4; ++var7) {
					class36.field238[var6][var7] = var1.method8126();
				}
			}

			class204.field2302 = new int[var5];
			class136.field1271 = new int[var5];
			class2.field1 = new int[var5];
			class74.field612 = new byte[var5][];
			class18.field92 = new byte[var5][];
			var5 = 0;

			for (var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
				for (var7 = (var4 - 6) / 8; var7 <= (var4 + 6) / 8; ++var7) {
					var8 = var7 + (var6 << 8);
					class204.field2302[var5] = var8;
					class136.field1271[var5] = class58.field417.method6124("m" + var6 + "_" + var7);
					class2.field1[var5] = class58.field417.method6124("l" + var6 + "_" + var7);
					++var5;
				}
			}

			class200.method3753(var3, var4, true);
		} else {
			boolean var16 = var1.method8154() == 1;
			var4 = var1.method8122();
			var5 = var1.method8162();
			var6 = var1.method8122();
			var1.method8013();

			int var9;
			int var10;
			for (var7 = 0; var7 < 4; ++var7) {
				for (var8 = 0; var8 < 13; ++var8) {
					for (var9 = 0; var9 < 13; ++var9) {
						var10 = var1.method8014(1);
						if (var10 == 1) {
							client.field1707[var7][var8][var9] = var1.method8014(26);
						} else {
							client.field1707[var7][var8][var9] = -1;
						}
					}
				}
			}

			var1.method8010();
			class36.field238 = new int[var6][4];

			for (var7 = 0; var7 < var6; ++var7) {
				for (var8 = 0; var8 < 4; ++var8) {
					class36.field238[var7][var8] = var1.method8126();
				}
			}

			class204.field2302 = new int[var6];
			class136.field1271 = new int[var6];
			class2.field1 = new int[var6];
			class74.field612 = new byte[var6][];
			class18.field92 = new byte[var6][];
			var6 = 0;

			for (var7 = 0; var7 < 4; ++var7) {
				for (var8 = 0; var8 < 13; ++var8) {
					for (var9 = 0; var9 < 13; ++var9) {
						var10 = client.field1707[var7][var8][var9];
						if (var10 != -1) {
							int var11 = var10 >> 14 & 1023;
							int var12 = var10 >> 3 & 2047;
							int var13 = var12 / 8 + (var11 / 8 << 8);

							int var14;
							for (var14 = 0; var14 < var6; ++var14) {
								if (class204.field2302[var14] == var13) {
									var13 = -1;
									break;
								}
							}

							if (var13 != -1) {
								class204.field2302[var6] = var13;
								var14 = var13 >> 8 & 255;
								int var15 = var13 & 255;
								class136.field1271[var6] = class58.field417.method6124("m" + var14 + "_" + var15);
								class2.field1[var6] = class58.field417.method6124("l" + var14 + "_" + var15);
								++var6;
							}
						}
					}
				}
			}

			class200.method3753(var4, var5, !var16);
		}

	}
}
