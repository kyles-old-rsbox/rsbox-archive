import java.util.Arrays;

public final class class412 {
	public static final class412 field4564;
	static class412[] field4560;
	static int field4561;
	static int field4562;
	public float[] field4563;

	static {
		field4560 = new class412[0];
		field4561 = 100;
		field4560 = new class412[100];
		field4562 = 0;
		field4564 = new class412();
	}

	public void method7469() {
		synchronized(field4560) {
			if (field4562 < field4561 - 1) {
				field4560[++field4562 - 1] = this;
			}

		}
	}

	public class412() {
		this.field4563 = new float[16];
		this.method7420();
	}

	public class412(class412 var1) {
		this.field4563 = new float[16];
		this.method7422(var1);
	}

	public class412(class460 var1, boolean var2) {
		this.field4563 = new float[16];
		this.method7463(var1, var2);
	}

	void method7463(class460 var1, boolean var2) {
		if (var2) {
			class414 var4 = new class414();
			int var7 = var1.method8204();
			var7 &= 16383;
			float var6 = (float)((double)((float)var7 / 16384.0F) * 6.283185307179586D);
			var4.method7502(var6);
			var4.method7520(class422.method3465(var1.method8204()));
			int var10 = var1.method8204();
			var10 &= 16383;
			float var9 = (float)((double)((float)var10 / 16384.0F) * 6.283185307179586D);
			var4.method7521(var9);
			var4.method7504((float)var1.method8204(), (float)var1.method8204(), (float)var1.method8204());
			this.method7428(var4);
		} else {
			for (int var11 = 0; var11 < 16; ++var11) {
				this.field4563[var11] = var1.method8128();
			}
		}

	}

	float[] method7418() {
		float[] var2 = new float[3];
		if ((double)this.field4563[2] < 0.999D && (double)this.field4563[2] > -0.999D) {
			var2[1] = (float)(-Math.asin((double)this.field4563[2]));
			double var3 = Math.cos((double)var2[1]);
			var2[0] = (float)Math.atan2((double)this.field4563[6] / var3, (double)this.field4563[10] / var3);
			var2[2] = (float)Math.atan2((double)this.field4563[1] / var3, (double)this.field4563[0] / var3);
		} else {
			var2[0] = 0.0F;
			var2[1] = (float)Math.atan2((double)this.field4563[2], 0.0D);
			var2[2] = (float)Math.atan2((double)(-this.field4563[9]), (double)this.field4563[5]);
		}

		return var2;
	}

	public float[] method7419() {
		float[] var2 = new float[]{(float)(-Math.asin((double)this.field4563[6])), 0.0F, 0.0F};
		double var3 = Math.cos((double)var2[0]);
		double var5;
		double var7;
		if (Math.abs(var3) > 0.005D) {
			var5 = (double)this.field4563[2];
			var7 = (double)this.field4563[10];
			double var9 = (double)this.field4563[4];
			double var11 = (double)this.field4563[5];
			var2[1] = (float)Math.atan2(var5, var7);
			var2[2] = (float)Math.atan2(var9, var11);
		} else {
			var5 = (double)this.field4563[1];
			var7 = (double)this.field4563[0];
			if (this.field4563[6] < 0.0F) {
				var2[1] = (float)Math.atan2(var5, var7);
			} else {
				var2[1] = (float)(-Math.atan2(var5, var7));
			}

			var2[2] = 0.0F;
		}

		return var2;
	}

	void method7420() {
		this.field4563[0] = 1.0F;
		this.field4563[1] = 0.0F;
		this.field4563[2] = 0.0F;
		this.field4563[3] = 0.0F;
		this.field4563[4] = 0.0F;
		this.field4563[5] = 1.0F;
		this.field4563[6] = 0.0F;
		this.field4563[7] = 0.0F;
		this.field4563[8] = 0.0F;
		this.field4563[9] = 0.0F;
		this.field4563[10] = 1.0F;
		this.field4563[11] = 0.0F;
		this.field4563[12] = 0.0F;
		this.field4563[13] = 0.0F;
		this.field4563[14] = 0.0F;
		this.field4563[15] = 1.0F;
	}

