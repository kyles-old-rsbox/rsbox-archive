import java.util.zip.CRC32;

public class class336 extends class319 {
	static CRC32 field3879;
	boolean field3876;
	class392 field3874;
	class392 field3877;
	int field3869;
	int field3875;
	int field3881;
	int field3882;
	public boolean field3883;
	volatile boolean[] field3878;
	volatile int field3880;

	static {
		field3879 = new CRC32();
	}

	public class336(class392 var1, class392 var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
		super(var4, var5);
		this.field3880 = 0;
		this.field3876 = false;
		this.field3882 = -1;
		this.field3883 = false;
		this.field3877 = var1;
		this.field3874 = var2;
		this.field3875 = var3;
		this.field3876 = var6;
		this.field3883 = var7;
		class53.method1092(this, this.field3875);
	}

	public boolean method6273() {
		return 1 == this.field3880;
	}

	public int method6274() {
		if (1 == this.field3880 || this.field3883 && this.field3880 == 2) {
			return 100;
		} else if (null != super.field3743) {
			return 99;
		} else {
			int var2 = class208.method3984(255, this.field3875);
			if (var2 >= 100) {
				var2 = 99;
			}

			return var2;
		}
	}

	void method6133(int var1) {
		class64.method1377(this.field3875, var1);
	}

	void method6094(int var1) {
		if (null != this.field3877 && this.field3878 != null && this.field3878[var1]) {
			class392 var3 = this.field3877;
			byte[] var5 = null;
			synchronized(class322.field3759) {
				for (class334 var7 = (class334)class322.field3759.method6364(); null != var7; var7 = (class334)class322.field3759.method6358()) {
					if (var7.field4681 == (long)var1 && var3 == var7.field3862 && var7.field3860 == 0) {
						var5 = var7.field3861;
						break;
					}
				}
			}

			if (var5 != null) {
				this.method6279(var3, var1, var5, true);
			} else {
				byte[] var6 = var3.method7144(var1);
				this.method6279(var3, var1, var6, true);
			}
		} else {
			class169.method2714(this, this.field3875, var1, super.field3737[var1], (byte)2, true);
		}

	}

	public void method6281() {
		this.field3880 = 2;
		super.field3734 = new int[0];
		super.field3737 = new int[0];
		super.field3738 = new int[0];
		super.field3733 = new int[0];
		super.field3740 = new int[0][];
		super.field3743 = new Object[0];
		super.field3747 = new Object[0][];
	}

	public void method6298(int var1, int var2) {
		this.field3869 = var1;
		this.field3881 = var2;
		if (this.field3874 != null) {
			int var4 = this.field3875;
			class392 var5 = this.field3874;
			byte[] var7 = null;
			synchronized(class322.field3759) {
				for (class334 var9 = (class334)class322.field3759.method6364(); var9 != null; var9 = (class334)class322.field3759.method6358()) {
					if (var9.field4681 == (long)var4 && var9.field3862 == var5 && 0 == var9.field3860) {
						var7 = var9.field3861;
						break;
					}
				}
			}

			if (var7 != null) {
				this.method6279(var5, var4, var7, true);
			} else {
				byte[] var8 = var5.method7144(var4);
				this.method6279(var5, var4, var8, true);
			}
		} else {
			class169.method2714(this, 255, this.field3875, this.field3869, (byte)0, true);
		}

	}

	public void method6278(int var1, byte[] var2, boolean var3, boolean var4) {
		if (var3) {
			if (this.field3880 == 1) {
				throw new RuntimeException();
			}

			if (this.field3874 != null) {
				class88.method1863(this.field3875, var2, this.field3874);
			}

			this.method6085(var2);
			this.method6285();
		} else {
			var2[var2.length - 2] = (byte)(super.field3738[var1] >> 8);
			var2[var2.length - 1] = (byte)super.field3738[var1];
			if (null != this.field3877) {
				class88.method1863(var1, var2, this.field3877);
				this.field3878[var1] = true;
			}

			if (var4) {
				super.field3743[var1] = class142.method2479(var2, false);
			}
		}

	}

