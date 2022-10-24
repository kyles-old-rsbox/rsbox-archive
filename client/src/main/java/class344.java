public class class344 {
	class423 field4231;
	class423 field4232;

	public class344() {
		this.field4232 = new class423();
		this.field4232.field4675 = this.field4232;
		this.field4232.field4674 = this.field4232;
	}

	public void method6382(class423 var1) {
		if (var1.field4674 != null) {
			var1.method7811();
		}

		var1.field4674 = this.field4232.field4674;
		var1.field4675 = this.field4232;
		var1.field4674.field4675 = var1;
		var1.field4675.field4674 = var1;
	}

	public class423 method6384() {
		class423 var1 = this.field4232.field4675;
		if (var1 == this.field4232) {
			this.field4231 = null;
			return null;
		} else {
			this.field4231 = var1.field4675;
			return var1;
		}
	}

	public class423 method6381() {
		class423 var1 = this.field4231;
		if (var1 == this.field4232) {
			this.field4231 = null;
			return null;
		} else {
			this.field4231 = var1.field4675;
			return var1;
		}
	}
}
