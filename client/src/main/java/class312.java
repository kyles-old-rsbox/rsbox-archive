import java.net.MalformedURLException;
import java.net.URL;

public class class312 {
	static class401 field3697;
	class109 field3696;
	class473 field3695;

	class312(String var1, class115 var2) {
		try {
			this.field3696 = var2.method2222(new URL(var1));
		} catch (MalformedURLException var4) {
			this.field3696 = null;
		}

	}

	class312(class109 var1) {
		this.field3696 = var1;
	}

	class473 method6058() {
		if (null == this.field3695 && null != this.field3696 && this.field3696.method2102()) {
			if (this.field3696.method2115() != null) {
				this.field3695 = class32.method712(this.field3696.method2115());
			}

			this.field3696 = null;
		}

		return this.field3695;
	}

	public static int method6062(int var0) {
		if (var0 > 0) {
			return 1;
		} else {
			return var0 < 0 ? -1 : 0;
		}
	}

	static void method6063(String var0, boolean var1) {
		var0 = var0.toLowerCase();
		short[] var3 = new short[16];
		int var4 = 0;

		for (int var5 = 0; var5 < class435.field4713; ++var5) {
			class198 var6 = class278.method5388(var5);
			if ((!var1 || var6.field2175) && -1 == var6.field2166 && var6.field2131.toLowerCase().indexOf(var0) != -1) {
				if (var4 >= 250) {
					class157.field1437 = -1;
					class102.field1009 = null;
					return;
				}

				if (var4 >= var3.length) {
					short[] var7 = new short[2 * var3.length];

					for (int var8 = 0; var8 < var4; ++var8) {
						var7[var8] = var3[var8];
					}

					var3 = var7;
				}

				var3[var4++] = (short)var5;
			}
		}

		class102.field1009 = var3;
		class369.field4362 = 0;
		class157.field1437 = var4;
		String[] var9 = new String[class157.field1437];

		for (int var10 = 0; var10 < class157.field1437; ++var10) {
			var9[var10] = class278.method5388(var3[var10]).field2131;
		}

		class446.method7363(var9, class102.field1009);
	}
}
