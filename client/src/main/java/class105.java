public class class105 extends class393 {
	public static class319 field1044;
	static boolean field1046;
	final boolean field1045;

	public class105(boolean var1) {
		this.field1045 = var1;
	}

	int method2040(class396 var1, class396 var2) {
		if (client.worldId == var1.field4491) {
			if (client.worldId != var2.field4491) {
				return this.field1045 ? -1 : 1;
			}
		} else if (var2.field4491 == client.worldId) {
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
		if (!client.isMenuOpen) {
			if (client.menuOptionsCount < 500) {
				client.field1791[client.menuOptionsCount] = var0;
				client.field1923[client.menuOptionsCount] = var1;
				client.field1788[client.menuOptionsCount] = var2;
				client.field1789[client.menuOptionsCount] = var3;
				client.field1851[client.menuOptionsCount] = var4;
				client.field1787[client.menuOptionsCount] = var5;
				client.field1790[client.menuOptionsCount] = var6;
				client.field1916[client.menuOptionsCount] = var7;
				++client.menuOptionsCount;
			}

		}
	}
}
