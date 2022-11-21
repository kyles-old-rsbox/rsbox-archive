import java.util.Comparator;

public abstract class class393 implements Comparator {
	Comparator field4487;

	protected class393() {
	}

	final void method7159(Comparator var1) {
		if (null == this.field4487) {
			this.field4487 = var1;
		} else if (this.field4487 instanceof class393) {
			((class393)this.field4487).method7159(var1);
		}

	}

	protected final int method7162(class400 var1, class400 var2) {
		return this.field4487 == null ? 0 : this.field4487.compare(var1, var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public static class488 method7165(class319 var0, String var1, String var2) {
		int var4 = var0.getGroupId(var1);
		int var5 = var0.method6170(var4, var2);
		byte[] var8 = var0.method6175(var4, var5);
		boolean var7;
		if (var8 == null) {
			var7 = false;
		} else {
			class317.method6080(var8);
			var7 = true;
		}

		class488 var6;
		if (!var7) {
			var6 = null;
		} else {
			class488 var9 = new class488();
			var9.field5016 = class475.field4967;
			var9.field5018 = class475.field4971;
			var9.field5020 = class450.field4840[0];
			var9.field5021 = class315.field3720[0];
			var9.field5017 = class467.field4921[0];
			var9.field5019 = class475.field4966[0];
			var9.field5023 = class475.field4970;
			var9.field5022 = class451.field4844[0];
			class450.field4840 = null;
			class315.field3720 = null;
			class467.field4921 = null;
			class475.field4966 = null;
			class475.field4970 = null;
			class451.field4844 = (byte[][])null;
			var6 = var9;
		}

		return var6;
	}

	static int method7161(int var0, class78 var1, boolean var2) {
		if (var0 < 1000) {
			return class11.method84(var0, var1, var2);
		} else if (var0 < 1100) {
			return class323.method6202(var0, var1, var2);
		} else if (var0 < 1200) {
			return class445.method7936(var0, var1, var2);
		} else if (var0 < 1300) {
			return class100.method1986(var0, var1, var2);
		} else if (var0 < 1400) {
			return class87.method1849(var0, var1, var2);
		} else if (var0 < 1500) {
			return class307.method6045(var0, var1, var2);
		} else if (var0 < 1600) {
			return class227.method4511(var0, var1, var2);
		} else if (var0 < 1700) {
			return class141.method2477(var0, var1, var2);
		} else if (var0 < 1800) {
			return class191.method3535(var0, var1, var2);
		} else if (var0 < 1900) {
			return class18.method221(var0, var1, var2);
		} else if (var0 < 2000) {
			return class204.method3891(var0, var1, var2);
		} else if (var0 < 2100) {
			return class323.method6202(var0, var1, var2);
		} else if (var0 < 2200) {
			return class445.method7936(var0, var1, var2);
		} else if (var0 < 2300) {
			return class100.method1986(var0, var1, var2);
		} else if (var0 < 2400) {
			return class87.method1849(var0, var1, var2);
		} else if (var0 < 2500) {
			return class307.method6045(var0, var1, var2);
		} else if (var0 < 2600) {
			return class396.method7176(var0, var1, var2);
		} else if (var0 < 2700) {
			return class83.method1796(var0, var1, var2);
		} else if (var0 < 2800) {
			return class2.method15(var0, var1, var2);
		} else if (var0 < 2900) {
			return class148.method2527(var0, var1, var2);
		} else if (var0 < 3000) {
			return class204.method3891(var0, var1, var2);
		} else if (var0 < 3200) {
			return class271.method5211(var0, var1, var2);
		} else if (var0 < 3300) {
			return class189.method3490(var0, var1, var2);
		} else if (var0 < 3400) {
			return class218.method4369(var0, var1, var2);
		} else if (var0 < 3500) {
			return class153.method2594(var0, var1, var2);
		} else if (var0 < 3600) {
			return class306.method6032(var0, var1, var2);
		} else if (var0 < 3700) {
			return class34.method621(var0, var1, var2);
		} else if (var0 < 3800) {
			return class57.method33(var0, var1, var2);
		} else if (var0 < 3900) {
			return class45.method952(var0, var1, var2);
		} else if (var0 < 4000) {
			return class289.method5464(var0, var1, var2);
		} else if (var0 < 4100) {
			return class90.method1884(var0, var1, var2);
		} else if (var0 < 4200) {
			return class90.method1886(var0, var1, var2);
		} else if (var0 < 4300) {
			return class325.method6221(var0, var1, var2);
		} else if (var0 < 5100) {
			return class179.method2843(var0, var1, var2);
		} else if (var0 < 5400) {
			return class143.method2496(var0, var1, var2);
		} else if (var0 < 5600) {
			return class114.method2219(var0, var1, var2);
		} else if (var0 < 5700) {
			return class30.method438(var0, var1, var2);
		} else if (var0 < 6300) {
			return class271.method5217(var0, var1, var2);
		} else if (var0 < 6600) {
			return class88.method1864(var0, var1, var2);
		} else if (var0 < 6700) {
			return class346.method6405(var0, var1, var2);
		} else if (var0 < 6800) {
			return class63.method1365(var0, var1, var2);
		} else if (var0 < 6900) {
			return class127.method2382(var0, var1, var2);
		} else if (var0 < 7000) {
			return class57.method2918(var0, var1, var2);
		} else if (var0 < 7100) {
			return class57.method211(var0, var1, var2);
		} else if (var0 < 7200) {
			return class332.method6264(var0, var1, var2);
		} else if (var0 < 7300) {
			return class57.method4885(var0, var1, var2);
		} else if (var0 < 7500) {
			return class141.method2478(var0, var1, var2);
		} else if (var0 < 7600) {
			return class36.method711(var0, var1, var2);
		} else {
			return var0 < 7700 ? class57.method4728(var0, var1, var2) : 2;
		}
	}
}
