public class class47 implements Runnable {
   static int field341;
   volatile class28[] field339 = new class28[2];

   class47() {
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            class28 var2 = this.field339[var1];
            if (var2 != null) {
               var2.method405();
            }
         }
      } catch (Exception var3) {
         class422.method7800((String)null, var3);
      }

   }

   static final boolean method962(int var0, int var1) {
      class195 var3 = class89.method1866(var0);
      if (var1 == 11) {
         var1 = 10;
      }

      if (var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var3.method3619(var1);
   }
}
