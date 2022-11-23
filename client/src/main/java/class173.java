public class class173 extends class437 {
	public static class284 field1561;
	public static class319 field1560;
	public boolean field1562;

	public class173() {
		this.field1562 = false;
	}

	static {
		field1561 = new class284(64);
	}

	public void method2738(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method2742(var1, var3);
		}
	}

	void method2742(Buffer var1, int var2) {
		if (var2 == 2) {
			this.field1562 = true;
		}

	}
}
