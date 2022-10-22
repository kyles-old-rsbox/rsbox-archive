public class class275 {
   class275() throws Throwable {
      throw new Error();
   }

   static final void method5224(int var0, int var1, int var2, int var3, class473 var4, class298 var5) {
      if (null != var4) {
         int var7 = client.field1672 & 2047;
         int var8 = var3 * var3 + var2 * var2;
         if (var8 <= 6400) {
            int var9 = class221.field2644[var7];
            int var10 = class221.field2645[var7];
            int var11 = var10 * var2 + var3 * var9 >> 16;
            int var12 = var10 * var3 - var2 * var9 >> 16;
            if (var8 > 2500) {
               var4.method8494(var11 + var5.field3435 / 2 - var4.field4956 / 2, var5.field3433 / 2 - var12 - var4.field4957 / 2, var0, var1, var5.field3435, var5.field3433, var5.field3432, var5.field3434);
            } else {
               var4.method8519(var11 + var5.field3435 / 2 + var0 - var4.field4956 / 2, var1 + var5.field3433 / 2 - var12 - var4.field4957 / 2);
            }

         }
      }
   }
}
