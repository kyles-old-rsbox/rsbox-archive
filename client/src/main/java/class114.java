public class class114 extends class393 {
   static class376 field1127;
   final boolean field1123;

   public class114(boolean var1) {
      this.field1123 = var1;
   }

   int method2214(class396 var1, class396 var2) {
      if (var1.field4491 != var2.field4491) {
         return this.field1123 ? var1.field4491 - var2.field4491 : var2.field4491 - var1.field4491;
      } else {
         return this.method7155(var1, var2);
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method2214((class396)var1, (class396)var2);
   }

   static int method2219(int var0, class78 var1, boolean var2) {
      int var4;
      if (5504 == var0) {
         class387.field4452 -= 2;
         var4 = class57.field404[class387.field4452];
         int var5 = class57.field404[1 + class387.field4452];
         if (!client.field1900) {
            client.field1761 = var4;
            client.field1672 = var5;
         }

         return 1;
      } else if (5505 == var0) {
         class57.field404[++class387.field4452 - 1] = client.field1761;
         return 1;
      } else if (5506 == var0) {
         class57.field404[++class387.field4452 - 1] = client.field1672;
         return 1;
      } else if (5530 == var0) {
         var4 = class57.field404[--class387.field4452];
         if (var4 < 0) {
            var4 = 0;
         }

         client.field1723 = var4;
         return 1;
      } else if (var0 == 5531) {
         class57.field404[++class387.field4452 - 1] = client.field1723;
         return 1;
      } else {
         return 2;
      }
   }

   public static boolean method2218() {
      return client.field1750 >= 2;
   }
}
