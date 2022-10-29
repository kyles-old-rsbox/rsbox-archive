public class class191 {
	public static int field2019;
	public static int field2022;
	public static int[] field2017;
	public static int[] field2021;
	public static int[][] field2020;
	public static int[][] field2023;
	static class448 field2026;

	static {
		field2023 = new int[128][128];
		field2020 = new int[128][128];
		field2017 = new int[4096];
		field2021 = new int[4096];
	}

	class191() throws Throwable {
		throw new Error();
	}

	public static class187 method3536(int var0) {
		class187 var2 = (class187)class187.field1977.method5439((long)var0);
		if (null != var2) {
			return var2;
		} else {
			byte[] var3 = class187.field1978.method6175(34, var0);
			var2 = new class187();
			if (null != var3) {
				var2.method3459(new class460(var3));
			}

			var2.method3455();
			class187.field1977.method5434(var2, (long)var0);
			return var2;
		}
	}

	static int method3535(int var0, class78 var1, boolean var2) {
		class300 var4 = var2 ? class138.field1284 : class153.field1414;
		if (var0 == CS2Opcodes.CC_GETINVOBJECT) {
			class57.field404[++class387.field4452 - 1] = var4.field3445;
			return 1;
		} else if (var0 == CS2Opcodes.CC_GETINVCOUNT) {
			if (-1 != var4.field3445) {
				class57.field404[++class387.field4452 - 1] = var4.field3599;
			} else {
				class57.field404[++class387.field4452 - 1] = 0;
			}

			return 1;
		} else if (var0 == CS2Opcodes.CC_GETID) {
			class57.field404[++class387.field4452 - 1] = var4.field3484;
			return 1;
		} else if (var0 == CS2Opcodes.CC_GETCRM_HASRESPONSE) {
			class57.field404[++class387.field4452 - 1] = var4.method5876() ? 1 : 0;
			return 1;
		} else if (var0 == CS2Opcodes.CC_GETCRM_INT) {
			return class405.method7368(var4);
		} else {
			return var0 == CS2Opcodes.CC_GETCRM_STRING ? class112.method2170(var4) : 2;
		}
	}

	static Object method3533(class451 var0) {
		if (null == var0) {
			throw new IllegalStateException("popValueOfType() failure - null baseVarType");
		} else {
			switch(var0.field4845) {
			case 0:
				return class57.field404[--class387.field4452];
			case 1:
				return class57.field405[--class126.field1220];
			default:
				throw new IllegalStateException("popValueOfType() failure - unsupported type");
			}
		}
	}
}
