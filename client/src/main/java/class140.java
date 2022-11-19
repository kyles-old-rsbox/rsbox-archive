import client.Client;

public abstract class class140 extends class427 {
	class140() {
	}

	static String method2473(String var0, boolean var1) {
		String var3 = var1 ? "https://" : "http://";
		if (1 == Client.field1911) {
			var0 = var0 + "-wtrc";
		} else if (2 == Client.field1911) {
			var0 = var0 + "-wtqa";
		} else if (3 == Client.field1911) {
			var0 = var0 + "-wtwip";
		} else if (Client.field1911 == 5) {
			var0 = var0 + "-wti";
		} else if (Client.field1911 == 4) {
			var0 = "local";
		}

		String var4 = "";
		if (null != class61.field481) {
			var4 = "/p=" + class61.field481;
		}

		String var5 = "runescape.com";
		return var3 + var0 + "." + var5 + "/l=" + class94.field940 + "/a=" + class11.field45 + var4 + "/";
	}

	abstract void method2467(class460 var1);

	abstract void method2468(class148 var1);
}
