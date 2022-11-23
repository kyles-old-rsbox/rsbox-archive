public class class150 extends class137 {
	byte field1397;
	int field1398;
	int field1401;
	String field1400;
	// $FF: synthetic field
	final class143 this$0;

	public static long method2591(int var0) {
		if (var0 > 63) {
			throw new class340("Cannot generate max unsigned value for more than 63 bits as this is greater than the boundaries of a java long. Value provided: %d", new Object[]{var0});
		} else {
			return (long)Math.pow(2.0D, (double)var0) - 1L;
		}
	}

	class150(class143 var1) {
		this.this$0 = var1;
		this.field1398 = -1;
	}

	void method2441(Buffer var1) {
		this.field1398 = var1.readUnsignedShort();
		this.field1397 = var1.readByte();
		this.field1401 = var1.readUnsignedShort();
		var1.readLong();
		this.field1400 = var1.readString();
	}

	void method2442(class147 var1) {
		class133 var3 = (class133)var1.field1347.get(this.field1398);
		var3.field1256 = this.field1397;
		var3.field1249 = this.field1401;
		var3.field1254 = new DisplayName(this.field1400);
	}
}
