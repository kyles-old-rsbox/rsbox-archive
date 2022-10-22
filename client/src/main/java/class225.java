public class class225 implements class248 {
   int field2685;
   int field2686;
   int field2687;
   int field2688;
   int field2689;
   int field2691;
   int field2692;
   int field2693;
   int field2694;
   int field2696;

   class225() {
   }

   public static class332 method4507(int var0) {
      class332[] var2 = new class332[]{class332.field3833, class332.field3834, class332.field3835, class332.field3837};
      class332[] var3 = var2;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         class332 var5 = var3[var4];
         if (var5.field3832 == var0) {
            return var5;
         }
      }

      return null;
   }

   public void method4986(class254 var1) {
      if (var1.field2936 > this.field2688) {
         var1.field2936 = this.field2688;
      }

      if (var1.field2930 < this.field2693) {
         var1.field2930 = this.field2693;
      }

      if (var1.field2937 > this.field2692) {
         var1.field2937 = this.field2692;
      }

      if (var1.field2939 < this.field2694) {
         var1.field2939 = this.field2694;
      }

   }

   public boolean method4976(int var1, int var2, int var3) {
      if (var1 >= this.field2691 && var1 < this.field2686 + this.field2691) {
         return var2 >> 6 >= this.field2687 && var2 >> 6 <= this.field2689 && var3 >> 6 >= this.field2696 && var3 >> 6 <= this.field2685;
      } else {
         return false;
      }
   }

   public boolean method4963(int var1, int var2) {
      return var1 >> 6 >= this.field2688 && var1 >> 6 <= this.field2693 && var2 >> 6 >= this.field2692 && var2 >> 6 <= this.field2694;
   }

   public int[] method4979(int var1, int var2, int var3) {
      if (!this.method4976(var1, var2, var3)) {
         return null;
      } else {
         int[] var5 = new int[]{var2 + (this.field2688 * 64 - this.field2687 * 64), this.field2692 * 64 - this.field2696 * 64 + var3};
         return var5;
      }
   }

   public class295 method4966(int var1, int var2) {
      if (!this.method4963(var1, var2)) {
         return null;
      } else {
         int var4 = this.field2687 * 64 - this.field2688 * 64 + var1;
         int var5 = this.field2696 * 64 - this.field2692 * 64 + var2;
         return new class295(this.field2691, var4, var5);
      }
   }

   public void method4967(class460 var1) {
      this.field2691 = var1.method8134();
      this.field2686 = var1.method8134();
      this.field2687 = var1.method8115();
      this.field2696 = var1.method8115();
      this.field2689 = var1.method8115();
      this.field2685 = var1.method8115();
      this.field2688 = var1.method8115();
      this.field2692 = var1.method8115();
      this.field2693 = var1.method8115();
      this.field2694 = var1.method8115();
      this.method4485();
   }

   void method4485() {
   }
}
