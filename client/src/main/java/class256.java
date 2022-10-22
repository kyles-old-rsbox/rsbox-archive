public class class256 {
   static class407 field2949;
   static final class256 field2948 = new class256(1);
   static final class256 field2950 = new class256(0);
   final int field2947;

   class256(int var1) {
      this.field2947 = var1;
   }

   static void method5126(class300[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var6 = 0; var6 < var0.length; ++var6) {
         class300 var7 = var0[var6];
         if (var7 != null && var7.field3596 == var1) {
            class235.method4586(var7, var2, var3, var4);
            class327.method6234(var7, var2, var3);
            if (var7.field3481 > var7.field3483 - var7.field3448) {
               var7.field3481 = var7.field3483 - var7.field3448;
            }

            if (var7.field3481 < 0) {
               var7.field3481 = 0;
            }

            if (var7.field3482 > var7.field3492 - var7.field3476) {
               var7.field3482 = var7.field3492 - var7.field3476;
            }

            if (var7.field3482 < 0) {
               var7.field3482 = 0;
            }

            if (var7.field3462 == 0) {
               class26.method349(var0, var7, var4);
            }
         }
      }

   }
}
