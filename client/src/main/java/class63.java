public class class63 extends class437 {
   class410 field501;
   class410 field502;
   class472 field499;
   int field495;
   int field496;
   int field497;
   String field498;
   String field500;
   String field503;

   class63(int var1, String var2, String var3, String var4) {
      this.field502 = class410.field4554;
      this.field501 = class410.field4554;
      this.method1341(var1, var2, var3, var4);
   }

   void method1341(int var1, String var2, String var3, String var4) {
      this.field496 = class110.method7839();
      this.field495 = client.field1645;
      this.field497 = var1;
      this.field500 = var2;
      this.method1348();
      this.field498 = var3;
      this.field503 = var4;
      this.method1342();
      this.method1345();
   }

   void method1342() {
      this.field502 = class410.field4554;
   }

   final boolean method1343() {
      if (class410.field4554 == this.field502) {
         this.method1344();
      }

      return this.field502 == class410.field4551;
   }

   void method1344() {
      this.field502 = class217.field2588.field380.method7352(this.field499) ? class410.field4551 : class410.field4552;
   }

   void method1345() {
      this.field501 = class410.field4554;
   }

   final boolean method1346() {
      if (this.field501 == class410.field4554) {
         this.method1364();
      }

      return this.field501 == class410.field4551;
   }

   void method1364() {
      this.field501 = class217.field2588.field376.method7352(this.field499) ? class410.field4551 : class410.field4552;
   }

   final void method1348() {
      if (this.field500 != null) {
         this.field499 = new class472(class208.method3985(this.field500), class234.field2779);
      } else {
         this.field499 = null;
      }

   }

   static int method1365(int var0, class78 var1, boolean var2) {
      if (var0 == 6754) {
         int var4 = class57.field404[--class387.field4452];
         class203 var5 = class158.method2632(var4);
         class57.field405[++class126.field1220 - 1] = var5 != null ? var5.field2261 : "";
         return 1;
      } else {
         return 2;
      }
   }

   static final void method1361(class300 var0, int var1, int var2) {
      if (var0.field3463 == 1) {
         client.method1556(var0.field3595, "", 24, 0, 0, var0.field3517, var0.field3445);
      }

      String var4;
      if (var0.field3463 == 2 && !client.field1804) {
         var4 = class323.method6195(var0);
         if (var4 != null) {
            client.method1556(var4, class96.method4510(65280) + var0.field3594, 25, 0, -1, var0.field3517, var0.field3445);
         }
      }

      if (var0.field3463 == 3) {
         client.method351(class338.field4063, "", 26, 0, 0, var0.field3517);
      }

      if (4 == var0.field3463) {
         client.method351(var0.field3595, "", 28, 0, 0, var0.field3517);
      }

      if (5 == var0.field3463) {
         client.method351(var0.field3595, "", 29, 0, 0, var0.field3517);
      }

      if (var0.field3463 == 6 && client.field1641 == null) {
         client.method351(var0.field3595, "", 30, 0, -1, var0.field3517);
      }

      int var5;
      int var6;
      int var18;
      if (var0.field3462 == 2) {
         var18 = 0;

         for(var5 = 0; var5 < var0.field3476; ++var5) {
            for(var6 = 0; var6 < var0.field3448; ++var6) {
               int var7 = var6 * (var0.field3528 + 32);
               int var8 = var5 * (var0.field3529 + 32);
               if (var18 < 20) {
                  var7 += var0.field3530[var18];
                  var8 += var0.field3531[var18];
               }

               if (var1 >= var7 && var2 >= var8 && var1 < var7 + 32 && var2 < 32 + var8) {
                  client.field1892 = var18;
                  class165.field1523 = var0;
                  if (var0.field3461[var18] > 0) {
                     label310: {
                        class198 var9 = class278.method5388(var0.field3461[var18] - 1);
                        boolean var10;
                        int var11;
                        if (1 == client.field1802) {
                           var11 = class190.method3528(var0);
                           var10 = (var11 >> 30 & 1) != 0;
                           if (var10) {
                              if (class213.field2493 != var0.field3517 || class6.field23 != var18) {
                                 client.method1556(class338.field3898, client.field1803 + " " + class96.field963 + " " + class96.method4510(16748608) + var9.field2131, 31, 0, var18, var0.field3517, var9.field2129);
                              }
                              break label310;
                           }
                        }

                        if (client.field1804) {
                           var11 = class190.method3528(var0);
                           var10 = 0 != (var11 >> 30 & 1);
                           if (var10) {
                              if (16 == (class120.field1161 & 16)) {
                                 client.method1556(client.field1653, client.field1754 + " " + class96.field963 + " " + class96.method4510(16748608) + var9.field2131, 32, 0, var18, var0.field3517, var9.field2129);
                              }
                              break label310;
                           }
                        }

                        String[] var23 = var9.field2149;
                        var11 = -1;
                        if (client.field1648 && class179.method2842()) {
                           var11 = var9.method3658();
                        }

                        int var13 = class190.method3528(var0);
                        boolean var12 = (var13 >> 30 & 1) != 0;
                        if (var12) {
                           for(int var14 = 4; var14 >= 3; --var14) {
                              if (var14 != var11) {
                                 class153.method2595(var0, var9, var18, var14, false);
                              }
                           }
                        }

                        class290 var10000 = (class290)null;
                        if (class290.method5432(class190.method3528(var0))) {
                           client.method1556(class338.field3898, class96.method4510(16748608) + var9.field2131, 38, 0, var18, var0.field3517, var9.field2129);
                        }

                        int var15 = class190.method3528(var0);
                        boolean var24 = (var15 >> 30 & 1) != 0;
                        int var16;
                        if (var24) {
                           for(var16 = 2; var16 >= 0; --var16) {
                              if (var11 != var16) {
                                 class153.method2595(var0, var9, var18, var16, false);
                              }
                           }

                           if (var11 >= 0) {
                              class153.method2595(var0, var9, var18, var11, true);
                           }
                        }

                        var23 = var0.field3533;
                        if (null != var23) {
                           for(var16 = 4; var16 >= 0; --var16) {
                              if (null != var23[var16]) {
                                 byte var17 = 0;
                                 if (var16 == 0) {
                                    var17 = 39;
                                 }

                                 if (1 == var16) {
                                    var17 = 40;
                                 }

                                 if (2 == var16) {
                                    var17 = 41;
                                 }

                                 if (3 == var16) {
                                    var17 = 42;
                                 }

                                 if (var16 == 4) {
                                    var17 = 43;
                                 }

                                 client.method1556(var23[var16], class96.method4510(16748608) + var9.field2131, var17, 0, var18, var0.field3517, var9.field2129);
                              }
                           }
                        }

                        client.method1556(class338.field4182, class96.method4510(16748608) + var9.field2131, 1005, 0, var18, var0.field3517, var9.field2129);
                     }
                  }
               }

               ++var18;
            }
         }
      }

      if (var0.field3459) {
         if (client.field1804) {
            var5 = class190.method3528(var0);
            boolean var19 = 0 != (var5 >> 21 & 1);
            if (var19 && (class120.field1161 & 32) == 32) {
               client.method1556(client.field1653, client.field1754 + " " + class96.field963 + " " + var0.field3545, 58, 0, var0.field3484, var0.field3517, var0.field3445);
            }
         } else {
            for(var18 = 9; var18 >= 5; --var18) {
               String var20 = class374.method6775(var0, var18);
               if (var20 != null) {
                  client.method1556(var20, var0.field3545, 1007, 1 + var18, var0.field3484, var0.field3517, var0.field3445);
               }
            }

            var4 = class323.method6195(var0);
            if (null != var4) {
               client.method1556(var4, var0.field3545, 25, 0, var0.field3484, var0.field3517, var0.field3445);
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var21 = class374.method6775(var0, var5);
               if (null != var21) {
                  class105.method2042(var21, var0.field3545, 57, 1 + var5, var0.field3484, var0.field3517, var0.field3445, var0.field3614);
               }
            }

            var6 = class190.method3528(var0);
            boolean var22 = 0 != (var6 & 1);
            if (var22) {
               client.method351(class338.field3897, "", 30, 0, var0.field3484, var0.field3517);
            }
         }
      }

   }
}
