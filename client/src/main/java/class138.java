public class class138 extends class140 {
   static class300 field1284;
   int field1278;
   int field1279;
   int field1280;
   int field1281;
   // $FF: synthetic field
   final class142 this$0;

   class138(class142 var1) {
      this.this$0 = var1;
   }

   void method2467(class460 var1) {
      this.field1281 = var1.method8119();
      this.field1280 = var1.method8119();
      this.field1278 = var1.method8134();
      this.field1279 = var1.method8134();
   }

   void method2468(class148 var1) {
      var1.method2539(this.field1281, this.field1280, this.field1278, this.field1279);
   }

   static final void method2457(int var0, int var1, int var2, int var3, int var4) {
      long var6 = class145.field1333.method4185(var0, var1, var2);
      int var8;
      int var9;
      int var10;
      int var11;
      int var13;
      int var14;
      if (0L != var6) {
         var8 = class145.field1333.method4156(var0, var1, var2, var6);
         var9 = var8 >> 6 & 3;
         var10 = var8 & 31;
         var11 = var3;
         if (class234.method5519(var6)) {
            var11 = var4;
         }

         int[] var12 = class309.field3678.field4952;
         var13 = 24624 + var1 * 4 + 2048 * (103 - var2);
         var14 = class234.method1610(var6);
         class195 var15 = class89.method1866(var14);
         if (var15.field2075 != -1) {
            class488 var16 = class91.field883[var15.field2075];
            if (var16 != null) {
               int var17 = (var15.field2100 * 4 - var16.field5017) / 2;
               int var18 = (var15.field2069 * 4 - var16.field5019) / 2;
               var16.method8748(48 + var1 * 4 + var17, var18 + 48 + 4 * (104 - var2 - var15.field2069));
            }
         } else {
            if (0 == var10 || 2 == var10) {
               if (var9 == 0) {
                  var12[var13] = var11;
                  var12[var13 + 512] = var11;
                  var12[1024 + var13] = var11;
                  var12[var13 + 1536] = var11;
               } else if (var9 == 1) {
                  var12[var13] = var11;
                  var12[1 + var13] = var11;
                  var12[2 + var13] = var11;
                  var12[3 + var13] = var11;
               } else if (var9 == 2) {
                  var12[3 + var13] = var11;
                  var12[var13 + 3 + 512] = var11;
                  var12[var13 + 3 + 1024] = var11;
                  var12[1536 + var13 + 3] = var11;
               } else if (3 == var9) {
                  var12[1536 + var13] = var11;
                  var12[1 + var13 + 1536] = var11;
                  var12[2 + 1536 + var13] = var11;
                  var12[1536 + var13 + 3] = var11;
               }
            }

            if (3 == var10) {
               if (var9 == 0) {
                  var12[var13] = var11;
               } else if (1 == var9) {
                  var12[var13 + 3] = var11;
               } else if (2 == var9) {
                  var12[3 + var13 + 1536] = var11;
               } else if (3 == var9) {
                  var12[1536 + var13] = var11;
               }
            }

            if (var10 == 2) {
               if (3 == var9) {
                  var12[var13] = var11;
                  var12[512 + var13] = var11;
                  var12[1024 + var13] = var11;
                  var12[1536 + var13] = var11;
               } else if (var9 == 0) {
                  var12[var13] = var11;
                  var12[var13 + 1] = var11;
                  var12[var13 + 2] = var11;
                  var12[3 + var13] = var11;
               } else if (1 == var9) {
                  var12[var13 + 3] = var11;
                  var12[512 + 3 + var13] = var11;
                  var12[3 + var13 + 1024] = var11;
                  var12[3 + var13 + 1536] = var11;
               } else if (2 == var9) {
                  var12[var13 + 1536] = var11;
                  var12[1 + 1536 + var13] = var11;
                  var12[2 + 1536 + var13] = var11;
                  var12[3 + var13 + 1536] = var11;
               }
            }
         }
      }

      var6 = class145.field1333.method4150(var0, var1, var2);
      if (0L != var6) {
         var8 = class145.field1333.method4156(var0, var1, var2, var6);
         var9 = var8 >> 6 & 3;
         var10 = var8 & 31;
         var11 = class234.method1610(var6);
         class195 var21 = class89.method1866(var11);
         int var25;
         if (var21.field2075 != -1) {
            class488 var23 = class91.field883[var21.field2075];
            if (var23 != null) {
               var14 = (var21.field2100 * 4 - var23.field5017) / 2;
               var25 = (var21.field2069 * 4 - var23.field5019) / 2;
               var23.method8748(48 + var1 * 4 + var14, var25 + (104 - var2 - var21.field2069) * 4 + 48);
            }
         } else if (9 == var10) {
            var13 = 15658734;
            if (class234.method5519(var6)) {
               var13 = 15597568;
            }

            int[] var24 = class309.field3678.field4952;
            var25 = 2048 * (103 - var2) + var1 * 4 + 24624;
            if (0 != var9 && 2 != var9) {
               var24[var25] = var13;
               var24[1 + var25 + 512] = var13;
               var24[1024 + var25 + 2] = var13;
               var24[3 + 1536 + var25] = var13;
            } else {
               var24[1536 + var25] = var13;
               var24[1 + var25 + 1024] = var13;
               var24[512 + var25 + 2] = var13;
               var24[var25 + 3] = var13;
            }
         }
      }

      var6 = class145.field1333.method4151(var0, var1, var2);
      if (0L != var6) {
         var8 = class234.method1610(var6);
         class195 var19 = class89.method1866(var8);
         if (var19.field2075 != -1) {
            class488 var20 = class91.field883[var19.field2075];
            if (var20 != null) {
               var11 = (var19.field2100 * 4 - var20.field5017) / 2;
               int var22 = (var19.field2069 * 4 - var20.field5019) / 2;
               var20.method8748(var1 * 4 + 48 + var11, var22 + (104 - var2 - var19.field2069) * 4 + 48);
            }
         }
      }

   }
}
