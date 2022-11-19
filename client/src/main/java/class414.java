public class class414 {
	static int field4588;
	float field4576;
	float field4577;
	float field4578;
	float field4579;
	float field4580;
	float field4581;
	float field4582;
	float field4583;
	float field4584;
	float field4585;
	float field4586;
	float field4587;

	static {
		new class414();
	}

	class414() {
		this.method7503();
	}

	void method7503() {
		this.field4587 = 0.0F;
		this.field4586 = 0.0F;
		this.field4585 = 0.0F;
		this.field4579 = 0.0F;
		this.field4582 = 0.0F;
		this.field4581 = 0.0F;
		this.field4576 = 0.0F;
		this.field4578 = 0.0F;
		this.field4577 = 0.0F;
		this.field4584 = 1.0F;
		this.field4580 = 1.0F;
		this.field4583 = 1.0F;
	}

	void method7502(float var1) {
		float var3 = (float)Math.cos((double)var1);
		float var4 = (float)Math.sin((double)var1);
		float var5 = this.field4577;
		float var6 = this.field4580;
		float var7 = this.field4579;
		float var8 = this.field4586;
		this.field4577 = var3 * var5 - this.field4578 * var4;
		this.field4578 = var4 * var5 + var3 * this.field4578;
		this.field4580 = var3 * var6 - var4 * this.field4581;
		this.field4581 = var4 * var6 + this.field4581 * var3;
		this.field4579 = var3 * var7 - this.field4584 * var4;
		this.field4584 = this.field4584 * var3 + var4 * var7;
		this.field4586 = var8 * var3 - var4 * this.field4587;
		this.field4587 = var4 * var8 + var3 * this.field4587;
	}

	void method7520(float var1) {
		float var3 = (float)Math.cos((double)var1);
		float var4 = (float)Math.sin((double)var1);
		float var5 = this.field4583;
		float var6 = this.field4576;
		float var7 = this.field4582;
		float var8 = this.field4585;
		this.field4583 = var3 * var5 + this.field4578 * var4;
		this.field4578 = this.field4578 * var3 - var4 * var5;
		this.field4576 = var6 * var3 + this.field4581 * var4;
		this.field4581 = this.field4581 * var3 - var4 * var6;
		this.field4582 = this.field4584 * var4 + var7 * var3;
		this.field4584 = this.field4584 * var3 - var7 * var4;
		this.field4585 = var4 * this.field4587 + var8 * var3;
		this.field4587 = var3 * this.field4587 - var4 * var8;
	}

	void method7521(float var1) {
		float var3 = (float)Math.cos((double)var1);
		float var4 = (float)Math.sin((double)var1);
		float var5 = this.field4583;
		float var6 = this.field4576;
		float var7 = this.field4582;
		float var8 = this.field4585;
		this.field4583 = var3 * var5 - var4 * this.field4577;
		this.field4577 = var4 * var5 + this.field4577 * var3;
		this.field4576 = var3 * var6 - this.field4580 * var4;
		this.field4580 = var6 * var4 + var3 * this.field4580;
		this.field4582 = var3 * var7 - this.field4579 * var4;
		this.field4579 = this.field4579 * var3 + var7 * var4;
		this.field4585 = var8 * var3 - var4 * this.field4586;
		this.field4586 = var8 * var4 + this.field4586 * var3;
	}

	void method7504(float var1, float var2, float var3) {
		this.field4585 += var1;
		this.field4586 += var2;
		this.field4587 += var3;
	}

	public String toString() {
		return this.field4583 + "," + this.field4576 + "," + this.field4582 + "," + this.field4585 + "\n" + this.field4577 + "," + this.field4580 + "," + this.field4579 + "," + this.field4586 + "\n" + this.field4578 + "," + this.field4581 + "," + this.field4584 + "," + this.field4587;
	}

	static final void method7518(int var0, int var1) {
		class147 var3 = var0 >= 0 ? client.field1883[var0] : class188.field1982;
		if (null != var3 && var1 >= 0 && var1 < var3.method2512()) {
			class133 var4 = (class133)var3.field1347.get(var1);
			if (var4.field1256 == -1) {
				String var5 = var4.field1254.method8451();
				class263 var6 = class185.method3435(class274.field3082, client.field1778.field1071);
				var6.field2984.method8104(3 + class460.method1887(var5));
				var6.field2984.method8104(var0);
				var6.field2984.method8181(var1);
				var6.field2984.method8111(var5);
				client.field1778.method2078(var6);
			}
		}
	}
}
