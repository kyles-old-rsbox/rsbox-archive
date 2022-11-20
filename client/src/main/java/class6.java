import java.util.concurrent.Callable;

public class class6 implements Callable {
	public static boolean field16;
	public static class478 field18;
	static int field23;
	final class24 field17;
	// $FF: synthetic field
	final class4 this$0;
	final Buffer field22;

	class6(class4 var1, Buffer var2, class24 var3) {
		this.this$0 = var1;
		this.field22 = var2;
		this.field17 = var3;
	}

	public Object call() {
		return this.field17.method339(this.field22);
	}
}
