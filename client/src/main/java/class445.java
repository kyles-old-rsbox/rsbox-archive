public class class445 implements class360 {
   public static final class445 field4787 = new class445(0, 2);
   public static final class445 field4791 = new class445(1, 0);
   static final class445 field4788 = new class445(5, 5);
   static final class445 field4789 = new class445(4, 6);
   static final class445 field4790 = new class445(3, 7);
   static final class445 field4793 = new class445(2, 8);
   final int field4786;
   final int field4792;

   class445(int var1, int var2) {
      this.field4792 = var1;
      this.field4786 = var2;
   }

   public int method6656() {
      return this.field4786;
   }

   public boolean method7931() {
      return this == field4787;
   }

   static int method7929(int var0, class78 var1, boolean var2) {
      int var5 = -1;
      class300 var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var5 = class57.field404[--class387.field4452];
         var4 = class282.method5426(var5);
      } else {
         var4 = var2 ? class138.field1284 : class153.field1414;
      }

      int var14;
      if (var0 == 1100) {
         class387.field4452 -= 2;
         var14 = class57.field404[class387.field4452];
         int var11 = class57.field404[class387.field4452 + 1];
         if (12 == var4.field3462) {
            class297 var8 = var4.method5869();
            if (var8 != null && var8.method5731(var14, var11)) {
               class136.method2438(var4);
            }
         } else {
            var4.field3481 = var14;
            if (var4.field3481 > var4.field3483 - var4.field3448) {
               var4.field3481 = var4.field3483 - var4.field3448;
            }

            if (var4.field3481 < 0) {
               var4.field3481 = 0;
            }

            var4.field3482 = var11;
            if (var4.field3482 > var4.field3492 - var4.field3476) {
               var4.field3482 = var4.field3492 - var4.field3476;
            }

            if (var4.field3482 < 0) {
               var4.field3482 = 0;
            }

            class136.method2438(var4);
         }

         return 1;
      } else if (var0 == 1101) {
         var4.field3485 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (1102 == var0) {
         var4.field3489 = class57.field404[--class387.field4452] == 1;
         class136.method2438(var4);
         return 1;
      } else if (1103 == var0) {
         var4.field3612 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (1104 == var0) {
         var4.field3493 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (1105 == var0) {
         var4.field3560 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (1106 == var0) {
         var4.field3498 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (var0 == 1107) {
         var4.field3499 = class57.field404[--class387.field4452] == 1;
         class136.method2438(var4);
         return 1;
      } else if (1108 == var0) {
         var4.field3504 = 1;
         var4.field3505 = class57.field404[--class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (var0 == 1109) {
         class387.field4452 -= 6;
         var4.field3510 = class57.field404[class387.field4452];
         var4.field3548 = class57.field404[1 + class387.field4452];
         var4.field3601 = class57.field404[class387.field4452 + 2];
         var4.field3513 = class57.field404[class387.field4452 + 3];
         var4.field3514 = class57.field404[4 + class387.field4452];
         var4.field3562 = class57.field404[5 + class387.field4452];
         class136.method2438(var4);
         return 1;
      } else if (var0 == 1110) {
         var14 = class57.field404[--class387.field4452];
         if (var4.field3575 != var14) {
            var4.field3575 = var14;
            var4.field3471 = 0;
            var4.field3518 = 0;
            class136.method2438(var4);
         }

         return 1;
      } else if (1111 == var0) {
         var4.field3534 = class57.field404[--class387.field4452] == 1;
         class136.method2438(var4);
         return 1;
      } else if (var0 == 1112) {
         String var15 = class57.field405[--class126.field1220];
         if (!var15.equals(var4.field3522)) {
            var4.field3522 = var15;
            class136.method2438(var4);
         }

         return 1;
      } else {
         class297 var9;
         if (var0 == 1113) {
            var4.field3521 = class57.field404[--class387.field4452];
            if (var4.field3462 == 12) {
               var9 = var4.method5869();
               if (var9 != null) {
                  var9.method5568();
               }
            }

            class136.method2438(var4);
            return 1;
         } else if (1114 == var0) {
            class387.field4452 -= 3;
            if (var4.field3462 == 12) {
               var9 = var4.method5869();
               if (null != var9) {
                  var9.method5562(class57.field404[class387.field4452], class57.field404[class387.field4452 + 1]);
                  var9.method5563(class57.field404[class387.field4452 + 2]);
               }
            } else {
               var4.field3525 = class57.field404[class387.field4452];
               var4.field3572 = class57.field404[1 + class387.field4452];
               var4.field3524 = class57.field404[class387.field4452 + 2];
            }

            class136.method2438(var4);
            return 1;
         } else if (1115 == var0) {
            var4.field3488 = class57.field404[--class387.field4452] == 1;
            class136.method2438(var4);
            return 1;
         } else if (var0 == 1116) {
            var4.field3500 = class57.field404[--class387.field4452];
            class136.method2438(var4);
            return 1;
         } else if (var0 == 1117) {
            var4.field3501 = class57.field404[--class387.field4452];
            class136.method2438(var4);
            return 1;
         } else if (var0 == 1118) {
            var4.field3467 = class57.field404[--class387.field4452] == 1;
            class136.method2438(var4);
            return 1;
         } else if (var0 == 1119) {
            var4.field3503 = class57.field404[--class387.field4452] == 1;
            class136.method2438(var4);
            return 1;
         } else if (1120 == var0) {
            class387.field4452 -= 2;
            var4.field3483 = class57.field404[class387.field4452];
            var4.field3492 = class57.field404[1 + class387.field4452];
            class136.method2438(var4);
            if (-1 != var5 && var4.field3462 == 0) {
               class26.method349(class300.field3593[var5 >> 16], var4, false);
            }

            return 1;
         } else if (1121 == var0) {
            client.method7978(var4.field3517, var4.field3484);
            client.field1641 = var4;
            class136.method2438(var4);
            return 1;
         } else if (var0 == 1122) {
            var4.field3496 = class57.field404[--class387.field4452];
            class136.method2438(var4);
            return 1;
         } else if (1123 == var0) {
            var4.field3495 = class57.field404[--class387.field4452];
            class136.method2438(var4);
            return 1;
         } else if (1124 == var0) {
            var4.field3588 = class57.field404[--class387.field4452];
            class136.method2438(var4);
            return 1;
         } else if (1125 == var0) {
            var14 = class57.field404[--class387.field4452];
            class469 var10 = (class469)class217.method4362(class469.method6563(), var14);
            if (var10 != null) {
               var4.field3490 = var10;
               class136.method2438(var4);
            }

            return 1;
         } else {
            boolean var12;
            if (1126 == var0) {
               var12 = class57.field404[--class387.field4452] == 1;
               var4.field3494 = var12;
               return 1;
            } else if (var0 == 1127) {
               var12 = class57.field404[--class387.field4452] == 1;
               var4.field3519 = var12;
               return 1;
            } else if (var0 == 1129) {
               var4.field3497 = class57.field405[--class126.field1220];
               class136.method2438(var4);
               return 1;
            } else if (1130 == var0) {
               var4.method5855(class57.field405[--class126.field1220], class28.field155, client.method2417());
               return 1;
            } else if (1131 == var0) {
               class387.field4452 -= 2;
               var4.method5867(class57.field404[class387.field4452], class57.field404[class387.field4452 + 1]);
               return 1;
            } else if (1132 == var0) {
               var4.method5858(class57.field405[--class126.field1220], class57.field404[--class387.field4452]);
               return 1;
            } else {
               class302 var13;
               if (var0 == 1133) {
                  --class387.field4452;
                  var13 = var4.method5946();
                  if (var13 != null) {
                     var13.field3617 = class57.field404[class387.field4452];
                     class136.method2438(var4);
                  }

                  return 1;
               } else if (1134 == var0) {
                  --class387.field4452;
                  var13 = var4.method5946();
                  if (var13 != null) {
                     var13.field3619 = class57.field404[class387.field4452];
                     class136.method2438(var4);
                  }

                  return 1;
               } else if (var0 == 1135) {
                  --class126.field1220;
                  var9 = var4.method5869();
                  if (null != var9) {
                     var4.field3523 = class57.field405[class126.field1220];
                  }

                  return 1;
               } else if (var0 == 1136) {
                  --class387.field4452;
                  var13 = var4.method5946();
                  if (var13 != null) {
                     var13.field3618 = class57.field404[class387.field4452];
                     class136.method2438(var4);
                  }

                  return 1;
               } else if (1137 == var0) {
                  --class387.field4452;
                  var9 = var4.method5869();
                  if (null != var9 && var9.method5558(class57.field404[class387.field4452])) {
                     class136.method2438(var4);
                  }

                  return 1;
               } else if (1138 == var0) {
                  --class387.field4452;
                  var9 = var4.method5869();
                  if (null != var9 && var9.method5559(class57.field404[class387.field4452])) {
                     class136.method2438(var4);
                  }

                  return 1;
               } else if (var0 == 1139) {
                  --class387.field4452;
                  var9 = var4.method5869();
                  if (var9 != null && var9.method5560(class57.field404[class387.field4452])) {
                     class136.method2438(var4);
                  }

                  return 1;
               } else {
                  class297 var7;
                  if (var0 == 1140) {
                     var12 = class57.field404[--class387.field4452] == 1;
                     client.field1877.method3521();
                     var7 = var4.method5869();
                     if (null != var7 && var7.method5552(var12)) {
                        if (var12) {
                           client.field1877.method3515(var4);
                        }

                        class136.method2438(var4);
                     }

                     return 1;
                  } else if (1141 == var0) {
                     var12 = class57.field404[--class387.field4452] == 1;
                     if (!var12 && client.field1877.method3516() == var4) {
                        client.field1877.method3521();
                        class136.method2438(var4);
                     }

                     var7 = var4.method5869();
                     if (var7 != null) {
                        var7.method5628(var12);
                     }

                     return 1;
                  } else if (var0 == 1142) {
                     class387.field4452 -= 2;
                     var9 = var4.method5869();
                     if (null != var9 && var9.method5576(class57.field404[class387.field4452], class57.field404[1 + class387.field4452])) {
                        class136.method2438(var4);
                     }

                     return 1;
                  } else if (var0 == 1143) {
                     --class387.field4452;
                     var9 = var4.method5869();
                     if (null != var9 && var9.method5576(class57.field404[class387.field4452], class57.field404[class387.field4452])) {
                        class136.method2438(var4);
                     }

                     return 1;
                  } else if (1144 == var0) {
                     --class387.field4452;
                     var9 = var4.method5869();
                     if (var9 != null) {
                        var9.method5565(class57.field404[class387.field4452]);
                        class136.method2438(var4);
                     }

                     return 1;
                  } else if (var0 == 1145) {
                     --class387.field4452;
                     var9 = var4.method5869();
                     if (null != var9) {
                        var9.method5564(class57.field404[class387.field4452]);
                     }

                     return 1;
                  } else if (var0 == 1146) {
                     --class387.field4452;
                     var9 = var4.method5869();
                     if (var9 != null) {
                        var9.method5721(class57.field404[class387.field4452]);
                     }

                     return 1;
                  } else if (var0 == 1147) {
                     --class387.field4452;
                     var9 = var4.method5869();
                     if (null != var9) {
                        var9.method5566(class57.field404[class387.field4452]);
                        class136.method2438(var4);
                     }

                     return 1;
                  } else {
                     class34 var6;
                     if (var0 == 1148) {
                        class387.field4452 -= 2;
                        var6 = var4.method5871();
                        if (var6 != null) {
                           var6.method615(class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
                        }

                        return 1;
                     } else if (var0 == 1149) {
                        class387.field4452 -= 2;
                        var6 = var4.method5871();
                        if (null != var6) {
                           var6.method616((char)class57.field404[class387.field4452], class57.field404[1 + class387.field4452]);
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  }
               }
            }
         }
      }
   }
}
