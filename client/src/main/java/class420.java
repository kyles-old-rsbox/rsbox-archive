import client.Client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class class420 {
	static class488[] field4661;
	static final class442 field4610;
	static final class442 field4639;
	static final class442 field4641;
	boolean field4632;
	boolean field4643;
	boolean field4649;
	class246 field4618;
	class254 field4615;
	class254 field4616;
	class254 field4617;
	class295 field4654;
	class319 field4607;
	class319 field4609;
	class319 field4662;
	class376 field4611;
	class435 field4619;
	class473 field4656;
	class488[] field4613;
	float field4625;
	float field4650;
	int field4603;
	int field4608;
	int field4620;
	int field4621;
	int field4622;
	int field4623;
	int field4624;
	int field4626;
	int field4627;
	int field4628;
	int field4629;
	int field4630;
	int field4631;
	int field4634;
	int field4635;
	int field4637;
	int field4638;
	int field4642;
	int field4651;
	int field4657;
	int field4658;
	int field4659;
	int field4660;
	HashMap field4612;
	HashMap field4614;
	HashSet field4606;
	HashSet field4633;
	HashSet field4644;
	HashSet field4645;
	HashSet field4646;
	HashSet field4647;
	Iterator field4652;
	List field4648;
	long field4640;
	final int[] field4636;
	public boolean field4655;

	public class420() {
		this.field4608 = -1;
		this.field4659 = -1;
		this.field4626 = -1;
		this.field4627 = -1;
		this.field4623 = -1;
		this.field4629 = -1;
		this.field4630 = 3;
		this.field4621 = 50;
		this.field4632 = false;
		this.field4633 = null;
		this.field4603 = -1;
		this.field4635 = -1;
		this.field4631 = -1;
		this.field4637 = -1;
		this.field4638 = -1;
		this.field4624 = -1;
		this.field4643 = true;
		this.field4644 = new HashSet();
		this.field4645 = new HashSet();
		this.field4646 = new HashSet();
		this.field4647 = new HashSet();
		this.field4649 = false;
		this.field4628 = 0;
		this.field4636 = new int[]{1008, 1009, 1010, 1011, 1012};
		this.field4606 = new HashSet();
		this.field4654 = null;
		this.field4655 = false;
		this.field4658 = -1;
		this.field4620 = -1;
		this.field4660 = -1;
	}

	static {
		field4641 = class442.field4771;
		field4639 = class442.field4770;
		field4610 = class442.field4773;
	}

	public void method7741(class319 var1, class319 var2, class319 var3, class376 var4, HashMap var5, class488[] var6) {
		this.field4613 = var6;
		this.field4609 = var1;
		this.field4662 = var2;
		this.field4607 = var3;
		this.field4611 = var4;
		this.field4612 = new HashMap();
		this.field4612.put(class210.field2456, var5.get(field4641));
		this.field4612.put(class210.field2457, var5.get(field4639));
		this.field4612.put(class210.field2459, var5.get(field4610));
		this.field4619 = new class435(var1);
		int var8 = this.field4609.method6124(class242.field2838.field2837);
		int[] var9 = this.field4609.method6098(var8);
		this.field4614 = new HashMap(var9.length);

		for (int var10 = 0; var10 < var9.length; ++var10) {
			class460 var11 = new class460(this.field4609.method6175(var8, var9[var10]));
			class254 var12 = new class254();
			var12.method5073(var11, var9[var10]);
			this.field4614.put(var12.method5054(), var12);
			if (var12.method5085()) {
				this.field4615 = var12;
			}
		}

		this.method7577(this.field4615);
		this.field4617 = null;
	}

	public void method7575() {
		class243.field2848.method5193(5);
	}

	public void method7657(int var1, int var2, boolean var3, int var4, int var5, int var6, int var7) {
		if (this.field4619.method7874()) {
			this.method7579();
			this.method7737();
			if (var3) {
				int var9 = (int)Math.ceil((double)((float)var6 / this.field4650));
				int var10 = (int)Math.ceil((double)((float)var7 / this.field4650));
				List var11 = this.field4618.method4922(this.field4634 - var9 / 2 - 1, this.field4622 - var10 / 2 - 1, this.field4634 + var9 / 2 + 1, 1 + var10 / 2 + this.field4622, var4, var5, var6, var7, var1, var2);
				HashSet var12 = new HashSet();

				Iterator var13;
				class251 var14;
				class79 var15;
				class245 var16;
				for (var13 = var11.iterator(); var13.hasNext(); class57.method5433(var15)) {
					var14 = (class251)var13.next();
					var12.add(var14);
					var15 = new class79();
					var16 = new class245(var14.method5024(), var14.field2909, var14.field2915);
					var15.method1602(new Object[]{var16, var1, var2});
					if (this.field4606.contains(var14)) {
						var15.method1600(17);
					} else {
						var15.method1600(15);
					}
				}

				var13 = this.field4606.iterator();

				while (var13.hasNext()) {
					var14 = (class251)var13.next();
					if (!var12.contains(var14)) {
						var15 = new class79();
						var16 = new class245(var14.method5024(), var14.field2909, var14.field2915);
						var15.method1602(new Object[]{var16, var1, var2});
						var15.method1600(16);
						class57.method5433(var15);
					}
				}

				this.field4606 = var12;
			}
		}
	}

	public void method7742(int var1, int var2, boolean var3, boolean var4) {
		long var6 = class272.method2046();
		this.method7664(var1, var2, var4, var6);
		if (!this.method7734() && (var4 || var3) && !Client.method5842()) {
			if (var4) {
				this.field4638 = var1;
				this.field4624 = var2;
				this.field4631 = this.field4634;
				this.field4637 = this.field4622;
			}

			if (-1 != this.field4631) {
				int var8 = var1 - this.field4638;
				int var9 = var2 - this.field4624;
				this.method7581(this.field4631 - (int)((float)var8 / this.field4625), this.field4637 + (int)((float)var9 / this.field4625), false);
			}
		} else {
			this.method7582();
		}

		if (var4) {
			this.field4640 = var6;
			this.field4657 = var1;
			this.field4642 = var2;
		}

	}

	void method7664(int var1, int var2, boolean var3, long var4) {
		if (this.field4616 != null) {
			int var6 = (int)((float)this.field4634 + ((float)(var1 - this.field4623) - (float)this.method7611() * this.field4650 / 2.0F) / this.field4650);
			int var7 = (int)((float)this.field4622 - ((float)(var2 - this.field4629) - (float)this.method7612() * this.field4650 / 2.0F) / this.field4650);
			this.field4654 = this.field4616.method5100(var6 + this.field4616.method5124() * 64, var7 + this.field4616.method5079() * 64);
			if (this.field4654 != null && var3) {
				class205 var8 = Client.field1876;
				if (class114.method2218() && var8.method3895(82) && var8.method3895(81)) {
					class136.method2439(this.field4654.field3376, this.field4654.field3375, this.field4654.field3374, false);
				} else {
					boolean var10 = true;
					if (this.field4643) {
						int var11 = var1 - this.field4657;
						int var12 = var2 - this.field4642;
						if (var4 - this.field4640 > 500L || var11 < -25 || var11 > 25 || var12 < -25 || var12 > 25) {
							var10 = false;
						}
					}

					if (var10) {
						class263 var13 = class185.method3435(class274.field3081, Client.field1778.field1071);
						var13.field2984.method8241(this.field4654.method5522());
						Client.field1778.method2078(var13);
						this.field4640 = 0L;
					}
				}
			}
		} else {
			this.field4654 = null;
		}

	}

	void method7579() {
		if (class335.field3867 != null) {
			this.field4650 = this.field4625;
		} else {
			if (this.field4650 < this.field4625) {
				this.field4650 = Math.min(this.field4625, this.field4650 + this.field4650 / 30.0F);
			}

			if (this.field4650 > this.field4625) {
				this.field4650 = Math.max(this.field4625, this.field4650 - this.field4650 / 30.0F);
			}

		}
	}

	void method7737() {
		if (this.method7734()) {
			int var2 = this.field4608 - this.field4634;
			int var3 = this.field4659 - this.field4622;
			if (var2 != 0) {
				var2 /= Math.min(8, Math.abs(var2));
			}

			if (var3 != 0) {
				var3 /= Math.min(8, Math.abs(var3));
			}

			this.method7581(this.field4634 + var2, this.field4622 + var3, true);
			if (this.field4634 == this.field4608 && this.field4622 == this.field4659) {
				this.field4608 = -1;
				this.field4659 = -1;
			}

		}
	}

	final void method7581(int var1, int var2, boolean var3) {
		this.field4634 = var1;
		this.field4622 = var2;
		class272.method2046();
		if (var3) {
			this.method7582();
		}

	}

	final void method7582() {
		this.field4624 = -1;
		this.field4638 = -1;
		this.field4637 = -1;
		this.field4631 = -1;
	}

	boolean method7734() {
		return -1 != this.field4608 && -1 != this.field4659;
	}

	public class254 method7714(int var1, int var2, int var3) {
		Iterator var5 = this.field4614.values().iterator();

		class254 var6;
		do {
			if (!var5.hasNext()) {
				return null;
			}

			var6 = (class254)var5.next();
		} while(!var6.method5083(var1, var2, var3));

		return var6;
	}

	public void method7597(int var1, int var2, int var3, boolean var4) {
		class254 var6 = this.method7714(var1, var2, var3);
		if (var6 == null) {
			if (!var4) {
				return;
			}

			var6 = this.field4615;
		}

		boolean var7 = false;
		if (this.field4617 != var6 || var4) {
			this.field4617 = var6;
			this.method7577(var6);
			var7 = true;
		}

		if (var7 || var4) {
			this.method7763(var1, var2, var3);
		}

	}

	public void method7616(int var1) {
		class254 var3 = this.method7603(var1);
		if (null != var3) {
			this.method7577(var3);
		}

	}

	public int method7583() {
		return this.field4616 == null ? -1 : this.field4616.method5063();
	}

	public class254 method7588() {
		return this.field4616;
	}

	void method7577(class254 var1) {
		if (this.field4616 == null || this.field4616 != var1) {
			this.method7592(var1);
			this.method7763(-1, -1, -1);
		}
	}

	void method7592(class254 var1) {
		this.field4616 = var1;
		this.field4618 = new class246(this.field4613, this.field4612, this.field4662, this.field4607);
		this.field4619.method7872(this.field4616.method5054());
	}

	public void method7591(class254 var1, class295 var2, class295 var3, boolean var4) {
		if (null != var1) {
			if (null == this.field4616 || var1 != this.field4616) {
				this.method7592(var1);
			}

			if (!var4 && this.field4616.method5083(var2.field3374, var2.field3376, var2.field3375)) {
				this.method7763(var2.field3374, var2.field3376, var2.field3375);
			} else {
				this.method7763(var3.field3374, var3.field3376, var3.field3375);
			}

		}
	}

	void method7763(int var1, int var2, int var3) {
		if (this.field4616 != null) {
			int[] var5 = this.field4616.method5049(var1, var2, var3);
			if (var5 == null) {
				var5 = this.field4616.method5049(this.field4616.method5103(), this.field4616.method5069(), this.field4616.method5108());
			}

			this.method7581(var5[0] - this.field4616.method5124() * 64, var5[1] - this.field4616.method5079() * 64, true);
			this.field4608 = -1;
			this.field4659 = -1;
			this.field4650 = this.method7768(this.field4616.method5057());
			this.field4625 = this.field4650;
			this.field4648 = null;
			this.field4652 = null;
			this.field4618.method4929();
		}
	}

	public void method7663(int var1, int var2, int var3, int var4, int var5) {
		int[] var7 = new int[4];
		class481.method8718(var7);
		class481.method8653(var1, var2, var3 + var1, var2 + var4);
		class481.method8660(var1, var2, var3, var4, -16777216);
		int var8 = this.field4619.method7871();
		if (var8 < 100) {
			this.method7662(var1, var2, var3, var4, var8);
		} else {
			if (!this.field4618.method4900()) {
				this.field4618.method4892(this.field4609, this.field4616.method5054(), Client.field1635);
				if (!this.field4618.method4900()) {
					return;
				}
			}

			if (null != this.field4633) {
				++this.field4635;
				if (this.field4635 % this.field4621 == 0) {
					this.field4635 = 0;
					++this.field4603;
				}

				if (this.field4603 >= this.field4630 && !this.field4632) {
					this.field4633 = null;
				}
			}

			int var9 = (int)Math.ceil((double)((float)var3 / this.field4650));
			int var10 = (int)Math.ceil((double)((float)var4 / this.field4650));
			class239.field2817 = Client.field1932 >= 209;
			this.field4618.method4894(this.field4634 - var9 / 2, this.field4622 - var10 / 2, var9 / 2 + this.field4634, var10 / 2 + this.field4622, var1, var2, var1 + var3, var4 + var2);
			if (!this.field4649) {
				boolean var11 = false;
				if (var5 - this.field4628 > 100) {
					this.field4628 = var5;
					var11 = true;
				}

				this.field4618.method4895(this.field4634 - var9 / 2, this.field4622 - var10 / 2, this.field4634 + var9 / 2, this.field4622 + var10 / 2, var1, var2, var1 + var3, var2 + var4, this.field4647, this.field4633, this.field4635, this.field4621, var11);
			}

			this.method7595(var1, var2, var3, var4, var9, var10);
			if (class114.method2218() && this.field4655 && this.field4654 != null) {
				this.field4611.method6875("Coord: " + this.field4654, class481.field4997 + 10, class481.field4995 + 20, 16776960, -1);
			}

			this.field4626 = var9;
			this.field4627 = var10;
			this.field4623 = var1;
			this.field4629 = var2;
			class481.method8655(var7);
		}
	}

	boolean method7594(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (null == this.field4656) {
			return true;
		} else if (var1 == this.field4656.field4959 && var2 == this.field4656.field4951) {
			if (this.field4618.field2875 != this.field4651) {
				return true;
			} else if (this.field4660 != Client.field1936) {
				return true;
			} else if (var3 <= 0 && var4 <= 0) {
				return var1 + var3 < var5 || var4 + var2 < var6;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	void method7595(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (class335.field3867 != null) {
			int var8 = 512 / (this.field4618.field2875 * 2);
			int var9 = var3 + 512;
			int var10 = var4 + 512;
			float var11 = 1.0F;
			var9 = (int)((float)var9 / var11);
			var10 = (int)((float)var10 / var11);
			int var12 = this.method7608() - var5 / 2 - var8;
			int var13 = this.method7609() - var6 / 2 - var8;
			int var14 = var1 - this.field4618.field2875 * (var8 + var12 - this.field4658);
			int var15 = var2 - (var8 - (var13 - this.field4620)) * this.field4618.field2875;
			if (this.method7594(var9, var10, var14, var15, var3, var4)) {
				if (this.field4656 != null && var9 == this.field4656.field4959 && this.field4656.field4951 == var10) {
					Arrays.fill(this.field4656.field4952, 0);
				} else {
					this.field4656 = new class473(var9, var10);
				}

				this.field4658 = this.method7608() - var5 / 2 - var8;
				this.field4620 = this.method7609() - var6 / 2 - var8;
				this.field4651 = this.field4618.field2875;
				class335.field3867.method6429(this.field4658, this.field4620, this.field4656, (float)this.field4651 / var11);
				this.field4660 = Client.field1936;
				var14 = var1 - (var8 + var12 - this.field4658) * this.field4618.field2875;
				var15 = var2 - this.field4618.field2875 * (var8 - (var13 - this.field4620));
			}

			class481.method8659(var1, var2, var3, var4, 0, 128);
			if (var11 == 1.0F) {
				this.field4656.method8495(var14, var15, 192);
			} else {
				this.field4656.method8498(var14, var15, (int)((float)var9 * var11), (int)(var11 * (float)var10), 192);
			}
		}

	}

	public void method7596(int var1, int var2, int var3, int var4) {
		if (this.field4619.method7874()) {
			if (!this.field4618.method4900()) {
				this.field4618.method4892(this.field4609, this.field4616.method5054(), Client.field1635);
				if (!this.field4618.method4900()) {
					return;
				}
			}

			this.field4618.method4896(var1, var2, var3, var4, this.field4633, this.field4635, this.field4621);
		}
	}

	public void method7585(int var1) {
		this.field4625 = this.method7768(var1);
	}

	void method7662(int var1, int var2, int var3, int var4, int var5) {
		byte var7 = 20;
		int var8 = var1 + var3 / 2;
		int var9 = var4 / 2 + var2 - 18 - var7;
		class481.method8660(var1, var2, var3, var4, -16777216);
		class481.method8664(var8 - 152, var9, 304, 34, -65536);
		class481.method8660(var8 - 150, var9 + 2, var5 * 3, 30, -65536);
		this.field4611.method6955(class338.field3961, var8, var9 + var7, -1, -1);
	}

	float method7768(int var1) {
		if (var1 == 25) {
			return 1.0F;
		} else if (var1 == 37) {
			return 1.5F;
		} else if (var1 == 50) {
			return 2.0F;
		} else if (var1 == 75) {
			return 3.0F;
		} else {
			return var1 == 100 ? 4.0F : 8.0F;
		}
	}

	public int method7600() {
		if ((double)this.field4625 == 1.0D) {
			return 25;
		} else if (1.5D == (double)this.field4625) {
			return 37;
		} else if ((double)this.field4625 == 2.0D) {
			return 50;
		} else if ((double)this.field4625 == 3.0D) {
			return 75;
		} else {
			return 4.0D == (double)this.field4625 ? 100 : 200;
		}
	}

	public void method7601() {
		this.field4619.method7873();
	}

	public boolean method7602() {
		return this.field4619.method7874();
	}

	public class254 method7603(int var1) {
		Iterator var3 = this.field4614.values().iterator();

		class254 var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (class254)var3.next();
		} while(var4.method5063() != var1);

		return var4;
	}

	public void method7604(int var1, int var2) {
		if (this.field4616 != null && this.field4616.method5048(var1, var2)) {
			this.field4608 = var1 - this.field4616.method5124() * 64;
			this.field4659 = var2 - this.field4616.method5079() * 64;
		}
	}

	public void method7605(int var1, int var2) {
		if (this.field4616 != null) {
			this.method7581(var1 - this.field4616.method5124() * 64, var2 - this.field4616.method5079() * 64, true);
			this.field4608 = -1;
			this.field4659 = -1;
		}
	}

	public void method7606(int var1, int var2, int var3) {
		if (this.field4616 != null) {
			int[] var5 = this.field4616.method5049(var1, var2, var3);
			if (null != var5) {
				this.method7604(var5[0], var5[1]);
			}

		}
	}

	public void method7607(int var1, int var2, int var3) {
		if (null != this.field4616) {
			int[] var5 = this.field4616.method5049(var1, var2, var3);
			if (null != var5) {
				this.method7605(var5[0], var5[1]);
			}

		}
	}

	public int method7608() {
		return this.field4616 == null ? -1 : this.field4634 + this.field4616.method5124() * 64;
	}

	public int method7609() {
		return this.field4616 == null ? -1 : this.field4622 + this.field4616.method5079() * 64;
	}

	public class295 method7610() {
		return this.field4616 == null ? null : this.field4616.method5100(this.method7608(), this.method7609());
	}

	public int method7611() {
		return this.field4626;
	}

	public int method7612() {
		return this.field4627;
	}

	public void method7613(int var1) {
		if (var1 >= 1) {
			this.field4630 = var1;
		}

	}

	public void method7598() {
		this.field4630 = 3;
	}

	public void method7615(int var1) {
		if (var1 >= 1) {
			this.field4621 = var1;
		}

	}

	public void method7645() {
		this.field4621 = 50;
	}

	public void method7707(boolean var1) {
		this.field4632 = var1;
	}

	public void method7765(int var1) {
		this.field4633 = new HashSet();
		this.field4633.add(var1);
		this.field4603 = 0;
		this.field4635 = 0;
	}

	public void method7731(int var1) {
		this.field4633 = new HashSet();
		this.field4603 = 0;
		this.field4635 = 0;

		for (int var3 = 0; var3 < class160.field1469; ++var3) {
			if (class90.method1885(var3) != null && class90.method1885(var3).field1487 == var1) {
				this.field4633.add(class90.method1885(var3).field1481);
			}
		}

	}

	public void method7620() {
		this.field4633 = null;
	}

	public void method7621(boolean var1) {
		this.field4649 = !var1;
	}

	public void method7622(int var1, boolean var2) {
		if (!var2) {
			this.field4644.add(var1);
		} else {
			this.field4644.remove(var1);
		}

		this.method7584();
	}

	public void method7623(int var1, boolean var2) {
		if (!var2) {
			this.field4645.add(var1);
		} else {
			this.field4645.remove(var1);
		}

		for (int var4 = 0; var4 < class160.field1469; ++var4) {
			if (class90.method1885(var4) != null && class90.method1885(var4).field1487 == var1) {
				int var5 = class90.method1885(var4).field1481;
				if (!var2) {
					this.field4646.add(var5);
				} else {
					this.field4646.remove(var5);
				}
			}
		}

		this.method7584();
	}

	public boolean method7624() {
		return !this.field4649;
	}

	public boolean method7625(int var1) {
		return !this.field4644.contains(var1);
	}

	public boolean method7626(int var1) {
		return !this.field4645.contains(var1);
	}

	void method7584() {
		this.field4647.clear();
		this.field4647.addAll(this.field4644);
		this.field4647.addAll(this.field4646);
	}

	public void method7628(int var1, int var2, int var3, int var4, int var5, int var6) {
		if (this.field4619.method7874()) {
			int var8 = (int)Math.ceil((double)((float)var3 / this.field4650));
			int var9 = (int)Math.ceil((double)((float)var4 / this.field4650));
			List var10 = this.field4618.method4922(this.field4634 - var8 / 2 - 1, this.field4622 - var9 / 2 - 1, var8 / 2 + this.field4634 + 1, this.field4622 + var9 / 2 + 1, var1, var2, var3, var4, var5, var6);
			if (!var10.isEmpty()) {
				Iterator var11 = var10.iterator();

				boolean var14;
				do {
					if (!var11.hasNext()) {
						return;
					}

					class251 var12 = (class251)var11.next();
					class160 var13 = class90.method1885(var12.method5024());
					var14 = false;

					for (int var15 = this.field4636.length - 1; var15 >= 0; --var15) {
						if (var13.field1476[var15] != null) {
							Client.method351(var13.field1476[var15], var13.field1477, this.field4636[var15], var12.method5024(), var12.field2909.method5522(), var12.field2915.method5522());
							var14 = true;
						}
					}
				} while(!var14);

			}
		}
	}

	public class295 method7629(int var1, class295 var2) {
		if (!this.field4619.method7874()) {
			return null;
		} else if (!this.field4618.method4900()) {
			return null;
		} else if (!this.field4616.method5048(var2.field3376, var2.field3375)) {
			return null;
		} else {
			HashMap var4 = this.field4618.method4920();
			List var5 = (List)var4.get(var1);
			if (null != var5 && !var5.isEmpty()) {
				class251 var6 = null;
				int var7 = -1;
				Iterator var8 = var5.iterator();

				while (true) {
					class251 var9;
					int var12;
					do {
						if (!var8.hasNext()) {
							return var6.field2915;
						}

						var9 = (class251)var8.next();
						int var10 = var9.field2915.field3376 - var2.field3376;
						int var11 = var9.field2915.field3375 - var2.field3375;
						var12 = var10 * var10 + var11 * var11;
						if (var12 == 0) {
							return var9.field2915;
						}
					} while(var12 >= var7 && null != var6);

					var6 = var9;
					var7 = var12;
				}
			} else {
				return null;
			}
		}
	}

	public void method7630(int var1, int var2, class295 var3, class295 var4) {
		class79 var6 = new class79();
		class245 var7 = new class245(var2, var3, var4);
		var6.method1602(new Object[]{var7});
		switch(var1) {
		case 1008:
			var6.method1600(10);
			break;
		case 1009:
			var6.method1600(11);
			break;
		case 1010:
			var6.method1600(12);
			break;
		case 1011:
			var6.method1600(13);
			break;
		case 1012:
			var6.method1600(14);
		}

		class57.method5433(var6);
	}

	public class251 method7631() {
		if (!this.field4619.method7874()) {
			return null;
		} else if (!this.field4618.method4900()) {
			return null;
		} else {
			HashMap var2 = this.field4618.method4920();
			this.field4648 = new LinkedList();
			Iterator var3 = var2.values().iterator();

			while (var3.hasNext()) {
				List var4 = (List)var3.next();
				this.field4648.addAll(var4);
			}

			this.field4652 = this.field4648.iterator();
			return this.method7718();
		}
	}

	public class251 method7718() {
		if (null == this.field4652) {
			return null;
		} else {
			class251 var2;
			do {
				if (!this.field4652.hasNext()) {
					return null;
				}

				var2 = (class251)this.field4652.next();
			} while(var2.method5024() == -1);

			return var2;
		}
	}
}
