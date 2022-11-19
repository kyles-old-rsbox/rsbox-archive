import client.Client;

public class class380 extends class396 {
	boolean field4407;
	boolean field4408;

	class380() {
	}

	int method6807(class380 var1) {
		if (Client.field1868 == super.field4491 && var1.field4491 != Client.field1868) {
			return -1;
		} else if (Client.field1868 == var1.field4491 && super.field4491 != Client.field1868) {
			return 1;
		} else if (super.field4491 != 0 && 0 == var1.field4491) {
			return -1;
		} else if (0 != var1.field4491 && 0 == super.field4491) {
			return 1;
		} else if (this.field4407 && !var1.field4407) {
			return -1;
		} else if (!this.field4407 && var1.field4407) {
			return 1;
		} else if (this.field4408 && !var1.field4408) {
			return -1;
		} else if (!this.field4408 && var1.field4408) {
			return 1;
		} else {
			return 0 != super.field4491 ? super.field4490 - var1.field4490 : var1.field4490 - super.field4490;
		}
	}

	public int method7236(class400 var1) {
		return this.method6807((class380)var1);
	}

	public int compareTo(Object var1) {
		return this.method6807((class380)var1);
	}

	static final void method6806(int var0, int var1, int var2, int var3, int var4, int var5) {
		int var7 = var2 - var0;
		int var8 = var3 - var1;
		int var9 = var7 >= 0 ? var7 : -var7;
		int var10 = var8 >= 0 ? var8 : -var8;
		int var11 = var9;
		if (var9 < var10) {
			var11 = var10;
		}

		if (var11 != 0) {
			int var12 = (var7 << 16) / var11;
			int var13 = (var8 << 16) / var11;
			if (var13 <= var12) {
				var12 = -var12;
			} else {
				var13 = -var13;
			}

			int var14 = var13 * var5 >> 17;
			int var15 = var5 * var13 + 1 >> 17;
			int var16 = var5 * var12 >> 17;
			int var17 = 1 + var12 * var5 >> 17;
			var0 -= class481.field4997;
			var1 -= class481.field4995;
			int var18 = var14 + var0;
			int var19 = var0 - var15;
			int var20 = var7 + var0 - var15;
			int var21 = var0 + var7 + var14;
			int var22 = var1 + var16;
			int var23 = var1 - var17;
			int var24 = var1 + var8 - var17;
			int var25 = var16 + var1 + var8;
			class221.method4473(var18, var19, var20);
			class221.method4460(var22, var23, var24, var18, var19, var20, var4);
			class221.method4473(var18, var20, var21);
			class221.method4460(var22, var24, var25, var18, var20, var21, var4);
		}
	}
}