	public void method7421() {
		this.field4563[0] = 0.0F;
		this.field4563[1] = 0.0F;
		this.field4563[2] = 0.0F;
		this.field4563[3] = 0.0F;
		this.field4563[4] = 0.0F;
		this.field4563[5] = 0.0F;
		this.field4563[6] = 0.0F;
		this.field4563[7] = 0.0F;
		this.field4563[8] = 0.0F;
		this.field4563[9] = 0.0F;
		this.field4563[10] = 0.0F;
		this.field4563[11] = 0.0F;
		this.field4563[12] = 0.0F;
		this.field4563[13] = 0.0F;
		this.field4563[14] = 0.0F;
		this.field4563[15] = 0.0F;
	}

	public void method7422(class412 var1) {
		System.arraycopy(var1.field4563, 0, this.field4563, 0, 16);
	}

	public void method7454(float var1) {
		this.method7424(var1, var1, var1);
	}

	public void method7424(float var1, float var2, float var3) {
		this.method7420();
		this.field4563[0] = var1;
		this.field4563[5] = var2;
		this.field4563[10] = var3;
	}

	public void method7447(class412 var1) {
		for (int var3 = 0; var3 < this.field4563.length; ++var3) {
			float[] var10000 = this.field4563;
			var10000[var3] += var1.field4563[var3];
		}

	}

	public void method7426(class412 var1) {
		float var3 = var1.field4563[12] * this.field4563[3] + this.field4563[0] * var1.field4563[0] + this.field4563[1] * var1.field4563[4] + this.field4563[2] * var1.field4563[8];
		float var4 = var1.field4563[13] * this.field4563[3] + this.field4563[2] * var1.field4563[9] + this.field4563[0] * var1.field4563[1] + var1.field4563[5] * this.field4563[1];
		float var5 = this.field4563[3] * var1.field4563[14] + this.field4563[0] * var1.field4563[2] + var1.field4563[6] * this.field4563[1] + var1.field4563[10] * this.field4563[2];
		float var6 = this.field4563[2] * var1.field4563[11] + this.field4563[0] * var1.field4563[3] + var1.field4563[7] * this.field4563[1] + var1.field4563[15] * this.field4563[3];
		float var7 = this.field4563[7] * var1.field4563[12] + var1.field4563[8] * this.field4563[6] + var1.field4563[0] * this.field4563[4] + var1.field4563[4] * this.field4563[5];
		float var8 = this.field4563[6] * var1.field4563[9] + var1.field4563[5] * this.field4563[5] + this.field4563[4] * var1.field4563[1] + this.field4563[7] * var1.field4563[13];
		float var9 = var1.field4563[14] * this.field4563[7] + this.field4563[4] * var1.field4563[2] + var1.field4563[6] * this.field4563[5] + this.field4563[6] * var1.field4563[10];
		float var10 = var1.field4563[15] * this.field4563[7] + var1.field4563[3] * this.field4563[4] + this.field4563[5] * var1.field4563[7] + this.field4563[6] * var1.field4563[11];
		float var11 = var1.field4563[12] * this.field4563[11] + this.field4563[9] * var1.field4563[4] + var1.field4563[0] * this.field4563[8] + var1.field4563[8] * this.field4563[10];
		float var12 = this.field4563[9] * var1.field4563[5] + this.field4563[8] * var1.field4563[1] + this.field4563[10] * var1.field4563[9] + this.field4563[11] * var1.field4563[13];
		float var13 = this.field4563[9] * var1.field4563[6] + var1.field4563[2] * this.field4563[8] + this.field4563[10] * var1.field4563[10] + this.field4563[11] * var1.field4563[14];
		float var14 = this.field4563[11] * var1.field4563[15] + this.field4563[10] * var1.field4563[11] + this.field4563[9] * var1.field4563[7] + this.field4563[8] * var1.field4563[3];
		float var15 = var1.field4563[12] * this.field4563[15] + var1.field4563[4] * this.field4563[13] + var1.field4563[0] * this.field4563[12] + this.field4563[14] * var1.field4563[8];
		float var16 = var1.field4563[13] * this.field4563[15] + this.field4563[12] * var1.field4563[1] + this.field4563[13] * var1.field4563[5] + var1.field4563[9] * this.field4563[14];
		float var17 = var1.field4563[2] * this.field4563[12] + var1.field4563[6] * this.field4563[13] + var1.field4563[10] * this.field4563[14] + var1.field4563[14] * this.field4563[15];
		float var18 = var1.field4563[15] * this.field4563[15] + var1.field4563[11] * this.field4563[14] + this.field4563[13] * var1.field4563[7] + var1.field4563[3] * this.field4563[12];
		this.field4563[0] = var3;
		this.field4563[1] = var4;
		this.field4563[2] = var5;
		this.field4563[3] = var6;
		this.field4563[4] = var7;
		this.field4563[5] = var8;
		this.field4563[6] = var9;
		this.field4563[7] = var10;
		this.field4563[8] = var11;
		this.field4563[9] = var12;
		this.field4563[10] = var13;
		this.field4563[11] = var14;
		this.field4563[12] = var15;
		this.field4563[13] = var16;
		this.field4563[14] = var17;
		this.field4563[15] = var18;
	}

