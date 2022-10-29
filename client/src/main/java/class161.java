import java.io.File;
import java.io.IOException;

public class class161 {
	class161() throws Throwable {
		throw new Error();
	}

	public static class464 method2668(String var0, String var1, boolean var2) {
		File var4 = new File(class290.field3361, "preferences" + var0 + ".dat");
		if (var4.exists()) {
			try {
				class464 var11 = new class464(var4, "rw", 10000L);
				return var11;
			} catch (IOException var10) {
			}
		}

		String var5 = "";
		if (class163.field1511 == 33) {
			var5 = "_rc";
		} else if (class163.field1511 == 34) {
			var5 = "_wip";
		}

		File var6 = new File(class45.field328, "jagex_" + var1 + "_preferences" + var0 + var5 + ".dat");
		class464 var7;
		if (!var2 && var6.exists()) {
			try {
				var7 = new class464(var6, "rw", 10000L);
				return var7;
			} catch (IOException var9) {
			}
		}

		try {
			var7 = new class464(var4, "rw", 10000L);
			return var7;
		} catch (IOException var8) {
			throw new RuntimeException();
		}
	}
}
