public class class388 {
	class390 field4459;
	int field4460;
	int field4461;

	class388(class390 var1, int var2, int var3) {
		this.field4460 = 0;
		this.field4461 = 0;
		this.field4459 = var1;
		this.field4460 = var2;
		this.field4461 = var3;
	}

	public String method7012() {
		if (this.method6993()) {
			return "";
		} else {
			StringBuilder var2 = new StringBuilder(this.method6994());

			for (int var3 = this.field4460; var3 < this.field4461; ++var3) {
				class383 var4 = this.field4459.method7029(var3);
				var2.append(var4.field4428);
			}

			return var2.toString();
		}
	}

	boolean method6992(int var1) {
		return this.field4459.method7056() == 2 || this.field4459.method7056() == 1 && (!this.field4459.field4472 || var1 != this.field4461 - 1);
	}

	public boolean method6993() {
		return this.field4461 == this.field4460;
	}

	public int method6994() {
		return this.field4461 - this.field4460;
	}

	boolean method6995(class383 var1) {
		if (this.field4459.field4480 == 2) {
			return true;
		} else if (this.field4459.field4480 == 0) {
			return false;
		} else {
			return this.field4459.method7030() != var1;
		}
	}

	int method7005() {
		if (this.method6993()) {
			return 0;
		} else {
			class383 var2 = this.field4459.method7029(this.field4461 - 1);
			if ('\n' == var2.field4428) {
				return 0;
			} else if (this.method6995(var2)) {
				return this.field4459.field4477.field4430[42];
			} else {
				int var3 = this.field4459.field4477.field4430[var2.field4428];
				if (0 == var3) {
					return var2.field4428 == '\t' ? 3 * this.field4459.field4477.field4430[32] : this.field4459.field4477.field4430[32];
				} else {
					return var3;
				}
			}
		}
	}

	public class438 method6997() {
		if (this.method6993()) {
			return new class438(0, 0);
		} else {
			class383 var2 = this.field4459.method7029(this.field4461 - 1);
			return new class438(var2.field4422 + this.method7005(), var2.field4424);
		}
	}

	public class383 method7010(int var1) {
		return var1 >= 0 && var1 < this.method6994() ? this.field4459.method7029(this.field4460 + var1) : null;
	}
}
