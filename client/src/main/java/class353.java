import java.util.Locale;

@class356
@class308
public class class353 implements class360 {
	public static final class353 field4292;
	public static final class353 field4294;
	public static final class353 field4303;
	static class376 field4289;
	static final class353 field4288;
	static final class353 field4290;
	static final class353 field4291;
	static final class353 field4293;
	static final class353[] field4297;
	final int field4299;
	final String field4287;
	final String field4296;

	static {
		field4303 = new class353("EN", "en", "English", class346.field4242, 0, "GB");
		field4288 = new class353("DE", "de", "German", class346.field4242, 1, "DE");
		field4294 = new class353("FR", "fr", "French", class346.field4242, 2, "FR");
		field4290 = new class353("PT", "pt", "Portuguese", class346.field4242, 3, "BR");
		field4291 = new class353("NL", "nl", "Dutch", class346.field4236, 4, "NL");
		field4292 = new class353("ES", "es", "Spanish", class346.field4236, 5, "ES");
		field4293 = new class353("ES_MX", "es-mx", "Spanish (Latin American)", class346.field4242, 6, "MX");
		class353[] var0 = method6553();
		field4297 = new class353[var0.length];
		class353[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			class353 var3 = var1[var2];
			if (null != field4297[var3.field4299]) {
				throw new IllegalStateException();
			}

			field4297[var3.field4299] = var3;
		}

	}

	static int method6569(class421 var0, int var1, int var2) {
		if (null == var0) {
			return var2;
		} else {
			class426 var4 = (class426)var0.method7788((long)var1);
			return var4 == null ? var2 : var4.field4680;
		}
	}

	static class353[] method6553() {
		return new class353[]{field4294, field4303, field4290, field4291, field4293, field4292, field4288};
	}

	class353(String var1, String var2, String var3, class346 var4, int var5, String var6) {
		this.field4287 = var1;
		this.field4296 = var2;
		this.field4299 = var5;
		if (var6 != null) {
			new Locale(var2.substring(0, 2), var6);
		} else {
			new Locale(var2.substring(0, 2));
		}

	}

	String method6552() {
		return this.field4296;
	}

	public int rsOrdinal() {
		return this.field4299;
	}

	public static class353 method6565(int var0) {
		return var0 >= 0 && var0 < field4297.length ? field4297[var0] : null;
	}

	public String toString() {
		return this.method6552().toLowerCase(Locale.ENGLISH);
	}

	static void method6567(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
		if (var0 < var1) {
			int var7 = (var1 + var0) / 2;
			int var8 = var0;
			class72 var9 = class399.field4502[var7];
			class399.field4502[var7] = class399.field4502[var1];
			class399.field4502[var1] = var9;

			for (int var10 = var0; var10 < var1; ++var10) {
				if (class207.method3983(class399.field4502[var10], var9, var2, var3, var4, var5) <= 0) {
					class72 var11 = class399.field4502[var10];
					class399.field4502[var10] = class399.field4502[var8];
					class399.field4502[var8++] = var11;
				}
			}

			class399.field4502[var1] = class399.field4502[var8];
			class399.field4502[var8] = var9;
			method6567(var0, var8 - 1, var2, var3, var4, var5);
			method6567(var8 + 1, var1, var2, var3, var4, var5);
		}

	}

	static void method6566() {
		if (client.field1739) {
			class17.method200(class291.localPlayer, false);
		}

	}
}
