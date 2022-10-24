public class class253 {
	final int field2926;
	final int field2927;
	final int field2929;

	class253(int var1, int var2, int var3) {
		this.field2927 = var1;
		this.field2929 = var2;
		this.field2926 = var3;
	}

	static float method5042(class106 var0, float var1) {
		if (null == var0) {
			return 0.0F;
		} else {
			float var3 = var1 - var0.field1053;
			return var0.field1055[3] + (var0.field1055[2] + (var3 * var0.field1055[0] + var0.field1055[1]) * var3) * var3;
		}
	}

	public static class300 method5043(int var0, int var1) {
		class300 var3 = class282.method5426(var0);
		if (-1 == var1) {
			return var3;
		} else {
			return null != var3 && null != var3.field3602 && var1 < var3.field3602.length ? var3.field3602[var1] : null;
		}
	}
}