	public static class488 method7415(class319 var0, int var1) {
		if (!class475.method2719(var0, var1)) {
			return null;
		} else {
			class488 var4 = new class488();
			var4.field5016 = class475.field4967;
			var4.field5018 = class475.field4971;
			var4.field5020 = class450.field4840[0];
			var4.field5021 = class315.field3720[0];
			var4.field5017 = class467.field4921[0];
			var4.field5019 = class475.field4966[0];
			var4.field5023 = class475.field4970;
			var4.field5022 = class451.field4844[0];
			class450.field4840 = null;
			class315.field3720 = null;
			class467.field4921 = null;
			class475.field4966 = null;
			class475.field4970 = null;
			class451.field4844 = (byte[][])null;
			return var4;
		}
	}

	public void method7427(class415 var1) {
		float var3 = var1.field4591 * var1.field4591;
		float var4 = var1.field4591 * var1.field4592;
		float var5 = var1.field4589 * var1.field4591;
		float var6 = var1.field4593 * var1.field4591;
		float var7 = var1.field4592 * var1.field4592;
		float var8 = var1.field4589 * var1.field4592;
		float var9 = var1.field4593 * var1.field4592;
		float var10 = var1.field4589 * var1.field4589;
		float var11 = var1.field4593 * var1.field4589;
		float var12 = var1.field4593 * var1.field4593;
		this.field4563[0] = var7 + var3 - var12 - var10;
		this.field4563[1] = var6 + var8 + var6 + var8;
		this.field4563[2] = var9 - var5 - var5 + var9;
		this.field4563[4] = var8 - var6 - var6 + var8;
		this.field4563[5] = var3 + var10 - var7 - var12;
		this.field4563[6] = var4 + var11 + var4 + var11;
		this.field4563[8] = var5 + var9 + var9 + var5;
		this.field4563[9] = var11 - var4 - var4 + var11;
		this.field4563[10] = var12 + var3 - var10 - var7;
	}

	void method7428(class414 var1) {
		this.field4563[0] = var1.field4583;
		this.field4563[1] = var1.field4577;
		this.field4563[2] = var1.field4578;
		this.field4563[3] = 0.0F;
		this.field4563[4] = var1.field4576;
		this.field4563[5] = var1.field4580;
		this.field4563[6] = var1.field4581;
		this.field4563[7] = 0.0F;
		this.field4563[8] = var1.field4582;
		this.field4563[9] = var1.field4579;
		this.field4563[10] = var1.field4584;
		this.field4563[11] = 0.0F;
		this.field4563[12] = var1.field4585;
		this.field4563[13] = var1.field4586;
		this.field4563[14] = var1.field4587;
		this.field4563[15] = 1.0F;
	}

