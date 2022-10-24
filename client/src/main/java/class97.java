public class class97 {
	public static short[][] field974;
	int field970;
	final class336 field969;
	final int field971;

	class97(class336 var1, String var2) {
		this.field970 = 0;
		this.field969 = var1;
		this.field971 = var1.method6100();
	}

	boolean method1962() {
		this.field970 = 0;

		for (int var2 = 0; var2 < this.field971; ++var2) {
			if (!this.field969.method6276(var2) || this.field969.method6280(var2)) {
				++this.field970;
			}
		}

		return this.field970 >= this.field971;
	}
}
