import java.util.Iterator;
import java.util.LinkedList;

public class class254 {
	boolean field2938;
	class295 field2935;
	int field2930;
	int field2933;
	int field2934;
	int field2936;
	int field2937;
	int field2939;
	int field2940;
	String field2931;
	String field2932;
	LinkedList field2941;

	public class254() {
		this.field2940 = -1;
		this.field2933 = -1;
		this.field2934 = -1;
		this.field2935 = null;
		this.field2936 = Integer.MAX_VALUE;
		this.field2930 = 0;
		this.field2937 = Integer.MAX_VALUE;
		this.field2939 = 0;
		this.field2938 = false;
	}

	public void method5073(Buffer var1, int var2) {
		this.field2940 = var2;
		this.field2931 = var1.readString();
		this.field2932 = var1.readString();
		this.field2935 = new class295(var1.readInt());
		this.field2933 = var1.readInt();
		var1.readUnsignedByte();
		this.field2938 = var1.readUnsignedByte() == 1;
		this.field2934 = var1.readUnsignedByte();
		int var4 = var1.readUnsignedByte();
		this.field2941 = new LinkedList();

		for (int var5 = 0; var5 < var4; ++var5) {
			this.field2941.add(this.method5121(var1));
		}

		this.method5119();
	}

	class248 method5121(Buffer var1) {
		int var3 = var1.readUnsignedByte();
		class252[] var4 = new class252[]{class252.field2916, class252.field2923, class252.field2919, class252.field2917};
		class252 var5 = (class252)class217.fromValue(var4, var3);
		Object var6 = null;
		switch(var5.field2920) {
		case 0:
			var6 = new class247();
			break;
		case 1:
			var6 = new class236();
			break;
		case 2:
			var6 = new class225();
			break;
		case 3:
			var6 = new class237();
			break;
		default:
			throw new IllegalStateException("");
		}

		((class248)var6).method4967(var1);
		return (class248)var6;
	}

	public boolean method5083(int var1, int var2, int var3) {
		Iterator var5 = this.field2941.iterator();

		class248 var6;
		do {
			if (!var5.hasNext()) {
				return false;
			}

			var6 = (class248)var5.next();
		} while(!var6.method4976(var1, var2, var3));

		return true;
	}

	public boolean method5048(int var1, int var2) {
		int var4 = var1 / 64;
		int var5 = var2 / 64;
		if (var4 >= this.field2936 && var4 <= this.field2930) {
			if (var5 >= this.field2937 && var5 <= this.field2939) {
				Iterator var6 = this.field2941.iterator();

				class248 var7;
				do {
					if (!var6.hasNext()) {
						return false;
					}

					var7 = (class248)var6.next();
				} while(!var7.method4963(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public int[] method5049(int var1, int var2, int var3) {
		Iterator var5 = this.field2941.iterator();

		class248 var6;
		do {
			if (!var5.hasNext()) {
				return null;
			}

			var6 = (class248)var5.next();
		} while(!var6.method4976(var1, var2, var3));

		return var6.method4979(var1, var2, var3);
	}

	public class295 method5100(int var1, int var2) {
		Iterator var4 = this.field2941.iterator();

		class248 var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (class248)var4.next();
		} while(!var5.method4963(var1, var2));

		return var5.method4966(var1, var2);
	}

	void method5119() {
		Iterator var2 = this.field2941.iterator();

		while (var2.hasNext()) {
			class248 var3 = (class248)var2.next();
			var3.method4986(this);
		}

	}

	public int method5063() {
		return this.field2940;
	}

	public boolean method5085() {
		return this.field2938;
	}

	public String method5054() {
		return this.field2931;
	}

	public String method5055() {
		return this.field2932;
	}

	int method5056() {
		return this.field2933;
	}

	public int method5057() {
		return this.field2934;
	}

	public int method5124() {
		return this.field2936;
	}

	public int method5059() {
		return this.field2930;
	}

	public int method5079() {
		return this.field2937;
	}

	public int method5061() {
		return this.field2939;
	}

	public int method5069() {
		return this.field2935.field3376;
	}

	public int method5103() {
		return this.field2935.field3374;
	}

	public int method5108() {
		return this.field2935.field3375;
	}

	public class295 method5064() {
		return new class295(this.field2935);
	}
}