	float method7446() {
		return this.field4563[12] * this.field4563[6] * this.field4563[3] * this.field4563[9] + (this.field4563[5] * this.field4563[2] * this.field4563[11] * this.field4563[12] + (this.field4563[15] * this.field4563[9] * this.field4563[2] * this.field4563[4] + this.field4563[8] * this.field4563[6] * this.field4563[1] * this.field4563[15] + this.field4563[15] * this.field4563[10] * this.field4563[5] * this.field4563[0] - this.field4563[11] * this.field4563[5] * this.field4563[0] * this.field4563[14] - this.field4563[15] * this.field4563[6] * this.field4563[0] * this.field4563[9] + this.field4563[13] * this.field4563[11] * this.field4563[6] * this.field4563[0] + this.field4563[14] * this.field4563[9] * this.field4563[7] * this.field4563[0] - this.field4563[10] * this.field4563[0] * this.field4563[7] * this.field4563[13] - this.field4563[15] * this.field4563[1] * this.field4563[4] * this.field4563[10] + this.field4563[11] * this.field4563[1] * this.field4563[4] * this.field4563[14] - this.field4563[6] * this.field4563[1] * this.field4563[11] * this.field4563[12] - this.field4563[14] * this.field4563[7] * this.field4563[1] * this.field4563[8] + this.field4563[12] * this.field4563[10] * this.field4563[1] * this.field4563[7] - this.field4563[13] * this.field4563[4] * this.field4563[2] * this.field4563[11] - this.field4563[15] * this.field4563[8] * this.field4563[5] * this.field4563[2]) + this.field4563[2] * this.field4563[7] * this.field4563[8] * this.field4563[13] - this.field4563[12] * this.field4563[9] * this.field4563[7] * this.field4563[2] - this.field4563[14] * this.field4563[4] * this.field4563[3] * this.field4563[9] + this.field4563[13] * this.field4563[10] * this.field4563[4] * this.field4563[3] + this.field4563[14] * this.field4563[8] * this.field4563[5] * this.field4563[3] - this.field4563[12] * this.field4563[3] * this.field4563[5] * this.field4563[10] - this.field4563[13] * this.field4563[6] * this.field4563[3] * this.field4563[8]);
	}

