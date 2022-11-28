import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class class200 {
	static class488[] field2206;
	int field2200;
	int field2203;
	public int field2197;
	public int field2202;
	public int[][] field2205;

	public class200(int var1, int var2) {
		this.field2197 = 0;
		this.field2202 = 0;
		this.field2203 = var1;
		this.field2200 = var2;
		this.field2205 = new int[this.field2203][this.field2200];
		this.method3735();
	}

	public void method3735() {
		for (int var2 = 0; var2 < this.field2203; ++var2) {
			for (int var3 = 0; var3 < this.field2200; ++var3) {
				if (var2 != 0 && var3 != 0 && var2 < this.field2203 - 5 && var3 < this.field2200 - 5) {
					this.field2205[var2][var3] = 16777216;
				} else {
					this.field2205[var2][var3] = 16777215;
				}
			}
		}

	}

	public void method3736(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.field2197;
		var2 -= this.field2202;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3755(var1, var2, 128);
				this.method3755(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3755(var1, var2, 2);
				this.method3755(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3755(var1, var2, 8);
				this.method3755(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3755(var1, var2, 32);
				this.method3755(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3755(var1, var2, 1);
				this.method3755(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3755(var1, var2, 4);
				this.method3755(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3755(var1, var2, 16);
				this.method3755(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3755(var1, var2, 64);
				this.method3755(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3755(var1, var2, 130);
				this.method3755(var1 - 1, var2, 8);
				this.method3755(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3755(var1, var2, 10);
				this.method3755(var1, var2 + 1, 32);
				this.method3755(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3755(var1, var2, 40);
				this.method3755(var1 + 1, var2, 128);
				this.method3755(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3755(var1, var2, 160);
				this.method3755(var1, var2 - 1, 2);
				this.method3755(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3755(var1, var2, 65536);
					this.method3755(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3755(var1, var2, 1024);
					this.method3755(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3755(var1, var2, 4096);
					this.method3755(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3755(var1, var2, 16384);
					this.method3755(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3755(var1, var2, 512);
					this.method3755(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3755(var1, var2, 2048);
					this.method3755(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3755(var1, var2, 8192);
					this.method3755(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3755(var1, var2, 32768);
					this.method3755(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3755(var1, var2, 66560);
					this.method3755(var1 - 1, var2, 4096);
					this.method3755(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3755(var1, var2, 5120);
					this.method3755(var1, var2 + 1, 16384);
					this.method3755(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3755(var1, var2, 20480);
					this.method3755(var1 + 1, var2, 65536);
					this.method3755(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3755(var1, var2, 81920);
					this.method3755(var1, var2 - 1, 1024);
					this.method3755(var1 - 1, var2, 4096);
				}
			}
		}

	}

	public void method3737(int var1, int var2, int var3, int var4, boolean var5) {
		int var7 = 256;
		if (var5) {
			var7 += 131072;
		}

		var1 -= this.field2197;
		var2 -= this.field2202;

		for (int var8 = var1; var8 < var3 + var1; ++var8) {
			if (var8 >= 0 && var8 < this.field2203) {
				for (int var9 = var2; var9 < var4 + var2; ++var9) {
					if (var9 >= 0 && var9 < this.field2200) {
						this.method3755(var8, var9, var7);
					}
				}
			}
		}

	}

	public void method3738(int var1, int var2) {
		var1 -= this.field2197;
		var2 -= this.field2202;
		int[] var10000 = this.field2205[var1];
		var10000[var2] |= 2097152;
	}

	public void method3739(int var1, int var2) {
		var1 -= this.field2197;
		var2 -= this.field2202;
		int[] var10000 = this.field2205[var1];
		var10000[var2] |= 262144;
	}

	void method3755(int var1, int var2, int var3) {
		int[] var10000 = this.field2205[var1];
		var10000[var2] |= var3;
	}

	public void method3759(int var1, int var2, int var3, int var4, boolean var5) {
		var1 -= this.field2197;
		var2 -= this.field2202;
		if (var3 == 0) {
			if (var4 == 0) {
				this.method3742(var1, var2, 128);
				this.method3742(var1 - 1, var2, 8);
			}

			if (var4 == 1) {
				this.method3742(var1, var2, 2);
				this.method3742(var1, var2 + 1, 32);
			}

			if (var4 == 2) {
				this.method3742(var1, var2, 8);
				this.method3742(var1 + 1, var2, 128);
			}

			if (var4 == 3) {
				this.method3742(var1, var2, 32);
				this.method3742(var1, var2 - 1, 2);
			}
		}

		if (var3 == 1 || var3 == 3) {
			if (var4 == 0) {
				this.method3742(var1, var2, 1);
				this.method3742(var1 - 1, var2 + 1, 16);
			}

			if (var4 == 1) {
				this.method3742(var1, var2, 4);
				this.method3742(var1 + 1, var2 + 1, 64);
			}

			if (var4 == 2) {
				this.method3742(var1, var2, 16);
				this.method3742(var1 + 1, var2 - 1, 1);
			}

			if (var4 == 3) {
				this.method3742(var1, var2, 64);
				this.method3742(var1 - 1, var2 - 1, 4);
			}
		}

		if (var3 == 2) {
			if (var4 == 0) {
				this.method3742(var1, var2, 130);
				this.method3742(var1 - 1, var2, 8);
				this.method3742(var1, var2 + 1, 32);
			}

			if (var4 == 1) {
				this.method3742(var1, var2, 10);
				this.method3742(var1, var2 + 1, 32);
				this.method3742(var1 + 1, var2, 128);
			}

			if (var4 == 2) {
				this.method3742(var1, var2, 40);
				this.method3742(var1 + 1, var2, 128);
				this.method3742(var1, var2 - 1, 2);
			}

			if (var4 == 3) {
				this.method3742(var1, var2, 160);
				this.method3742(var1, var2 - 1, 2);
				this.method3742(var1 - 1, var2, 8);
			}
		}

		if (var5) {
			if (var3 == 0) {
				if (var4 == 0) {
					this.method3742(var1, var2, 65536);
					this.method3742(var1 - 1, var2, 4096);
				}

				if (var4 == 1) {
					this.method3742(var1, var2, 1024);
					this.method3742(var1, var2 + 1, 16384);
				}

				if (var4 == 2) {
					this.method3742(var1, var2, 4096);
					this.method3742(var1 + 1, var2, 65536);
				}

				if (var4 == 3) {
					this.method3742(var1, var2, 16384);
					this.method3742(var1, var2 - 1, 1024);
				}
			}

			if (var3 == 1 || var3 == 3) {
				if (var4 == 0) {
					this.method3742(var1, var2, 512);
					this.method3742(var1 - 1, var2 + 1, 8192);
				}

				if (var4 == 1) {
					this.method3742(var1, var2, 2048);
					this.method3742(var1 + 1, var2 + 1, 32768);
				}

				if (var4 == 2) {
					this.method3742(var1, var2, 8192);
					this.method3742(var1 + 1, var2 - 1, 512);
				}

				if (var4 == 3) {
					this.method3742(var1, var2, 32768);
					this.method3742(var1 - 1, var2 - 1, 2048);
				}
			}

			if (var3 == 2) {
				if (var4 == 0) {
					this.method3742(var1, var2, 66560);
					this.method3742(var1 - 1, var2, 4096);
					this.method3742(var1, var2 + 1, 16384);
				}

				if (var4 == 1) {
					this.method3742(var1, var2, 5120);
					this.method3742(var1, var2 + 1, 16384);
					this.method3742(var1 + 1, var2, 65536);
				}

				if (var4 == 2) {
					this.method3742(var1, var2, 20480);
					this.method3742(var1 + 1, var2, 65536);
					this.method3742(var1, var2 - 1, 1024);
				}

				if (var4 == 3) {
					this.method3742(var1, var2, 81920);
					this.method3742(var1, var2 - 1, 1024);
					this.method3742(var1 - 1, var2, 4096);
				}
			}
		}

	}

	static final boolean method3770(byte[] var0, int var1, int var2) {
		boolean var4 = true;
		Buffer var5 = new Buffer(var0);
		int var6 = -1;

		label70:
		while (true) {
			int var7 = var5.method8138();
			if (var7 == 0) {
				return var4;
			}

			var6 += var7;
			int var8 = 0;
			boolean var9 = false;

			while (true) {
				int var10;
				while (!var9) {
					var10 = var5.method8207();
					if (var10 == 0) {
						continue label70;
					}

					var8 += var10 - 1;
					int var11 = var8 & 63;
					int var12 = var8 >> 6 & 63;
					int var13 = var5.readUnsignedByte() >> 2;
					int var14 = var12 + var1;
					int var15 = var11 + var2;
					if (var14 > 0 && var15 > 0 && var14 < 103 && var15 < 103) {
						class195 var16 = InterfaceParent.method1866(var6);
						if (var13 != 22 || !client.isLowDetail || var16.field2072 != 0 || var16.field2070 == 1 || var16.field2068) {
							if (!var16.method3587()) {
								++client.field1702;
								var4 = false;
							}

							var9 = true;
						}
					}
				}

				var10 = var5.method8207();
				if (var10 == 0) {
					break;
				}

				var5.readUnsignedByte();
			}
		}
	}

	public void method3741(int var1, int var2, int var3, int var4, int var5, boolean var6) {
		int var8 = 256;
		if (var6) {
			var8 += 131072;
		}

		var1 -= this.field2197;
		var2 -= this.field2202;
		int var9;
		if (var5 == 1 || var5 == 3) {
			var9 = var3;
			var3 = var4;
			var4 = var9;
		}

		for (var9 = var1; var9 < var1 + var3; ++var9) {
			if (var9 >= 0 && var9 < this.field2203) {
				for (int var10 = var2; var10 < var2 + var4; ++var10) {
					if (var10 >= 0 && var10 < this.field2200) {
						this.method3742(var9, var10, var8);
					}
				}
			}
		}

	}

	void method3742(int var1, int var2, int var3) {
		int[] var10000 = this.field2205[var1];
		var10000[var2] &= ~var3;
	}

	public void method3743(int var1, int var2) {
		var1 -= this.field2197;
		var2 -= this.field2202;
		int[] var10000 = this.field2205[var1];
		var10000[var2] &= -262145;
	}

	static Date method3762() throws ParseException {
		SimpleDateFormat var1 = new SimpleDateFormat("ddMMyyyyHH", Locale.ENGLISH);
		var1.setLenient(false);
		StringBuilder var2 = new StringBuilder();
		String[] var3 = Login.field635;

		for (int var4 = 0; var4 < var3.length; ++var4) {
			String var5 = var3[var4];
			if (null == var5) {
				Login.method201("Date not valid.", "Please ensure all characters are populated.", "");
				return null;
			}

			var2.append(var5);
		}

		var2.append("12");
		return var1.parse(var2.toString());
	}

	static final void method3753(int var0, int var1, boolean var2) {
		if (!var2 || class361.field4314 != var0 || ServerPacket.field3216 != var1) {
			class361.field4314 = var0;
			ServerPacket.field3216 = var1;
			class9.method64(25);
			class131.method2399(class338.field3902, true);
			int var4 = class36.sceneBaseX;
			int var5 = class169.sceneBaseY;
			class36.sceneBaseX = 8 * (var0 - 6);
			class169.sceneBaseY = (var1 - 6) * 8;
			int var6 = class36.sceneBaseX - var4;
			int var7 = class169.sceneBaseY - var5;
			var4 = class36.sceneBaseX;
			var5 = class169.sceneBaseY;

			int var8;
			int var10;
			int[] var10000;
			for (var8 = 0; var8 < 65536; ++var8) {
				class81 var9 = client.npcs[var8];
				if (null != var9) {
					for (var10 = 0; var10 < 10; ++var10) {
						var10000 = var9.field861;
						var10000[var10] -= var6;
						var10000 = var9.field873;
						var10000[var10] -= var7;
					}

					var9.field827 -= var6 * 128;
					var9.field802 -= var7 * 128;
				}
			}

			for (var8 = 0; var8 < 2048; ++var8) {
				PlayerEntity var22 = client.localPlayers[var8];
				if (var22 != null) {
					for (var10 = 0; var10 < 10; ++var10) {
						var10000 = var22.field861;
						var10000[var10] -= var6;
						var10000 = var22.field873;
						var10000[var10] -= var7;
					}

					var22.field827 -= var6 * 128;
					var22.field802 -= var7 * 128;
				}
			}

			byte var21 = 0;
			byte var19 = 104;
			byte var23 = 1;
			if (var6 < 0) {
				var21 = 103;
				var19 = -1;
				var23 = -1;
			}

			byte var11 = 0;
			byte var12 = 104;
			byte var13 = 1;
			if (var7 < 0) {
				var11 = 103;
				var12 = -1;
				var13 = -1;
			}

			int var15;
			for (int var14 = var21; var19 != var14; var14 += var23) {
				for (var15 = var11; var15 != var12; var15 += var13) {
					int var16 = var14 + var6;
					int var17 = var7 + var15;

					for (int var18 = 0; var18 < 4; ++var18) {
						if (var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
							client.groundItems[var18][var14][var15] = client.groundItems[var18][var16][var17];
						} else {
							client.groundItems[var18][var14][var15] = null;
						}
					}
				}
			}

			for (class101 var20 = (class101)client.pendingSpawns.method6364(); var20 != null; var20 = (class101)client.pendingSpawns.method6358()) {
				var20.field999 -= var6;
				var20.field994 -= var7;
				if (var20.field999 < 0 || var20.field994 < 0 || var20.field999 >= 104 || var20.field994 >= 104) {
					var20.method7825();
				}
			}

			if (0 != client.destinationX) {
				client.destinationX -= var6;
				client.destinationY -= var7;
			}

			client.soundEffectCount = 0;
			client.field1900 = false;
			class215.field2568 -= var6 << 7;
			class323.field3766 -= var7 << 7;
			class32.field203 -= var6 << 7;
			class101.field1004 -= var7 << 7;
			client.field1662 = -1;
			client.graphics.clear();
			client.projectiles.clear();

			for (var15 = 0; var15 < 4; ++var15) {
				client.field1884[var15].method3735();
			}

		}
	}
}
