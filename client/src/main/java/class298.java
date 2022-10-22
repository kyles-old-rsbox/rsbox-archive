public class class298 extends class437 {
   public static class319 field3438;
   static String field3437;
   public final int field3433;
   public final int field3435;
   public final int[] field3432;
   public final int[] field3434;

   class298(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field3435 = var1;
      this.field3433 = var2;
      this.field3434 = var3;
      this.field3432 = var4;
   }

   public boolean method5829(int var1, int var2) {
      if (var2 >= 0 && var2 < this.field3432.length) {
         int var4 = this.field3432[var2];
         if (var1 >= var4 && var1 <= this.field3434[var2] + var4) {
            return true;
         }
      }

      return false;
   }
}
