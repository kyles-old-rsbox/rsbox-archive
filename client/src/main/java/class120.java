public class class120 extends class393 {
	static int field1161;
	final boolean field1162;

	public class120(boolean var1) {
		this.field1162 = var1;
	}

	int method2279(class396 var1, class396 var2) {
		if (0 != var1.field4491) {
			if (var2.field4491 == 0) {
				return this.field1162 ? -1 : 1;
			}
		} else if (var2.field4491 != 0) {
			return this.field1162 ? 1 : -1;
		}

		return this.method7162(var1, var2);
	}

	public int compare(Object var1, Object var2) {
		return this.method2279((class396)var1, (class396)var2);
	}
}
