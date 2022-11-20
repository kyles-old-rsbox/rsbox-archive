public final class class265 {
	class267 field3005;
	class355 field3004;
	class421 field3003;
	int field3001;
	int field3002;

	public class265(int var1) {
		this(var1, var1);
	}

	public class265(int var1, int var2) {
		this.field3004 = new class355();
		this.field3001 = var1;
		this.field3002 = var1;

		int var3;
		for (var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
		}

		this.field3003 = new class421(var3);
	}

	public Object method5177(long var1) {
		class285 var3 = (class285)this.field3003.method7788(var1);
		if (var3 == null) {
			return null;
		} else {
			Object var4 = var3.method5448();
			if (var4 == null) {
				var3.method7825();
				var3.method7889();
				this.field3002 += var3.field3332;
				return null;
			} else {
				if (var3.method5447()) {
					class280 var5 = new class280(var4, var3.field3332);
					this.field3003.method7781(var5, var3.field4681);
					this.field3004.method6599(var5);
					var5.field4723 = 0L;
					var3.method7825();
					var3.method7889();
				} else {
					this.field3004.method6599(var3);
					var3.field4723 = 0L;
				}

				return var4;
			}
		}
	}

	void method5172(long var1) {
		class285 var3 = (class285)this.field3003.method7788(var1);
		this.method5173(var3);
	}

	void method5173(class285 var1) {
		if (var1 != null) {
			var1.method7825();
			var1.method7889();
			this.field3002 += var1.field3332;
		}

	}

	public void method5174(Object var1, long var2) {
		this.method5170(var1, var2, 1);
	}

	public void method5170(Object var1, long var2, int var4) {
		if (var4 > this.field3001) {
			throw new IllegalStateException();
		} else {
			this.method5172(var2);
			this.field3002 -= var4;

			while (this.field3002 < 0) {
				class285 var5 = (class285)this.field3004.method6588();
				if (var5 == null) {
					throw new RuntimeException("");
				}

				if (!var5.method5447()) {
				}

				this.method5173(var5);
				if (this.field3005 != null) {
					this.field3005.method5201(var5.method5448());
				}
			}

			class280 var6 = new class280(var1, var4);
			this.field3003.method7781(var6, var2);
			this.field3004.method6599(var6);
			var6.field4723 = 0L;
		}
	}

	public void method5193(int var1) {
		for (class285 var2 = (class285)this.field3004.method6589(); var2 != null; var2 = (class285)this.field3004.method6591()) {
			if (var2.method5447()) {
				if (var2.method5448() == null) {
					var2.method7825();
					var2.method7889();
					this.field3002 += var2.field3332;
				}
			} else if (++var2.field4723 > (long)var1) {
				class268 var3 = new class268(var2.method5448(), var2.field3332);
				this.field3003.method7781(var3, var2.field4681);
				class355.method6587(var3, var2);
				var2.method7825();
				var2.method7889();
			}
		}

	}

	public void method5185() {
		this.field3004.clear();
		this.field3003.clear();
		this.field3002 = this.field3001;
	}
}
