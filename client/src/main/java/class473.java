public final class class473 extends class481 {
   int field4962;
   public int field4951;
   public int field4954;
   public int field4956;
   public int field4957;
   public int field4959;
   public int[] field4952;

   class473() {
   }

   public class473(int var1, int var2) {
      this(new int[var1 * var2], var1, var2);
   }

   public class473(int[] var1, int var2, int var3) {
      this.field4952 = var1;
      this.field4959 = this.field4956 = var2;
      this.field4951 = this.field4957 = var3;
      this.field4962 = 0;
      this.field4954 = 0;
   }

   public class473 method8466() {
      class473 var1 = new class473(this.field4959, this.field4951);
      var1.field4956 = this.field4956;
      var1.field4957 = this.field4957;
      var1.field4954 = this.field4956 - this.field4959 - this.field4954;
      var1.field4962 = this.field4962;

      for(int var2 = 0; var2 < this.field4951; ++var2) {
         for(int var3 = 0; var3 < this.field4959; ++var3) {
            var1.field4952[var2 * this.field4959 + var3] = this.field4952[var2 * this.field4959 + this.field4959 - 1 - var3];
         }
      }

      return var1;
   }

   public class473 method8467() {
      class473 var1 = new class473(this.field4959, this.field4951);
      var1.field4956 = this.field4956;
      var1.field4957 = this.field4957;
      var1.field4954 = this.field4954;
      var1.field4962 = this.field4962;
      int var2 = this.field4952.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.field4952[var3] = this.field4952[var3];
      }

      return var1;
   }

   public class473 method8468() {
      class473 var1 = new class473(this.field4956, this.field4957);

      for(int var2 = 0; var2 < this.field4951; ++var2) {
         for(int var3 = 0; var3 < this.field4959; ++var3) {
            var1.field4952[(var2 + this.field4962) * this.field4956 + var3 + this.field4954] = this.field4952[var2 * this.field4959 + var3];
         }
      }

      return var1;
   }

   public void method8469() {
      method8644(this.field4952, this.field4959, this.field4951);
   }

   public void method8470() {
      if (this.field4959 != this.field4956 || this.field4951 != this.field4957) {
         int[] var1 = new int[this.field4956 * this.field4957];

         for(int var2 = 0; var2 < this.field4951; ++var2) {
            for(int var3 = 0; var3 < this.field4959; ++var3) {
               var1[(var2 + this.field4962) * this.field4956 + var3 + this.field4954] = this.field4952[var2 * this.field4959 + var3];
            }
         }

         this.field4952 = var1;
         this.field4959 = this.field4956;
         this.field4951 = this.field4957;
         this.field4954 = 0;
         this.field4962 = 0;
      }
   }

   public void method8471(int var1) {
      if (this.field4959 != this.field4956 || this.field4951 != this.field4957) {
         int var2 = var1;
         if (var1 > this.field4954) {
            var2 = this.field4954;
         }

         int var3 = var1;
         if (var1 + this.field4954 + this.field4959 > this.field4956) {
            var3 = this.field4956 - this.field4954 - this.field4959;
         }

         int var4 = var1;
         if (var1 > this.field4962) {
            var4 = this.field4962;
         }

         int var5 = var1;
         if (var1 + this.field4962 + this.field4951 > this.field4957) {
            var5 = this.field4957 - this.field4962 - this.field4951;
         }

         int var6 = this.field4959 + var2 + var3;
         int var7 = this.field4951 + var4 + var5;
         int[] var8 = new int[var6 * var7];

         for(int var9 = 0; var9 < this.field4951; ++var9) {
            for(int var10 = 0; var10 < this.field4959; ++var10) {
               var8[(var9 + var4) * var6 + var10 + var2] = this.field4952[var9 * this.field4959 + var10];
            }
         }

         this.field4952 = var8;
         this.field4959 = var6;
         this.field4951 = var7;
         this.field4954 -= var2;
         this.field4962 -= var4;
      }
   }

   public void method8576() {
      int[] var1 = new int[this.field4959 * this.field4951];
      int var2 = 0;

      for(int var3 = 0; var3 < this.field4951; ++var3) {
         for(int var4 = this.field4959 - 1; var4 >= 0; --var4) {
            var1[var2++] = this.field4952[var4 + var3 * this.field4959];
         }
      }

      this.field4952 = var1;
      this.field4954 = this.field4956 - this.field4959 - this.field4954;
   }

   public void method8473() {
      int[] var1 = new int[this.field4959 * this.field4951];
      int var2 = 0;

      for(int var3 = this.field4951 - 1; var3 >= 0; --var3) {
         for(int var4 = 0; var4 < this.field4959; ++var4) {
            var1[var2++] = this.field4952[var4 + var3 * this.field4959];
         }
      }

      this.field4952 = var1;
      this.field4962 = this.field4957 - this.field4951 - this.field4962;
   }

   public void method8511(int var1) {
      int[] var2 = new int[this.field4959 * this.field4951];
      int var3 = 0;

      for(int var4 = 0; var4 < this.field4951; ++var4) {
         for(int var5 = 0; var5 < this.field4959; ++var5) {
            int var6 = this.field4952[var3];
            if (var6 == 0) {
               if (var5 > 0 && this.field4952[var3 - 1] != 0) {
                  var6 = var1;
               } else if (var4 > 0 && this.field4952[var3 - this.field4959] != 0) {
                  var6 = var1;
               } else if (var5 < this.field4959 - 1 && this.field4952[var3 + 1] != 0) {
                  var6 = var1;
               } else if (var4 < this.field4951 - 1 && this.field4952[var3 + this.field4959] != 0) {
                  var6 = var1;
               }
            }

            var2[var3++] = var6;
         }
      }

      this.field4952 = var2;
   }

   public void method8475(int var1) {
      for(int var2 = this.field4951 - 1; var2 > 0; --var2) {
         int var3 = var2 * this.field4959;

         for(int var4 = this.field4959 - 1; var4 > 0; --var4) {
            if (this.field4952[var4 + var3] == 0 && this.field4952[var4 + var3 - 1 - this.field4959] != 0) {
               this.field4952[var4 + var3] = var1;
            }
         }
      }

   }

   public void method8476(int var1, int var2) {
      var1 += this.field4954;
      var2 += this.field4962;
      int var3 = var1 + var2 * class481.field4993;
      int var4 = 0;
      int var5 = this.field4951;
      int var6 = this.field4959;
      int var7 = class481.field4993 - var6;
      int var8 = 0;
      int var9;
      if (var2 < class481.field4995) {
         var9 = class481.field4995 - var2;
         var5 -= var9;
         var2 = class481.field4995;
         var4 += var9 * var6;
         var3 += var9 * class481.field4993;
      }

      if (var2 + var5 > class481.field4998) {
         var5 -= var2 + var5 - class481.field4998;
      }

      if (var1 < class481.field4997) {
         var9 = class481.field4997 - var1;
         var6 -= var9;
         var1 = class481.field4997;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if (var1 + var6 > class481.field4996) {
         var9 = var1 + var6 - class481.field4996;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if (var6 > 0 && var5 > 0) {
         method8483(class481.field4992, this.field4952, var4, var3, var6, var5, var7, var8);
      }
   }

   static void method8483(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = -var5; var8 < 0; ++var8) {
         int var9;
         for(var9 = var3 + var4 - 3; var3 < var9; var0[var3++] = var1[var2++]) {
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
            var0[var3++] = var1[var2++];
         }

         for(var9 += 3; var3 < var9; var0[var3++] = var1[var2++]) {
         }

         var3 += var6;
         var2 += var7;
      }

   }

   public void method8519(int var1, int var2) {
      var1 += this.field4954;
      var2 += this.field4962;
      int var3 = var1 + var2 * class481.field4993;
      int var4 = 0;
      int var5 = this.field4951;
      int var6 = this.field4959;
      int var7 = class481.field4993 - var6;
      int var8 = 0;
      int var9;
      if (var2 < class481.field4995) {
         var9 = class481.field4995 - var2;
         var5 -= var9;
         var2 = class481.field4995;
         var4 += var9 * var6;
         var3 += var9 * class481.field4993;
      }

      if (var2 + var5 > class481.field4998) {
         var5 -= var2 + var5 - class481.field4998;
      }

      if (var1 < class481.field4997) {
         var9 = class481.field4997 - var1;
         var6 -= var9;
         var1 = class481.field4997;
         var4 += var9;
         var3 += var9;
         var8 += var9;
         var7 += var9;
      }

      if (var1 + var6 > class481.field4996) {
         var9 = var1 + var6 - class481.field4996;
         var6 -= var9;
         var8 += var9;
         var7 += var9;
      }

      if (var6 > 0 && var5 > 0) {
         method8544(class481.field4992, this.field4952, 0, var4, var3, var6, var5, var7, var8);
      }
   }

   static void method8544(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = -(var5 >> 2);
      var5 = -(var5 & 3);

      for(int var10 = -var6; var10 < 0; ++var10) {
         int var11;
         for(var11 = var9; var11 < 0; ++var11) {
            var2 = var1[var3++];
            if (var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if (var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if (var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }

            var2 = var1[var3++];
            if (var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         for(var11 = var5; var11 < 0; ++var11) {
            var2 = var1[var3++];
            if (var2 != 0) {
               var0[var4++] = var2;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   public void method8480(int var1, int var2, int var3, int var4) {
      if (var3 > 0 && var4 > 0) {
         int var5 = this.field4959;
         int var6 = this.field4951;
         int var7 = 0;
         int var8 = 0;
         int var9 = this.field4956;
         int var10 = this.field4957;
         int var11 = (var9 << 16) / var3;
         int var12 = (var10 << 16) / var4;
         int var13;
         if (this.field4954 > 0) {
            var13 = ((this.field4954 << 16) + var11 - 1) / var11;
            var1 += var13;
            var7 += var13 * var11 - (this.field4954 << 16);
         }

         if (this.field4962 > 0) {
            var13 = ((this.field4962 << 16) + var12 - 1) / var12;
            var2 += var13;
            var8 += var13 * var12 - (this.field4962 << 16);
         }

         if (var5 < var9) {
            var3 = ((var5 << 16) - var7 + var11 - 1) / var11;
         }

         if (var6 < var10) {
            var4 = ((var6 << 16) - var8 + var12 - 1) / var12;
         }

         var13 = var1 + var2 * class481.field4993;
         int var14 = class481.field4993 - var3;
         if (var2 + var4 > class481.field4998) {
            var4 -= var2 + var4 - class481.field4998;
         }

         int var15;
         if (var2 < class481.field4995) {
            var15 = class481.field4995 - var2;
            var4 -= var15;
            var13 += var15 * class481.field4993;
            var8 += var12 * var15;
         }

         if (var1 + var3 > class481.field4996) {
            var15 = var1 + var3 - class481.field4996;
            var3 -= var15;
            var14 += var15;
         }

         if (var1 < class481.field4997) {
            var15 = class481.field4997 - var1;
            var3 -= var15;
            var13 += var15;
            var7 += var11 * var15;
            var14 += var15;
         }

         method8481(class481.field4992, this.field4952, 0, var7, var8, var13, var14, var3, var4, var11, var12, var5);
      }
   }

   static void method8481(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = var3;

      for(int var13 = -var8; var13 < 0; ++var13) {
         int var14 = (var4 >> 16) * var11;

         for(int var15 = -var7; var15 < 0; ++var15) {
            var2 = var1[(var3 >> 16) + var14];
            if (var2 != 0) {
               var0[var5++] = var2;
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var12;
         var5 += var6;
      }

   }

   public void method8482(int var1, int var2, int var3, int var4) {
      if (var3 == 256) {
         this.method8519(var1, var2);
      } else {
         var1 += this.field4954;
         var2 += this.field4962;
         int var5 = var1 + var2 * class481.field4993;
         int var6 = 0;
         int var7 = this.field4951;
         int var8 = this.field4959;
         int var9 = class481.field4993 - var8;
         int var10 = 0;
         int var11;
         if (var2 < class481.field4995) {
            var11 = class481.field4995 - var2;
            var7 -= var11;
            var2 = class481.field4995;
            var6 += var11 * var8;
            var5 += var11 * class481.field4993;
         }

         if (var2 + var7 > class481.field4998) {
            var7 -= var2 + var7 - class481.field4998;
         }

         if (var1 < class481.field4997) {
            var11 = class481.field4997 - var1;
            var8 -= var11;
            var1 = class481.field4997;
            var6 += var11;
            var5 += var11;
            var10 += var11;
            var9 += var11;
         }

         if (var1 + var8 > class481.field4996) {
            var11 = var1 + var8 - class481.field4996;
            var8 -= var11;
            var10 += var11;
            var9 += var11;
         }

         if (var8 > 0 && var7 > 0) {
            method8532(class481.field4992, this.field4952, 0, var6, var5, var8, var7, var9, var10, var3, var4);
         }
      }
   }

   static void method8532(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = 256 - var9;
      int var12 = (var10 & 16711935) * var11 & -16711936;
      int var13 = (var10 & '\uff00') * var11 & 16711680;
      var10 = (var12 | var13) >>> 8;

      for(int var14 = -var6; var14 < 0; ++var14) {
         for(int var15 = -var5; var15 < 0; ++var15) {
            var2 = var1[var3++];
            if (var2 != 0) {
               var12 = (var2 & 16711935) * var9 & -16711936;
               var13 = (var2 & '\uff00') * var9 & 16711680;
               var0[var4++] = ((var12 | var13) >>> 8) + var10;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   public void method8484(int var1, int var2, int var3) {
      var1 += this.field4954;
      var2 += this.field4962;
      int var4 = var1 + var2 * class481.field4993;
      int var5 = 0;
      int var6 = this.field4951;
      int var7 = this.field4959;
      int var8 = class481.field4993 - var7;
      int var9 = 0;
      int var10;
      if (var2 < class481.field4995) {
         var10 = class481.field4995 - var2;
         var6 -= var10;
         var2 = class481.field4995;
         var5 += var10 * var7;
         var4 += var10 * class481.field4993;
      }

      if (var2 + var6 > class481.field4998) {
         var6 -= var2 + var6 - class481.field4998;
      }

      if (var1 < class481.field4997) {
         var10 = class481.field4997 - var1;
         var7 -= var10;
         var1 = class481.field4997;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if (var1 + var7 > class481.field4996) {
         var10 = var1 + var7 - class481.field4996;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if (var7 > 0 && var6 > 0) {
         method8485(class481.field4992, this.field4952, 0, var5, var4, var7, var6, var8, var9, var3);
      }
   }

   static void method8485(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var10 = 256 - var9;

      for(int var11 = -var6; var11 < 0; ++var11) {
         for(int var12 = -var5; var12 < 0; ++var12) {
            var2 = var1[var3++];
            if (var2 != 0) {
               int var13 = var0[var4];
               var0[var4++] = ((var2 & 16711935) * var9 + (var13 & 16711935) * var10 & -16711936) + ((var2 & '\uff00') * var9 + (var13 & '\uff00') * var10 & 16711680) >> 8;
            } else {
               ++var4;
            }
         }

         var4 += var7;
         var3 += var8;
      }

   }

   public void method8486(int var1, int var2, int var3, int var4, int var5) {
      if (var3 > 0 && var4 > 0) {
         int var6 = this.field4959;
         int var7 = this.field4951;
         int var8 = 0;
         int var9 = 0;
         int var10 = this.field4956;
         int var11 = this.field4957;
         int var12 = (var10 << 16) / var3;
         int var13 = (var11 << 16) / var4;
         int var14;
         if (this.field4954 > 0) {
            var14 = ((this.field4954 << 16) + var12 - 1) / var12;
            var1 += var14;
            var8 += var14 * var12 - (this.field4954 << 16);
         }

         if (this.field4962 > 0) {
            var14 = ((this.field4962 << 16) + var13 - 1) / var13;
            var2 += var14;
            var9 += var14 * var13 - (this.field4962 << 16);
         }

         if (var6 < var10) {
            var3 = ((var6 << 16) - var8 + var12 - 1) / var12;
         }

         if (var7 < var11) {
            var4 = ((var7 << 16) - var9 + var13 - 1) / var13;
         }

         var14 = var1 + var2 * class481.field4993;
         int var15 = class481.field4993 - var3;
         if (var2 + var4 > class481.field4998) {
            var4 -= var2 + var4 - class481.field4998;
         }

         int var16;
         if (var2 < class481.field4995) {
            var16 = class481.field4995 - var2;
            var4 -= var16;
            var14 += var16 * class481.field4993;
            var9 += var13 * var16;
         }

         if (var1 + var3 > class481.field4996) {
            var16 = var1 + var3 - class481.field4996;
            var3 -= var16;
            var15 += var16;
         }

         if (var1 < class481.field4997) {
            var16 = class481.field4997 - var1;
            var3 -= var16;
            var14 += var16;
            var8 += var12 * var16;
            var15 += var16;
         }

         method8487(class481.field4992, this.field4952, 0, var8, var9, var14, var15, var3, var4, var12, var13, var6, var5);
      }
   }

   static void method8487(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      int var13 = 256 - var12;
      int var14 = var3;

      for(int var15 = -var8; var15 < 0; ++var15) {
         int var16 = (var4 >> 16) * var11;

         for(int var17 = -var7; var17 < 0; ++var17) {
            var2 = var1[(var3 >> 16) + var16];
            if (var2 != 0) {
               int var18 = var0[var5];
               var0[var5++] = ((var2 & 16711935) * var12 + (var18 & 16711935) * var13 & -16711936) + ((var2 & '\uff00') * var12 + (var18 & '\uff00') * var13 & 16711680) >> 8;
            } else {
               ++var5;
            }

            var3 += var9;
         }

         var4 += var10;
         var3 = var14;
         var5 += var6;
      }

   }

   public void method8488(int var1, int var2, int var3) {
      var1 += this.field4954;
      var2 += this.field4962;
      int var4 = var1 + var2 * class481.field4993;
      int var5 = 0;
      int var6 = this.field4951;
      int var7 = this.field4959;
      int var8 = class481.field4993 - var7;
      int var9 = 0;
      int var10;
      if (var2 < class481.field4995) {
         var10 = class481.field4995 - var2;
         var6 -= var10;
         var2 = class481.field4995;
         var5 += var10 * var7;
         var4 += var10 * class481.field4993;
      }

      if (var2 + var6 > class481.field4998) {
         var6 -= var2 + var6 - class481.field4998;
      }

      if (var1 < class481.field4997) {
         var10 = class481.field4997 - var1;
         var7 -= var10;
         var1 = class481.field4997;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if (var1 + var7 > class481.field4996) {
         var10 = var1 + var7 - class481.field4996;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if (var7 > 0 && var6 > 0) {
         if (var3 == 256) {
            method8489(0, 0, 0, class481.field4992, this.field4952, var5, 0, var4, 0, var7, var6, var8, var9);
         } else {
            method8490(0, 0, 0, class481.field4992, this.field4952, var5, 0, var4, 0, var7, var6, var8, var9, var3);
         }

      }
   }

   static void method8489(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      for(var8 = -var10; var8 < 0; ++var8) {
         for(var6 = -var9; var6 < 0; ++var6) {
            var0 = var4[var5++];
            if (var0 != 0) {
               var1 = var3[var7];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var7;
            }
         }

         var7 += var11;
         var5 += var12;
      }

   }

   static void method8490(int var0, int var1, int var2, int[] var3, int[] var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      for(var8 = -var10; var8 < 0; ++var8) {
         for(var6 = -var9; var6 < 0; ++var6) {
            var0 = var4[var5++];
            if (var0 != 0) {
               var1 = (var0 & 16711935) * var13;
               var0 = (var1 & -16711936) + (var0 * var13 - var1 & 16711680) >>> 8;
               var1 = var3[var7];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var3[var7++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var7;
            }
         }

         var7 += var11;
         var5 += var12;
      }

   }

   public void method8491(int var1, int var2, int var3, int var4, int var5) {
      if (var3 > 0 && var4 > 0) {
         int var6 = this.field4959;
         int var7 = this.field4951;
         int var8 = 0;
         int var9 = 0;
         int var10 = this.field4956;
         int var11 = this.field4957;
         int var12 = (var10 << 16) / var3;
         int var13 = (var11 << 16) / var4;
         int var14;
         if (this.field4954 > 0) {
            var14 = ((this.field4954 << 16) + var12 - 1) / var12;
            var1 += var14;
            var8 += var14 * var12 - (this.field4954 << 16);
         }

         if (this.field4962 > 0) {
            var14 = ((this.field4962 << 16) + var13 - 1) / var13;
            var2 += var14;
            var9 += var14 * var13 - (this.field4962 << 16);
         }

         if (var6 < var10) {
            var3 = ((var6 << 16) - var8 + var12 - 1) / var12;
         }

         if (var7 < var11) {
            var4 = ((var7 << 16) - var9 + var13 - 1) / var13;
         }

         var14 = var1 + var2 * class481.field4993;
         int var15 = class481.field4993 - var3;
         if (var2 + var4 > class481.field4998) {
            var4 -= var2 + var4 - class481.field4998;
         }

         int var16;
         if (var2 < class481.field4995) {
            var16 = class481.field4995 - var2;
            var4 -= var16;
            var14 += var16 * class481.field4993;
            var9 += var13 * var16;
         }

         if (var1 + var3 > class481.field4996) {
            var16 = var1 + var3 - class481.field4996;
            var3 -= var16;
            var15 += var16;
         }

         if (var1 < class481.field4997) {
            var16 = class481.field4997 - var1;
            var3 -= var16;
            var14 += var16;
            var8 += var12 * var16;
            var15 += var16;
         }

         if (var5 == 256) {
            method8492(0, 0, 0, var8, this.field4952, class481.field4992, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6);
         } else {
            method8493(0, 0, 0, var8, this.field4952, class481.field4992, 0, 0, -var4, var9, var14, var15, var3, var12, var13, var6, var5);
         }

      }
   }

   static void method8492(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15) {
      for(int var16 = var3; var8 < 0; ++var8) {
         var7 = (var9 >> 16) * var15;

         for(var6 = -var12; var6 < 0; ++var6) {
            var0 = var4[(var3 >> 16) + var7];
            if (var0 != 0) {
               var1 = var5[var10];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var10;
            }

            var3 += var13;
         }

         var9 += var14;
         var3 = var16;
         var10 += var11;
      }

   }

   static void method8493(int var0, int var1, int var2, int var3, int[] var4, int[] var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
      for(int var17 = var3; var8 < 0; ++var8) {
         var7 = (var9 >> 16) * var15;

         for(var6 = -var12; var6 < 0; ++var6) {
            var0 = var4[(var3 >> 16) + var7];
            if (var0 != 0) {
               var1 = (var0 & 16711935) * var16;
               var0 = (var1 & -16711936) + (var0 * var16 - var1 & 16711680) >>> 8;
               var1 = var5[var10];
               var2 = var0 + var1;
               var0 = (var0 & 16711935) + (var1 & 16711935);
               var1 = (var0 & 16777472) + (var2 - var0 & 65536);
               var5[var10++] = var2 - var1 | var1 - (var1 >>> 8);
            } else {
               ++var10;
            }

            var3 += var13;
         }

         var9 += var14;
         var3 = var17;
         var10 += var11;
      }

   }

   public void method8494(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7, int[] var8) {
      int var9 = var2 < 0 ? -var2 : 0;
      int var10 = var2 + this.field4951 <= var6 ? this.field4951 : var6 - var2;
      int var11 = var1 < 0 ? -var1 : 0;
      int var10000;
      if (var1 + this.field4959 <= var5) {
         var10000 = this.field4959;
      } else {
         var10000 = var5 - var1;
      }

      int var13 = var3 + var1 + var11 + (var4 + var2 + var9) * class481.field4993;
      int var14 = var2 + var9;

      for(int var15 = var9; var15 < var10; ++var15) {
         int var16 = var7[var14];
         int var17 = var8[var14++];
         int var18 = var13;
         int var19;
         if (var1 < var16) {
            var19 = var16 - var1;
            var18 = var13 + (var19 - var11);
         } else {
            var19 = var11;
         }

         int var12;
         if (var1 + this.field4959 <= var16 + var17) {
            var12 = this.field4959;
         } else {
            var12 = var16 + var17 - var1;
         }

         for(int var20 = var19; var20 < var12; ++var20) {
            int var21 = this.field4952[var20 + var15 * this.field4959];
            if (var21 != 0) {
               class481.field4992[var18++] = var21;
            } else {
               ++var18;
            }
         }

         var13 += class481.field4993;
      }

   }

   public void method8495(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, int[] var10) {
      try {
         int var11 = -var3 / 2;
         int var12 = -var4 / 2;
         int var13 = (int)(Math.sin((double)var7 / 326.11D) * 65536.0D);
         int var14 = (int)(Math.cos((double)var7 / 326.11D) * 65536.0D);
         var13 = var13 * var8 >> 8;
         var14 = var14 * var8 >> 8;
         int var15 = (var5 << 16) + var12 * var13 + var11 * var14;
         int var16 = (var6 << 16) + (var12 * var14 - var11 * var13);
         int var17 = var1 + var2 * class481.field4993;

         for(var2 = 0; var2 < var4; ++var2) {
            int var18 = var9[var2];
            int var19 = var17 + var18;
            int var20 = var15 + var14 * var18;
            int var21 = var16 - var13 * var18;

            for(var1 = -var10[var2]; var1 < 0; ++var1) {
               class481.field4992[var19++] = this.field4952[(var20 >> 16) + (var21 >> 16) * this.field4959];
               var20 += var14;
               var21 -= var13;
            }

            var15 += var13;
            var16 += var14;
            var17 += class481.field4993;
         }
      } catch (Exception var22) {
      }

   }

   public void method8566(int var1, int var2, int var3, int var4, int var5, int var6, double var7, int var9) {
      try {
         int var10 = -var3 / 2;
         int var11 = -var4 / 2;
         int var12 = (int)(Math.sin(var7) * 65536.0D);
         int var13 = (int)(Math.cos(var7) * 65536.0D);
         var12 = var12 * var9 >> 8;
         var13 = var13 * var9 >> 8;
         int var14 = (var5 << 16) + var11 * var12 + var10 * var13;
         int var15 = (var6 << 16) + (var11 * var13 - var10 * var12);
         int var16 = var1 + var2 * class481.field4993;

         for(var2 = 0; var2 < var4; ++var2) {
            int var17 = var16;
            int var18 = var14;
            int var19 = var15;

            for(var1 = -var3; var1 < 0; ++var1) {
               int var20 = this.field4952[(var18 >> 16) + (var19 >> 16) * this.field4959];
               if (var20 != 0) {
                  class481.field4992[var17++] = var20;
               } else {
                  ++var17;
               }

               var18 += var13;
               var19 -= var12;
            }

            var14 += var12;
            var15 += var13;
            var16 += class481.field4993;
         }
      } catch (Exception var21) {
      }

   }

   public void method8497(int var1, int var2, int var3, int var4) {
      this.method8498(this.field4956 << 3, this.field4957 << 3, var1 << 4, var2 << 4, var3, var4);
   }

   void method8498(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var6 != 0) {
         var1 -= this.field4954 << 4;
         var2 -= this.field4962 << 4;
         double var7 = (double)(var5 & '\uffff') * 9.587379924285257E-5D;
         int var9 = (int)Math.floor(Math.sin(var7) * (double)var6 + 0.5D);
         int var10 = (int)Math.floor(Math.cos(var7) * (double)var6 + 0.5D);
         int var11 = -var1 * var10 + -var2 * var9;
         int var12 = -(-var1) * var9 + -var2 * var10;
         int var13 = ((this.field4959 << 4) - var1) * var10 + -var2 * var9;
         int var14 = -((this.field4959 << 4) - var1) * var9 + -var2 * var10;
         int var15 = -var1 * var10 + ((this.field4951 << 4) - var2) * var9;
         int var16 = -(-var1) * var9 + ((this.field4951 << 4) - var2) * var10;
         int var17 = ((this.field4959 << 4) - var1) * var10 + ((this.field4951 << 4) - var2) * var9;
         int var18 = -((this.field4959 << 4) - var1) * var9 + ((this.field4951 << 4) - var2) * var10;
         int var19;
         int var20;
         if (var11 < var13) {
            var19 = var11;
            var20 = var13;
         } else {
            var19 = var13;
            var20 = var11;
         }

         if (var15 < var19) {
            var19 = var15;
         }

         if (var17 < var19) {
            var19 = var17;
         }

         if (var15 > var20) {
            var20 = var15;
         }

         if (var17 > var20) {
            var20 = var17;
         }

         int var21;
         int var22;
         if (var12 < var14) {
            var21 = var12;
            var22 = var14;
         } else {
            var21 = var14;
            var22 = var12;
         }

         if (var16 < var21) {
            var21 = var16;
         }

         if (var18 < var21) {
            var21 = var18;
         }

         if (var16 > var22) {
            var22 = var16;
         }

         if (var18 > var22) {
            var22 = var18;
         }

         var19 >>= 12;
         var20 = var20 + 4095 >> 12;
         var21 >>= 12;
         var22 = var22 + 4095 >> 12;
         var19 += var3;
         var20 += var3;
         var21 += var4;
         var22 += var4;
         var19 >>= 4;
         var20 = var20 + 15 >> 4;
         var21 >>= 4;
         var22 = var22 + 15 >> 4;
         if (var19 < class481.field4997) {
            var19 = class481.field4997;
         }

         if (var20 > class481.field4996) {
            var20 = class481.field4996;
         }

         if (var21 < class481.field4995) {
            var21 = class481.field4995;
         }

         if (var22 > class481.field4998) {
            var22 = class481.field4998;
         }

         var20 = var19 - var20;
         if (var20 < 0) {
            var22 = var21 - var22;
            if (var22 < 0) {
               int var23 = var21 * class481.field4993 + var19;
               double var24 = 1.6777216E7D / (double)var6;
               int var26 = (int)Math.floor(Math.sin(var7) * var24 + 0.5D);
               int var27 = (int)Math.floor(Math.cos(var7) * var24 + 0.5D);
               int var28 = (var19 << 4) + 8 - var3;
               int var29 = (var21 << 4) + 8 - var4;
               int var30 = (var1 << 8) - (var29 * var26 >> 4);
               int var31 = (var2 << 8) + (var29 * var27 >> 4);
               int var32;
               int var33;
               int var34;
               int var35;
               int var36;
               int var37;
               int var38;
               if (var27 == 0) {
                  if (var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31;
                        var37 = var20;
                        if (var30 >= 0 && var31 >= 0 && var30 - (this.field4959 << 12) < 0 && var31 - (this.field4951 << 12) < 0) {
                           for(; var37 < 0; ++var37) {
                              var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                              if (var38 != 0) {
                                 class481.field4992[var34++] = var38;
                              } else {
                                 ++var34;
                              }
                           }
                        }

                        ++var33;
                     }
                  } else if (var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if (var30 >= 0 && var30 - (this.field4959 << 12) < 0) {
                           if ((var32 = var36 - (this.field4951 << 12)) >= 0) {
                              var32 = (var26 - var32) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if ((var32 = (var36 - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                              if (var38 != 0) {
                                 class481.field4992[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30;
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if (var30 >= 0 && var30 - (this.field4959 << 12) < 0) {
                           if (var36 < 0) {
                              var32 = (var26 - 1 - var36) / var26;
                              var37 = var20 + var32;
                              var36 += var26 * var32;
                              var34 = var23 + var32;
                           }

                           if ((var32 = (1 + var36 - (this.field4951 << 12) - var26) / var26) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                              if (var38 != 0) {
                                 class481.field4992[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var36 += var26;
                              ++var37;
                           }
                        }

                        ++var33;
                        var30 -= var26;
                     }
                  }
               } else if (var27 < 0) {
                  if (var26 == 0) {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31;
                        var37 = var20;
                        if (var31 >= 0 && var31 - (this.field4951 << 12) < 0) {
                           if ((var32 = var35 - (this.field4959 << 12)) >= 0) {
                              var32 = (var27 - var32) / var27;
                              var37 = var20 + var32;
                              var35 += var27 * var32;
                              var34 = var23 + var32;
                           }

                           if ((var32 = (var35 - var27) / var27) > var37) {
                              var37 = var32;
                           }

                           while(var37 < 0) {
                              var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                              if (var38 != 0) {
                                 class481.field4992[var34++] = var38;
                              } else {
                                 ++var34;
                              }

                              var35 += var27;
                              ++var37;
                           }
                        }

                        ++var33;
                        var31 += var27;
                     }
                  } else if (var26 < 0) {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if ((var32 = var35 - (this.field4959 << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if ((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if ((var32 = var36 - (this.field4951 << 12)) >= 0) {
                           var32 = (var26 - var32) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if ((var32 = (var36 - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                           if (var38 != 0) {
                              class481.field4992[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  } else {
                     for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                        var34 = var23;
                        var35 = var30 + (var28 * var27 >> 4);
                        var36 = var31 + (var28 * var26 >> 4);
                        var37 = var20;
                        if ((var32 = var35 - (this.field4959 << 12)) >= 0) {
                           var32 = (var27 - var32) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 = var23 + var32;
                        }

                        if ((var32 = (var35 - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        if (var36 < 0) {
                           var32 = (var26 - 1 - var36) / var26;
                           var37 += var32;
                           var35 += var27 * var32;
                           var36 += var26 * var32;
                           var34 += var32;
                        }

                        if ((var32 = (1 + var36 - (this.field4951 << 12) - var26) / var26) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                           if (var38 != 0) {
                              class481.field4992[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           var36 += var26;
                           ++var37;
                        }

                        ++var33;
                        var30 -= var26;
                        var31 += var27;
                     }
                  }
               } else if (var26 == 0) {
                  for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31;
                     var37 = var20;
                     if (var31 >= 0 && var31 - (this.field4951 << 12) < 0) {
                        if (var35 < 0) {
                           var32 = (var27 - 1 - var35) / var27;
                           var37 = var20 + var32;
                           var35 += var27 * var32;
                           var34 = var23 + var32;
                        }

                        if ((var32 = (1 + var35 - (this.field4959 << 12) - var27) / var27) > var37) {
                           var37 = var32;
                        }

                        while(var37 < 0) {
                           var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                           if (var38 != 0) {
                              class481.field4992[var34++] = var38;
                           } else {
                              ++var34;
                           }

                           var35 += var27;
                           ++var37;
                        }
                     }

                     ++var33;
                     var31 += var27;
                  }
               } else if (var26 < 0) {
                  for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31 + (var28 * var26 >> 4);
                     var37 = var20;
                     if (var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if ((var32 = (1 + var35 - (this.field4959 << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if ((var32 = var36 - (this.field4951 << 12)) >= 0) {
                        var32 = (var26 - var32) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if ((var32 = (var36 - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                        if (var38 != 0) {
                           class481.field4992[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               } else {
                  for(var33 = var22; var33 < 0; var23 += class481.field4993) {
                     var34 = var23;
                     var35 = var30 + (var28 * var27 >> 4);
                     var36 = var31 + (var28 * var26 >> 4);
                     var37 = var20;
                     if (var35 < 0) {
                        var32 = (var27 - 1 - var35) / var27;
                        var37 = var20 + var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 = var23 + var32;
                     }

                     if ((var32 = (1 + var35 - (this.field4959 << 12) - var27) / var27) > var37) {
                        var37 = var32;
                     }

                     if (var36 < 0) {
                        var32 = (var26 - 1 - var36) / var26;
                        var37 += var32;
                        var35 += var27 * var32;
                        var36 += var26 * var32;
                        var34 += var32;
                     }

                     if ((var32 = (1 + var36 - (this.field4951 << 12) - var26) / var26) > var37) {
                        var37 = var32;
                     }

                     while(var37 < 0) {
                        var38 = this.field4952[(var36 >> 12) * this.field4959 + (var35 >> 12)];
                        if (var38 != 0) {
                           class481.field4992[var34++] = var38;
                        } else {
                           ++var34;
                        }

                        var35 += var27;
                        var36 += var26;
                        ++var37;
                     }

                     ++var33;
                     var30 -= var26;
                     var31 += var27;
                  }
               }

            }
         }
      }
   }

   public void method8477(int var1, int var2, int var3, int var4) {
      if (var3 <= this.field4956 && var4 <= this.field4957) {
         int var5 = var1 + this.field4954 * var3 / this.field4956;
         int var6 = var1 + ((this.field4954 + this.field4959) * var3 + this.field4956 - 1) / this.field4956;
         int var7 = var2 + this.field4962 * var4 / this.field4957;
         int var8 = var2 + ((this.field4962 + this.field4951) * var4 + this.field4957 - 1) / this.field4957;
         if (var5 < class481.field4997) {
            var5 = class481.field4997;
         }

         if (var6 > class481.field4996) {
            var6 = class481.field4996;
         }

         if (var7 < class481.field4995) {
            var7 = class481.field4995;
         }

         if (var8 > class481.field4998) {
            var8 = class481.field4998;
         }

         if (var5 < var6 && var7 < var8) {
            int var9 = var7 * class481.field4993 + var5;
            int var10 = class481.field4993 - (var6 - var5);
            if (var9 < class481.field4992.length) {
               for(int var11 = var7; var11 < var8; ++var11) {
                  for(int var12 = var5; var12 < var6; ++var12) {
                     int var13 = var12 - var1 << 4;
                     int var14 = var11 - var2 << 4;
                     int var15 = var13 * this.field4956 / var3 - (this.field4954 << 4);
                     int var16 = (var13 + 16) * this.field4956 / var3 - (this.field4954 << 4);
                     int var17 = var14 * this.field4957 / var4 - (this.field4962 << 4);
                     int var18 = (var14 + 16) * this.field4957 / var4 - (this.field4962 << 4);
                     int var19 = (var16 - var15) * (var18 - var17) >> 1;
                     if (var19 != 0) {
                        if (var15 < 0) {
                           var15 = 0;
                        }

                        if (var16 >= this.field4959 << 4) {
                           var16 = this.field4959 << 4;
                        }

                        if (var17 < 0) {
                           var17 = 0;
                        }

                        if (var18 >= this.field4951 << 4) {
                           var18 = this.field4951 << 4;
                        }

                        --var16;
                        --var18;
                        int var20 = 16 - (var15 & 15);
                        int var21 = (var16 & 15) + 1;
                        int var22 = 16 - (var17 & 15);
                        int var23 = (var18 & 15) + 1;
                        var15 >>= 4;
                        var16 >>= 4;
                        var17 >>= 4;
                        var18 >>= 4;
                        int var24 = 0;
                        int var25 = 0;
                        int var26 = 0;
                        int var27 = 0;

                        int var28;
                        for(var28 = var17; var28 <= var18; ++var28) {
                           int var29 = 16;
                           if (var28 == var17) {
                              var29 = var22;
                           }

                           if (var28 == var18) {
                              var29 = var23;
                           }

                           for(int var30 = var15; var30 <= var16; ++var30) {
                              int var31 = this.field4952[var28 * this.field4959 + var30];
                              if (var31 != 0) {
                                 int var32;
                                 if (var30 == var15) {
                                    var32 = var29 * var20;
                                 } else if (var30 == var16) {
                                    var32 = var29 * var21;
                                 } else {
                                    var32 = var29 << 4;
                                 }

                                 var27 += var32;
                                 var24 += (var31 >> 16 & 255) * var32;
                                 var25 += (var31 >> 8 & 255) * var32;
                                 var26 += (var31 & 255) * var32;
                              }
                           }
                        }

                        if (var27 >= var19) {
                           var28 = (var24 / var27 << 16) + (var25 / var27 << 8) + var26 / var27;
                           if (var28 == 0) {
                              var28 = 1;
                           }

                           class481.field4992[var9] = var28;
                        }

                        ++var9;
                     }
                  }

                  var9 += var10;
               }

            }
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
