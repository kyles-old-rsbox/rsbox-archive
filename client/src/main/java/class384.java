import java.util.Random;

public abstract class class384 extends class481 {
	public static class488[] field4438;
	static int field4429;
	static int field4439;
	static int field4440;
	static int field4442;
	static int field4443;
	static int field4444;
	static int field4445;
	static int field4447;
	static int field4448;
	static String[] field4450;
	static Random field4449;
	byte[] field4441;
	byte[][] field4446;
	int[] field4430;
	int[] field4431;
	int[] field4432;
	int[] field4433;
	int[] field4434;
	public int field4435;
	public int field4436;
	public int field4437;

	static {
		field4440 = -1;
		field4443 = -1;
		field4445 = -1;
		field4442 = -1;
		field4444 = 0;
		field4448 = 0;
		field4439 = 256;
		field4447 = 0;
		field4429 = 0;
		field4449 = new Random();
		field4450 = new String[100];
	}

	class384(byte[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, byte[][] var7) {
		this.field4446 = new byte[256][];
		this.field4435 = 0;
		this.field4433 = var2;
		this.field4434 = var3;
		this.field4432 = var4;
		this.field4431 = var5;
		this.method6887(var1);
		this.field4446 = var7;
		int var8 = Integer.MAX_VALUE;
		int var9 = Integer.MIN_VALUE;

		for (int var10 = 0; var10 < 256; ++var10) {
			if (this.field4434[var10] < var8 && this.field4431[var10] != 0) {
				var8 = this.field4434[var10];
			}

			if (this.field4434[var10] + this.field4431[var10] > var9) {
				var9 = this.field4434[var10] + this.field4431[var10];
			}
		}

		this.field4436 = this.field4435 - var8;
		this.field4437 = var9 - this.field4435;
	}

	class384(byte[] var1) {
		this.field4446 = new byte[256][];
		this.field4435 = 0;
		this.method6887(var1);
	}

	void method6887(byte[] var1) {
		this.field4430 = new int[256];
		int var2;
		if (var1.length == 257) {
			for (var2 = 0; var2 < this.field4430.length; ++var2) {
				this.field4430[var2] = var1[var2] & 255;
			}

			this.field4435 = var1[256] & 255;
		} else {
			var2 = 0;

			for (int var3 = 0; var3 < 256; ++var3) {
				this.field4430[var3] = var1[var2++] & 255;
			}

			int[] var10 = new int[256];
			int[] var4 = new int[256];

			int var5;
			for (var5 = 0; var5 < 256; ++var5) {
				var10[var5] = var1[var2++] & 255;
			}

			for (var5 = 0; var5 < 256; ++var5) {
				var4[var5] = var1[var2++] & 255;
			}

			byte[][] var11 = new byte[256][];

			int var8;
			for (int var6 = 0; var6 < 256; ++var6) {
				var11[var6] = new byte[var10[var6]];
				byte var7 = 0;

				for (var8 = 0; var8 < var11[var6].length; ++var8) {
					var7 += var1[var2++];
					var11[var6][var8] = var7;
				}
			}

			byte[][] var12 = new byte[256][];

			int var13;
			for (var13 = 0; var13 < 256; ++var13) {
				var12[var13] = new byte[var10[var13]];
				byte var14 = 0;

				for (int var9 = 0; var9 < var12[var13].length; ++var9) {
					var14 += var1[var2++];
					var12[var13][var9] = var14;
				}
			}

			this.field4441 = new byte[65536];

			for (var13 = 0; var13 < 256; ++var13) {
				if (var13 != 32 && var13 != 160) {
					for (var8 = 0; var8 < 256; ++var8) {
						if (var8 != 32 && var8 != 160) {
							this.field4441[(var13 << 8) + var8] = (byte)method6917(var11, var12, var4, this.field4430, var10, var13, var8);
						}
					}
				}
			}

			this.field4435 = var4[32] + var10[32];
		}

	}

	static int method6917(byte[][] var0, byte[][] var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
		int var7 = var2[var5];
		int var8 = var7 + var4[var5];
		int var9 = var2[var6];
		int var10 = var9 + var4[var6];
		int var11 = var7;
		if (var9 > var7) {
			var11 = var9;
		}

		int var12 = var8;
		if (var10 < var8) {
			var12 = var10;
		}

		int var13 = var3[var5];
		if (var3[var6] < var13) {
			var13 = var3[var6];
		}

		byte[] var14 = var1[var5];
		byte[] var15 = var0[var6];
		int var16 = var11 - var7;
		int var17 = var11 - var9;

		for (int var18 = var11; var18 < var12; ++var18) {
			int var19 = var14[var16++] + var15[var17++];
			if (var19 < var13) {
				var13 = var19;
			}
		}

		return -var13;
	}

	public int method6927(char var1) {
		if (var1 == 160) {
			var1 = ' ';
		}

		return this.field4430[class107.method2099(var1) & 255];
	}

	public int method6894(String var1) {
		if (var1 == null) {
			return 0;
		} else {
			int var2 = -1;
			int var3 = -1;
			int var4 = 0;

			for (int var5 = 0; var5 < var1.length(); ++var5) {
				char var6 = var1.charAt(var5);
				if (var6 == '<') {
					var2 = var5;
				} else {
					if (var6 == '>' && var2 != -1) {
						String var7 = var1.substring(var2 + 1, var5);
						var2 = -1;
						if (var7.equals("lt")) {
							var6 = '<';
						} else {
							if (!var7.equals("gt")) {
								if (var7.startsWith("img=")) {
									try {
										int var8 = class359.method1905(var7.substring(4));
										var4 += field4438[var8].field5016;
										var3 = -1;
									} catch (Exception var10) {
									}
								}
								continue;
							}

							var6 = '>';
						}
					}

					if (var6 == 160) {
						var6 = ' ';
					}

					if (var2 == -1) {
						var4 += this.field4430[(char)(class107.method2099(var6) & 255)];
						if (this.field4441 != null && var3 != -1) {
							var4 += this.field4441[(var3 << 8) + var6];
						}

						var3 = var6;
					}
				}
			}

			return var4;
		}
	}

	public int method6909(String var1, int[] var2, String[] var3) {
		if (var1 == null) {
			return 0;
		} else {
			int var4 = 0;
			int var5 = 0;
			StringBuilder var6 = new StringBuilder(100);
			int var7 = -1;
			int var8 = 0;
			byte var9 = 0;
			int var10 = -1;
			char var11 = 0;
			int var12 = 0;
			int var13 = var1.length();

			for (int var14 = 0; var14 < var13; ++var14) {
				char var15 = var1.charAt(var14);
				if (var15 == '<') {
					var10 = var14;
				} else {
					if (var15 == '>' && var10 != -1) {
						String var16 = var1.substring(var10 + 1, var14);
						var10 = -1;
						var6.append('<');
						var6.append(var16);
						var6.append('>');
						if (var16.equals("br")) {
							var3[var12] = var6.toString().substring(var5, var6.length());
							++var12;
							var5 = var6.length();
							var4 = 0;
							var7 = -1;
							var11 = 0;
						} else if (var16.equals("lt")) {
							var4 += this.method6927('<');
							if (this.field4441 != null && var11 != -1) {
								var4 += this.field4441[(var11 << '\b') + 60];
							}

							var11 = '<';
						} else if (var16.equals("gt")) {
							var4 += this.method6927('>');
							if (this.field4441 != null && var11 != -1) {
								var4 += this.field4441[(var11 << '\b') + 62];
							}

							var11 = '>';
						} else if (var16.startsWith("img=")) {
							try {
								int var17 = class359.method1905(var16.substring(4));
								var4 += field4438[var17].field5016;
								var11 = 0;
							} catch (Exception var20) {
							}
						}

						var15 = 0;
					}

					if (var10 == -1) {
						if (var15 != 0) {
							var6.append(var15);
							var4 += this.method6927(var15);
							if (this.field4441 != null && var11 != -1) {
								var4 += this.field4441[(var11 << '\b') + var15];
							}

							var11 = var15;
						}

						if (var15 == ' ') {
							var7 = var6.length();
							var8 = var4;
							var9 = 1;
						}

						if (var2 != null && var4 > var2[var12 < var2.length ? var12 : var2.length - 1] && var7 >= 0) {
							var3[var12] = var6.toString().substring(var5, var7 - var9);
							++var12;
							var5 = var7;
							var7 = -1;
							var4 -= var8;
							var11 = 0;
						}

						if (var15 == '-') {
							var7 = var6.length();
							var8 = var4;
							var9 = 0;
						}
					}
				}
			}

			String var19 = var6.toString();
			if (var19.length() > var5) {
				var3[var12++] = var19.substring(var5, var19.length());
			}

			return var12;
		}
	}

	public int method6862(String var1, int var2) {
		int var3 = this.method6909(var1, new int[]{var2}, field4450);
		int var4 = 0;

		for (int var5 = 0; var5 < var3; ++var5) {
			int var6 = this.method6894(field4450[var5]);
			if (var6 > var4) {
				var4 = var6;
			}
		}

		return var4;
	}

	public int method6869(String var1, int var2) {
		return this.method6909(var1, new int[]{var2}, field4450);
	}

	public static String method6864(String var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if (var4 == '<' || var4 == '>') {
				var2 += 3;
			}
		}

		StringBuilder var6 = new StringBuilder(var1 + var2);

		for (int var7 = 0; var7 < var1; ++var7) {
			char var5 = var0.charAt(var7);
			if (var5 == '<') {
				var6.append("<lt>");
			} else if (var5 == '>') {
				var6.append("<gt>");
			} else {
				var6.append(var5);
			}
		}

		return var6.toString();
	}

