import java.util.Arrays;

public class class205 implements class29 {
	static class473[] field2326;
	boolean[] field2316;
	boolean[] field2319;
	boolean[] field2322;
	char[] field2318;
	int field2314;
	int field2315;
	int field2320;
	int field2323;
	int[] field2309;
	int[] field2325;
	public char field2321;
	public int field2312;
	public int field2317;
	public int[] field2311;

	public class205() {
		this.field2318 = new char[128];
		this.field2309 = new int[128];
		this.field2311 = new int[128];
		this.field2312 = 0;
		this.field2325 = new int[128];
		this.field2320 = 0;
		this.field2315 = 0;
		this.field2314 = 0;
		this.field2323 = 0;
		this.field2316 = new boolean[112];
		this.field2319 = new boolean[112];
		this.field2322 = new boolean[112];
	}

	public boolean method424(int var1) {
		this.method3892(var1);
		this.field2316[var1] = true;
		this.field2319[var1] = true;
		this.field2322[var1] = false;
		this.field2311[++this.field2312 - 1] = var1;
		return true;
	}

	public boolean method414(int var1) {
		this.field2316[var1] = false;
		this.field2319[var1] = false;
		this.field2322[var1] = true;
		this.field2325[++this.field2320 - 1] = var1;
		return true;
	}

	public boolean method415(char var1) {
		int var3 = this.field2314 + 1 & 127;
		if (var3 != this.field2315) {
			this.field2309[this.field2314] = -1;
			this.field2318[this.field2314] = var1;
			this.field2314 = var3;
		}

		return false;
	}

	void method3892(int var1) {
		int var3 = this.field2314 + 1 & 127;
		if (this.field2315 != var3) {
			this.field2309[this.field2314] = var1;
			this.field2318[this.field2314] = 0;
			this.field2314 = var3;
		}

	}

	public boolean method416(boolean var1) {
		return false;
	}

	public void method3893() {
		this.field2315 = this.field2323;
		this.field2323 = this.field2314;
		this.field2312 = 0;
		this.field2320 = 0;
		Arrays.fill(this.field2319, false);
		Arrays.fill(this.field2322, false);
	}

	public final boolean method3911() {
		if (this.field2323 == this.field2315) {
			return false;
		} else {
			this.field2317 = this.field2309[this.field2315];
			this.field2321 = this.field2318[this.field2315];
			this.field2315 = this.field2315 + 1 & 127;
			return true;
		}
	}

	public boolean method3919(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field2319[var1] : false;
	}

	public boolean method3895(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field2316[var1] : false;
	}

	public boolean method3900(int var1) {
		return var1 >= 0 && var1 < 112 ? this.field2322[var1] : false;
	}

	public int[] method3915() {
		int[] var2 = new int[this.field2312];

		for (int var3 = 0; var3 < this.field2312; ++var3) {
			var2[var3] = this.field2311[var3];
		}

		return var2;
	}

	public static synchronized void method3927(byte[] var0) {
		if (var0.length == 100 && class378.field4390 < class378.field4394) {
			class378.field4398[++class378.field4390 - 1] = var0;
		} else if (5000 == var0.length && class378.field4397 < class378.field4395) {
			class378.field4388[++class378.field4397 - 1] = var0;
		} else if (var0.length == 10000 && class378.field4392 < class378.field4396) {
			class378.field4403[++class378.field4392 - 1] = var0;
		} else if (30000 == var0.length && class378.field4393 < class378.field4401) {
			class378.field4399[++class378.field4393 - 1] = var0;
		} else {
			if (null != class359.field4312) {
				for (int var2 = 0; var2 < class229.field2738.length; ++var2) {
					if (var0.length == class229.field2738[var2] && class258.field2960[var2] < class359.field4312[var2].length) {
						class359.field4312[var2][class258.field2960[var2]++] = var0;
						return;
					}
				}
			}

		}
	}

	public int[] method3896() {
		int[] var2 = new int[this.field2320];

		for (int var3 = 0; var3 < this.field2320; ++var3) {
			var2[var3] = this.field2325[var3];
		}

		return var2;
	}

	static boolean method3926(char var0) {
		return class75.field641.indexOf(var0) != -1;
	}
}
