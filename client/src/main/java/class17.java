import java.io.IOException;
import java.util.concurrent.Callable;

public class class17 implements Callable {
	final class12 field82;
	// $FF: synthetic field
	final class15 this$0;

	class17(class15 var1, class12 var2) {
		this.this$0 = var1;
		this.field82 = var2;
	}

	public Object call() throws Exception {
		try {
			while (this.field82.method93()) {
				class266.method3531(10L);
			}
		} catch (IOException var2) {
			return new class9("Error servicing REST query: " + var2.getMessage());
		}

		return this.field82.method92();
	}

	static void method200(class93 var0, boolean var1) {
		if (null != var0 && var0.method1869() && !var0.field913) {
			var0.field895 = false;
			if ((client.field1636 && class102.field1012 > 50 || class102.field1012 > 200) && var1 && var0.field839 == var0.field823) {
				var0.field895 = true;
			}

			int var3 = var0.field827 >> 7;
			int var4 = var0.field802 >> 7;
			if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
				long var5 = class207.method3982(0, 0, 0, false, var0.field915);
				if (null != var0.field906 && client.field1645 >= var0.field901 && client.field1645 < var0.field902) {
					var0.field895 = false;
					var0.field900 = class144.method2498(var0.field827, var0.field802, class55.field396);
					var0.field872 = client.field1645;
					class145.field1333.method4134(class55.field396, var0.field827, var0.field802, var0.field900, 60, var0, var0.field826, var5, var0.field907, var0.field908, var0.field909, var0.field899);
				} else {
					if (64 == (var0.field827 & 127) && (var0.field802 & 127) == 64) {
						if (client.field1745 == client.field1855[var3][var4]) {
							return;
						}

						client.field1855[var3][var4] = client.field1745;
					}

					var0.field900 = class144.method2498(var0.field827, var0.field802, class55.field396);
					var0.field872 = client.field1645;
					class145.field1333.method4133(class55.field396, var0.field827, var0.field802, var0.field900, 60, var0, var0.field826, var5, var0.field805);
				}
			}
		}

	}

	static final void method198(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != class413.field4575.method1716()) {
			if (class413.field4575.method1716() == 0 && -1 != client.field1748) {
				class279.method332(class43.field311, client.field1748, 0, var0, false);
				client.field1781 = false;
			} else if (var0 == 0) {
				class279.field3201.method5365();
				class279.field3202 = 1;
				class7.field29 = null;
				client.field1781 = false;
			} else {
				class250.method5006(var0);
			}

			class413.field4575.method1715(var0);
		}

	}
}
