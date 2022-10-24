public final class class354 {
	class437 field4304;

	public class354() {
		this.field4304 = new class437();
		this.field4304.field4724 = this.field4304;
		this.field4304.field4725 = this.field4304;
	}

	public void method6571(class437 var1) {
		if (var1.field4725 != null) {
			var1.method7889();
		}

		var1.field4725 = this.field4304.field4725;
		var1.field4724 = this.field4304;
		var1.field4725.field4724 = var1;
		var1.field4724.field4725 = var1;
	}

	public void method6579(class437 var1) {
		if (var1.field4725 != null) {
			var1.method7889();
		}

		var1.field4725 = this.field4304;
		var1.field4724 = this.field4304.field4724;
		var1.field4725.field4724 = var1;
		var1.field4724.field4725 = var1;
	}

	public class437 method6573() {
		class437 var1 = this.field4304.field4724;
		return var1 == this.field4304 ? null : var1;
	}
}