	public void method7452() {
		float var2 = 1.0F / this.method7446();
		float var3 = (this.field4563[10] * this.field4563[5] * this.field4563[15] - this.field4563[14] * this.field4563[11] * this.field4563[5] - this.field4563[9] * this.field4563[6] * this.field4563[15] + this.field4563[13] * this.field4563[11] * this.field4563[6] + this.field4563[7] * this.field4563[9] * this.field4563[14] - this.field4563[10] * this.field4563[7] * this.field4563[13]) * var2;
		float var4 = var2 * (this.field4563[15] * this.field4563[10] * -this.field4563[1] + this.field4563[14] * this.field4563[11] * this.field4563[1] + this.field4563[15] * this.field4563[2] * this.field4563[9] - this.field4563[13] * this.field4563[2] * this.field4563[11] - this.field4563[9] * this.field4563[3] * this.field4563[14] + this.field4563[10] * this.field4563[3] * this.field4563[13]);
		float var5 = var2 * (this.field4563[3] * this.field4563[5] * this.field4563[14] + this.field4563[15] * this.field4563[6] * this.field4563[1] - this.field4563[7] * this.field4563[1] * this.field4563[14] - this.field4563[15] * this.field4563[2] * this.field4563[5] + this.field4563[2] * this.field4563[7] * this.field4563[13] - this.field4563[6] * this.field4563[3] * this.field4563[13]);
		float var6 = (this.field4563[5] * this.field4563[2] * this.field4563[11] + this.field4563[11] * this.field4563[6] * -this.field4563[1] + this.field4563[10] * this.field4563[1] * this.field4563[7] - this.field4563[7] * this.field4563[2] * this.field4563[9] - this.field4563[10] * this.field4563[3] * this.field4563[5] + this.field4563[6] * this.field4563[3] * this.field4563[9]) * var2;
		float var7 = (this.field4563[15] * this.field4563[6] * this.field4563[8] + this.field4563[11] * this.field4563[4] * this.field4563[14] + -this.field4563[4] * this.field4563[10] * this.field4563[15] - this.field4563[6] * this.field4563[11] * this.field4563[12] - this.field4563[14] * this.field4563[7] * this.field4563[8] + this.field4563[10] * this.field4563[7] * this.field4563[12]) * var2;
		float var8 = var2 * (this.field4563[15] * this.field4563[0] * this.field4563[10] - this.field4563[0] * this.field4563[11] * this.field4563[14] - this.field4563[15] * this.field4563[2] * this.field4563[8] + this.field4563[2] * this.field4563[11] * this.field4563[12] + this.field4563[14] * this.field4563[8] * this.field4563[3] - this.field4563[12] * this.field4563[10] * this.field4563[3]);
		float var9 = var2 * (this.field4563[15] * -this.field4563[0] * this.field4563[6] + this.field4563[14] * this.field4563[0] * this.field4563[7] + this.field4563[4] * this.field4563[2] * this.field4563[15] - this.field4563[2] * this.field4563[7] * this.field4563[12] - this.field4563[14] * this.field4563[3] * this.field4563[4] + this.field4563[3] * this.field4563[6] * this.field4563[12]);
		float var10 = var2 * (this.field4563[3] * this.field4563[4] * this.field4563[10] + this.field4563[6] * this.field4563[0] * this.field4563[11] - this.field4563[0] * this.field4563[7] * this.field4563[10] - this.field4563[11] * this.field4563[4] * this.field4563[2] + this.field4563[2] * this.field4563[7] * this.field4563[8] - this.field4563[3] * this.field4563[6] * this.field4563[8]);
		float var11 = var2 * (this.field4563[13] * this.field4563[8] * this.field4563[7] + this.field4563[12] * this.field4563[5] * this.field4563[11] + (this.field4563[4] * this.field4563[9] * this.field4563[15] - this.field4563[11] * this.field4563[4] * this.field4563[13] - this.field4563[8] * this.field4563[5] * this.field4563[15]) - this.field4563[12] * this.field4563[9] * this.field4563[7]);
		float var12 = (this.field4563[12] * this.field4563[3] * this.field4563[9] + (this.field4563[9] * -this.field4563[0] * this.field4563[15] + this.field4563[0] * this.field4563[11] * this.field4563[13] + this.field4563[15] * this.field4563[1] * this.field4563[8] - this.field4563[1] * this.field4563[11] * this.field4563[12] - this.field4563[13] * this.field4563[3] * this.field4563[8])) * var2;
		float var13 = var2 * (this.field4563[4] * this.field4563[3] * this.field4563[13] + this.field4563[7] * this.field4563[1] * this.field4563[12] + (this.field4563[5] * this.field4563[0] * this.field4563[15] - this.field4563[13] * this.field4563[0] * this.field4563[7] - this.field4563[1] * this.field4563[4] * this.field4563[15]) - this.field4563[3] * this.field4563[5] * this.field4563[12]);
		float var14 = var2 * (this.field4563[8] * this.field4563[5] * this.field4563[3] + (this.field4563[4] * this.field4563[1] * this.field4563[11] + this.field4563[11] * -this.field4563[0] * this.field4563[5] + this.field4563[9] * this.field4563[0] * this.field4563[7] - this.field4563[8] * this.field4563[7] * this.field4563[1] - this.field4563[9] * this.field4563[3] * this.field4563[4]));
		float var15 = var2 * (this.field4563[5] * this.field4563[8] * this.field4563[14] + this.field4563[4] * this.field4563[10] * this.field4563[13] + this.field4563[14] * this.field4563[9] * -this.field4563[4] - this.field4563[12] * this.field4563[5] * this.field4563[10] - this.field4563[13] * this.field4563[8] * this.field4563[6] + this.field4563[12] * this.field4563[6] * this.field4563[9]);
		float var16 = (this.field4563[2] * this.field4563[8] * this.field4563[13] + this.field4563[0] * this.field4563[9] * this.field4563[14] - this.field4563[10] * this.field4563[0] * this.field4563[13] - this.field4563[14] * this.field4563[1] * this.field4563[8] + this.field4563[12] * this.field4563[1] * this.field4563[10] - this.field4563[12] * this.field4563[2] * this.field4563[9]) * var2;
		float var17 = (this.field4563[4] * this.field4563[1] * this.field4563[14] + this.field4563[6] * this.field4563[0] * this.field4563[13] + -this.field4563[0] * this.field4563[5] * this.field4563[14] - this.field4563[12] * this.field4563[1] * this.field4563[6] - this.field4563[2] * this.field4563[4] * this.field4563[13] + this.field4563[12] * this.field4563[5] * this.field4563[2]) * var2;
		float var18 = var2 * (this.field4563[9] * this.field4563[2] * this.field4563[4] + this.field4563[10] * this.field4563[5] * this.field4563[0] - this.field4563[6] * this.field4563[0] * this.field4563[9] - this.field4563[1] * this.field4563[4] * this.field4563[10] + this.field4563[1] * this.field4563[6] * this.field4563[8] - this.field4563[8] * this.field4563[2] * this.field4563[5]);
		this.field4563[0] = var3;
		this.field4563[1] = var4;
		this.field4563[2] = var5;
		this.field4563[3] = var6;
		this.field4563[4] = var7;
		this.field4563[5] = var8;
		this.field4563[6] = var9;
		this.field4563[7] = var10;
		this.field4563[8] = var11;
		this.field4563[9] = var12;
		this.field4563[10] = var13;
		this.field4563[11] = var14;
		this.field4563[12] = var15;
		this.field4563[13] = var16;
		this.field4563[14] = var17;
		this.field4563[15] = var18;
	}

