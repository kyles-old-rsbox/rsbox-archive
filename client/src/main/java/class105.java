import client.Client;

public class class105 extends class393 {
	public static class319 field1044;
	static boolean field1046;
	final boolean field1045;

	public class105(boolean var1) {
		this.field1045 = var1;
	}

	int method2040(class396 var1, class396 var2) {
		if (Client.field1868 == var1.field4491) {
			if (Client.field1868 != var2.field4491) {
				return this.field1045 ? -1 : 1;
			}
		} else if (var2.field4491 == Client.field1868) {
			return this.field1045 ? 1 : -1;
		}

		return this.method7162(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.method2040((class396)var1, (class396)var2);
	}

	static final void method2047(int var0, int var1, int var2, int var3) {
		for (int var5 = 0; var5 < Client.field1858; ++var5) {
			if (Client.field1710[var5] + Client.field1863[var5] > var0 && Client.field1863[var5] < var0 + var2 && Client.field1658[var5] + Client.field1864[var5] > var1 && Client.field1864[var5] < var1 + var3) {
				Client.field1861[var5] = true;
			}
		}

	}

	static final void method2042(String var0, String var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		if (!Client.field1784) {
			if (Client.field1695 < 500) {
				Client.field1791[Client.field1695] = var0;
				Client.field1923[Client.field1695] = var1;
				Client.field1788[Client.field1695] = var2;
				Client.field1789[Client.field1695] = var3;
				Client.field1851[Client.field1695] = var4;
				Client.field1787[Client.field1695] = var5;
				Client.field1790[Client.field1695] = var6;
				Client.field1916[Client.field1695] = var7;
				++Client.field1695;
			}

		}
	}
}
