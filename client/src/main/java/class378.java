import java.util.ArrayList;
import java.util.HashMap;

public class class378 {
	public static ArrayList field4402;
	static byte[][] field4388;
	static byte[][] field4398;
	static byte[][] field4399;
	static byte[][] field4403;
	static int field4390;
	static int field4392;
	static int field4393;
	static int field4394;
	static int field4395;
	static int field4396;
	static int field4397;
	static int field4401;

	static {
		field4390 = 0;
		field4397 = 0;
		field4392 = 0;
		field4393 = 0;
		field4394 = 1000;
		field4395 = 250;
		field4396 = 100;
		field4401 = 50;
		field4398 = new byte[1000][];
		field4388 = new byte[250][];
		field4403 = new byte[100][];
		field4399 = new byte[50][];
		field4402 = new ArrayList();
		method6183();
		new HashMap();
	}

	class378() throws Throwable {
		throw new Error();
	}

	public static void method6183() {
		field4402.clear();
		field4402.add(100);
		field4402.add(5000);
		field4402.add(10000);
		field4402.add(30000);
	}

	static synchronized byte[] method6793(int var0, boolean var1) {
		byte[] var3;
		if ((100 == var0 || var0 < 100 && var1) && field4390 > 0) {
			var3 = field4398[--field4390];
			field4398[field4390] = null;
			return var3;
		} else if ((var0 == 5000 || var0 < 5000 && var1) && field4397 > 0) {
			var3 = field4388[--field4397];
			field4388[field4397] = null;
			return var3;
		} else if ((var0 == 10000 || var0 < 10000 && var1) && field4392 > 0) {
			var3 = field4403[--field4392];
			field4403[field4392] = null;
			return var3;
		} else if ((30000 == var0 || var0 < 30000 && var1) && field4393 > 0) {
			var3 = field4399[--field4393];
			field4399[field4393] = null;
			return var3;
		} else {
			int var5;
			if (null != class359.field4312) {
				for (var5 = 0; var5 < class229.field2738.length; ++var5) {
					if ((class229.field2738[var5] == var0 || var0 < class229.field2738[var5] && var1) && class258.field2960[var5] > 0) {
						byte[] var4 = class359.field4312[var5][--class258.field2960[var5]];
						class359.field4312[var5][class258.field2960[var5]] = null;
						return var4;
					}
				}
			}

			if (var1 && null != class229.field2738) {
				for (var5 = 0; var5 < class229.field2738.length; ++var5) {
					if (var0 <= class229.field2738[var5] && class258.field2960[var5] < class359.field4312[var5].length) {
						return new byte[class229.field2738[var5]];
					}
				}
			}

			return new byte[var0];
		}
	}

	public static synchronized byte[] method765(int var0) {
		return method6793(var0, false);
	}

	public static class376 method6805(class319 var0, class319 var1, int var2, int var3) {
		byte[] var6 = var0.method6175(var2, var3);
		boolean var5;
		if (null == var6) {
			var5 = false;
		} else {
			class317.method6080(var6);
			var5 = true;
		}

		if (!var5) {
			return null;
		} else {
			byte[] var7 = var1.method6175(var2, var3);
			class376 var9;
			if (null == var7) {
				var9 = null;
			} else {
				class376 var8 = new class376(var7, class450.field4840, class315.field3720, class467.field4921, class475.field4966, class475.field4970, class451.field4844);
				class450.field4840 = null;
				class315.field3720 = null;
				class467.field4921 = null;
				class475.field4966 = null;
				class475.field4970 = null;
				class451.field4844 = (byte[][])null;
				var9 = var8;
			}

			return var9;
		}
	}

	static final void method6804(int var0) {
		if (class246.method4928(var0)) {
			class73.method1486(class300.field3593[var0], -1);
		}
	}
}
