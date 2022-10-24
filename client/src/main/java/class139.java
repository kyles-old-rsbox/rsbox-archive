public class class139 extends class140 {
	static class336 field1286;
	static class473 field1292;
	int field1290;
	String field1287;
	long field1293;
	// $FF: synthetic field
	final class142 this$0;

	class139(class142 var1) {
		this.this$0 = var1;
		this.field1293 = -1L;
		this.field1287 = null;
		this.field1290 = 0;
	}

	void method2467(class460 var1) {
		if (var1.method8141() != 255) {
			--var1.field4878;
			this.field1293 = var1.method8127();
		}

		this.field1287 = var1.method8305();
		this.field1290 = var1.method8122();
	}

	void method2468(class148 var1) {
		var1.method2529(this.field1293, this.field1287, this.field1290);
	}

	static void method2465(class106 var0, float[] var1, float[] var2) {
		if (var0 != null) {
			var0.field1053 = var1[0];
			float var4 = var1[3] - var1[0];
			float var5 = var2[3] - var2[0];
			float var6 = var1[1] - var1[0];
			float var7 = 0.0F;
			float var8 = 0.0F;
			if ((double)var6 != 0.0D) {
				var7 = (var2[1] - var2[0]) / var6;
			}

			var6 = var1[3] - var1[2];
			if (0.0D != (double)var6) {
				var8 = (var2[3] - var2[2]) / var6;
			}

			float var9 = 1.0F / (var4 * var4);
			float var10 = var4 * var7;
			float var11 = var8 * var4;
			var0.field1055[0] = var9 * (var11 + var10 - var5 - var5) / var4;
			var0.field1055[1] = var9 * (var5 + var5 + var5 - var10 - var10 - var11);
			var0.field1055[2] = var7;
			var0.field1055[3] = var2[0];
		}
	}
}
