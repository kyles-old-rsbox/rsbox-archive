public final class class227 {
   static boolean field2714;
   static class392 field2721;
   static class488 field2723;
   int field2707;
   int field2708;
   int field2709;
   int field2710;
   int field2712;
   int field2713;
   int field2715;
   int field2716;
   int field2717;
   int field2718;
   int field2720 = 0;
   int field2722;
   public class212 field2711;
   public long field2719 = 0L;

   class227() {
   }

   static final void method4512(class300 var0, int var1, byte[] var2, byte[] var3) {
      if (var0.field3541 == null) {
         if (null == var2) {
            return;
         }

         var0.field3541 = new byte[11][];
         var0.field3542 = new byte[11][];
         var0.field3590 = new int[11];
         var0.field3544 = new int[11];
      }

      var0.field3541[var1] = var2;
      if (null != var2) {
         var0.field3540 = true;
      } else {
         var0.field3540 = false;

         for(int var5 = 0; var5 < var0.field3541.length; ++var5) {
            if (null != var0.field3541[var5]) {
               var0.field3540 = true;
               break;
            }
         }
      }

      var0.field3542[var1] = var3;
   }

   static int method4511(int var0, class78 var1, boolean var2) {
      class300 var4 = var2 ? class138.field1284 : class153.field1414;
      if (1500 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3473;
         return 1;
      } else if (var0 == 1501) {
         class57.field404[++class387.field4452 - 1] = var4.field3551;
         return 1;
      } else if (1502 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3448;
         return 1;
      } else if (1503 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3476;
         return 1;
      } else if (var0 == 1504) {
         class57.field404[++class387.field4452 - 1] = var4.field3480 ? 1 : 0;
         return 1;
      } else if (1505 == var0) {
         class57.field404[++class387.field4452 - 1] = var4.field3596;
         return 1;
      } else {
         return 2;
      }
   }
}
