public class class46 {
   int field331 = VorbisSample.readBits(8);
   int field332 = VorbisSample.readBits(24);
   int field333 = VorbisSample.readBits(16);
   int field334 = VorbisSample.readBits(24) + 1;
   int field335 = VorbisSample.readBits(24);
   int field337 = VorbisSample.readBits(6) + 1;
   int[] field336;

   class46() {
      int[] var1 = new int[this.field337];

      int var2;
      for(var2 = 0; var2 < this.field337; ++var2) {
         int var3 = 0;
         int var4 = VorbisSample.readBits(3);
         boolean var5 = VorbisSample.method1299() != 0;
         if (var5) {
            var3 = VorbisSample.readBits(5);
         }

         var1[var2] = var3 << 3 | var4;
      }

      this.field336 = new int[this.field337 * 8];

      for(var2 = 0; var2 < this.field337 * 8; ++var2) {
         this.field336[var2] = (var1[var2 >> 3] & 1 << (var2 & 7)) != 0 ? VorbisSample.readBits(8) : -1;
      }

   }

   void method954(float[] var1, int var2, boolean var3) {
      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var1[var4] = 0.0F;
      }

      if (!var3) {
         var4 = VorbisSample.field458[this.field331].field653;
         int var5 = this.field335 - this.field332;
         int var6 = var5 / this.field334;
         int[] var7 = new int[var6];

         for(int var8 = 0; var8 < 8; ++var8) {
            int var9 = 0;

            while(var9 < var6) {
               int var10;
               int var11;
               if (var8 == 0) {
                  var10 = VorbisSample.field458[this.field331].method1562();

                  for(var11 = var4 - 1; var11 >= 0; --var11) {
                     if (var9 + var11 < var6) {
                        var7[var9 + var11] = var10 % this.field337;
                     }

                     var10 /= this.field337;
                  }
               }

               for(var10 = 0; var10 < var4; ++var10) {
                  var11 = var7[var9];
                  int var12 = this.field336[var11 * 8 + var8];
                  if (var12 >= 0) {
                     int var13 = this.field332 + var9 * this.field334;
                     class76 var14 = VorbisSample.field458[var12];
                     int var15;
                     if (this.field333 == 0) {
                        var15 = this.field334 / var14.field653;

                        for(int var19 = 0; var19 < var15; ++var19) {
                           float[] var20 = var14.method1559();

                           for(int var18 = 0; var18 < var14.field653; ++var18) {
                              var1[var13 + var19 + var18 * var15] += var20[var18];
                           }
                        }
                     } else {
                        var15 = 0;

                        while(var15 < this.field334) {
                           float[] var16 = var14.method1559();

                           for(int var17 = 0; var17 < var14.field653; ++var17) {
                              var1[var13 + var15] += var16[var17];
                              ++var15;
                           }
                        }
                     }
                  }

                  ++var9;
                  if (var9 >= var6) {
                     break;
                  }
               }
            }
         }

      }
   }
}
