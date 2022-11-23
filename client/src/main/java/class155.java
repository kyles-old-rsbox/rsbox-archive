public class class155 extends class140 {
	static class336 field1425;
	boolean field1423;
	byte field1418;
	byte field1419;
	byte field1421;
	byte field1422;
	// $FF: synthetic field
	final class142 this$0;

	class155(class142 var1) {
		this.this$0 = var1;
	}

	void method2467(Buffer var1) {
		this.field1423 = var1.readUnsignedByte() == 1;
		this.field1419 = var1.readByte();
		this.field1418 = var1.readByte();
		this.field1421 = var1.readByte();
		this.field1422 = var1.readByte();
	}

	void method2468(class148 var1) {
		var1.field1364 = this.field1423;
		var1.field1367 = this.field1419;
		var1.field1357 = this.field1418;
		var1.field1377 = this.field1421;
		var1.field1368 = this.field1422;
	}
}
