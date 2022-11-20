public class class156 extends class137 {
	byte field1427;
	int field1428;
	int field1429;
	String field1426;
	// $FF: synthetic field
	final class143 this$0;

	class156(class143 var1) {
		this.this$0 = var1;
		this.field1429 = -1;
	}

	void method2441(Buffer var1) {
		var1.method8141();
		this.field1429 = var1.readUnsignedShort();
		this.field1427 = var1.method8287();
		this.field1428 = var1.readUnsignedShort();
		var1.readLong();
		this.field1426 = var1.readString();
		var1.method8141();
	}

	void method2442(class147 var1) {
		class133 var3 = (class133)var1.field1347.get(this.field1429);
		var3.field1256 = this.field1427;
		var3.field1249 = this.field1428;
		var3.field1254 = new class472(this.field1426);
	}
}
