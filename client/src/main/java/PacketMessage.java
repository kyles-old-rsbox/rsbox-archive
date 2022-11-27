public class PacketMessage extends class427 {
	static PacketMessage[] field2986;
	static int field2988;
	ClientPacket field2989;
	int field2985;
	public PacketBuffer buffer;
	public int field2987;

	static {
		field2986 = new PacketMessage[300];
		field2988 = 0;
	}

	PacketMessage() {
	}

	public static PacketMessage create() {
		PacketMessage var1 = class210.method4096();
		var1.field2989 = null;
		var1.field2985 = 0;
		var1.buffer = new PacketBuffer(5000);
		return var1;
	}

	public void method5153() {
		if (field2988 < field2986.length) {
			field2986[++field2988 - 1] = this;
		}
	}

	static final void method5159(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		class300 var10;
		if (var2 == 57 || var2 == 1007) {
			var10 = class253.method5043(var1, var0);
			if (var10 != null) {
				class272.method5220(var3, var1, var0, var4, var6);
			}
		}

		PacketMessage var12;
		class81 var15;
		if (var2 == 1003) {
			client.field1657 = var7;
			client.field1749 = var8;
			client.field1751 = 2;
			client.field1904 = 0;
			var15 = client.npcs[var3];
			if (var15 != null) {
				class203 var11 = var15.field709;
				if (null != var11.field2278) {
					var11 = var11.method3857();
				}

				if (var11 != null) {
					var12 = class185.method3435(ClientPacket.field3060, client.serverConnection.isaacRandom);
					var12.buffer.method8161(var11.field2260);
					client.serverConnection.add(var12);
				}
			}
		}

		PacketMessage var16;
		if (var2 == 31) {
			var16 = class185.method3435(ClientPacket.field3096, client.serverConnection.isaacRandom);
			var16.buffer.method8337(class6.field23);
			var16.buffer.writeIntLEAlt(class213.field2493);
			var16.buffer.writeIntLEAlt(var1);
			var16.buffer.writeShort(var0);
			var16.buffer.method8159(var4);
			var16.buffer.writeShort(class54.field385);
			client.serverConnection.add(var16);
			client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			client.field1888 = var0;
		}

		if (var2 == 1002) {
			client.field1657 = var7;
			client.field1749 = var8;
			client.field1751 = 2;
			client.field1904 = 0;
			var16 = class185.method3435(ClientPacket.field3126, client.serverConnection.isaacRandom);
			var16.buffer.writeShort(var3);
			client.serverConnection.add(var16);
		}

		PlayerEntity var17;
		PacketMessage var18;
		if (var2 == 50) {
			var17 = client.players[var3];
			if (null != var17) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var18 = class185.method3435(ClientPacket.field3089, client.serverConnection.isaacRandom);
				var18.buffer.writeShort(var3);
				var18.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 14) {
			var17 = client.players[var3];
			if (null != var17) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var18 = class185.method3435(ClientPacket.field3143, client.serverConnection.isaacRandom);
				var18.buffer.writeIntLEAlt(class213.field2493);
				var18.buffer.method8161(class6.field23);
				var18.buffer.method8161(class54.field385);
				var18.buffer.method8337(var3);
				var18.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 46) {
			var17 = client.players[var3];
			if (null != var17) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var18 = class185.method3435(ClientPacket.field3044, client.serverConnection.isaacRandom);
				var18.buffer.method8337(var3);
				var18.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 15) {
			var17 = client.players[var3];
			if (var17 != null) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var18 = class185.method3435(ClientPacket.field3145, client.serverConnection.isaacRandom);
				var18.buffer.writeIntAlt(class106.field1066);
				var18.buffer.method8159(client.field1806);
				var18.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				var18.buffer.method8337(client.field1805);
				var18.buffer.method8161(var3);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 41) {
			var16 = class185.method3435(ClientPacket.field3098, client.serverConnection.isaacRandom);
			var16.buffer.method8159(var4);
			var16.buffer.writeInt(var1);
			var16.buffer.writeShort(var0);
			client.serverConnection.add(var16);
			client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			client.field1888 = var0;
		}

		if (var2 == 47) {
			var17 = client.players[var3];
			if (null != var17) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var18 = class185.method3435(ClientPacket.field3042, client.serverConnection.isaacRandom);
				var18.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
				var18.buffer.method8159(var3);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 1004) {
			client.field1657 = var7;
			client.field1749 = var8;
			client.field1751 = 2;
			client.field1904 = 0;
			var16 = class185.method3435(ClientPacket.field3138, client.serverConnection.isaacRandom);
			var16.buffer.writeShort(var0 + class36.field241);
			var16.buffer.method8337(var3);
			var16.buffer.writeShort(class169.field1536 + var1);
			client.serverConnection.add(var16);
		}

		if (var2 == 37) {
			var16 = class185.method3435(ClientPacket.field3125, client.serverConnection.isaacRandom);
			var16.buffer.writeShort(var0);
			var16.buffer.method8161(var4);
			var16.buffer.writeIntLE(var1);
			client.serverConnection.add(var16);
			client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			client.field1888 = var0;
		}

		if (var2 == 42) {
			var16 = class185.method3435(ClientPacket.field3103, client.serverConnection.isaacRandom);
			var16.buffer.method8159(var4);
			var16.buffer.writeIntLEAlt(var1);
			var16.buffer.method8159(var0);
			client.serverConnection.add(var16);
			client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			client.field1888 = var0;
		}

		if (var2 == 40) {
			var16 = class185.method3435(ClientPacket.field3072, client.serverConnection.isaacRandom);
			var16.buffer.writeIntLEAlt(var1);
			var16.buffer.writeShort(var0);
			var16.buffer.method8161(var4);
			client.serverConnection.add(var16);
			client.field1840 = 0;
			class132.field1247 = class282.method5426(var1);
			client.field1888 = var0;
		}

		if (var2 == 58) {
			var10 = class253.method5043(var1, var0);
			if (var10 != null) {
				if (null != var10.field3573) {
					ClientScript var19 = new ClientScript();
					var19.field694 = var10;
					var19.field690 = var3;
					var19.field685 = var6;
					var19.args = var10.field3573;
					class57.runClientScript(var19);
				}

				var18 = class185.method3435(ClientPacket.field3131, client.serverConnection.isaacRandom);
				var18.buffer.method8161(client.field1806);
				var18.buffer.method8161(var0);
				var18.buffer.writeIntAlt(class106.field1066);
				var18.buffer.writeShort(var4);
				var18.buffer.writeIntLE(var1);
				var18.buffer.method8159(client.field1805);
				client.serverConnection.add(var18);
			}
		}

		if (var2 == 1) {
			client.field1657 = var7;
			client.field1749 = var8;
			client.field1751 = 2;
			client.field1904 = 0;
			client.destinationX = var0;
			client.destinationY = var1;
			var16 = class185.method3435(ClientPacket.field3123, client.serverConnection.isaacRandom);
			var16.buffer.method8337(class6.field23);
			var16.buffer.method8337(class54.field385);
			var16.buffer.writeShort(var1 + class169.field1536);
			var16.buffer.method8161(class36.field241 + var0);
			var16.buffer.writeIntAlt(class213.field2493);
			var16.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
			var16.buffer.method8337(var3);
			client.serverConnection.add(var16);
		}

		if (var2 == 38) {
			class100.method1989();
			var10 = class282.method5426(var1);
			client.isItemSelected = 1;
			class6.field23 = var0;
			class213.field2493 = var1;
			class54.field385 = var4;
			class136.method2438(var10);
			client.field1803 = class96.method4510(16748608) + class278.method5388(var4).field2131 + class96.method4510(16777215);
			if (null == client.field1803) {
				client.field1803 = class338.field3899;
			}

		} else {
			if (var2 == 21) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3054, client.serverConnection.isaacRandom);
				var16.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8159(var1 + class169.field1536);
				var16.buffer.method8159(class36.field241 + var0);
				var16.buffer.method8161(var3);
				client.serverConnection.add(var16);
			}

			if (var2 == 36) {
				var16 = class185.method3435(ClientPacket.field3107, client.serverConnection.isaacRandom);
				var16.buffer.writeInt(var1);
				var16.buffer.method8337(var0);
				var16.buffer.method8159(var4);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			int var13;
			class300 var20;
			if (var2 == 28) {
				var16 = class185.method3435(ClientPacket.field3039, client.serverConnection.isaacRandom);
				var16.buffer.writeInt(var1);
				client.serverConnection.add(var16);
				var20 = class282.method5426(var1);
				if (null != var20 && var20.field3613 != null && 5 == var20.field3613[0][0]) {
					var13 = var20.field3613[0][1];
					class293.field3370[var13] = 1 - class293.field3370[var13];
					class147.method2521(var13);
				}
			}

			if (var2 == 44) {
				var17 = client.players[var3];
				if (null != var17) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3110, client.serverConnection.isaacRandom);
					var18.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
					var18.buffer.method8161(var3);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 39) {
				var16 = class185.method3435(ClientPacket.field3086, client.serverConnection.isaacRandom);
				var16.buffer.writeIntLE(var1);
				var16.buffer.method8159(var4);
				var16.buffer.writeShort(var0);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 35) {
				var16 = class185.method3435(ClientPacket.field3091, client.serverConnection.isaacRandom);
				var16.buffer.writeInt(var1);
				var16.buffer.method8161(var4);
				var16.buffer.writeShort(var0);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 19) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3106, client.serverConnection.isaacRandom);
				var16.buffer.method8161(var1 + class169.field1536);
				var16.buffer.method8159(var3);
				var16.buffer.method8348(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.writeShort(var0 + class36.field241);
				client.serverConnection.add(var16);
			}

			if (var2 == 22) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3084, client.serverConnection.isaacRandom);
				var16.buffer.method8161(class36.field241 + var0);
				var16.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8161(var3);
				var16.buffer.method8161(class169.field1536 + var1);
				client.serverConnection.add(var16);
			}

			if (var2 == 11) {
				var15 = client.npcs[var3];
				if (var15 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3056, client.serverConnection.isaacRandom);
					var18.buffer.method8337(var3);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 7) {
				var15 = client.npcs[var3];
				if (var15 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3111, client.serverConnection.isaacRandom);
					var18.buffer.method8161(class6.field23);
					var18.buffer.method8159(class54.field385);
					var18.buffer.method8337(var3);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					var18.buffer.writeInt(class213.field2493);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 6) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3053, client.serverConnection.isaacRandom);
				var16.buffer.method8161(class36.field241 + var0);
				var16.buffer.method8348(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8337(var3);
				var16.buffer.method8161(var1 + class169.field1536);
				client.serverConnection.add(var16);
			}

			if (var2 == 1005) {
				var10 = class282.method5426(var1);
				if (var10 != null && var10.field3456[var0] >= 100000) {
					MouseManager.method773(27, "", var10.field3456[var0] + " x " + class278.method5388(var4).field2131);
				} else {
					var18 = class185.method3435(ClientPacket.field3139, client.serverConnection.isaacRandom);
					var18.buffer.method8159(var4);
					client.serverConnection.add(var18);
				}

				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 49) {
				var17 = client.players[var3];
				if (var17 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3070, client.serverConnection.isaacRandom);
					var18.buffer.method8161(var3);
					var18.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 8) {
				var15 = client.npcs[var3];
				if (var15 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3119, client.serverConnection.isaacRandom);
					var18.buffer.method8161(var3);
					var18.buffer.method8337(client.field1805);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					var18.buffer.method8337(client.field1806);
					var18.buffer.writeIntLEAlt(class106.field1066);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
				ProofOfWorkRequest.field10.method7630(var2, var3, new class295(var0), new class295(var1));
			}

			if (var2 == 1001) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3064, client.serverConnection.isaacRandom);
				var16.buffer.method8161(var1 + class169.field1536);
				var16.buffer.writeShort(var0 + class36.field241);
				var16.buffer.method8161(var3);
				var16.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var16);
			}

			if (var2 == 45) {
				var17 = client.players[var3];
				if (var17 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3090, client.serverConnection.isaacRandom);
					var18.buffer.method8337(var3);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 43) {
				var16 = class185.method3435(ClientPacket.field3130, client.serverConnection.isaacRandom);
				var16.buffer.method8337(var4);
				var16.buffer.writeIntAlt(var1);
				var16.buffer.method8159(var0);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 30 && client.field1641 == null) {
				client.method7985(var1, var0);
				client.field1641 = class253.method5043(var1, var0);
				class136.method2438(client.field1641);
			}

			if (var2 == 48) {
				var17 = client.players[var3];
				if (null != var17) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3141, client.serverConnection.isaacRandom);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					var18.buffer.writeShort(var3);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 17) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3087, client.serverConnection.isaacRandom);
				var16.buffer.method8159(client.field1805);
				var16.buffer.method8159(class169.field1536 + var1);
				var16.buffer.writeIntLE(class106.field1066);
				var16.buffer.method8348(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8159(var0 + class36.field241);
				var16.buffer.method8159(var3);
				var16.buffer.method8337(client.field1806);
				client.serverConnection.add(var16);
			}

			if (var2 == 20) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3092, client.serverConnection.isaacRandom);
				var16.buffer.writeShort(class36.field241 + var0);
				var16.buffer.method8161(class169.field1536 + var1);
				var16.buffer.method8159(var3);
				var16.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var16);
			}

			if (var2 == 34) {
				var16 = class185.method3435(ClientPacket.field3104, client.serverConnection.isaacRandom);
				var16.buffer.method8337(var0);
				var16.buffer.writeShort(var4);
				var16.buffer.writeIntAlt(var1);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 24) {
				var10 = class282.method5426(var1);
				if (null != var10) {
					boolean var14 = true;
					if (var10.field3464 > 0) {
						var14 = class157.method2603(var10);
					}

					if (var14) {
						var12 = class185.method3435(ClientPacket.field3039, client.serverConnection.isaacRandom);
						var12.buffer.writeInt(var1);
						client.serverConnection.add(var12);
					}
				}
			}

			if (var2 == 29) {
				var16 = class185.method3435(ClientPacket.field3039, client.serverConnection.isaacRandom);
				var16.buffer.writeInt(var1);
				client.serverConnection.add(var16);
				var20 = class282.method5426(var1);
				if (null != var20 && null != var20.field3613 && 5 == var20.field3613[0][0]) {
					var13 = var20.field3613[0][1];
					if (class293.field3370[var13] != var20.field3592[0]) {
						class293.field3370[var13] = var20.field3592[0];
						class147.method2521(var13);
					}
				}
			}

			if (var2 == 3) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3121, client.serverConnection.isaacRandom);
				var16.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8337(class36.field241 + var0);
				var16.buffer.method8161(var1 + class169.field1536);
				var16.buffer.writeShort(var3);
				client.serverConnection.add(var16);
			}

			if (var2 == 16) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3057, client.serverConnection.isaacRandom);
				var16.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8337(var1 + class169.field1536);
				var16.buffer.method8159(class54.field385);
				var16.buffer.method8161(var3);
				var16.buffer.writeIntLE(class213.field2493);
				var16.buffer.method8159(class6.field23);
				var16.buffer.writeShort(var0 + class36.field241);
				client.serverConnection.add(var16);
			}

			if (var2 == 12) {
				var15 = client.npcs[var3];
				if (null != var15) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3078, client.serverConnection.isaacRandom);
					var18.buffer.method8159(var3);
					var18.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 2) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3093, client.serverConnection.isaacRandom);
				var16.buffer.writeIntLEAlt(class106.field1066);
				var16.buffer.method8337(var3);
				var16.buffer.method8159(class169.field1536 + var1);
				var16.buffer.method8337(client.field1806);
				var16.buffer.method8161(client.field1805);
				var16.buffer.method8161(var0 + class36.field241);
				var16.buffer.method8152(client.field1876.method3895(82) ? 1 : 0);
				client.serverConnection.add(var16);
			}

			if (var2 == 33) {
				var16 = class185.method3435(ClientPacket.field3067, client.serverConnection.isaacRandom);
				var16.buffer.writeShort(var4);
				var16.buffer.writeShort(var0);
				var16.buffer.writeInt(var1);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 13) {
				var15 = client.npcs[var3];
				if (var15 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3048, client.serverConnection.isaacRandom);
					var18.buffer.method8161(var3);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 5) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3050, client.serverConnection.isaacRandom);
				var16.buffer.method8337(var1 + class169.field1536);
				var16.buffer.method8337(class36.field241 + var0);
				var16.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8159(var3);
				client.serverConnection.add(var16);
			}

			if (var2 == 10) {
				var15 = client.npcs[var3];
				if (null != var15) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3122, client.serverConnection.isaacRandom);
					var18.buffer.method8337(var3);
					var18.buffer.writeByte(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 23) {
				if (client.isMenuOpen) {
					class145.field1333.method4160();
				} else {
					class145.field1333.method4159(class55.field396, var0, var1, true);
				}
			}

			if (var2 == 18) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3080, client.serverConnection.isaacRandom);
				var16.buffer.writeShort(var3);
				var16.buffer.method8161(var0 + class36.field241);
				var16.buffer.method8348(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.method8159(var1 + class169.field1536);
				client.serverConnection.add(var16);
			}

			if (var2 == 32) {
				var16 = class185.method3435(ClientPacket.field3041, client.serverConnection.isaacRandom);
				var16.buffer.method8159(client.field1805);
				var16.buffer.method8161(var0);
				var16.buffer.writeIntAlt(var1);
				var16.buffer.writeInt(class106.field1066);
				var16.buffer.method8159(var4);
				client.serverConnection.add(var16);
				client.field1840 = 0;
				class132.field1247 = class282.method5426(var1);
				client.field1888 = var0;
			}

			if (var2 == 4) {
				client.field1657 = var7;
				client.field1749 = var8;
				client.field1751 = 2;
				client.field1904 = 0;
				client.destinationX = var0;
				client.destinationY = var1;
				var16 = class185.method3435(ClientPacket.field3132, client.serverConnection.isaacRandom);
				var16.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
				var16.buffer.writeShort(class36.field241 + var0);
				var16.buffer.method8337(var3);
				var16.buffer.method8159(var1 + class169.field1536);
				client.serverConnection.add(var16);
			}

			if (var2 == 9) {
				var15 = client.npcs[var3];
				if (null != var15) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3069, client.serverConnection.isaacRandom);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					var18.buffer.writeShort(var3);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 51) {
				var17 = client.players[var3];
				if (var17 != null) {
					client.field1657 = var7;
					client.field1749 = var8;
					client.field1751 = 2;
					client.field1904 = 0;
					client.destinationX = var0;
					client.destinationY = var1;
					var18 = class185.method3435(ClientPacket.field3095, client.serverConnection.isaacRandom);
					var18.buffer.method8337(var3);
					var18.buffer.method8264(client.field1876.method3895(82) ? 1 : 0);
					client.serverConnection.add(var18);
				}
			}

			if (var2 == 26) {
				class339.method6316();
			}

			if (var2 == 25) {
				var10 = class253.method5043(var1, var0);
				if (var10 != null) {
					class100.method1989();
					class247.method4960(var1, var0, class290.method2693(class190.method3528(var10)), var4);
					client.isItemSelected = 0;
					client.field1653 = class323.method6203(var10);
					if (null == client.field1653) {
						client.field1653 = class338.field3899;
					}

					if (var10.field3459) {
						client.field1754 = var10.field3545 + class96.method4510(16777215);
					} else {
						client.field1754 = class96.method4510(65280) + var10.field3594 + class96.method4510(16777215);
					}
				}

			} else {
				if (0 != client.isItemSelected) {
					client.isItemSelected = 0;
					class136.method2438(class282.method5426(class213.field2493));
				}

				if (client.isSpellSelected) {
					class100.method1989();
				}

				if (null != class132.field1247 && 0 == client.field1840) {
					class136.method2438(class132.field1247);
				}

			}
		}
	}
}
