import java.util.Iterator;
import java.util.LinkedHashMap;

public class class49 {
	public static int field348;
	class319 field346;
	class319 field350;
	class434 field347;
	class434 field351;

	public class49(class319 var1, class319 var2) {
		this.field347 = new class434(256);
		this.field351 = new class434(256);
		this.field350 = var1;
		this.field346 = var2;
	}

	class39 method989(int var1, int var2, int[] var3) {
		int var5 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var5 |= var1 << 16;
		long var6 = (long)var5;
		class39 var8 = (class39)this.field351.method7855(var6);
		if (null != var8) {
			return var8;
		} else if (null != var3 && var3[0] <= 0) {
			return null;
		} else {
			class33 var9 = class33.method610(this.field350, var1, var2);
			if (var9 == null) {
				return null;
			} else {
				var8 = var9.method605();
				this.field351.method7857(var8, var6);
				if (null != var3) {
					var3[0] -= var8.field258.length;
				}

				return var8;
			}
		}
	}

	class39 method987(int var1, int var2, int[] var3) {
		int var5 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
		var5 |= var1 << 16;
		long var6 = (long)var5 ^ 4294967296L;
		class39 var8 = (class39)this.field351.method7855(var6);
		if (var8 != null) {
			return var8;
		} else if (null != var3 && var3[0] <= 0) {
			return null;
		} else {
			class60 var9 = (class60)this.field347.method7855(var6);
			if (null == var9) {
				var9 = class60.method1324(this.field346, var1, var2);
				if (var9 == null) {
					return null;
				}

				this.field347.method7857(var9, var6);
			}

			var8 = var9.method1305(var3);
			if (null == var8) {
				return null;
			} else {
				var9.method7825();
				this.field351.method7857(var8, var6);
				return var8;
			}
		}
	}

	public class39 method988(int var1, int[] var2) {
		if (this.field350.method6100() == 1) {
			return this.method989(0, var1, var2);
		} else if (this.field350.method6099(var1) == 1) {
			return this.method989(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	static void method1000() {
		Iterator var1 = class110.field1089.iterator();

		while (var1.hasNext()) {
			class63 var2 = (class63)var1.next();
			var2.method1345();
		}

	}

	public class39 method985(int var1, int[] var2) {
		if (this.field346.method6100() == 1) {
			return this.method987(0, var1, var2);
		} else if (this.field346.method6099(var1) == 1) {
			return this.method987(var1, 0, var2);
		} else {
			throw new RuntimeException();
		}
	}

	static final void method996(boolean var0) {
		if (var0) {
			client.field1671 = class75.field621 ? class141.field1306 : class141.field1303;
		} else {
			LinkedHashMap var2 = class413.field4575.field744;
			String var4 = class75.field633;
			int var5 = var4.length();
			int var6 = 0;

			for (int var7 = 0; var7 < var5; ++var7) {
				var6 = (var6 << 5) - var6 + var4.charAt(var7);
			}

			client.field1671 = var2.containsKey(var6) ? class141.field1302 : class141.field1301;
		}

	}
}
