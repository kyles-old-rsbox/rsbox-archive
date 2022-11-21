import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class class246 {
	public static class319 field2881;
	static class488 field2880;
	boolean field2865;
	boolean field2874;
	class243[][] field2869;
	class257 field2866;
	class473 field2870;
	class488[] field2867;
	int field2864;
	int field2876;
	int field2877;
	int field2878;
	HashMap field2871;
	HashMap field2879;
	final class319 field2868;
	final class319 field2873;
	final HashMap field2872;
	public int field2875;

	public class246(class488[] var1, HashMap var2, class319 var3, class319 var4) {
		this.field2874 = false;
		this.field2865 = false;
		this.field2871 = new HashMap();
		this.field2875 = 0;
		this.field2867 = var1;
		this.field2872 = var2;
		this.field2868 = var3;
		this.field2873 = var4;
	}

	public static boolean method4930(CharSequence var0) {
		boolean var3 = false;
		boolean var4 = false;
		int var5 = 0;
		int var6 = var0.length();
		int var7 = 0;

		boolean var2;
		while (true) {
			if (var7 >= var6) {
				var2 = var4;
				break;
			}

			label85: {
				char var8 = var0.charAt(var7);
				if (var7 == 0) {
					if (var8 == '-') {
						var3 = true;
						break label85;
					}

					if (var8 == '+') {
						break label85;
					}
				}

				int var10;
				if (var8 >= '0' && var8 <= '9') {
					var10 = var8 - '0';
				} else if (var8 >= 'A' && var8 <= 'Z') {
					var10 = var8 - '7';
				} else {
					if (var8 < 'a' || var8 > 'z') {
						var2 = false;
						break;
					}

					var10 = var8 - 'W';
				}

				if (var10 >= 10) {
					var2 = false;
					break;
				}

				if (var3) {
					var10 = -var10;
				}

				int var9 = var5 * 10 + var10;
				if (var9 / 10 != var5) {
					var2 = false;
					break;
				}

				var5 = var9;
				var4 = true;
			}

			++var7;
		}

		return var2;
	}

	public void method4892(class319 var1, String var2, boolean var3) {
		if (!this.field2865) {
			this.field2874 = false;
			this.field2865 = true;
			System.nanoTime();
			int var5 = var1.getGroupId(class242.field2838.field2837);
			int var6 = var1.method6170(var5, var2);
			Buffer var7 = new Buffer(var1.method6148(class242.field2838.field2837, var2));
			Buffer var8 = new Buffer(var1.method6148(class242.field2833.field2837, var2));
			System.nanoTime();
			System.nanoTime();
			this.field2866 = new class257();

			try {
				this.field2866.method5129(var7, var8, var6, var3);
			} catch (IllegalStateException var20) {
				return;
			}

			this.field2866.method5069();
			this.field2866.method5103();
			this.field2866.method5108();
			this.field2864 = this.field2866.method5124() * 64;
			this.field2876 = this.field2866.method5079() * 64;
			this.field2877 = (this.field2866.method5059() - this.field2866.method5124() + 1) * 64;
			this.field2878 = (this.field2866.method5061() - this.field2866.method5079() + 1) * 64;
			int var17 = this.field2866.method5059() - this.field2866.method5124() + 1;
			int var10 = this.field2866.method5061() - this.field2866.method5079() + 1;
			System.nanoTime();
			System.nanoTime();
			class243.method3411();
			this.field2869 = new class243[var17][var10];
			Iterator var11 = this.field2866.field2952.iterator();

			while (var11.hasNext()) {
				class228 var12 = (class228)var11.next();
				int var13 = var12.field2810;
				int var14 = var12.field2811;
				int var15 = var13 - this.field2866.method5124();
				int var16 = var14 - this.field2866.method5079();
				this.field2869[var15][var16] = new class243(var13, var14, this.field2866.method5056(), this.field2872);
				this.field2869[var15][var16].method4736(var12, this.field2866.field2953);
			}

			for (int var18 = 0; var18 < var17; ++var18) {
				for (int var19 = 0; var19 < var10; ++var19) {
					if (null == this.field2869[var18][var19]) {
						this.field2869[var18][var19] = new class243(this.field2866.method5124() + var18, this.field2866.method5079() + var19, this.field2866.method5056(), this.field2872);
						this.field2869[var18][var19].method4737(this.field2866.field2954, this.field2866.field2953);
					}
				}
			}

			System.nanoTime();
			System.nanoTime();
			if (var1.method6155(class242.field2832.field2837, var2)) {
				byte[] var21 = var1.method6148(class242.field2832.field2837, var2);
				this.field2870 = class32.method712(var21);
			}

			System.nanoTime();
			var1.method6101();
			var1.method6117();
			this.field2874 = true;
		}
	}

	public final void method4929() {
		this.field2879 = null;
	}

	public final void method4894(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int[] var10 = class481.field4992;
		int var11 = class481.field4993;
		int var12 = class481.field4994;
		int[] var13 = new int[4];
		class481.method8718(var13);
		class235 var14 = this.method4898(var1, var2, var3, var4);
		float var15 = this.method4902(var7 - var5, var3 - var1);
		int var16 = (int)Math.ceil((double)var15);
		this.field2875 = var16;
		if (!this.field2871.containsKey(var16)) {
			class240 var17 = new class240(var16);
			var17.method4686();
			this.field2871.put(var16, var17);
		}

		int var24 = var14.field2782 + var14.field2786 - 1;
		int var18 = var14.field2781 + var14.field2783 - 1;

		int var19;
		int var20;
		for (var19 = var14.field2782; var19 <= var24; ++var19) {
			for (var20 = var14.field2783; var20 <= var18; ++var20) {
				this.field2869[var19][var20].method4744(var16, (class240)this.field2871.get(var16), this.field2867, this.field2868, this.field2873);
			}
		}

		class481.method8651(var10, var11, var12);
		class481.method8655(var13);
		var19 = (int)(var15 * 64.0F);
		var20 = this.field2864 + var1;
		int var21 = this.field2876 + var2;

		for (int var22 = var14.field2782; var22 < var14.field2786 + var14.field2782; ++var22) {
			for (int var23 = var14.field2783; var23 < var14.field2781 + var14.field2783; ++var23) {
				this.field2869[var22][var23].method4735((this.field2869[var22][var23].field2844 * 64 - var20) * var19 / 64 + var5, var8 - var19 * (this.field2869[var22][var23].field2845 * 64 - var21 + 64) / 64, var19);
			}
		}

	}

	public final void method4895(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
		class235 var15 = this.method4898(var1, var2, var3, var4);
		float var16 = this.method4902(var7 - var5, var3 - var1);
		int var17 = (int)(var16 * 64.0F);
		int var18 = this.field2864 + var1;
		int var19 = this.field2876 + var2;

		int var20;
		int var21;
		for (var20 = var15.field2782; var20 < var15.field2786 + var15.field2782; ++var20) {
			for (var21 = var15.field2783; var21 < var15.field2781 + var15.field2783; ++var21) {
				if (var13) {
					this.field2869[var20][var21].method4740();
				}

				this.field2869[var20][var21].method4820((this.field2869[var20][var21].field2844 * 64 - var18) * var17 / 64 + var5, var8 - var17 * (64 + (this.field2869[var20][var21].field2845 * 64 - var19)) / 64, var17, var9);
			}
		}

		if (null != var10 && var11 > 0) {
			for (var20 = var15.field2782; var20 < var15.field2782 + var15.field2786; ++var20) {
				for (var21 = var15.field2783; var21 < var15.field2783 + var15.field2781; ++var21) {
					this.field2869[var20][var21].method4779(var10, var11, var12);
				}
			}
		}

	}

	public void method4896(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
		if (null != this.field2870) {
			this.field2870.method8487(var1, var2, var3, var4);
			if (var6 > 0 && var6 % var7 < var7 / 2) {
				if (this.field2879 == null) {
					this.method4901();
				}

				Iterator var9 = var5.iterator();

				while (true) {
					List var11;
					do {
						if (!var9.hasNext()) {
							return;
						}

						int var10 = (Integer)var9.next();
						var11 = (List)this.field2879.get(var10);
					} while(var11 == null);

					Iterator var12 = var11.iterator();

					while (var12.hasNext()) {
						class251 var13 = (class251)var12.next();
						int var14 = (var13.field2915.field3376 - this.field2864) * var3 / this.field2877;
						int var15 = var4 - (var13.field2915.field3375 - this.field2876) * var4 / this.field2878;
						class481.method8658(var14 + var1, var2 + var15, 2, 16776960, 256);
					}
				}
			}
		}
	}

	public List method4922(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		LinkedList var12 = new LinkedList();
		if (!this.field2874) {
			return var12;
		} else {
			class235 var13 = this.method4898(var1, var2, var3, var4);
			float var14 = this.method4902(var7, var3 - var1);
			int var15 = (int)(var14 * 64.0F);
			int var16 = var1 + this.field2864;
			int var17 = var2 + this.field2876;

			for (int var18 = var13.field2782; var18 < var13.field2786 + var13.field2782; ++var18) {
				for (int var19 = var13.field2783; var19 < var13.field2783 + var13.field2781; ++var19) {
					List var20 = this.field2869[var18][var19].method4765(var15 * (this.field2869[var18][var19].field2844 * 64 - var16) / 64 + var5, var6 + var8 - (64 + (this.field2869[var18][var19].field2845 * 64 - var17)) * var15 / 64, var15, var9, var10);
					if (!var20.isEmpty()) {
						var12.addAll(var20);
					}
				}
			}

			return var12;
		}
	}

	class235 method4898(int var1, int var2, int var3, int var4) {
		class235 var6 = new class235(this);
		int var7 = var1 + this.field2864;
		int var8 = this.field2876 + var2;
		int var9 = this.field2864 + var3;
		int var10 = var4 + this.field2876;
		int var11 = var7 / 64;
		int var12 = var8 / 64;
		int var13 = var9 / 64;
		int var14 = var10 / 64;
		var6.field2786 = var13 - var11 + 1;
		var6.field2781 = 1 + (var14 - var12);
		var6.field2782 = var11 - this.field2866.method5124();
		var6.field2783 = var12 - this.field2866.method5079();
		if (var6.field2782 < 0) {
			var6.field2786 += var6.field2782;
			var6.field2782 = 0;
		}

		if (var6.field2782 > this.field2869.length - var6.field2786) {
			var6.field2786 = this.field2869.length - var6.field2782;
		}

		if (var6.field2783 < 0) {
			var6.field2781 += var6.field2783;
			var6.field2783 = 0;
		}

		if (var6.field2783 > this.field2869[0].length - var6.field2781) {
			var6.field2781 = this.field2869[0].length - var6.field2783;
		}

		var6.field2786 = Math.min(var6.field2786, this.field2869.length);
		var6.field2781 = Math.min(var6.field2781, this.field2869[0].length);
		return var6;
	}

	public static boolean method4928(int var0) {
		if (class299.field3442[var0]) {
			return true;
		} else if (!class105.field1044.method6091(var0)) {
			return false;
		} else {
			int var2 = class105.field1044.method6099(var0);
			if (var2 == 0) {
				class299.field3442[var0] = true;
				return true;
			} else {
				if (class300.field3593[var0] == null) {
					class300.field3593[var0] = new class300[var2];
				}

				for (int var3 = 0; var3 < var2; ++var3) {
					if (null == class300.field3593[var0][var3]) {
						byte[] var4 = class105.field1044.method6175(var0, var3);
						if (var4 != null) {
							class300.field3593[var0][var3] = new class300();
							class300.field3593[var0][var3].field3517 = var3 + (var0 << 16);
							if (-1 == var4[0]) {
								class300.field3593[var0][var3].method5848(new Buffer(var4));
							} else {
								class300.field3593[var0][var3].method5847(new Buffer(var4));
							}
						}
					}
				}

				class299.field3442[var0] = true;
				return true;
			}
		}
	}

	public boolean method4900() {
		return this.field2874;
	}

	public HashMap method4920() {
		this.method4901();
		return this.field2879;
	}

	void method4901() {
		if (null == this.field2879) {
			this.field2879 = new HashMap();
		}

		this.field2879.clear();

		for (int var2 = 0; var2 < this.field2869.length; ++var2) {
			for (int var3 = 0; var3 < this.field2869[var2].length; ++var3) {
				List var4 = this.field2869[var2][var3].method4766();
				Iterator var5 = var4.iterator();

				while (var5.hasNext()) {
					class251 var6 = (class251)var5.next();
					if (var6.method5014()) {
						int var7 = var6.method5024();
						if (!this.field2879.containsKey(var7)) {
							LinkedList var8 = new LinkedList();
							var8.add(var6);
							this.field2879.put(var7, var8);
						} else {
							List var9 = (List)this.field2879.get(var7);
							var9.add(var6);
						}
					}
				}
			}
		}

	}

	float method4902(int var1, int var2) {
		float var4 = (float)var1 / (float)var2;
		if (var4 > 8.0F) {
			return 8.0F;
		} else if (var4 < 1.0F) {
			return 1.0F;
		} else {
			int var5 = Math.round(var4);
			return Math.abs((float)var5 - var4) < 0.05F ? (float)var5 : var4;
		}
	}
}
