public class class1 implements ProofOfWorkMessage {
	class1() {
	}

	public Buffer method339(Buffer var1) {
		Buffer var2 = new Buffer(100);
		this.method3(var1, var2);
		return var2;
	}

	void method3(Buffer var1, Buffer var2) {
		class14 var3 = new class14(var1);
		class10 var4 = new class10(var3);

		long var5;
		for (var5 = 0L; !var4.method66(var3.method124(), var3.method122(), var5); ++var5) {
		}

		var2.writeLong(var5);
	}
}
