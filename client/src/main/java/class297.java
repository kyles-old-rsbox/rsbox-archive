import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class class297 {
	static class486 field3431;
	boolean field3403;
	boolean field3411;
	boolean field3412;
	class301 field3429;
	class301 field3430;
	class390 field3409;
	class390 field3423;
	int field3402;
	int field3413;
	int field3414;
	int field3415;
	int field3416;
	int field3417;
	int field3418;
	int field3419;
	int field3420;
	int field3421;
	int field3422;
	int field3425;
	int field3426;
	int field3427;
	int field3428;

	class297() {
		this.field3409 = new class390();
		this.field3423 = new class390();
		this.field3411 = false;
		this.field3412 = true;
		this.field3413 = 0;
		this.field3403 = false;
		this.field3414 = 0;
		this.field3421 = 0;
		this.field3417 = 0;
		this.field3418 = 0;
		this.field3419 = 0;
		this.field3420 = 0;
		this.field3426 = 0;
		this.field3422 = Integer.MAX_VALUE;
		this.field3402 = Integer.MAX_VALUE;
		this.field3416 = Integer.MAX_VALUE;
		this.field3425 = 0;
		this.field3415 = 0;
		this.field3427 = 0;
		this.field3428 = 0;
		this.field3409.method7053(1);
		this.field3423.method7053(1);
	}

	void method5738() {
		this.field3413 = (1 + this.field3413) % 60;
		if (this.field3426 > 0) {
			--this.field3426;
		}

	}

	public boolean method5560(boolean var1) {
		var1 = var1 && this.field3412;
		boolean var3 = this.field3411 != var1;
		this.field3411 = var1;
		if (!this.field3411) {
			this.method5584(this.field3418, this.field3418);
		}

		return var3;
	}

	public void method5636(boolean var1) {
		this.field3412 = var1;
		this.field3411 = var1 && this.field3411;
	}

	boolean method5562(String var1) {
		String var3 = this.field3409.method7028();
		if (!var3.equals(var1)) {
			var1 = this.method5670(var1);
			this.field3409.method7043(var1);
			this.method5739(this.field3427, this.field3428);
			this.method5632();
			this.method5637();
			return true;
		} else {
			return false;
		}
	}

	boolean method5583(String var1) {
		this.field3423.method7043(var1);
		return true;
	}

	boolean method5564(class384 var1) {
		boolean var3 = !this.field3403;
		this.field3409.method7036(var1);
		this.field3423.method7036(var1);
		this.field3403 = true;
		var3 |= this.method5739(this.field3427, this.field3428);
		var3 |= this.method5584(this.field3419, this.field3418);
		if (this.method5632()) {
			this.method5637();
			var3 = true;
		}

		return var3;
	}

	public boolean method5565(int var1, int var2) {
		boolean var4 = this.field3425 != var1 || var2 != this.field3415;
		this.field3425 = var1;
		this.field3415 = var2;
		var4 |= this.method5739(this.field3427, this.field3428);
		return var4;
	}

	public boolean method5566(int var1) {
		if (var1 < 0) {
			var1 = Integer.MAX_VALUE;
		}

		boolean var3 = var1 == this.field3409.method7054();
		this.field3409.method7034(var1, true);
		this.field3423.method7034(var1, true);
		if (this.method5632()) {
			this.method5637();
			var3 = true;
		}

		return var3;
	}

	public boolean method5567(int var1) {
		if (var1 < 0) {
			this.field3422 = Integer.MAX_VALUE;
		} else {
			this.field3422 = var1;
		}

		if (this.method5632()) {
			this.method5637();
			return true;
		} else {
			return false;
		}
	}

	public boolean method5568(int var1) {
		this.field3416 = var1;
		if (this.method5632()) {
			this.method5637();
			return true;
		} else {
			return false;
		}
	}

	public boolean method5739(int var1, int var2) {
		if (!this.method5699()) {
			this.field3427 = var1;
			this.field3428 = var2;
			return false;
		} else {
			int var4 = this.field3427;
			int var5 = this.field3428;
			int var6 = Math.max(0, this.field3409.method7049() - this.field3425 + 2);
			int var7 = Math.max(0, this.field3409.method7117() - this.field3415 + 1);
			this.field3427 = Math.max(0, Math.min(var6, var1));
			this.field3428 = Math.max(0, Math.min(var7, var2));
			return this.field3427 != var4 || this.field3428 != var5;
		}
	}

	public boolean method5570(int var1, int var2) {
		return true;
	}

	public void method5571(int var1) {
		this.field3409.method7038(var1);
	}

	public void method5572(int var1) {
		this.field3414 = var1;
	}

	public void method5573(int var1) {
		this.field3409.method7053(var1);
	}

	public void method5574(int var1) {
		this.field3409.method7035(var1);
	}

	public boolean method5729(int var1) {
		this.field3417 = var1;
		String var3 = this.field3409.method7028();
		int var4 = var3.length();
		var3 = this.method5670(var3);
		if (var3.length() != var4) {
			this.field3409.method7043(var3);
			this.method5739(this.field3427, this.field3428);
			this.method5632();
			this.method5637();
			return true;
		} else {
			return false;
		}
	}

	public void method5576() {
		this.field3403 = false;
	}

	public boolean method5577(int var1) {
		if (this.method5638(var1)) {
			this.method5582();
			class385 var3 = this.field3409.method7033((char)var1, this.field3418, this.field3402, this.field3422);
			this.method5584(var3.method6958(), var3.method6958());
			this.method5632();
			this.method5637();
		}

		return true;
	}

	public void method5616() {
		if (!this.method5582() && this.field3418 > 0) {
			int var2 = this.field3409.method7045(this.field3418 - 1);
			this.method5637();
			this.method5584(var2, var2);
		}

	}

	public void method5665() {
		if (!this.method5582() && this.field3418 < this.field3409.method7091()) {
			int var2 = this.field3409.method7045(this.field3418);
			this.method5637();
			this.method5584(var2, var2);
		}

	}

	public void method5580() {
		if (!this.method5582() && this.field3418 > 0) {
			class438 var2 = this.method5630(this.field3418 - 1);
			int var3 = this.field3409.method7046((Integer)var2.field4727, this.field3418);
			this.method5637();
			this.method5584(var3, var3);
		}

	}

	public void method5746() {
		if (!this.method5582() && this.field3418 < this.field3409.method7091()) {
			class438 var2 = this.method5630(this.field3418);
			int var3 = this.field3409.method7046(this.field3418, (Integer)var2.field4728);
			this.method5637();
			this.method5584(var3, var3);
		}

	}

	boolean method5582() {
		if (!this.method5627()) {
			return false;
		} else {
			int var2 = this.field3409.method7046(this.field3419, this.field3418);
			this.method5637();
			this.method5584(var2, var2);
			return true;
		}
	}

	public void method5563() {
		this.method5584(0, this.field3409.method7091());
	}

	public boolean method5584(int var1, int var2) {
		if (!this.method5699()) {
			this.field3419 = var1;
			this.field3418 = var2;
			return false;
		} else {
			if (var1 > this.field3409.method7091()) {
				var1 = this.field3409.method7091();
			}

			if (var2 > this.field3409.method7091()) {
				var2 = this.field3409.method7091();
			}

			boolean var4 = var1 != this.field3419 || this.field3418 != var2;
			this.field3419 = var1;
			if (this.field3418 != var2) {
				this.field3418 = var2;
				this.field3413 = 0;
				this.method5587();
			}

			if (var4 && this.field3430 != null) {
				this.field3430.method5987();
			}

			return var4;
		}
	}

	public void method5585(boolean var1) {
		class438 var3 = this.method5631(this.field3418);
		this.method5697((Integer)var3.field4727, var1);
	}

	public void method5646(boolean var1) {
		class438 var3 = this.method5631(this.field3418);
		this.method5697((Integer)var3.field4728, var1);
	}

	public void method5660(boolean var1) {
		this.method5697(0, var1);
	}

	public void method5618(boolean var1) {
		this.method5697(this.field3409.method7091(), var1);
	}

	public void method5821(boolean var1) {
		if (this.method5627() && !var1) {
			this.method5697(Math.min(this.field3419, this.field3418), var1);
		} else if (this.field3418 > 0) {
			this.method5697(this.field3418 - 1, var1);
		}

	}

	public void method5579(boolean var1) {
		if (this.method5627() && !var1) {
			this.method5697(Math.max(this.field3419, this.field3418), var1);
		} else if (this.field3418 < this.field3409.method7091()) {
			this.method5697(1 + this.field3418, var1);
		}

	}

	public void method5591(boolean var1) {
		if (this.field3418 > 0) {
			class438 var3 = this.method5630(this.field3418 - 1);
			this.method5697((Integer)var3.field4727, var1);
		}

	}

	public void method5592(boolean var1) {
		if (this.field3418 < this.field3409.method7091()) {
			class438 var3 = this.method5630(1 + this.field3418);
			this.method5697((Integer)var3.field4728, var1);
		}

	}

	public void method5679(boolean var1) {
		if (this.field3418 > 0) {
			this.method5697(this.field3409.method7048(this.field3418, -1), var1);
		}

	}

	public void method5803(boolean var1) {
		if (this.field3418 < this.field3409.method7091()) {
			this.method5697(this.field3409.method7048(this.field3418, 1), var1);
		}

	}

	public void method5561(boolean var1) {
		if (this.field3418 > 0) {
			int var3 = this.method5634();
			this.method5697(this.field3409.method7048(this.field3418, -var3), var1);
		}

	}

	public void method5596(boolean var1) {
		if (this.field3418 < this.field3409.method7091()) {
			int var3 = this.method5634();
			this.method5697(this.field3409.method7048(this.field3418, var3), var1);
		}

	}

	public void method5730(boolean var1) {
		class388 var3 = this.field3409.method7039(0, this.field3418);
		class438 var4 = var3.method6997();
		this.method5697(this.field3409.method7078((Integer)var4.field4727, this.field3428), var1);
	}

	public void method5598(boolean var1) {
		class388 var3 = this.field3409.method7039(0, this.field3418);
		class438 var4 = var3.method6997();
		this.method5697(this.field3409.method7078((Integer)var4.field4727, this.field3415 + this.field3428), var1);
	}

	public void method5599(int var1, int var2, boolean var3, boolean var4) {
		boolean var6 = false;
		int var9;
		if (!this.field3403) {
			var9 = 0;
		} else {
			var1 += this.field3427;
			var2 += this.field3428;
			var9 = this.field3409.method7078(var1, var2);
		}

		class438 var7;
		if (var3 && var4) {
			this.field3421 = 1;
			var7 = this.method5630(var9);
			class438 var8 = this.method5630(this.field3420);
			this.method5629(var8, var7);
		} else if (var3) {
			this.field3421 = 1;
			var7 = this.method5630(var9);
			this.method5584((Integer)var7.field4727, (Integer)var7.field4728);
			this.field3420 = (Integer)var7.field4727;
		} else if (var4) {
			this.method5584(this.field3420, var9);
		} else {
			if (this.field3426 > 0 && this.field3420 == var9) {
				if (this.field3418 == this.field3419) {
					this.field3421 = 1;
					var7 = this.method5630(var9);
					this.method5584((Integer)var7.field4727, (Integer)var7.field4728);
				} else {
					this.field3421 = 2;
					var7 = this.method5631(var9);
					this.method5584((Integer)var7.field4727, (Integer)var7.field4728);
				}
			} else {
				this.field3421 = 0;
				this.method5584(var9, var9);
				this.field3420 = var9;
			}

			this.field3426 = 25;
		}

	}

	public void method5600(int var1, int var2) {
		if (this.field3403 && this.method5593()) {
			var1 += this.field3427;
			var2 += this.field3428;
			int var4 = this.field3409.method7078(var1, var2);
			class438 var5;
			class438 var6;
			switch(this.field3421) {
			case 0:
				this.method5584(this.field3419, var4);
				break;
			case 1:
				var5 = this.method5630(this.field3420);
				var6 = this.method5630(var4);
				this.method5629(var5, var6);
				break;
			case 2:
				var5 = this.method5631(this.field3420);
				var6 = this.method5631(var4);
				this.method5629(var5, var6);
			}
		}

	}

	public void method5633(Clipboard var1) {
		class388 var3 = this.field3409.method7039(this.field3419, this.field3418);
		if (!var3.method6993()) {
			String var4 = var3.method7012();
			if (!var4.isEmpty()) {
				var1.setContents(new StringSelection(var4), (ClipboardOwner)null);
			}
		}

	}

	public void method5602(Clipboard var1) {
		if (this.method5627()) {
			this.method5633(var1);
			this.method5582();
		}

	}

	public void method5647(Clipboard var1) {
		Transferable var3 = var1.getContents((Object)null);
		if (var3 != null && var3.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String var4 = this.method5670((String)var3.getTransferData(DataFlavor.stringFlavor));
				this.method5582();
				class385 var5 = this.field3409.method7083(var4, this.field3418, this.field3402, this.field3422);
				this.method5584(var5.method6958(), var5.method6958());
				this.method5632();
				this.method5637();
			} catch (Exception var6) {
				System.out.println("Error pasting clipboard to InputField.");
			}
		}

	}

	public void method5710() {
		this.field3428 = Math.max(0, this.field3428 - this.field3409.method7051());
	}

	public void method5597() {
		int var2 = Math.max(0, this.field3409.method7117() - this.field3415);
		this.field3428 = Math.min(var2, this.field3428 + this.field3409.method7051());
	}

	public void method5606(class301 var1) {
		this.field3429 = var1;
	}

	public void method5607(class301 var1) {
		this.field3430 = var1;
	}

	public class390 method5755() {
		return this.field3409;
	}

	public class390 method5609() {
		return this.field3423;
	}

	public class388 method5610() {
		return this.field3409.method7039(this.field3419, this.field3418);
	}

	public boolean method5593() {
		return this.field3411;
	}

	public boolean method5612() {
		return this.field3412;
	}

	public boolean method5613() {
		return this.method5593() && this.field3413 % 60 < 30;
	}

	public int method5614() {
		return this.field3418;
	}

	public int method5691() {
		return this.field3419;
	}

	public boolean method5699() {
		return this.field3403;
	}

	public int method5617() {
		return this.field3427;
	}

	public int method5685() {
		return this.field3428;
	}

	public int method5619() {
		return this.field3409.method7054();
	}

	public int method5620() {
		return this.field3422;
	}

	public int method5621() {
		return this.field3416;
	}

	public int method5622() {
		return this.field3414;
	}

	public int method5823() {
		return this.field3409.method7041();
	}

	public int method5747() {
		return this.field3417;
	}

	public int method5625() {
		return this.field3409.method7056();
	}

	public boolean method5626() {
		return this.field3422 > 1;
	}

	boolean method5627() {
		return this.field3418 != this.field3419;
	}

	String method5670(String var1) {
		StringBuilder var3 = new StringBuilder(var1.length());

		for (int var4 = 0; var4 < var1.length(); ++var4) {
			char var5 = var1.charAt(var4);
			if (this.method5638(var5)) {
				var3.append(var5);
			}
		}

		return var3.toString();
	}

	void method5629(class438 var1, class438 var2) {
		if ((Integer)var2.field4727 < (Integer)var1.field4727) {
			this.method5584((Integer)var1.field4728, (Integer)var2.field4727);
		} else {
			this.method5584((Integer)var1.field4727, (Integer)var2.field4728);
		}

	}

	class438 method5630(int var1) {
		int var3 = this.field3409.method7091();
		int var4 = 0;
		int var5 = var3;

		int var6;
		for (var6 = var1; var6 > 0; --var6) {
			if (this.method5768(this.field3409.method7029(var6 - 1).field4428)) {
				var4 = var6;
				break;
			}
		}

		for (var6 = var1; var6 < var3; ++var6) {
			if (this.method5768(this.field3409.method7029(var6).field4428)) {
				var5 = var6;
				break;
			}
		}

		return new class438(var4, var5);
	}

	class438 method5631(int var1) {
		int var3 = this.field3409.method7091();
		int var4 = 0;
		int var5 = var3;

		int var6;
		for (var6 = var1; var6 > 0; --var6) {
			if (this.field3409.method7029(var6 - 1).field4428 == '\n') {
				var4 = var6;
				break;
			}
		}

		for (var6 = var1; var6 < var3; ++var6) {
			if (this.field3409.method7029(var6).field4428 == '\n') {
				var5 = var6;
				break;
			}
		}

		return new class438(var4, var5);
	}

	boolean method5632() {
		if (!this.method5699()) {
			return false;
		} else {
			boolean var2 = false;
			if (this.field3409.method7091() > this.field3416) {
				this.field3409.method7046(this.field3416, this.field3409.method7091());
				var2 = true;
			}

			int var3;
			if (this.field3409.method7052() > this.field3422) {
				var3 = this.field3409.method7048(0, this.field3422) - 1;
				this.field3409.method7046(var3, this.field3409.method7091());
				var2 = true;
			}

			if (var2) {
				var3 = this.field3418;
				int var4 = this.field3419;
				int var5 = this.field3409.method7091();
				if (this.field3418 > var5) {
					var3 = var5;
				}

				if (this.field3419 > var5) {
					var4 = var5;
				}

				this.method5584(var4, var3);
			}

			return var2;
		}
	}

	void method5697(int var1, boolean var2) {
		if (var2) {
			this.method5584(this.field3419, var1);
		} else {
			this.method5584(var1, var1);
		}

	}

	int method5634() {
		return this.field3415 / this.field3409.method7051();
	}

	void method5587() {
		class388 var2 = this.field3409.method7039(0, this.field3418);
		class438 var3 = var2.method6997();
		int var4 = this.field3409.method7051();
		int var5 = (Integer)var3.field4727 - 10;
		int var6 = var5 + 20;
		int var7 = (Integer)var3.field4728 - 3;
		int var8 = 6 + var7 + var4;
		int var9 = this.field3427;
		int var10 = this.field3425 + var9;
		int var11 = this.field3428;
		int var12 = var11 + this.field3415;
		int var13 = this.field3427;
		int var14 = this.field3428;
		if (var5 < var9) {
			var13 = var5;
		} else if (var6 > var10) {
			var13 = var6 - this.field3425;
		}

		if (var7 < var11) {
			var14 = var7;
		} else if (var8 > var12) {
			var14 = var8 - this.field3415;
		}

		this.method5739(var13, var14);
	}

	boolean method5768(int var1) {
		return 32 == var1 || var1 == 10 || 9 == var1;
	}

	void method5637() {
		if (this.field3429 != null) {
			this.field3429.method5987();
		}

	}

	boolean method5638(int var1) {
		switch(this.field3417) {
		case 1:
			return class148.method2543((char)var1);
		case 2:
			return class122.method2302((char)var1);
		case 3:
			return class347.method6422((char)var1);
		case 4:
			char var3 = (char)var1;
			if (class347.method6422(var3)) {
				return true;
			} else {
				if ('k' != var3 && var3 != 'K' && var3 != 'm' && var3 != 'M' && var3 != 'b' && var3 != 'B') {
					return false;
				}

				return true;
			}
		default:
			return true;
		}
	}
}
