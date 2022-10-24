public class class234 {
	public static boolean field2774;
	public static boolean field2778;
	public static int field2767;
	public static int field2768;
	public static int field2771;
	public static long[] field2766;
	static class463 field2779;
	static int field2770;
	static int field2772;
	static int field2773;
	static int field2775;

	static {
		field2778 = false;
		field2767 = 0;
		field2768 = 0;
		field2774 = false;
		field2771 = 0;
		field2766 = new long[1000];
	}

	class234() throws Throwable {
		throw new Error();
	}

	public static int method1116() {
		return field2771;
	}

	static boolean method1417(long var0) {
		int var2 = (int)(var0 >>> 14 & 3L);
		return var2 == 2;
	}

	public static boolean method5519(long var0) {
		boolean var2 = var0 != 0L;
		if (var2) {
			boolean var3 = 1 == (int)(var0 >>> 16 & 1L);
			var2 = !var3;
		}

		return var2;
	}

	public static int method7552(long var0) {
		return (int)(var0 >>> 0 & 127L);
	}

	public static int method134(int var0) {
		return method3636(field2766[var0]);
	}

	public static int method3636(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	public static int method1610(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	static final boolean method2212() {
		return field2778;
	}

	static final int method5046() {
		return field2767;
	}
}
