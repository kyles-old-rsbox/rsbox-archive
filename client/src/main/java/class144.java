public class class144 extends class140 {
   int field1326;
   int field1327;
   int field1328;
   int field1329;
   // $FF: synthetic field
   final class142 this$0;

   static float method2499(class106 var0, float var1) {
      if (var0 != null && var0.method2055() != 0) {
         if (var1 < (float)var0.field1061[0].field1153) {
            return class118.field1141 == var0.field1058 ? var0.field1061[0].field1150 : class394.method7163(var0, var1, true);
         } else if (var1 > (float)var0.field1061[var0.method2055() - 1].field1153) {
            return var0.field1057 == class118.field1141 ? var0.field1061[var0.method2055() - 1].field1150 : class394.method7163(var0, var1, false);
         } else if (var0.field1048) {
            return var0.field1061[0].field1150;
         } else {
            class119 var3 = var0.method2054(var1);
            boolean var4 = false;
            boolean var5 = false;
            if (null == var3) {
               return 0.0F;
            } else {
               if ((double)var3.field1154 == 0.0D && 0.0D == (double)var3.field1155) {
                  var4 = true;
               } else if (Float.MAX_VALUE == var3.field1154 && Float.MAX_VALUE == var3.field1155) {
                  var5 = true;
               } else if (var3.field1156 != null) {
                  if (var0.field1051) {
                     float[] var6 = new float[4];
                     float[] var7 = new float[4];
                     var6[0] = (float)var3.field1153;
                     var7[0] = var3.field1150;
                     var6[1] = var6[0] + 0.33333334F * var3.field1154;
                     var7[1] = 0.33333334F * var3.field1155 + var7[0];
                     var6[3] = (float)var3.field1156.field1153;
                     var7[3] = var3.field1156.field1150;
                     var6[2] = var6[3] - var3.field1156.field1152 * 0.33333334F;
                     var7[2] = var7[3] - var3.field1156.field1151 * 0.33333334F;
                     if (var0.field1049) {
                        if (null != var0) {
                           float var8 = var6[3] - var6[0];
                           if ((double)var8 != 0.0D) {
                              float var9 = var6[1] - var6[0];
                              float var10 = var6[2] - var6[0];
                              Float var11 = var9 / var8;
                              Float var12 = var10 / var8;
                              var0.field1052 = var11 == 0.33333334F && var12 == 0.6666667F;
                              float var13 = var11;
                              float var14 = var12;
                              if ((double)var11 < 0.0D) {
                                 var11 = 0.0F;
                              }

                              if ((double)var12 > 1.0D) {
                                 var12 = 1.0F;
                              }

                              if ((double)var11 > 1.0D || var12 < -1.0F) {
                                 Float var15 = var11;
                                 Float var16 = 1.0F - var12;
                                 if (var11 < 0.0F) {
                                    var15 = 0.0F;
                                 }

                                 if (var16 < 0.0F) {
                                    var16 = 0.0F;
                                 }

                                 if (var15 > 1.0F || var16 > 1.0F) {
                                    float var17 = (float)((double)(var15 * (var15 - 2.0F + var16)) + (double)var16 * ((double)var16 - 2.0D) + 1.0D);
                                    if (class127.field1227 + var17 > 0.0F) {
                                       class245.method4890(var15, var16);
                                    }
                                 }

                                 var16 = 1.0F - var16;
                              }

                              if (var11 != var13) {
                                 var6[1] = var6[0] + var11 * var8;
                                 if (0.0D != (double)var13) {
                                    var7[1] = var7[0] + (var7[1] - var7[0]) * var11 / var13;
                                 }
                              }

                              if (var12 != var14) {
                                 var6[2] = var6[0] + var12 * var8;
                                 if ((double)var14 != 1.0D) {
                                    var7[2] = (float)((double)var7[3] - (double)(var7[3] - var7[2]) * (1.0D - (double)var12) / (1.0D - (double)var14));
                                 }
                              }

                              var0.field1053 = var6[0];
                              var0.field1054 = var6[3];
                              float var27 = var11;
                              float var29 = var12;
                              float[] var28 = var0.field1055;
                              float var18 = var27 - 0.0F;
                              float var19 = var29 - var27;
                              float var20 = 1.0F - var29;
                              float var21 = var19 - var18;
                              var28[3] = var20 - var19 - var21;
                              var28[2] = var21 + var21 + var21;
                              var28[1] = var18 + var18 + var18;
                              var28[0] = 0.0F;
                              var18 = var7[0];
                              var19 = var7[1];
                              var20 = var7[2];
                              var21 = var7[3];
                              float[] var22 = var0.field1056;
                              float var23 = var19 - var18;
                              float var24 = var20 - var19;
                              float var25 = var21 - var20;
                              float var26 = var24 - var23;
                              var22[3] = var25 - var24 - var26;
                              var22[2] = var26 + var26 + var26;
                              var22[1] = var23 + var23 + var23;
                              var22[0] = var18;
                           }
                        }
                     } else {
                        class139.method2465(var0, var6, var7);
                     }

                     var0.field1051 = false;
                  }
               } else {
                  var4 = true;
               }

               if (var4) {
                  return var3.field1150;
               } else if (var5) {
                  return (float)var3.field1153 != var1 && var3.field1156 != null ? var3.field1156.field1150 : var3.field1150;
               } else {
                  return var0.field1049 ? class57.method1159(var0, var1) : class253.method5042(var0, var1);
               }
            }
         }
      } else {
         return 0.0F;
      }
   }

   class144(class142 var1) {
      this.this$0 = var1;
      this.field1326 = -1;
   }

   void method2467(class460 var1) {
      this.field1326 = var1.method8115();
      this.field1328 = var1.method8119();
      this.field1327 = var1.method8134();
      this.field1329 = var1.method8134();
   }

   void method2468(class148 var1) {
      var1.method2537(this.field1326, this.field1328, this.field1327, this.field1329);
   }

   static final int method2498(int var0, int var1, int var2) {
      int var4 = var0 >> 7;
      int var5 = var1 >> 7;
      if (var4 >= 0 && var5 >= 0 && var4 <= 103 && var5 <= 103) {
         int var6 = var2;
         if (var2 < 3 && 2 == (class82.field714[1][var4][var5] & 2)) {
            var6 = var2 + 1;
         }

         int var7 = var0 & 127;
         int var8 = var1 & 127;
         int var9 = class82.field719[var6][var4][var5] * (128 - var7) + var7 * class82.field719[var6][var4 + 1][var5] >> 7;
         int var10 = class82.field719[var6][1 + var4][1 + var5] * var7 + class82.field719[var6][var4][1 + var5] * (128 - var7) >> 7;
         return var10 * var8 + var9 * (128 - var8) >> 7;
      } else {
         return 0;
      }
   }
}
