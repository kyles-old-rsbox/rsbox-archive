import java.util.concurrent.Callable;

public class class6 implements Callable {
	public static boolean field16;
	public static class478 field18;
	static int field23;
	final ProofOfWorkMessage field17;
	// $FF: synthetic field
	final ProofOfWorkRequest this$0;
	final Buffer field22;

	class6(ProofOfWorkRequest var1, Buffer var2, ProofOfWorkMessage var3) {
		this.this$0 = var1;
		this.field22 = var2;
		this.field17 = var3;
	}

	public Object call() {
		return this.field17.method339(this.field22);
	}
}
