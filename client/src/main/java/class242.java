public class class242 {
   public static final class242 field2832 = new class242("compositetexture");
   public static final class242 field2833 = new class242("compositemap");
   public static final class242 field2836 = new class242("labels");
   public static final class242 field2838 = new class242("details");
   static class337 field2835;
   static final class242 field2834 = new class242("area");
   public final String field2837;

   class242(String var1) {
      this.field2837 = var1;
   }

   public static boolean method4733(int var0) {
      return 0 != (var0 >> 22 & 1);
   }

   static final void method4731(class453 var0, int var1) {
      int var3 = var0.field4878;
      class102.field1007 = 0;
      class172.method2733(var0);
      class9.method56(var0);
      if (var0.field4878 - var3 != var1) {
         throw new RuntimeException(var0.field4878 - var3 + " " + var1);
      }
   }

   static final void method4732(int var0, int var1, int var2, int var3) {
      for(int var5 = var1; var5 <= var3 + var1; ++var5) {
         for(int var6 = var0; var6 <= var0 + var2; ++var6) {
            if (var6 >= 0 && var6 < 104 && var5 >= 0 && var5 < 104) {
               class30.field160[0][var6][var5] = 127;
               if (var6 == var0 && var6 > 0) {
                  class82.field719[0][var6][var5] = class82.field719[0][var6 - 1][var5];
               }

               if (var2 + var0 == var6 && var6 < 103) {
                  class82.field719[0][var6][var5] = class82.field719[0][var6 + 1][var5];
               }

               if (var5 == var1 && var5 > 0) {
                  class82.field719[0][var6][var5] = class82.field719[0][var6][var5 - 1];
               }

               if (var5 == var1 + var3 && var5 < 103) {
                  class82.field719[0][var6][var5] = class82.field719[0][var6][var5 + 1];
               }
            }
         }
      }

   }
}
