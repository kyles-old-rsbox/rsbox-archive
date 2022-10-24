public class class429 {
	static final int[] field4690;
	static final int[] field4696;

	static {
		field4696 = new int[2048];
		field4690 = new int[2048];
		double var0 = 0.0030679615757712823D;

		for (int var2 = 0; var2 < 2048; ++var2) {
			field4696[var2] = (int)(65536.0D * Math.sin((double)var2 * var0));
			field4690[var2] = (int)(65536.0D * Math.cos(var0 * (double)var2));
		}

	}

	class429() throws Throwable {
		throw new Error();
	}
}
