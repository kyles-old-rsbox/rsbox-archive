public class class192 extends class437 {
   public static class319 field2034;
   static class284 field2028 = new class284(64);
   public char field2030;
   public char field2037;
   public int field2029;
   public int field2033;
   public int[] field2035;
   public int[] field2036;
   public String field2031;
   public String[] field2027;

   class192() {
      this.field2031 = class338.field3899;
      this.field2033 = 0;
   }

   void method3538(class460 var1) {
      while(true) {
         int var3 = var1.method8134();
         if (0 == var3) {
            return;
         }

         this.method3539(var1, var3);
      }
   }

   void method3539(class460 var1, int var2) {
      if (1 == var2) {
         this.field2037 = (char)var1.method8134();
      } else if (2 == var2) {
         this.field2030 = (char)var1.method8134();
      } else if (3 == var2) {
         this.field2031 = var1.method8124();
      } else if (4 == var2) {
         this.field2029 = var1.method8119();
      } else {
         int var4;
         if (5 == var2) {
            this.field2033 = var1.method8115();
            this.field2036 = new int[this.field2033];
            this.field2027 = new String[this.field2033];

            for(var4 = 0; var4 < this.field2033; ++var4) {
               this.field2036[var4] = var1.method8119();
               this.field2027[var4] = var1.method8124();
            }
         } else if (6 == var2) {
            this.field2033 = var1.method8115();
            this.field2036 = new int[this.field2033];
            this.field2035 = new int[this.field2033];

            for(var4 = 0; var4 < this.field2033; ++var4) {
               this.field2036[var4] = var1.method8119();
               this.field2035[var4] = var1.method8119();
            }
         }
      }

   }

   public int method3548() {
      return this.field2033;
   }
}
