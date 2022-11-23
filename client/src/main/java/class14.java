public class class14 {
	final int field68;
	final int field69;
	final String field70;

	class14(int var1, int var2, String var3) {
		this.field69 = var1;
		this.field68 = var2;
		this.field70 = var3;
	}

	class14(Buffer var1) {
		this(var1.readUnsignedByte(), var1.readUnsignedByte(), var1.readString());
	}

	String method122() {
		return Integer.toHexString(this.field69) + Integer.toHexString(this.field68) + this.field70;
	}

	int method124() {
		return this.field68;
	}
}
