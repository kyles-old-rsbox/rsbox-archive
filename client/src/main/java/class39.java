public class class39 extends class56 {
	int field260;
	public boolean field261;
	public byte[] field258;
	public int field257;
	public int field259;

	class39(int var1, byte[] var2, int var3, int var4) {
		this.field257 = var1;
		this.field258 = var2;
		this.field259 = var3;
		this.field260 = var4;
	}

	class39(int var1, byte[] var2, int var3, int var4, boolean var5) {
		this.field257 = var1;
		this.field258 = var2;
		this.field259 = var3;
		this.field260 = var4;
		this.field261 = var5;
	}

	public class39 method752(class64 var1) {
		this.field258 = var1.method1368(this.field258);
		this.field257 = var1.method1370(this.field257);
		if (this.field259 == this.field260) {
			this.field259 = this.field260 = var1.method1372(this.field259);
		} else {
			this.field259 = var1.method1372(this.field259);
			this.field260 = var1.method1372(this.field260);
			if (this.field259 == this.field260) {
				--this.field259;
			}
		}

		return this;
	}
}
