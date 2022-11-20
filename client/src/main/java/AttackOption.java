import java.awt.Image;

public class AttackOption implements class360 {
	protected static String field706;
	static Image field707;
	static final AttackOption field697;
	static final AttackOption field698;
	static final AttackOption field701;
	static final AttackOption HIDDEN;
	static final AttackOption field705;
	final int field702;

	public static int method1613(int var0, int var1, int var2, int var3, int var4, int var5) {
		if (1 == (var5 & 1)) {
			int var7 = var3;
			var3 = var4;
			var4 = var7;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	static {
		field705 = new AttackOption(0);
		field698 = new AttackOption(1);
		field697 = new AttackOption(2);
		HIDDEN = new AttackOption(3);
		field701 = new AttackOption(4);
	}

	static AttackOption[] method1045() {
		return new AttackOption[]{field697, field701, field705, field698, HIDDEN};
	}

	AttackOption(int var1) {
		this.field702 = var1;
	}

	public int rsOrdinal() {
		return this.field702;
	}
}
