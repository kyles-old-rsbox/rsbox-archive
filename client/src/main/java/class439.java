public class class439 extends class427 {
	boolean field4738;
	boolean field4744;
	int field4729;
	int field4731;
	int field4733;
	int field4737;
	int field4740;
	int field4741;
	int field4742;
	int field4743;
	int field4745;
	int field4746;
	int field4747;
	int field4754;
	int field4756;
	int field4760;
	int field4761;
	int[] field4759;
	String field4732;
	String field4748;
	String field4749;
	String field4750;
	String field4751;
	String field4752;
	String field4757;
	String field4758;

	class439(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17, int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25, String var26) {
		this.field4759 = new int[3];
		this.field4747 = var1;
		this.field4738 = var2;
		this.field4737 = var3;
		this.field4740 = var4;
		this.field4741 = var5;
		this.field4731 = var6;
		this.field4743 = var7;
		this.field4744 = var8;
		this.field4729 = var9;
		this.field4746 = var10;
		this.field4742 = var11;
		this.field4756 = var12;
		this.field4749 = var13;
		this.field4750 = var14;
		this.field4732 = var15;
		this.field4752 = var16;
		this.field4761 = var17;
		this.field4754 = var18;
		this.field4745 = var19;
		this.field4733 = var20;
		this.field4757 = var21;
		this.field4758 = var22;
		this.field4759 = var23;
		this.field4760 = var24;
		this.field4748 = var25;
		this.field4751 = var26;
	}

	public void write(Buffer var1) {
		var1.writeByte(9);
		var1.writeByte(this.field4747);
		var1.writeByte(this.field4738 ? 1 : 0);
		var1.writeShort(this.field4737);
		var1.writeByte(this.field4740);
		var1.writeByte(this.field4741);
		var1.writeByte(this.field4731);
		var1.writeByte(this.field4743);
		var1.writeByte(this.field4744 ? 1 : 0);
		var1.writeShort(this.field4729);
		var1.writeByte(this.field4746);
		var1.writeMedium(this.field4742);
		var1.writeShort(this.field4756);
		var1.method8112(this.field4749);
		var1.method8112(this.field4750);
		var1.method8112(this.field4732);
		var1.method8112(this.field4752);
		var1.writeByte(this.field4754);
		var1.writeShort(this.field4761);
		var1.method8112(this.field4757);
		var1.method8112(this.field4758);
		var1.writeByte(this.field4745);
		var1.writeByte(this.field4733);

		for (int var3 = 0; var3 < this.field4759.length; ++var3) {
			var1.writeInt(this.field4759[var3]);
		}

		var1.writeInt(this.field4760);
		var1.method8112(this.field4748);
		var1.method8112(this.field4751);
	}

	public int size() {
		byte var2 = 39;
		String var5 = this.field4749;
		int var4 = var5.length() + 2;
		int var27 = var2 + var4;
		String var8 = this.field4750;
		int var7 = var8.length() + 2;
		var27 += var7;
		String var11 = this.field4732;
		int var10 = var11.length() + 2;
		var27 += var10;
		String var14 = this.field4752;
		int var13 = var14.length() + 2;
		var27 += var13;
		String var17 = this.field4757;
		int var16 = var17.length() + 2;
		var27 += var16;
		String var20 = this.field4758;
		int var19 = var20.length() + 2;
		var27 += var19;
		String var23 = this.field4748;
		int var22 = var23.length() + 2;
		var27 += var22;
		String var26 = this.field4751;
		int var25 = var26.length() + 2;
		var27 += var25;
		return var27;
	}
}
