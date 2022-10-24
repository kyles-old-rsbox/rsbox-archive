public class class206 extends class437 {
	public static class284 field2330;
	public static class284 field2331;
	public static class284 field2332;
	static class319 field2328;
	static class319 field2329;
	static class319 field2346;
	int field2335;
	int field2337;
	int field2340;
	int field2341;
	int field2343;
	int field2347;
	int field2349;
	String field2342;
	public int field2327;
	public int field2336;
	public int field2338;
	public int field2339;
	public int field2344;
	public int field2345;
	public int field2350;
	public int[] field2348;

	static {
		field2330 = new class284(64);
		field2331 = new class284(64);
		field2332 = new class284(20);
	}

	class206() {
		this.field2335 = -1;
		this.field2336 = 16777215;
		this.field2327 = 70;
		this.field2343 = -1;
		this.field2337 = -1;
		this.field2347 = -1;
		this.field2341 = -1;
		this.field2345 = 0;
		this.field2350 = 0;
		this.field2344 = -1;
		this.field2342 = "";
		this.field2338 = -1;
		this.field2339 = 0;
		this.field2349 = -1;
		this.field2340 = -1;
	}

	public static void method2590(class319 var0, class319 var1, class319 var2) {
		field2346 = var0;
		field2328 = var1;
		field2329 = var2;
	}

	void method3930(class460 var1) {
		while (true) {
			int var3 = var1.method8141();
			if (var3 == 0) {
				return;
			}

			this.method3934(var1, var3);
		}
	}

	void method3934(class460 var1, int var2) {
		if (var2 == 1) {
			this.field2335 = var1.method8140();
		} else if (2 == var2) {
			this.field2336 = var1.method8312();
		} else if (3 == var2) {
			this.field2343 = var1.method8140();
		} else if (4 == var2) {
			this.field2347 = var1.method8140();
		} else if (var2 == 5) {
			this.field2337 = var1.method8140();
		} else if (6 == var2) {
			this.field2341 = var1.method8140();
		} else if (7 == var2) {
			this.field2345 = var1.method8204();
		} else if (8 == var2) {
			this.field2342 = var1.method8132();
		} else if (9 == var2) {
			this.field2327 = var1.method8122();
		} else if (var2 == 10) {
			this.field2350 = var1.method8204();
		} else if (11 == var2) {
			this.field2344 = 0;
		} else if (12 == var2) {
			this.field2338 = var1.method8141();
		} else if (13 == var2) {
			this.field2339 = var1.method8204();
		} else if (14 == var2) {
			this.field2344 = var1.method8122();
		} else if (var2 == 17 || var2 == 18) {
			this.field2349 = var1.method8122();
			if (this.field2349 == 65535) {
				this.field2349 = -1;
			}

			this.field2340 = var1.method8122();
			if (this.field2340 == 65535) {
				this.field2340 = -1;
			}

			int var4 = -1;
			if (var2 == 18) {
				var4 = var1.method8122();
				if (65535 == var4) {
					var4 = -1;
				}
			}

			int var5 = var1.method8141();
			this.field2348 = new int[var5 + 2];

			for (int var6 = 0; var6 <= var5; ++var6) {
				this.field2348[var6] = var1.method8122();
				if (this.field2348[var6] == 65535) {
					this.field2348[var6] = -1;
				}
			}

			this.field2348[1 + var5] = var4;
		}

	}

	public final class206 method3929() {
		int var2 = -1;
		if (this.field2349 != -1) {
			var2 = class293.method1557(this.field2349);
		} else if (-1 != this.field2340) {
			var2 = class293.field3370[this.field2340];
		}

		int var3;
		if (var2 >= 0 && var2 < this.field2348.length - 1) {
			var3 = this.field2348[var2];
		} else {
			var3 = this.field2348[this.field2348.length - 1];
		}

		return -1 != var3 ? class169.method2715(var3) : null;
	}

	static final void method3968(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class200[] var8) {
		int var11;
		for (int var10 = 0; var10 < 8; ++var10) {
			for (var11 = 0; var11 < 8; ++var11) {
				if (var2 + var10 > 0 && var10 + var2 < 103 && var11 + var3 > 0 && var3 + var11 < 103) {
					int[] var10000 = var8[var1].field2205[var10 + var2];
					var10000[var11 + var3] &= -16777217;
				}
			}
		}

		class460 var21 = new class460(var0);

		for (var11 = 0; var11 < 4; ++var11) {
			for (int var12 = 0; var12 < 64; ++var12) {
				for (int var13 = 0; var13 < 64; ++var13) {
					if (var11 == var4 && var12 >= var5 && var12 < 8 + var5 && var13 >= var6 && var13 < 8 + var6) {
						int var18 = var12 & 7;
						int var19 = var13 & 7;
						int var20 = var7 & 3;
						int var17;
						if (0 == var20) {
							var17 = var18;
						} else if (1 == var20) {
							var17 = var19;
						} else if (2 == var20) {
							var17 = 7 - var18;
						} else {
							var17 = 7 - var19;
						}

						class243.method4768(var21, var1, var17 + var2, var3 + class189.method3498(var12 & 7, var13 & 7, var7), 0, 0, var7);
					} else {
						class243.method4768(var21, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	public String method3937(int var1) {
		String var3 = this.field2342;

		while (true) {
			int var4 = var3.indexOf("%1");
			if (var4 < 0) {
				return var3;
			}

			var3 = var3.substring(0, var4) + class11.method86(var1, false) + var3.substring(var4 + 2);
		}
	}

	public class473 method3954() {
		if (this.field2343 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field2331.method5439((long)this.field2343);
			if (null != var2) {
				return var2;
			} else {
				var2 = class389.method7014(field2328, this.field2343, 0);
				if (var2 != null) {
					field2331.method5434(var2, (long)this.field2343);
				}

				return var2;
			}
		}
	}

	public class473 method3944() {
		if (this.field2337 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field2331.method5439((long)this.field2337);
			if (null != var2) {
				return var2;
			} else {
				var2 = class389.method7014(field2328, this.field2337, 0);
				if (var2 != null) {
					field2331.method5434(var2, (long)this.field2337);
				}

				return var2;
			}
		}
	}

	public class473 method3936() {
		if (this.field2347 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field2331.method5439((long)this.field2347);
			if (null != var2) {
				return var2;
			} else {
				var2 = class389.method7014(field2328, this.field2347, 0);
				if (var2 != null) {
					field2331.method5434(var2, (long)this.field2347);
				}

				return var2;
			}
		}
	}

	public class473 method3963() {
		if (this.field2341 < 0) {
			return null;
		} else {
			class473 var2 = (class473)field2331.method5439((long)this.field2341);
			if (var2 != null) {
				return var2;
			} else {
				var2 = class389.method7014(field2328, this.field2341, 0);
				if (null != var2) {
					field2331.method5434(var2, (long)this.field2341);
				}

				return var2;
			}
		}
	}

	public class376 method3938() {
		if (this.field2335 == -1) {
			return null;
		} else {
			class376 var2 = (class376)field2332.method5439((long)this.field2335);
			if (var2 != null) {
				return var2;
			} else {
				var2 = class378.method6805(field2328, field2329, this.field2335, 0);
				if (null != var2) {
					field2332.method5434(var2, (long)this.field2335);
				}

				return var2;
			}
		}
	}
}
