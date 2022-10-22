public class class199 extends class437 {
   public static class284 field2183 = new class284(64);
   public static class319 field2188;
   public boolean field2186 = true;
   public int field2182;
   public int field2184 = 0;
   public int field2185 = -1;
   public int field2187 = -1;
   public int field2190;
   public int field2191;
   public int field2192;
   public int field2193;
   public int field2194;

   public static void method4997(class319 var0) {
      field2188 = var0;
   }

   public void method3716() {
      if (this.field2187 != -1) {
         this.method3715(this.field2187);
         this.field2191 = this.field2194;
         this.field2192 = this.field2182;
         this.field2193 = this.field2190;
      }

      this.method3715(this.field2184);
   }

   public void method3717(class460 var1, int var2) {
      while(true) {
         int var4 = var1.method8134();
         if (var4 == 0) {
            return;
         }

         this.method3719(var1, var4, var2);
      }
   }

   void method3719(class460 var1, int var2, int var3) {
      if (1 == var2) {
         this.field2184 = var1.method8305();
      } else if (var2 == 2) {
         this.field2185 = var1.method8134();
      } else if (5 == var2) {
         this.field2186 = false;
      } else if (var2 == 7) {
         this.field2187 = var1.method8305();
      } else if (var2 == 8) {
      }

   }

   void method3715(int var1) {
      double var3 = (double)(var1 >> 16 & 255) / 256.0D;
      double var5 = (double)(var1 >> 8 & 255) / 256.0D;
      double var7 = (double)(var1 & 255) / 256.0D;
      double var9 = var3;
      if (var5 < var3) {
         var9 = var5;
      }

      if (var7 < var9) {
         var9 = var7;
      }

      double var11 = var3;
      if (var5 > var3) {
         var11 = var5;
      }

      if (var7 > var11) {
         var11 = var7;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = (var11 + var9) / 2.0D;
      if (var11 != var9) {
         if (var17 < 0.5D) {
            var15 = (var11 - var9) / (var11 + var9);
         }

         if (var17 >= 0.5D) {
            var15 = (var11 - var9) / (2.0D - var11 - var9);
         }

         if (var11 == var3) {
            var13 = (var5 - var7) / (var11 - var9);
         } else if (var11 == var5) {
            var13 = 2.0D + (var7 - var3) / (var11 - var9);
         } else if (var11 == var7) {
            var13 = (var3 - var5) / (var11 - var9) + 4.0D;
         }
      }

      var13 /= 6.0D;
      this.field2194 = (int)(var13 * 256.0D);
      this.field2182 = (int)(var15 * 256.0D);
      this.field2190 = (int)(256.0D * var17);
      if (this.field2182 < 0) {
         this.field2182 = 0;
      } else if (this.field2182 > 255) {
         this.field2182 = 255;
      }

      if (this.field2190 < 0) {
         this.field2190 = 0;
      } else if (this.field2190 > 255) {
         this.field2190 = 255;
      }

   }

   static int method3733(char var0, class353 var1) {
      int var3 = var0 << 4;
      if (Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var3 = (var0 << 4) + 1;
      }

      if (241 == var0 && class353.field4292 == var1) {
         var3 = 1762;
      }

      return var3;
   }

   public static void method3732(class460 var0, int var1) {
      if (class163.field1498 != null) {
         try {
            class163.field1498.method8386(0L);
            class163.field1498.method8391(var0.field4881, var1, 24);
         } catch (Exception var4) {
         }
      }

   }
}
