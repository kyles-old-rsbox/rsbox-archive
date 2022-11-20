import java.util.HashMap;
import java.util.Map;

public class MessagesManager {
	public static Buffer field1090;
	public static int field1092;
	static int count;
	static final class355 queue;
	static final class421 hashTable;
	static final Map channels;

	static {
		channels = new HashMap();
		hashTable = new class421(1024);
		queue = new class355();
		count = 0;
	}

	MessagesManager() throws Throwable {
		throw new Error();
	}

	static int method7846() {
		return ++count - 1;
	}

	static void method2130() {
		class177.field1588 = new int[2000];
		int var1 = 0;
		int var2 = 240;

		int var4;
		for (byte var3 = 12; var1 < 16; var2 -= var3) {
			var4 = class18.method217((double)((float)var2 / 360.0F), 0.9998999834060669D, (double)((float)var1 * 0.425F / 16.0F + 0.075F));
			class177.field1588[var1] = var4;
			++var1;
		}

		var2 = 48;

		for (int var6 = var2 / 6; var1 < class177.field1588.length; var2 -= var6) {
			var4 = var1 * 2;

			for (int var5 = class18.method217((double)((float)var2 / 360.0F), 0.9998999834060669D, 0.5D); var1 < var4 && var1 < class177.field1588.length; ++var1) {
				class177.field1588[var1] = var5;
			}
		}

	}

	static void method1858(int var0, String var1, String var2, String var3) {
		class71 var5 = (class71) channels.get(var0);
		if (null == var5) {
			var5 = new class71();
			channels.put(var0, var5);
		}

		class63 var6 = var5.method1434(var0, var1, var2, var3);
		hashTable.method7781(var6, (long)var6.field496);
		queue.method6599(var6);
		client.field1843 = client.field1878;
	}

	static class63 method6313(int var0, int var1) {
		class71 var3 = (class71) channels.get(var0);
		return var3.method1428(var1);
	}

	static class63 method204(int var0) {
		return (class63) hashTable.method7788((long)var0);
	}
}
