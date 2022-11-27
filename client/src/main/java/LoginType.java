public class LoginType implements ClientProt {
	public static final LoginType RECONNECT;
	public static final LoginType field2976;
	public static final LoginType PROOF_OF_WORK;
	public static final LoginType NORMAL;
	static final LoginType field2974;
	static final LoginType field2978;
	static final LoginType[] field2973;
	public final int id;

	static {
		field2976 = new LoginType(14);
		field2974 = new LoginType(15);
		NORMAL = new LoginType(16);
		RECONNECT = new LoginType(18);
		PROOF_OF_WORK = new LoginType(19);
		field2978 = new LoginType(27);
		field2973 = new LoginType[32];
		LoginType[] var0 = new LoginType[]{RECONNECT, NORMAL, PROOF_OF_WORK, field2978, field2974, field2976};
		LoginType[] var1 = var0;

		for (int var2 = 0; var2 < var1.length; ++var2) {
			field2973[var1[var2].id] = var1[var2];
		}

	}

	LoginType(int var1) {
		this.id = var1;
	}
}
