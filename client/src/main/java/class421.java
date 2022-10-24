import java.util.Iterator;

public final class class421 implements Iterable {
	class427 field4665;
	class427 field4666;
	class427[] field4667;
	int field4663;
	int field4664;

	public class421(int var1) {
		this.field4663 = 0;
		this.field4664 = var1;
		this.field4667 = new class427[var1];

		for (int var2 = 0; var2 < var1; ++var2) {
			class427 var3 = this.field4667[var2] = new class427();
			var3.field4682 = var3;
			var3.field4683 = var3;
		}

	}

	public class427 method7788(long var1) {
		class427 var3 = this.field4667[(int)(var1 & (long)(this.field4664 - 1))];

		for (this.field4665 = var3.field4682; this.field4665 != var3; this.field4665 = this.field4665.field4682) {
			if (this.field4665.field4681 == var1) {
				class427 var4 = this.field4665;
				this.field4665 = this.field4665.field4682;
				return var4;
			}
		}

		this.field4665 = null;
		return null;
	}

	public void method7781(class427 var1, long var2) {
		if (var1.field4683 != null) {
			var1.method7825();
		}

		class427 var4 = this.field4667[(int)(var2 & (long)(this.field4664 - 1))];
		var1.field4683 = var4.field4683;
		var1.field4682 = var4;
		var1.field4683.field4682 = var1;
		var1.field4682.field4683 = var1;
		var1.field4681 = var2;
	}

	public void method7782() {
		for (int var1 = 0; var1 < this.field4664; ++var1) {
			class427 var2 = this.field4667[var1];

			while (true) {
				class427 var3 = var2.field4682;
				if (var3 == var2) {
					break;
				}

				var3.method7825();
			}
		}

		this.field4665 = null;
		this.field4666 = null;
	}

	public class427 method7787() {
		this.field4663 = 0;
		return this.method7789();
	}

	public class427 method7789() {
		class427 var1;
		if (this.field4663 > 0 && this.field4666 != this.field4667[this.field4663 - 1]) {
			var1 = this.field4666;
			this.field4666 = var1.field4682;
			return var1;
		} else {
			do {
				if (this.field4663 >= this.field4664) {
					return null;
				}

				var1 = this.field4667[this.field4663++].field4682;
			} while(var1 == this.field4667[this.field4663 - 1]);

			this.field4666 = var1.field4682;
			return var1;
		}
	}

	public Iterator iterator() {
		return new class441(this);
	}
}
