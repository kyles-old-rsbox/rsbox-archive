import client.Client;

import java.io.IOException;

public abstract class class401 {
	class401() {
	}

	static void method7270(class189 var0, int var1, int var2, int var3) {
		if (Client.field1894 < 50 && class413.field4575.method1736() != 0) {
			if (var0.field1995 != null && var0.field1995.containsKey(var1)) {
				int var5 = (Integer)var0.field1995.get(var1);
				if (var5 != 0) {
					int var8 = var5 >> 8;
					int var9 = var5 >> 4 & 7;
					int var10 = var5 & 15;
					Client.field1895[Client.field1894] = var8;
					Client.field1896[Client.field1894] = var9;
					Client.field1897[Client.field1894] = 0;
					Client.field1899[Client.field1894] = null;
					int var11 = (var2 - 64) / 128;
					int var12 = (var3 - 64) / 128;
					Client.field1734[Client.field1894] = (var11 << 16) + (var12 << 8) + var10;
					++Client.field1894;
				}

			}
		}
	}

	public abstract boolean method7254(int var1) throws IOException;

	public abstract int method7255() throws IOException;

	public abstract int method7256() throws IOException;

	public abstract void method7258(byte[] var1, int var2, int var3) throws IOException;

	public abstract void method7259();

	public abstract int method7267(byte[] var1, int var2, int var3) throws IOException;
}
