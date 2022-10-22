public class class76 {
   float[][] field656;
   int field653;
   int field657;
   int[] field652;
   int[] field654;
   int[] field655;

   static int method1558(int var0, int var1) {
      int var2;
      for(var2 = (int)Math.pow((double)var0, 1.0D / (double)var1) + 1; class232.method4556(var2, var1) > var0; --var2) {
      }

      return var2;
   }

   class76() {
      VorbisSample.readBits(24);
      this.field653 = VorbisSample.readBits(16);
      this.field657 = VorbisSample.readBits(24);
      this.field654 = new int[this.field657];
      boolean var1 = VorbisSample.method1299() != 0;
      int var2;
      int var3;
      int var5;
      if (var1) {
         var2 = 0;

         for(var3 = VorbisSample.readBits(5) + 1; var2 < this.field657; ++var3) {
            int var4 = VorbisSample.readBits(class8.method51(this.field657 - var2));

            for(var5 = 0; var5 < var4; ++var5) {
               this.field654[var2++] = var3;
            }
         }
      } else {
         boolean var14 = VorbisSample.method1299() != 0;

         for(var3 = 0; var3 < this.field657; ++var3) {
            if (var14 && VorbisSample.method1299() == 0) {
               this.field654[var3] = 0;
            } else {
               this.field654[var3] = VorbisSample.readBits(5) + 1;
            }
         }
      }

      this.method1560();
      var2 = VorbisSample.readBits(4);
      if (var2 > 0) {
         float var15 = VorbisSample.method1331(VorbisSample.readBits(32));
         float var16 = VorbisSample.method1331(VorbisSample.readBits(32));
         var5 = VorbisSample.readBits(4) + 1;
         boolean var6 = VorbisSample.method1299() != 0;
         int var7;
         if (var2 == 1) {
            var7 = method1558(this.field657, this.field653);
         } else {
            var7 = this.field657 * this.field653;
         }

         this.field655 = new int[var7];

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            this.field655[var8] = VorbisSample.readBits(var5);
         }

         this.field656 = new float[this.field657][this.field653];
         float var9;
         int var10;
         int var11;
         if (var2 == 1) {
            for(var8 = 0; var8 < this.field657; ++var8) {
               var9 = 0.0F;
               var10 = 1;

               for(var11 = 0; var11 < this.field653; ++var11) {
                  int var12 = var8 / var10 % var7;
                  float var13 = (float)this.field655[var12] * var16 + var15 + var9;
                  this.field656[var8][var11] = var13;
                  if (var6) {
                     var9 = var13;
                  }

                  var10 *= var7;
               }
            }
         } else {
            for(var8 = 0; var8 < this.field657; ++var8) {
               var9 = 0.0F;
               var10 = var8 * this.field653;

               for(var11 = 0; var11 < this.field653; ++var11) {
                  float var17 = (float)this.field655[var10] * var16 + var15 + var9;
                  this.field656[var8][var11] = var17;
                  if (var6) {
                     var9 = var17;
                  }

                  ++var10;
               }
            }
         }
      }

   }

   void method1560() {
      int[] var1 = new int[this.field657];
      int[] var2 = new int[33];

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      for(var3 = 0; var3 < this.field657; ++var3) {
         var4 = this.field654[var3];
         if (var4 != 0) {
            var5 = 1 << 32 - var4;
            var6 = var2[var4];
            var1[var3] = var6;
            int var9;
            if ((var6 & var5) != 0) {
               var7 = var2[var4 - 1];
            } else {
               var7 = var6 | var5;

               for(var8 = var4 - 1; var8 >= 1; --var8) {
                  var9 = var2[var8];
                  if (var9 != var6) {
                     break;
                  }

                  var10 = 1 << 32 - var8;
                  if ((var9 & var10) != 0) {
                     var2[var8] = var2[var8 - 1];
                     break;
                  }

                  var2[var8] = var9 | var10;
               }
            }

            var2[var4] = var7;

            for(var8 = var4 + 1; var8 <= 32; ++var8) {
               var9 = var2[var8];
               if (var9 == var6) {
                  var2[var8] = var7;
               }
            }
         }
      }

      this.field652 = new int[8];
      int var11 = 0;

      for(var3 = 0; var3 < this.field657; ++var3) {
         var4 = this.field654[var3];
         if (var4 != 0) {
            var5 = var1[var3];
            var6 = 0;

            for(var7 = 0; var7 < var4; ++var7) {
               var8 = Integer.MIN_VALUE >>> var7;
               if ((var5 & var8) != 0) {
                  if (this.field652[var6] == 0) {
                     this.field652[var6] = var11;
                  }

                  var6 = this.field652[var6];
               } else {
                  ++var6;
               }

               if (var6 >= this.field652.length) {
                  int[] var12 = new int[this.field652.length * 2];

                  for(var10 = 0; var10 < this.field652.length; ++var10) {
                     var12[var10] = this.field652[var10];
                  }

                  this.field652 = var12;
               }

               var8 >>>= 1;
            }

            this.field652[var6] = ~var3;
            if (var6 >= var11) {
               var11 = var6 + 1;
            }
         }
      }

   }

   int method1562() {
      int var1;
      for(var1 = 0; this.field652[var1] >= 0; var1 = VorbisSample.method1299() != 0 ? this.field652[var1] : var1 + 1) {
      }

      return ~this.field652[var1];
   }

   float[] method1559() {
      return this.field656[this.method1562()];
   }
}
