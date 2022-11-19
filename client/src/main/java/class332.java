public class class332 {
	static final class332 field3833;
	static final class332 field3834;
	static final class332 field3835;
	static final class332 field3837;
	final int field3832;
	public final String field3836;

	static {
		field3837 = new class332("LIVE", 0);
		field3833 = new class332("BUILDLIVE", 3);
		field3834 = new class332("RC", 1);
		field3835 = new class332("WIP", 2);
	}

	class332(String var1, int var2) {
		this.field3836 = var1;
		this.field3832 = var2;
	}

	static int method6264(int var0, class78 var1, boolean var2) {
		if (var0 == CS2Opcodes.ISMENUOPEN) {
			class57.field404[++class387.field4452 - 1] = client.method5007() ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
