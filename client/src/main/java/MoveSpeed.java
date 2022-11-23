public class MoveSpeed implements class360 {
	public static final MoveSpeed field2113;
	public static final MoveSpeed field2114;
	public static final MoveSpeed field2116;
	public static final MoveSpeed NONE;
	static class439 platformInfo;
	public byte speed;

	static {
		NONE = new MoveSpeed((byte)-1);
		field2113 = new MoveSpeed((byte)0);
		field2114 = new MoveSpeed((byte)1);
		field2116 = new MoveSpeed((byte)2);
	}

	public static MoveSpeed[] method7499() {
		return new MoveSpeed[]{NONE, field2114, field2116, field2113};
	}

	MoveSpeed(byte var1) {
		this.speed = var1;
	}

	public int rsOrdinal() {
		return this.speed;
	}
}
