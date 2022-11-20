import java.io.IOException;

public abstract class AbstractSocket {
	AbstractSocket() {
	}

	static void method7270(class189 var0, int var1, int var2, int var3) {
		if (client.soundEffectCount < 50 && class413.clientPreferences.method1736() != 0) {
			if (var0.field1995 != null && var0.field1995.containsKey(var1)) {
				int var5 = (Integer)var0.field1995.get(var1);
				if (var5 != 0) {
					int var8 = var5 >> 8;
					int var9 = var5 >> 4 & 7;
					int var10 = var5 & 15;
					client.field1895[client.soundEffectCount] = var8;
					client.field1896[client.soundEffectCount] = var9;
					client.field1897[client.soundEffectCount] = 0;
					client.field1899[client.soundEffectCount] = null;
					int var11 = (var2 - 64) / 128;
					int var12 = (var3 - 64) / 128;
					client.field1734[client.soundEffectCount] = (var11 << 16) + (var12 << 8) + var10;
					++client.soundEffectCount;
				}

			}
		}
	}

	public abstract boolean method7254(int var1) throws IOException;

	public abstract int available() throws IOException;

	public abstract int readUnsignedByte() throws IOException;

	public abstract void write(byte[] var1, int var2, int var3) throws IOException;

	public abstract void method7259();

	public abstract int read(byte[] var1, int var2, int var3) throws IOException;
}
