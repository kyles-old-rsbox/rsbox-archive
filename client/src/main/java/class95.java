public class class95 {
	static boolean field944;

	public static String method1955(String var0) {
		StringBuilder var2 = new StringBuilder(var0.length());
		int var3 = 0;
		int var4 = -1;

		for (int var5 = 0; var5 < var0.length(); ++var5) {
			char var6 = var0.charAt(var5);
			if (var6 == '<') {
				var2.append(var0.substring(var3, var5));
				var4 = var5;
			} else if (var6 == '>' && var4 != -1) {
				String var7 = var0.substring(var4 + 1, var5);
				var4 = -1;
				if (var7.equals("lt")) {
					var2.append("<");
				} else if (var7.equals("gt")) {
					var2.append(">");
				} else if (var7.equals("br")) {
					var2.append("\n");
				}

				var3 = var5 + 1;
			}
		}

		if (var3 < var0.length()) {
			var2.append(var0.substring(var3, var0.length()));
		}

		return var2.toString();
	}

	class95() throws Throwable {
		throw new Error();
	}
}
