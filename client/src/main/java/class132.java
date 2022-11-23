public class class132 extends class140 {
	static class300 field1247;
	String field1244;
	long field1245;
	// $FF: synthetic field
	final class142 this$0;

	static int method2409(int var0) {
		class63 var2 = (class63) MessagesManager.hashTable.method7788((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var2.field4724 == MessagesManager.queue.field4305 ? -1 : ((class63)var2.field4724).field496;
		}
	}

	class132(class142 var1) {
		this.this$0 = var1;
		this.field1245 = -1L;
		this.field1244 = null;
	}

	void method2467(Buffer var1) {
		if (var1.readUnsignedByte() != 255) {
			--var1.offset;
			this.field1245 = var1.readLong();
		}

		this.field1244 = var1.method8305();
	}

	void method2468(class148 var1) {
		var1.method2529(this.field1245, this.field1244, 0);
	}
}
