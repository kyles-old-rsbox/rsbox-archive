import java.util.Iterator;

public class class358 implements Iterator {
	class350 field4309;
	class427 field4310;
	class427 field4311;

	class358(class350 var1) {
		this.field4311 = null;
		this.method6612(var1);
	}

	void method6612(class350 var1) {
		this.field4309 = var1;
		this.method6609();
	}

	void method6609() {
		this.field4310 = this.field4309 != null ? this.field4309.field4272.field4682 : null;
		this.field4311 = null;
	}

	public Object next() {
		class427 var1 = this.field4310;
		if (var1 == this.field4309.field4272) {
			var1 = null;
			this.field4310 = null;
		} else {
			this.field4310 = var1.field4682;
		}

		this.field4311 = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.field4310 != this.field4309.field4272 && this.field4310 != null;
	}

	public void remove() {
		if (this.field4311 == null) {
			throw new IllegalStateException();
		} else {
			this.field4311.method7825();
			this.field4311 = null;
		}
	}
}
