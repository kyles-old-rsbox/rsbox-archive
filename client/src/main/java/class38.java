public class class38 extends class51 {
	NodeDeque field253;
	NodeDeque field254;
	int field255;
	int field256;

	public class38() {
		this.field254 = new NodeDeque();
		this.field253 = new NodeDeque();
		this.field255 = 0;
		this.field256 = -1;
	}

	public final synchronized void method718(class51 var1) {
		this.field254.method6353(var1);
	}

	public final synchronized void method737(class51 var1) {
		var1.method7825();
	}

	void method720() {
		if (this.field255 > 0) {
			for (class68 var1 = (class68)this.field253.method6364(); var1 != null; var1 = (class68)this.field253.method6358()) {
				var1.field551 -= this.field255;
			}

			this.field256 -= this.field255;
			this.field255 = 0;
		}

	}

	void method721(class427 var1, class68 var2) {
		while (var1 != this.field253.field4230 && ((class68)var1).field551 <= var2.field551) {
			var1 = var1.field4682;
		}

		NodeDeque.method6361(var2, var1);
		this.field256 = ((class68)this.field253.field4230.field4682).field551;
	}

	void method722(class68 var1) {
		var1.method7825();
		var1.method1412();
		class427 var2 = this.field253.field4230.field4682;
		if (var2 == this.field253.field4230) {
			this.field256 = -1;
		} else {
			this.field256 = ((class68)var2).field551;
		}

	}

	protected class51 method1007() {
		return (class51)this.field254.method6364();
	}

	protected class51 method1004() {
		return (class51)this.field254.method6358();
	}

	protected int method1003() {
		return 0;
	}

	public final synchronized void method1005(int[] var1, int var2, int var3) {
		do {
			if (this.field256 < 0) {
				this.method727(var1, var2, var3);
				return;
			}

			if (this.field255 + var3 < this.field256) {
				this.field255 += var3;
				this.method727(var1, var2, var3);
				return;
			}

			int var4 = this.field256 - this.field255;
			this.method727(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field255 += var4;
			this.method720();
			class68 var5 = (class68)this.field253.method6364();
			synchronized(var5) {
				int var7 = var5.method1411(this);
				if (var7 < 0) {
					var5.field551 = 0;
					this.method722(var5);
				} else {
					var5.field551 = var7;
					this.method721(var5.field4682, var5);
				}
			}
		} while(var3 != 0);

	}

	void method727(int[] var1, int var2, int var3) {
		for (class51 var4 = (class51)this.field254.method6364(); var4 != null; var4 = (class51)this.field254.method6358()) {
			var4.method1006(var1, var2, var3);
		}

	}

	public final synchronized void method1001(int var1) {
		do {
			if (this.field256 < 0) {
				this.method729(var1);
				return;
			}

			if (this.field255 + var1 < this.field256) {
				this.field255 += var1;
				this.method729(var1);
				return;
			}

			int var2 = this.field256 - this.field255;
			this.method729(var2);
			var1 -= var2;
			this.field255 += var2;
			this.method720();
			class68 var3 = (class68)this.field253.method6364();
			synchronized(var3) {
				int var5 = var3.method1411(this);
				if (var5 < 0) {
					var3.field551 = 0;
					this.method722(var3);
				} else {
					var3.field551 = var5;
					this.method721(var3.field4682, var3);
				}
			}
		} while(var1 != 0);

	}

	void method729(int var1) {
		for (class51 var2 = (class51)this.field254.method6364(); var2 != null; var2 = (class51)this.field254.method6358()) {
			var2.method1001(var1);
		}

	}
}
