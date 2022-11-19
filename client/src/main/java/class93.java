import client.Client;

public final class class93 extends class90 {
	boolean field895;
	boolean field913;
	boolean field919;
	class209 field906;
	class305 field911;
	class410 field916;
	class410 field917;
	class410 field918;
	class472 field910;
	int field892;
	int field893;
	int field894;
	int field898;
	int field899;
	int field900;
	int field901;
	int field902;
	int field903;
	int field904;
	int field905;
	int field907;
	int field908;
	int field909;
	int field912;
	int field914;
	int field915;
	int field920;
	int field921;
	String[] field897;

	class93() {
		this.field894 = -1;
		this.field893 = -1;
		this.field897 = new String[3];

		for (int var1 = 0; var1 < 3; ++var1) {
			this.field897[var1] = "";
		}

		this.field905 = 0;
		this.field912 = 0;
		this.field901 = 0;
		this.field902 = 0;
		this.field895 = false;
		this.field921 = 0;
		this.field913 = false;
		this.field916 = class410.field4554;
		this.field917 = class410.field4554;
		this.field918 = class410.field4554;
		this.field919 = false;
	}

	final void method1906(class460 var1) {
		var1.field4878 = 0;
		int var3 = var1.method8141();
		int var4 = -1;
		this.field894 = var1.method8287();
		this.field893 = var1.method8287();
		int var5 = -1;
		this.field921 = 0;
		int[] var6 = new int[12];

		int var8;
		int var9;
		int var10;
		for (int var7 = 0; var7 < 12; ++var7) {
			var8 = var1.method8141();
			if (var8 == 0) {
				var6[var7] = 0;
			} else {
				var9 = var1.method8141();
				var6[var7] = var9 + (var8 << 8);
				if (var7 == 0 && 65535 == var6[0]) {
					var5 = var1.method8122();
					break;
				}

				if (var6[var7] >= 512) {
					var10 = class278.method5388(var6[var7] - 512).field2172;
					if (var10 != 0) {
						this.field921 = var10;
					}
				}
			}
		}

		int[] var26 = new int[5];

		for (var8 = 0; var8 < 5; ++var8) {
			var9 = var1.method8141();
			if (var9 < 0 || var9 >= class37.field251[var8].length) {
				var9 = 0;
			}

			var26[var8] = var9;
		}

		super.field823 = var1.method8122();
		if (super.field823 == 65535) {
			super.field823 = -1;
		}

		super.field808 = var1.method8122();
		if (super.field808 == 65535) {
			super.field808 = -1;
		}

		super.field806 = super.field808;
		super.field810 = var1.method8122();
		if (65535 == super.field810) {
			super.field810 = -1;
		}

		super.field811 = var1.method8122();
		if (65535 == super.field811) {
			super.field811 = -1;
		}

		super.field812 = var1.method8122();
		if (super.field812 == 65535) {
			super.field812 = -1;
		}

		super.field813 = var1.method8122();
		if (super.field813 == 65535) {
			super.field813 = -1;
		}

		super.field814 = var1.method8122();
		if (super.field814 == 65535) {
			super.field814 = -1;
		}

		this.field910 = new class472(var1.method8131(), class234.field2779);
		this.method1908();
		this.method1913();
		this.method1911();
		if (class291.field3364 == this) {
			class487.field5013 = this.field910.method8451();
		}

		this.field905 = var1.method8141();
		this.field912 = var1.method8122();
		this.field913 = var1.method8141() == 1;
		if (0 == Client.field1911 && Client.field1750 >= 2) {
			this.field913 = false;
		}

		class179[] var27 = null;
		boolean var28 = false;
		var10 = var1.method8122();
		var28 = 1 == (var10 >> 15 & 1);
		int var11;
		if (var10 > 0 && var10 != 32768) {
			var27 = new class179[12];

			for (var11 = 0; var11 < 12; ++var11) {
				int var12 = var10 >> 12 - var11 & 1;
				if (var12 == 1) {
					int var16 = var6[var11] - 512;
					int var17 = var1.method8141();
					boolean var18 = (var17 & 1) != 0;
					boolean var19 = (var17 & 2) != 0;
					class179 var20 = new class179(var16);
					int var21;
					int[] var22;
					boolean var23;
					int var24;
					short var25;
					if (var18) {
						var21 = var1.method8141();
						var22 = new int[]{var21 & 15, var21 >> 4 & 15};
						var23 = null != var20.field1603 && var20.field1603.length == var22.length;

						for (var24 = 0; var24 < 2; ++var24) {
							if (15 != var22[var24]) {
								var25 = (short)var1.method8122();
								if (var23) {
									var20.field1603[var22[var24]] = var25;
								}
							}
						}
					}

					if (var19) {
						var21 = var1.method8141();
						var22 = new int[]{var21 & 15, var21 >> 4 & 15};
						var23 = null != var20.field1600 && var22.length == var20.field1600.length;

						for (var24 = 0; var24 < 2; ++var24) {
							if (var22[var24] != 15) {
								var25 = (short)var1.method8122();
								if (var23) {
									var20.field1600[var22[var24]] = var25;
								}
							}
						}
					}

					var27[var11] = var20;
				}
			}
		}

		for (var11 = 0; var11 < 3; ++var11) {
			this.field897[var11] = var1.method8131();
		}

		if (Client.field1932 > 208) {
			var4 = var1.method8141();
		}

		if (this.field911 == null) {
			this.field911 = new class305();
		}

		this.field911.method5997(var6, var27, var28, var26, var3, var5, var4);
	}

