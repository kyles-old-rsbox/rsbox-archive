public class class245 {
   public class295 field2861;
   public class295 field2862;
   public int field2860;

   public class245(int var1, class295 var2, class295 var3) {
      this.field2860 = var1;
      this.field2861 = var2;
      this.field2862 = var3;
   }

   static void method4890(Float var0, Float var1) {
      if (var0 + class127.field1227 < 1.3333334F) {
         float var3 = var0 - 2.0F;
         float var4 = var0 - 1.0F;
         float var5 = (float)Math.sqrt((double)(var3 * var3 - var4 * 4.0F * var4));
         float var6 = 0.5F * (var5 + -var3);
         if (var1 + class127.field1227 > var6) {
            var1 = var6 - class127.field1227;
         } else {
            var6 = 0.5F * (-var3 - var5);
            if (var1 < var6 + class127.field1227) {
               var1 = class127.field1227 + var6;
            }
         }
      } else {
         var0 = 1.3333334F - class127.field1227;
         var1 = 0.33333334F - class127.field1227;
      }

   }
}
