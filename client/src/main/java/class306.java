import client.Client;

public class class306 implements class360 {
	public static final class306 field3651;
	public static final class306 field3657;
	public static final class306 field3659;
	public static final class306 field3660;
	public static final class306 field3663;
	public static final class306 field3667;
	static final class306 field3648;
	static final class306 field3649;
	static final class306 field3650;
	static final class306 field3652;
	static final class306 field3653;
	static final class306 field3654;
	static final class306 field3655;
	static final class306 field3656;
	static final class306 field3658;
	static final class306 field3661;
	static final class306 field3662;
	static final class306 field3664;
	static final class306 field3665;
	static final class306 field3666;
	static final class306 field3668;
	static final class306 field3669;
	static final class306 field3671;
	public final int field3670;

	static {
		field3660 = new class306(0);
		field3648 = new class306(1);
		field3659 = new class306(2);
		field3663 = new class306(3);
		field3651 = new class306(9);
		field3652 = new class306(4);
		field3656 = new class306(5);
		field3654 = new class306(6);
		field3655 = new class306(7);
		field3668 = new class306(8);
		field3671 = new class306(12);
		field3658 = new class306(13);
		field3653 = new class306(14);
		field3650 = new class306(15);
		field3661 = new class306(16);
		field3662 = new class306(17);
		field3665 = new class306(18);
		field3664 = new class306(19);
		field3649 = new class306(20);
		field3666 = new class306(21);
		field3667 = new class306(10);
		field3657 = new class306(11);
		field3669 = new class306(22);
	}

	class306(int var1) {
		this.field3670 = var1;
	}

	public int method6663() {
		return this.field3670;
	}

	static int method6032(int var0, class78 var1, boolean var2) {
		int var4;
		if (var0 == CS2Opcodes.KEYHELD) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1876.method3895(var4) ? 1 : 0;
			return 1;
		} else if (var0 == CS2Opcodes.KEYPRESSED) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1876.method3919(var4) ? 1 : 0;
			return 1;
		} else if (var0 == CS2Opcodes.KEYRELEASED) {
			var4 = class57.field404[--class387.field4452];
			class57.field404[++class387.field4452 - 1] = Client.field1876.method3900(var4) ? 1 : 0;
			return 1;
		} else {
			return 2;
		}
	}
}
