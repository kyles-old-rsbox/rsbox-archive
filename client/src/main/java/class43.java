import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class class43 extends class427 {
   static class336 field311;
   byte[][][] field306;
   int field307;
   int field309;
   int[] field300;
   int[] field301;
   int[] field304;
   Field[] field303;
   Method[] field305;

   class43() {
   }

   static final void method802() {
      class318.method6075(false);
      client.field1700 = 0;
      boolean var1 = true;

      int var2;
      for(var2 = 0; var2 < class74.field612.length; ++var2) {
         if (class136.field1271[var2] != -1 && class74.field612[var2] == null) {
            class74.field612[var2] = class58.field417.method6167(class136.field1271[var2], 0);
            if (class74.field612[var2] == null) {
               var1 = false;
               ++client.field1700;
            }
         }

         if (class2.field1[var2] != -1 && class18.field92[var2] == null) {
            class18.field92[var2] = class58.field417.method6080(class2.field1[var2], 0, class36.field238[var2]);
            if (null == class18.field92[var2]) {
               var1 = false;
               ++client.field1700;
            }
         }
      }

      if (!var1) {
         client.field1725 = 1;
      } else {
         client.field1702 = 0;
         var1 = true;

         int var4;
         int var5;
         for(var2 = 0; var2 < class74.field612.length; ++var2) {
            byte[] var3 = class18.field92[var2];
            if (var3 != null) {
               var4 = 64 * (class204.field2302[var2] >> 8) - class36.field241;
               var5 = 64 * (class204.field2302[var2] & 255) - class169.field1536;
               if (client.field1706) {
                  var4 = 10;
                  var5 = 10;
               }

               var1 &= class200.method3770(var3, var4, var5);
            }
         }

         if (!var1) {
            client.field1725 = 2;
         } else {
            if (0 != client.field1725) {
               class131.method2399(class338.field3902 + class96.field966 + class96.field964 + 100 + "%" + class96.field958, true);
            }

            class349.method6449();
            class145.field1333.method4122();

            for(var2 = 0; var2 < 4; ++var2) {
               client.field1884[var2].method3735();
            }

            int var14;
            for(var2 = 0; var2 < 4; ++var2) {
               for(var14 = 0; var14 < 104; ++var14) {
                  for(var4 = 0; var4 < 104; ++var4) {
                     class82.field714[var2][var14][var4] = 0;
                  }
               }
            }

            class349.method6449();
            class82.method1589();
            var2 = class74.field612.length;
            class103.method2025();
            class318.method6075(true);
            int var16;
            if (!client.field1706) {
               byte[] var6;
               for(var14 = 0; var14 < var2; ++var14) {
                  var4 = 64 * (class204.field2302[var14] >> 8) - class36.field241;
                  var5 = 64 * (class204.field2302[var14] & 255) - class169.field1536;
                  var6 = class74.field612[var14];
                  if (null != var6) {
                     class349.method6449();
                     class9.method57(var6, var4, var5, class361.field4314 * 8 - 48, class283.field3216 * 8 - 48, client.field1884);
                  }
               }

               for(var14 = 0; var14 < var2; ++var14) {
                  var4 = (class204.field2302[var14] >> 8) * 64 - class36.field241;
                  var5 = (class204.field2302[var14] & 255) * 64 - class169.field1536;
                  var6 = class74.field612[var14];
                  if (null == var6 && class283.field3216 < 800) {
                     class349.method6449();
                     class242.method4732(var4, var5, 64, 64);
                  }
               }

               class318.method6075(true);

               for(var14 = 0; var14 < var2; ++var14) {
                  byte[] var15 = class18.field92[var14];
                  if (var15 != null) {
                     var5 = 64 * (class204.field2302[var14] >> 8) - class36.field241;
                     var16 = 64 * (class204.field2302[var14] & 255) - class169.field1536;
                     class349.method6449();
                     class357.method6600(var15, var5, var16, class145.field1333, client.field1884);
                  }
               }
            }

            int var7;
            int var8;
            int var9;
            if (client.field1706) {
               int var10;
               int var11;
               int var12;
               for(var14 = 0; var14 < 4; ++var14) {
                  class349.method6449();

                  for(var4 = 0; var4 < 13; ++var4) {
                     for(var5 = 0; var5 < 13; ++var5) {
                        boolean var17 = false;
                        var7 = client.field1707[var14][var4][var5];
                        if (var7 != -1) {
                           var8 = var7 >> 24 & 3;
                           var9 = var7 >> 1 & 3;
                           var10 = var7 >> 14 & 1023;
                           var11 = var7 >> 3 & 2047;
                           var12 = (var10 / 8 << 8) + var11 / 8;

                           for(int var13 = 0; var13 < class204.field2302.length; ++var13) {
                              if (class204.field2302[var13] == var12 && null != class74.field612[var13]) {
                                 class206.method3968(class74.field612[var13], var14, 8 * var4, 8 * var5, var8, 8 * (var10 & 7), 8 * (var11 & 7), var9, client.field1884);
                                 var17 = true;
                                 break;
                              }
                           }
                        }

                        if (!var17) {
                           class61.method1337(var14, var4 * 8, 8 * var5);
                        }
                     }
                  }
               }

               for(var14 = 0; var14 < 13; ++var14) {
                  for(var4 = 0; var4 < 13; ++var4) {
                     var5 = client.field1707[0][var14][var4];
                     if (var5 == -1) {
                        class242.method4732(var14 * 8, 8 * var4, 8, 8);
                     }
                  }
               }

               class318.method6075(true);

               for(var14 = 0; var14 < 4; ++var14) {
                  class349.method6449();

                  for(var4 = 0; var4 < 13; ++var4) {
                     for(var5 = 0; var5 < 13; ++var5) {
                        var16 = client.field1707[var14][var4][var5];
                        if (var16 != -1) {
                           var7 = var16 >> 24 & 3;
                           var8 = var16 >> 1 & 3;
                           var9 = var16 >> 14 & 1023;
                           var10 = var16 >> 3 & 2047;
                           var11 = var10 / 8 + (var9 / 8 << 8);

                           for(var12 = 0; var12 < class204.field2302.length; ++var12) {
                              if (class204.field2302[var12] == var11 && null != class18.field92[var12]) {
                                 class82.method1668(class18.field92[var12], var14, var4 * 8, 8 * var5, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, class145.field1333, client.field1884);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class318.method6075(true);
            class349.method6449();
            class307.method6034(class145.field1333, client.field1884);
            class318.method6075(true);
            var14 = class82.field724;
            if (var14 > class55.field396) {
               var14 = class55.field396;
            }

            if (var14 < class55.field396 - 1) {
               var14 = class55.field396 - 1;
            }

            if (client.field1636) {
               class145.field1333.method4123(class82.field724);
            } else {
               class145.field1333.method4123(0);
            }

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  class176.method2802(var4, var5);
               }
            }

            class349.method6449();
            class66.method1392();
            class195.field2056.method5437();
            class263 var18;
            if (class133.field1257.method562()) {
               var18 = class185.method3435(class274.field3051, client.field1778.field1071);
               var18.field2984.method8234(1057001181);
               client.field1778.method2078(var18);
            }

            if (!client.field1706) {
               var4 = (class361.field4314 - 6) / 8;
               var5 = (class361.field4314 + 6) / 8;
               var16 = (class283.field3216 - 6) / 8;
               var7 = (class283.field3216 + 6) / 8;

               for(var8 = var4 - 1; var8 <= 1 + var5; ++var8) {
                  for(var9 = var16 - 1; var9 <= var7 + 1; ++var9) {
                     if (var8 < var4 || var8 > var5 || var9 < var16 || var9 > var7) {
                        class58.field417.method6098("m" + var8 + "_" + var9);
                        class58.field417.method6098("l" + var8 + "_" + var9);
                     }
                  }
               }
            }

            class9.method64(30);
            class349.method6449();
            class82.method1271();
            var18 = class185.method3435(class274.field3136, client.field1778.field1071);
            client.field1778.method2078(var18);
            class339.method6307();
         }
      }
   }

   static void method801(int var0) {
      if (var0 != client.field1667) {
         client.field1667 = var0;
      }
   }
}
