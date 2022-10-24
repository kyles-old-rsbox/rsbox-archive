public class class400 implements Comparable {
	class472 field4503;
	class472 field4504;

	class400() {
	}

	public class472 method7232() {
		return this.field4503;
	}

	public String method7249() {
		return null == this.field4503 ? "" : this.field4503.method8451();
	}

	public String method7234() {
		return null == this.field4504 ? "" : this.field4504.method8451();
	}

	void method7235(class472 var1, class472 var2) {
		if (null == var1) {
			throw new NullPointerException();
		} else {
			this.field4503 = var1;
			this.field4504 = var2;
		}
	}

	public int method7236(class400 var1) {
		return this.field4503.method8457(var1.field4503);
	}

	public int compareTo(Object var1) {
		return this.method7236((class400)var1);
	}
}
