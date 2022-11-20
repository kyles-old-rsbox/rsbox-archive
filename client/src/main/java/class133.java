public class class133 {
	static client field1257;
	static int[] field1250;
	public byte field1256;
	public class472 field1254;
	public int field1249;

	class133() {
	}

	static final void method2411() {
		PacketBuffer var1 = client.packetWriter.buffer;
		var1.method8013();
		int var2 = var1.method8014(8);
		int var3;
		if (var2 < client.npcCount) {
			for (var3 = var2; var3 < client.npcCount; ++var3) {
				client.field1770[++client.field1769 - 1] = client.field1692[var3];
			}
		}

		if (var2 > client.npcCount) {
			throw new RuntimeException("");
		} else {
			client.npcCount = 0;

			for (var3 = 0; var3 < var2; ++var3) {
				int var4 = client.field1692[var3];
				class81 var5 = client.npcs[var4];
				int var6 = var1.method8014(1);
				if (var6 == 0) {
					client.field1692[++client.npcCount - 1] = var4;
					var5.field847 = client.field1645;
				} else {
					int var7 = var1.method8014(2);
					if (var7 == 0) {
						client.field1692[++client.npcCount - 1] = var4;
						var5.field847 = client.field1645;
						client.field1694[++client.field1693 - 1] = var4;
					} else {
						int var8;
						int var9;
						if (var7 == 1) {
							client.field1692[++client.npcCount - 1] = var4;
							var5.field847 = client.field1645;
							var8 = var1.method8014(3);
							var5.method1615(var8, class197.field2114);
							var9 = var1.method8014(1);
							if (var9 == 1) {
								client.field1694[++client.field1693 - 1] = var4;
							}
						} else if (var7 == 2) {
							client.field1692[++client.npcCount - 1] = var4;
							var5.field847 = client.field1645;
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
								client.field1694[++client.field1693 - 1] = var4;
							}
						} else if (var7 == 3) {
							client.field1770[++client.field1769 - 1] = var4;
						}
					}
				}
			}

		}
	}
}
