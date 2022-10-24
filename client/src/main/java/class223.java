public class class223 {
	static int[] field2651;
	static int[] field2652;
	static int[] field2653;
	static int[] field2655;
	boolean field2659;
	class230 field2650;
	int field2654;
	int[] field2649;
	int[] field2656;
	int[] field2657;
	int[] field2658;

	static {
		field2655 = new int[500];
		field2653 = new int[500];
		field2651 = new int[500];
		field2652 = new int[500];
	}

	class223(byte[] var1, class230 var2) {
		this.field2650 = null;
		this.field2654 = -1;
		this.field2659 = false;
		this.field2650 = var2;
		class460 var3 = new class460(var1);
		class460 var4 = new class460(var1);
		var3.field4878 = 2;
		int var5 = var3.method8141();
		int var6 = -1;
		int var7 = 0;
		var4.field4878 = var3.field4878 + var5;

		int var8;
		for (var8 = 0; var8 < var5; ++var8) {
			int var9 = var3.method8141();
			if (var9 > 0) {
				if (this.field2650.field2745[var8] != 0) {
					for (int var10 = var8 - 1; var10 > var6; --var10) {
						if (this.field2650.field2745[var10] == 0) {
							field2655[var7] = var10;
							field2653[var7] = 0;
							field2651[var7] = 0;
							field2652[var7] = 0;
							++var7;
							break;
						}
					}
				}

				field2655[var7] = var8;
				short var11 = 0;
				if (this.field2650.field2745[var8] == 3) {
					var11 = 128;
				}

				if ((var9 & 1) != 0) {
					field2653[var7] = var4.method8219();
				} else {
					field2653[var7] = var11;
				}

				if ((var9 & 2) != 0) {
					field2651[var7] = var4.method8219();
				} else {
					field2651[var7] = var11;
				}

				if ((var9 & 4) != 0) {
					field2652[var7] = var4.method8219();
				} else {
					field2652[var7] = var11;
				}

				var6 = var8;
				++var7;
				if (this.field2650.field2745[var8] == 5) {
					this.field2659 = true;
				}
			}
		}

		if (var4.field4878 != var1.length) {
			throw new RuntimeException();
		} else {
			this.field2654 = var7;
			this.field2658 = new int[var7];
			this.field2656 = new int[var7];
			this.field2657 = new int[var7];
			this.field2649 = new int[var7];

			for (var8 = 0; var8 < var7; ++var8) {
				this.field2658[var8] = field2655[var8];
				this.field2656[var8] = field2653[var8];
				this.field2657[var8] = field2651[var8];
				this.field2649[var8] = field2652[var8];
			}

		}
	}
}
