public final class class415 {
	static class415[] field4595;
	static int field4590;
	static int field4594;
	float field4589;
	float field4591;
	float field4592;
	float field4593;

	static {
		field4595 = new class415[0];
		field4590 = 100;
		field4595 = new class415[100];
		field4594 = 0;
		new class415();
	}

	public void method7535() {
		synchronized(field4595) {
			if (field4594 < field4590 - 1) {
				field4595[++field4594 - 1] = this;
			}

		}
	}

	class415() {
		this.method7545();
	}

	void method7529(float var1, float var2, float var3, float var4) {
		this.field4592 = var1;
		this.field4589 = var2;
		this.field4593 = var3;
		this.field4591 = var4;
	}

	public void method7550(float var1, float var2, float var3, float var4) {
		float var6 = (float)Math.sin((double)(var4 * 0.5F));
		float var7 = (float)Math.cos((double)(var4 * 0.5F));
		this.field4592 = var1 * var6;
		this.field4589 = var2 * var6;
		this.field4593 = var6 * var3;
		this.field4591 = var7;
	}

	final void method7545() {
		this.field4593 = 0.0F;
		this.field4589 = 0.0F;
		this.field4592 = 0.0F;
		this.field4591 = 1.0F;
	}

	public final void method7527(class415 var1) {
		this.method7529(var1.field4592 * this.field4591 + this.field4592 * var1.field4591 + this.field4593 * var1.field4589 - this.field4589 * var1.field4593, var1.field4593 * this.field4592 + var1.field4589 * this.field4591 + (var1.field4591 * this.field4589 - this.field4593 * var1.field4592), this.field4593 * var1.field4591 + this.field4589 * var1.field4592 - var1.field4589 * this.field4592 + var1.field4593 * this.field4591, var1.field4591 * this.field4591 - this.field4592 * var1.field4592 - var1.field4589 * this.field4589 - var1.field4593 * this.field4593);
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class415)) {
			return false;
		} else {
			class415 var2 = (class415)var1;
			return var2.field4592 == this.field4592 && this.field4589 == var2.field4589 && this.field4593 == var2.field4593 && var2.field4591 == this.field4591;
		}
	}

	public int hashCode() {
		boolean var1 = true;
		float var2 = 1.0F;
		var2 = var2 * 31.0F + this.field4592;
		var2 = var2 * 31.0F + this.field4589;
		var2 = this.field4593 + var2 * 31.0F;
		var2 = var2 * 31.0F + this.field4591;
		return (int)var2;
	}

	public String toString() {
		return this.field4592 + "," + this.field4589 + "," + this.field4593 + "," + this.field4591;
	}

	static float method7530(class405 var0, float var1, float var2, float var3) {
		float var5 = class405.method45(var0.field4520, var0.field4519, var1);
		if (Math.abs(var5) < class127.field1227) {
			return var1;
		} else {
			float var6 = class405.method45(var0.field4520, var0.field4519, var2);
			if (Math.abs(var6) < class127.field1227) {
				return var2;
			} else {
				float var7 = 0.0F;
				float var8 = 0.0F;
				float var9 = 0.0F;
				float var14 = 0.0F;
				boolean var15 = true;
				boolean var16 = false;

				do {
					var16 = false;
					if (var15) {
						var7 = var1;
						var14 = var5;
						var8 = var2 - var1;
						var9 = var8;
						var15 = false;
					}

					if (Math.abs(var14) < Math.abs(var6)) {
						var1 = var2;
						var2 = var7;
						var7 = var1;
						var5 = var6;
						var6 = var14;
						var14 = var5;
					}

					float var17 = class127.field1225 * Math.abs(var2) + var3 * 0.5F;
					float var18 = 0.5F * (var7 - var2);
					boolean var19 = Math.abs(var18) > var17 && 0.0F != var6;
					if (var19) {
						if (Math.abs(var9) >= var17 && Math.abs(var5) > Math.abs(var6)) {
							float var13 = var6 / var5;
							float var10;
							float var11;
							if (var7 == var1) {
								var10 = var18 * 2.0F * var13;
								var11 = 1.0F - var13;
							} else {
								var11 = var5 / var14;
								float var12 = var6 / var14;
								var10 = var13 * (var11 * var18 * 2.0F * (var11 - var12) - (var2 - var1) * (var12 - 1.0F));
								var11 = (var13 - 1.0F) * (var12 - 1.0F) * (var11 - 1.0F);
							}

							if ((double)var10 > 0.0D) {
								var11 = -var11;
							} else {
								var10 = -var10;
							}

							var13 = var9;
							var9 = var8;
							if (var10 * 2.0F < var11 * var18 * 3.0F - Math.abs(var17 * var11) && var10 < Math.abs(var11 * var13 * 0.5F)) {
								var8 = var10 / var11;
							} else {
								var8 = var18;
								var9 = var18;
							}
						} else {
							var8 = var18;
							var9 = var18;
						}

						var1 = var2;
						var5 = var6;
						if (Math.abs(var8) > var17) {
							var2 += var8;
						} else if ((double)var18 > 0.0D) {
							var2 += var17;
						} else {
							var2 -= var17;
						}

						var6 = class405.method45(var0.field4520, var0.field4519, var2);
						if ((double)(var6 * (var14 / Math.abs(var14))) > 0.0D) {
							var15 = true;
							var16 = true;
						} else {
							var16 = true;
						}
					}
				} while(var16);

				return var2;
			}
		}
	}
}
