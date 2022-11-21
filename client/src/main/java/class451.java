public class class451 implements class360 {
	public static final class451 field4842;
	public static final class451 field4848;
	public static final class451 field4850;
	static byte[][] field4844;
	static class38 field4849;
	final class443 field4843;
	public final int field4845;
	public final int field4846;
	public final Class field4847;

	static {
		field4848 = new class451(0, 0, Integer.class, new class467());
		field4842 = new class451(2, 1, Long.class, new class465());
		field4850 = new class451(1, 2, String.class, new class454());
	}

	public static class184 method7975(int var0) {
		class184 var2 = (class184)class184.field1947.method5439((long)var0);
		if (var2 != null) {
			return var2;
		} else {
			byte[] var3 = class326.field3804.method6175(14, var0);
			var2 = new class184();
			if (null != var3) {
				var2.method3405(new Buffer(var3));
			}

			class184.field1947.method5434(var2, (long)var0);
			return var2;
		}
	}

	static class78 method7977(int var0, int var1) {
		class78 var3 = (class78)class78.field675.method5439((long)(var0 << 16));
		if (null != var3) {
			return var3;
		} else {
			String var4 = String.valueOf(var0);
			int var5 = class202.field2255.getGroupId(var4);
			if (var5 == -1) {
				return null;
			} else {
				byte[] var6 = class202.field2255.method6103(var5);
				if (null != var6) {
					if (var6.length <= 1) {
						return null;
					}

					var3 = class31.method597(var6);
					if (var3 != null) {
						class78.field675.method5434(var3, (long)(var0 << 16));
						return var3;
					}
				}

				return null;
			}
		}
	}

	public static class451[] method7984() {
		return new class451[]{field4850, field4842, field4848};
	}

	class451(int var1, int var2, Class var3, class443 var4) {
		this.field4845 = var1;
		this.field4846 = var2;
		this.field4847 = var3;
		this.field4843 = var4;
	}

	public static class451 method7973(Class var0) {
		class451[] var2 = method7984();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class451 var4 = var2[var3];
			if (var4.field4847 == var0) {
				return var4;
			}
		}

		return null;
	}

	public static void method7981(Object var0, Buffer var1) {
		Class var4 = var0.getClass();
		class451 var5 = method7973(var4);
		if (null == var5) {
			throw new IllegalArgumentException();
		} else {
			class443 var3 = var5.field4843;
			var3.method7924(var0, var1);
		}
	}

	public int rsOrdinal() {
		return this.field4846;
	}

	public Object method7974(Buffer var1) {
		return this.field4843.method7925(var1);
	}

	static boolean method7972() {
		return 0 != (client.field1768 & 8);
	}
}
