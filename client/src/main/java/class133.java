import client.Client;

public class class133 {
	static Client field1257;
	static int[] field1250;
	public byte field1256;
	public class472 field1254;
	public int field1249;

	class133() {
	}

	static final void method2411() {
		class453 var1 = Client.field1778.field1076;
		var1.method8013();
		int var2 = var1.method8014(8);
		int var3;
		if (var2 < Client.field1691) {
			for (var3 = var2; var3 < Client.field1691; ++var3) {
				Client.field1770[++Client.field1769 - 1] = Client.field1692[var3];
			}
		}

		if (var2 > Client.field1691) {
			throw new RuntimeException("");
		} else {
			Client.field1691 = 0;

			for (var3 = 0; var3 < var2; ++var3) {
				int var4 = Client.field1692[var3];
				class81 var5 = Client.field1902[var4];
				int var6 = var1.method8014(1);
				if (var6 == 0) {
					Client.field1692[++Client.field1691 - 1] = var4;
					var5.field847 = Client.field1645;
				} else {
					int var7 = var1.method8014(2);
					if (var7 == 0) {
						Client.field1692[++Client.field1691 - 1] = var4;
						var5.field847 = Client.field1645;
						Client.field1694[++Client.field1693 - 1] = var4;
					} else {
						int var8;
						int var9;
						if (var7 == 1) {
							Client.field1692[++Client.field1691 - 1] = var4;
							var5.field847 = Client.field1645;
							var8 = var1.method8014(3);
							var5.method1615(var8, class197.field2114);
							var9 = var1.method8014(1);
							if (var9 == 1) {
								Client.field1694[++Client.field1693 - 1] = var4;
							}
						} else if (var7 == 2) {
							Client.field1692[++Client.field1691 - 1] = var4;
							var5.field847 = Client.field1645;
							if (var1.method8014(1) == 1) {
								var8 = var1.method8014(3);
								var5.method1615(var8, class197.field2116);
								var9 = var1.method8014(3);
								var5.method1615(var9, class197.field2116);
							} else {
								var8 = var1.method8014(3);
								var5.method1615(var8, class197.field2113);
							}

							var8 = var1.method8014(1);
							if (var8 == 1) {
								Client.field1694[++Client.field1693 - 1] = var4;
							}
						} else if (var7 == 3) {
							Client.field1770[++Client.field1769 - 1] = var4;
						}
					}
				}
			}

		}
	}
}