	boolean method1907() {
		if (this.field916 == class410.field4554) {
			this.method1909();
		}

		return this.field916 == class410.field4551;
	}

	void method1908() {
		this.field916 = class410.field4554;
	}

	void method1909() {
		this.field916 = class217.field2588.method1056(this.field910) ? class410.field4551 : class410.field4552;
	}

	boolean method1939() {
		if (this.field917 == class410.field4554) {
			this.method1912();
		}

		return this.field917 == class410.field4551;
	}

	void method1913() {
		this.field917 = class410.field4554;
	}

	void method1912() {
		this.field917 = null != class73.field603 && class73.field603.method7359(this.field910) ? class410.field4551 : class410.field4552;
	}

	void method1910() {
		for (int var2 = 0; var2 < 4; ++var2) {
			if (null != Client.field1738[var2] && Client.field1738[var2].method2525(this.field910.method8451()) != -1 && var2 != 2) {
				this.field918 = class410.field4551;
				return;
			}
		}

		this.field918 = class410.field4552;
	}

	void method1911() {
		this.field918 = class410.field4554;
	}

	boolean method1951() {
		if (this.field918 == class410.field4554) {
			this.method1910();
		}

		return class410.field4551 == this.field918;
	}

	int method1916() {
		return null != this.field911 && this.field911.field3640 != -1 ? class158.method2632(this.field911.field3640).field2262 : 1;
	}

