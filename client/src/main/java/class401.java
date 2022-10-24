import java.io.IOException;

public abstract class class401 {
	class401() {
	}

	static void method7270(class189 var0, int var1, int var2, int var3) {
		if (client.field1894 < 50 && class413.field4575.method1736() != 0) {
			if (var0.field1995 != null && var0.field1995.containsKey(var1)) {
				int var5 = (Integer)var0.field1995.get(var1);
				if (0 != var5) {
					int var8 = var5 >> 8;
					int var9 = var5 >> 4 & 7;
					int var10 = var5 & 15;
					client.field1895[client.field1894] = var8;
					client.field1896[client.field1894] = var9;
					client.field1897[client.field1894] = 0;
					client.field1899[client.field1894] = null;
					int var11 = (var2 - 64) / 128;
					int var12 = (var3 - 64) / 128;
					client.field1734[client.field1894] = (var11 << 16) + (var12 << 8) + var10;
					++client.field1894;
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