	public String toString() {
		StringBuilder var1 = new StringBuilder();
		this.method7419();
		this.method7418();

		for (int var2 = 0; var2 < 4; ++var2) {
			for (int var3 = 0; var3 < 4; ++var3) {
				if (var3 > 0) {
					var1.append("\t");
				}

				float var4 = this.field4563[var3 + var2 * 4];
				if (Math.sqrt((double)(var4 * var4)) < 9.999999747378752E-5D) {
					var4 = 0.0F;
				}

				var1.append(var4);
			}

			var1.append("\n");
		}

		return var1.toString();
	}

	public int hashCode() {
		boolean var1 = true;
		byte var2 = 1;
		int var3 = var2 * 31 + Arrays.hashCode(this.field4563);
		return var3;
	}

	public boolean equals(Object var1) {
		if (!(var1 instanceof class412)) {
			return false;
		} else {
			class412 var2 = (class412)var1;

			for (int var3 = 0; var3 < 16; ++var3) {
				if (var2.field4563[var3] != this.field4563[var3]) {
					return false;
				}
			}

			return true;
		}
	}

	public float[] method7432() {
		float[] var2 = new float[3];
		class402 var3 = new class402(this.field4563[0], this.field4563[1], this.field4563[2]);
		class402 var4 = new class402(this.field4563[4], this.field4563[5], this.field4563[6]);
		class402 var5 = new class402(this.field4563[8], this.field4563[9], this.field4563[10]);
		var2[0] = var3.method7275();
		var2[1] = var4.method7275();
		var2[2] = var5.method7275();
		return var2;
	}
}
