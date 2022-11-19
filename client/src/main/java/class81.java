import client.Client;

import java.net.MalformedURLException;
import java.net.URL;

public final class class81 extends class90 {
	class203 field709;
	int field711;
	String field708;

	class81() {
		this.field708 = "";
		this.field711 = 31;
	}

	void method1616(String var1) {
		this.field708 = null == var1 ? "" : var1;
	}

	void method1617(int var1) {
		this.field711 = var1;
	}

	boolean method1639(int var1) {
		if (var1 >= 0 && var1 <= 4) {
			return (this.field711 & 1 << var1) != 0;
		} else {
			return true;
		}
	}

	final String method1620() {
		if (!this.field708.isEmpty()) {
			return this.field708;
		} else {
			class203 var2 = this.field709;
			if (var2.field2278 != null) {
				var2 = var2.method3857();
				if (null == var2) {
					var2 = this.field709;
				}
			}

			return var2.field2261;
		}
	}

	final void method1615(int var1, class197 var2) {
		int var4 = super.field861[0];
		int var5 = super.field873[0];
		if (var1 == 0) {
			--var4;
			++var5;
		}

		if (var1 == 1) {
			++var5;
		}

		if (var1 == 2) {
			++var4;
			++var5;
		}

		if (var1 == 3) {
			--var4;
		}

		if (var1 == 4) {
			++var4;
		}

		if (var1 == 5) {
			--var4;
			--var5;
		}

		if (var1 == 6) {
			--var5;
		}

		if (var1 == 7) {
			++var4;
			--var5;
		}

		if (-1 != super.field852 && class160.method2660(super.field852).field1992 == 1) {
			super.field852 = -1;
		}

		if (super.field871 < 9) {
			++super.field871;
		}

		for (int var6 = super.field871; var6 > 0; --var6) {
			super.field861[var6] = super.field861[var6 - 1];
			super.field873[var6] = super.field873[var6 - 1];
			super.field803[var6] = super.field803[var6 - 1];
		}

		super.field861[0] = var4;
		super.field873[0] = var5;
		super.field803[0] = var2;
	}

	final void method1625(int var1, int var2, boolean var3) {
		if (super.field852 != -1 && class160.method2660(super.field852).field1992 == 1) {
			super.field852 = -1;
		}

		if (!var3) {
			int var5 = var1 - super.field861[0];
			int var6 = var2 - super.field873[0];
			if (var5 >= -8 && var5 <= 8 && var6 >= -8 && var6 <= 8) {
				if (super.field871 < 9) {
					++super.field871;
				}

				for (int var7 = super.field871; var7 > 0; --var7) {
					super.field861[var7] = super.field861[var7 - 1];
					super.field873[var7] = super.field873[var7 - 1];
					super.field803[var7] = super.field803[var7 - 1];
				}

				super.field861[0] = var1;
				super.field873[0] = var2;
				super.field803[0] = class197.field2114;
				return;
			}
		}

		super.field871 = 0;
		super.field876 = 0;
		super.field837 = 0;
		super.field861[0] = var1;
		super.field873[0] = var2;
		super.field827 = super.field866 * 64 + super.field861[0] * 128;
		super.field802 = super.field866 * 64 + super.field873[0] * 128;
	}

	protected final class209 method4112() {
		if (this.field709 == null) {
			return null;
		} else {
			class189 var2 = -1 != super.field852 && 0 == super.field804 ? class160.method2660(super.field852) : null;
			class189 var3 = super.field839 != -1 && (super.field823 != super.field839 || null == var2) ? class160.method2660(super.field839) : null;
			class209 var4 = this.field709.method3855(var2, super.field844, var3, super.field840);
			if (var4 == null) {
				return null;
			} else {
				var4.method4067();
				super.field809 = var4.field2489;
				int var5 = var4.field2409;
				if (super.field848 != -1 && super.field856 != -1) {
					class209 var6 = class207.method803(super.field848).method3972(super.field856);
					if (null != var6) {
						var6.method4008(0, -super.field824, 0);
						class209[] var7 = new class209[]{var4, var6};
						var4 = new class209(var7, 2);
					}
				}

				if (1 == this.field709.field2262) {
					var4.field2407 = true;
				}

				if (super.field867 != 0 && Client.field1645 >= super.field862 && Client.field1645 < super.field863) {
					var4.field2440 = super.field864;
					var4.field2417 = super.field865;
					var4.field2453 = super.field850;
					var4.field2454 = super.field867;
					var4.field2455 = (short)var5;
				} else {
					var4.field2454 = 0;
				}

				return var4;
			}
		}
	}

	final boolean method1869() {
		return null != this.field709;
	}

	static boolean method1622(String var0) {
		if (var0 == null) {
			return false;
		} else {
			try {
				new URL(var0);
				return true;
			} catch (MalformedURLException var3) {
				return false;
			}
		}
	}
}
