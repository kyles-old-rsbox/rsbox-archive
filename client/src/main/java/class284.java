public final class class284 {
	class355 field3331;
	class421 field3330;
	class437 field3328;
	int field3327;
	int field3329;

	public class284(int var1) {
		this.field3328 = new class437();
		this.field3331 = new class355();
		this.field3327 = var1;
		this.field3329 = var1;

		int var2;
		for (var2 = 1; var2 + var2 < var1; var2 += var2) {
		}

		this.field3330 = new class421(var2);
	}

	public class437 method5439(long var1) {
		class437 var3 = (class437)this.field3330.method7788(var1);
		if (var3 != null) {
			this.field3331.method6599(var3);
		}

		return var3;
	}

	public void method5441(long var1) {
		class437 var3 = (class437)this.field3330.method7788(var1);
		if (var3 != null) {
			var3.method7825();
			var3.method7889();
			++this.field3329;
		}

	}

	public void method5434(class437 var1, long var2) {
		if (this.field3329 == 0) {
			class437 var4 = this.field3331.method6588();
			var4.method7825();
			var4.method7889();
			if (var4 == this.field3328) {
				var4 = this.field3331.method6588();
				var4.method7825();
				var4.method7889();
			}
		} else {
			--this.field3329;
		}

		this.field3330.method7781(var1, var2);
		this.field3331.method6599(var1);
	}

	public void method5437() {
		this.field3331.clear();
		this.field3330.clear();
		this.field3328 = new class437();
		this.field3329 = this.field3327;
	}
}
