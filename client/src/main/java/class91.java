public class class91 extends class427 {
	static class28 field886;
	static class473 field882;
	static class488[] field883;
	class158 field880;
	class350 field879;

	class91(class158 var1) {
		this.field879 = new class350();
		this.field880 = var1;
	}

	void method1889(int var1, int var2, int var3, int var4) {
		class99 var6 = null;
		int var7 = 0;

		for (class99 var8 = (class99)this.field879.method6465(); var8 != null; var8 = (class99)this.field879.method6467()) {
			++var7;
			if (var1 == var8.field986) {
				var8.method1984(var1, var2, var3, var4);
				return;
			}

			if (var8.field986 <= var1) {
				var6 = var8;
			}
		}

		if (var6 == null) {
			if (var7 < 4) {
				this.field879.method6463(new class99(var1, var2, var3, var4));
			}

		} else {
			class350.method6476(new class99(var1, var2, var3, var4), var6);
			if (var7 >= 4) {
				this.field879.method6465().method7825();
			}

		}
	}

	class99 method1896(int var1) {
		class99 var3 = (class99)this.field879.method6465();
		if (null != var3 && var3.field986 <= var1) {
			for (class99 var4 = (class99)this.field879.method6467(); var4 != null && var4.field986 <= var1; var4 = (class99)this.field879.method6467()) {
				var3.method7825();
				var3 = var4;
			}

			if (var3.field986 + var3.field983 + this.field880.field1450 > var1) {
				return var3;
			} else {
				var3.method7825();
				return null;
			}
		} else {
			return null;
		}
	}

	boolean method1891() {
		return this.field879.method6531();
	}

	static final void method1892() {
		for (int var1 = 0; var1 < class102.field1012; ++var1) {
			class93 var2 = client.field1763[class102.field1013[var1]];
			var2.method1913();
		}

	}
}
