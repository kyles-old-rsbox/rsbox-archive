public class class311 {
   byte[] field3691;
   int[] field3692;
   int[] field3693;

   public class311(byte[] var1) {
      int var2 = var1.length;
      this.field3692 = new int[var2];
      this.field3691 = var1;
      int[] var3 = new int[33];
      this.field3693 = new int[8];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         byte var6 = var1[var5];
         if (var6 != 0) {
            int var7 = 1 << 32 - var6;
            int var8 = var3[var6];
            this.field3692[var5] = var8;
            int var9;
            int var10;
            int var11;
            int var12;
            if ((var8 & var7) != 0) {
               var9 = var3[var6 - 1];
            } else {
               var9 = var8 | var7;

               for(var10 = var6 - 1; var10 >= 1; --var10) {
                  var11 = var3[var10];
                  if (var11 != var8) {
                     break;
                  }

                  var12 = 1 << 32 - var10;
                  if ((var11 & var12) != 0) {
                     var3[var10] = var3[var10 - 1];
                     break;
                  }

                  var3[var10] = var11 | var12;
               }
            }

            var3[var6] = var9;

            for(var10 = var6 + 1; var10 <= 32; ++var10) {
               if (var8 == var3[var10]) {
                  var3[var10] = var9;
               }
            }

            var10 = 0;

            for(var11 = 0; var11 < var6; ++var11) {
               var12 = Integer.MIN_VALUE >>> var11;
               if ((var8 & var12) != 0) {
                  if (0 == this.field3693[var10]) {
                     this.field3693[var10] = var4;
                  }

                  var10 = this.field3693[var10];
               } else {
                  ++var10;
               }

               if (var10 >= this.field3693.length) {
                  int[] var13 = new int[this.field3693.length * 2];

                  for(int var14 = 0; var14 < this.field3693.length; ++var14) {
                     var13[var14] = this.field3693[var14];
                  }

                  this.field3693 = var13;
               }

               var12 >>>= 1;
            }

            this.field3693[var10] = ~var5;
            if (var10 >= var4) {
               var4 = 1 + var10;
            }
         }
      }

   }

   int method6044(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var7 = 0;
      int var8 = var5 << 3;

      for(var3 += var2; var2 < var3; ++var2) {
         int var9 = var1[var2] & 255;
         int var10 = this.field3692[var9];
         byte var11 = this.field3691[var9];
         if (0 == var11) {
            throw new RuntimeException("" + var9);
         }

         int var12 = var8 >> 3;
         int var13 = var8 & 7;
         var7 &= -var13 >> 31;
         int var14 = (var11 + var13 - 1 >> 3) + var12;
         var13 += 24;
         var4[var12] = (byte)(var7 |= var10 >>> var13);
         if (var12 < var14) {
            ++var12;
            var13 -= 8;
            var4[var12] = (byte)(var7 = var10 >>> var13);
            if (var12 < var14) {
               ++var12;
               var13 -= 8;
               var4[var12] = (byte)(var7 = var10 >>> var13);
               if (var12 < var14) {
                  ++var12;
                  var13 -= 8;
                  var4[var12] = (byte)(var7 = var10 >>> var13);
                  if (var12 < var14) {
                     ++var12;
                     var13 -= 8;
                     var4[var12] = (byte)(var7 = var10 << -var13);
                  }
               }
            }
         }

         var8 += var11;
      }

      return (7 + var8 >> 3) - var5;
   }

   int method6049(byte[] var1, int var2, byte[] var3, int var4, int var5) {
      if (var5 == 0) {
         return 0;
      } else {
         int var7 = 0;
         var5 += var4;
         int var8 = var2;

         while(true) {
            byte var9 = var1[var8];
            if (var9 < 0) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            int var10;
            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if ((var9 & 64) != 0) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if ((var9 & 32) != 0) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if (0 != (var9 & 16)) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if (0 != (var9 & 8)) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if (0 != (var9 & 4)) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if (0 != (var9 & 2)) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            if (0 != (var9 & 1)) {
               var7 = this.field3693[var7];
            } else {
               ++var7;
            }

            if ((var10 = this.field3693[var7]) < 0) {
               var3[var4++] = (byte)(~var10);
               if (var4 >= var5) {
                  break;
               }

               var7 = 0;
            }

            ++var8;
         }

         return 1 + var8 - var2;
      }
   }

   static final void method6043(class300 var0, int var1, int var2) {
      if (client.field1874 == null && !client.field1784) {
         if (var0 != null) {
            class300 var5 = class252.method5039(var0);
            if (var5 == null) {
               var5 = var0.field3547;
            }

            if (var5 != null) {
               client.field1874 = var0;
               class300 var6 = var0;
               int var8 = class190.method3528(var0);
               int var7 = var8 >> 17 & 7;
               int var9 = var7;
               if (var7 == 0) {
                  var5 = null;
               } else {
                  int var10 = 0;

                  while(true) {
                     if (var10 >= var9) {
                        var5 = var6;
                        break;
                     }

                     var6 = class282.method5426(var6.field3596);
                     if (var6 == null) {
                        var5 = null;
                        break;
                     }

                     ++var10;
                  }
               }

               class300 var11 = var5;
               if (null == var5) {
                  var11 = var0.field3547;
               }

               client.field1823 = var11;
               client.field1824 = var1;
               client.field1825 = var2;
               class78.field684 = 0;
               client.field1833 = false;
               int var12 = client.method5125();
               if (-1 != var12) {
                  client.method102(var12);
               }

               return;
            }
         }

      }
   }
}
