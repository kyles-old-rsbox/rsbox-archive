public class class168 extends class175 {
	long field1531;

	public class168() {
		this.field1531 = System.nanoTime();
	}

	public void method2748() {
		this.field1531 = System.nanoTime();
	}

	public int method2746(int var1, int var2) {
		long var4 = 1000000L * (long)var2;
		long var6 = this.field1531 - System.nanoTime();
		if (var6 < var4) {
			var6 = var4;
		}

		class266.method3531(var6 / 1000000L);
		long var8 = System.nanoTime();

		int var10;
		for (var10 = 0; var10 < 10 && (var10 < 1 || this.field1531 < var8); this.field1531 += 1000000L * (long)var1) {
			++var10;
		}

		if (this.field1531 < var8) {
			this.field1531 = var8;
		}

		return var10;
	}
}
