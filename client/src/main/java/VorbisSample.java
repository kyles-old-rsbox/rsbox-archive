public class VorbisSample extends class427 {
   static boolean field464 = false;
   static boolean[] field447;
   static byte[] VarbisSoundBytes;
   static class46[] field460;
   static class50[] field474;
   static class52[] field459;
   static class76[] field458;
   static float[] field449;
   static float[] field453;
   static float[] field470;
   static float[] field471;
   static float[] field472;
   static float[] field473;
   static float[] field475;
   static int VarbisSoundByteOffset;
   static int field456;
   static int field457;
   static int VarbisSoundBitOffset;
   static int[] field455;
   static int[] field463;
   static int[] field477;
   boolean field452;
   boolean field462;
   byte[] field478;
   byte[][] field480;
   float[] field465;
   int field448;
   int field450;
   int field451;
   int field466;
   int field467;
   int field469;
   int field476;
   int field479;

   static float method1331(int var0) {
      int var1 = var0 & 2097151;
      int var2 = var0 & Integer.MIN_VALUE;
      int var3 = (var0 & 2145386496) >> 21;
      if (var2 != 0) {
         var1 = -var1;
      }

      return (float)((double)var1 * Math.pow(2.0D, (double)(var3 - 788)));
   }

   static void setData(byte[] var0, int var1) {
      VarbisSoundBytes = var0;
      VarbisSoundByteOffset = var1;
      VarbisSoundBitOffset = 0;
   }

   static int method1299() {
      int var0 = VarbisSoundBytes[VarbisSoundByteOffset] >> VarbisSoundBitOffset & 1;
      ++VarbisSoundBitOffset;
      VarbisSoundByteOffset += VarbisSoundBitOffset >> 3;
      VarbisSoundBitOffset &= 7;
      return var0;
   }

   static int readBits(int numberOfBits) {
      int result = 0;

      int i;
      int bitPos;
      for(i = 0; numberOfBits >= 8 - VarbisSoundBitOffset; numberOfBits -= bitPos) {
         bitPos = 8 - VarbisSoundBitOffset;
         int var4 = (1 << bitPos) - 1;
         result += (VarbisSoundBytes[VarbisSoundByteOffset] >> VarbisSoundBitOffset & var4) << i;
         VarbisSoundBitOffset = 0;
         ++VarbisSoundByteOffset;
         i += bitPos;
      }

      if (numberOfBits > 0) {
         bitPos = (1 << numberOfBits) - 1;
         result += (VarbisSoundBytes[VarbisSoundByteOffset] >> VarbisSoundBitOffset & bitPos) << i;
         VarbisSoundBitOffset += numberOfBits;
      }

      return result;
   }

   void method1317(byte[] var1) {
      class460 var2 = new class460(var1);
      this.field469 = var2.method8119();
      this.field466 = var2.method8119();
      this.field450 = var2.method8119();
      this.field451 = var2.method8119();
      if (this.field451 < 0) {
         this.field451 = ~this.field451;
         this.field452 = true;
      }

      int var3 = var2.method8119();
      this.field480 = new byte[var3][];

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = 0;

         int var6;
         do {
            var6 = var2.method8134();
            var5 += var6;
         } while(var6 >= 255);

         byte[] var7 = new byte[var5];
         var2.method8326(var7, 0, var5);
         this.field480[var4] = var7;
      }

   }

   static void method1302(byte[] var0) {
      setData(var0, 0);
      field456 = 1 << readBits(4);
      field457 = 1 << readBits(4);
      field453 = new float[field457];

      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < 2; ++var1) {
         var2 = var1 != 0 ? field457 : field456;
         var3 = var2 >> 1;
         var4 = var2 >> 2;
         var5 = var2 >> 3;
         float[] var6 = new float[var3];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[2 * var7] = (float)Math.cos((double)(4 * var7) * 3.141592653589793D / (double)var2);
            var6[2 * var7 + 1] = -((float)Math.sin((double)(4 * var7) * 3.141592653589793D / (double)var2));
         }

         float[] var19 = new float[var3];

         for(int var8 = 0; var8 < var4; ++var8) {
            var19[2 * var8] = (float)Math.cos((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
            var19[2 * var8 + 1] = (float)Math.sin((double)(2 * var8 + 1) * 3.141592653589793D / (double)(2 * var2));
         }

         float[] var20 = new float[var4];

         for(int var9 = 0; var9 < var5; ++var9) {
            var20[2 * var9] = (float)Math.cos((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2);
            var20[2 * var9 + 1] = -((float)Math.sin((double)(4 * var9 + 2) * 3.141592653589793D / (double)var2));
         }

         int[] var21 = new int[var5];
         int var10 = class8.method51(var5 - 1);

         for(int var11 = 0; var11 < var5; ++var11) {
            int var15 = var11;
            int var16 = var10;

            int var17;
            for(var17 = 0; var16 > 0; --var16) {
               var17 = var17 << 1 | var15 & 1;
               var15 >>>= 1;
            }

            var21[var11] = var17;
         }

         if (var1 != 0) {
            field473 = var6;
            field449 = var19;
            field475 = var20;
            field477 = var21;
         } else {
            field470 = var6;
            field471 = var19;
            field472 = var20;
            field455 = var21;
         }
      }

      var1 = readBits(8) + 1;
      field458 = new class76[var1];

      for(var2 = 0; var2 < var1; ++var2) {
         field458[var2] = new class76();
      }

      var2 = readBits(6) + 1;

      for(var3 = 0; var3 < var2; ++var3) {
         readBits(16);
      }

      var2 = readBits(6) + 1;
      field459 = new class52[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         field459[var3] = new class52();
      }

      var3 = readBits(6) + 1;
      field460 = new class46[var3];

      for(var4 = 0; var4 < var3; ++var4) {
         field460[var4] = new class46();
      }

      var4 = readBits(6) + 1;
      field474 = new class50[var4];

      for(var5 = 0; var5 < var4; ++var5) {
         field474[var5] = new class50();
      }

      var5 = readBits(6) + 1;
      field447 = new boolean[var5];
      field463 = new int[var5];

      for(int var18 = 0; var18 < var5; ++var18) {
         field447[var18] = method1299() != 0;
         readBits(16);
         readBits(16);
         field463[var18] = readBits(8);
      }

   }

   float[] method1303(int var1) {
      setData(this.field480[var1], 0);
      method1299();
      int var2 = readBits(class8.method51(field463.length - 1));
      boolean var3 = field447[var2];
      int var4 = var3 ? field457 : field456;
      boolean var5 = false;
      boolean var6 = false;
      if (var3) {
         var5 = method1299() != 0;
         var6 = method1299() != 0;
      }

      int var7 = var4 >> 1;
      int var8;
      int var9;
      int var10;
      if (var3 && !var5) {
         var8 = (var4 >> 2) - (field456 >> 2);
         var9 = (var4 >> 2) + (field456 >> 2);
         var10 = field456 >> 1;
      } else {
         var8 = 0;
         var9 = var7;
         var10 = var4 >> 1;
      }

      int var11;
      int var12;
      int var13;
      if (var3 && !var6) {
         var11 = var4 - (var4 >> 2) - (field456 >> 2);
         var12 = var4 - (var4 >> 2) + (field456 >> 2);
         var13 = field456 >> 1;
      } else {
         var11 = var7;
         var12 = var4;
         var13 = var4 >> 1;
      }

      class50 var14 = field474[field463[var2]];
      int var16 = var14.field355;
      int var17 = var14.field352[var16];
      boolean var15 = !field459[var17].method1032();
      boolean var40 = var15;

      for(var17 = 0; var17 < var14.field353; ++var17) {
         class46 var18 = field460[var14.field354[var17]];
         float[] var19 = field453;
         var18.method954(var19, var4 >> 1, var40);
      }

      int var41;
      if (!var15) {
         var17 = var14.field355;
         var41 = var14.field352[var17];
         field459[var41].method1041(field453, var4 >> 1);
      }

      int var42;
      if (var15) {
         for(var17 = var4 >> 1; var17 < var4; ++var17) {
            field453[var17] = 0.0F;
         }
      } else {
         var17 = var4 >> 1;
         var41 = var4 >> 2;
         var42 = var4 >> 3;
         float[] var20 = field453;

         int var21;
         for(var21 = 0; var21 < var17; ++var21) {
            var20[var21] *= 0.5F;
         }

         for(var21 = var17; var21 < var4; ++var21) {
            var20[var21] = -var20[var4 - var21 - 1];
         }

         float[] var46 = var3 ? field473 : field470;
         float[] var22 = var3 ? field449 : field471;
         float[] var23 = var3 ? field475 : field472;
         int[] var24 = var3 ? field477 : field455;

         int var25;
         float var26;
         float var27;
         float var28;
         float var29;
         for(var25 = 0; var25 < var41; ++var25) {
            var26 = var20[4 * var25] - var20[var4 - 4 * var25 - 1];
            var27 = var20[4 * var25 + 2] - var20[var4 - 4 * var25 - 3];
            var28 = var46[2 * var25];
            var29 = var46[2 * var25 + 1];
            var20[var4 - 4 * var25 - 1] = var26 * var28 - var27 * var29;
            var20[var4 - 4 * var25 - 3] = var26 * var29 + var27 * var28;
         }

         float var30;
         float var31;
         for(var25 = 0; var25 < var42; ++var25) {
            var26 = var20[var17 + 3 + 4 * var25];
            var27 = var20[var17 + 1 + 4 * var25];
            var28 = var20[4 * var25 + 3];
            var29 = var20[4 * var25 + 1];
            var20[var17 + 3 + 4 * var25] = var26 + var28;
            var20[var17 + 1 + 4 * var25] = var27 + var29;
            var30 = var46[var17 - 4 - 4 * var25];
            var31 = var46[var17 - 3 - 4 * var25];
            var20[4 * var25 + 3] = (var26 - var28) * var30 - (var27 - var29) * var31;
            var20[4 * var25 + 1] = (var27 - var29) * var30 + (var26 - var28) * var31;
         }

         var25 = class8.method51(var4 - 1);

         int var47;
         int var48;
         int var49;
         int var50;
         for(var47 = 0; var47 < var25 - 3; ++var47) {
            var48 = var4 >> var47 + 2;
            var49 = 8 << var47;

            for(var50 = 0; var50 < 2 << var47; ++var50) {
               int var51 = var4 - var48 * 2 * var50;
               int var52 = var4 - var48 * (2 * var50 + 1);

               for(int var32 = 0; var32 < var4 >> var47 + 4; ++var32) {
                  int var33 = 4 * var32;
                  float var34 = var20[var51 - 1 - var33];
                  float var35 = var20[var51 - 3 - var33];
                  float var36 = var20[var52 - 1 - var33];
                  float var37 = var20[var52 - 3 - var33];
                  var20[var51 - 1 - var33] = var34 + var36;
                  var20[var51 - 3 - var33] = var35 + var37;
                  float var38 = var46[var32 * var49];
                  float var39 = var46[var32 * var49 + 1];
                  var20[var52 - 1 - var33] = (var34 - var36) * var38 - (var35 - var37) * var39;
                  var20[var52 - 3 - var33] = (var35 - var37) * var38 + (var34 - var36) * var39;
               }
            }
         }

         for(var47 = 1; var47 < var42 - 1; ++var47) {
            var48 = var24[var47];
            if (var47 < var48) {
               var49 = 8 * var47;
               var50 = 8 * var48;
               var30 = var20[var49 + 1];
               var20[var49 + 1] = var20[var50 + 1];
               var20[var50 + 1] = var30;
               var30 = var20[var49 + 3];
               var20[var49 + 3] = var20[var50 + 3];
               var20[var50 + 3] = var30;
               var30 = var20[var49 + 5];
               var20[var49 + 5] = var20[var50 + 5];
               var20[var50 + 5] = var30;
               var30 = var20[var49 + 7];
               var20[var49 + 7] = var20[var50 + 7];
               var20[var50 + 7] = var30;
            }
         }

         for(var47 = 0; var47 < var17; ++var47) {
            var20[var47] = var20[2 * var47 + 1];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var20[var4 - 1 - 2 * var47] = var20[4 * var47];
            var20[var4 - 2 - 2 * var47] = var20[4 * var47 + 1];
            var20[var4 - var41 - 1 - 2 * var47] = var20[4 * var47 + 2];
            var20[var4 - var41 - 2 - 2 * var47] = var20[4 * var47 + 3];
         }

         for(var47 = 0; var47 < var42; ++var47) {
            var27 = var23[2 * var47];
            var28 = var23[2 * var47 + 1];
            var29 = var20[var17 + 2 * var47];
            var30 = var20[var17 + 2 * var47 + 1];
            var31 = var20[var4 - 2 - 2 * var47];
            float var53 = var20[var4 - 1 - 2 * var47];
            float var54 = var28 * (var29 - var31) + var27 * (var30 + var53);
            var20[var17 + 2 * var47] = (var29 + var31 + var54) * 0.5F;
            var20[var4 - 2 - 2 * var47] = (var29 + var31 - var54) * 0.5F;
            var54 = var28 * (var30 + var53) - var27 * (var29 - var31);
            var20[var17 + 2 * var47 + 1] = (var30 - var53 + var54) * 0.5F;
            var20[var4 - 1 - 2 * var47] = (-var30 + var53 + var54) * 0.5F;
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var47] = var20[2 * var47 + var17] * var22[2 * var47] + var20[2 * var47 + 1 + var17] * var22[2 * var47 + 1];
            var20[var17 - 1 - var47] = var20[2 * var47 + var17] * var22[2 * var47 + 1] - var20[2 * var47 + 1 + var17] * var22[2 * var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var4 - var41 + var47] = -var20[var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var47] = var20[var41 + var47];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var41 + var47] = -var20[var41 - var47 - 1];
         }

         for(var47 = 0; var47 < var41; ++var47) {
            var20[var17 + var47] = var20[var4 - var47 - 1];
         }

         float[] var10000;
         for(var47 = var8; var47 < var9; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var8) + 0.5D) / (double)var10 * 0.5D * 3.141592653589793D);
            var10000 = field453;
            var10000[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }

         for(var47 = var11; var47 < var12; ++var47) {
            var27 = (float)Math.sin(((double)(var47 - var11) + 0.5D) / (double)var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
            var10000 = field453;
            var10000[var47] *= (float)Math.sin(1.5707963267948966D * (double)var27 * (double)var27);
         }
      }

      float[] var43 = null;
      if (this.field479 > 0) {
         var41 = this.field479 + var4 >> 2;
         var43 = new float[var41];
         int var45;
         if (!this.field462) {
            for(var42 = 0; var42 < this.field467; ++var42) {
               var45 = (this.field479 >> 1) + var42;
               var43[var42] += this.field465[var45];
            }
         }

         if (!var15) {
            for(var42 = var8; var42 < var4 >> 1; ++var42) {
               var45 = var43.length - (var4 >> 1) + var42;
               var43[var45] += field453[var42];
            }
         }
      }

      float[] var44 = this.field465;
      this.field465 = field453;
      field453 = var44;
      this.field479 = var4;
      this.field467 = var12 - (var4 >> 1);
      this.field462 = var15;
      return var43;
   }

   static boolean method1304(class319 var0) {
      if (!field464) {
         byte[] var1 = var0.method6167(0, 0);
         if (var1 == null) {
            return false;
         }

         method1302(var1);
         field464 = true;
      }

      return true;
   }

   static VorbisSample readMusicSample(class319 var0, int var1, int var2) {
      if (!method1304(var0)) {
         var0.method6081(var1, var2);
         return null;
      } else {
         byte[] var3 = var0.method6167(var1, var2);
         return var3 == null ? null : new VorbisSample(var3);
      }
   }

   VorbisSample(byte[] var1) {
      this.method1317(var1);
   }

   RawSound toRawSound(int[] var1) {
      if (var1 != null && var1[0] <= 0) {
         return null;
      } else {
         if (this.field478 == null) {
            this.field479 = 0;
            this.field465 = new float[field457];
            this.field478 = new byte[this.field466];
            this.field476 = 0;
            this.field448 = 0;
         }

         for(; this.field448 < this.field480.length; ++this.field448) {
            if (var1 != null && var1[0] <= 0) {
               return null;
            }

            float[] var2 = this.method1303(this.field448);
            if (var2 != null) {
               int var3 = this.field476;
               int var4 = var2.length;
               if (var4 > this.field466 - var3) {
                  var4 = this.field466 - var3;
               }

               for(int var5 = 0; var5 < var4; ++var5) {
                  int var6 = (int)(128.0F + var2[var5] * 128.0F);
                  if ((var6 & -256) != 0) {
                     var6 = ~var6 >> 31;
                  }

                  this.field478[var3++] = (byte)(var6 - 128);
               }

               if (var1 != null) {
                  var1[0] -= var3 - this.field476;
               }

               this.field476 = var3;
            }
         }

         this.field465 = null;
         byte[] var7 = this.field478;
         this.field478 = null;
         return new RawSound(this.field469, var7, this.field450, this.field451, this.field452);
      }
   }
}
