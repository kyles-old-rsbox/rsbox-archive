public class class288 extends class427 {
   byte[] field3350 = new byte[128];
   byte[] field3351 = new byte[128];
   byte[] field3353 = new byte[128];
   class286[] field3352 = new class286[128];
   RawSound[] rawSounds = new RawSound[128];
   int field3356;
   int[] field3354 = new int[128];
   short[] field3349 = new short[128];

   class288(byte[] var1) {
      class460 var2 = new class460(var1);

      int var3;
      for(var3 = 0; 0 != var2.field4881[var3 + var2.field4878]; ++var3) {
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.method8280();
      }

      ++var2.field4878;
      ++var3;
      var5 = var2.field4878;
      var2.field4878 += var3;

      int var6;
      for(var6 = 0; 0 != var2.field4881[var2.field4878 + var6]; ++var6) {
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.method8280();
      }

      ++var2.field4878;
      ++var6;
      var8 = var2.field4878;
      var2.field4878 += var6;

      int var9;
      for(var9 = 0; var2.field4881[var9 + var2.field4878] != 0; ++var9) {
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.method8280();
      }

      ++var2.field4878;
      ++var9;
      byte[] var36 = new byte[var9];
      int var12;
      int var14;
      if (var9 > 1) {
         var36[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.method8134();
            if (0 == var15) {
               var13 = var12++;
            } else {
               if (var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var36[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class286[] var37 = new class286[var12];

      class286 var38;
      for(var14 = 0; var14 < var37.length; ++var14) {
         var38 = var37[var14] = new class286();
         int var16 = var2.method8134();
         if (var16 > 0) {
            var38.field3341 = new byte[2 * var16];
         }

         var16 = var2.method8134();
         if (var16 > 0) {
            var38.field3339 = new byte[var16 * 2 + 2];
            var38.field3339[1] = 64;
         }
      }

      var14 = var2.method8134();
      byte[] var39 = var14 > 0 ? new byte[2 * var14] : null;
      var14 = var2.method8134();
      byte[] var40 = var14 > 0 ? new byte[2 * var14] : null;

      int var17;
      for(var17 = 0; var2.field4881[var17 + var2.field4878] != 0; ++var17) {
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.method8280();
      }

      ++var2.field4878;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method8134();
         this.field3349[var20] = (short)var19;
      }

      var19 = 0;

      short[] var48;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.method8134();
         var48 = this.field3349;
         var48[var20] = (short)(var48[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if (0 == var20) {
            if (var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.method8228();
         }

         var48 = this.field3349;
         var48[var23] = (short)(var48[var23] + ((var22 - 1 & 2) << 14));
         this.field3354[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if (this.field3354[var24] != 0) {
            if (var20 == 0) {
               if (var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.field4881[var5++] - 1;
            }

            this.field3353[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if (this.field3354[var25] != 0) {
            if (var20 == 0) {
               if (var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.field4881[var8++] + 16 << 2;
            }

            this.field3351[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class286 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if (0 != this.field3354[var26]) {
            if (var20 == 0) {
               var42 = var37[var36[var21]];
               if (var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field3352[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if (0 == var20) {
            if (var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if (this.field3354[var27] > 0) {
               var26 = var2.method8134() + 1;
            }
         }

         this.field3350[var27] = (byte)var26;
         --var20;
      }

      this.field3356 = var2.method8134() + 1;

      class286 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3341 != null) {
            for(var29 = 1; var29 < var28.field3341.length; var29 += 2) {
               var28.field3341[var29] = var2.method8280();
            }
         }

         if (null != var28.field3339) {
            for(var29 = 3; var29 < var28.field3339.length - 2; var29 += 2) {
               var28.field3339[var29] = var2.method8280();
            }
         }
      }

      if (null != var39) {
         for(var27 = 1; var27 < var39.length; var27 += 2) {
            var39[var27] = var2.method8280();
         }
      }

      if (var40 != null) {
         for(var27 = 1; var27 < var40.length; var27 += 2) {
            var40[var27] = var2.method8280();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3339 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3339.length; var29 += 2) {
               var19 = 1 + var19 + var2.method8134();
               var28.field3339[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3341 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field3341.length; var29 += 2) {
               var19 = 1 + var19 + var2.method8134();
               var28.field3341[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var45;
      byte var47;
      if (null != var39) {
         var19 = var2.method8134();
         var39[0] = (byte)var19;

         for(var27 = 2; var27 < var39.length; var27 += 2) {
            var19 = var19 + 1 + var2.method8134();
            var39[var27] = (byte)var19;
         }

         var47 = var39[0];
         byte var43 = var39[1];

         for(var29 = 0; var29 < var47; ++var29) {
            this.field3350[var29] = (byte)(this.field3350[var29] * var43 + 32 >> 6);
         }

         for(var29 = 2; var29 < var39.length; var29 += 2) {
            var30 = var39[var29];
            byte var31 = var39[1 + var29];
            var32 = (var30 - var47) * var43 + (var30 - var47) / 2;

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class282.method5210(var32, var30 - var47);
               this.field3350[var33] = (byte)(32 + this.field3350[var33] * var34 >> 6);
               var32 += var31 - var43;
            }

            var47 = var30;
            var43 = var31;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            this.field3350[var45] = (byte)(32 + var43 * this.field3350[var45] >> 6);
         }

         var38 = null;
      }

      if (null != var40) {
         var19 = var2.method8134();
         var40[0] = (byte)var19;

         for(var27 = 2; var27 < var40.length; var27 += 2) {
            var19 = var19 + 1 + var2.method8134();
            var40[var27] = (byte)var19;
         }

         var47 = var40[0];
         int var44 = var40[1] << 1;

         for(var29 = 0; var29 < var47; ++var29) {
            var45 = (this.field3351[var29] & 255) + var44;
            if (var45 < 0) {
               var45 = 0;
            }

            if (var45 > 128) {
               var45 = 128;
            }

            this.field3351[var29] = (byte)var45;
         }

         int var46;
         for(var29 = 2; var29 < var40.length; var29 += 2) {
            var30 = var40[var29];
            var46 = var40[1 + var29] << 1;
            var32 = (var30 - var47) / 2 + var44 * (var30 - var47);

            for(var33 = var47; var33 < var30; ++var33) {
               var34 = class282.method5210(var32, var30 - var47);
               int var35 = var34 + (this.field3351[var33] & 255);
               if (var35 < 0) {
                  var35 = 0;
               }

               if (var35 > 128) {
                  var35 = 128;
               }

               this.field3351[var33] = (byte)var35;
               var32 += var46 - var44;
            }

            var47 = var30;
            var44 = var46;
         }

         for(var45 = var47; var45 < 128; ++var45) {
            var46 = var44 + (this.field3351[var45] & 255);
            if (var46 < 0) {
               var46 = 0;
            }

            if (var46 > 128) {
               var46 = 128;
            }

            this.field3351[var45] = (byte)var46;
         }

         Object var41 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field3335 = var2.method8134();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3341 != null) {
            var28.field3336 = var2.method8134();
         }

         if (var28.field3339 != null) {
            var28.field3337 = var2.method8134();
         }

         if (var28.field3335 > 0) {
            var28.field3338 = var2.method8134();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var37[var27].field3340 = var2.method8134();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3340 > 0) {
            var28.field3333 = var2.method8134();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var37[var27];
         if (var28.field3333 > 0) {
            var28.field3334 = var2.method8134();
         }
      }

   }

   boolean method5455(SoundCache var1, byte[] var2, int[] var3) {
      boolean var5 = true;
      int var6 = 0;
      RawSound var7 = null;

      for(int i = 0; i < 128; ++i) {
         if (var2 == null || 0 != var2[i]) {
            int var9 = this.field3354[i];
            if (var9 != 0) {
               if (var6 != var9) {
                  var6 = var9--;
                  if ((var9 & 1) == 0) {
                     var7 = var1.getSoundEffect(var9 >> 2, var3);
                  } else {
                     var7 = var1.getMusicSample(var9 >> 2, var3);
                  }

                  if (null == var7) {
                     var5 = false;
                  }
               }

               if (var7 != null) {
                  this.rawSounds[i] = var7;
                  this.field3354[i] = 0;
               }
            }
         }
      }

      return var5;
   }

   void method5454() {
      this.field3354 = null;
   }
}
