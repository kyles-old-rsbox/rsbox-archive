public class class231 {
   static class181 field2748;
   int field2749;
   int field2750;
   int field2751;
   int field2752;

   class231() {
   }

   class231(class231 var1) {
      this.field2752 = var1.field2752;
      this.field2749 = var1.field2749;
      this.field2750 = var1.field2750;
      this.field2751 = var1.field2751;
   }

   static final byte[] method4537(byte[] var0) {
      class460 var2 = new class460(var0);
      int var3 = var2.method8134();
      int var4 = var2.method8119();
      if (var4 < 0 || class319.field3744 != 0 && var4 > class319.field3744) {
         throw new RuntimeException();
      } else if (0 == var3) {
         byte[] var7 = new byte[var4];
         var2.method8326(var7, 0, var4);
         return var7;
      } else {
         int var5 = var2.method8119();
         if (var5 >= 0 && (class319.field3744 == 0 || var5 <= class319.field3744)) {
            byte[] var6 = new byte[var5];
            if (1 == var3) {
               class455.method8042(var6, var5, var0, var4, 9);
            } else {
               class319.field3745.method8728(var2, var6);
            }

            return var6;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
