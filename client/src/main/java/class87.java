public class class87 extends class427 {
   static boolean field781;
   static class434 field782 = new class434(32);
   int[] field779 = new int[]{-1};
   int[] field783 = new int[]{0};

   class87() {
   }

   public static boolean method1851(int var0) {
      return class306.field3669.field3670 == var0;
   }

   static void method2410() {
      field782 = new class434(32);
   }

   static class121 method1855(int var0) {
      class121 var2 = (class121)class217.method4362(class121.method135(), var0);
      if (var2 == null) {
         var2 = class121.field1170;
      }

      return var2;
   }

   static int method1849(int var0, class78 var1, boolean var2) {
      boolean var4 = true;
      class300 var5;
      if (var0 >= 2000) {
         var0 -= 1000;
         var5 = class282.method5426(class57.field404[--class387.field4452]);
         var4 = false;
      } else {
         var5 = var2 ? class138.field1284 : class153.field1414;
      }

      int var10;
      if (var0 == 1300) {
         var10 = class57.field404[--class387.field4452] - 1;
         if (var10 >= 0 && var10 <= 9) {
            var5.method5852(var10, class57.field405[--class126.field1220]);
            return 1;
         } else {
            --class126.field1220;
            return 1;
         }
      } else {
         int var11;
         if (1301 == var0) {
            class387.field4452 -= 2;
            var10 = class57.field404[class387.field4452];
            var11 = class57.field404[1 + class387.field4452];
            var5.field3547 = class253.method5043(var10, var11);
            return 1;
         } else if (1302 == var0) {
            var5.field3550 = class57.field404[--class387.field4452] == 1;
            return 1;
         } else if (1303 == var0) {
            var5.field3600 = class57.field404[--class387.field4452];
            return 1;
         } else if (var0 == 1304) {
            var5.field3604 = class57.field404[--class387.field4452];
            return 1;
         } else if (var0 == 1305) {
            var5.field3545 = class57.field405[--class126.field1220];
            return 1;
         } else if (1306 == var0) {
            var5.field3515 = class57.field405[--class126.field1220];
            return 1;
         } else if (var0 == 1307) {
            var5.field3546 = null;
            return 1;
         } else if (1308 == var0) {
            var5.field3614 = class57.field404[--class387.field4452] == 1;
            return 1;
         } else if (var0 == 1309) {
            --class387.field4452;
            return 1;
         } else {
            byte[] var7;
            int var8;
            if (var0 != 1350) {
               byte var9;
               if (1351 == var0) {
                  class387.field4452 -= 2;
                  var9 = 10;
                  var7 = new byte[]{(byte)class57.field404[class387.field4452]};
                  byte[] var12 = new byte[]{(byte)class57.field404[1 + class387.field4452]};
                  class227.method4512(var5, var9, var7, var12);
                  return 1;
               } else if (1352 == var0) {
                  class387.field4452 -= 3;
                  var10 = class57.field404[class387.field4452] - 1;
                  var11 = class57.field404[class387.field4452 + 1];
                  var8 = class57.field404[2 + class387.field4452];
                  if (var10 >= 0 && var10 <= 9) {
                     class57.method2259(var5, var10, var11, var8);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (var0 == 1353) {
                  var9 = 10;
                  var11 = class57.field404[--class387.field4452];
                  var8 = class57.field404[--class387.field4452];
                  class57.method2259(var5, var9, var11, var8);
                  return 1;
               } else if (var0 == 1354) {
                  --class387.field4452;
                  var10 = class57.field404[class387.field4452] - 1;
                  if (var10 >= 0 && var10 <= 9) {
                     class57.method6451(var5, var10);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (1355 == var0) {
                  var9 = 10;
                  class57.method6451(var5, var9);
                  return 1;
               } else {
                  return 2;
               }
            } else {
               byte[] var6 = null;
               var7 = null;
               if (var4) {
                  class387.field4452 -= 10;

                  for(var8 = 0; var8 < 10 && class57.field404[var8 + class387.field4452] >= 0; var8 += 2) {
                  }

                  if (var8 > 0) {
                     var6 = new byte[var8 / 2];
                     var7 = new byte[var8 / 2];

                     for(var8 -= 2; var8 >= 0; var8 -= 2) {
                        var6[var8 / 2] = (byte)class57.field404[var8 + class387.field4452];
                        var7[var8 / 2] = (byte)class57.field404[1 + var8 + class387.field4452];
                     }
                  }
               } else {
                  class387.field4452 -= 2;
                  var6 = new byte[]{(byte)class57.field404[class387.field4452]};
                  var7 = new byte[]{(byte)class57.field404[class387.field4452 + 1]};
               }

               var8 = class57.field404[--class387.field4452] - 1;
               if (var8 >= 0 && var8 <= 9) {
                  class227.method4512(var5, var8, var6, var7);
                  return 1;
               } else {
                  throw new RuntimeException();
               }
            }
         }
      }
   }
}
