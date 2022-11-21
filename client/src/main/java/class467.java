final class class467 implements class443 {
	static int[] field4921;

	void method8416(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	public Object method7925(Buffer var1) {
		return var1.readInt();
	}

	public void method7924(Object var1, Buffer var2) {
		this.method8416((Integer)var1, var2);
	}
}