	protected final class209 method4112() {
		if (this.field911 == null) {
			return null;
		} else {
			class189 var2 = super.field852 != -1 && super.field804 == 0 ? class160.method2660(super.field852) : null;
			class189 var3 = -1 == super.field839 || this.field895 || super.field823 == super.field839 && null != var2 ? null : class160.method2660(super.field839);
			class209 var4 = this.field911.method6003(var2, super.field844, var3, super.field840);
			if (var4 == null) {
				return null;
			} else {
				var4.method4067();
				super.field809 = var4.field2489;
				int var5 = var4.field2409;
				class209 var6;
				class209[] var7;
				if (!this.field895 && -1 != super.field848 && -1 != super.field856) {
					var6 = class207.method803(super.field848).method3972(super.field856);
					if (var6 != null) {
						var6.method4008(0, -super.field824, 0);
						var7 = new class209[]{var4, var6};
						var4 = new class209(var7, 2);
					}
				}

				if (!this.field895 && null != this.field906) {
					if (Client.field1645 >= this.field902) {
						this.field906 = null;
					}

					if (Client.field1645 >= this.field901 && Client.field1645 < this.field902) {
						var6 = this.field906;
						var6.method4008(this.field898 - super.field827, this.field904 - this.field900, this.field903 - super.field802);
						if (512 == super.field860) {
							var6.method4083();
							var6.method4083();
							var6.method4083();
						} else if (super.field860 == 1024) {
							var6.method4083();
							var6.method4083();
						} else if (1536 == super.field860) {
							var6.method4083();
						}

						var7 = new class209[]{var4, var6};
						var4 = new class209(var7, 2);
						if (512 == super.field860) {
							var6.method4083();
						} else if (1024 == super.field860) {
							var6.method4083();
							var6.method4083();
						} else if (super.field860 == 1536) {
							var6.method4083();
							var6.method4083();
							var6.method4083();
						}

						var6.method4008(super.field827 - this.field898, this.field900 - this.field904, super.field802 - this.field903);
					}
				}

				var4.field2407 = true;
				if (super.field867 != 0 && Client.field1645 >= super.field862 && Client.field1645 < super.field863) {
					var4.field2440 = super.field864;
					var4.field2417 = super.field865;
					var4.field2453 = super.field850;
					var4.field2454 = super.field867;
					var4.field2455 = (short)var5;
				} else {
					var4.field2454 = 0;
				}

				return var4;
			}
		}
	}

	final void method1938(int var1, int var2, class197 var3) {
		if (-1 != super.field852 && class160.method2660(super.field852).field1992 == 1) {
			super.field852 = -1;
		}

		super.field868 = -1;
		if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
			if (super.field861[0] >= 0 && super.field861[0] < 104 && super.field873[0] >= 0 && super.field873[0] < 104) {
				if (var3 == class197.field2116) {
					class93 var5 = this;
					class197 var6 = class197.field2116;
					int var7 = super.field861[0];
					int var8 = super.field873[0];
					int var9 = this.method1916();
					if (var7 >= var9 && var7 < 104 - var9 && var8 >= var9 && var8 < 104 - var9 && var1 >= var9 && var1 < 104 - var9 && var2 >= var9 && var2 < 104 - var9) {
						int var11 = this.method1916();
						Client.field1933.field2305 = var1;
						Client.field1933.field2303 = var2;
						Client.field1933.field2307 = 1;
						Client.field1933.field2308 = 1;
						class55 var12 = Client.field1933;
						class55 var13 = var12;
						class200 var14 = Client.field1884[this.field914];
						int[] var15 = Client.field1836;
						int[] var16 = Client.field1935;
						int var17 = 0;

						label544:
						while (true) {
							int var18;
							if (var17 >= 128) {
								int var19;
								int var20;
								byte var21;
								byte var22;
								int var23;
								int var24;
								byte var25;
								int var26;
								int[][] var27;
								int var28;
								int var29;
								int var30;
								boolean var37;
								boolean var38;
								int var39;
								int var40;
								int var42;
								if (var11 == 1) {
									var19 = var7;
									var20 = var8;
									var21 = 64;
									var22 = 64;
									var23 = var7 - var21;
									var24 = var8 - var22;
									class191.field2023[var21][var22] = 99;
									class191.field2020[var21][var22] = 0;
									var25 = 0;
									var26 = 0;
									class191.field2017[var25] = var7;
									var42 = var25 + 1;
									class191.field2021[var25] = var8;
									var27 = var14.field2205;

									while (true) {
										if (var26 == var42) {
											class191.field2019 = var19;
											class191.field2022 = var20;
											var38 = false;
											break;
										}

										var19 = class191.field2017[var26];
										var20 = class191.field2021[var26];
										var26 = var26 + 1 & 4095;
										var39 = var19 - var23;
										var40 = var20 - var24;
										var28 = var19 - var14.field2197;
										var29 = var20 - var14.field2202;
										if (var13.method3887(1, var19, var20, var14)) {
											class191.field2019 = var19;
											class191.field2022 = var20;
											var38 = true;
											break;
										}

										var30 = 1 + class191.field2020[var39][var40];
										if (var39 > 0 && 0 == class191.field2023[var39 - 1][var40] && 0 == (var27[var28 - 1][var29] & 19136776)) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40] = 2;
											class191.field2020[var39 - 1][var40] = var30;
										}

										if (var39 < 127 && 0 == class191.field2023[var39 + 1][var40] && (var27[var28 + 1][var29] & 19136896) == 0) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40] = 8;
											class191.field2020[var39 + 1][var40] = var30;
										}

										if (var40 > 0 && class191.field2023[var39][var40 - 1] == 0 && (var27[var28][var29 - 1] & 19136770) == 0) {
											class191.field2017[var42] = var19;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39][var40 - 1] = 1;
											class191.field2020[var39][var40 - 1] = var30;
										}

										if (var40 < 127 && 0 == class191.field2023[var39][var40 + 1] && (var27[var28][var29 + 1] & 19136800) == 0) {
											class191.field2017[var42] = var19;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39][var40 + 1] = 4;
											class191.field2020[var39][var40 + 1] = var30;
										}

										if (var39 > 0 && var40 > 0 && 0 == class191.field2023[var39 - 1][var40 - 1] && 0 == (var27[var28 - 1][var29 - 1] & 19136782) && 0 == (var27[var28 - 1][var29] & 19136776) && (var27[var28][var29 - 1] & 19136770) == 0) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40 - 1] = 3;
											class191.field2020[var39 - 1][var40 - 1] = var30;
										}

