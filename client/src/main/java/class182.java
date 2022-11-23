public class class182 extends class437 {
	public static class319 field1619;
	public static class319 field1622;
	public static int field1626;
	static class284 field1627;
	int[] field1624;
	int[] field1629;
	short[] field1620;
	short[] field1621;
	short[] field1625;
	short[] field1628;
	public boolean field1630;
	public int field1623;

	static {
		field1627 = new class284(64);
	}

	class182() {
		this.field1623 = -1;
		this.field1629 = new int[]{-1, -1, -1, -1, -1};
		this.field1630 = false;
	}

	void method2846(Buffer var1) {
		while (true) {
			int var3 = var1.readUnsignedByte();
			if (var3 == 0) {
				return;
			}

			this.method2849(var1, var3);
		}
	}

	void method2849(Buffer var1, int var2) {
		if (var2 == 1) {
			this.field1623 = var1.readUnsignedByte();
		} else {
			int var4;
			int var5;
			if (var2 == 2) {
				var4 = var1.readUnsignedByte();
				this.field1624 = new int[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field1624[var5] = var1.readUnsignedShort();
				}
			} else if (var2 == 3) {
				this.field1630 = true;
			} else if (var2 == 40) {
				var4 = var1.readUnsignedByte();
				this.field1625 = new short[var4];
				this.field1620 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field1625[var5] = (short)var1.readUnsignedShort();
					this.field1620[var5] = (short)var1.readUnsignedShort();
				}
			} else if (var2 == 41) {
				var4 = var1.readUnsignedByte();
				this.field1621 = new short[var4];
				this.field1628 = new short[var4];

				for (var5 = 0; var5 < var4; ++var5) {
					this.field1621[var5] = (short)var1.readUnsignedShort();
					this.field1628[var5] = (short)var1.readUnsignedShort();
				}
			} else if (var2 >= 60 && var2 < 70) {
				this.field1629[var2 - 60] = var1.readUnsignedShort();
			}
		}

	}

	public static void method2856() {
		try {
			if (1 == class279.field3202) {
				int var1 = class279.field3201.method5382();
				if (var1 > 0 && class279.field3201.method5278()) {
					var1 -= class13.field67;
					if (var1 < 0) {
						var1 = 0;
					}

					class279.field3201.method5271(var1);
					return;
				}

				class279.field3201.method5365();
				class279.field3201.method5275();
				if (null != class7.field29) {
					class279.field3202 = 2;
				} else {
					class279.field3202 = 0;
				}

				class141.field1300 = null;
				class370.field4368 = null;
			}
		} catch (Exception var3) {
			var3.printStackTrace();
			class279.field3201.method5365();
			class279.field3202 = 0;
			class141.field1300 = null;
			class370.field4368 = null;
			class7.field29 = null;
		}

	}

	public boolean method2848() {
		if (this.field1624 == null) {
			return true;
		} else {
			boolean var2 = true;

			for (int var3 = 0; var3 < this.field1624.length; ++var3) {
				if (!field1619.method6089(this.field1624[var3], 0)) {
					var2 = false;
				}
			}

			return var2;
		}
	}

	public class201 method2863() {
		if (null == this.field1624) {
			return null;
		} else {
			class201[] var2 = new class201[this.field1624.length];

			for (int var3 = 0; var3 < this.field1624.length; ++var3) {
				var2[var3] = class201.method3774(field1619, this.field1624[var3], 0);
			}

			class201 var5;
			if (1 == var2.length) {
				var5 = var2[0];
			} else {
				var5 = new class201(var2, var2.length);
			}

			int var4;
			if (this.field1625 != null) {
				for (var4 = 0; var4 < this.field1625.length; ++var4) {
					var5.method3790(this.field1625[var4], this.field1620[var4]);
				}
			}

			if (null != this.field1621) {
				for (var4 = 0; var4 < this.field1621.length; ++var4) {
					var5.method3791(this.field1621[var4], this.field1628[var4]);
				}
			}

			return var5;
		}
	}

	public boolean method2850() {
		boolean var2 = true;

		for (int var3 = 0; var3 < 5; ++var3) {
			if (-1 != this.field1629[var3] && !field1619.method6089(this.field1629[var3], 0)) {
				var2 = false;
			}
		}

		return var2;
	}

	public class201 method2852() {
		class201[] var2 = new class201[5];
		int var3 = 0;

		for (int var4 = 0; var4 < 5; ++var4) {
			if (this.field1629[var4] != -1) {
				var2[var3++] = class201.method3774(field1619, this.field1629[var4], 0);
			}
		}

		class201 var6 = new class201(var2, var3);
		int var5;
		if (null != this.field1625) {
			for (var5 = 0; var5 < this.field1625.length; ++var5) {
				var6.method3790(this.field1625[var5], this.field1620[var5]);
			}
		}

		if (null != this.field1621) {
			for (var5 = 0; var5 < this.field1621.length; ++var5) {
				var6.method3791(this.field1621[var5], this.field1628[var5]);
			}
		}

		return var6;
	}

	public static void method2825() {
		field1627.method5437();
	}
}
