public class class323 {
   static class473 field3774;
   static int field3766;

   class323() throws Throwable {
      throw new Error();
   }

   public static void method6192() {
      if (null != class324.field3787) {
         class324.field3787.method7252();
      }

   }

   static int method6194(int var0, class78 var1, boolean var2) {
      int var4 = -1;
      class300 var5;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = class57.field404[--class387.field4452];
         var5 = class282.method5426(var4);
      } else {
         var5 = var2 ? class138.field1284 : class153.field1414;
      }

      if (var0 == 1000) {
         class387.field4452 -= 4;
         var5.field3469 = class57.field404[class387.field4452];
         var5.field3470 = class57.field404[class387.field4452 + 1];
         var5.field3465 = class57.field404[class387.field4452 + 2];
         var5.field3466 = class57.field404[class387.field4452 + 3];
         class136.method2438(var5);
         class133.field1257.method2893(var5);
         if (var4 != -1 && 0 == var5.field3462) {
            class26.method349(class300.field3593[var4 >> 16], var5, false);
         }

         return 1;
      } else if (var0 == 1001) {
         class387.field4452 -= 4;
         var5.field3486 = class57.field404[class387.field4452];
         var5.field3472 = class57.field404[1 + class387.field4452];
         var5.field3508 = class57.field404[2 + class387.field4452];
         var5.field3468 = class57.field404[3 + class387.field4452];
         class136.method2438(var5);
         class133.field1257.method2893(var5);
         if (-1 != var4 && 0 == var5.field3462) {
            class26.method349(class300.field3593[var4 >> 16], var5, false);
         }

         return 1;
      } else if (1003 == var0) {
         boolean var6 = class57.field404[--class387.field4452] == 1;
         if (var6 != var5.field3480) {
            var5.field3480 = var6;
            class136.method2438(var5);
         }

         return 1;
      } else if (var0 == 1005) {
         var5.field3539 = class57.field404[--class387.field4452] == 1;
         return 1;
      } else if (1006 == var0) {
         var5.field3449 = class57.field404[--class387.field4452] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   static String method6195(class300 var0) {
      if (class290.method2693(class190.method3528(var0)) == 0) {
         return null;
      } else {
         return var0.field3515 != null && var0.field3515.trim().length() != 0 ? var0.field3515 : null;
      }
   }
}
