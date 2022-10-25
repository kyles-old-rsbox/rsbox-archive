public class class105 extends class393 {
	public static class319 field1044;
	static boolean field1046;
	final boolean field1045;

	public class105(boolean var1) {
		this.field1045 = var1;
	}

	int method2040(class396 var1, class396 var2) {
		if (client.field1868 == var1.field4491) {
			if (client.field1868 != var2.field4491) {
				return this.field1045 ? -1 : 1;
			}
		} else if (var2.field4491 == client.field1868) {
			return this.field1045 ? 1 : -1;
		}

		return this.method7162(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.method2040((class396)var1, (class396)var2);
	}

	static final void method2047(int var0, int var1, int var2, int var3) {
		for (int var5 = 0; var5 < client.field1858; ++var5) {
			if (client.field1710[var5] + client.field1863[var5] > var0 && client.field1863[var5] < var0 + var2 && client.field1658[var5] + client.field1864[var5] > var1 && client.field1864[var5] < var1 + var3) {
				client.field1861[var5] = true;
			}
		}

	}

	static final void method2042(String var0, String var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		if (!client.field1784) {
			if (client.field1695 < 500) {
				client.menuActions[client.field1695] = var0;
				client.menuTargets[client.field1695] = var1;
				client.menuActionOpcodes[client.field1695] = var2;
				client.menuIdentifiers[client.field1695] = var3;
				client.menuArguments1[client.field1695] = var4;
				client.menuArguments2[client.field1695] = var5;
				client.field1790[client.field1695] = var6;
				client.field1916[client.field1695] = var7;
				++client.field1695;
			}

		}
	}
}
