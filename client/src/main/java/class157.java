public class class157 extends class175 {
	static int field1437;
	int field1432;
	int field1433;
	int field1435;
	int field1438;
	long field1434;
	long[] field1436;

	public class157() {
		this.field1436 = new long[10];
		this.field1438 = 256;
		this.field1433 = 1;
		this.field1435 = 0;
		this.field1434 = class272.method2046();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1436[var1] = this.field1434;
		}

	}

	public void method2748() {
		for (int var2 = 0; var2 < 10; ++var2) {
			this.field1436[var2] = 0L;
		}

	}

	public int method2746(int var1, int var2) {
		int var4 = this.field1438;
		int var5 = this.field1433;
		this.field1438 = 300;
		this.field1433 = 1;
		this.field1434 = class272.method2046();
		if (this.field1436[this.field1432] == 0L) {
			this.field1438 = var4;
			this.field1433 = var5;
		} else if (this.field1434 > this.field1436[this.field1432]) {
			this.field1438 = (int)((long)(var1 * 2560) / (this.field1434 - this.field1436[this.field1432]));
		}

		if (this.field1438 < 25) {
			this.field1438 = 25;
		}

		if (this.field1438 > 256) {
			this.field1438 = 256;
			this.field1433 = (int)((long)var1 - (this.field1434 - this.field1436[this.field1432]) / 10L);
		}

		if (this.field1433 > var1) {
			this.field1433 = var1;
		}

		this.field1436[this.field1432] = this.field1434;
		this.field1432 = (1 + this.field1432) % 10;
		int var6;
		if (this.field1433 > 1) {
			for (var6 = 0; var6 < 10; ++var6) {
				if (this.field1436[var6] != 0L) {
					this.field1436[var6] += (long)this.field1433;
				}
			}
		}

		if (this.field1433 < var2) {
			this.field1433 = var2;
		}

		class266.method3531((long)this.field1433);

		for (var6 = 0; this.field1435 < 256; this.field1435 += this.field1438) {
			++var6;
		}

		this.field1435 &= 255;
		return var6;
	}

	static final boolean method2603(class300 var0) {
		int var2 = var0.field3464;
		if (var2 == 205) {
			client.logoutTimer = 250;
			return true;
		} else {
			int var3;
			int var4;
			if (var2 >= 300 && var2 <= 313) {
				var3 = (var2 - 300) / 2;
				var4 = var2 & 1;
				client.playerAppearance.method6000(var3, var4 == 1);
			}

			if (var2 >= 314 && var2 <= 323) {
				var3 = (var2 - 314) / 2;
				var4 = var2 & 1;
				client.playerAppearance.method6012(var3, var4 == 1);
			}

			if (var2 == 324) {
				client.playerAppearance.method5999(0);
			}

			if (var2 == 325) {
				client.playerAppearance.method5999(1);
			}

			if (var2 == 326) {
				PacketBufferNode var5 = class185.method3435(class274.field3065, client.packetWriter.isaacRandom);
				client.playerAppearance.method6016(var5.buffer);
				client.packetWriter.add(var5);
				return true;
			} else {
				return false;
			}
		}
	}
}