										if (var39 < 127 && var40 > 0 && class191.field2023[var39 + 1][var40 - 1] == 0 && 0 == (var27[var28 + 1][var29 - 1] & 19136899) && (var27[var28 + 1][var29] & 19136896) == 0 && 0 == (var27[var28][var29 - 1] & 19136770)) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40 - 1] = 9;
											class191.field2020[var39 + 1][var40 - 1] = var30;
										}

										if (var39 > 0 && var40 < 127 && 0 == class191.field2023[var39 - 1][var40 + 1] && 0 == (var27[var28 - 1][var29 + 1] & 19136824) && (var27[var28 - 1][var29] & 19136776) == 0 && (var27[var28][var29 + 1] & 19136800) == 0) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40 + 1] = 6;
											class191.field2020[var39 - 1][var40 + 1] = var30;
										}

										if (var39 < 127 && var40 < 127 && class191.field2023[var39 + 1][var40 + 1] == 0 && (var27[var28 + 1][var29 + 1] & 19136992) == 0 && 0 == (var27[var28 + 1][var29] & 19136896) && 0 == (var27[var28][var29 + 1] & 19136800)) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40 + 1] = 12;
											class191.field2020[var39 + 1][var40 + 1] = var30;
										}
									}

									var37 = var38;
								} else if (var11 == 2) {
									var19 = var7;
									var20 = var8;
									var21 = 64;
									var22 = 64;
									var23 = var7 - var21;
									var24 = var8 - var22;
									class191.field2023[var21][var22] = 99;
									class191.field2020[var21][var22] = 0;
									var25 = 0;
									var26 = 0;
									class191.field2017[var25] = var7;
									var42 = var25 + 1;
									class191.field2021[var25] = var8;
									var27 = var14.field2205;

									while (true) {
										if (var42 == var26) {
											class191.field2019 = var19;
											class191.field2022 = var20;
											var38 = false;
											break;
										}

										var19 = class191.field2017[var26];
										var20 = class191.field2021[var26];
										var26 = var26 + 1 & 4095;
										var39 = var19 - var23;
										var40 = var20 - var24;
										var28 = var19 - var14.field2197;
										var29 = var20 - var14.field2202;
										if (var13.method3887(2, var19, var20, var14)) {
											class191.field2019 = var19;
											class191.field2022 = var20;
											var38 = true;
											break;
										}

										var30 = 1 + class191.field2020[var39][var40];
										if (var39 > 0 && 0 == class191.field2023[var39 - 1][var40] && (var27[var28 - 1][var29] & 19136782) == 0 && (var27[var28 - 1][var29 + 1] & 19136824) == 0) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40] = 2;
											class191.field2020[var39 - 1][var40] = var30;
										}

										if (var39 < 126 && 0 == class191.field2023[var39 + 1][var40] && 0 == (var27[var28 + 2][var29] & 19136899) && (var27[var28 + 2][var29 + 1] & 19136992) == 0) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40] = 8;
											class191.field2020[var39 + 1][var40] = var30;
										}

										if (var40 > 0 && 0 == class191.field2023[var39][var40 - 1] && 0 == (var27[var28][var29 - 1] & 19136782) && 0 == (var27[var28 + 1][var29 - 1] & 19136899)) {
											class191.field2017[var42] = var19;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39][var40 - 1] = 1;
											class191.field2020[var39][var40 - 1] = var30;
										}

										if (var40 < 126 && 0 == class191.field2023[var39][var40 + 1] && (var27[var28][var29 + 2] & 19136824) == 0 && (var27[var28 + 1][var29 + 2] & 19136992) == 0) {
											class191.field2017[var42] = var19;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39][var40 + 1] = 4;
											class191.field2020[var39][var40 + 1] = var30;
										}

										if (var39 > 0 && var40 > 0 && 0 == class191.field2023[var39 - 1][var40 - 1] && (var27[var28 - 1][var29] & 19136830) == 0 && (var27[var28 - 1][var29 - 1] & 19136782) == 0 && 0 == (var27[var28][var29 - 1] & 19136911)) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40 - 1] = 3;
											class191.field2020[var39 - 1][var40 - 1] = var30;
										}

										if (var39 < 126 && var40 > 0 && class191.field2023[var39 + 1][var40 - 1] == 0 && 0 == (var27[var28 + 1][var29 - 1] & 19136911) && 0 == (var27[var28 + 2][var29 - 1] & 19136899) && 0 == (var27[var28 + 2][var29] & 19136995)) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20 - 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40 - 1] = 9;
											class191.field2020[var39 + 1][var40 - 1] = var30;
										}

										if (var39 > 0 && var40 < 126 && 0 == class191.field2023[var39 - 1][var40 + 1] && 0 == (var27[var28 - 1][var29 + 1] & 19136830) && (var27[var28 - 1][var29 + 2] & 19136824) == 0 && 0 == (var27[var28][var29 + 2] & 19137016)) {
											class191.field2017[var42] = var19 - 1;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 - 1][var40 + 1] = 6;
											class191.field2020[var39 - 1][var40 + 1] = var30;
										}

										if (var39 < 126 && var40 < 126 && 0 == class191.field2023[var39 + 1][var40 + 1] && (var27[var28 + 1][var29 + 2] & 19137016) == 0 && 0 == (var27[var28 + 2][var29 + 2] & 19136992) && 0 == (var27[var28 + 2][var29 + 1] & 19136995)) {
											class191.field2017[var42] = var19 + 1;
											class191.field2021[var42] = var20 + 1;
											var42 = var42 + 1 & 4095;
											class191.field2023[var39 + 1][var40 + 1] = 12;
											class191.field2020[var39 + 1][var40 + 1] = var30;
										}
									}

									var37 = var38;
								} else {
									var37 = class37.method715(var7, var8, var11, var12, var14);
								}

								int var10;
								label569: {
									var18 = var7 - 64;
									var19 = var8 - 64;
									var20 = class191.field2019;
									var39 = class191.field2022;
									if (!var37) {
										var40 = Integer.MAX_VALUE;
										var23 = Integer.MAX_VALUE;
										byte var41 = 10;
										var42 = var13.field2305;
										var26 = var13.field2303;
										int var36 = var13.field2307;
										var28 = var13.field2308;

										for (var29 = var42 - var41; var29 <= var41 + var42; ++var29) {
											for (var30 = var26 - var41; var30 <= var41 + var26; ++var30) {
												int var31 = var29 - var18;
												int var32 = var30 - var19;
												if (var31 >= 0 && var32 >= 0 && var31 < 128 && var32 < 128 && class191.field2020[var31][var32] < 100) {
													int var33 = 0;
													if (var29 < var42) {
														var33 = var42 - var29;
													} else if (var29 > var36 + var42 - 1) {
														var33 = var29 - (var36 + var42 - 1);
													}

													int var34 = 0;
													if (var30 < var26) {
														var34 = var26 - var30;
													} else if (var30 > var28 + var26 - 1) {
														var34 = var30 - (var28 + var26 - 1);
													}

													int var35 = var33 * var33 + var34 * var34;
													if (var35 < var40 || var35 == var40 && class191.field2020[var31][var32] < var23) {
														var40 = var35;
														var23 = class191.field2020[var31][var32];
														var20 = var29;
														var39 = var30;
													}
												}
											}
										}

										if (var40 == Integer.MAX_VALUE) {
											var10 = -1;
											break label569;
										}
									}

									if (var7 == var20 && var39 == var8) {
										var15[0] = var20;
										var16[0] = var39;
										var10 = 0;
									} else {
										var22 = 0;
										class191.field2017[var22] = var20;
										var40 = var22 + 1;
										class191.field2021[var22] = var39;

										for (var23 = var24 = class191.field2023[var20 - var18][var39 - var19]; var7 != var20 || var39 != var8; var23 = class191.field2023[var20 - var18][var39 - var19]) {
											if (var24 != var23) {
												var24 = var23;
												class191.field2017[var40] = var20;
												class191.field2021[var40++] = var39;
											}

											if ((var23 & 2) != 0) {
												++var20;
											} else if ((var23 & 8) != 0) {
												--var20;
											}

											if ((var23 & 1) != 0) {
												++var39;
											} else if ((var23 & 4) != 0) {
												--var39;
											}
										}

										var42 = 0;

										while (var40-- > 0) {
											var15[var42] = class191.field2017[var40];
											var16[var42++] = class191.field2021[var40];
											if (var42 >= var15.length) {
												break;
											}
										}

										var10 = var42;
									}
								}

								var17 = var10;
								if (var10 < 1) {
									break;
								}

								var18 = 0;

								while (true) {
									if (var18 >= var17 - 1) {
										break label544;
									}

									var5.method1914(Client.field1836[var18], Client.field1935[var18], var6);
									++var18;
								}
							}

							for (var18 = 0; var18 < 128; ++var18) {
								class191.field2023[var17][var18] = 0;
								class191.field2020[var17][var18] = 99999999;
							}

							++var17;
						}
					}
				}

				this.method1914(var1, var2, var3);
			} else {
				this.method1919(var1, var2);
			}
		} else {
			this.method1919(var1, var2);
		}

	}

	void method1919(int var1, int var2) {
		super.field871 = 0;
		super.field876 = 0;
		super.field837 = 0;
		super.field861[0] = var1;
		super.field873[0] = var2;
		int var4 = this.method1916();
		super.field827 = 128 * super.field861[0] + var4 * 64;
		super.field802 = var4 * 64 + 128 * super.field873[0];
	}

	final void method1914(int var1, int var2, class197 var3) {
		if (super.field871 < 9) {
			++super.field871;
		}

		for (int var5 = super.field871; var5 > 0; --var5) {
			super.field861[var5] = super.field861[var5 - 1];
			super.field873[var5] = super.field873[var5 - 1];
			super.field803[var5] = super.field803[var5 - 1];
		}

		super.field861[0] = var1;
		super.field873[0] = var2;
		super.field803[0] = var3;
	}

	final boolean method1869() {
		return null != this.field911;
	}
}
