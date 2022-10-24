import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class class185 extends class437 {
	public static class284 field1956;
	public static class319 field1954;
	int field1955;
	public int field1953;
	public int field1957;
	public int field1958;
	public int field1959;

	public class185() {
		this.field1955 = 0;
	}

	static {
		field1956 = new class284(64);
	}

	public static void method5209(class319 var0) {
		field1954 = var0;
	}

	public void method3413() {
		this.method3431(this.field1955);
	}

	public static class263 method3435(class274 var0, class479 var1) {
		class263 var3 = class210.method4096();
		var3.field2989 = var0;
		var3.field2985 = var0.field3148;
		if (var3.field2985 == -1) {
			var3.field2984 = new class453(260);
		} else if (var3.field2985 == -2) {
			var3.field2984 = new class453(10000);
		} else if (var3.field2985 <= 18) {
			var3.field2984 = new class453(20);
		} else if (var3.field2985 <= 98) {
			var3.field2984 = new class453(100);
		} else {
			var3.field2984 = new class453(260);
		}

		var3.field2984.method8025(var1);
		var3.field2984.method8008(var3.field2989.field3147);
		var3.field2987 = 0;
		return var3;
	}

	public void method3414(class460 var1, int var2) {
		while (true) {
			int var4 = var1.method8141();
			if (0 == var4) {
				return;
			}

			this.method3415(var1, var4, var2);
		}
	}

	void method3415(class460 var1, int var2, int var3) {
		if (1 == var2) {
			this.field1955 = var1.method8312();
		}

	}

	void method3431(int var1) {
		double var3 = (double)(var1 >> 16 & 255) / 256.0D;
		double var5 = (double)(var1 >> 8 & 255) / 256.0D;
		double var7 = (double)(var1 & 255) / 256.0D;
		double var9 = var3;
		if (var5 < var3) {
			var9 = var5;
		}

		if (var7 < var9) {
			var9 = var7;
		}

		double var11 = var3;
		if (var5 > var3) {
			var11 = var5;
		}

		if (var7 > var11) {
			var11 = var7;
		}

		double var13 = 0.0D;
		double var15 = 0.0D;
		double var17 = (var9 + var11) / 2.0D;
		if (var11 != var9) {
			if (var17 < 0.5D) {
				var15 = (var11 - var9) / (var11 + var9);
			}

			if (var17 >= 0.5D) {
				var15 = (var11 - var9) / (2.0D - var11 - var9);
			}

			if (var3 == var11) {
				var13 = (var5 - var7) / (var11 - var9);
			} else if (var5 == var11) {
				var13 = 2.0D + (var7 - var3) / (var11 - var9);
			} else if (var7 == var11) {
				var13 = (var3 - var5) / (var11 - var9) + 4.0D;
			}
		}

		var13 /= 6.0D;
		this.field1957 = (int)(var15 * 256.0D);
		this.field1958 = (int)(var17 * 256.0D);
		if (this.field1957 < 0) {
			this.field1957 = 0;
		} else if (this.field1957 > 255) {
			this.field1957 = 255;
		}

		if (this.field1958 < 0) {
			this.field1958 = 0;
		} else if (this.field1958 > 255) {
			this.field1958 = 255;
		}

		if (var17 > 0.5D) {
			this.field1959 = (int)((1.0D - var17) * var15 * 512.0D);
		} else {
			this.field1959 = (int)(var15 * var17 * 512.0D);
		}

		if (this.field1959 < 1) {
			this.field1959 = 1;
		}

		this.field1953 = (int)((double)this.field1959 * var13);
	}

	public static void method2597() {
		field1956.method5437();
	}

	static boolean method3433() {
		Date var1;
		try {
			var1 = class200.method3762();
		} catch (ParseException var10) {
			class74.method1490(7);
			class75.method5452("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
			return false;
		}

		if (var1 == null) {
			return false;
		} else {
			Calendar var3 = Calendar.getInstance();
			var3.set(1, var3.get(1) - 13);
			var3.set(5, var3.get(5) + 1);
			var3.set(11, 0);
			var3.set(12, 0);
			var3.set(13, 0);
			var3.set(14, 0);
			Date var4 = var3.getTime();
			boolean var6 = var1.before(var4);
			Date var5 = class75.method2497();
			boolean var8 = var1.after(var5);
			if (!var8) {
				class74.method1490(7);
				class75.method5452("Date not valid.", "Please ensure date follows the format", "DD/MM/YYYY and is after 01/01/1900");
				return false;
			} else {
				if (!var6) {
					class158.field1451 = 8388607;
				} else {
					class158.field1451 = (int)(var1.getTime() / 86400000L - 11745L);
				}

				return true;
			}
		}
	}
}