	void method6279(class392 var1, int var2, byte[] var3, boolean var4) {
		int var6;
		if (this.field3874 == var1) {
			if (this.field3880 == 1) {
				throw new RuntimeException();
			} else if (var3 == null) {
				class169.method2714(this, 255, this.field3875, this.field3869, (byte)0, true);
			} else {
				field3879.reset();
				field3879.update(var3, 0, var3.length);
				var6 = (int)field3879.getValue();
				if (this.field3869 != var6) {
					class169.method2714(this, 255, this.field3875, this.field3869, (byte)0, true);
				} else {
					class460 var7 = new class460(class231.method4537(var3));
					int var8 = var7.method8141();
					if (var8 != 5 && var8 != 6) {
						throw new RuntimeException(var8 + "," + this.field3875 + "," + var2);
					} else {
						int var9 = 0;
						if (var8 >= 6) {
							var9 = var7.method8126();
						}

						if (this.field3881 != var9) {
							class169.method2714(this, 255, this.field3875, this.field3869, (byte)0, true);
						} else {
							this.method6085(var3);
							this.method6285();
						}
					}
				}
			}
		} else {
			if (!var4 && var2 == this.field3882) {
				this.field3880 = 1;
			}

			if (null != var3 && var3.length > 2) {
				field3879.reset();
				field3879.update(var3, 0, var3.length - 2);
				var6 = (int)field3879.getValue();
				int var10 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
				if (super.field3737[var2] == var6 && var10 == super.field3738[var2]) {
					this.field3878[var2] = true;
					if (var4) {
						super.field3743[var2] = class142.method2479(var3, false);
					}

				} else {
					this.field3878[var2] = false;
					if (this.field3876 || var4) {
						class169.method2714(this, this.field3875, var2, super.field3737[var2], (byte)2, var4);
					}

				}
			} else {
				this.field3878[var2] = false;
				if (this.field3876 || var4) {
					class169.method2714(this, this.field3875, var2, super.field3737[var2], (byte)2, var4);
				}

			}
		}
	}

	void method6285() {
		this.field3878 = new boolean[super.field3743.length];

		int var2;
		for (var2 = 0; var2 < this.field3878.length; ++var2) {
			this.field3878[var2] = false;
		}

		if (null == this.field3877) {
			this.field3880 = 1;
		} else {
			this.field3882 = -1;

			for (var2 = 0; var2 < this.field3878.length; ++var2) {
				if (super.field3733[var2] > 0) {
					class295.method5524(var2, this.field3877, this);
					this.field3882 = var2;
				}
			}

			if (this.field3882 == -1) {
				this.field3880 = 1;
			}

		}
	}

	int method6159(int var1) {
		if (null != super.field3743[var1]) {
			return 100;
		} else {
			return this.field3878[var1] ? 100 : class208.method3984(this.field3875, var1);
		}
	}

	public boolean method6280(int var1) {
		return this.field3878[var1];
	}

	public boolean method6276(int var1) {
		return this.method6098(var1) != null;
	}

	public int method6303() {
		int var2 = 0;
		int var3 = 0;

		int var4;
		for (var4 = 0; var4 < super.field3743.length; ++var4) {
			if (super.field3733[var4] > 0) {
				var2 += 100;
				var3 += this.method6159(var4);
			}
		}

		if (var2 == 0) {
			return 100;
		} else {
			var4 = var3 * 100 / var2;
			return var4;
		}
	}

	static void method6282(int var0, int var1) {
		int[] var3 = new int[9];

		for (int var4 = 0; var4 < var3.length; ++var4) {
			int var5 = 15 + 128 + var4 * 32;
			int var6 = client.method3449(var5);
			int var7 = class221.field2644[var5];
			int var9 = var1 - 334;
			if (var9 < 0) {
				var9 = 0;
			} else if (var9 > 100) {
				var9 = 100;
			}

			int var10 = (client.field1801 - client.field1909) * var9 / 100 + client.field1909;
			int var8 = var10 * var6 / 256;
			var3[var4] = var7 * var8 >> 16;
		}

		class214.method4157(var3, 500, 800, var0 * 334 / var1, 334);
	}
}
