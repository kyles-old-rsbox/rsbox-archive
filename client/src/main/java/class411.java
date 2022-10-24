import java.net.URL;

public class class411 implements class432 {
	public final class417 field4557;

	public class411(class399 var1) {
		this(new class456(var1));
	}

	class411(class456 var1) {
		this.field4557 = var1;
	}

	public int method7412(int var1) {
		return this.field4557.method7569(var1);
	}

	static boolean method7411(String var0, int var1, String var2) {
		boolean var10000;
		if (var1 == 0) {
			try {
				if (!class30.field157.startsWith("win")) {
					throw new Exception();
				}

				if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
					throw new Exception();
				}

				String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

				for (int var5 = 0; var5 < var0.length(); ++var5) {
					if (var11.indexOf(var0.charAt(var5)) == -1) {
						throw new Exception();
					}
				}

				Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
				var10000 = true;
			} catch (Throwable var10) {
				return false;
			}

			return var10000;
		} else if (var1 == 1) {
			try {
				Object var4 = class40.method760(class30.field156, var2, new Object[]{(new URL(class30.field156.getCodeBase(), var0)).toString()});
				var10000 = null != var4;
			} catch (Throwable var6) {
				return false;
			}

			return var10000;
		} else if (var1 == 2) {
			try {
				class30.field156.getAppletContext().showDocument(new URL(class30.field156.getCodeBase(), var0), "_blank");
				var10000 = true;
			} catch (Exception var7) {
				return false;
			}

			return var10000;
		} else if (3 == var1) {
			try {
				class40.method756(class30.field156, "loggedout");
			} catch (Throwable var9) {
			}

			try {
				class30.field156.getAppletContext().showDocument(new URL(class30.field156.getCodeBase(), var0), "_top");
				var10000 = true;
			} catch (Exception var8) {
				return false;
			}

			return var10000;
		} else {
			throw new IllegalArgumentException();
		}
	}
}
