public class class470 {
	boolean field4937;
	int field4932;
	int field4933;
	int field4934;
	int field4935;
	int field4936;
	int field4939;
	int field4940;
	int field4941;
	int field4942;
	int field4943;
	int field4944;
	int field4945;

	public class470() {
		this.field4939 = 0;
		this.field4940 = 0;
	}

	public void method8427(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, boolean var11) {
		this.field4933 = var1;
		this.field4934 = var2;
		this.field4944 = var3;
		this.field4936 = var4;
		this.field4932 = var5;
		this.field4943 = var6;
		this.field4939 = var9;
		this.field4940 = var10;
		this.field4937 = var11;
	}

	public void method8428(int var1, int var2, int var3, int var4) {
		this.field4942 = var1;
		this.field4935 = var2;
		this.field4941 = var3;
		this.field4945 = var4;
	}

	public void method8426(class390 var1, class376 var2) {
		if (var2 != null) {
			int var4 = var2.field4435;
			int var5 = Math.min(this.field4936, (int)((float)var4 * 0.9F));
			int var6 = this.field4933 - this.field4932;
			int var7 = var4 + (this.field4934 - this.field4943);
			class481.method8653(this.field4933, this.field4934, this.field4933 + this.field4944, this.field4936 + this.field4934);
			int var8 = this.field4940;
			int var9 = this.field4939;
			if (var8 > var9) {
				int var10 = var8;
				var8 = var9;
				var9 = var10;
			}

			class388 var20 = var1.method7039(0, var8);
			class388 var11 = var1.method7039(var8, var9);
			class388 var12 = var1.method7039(var9, var1.method7091());
			class388 var13 = var1.method7039(0, this.field4939);
			int var15;
			int var17;
			if (!var11.method6993()) {
				int var14 = var2.field4436 + var2.field4437;

				for (var15 = 0; var15 < var11.method6994(); ++var15) {
					class383 var16 = var11.method7010(var15);
					var17 = var16.field4422 + var6;
					int var18 = var2.method6927(var16.field4428);
					int var19 = var16.field4424 + var7 - var4;
					class481.method8660(var17, var19, var18, var14, this.field4945);
				}
			}

			if (!var20.method6993()) {
				var2.method6871(var20, var6, var7, this.field4942, this.field4935, -1);
			}

			if (!var11.method6993()) {
				var2.method6871(var11, var6, var7, this.field4941, this.field4935, -1);
			}

			if (!var12.method6993()) {
				var2.method6871(var12, var6, var7, this.field4942, this.field4935, -1);
			}

			if (this.field4937) {
				class438 var21 = var13.method6997();
				var15 = var6 + (Integer)var21.field4727;
				int var22 = var7 + (Integer)var21.field4728;
				var17 = var22 - var5;
				class481.method8670(var15, var22, var15, var17, this.field4942);
				if (this.field4935 != -1) {
					class481.method8670(1 + var15, 1 + var22, 1 + var15, var17 + 1, this.field4935);
				}
			}

		}
	}
}
