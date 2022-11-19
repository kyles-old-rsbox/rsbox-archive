import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class class337 {
	public static boolean field3889;
	public static Comparator field3884;
	public static Comparator field3885;
	public static Comparator field3887;
	public static Comparator field3888;
	public final List field3886;

	static {
		field3884 = new class327();
		new class316();
		field3887 = new class341();
		field3888 = new class314();
		field3885 = new class326();
	}

	public class337(class460 var1, boolean var2) {
		int var3 = var1.method8122();
		boolean var4 = var1.method8141() == 1;
		byte var5;
		if (var4) {
			var5 = 1;
		} else {
			var5 = 0;
		}

		int var6 = var1.method8122();
		this.field3886 = new ArrayList(var6);

		for (int var7 = 0; var7 < var6; ++var7) {
			this.field3886.add(new class328(var1, var5, var3));
		}

	}

	public void method6309(Comparator var1, boolean var2) {
		if (var2) {
			Collections.sort(this.field3886, var1);
		} else {
			Collections.sort(this.field3886, Collections.reverseOrder(var1));
		}

	}

	static void method6314(boolean var0) {
		byte var2 = 0;
		boolean var3 = class413.field4575.method1797() >= client.field1637;
		if (!var3) {
			var2 = 12;
		} else if (class133.field1257.method2874() || class133.field1257.method3038()) {
			var2 = 10;
		}

		class74.method1490(var2);
		if (var0) {
			class75.field633 = "";
			class75.field650 = "";
			class340.field4220 = 0;
			class349.field4269 = "";
		}

		class28.method400();
		class279.method5396();
	}
}
