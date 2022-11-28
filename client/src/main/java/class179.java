public class class179 {
	static byte[][][] field1597;
	static class408 field1602;
	static int field1601;
	public short[] field1600;
	public short[] field1603;

	public class179(int var1) {
		class198 var2 = class278.method5388(var1);
		if (var2.method3653()) {
			this.field1603 = new short[var2.field2133.length];
			System.arraycopy(var2.field2133, 0, this.field1603, 0, this.field1603.length);
		}

		if (var2.method3689()) {
			this.field1600 = new short[var2.field2135.length];
			System.arraycopy(var2.field2135, 0, this.field1600, 0, this.field1600.length);
		}

	}

	static int method2843(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.CHAT_GETFILTER_PUBLIC) {
			class57.field404[++class387.field4452 - 1] = client.field1871;
			return 1;
		} else if (var0 == CS2Opcodes.CHAT_SETFILTER) {
			class387.field4452 -= 3;
			client.field1871 = class57.field404[class387.field4452];
			class297.field3431 = class363.method6675(class57.field404[1 + class387.field4452]);
			if (null == class297.field3431) {
				class297.field3431 = class486.field5006;
			}

			client.field1872 = class57.field404[2 + class387.field4452];
			PacketMessage var12 = class185.create(ClientPacket.field3142, client.serverConnection.isaacRandom);
			var12.buffer.writeByte(client.field1871);
			var12.buffer.writeByte(class297.field3431.field5005);
			var12.buffer.writeByte(client.field1872);
			client.serverConnection.add(var12);
			return 1;
		} else {
			String var4;
			int var5;
			int var6;
			PacketMessage var7;
			if (var0 == CS2Opcodes.CHAT_SENDABUSEREPORT) {
				var4 = class57.field405[--class126.field1220];
				class387.field4452 -= 2;
				var5 = class57.field404[class387.field4452];
				var6 = class57.field404[class387.field4452 + 1];
				var7 = class185.create(ClientPacket.field3112, client.serverConnection.isaacRandom);
				var7.buffer.writeByte(Buffer.method1887(var4) + 2);
				var7.buffer.writeString(var4);
				var7.buffer.writeByte(var5 - 1);
				var7.buffer.writeByte(var6);
				client.serverConnection.add(var7);
				return 1;
			} else {
				int var8;
				class63 var9;
				if (var0 == CS2Opcodes.CHAT_GETHISTORY_BYTYPEANDLINE_OLD) {
					class387.field4452 -= 2;
					var8 = class57.field404[class387.field4452];
					var5 = class57.field404[1 + class387.field4452];
					var9 = MessagesManager.method6313(var8, var5);
					if (null != var9) {
						class57.field404[++class387.field4452 - 1] = var9.field496;
						class57.field404[++class387.field4452 - 1] = var9.field495;
						class57.field405[++class126.field1220 - 1] = null != var9.field500 ? var9.field500 : "";
						class57.field405[++class126.field1220 - 1] = var9.field498 != null ? var9.field498 : "";
						class57.field405[++class126.field1220 - 1] = var9.field503 != null ? var9.field503 : "";
						class57.field404[++class387.field4452 - 1] = var9.method1343() ? 1 : (var9.method1346() ? 2 : 0);
					} else {
						class57.field404[++class387.field4452 - 1] = -1;
						class57.field404[++class387.field4452 - 1] = 0;
						class57.field405[++class126.field1220 - 1] = "";
						class57.field405[++class126.field1220 - 1] = "";
						class57.field405[++class126.field1220 - 1] = "";
						class57.field404[++class387.field4452 - 1] = 0;
					}

					return 1;
				} else {
					class63 var10;
					if (var0 == CS2Opcodes.CHAT_GETHISTORY_BYUID_OLD) {
						var8 = class57.field404[--class387.field4452];
						var10 = MessagesManager.method204(var8);
						if (var10 != null) {
							class57.field404[++class387.field4452 - 1] = var10.field497;
							class57.field404[++class387.field4452 - 1] = var10.field495;
							class57.field405[++class126.field1220 - 1] = null != var10.field500 ? var10.field500 : "";
							class57.field405[++class126.field1220 - 1] = null != var10.field498 ? var10.field498 : "";
							class57.field405[++class126.field1220 - 1] = null != var10.field503 ? var10.field503 : "";
							class57.field404[++class387.field4452 - 1] = var10.method1343() ? 1 : (var10.method1346() ? 2 : 0);
						} else {
							class57.field404[++class387.field4452 - 1] = -1;
							class57.field404[++class387.field4452 - 1] = 0;
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field405[++class126.field1220 - 1] = "";
							class57.field404[++class387.field4452 - 1] = 0;
						}

						return 1;
					} else if (var0 == CS2Opcodes.CHAT_GETFILTER_PRIVATE) {
						if (class297.field3431 == null) {
							class57.field404[++class387.field4452 - 1] = -1;
						} else {
							class57.field404[++class387.field4452 - 1] = class297.field3431.field5005;
						}

						return 1;
					} else {
						PacketMessage var13;
						if (var0 == CS2Opcodes.CHAT_SENDPUBLIC) {
							var4 = class57.field405[--class126.field1220];
							var5 = class57.field404[--class387.field4452];
							var13 = class307.method6040(var5, var4, class94.field940, -1);
							client.serverConnection.add(var13);
							return 1;
						} else if (var0 == CS2Opcodes.CHAT_SENDPRIVATE) {
							class126.field1220 -= 2;
							var4 = class57.field405[class126.field1220];
							String var14 = class57.field405[1 + class126.field1220];
							var13 = class185.create(ClientPacket.field3120, client.serverConnection.isaacRandom);
							var13.buffer.writeShort(0);
							int var11 = var13.buffer.offset;
							var13.buffer.writeString(var4);
							class282.method5406(var13.buffer, var14);
							var13.buffer.writeLengthShort(var13.buffer.offset - var11);
							client.serverConnection.add(var13);
							return 1;
						} else if (var0 == CS2Opcodes.CHAT_SENDCLAN) {
							var4 = class57.field405[--class126.field1220];
							class387.field4452 -= 2;
							var5 = class57.field404[class387.field4452];
							var6 = class57.field404[1 + class387.field4452];
							var7 = class307.method6040(var5, var4, class94.field940, var6);
							client.serverConnection.add(var7);
							return 1;
						} else if (var0 != CS2Opcodes.CHAT_PLAYERNAME) {
							if (var0 == CS2Opcodes.CHAT_GETFILTER_TRADE) {
								class57.field404[++class387.field4452 - 1] = client.field1872;
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETHISTORYLENGTH) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class252.method5040(var8);
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETNEXTUID) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class132.method2409(var8);
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETPREVUID) {
								var8 = class57.field404[--class387.field4452];
								class57.field404[++class387.field4452 - 1] = class282.method5416(var8);
								return 1;
							} else if (var0 == CS2Opcodes.DOCHEAT) {
								var4 = class57.field405[--class126.field1220];
								class31.method506(var4);
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_SETMESSAGEFILTER) {
								client.field1873 = class57.field405[--class126.field1220].toLowerCase().trim();
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETMESSAGEFILTER) {
								class57.field405[++class126.field1220 - 1] = client.field1873;
								return 1;
							} else if (var0 == CS2Opcodes.WRITECONSOLE) {
								var4 = class57.field405[--class126.field1220];
								System.out.println(var4);
								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
								class387.field4452 -= 2;
								var8 = class57.field404[class387.field4452];
								var5 = class57.field404[class387.field4452 + 1];
								var9 = MessagesManager.method6313(var8, var5);
								if (var9 != null) {
									class57.field404[++class387.field4452 - 1] = var9.field496;
									class57.field404[++class387.field4452 - 1] = var9.field495;
									class57.field405[++class126.field1220 - 1] = null != var9.field500 ? var9.field500 : "";
									class57.field405[++class126.field1220 - 1] = null != var9.field498 ? var9.field498 : "";
									class57.field405[++class126.field1220 - 1] = var9.field503 != null ? var9.field503 : "";
									class57.field404[++class387.field4452 - 1] = var9.method1343() ? 1 : (var9.method1346() ? 2 : 0);
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								} else {
									class57.field404[++class387.field4452 - 1] = -1;
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								}

								return 1;
							} else if (var0 == CS2Opcodes.CHAT_GETHISTORY_BYUID) {
								var8 = class57.field404[--class387.field4452];
								var10 = MessagesManager.method204(var8);
								if (var10 != null) {
									class57.field404[++class387.field4452 - 1] = var10.field497;
									class57.field404[++class387.field4452 - 1] = var10.field495;
									class57.field405[++class126.field1220 - 1] = var10.field500 != null ? var10.field500 : "";
									class57.field405[++class126.field1220 - 1] = null != var10.field498 ? var10.field498 : "";
									class57.field405[++class126.field1220 - 1] = null != var10.field503 ? var10.field503 : "";
									class57.field404[++class387.field4452 - 1] = var10.method1343() ? 1 : (var10.method1346() ? 2 : 0);
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								} else {
									class57.field404[++class387.field4452 - 1] = -1;
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
									class57.field405[++class126.field1220 - 1] = "";
									class57.field404[++class387.field4452 - 1] = 0;
								}

								return 1;
							} else {
								return 2;
							}
						} else {
							if (class291.localPlayer != null && null != class291.localPlayer.displayName) {
								var4 = class291.localPlayer.displayName.getName();
							} else {
								var4 = "";
							}

							class57.field405[++class126.field1220 - 1] = var4;
							return 1;
						}
					}
				}
			}
		}
	}

	static boolean method2842() {
		return client.field1796 || client.keyHandler.isKeyDown(81);
	}
}
