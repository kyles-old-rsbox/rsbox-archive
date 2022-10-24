public class class407 {
	public int field4528;
	public int field4529;
	public int field4530;
	public int field4531;

	public class407(int var1, int var2) {
		this(0, 0, var1, var2);
	}

	public class407(int var1, int var2, int var3, int var4) {
		this.method7373(var1, var2);
		this.method7374(var3, var4);
	}

	public void method7373(int var1, int var2) {
		this.field4529 = var1;
		this.field4530 = var2;
	}

	public void method7374(int var1, int var2) {
		this.field4531 = var1;
		this.field4528 = var2;
	}

	public boolean method7375(int var1, int var2) {
		return var1 >= this.field4529 && var1 < this.field4531 + this.field4529 && var2 >= this.field4530 && var2 < this.field4528 + this.field4530;
	}

	public String toString() {
		return null;
	}

	public void method7376(class407 var1, class407 var2) {
		this.method7377(var1, var2);
		this.method7372(var1, var2);
	}

	void method7377(class407 var1, class407 var2) {
		var2.field4529 = this.field4529;
		var2.field4531 = this.field4531;
		if (this.field4529 < var1.field4529) {
			var2.field4531 = (var2.field4531 * 646679223 - (var1.field4529 * 646679223 - this.field4529 * 646679223)) * 18445063;
			var2.field4529 = var1.field4529;
		}

		if (var2.method7379() > var1.method7379()) {
			var2.field4531 -= var2.method7379() - var1.method7379();
		}

		if (var2.field4531 < 0) {
			var2.field4531 = 0;
		}

	}

	void method7372(class407 var1, class407 var2) {
		var2.field4530 = this.field4530;
		var2.field4528 = this.field4528;
		if (this.field4530 < var1.field4530) {
			var2.field4528 = (var2.field4528 * 1396884327 - (var1.field4530 * 1396884327 - this.field4530 * 1396884327)) * -1563645865;
			var2.field4530 = var1.field4530;
		}

		if (var2.method7385() > var1.method7385()) {
			var2.field4528 -= var2.method7385() - var1.method7385();
		}

		if (var2.field4528 < 0) {
			var2.field4528 = 0;
		}

	}

	int method7379() {
		return this.field4531 + this.field4529;
	}

	int method7385() {
		return this.field4528 + this.field4530;
	}
}
