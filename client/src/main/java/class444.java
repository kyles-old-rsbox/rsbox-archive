public class class444 {
	static class407 field4785;
	static final int field4783;
	static final int field4784;

	static {
		field4783 = (int)(Math.pow(2.0D, 4.0D) - 1.0D);
		field4784 = (int)(Math.pow(2.0D, 8.0D) - 1.0D);
	}

	class444() throws Throwable {
		throw new Error();
	}

	public static int method7142(int var0) {
		return var0 >>> 12;
	}

	public static int method6199(int var0) {
		return var0 >>> 4 & field4784;
	}

	public static int method1425(int var0) {
		return (var0 & field4783) - 1;
	}
}
