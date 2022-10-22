public class class193 extends class437 {
   static class284 field2040 = new class284(64);
   boolean field2039 = true;
   char field2042;
   public int field2043;
   public String field2041;

   class193() {
   }

   public static void method5223(class319 var0) {
      class19.field97 = var0;
   }

   void method3565() {
   }

   void method3553(class460 var1) {
      while(true) {
         int var3 = var1.method8134();
         if (0 == var3) {
            return;
         }

         this.method3564(var1, var3);
      }
   }

   void method3564(class460 var1, int var2) {
      if (1 == var2) {
         byte var5 = var1.method8280();
         int var6 = var5 & 255;
         if (var6 == 0) {
            throw new IllegalArgumentException("" + Integer.toString(var6, 16));
         }

         if (var6 >= 128 && var6 < 160) {
            char var7 = class349.field4270[var6 - 128];
            if (0 == var7) {
               var7 = '?';
            }

            var6 = var7;
         }

         char var4 = (char)var6;
         this.field2042 = var4;
      } else if (2 == var2) {
         this.field2043 = var1.method8119();
      } else if (var2 == 4) {
         this.field2039 = false;
      } else if (5 == var2) {
         this.field2041 = var1.method8124();
      }

   }

   public boolean method3567() {
      return this.field2042 == 's';
   }

   public static void method6189() {
      field2040.method5437();
   }
}
