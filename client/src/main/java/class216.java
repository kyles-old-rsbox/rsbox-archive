public class class216 {
	class113[] field2570;
	int field2569;

	class216(Buffer var1, int var2) {
		this.field2570 = new class113[var2];
		this.field2569 = var1.method8141();

		for (int var3 = 0; var3 < this.field2570.length; ++var3) {
			class113 var4 = new class113(this.field2569, var1, false);
			this.field2570[var3] = var4;
		}

		this.method4337();
	}

	void method4337() {
		class113[] var2 = this.field2570;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class113 var4 = var2[var3];
			if (var4.field1109 >= 0) {
				var4.field1110 = this.field2570[var4.field1109];
			}
		}

	}

	public int method4346() {
		return this.field2570.length;
	}

	class113 method4344(int var1) {
		return var1 >= this.method4346() ? null : this.field2570[var1];
	}

	class113[] method4352() {
		return this.field2570;
	}

	void method4341(class112 var1, int var2) {
		this.method4342(var1, var2, (boolean[])null, false);
	}

	void method4342(class112 var1, int var2, boolean[] var3, boolean var4) {
		int var6 = var1.method2147();
		int var7 = 0;
		class113[] var8 = this.method4352();

		for (int var9 = 0; var9 < var8.length; ++var9) {
			class113 var10 = var8[var9];
			if (var3 == null || var3[var7] == var4) {
				var1.method2164(var2, var10, var7, var6);
			}

			++var7;
		}

	}

	static char method4360(char var0, class353 var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != class353.field4292) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && class353.field4292 != var1) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else if (var0 == 376) {
			return 'Y';
		} else {
			return var0;
		}
	}
}
