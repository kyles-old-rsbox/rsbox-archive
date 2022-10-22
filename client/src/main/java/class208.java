public final class class208 {
   class212 field2368;
   class212 field2369;
   class212 field2371;
   int field2370;
   int field2372;
   int field2373;
   int field2375;
   long field2374;

   class208() {
   }

   static int method3984(int var0, int var1) {
      long var3 = (long)((var0 << 16) + var1);
      return class116.field1137 != null && var3 == class116.field1137.field4681 ? class431.field4704.field4878 * 99 / (class431.field4704.field4881.length - class116.field1137.field3868) + 1 : 0;
   }

   static String method3985(String var0) {
      class333[] var2 = class333.method5480();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class333 var4 = var2[var3];
         if (var4.field3856 != -1 && var0.startsWith(class96.method5151(var4.field3856))) {
            var0 = var0.substring(6 + Integer.toString(var4.field3856).length());
            break;
         }
      }

      return var0;
   }
}
