final class class454 implements class443 {
	static int currentPort;

	void method8046(String var1, Buffer var2) {
		var2.writeString(var1);
	}

	public Object method7925(Buffer var1) {
		return var1.readString();
	}

	public void method7924(Object var1, Buffer var2) {
		this.method8046((String)var1, var2);
	}
}
