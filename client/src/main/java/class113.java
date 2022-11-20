public class class113 {
	boolean field1114;
	boolean field1115;
	class412 field1116;
	class412 field1117;
	class412 field1120;
	class412[] field1112;
	class412[] field1113;
	float[][] field1118;
	float[][] field1119;
	float[][] field1121;
	float[][] field1122;
	final class412[] field1111;
	public class113 field1110;
	public final int field1109;

	public class113(int var1, Buffer var2, boolean var3) {
		this.field1120 = new class412();
		this.field1115 = true;
		this.field1116 = new class412();
		this.field1114 = true;
		this.field1117 = new class412();
		this.field1109 = var2.method8204();
		this.field1111 = new class412[var1];
		this.field1112 = new class412[this.field1111.length];
		this.field1113 = new class412[this.field1111.length];
		this.field1122 = new float[this.field1111.length][3];

		for (int var4 = 0; var4 < this.field1111.length; ++var4) {
			this.field1111[var4] = new class412(var2, var3);
			this.field1122[var4][0] = var2.method8128();
			this.field1122[var4][1] = var2.method8128();
			this.field1122[var4][2] = var2.method8128();
		}

		this.method2172();
	}

	void method2172() {
		this.field1119 = new float[this.field1111.length][3];
		this.field1118 = new float[this.field1111.length][3];
		this.field1121 = new float[this.field1111.length][3];
		class412 var2 = class295.method5542();

		for (int var3 = 0; var3 < this.field1111.length; ++var3) {
			class412 var4 = this.method2210(var3);
			var2.method7422(var4);
			var2.method7452();
			this.field1119[var3] = var2.method7419();
			this.field1118[var3][0] = var4.field4563[12];
			this.field1118[var3][1] = var4.field4563[13];
			this.field1118[var3][2] = var4.field4563[14];
			this.field1121[var3] = var4.method7432();
		}

		var2.method7469();
	}

	class412 method2210(int var1) {
		return this.field1111[var1];
	}

	class412 method2190(int var1) {
		if (null == this.field1112[var1]) {
			this.field1112[var1] = new class412(this.method2210(var1));
			if (null != this.field1110) {
				this.field1112[var1].method7426(this.field1110.method2190(var1));
			} else {
				this.field1112[var1].method7426(class412.field4564);
			}
		}

		return this.field1112[var1];
	}

	class412 method2175(int var1) {
		if (null == this.field1113[var1]) {
			this.field1113[var1] = new class412(this.method2190(var1));
			this.field1113[var1].method7452();
		}

		return this.field1113[var1];
	}

	void method2194(class412 var1) {
		this.field1120.method7422(var1);
		this.field1115 = true;
		this.field1114 = true;
	}

	class412 method2177() {
		return this.field1120;
	}

	class412 method2178() {
		if (this.field1115) {
			this.field1116.method7422(this.method2177());
			if (this.field1110 != null) {
				this.field1116.method7426(this.field1110.method2178());
			}

			this.field1115 = false;
		}

		return this.field1116;
	}

	static final void method2211() {
		if (!class234.field2774) {
			int var1 = class214.field2556;
			int var2 = class214.field2521;
			int var3 = class214.field2522;
			int var4 = class214.field2523;
			byte var5 = 50;
			short var6 = 3500;
			int var7 = (class234.field2767 - class221.field2634) * var5 / class221.field2630;
			int var8 = (class234.field2768 - class221.field2620) * var5 / class221.field2630;
			int var9 = var6 * (class234.field2767 - class221.field2634) / class221.field2630;
			int var10 = (class234.field2768 - class221.field2620) * var6 / class221.field2630;
			int var11 = class221.method4429(var8, var5, var2, var1);
			int var12 = class221.method4439(var8, var5, var2, var1);
			var8 = var11;
			var11 = class221.method4429(var10, var6, var2, var1);
			int var13 = class221.method4439(var10, var6, var2, var1);
			var10 = var11;
			var11 = class221.method4454(var7, var12, var4, var3);
			var12 = class221.method4412(var7, var12, var4, var3);
			var7 = var11;
			var11 = class221.method4454(var9, var13, var4, var3);
			var13 = class221.method4412(var9, var13, var4, var3);
			class234.field2770 = (var11 + var7) / 2;
			class234.field2775 = (var8 + var10) / 2;
			class234.field2772 = (var12 + var13) / 2;
			class287.field3343 = (var11 - var7) / 2;
			class116.field1135 = (var10 - var8) / 2;
			class73.field602 = (var13 - var12) / 2;
			class234.field2773 = Math.abs(class287.field3343);
			class435.field4721 = Math.abs(class116.field1135);
			class25.field120 = Math.abs(class73.field602);
		}
	}

	public class412 method2179(int var1) {
		if (this.field1114) {
			this.field1117.method7422(this.method2175(var1));
			this.field1117.method7426(this.method2178());
			this.field1114 = false;
		}

		return this.field1117;
	}

	float[] method2192(int var1) {
		return this.field1119[var1];
	}

	float[] method2181(int var1) {
		return this.field1118[var1];
	}

	float[] method2182(int var1) {
		return this.field1121[var1];
	}
}
