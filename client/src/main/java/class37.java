public class class37 {
	public static class319 field250;
	public static short[][] field251;
	int field248;
	int field249;

	class37(int var1, int var2) {
		this.field248 = var1;
		this.field249 = var2;
	}

	boolean method714(class29 var1) {
		if (null == var1) {
			return false;
		} else {
			switch(this.field248) {
			case 1:
				return var1.method424(this.field249);
			case 2:
				return var1.method414(this.field249);
			case 3:
				return var1.method415((char)this.field249);
			case 4:
				return var1.method416(1 == this.field249);
			default:
				return false;
			}
		}
	}

	public static final boolean method715(int var0, int var1, int var2, class204 var3, class200 var4) {
		int var6 = var0;
		int var7 = var1;
		byte var8 = 64;
		byte var9 = 64;
		int var10 = var0 - var8;
		int var11 = var1 - var9;
		class191.field2023[var8][var9] = 99;
		class191.field2020[var8][var9] = 0;
		byte var12 = 0;
		int var13 = 0;
		class191.field2017[var12] = var0;
		int var21 = var12 + 1;
		class191.field2021[var12] = var1;
		int[][] var14 = var4.field2205;

		while (true) {
			label301:
			while (true) {
				int var15;
				int var16;
				int var17;
				int var18;
				int var19;
				int var20;
				do {
					do {
						do {
							label278:
							do {
								if (var21 == var13) {
									class191.field2019 = var6;
									class191.field2022 = var7;
									return false;
								}

								var6 = class191.field2017[var13];
								var7 = class191.field2021[var13];
								var13 = var13 + 1 & 4095;
								var19 = var6 - var10;
								var20 = var7 - var11;
								var15 = var6 - var4.field2197;
								var16 = var7 - var4.field2202;
								if (var3.method3887(var2, var6, var7, var4)) {
									class191.field2019 = var6;
									class191.field2022 = var7;
									return true;
								}

								var17 = class191.field2020[var19][var20] + 1;
								if (var19 > 0 && 0 == class191.field2023[var19 - 1][var20] && (var14[var15 - 1][var16] & 19136782) == 0 && 0 == (var14[var15 - 1][var16 + var2 - 1] & 19136824)) {
									var18 = 1;

									while (true) {
										if (var18 >= var2 - 1) {
											class191.field2017[var21] = var6 - 1;
											class191.field2021[var21] = var7;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19 - 1][var20] = 2;
											class191.field2020[var19 - 1][var20] = var17;
											break;
										}

										if ((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
											break;
										}

										++var18;
									}
								}

								if (var19 < 128 - var2 && class191.field2023[var19 + 1][var20] == 0 && (var14[var2 + var15][var16] & 19136899) == 0 && 0 == (var14[var2 + var15][var16 + var2 - 1] & 19136992)) {
									var18 = 1;

									while (true) {
										if (var18 >= var2 - 1) {
											class191.field2017[var21] = var6 + 1;
											class191.field2021[var21] = var7;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19 + 1][var20] = 8;
											class191.field2020[var19 + 1][var20] = var17;
											break;
										}

										if (0 != (var14[var2 + var15][var18 + var16] & 19136995)) {
											break;
										}

										++var18;
									}
								}

								if (var20 > 0 && class191.field2023[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && 0 == (var14[var15 + var2 - 1][var16 - 1] & 19136899)) {
									var18 = 1;

									while (true) {
										if (var18 >= var2 - 1) {
											class191.field2017[var21] = var6;
											class191.field2021[var21] = var7 - 1;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19][var20 - 1] = 1;
											class191.field2020[var19][var20 - 1] = var17;
											break;
										}

										if ((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
											break;
										}

										++var18;
									}
								}

								if (var20 < 128 - var2 && 0 == class191.field2023[var19][var20 + 1] && (var14[var15][var16 + var2] & 19136824) == 0 && 0 == (var14[var2 + var15 - 1][var2 + var16] & 19136992)) {
									var18 = 1;

									while (true) {
										if (var18 >= var2 - 1) {
											class191.field2017[var21] = var6;
											class191.field2021[var21] = var7 + 1;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19][var20 + 1] = 4;
											class191.field2020[var19][var20 + 1] = var17;
											break;
										}

										if ((var14[var18 + var15][var2 + var16] & 19137016) != 0) {
											break;
										}

										++var18;
									}
								}

								if (var19 > 0 && var20 > 0 && 0 == class191.field2023[var19 - 1][var20 - 1] && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
									var18 = 1;

									while (true) {
										if (var18 >= var2) {
											class191.field2017[var21] = var6 - 1;
											class191.field2021[var21] = var7 - 1;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19 - 1][var20 - 1] = 3;
											class191.field2020[var19 - 1][var20 - 1] = var17;
											break;
										}

										if ((var14[var15 - 1][var16 - 1 + var18] & 19136830) != 0 || 0 != (var14[var15 - 1 + var18][var16 - 1] & 19136911)) {
											break;
										}

										++var18;
									}
								}

								if (var19 < 128 - var2 && var20 > 0 && 0 == class191.field2023[var19 + 1][var20 - 1] && 0 == (var14[var2 + var15][var16 - 1] & 19136899)) {
									var18 = 1;

									while (true) {
										if (var18 >= var2) {
											class191.field2017[var21] = var6 + 1;
											class191.field2021[var21] = var7 - 1;
											var21 = var21 + 1 & 4095;
											class191.field2023[var19 + 1][var20 - 1] = 9;
											class191.field2020[var19 + 1][var20 - 1] = var17;
											break;
										}

										if (0 != (var14[var15 + var2][var16 - 1 + var18] & 19136995) || (var14[var15 + var18][var16 - 1] & 19136911) != 0) {
											break;
										}

										++var18;
									}
								}

								if (var19 > 0 && var20 < 128 - var2 && class191.field2023[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
									for (var18 = 1; var18 < var2; ++var18) {
										if (0 != (var14[var15 - 1][var18 + var16] & 19136830) || (var14[var15 - 1 + var18][var2 + var16] & 19137016) != 0) {
											continue label278;
										}
									}

									class191.field2017[var21] = var6 - 1;
									class191.field2021[var21] = var7 + 1;
									var21 = var21 + 1 & 4095;
									class191.field2023[var19 - 1][var20 + 1] = 6;
									class191.field2020[var19 - 1][var20 + 1] = var17;
								}
							} while(var19 >= 128 - var2);
						} while(var20 >= 128 - var2);
					} while(class191.field2023[var19 + 1][var20 + 1] != 0);
				} while((var14[var15 + var2][var2 + var16] & 19136992) != 0);

				for (var18 = 1; var18 < var2; ++var18) {
					if (0 != (var14[var18 + var15][var16 + var2] & 19137016) || (var14[var15 + var2][var18 + var16] & 19136995) != 0) {
						continue label301;
					}
				}

				class191.field2017[var21] = var6 + 1;
				class191.field2021[var21] = var7 + 1;
				var21 = var21 + 1 & 4095;
				class191.field2023[var19 + 1][var20 + 1] = 12;
				class191.field2020[var19 + 1][var20 + 1] = var17;
			}
		}
	}
}
