public class class382 {
	int field4417;
	int field4418;
	int field4419;
	int field4420;
	long field4411;
	long field4412;
	long field4414;
	long field4415;
	long field4416;
	public boolean field4413;

	public class382() {
		this.field4415 = -1L;
		this.field4412 = -1L;
		this.field4413 = false;
		this.field4414 = 0L;
		this.field4411 = 0L;
		this.field4416 = 0L;
		this.field4417 = 0;
		this.field4419 = 0;
		this.field4418 = 0;
		this.field4420 = 0;
	}

	public void method6829() {
		this.field4415 = class272.method2046();
	}

	public void method6830() {
		if (-1L != this.field4415) {
			this.field4411 = class272.method2046() - this.field4415;
			this.field4415 = -1L;
		}

	}

	public void method6843(int var1) {
		this.field4412 = class272.method2046();
		this.field4417 = var1;
	}

	public void method6846() {
		if (this.field4412 != -1L) {
			this.field4414 = class272.method2046() - this.field4412;
			this.field4412 = -1L;
		}

		++this.field4418;
		this.field4413 = true;
	}

	public void method6832() {
		this.field4413 = false;
		this.field4419 = 0;
	}

	public void method6833() {
		this.method6846();
	}

	public void method6834(class460 var1) {
		method4869(var1, this.field4411);
		method4869(var1, this.field4414);
		method4869(var1, this.field4416);
		var1.method8181(this.field4417);
		var1.method8181(this.field4419);
		var1.method8181(this.field4418);
		var1.method8181(this.field4420);
	}

	static void method4869(class460 var0, long var1) {
		var1 /= 10L;
		if (var1 < 0L) {
			var1 = 0L;
		} else if (var1 > 65535L) {
			var1 = 65535L;
		}

		var0.method8181((int)var1);
	}
}
