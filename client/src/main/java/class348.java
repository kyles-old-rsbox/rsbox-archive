import java.util.HashMap;

public class class348 {
   class407 field4263 = new class407(0, 0);
   int field4266 = 0;
   int[] field4264 = new int[2048];
   int[] field4265 = new int[2048];
   final HashMap field4262 = new HashMap();

   public class348() {
      class110.method2130();
   }

   void method6417(int var1) {
      int var3 = var1 * 2 + 1;
      double var5 = (double)((float)var1 / 3.0F);
      int var7 = 1 + var1 * 2;
      double[] var8 = new double[var7];
      int var9 = -var1;

      for(int var10 = 0; var9 <= var1; ++var10) {
         double var17 = (double)(var9 - 0) / var5;
         double var15 = Math.exp(var17 * -var17 / 2.0D) / Math.sqrt(6.283185307179586D);
         double var13 = var15 / var5;
         var8[var10] = var13;
         ++var9;
      }

      double[] var19 = var8;
      double var20 = var8[var1] * var8[var1];
      int[] var21 = new int[var3 * var3];
      boolean var11 = false;

      for(int var12 = 0; var12 < var3; ++var12) {
         for(int var23 = 0; var23 < var3; ++var23) {
            int var14 = var21[var12 * var3 + var23] = (int)(var19[var12] * var19[var23] / var20 * 256.0D);
            if (!var11 && var14 > 0) {
               var11 = true;
            }
         }
      }

      class473 var22 = new class473(var21, var3, var3);
      this.field4262.put(var1, var22);
   }

   class473 method6422(int var1) {
      if (!this.field4262.containsKey(var1)) {
         this.method6417(var1);
      }

      return (class473)this.field4262.get(var1);
   }

   public final void method6419(int var1, int var2) {
      if (this.field4266 < this.field4264.length) {
         this.field4264[this.field4266] = var1;
         this.field4265[this.field4266] = var2;
         ++this.field4266;
      }
   }

   public final void method6420() {
      this.field4266 = 0;
   }

   public final void method6421(int var1, int var2, class473 var3, float var4) {
      int var6 = (int)(18.0F * var4);
      class473 var7 = this.method6422(var6);
      int var8 = 2 * var6 + 1;
      class407 var9 = new class407(0, 0, var3.field4959, var3.field4951);
      class407 var10 = new class407(0, 0);
      this.field4263.method7367(var8, var8);
      System.nanoTime();

      int var11;
      int var12;
      int var13;
      for(var11 = 0; var11 < this.field4266; ++var11) {
         var12 = this.field4264[var11];
         var13 = this.field4265[var11];
         int var14 = (int)((float)(var12 - var1) * var4) - var6;
         int var15 = (int)((float)var3.field4951 - (float)(var13 - var2) * var4) - var6;
         this.field4263.method7366(var14, var15);
         this.field4263.method7369(var9, var10);
         this.method6429(var7, var3, var10);
      }

      System.nanoTime();
      System.nanoTime();

      for(var11 = 0; var11 < var3.field4952.length; ++var11) {
         if (var3.field4952[var11] == 0) {
            var3.field4952[var11] = -16777216;
         } else {
            var12 = (64 + var3.field4952[var11] - 1) / 256;
            if (var12 <= 0) {
               var3.field4952[var11] = -16777216;
            } else {
               if (var12 > class177.field1588.length) {
                  var12 = class177.field1588.length;
               }

               var13 = class177.field1588[var12 - 1];
               var3.field4952[var11] = -16777216 | var13;
            }
         }
      }

      System.nanoTime();
   }

   void method6429(class473 var1, class473 var2, class407 var3) {
      if (var3.field4531 != 0 && 0 != var3.field4528) {
         int var5 = 0;
         int var6 = 0;
         if (var3.field4529 == 0) {
            var5 = var1.field4959 - var3.field4531;
         }

         if (0 == var3.field4530) {
            var6 = var1.field4951 - var3.field4528;
         }

         int var7 = var6 * var1.field4959 + var5;
         int var8 = var3.field4529 + var3.field4530 * var2.field4959;

         for(int var9 = 0; var9 < var3.field4528; ++var9) {
            for(int var10 = 0; var10 < var3.field4531; ++var10) {
               int[] var10000 = var2.field4952;
               int var10001 = var8++;
               var10000[var10001] += var1.field4952[var7++];
            }

            var7 += var1.field4959 - var3.field4531;
            var8 += var2.field4959 - var3.field4531;
         }

      }
   }

   public static boolean method6438(char var0) {
      if (var0 >= ' ' && var0 <= '~') {
         return true;
      } else if (var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         return var0 == 8364 || 338 == var0 || 8212 == var0 || 339 == var0 || var0 == 376;
      }
   }
}
