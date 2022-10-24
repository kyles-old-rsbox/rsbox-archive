public class class210 {
	public static final class210 field2456;
	public static final class210 field2457;
	public static final class210 field2459;
	static class473[] field2462;
	final int field2458;
	final int field2460;
	final int field2461;

	static {
		field2456 = new class210(0, 0, 4);
		field2457 = new class210(2, 1, 2);
		field2459 = new class210(1, 2, 0);
	}

	static class210[] method4107() {
		return new class210[]{field2459, field2457, field2456};
	}

	class210(int var1, int var2, int var3) {
		this.field2458 = var1;
		this.field2460 = var2;
		this.field2461 = var3;
	}

	static class263 method4096() {
		return 0 == class263.field2988 ? new class263() : class263.field2986[--class263.field2988];
	}

	boolean method4098(float var1) {
		return var1 >= (float)this.field2461;
	}

	static class210 method4099(int var0) {
		class210[] var2 = method4107();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class210 var4 = var2[var3];
			if (var0 == var4.field2460) {
				return var4;
			}
		}

		return null;
	}
}