	public class407 method6865(int var1, int var2, String var3, int var4, int var5) {
		if (var3 != null && var3.length() >= var1 + var2) {
			int var6 = var4 - this.method6894(var3) / 2;
			var6 += this.method6894(var3.substring(0, var1));
			int var7 = var5 - this.field4436;
			int var8 = this.method6894(var3.substring(var1, var1 + var2));
			int var9 = this.field4436 + this.field4437;
			return new class407(var6, var7, var8, var9);
		} else {
			return new class407(var4, var5, 0, 0);
		}
	}

	public void method6875(String var1, int var2, int var3, int var4, int var5) {
		if (var1 != null) {
			this.method6876(var4, var5);
			this.method6879(var1, var2, var3);
		}
	}

	public void method6867(String var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 != null) {
			this.method6876(var4, var5);
			field4439 = var6;
			this.method6879(var1, var2, var3);
		}
	}

	public void method6868(String var1, int var2, int var3, int var4, int var5) {
		if (var1 != null) {
			this.method6876(var4, var5);
			this.method6879(var1, var2 - this.method6894(var1), var3);
		}
	}

	public void method6955(String var1, int var2, int var3, int var4, int var5) {
		if (var1 != null) {
			this.method6876(var4, var5);
			this.method6879(var1, var2 - this.method6894(var1) / 2, var3);
		}
	}

	public int method6870(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		if (var1 == null) {
			return 0;
		} else {
			this.method6876(var6, var7);
			if (var10 == 0) {
				var10 = this.field4435;
			}

			int[] var11 = new int[]{var4};
			if (var5 < this.field4436 + this.field4437 + var10 && var5 < var10 + var10) {
				var11 = null;
			}

			int var12 = this.method6909(var1, var11, field4450);
			if (var9 == 3 && var12 == 1) {
				var9 = 1;
			}

			int var13;
			int var14;
			if (var9 == 0) {
				var13 = var3 + this.field4436;
			} else if (var9 == 1) {
				var13 = var3 + this.field4436 + (var5 - this.field4436 - this.field4437 - (var12 - 1) * var10) / 2;
			} else if (var9 == 2) {
				var13 = var3 + var5 - this.field4437 - (var12 - 1) * var10;
			} else {
				var14 = (var5 - this.field4436 - this.field4437 - (var12 - 1) * var10) / (var12 + 1);
				if (var14 < 0) {
					var14 = 0;
				}

				var13 = var3 + this.field4436 + var14;
				var10 += var14;
			}

			for (var14 = 0; var14 < var12; ++var14) {
				if (var8 == 0) {
					this.method6879(field4450[var14], var2, var13);
				} else if (var8 == 1) {
					this.method6879(field4450[var14], var2 + (var4 - this.method6894(field4450[var14])) / 2, var13);
				} else if (var8 == 2) {
					this.method6879(field4450[var14], var2 + var4 - this.method6894(field4450[var14]), var13);
				} else if (var14 == var12 - 1) {
					this.method6879(field4450[var14], var2, var13);
				} else {
					this.method6878(field4450[var14], var4);
					this.method6879(field4450[var14], var2, var13);
					field4447 = 0;
				}

				var13 += var10;
			}

			return var12;
		}
	}

	public class438 method6871(class388 var1, int var2, int var3, int var4, int var5, int var6) {
		if (!var1.method6993()) {
			this.method6876(var4, var5);
			var3 -= this.field4435;

			for (int var7 = 0; var7 < var1.method6994(); ++var7) {
				class383 var8 = var1.method7010(var7);
				if (var6 != -1 && var8.field4424 > var6) {
					return new class438(var8.field4422, var8.field4424);
				}

				char var9 = var8.field4428;
				if (var9 != '\n') {
					if (var1.method6992(var7)) {
						var9 = '*';
					}

					if (var9 != '\t') {
						if (var9 == 160) {
							var9 = ' ';
						}

						int var10 = var2 + var8.field4422;
						int var11 = var3 + var8.field4424;
						int var12 = this.field4432[var9];
						int var13 = this.field4431[var9];
						if (field4442 != -1) {
							this.method6890(this.field4446[var9], var10 + this.field4433[var9] + 1, var11 + this.field4434[var9] + 1, var12, var13, field4442);
						}

						this.method6890(this.field4446[var9], var10 + this.field4433[var9], var11 + this.field4434[var9], var12, var13, field4448);
					}
				}
			}
		}

		return var1.method6997();
	}

	public void method6872(String var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 != null) {
			this.method6876(var4, var5);
			int[] var7 = new int[var1.length()];

			for (int var8 = 0; var8 < var1.length(); ++var8) {
				var7[var8] = (int)(Math.sin((double)var8 / 2.0D + (double)var6 / 5.0D) * 5.0D);
			}

			this.method6857(var1, var2 - this.method6894(var1) / 2, var3, (int[])null, var7);
		}
	}

	public void method6873(String var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 != null) {
			this.method6876(var4, var5);
			int[] var7 = new int[var1.length()];
			int[] var8 = new int[var1.length()];

			for (int var9 = 0; var9 < var1.length(); ++var9) {
				var7[var9] = (int)(Math.sin((double)var9 / 5.0D + (double)var6 / 5.0D) * 5.0D);
				var8[var9] = (int)(Math.sin((double)var9 / 3.0D + (double)var6 / 5.0D) * 5.0D);
			}

			this.method6857(var1, var2 - this.method6894(var1) / 2, var3, var7, var8);
		}
	}

	public void method6874(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var1 != null) {
			this.method6876(var4, var5);
			double var8 = 7.0D - (double)var7 / 8.0D;
			if (var8 < 0.0D) {
				var8 = 0.0D;
			}

			int[] var10 = new int[var1.length()];

			for (int var11 = 0; var11 < var1.length(); ++var11) {
				var10[var11] = (int)(Math.sin((double)var11 / 1.5D + (double)var6 / 1.0D) * var8);
			}

			this.method6857(var1, var2 - this.method6894(var1) / 2, var3, (int[])null, var10);
		}
	}

	public void method6860(String var1, int var2, int var3, int var4, int var5, int var6) {
		if (var1 != null) {
			this.method6876(var4, var5);
			field4449.setSeed((long)var6);
			field4439 = 192 + (field4449.nextInt() & 31);
			int[] var7 = new int[var1.length()];
			int var8 = 0;

			for (int var9 = 0; var9 < var1.length(); ++var9) {
				var7[var9] = var8;
				if ((field4449.nextInt() & 3) == 0) {
					++var8;
				}
			}

			this.method6857(var1, var2, var3, var7, (int[])null);
		}
	}

	void method6876(int var1, int var2) {
		field4440 = -1;
		field4443 = -1;
		field4445 = var2;
		field4442 = var2;
		field4444 = var1;
		field4448 = var1;
		field4439 = 256;
		field4447 = 0;
		field4429 = 0;
	}

	void method6877(String var1) {
		try {
			int var2;
			String var3;
			if (var1.startsWith("col=")) {
				var3 = var1.substring(4);
				var2 = class13.method120(var3, 16, true);
				field4448 = var2;
			} else if (var1.equals("/col")) {
				field4448 = field4444;
			} else if (var1.startsWith("str=")) {
				var3 = var1.substring(4);
				var2 = class13.method120(var3, 16, true);
				field4440 = var2;
			} else if (var1.equals("str")) {
				field4440 = 8388608;
			} else if (var1.equals("/str")) {
				field4440 = -1;
			} else if (var1.startsWith("u=")) {
				var3 = var1.substring(2);
				var2 = class13.method120(var3, 16, true);
				field4443 = var2;
			} else if (var1.equals("u")) {
				field4443 = 0;
			} else if (var1.equals("/u")) {
				field4443 = -1;
			} else if (var1.startsWith("shad=")) {
				var3 = var1.substring(5);
				var2 = class13.method120(var3, 16, true);
				field4442 = var2;
			} else if (var1.equals("shad")) {
				field4442 = 0;
			} else if (var1.equals("/shad")) {
				field4442 = field4445;
			} else if (var1.equals("br")) {
				this.method6876(field4444, field4445);
			}
		} catch (Exception var5) {
		}

	}

	void method6878(String var1, int var2) {
		int var3 = 0;
		boolean var4 = false;

		for (int var5 = 0; var5 < var1.length(); ++var5) {
			char var6 = var1.charAt(var5);
			if (var6 == '<') {
				var4 = true;
			} else if (var6 == '>') {
				var4 = false;
			} else if (!var4 && var6 == ' ') {
				++var3;
			}
		}

		if (var3 > 0) {
			field4447 = (var2 - this.method6894(var1) << 8) / var3;
		}

	}

	void method6879(String var1, int var2, int var3) {
		var3 -= this.field4435;
		int var4 = -1;
		int var5 = -1;

		for (int var6 = 0; var6 < var1.length(); ++var6) {
			if (var1.charAt(var6) != 0) {
				char var7 = (char)(class107.method2099(var1.charAt(var6)) & 255);
				if (var7 == '<') {
					var4 = var6;
				} else {
					int var9;
					if (var7 == '>' && var4 != -1) {
						String var8 = var1.substring(var4 + 1, var6);
						var4 = -1;
						if (var8.equals("lt")) {
							var7 = '<';
						} else {
							if (!var8.equals("gt")) {
								if (var8.startsWith("img=")) {
									try {
										var9 = class359.method1905(var8.substring(4));
										class488 var10 = field4438[var9];
										var10.method8755(var2, var3 + this.field4435 - var10.field5018);
										var2 += var10.field5016;
										var5 = -1;
									} catch (Exception var14) {
									}
								} else {
									this.method6877(var8);
								}
								continue;
							}

							var7 = '>';
						}
					}

					if (var7 == 160) {
						var7 = ' ';
					}

					if (var4 == -1) {
						if (this.field4441 != null && var5 != -1) {
							var2 += this.field4441[(var5 << 8) + var7];
						}

						int var12 = this.field4432[var7];
						var9 = this.field4431[var7];
						if (var7 != ' ') {
							if (field4439 == 256) {
								if (field4442 != -1) {
									method6883(this.field4446[var7], var2 + this.field4433[var7] + 1, var3 + this.field4434[var7] + 1, var12, var9, field4442);
								}

								this.method6890(this.field4446[var7], var2 + this.field4433[var7], var3 + this.field4434[var7], var12, var9, field4448);
							} else {
								if (field4442 != -1) {
									method6885(this.field4446[var7], var2 + this.field4433[var7] + 1, var3 + this.field4434[var7] + 1, var12, var9, field4442, field4439);
								}

								this.method6956(this.field4446[var7], var2 + this.field4433[var7], var3 + this.field4434[var7], var12, var9, field4448, field4439);
							}
						} else if (field4447 > 0) {
							field4429 += field4447;
							var2 += field4429 >> 8;
							field4429 &= 255;
						}

						int var13 = this.field4430[var7];
						if (field4440 != -1) {
							method8666(var2, var3 + (int)((double)this.field4435 * 0.7D), var13, field4440);
						}

						if (field4443 != -1) {
							method8666(var2, var3 + this.field4435 + 1, var13, field4443);
						}

						var2 += var13;
						var5 = var7;
					}
				}
			}
		}

	}

	void method6857(String var1, int var2, int var3, int[] var4, int[] var5) {
		var3 -= this.field4435;
		int var6 = -1;
		int var7 = -1;
		int var8 = 0;

		for (int var9 = 0; var9 < var1.length(); ++var9) {
			if (var1.charAt(var9) != 0) {
				char var10 = (char)(class107.method2099(var1.charAt(var9)) & 255);
				if (var10 == '<') {
					var6 = var9;
				} else {
					int var12;
					int var13;
					int var14;
					if (var10 == '>' && var6 != -1) {
						String var11 = var1.substring(var6 + 1, var9);
						var6 = -1;
						if (var11.equals("lt")) {
							var10 = '<';
						} else {
							if (!var11.equals("gt")) {
								if (var11.startsWith("img=")) {
									try {
										if (var4 != null) {
											var12 = var4[var8];
										} else {
											var12 = 0;
										}

										if (var5 != null) {
											var13 = var5[var8];
										} else {
											var13 = 0;
										}

										++var8;
										var14 = class359.method1905(var11.substring(4));
										class488 var15 = field4438[var14];
										var15.method8755(var2 + var12, var3 + this.field4435 - var15.field5018 + var13);
										var2 += var15.field5016;
										var7 = -1;
									} catch (Exception var19) {
									}
								} else {
									this.method6877(var11);
								}
								continue;
							}

							var10 = '>';
						}
					}

					if (var10 == 160) {
						var10 = ' ';
					}

					if (var6 == -1) {
						if (this.field4441 != null && var7 != -1) {
							var2 += this.field4441[(var7 << 8) + var10];
						}

						int var17 = this.field4432[var10];
						var12 = this.field4431[var10];
						if (var4 != null) {
							var13 = var4[var8];
						} else {
							var13 = 0;
						}

						if (var5 != null) {
							var14 = var5[var8];
						} else {
							var14 = 0;
						}

						++var8;
						if (var10 != ' ') {
							if (field4439 == 256) {
								if (field4442 != -1) {
									method6883(this.field4446[var10], var2 + this.field4433[var10] + 1 + var13, var3 + this.field4434[var10] + 1 + var14, var17, var12, field4442);
								}

								this.method6890(this.field4446[var10], var2 + this.field4433[var10] + var13, var3 + this.field4434[var10] + var14, var17, var12, field4448);
							} else {
								if (field4442 != -1) {
									method6885(this.field4446[var10], var2 + this.field4433[var10] + 1 + var13, var3 + this.field4434[var10] + 1 + var14, var17, var12, field4442, field4439);
								}

								this.method6956(this.field4446[var10], var2 + this.field4433[var10] + var13, var3 + this.field4434[var10] + var14, var17, var12, field4448, field4439);
							}
						} else if (field4447 > 0) {
							field4429 += field4447;
							var2 += field4429 >> 8;
							field4429 &= 255;
						}

						int var18 = this.field4430[var10];
						if (field4440 != -1) {
							method8666(var2, var3 + (int)((double)this.field4435 * 0.7D), var18, field4440);
						}

						if (field4443 != -1) {
							method8666(var2, var3 + this.field4435, var18, field4443);
						}

						var2 += var18;
						var7 = var10;
					}
				}
			}
		}

	}

	static void method6883(byte[] var0, int var1, int var2, int var3, int var4, int var5) {
		int var6 = var1 + var2 * class481.field4993;
		int var7 = class481.field4993 - var3;
		int var8 = 0;
		int var9 = 0;
		int var10;
		if (var2 < class481.field4995) {
			var10 = class481.field4995 - var2;
			var4 -= var10;
			var2 = class481.field4995;
			var9 += var10 * var3;
			var6 += var10 * class481.field4993;
		}

		if (var2 + var4 > class481.field4998) {
			var4 -= var2 + var4 - class481.field4998;
		}

		if (var1 < class481.field4997) {
			var10 = class481.field4997 - var1;
			var3 -= var10;
			var1 = class481.field4997;
			var9 += var10;
			var6 += var10;
			var8 += var10;
			var7 += var10;
		}

		if (var1 + var3 > class481.field4996) {
			var10 = var1 + var3 - class481.field4996;
			var3 -= var10;
			var8 += var10;
			var7 += var10;
		}

		if (var3 > 0 && var4 > 0) {
			method6884(class481.field4992, var0, var5, var9, var6, var3, var4, var7, var8);
		}
	}

	static void method6884(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int var9 = -(var5 >> 2);
		var5 = -(var5 & 3);

		for (int var10 = -var6; var10 < 0; ++var10) {
			int var11;
			for (var11 = var9; var11 < 0; ++var11) {
				if (var1[var3++] != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				if (var1[var3++] != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				if (var1[var3++] != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}

				if (var1[var3++] != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}
			}

			for (var11 = var5; var11 < 0; ++var11) {
				if (var1[var3++] != 0) {
					var0[var4++] = var2;
				} else {
					++var4;
				}
			}

			var4 += var7;
			var3 += var8;
		}

	}

	static void method6885(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = var1 + var2 * class481.field4993;
		int var8 = class481.field4993 - var3;
		int var9 = 0;
		int var10 = 0;
		int var11;
		if (var2 < class481.field4995) {
			var11 = class481.field4995 - var2;
			var4 -= var11;
			var2 = class481.field4995;
			var10 += var11 * var3;
			var7 += var11 * class481.field4993;
		}

		if (var2 + var4 > class481.field4998) {
			var4 -= var2 + var4 - class481.field4998;
		}

		if (var1 < class481.field4997) {
			var11 = class481.field4997 - var1;
			var3 -= var11;
			var1 = class481.field4997;
			var10 += var11;
			var7 += var11;
			var9 += var11;
			var8 += var11;
		}

		if (var1 + var3 > class481.field4996) {
			var11 = var1 + var3 - class481.field4996;
			var3 -= var11;
			var9 += var11;
			var8 += var11;
		}

		if (var3 > 0 && var4 > 0) {
			method6886(class481.field4992, var0, var5, var10, var7, var3, var4, var8, var9, var6);
		}
	}

	static void method6886(int[] var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
		var2 = ((var2 & 16711935) * var9 & -16711936) + ((var2 & 65280) * var9 & 16711680) >> 8;
		var9 = 256 - var9;

		for (int var10 = -var6; var10 < 0; ++var10) {
			for (int var11 = -var5; var11 < 0; ++var11) {
				if (var1[var3++] != 0) {
					int var12 = var0[var4];
					var0[var4++] = (((var12 & 16711935) * var9 & -16711936) + ((var12 & 65280) * var9 & 16711680) >> 8) + var2;
				} else {
					++var4;
				}
			}

			var4 += var7;
			var3 += var8;
		}

	}

	abstract void method6890(byte[] var1, int var2, int var3, int var4, int var5, int var6);

	abstract void method6956(byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);
}
