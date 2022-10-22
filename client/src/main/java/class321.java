public class class321 {
   public static int[] field3756 = new int[99];
   public static final boolean[] field3754 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field3756[var1] = var0 / 4;
      }

   }

   class321() throws Throwable {
      throw new Error();
   }
}
